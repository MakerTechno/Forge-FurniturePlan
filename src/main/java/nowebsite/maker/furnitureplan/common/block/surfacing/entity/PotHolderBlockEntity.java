package nowebsite.maker.furnitureplan.common.block.surfacing.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.Containers;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.neoforged.neoforge.network.PacketDistributor;
import nowebsite.maker.furnitureplan.common.init.FPBlockReg;
import nowebsite.maker.furnitureplan.networks.PotHolderSyncData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class PotHolderBlockEntity extends BlockEntity implements Container {
    public static final String STORAGE_NAME = "inventory";

    public boolean havePotAt0, havePotAt1, havePotAt2;
    private final NonNullList<ItemStack> items = NonNullList.withSize(3, ItemStack.EMPTY);
    private BlockState state0 = Blocks.AIR.defaultBlockState(), state1 = Blocks.AIR.defaultBlockState(), state2 = Blocks.AIR.defaultBlockState();
    public PotHolderBlockEntity(BlockEntityType<@NotNull PotHolderBlockEntity> type, BlockPos pos, BlockState blockState) {
        super(type, pos, blockState);
    }
    public PotHolderBlockEntity(BlockPos pos, BlockState blockState) {
        this(FPBlockReg.POT_HOLDER_BLOCK_ENTITY.get(), pos, blockState);
    }
    private void markUpdated() {
        flushState();
        this.setChanged();
        Objects.requireNonNull(this.getLevel()).sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), 3);
    }
    public boolean hasPotAt(int index) {
        assert index < 3 && index >= 0;
        return index == 0 ? havePotAt0 : index == 1 ? havePotAt1 : havePotAt2;
    }
    public boolean setPotAt(int index, boolean has) {
        if (hasPlantAt(index)) return false;
        if (index == 0) {
            if (havePotAt0 == has) return false;
            havePotAt0 = has;
            if (has) setStateAt(0, Blocks.FLOWER_POT.defaultBlockState());
        }
        else if (index == 1) {
            if (havePotAt1 == has) return false;
            havePotAt1 = has;
            if (has) setStateAt(1, Blocks.FLOWER_POT.defaultBlockState());
        }
        else if (index == 2) {
            if (havePotAt2 == has) return false;
            havePotAt2 = has;
            if (has) setStateAt(2, Blocks.FLOWER_POT.defaultBlockState());
        }
        else throw new IndexOutOfBoundsException("Pot holder's index must be in [0,2] as a integer.");
        if (!has) setStateAt(index, Blocks.AIR.defaultBlockState());
        markUpdated();
        return true;
    }
    public BlockState getStateAt(int index) {
        return index == 0 ? state0 : index == 1 ? state1 :state2;
    }
    /**YOU SHOULDN'T CALL IT FOR CHANGE.*/
    public void setStateAt(int index, BlockState state) {
        if (index == 0) state0 = state;
        else if (index == 1) state1 = state;
        else if (index == 2) state2 = state;
        else throw new IndexOutOfBoundsException("Pot holder's index must be in [0,2] as a integer.");
    }
    public void flushState() {
        for (int i = 0; i < 3; i++) {
            if (hasPotAt(i)) {
                if (hasPlantAt(i)) {
                    BlockItem plant = (BlockItem) items.get(i).getItem();
                    FlowerPotBlock potBlock = (FlowerPotBlock) Blocks.FLOWER_POT;
                    BlockState state = potBlock.getEmptyPot().getFullPotsView().getOrDefault(
                        BuiltInRegistries.BLOCK.getKey(plant.getBlock()),
                        () -> Blocks.AIR
                    ).get().defaultBlockState();
                    if (state.isAir()) {
                        items.set(i, ItemStack.EMPTY);
                        setStateAt(i, Blocks.AIR.defaultBlockState());
                    }
                    else setStateAt(i, state);
                } else {
                    setStateAt(i, Blocks.FLOWER_POT.defaultBlockState());
                }
            } else {
                setStateAt(i, Blocks.AIR.defaultBlockState());
            }
        }
        if (level != null && !level.isClientSide())
            syncS2C();
    }
    public boolean hasPlantAt(int index) {
        return ! getPlantAt(index).isEmpty();
    }
    public ItemStack getPlantAt(int index) {
        return items.get(index);
    }
    public boolean setPlantAt(int index, @Nullable BlockItem plant) {
        if (!hasPotAt(index) || hasPlantAt(index)) return false;
        return setPlant(index, plant);
    }
    private boolean setPlant(int index, @Nullable BlockItem plant) {
        if (plant == null) {
            items.set(index, ItemStack.EMPTY);
        } else {
            FlowerPotBlock potBlock = (FlowerPotBlock) Blocks.FLOWER_POT;
            BlockState state = potBlock.getEmptyPot().getFullPotsView().getOrDefault(BuiltInRegistries.BLOCK.getKey(plant.getBlock()), () -> Blocks.AIR).get().defaultBlockState();
            if (state.isAir()) return false;
            items.set(index, new ItemStack(plant));
        }
        markUpdated();
        return true;
    }
    public boolean tryDropSth(int index){
        boolean hasPlant = hasPlantAt(index), hasPot = hasPotAt(index);
        if (!hasPot) {
            setPlantAt(index, null);
            return false;
        }
        SimpleContainer inventory = new SimpleContainer(1);
        if (hasPlant) {
            inventory.setItem(0, getPlantAt(index));
            setPlant(index, null);
        } else {
            inventory.setItem(0, Items.FLOWER_POT.getDefaultInstance());
            setPotAt(index, false);
        }
        Containers.dropContents(Objects.requireNonNull(this.getLevel()), this.worldPosition, inventory);
        return true;
    }
    @Override
    public void preRemoveSideEffects(@NotNull BlockPos pos, @NotNull BlockState state) {
        if (this.getLevel() != null) dropAll();
    }
    public void dropAll() {
        SimpleContainer inventory = new SimpleContainer(6);
        for (int i = 0; i < 3; i++) {
            inventory.setItem(i, items.get(i));
            inventory.setItem(i + 3, hasPotAt(i) ? Items.FLOWER_POT.getDefaultInstance() : ItemStack.EMPTY);
            setPlant(i, null);
            setPotAt(i, false);
        }
        Containers.dropContents(Objects.requireNonNull(this.getLevel()), this.worldPosition, inventory);
    }
    private void syncS2C(){
        PacketDistributor.sendToAllPlayers(
            new PotHolderSyncData(
                this.worldPosition.getCenter().toVector3f(),
                state0,
                state1,
                state2
            )
        );
    }

    @Override
    protected void saveAdditional(ValueOutput output) {
        super.saveAdditional(output);
        ContainerHelper.saveAllItems(output, this.items, true);
        output.putBoolean(STORAGE_NAME + "p0", havePotAt0);
        output.putBoolean(STORAGE_NAME + "p1", havePotAt1);
        output.putBoolean(STORAGE_NAME + "p2", havePotAt2);
    }

    @Override
    protected void loadAdditional(ValueInput input) {
        super.loadAdditional(input);
        this.items.clear();
        ContainerHelper.loadAllItems(input, this.items);
        havePotAt0 = input.getBooleanOr(STORAGE_NAME + "p0", false);
        havePotAt1 = input.getBooleanOr(STORAGE_NAME + "p1", false);
        havePotAt2 = input.getBooleanOr(STORAGE_NAME + "p2", false);
        flushState();
    }

    @Override
    public Packet<@NotNull ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        return saveWithoutMetadata(registries);
    }

    @Override
    public int getContainerSize() {
        return 6;
    }

    @Override
    public boolean isEmpty() {
        return this.items.isEmpty() && !this.havePotAt0 && !this.havePotAt1 && !this.havePotAt2;
    }

    @Override
    public ItemStack getItem(int slot) {
        return slot > 2 ? getPlantAt(slot - 3)
            : hasPlantAt(slot) ? Items.FLOWER_POT.getDefaultInstance() : ItemStack.EMPTY;
    }

    @Override
    public ItemStack removeItem(int slot, int count) {
        if (slot > 2) return ContainerHelper.removeItem(items, slot - 3, count);
        else if (hasPotAt(slot)) {
            setPotAt(slot, false);
            return Items.FLOWER_POT.getDefaultInstance();
        }
        return ItemStack.EMPTY;
    }

    @Override
    public ItemStack removeItemNoUpdate(int slot) {
        if (slot > 2) return ContainerHelper.takeItem(this.items, slot - 3);
        else if (hasPotAt(slot)) {
            setPotAt(slot, false);
            return Items.FLOWER_POT.getDefaultInstance();
        }
        return ItemStack.EMPTY;
    }

    @Override
    public void setItem(int slot, ItemStack itemStack) {
        if (itemStack.getItem() instanceof BlockItem blockItem) {
            if (slot > 2) setPlantAt(slot - 3, blockItem);
            else if (itemStack.is(Items.FLOWER_POT)) setPotAt(slot, true);
        } else if (itemStack.isEmpty()) {
            if (slot > 2) setPlant(slot - 3, null);
            else setPotAt(slot, false);
        }
    }

    @Override
    public boolean stillValid(Player player) {
        return Container.stillValidBlockEntity(this, player);
    }

    @Override
    public void clearContent() {
        for (int i = 0; i < 3; i++) {
            ContainerHelper.removeItem(this.items, i, 1);
            setPotAt(i, false);
        }
    }
}
