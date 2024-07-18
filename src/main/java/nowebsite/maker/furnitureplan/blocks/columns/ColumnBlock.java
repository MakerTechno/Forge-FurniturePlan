package nowebsite.maker.furnitureplan.blocks.columns;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.VoxelShape;
import nowebsite.maker.furnitureplan.blocks.func.BasePropertyBlock;
import nowebsite.maker.furnitureplan.blocks.func.definition.ColumnShape;
import nowebsite.maker.furnitureplan.registry.BlockRegistration;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("deprecation")
public class ColumnBlock extends BasePropertyBlock implements SimpleWaterloggedBlock {
    public static final EnumProperty<ColumnShape> SHAPE = BlockRegistration.BlockStateRegistration.COLUMN_SHAPE;
    public ColumnBlock(@NotNull BlockState state, Properties properties) {
        super(state, properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(WATERLOGGED, Boolean.FALSE).setValue(SHAPE, ColumnShape.FULL));
    }
    @Override
    public @NotNull VoxelShape getOcclusionShape(@NotNull BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos pos) {
        return state.getValue(SHAPE).getOccModel(state, getter, pos);
    }
    @Override
    public void neighborChanged(@NotNull BlockState pState, @NotNull Level pLevel, @NotNull BlockPos pPos, @NotNull Block pNeighborBlock, @NotNull BlockPos pNeighborPos, boolean pMovedByPiston) {
        super.neighborChanged(pState, pLevel, pPos, pNeighborBlock, pNeighborPos, pMovedByPiston);
        Direction direction = Direction.fromNormal(pNeighborPos);
        updateShape(pState, direction == null ? Direction.NORTH : direction, pLevel.getBlockState(pNeighborPos), pLevel, pPos, pNeighborPos);
    }

    @Override
    public @NotNull BlockState updateShape(@NotNull BlockState pState, @NotNull Direction pDirection, @NotNull BlockState pNeighborState, @NotNull LevelAccessor pLevel, @NotNull BlockPos pPos, @NotNull BlockPos pNeighborPos) {
        super.updateShape(pState, pDirection, pNeighborState, pLevel, pPos, pNeighborPos);
        int countState =
                (pLevel.getBlockState(pPos.below()).getBlock() instanceof ColumnBlock ? 1 : 0)
                        + (pLevel.getBlockState(pPos.above()).getBlock() instanceof ColumnBlock ? 2 : 0);
        return switch (countState) {
            case 1 -> pState.setValue(SHAPE, ColumnShape.TOP);
            case 2 -> pState.setValue(SHAPE, ColumnShape.BASE);
            case 3 -> pState.setValue(SHAPE, ColumnShape.CONNECT);
            default -> pState.setValue(SHAPE, ColumnShape.FULL);
        };
    }

    @Override
    public String getSpecificName() {
        return "column";
    }

    @Override
    public String parentName() {
        return getSpecificName();
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> pBuilder) {
        pBuilder.add(WATERLOGGED, SHAPE);
    }
}
