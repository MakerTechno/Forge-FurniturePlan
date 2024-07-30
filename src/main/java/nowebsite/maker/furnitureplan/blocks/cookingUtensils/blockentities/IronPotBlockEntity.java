package nowebsite.maker.furnitureplan.blocks.cookingUtensils.blockentities;

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
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.neoforged.neoforge.common.util.Lazy;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;
import nowebsite.maker.furnitureplan.blocks.tableware.blockentities.HasPlateEntity;
import nowebsite.maker.furnitureplan.registry.BlockRegistration;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class IronPotBlockEntity extends BlockEntity implements HasPlateEntity {
    private final ItemStackHandler itemStackHandler = new ItemStackHandler(1){
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            if (level != null) {
                level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), Block.UPDATE_ALL);
            }
        }
        @Override
        public void setSize(int size) {
            super.setSize(1);
        }
    };
    public static final String INVENTORY = "inventory";
    public IronPotBlockEntity(BlockPos pos, BlockState state) {
        super(BlockRegistration.IRON_POT_BLOCK_ENTITY.get(), pos, state);
    }
    private Lazy<IItemHandler> lazyItemHandler = Lazy.of(() -> itemStackHandler);
    /**You can't change this*/
    public ItemStack getFoodStack() {return itemStackHandler.getStackInSlot(0).copy();}

    public void changeFood(@NotNull ItemStack stack) {
        itemStackHandler.setStackInSlot(0, stack);
    }
    public boolean placeFood(Entity entity, ItemStack stack) {
        if (!getFoodStack().isEmpty() || stack.is(Items.HONEY_BOTTLE)) return false;
        changeFood(stack.split(1));
        if (this.level != null) {
            this.level.gameEvent(GameEvent.BLOCK_CHANGE, this.getBlockPos(), GameEvent.Context.of(entity, this.getBlockState()));
        }
        this.markUpdated();
        return true;
    }
    private void markUpdated() {
        this.setChanged();
        Objects.requireNonNull(this.getLevel()).sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), 3);
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
    public void drops(){
        SimpleContainer inventory = new SimpleContainer(1);
        inventory.setItem(0, getFoodStack());
        Containers.dropContents(Objects.requireNonNull(this.getLevel()), this.worldPosition, inventory);
        changeFood(ItemStack.EMPTY);
        markUpdated();
    }
}
