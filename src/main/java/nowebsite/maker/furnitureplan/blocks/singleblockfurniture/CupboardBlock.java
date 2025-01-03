package nowebsite.maker.furnitureplan.blocks.singleblockfurniture;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.*;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import nowebsite.maker.furnitureplan.blocks.func.IHorizontalBlock;
import nowebsite.maker.furnitureplan.blocks.singleblockfurniture.blockentities.CupboardBlockEntity;
import nowebsite.maker.furnitureplan.blocks.voxel.VoxelShapeReference;
import nowebsite.maker.furnitureplan.utils.Vec3Utils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

@SuppressWarnings("deprecation")
public class CupboardBlock extends AbstractCupboardBlock<CupboardBlockEntity> implements IHorizontalBlock {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public CupboardBlock(Properties properties, Supplier<BlockEntityType<? extends CupboardBlockEntity>> blockEntityType) {
        super(properties, blockEntityType);
        this.registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.NORTH));
    }
    @Override
    public boolean useShapeForLightOcclusion(@NotNull BlockState pState) {
        return true;
    }
    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return new CupboardBlockEntity(pos, state);
    }
    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(@NotNull Level pLevel, @NotNull BlockState pState, @NotNull BlockEntityType<T> pBlockEntityType) {
        return pLevel.isClientSide ? createTickerHelper(pBlockEntityType, this.blockEntityType.get(), CupboardBlockEntity::animateTick) : null;
    }
    @Override
    protected @NotNull MapCodec<? extends BaseEntityBlock> codec() {
        return simpleCodec(properties1 -> new CupboardBlock(properties1, blockEntityType));
    }
    @Override
    public @NotNull RenderShape getRenderShape(@NotNull BlockState pState) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }
    @Nullable
    @Override
    public BlockState getStateForPlacement(@NotNull BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }
    private static boolean isNotBlockedDrawerByBlock(@NotNull BlockGetter level, BlockPos pos) {
        Direction direction = level.getBlockState(pos).getValue(FACING);
        BlockPos faceBlock = switch (direction){
            case NORTH -> pos.north();
            case EAST -> pos.east();
            case SOUTH -> pos.south();
            case WEST -> pos.west();
            default -> null;
        };
        if (faceBlock == null) return true;
        return !level.getBlockState(faceBlock).isRedstoneConductor(level, faceBlock);
    }
    @Override
    protected @NotNull ItemInteractionResult useItemOn(@NotNull ItemStack stack, @NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hitResult) {
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }
    @Override
    protected @NotNull InteractionResult useWithoutItem(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull BlockHitResult hitResult) {
        if (level.getBlockEntity(pos) instanceof CupboardBlockEntity blockEntity) {
            Direction facing = state.getValue(CupboardBlock.FACING);
            if (facing != hitResult.getDirection()) return InteractionResult.PASS;
            Vec3 hit = hitResult.getLocation().subtract(pos.getX(), pos.getY(), pos.getZ());
            double x = Vec3Utils.getXFromHit(facing, hit);

            if (level.isClientSide) {
                return InteractionResult.SUCCESS;
            } else {
                if (x > 3.0 / 16 && x < 15.0 / 16 && isNotBlockedDrawerByBlock(level, pos)) {
                    if (x < 7.3 / 16) { //Drawer3
                        blockEntity.removeUsingD1Player(player);
                        blockEntity.removeUsingD2Player(player);
                        blockEntity.addUsingD3Player(player);
                    } else if (x < 11.3 / 16) {//Drawer2
                        blockEntity.removeUsingD1Player(player);
                        blockEntity.removeUsingD3Player(player);
                        blockEntity.addUsingD2Player(player);
                    } else {//Drawer1
                        blockEntity.removeUsingD2Player(player);
                        blockEntity.removeUsingD3Player(player);
                        blockEntity.addUsingD1Player(player);
                    }
                }
                MenuProvider menuprovider = this.getMenuProvider(state, level, pos);
                if (menuprovider != null) {
                    player.openMenu(menuprovider);
                }
                return InteractionResult.CONSUME;
            }
        }
        return InteractionResult.FAIL;
    }
    @Override
    public void onRemove(@NotNull BlockState pState, @NotNull Level pLevel, @NotNull BlockPos pPos, @NotNull BlockState pNewState, boolean pMovedByPiston) {
        if (!pState.is(pNewState.getBlock())) {
            if (pLevel.getBlockEntity(pPos) instanceof CupboardBlockEntity blockEntity) {
                Containers.dropContents(pLevel, pPos, blockEntity.drawer1);
                Containers.dropContents(pLevel, pPos, blockEntity.drawer2);
                Containers.dropContents(pLevel, pPos, blockEntity.drawer3);
                pLevel.updateNeighbourForOutputSignal(pPos, this);
            }
            super.onRemove(pState, pLevel, pPos, pNewState, pMovedByPiston);
        }
    }
    @Override
    public void setPlacedBy(@NotNull Level pLevel, @NotNull BlockPos pPos, @NotNull BlockState pState, @Nullable LivingEntity pPlacer, @NotNull ItemStack pStack) {
        if (pStack.get(DataComponents.CUSTOM_DATA) != null) {
            if (pLevel.getBlockEntity(pPos) instanceof CupboardBlockEntity blockEntity) {
                blockEntity.setCustomName(pStack.getHoverName());
            }
        }
    }
    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return this.getOcclusionShape(state, level, pos);
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
    }
    @Override
    public void tick(@NotNull BlockState pState, @NotNull ServerLevel pLevel, @NotNull BlockPos pPos, @NotNull RandomSource pRandom) {
        if (pLevel.getBlockEntity(pPos) instanceof CupboardBlockEntity blockEntity) {
            blockEntity.recheckOpen();
        }
    }
    @Override
    public @NotNull VoxelShape getOcclusionShape(@NotNull BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos) {
        return VoxelShapeReference.CUPBOARD_VOXEL;
    }
    @Override
    public String parentName() {
        return "cupboard";
    }
    @Override
    public String textureKey() {
        return "texture";
    }
    @Override
    public String textureName() {
        return parentName();
    }
}
