package nowebsite.maker.furnitureplan.blocks.singleblockfurniture;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
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
    public @NotNull BlockState updateShape(@NotNull BlockState pState, @NotNull Direction pDirection, @NotNull BlockState pNeighborState, @NotNull LevelAccessor pLevel, @NotNull BlockPos pPos, @NotNull BlockPos pNeighborPos) {
        super.updateShape(pState, pDirection, pNeighborState, pLevel, pPos, pNeighborPos);
        int countState =
                (pLevel.getBlockState(pPos.north()).is(BlockRegistration.TABLE_BLOCK) ? 1 : 0)
                        + (pLevel.getBlockState(pPos.east()).is(BlockRegistration.TABLE_BLOCK) ? 2 : 0)
                        + (pLevel.getBlockState(pPos.south()).is(BlockRegistration.TABLE_BLOCK) ? 4 : 0)
                        + (pLevel.getBlockState(pPos.west()).is(BlockRegistration.TABLE_BLOCK) ? 8 : 0);
        return switch (countState) {
            case 0 -> pState.setValue(SHAPE, TableShape.FULL);
            case 1 -> pState.setValue(SHAPE, TableShape.SIDE).setValue(FACING, Direction.SOUTH);
            case 2 -> pState.setValue(SHAPE, TableShape.SIDE).setValue(FACING, Direction.WEST);
            case 3 -> pState.setValue(SHAPE, TableShape.SINGLE).setValue(FACING, Direction.SOUTH);
            case 4 -> pState.setValue(SHAPE, TableShape.SIDE).setValue(FACING, Direction.NORTH);
            case 6 -> pState.setValue(SHAPE, TableShape.SINGLE).setValue(FACING, Direction.WEST);
            case 8 -> pState.setValue(SHAPE, TableShape.SIDE).setValue(FACING, Direction.EAST);
            case 9 -> pState.setValue(SHAPE, TableShape.SINGLE).setValue(FACING, Direction.EAST);
            case 12 -> pState.setValue(SHAPE, TableShape.SINGLE).setValue(FACING, Direction.NORTH);
            default -> pState.setValue(SHAPE, TableShape.PANE);
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
    public @NotNull VoxelShape getOcclusionShape(@NotNull BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos pos) {
        return state.getValue(SHAPE).getOccModel(state, getter, pos);
    }
    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return getOcclusionShape(state,getter,pos);
    }
    @Override
    public @NotNull VoxelShape getCollisionShape(@NotNull BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos, @NotNull CollisionContext pContext) {
        return getShape(pState, pLevel, pPos, pContext);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> pBuilder) {
        pBuilder.add(WATERLOGGED, SHAPE, FACING);
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

