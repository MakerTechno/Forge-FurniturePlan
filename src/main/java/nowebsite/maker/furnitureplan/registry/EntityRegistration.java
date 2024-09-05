package nowebsite.maker.furnitureplan.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import nowebsite.maker.furnitureplan.FurniturePlan;
import nowebsite.maker.furnitureplan.entities.RideableEntityNull;

public class EntityRegistration {
    public static void init() {
    }
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(Registries.ENTITY_TYPE, FurniturePlan.MOD_ID);

    public static final DeferredHolder<EntityType<?>, EntityType<RideableEntityNull>> NULL_RIDE = ENTITIES.register(
        "null_ride",
        ()-> EntityType.Builder.<RideableEntityNull>of(
            RideableEntityNull::new,
            MobCategory.MISC
        ).sized(0,0)
            .clientTrackingRange(10)
            .noSave()
            .build("null_ride")
    );
}
