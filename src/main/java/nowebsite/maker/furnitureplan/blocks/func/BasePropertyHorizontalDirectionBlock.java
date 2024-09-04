package nowebsite.maker.furnitureplan.blocks.func;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("deprecation")
public abstract class BasePropertyHorizontalDirectionBlock<T extends BasePropertyHorizontalDirectionBlock<T>> extends HorizontalDirectionalBlock implements SimpleWaterloggedBlock, IVarietyBlock {
    public final MapCodec<BasePropertyHorizontalDirectionBlock<T>> codec = RecordCodecBuilder.mapCodec(
            instance -> instance.group(BlockState.CODEC.fieldOf("base_state").forGetter(block -> block.baseState), propertiesCodec())
                    .apply(instance, this::getSelfNew)
    );
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public final Block base;
    protected final BlockState baseState;
    public BasePropertyHorizontalDirectionBlock(@NotNull BlockState state, Properties properties) {
        super(properties);
        this.base = state.getBlock();
        this.baseState = state;
    }
    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return this.getOcclusionShape(state, getter, pos);
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
    public BlockState getStateForPlacement(@NotNull BlockPlaceContext context) {
        BlockState blockState = super.getStateForPlacement(context);
        blockState =
            blockState == null ?
                defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite())
                :
                blockState.setValue(FACING, context.getHorizontalDirection().getOpposite());
        return blockState.setValue(WATERLOGGED, context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER);
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> pBuilder) {
        pBuilder.add(WATERLOGGED, FACING);
    }
    @Override
    public float getExplosionResistance() {
        return this.base.getExplosionResistance();
    }
    @Override
    public String textureName() {
        return null;
    }
    @Override
    public String textureKey() {
        return "particle";
    }
    @Override
    protected boolean isPathfindable(@NotNull BlockState state, @NotNull PathComputationType pathComputationType) {
        return false;
    }
    @Override
    protected @NotNull MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return codec;
    }
    protected abstract BasePropertyHorizontalDirectionBlock<T> getSelfNew(BlockState baseState, BlockBehaviour.Properties properties);
}
