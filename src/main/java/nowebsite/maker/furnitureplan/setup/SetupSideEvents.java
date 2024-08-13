package nowebsite.maker.furnitureplan.setup;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import nowebsite.maker.furnitureplan.FurniturePlan;
import nowebsite.maker.furnitureplan.networks.CupboardPayloadHandler;
import nowebsite.maker.furnitureplan.networks.CupboardSyncData;
import nowebsite.maker.furnitureplan.networks.GraverPayloadHandler;
import nowebsite.maker.furnitureplan.networks.GraverSyncData;
import nowebsite.maker.furnitureplan.registry.BlockRegistration;
import org.jetbrains.annotations.NotNull;

@EventBusSubscriber(modid = FurniturePlan.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class SetupSideEvents {
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
    public static void registerPayloads(final @NotNull RegisterPayloadHandlersEvent event) {
        final PayloadRegistrar registrar = event.registrar("1");
        registrar.playToClient(
            CupboardSyncData.TYPE,
            CupboardSyncData.STREAM_CODEC,
            new CupboardPayloadHandler()
        );
        registrar.playToClient(
            GraverSyncData.TYPE,
            GraverSyncData.STREAM_CODEC,
            new GraverPayloadHandler()
        );
    }
}
