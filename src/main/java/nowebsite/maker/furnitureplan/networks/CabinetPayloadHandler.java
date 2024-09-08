package nowebsite.maker.furnitureplan.networks;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.network.handling.IPayloadHandler;
import nowebsite.maker.furnitureplan.blocks.singleblockfurniture.blockentities.CabinetBlockEntity;
import org.jetbrains.annotations.NotNull;

public class CabinetPayloadHandler implements IPayloadHandler<CabinetSyncData> {
    public static void function(@NotNull IPayloadContext context, @NotNull CabinetSyncData data){
        BlockPos pos = BlockPos.containing(data.pos().x, data.pos().y, data.pos().z);
        if (context.player().level().getBlockEntity(pos) instanceof CabinetBlockEntity cast) {
            cast.shouldBeOpen(data.open());
        }
    }

    @Override
    public void handle(@NotNull CabinetSyncData payload, @NotNull IPayloadContext context) {
        context.enqueueWork(() -> function(context, payload))
                .exceptionally(e -> {
                    // Handle exception
                    context.disconnect(Component.translatable("furnitureplan.networking.failed", e.getMessage()));
                    return null;
                });
    }
}