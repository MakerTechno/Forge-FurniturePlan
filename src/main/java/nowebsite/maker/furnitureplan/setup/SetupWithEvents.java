package nowebsite.maker.furnitureplan.setup;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.RegistryObject;
import nowebsite.maker.furnitureplan.FurniturePlan;
import nowebsite.maker.furnitureplan.blocks.blockentities.FoodPlateBlockEntity;
import nowebsite.maker.furnitureplan.blocks.blockentities.renderers.FoodPlateBlockEntityRenderer;
import nowebsite.maker.furnitureplan.networks.ModMessages;
import nowebsite.maker.furnitureplan.networks.packets.ItemStackSyncS2CPacket;
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
                            initKindsItem(output, FoldingRegistration.getChairItemLists());
                            initKindsItem(output, FoldingRegistration.getTableItemLists());
                            initKindsItem(output, FoldingRegistration.getColumnItemLists());
                            initKindsItem(output, FoldingRegistration.getCarvedColumnItemLists());
                            initKindsItem(output, FoldingRegistration.getLightedColumnItemLists());
                            output.accept(ItemRegistration.DETRITUS.get());
                            output.accept(ItemRegistration.SAWDUST.get());
                            output.accept(ItemRegistration.GRAVER.get());
                            output.accept(BlockRegistration.FOOD_PLATE_BLOCK_ITEM.get());
                        })
                        .title(Component.translatable("itemGroup.furniture"))
                        .icon(() -> new ItemStack(ItemRegistration.TEST_ITEM.get()))
        );
    }

    public static void initKindsItem(CreativeModeTab.Output output, @NotNull List<RegistryObject<? extends Item>> list) {
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
            }
        }
    }

    public static void playerLoggedInEvent(PlayerEvent.PlayerLoggedInEvent event){
        Level level = event.getEntity().level;
        if (level.isClientSide){
            event.getEntity().refreshDimensions();
        }
    }
}


