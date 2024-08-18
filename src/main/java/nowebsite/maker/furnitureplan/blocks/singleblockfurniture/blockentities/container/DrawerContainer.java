package nowebsite.maker.furnitureplan.blocks.singleblockfurniture.blockentities.container;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.LockCode;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.Nameable;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import nowebsite.maker.furnitureplan.blocks.singleblockfurniture.blockentities.CupboardBlockEntity;
import nowebsite.maker.furnitureplan.blocks.singleblockfurniture.gui.DrawerMenu;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class DrawerContainer extends SimpleContainer implements MenuProvider, Nameable {
    public static final String TAG_NAME = "DrawerContainer";
    private LockCode lockKey = LockCode.NO_LOCK;
    private final CupboardBlockEntity entitySelf;
    public DrawerContainer(int containerSize, CupboardBlockEntity entitySelf){
        super(containerSize);
        this.entitySelf = entitySelf;
    }

    @Override
    public @NotNull Component getName() {
        return this.getDisplayName();
    }

    @Override
    public @NotNull Component getDisplayName() {
        return entitySelf.getName();
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, @NotNull Inventory pPlayerInventory, @NotNull Player pPlayer) {
        return BaseContainerBlockEntity.canUnlock(pPlayer, this.lockKey, this.getDisplayName()) ? this.createMenu(pContainerId, pPlayerInventory) : null;
    }

    public AbstractContainerMenu createMenu(int pId, Inventory pPlayer){
        return this.getContainerSize() > 9 ? DrawerMenu.oneRow(pId, pPlayer) : DrawerMenu.twoRows(pId, pPlayer);
    }

    public void startOpen(@NotNull Player pPlayer) {
        if (!entitySelf.isRemoved() && !pPlayer.isSpectator()) {
            entitySelf.counter.incrementOpeners(pPlayer, Objects.requireNonNull(entitySelf.getLevel()), entitySelf.getBlockPos(), entitySelf.getBlockState());
        }

    }

    public void stopOpen(@NotNull Player pPlayer) {
        if (!entitySelf.isRemoved() && !pPlayer.isSpectator()) {
            entitySelf.counter.decrementOpeners(pPlayer, Objects.requireNonNull(entitySelf.getLevel()), entitySelf.getBlockPos(), entitySelf.getBlockState());
            if (!entitySelf.getLevel().isClientSide){
                if (this == entitySelf.drawer1) entitySelf.removeUsingD1Player(pPlayer);
                if (this == entitySelf.drawer2) entitySelf.removeUsingD2Player(pPlayer);
                if (this == entitySelf.drawer3) entitySelf.removeUsingD3Player(pPlayer);

            }
        }

    }

    public void loadFromBlockEntity(CompoundTag pTag, int id){
        this.lockKey = LockCode.fromTag(pTag);
        this.fromTag((ListTag) Objects.requireNonNull(pTag.get(TAG_NAME + id)));
    }

    public void saveAdditionalFromBlockEntity(CompoundTag pTag, int id){
        this.lockKey.addToTag(pTag);
        pTag.put(TAG_NAME + id, this.createTag());
    }
}
