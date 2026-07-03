package nowebsite.maker.furnitureplan.common.block.decorating.columns;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import nowebsite.maker.furnitureplan.common.block.abstraction.BasePropertyExtendedBlock;
import nowebsite.maker.furnitureplan.common.block.abstraction.definition.ColumnShape;
import nowebsite.maker.furnitureplan.common.block.abstraction.generators.SingleMulStateBDG;
import nowebsite.maker.furnitureplan.common.block.abstraction.set.FPBlockSetType;
import nowebsite.maker.furnitureplan.common.block.abstraction.set.FPBlockType;
import nowebsite.maker.furnitureplan.common.data.gen.empowered.BlockDataGenerator;
import nowebsite.maker.furnitureplan.common.init.FPTags;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class LightedColumnBlock extends ColumnBlock {
    public static final BooleanProperty LIT = BlockStateProperties.LIT;

    public LightedColumnBlock(FPBlockSetType type, BlockState state, Properties properties) {
        super(type, state, properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(LIT, Boolean.TRUE).setValue(SHAPE, ColumnShape.FULL).setValue(WATERLOGGED, Boolean.FALSE));
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, @NotNull BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(LIT);
    }
    @Override
    protected BasePropertyExtendedBlock<ColumnBlock> createNewInstance(BlockState baseState, Properties properties) {
        return new LightedColumnBlock(getType(), baseState, properties);
    }

    @Override
    public int getLightEmission(BlockState state, BlockGetter level, BlockPos pos) {
        return state.getValue(LIT) ? 15 : 0;
    }

    @Override
    public @Nullable BlockDataGenerator<? super @NotNull ColumnBlock> getGenerator() {
        return new SingleMulStateBDG<>() {
            @Override
            public FPBlockType<? extends @NotNull ColumnBlock> getTemplateType(ColumnBlock block) {
                return FPBlockType.LIGHTED_COLUMN;
            }

            @Override
            public void addBlockTags(ColumnBlock block, BlockTagsProvider provider, List<TagKey<Block>> keys) {
                super.addBlockTags(block, provider, keys);
                keys.add(FPTags.COLUMN_BLOCK);
                keys.add(FPTags.LIGHTED_COLUMN_BLOCK);
            }
        };
    }
}
