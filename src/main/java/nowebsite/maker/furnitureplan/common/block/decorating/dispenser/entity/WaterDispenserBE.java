package nowebsite.maker.furnitureplan.common.block.decorating.dispenser.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Containers;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class WaterDispenserBE extends BlockEntity {
    public static final String STORAGE_NAME = "inventory";
    private ItemStack itemLeft = ItemStack.EMPTY;
    private ItemStack itemRight = ItemStack.EMPTY;

    public static final String INVENTORY = "inventory";
    public WaterDispenserBE(BlockEntityType<?> type, BlockPos pos, BlockState blockState) {
        super(type, pos, blockState);
    }
    public ItemStack getHotStack() {
        return itemLeft;
    }
    public ItemStack getColdStack() {
        return itemRight;
    }
    public void changeHotStack(ItemStack stack) {
       itemLeft = stack;
    }
    public void changeColdStack(ItemStack stack) {
        itemRight = stack;
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


    @Override
    public void onLoad() {
        super.onLoad();
    }

    @Override
    protected void saveAdditional(ValueOutput output) {
        super.saveAdditional(output);
    }

    @Override
    protected void loadAdditional(ValueInput input) {
        super.loadAdditional(input);
    }

    @Override
    public Packet<@NotNull ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public @NotNull CompoundTag getUpdateTag(HolderLookup.@NotNull Provider registries) {
        return saveWithoutMetadata(registries);
    }

    private void markUpdated() {
        this.setChanged();
        Objects.requireNonNull(this.getLevel()).sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), 3);
    }
}
