package nowebsite.maker.furnitureplan.utils.display;

import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.TagValueOutput;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class FPDisplayableItemStacks {
    public static final String FACING_STORAGE = "Facings";
    private final NonNullList<ItemStack> items;
    private final List<FPDisplayableItemStack> states;
    private final int capacity;

    public FPDisplayableItemStacks(int capacity) {
        items = NonNullList.withSize(capacity, ItemStack.EMPTY);
        states = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            states.add(new FPDisplayableItemStack());
        }
        this.capacity = capacity;
    }

    public FPDisplayableItemStack getState(int index) {
        return states.get(index);
    }

    public ItemStack getItem(int index) {
        return items.get(index);
    }

    public NonNullList<ItemStack> getItems() {
        return items;
    }

    public ItemStack setItem(int index, ItemStack stack) {
        return items.set(index, stack);
    }

    public boolean isEmpty() {
        return items.stream().allMatch(ItemStack::isEmpty);
    }

    public void clear() {
        items.clear();
    }

    public CompoundTag getUpdtTags(TagValueOutput output) {
        ContainerHelper.saveAllItems(output, items);
        ValueOutput.TypedOutputList<DirectionWithSlot> facingList = output.list(FACING_STORAGE, DirectionWithSlot.CODEC);
        for (int i = 0; i < capacity; i++) {
            Direction facing = states.get(i).getDisplayFacing();
            if (facing != null) facingList.add(new DirectionWithSlot(i, facing));
        }
        return output.buildResult();
    }

    public void loadAdditional(ValueInput input, BlockEntity blockEntity) {
        items.clear();
        ContainerHelper.loadAllItems(input, items);

        for (DirectionWithSlot facing : input.listOrEmpty(FACING_STORAGE, DirectionWithSlot.CODEC)) {
            if (facing.isValidInContainer(capacity) && facing.direction() != Direction.UP) {
                states.get(facing.slot()).setDisplayFacing(facing.direction());
            }
        }

        // Client only
        Level level = blockEntity.getLevel();
        if (level == null || !level.isClientSide()) return;
        generateCaches(level, blockEntity);
    }

    public void generateCaches(Level client, BlockEntity holder) {
        for (int i = 0; i < capacity; i++) {
            states.get(i).generateCache(items.get(i), client, holder);
        }
    }
    public void saveAdditional(ValueOutput output) {
        ContainerHelper.saveAllItems(output, items);
    }

    public void setFacing(int index, Direction facing) {
        states.get(index).setDisplayFacing(facing);
    }

    public @Nullable Direction getFacing(int index) {
        return states.get(index).getDisplayFacing();
    }

    public @Nullable BlockState getBlockState(int index) {
        return states.get(index).getBlockStateCache();
    }

    public @Nullable BlockEntity getBlockEntity(int index) {
        return states.get(index).getBlockEntityCache();
    }
}
