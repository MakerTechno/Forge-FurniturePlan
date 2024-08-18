package nowebsite.maker.furnitureplan.setup;

import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import nowebsite.maker.furnitureplan.FurniturePlan;
import nowebsite.maker.furnitureplan.networks.ModMessages;

@EventBusSubscriber(modid = FurniturePlan.MOD_ID, bus = Bus.MOD)
public class ModSetup {
    @SuppressWarnings("unused")
    public static void init(FMLCommonSetupEvent event) {
        ModMessages.register();
    }
}
