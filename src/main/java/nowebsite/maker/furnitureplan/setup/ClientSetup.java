package nowebsite.maker.furnitureplan.setup;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import nowebsite.maker.furnitureplan.FurniturePlan;
import nowebsite.maker.furnitureplan.blocks.singleblockfurniture.blockentities.renderer.CupboardEntityRenderer;
import nowebsite.maker.furnitureplan.blocks.singleblockfurniture.gui.CupboardScreen;
import nowebsite.maker.furnitureplan.registry.GUIRegistration;
import org.jetbrains.annotations.NotNull;

@EventBusSubscriber(modid = FurniturePlan.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientSetup {
    //public static final BlockEntityWithoutLevelRenderer MOD_ITEM_WITH_BE =
    public static void init(@NotNull FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            MenuScreens.register(GUIRegistration.DRAWER_MENU1.get(), CupboardScreen::new);
            MenuScreens.register(GUIRegistration.DRAWER_MENU2.get(), CupboardScreen::new);
        });
    }
    public static final ModelLayerLocation CUPBOARD = new ModelLayerLocation(new ResourceLocation(FurniturePlan.MOD_ID, "cupboard"), "main");

    @SubscribeEvent
    public static void layerDefinitions(EntityRenderersEvent.@NotNull RegisterLayerDefinitions event) {
        event.registerLayerDefinition(CUPBOARD, CupboardEntityRenderer::createSingleBodyLayer);
    }
}
