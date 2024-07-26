package nowebsite.maker.furnitureplan.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.registries.DeferredRegister;
import nowebsite.maker.furnitureplan.FurniturePlan;

public class EntityRegistration {
    public static void init() {
        IEventBus bus = NeoForge.EVENT_BUS;
        ENTITY_TYPES.register(bus);
    }
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(Registries.ENTITY_TYPE, FurniturePlan.MOD_ID);
}
