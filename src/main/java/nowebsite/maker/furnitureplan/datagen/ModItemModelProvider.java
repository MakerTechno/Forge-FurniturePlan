package nowebsite.maker.furnitureplan.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import nowebsite.maker.furnitureplan.FurniturePlan;
import nowebsite.maker.furnitureplan.registry.FoldingRegistration;
import nowebsite.maker.furnitureplan.registry.ItemRegistration;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper helper) {
        super(output, FurniturePlan.MOD_ID, helper);
    }

    protected void registerModels() {
        singleTexture(
                ItemRegistration.TEST_ITEM.get().toString(),
                mcLoc("item/generated"),
                "layer0",
                modLoc("item/test_item")
        );
        singleTexture(
                ItemRegistration.GRAVER.get().toString(),
                mcLoc("item/generated"),
                "layer0",
                modLoc("item/graver")
        );
        singleTexture(
                ItemRegistration.SAWDUST.get().toString(),
                mcLoc("item/generated"),
                "layer0",
                modLoc("item/sawdust")
        );
        singleTexture(
                ItemRegistration.DETRITUS.get().toString(),
                mcLoc("item/generated"),
                "layer0",
                modLoc("item/detritus")
        );
        add(FoldingRegistration.getChairItemLists());
        add(FoldingRegistration.getTableItemLists());
        add(FoldingRegistration.getColumnItemLists());
        add(FoldingRegistration.getCarvedColumnItemLists());
        add(FoldingRegistration.getLightedColumnItemLists());
    }

    public void add(@NotNull List<RegistryObject<? extends Item>> list) {
        assert list.size() <= FoldingRegistration.PROPERTY_KINDS.length;
        for(RegistryObject<? extends Item> ro : list) {
            withExistingParent(ro.get().toString(), modLoc("block/" + ro.get()));
        }
    }
}
