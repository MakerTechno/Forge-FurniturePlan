package nowebsite.maker.furnitureplan.networks;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import nowebsite.maker.furnitureplan.FurniturePlan;
import org.jetbrains.annotations.NotNull;

public record GraverSyncData(String value) implements CustomPacketPayload {
    public static final Type<@NotNull GraverSyncData> TYPE = new Type<>(Identifier.fromNamespaceAndPath(FurniturePlan.MOD_ID, "graver_sync_msg"));
    public static final StreamCodec<ByteBuf, GraverSyncData> STREAM_CODEC = StreamCodec.composite(
        ByteBufCodecs.STRING_UTF8,
        GraverSyncData::value,
        GraverSyncData::new
    );

    @Override
    public @NotNull Type<? extends @NotNull CustomPacketPayload> type() {
        return TYPE;
    }
}
