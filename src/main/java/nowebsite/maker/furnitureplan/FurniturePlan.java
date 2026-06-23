package nowebsite.maker.furnitureplan;

import com.mojang.logging.LogUtils;
import net.minecraft.resources.Identifier;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import nowebsite.maker.furnitureplan.common.event.ClientEvents;
import nowebsite.maker.furnitureplan.common.init.*;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

@Mod(FurniturePlan.MOD_ID)
public class FurniturePlan {
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final String MOD_ID = "furnitureplan";
    //public static BlockEntityWithoutLevelRenderer renderer;

    public FurniturePlan(@NotNull IEventBus bus) {
        LOGGER.info("Furniture plan alpha is on loading!");
        FPBlockSetTypes.touch();
        FPBlockReg.touch();
        FPItemReg.touch();
        FPEntityTypeReg.touch();
        FPCreativeModTabReg.touch();

        FPBlockReg.BLOCKS.register(bus);
        FPBlockReg.BLOCK_ENTITIES.register(bus);
        FPItemReg.ITEMS.register(bus);
        FPEntityTypeReg.ENTITIES.register(bus);
        FPCreativeModTabReg.TABS.register(bus);
        FPMenuRegistration.MENUS.register(bus);

        bus.addListener(FPCreativeModTabReg::registerCreativeTabs);
        bus.addListener(ClientEvents::registerEntityRenderers);
        /*
        BlockRegistration.init();
        ItemRegistration.init();
        EntityRegistration.init();
        PaintRegistration.init();
        GUIRegistration.init();
        CreativeModeTabRegistration.init();
        BlockRegistration.BLOCKS.register(modEventBus);
        BlockRegistration.BLOCK_ENTITY.register(modEventBus);
        ItemRegistration.ITEMS.register(modEventBus);
        EntityRegistration.ENTITIES.register(modEventBus);
        CreativeModeTabRegistration.TABS.register(modEventBus);
        PaintRegistration.PAINTINGS.register(modEventBus);
        GUIRegistration.MENUS.register(modEventBus);

        modEventBus.addListener(CreativeModeTabRegistration::registerCreativeModeTabItems);
        modEventBus.addListener(ModDataGenerators::gatherData);
*/
    }

    @Contract("_ -> new")
    public static @NotNull Identifier asResource(String path) {
        return Identifier.fromNamespaceAndPath(MOD_ID, path);
    }
}
