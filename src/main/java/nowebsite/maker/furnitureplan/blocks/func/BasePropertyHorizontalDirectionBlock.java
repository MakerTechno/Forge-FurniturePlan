package nowebsite.maker.furnitureplan.blocks.func;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

@SuppressWarnings("deprecation")
public abstract class BasePropertyHorizontalDirectionBlock extends HorizontalDirectionalBlock implements SimpleWaterloggedBlock, IVarietyBlock {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public final Block base;
    private final BlockState baseState;
    private final Supplier<BlockState> stateSupplier;
    public BasePropertyHorizontalDirectionBlock(@NotNull BlockState state, Properties properties) {
        super(properties);
        this.base = state.getBlock();
        this.baseState = state;
        this.stateSupplier = () -> state;
    }
    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return this.getOcclusionShape(state, getter, pos);
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
    public @NotNull BlockState updateShape(@NotNull BlockState pState, @NotNull Direction pDirection, @NotNull BlockState pNeighborState, @NotNull LevelAccessor pLevel, @NotNull BlockPos pPos, @NotNull BlockPos pNeighborPos) {
        if (pState.getValue(WATERLOGGED)) {
            pLevel.scheduleTick(pPos, Fluids.WATER, Fluids.WATER.getTickDelay(pLevel));
        }
        return super.updateShape(pState, pDirection, pNeighborState, pLevel, pPos, pNeighborPos);
    }

    @Override
    public @NotNull FluidState getFluidState(@NotNull BlockState pState) {
        return pState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pState);
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
    protected InteractionResult stateUse(Level level, Player player, InteractionHand hand, BlockHitResult result){
        return baseState.use(level, player, hand, result);
    }

    @Override
    public String textureName() {
        return null;
    }
    @Override
    public String textureKey() {
        return "particle";
    }
}
