package nowebsite.maker.furnitureplan.datagen;

import com.google.common.collect.Iterables;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTables;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.registries.RegistryObject;
import nowebsite.maker.furnitureplan.registry.BlockRegistration;
import nowebsite.maker.furnitureplan.registry.FoldingRegistration;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ModLootTableProvider extends LootTableProvider {
    static Set<ResourceLocation> resourceLocations = new HashSet<>();
    static {
        for (RegistryObject<? extends Block> ro : FoldingRegistration.getChairBlockLists()) {
            resourceLocations.add(ro.getId());
        }
        for (RegistryObject<? extends Block> ro : FoldingRegistration.getTableBlockLists()) {
            resourceLocations.add(ro.getId());
        }
        for (RegistryObject<? extends Block> ro : FoldingRegistration.getColumnBlockLists()) {
            resourceLocations.add(ro.getId());
        }
        for (RegistryObject<? extends Block> ro : FoldingRegistration.getCarvedColumnBlockLists()) {
            resourceLocations.add(ro.getId());
        }
        for (RegistryObject<? extends Block> ro : FoldingRegistration.getLightedColumnBlockLists()) {
            resourceLocations.add(ro.getId());
        }
        resourceLocations.add(BlockRegistration.FOOD_PLATE_BLOCK.getId());
        resourceLocations.add(BlockRegistration.GLASS_B_BLOCK.getId());
        resourceLocations.add(BlockRegistration.CUTLERY_BLOCK.getId());
        resourceLocations.add(BlockRegistration.FOOD_PLATE_AND_GLASS_AND_CUTLERY_BLOCK.getId());
        resourceLocations.add(BlockRegistration.FOOD_PLATE_AND_GLASS_BLOCK.getId());
        resourceLocations.add(BlockRegistration.FOOD_PLATE_AND_CUTLERY_BLOCK.getId());
    }

    public ModLootTableProvider(PackOutput output) {
        super(output, resourceLocations, List.of(new SubProviderEntry(ModCustomBlockLootProvider::new, LootContextParamSets.BLOCK)));
    }

    protected void validate(@NotNull Map<ResourceLocation, LootTable> map, @NotNull ValidationContext validationcontext) {
        map.forEach((key, value) -> LootTables.validate(validationcontext, key, value));
    }
}

class ModCustomBlockLootProvider extends BlockLootSubProvider {
    public ModCustomBlockLootProvider() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    protected void generate() {
        this.addKindsProp(FoldingRegistration.getChairBlockLists());
        this.addKindsProp(FoldingRegistration.getTableBlockLists());
        this.addKindsProp(FoldingRegistration.getColumnBlockLists());
        this.addKindsProp(FoldingRegistration.getCarvedColumnBlockLists());
        this.addKindsProp(FoldingRegistration.getLightedColumnBlockLists());

        dropSelf(BlockRegistration.FOOD_PLATE_BLOCK.get());
        dropSelf(BlockRegistration.GLASS_B_BLOCK.get());
        dropSelf(BlockRegistration.CUTLERY_BLOCK.get());
        dropOther(BlockRegistration.FOOD_PLATE_AND_GLASS_AND_CUTLERY_BLOCK.get(), BlockRegistration.CUTLERY_ITEM.get());
        dropOther(BlockRegistration.FOOD_PLATE_AND_GLASS_BLOCK.get(), BlockRegistration.GLASS_B_BLOCK_ITEM.get());
        dropOther(BlockRegistration.FOOD_PLATE_AND_CUTLERY_BLOCK.get(), BlockRegistration.CUTLERY_ITEM.get());
    }

    protected @NotNull Iterable<Block> getKnownBlocks() {
        return Iterables.transform(BlockRegistration.BLOCKS.getEntries(), RegistryObject::get);
    }

    public void addKindsProp(@NotNull List<RegistryObject<? extends Block>> list) {
        assert list.size() <= FoldingRegistration.PROPERTY_KINDS.length;
        for(RegistryObject<? extends Block> ro : list) {
            dropSelf(ro.get());
        }
    }
}
