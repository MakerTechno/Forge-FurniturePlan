package nowebsite.maker.furnitureplan.networks;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;
import nowebsite.maker.furnitureplan.FurniturePlan;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

public record PotHolderSyncData(Vector3f pos, BlockState state1, BlockState state2, BlockState state3) implements CustomPacketPayload {
    public static final Type<PotHolderSyncData> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(FurniturePlan.MOD_ID, "potholder_sync_msg"));
    public static final StreamCodec<RegistryFriendlyByteBuf, PotHolderSyncData> STREAM_CODEC = StreamCodec.composite(
        ByteBufCodecs.VECTOR3F,
        PotHolderSyncData::pos,
        ByteBufCodecs.fromCodec(BlockState.CODEC),
        PotHolderSyncData::state1,
        ByteBufCodecs.fromCodec(BlockState.CODEC),
        PotHolderSyncData::state2,
        ByteBufCodecs.fromCodec(BlockState.CODEC),
        PotHolderSyncData::state3,
        PotHolderSyncData::new
    );
    @Override
    public @NotNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
