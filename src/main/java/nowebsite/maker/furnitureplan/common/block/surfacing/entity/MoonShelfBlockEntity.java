package nowebsite.maker.furnitureplan.common.block.surfacing.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.util.ProblemReporter;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.TagValueOutput;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import nowebsite.maker.furnitureplan.FurniturePlan;
import nowebsite.maker.furnitureplan.common.block.surfacing.MoonShelfBlock;
import nowebsite.maker.furnitureplan.common.init.FPBlockReg;
import nowebsite.maker.furnitureplan.utils.display.FPDisplayableItemStacks;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class MoonShelfBlockEntity extends BlockEntity implements Container {
    /*
    * Ordered sorted in one block & for all blocks
    * 1 2 3
    * 4 5 6
    * 7 8 9
    */
    private final FPDisplayableItemStacks poweredItems = new FPDisplayableItemStacks(22);

    public MoonShelfBlockEntity(BlockPos worldPosition, BlockState blockState) {
        super(FPBlockReg.MOON_SHELF_BLOCK_ENTITY.get(), worldPosition, blockState);
    }

    private void markUpdated() {
        this.setChanged();
        Objects.requireNonNull(this.getLevel()).sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), 3);
    }

    public boolean putItem(ItemStack item, int index) {
        if (index < 0 || index > 21) return false;
        if (!poweredItems.getItem(index).isEmpty()) return false;
        poweredItems.setItem(index, item.split(1));
        markUpdated();
        return true;
    }

    public boolean tryRotate(int index) {
        if (index < 0 || index > 21) return false;
        if (poweredItems.getItem(index).isEmpty()) return false;
        Direction last = poweredItems.getFacing(index);
        poweredItems.setFacing(index, last == null ? getBlockState().getValue(MoonShelfBlock.FACING).getClockWise() : last.getClockWise());
        markUpdated();
        return true;
    }

    public boolean dropItem(int index) {
        if (index < 0 || index > 21) return false;
        if (poweredItems.getItem(index).isEmpty()) return false;
        SimpleContainer inventory = new SimpleContainer(1);
        inventory.setItem(0, poweredItems.getItem(index));
        Containers.dropContents(Objects.requireNonNull(this.getLevel()), this.worldPosition, inventory);
        poweredItems.setItem(index, ItemStack.EMPTY);
        markUpdated();
        return true;
    }

    @Override
    public int getContainerSize() {
        return 22;
    }

    @Override
    public boolean isEmpty() {
        return poweredItems.isEmpty();
    }

    public ItemStack getItem(int index) {
        return poweredItems.getItem(index);
    }

    @Override
    public ItemStack removeItem(int slot, int count) {
        ItemStack stack = poweredItems.setItem(slot, ItemStack.EMPTY);
        markUpdated();
        return stack;
    }

    @Override
    public ItemStack removeItemNoUpdate(int slot) {
        return poweredItems.setItem(slot, ItemStack.EMPTY);
    }

    @Override
    public void setItem(int slot, ItemStack itemStack) {
        poweredItems.setItem(slot, itemStack.split(1));
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }

    @Override
    public void preRemoveSideEffects(BlockPos pos, BlockState state) {
        SimpleContainer inventory = new SimpleContainer(22);
        for (int i = 0; i < 22; i++) {
            inventory.setItem(i, getItem(i));
        }
        Containers.dropContents(Objects.requireNonNull(this.getLevel()), this.worldPosition, inventory);
    }

    @Override
    protected void loadAdditional(ValueInput input) {
        super.loadAdditional(input);
        poweredItems.loadAdditional(input, this);
    }

    @Override
    protected void saveAdditional(ValueOutput output) {
        super.saveAdditional(output);
        poweredItems.saveAdditional(output);
    }

    @Override
    public Packet<@NotNull ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        CompoundTag tag;
        try (ProblemReporter.ScopedCollector reporter = new ProblemReporter.ScopedCollector(this.problemPath(), FurniturePlan.LOGGER)) {
            TagValueOutput output = TagValueOutput.createWithContext(reporter, registries);
            tag = poweredItems.getUpdtTags(output);
        }
        return tag;
    }

    public NonNullList<ItemStack> getItems() {
        return poweredItems.getItems();
    }

    public FPDisplayableItemStacks getPoweredItems() {
        return poweredItems;
    }

    @Override
    public void clearContent() {
        poweredItems.clear();
    }
}
