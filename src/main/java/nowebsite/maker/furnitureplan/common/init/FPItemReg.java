package nowebsite.maker.furnitureplan.common.init;

import net.neoforged.fml.ModList;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import nowebsite.maker.furnitureplan.FurniturePlan;
import org.jetbrains.annotations.NotNull;

public class FPItemReg {
    public static void touch () {}

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(FurniturePlan.MOD_ID);
    public static DeferredItem<@NotNull Item> AGERATUM_GUIDEBOOK = null;
    static {
        if (ModList.get().isLoaded("ageratum")) {
            AGERATUM_GUIDEBOOK = ITEMS.registerSimpleItem("ageratum_guidebook");
        }
    }

    public static final DeferredItem<@NotNull Item> SAWDUST = ITEMS.registerSimpleItem("sawdust");
    public static final DeferredItem<@NotNull Item> DETRITUS = ITEMS.registerSimpleItem("detritus");
}
