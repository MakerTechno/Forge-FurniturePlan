package nowebsite.maker.furnitureplan;

import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import nowebsite.maker.furnitureplan.datagen.ModDataGenerators;
import nowebsite.maker.furnitureplan.registry.*;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

@Mod(FurniturePlan.MOD_ID)
public class FurniturePlan {
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final String MOD_ID = "furnitureplan";
    public static BlockEntityWithoutLevelRenderer renderer;

    public FurniturePlan(@NotNull IEventBus modEventBus) {
        LOGGER.info("Furniture plan alpha is on loading!");
        BlockRegistration.init();
        ItemRegistration.init();
        PaintRegistration.init();
        GUIRegistration.init();
        CreativeModeTabRegistration.init();
        BlockRegistration.BLOCKS.register(modEventBus);
        BlockRegistration.BLOCK_ENTITY.register(modEventBus);
        ItemRegistration.ITEMS.register(modEventBus);
        CreativeModeTabRegistration.TABS.register(modEventBus);
        PaintRegistration.PAINTINGS.register(modEventBus);
        GUIRegistration.MENUS.register(modEventBus);

        modEventBus.addListener(CreativeModeTabRegistration::registerCreativeModeTabItems);
        modEventBus.addListener(ModDataGenerators::gatherData);

    }

}
