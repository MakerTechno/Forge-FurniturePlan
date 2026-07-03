package nowebsite.maker.furnitureplan.common.block.decorating.columns;

import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import nowebsite.maker.furnitureplan.common.block.abstraction.BasePropertyExtendedBlock;
import nowebsite.maker.furnitureplan.common.block.abstraction.generators.SingleMulStateBDG;
import nowebsite.maker.furnitureplan.common.block.abstraction.set.FPBlockSetType;
import nowebsite.maker.furnitureplan.common.block.abstraction.set.FPBlockType;
import nowebsite.maker.furnitureplan.common.data.gen.empowered.BlockDataGenerator;
import nowebsite.maker.furnitureplan.common.init.FPTags;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CarvedColumnBlock extends ColumnBlock {

    public CarvedColumnBlock(FPBlockSetType type, BlockState state, Properties properties) {
        super(type, state, properties);
    }

    @Override
    protected BasePropertyExtendedBlock<ColumnBlock> createNewInstance(BlockState baseState, Properties properties) {
        return new CarvedColumnBlock(getType(), baseState, properties);
    }


    @Override
    public @Nullable BlockDataGenerator<? super @NotNull ColumnBlock> getGenerator() {
        return new SingleMulStateBDG<>() {
            @Override
            public FPBlockType<? extends @NotNull ColumnBlock> getTemplateType(ColumnBlock block) {
                return FPBlockType.CARVED_COLUMN;
            }

            @Override
            public void addBlockTags(ColumnBlock block, BlockTagsProvider provider, List<TagKey<Block>> keys) {
                super.addBlockTags(block, provider, keys);
                keys.add(FPTags.COLUMN_BLOCK);
                keys.add(FPTags.CARVED_COLUMN_BLOCK);
            }
        };
    }
}