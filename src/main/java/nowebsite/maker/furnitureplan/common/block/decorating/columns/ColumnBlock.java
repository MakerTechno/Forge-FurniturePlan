package nowebsite.maker.furnitureplan.common.block.decorating.columns;

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
import nowebsite.maker.furnitureplan.common.block.abstraction.BasePropertyExtendedBlock;
import nowebsite.maker.furnitureplan.common.block.abstraction.MulStateGetter;
import nowebsite.maker.furnitureplan.common.block.abstraction.definition.ColumnShape;
import nowebsite.maker.furnitureplan.common.block.abstraction.generators.SingleMulStateBDG;
import nowebsite.maker.furnitureplan.common.block.abstraction.set.FPBlockSetType;
import nowebsite.maker.furnitureplan.common.block.abstraction.set.FPBlockType;
import nowebsite.maker.furnitureplan.common.data.gen.empowered.BlockDataGenerator;
import nowebsite.maker.furnitureplan.common.init.FPBlockReg;
import nowebsite.maker.furnitureplan.common.init.FPTags;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;

public class ColumnBlock extends BasePropertyExtendedBlock<ColumnBlock> implements MulStateGetter<ColumnShape> {
    public static final EnumProperty<@NotNull ColumnShape> SHAPE = FPBlockReg.BlockStateReg.COLUMN_SHAPE;
    public ColumnBlock(FPBlockSetType type, BlockState state, Properties properties) {
        super(type, state, properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(WATERLOGGED, Boolean.FALSE).setValue(SHAPE, ColumnShape.FULL));
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
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
    protected BasePropertyExtendedBlock<ColumnBlock> createNewInstance (BlockState baseState, Properties properties) {
        return new ColumnBlock(getType(), baseState, properties);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, @NotNull BlockState> pBuilder) {
        super.createBlockStateDefinition(pBuilder);
        pBuilder.add(SHAPE);
    }

    @Override
    public @Nullable BlockDataGenerator<? super @NotNull ColumnBlock> getGenerator() {
        return new SingleMulStateBDG<>() {
            @Override
            public FPBlockType<? extends @NotNull ColumnBlock> getTemplateType(ColumnBlock block) {
                return FPBlockType.COLUMN;
            }

            @Override
            public void addBlockTags(ColumnBlock block, BlockTagsProvider provider, HashSet<TagKey<Block>> keys) {
                super.addBlockTags(block, provider, keys);
                keys.add(FPTags.COLUMN_BLOCK);
            }
        };
    }

    @Override
    public EnumProperty<@NotNull ColumnShape> getContainer() {
        return SHAPE;
    }
}
