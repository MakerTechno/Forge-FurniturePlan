package nowebsite.maker.furnitureplan.blocks.columns;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.VoxelShape;
import nowebsite.maker.furnitureplan.blocks.func.BasePropertyBlock;
import nowebsite.maker.furnitureplan.blocks.func.definition.ColumnShape;
import nowebsite.maker.furnitureplan.registry.BlockRegistration;
import org.jetbrains.annotations.NotNull;

public class ColumnBlock extends BasePropertyBlock<ColumnBlock> {
    public static final EnumProperty<ColumnShape> SHAPE = BlockRegistration.BlockStateRegistration.COLUMN_SHAPE;
    public ColumnBlock(@NotNull BlockState state, Properties properties) {
        super(state, properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(WATERLOGGED, Boolean.FALSE).setValue(SHAPE, ColumnShape.FULL));
    }

    @Override
    protected @NotNull VoxelShape getOcclusionShape(@NotNull BlockState state) {
        return state.getValue(SHAPE).getOccModel(state);
    }

    @Override
    protected BlockState updateShape(BlockState state, LevelReader level, ScheduledTickAccess ticks, BlockPos pos, Direction directionToNeighbour, BlockPos neighbourPos, BlockState neighbourState, RandomSource random) {
        super.updateShape(state, level, ticks, pos, directionToNeighbour, neighbourPos, neighbourState, random);
        int countState =
            (level.getBlockState(pos.below()).getBlock() instanceof ColumnBlock ? 1 : 0)
                + (level.getBlockState(pos.above()).getBlock() instanceof ColumnBlock ? 2 : 0);
        return switch (countState) {
            case 1 -> state.setValue(SHAPE, ColumnShape.TOP);
            case 2 -> state.setValue(SHAPE, ColumnShape.BASE);
            case 3 -> state.setValue(SHAPE, ColumnShape.CONNECT);
            default -> state.setValue(SHAPE, ColumnShape.FULL);
        };
    }

    @Override
    protected BasePropertyBlock<ColumnBlock> getSelfNew(BlockState baseState, Properties properties) {
        return new ColumnBlock(baseState, properties);
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
    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, @NotNull BlockState> pBuilder) {
        super.createBlockStateDefinition(pBuilder);
        pBuilder.add(SHAPE);
    }

}
