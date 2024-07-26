package nowebsite.maker.furnitureplan.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredHolder;
import nowebsite.maker.furnitureplan.FurniturePlan;
import nowebsite.maker.furnitureplan.blocks.func.IWeatheringCopper;
import nowebsite.maker.furnitureplan.registry.BlockRegistration;
import nowebsite.maker.furnitureplan.registry.FoldingRegistration;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, FurniturePlan.MOD_ID, existingFileHelper);
    }

    protected void addTags(HolderLookup.@NotNull Provider provider) {
        addKindsByDefault(FoldingRegistration.getChairBlockLists(), BlockRegistration.CHAIR_BLOCK);
        addKindsByDefault(FoldingRegistration.getTableBlockLists(), BlockRegistration.TABLE_BLOCK);
        addKindsByDefault(FoldingRegistration.getColumnBlockLists(), BlockRegistration.COLUMN_BLOCK);
        addKindsByDefault(FoldingRegistration.getCarvedColumnBlockLists(), BlockRegistration.CARVED_COLUMN_BLOCK);
        addKindsByDefault(FoldingRegistration.getLightedColumnBlockLists(), BlockRegistration.LIGHTED_COLUMN_BLOCK);
    }

    public void addKindsByDefault(@NotNull List<DeferredHolder<Block, ? extends Block>> list, TagKey<Block> additionalTag) {
        assert list.size() <= FoldingRegistration.PROPERTY_KINDS.size();
        int count = 0;
        for(DeferredHolder<Block, ? extends Block> holder : list) {
            tag(FoldingRegistration.PROPERTY_TAGS.get(count)).add(holder.get());
            if (holder.get() instanceof IWeatheringCopper) {
                tag(BlockTags.NEEDS_STONE_TOOL).add(holder.get());
            }
            if (additionalTag != null) tag(additionalTag).add(holder.get());
            count++;
        }
    }
}
