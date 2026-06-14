package nowebsite.maker.furnitureplan.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import nowebsite.maker.furnitureplan.FurniturePlan;
import nowebsite.maker.furnitureplan.entities.RideableEntityNull;
import org.jetbrains.annotations.NotNull;

public class EntityRegistration {
    public static void init() {
    }
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(Registries.ENTITY_TYPE, FurniturePlan.MOD_ID);

    public static final DeferredHolder<EntityType<?>, @NotNull EntityType<@NotNull RideableEntityNull>> NULL_RIDE = ENTITIES.register(
        "null_ride",
        ()-> EntityType.Builder.<RideableEntityNull>of(
            RideableEntityNull::new,
            MobCategory.MISC
        ).sized(0,0)
            .clientTrackingRange(10)
            .noSave()
            .build(entityId("null_ride"))
    );

    @SuppressWarnings("SameParameterValue")
    private static ResourceKey<EntityType<?>> entityId(String id) {
        return ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(FurniturePlan.MOD_ID, id));
    }
}
