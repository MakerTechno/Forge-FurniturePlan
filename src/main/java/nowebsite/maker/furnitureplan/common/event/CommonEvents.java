package nowebsite.maker.furnitureplan.common.event;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import net.neoforged.neoforge.transfer.CombinedResourceHandler;
import net.neoforged.neoforge.transfer.item.VanillaContainerWrapper;
import nowebsite.maker.furnitureplan.FurniturePlan;
import nowebsite.maker.furnitureplan.common.init.FPBlockReg;
import nowebsite.maker.furnitureplan.networks.*;
import org.jetbrains.annotations.NotNull;

@EventBusSubscriber(modid = FurniturePlan.MOD_ID)
public class CommonEvents {
    @SubscribeEvent
    public static void registerCapabilities(@NotNull RegisterCapabilitiesEvent event) {
        event.registerBlockEntity(
            Capabilities.Item.BLOCK,
            FPBlockReg.IRON_POT_BE.get(),
            (be, _) -> VanillaContainerWrapper.of(be)
        );
        event.registerBlockEntity(
            Capabilities.Item.BLOCK,
            FPBlockReg.FOOD_PLATE_BLOCK_ENTITY.get(),
            (be, _) -> VanillaContainerWrapper.of(be)
        );
        event.registerBlockEntity(
            Capabilities.Item.BLOCK,
            FPBlockReg.POT_HOLDER_BLOCK_ENTITY.get(),
            (be, _) -> VanillaContainerWrapper.of(be)
        );

        event.registerBlockEntity(
            Capabilities.Item.BLOCK,
            FPBlockReg.CUPBOARD_BLOCK_ENTITY.get(),
            (be, _) -> new CombinedResourceHandler<>(
                VanillaContainerWrapper.of(be.drawer1),
                VanillaContainerWrapper.of(be.drawer2),
                VanillaContainerWrapper.of(be.drawer3)
            )
        );

        event.registerBlockEntity(
            Capabilities.Item.BLOCK,
            FPBlockReg.CABINET_BLOCK_ENTITY.get(),
            (be, _) -> VanillaContainerWrapper.of(be.container)
        );

        event.registerBlockEntity(
            Capabilities.Item.BLOCK,
            FPBlockReg.MOON_SHELF_BLOCK_ENTITY.get(),
            (be, _) -> VanillaContainerWrapper.of(be)
        );
        event.registerBlockEntity(
            Capabilities.Item.BLOCK,
            FPBlockReg.WALL_SHELF_BLOCK_ENTITY.get(),
            (be, _) -> VanillaContainerWrapper.of(be)
        );
    }
    @SubscribeEvent
    public static void registerPayloads(final @NotNull RegisterPayloadHandlersEvent event) {
        final PayloadRegistrar registrar = event.registrar("1");
        /*
        registrar.playToClient(
            GraverSyncData.TYPE,
            GraverSyncData.STREAM_CODEC,
            new GraverPayloadHandler()
        );*/
        registrar.playToClient(
            CupboardSyncData.TYPE,
            CupboardSyncData.STREAM_CODEC,
            new CupboardPayloadHandler()
        );
        registrar.playToClient(
            PotHolderSyncData.TYPE,
            PotHolderSyncData.STREAM_CODEC,
            new PotHolderPayloadHandler()
        );
        registrar.playToClient(
            CabinetSyncData.TYPE,
            CabinetSyncData.STREAM_CODEC,
            new CabinetPayloadHandler()
        );
    }
}
