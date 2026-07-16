package nowebsite.maker.furnitureplan.common.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import nowebsite.maker.furnitureplan.FurniturePlan;

public class FPItemReg {
    public static void touch () {

    }

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(FurniturePlan.MOD_ID);
    public static final DeferredItem<Item> AGERATUM_GUIDEBOOK = ITEMS.registerSimpleItem("ageratum_guidebook");
}
