package nowebsite.maker.furnitureplan.setup;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.RegistryObject;
import nowebsite.maker.furnitureplan.FurniturePlan;
import nowebsite.maker.furnitureplan.blocks.cookingUtensils.blockentities.renderers.IronPotBlockEntityRenderer;
import nowebsite.maker.furnitureplan.blocks.singleblockfurniture.blockentities.renderer.CupboardEntityRenderer;
import nowebsite.maker.furnitureplan.blocks.singleblockfurniture.blockentities.renderer.VaseBBlockEntityRenderer;
import nowebsite.maker.furnitureplan.blocks.tableware.blockentities.renderers.*;
import nowebsite.maker.furnitureplan.registry.BlockRegistration;
import nowebsite.maker.furnitureplan.registry.FoldingRegistration;
import nowebsite.maker.furnitureplan.registry.ItemRegistration;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@EventBusSubscriber(modid = FurniturePlan.MOD_ID, bus = Bus.MOD)
public class SetupWithEvents {
    @SubscribeEvent
    public static void registerCreativeModeTab(CreativeModeTabEvent.@NotNull Register event) {
        event.registerCreativeModeTab(
                new ResourceLocation(FurniturePlan.MOD_ID, "main_tab"),
                (builder) -> builder.displayItems((parameters, output) -> {
                            output.accept(ItemRegistration.GRAVER.get());
                            output.accept(BlockRegistration.FOOD_PLATE_BLOCK_ITEM.get());
                            output.accept(BlockRegistration.GLASS_B_BLOCK_ITEM.get());
                            output.accept(BlockRegistration.CUTLERY_ITEM.get());
                            output.accept(BlockRegistration.LANTERN_ITEM.get());
                            output.accept(BlockRegistration.IRON_POT_BLOCK.get());
                            initKindItem(output, FoldingRegistration.getChairItemLists());
                            initKindItem(output, FoldingRegistration.getTableItemLists());
                            initKindItem(output, FoldingRegistration.getColumnItemLists());
                            initKindItem(output, FoldingRegistration.getCarvedColumnItemLists());
                            initKindItem(output, FoldingRegistration.getLightedColumnItemLists());
                            output.accept(ItemRegistration.DETRITUS.get());
                            output.accept(ItemRegistration.SAWDUST.get());
                            output.accept(BlockRegistration.CUPBOARD_BLOCK_ITEM.get());
                            output.accept(BlockRegistration.VASE_B_BLOCK_ITEM.get());
                        })
                        .title(Component.translatable("itemGroup.furniture"))
                        .icon(() -> new ItemStack(ItemRegistration.TEST_ITEM.get()))
        );
    }

    public static void initKindItem(CreativeModeTab.Output output, @NotNull List<RegistryObject<? extends Item>> list) {
        assert list.size() == 53;
        for (RegistryObject<? extends Item> ro : list) {
            output.accept(ro.get());
        }
    }


    @EventBusSubscriber(modid = FurniturePlan.MOD_ID, value = Dist.CLIENT)
    public static class ClientEvents{
        @EventBusSubscriber(modid = FurniturePlan.MOD_ID, value = Dist.CLIENT, bus = Bus.MOD)
        public static class ClientModBusEvents{
            @SubscribeEvent
            public static void registerEntityRenderers(EntityRenderersEvent.@NotNull RegisterRenderers event){
                event.registerBlockEntityRenderer(BlockRegistration.FOOD_PLATE_BLOCK_ENTITY.get(), pContext -> new FoodPlateBlockEntityRenderer());
                event.registerBlockEntityRenderer(BlockRegistration.GLASS_B_BLOCK_ENTITY.get(), pContext -> new GlassBBlockEntityRenderer());
                event.registerBlockEntityRenderer(BlockRegistration.IRON_POT_BLOCK_ENTITY.get(), pContext -> new IronPotBlockEntityRenderer());
                event.registerBlockEntityRenderer(BlockRegistration.CUPBOARD_BLOCK_ENTITY.get(), CupboardEntityRenderer::new);
                event.registerBlockEntityRenderer(BlockRegistration.VASE_B_BLOCK_ENTITY.get(), pContext -> new VaseBBlockEntityRenderer());
            }
        }
    }
}


