package nowebsite.maker.furnitureplan.common.block.storaging.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentSerialization;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Container;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.Nameable;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.ChestLidController;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.neoforged.neoforge.network.PacketDistributor;
import nowebsite.maker.furnitureplan.common.block.storaging.container.DrawerContainer;
import nowebsite.maker.furnitureplan.common.block.storaging.container.OpensCounterUtil;
import nowebsite.maker.furnitureplan.common.block.storaging.gui.DrawerMenu;
import nowebsite.maker.furnitureplan.common.init.FPBlockReg;
import nowebsite.maker.furnitureplan.networks.CupboardSyncData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class CupboardBlockEntity extends BlockEntity implements MenuProvider, Nameable {
    @Nullable
    private Component name;
    private final Set<LivingEntity>
            usingDrawer1 = new HashSet<>(),
            usingDrawer2 = new HashSet<>(),
            usingDrawer3 = new HashSet<>();
    public final DrawerContainer
            drawer1 = new DrawerContainer(9, this),
            drawer2 = new DrawerContainer(9, this),
            drawer3 = new DrawerContainer(12, this);
    public final OpensCounterUtil counter = new OpensCounterUtil() {
        @Override
        public boolean isOwnContainer(@NotNull Player player) {
            if (!(player.containerMenu instanceof DrawerMenu)) {
                return false;
            } else {
                Container container = ((DrawerMenu)player.containerMenu).getContainer();
                return container instanceof DrawerContainer;
            }
        }
    };
    /*--------Animate part--------*/
    private final ChestLidController  //We use Chest's controller, so I needn't create a new one.
            controller1 = new ChestLidController(),
            controller2 = new ChestLidController(),
            controller3 = new ChestLidController();
    public void animateTick() {
        this.controller1.tickLid();
        this.controller2.tickLid();
        this.controller3.tickLid();
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
    public void addUsingD1Player(LivingEntity entity){
        usingDrawer1.add(entity);
        markUpdated();
    }
    /**Warnings: only call ON SERVER SIDE*/
    public void addUsingD2Player(LivingEntity entity){
        usingDrawer2.add(entity);
        markUpdated();
    }
    /**Warnings: only call ON SERVER SIDE*/
    public void addUsingD3Player(LivingEntity entity){
        usingDrawer3.add(entity);
        markUpdated();
    }
    /**Warnings: only call ON SERVER SIDE*/
    public void removeUsingD1Player(LivingEntity entity){
        usingDrawer1.remove(entity);
        markUpdated();
    }
    /**Warnings: only call ON SERVER SIDE*/
    public void removeUsingD2Player(LivingEntity entity){
        usingDrawer2.remove(entity);
        markUpdated();
    }
    /**Warnings: only call ON SERVER SIDE*/
    public void removeUsingD3Player(LivingEntity entity){
        usingDrawer3.remove(entity);
        markUpdated();
    }
    public CupboardBlockEntity(BlockPos pPos, BlockState pBlockState) {
        this(FPBlockReg.CUPBOARD_BLOCK_ENTITY.get(), pPos, pBlockState);
    }


    @Override
    protected void loadAdditional(ValueInput input) {
        super.loadAdditional(input);
        this.name = BlockEntity.parseCustomNameSafe(input, "CustomName");
        drawer1.loadFromBlockEntity(input.child(DrawerContainer.TAG_NAME + 1).orElse(null));
        drawer2.loadFromBlockEntity(input.child(DrawerContainer.TAG_NAME + 2).orElse(null));
        drawer3.loadFromBlockEntity(input.child(DrawerContainer.TAG_NAME + 3).orElse(null));
    }

    @Override
    protected void saveAdditional(ValueOutput output) {
        super.saveAdditional(output);
        output.storeNullable("CustomName", ComponentSerialization.CODEC, this.name);
        drawer1.saveAdditionalFromBlockEntity(output.child(DrawerContainer.TAG_NAME + 1));
        drawer2.saveAdditionalFromBlockEntity(output.child(DrawerContainer.TAG_NAME + 2));
        drawer3.saveAdditionalFromBlockEntity(output.child(DrawerContainer.TAG_NAME + 3));
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
    public Packet<@NotNull ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public @NotNull CompoundTag getUpdateTag(HolderLookup.@NotNull Provider registries) {
        return saveWithoutMetadata(registries);
    }

    @Override
    public void preRemoveSideEffects(BlockPos pos, BlockState state) {
        super.preRemoveSideEffects(pos, state);
        if (level == null) return;
        Containers.dropContents(level, pos, this.drawer1);
        Containers.dropContents(level, pos, this.drawer2);
        Containers.dropContents(level, pos, this.drawer3);
    }
}
