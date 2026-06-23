package nowebsite.maker.furnitureplan.common.block.storaging.gui;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.MenuAccess;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Inventory;
import nowebsite.maker.furnitureplan.FurniturePlan;
import org.jetbrains.annotations.NotNull;

public class CupboardScreen extends AbstractContainerScreen<@NotNull DrawerMenu> implements MenuAccess<@NotNull DrawerMenu> {
    private static final Identifier LOCATION = Identifier.fromNamespaceAndPath(FurniturePlan.MOD_ID, "textures/gui/container/cupboard.png");
    private final int containerRows;
    public CupboardScreen(DrawerMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle, 176, 114 + pMenu.getRowCount() * 18);
        this.containerRows = pMenu.getRowCount();
        this.inventoryLabelY = this.imageHeight - 96;
    }

    @Override
    public void extractBackground(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float a) {
        super.extractBackground(graphics, mouseX, mouseY, a);
        int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;
        graphics.blit(RenderPipelines.GUI_TEXTURED, LOCATION, i, j, 0F, 0F, this.imageWidth, this.containerRows * 18 + 17, 256, 256);
        graphics.blit(RenderPipelines.GUI_TEXTURED, LOCATION, i, j + this.containerRows * 18 + 17, 0F, 54F, this.imageWidth, 96, 256, 256);
    }

}
