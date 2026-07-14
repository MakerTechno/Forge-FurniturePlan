package nowebsite.maker.furnitureplan.common.event;

import net.minecraft.client.renderer.entity.NoopRenderer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import nowebsite.maker.furnitureplan.FurniturePlan;
import nowebsite.maker.furnitureplan.common.block.cooking.utensils.entities.renderer.FoodPlateBlockEntityRenderer;
import nowebsite.maker.furnitureplan.common.block.cooking.utensils.entities.renderer.GlassBBlockEntityRenderer;
import nowebsite.maker.furnitureplan.common.block.cooking.utensils.entities.renderer.IronPotBlockEntityRenderer;
import nowebsite.maker.furnitureplan.common.block.storaging.entity.renderer.CabinetEntityRenderer;
import nowebsite.maker.furnitureplan.common.block.storaging.entity.renderer.CupboardEntityRenderer;
import nowebsite.maker.furnitureplan.common.block.storaging.gui.CupboardScreen;
import nowebsite.maker.furnitureplan.common.block.surfacing.entity.renderer.MoonShelfBlockEntityRenderer;
import nowebsite.maker.furnitureplan.common.block.surfacing.entity.renderer.PotHolderBlockEntityRenderer;
import nowebsite.maker.furnitureplan.common.init.FPBlockReg;
import nowebsite.maker.furnitureplan.common.init.FPEntityTypeReg;
import nowebsite.maker.furnitureplan.common.init.FPMenuRegistration;
import org.jetbrains.annotations.NotNull;

@EventBusSubscriber(modid = FurniturePlan.MOD_ID, value = Dist.CLIENT)
public class ClientEvents {
    @SubscribeEvent
    public static void registerScreens(@NotNull RegisterMenuScreensEvent event) {
        event.register(FPMenuRegistration.DRAWER_MENU1.get(), CupboardScreen::new);
        event.register(FPMenuRegistration.DRAWER_MENU2.get(), CupboardScreen::new);
    }

    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.@NotNull RegisterRenderers event) {
        event.registerBlockEntityRenderer(FPBlockReg.IRON_POT_BE.get(), IronPotBlockEntityRenderer::new);
        event.registerBlockEntityRenderer(FPBlockReg.POT_HOLDER_BLOCK_ENTITY.get(), PotHolderBlockEntityRenderer::new);
        event.registerBlockEntityRenderer(FPBlockReg.CUPBOARD_BLOCK_ENTITY.get(), CupboardEntityRenderer::new);
        event.registerBlockEntityRenderer(FPBlockReg.FOOD_PLATE_BLOCK_ENTITY.get(), FoodPlateBlockEntityRenderer::new);
        event.registerBlockEntityRenderer(FPBlockReg.GLASS_B_BLOCK_ENTITY.get(), GlassBBlockEntityRenderer::new);
        event.registerBlockEntityRenderer(FPBlockReg.CABINET_BLOCK_ENTITY.get(), CabinetEntityRenderer::new);
        event.registerBlockEntityRenderer(FPBlockReg.MOON_SHELF_BLOCK_ENTITY.get(), MoonShelfBlockEntityRenderer::new);
        event.registerEntityRenderer(FPEntityTypeReg.NULL_RIDE.get(), NoopRenderer::new);
    }

}
