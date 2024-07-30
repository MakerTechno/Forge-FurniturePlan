package nowebsite.maker.furnitureplan.blocks.tableware.blockentities;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Containers;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.neoforged.neoforge.common.util.Lazy;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;
import nowebsite.maker.furnitureplan.registry.BlockRegistration;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class GlassBBlockEntity extends BlockEntity implements HasGlassEntity {
    private final ItemStackHandler potionItemStackHandler = new ItemStackHandler(2){
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
    private Lazy<IItemHandler> lazyItemHandler = Lazy.of(() -> potionItemStackHandler);
    public static final String INVENTORY = "inventory";
    public GlassBBlockEntity(BlockPos pos, BlockState state) {
        super(BlockRegistration.GLASS_B_BLOCK_ENTITY.get(), pos, state);
    }

    /**You can't change this*/
    public ItemStack getPotionStack(){
        return this.potionItemStackHandler.getStackInSlot(1).copy();
    }
    public boolean usePotion(Player player){
        if (getPotionStack().isEmpty()) return false;
        PotionContents potioncontents = getPotionStack().getOrDefault(DataComponents.POTION_CONTENTS, PotionContents.EMPTY);
        potioncontents.forEachEffect(effect -> {
            if (effect.getEffect().value().isInstantenous()) {
                effect.getEffect().value().applyInstantenousEffect(null, null, player, effect.getAmplifier(), 1.0);
            } else {
                player.addEffect(effect);
            }
        });
        changePotion(ItemStack.EMPTY);
        return true;
    }
    public boolean restorePotion(Player player, @NotNull ItemStack stack){
        if (!stack.is(Items.GLASS_BOTTLE) || getPotionStack().isEmpty()) return false;
        stack.shrink(1);
        player.getInventory().add(getPotionStack());
        changePotion(ItemStack.EMPTY);
        return true;
    }
    public boolean fillPotion(Entity entity, ItemStack stack) {
        if (!getPotionStack().isEmpty()) return false;
        this.changePotion(stack.split(1));
        if (entity instanceof Player player && !player.getAbilities().instabuild) {
            player.getInventory().add(new ItemStack(Items.GLASS_BOTTLE));
        }
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
    public void changePotion(ItemStack stack){
        potionItemStackHandler.setStackInSlot(1, stack);
    }
    public void dropBottle(){
        SimpleContainer inventory = new SimpleContainer(1);
        ItemStack stack = new ItemStack(BlockRegistration.GLASS_B_BLOCK_ITEM.get(),1);
        if (getPotionStack() != null && !getPotionStack().isEmpty() && this.getLevel() != null) {
            BlockItem.setBlockEntityData(stack, BlockRegistration.GLASS_B_BLOCK_ENTITY.get(), this.saveWithoutMetadata(this.getLevel().registryAccess()));
        }
        inventory.setItem(0, stack);
        Containers.dropContents(Objects.requireNonNull(this.getLevel()), this.worldPosition, inventory);
        changePotion(ItemStack.EMPTY);
        markUpdated();
    }
    public Lazy<IItemHandler> getLazyItemHandler() {
        return lazyItemHandler;
    }
    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = Lazy.of(() -> potionItemStackHandler);
    }
    @Override
    protected void saveAdditional(@NotNull CompoundTag tag, HolderLookup.@NotNull Provider registries) {
        tag.put(INVENTORY, potionItemStackHandler.serializeNBT(registries));
        super.saveAdditional(tag, registries);
    }
    @Override
    protected void loadAdditional(@NotNull CompoundTag tag, HolderLookup.@NotNull Provider registries) {
        potionItemStackHandler.deserializeNBT(registries, tag.getCompound(INVENTORY));
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
