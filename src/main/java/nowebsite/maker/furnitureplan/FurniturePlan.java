package nowebsite.maker.furnitureplan;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import nowebsite.maker.furnitureplan.datagen.ModDataGenerators;
import nowebsite.maker.furnitureplan.networks.ModMessages;
import nowebsite.maker.furnitureplan.registry.BlockRegistration;
import nowebsite.maker.furnitureplan.registry.EntityRegistration;
import nowebsite.maker.furnitureplan.registry.ItemRegistration;
import nowebsite.maker.furnitureplan.registry.PaintRegistration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(FurniturePlan.MOD_ID)
public class FurniturePlan {
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "furnitureplan";

    public FurniturePlan() {
        LOGGER.info("Furniture plan alpha is on loading!");
        EntityRegistration.init();
        BlockRegistration.init();
        ItemRegistration.init();
        PaintRegistration.init();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(ModDataGenerators::gatherData);

        ModMessages.register();
    }
}
