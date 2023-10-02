package nowebsite.maker.furnitureplan.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.registries.RegistryObject;
import nowebsite.maker.furnitureplan.FurniturePlan;
import nowebsite.maker.furnitureplan.blocks.blockentities.ChairBlockEntity;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

@SuppressWarnings("deprecation")
public class ChairBlock extends HorizontalDirectionalBlock implements EntityBlock, SimpleWaterloggedBlock {
    public final RegistryObject<BlockEntityType<ChairBlockEntity>> TYPE;
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public final Block base;
    private final BlockState baseState;
    private final Supplier<BlockState> stateSupplier;
    private static VoxelShape SHAPE_N = Shapes.empty();
    private static VoxelShape SHAPE_E = Shapes.empty();
    private static VoxelShape SHAPE_S = Shapes.empty();
    private static VoxelShape SHAPE_W = Shapes.empty();

    static {
        SHAPE_N = Shapes.join(SHAPE_N, Shapes.box(0.125, 0.0, 0.125, 0.25, 0.3125, 0.25), BooleanOp.OR);
        SHAPE_N = Shapes.join(SHAPE_N, Shapes.box(0.125, 0.0, 0.75, 0.25, 0.3125, 0.875), BooleanOp.OR);
        SHAPE_N = Shapes.join(SHAPE_N, Shapes.box(0.75, 0.0, 0.125, 0.875, 0.3125, 0.25), BooleanOp.OR);
        SHAPE_N = Shapes.join(SHAPE_N, Shapes.box(0.75, 0.0, 0.6875, 0.875, 0.3125, 0.8125), BooleanOp.OR);
        SHAPE_N = Shapes.join(SHAPE_N, Shapes.box(0.0, 0.3125, 0.0, 1.0, 0.4375, 1.0), BooleanOp.OR);
        SHAPE_N = Shapes.join(SHAPE_N, Shapes.box(0.25, 0.4375, 0.875, 0.375, 0.5625, 1.0), BooleanOp.OR);
        SHAPE_N = Shapes.join(SHAPE_N, Shapes.box(0.625, 0.4375, 0.875, 0.75, 0.5625, 1.0), BooleanOp.OR);
        SHAPE_N = Shapes.join(SHAPE_N, Shapes.box(0.0, 0.5625, 0.875, 1.0, 1.0, 1.0), BooleanOp.OR);

        SHAPE_E = Shapes.join(SHAPE_E, Shapes.box(0.75, 0.0, 0.125, 0.875, 0.3125, 0.25), BooleanOp.OR);
        SHAPE_E = Shapes.join(SHAPE_E, Shapes.box(0.125, 0.0, 0.125, 0.25, 0.3125, 0.25), BooleanOp.OR);
        SHAPE_E = Shapes.join(SHAPE_E, Shapes.box(0.75, 0.0, 0.75, 0.875, 0.3125, 0.875), BooleanOp.OR);
        SHAPE_E = Shapes.join(SHAPE_E, Shapes.box(0.1875, 0.0, 0.75, 0.3125, 0.3125, 0.875), BooleanOp.OR);
        SHAPE_E = Shapes.join(SHAPE_E, Shapes.box(0.0, 0.3125, 0.0, 1.0, 0.4375, 1.0), BooleanOp.OR);
        SHAPE_E = Shapes.join(SHAPE_E, Shapes.box(0.0, 0.4375, 0.25, 0.125, 0.5625, 0.375), BooleanOp.OR);
        SHAPE_E = Shapes.join(SHAPE_E, Shapes.box(0.0, 0.4375, 0.625, 0.125, 0.5625, 0.75), BooleanOp.OR);
        SHAPE_E = Shapes.join(SHAPE_E, Shapes.box(0.0, 0.5625, 0.0, 0.125, 1.0, 1.0), BooleanOp.OR);

        SHAPE_S = Shapes.join(SHAPE_S, Shapes.box(0.75, 0.0, 0.75, 0.875, 0.3125, 0.875), BooleanOp.OR);
        SHAPE_S = Shapes.join(SHAPE_S, Shapes.box(0.75, 0.0, 0.125, 0.875, 0.3125, 0.25), BooleanOp.OR);
        SHAPE_S = Shapes.join(SHAPE_S, Shapes.box(0.125, 0.0, 0.75, 0.25, 0.3125, 0.875), BooleanOp.OR);
        SHAPE_S = Shapes.join(SHAPE_S, Shapes.box(0.125, 0.0, 0.1875, 0.25, 0.3125, 0.3125), BooleanOp.OR);
        SHAPE_S = Shapes.join(SHAPE_S, Shapes.box(0.0, 0.3125, 0.0, 1.0, 0.4375, 1.0), BooleanOp.OR);
        SHAPE_S = Shapes.join(SHAPE_S, Shapes.box(0.625, 0.4375, 0.0, 0.75, 0.5625, 0.125), BooleanOp.OR);
        SHAPE_S = Shapes.join(SHAPE_S, Shapes.box(0.25, 0.4375, 0.0, 0.375, 0.5625, 0.125), BooleanOp.OR);
        SHAPE_S = Shapes.join(SHAPE_S, Shapes.box(0.0, 0.5625, 0.0, 1.0, 1.0, 0.125), BooleanOp.OR);

        SHAPE_W = Shapes.join(SHAPE_W, Shapes.box(0.125, 0.0, 0.75, 0.25, 0.3125, 0.875), BooleanOp.OR);
        SHAPE_W = Shapes.join(SHAPE_W, Shapes.box(0.75, 0.0, 0.75, 0.875, 0.3125, 0.875), BooleanOp.OR);
        SHAPE_W = Shapes.join(SHAPE_W, Shapes.box(0.125, 0.0, 0.125, 0.25, 0.3125, 0.25), BooleanOp.OR);
        SHAPE_W = Shapes.join(SHAPE_W, Shapes.box(0.6875, 0.0, 0.125, 0.8125, 0.3125, 0.25), BooleanOp.OR);
        SHAPE_W = Shapes.join(SHAPE_W, Shapes.box(0.0, 0.3125, 0.0, 1.0, 0.4375, 1.0), BooleanOp.OR);
        SHAPE_W = Shapes.join(SHAPE_W, Shapes.box(0.875, 0.4375, 0.625, 1.0, 0.5625, 0.75), BooleanOp.OR);
        SHAPE_W = Shapes.join(SHAPE_W, Shapes.box(0.875, 0.4375, 0.25, 1.0, 0.5625, 0.375), BooleanOp.OR);
        SHAPE_W = Shapes.join(SHAPE_W, Shapes.box(0.875, 0.5625, 0.0, 1.0, 1.0, 1.0), BooleanOp.OR);
    }

    public ChairBlock(RegistryObject<BlockEntityType<ChairBlockEntity>> type, @NotNull BlockState state, Properties properties) {
        super(properties);
        this.TYPE = type;
        this.base = state.getBlock();
        this.baseState = state;
        this.stateSupplier = () -> state;
    }

    @Override
    public @NotNull VoxelShape getOcclusionShape(@NotNull BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos pos) {
        return switch (state.getValue(FACING)) {
            case EAST -> SHAPE_E;
            case SOUTH -> SHAPE_S;
            case WEST -> SHAPE_W;
            default -> SHAPE_N;
        };
    }
    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return this.getOcclusionShape(state, getter, pos);
    }

    @Override
    public BlockState getStateForPlacement(@NotNull BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    public @NotNull BlockState rotate(@NotNull BlockState state, @NotNull Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @Override
    public @NotNull BlockState mirror(@NotNull BlockState state, @NotNull Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public void animateTick(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull RandomSource source) {
        this.base.animateTick(state, level, pos, source);
    }

    @Override
    public void attack(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player) {
        this.baseState.attack(level, pos, player);
    }

    @Override
    public void onPlace(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState state1, boolean b) {
        if (!state.is(state.getBlock())) {
            level.neighborChanged(this.baseState, pos, Blocks.AIR, pos, false);
            this.base.onPlace(this.baseState, level, pos, state1, false);
        }
    }



    @Override
    public void onRemove(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState state1, boolean b) {
        if (!state.is(state1.getBlock())) {
            this.baseState.onRemove(level, pos, state1, b);
        }
    }

    @Override
    public void destroy(@NotNull LevelAccessor accessor, @NotNull BlockPos pos, @NotNull BlockState state) {
        this.base.destroy(accessor, pos, state);
    }

    @Override
    public void wasExploded(@NotNull Level level, @NotNull BlockPos pos, @NotNull Explosion explosion) {
        this.base.wasExploded(level, pos, explosion);
    }

    @Override
    public float getExplosionResistance() {
        return this.base.getExplosionResistance();
    }

    @Override
    public @NotNull InteractionResult use(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hitResult) {
        InteractionResult resultA;
        if (!level.isClientSide) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof ChairBlockEntity) {
                resultA = ((ChairBlockEntity)blockEntity).useAct(level, pos, player, state.getValue(FACING));
            } else {
                FurniturePlan.LOGGER.error(new Exception("? Where's my chair block entity???"));
                resultA = InteractionResult.FAIL;
            }
        } else {
            resultA = InteractionResult.PASS;
        }

        if (resultA.equals(InteractionResult.FAIL)) {
            return this.baseState.use(level, player, hand, hitResult);
        } else {
            return resultA;
        }
    }

    @Override
    public void stepOn(@NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState state, @NotNull Entity entity) {
        this.base.stepOn(level, pos, state, entity);
    }

    @Override
    public boolean isRandomlyTicking(@NotNull BlockState state) {
        return this.base.isRandomlyTicking(state);
    }

    @Override
    public void tick(@NotNull BlockState state, @NotNull ServerLevel level, @NotNull BlockPos pos, @NotNull RandomSource source) {
        this.base.tick(state, level, pos, source);
    }

    @Override
    public void randomTick(@NotNull BlockState state, @NotNull ServerLevel level, @NotNull BlockPos pos, @NotNull RandomSource source) {
        this.base.randomTick(state, level, pos, source);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(@NotNull Level level, @NotNull BlockState state, @NotNull BlockEntityType<T> blockEntityType) {
        return level.isClientSide() ? null : (level1, pos, blockState, t) -> {
            if (t instanceof ChairBlockEntity tile) {
                tile.tickAtServer();
            }
        };
    }

    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return new ChairBlockEntity(this.TYPE, pos, state);
    }

    private BlockState getModelState() {
        return this.stateSupplier.get();
    }

    @SuppressWarnings("all")
    private @NotNull Block getModelBlock() {
        return this.getModelState().getBlock();
    }

}
