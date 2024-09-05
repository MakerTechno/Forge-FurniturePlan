package nowebsite.maker.furnitureplan.entities;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.players.PlayerList;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.VehicleEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.entity.IEntityWithComplexSpawn;
import nowebsite.maker.furnitureplan.blocks.singleblockfurniture.blockentities.BaseSittableBE;
import org.jetbrains.annotations.NotNull;

public class RideableEntityNull extends VehicleEntity implements IEntityWithComplexSpawn {
    private BlockPos blockEntityPos;
    public RideableEntityNull(EntityType<? extends VehicleEntity> entityType, Level level) {
        this(entityType, level, BlockPos.ZERO);
    }
    public RideableEntityNull(EntityType<? extends VehicleEntity> entityType, Level level, BlockPos blockEntityPos) {
        super(entityType, level);
        this.blockEntityPos = blockEntityPos;
        setNoGravity(true);
        setInvisible(true);
        horizontalCollision = false;
        minorHorizontalCollision = false;
        verticalCollision = false;
        verticalCollisionBelow = false;
    }
    @Override
    protected @NotNull Item getDropItem() {
        return Items.AIR;
    }
    @Override
    public void tick() {
        super.tick();
        BlockEntity blockEntity = level().getBlockEntity(blockEntityPos);
        if (!(blockEntity instanceof BaseSittableBE<?> cast)){


            MinecraftServer server = level().getServer();
            if(server != null) {
                PlayerList playerlist = server.getPlayerList();
                playerlist.getPlayers().getFirst().sendSystemMessage(Component.literal("[Entity]实体因没发现方块实体而被删除。"));
            }


            this.remove(RemovalReason.DISCARDED);
        }
        else if (cast.getBlockState() != cast.containerBlock || canAddPassenger(this)){


            MinecraftServer server = level().getServer();
            if(server != null) {
                PlayerList playerlist = server.getPlayerList();
                Component chat;
                if (canAddPassenger(this)) chat = Component.literal("[Entity]实体因没有乘客而被删除。");
                else chat = Component.literal("[Entity]实体因没在正确材质的椅子上而被删除。");
                playerlist.getPlayers().getFirst().sendSystemMessage(chat);
            }


            cast.setRemoved();
        }
    }
    private int count;
    @Override
    public void baseTick() {
        super.baseTick();
        if (count ==50) {
            BlockEntity blockEntity = level().getBlockEntity(blockEntityPos);
            if (!(blockEntity instanceof BaseSittableBE<?> cast)){


                MinecraftServer server = level().getServer();
                if(server != null) {
                    PlayerList playerlist = server.getPlayerList();
                    playerlist.getPlayers().getFirst().sendSystemMessage(Component.literal("[Entity]实体因没发现方块实体而被删除。"));
                }


                this.remove(RemovalReason.DISCARDED);
            }
            else if (cast.getBlockState() != cast.containerBlock || canAddPassenger(this)){


                MinecraftServer server = level().getServer();
                if(server != null) {
                    PlayerList playerlist = server.getPlayerList();
                    Component chat;
                    if (canAddPassenger(this)) chat = Component.literal("[Entity]实体因没有乘客而被删除。");
                    else chat = Component.literal("[Entity]实体因没在正确材质的椅子上而被删除。");
                    playerlist.getPlayers().getFirst().sendSystemMessage(chat);
                }


                cast.setRemoved();
            }
        } else {
            count++;
        }
    }
    @Override
    protected void readAdditionalSaveData(@NotNull CompoundTag pCompound) {
        MinecraftServer server = level().getServer();
        if(server != null) {
            PlayerList playerlist = server.getPlayerList();
            playerlist.getPlayers().getFirst().sendSystemMessage(Component.literal("[Entity]实体因访问readAdditionalSaveData而被删除。"));
        }

        this.remove(RemovalReason.DISCARDED);
    }
    @Override
    protected void addAdditionalSaveData(@NotNull CompoundTag pCompound) {
        MinecraftServer server = level().getServer();
        if(server != null) {
            PlayerList playerlist = server.getPlayerList();
            playerlist.getPlayers().getFirst().sendSystemMessage(Component.literal("[Entity]实体因访问addAdditionalSaveData而被删除。"));
        }

        this.remove(RemovalReason.DISCARDED);
    }

    @Override
    public void writeSpawnData(@NotNull RegistryFriendlyByteBuf buffer) {
        buffer.writeBlockPos(this.blockEntityPos);
    }
    @Override
    public void readSpawnData(@NotNull RegistryFriendlyByteBuf additionalData) {
        blockEntityPos = additionalData.readBlockPos();
    }
}
