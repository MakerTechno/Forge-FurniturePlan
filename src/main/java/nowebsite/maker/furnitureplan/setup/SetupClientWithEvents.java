package nowebsite.maker.furnitureplan.setup;

import net.minecraft.client.renderer.entity.NoopRenderer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import nowebsite.maker.furnitureplan.FurniturePlan;
import nowebsite.maker.furnitureplan.blocks.cookingUtensils.blockentities.renderers.IronPotBlockEntityRenderer;
import nowebsite.maker.furnitureplan.blocks.singleblockfurniture.blockentities.renderer.CabinetEntityRenderer;
import nowebsite.maker.furnitureplan.blocks.singleblockfurniture.blockentities.renderer.CupboardEntityRenderer;
import nowebsite.maker.furnitureplan.blocks.multiaffected.blockentities.renderer.PotHolderBlockEntityRenderer;
import nowebsite.maker.furnitureplan.blocks.singleblockfurniture.blockentities.renderer.VaseBBlockEntityRenderer;
import nowebsite.maker.furnitureplan.blocks.singleblockfurniture.gui.CupboardScreen;
import nowebsite.maker.furnitureplan.blocks.tableware.blockentities.renderers.FoodPlateBlockEntityRenderer;
import nowebsite.maker.furnitureplan.blocks.tableware.blockentities.renderers.GlassBBlockEntityRenderer;
import nowebsite.maker.furnitureplan.registry.BlockRegistration;
import nowebsite.maker.furnitureplan.registry.EntityRegistration;
import nowebsite.maker.furnitureplan.registry.GUIRegistration;
import nowebsite.maker.furnitureplan.registry.kindsblock.cabinet.*;
import nowebsite.maker.furnitureplan.registry.kindsblock.PotHolderBlockRegistration;
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
        event.registerBlockEntityRenderer(PotHolderBlockRegistration.POT_HOLDER_BLOCK_ENTITY.get(), context -> new PotHolderBlockEntityRenderer());
        event.registerBlockEntityRenderer(CabinetBlockRegistration.CABINET_BLOCK_ENTITY.get(), context -> new CabinetEntityRenderer());

        event.registerEntityRenderer(EntityRegistration.NULL_RIDE.get(), NoopRenderer::new);


        event.registerBlockEntityRenderer(BlackCabinetRegistration.BLACK_CABINET_BLOCK_ENTITY.get(), context -> new CabinetEntityRenderer());
        event.registerBlockEntityRenderer(BlueCabinetRegistration.BLUE_CABINET_BLOCK_ENTITY.get(), context -> new CabinetEntityRenderer());
        event.registerBlockEntityRenderer(BrownCabinetRegistration.BROWN_CABINET_BLOCK_ENTITY.get(), context -> new CabinetEntityRenderer());
        event.registerBlockEntityRenderer(CyanCabinetRegistration.CYAN_CABINET_BLOCK_ENTITY.get(), context -> new CabinetEntityRenderer());
        event.registerBlockEntityRenderer(GrayCabinetRegistration.GRAY_CABINET_BLOCK_ENTITY.get(), context -> new CabinetEntityRenderer());
        event.registerBlockEntityRenderer(GreenCabinetRegistration.GREEN_CABINET_BLOCK_ENTITY.get(), context -> new CabinetEntityRenderer());
        event.registerBlockEntityRenderer(LightBlueCabinetRegistration.LIGHT_BLUE_CABINET_BLOCK_ENTITY.get(), context -> new CabinetEntityRenderer());
        event.registerBlockEntityRenderer(LightGrayCabinetRegistration.LIGHT_GRAY_CABINET_BLOCK_ENTITY.get(), context -> new CabinetEntityRenderer());
        event.registerBlockEntityRenderer(LimeCabinetRegistration.LIME_CABINET_BLOCK_ENTITY.get(), context -> new CabinetEntityRenderer());
        event.registerBlockEntityRenderer(MagentaCabinetRegistration.MAGENTA_CABINET_BLOCK_ENTITY.get(), context -> new CabinetEntityRenderer());
        event.registerBlockEntityRenderer(OrangeCabinetRegistration.ORANGE_CABINET_BLOCK_ENTITY.get(), context -> new CabinetEntityRenderer());
        event.registerBlockEntityRenderer(PinkCabinetRegistration.PINK_CABINET_BLOCK_ENTITY.get(), context -> new CabinetEntityRenderer());
        event.registerBlockEntityRenderer(PurpleCabinetRegistration.PURPLE_CABINET_BLOCK_ENTITY.get(), context -> new CabinetEntityRenderer());
        event.registerBlockEntityRenderer(RedCabinetRegistration.RED_CABINET_BLOCK_ENTITY.get(), context -> new CabinetEntityRenderer());
        event.registerBlockEntityRenderer(YellowCabinetRegistration.YELLOW_CABINET_BLOCK_ENTITY.get(), context -> new CabinetEntityRenderer());
        event.registerBlockEntityRenderer(WhiteCabinetRegistration.WHITE_CABINET_BLOCK_ENTITY.get(), context -> new CabinetEntityRenderer());
    }

}
