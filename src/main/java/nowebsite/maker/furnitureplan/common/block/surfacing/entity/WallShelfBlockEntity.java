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
import net.minecraft.world.Container;
import net.minecraft.world.Containers;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.TagValueOutput;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import nowebsite.maker.furnitureplan.FurniturePlan;
import nowebsite.maker.furnitureplan.common.block.abstraction.definition.WallShelfShape;
import nowebsite.maker.furnitureplan.common.block.surfacing.WallShelfBlock;
import nowebsite.maker.furnitureplan.common.init.FPBlockReg;
import nowebsite.maker.furnitureplan.utils.display.FPDisplayableItemStacks;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class WallShelfBlockEntity extends BlockEntity implements Container {
    private final FPDisplayableItemStacks poweredItems = new FPDisplayableItemStacks(6);
    private boolean isBi = false;

    public WallShelfBlockEntity(BlockPos worldPosition, BlockState blockState) {
        super(FPBlockReg.WALL_SHELF_BLOCK_ENTITY.get(), worldPosition, blockState);
        if (blockState.getValue(WallShelfBlock.SHAPE).equals(WallShelfShape.BI)) this.isBi = true;
    }

    private void markUpdated() {
        this.setChanged();
        Objects.requireNonNull(this.getLevel()).sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), 3);
    }

    public void setBi(boolean bi) {
        isBi = bi;
    }

    public boolean putItem(ItemStack item, int index) {
        if (item.isEmpty()) return false;
        if (index < 0 || index > (isBi ? 5 : 2)) return false;
        if (!poweredItems.getItem(index).isEmpty()) return false;
        poweredItems.setItem(index, item.split(1));
        markUpdated();
        return true;
    }

    public boolean tryRotate(int index) {
        if (index < 0 || index > (isBi ? 5 : 2)) return false;
        if (poweredItems.getItem(index).isEmpty()) return false;
        Direction last = poweredItems.getFacing(index);
        poweredItems.setFacing(index, last == null ? getBlockState().getValue(WallShelfBlock.FACING).getClockWise() : last.getClockWise());
        markUpdated();
        return true;
    }

    public boolean dropItem(int index) {
        if (index < 0 || index > (isBi ? 5 : 2)) return false;
        if (poweredItems.getItem(index).isEmpty()) return false;
        SimpleContainer inventory = new SimpleContainer(1);
        inventory.setItem(0, poweredItems.setItem(index, ItemStack.EMPTY));
        Containers.dropContents(Objects.requireNonNull(this.getLevel()), this.worldPosition, inventory);
        markUpdated();
        return true;
    }

    public void dropSecondFloor() {
        SimpleContainer inventory = new SimpleContainer(4);
        for (int i = 3; i < 6; i++) inventory.setItem(i - 3, poweredItems.setItem(i, ItemStack.EMPTY));
        inventory.setItem(3, this.getBlockState().getBlock().asItem().getDefaultInstance());
        Containers.dropContents(Objects.requireNonNull(this.getLevel()), this.worldPosition, inventory);
        markUpdated();
    }

    @Override
    public int getContainerSize() {
        return isBi ? 6 : 3;
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
        SimpleContainer inventory = new SimpleContainer(6);
        for (int i = 0; i < 6; i++) {
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
