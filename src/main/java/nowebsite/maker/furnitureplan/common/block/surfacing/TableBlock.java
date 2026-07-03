package nowebsite.maker.furnitureplan.common.block.surfacing;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import nowebsite.maker.furnitureplan.common.block.abstraction.BasePropertyHorizontalDirectionBlock;
import nowebsite.maker.furnitureplan.common.block.abstraction.MulStateGetter;
import nowebsite.maker.furnitureplan.common.block.abstraction.definition.TableShape;
import nowebsite.maker.furnitureplan.common.block.abstraction.generators.HorizontalMulStateBDG;
import nowebsite.maker.furnitureplan.common.block.abstraction.set.FPBlockSetType;
import nowebsite.maker.furnitureplan.common.block.abstraction.set.FPBlockType;
import nowebsite.maker.furnitureplan.common.data.gen.empowered.BlockDataGenerator;
import nowebsite.maker.furnitureplan.common.init.FPBlockReg;
import nowebsite.maker.furnitureplan.common.init.FPTags;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TableBlock extends BasePropertyHorizontalDirectionBlock<TableBlock> implements MulStateGetter<TableShape> {
    private static final EnumProperty<@NotNull TableShape> SHAPE = FPBlockReg.BlockStateReg.TABLE_SHAPE;

    public TableBlock(FPBlockSetType type, BlockState state, Properties properties) {
        super(type, state, properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, Boolean.FALSE));
    }

    @Override
    protected BlockState updateShape(BlockState state, LevelReader level, ScheduledTickAccess ticks, BlockPos pos, Direction directionToNeighbour, BlockPos neighbourPos, BlockState neighbourState, RandomSource random) {
        super.updateShape(state, level, ticks, pos, directionToNeighbour, neighbourPos, neighbourState, random);
        int countState =
            (level.getBlockState(pos.north()).getBlock() instanceof TableBlock ? 1 : 0)
                + (level.getBlockState(pos.east()).getBlock() instanceof TableBlock ? 2 : 0)
                + (level.getBlockState(pos.south()).getBlock() instanceof TableBlock ? 4 : 0)
                + (level.getBlockState(pos.west()).getBlock() instanceof TableBlock ? 8 : 0);
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
    protected BasePropertyHorizontalDirectionBlock<TableBlock> createNewInstance(BlockState baseState, Properties properties) {
        return new TableBlock(getType(), baseState, properties);
    }
    @Override
    public boolean useShapeForLightOcclusion(BlockState pState) {
        return true;
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return state.getValue(SHAPE).getOccModel(state);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, @NotNull BlockState> pBuilder) {
        super.createBlockStateDefinition(pBuilder);
        pBuilder.add(SHAPE);
    }

    @Override
    public @Nullable BlockDataGenerator<? super @NotNull TableBlock> getGenerator() {
        return new HorizontalMulStateBDG<>() {
            @Override
            public FPBlockType<? extends @NotNull TableBlock> getTemplateType(TableBlock block) {
                return FPBlockType.TABLE;
            }

            @Override
            public boolean doLockUV() {
                return true;
            }

            @Override
            public void addBlockTags(@NotNull TableBlock block, BlockTagsProvider provider, List<TagKey<Block>> keys) {
                super.addBlockTags(block, provider, keys);
                keys.add(FPTags.TABLE_BLOCK);
            }
        };
    }

    @Override
    public EnumProperty<@NotNull TableShape> getContainer() {
        return SHAPE;
    }
}

