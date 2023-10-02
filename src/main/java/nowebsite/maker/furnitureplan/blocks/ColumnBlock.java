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
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

@SuppressWarnings("deprecation")
public class ColumnBlock extends HorizontalDirectionalBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public final Block base;
    private final BlockState baseState;
    private final Supplier<BlockState> stateSupplier;
    private static VoxelShape SHAPE = Shapes.empty();

    static {
        SHAPE = Shapes.join(SHAPE, Shapes.box(0.0625, 0, 0.125, 0.9375, 0.0625, 0.875), BooleanOp.OR);
        SHAPE = Shapes.join(SHAPE, Shapes.box(0.125, 0, 0.0625, 0.875, 0.0625, 0.125), BooleanOp.OR);
        SHAPE = Shapes.join(SHAPE, Shapes.box(0.125, 0, 0.875, 0.875, 0.0625, 0.9375), BooleanOp.OR);
        SHAPE = Shapes.join(SHAPE, Shapes.box(0.125, 0.0625, 0.1875, 0.875, 0.125, 0.8125), BooleanOp.OR);
        SHAPE = Shapes.join(SHAPE, Shapes.box(0.1875, 0.0625, 0.125, 0.8125, 0.125, 0.1875), BooleanOp.OR);
        SHAPE = Shapes.join(SHAPE, Shapes.box(0.25, 0.125, 0.75, 0.75, 0.875, 0.8125), BooleanOp.OR);
        SHAPE = Shapes.join(SHAPE, Shapes.box(0.1875, 0.125, 0.25, 0.8125, 0.875, 0.75), BooleanOp.OR);
        SHAPE = Shapes.join(SHAPE, Shapes.box(0.1875, 0.0625, 0.8125, 0.8125, 0.125, 0.875), BooleanOp.OR);
        SHAPE = Shapes.join(SHAPE, Shapes.box(0.25, 0.125, 0.1875, 0.75, 0.875, 0.25), BooleanOp.OR);
        SHAPE = Shapes.join(SHAPE, Shapes.box(0.0625, 0.9375, 0.125, 0.9375, 1, 0.875), BooleanOp.OR);
        SHAPE = Shapes.join(SHAPE, Shapes.box(0.125, 0.9375, 0.0625, 0.875, 1, 0.125), BooleanOp.OR);
        SHAPE = Shapes.join(SHAPE, Shapes.box(0.125, 0.9375, 0.875, 0.875, 1, 0.9375), BooleanOp.OR);
        SHAPE = Shapes.join(SHAPE, Shapes.box(0.125, 0.875, 0.1875, 0.875, 0.9375, 0.8125), BooleanOp.OR);
        SHAPE = Shapes.join(SHAPE, Shapes.box(0.1875, 0.875, 0.125, 0.8125, 0.9375, 0.1875), BooleanOp.OR);
        SHAPE = Shapes.join(SHAPE, Shapes.box(0.1875, 0.875, 0.8125, 0.8125, 0.9375, 0.875), BooleanOp.OR);
    }

    public ColumnBlock(@NotNull BlockState state, Properties properties) {
        super(properties);
        this.base = state.getBlock();
        this.baseState = state;
        this.stateSupplier = () -> state;

    }

    @Override
    public @NotNull VoxelShape getOcclusionShape(@NotNull BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos pos) {
        return SHAPE;
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
        return this.baseState.use(level, player, hand, hitResult);
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

    private BlockState getModelState() {
        return this.stateSupplier.get();
    }

    @SuppressWarnings("all")
    private @NotNull Block getModelBlock() {
        return this.getModelState().getBlock();
    }
}
