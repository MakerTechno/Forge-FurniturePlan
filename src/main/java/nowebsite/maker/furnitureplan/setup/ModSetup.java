package nowebsite.maker.furnitureplan.setup;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import nowebsite.maker.furnitureplan.FurniturePlan;

@EventBusSubscriber(modid = FurniturePlan.MOD_ID, bus = Bus.MOD)
public class ModSetup {
    public static void setup() {
        IEventBus bus = MinecraftForge.EVENT_BUS;
    }
}
