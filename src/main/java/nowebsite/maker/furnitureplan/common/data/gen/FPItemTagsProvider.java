package nowebsite.maker.furnitureplan.common.data.gen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ItemTagsProvider;
import nowebsite.maker.furnitureplan.FurniturePlan;

import java.util.concurrent.CompletableFuture;

public class FPItemTagsProvider extends ItemTagsProvider {
    public FPItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, FurniturePlan.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

    }

}
