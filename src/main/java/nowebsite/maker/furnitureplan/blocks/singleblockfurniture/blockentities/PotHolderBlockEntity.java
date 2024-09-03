package nowebsite.maker.furnitureplan.blocks.singleblockfurniture.blockentities;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Containers;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.util.Lazy;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;
import net.neoforged.neoforge.network.PacketDistributor;
import nowebsite.maker.furnitureplan.networks.PotHolderSyncData;
import nowebsite.maker.furnitureplan.registry.kindsblock.PotHolderBlockRegistration;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class PotHolderBlockEntity extends BlockEntity {
    private final ItemStackHandler itemStackHandler = new ItemStackHandler(3){
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            if (level != null) {
                level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), Block.UPDATE_ALL);
            }
        }
        @Override
        public void setSize(int size) {
            super.setSize(3);
        }
    };
    public static final String INVENTORY = "inventory";
    public boolean havePotAt0, havePotAt1, havePotAt2;
    private Lazy<IItemHandler> lazyItemHandler = Lazy.of(() -> itemStackHandler);
    private BlockState state0 = Blocks.AIR.defaultBlockState(), state1 = Blocks.AIR.defaultBlockState(), state2 = Blocks.AIR.defaultBlockState();
    public PotHolderBlockEntity(BlockEntityType<PotHolderBlockEntity> type, BlockPos pos, BlockState blockState) {
        super(type, pos, blockState);
    }
    public PotHolderBlockEntity(BlockPos pos, BlockState blockState) {
        this(PotHolderBlockRegistration.POT_HOLDER_BLOCK_ENTITY.get(), pos, blockState);
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
                    BlockItem plant = (BlockItem) itemStackHandler.getStackInSlot(i).getItem();
                    FlowerPotBlock potBlock = (FlowerPotBlock) Blocks.FLOWER_POT;
                    BlockState state = potBlock.getEmptyPot().getFullPotsView().getOrDefault(
                        BuiltInRegistries.BLOCK.getKey(plant.getBlock()),
                        () -> Blocks.AIR
                    ).get().defaultBlockState();
                    if (state.isAir()) {
                        itemStackHandler.setStackInSlot(i, ItemStack.EMPTY);
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
        if (level != null && !level.isClientSide)
            syncS2C();
    }
    public boolean hasPlantAt(int index) {
        return ! getPlantAt(index).isEmpty();
    }
    public ItemStack getPlantAt(int index) {
        return itemStackHandler.getStackInSlot(index);
    }
    public boolean setPlantAt(int index, BlockItem plant) {
        if (!hasPotAt(index) || hasPlantAt(index)) return false;
        return setPlant(index, plant);
    }
    private boolean setPlant(int index, BlockItem plant) {
        if (plant == null) {
            itemStackHandler.setStackInSlot(index, ItemStack.EMPTY);
        } else {
            FlowerPotBlock potBlock = (FlowerPotBlock) Blocks.FLOWER_POT;
            BlockState state = potBlock.getEmptyPot().getFullPotsView().getOrDefault(net.minecraft.core.registries.BuiltInRegistries.BLOCK.getKey(plant.getBlock()), () -> Blocks.AIR).get().defaultBlockState();
            if (state.isAir()) return false;
            itemStackHandler.setStackInSlot(index, new ItemStack(plant));
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
    public void dropAll() {
        SimpleContainer inventory = new SimpleContainer(6);
        for (int i = 0; i < 3; i++) {
            inventory.setItem(i, itemStackHandler.getStackInSlot(i));
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
        tag.putBoolean(INVENTORY + "p0", havePotAt0);
        tag.putBoolean(INVENTORY + "p1", havePotAt1);
        tag.putBoolean(INVENTORY + "p2", havePotAt2);
        super.saveAdditional(tag, registries);
    }
    @Override
    protected void loadAdditional(@NotNull CompoundTag tag, HolderLookup.@NotNull Provider registries) {
        havePotAt0 = tag.getBoolean(INVENTORY + "p0");
        havePotAt1 = tag.getBoolean(INVENTORY + "p1");
        havePotAt2 = tag.getBoolean(INVENTORY + "p2");
        itemStackHandler.deserializeNBT(registries, tag.getCompound(INVENTORY));
        flushState();
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
