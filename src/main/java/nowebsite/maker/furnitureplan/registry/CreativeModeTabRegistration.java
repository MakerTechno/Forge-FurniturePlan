package nowebsite.maker.furnitureplan.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import nowebsite.maker.furnitureplan.FurniturePlan;
import nowebsite.maker.furnitureplan.registry.kindsblock.ChairBlockRegistration;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CreativeModeTabRegistration {
    public static void init(){
    }

    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FurniturePlan.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MAIN_TAB = TABS.register("main_tab", () -> CreativeModeTab.builder().title(Component.translatable("itemGroup.furniture")).icon(() -> new ItemStack(ChairBlockRegistration.OAK_CHAIR_ITEM.get())).build());

    public static void registerCreativeModeTabItems(@NotNull BuildCreativeModeTabContentsEvent event) {
        if (event.getTab().equals(MAIN_TAB.get())) {
            event.accept(ItemRegistration.GRAVER.get());
            event.accept(BlockRegistration.FOOD_PLATE_BLOCK_ITEM.get());
            event.accept(BlockRegistration.GLASS_B_BLOCK_ITEM.get());
            event.accept(BlockRegistration.CUTLERY_ITEM.get());
            event.accept(BlockRegistration.LANTERN_ITEM.get());
            event.accept(BlockRegistration.IRON_POT_BLOCK.get());
            event.accept(BlockRegistration.CUPBOARD_BLOCK_ITEM.get());
            event.accept(BlockRegistration.STOVE_BLOCK_ITEM.get());
            event.accept(BlockRegistration.TABLE_LAMP_ITEM.get());
            event.accept(ItemRegistration.DETRITUS.get());
            event.accept(ItemRegistration.SAWDUST.get());
            initKindItem(event, FoldingRegistration.getPotHolderItemList());
            initKindItem(event, FoldingRegistration.getChairItemList());
            initKindItem(event, FoldingRegistration.getTableItemList());
            initKindItem(event, FoldingRegistration.getColumnItemList());
            initKindItem(event, FoldingRegistration.getCarvedColumnItemList());
            initKindItem(event, FoldingRegistration.getLightedColumnItemList());
            initKindItem(event, FoldingRegistration.getBenchItemList());
            initKindItem(event, FoldingRegistration.getCabinetItemList());


            initKindItem(event, ColorfulCabinetFolding.getBlackCabinetItemList());
            initKindItem(event, ColorfulCabinetFolding.getBlueCabinetItemList());
            initKindItem(event, ColorfulCabinetFolding.getBrownCabinetItemList());
            initKindItem(event, ColorfulCabinetFolding.getCyanCabinetItemList());
            initKindItem(event, ColorfulCabinetFolding.getGrayCabinetItemList());
            initKindItem(event, ColorfulCabinetFolding.getGreenCabinetItemList());
            initKindItem(event, ColorfulCabinetFolding.getLightBlueCabinetItemList());
            initKindItem(event, ColorfulCabinetFolding.getLightGrayCabinetItemList());
            initKindItem(event, ColorfulCabinetFolding.getLimeCabinetItemList());
            initKindItem(event, ColorfulCabinetFolding.getMagentaCabinetItemList());
            initKindItem(event, ColorfulCabinetFolding.getOrangeCabinetItemList());
            initKindItem(event, ColorfulCabinetFolding.getPinkCabinetItemList());
            initKindItem(event, ColorfulCabinetFolding.getPurpleCabinetItemList());
            initKindItem(event, ColorfulCabinetFolding.getRedCabinetItemList());
            initKindItem(event, ColorfulCabinetFolding.getYellowCabinetItemList());
            initKindItem(event, ColorfulCabinetFolding.getWhiteCabinetItemList());
            //event.accept(BlockRegistration.VASE_B_BLOCK_ITEM.get());
        }
    }

    public static void initKindItem(BuildCreativeModeTabContentsEvent event, @NotNull List<DeferredHolder<Item, ? extends Item>> list) {
        assert list.size() == 53;
        for (DeferredHolder<Item, ? extends Item> holder : list) {
            event.accept(holder.get());
        }
    }
}
