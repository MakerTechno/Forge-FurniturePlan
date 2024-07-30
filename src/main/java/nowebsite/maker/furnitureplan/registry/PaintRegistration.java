package nowebsite.maker.furnitureplan.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.neoforged.neoforge.registries.DeferredRegister;
import nowebsite.maker.furnitureplan.FurniturePlan;

public class PaintRegistration {
    public static void init() {
    }

    public static final DeferredRegister<PaintingVariant> PAINTINGS = DeferredRegister.create(Registries.PAINTING_VARIANT, FurniturePlan.MOD_ID);

}
