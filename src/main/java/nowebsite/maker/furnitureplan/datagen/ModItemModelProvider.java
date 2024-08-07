package nowebsite.maker.furnitureplan.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import nowebsite.maker.furnitureplan.FurniturePlan;
import nowebsite.maker.furnitureplan.registry.BlockRegistration;
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
        add(FoldingRegistration.getTableItemLists(), "full");
        add(FoldingRegistration.getColumnItemLists(), "full");
        add(FoldingRegistration.getCarvedColumnItemLists(), "full");
        add(FoldingRegistration.getLightedColumnItemLists(), "full");

        withExistingParent(BlockRegistration.FOOD_PLATE_BLOCK_ITEM.get().toString(), modLoc("block/food_plate_block_plt"));
        withExistingParent(BlockRegistration.GLASS_B_BLOCK_ITEM.get().toString(), modLoc("block/glass_b_block"));
        singleTexture(
                BlockRegistration.CUTLERY_ITEM.get().toString(),
                modLoc("item/cutlery_handing"),
                "particle",
                modLoc("block/plate")
        );
        withExistingParent(BlockRegistration.LANTERN_ITEM.get().toString(), modLoc("block/lantern_block"));
        withExistingParent(BlockRegistration.IRON_POT_BLOCK_ITEM.get().toString(), modLoc("block/iron_pot_block"));
        withExistingParent(BlockRegistration.STOVE_BLOCK_ITEM.get().toString(), modLoc("block/stove_block_u"));

        withExistingParent(BlockRegistration.CUPBOARD_BLOCK_ITEM.get().toString(), modLoc("item/cupboard"));
        withExistingParent(BlockRegistration.VASE_B_BLOCK_ITEM.get().toString(), modLoc("block/vase"));
    }

    public void add(@NotNull List<RegistryObject<? extends Item>> list) {
        assert list.size() <= FoldingRegistration.PROPERTY_KINDS.size();
        for(RegistryObject<? extends Item> ro : list) {
            withExistingParent(ro.get().toString(), modLoc("block/" + ro.get()));
        }
    }
    public void add(@NotNull List<RegistryObject<? extends Item>> list, String specificName) {
        assert list.size() <= FoldingRegistration.PROPERTY_KINDS.size();
        for(RegistryObject<? extends Item> ro : list) {
            withExistingParent(ro.get().toString(), modLoc("block/" + ro.get() + "_" + specificName));
        }
    }
}
