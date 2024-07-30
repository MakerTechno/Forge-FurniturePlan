/*
package nowebsite.maker.furnitureplan.networks.packets;

import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;
import nowebsite.maker.furnitureplan.blocks.singleblockfurniture.blockentities.CupboardBlockEntity;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class PlayerListSyncS2CPacket {
    private final int state;
    private final BlockPos pos;

    public PlayerListSyncS2CPacket(int state, BlockPos pos) {
        this.state = state;
        this.pos = pos;
    }

    public PlayerListSyncS2CPacket(@NotNull FriendlyByteBuf buf) {
        state = buf.readInt();
        this.pos = buf.readBlockPos();
    }

    public void toBytes(@NotNull FriendlyByteBuf buf) {
        buf.writeInt(state);
        buf.writeBlockPos(pos);
    }
    public void handle(@NotNull Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            if (Minecraft.getInstance().level != null) {
                if (Minecraft.getInstance().level.getBlockEntity(pos) instanceof CupboardBlockEntity blockEntity) {
                    blockEntity.drawer1ShouldBeOpen(this.state >= 100);
                    blockEntity.drawer2ShouldBeOpen(this.state % 100 > 1);
                    blockEntity.drawer3ShouldBeOpen(this.state % 10 == 1);
                }
            }
        });
    }


}
*/
