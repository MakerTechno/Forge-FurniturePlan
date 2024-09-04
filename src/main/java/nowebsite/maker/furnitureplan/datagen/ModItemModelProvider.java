package nowebsite.maker.furnitureplan.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredHolder;
import nowebsite.maker.furnitureplan.FurniturePlan;
import nowebsite.maker.furnitureplan.blocks.func.IColorfulBlock;
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
        add(FoldingRegistration.getChairItemList());
        add(FoldingRegistration.getTableItemList(), "full");
        add(FoldingRegistration.getColumnItemList(), "full");
        add(FoldingRegistration.getCarvedColumnItemList(), "full");
        add(FoldingRegistration.getLightedColumnItemList(), "full");

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
        withExistingParent(BlockRegistration.TABLE_LAMP_ITEM.get().toString(), modLoc("block/table_lamp_off"));
        withExistingParent(BlockRegistration.GRASS_GRASS_ITEM.get().toString(), modLoc("block/grass_grass"));

        addWithColorsSingleModel(FoldingRegistration.getPotHolderItemList(), "pot_holder");
        add(FoldingRegistration.getBenchItemList());
    }

    public void add(@NotNull List<DeferredHolder<Item, ? extends Item>> list) {
        assert list.size() <= FoldingRegistration.PROPERTY_KINDS.size();
        for(DeferredHolder<Item, ? extends Item> ro : list) {
            withExistingParent(ro.get().toString(), modLoc("block/" + ro.getId().getPath()));
        }
    }
    public void add(@NotNull List<DeferredHolder<Item, ? extends Item>> list, String specificName) {
        assert list.size() <= FoldingRegistration.PROPERTY_KINDS.size();
        for(DeferredHolder<Item, ? extends Item> ro : list) {
            withExistingParent(ro.get().toString(), modLoc("block/" + ro.getId().getPath() + "_" + specificName));
        }
    }
    public void addWithColorsSingleModel(@NotNull List<DeferredHolder<Item, ? extends Item>> list, String specificName) {
        assert list.size() <= IColorfulBlock.CONCRETE_TEXTURE_LIST.size();
        for(int i = 0; i < list.size(); i++) {
            DeferredHolder<Item, ? extends Item> ro = list.get(i);
            singleTexture(
                ro.get().toString(),
                modLoc("item/" + specificName),
                "particle",
                IColorfulBlock.CONCRETE_TEXTURE_LIST.get(i)
            );
        }
    }
}
