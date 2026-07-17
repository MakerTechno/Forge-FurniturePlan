package nowebsite.maker.furnitureplan.common.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import nowebsite.maker.furnitureplan.FurniturePlan;
import nowebsite.maker.furnitureplan.common.item.GraverItem;
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
    public static final DeferredItem<@NotNull Item> GRAVER = ITEMS.register("graver", identifier -> new GraverItem(new Item.Properties().stacksTo(1).setId(getItemId(identifier))));

    private static @NotNull ResourceKey<Item> getItemId(Identifier name) {
        return ResourceKey.create(Registries.ITEM, name);
    }
}
