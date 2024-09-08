package nowebsite.maker.furnitureplan.datagen;

import com.google.common.collect.Iterables;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.WritableRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.util.ProblemReporter;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.neoforge.registries.DeferredHolder;
import nowebsite.maker.furnitureplan.registry.BlockRegistration;
import nowebsite.maker.furnitureplan.registry.FoldingRegistration;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModLootTableSubProvider extends LootTableProvider {
    public ModLootTableSubProvider(PackOutput gen, CompletableFuture<HolderLookup.Provider> lookup) {
        super(gen, Set.of(), List.of(new SubProviderEntry(ModCustomBlockLootProvider::new, LootContextParamSets.BLOCK)), lookup);
    }

    @Override
    protected void validate(@NotNull WritableRegistry<LootTable> registry, @NotNull ValidationContext context, ProblemReporter.@NotNull Collector collector) {
        super.validate(registry, context, collector);
    }
}
class ModCustomBlockLootProvider extends BlockLootSubProvider {
    public ModCustomBlockLootProvider(HolderLookup.Provider provider) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider);
    }

    protected void generate() {
        this.addList(FoldingRegistration.getChairBlockList());
        this.addList(FoldingRegistration.getTableBlockList());
        this.addList(FoldingRegistration.getColumnBlockList());
        this.addList(FoldingRegistration.getCarvedColumnBlockList());
        this.addList(FoldingRegistration.getLightedColumnBlockList());
        this.addList(FoldingRegistration.getPotHolderBlockList());
        this.addList(FoldingRegistration.getBenchBlockList());
        this.addList(FoldingRegistration.getCabinetBlockList());

        add(BlockRegistration.FOOD_PLATE_BLOCK.get(), noDrop());
        add(BlockRegistration.GLASS_B_BLOCK.get(), noDrop());
        dropSelf(BlockRegistration.CUTLERY_BLOCK.get());
        dropSelf(BlockRegistration.LANTERN_BLOCK.get());
        dropSelf(BlockRegistration.IRON_POT_BLOCK.get());
        add(BlockRegistration.STOVE_BLOCK.get(), noDrop());
        dropSelf(BlockRegistration.CUPBOARD_BLOCK.get());
        dropSelf(BlockRegistration.VASE_B_BLOCK.get());
        dropSelf(BlockRegistration.TABLE_LAMP.get());
        dropSelf(BlockRegistration.GRASS_GRASS.get());
    }

    protected @NotNull Iterable<Block> getKnownBlocks() {
        return Iterables.transform(BlockRegistration.BLOCKS.getEntries(), DeferredHolder::get);
    }

    public void addList(@NotNull List<DeferredHolder<Block, ? extends Block>> list) {
        for(DeferredHolder<Block, ? extends Block> ro : list) {
            dropSelf(ro.get());
        }
    }
}
