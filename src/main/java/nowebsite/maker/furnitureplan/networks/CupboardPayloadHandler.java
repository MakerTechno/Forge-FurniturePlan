package nowebsite.maker.furnitureplan.networks;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.network.handling.IPayloadHandler;
import nowebsite.maker.furnitureplan.blocks.singleblockfurniture.blockentities.CupboardBlockEntity;
import org.jetbrains.annotations.NotNull;

public class CupboardPayloadHandler implements IPayloadHandler<CupboardSyncData> {
    public static void function(@NotNull IPayloadContext context, @NotNull CupboardSyncData data){
        BlockPos pos = BlockPos.containing(data.pos().x, data.pos().y, data.pos().z);
        if (context.player().level().getBlockEntity(pos) instanceof CupboardBlockEntity cast) {
            cast.drawer1ShouldBeOpen(data.d1());
            cast.drawer2ShouldBeOpen(data.d2());
            cast.drawer3ShouldBeOpen(data.d3());
        }
    }

    @Override
    public void handle(@NotNull CupboardSyncData payload, @NotNull IPayloadContext context) {
        context.enqueueWork(() -> function(context, payload))
                .exceptionally(e -> {
                    // Handle exception
                    context.disconnect(Component.translatable("furnitureplan.networking.failed", e.getMessage()));
                    return null;
                });
    }
}