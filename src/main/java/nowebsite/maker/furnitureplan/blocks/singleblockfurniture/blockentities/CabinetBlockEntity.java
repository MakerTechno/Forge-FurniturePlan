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
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.ChestLidController;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.util.Lazy;
import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.wrapper.InvWrapper;
import net.neoforged.neoforge.network.PacketDistributor;
import nowebsite.maker.furnitureplan.blocks.singleblockfurniture.ColorfulBorderedCabinet;
import nowebsite.maker.furnitureplan.blocks.singleblockfurniture.blockentities.container.OpensCounterUtil;
import nowebsite.maker.furnitureplan.networks.CabinetSyncData;
import nowebsite.maker.furnitureplan.registry.kindsblock.cabinet.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static nowebsite.maker.furnitureplan.registry.kindsblock.cabinet.CabinetBlockRegistration.CABINET_BLOCK_ENTITY;

public class CabinetBlockEntity extends BlockEntity implements MenuProvider, Nameable {
    @Nullable
    private Component name;
    private final Set<Player> using = new HashSet<>();
    public final SimpleContainer container = new SimpleContainer(36){
        @Override
        public void startOpen(@NotNull Player player) {
            super.startOpen(player);
            if (!isRemoved() && !player.isSpectator()) {
                counter.incrementOpeners(player, Objects.requireNonNull(getLevel()), getBlockPos(), getBlockState());
            }
        }
        @Override
        public void stopOpen(@NotNull Player player) {
            super.stopOpen(player);

            if (!isRemoved() && !player.isSpectator()) {
                counter.decrementOpeners(player, Objects.requireNonNull(getLevel()), getBlockPos(), getBlockState());
                if (level != null && !level.isClientSide) removeUsingPlayer(player);
            }
        }
    };
    public final OpensCounterUtil counter = new OpensCounterUtil() {
        @Override
        protected boolean isOwnContainer(@NotNull Player player) {
            if (!(player.containerMenu instanceof ChestMenu)) {
                return false;
            } else {
                Container container = ((ChestMenu)player.containerMenu).getContainer();
                return container instanceof SimpleContainer;
            }
        }
    };
    private final ChestLidController controller = new ChestLidController();
    private Lazy<IItemHandlerModifiable> handlerLazy = Lazy.of(() -> new InvWrapper(container));

    public CabinetBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState blockState) {
        super(type, pos, blockState);
    }
    public CabinetBlockEntity(BlockPos pos, BlockState state) {
        this(state.getBlock() instanceof ColorfulBorderedCabinet cabinet? getColored(cabinet.getColorId()) : CABINET_BLOCK_ENTITY.get(), pos, state);
    }
    public static BlockEntityType<CabinetBlockEntity> getColored(int colorId){
        return switch (colorId) {
            case 0 -> BlackCabinetRegistration.BLACK_CABINET_BLOCK_ENTITY.get();
            case 1 -> BlueCabinetRegistration.BLUE_CABINET_BLOCK_ENTITY.get();
            case 2 -> BrownCabinetRegistration.BROWN_CABINET_BLOCK_ENTITY.get();
            case 3 -> CyanCabinetRegistration.CYAN_CABINET_BLOCK_ENTITY.get();
            case 4 -> GrayCabinetRegistration.GRAY_CABINET_BLOCK_ENTITY.get();
            case 5 -> GreenCabinetRegistration.GREEN_CABINET_BLOCK_ENTITY.get();
            case 6 -> LightBlueCabinetRegistration.LIGHT_BLUE_CABINET_BLOCK_ENTITY.get();
            case 7 -> LightGrayCabinetRegistration.LIGHT_GRAY_CABINET_BLOCK_ENTITY.get();
            case 8 -> LimeCabinetRegistration.LIME_CABINET_BLOCK_ENTITY.get();
            case 9 -> MagentaCabinetRegistration.MAGENTA_CABINET_BLOCK_ENTITY.get();
            case 10 -> OrangeCabinetRegistration.ORANGE_CABINET_BLOCK_ENTITY.get();
            case 11 -> PinkCabinetRegistration.PINK_CABINET_BLOCK_ENTITY.get();
            case 12 -> PurpleCabinetRegistration.PURPLE_CABINET_BLOCK_ENTITY.get();
            case 13 -> RedCabinetRegistration.RED_CABINET_BLOCK_ENTITY.get();
            case 14 -> YellowCabinetRegistration.YELLOW_CABINET_BLOCK_ENTITY.get();
            case 15 -> WhiteCabinetRegistration.WHITE_CABINET_BLOCK_ENTITY.get();
            default -> CABINET_BLOCK_ENTITY.get();
        };
    }
    public static void animateTick(Level ignore, BlockPos ignore1, BlockState ignore2, @NotNull CabinetBlockEntity blockEntity) {
        blockEntity.controller.tickLid();
    }
    public void shouldBeOpen(boolean shouldOpen) {
        this.controller.shouldBeOpen(shouldOpen);
    }
    public float getOpenness(float partialTicks) {
        return this.controller.getOpenness(partialTicks);
    }
    /**Warnings: only call ON SERVER SIDE*/
    public void addUsingPlayer(Player player){
        using.add(player);
        markUpdated();
    }
    /**Warnings: only call ON SERVER SIDE*/
    public void removeUsingPlayer(Player player){
        using.remove(player);
        markUpdated();
    }
    public Lazy<IItemHandlerModifiable> createHandler() {
        return handlerLazy;
    }
    @Override
    public void onLoad() {
        super.onLoad();
        handlerLazy = Lazy.of(() -> new InvWrapper(container));
    }
    public static final String INVENTORY = "inventory";
    @Override
    protected void loadAdditional(@NotNull CompoundTag tag, HolderLookup.@NotNull Provider registries) {
        super.loadAdditional(tag, registries);
        container.fromTag((ListTag) tag.get(INVENTORY), registries);
    }
    @Override
    protected void saveAdditional(@NotNull CompoundTag tag, HolderLookup.@NotNull Provider registries) {
        super.saveAdditional(tag, registries);
        tag.put(INVENTORY, container.createTag(registries));
        if (this.name != null) {
            tag.putString("CustomName", Component.Serializer.toJson(this.name, registries));
        }
    }
    public void setCustomName(Component pName) {
        this.name = pName;
    }
    @Override
    public @NotNull Component getName() {
        return this.name == null ? this.getDisplayName() : this.name;
    }

    @Override
    public @NotNull Component getDisplayName() {
        return Component.translatable(getBlockState().getBlock().getDescriptionId());
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int containerId, @NotNull Inventory playerInventory, @NotNull Player player) {
        return using.contains(player) ? new ChestMenu(MenuType.GENERIC_9x4, containerId, playerInventory, this.container, 4) : null;
    }
    public void recheckOpen() {
        if (!this.remove) {
            this.counter.recheckOpeners(Objects.requireNonNull(this.getLevel()), this.getBlockPos(), this.getBlockState());
        }
    }
    private void markUpdated() {
        this.setChanged();
        Objects.requireNonNull(this.getLevel()).sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), 3);
        syncS2C();
    }
    private void syncS2C(){
        PacketDistributor.sendToAllPlayers(new CabinetSyncData(worldPosition.getCenter().toVector3f(), !using.isEmpty()));
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
