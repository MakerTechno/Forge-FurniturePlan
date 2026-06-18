package nowebsite.maker.furnitureplan.blocks.singleblockfurniture.gui;

import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import nowebsite.maker.furnitureplan.registry.GUIRegistration;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DrawerMenu extends AbstractContainerMenu {
    /**The three containers for a cupboard. */
    private final Container container;
    private final int containerSize;
    private DrawerMenu(MenuType<?> pType, int pContainerId, Inventory pPlayerInventory, int pSize) {
        this(pType, pContainerId, pPlayerInventory, new SimpleContainer(pSize));
    }
    @Contract("_, _ -> new")
    public static @NotNull DrawerMenu oneRow(int pContainerId, Inventory pPlayerInventory) {
        return new DrawerMenu(GUIRegistration.DRAWER_MENU1.get(), pContainerId, pPlayerInventory, 9);
    }
    @Contract("_, _ -> new")
    public static @NotNull DrawerMenu twoRows(int pContainerId, Inventory pPlayerInventory) {
        return new DrawerMenu(GUIRegistration.DRAWER_MENU2.get(), pContainerId, pPlayerInventory, 12);
    }
    @Contract("_, _, _ -> new")
    public static @NotNull DrawerMenu oneRow(int pContainerId, Inventory pPlayerInventory, Container pContainer) {
        return new DrawerMenu(GUIRegistration.DRAWER_MENU1.get(), pContainerId, pPlayerInventory, pContainer);
    }
    @Contract("_, _, _ -> new")
    public static @NotNull DrawerMenu twoRows(int pContainerId, Inventory pPlayerInventory, Container pContainer) {
        return new DrawerMenu(GUIRegistration.DRAWER_MENU2.get(), pContainerId, pPlayerInventory, pContainer);
    }
    protected DrawerMenu(@Nullable MenuType<?> pMenuType, int pContainerId, Inventory pPlayerInv , Container openingContainer) {
        super(pMenuType, pContainerId);
        this.container = openingContainer;
        this.containerSize = container.getContainerSize();
        int containerRows = containerSize / 9 + (containerSize % 9 == 0 ? 0 : 1);

        container.startOpen(pPlayerInv.player);

        /*Add slots (what I expected to call "grids") to the showing GUI.*/
        /*Container's slots*/
        int i = (containerRows - 4) * 18;
        l1:for(int j = 0; j < containerRows; ++j) {
            for(int k = 0; k < 9; ++k) {
                if (j * 9 + k == containerSize) break l1;
                this.addSlot(new Slot(openingContainer, k + j * 9, 8 + k * 18, 18 + j * 18));
            }
        }
        /*Player's backpack slots*/
        for(int l = 0; l < 3; ++l) {
            for(int j1 = 0; j1 < 9; ++j1) {
                this.addSlot(new Slot(pPlayerInv, j1 + l * 9 + 9, 8 + j1 * 18, 103 + l * 18 + i));
            }
        }
        /*Player's fast stacks*/
        for(int i1 = 0; i1 < 9; ++i1) {
            this.addSlot(new Slot(pPlayerInv, i1, 8 + i1 * 18, 161 + i));
        }
    }

    @Override
    public @NotNull ItemStack quickMoveStack(@NotNull Player pPlayer, int pIndex) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(pIndex);
        if (slot != null && slot.hasItem()) { //do not reduce, copy from source code always has its points.
            ItemStack itemStack1 = slot.getItem();
            itemStack = itemStack1.copy();
            if (pIndex < this.containerSize) {
                if (!this.moveItemStackTo(itemStack1, this.containerSize, this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(itemStack1, 0, this.containerSize, false)) {
                return ItemStack.EMPTY;
            }

            if (itemStack1.isEmpty()) {
                slot.setByPlayer(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }

        return itemStack;
    }
    @Override
    public boolean stillValid(@NotNull Player pPlayer) {
        return container.stillValid(pPlayer);
    }
    public void removed(@NotNull Player pPlayer) {
        super.removed(pPlayer);
        this.container.stopOpen(pPlayer);
    }

    public Container getContainer() {
        return this.container;
    }

    public int getRowCount() {
        return this.containerSize / 9 + (this.containerSize % 9 == 0 ? 0 : 1);
    }
}
