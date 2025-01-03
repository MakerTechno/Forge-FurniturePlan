package nowebsite.maker.furnitureplan.blocks.singleblockfurniture;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.*;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import nowebsite.maker.furnitureplan.blocks.func.BasePropertyHorizontalDirectionBlock;
import nowebsite.maker.furnitureplan.blocks.func.IHorizontalBlock;
import nowebsite.maker.furnitureplan.blocks.func.IUVLockedBlock;
import nowebsite.maker.furnitureplan.blocks.func.IVarietyBlock;
import nowebsite.maker.furnitureplan.blocks.singleblockfurniture.blockentities.CabinetBlockEntity;
import nowebsite.maker.furnitureplan.registry.kindsblock.cabinet.CabinetBlockRegistration;
import nowebsite.maker.furnitureplan.utils.Vec3Utils;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class CabinetBlock extends BasePropertyHorizontalDirectionBlock<CabinetBlock> implements IHorizontalBlock, IVarietyBlock, IUVLockedBlock, EntityBlock {
    private final MapCodec<CabinetBlock> CODEC = RecordCodecBuilder.mapCodec(
        cabinetBlockInstance -> cabinetBlockInstance.group(
            propertiesCodec(),
            BlockState.CODEC.fieldOf("base_state").forGetter(block -> block.baseState),
            Codec.BOOL.fieldOf("hasDoorRendered").forGetter(block -> block.hasDoorRendered)
        ).apply(cabinetBlockInstance, this::getSelfNew)
    );
    final boolean hasDoorRendered;
    public CabinetBlock(Properties properties, BlockState state, boolean hasDoorRendered) {
        super(state, properties);
        this.hasDoorRendered = hasDoorRendered;
        this.registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, Boolean.FALSE));
    }
    @Override
    protected @NotNull ItemInteractionResult useItemOn(@NotNull ItemStack stack, @NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hitResult) {
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }
    @Override
    protected @NotNull InteractionResult useWithoutItem(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull BlockHitResult hitResult) {
        if (level.getBlockEntity(pos) instanceof CabinetBlockEntity blockEntity) {
            Direction facing = state.getValue(FACING);
            if (facing != hitResult.getDirection()) return InteractionResult.PASS;
            Vec3 hit = hitResult.getLocation().subtract(pos.getX(), pos.getY(), pos.getZ());
            double x = Vec3Utils.getXFromHit(facing, hit);

            if (level.isClientSide) {
                if (x > 1.0 / 16 && x < 15.0 / 16 && isNotBlockedDrawerByBlock(level, pos)) {
                    return InteractionResult.SUCCESS;
                }
                return InteractionResult.PASS;
            } else {
                if (x > 1.0 / 16 && x < 15.0 / 16 && isNotBlockedDrawerByBlock(level, pos)) {
                    blockEntity.addUsingPlayer(player);
                    MenuProvider menuprovider = this.getMenuProvider(state, level, pos);
                    if (menuprovider != null) {
                        player.openMenu(menuprovider);
                    }
                    return InteractionResult.CONSUME;
                }
            }
        }
        return InteractionResult.PASS;
    }
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return new CabinetBlockEntity(CabinetBlockRegistration.CABINET_BLOCK_ENTITY.get(), pos, state);
    }
    @Override
    public boolean useShapeForLightOcclusion(@NotNull BlockState pState) {
        return true;
    }
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(@NotNull Level pLevel, @NotNull BlockState pState, @NotNull BlockEntityType<T> pBlockEntityType) {
        return pLevel.isClientSide ? createTickerHelper(pBlockEntityType, CabinetBlockRegistration.CABINET_BLOCK_ENTITY.get(), CabinetBlockEntity::animateTick) : null;
    }
    @SuppressWarnings("deprecation")
    @Override
    protected boolean triggerEvent(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, int id, int param) {
        super.triggerEvent(state, level, pos, id, param);
        BlockEntity blockentity = level.getBlockEntity(pos);
        return blockentity != null && blockentity.triggerEvent(id, param);
    }
    @Override
    public void setPlacedBy(@NotNull Level pLevel, @NotNull BlockPos pPos, @NotNull BlockState pState, @org.jetbrains.annotations.Nullable LivingEntity pPlacer, @NotNull ItemStack pStack) {
        if (pStack.get(DataComponents.CUSTOM_DATA) != null) {
            if (pLevel.getBlockEntity(pPos) instanceof CabinetBlockEntity blockEntity) {
                blockEntity.setCustomName(pStack.getHoverName());
            }
        }
    }
    @Override
    protected void tick(@NotNull BlockState state, @NotNull ServerLevel level, @NotNull BlockPos pos, @NotNull RandomSource random) {
        if (level.getBlockEntity(pos) instanceof CabinetBlockEntity blockEntity) {
            blockEntity.recheckOpen();
        }
    }

    @Override
    public void onRemove(@NotNull BlockState pState, @NotNull Level pLevel, @NotNull BlockPos pPos, @NotNull BlockState pNewState, boolean pMovedByPiston) {
        if (!pState.is(pNewState.getBlock())) {
            if (pLevel.getBlockEntity(pPos) instanceof CabinetBlockEntity blockEntity) {
                Containers.dropContents(pLevel, pPos, blockEntity.container);
                pLevel.updateNeighbourForOutputSignal(pPos, this);
            }
            super.onRemove(pState, pLevel, pPos, pNewState, pMovedByPiston);
        }
    }

    @Nullable
    @Override
    protected MenuProvider getMenuProvider(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos) {
        BlockEntity blockentity = level.getBlockEntity(pos);
        return blockentity instanceof MenuProvider ? (MenuProvider)blockentity : null;
    }

    @Override
    protected @NotNull VoxelShape getOcclusionShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos) {
        return Shapes.block();
    }

    @SuppressWarnings("all")
    @Nullable
    protected static <E extends BlockEntity, A extends BlockEntity> BlockEntityTicker<A> createTickerHelper(
        BlockEntityType<A> serverType, BlockEntityType<E> clientType, BlockEntityTicker<? super E> ticker
    ) {
        return clientType == serverType ? (BlockEntityTicker<A>)ticker : null;
    }
    public boolean hasDoorRendered() {
        return this.hasDoorRendered;
    }
    @SuppressWarnings("deprecation")
    @Override
    protected @NotNull RenderShape getRenderShape(@NotNull BlockState state) {
        return RenderShape.MODEL;
    }
    @Override
    protected @NotNull MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return CODEC;
    }
    @Override
    protected BasePropertyHorizontalDirectionBlock<CabinetBlock> getSelfNew(BlockState baseState, Properties properties) {
        return new CabinetBlock(properties, baseState, hasDoorRendered);
    }
    @Contract("_, _, _ -> new")
    protected @NotNull CabinetBlock getSelfNew(Properties properties, BlockState baseState, boolean hasDoorRendered) {
        return new CabinetBlock(properties, baseState, hasDoorRendered);
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
    public String parentName() {
        return "cube_all";
    }
    @Override
    public String textureKey() {
        return "all";
    }
    @Override
    public String getSpecificName() {
        return "cabinet";
    }
}
