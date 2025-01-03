package nowebsite.maker.furnitureplan.networks;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import nowebsite.maker.furnitureplan.FurniturePlan;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

public record CupboardSyncData(Vector3f pos, boolean d1, boolean d2, boolean d3) implements CustomPacketPayload {
    public static final Type<CupboardSyncData> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(FurniturePlan.MOD_ID, "cupboard_sync_msg"));
    public static final StreamCodec<ByteBuf, CupboardSyncData> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.VECTOR3F,
            CupboardSyncData::pos,
            ByteBufCodecs.BOOL,
            CupboardSyncData::d1,
            ByteBufCodecs.BOOL,
            CupboardSyncData::d2,
            ByteBufCodecs.BOOL,
            CupboardSyncData::d3,
            CupboardSyncData::new
    );

    @Override
    public @NotNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
