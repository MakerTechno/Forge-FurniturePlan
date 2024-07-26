package nowebsite.maker.furnitureplan.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import nowebsite.maker.furnitureplan.FurniturePlan;
import nowebsite.maker.furnitureplan.registry.kindsblock.ChairBlockRegistration;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CreativeModeTabRegistration {
    public static void init(){
        IEventBus bus = NeoForge.EVENT_BUS;
        TABS.register(bus);
        bus.addListener(CreativeModeTabRegistration::registerCreativeModeTabItems);
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
            initKindItem(event, FoldingRegistration.getChairItemLists());
            initKindItem(event, FoldingRegistration.getTableItemLists());
            initKindItem(event, FoldingRegistration.getColumnItemLists());
            initKindItem(event, FoldingRegistration.getCarvedColumnItemLists());
            initKindItem(event, FoldingRegistration.getLightedColumnItemLists());
            event.accept(ItemRegistration.DETRITUS.get());
            event.accept(ItemRegistration.SAWDUST.get());
            event.accept(BlockRegistration.CUPBOARD_BLOCK_ITEM.get());
            event.accept(BlockRegistration.VASE_B_BLOCK_ITEM.get());
        }
    }

    public static void initKindItem(BuildCreativeModeTabContentsEvent event, @NotNull List<DeferredHolder<Item, ? extends Item>> list) {
        assert list.size() == 53;
        for (DeferredHolder<Item, ? extends Item> holder : list) {
            event.accept(holder.get());
        }
    }
}
