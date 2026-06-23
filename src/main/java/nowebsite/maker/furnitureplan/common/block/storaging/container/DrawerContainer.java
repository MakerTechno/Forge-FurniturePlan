package nowebsite.maker.furnitureplan.common.block.storaging.container;

import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.*;
import net.minecraft.world.entity.ContainerUser;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import nowebsite.maker.furnitureplan.common.block.storaging.entity.CupboardBlockEntity;
import nowebsite.maker.furnitureplan.common.block.storaging.gui.DrawerMenu;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class DrawerContainer extends SimpleContainer implements MenuProvider, Nameable {
    public static final String TAG_NAME = "DrawerContainer";
    public static final String INVENTORY = "Inventory";
    private LockCode lockKey = LockCode.NO_LOCK;
    private final CupboardBlockEntity entitySelf;
    public DrawerContainer(int containerSize, CupboardBlockEntity entitySelf){
        super(containerSize);
        this.entitySelf = entitySelf;
    }

    @Override
    public Component getName() {
        return this.getDisplayName();
    }

    @Override
    public Component getDisplayName() {
        return entitySelf.getName();
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return canUnlock(pPlayer, this.lockKey, this.getDisplayName()) ? this.createMenu(pContainerId, pPlayerInventory) : null;
    }

    public AbstractContainerMenu createMenu(int pId, Inventory pPlayer){
        return this.getContainerSize() > 9 ? DrawerMenu.oneRow(pId, pPlayer) : DrawerMenu.twoRows(pId, pPlayer);
    }

    @Override
    public void startOpen(ContainerUser user) {
        if (!entitySelf.isRemoved() && !user.getLivingEntity().isSpectator()) {
            entitySelf.counter.incrementOpeners(user.getLivingEntity(), Objects.requireNonNull(entitySelf.getLevel()), entitySelf.getBlockPos(), entitySelf.getBlockState(), user.getContainerInteractionRange());
        }

    }

    @Override
    public void stopOpen(ContainerUser user) {
        if (!entitySelf.isRemoved() && !user.getLivingEntity().isSpectator()) {
            entitySelf.counter.decrementOpeners(user.getLivingEntity(), Objects.requireNonNull(entitySelf.getLevel()), entitySelf.getBlockPos(), entitySelf.getBlockState());
            if (!entitySelf.getLevel().isClientSide()){
                if (this == entitySelf.drawer1) entitySelf.removeUsingD1Player(user.getLivingEntity());
                if (this == entitySelf.drawer2) entitySelf.removeUsingD2Player(user.getLivingEntity());
                if (this == entitySelf.drawer3) entitySelf.removeUsingD3Player(user.getLivingEntity());
            }
        }

    }



    public void loadFromBlockEntity(@Nullable ValueInput input){
        if (input == null) return;
        this.lockKey = LockCode.fromTag(input);
        ContainerHelper.loadAllItems(input, this.getItems());
    }

    public void saveAdditionalFromBlockEntity(ValueOutput output){
        this.lockKey.addToTag(output);
        ContainerHelper.saveAllItems(output, this.getItems());
    }

    public static boolean canUnlock(Player player, LockCode code, Component displayName) {
        if (!player.isSpectator() && !code.unlocksWith(player.getMainHandItem())) {
            BaseContainerBlockEntity.sendChestLockedNotifications(player.position(), player, displayName);
            player.playSound(SoundEvents.CHEST_LOCKED, 1.0F, 1.0F);
            return false;
        } else {
            return true;
        }
    }
}
