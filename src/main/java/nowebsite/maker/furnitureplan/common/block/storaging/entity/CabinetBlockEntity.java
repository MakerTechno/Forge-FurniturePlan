package nowebsite.maker.furnitureplan.common.block.storaging.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentSerialization;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.*;
import net.minecraft.world.entity.ContainerUser;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.ChestLidController;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.neoforged.neoforge.network.PacketDistributor;
import nowebsite.maker.furnitureplan.common.block.storaging.container.OpensCounterUtil;
import nowebsite.maker.furnitureplan.common.init.FPBlockReg;
import nowebsite.maker.furnitureplan.networks.CabinetSyncData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


public class CabinetBlockEntity extends BlockEntity implements MenuProvider, Nameable {
    @Nullable
    private Component name;
    private final Set<LivingEntity> using = new HashSet<>();
    public final SimpleContainer container = new SimpleContainer(36){
        @Override
        public void startOpen(ContainerUser containerUser) {
            super.startOpen(containerUser);
            if (!isRemoved() && !containerUser.getLivingEntity().isSpectator()) {
                counter.incrementOpeners(containerUser.getLivingEntity(), Objects.requireNonNull(getLevel()), getBlockPos(), getBlockState(), containerUser.getContainerInteractionRange());
            }
        }

        @Override
        public void stopOpen(ContainerUser containerUser) {
            super.stopOpen(containerUser);
            if (!isRemoved() && !containerUser.getLivingEntity().isSpectator()) {
                counter.decrementOpeners(containerUser.getLivingEntity(), Objects.requireNonNull(getLevel()), getBlockPos(), getBlockState());
                if (level != null && !level.isClientSide()) removeUsingPlayer(containerUser.getLivingEntity());
            }
        }

    };

    public final OpensCounterUtil counter = new OpensCounterUtil() {
        @Override
        public boolean isOwnContainer(@NotNull Player player) {
            if (!(player.containerMenu instanceof ChestMenu)) {
                return false;
            } else {
                Container container = ((ChestMenu)player.containerMenu).getContainer();
                return container instanceof SimpleContainer;
            }
        }
    };

    private final ChestLidController controller = new ChestLidController();

    public CabinetBlockEntity(BlockPos pos, BlockState state) {
        super(FPBlockReg.CABINET_BLOCK_ENTITY.get(), pos, state);
    }

    public static void animateTick(Level ignore, BlockPos ignore1, BlockState ignore2, @NotNull CabinetBlockEntity blockEntity) {
        blockEntity.controller.tickLid();
    }
    public void shouldBeOpen(boolean shouldOpen) {
        this.controller.shouldBeOpen(shouldOpen);
    }
    public float getOpenness(float partialTicks) {
        return this.controller.getOpenness(partialTicks);
    }

    /**Warnings: only call ON SERVER SIDE*/
    public void addUsingPlayer(LivingEntity entity){
        using.add(entity);
        markUpdated();
    }

    /**Warnings: only call ON SERVER SIDE*/
    public void removeUsingPlayer(LivingEntity entity){
        using.remove(entity);
        markUpdated();
    }

    @Override
    protected void loadAdditional(ValueInput input) {
        super.loadAdditional(input);
        ContainerHelper.loadAllItems(input, container.getItems());
        this.name = parseCustomNameSafe(input, "CustomName");
    }

    @Override
    protected void saveAdditional(ValueOutput output) {
        super.saveAdditional(output);
        ContainerHelper.saveAllItems(output, container.getItems());
        output.storeNullable("CustomName", ComponentSerialization.CODEC, this.name);
    }

    public void setCustomName(Component pName) {
        this.name = pName;
    }


    @Override
    public @NotNull Component getName() {
        return this.name == null ? this.getDisplayName() : this.name;
    }

    @Override
    public @NotNull Component getDisplayName() {
        return Component.translatable(getBlockState().getBlock().getDescriptionId());
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int containerId, @NotNull Inventory playerInventory, @NotNull Player player) {
        return using.contains(player) ? new ChestMenu(MenuType.GENERIC_9x4, containerId, playerInventory, this.container, 4) : null;
    }
    public void recheckOpen() {
        if (!this.remove) {
            this.counter.recheckOpeners(Objects.requireNonNull(this.getLevel()), this.getBlockPos(), this.getBlockState());
        }
    }
    private void markUpdated() {
        this.setChanged();
        Objects.requireNonNull(this.getLevel()).sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), 3);
        syncS2C();
    }
    private void syncS2C(){
        PacketDistributor.sendToAllPlayers(new CabinetSyncData(worldPosition.getCenter().toVector3f(), !using.isEmpty()));
    }
    @Override
    public Packet<@NotNull ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public @NotNull CompoundTag getUpdateTag(HolderLookup.@NotNull Provider registries) {
        return saveWithoutMetadata(registries);
    }

    @Override
    public void preRemoveSideEffects(BlockPos pos, BlockState state) {
        if (level == null) return;
        Containers.dropContents(level, pos, this.container);
        level.updateNeighbourForOutputSignal(pos, this.getBlockState().getBlock());
    }
}
