package nowebsite.maker.furnitureplan.setup;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import nowebsite.maker.furnitureplan.FurniturePlan;
import nowebsite.maker.furnitureplan.networks.*;
import nowebsite.maker.furnitureplan.registry.BlockRegistration;
import nowebsite.maker.furnitureplan.registry.kindsblock.cabinet.*;
import nowebsite.maker.furnitureplan.registry.kindsblock.PotHolderBlockRegistration;
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
        event.registerBlockEntity(
            Capabilities.ItemHandler.BLOCK,
            PotHolderBlockRegistration.POT_HOLDER_BLOCK_ENTITY.get(),
            (blockEntity, direction) -> blockEntity.getLazyItemHandler().get()
        );
        event.registerBlockEntity(
            Capabilities.ItemHandler.BLOCK,
            CabinetBlockRegistration.CABINET_BLOCK_ENTITY.get(),
            (blockEntity, direction) -> blockEntity.createHandler().get()
        );



        event.registerBlockEntity(
            Capabilities.ItemHandler.BLOCK,
            BlackCabinetRegistration.BLACK_CABINET_BLOCK_ENTITY.get(),
            (blockEntity, direction) -> blockEntity.createHandler().get()
        );
        event.registerBlockEntity(
            Capabilities.ItemHandler.BLOCK,
            BlueCabinetRegistration.BLUE_CABINET_BLOCK_ENTITY.get(),
            (blockEntity, direction) -> blockEntity.createHandler().get()
        );
        event.registerBlockEntity(
            Capabilities.ItemHandler.BLOCK,
            BrownCabinetRegistration.BROWN_CABINET_BLOCK_ENTITY.get(),
            (blockEntity, direction) -> blockEntity.createHandler().get()
        );
        event.registerBlockEntity(
            Capabilities.ItemHandler.BLOCK,
            CyanCabinetRegistration.CYAN_CABINET_BLOCK_ENTITY.get(),
            (blockEntity, direction) -> blockEntity.createHandler().get()
        );
        event.registerBlockEntity(
            Capabilities.ItemHandler.BLOCK,
            GrayCabinetRegistration.GRAY_CABINET_BLOCK_ENTITY.get(),
            (blockEntity, direction) -> blockEntity.createHandler().get()
        );
        event.registerBlockEntity(
            Capabilities.ItemHandler.BLOCK,
            GreenCabinetRegistration.GREEN_CABINET_BLOCK_ENTITY.get(),
            (blockEntity, direction) -> blockEntity.createHandler().get()
        );
        event.registerBlockEntity(
            Capabilities.ItemHandler.BLOCK,
            LightBlueCabinetRegistration.LIGHT_BLUE_CABINET_BLOCK_ENTITY.get(),
            (blockEntity, direction) -> blockEntity.createHandler().get()
        );
        event.registerBlockEntity(
            Capabilities.ItemHandler.BLOCK,
            LightGrayCabinetRegistration.LIGHT_GRAY_CABINET_BLOCK_ENTITY.get(),
            (blockEntity, direction) -> blockEntity.createHandler().get()
        );
        event.registerBlockEntity(
            Capabilities.ItemHandler.BLOCK,
            LimeCabinetRegistration.LIME_CABINET_BLOCK_ENTITY.get(),
            (blockEntity, direction) -> blockEntity.createHandler().get()
        );
        event.registerBlockEntity(
            Capabilities.ItemHandler.BLOCK,
            MagentaCabinetRegistration.MAGENTA_CABINET_BLOCK_ENTITY.get(),
            (blockEntity, direction) -> blockEntity.createHandler().get()
        );
        event.registerBlockEntity(
            Capabilities.ItemHandler.BLOCK,
            OrangeCabinetRegistration.ORANGE_CABINET_BLOCK_ENTITY.get(),
            (blockEntity, direction) -> blockEntity.createHandler().get()
        );
        event.registerBlockEntity(
            Capabilities.ItemHandler.BLOCK,
            PinkCabinetRegistration.PINK_CABINET_BLOCK_ENTITY.get(),
            (blockEntity, direction) -> blockEntity.createHandler().get()
        );
        event.registerBlockEntity(
            Capabilities.ItemHandler.BLOCK,
            PurpleCabinetRegistration.PURPLE_CABINET_BLOCK_ENTITY.get(),
            (blockEntity, direction) -> blockEntity.createHandler().get()
        );
        event.registerBlockEntity(
            Capabilities.ItemHandler.BLOCK,
            RedCabinetRegistration.RED_CABINET_BLOCK_ENTITY.get(),
            (blockEntity, direction) -> blockEntity.createHandler().get()
        );
        event.registerBlockEntity(
            Capabilities.ItemHandler.BLOCK,
            YellowCabinetRegistration.YELLOW_CABINET_BLOCK_ENTITY.get(),
            (blockEntity, direction) -> blockEntity.createHandler().get()
        );
        event.registerBlockEntity(
            Capabilities.ItemHandler.BLOCK,
            WhiteCabinetRegistration.WHITE_CABINET_BLOCK_ENTITY.get(),
            (blockEntity, direction) -> blockEntity.createHandler().get()
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
