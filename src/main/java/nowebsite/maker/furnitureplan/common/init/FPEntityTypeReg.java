package nowebsite.maker.furnitureplan.common.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import nowebsite.maker.furnitureplan.FurniturePlan;
import nowebsite.maker.furnitureplan.common.entity.RideableEntityNull;
import org.jetbrains.annotations.NotNull;

public class FPEntityTypeReg {
    public static void touch() {

    }
    public static final DeferredRegister.Entities ENTITIES = DeferredRegister.createEntities(FurniturePlan.MOD_ID);

    public static final DeferredHolder<EntityType<?>, @NotNull EntityType<@NotNull RideableEntityNull>> NULL_RIDE = ENTITIES.register(
        "null_ride",
        ()-> EntityType.Builder.<RideableEntityNull>of(
                RideableEntityNull::new,
                MobCategory.MISC
            ).sized(0,0)
            .clientTrackingRange(10)
            .build(entityId("null_ride"))
    );

    @SuppressWarnings("SameParameterValue")
    private static ResourceKey<EntityType<?>> entityId(String id) {
        return ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(FurniturePlan.MOD_ID, id));
    }
}
