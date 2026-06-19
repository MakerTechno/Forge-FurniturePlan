package nowebsite.maker.furnitureplan.common.event;

import net.minecraft.client.renderer.entity.NoopRenderer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import nowebsite.maker.furnitureplan.FurniturePlan;
import nowebsite.maker.furnitureplan.common.block.cooking.utensils.entities.renderers.IronPotBlockEntityRenderer;
import nowebsite.maker.furnitureplan.common.init.FPBlockReg;
import nowebsite.maker.furnitureplan.common.init.FPEntityTypeReg;
import org.jetbrains.annotations.NotNull;

@EventBusSubscriber(modid = FurniturePlan.MOD_ID, value = Dist.CLIENT)
public class ClientEvents {
    @SubscribeEvent
    public static void registerScreens(@NotNull RegisterMenuScreensEvent event) {
    }

    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.@NotNull RegisterRenderers event) {
        event.registerBlockEntityRenderer(FPBlockReg.IRON_POT_BE.get(), IronPotBlockEntityRenderer::new);
        event.registerEntityRenderer(FPEntityTypeReg.NULL_RIDE.get(), NoopRenderer::new);
    }

}
