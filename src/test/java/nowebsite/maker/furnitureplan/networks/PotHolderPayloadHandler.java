package nowebsite.maker.furnitureplan.networks;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.network.handling.IPayloadHandler;
import nowebsite.maker.furnitureplan.blocks.multiaffected.blockentities.PotHolderBlockEntity;
import org.jetbrains.annotations.NotNull;

public class PotHolderPayloadHandler implements IPayloadHandler<PotHolderSyncData> {
    public static void function(@NotNull IPayloadContext context, @NotNull PotHolderSyncData data){
        BlockPos pos = BlockPos.containing(data.pos().x, data.pos().y, data.pos().z);
        if (context.player().level().getBlockEntity(pos) instanceof PotHolderBlockEntity cast) {
            cast.setStateAt(0, data.state1());
            cast.setStateAt(1, data.state2());
            cast.setStateAt(2, data.state3());
        }
    }
    @Override
    public void handle(@NotNull PotHolderSyncData payload, @NotNull IPayloadContext context) {
        context.enqueueWork(() -> function(context, payload))
                .exceptionally(e -> {
                    // Handle exception
                    context.disconnect(Component.translatable("furnitureplan.networking.failed", e.getMessage()));
                    return null;
                });
    }
}