package nowebsite.maker.furnitureplan.blocks.singleblockfurniture.blockentities;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.Connection;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Container;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.Nameable;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.ChestLidController;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.util.Lazy;
import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.wrapper.CombinedInvWrapper;
import net.neoforged.neoforge.items.wrapper.InvWrapper;
import net.neoforged.neoforge.network.PacketDistributor;
import nowebsite.maker.furnitureplan.blocks.singleblockfurniture.blockentities.container.DrawerContainer;
import nowebsite.maker.furnitureplan.blocks.singleblockfurniture.blockentities.container.OpensCounterUtil;
import nowebsite.maker.furnitureplan.blocks.singleblockfurniture.gui.DrawerMenu;
import nowebsite.maker.furnitureplan.networks.CupboardSyncData;
import nowebsite.maker.furnitureplan.registry.BlockRegistration;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class CupboardBlockEntity extends BlockEntity implements MenuProvider, Nameable {
    @Nullable
    private Component name;
    private final Set<Player>
            usingDrawer1 = new HashSet<>(),
            usingDrawer2 = new HashSet<>(),
            usingDrawer3 = new HashSet<>();
    public final DrawerContainer
            drawer1 = new DrawerContainer(9, this),
            drawer2 = new DrawerContainer(9, this),
            drawer3 = new DrawerContainer(12, this);
    public final OpensCounterUtil counter = new OpensCounterUtil() {
        @Override
        protected boolean isOwnContainer(@NotNull Player player) {
            if (!(player.containerMenu instanceof DrawerMenu)) {
                return false;
            } else {
                Container container = ((DrawerMenu)player.containerMenu).getContainer();
                return container instanceof DrawerContainer;
            }
        }
    };
    private Lazy<IItemHandlerModifiable> handlerLazy = Lazy.of(() -> new CombinedInvWrapper(new InvWrapper(drawer1), new InvWrapper(drawer2), new InvWrapper(drawer3)));
    /*--------Animate part--------*/
    private final ChestLidController  //We use Chest's controller, so I needn't create a new one.
            controller1 = new ChestLidController(),
            controller2 = new ChestLidController(),
            controller3 = new ChestLidController();
    public static void animateTick(Level ignore, BlockPos ignore1, BlockState ignore2, @NotNull CupboardBlockEntity pBlockEntity) {
        pBlockEntity.controller1.tickLid();
        pBlockEntity.controller2.tickLid();
        pBlockEntity.controller3.tickLid();
    }
    public void drawer1ShouldBeOpen(boolean shouldOpen){
        this.controller1.shouldBeOpen(shouldOpen);
    }
    public void drawer2ShouldBeOpen(boolean shouldOpen){
        this.controller2.shouldBeOpen(shouldOpen);
    }
    public void drawer3ShouldBeOpen(boolean shouldOpen){
        this.controller3.shouldBeOpen(shouldOpen);
    }

    public float getOpenness(int index, float pPartialTicks) {
        return switch (index){
            case 0 -> this.controller1.getOpenness(pPartialTicks);
            case 1 -> this.controller2.getOpenness(pPartialTicks);
            case 2 -> this.controller3.getOpenness(pPartialTicks);
            default -> -1;
        };
    }
    public CupboardBlockEntity(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState) {
        super(pType, pPos, pBlockState);
    }

    /**Warnings: only call ON SERVER SIDE*/
    public void addUsingD1Player(Player player){
        usingDrawer1.add(player);
        markUpdated();
    }
    /**Warnings: only call ON SERVER SIDE*/
    public void addUsingD2Player(Player player){
        usingDrawer2.add(player);
        markUpdated();
    }
    /**Warnings: only call ON SERVER SIDE*/
    public void addUsingD3Player(Player player){
        usingDrawer3.add(player);
        markUpdated();
    }
    /**Warnings: only call ON SERVER SIDE*/
    public void removeUsingD1Player(Player player){
        usingDrawer1.remove(player);
        markUpdated();
    }
    /**Warnings: only call ON SERVER SIDE*/
    public void removeUsingD2Player(Player player){
        usingDrawer2.remove(player);
        markUpdated();
    }
    /**Warnings: only call ON SERVER SIDE*/
    public void removeUsingD3Player(Player player){
        usingDrawer3.remove(player);
        markUpdated();
    }
    public CupboardBlockEntity(BlockPos pPos, BlockState pBlockState) {
        this(BlockRegistration.CUPBOARD_BLOCK_ENTITY.get(), pPos, pBlockState);
    }
    public Block getBlockRef(){
        return BlockRegistration.CUPBOARD_BLOCK.get();
    }

    public Lazy<IItemHandlerModifiable> createHandler() {
        return handlerLazy;
    }
    @Override
    public void onLoad() {
        super.onLoad();
        handlerLazy = Lazy.of(() -> new CombinedInvWrapper(new InvWrapper(drawer1), new InvWrapper(drawer2), new InvWrapper(drawer3)));
    }
    @Override
    protected void loadAdditional(@NotNull CompoundTag tag, HolderLookup.@NotNull Provider registries) {
        super.loadAdditional(tag, registries);
        ListTag listTag = (ListTag) tag.get(DrawerContainer.TAG_NAME);
        if (listTag != null) {
            drawer1.loadFromBlockEntity(listTag.getCompound(0), registries);
            drawer2.loadFromBlockEntity(listTag.getCompound(1), registries);
            drawer3.loadFromBlockEntity(listTag.getCompound(2), registries);
        }
    }
    @Override
    protected void saveAdditional(@NotNull CompoundTag tag, HolderLookup.@NotNull Provider registries) {
        super.saveAdditional(tag, registries);
        ListTag listTag = new ListTag();
        listTag.add(drawer1.saveAdditionalFromBlockEntity(registries));
        listTag.add(drawer2.saveAdditionalFromBlockEntity(registries));
        listTag.add(drawer3.saveAdditionalFromBlockEntity(registries));
        tag.put(DrawerContainer.TAG_NAME, listTag);
        if (this.name != null) {
            tag.putString("CustomName", Component.Serializer.toJson(this.name, registries));
        }
    }
    public void setCustomName(Component pName) {
        this.name = pName;
    }
    @Override
    public @NotNull Component getName() {
        return this.name != null ? this.name : this.getDisplayName();
    }
    @Override
    public @NotNull Component getDisplayName() {
        return Component.translatable("block.furnitureplan.cupboard_block");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, @NotNull Inventory pPlayerInventory, @NotNull Player pPlayer) {
        Player player = pPlayerInventory.player;
        if (usingDrawer1.contains(player)) return DrawerMenu.oneRow(pContainerId, pPlayerInventory, this.drawer1);
        else if (usingDrawer2.contains(player)) return DrawerMenu.oneRow(pContainerId, pPlayerInventory, this.drawer2);
        else if (usingDrawer3.contains(player)) return  DrawerMenu.twoRows(pContainerId, pPlayerInventory, this.drawer3);
        else return null;
    }
    public void recheckOpen() {
        if (!this.remove) {
            this.counter.recheckOpeners(Objects.requireNonNull(this.getLevel()), this.getBlockPos(), this.getBlockState());
        }
    }
    private void markUpdated(){
        this.setChanged();
        Objects.requireNonNull(this.getLevel()).sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), 3);
        syncS2C();
    }
    public void syncS2C(){
        PacketDistributor.sendToAllPlayers(new CupboardSyncData(worldPosition.getCenter().toVector3f(), !usingDrawer1.isEmpty(), !usingDrawer2.isEmpty(), !usingDrawer3.isEmpty()));
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
