package nowebsite.maker.furnitureplan.blocks.multiaffected.blockentities;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Containers;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.neoforged.neoforge.common.util.Lazy;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class WaterDispenserBE extends BlockEntity {
    private final ItemStackHandler itemStackHandler = new ItemStackHandler(2){
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            if (level != null) {
                level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), Block.UPDATE_ALL);
            }
        }
        @Override
        public void setSize(int size) {
            super.setSize(2);
        }
    };
    private void markUpdated() {
        this.setChanged();
        Objects.requireNonNull(this.getLevel()).sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), 3);
    }
    private Lazy<IItemHandler> lazyItemHandler = Lazy.of(() -> itemStackHandler);
    public static final String INVENTORY = "inventory";
    public WaterDispenserBE(BlockEntityType<?> type, BlockPos pos, BlockState blockState) {
        super(type, pos, blockState);
    }
    public ItemStack getHotStack() {
        return itemStackHandler.getStackInSlot(0);
    }
    public ItemStack getColdStack() {
        return itemStackHandler.getStackInSlot(1);
    }
    public void changeHotStack(ItemStack stack) {
       itemStackHandler.setStackInSlot(0, stack);
    }
    public void changeColdStack(ItemStack stack) {
        itemStackHandler.setStackInSlot(1, stack);
    }
    public boolean placeHot(Entity entity, ItemStack stack) {
        if (!getHotStack().isEmpty()) return false;
        changeHotStack(stack.split(1));
        if (this.level != null) {
            this.level.gameEvent(GameEvent.BLOCK_CHANGE, this.getBlockPos(), GameEvent.Context.of(entity, this.getBlockState()));
        }
        return true;
    }
    public boolean placeCold(Entity entity, ItemStack stack) {
        if (!getColdStack().isEmpty()) return false;
        changeColdStack(stack.split(1));
        if (this.level != null) {
            this.level.gameEvent(GameEvent.BLOCK_CHANGE, this.getBlockPos(), GameEvent.Context.of(entity, this.getBlockState()));
        }
        return true;
    }
    public void dropHot(){
        SimpleContainer inventory = new SimpleContainer(1);
        inventory.setItem(0, getHotStack());
        Containers.dropContents(Objects.requireNonNull(this.getLevel()), this.worldPosition, inventory);
        changeHotStack(ItemStack.EMPTY);
        markUpdated();
    }
    public void dropCold(){
        SimpleContainer inventory = new SimpleContainer(1);
        inventory.setItem(0, getColdStack());
        Containers.dropContents(Objects.requireNonNull(this.getLevel()), this.worldPosition, inventory);
        changeColdStack(ItemStack.EMPTY);
        markUpdated();
    }
    public void dropAll(){
        SimpleContainer inventory = new SimpleContainer(2);
        inventory.setItem(0, getHotStack());
        inventory.setItem(1, getColdStack());
        Containers.dropContents(Objects.requireNonNull(this.getLevel()), this.worldPosition, inventory);
        changeHotStack(ItemStack.EMPTY);
        changeColdStack(ItemStack.EMPTY);
        markUpdated();
    }


    public Lazy<IItemHandler> getLazyItemHandler() {
        return lazyItemHandler;
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = Lazy.of(() -> itemStackHandler);
    }
    @Override
    protected void saveAdditional(@NotNull CompoundTag tag, HolderLookup.@NotNull Provider registries) {
        tag.put(INVENTORY, itemStackHandler.serializeNBT(registries));
        super.saveAdditional(tag, registries);
    }
    @Override
    protected void loadAdditional(@NotNull CompoundTag tag, HolderLookup.@NotNull Provider registries) {
        itemStackHandler.deserializeNBT(registries, tag.getCompound(INVENTORY));
        super.loadAdditional(tag, registries);
    }
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }
    @Override
    public void onDataPacket(@NotNull Connection net, @NotNull ClientboundBlockEntityDataPacket pkt, HolderLookup.@NotNull Provider lookupProvider) {
        handleUpdateTag(pkt.getTag(), lookupProvider);
    }
    @Override
    public @NotNull CompoundTag getUpdateTag(HolderLookup.@NotNull Provider registries) {
        return saveWithoutMetadata(registries);
    }
    @Override
    public void handleUpdateTag(@NotNull CompoundTag tag, HolderLookup.@NotNull Provider lookupProvider) {
        super.handleUpdateTag(tag, lookupProvider);
    }
}
