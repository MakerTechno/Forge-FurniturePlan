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
import nowebsite.maker.furnitureplan.networks.CupboardPayloadHandler;
import nowebsite.maker.furnitureplan.networks.CupboardSyncData;
import nowebsite.maker.furnitureplan.networks.PotHolderPayloadHandler;
import nowebsite.maker.furnitureplan.networks.PotHolderSyncData;
import org.jetbrains.annotations.NotNull;

@EventBusSubscriber(modid = FurniturePlan.MOD_ID)
public class CommonEvents {
    @SubscribeEvent
    public static void registerCapabilities(@NotNull RegisterCapabilitiesEvent event) {
        /*event.registerBlockEntity(
            Capabilities.Item.BLOCK,
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
            BlockRegistration.CUPBOARD_BLOCK_ENTITY.get(),
            (blockEntity, direction) -> blockEntity.createHandler().get()
        );
        event.registerBlockEntity(
            Capabilities.ItemHandler.BLOCK,
            BlockRegistration.VASE_B_BLOCK_ENTITY.get(),
            (blockEntity, direction) -> blockEntity.getLazyItemHandler().get()
        );
        event.registerBlockEntity(
            Capabilities.Item.BLOCK,
            PotHolderBlockRegistration.POT_HOLDER_BLOCK_ENTITY.get(),
            (blockEntity, direction) -> blockEntity.getLazyItemHandler().get()
        );
        event.registerBlockEntity(
            Capabilities.ItemHandler.BLOCK,
            CabinetBlockRegistration.CABINET_BLOCK_ENTITY.get(),
            (blockEntity, direction) -> blockEntity.createHandler().get()
        );*/


        event.registerBlockEntity(
            Capabilities.Item.BLOCK,
            FPBlockReg.IRON_POT_BE.get(),
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
            ((be, context) -> new CombinedResourceHandler<>(
                VanillaContainerWrapper.of(be.drawer1),
                VanillaContainerWrapper.of(be.drawer2),
                VanillaContainerWrapper.of(be.drawer3)
            ))
        );

        /*event.registerBlockEntity(
            Capabilities.ItemHandler.BLOCK,
            BlackCabinetRegistration.BLACK_CABINET_BLOCK_ENTITY.get(),
            (blockEntity, direction) -> blockEntity.createHandler().get()
        );*/
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
        /*registrar.playToClient(
            CabinetSyncData.TYPE,
            CabinetSyncData.STREAM_CODEC,
            new CabinetPayloadHandler()
        );*/
    }
}
