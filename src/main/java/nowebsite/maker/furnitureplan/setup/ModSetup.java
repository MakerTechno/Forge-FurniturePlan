package nowebsite.maker.furnitureplan.setup;

import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import nowebsite.maker.furnitureplan.FurniturePlan;
import nowebsite.maker.furnitureplan.networks.ModMessages;

@EventBusSubscriber(modid = FurniturePlan.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ModSetup {
    public static void init() {
        ModMessages.register();
    }
}
