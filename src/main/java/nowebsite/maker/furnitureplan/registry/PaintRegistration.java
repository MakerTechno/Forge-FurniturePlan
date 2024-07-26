package nowebsite.maker.furnitureplan.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.registries.DeferredRegister;
import nowebsite.maker.furnitureplan.FurniturePlan;

public class PaintRegistration {
    public static void init() {
        IEventBus bus = NeoForge.EVENT_BUS;
        PAINTINGS.register(bus);
    }

    public static final DeferredRegister<PaintingVariant> PAINTINGS = DeferredRegister.create(Registries.PAINTING_VARIANT, FurniturePlan.MOD_ID);

}
