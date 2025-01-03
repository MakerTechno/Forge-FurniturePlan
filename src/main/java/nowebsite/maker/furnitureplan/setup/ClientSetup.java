package nowebsite.maker.furnitureplan.setup;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import nowebsite.maker.furnitureplan.FurniturePlan;
import nowebsite.maker.furnitureplan.blocks.singleblockfurniture.blockentities.renderer.CupboardEntityRenderer;
import org.jetbrains.annotations.NotNull;

@EventBusSubscriber(modid = FurniturePlan.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSetup {
    public static final ModelLayerLocation CUPBOARD = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(FurniturePlan.MOD_ID, "cupboard"), "main");

    @SubscribeEvent
    public static void layerDefinitions(EntityRenderersEvent.@NotNull RegisterLayerDefinitions event) {
        event.registerLayerDefinition(CUPBOARD, CupboardEntityRenderer::createSingleBodyLayer);
    }
}
