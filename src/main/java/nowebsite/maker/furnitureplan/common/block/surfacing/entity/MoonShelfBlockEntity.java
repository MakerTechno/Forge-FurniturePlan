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
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.storage.TagValueOutput;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import nowebsite.maker.furnitureplan.FurniturePlan;
import nowebsite.maker.furnitureplan.common.block.surfacing.MoonShelfBlock;
import nowebsite.maker.furnitureplan.common.init.FPBlockReg;
import nowebsite.maker.furnitureplan.utils.DirectionWithSlot;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MoonShelfBlockEntity extends BlockEntity implements Container {
    public static final String FACING_STORAGE = "Facings";
    /*
    * Ordered sorted in one block & for all blocks
    * 1 2 3
    * 4 5 6
    * 7 8 9
    */
    private final NonNullList<ItemStack> items = NonNullList.withSize(22, ItemStack.EMPTY);
    private final NonNullList<BlockState> blockStateCaches = NonNullList.withSize(22, Blocks.AIR.defaultBlockState());
    private final List<BlockEntity> blockEntityCaches = new ArrayList<>(22);
    private final List<Direction> itemFacing = new ArrayList<>(22);
    public boolean clientUpdated = false;
    public MoonShelfBlockEntity(BlockPos worldPosition, BlockState blockState) {
        super(FPBlockReg.MOON_SHELF_BLOCK_ENTITY.get(), worldPosition, blockState);
        for (int i = 0; i < 22; i++) {
            blockEntityCaches.add(null);
            itemFacing.add(null);
        }
    }
    private void markUpdated() {
        this.setChanged();
        Objects.requireNonNull(this.getLevel()).sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), 3);
    }

    public boolean putItem(ItemStack item, int index) {
        if (index < 0 || index > 21) return false;
        if (!items.get(index).isEmpty()) return false;
        items.set(index, item.split(1));
        markUpdated();
        return true;
    }

    public boolean tryRotate(int index) {
        if (index < 0 || index > 21) return false;
        if (items.get(index).isEmpty()) return false;
        Direction last = itemFacing.get(index);
        itemFacing.set(index, last == null ? getBlockState().getValue(MoonShelfBlock.FACING).getClockWise() : last.getClockWise());
        markUpdated();
        return true;
    }

    public boolean dropItem(int index) {
        if (index < 0 || index > 21) return false;
        if (items.get(index).isEmpty()) return false;
        SimpleContainer inventory = new SimpleContainer(1);
        inventory.setItem(0, items.get(index));
        Containers.dropContents(Objects.requireNonNull(this.getLevel()), this.worldPosition, inventory);
        items.set(index, ItemStack.EMPTY);
        markUpdated();
        return true;
    }

    @Override
    public int getContainerSize() {
        return 22;
    }

    @Override
    public boolean isEmpty() {
        return items.isEmpty() || items.stream().allMatch(ItemStack::isEmpty);
    }

    public ItemStack getItem(int index) {
        return items.get(index);
    }

    @Override
    public ItemStack removeItem(int slot, int count) {
        ItemStack stack = items.get(slot);
        items.set(slot, ItemStack.EMPTY);
        markUpdated();
        return stack;
    }

    @Override
    public ItemStack removeItemNoUpdate(int slot) {
        ItemStack stack = items.get(slot);
        items.set(slot, ItemStack.EMPTY);
        return stack;
    }

    @Override
    public void setItem(int slot, ItemStack itemStack) {
        items.set(slot, itemStack.split(1));
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
        items.clear();
        ContainerHelper.loadAllItems(input, items);

        for (DirectionWithSlot facing : input.listOrEmpty(FACING_STORAGE, DirectionWithSlot.CODEC)) {
            if (facing.isValidInContainer(itemFacing.size()) && facing.direction() != Direction.UP) {
                itemFacing.set(facing.slot(), facing.direction());
            }
        }
        genStateCaches();
    }

    @Override
    protected void saveAdditional(ValueOutput output) {
        super.saveAdditional(output);
        ContainerHelper.saveAllItems(output, items);
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
            ContainerHelper.saveAllItems(output, items);
            ValueOutput.TypedOutputList<DirectionWithSlot> facingList = output.list(FACING_STORAGE, DirectionWithSlot.CODEC);
            for (int i = 0; i < 22; i++) {
                Direction facing = itemFacing.get(i);
                if (facing != null) facingList.add(new DirectionWithSlot(i, facing));
            }
            tag = output.buildResult();
        }
        return tag;
    }

    public void genStateCaches() {
        if (level == null || !level.isClientSide()) return;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).isEmpty() || !(items.get(i).getItem() instanceof BlockItem blockItem)) {
                blockStateCaches.set(i, Blocks.AIR.defaultBlockState());
                continue;
            }
            BlockState state = blockItem.getBlock().defaultBlockState();
            Direction defaultFacing = getBlockState().getValue(BlockStateProperties.HORIZONTAL_FACING);
            @Nullable Direction adjusted = itemFacing.get(i);
            if (state.getProperties().contains(BlockStateProperties.FACING)) {
                state = state.setValue(BlockStateProperties.FACING,  adjusted == null ? defaultFacing : adjusted);
            } else if (state.getProperties().contains(BlockStateProperties.HORIZONTAL_FACING)) {
                state = state.setValue(BlockStateProperties.HORIZONTAL_FACING, adjusted == null ? defaultFacing : adjusted);
            }

            if (state.getBlock() instanceof EntityBlock entityBlock) {
                BlockEntity toRend = entityBlock.newBlockEntity(getBlockPos(), state);
                blockEntityCaches.set(i, toRend); // also nullable
            }

            blockStateCaches.set(i, state);
        }
        clientUpdated = true;
    }

    public NonNullList<ItemStack> getItems() {
        return items;
    }

    public NonNullList<BlockState> getBlockStateCaches() {
        return blockStateCaches;
    }

    public List<BlockEntity> getBlockEntityCaches() {
        return blockEntityCaches;
    }

    public List<Direction> getItemFacing() {
        return itemFacing;
    }

    @Override
    public void clearContent() {
        items.clear();
    }
}
