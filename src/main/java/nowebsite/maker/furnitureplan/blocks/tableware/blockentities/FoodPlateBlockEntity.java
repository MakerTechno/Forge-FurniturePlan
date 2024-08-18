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
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import nowebsite.maker.furnitureplan.blocks.tableware.FoodPlateBlock;
import nowebsite.maker.furnitureplan.networks.ModMessages;
import nowebsite.maker.furnitureplan.networks.packets.ItemStackSyncS2CPacket;
import nowebsite.maker.furnitureplan.registry.BlockRegistration;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class FoodPlateBlockEntity extends BlockEntity implements HasPlateEntity, HasGlassEntity{
    private final ItemStackHandler itemStackHandler = new ItemStackHandler(2){
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
    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();
    public static final String INVENTORY = "inventory";
    public FoodPlateBlockEntity(BlockPos pos, BlockState state) {
        super(BlockRegistration.FOOD_PLATE_BLOCK_ENTITY.get(), pos, state);
    }

    /**You can't change this*/
    public ItemStack getFoodStack() {
        return itemStackHandler.getStackInSlot(0).copy();
    }
    /**You can't change this*/
    public ItemStack getPotionStack(){
        if (this.getBlockState().getValue(FoodPlateBlock.SHAPE_DEF).hasGlass()) {
            return itemStackHandler.getStackInSlot(1).copy();
        } else return ItemStack.EMPTY;
    }

    public void changeFood(ItemStack stack) {
        itemStackHandler.setStackInSlot(0, stack);
        this.markUpdated();
    }

    public void changePotion(ItemStack stack){
        if (!this.getBlockState().getValue(FoodPlateBlock.SHAPE_DEF).hasGlass()) return;
        itemStackHandler.setStackInSlot(1, stack);
        this.markUpdated();
    }
    public boolean placeFood(Entity entity, ItemStack stack) {
        if (!getFoodStack().isEmpty() || stack.is(Items.HONEY_BOTTLE)) return false;
        changeFood(stack.split(1));
        if (this.level != null) {
            this.level.gameEvent(GameEvent.BLOCK_CHANGE, this.getBlockPos(), GameEvent.Context.of(entity, this.getBlockState()));
        }
        return true;
    }
    public boolean fillPotion(Entity entity, ItemStack stack) {
        if (!getPotionStack().isEmpty() || !this.getBlockState().getValue(FoodPlateBlock.SHAPE_DEF).hasGlass()) return false;
        this.changePotion(stack.split(1));
        if (entity instanceof Player player && !player.getAbilities().instabuild) {
            player.getInventory().add(new ItemStack(Items.GLASS_BOTTLE, 1));
            player.getInventory().setChanged();
        }
        if (this.level != null) {
            this.level.gameEvent(GameEvent.BLOCK_CHANGE, this.getBlockPos(), GameEvent.Context.of(entity, this.getBlockState()));
        }
        return true;
    }
    public boolean usePotion(Player player){
        if (getPotionStack().isEmpty() || !this.getBlockState().getValue(FoodPlateBlock.SHAPE_DEF).hasGlass()) return false;
        for (MobEffectInstance instance : PotionUtils.getMobEffects(getPotionStack())){
            player.addEffect(instance);
        }
        changePotion(ItemStack.EMPTY);
        return true;
    }
    public boolean restorePotion(Player player, @NotNull ItemStack stack){
        if (!stack.is(Items.GLASS_BOTTLE) || getPotionStack().isEmpty() || !this.getBlockState().getValue(FoodPlateBlock.SHAPE_DEF).hasGlass()) return false;
        stack.shrink(1);
        player.getInventory().add(getPotionStack());
        changePotion(ItemStack.EMPTY);
        return true;
    }
    private void markUpdated() {
        this.setChanged();
        Objects.requireNonNull(this.getLevel()).sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), 3);
    }
    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER) return lazyItemHandler.cast();
        return super.getCapability(cap, side);
    }
    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemStackHandler);
    }
    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }
    @Override
    protected void saveAdditional(@NotNull CompoundTag tag) {
        tag.put(INVENTORY, itemStackHandler.serializeNBT());
        super.saveAdditional(tag);
    }
    @Override
    public void load(@NotNull CompoundTag tag) {
        super.load(tag);
        itemStackHandler.deserializeNBT(tag.getCompound(INVENTORY));
    }
    public void drops(){
        SimpleContainer inventory = new SimpleContainer(1);
        inventory.setItem(0, getFoodStack());
        Containers.dropContents(Objects.requireNonNull(this.getLevel()), this.worldPosition, inventory);
        changeFood(ItemStack.EMPTY);
        markUpdated();
    }
    public void dropBottle(){
        SimpleContainer inventory = new SimpleContainer(1);
        ItemStack stack = new ItemStack(BlockRegistration.GLASS_B_BLOCK_ITEM.get(),1);
        if (getPotionStack() != null && !getPotionStack().isEmpty()) {
            BlockItem.setBlockEntityData(stack, BlockRegistration.GLASS_B_BLOCK_ENTITY.get(), this.saveWithoutMetadata());
        }
        inventory.setItem(0, stack);
        Containers.dropContents(Objects.requireNonNull(this.getLevel()), this.worldPosition, inventory);
        changePotion(ItemStack.EMPTY);
        markUpdated();
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
