package nowebsite.maker.furnitureplan.blocks.tableware.blockentities;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Containers;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.ItemStackHandler;
import nowebsite.maker.furnitureplan.networks.ModMessages;
import nowebsite.maker.furnitureplan.networks.packets.ItemStackSyncS2CPacket;
import nowebsite.maker.furnitureplan.registry.BlockRegistration;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class GlassBBlockEntity extends BlockEntity implements HasGlassEntity {
    private final ItemStackHandler potionItemStackHandler = new ItemStackHandler(2){
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            if (level != null && !level.isClientSide) {
                ModMessages.sendToClients(new ItemStackSyncS2CPacket(this, worldPosition));
            }
        }
        @Override
        public void setSize(int size) {
            super.setSize(2);
        }
    };
    private LazyOptional<ItemStack> lazyFluidHandler = LazyOptional.empty();
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
        for (MobEffectInstance instance : PotionUtils.getMobEffects(getPotionStack())){
            player.addEffect(instance);
        }
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
    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.FLUID_HANDLER) return lazyFluidHandler.cast();
        return super.getCapability(cap, side);
    }
    public void changePotion(ItemStack stack){
        potionItemStackHandler.setStackInSlot(1, stack);
    }
    public void dropBottle(){
        SimpleContainer inventory = new SimpleContainer(1);
        ItemStack stack = new ItemStack(BlockRegistration.GLASS_B_BLOCK_ITEM.get(),1);
        if (getPotionStack() != null && !getPotionStack().isEmpty()) {
            this.saveToItem(stack);
        }
        inventory.setItem(0, stack);
        Containers.dropContents(Objects.requireNonNull(this.getLevel()), this.worldPosition, inventory);
        changePotion(ItemStack.EMPTY);
        markUpdated();
    }
    @Override
    public void onLoad() {
        super.onLoad();
        lazyFluidHandler = LazyOptional.of(this::getPotionStack);
    }
    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyFluidHandler.invalidate();
    }
    @Override
    protected void saveAdditional(@NotNull CompoundTag tag) {
        tag.put(INVENTORY, potionItemStackHandler.serializeNBT());
        super.saveAdditional(tag);
    }
    @Override
    public void load(@NotNull CompoundTag tag) {
        super.load(tag);
        potionItemStackHandler.deserializeNBT(tag.getCompound(INVENTORY));
    }
    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }
    @Override
    public @NotNull CompoundTag getUpdateTag() {
        return saveWithoutMetadata();
    }
}
