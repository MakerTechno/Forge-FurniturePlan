package nowebsite.maker.furnitureplan.registry;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import nowebsite.maker.furnitureplan.FurniturePlan;
import nowebsite.maker.furnitureplan.items.Graver;

public class ItemRegistration {
    public static void init() {
        IEventBus bus = NeoForge.EVENT_BUS;
        ITEMS.register(bus);
    }
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.createItems(FurniturePlan.MOD_ID);
    public static final DeferredHolder<Item, Item> TEST_ITEM = ITEMS.register("test_item", () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, Item> GRAVER = ITEMS.register("graver", () -> new Graver(new Item.Properties().stacksTo(1).setNoRepair().durability(300)));
    public static final DeferredHolder<Item, Item> SAWDUST = ITEMS.register("sawdust", () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, Item> DETRITUS = ITEMS.register("detritus", () -> new Item(new Item.Properties()));
}

