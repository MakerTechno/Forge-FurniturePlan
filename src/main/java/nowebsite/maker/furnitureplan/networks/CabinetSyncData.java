package nowebsite.maker.furnitureplan.networks;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import nowebsite.maker.furnitureplan.FurniturePlan;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3fc;

public record CabinetSyncData(Vector3fc pos, boolean open) implements CustomPacketPayload {
    public static final Type<@NotNull CabinetSyncData> TYPE = new Type<>(Identifier.fromNamespaceAndPath(FurniturePlan.MOD_ID, "cabinet_sync_msg"));
    public static final StreamCodec<ByteBuf, CabinetSyncData> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.VECTOR3F,
            CabinetSyncData::pos,
            ByteBufCodecs.BOOL,
            CabinetSyncData::open,
            CabinetSyncData::new
    );

    @Override
    public @NotNull Type<? extends @NotNull CustomPacketPayload> type() {
        return TYPE;
    }
}
