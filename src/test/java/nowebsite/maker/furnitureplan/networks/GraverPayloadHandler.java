package nowebsite.maker.furnitureplan.networks;

import net.minecraft.network.chat.Component;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.network.handling.IPayloadHandler;
import nowebsite.maker.furnitureplan.items.Graver;
import org.jetbrains.annotations.NotNull;

public class GraverPayloadHandler implements IPayloadHandler<GraverSyncData> {
    public static void function(@NotNull IPayloadContext context, @NotNull GraverSyncData data){
        if (context.player().getItemInHand(context.player().getUsedItemHand()).getItem() instanceof Graver graver) {
            graver.kind = Graver.GraveKind.values()[data.value()];
        }
    }

    @Override
    public void handle(@NotNull GraverSyncData payload, @NotNull IPayloadContext context) {
        context.enqueueWork(() -> function(context, payload))
                .exceptionally(e -> {
                    // Handle exception
                    context.disconnect(Component.translatable("furnitureplan.networking.failed", e.getMessage()));
                    return null;
                });
    }
}