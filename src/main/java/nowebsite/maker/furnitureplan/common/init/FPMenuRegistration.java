package nowebsite.maker.furnitureplan.common.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import nowebsite.maker.furnitureplan.FurniturePlan;
import nowebsite.maker.furnitureplan.common.block.storaging.gui.DrawerMenu;
import org.jetbrains.annotations.NotNull;

public class FPMenuRegistration {
    public static void init(){
    }
    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(Registries.MENU, FurniturePlan.MOD_ID);

    public static final DeferredHolder<MenuType<?>, @NotNull MenuType<@NotNull DrawerMenu>> DRAWER_MENU1 = MENUS.register("drawer1", () -> new MenuType<>(DrawerMenu::oneRow, FeatureFlags.DEFAULT_FLAGS));
    public static final DeferredHolder<MenuType<?>, @NotNull MenuType<@NotNull DrawerMenu>> DRAWER_MENU2 = MENUS.register("drawer2", () -> new MenuType<>(DrawerMenu::twoRows, FeatureFlags.DEFAULT_FLAGS));
}
