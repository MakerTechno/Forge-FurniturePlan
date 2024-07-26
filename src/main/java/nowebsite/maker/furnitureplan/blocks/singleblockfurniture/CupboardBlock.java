package nowebsite.maker.furnitureplan.blocks.singleblockfurniture;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.RenderShape;
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
public class CupboardBlock extends AbstractCupboardBlock<CupboardBlockEntity> implements EntityBlock, IHorizontalBlock {
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
    public @NotNull InteractionResult use(@NotNull BlockState pState, @NotNull Level pLevel, @NotNull BlockPos pPos, @NotNull Player pPlayer, @NotNull InteractionHand pHand, @NotNull BlockHitResult pHit) {

        if (pLevel.getBlockEntity(pPos) instanceof CupboardBlockEntity blockEntity) {
            Direction facing = pState.getValue(CupboardBlock.FACING);
            if (facing != pHit.getDirection()) return InteractionResult.PASS;
            Vec3 hit = pHit.getLocation().subtract(pPos.getX(), pPos.getY(), pPos.getZ());
            double x = Vec3Utils.getXFromHit(facing, hit);

            if (pLevel.isClientSide) {
                return InteractionResult.SUCCESS;
            } else {
                if (x > 3.0 / 16 && x < 15.0 / 16 && isNotBlockedDrawerByBlock(pLevel, pPos)) {
                    if (x < 7.3 / 16) { //Drawer3
                        blockEntity.removeUsingD1Player(pPlayer);
                        blockEntity.removeUsingD2Player(pPlayer);
                        blockEntity.addUsingD3Player(pPlayer);
                    } else if (x < 11.3 / 16) {//Drawer2
                        blockEntity.removeUsingD1Player(pPlayer);
                        blockEntity.removeUsingD3Player(pPlayer);
                        blockEntity.addUsingD2Player(pPlayer);
                    } else {//Drawer1
                        blockEntity.removeUsingD2Player(pPlayer);
                        blockEntity.removeUsingD3Player(pPlayer);
                        blockEntity.addUsingD1Player(pPlayer);
                    }
                }
                MenuProvider menuprovider = this.getMenuProvider(pState, pLevel, pPos);
                if (menuprovider != null) {
                    pPlayer.openMenu(menuprovider);
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
