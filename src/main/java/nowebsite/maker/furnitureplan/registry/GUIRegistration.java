package nowebsite.maker.furnitureplan.registry;

import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import nowebsite.maker.furnitureplan.FurniturePlan;
import nowebsite.maker.furnitureplan.blocks.singleblockfurniture.gui.DrawerMenu;

public class GUIRegistration {
    public static void init(){
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        MENUS.register(bus);
    }
    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(ForgeRegistries.MENU_TYPES, FurniturePlan.MOD_ID);

    public static final RegistryObject<MenuType<DrawerMenu>> DRAWER_MENU1 = MENUS.register("drawer1", () -> new MenuType<>(DrawerMenu::oneRow, FeatureFlags.DEFAULT_FLAGS));
    public static final RegistryObject<MenuType<DrawerMenu>> DRAWER_MENU2 = MENUS.register("drawer2", () -> new MenuType<>(DrawerMenu::twoRows, FeatureFlags.DEFAULT_FLAGS));
}
