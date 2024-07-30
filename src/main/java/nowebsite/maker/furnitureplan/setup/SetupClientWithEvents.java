package nowebsite.maker.furnitureplan.setup;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import nowebsite.maker.furnitureplan.FurniturePlan;
import nowebsite.maker.furnitureplan.blocks.cookingUtensils.blockentities.renderers.IronPotBlockEntityRenderer;
import nowebsite.maker.furnitureplan.blocks.singleblockfurniture.blockentities.renderer.CupboardEntityRenderer;
import nowebsite.maker.furnitureplan.blocks.singleblockfurniture.blockentities.renderer.VaseBBlockEntityRenderer;
import nowebsite.maker.furnitureplan.blocks.singleblockfurniture.gui.CupboardScreen;
import nowebsite.maker.furnitureplan.blocks.tableware.blockentities.renderers.FoodPlateBlockEntityRenderer;
import nowebsite.maker.furnitureplan.blocks.tableware.blockentities.renderers.GlassBBlockEntityRenderer;
import nowebsite.maker.furnitureplan.networks.CupboardPayloadHandler;
import nowebsite.maker.furnitureplan.networks.CupboardSyncData;
import nowebsite.maker.furnitureplan.registry.BlockRegistration;
import nowebsite.maker.furnitureplan.registry.GUIRegistration;
import org.jetbrains.annotations.NotNull;

/*
 *
 *     DELETED STH.
 *
 */
@EventBusSubscriber(modid = FurniturePlan.MOD_ID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class SetupClientWithEvents {
    @SubscribeEvent
    public static void registerScreens(@NotNull RegisterMenuScreensEvent event) {
        event.register(GUIRegistration.DRAWER_MENU1.get(), CupboardScreen::new);
        event.register(GUIRegistration.DRAWER_MENU2.get(), CupboardScreen::new);
    }

    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.@NotNull RegisterRenderers event) {
        event.registerBlockEntityRenderer(BlockRegistration.FOOD_PLATE_BLOCK_ENTITY.get(), pContext -> new FoodPlateBlockEntityRenderer());
        event.registerBlockEntityRenderer(BlockRegistration.GLASS_B_BLOCK_ENTITY.get(), pContext -> new GlassBBlockEntityRenderer());
        event.registerBlockEntityRenderer(BlockRegistration.IRON_POT_BLOCK_ENTITY.get(), pContext -> new IronPotBlockEntityRenderer());
        event.registerBlockEntityRenderer(BlockRegistration.CUPBOARD_BLOCK_ENTITY.get(), CupboardEntityRenderer::new);
        event.registerBlockEntityRenderer(BlockRegistration.VASE_B_BLOCK_ENTITY.get(), pContext -> new VaseBBlockEntityRenderer());
    }

    @SubscribeEvent
    public static void registerCapabilities(@NotNull RegisterCapabilitiesEvent event) {
        event.registerBlockEntity(
                Capabilities.ItemHandler.BLOCK,
                BlockRegistration.FOOD_PLATE_BLOCK_ENTITY.get(),
                (blockEntity, direction) -> blockEntity.getLazyItemHandler().get()
        );
        event.registerBlockEntity(
                Capabilities.ItemHandler.BLOCK,
                BlockRegistration.GLASS_B_BLOCK_ENTITY.get(),
                (blockEntity, direction) -> blockEntity.getLazyItemHandler().get()
        );
        event.registerBlockEntity(
                Capabilities.ItemHandler.BLOCK,
                BlockRegistration.IRON_POT_BLOCK_ENTITY.get(),
                (blockEntity, direction) -> blockEntity.getLazyItemHandler().get()
        );
        event.registerBlockEntity(
                Capabilities.ItemHandler.BLOCK,
                BlockRegistration.CUPBOARD_BLOCK_ENTITY.get(),
                (blockEntity, direction) -> blockEntity.createHandler().get()
        );
        event.registerBlockEntity(
                Capabilities.ItemHandler.BLOCK,
                BlockRegistration.VASE_B_BLOCK_ENTITY.get(),
                (blockEntity, direction) -> blockEntity.getLazyItemHandler().get()
        );
    }
    @SubscribeEvent
    public static void registerPayloads(final RegisterPayloadHandlersEvent event) {
        final PayloadRegistrar registrar = event.registrar("1");
        registrar.commonToClient(
                CupboardSyncData.TYPE,
                CupboardSyncData.STREAM_CODEC,
                new CupboardPayloadHandler()
        );
    }
}
