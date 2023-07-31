package nowebsite.maker.furnitureplan.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import nowebsite.maker.furnitureplan.FurniturePlan;
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
        addKindsByDefault(FoldingRegistration.getChairBlockLists());
        addKindsByDefault(FoldingRegistration.getTableBlockLists());
    }

    public void addKindsByDefault(@NotNull List<RegistryObject<? extends Block>> list) {
        assert list.size() <= FoldingRegistration.PROPERTY_KINDS.length;
        int count = 0;
        for(RegistryObject<? extends Block> ro : list) {
            tag(FoldingRegistration.PROPERTY_TAGS.get(count)).add(ro.get());
            count++;
        }
    }
}
