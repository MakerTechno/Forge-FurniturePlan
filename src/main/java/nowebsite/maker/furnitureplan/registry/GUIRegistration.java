package nowebsite.maker.furnitureplan.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import nowebsite.maker.furnitureplan.FurniturePlan;
import nowebsite.maker.furnitureplan.blocks.singleblockfurniture.gui.DrawerMenu;

public class GUIRegistration {
    public static void init(){
    }
    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(Registries.MENU, FurniturePlan.MOD_ID);

    public static final DeferredHolder<MenuType<?>, MenuType<DrawerMenu>> DRAWER_MENU1 = MENUS.register("drawer1", () -> new MenuType<>(DrawerMenu::oneRow, FeatureFlags.DEFAULT_FLAGS));
    public static final DeferredHolder<MenuType<?>, MenuType<DrawerMenu>> DRAWER_MENU2 = MENUS.register("drawer2", () -> new MenuType<>(DrawerMenu::twoRows, FeatureFlags.DEFAULT_FLAGS));
}
