package nowebsite.maker.furnitureplan.common.block.storaging;

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
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import nowebsite.maker.furnitureplan.common.block.abstraction.BasePropertyHorizontalDirectionBlock;
import nowebsite.maker.furnitureplan.common.block.abstraction.generators.CabinetBDG;
import nowebsite.maker.furnitureplan.common.block.abstraction.set.FPBlockSetType;
import nowebsite.maker.furnitureplan.common.block.abstraction.set.FPColorfulSetType;
import nowebsite.maker.furnitureplan.common.block.storaging.entity.CabinetBlockEntity;
import nowebsite.maker.furnitureplan.common.data.gen.empowered.BlockDataGenerator;
import nowebsite.maker.furnitureplan.common.init.FPBlockReg;
import nowebsite.maker.furnitureplan.utils.Vec3Utils;
import nowebsite.maker.furnitureplan.utils.voxel.IVoxelHolder;
import nowebsite.maker.furnitureplan.utils.voxel.VoxelShapeBuilder;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class CabinetBlock extends BasePropertyHorizontalDirectionBlock<CabinetBlock> implements EntityBlock {
    public static final IVoxelHolder SHAPE_CLOSE = VoxelShapeBuilder.ofYRot()
        .startJoin()
        .or(0,0,0,1,1,1)
        .next()
        .or(0.0625, 0.0625, 0.0625, 0.9375, 0.9375, 0.9375)
        .finishJoin(BooleanOp.ONLY_FIRST)
        .build();
    public static final IVoxelHolder SHAPE_OPEN = VoxelShapeBuilder.ofYRot()
        .startJoin()
        .or(0,0,0,1,1,1)
        .next()
        .or(0.0625, 0.0625, 0, 0.9375, 0.9375, 0.9375)
        .finishJoin(BooleanOp.ONLY_FIRST)
        .build();

    private final MapCodec<CabinetBlock> CODEC = RecordCodecBuilder.mapCodec(
        cabinetBlockInstance -> cabinetBlockInstance.group(
            propertiesCodec(),
            BlockState.CODEC.fieldOf("base_state").forGetter(block -> block.baseState),
            Codec.BOOL.fieldOf("hasDoorRendered").forGetter(block -> block.hasDoorRendered)
        ).apply(cabinetBlockInstance, this::createNewInstance)
    );
    private final FPColorfulSetType frameType;
    private final boolean hasDoorRendered;

    public CabinetBlock(FPBlockSetType type, @Nullable FPColorfulSetType frameType, Properties properties, BlockState state) {
        super(type, state, properties);
        this.frameType = frameType;
        this.hasDoorRendered = frameType != null;
        this.registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, Boolean.FALSE));
    }

    @Override
    protected VoxelShape getInteractionShape(BlockState state, BlockGetter level, BlockPos pos) {
        return Shapes.block();
    }

    @Override
    protected boolean shouldChangedStateKeepBlockEntity(BlockState oldState) {
        return true;
    }

    @Override
    protected @NotNull InteractionResult useItemOn(@NotNull ItemStack stack, @NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hitResult) {
        return InteractionResult.TRY_WITH_EMPTY_HAND;
    }

    @Override
    protected @NotNull InteractionResult useWithoutItem(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull BlockHitResult hitResult) {
        if (level.getBlockEntity(pos) instanceof CabinetBlockEntity blockEntity) {
            Direction facing = state.getValue(FACING);
            if (facing != hitResult.getDirection()) return InteractionResult.PASS;
            Vec3 hit = hitResult.getLocation().subtract(pos.getX(), pos.getY(), pos.getZ());
            double x = Vec3Utils.getXFromHit(facing, hit);

            if (level.isClientSide()) {
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
        return new CabinetBlockEntity(pos, state);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE_CLOSE.getShape(state.getValue(FACING));
    }

    @Override
    protected VoxelShape getOcclusionShape(BlockState state) {
        return SHAPE_OPEN.getShape(state.getValue(FACING));
    }

    @Override
    protected VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return hasDoorRendered ? SHAPE_OPEN.getShape(state.getValue(FACING)) : SHAPE_CLOSE.getShape(state.getValue(FACING));
    }

    @Override
    public boolean useShapeForLightOcclusion(@NotNull BlockState pState) {
        return true;
    }

    @Override
    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(@NotNull Level pLevel, @NotNull BlockState pState, @NotNull BlockEntityType<T> pBlockEntityType) {
        return pLevel.isClientSide() ? createTickerHelper(pBlockEntityType, FPBlockReg.CABINET_BLOCK_ENTITY.get(), CabinetBlockEntity::animateTick) : null;
    }

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

    @Nullable
    @Override
    protected MenuProvider getMenuProvider(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos) {
        BlockEntity blockentity = level.getBlockEntity(pos);
        return blockentity instanceof MenuProvider ? (MenuProvider)blockentity : null;
    }

    @SuppressWarnings("unchecked")
    @Nullable
    protected static <E extends BlockEntity, A extends BlockEntity> BlockEntityTicker<A> createTickerHelper(
        BlockEntityType<A> serverType, BlockEntityType<E> clientType, BlockEntityTicker<? super E> ticker
    ) {
        return clientType == serverType ? (BlockEntityTicker<A>)ticker : null;
    }

    public boolean hasDoorRendered() {
        return this.hasDoorRendered;
    }

    @Override
    protected @NotNull RenderShape getRenderShape(@NotNull BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    protected MapCodec<CabinetBlock> codec() {
        return CODEC;
    }

    @Nullable
    public FPColorfulSetType getFrameType() {
        return frameType;
    }

    @Override
    protected BasePropertyHorizontalDirectionBlock<CabinetBlock> createNewInstance(BlockState baseState, Properties properties) {
        return new CabinetBlock(getType(), frameType, properties, baseState);
    }

    @Contract("_, _, _ -> new")
    protected @NotNull CabinetBlock createNewInstance(Properties properties, BlockState baseState, boolean hasDoorRendered) {
        return new CabinetBlock(getType(), frameType, properties, baseState);
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
    public @org.jetbrains.annotations.Nullable BlockDataGenerator<? super @NotNull CabinetBlock> getGenerator() {
        return new CabinetBDG();
    }
}
