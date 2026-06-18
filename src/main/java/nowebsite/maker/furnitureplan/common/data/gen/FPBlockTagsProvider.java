package nowebsite.maker.furnitureplan.common.data.gen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import nowebsite.maker.furnitureplan.FurniturePlan;
import nowebsite.maker.furnitureplan.common.data.gen.empowered.BlockDataGenerator;

import java.util.concurrent.CompletableFuture;

public class FPBlockTagsProvider extends BlockTagsProvider {
    public FPBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, FurniturePlan.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        FPDataGenerators.GENERATORS.forEach((block, blockDataGenerator) -> invokeGenerator(block, blockDataGenerator, this));
    }

    @SuppressWarnings("unchecked")
    private <T extends Block> void invokeGenerator(Block block, BlockDataGenerator<?> generator, BlockTagsProvider provider) {
        BlockDataGenerator<T> typedGenerator = (BlockDataGenerator<T>) generator;
        typedGenerator.getRegBlockTags((T) block, provider).stream().filter(tagKey -> tagKey instanceof TagKey<Block>).forEach(tagKey -> tag(tagKey).add(block));
    }
}
