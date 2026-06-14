package nowebsite.maker.furnitureplan.blocks.multiaffected;

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
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import nowebsite.maker.furnitureplan.blocks.func.BasePropertyHorizontalDirectionBlock;
import nowebsite.maker.furnitureplan.blocks.func.IUVLockedBlock;
import nowebsite.maker.furnitureplan.blocks.func.IVarietyBlock;
import nowebsite.maker.furnitureplan.blocks.func.definition.TableShape;
import nowebsite.maker.furnitureplan.registry.BlockRegistration;
import org.jetbrains.annotations.NotNull;

public class TableBlock extends BasePropertyHorizontalDirectionBlock<TableBlock> implements IVarietyBlock, IUVLockedBlock {
    private static final EnumProperty<TableShape> SHAPE = BlockRegistration.BlockStateRegistration.TABLE_SHAPE;

    public TableBlock(@NotNull BlockState state, Properties properties) {
        super(state, properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, Boolean.FALSE));
    }

    @Override
    protected BlockState updateShape(BlockState state, LevelReader level, ScheduledTickAccess ticks, BlockPos pos, Direction directionToNeighbour, BlockPos neighbourPos, BlockState neighbourState, RandomSource random) {
        super.updateShape(state, level, ticks, pos, directionToNeighbour, neighbourPos, neighbourState, random);
        int countState =
            (level.getBlockState(pos.north()).is(BlockRegistration.TABLE_BLOCK) ? 1 : 0)
                + (level.getBlockState(pos.east()).is(BlockRegistration.TABLE_BLOCK) ? 2 : 0)
                + (level.getBlockState(pos.south()).is(BlockRegistration.TABLE_BLOCK) ? 4 : 0)
                + (level.getBlockState(pos.west()).is(BlockRegistration.TABLE_BLOCK) ? 8 : 0);
        return switch (countState) {
            case 0 -> state.setValue(SHAPE, TableShape.FULL);
            case 1 -> state.setValue(SHAPE, TableShape.SIDE).setValue(FACING, Direction.SOUTH);
            case 2 -> state.setValue(SHAPE, TableShape.SIDE).setValue(FACING, Direction.WEST);
            case 3 -> state.setValue(SHAPE, TableShape.SINGLE).setValue(FACING, Direction.SOUTH);
            case 4 -> state.setValue(SHAPE, TableShape.SIDE).setValue(FACING, Direction.NORTH);
            case 6 -> state.setValue(SHAPE, TableShape.SINGLE).setValue(FACING, Direction.WEST);
            case 8 -> state.setValue(SHAPE, TableShape.SIDE).setValue(FACING, Direction.EAST);
            case 9 -> state.setValue(SHAPE, TableShape.SINGLE).setValue(FACING, Direction.EAST);
            case 12 -> state.setValue(SHAPE, TableShape.SINGLE).setValue(FACING, Direction.NORTH);
            default -> state.setValue(SHAPE, TableShape.PANE);
        };
    }

    @Override
    protected BasePropertyHorizontalDirectionBlock<TableBlock> getSelfNew(BlockState baseState, Properties properties) {
        return new TableBlock(baseState, properties);
    }
    @Override
    public boolean useShapeForLightOcclusion(@NotNull BlockState pState) {
        return true;
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return state.getValue(SHAPE).getOccModel(state);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> pBuilder) {
        super.createBlockStateDefinition(pBuilder);
        pBuilder.add(SHAPE);
    }
    @Override
    public String getSpecificName() {
        return "table";
    }

    @Override
    public String parentName() {
        return null;
    }
}

