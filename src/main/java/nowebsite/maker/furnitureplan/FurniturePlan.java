package nowebsite.maker.furnitureplan;

import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import nowebsite.maker.furnitureplan.datagen.ModDataGenerators;
import nowebsite.maker.furnitureplan.registry.*;
import nowebsite.maker.furnitureplan.setup.ModSetup;
import org.slf4j.Logger;

@Mod(FurniturePlan.MOD_ID)
public class FurniturePlan {
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final String MOD_ID = "furnitureplan";
    public static BlockEntityWithoutLevelRenderer renderer;

    public FurniturePlan() {
        LOGGER.info("Furniture plan alpha is on loading!");
        EntityRegistration.init();
        BlockRegistration.init();
        ItemRegistration.init();
        PaintRegistration.init();
        GUIRegistration.init();
        CreativeModeTabRegistration.init();
        IEventBus modbus = NeoForge.EVENT_BUS;
        modbus.addListener(ModDataGenerators::gatherData);

        modbus.addListener((FMLCommonSetupEvent event) -> ModSetup.init());
    }

}
