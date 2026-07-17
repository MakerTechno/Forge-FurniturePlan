package nowebsite.maker.furnitureplan.networks;

import net.minecraft.network.chat.Component;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.network.handling.IPayloadHandler;
import nowebsite.maker.furnitureplan.common.block.abstraction.set.FPBlockType;
import nowebsite.maker.furnitureplan.common.item.GraverItem;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;

public class GraverPayloadHandler implements IPayloadHandler<@NotNull GraverSyncData> {
    public static void function(@NotNull IPayloadContext context, @NotNull GraverSyncData data){
        if (context.player().getItemInHand(context.player().getUsedItemHand()).getItem() instanceof GraverItem graver) {
            graver.targetType = GraverItem.VALUES.stream().filter(type -> type.name().equals(data.value())).findFirst().orElse(FPBlockType.CHAIR);
            context.player().sendOverlayMessage(
                Component.translatable("tip.furnitureplan.graver.kind_change")
                    .append(Component.translatable("tip.furnitureplan.graver.kind." + graver.targetType.name().toLowerCase(Locale.ROOT)))
            );
        }
    }

    @Override
    @SuppressWarnings("all")
    public void handle(@NotNull GraverSyncData payload, @NotNull IPayloadContext context) {
        context.enqueueWork(() -> function(context, payload))
                .exceptionally(e -> {
                    // Handle exception
                    context.disconnect(Component.translatable("furnitureplan.networking.failed", e.getMessage()));
                    return null;
                });
    }
}