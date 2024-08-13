package nowebsite.maker.furnitureplan.networks;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import nowebsite.maker.furnitureplan.FurniturePlan;
import org.jetbrains.annotations.NotNull;

public record GraverSyncData(byte value) implements CustomPacketPayload {
    public static final Type<GraverSyncData> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(FurniturePlan.MOD_ID, "graver_sync_msg"));
    public static final StreamCodec<ByteBuf, GraverSyncData> STREAM_CODEC = StreamCodec.composite(
        ByteBufCodecs.BYTE,
        GraverSyncData::value,
        GraverSyncData::new
    );

    @Override
    public @NotNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
