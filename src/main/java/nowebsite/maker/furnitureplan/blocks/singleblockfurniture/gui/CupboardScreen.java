package nowebsite.maker.furnitureplan.blocks.singleblockfurniture.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.MenuAccess;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import nowebsite.maker.furnitureplan.FurniturePlan;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
public class CupboardScreen extends AbstractContainerScreen<DrawerMenu> implements MenuAccess<DrawerMenu> {
    private static final ResourceLocation LOCATION = ResourceLocation.fromNamespaceAndPath(FurniturePlan.MOD_ID, "textures/gui/container/cupboard.png");
    private final int containerRows;
    public CupboardScreen(DrawerMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
        this.containerRows = pMenu.getRowCount();
        this.imageHeight = 114 + this.containerRows * 18;
        this.inventoryLabelY = this.imageHeight - 96;
    }

    @Override
    protected void renderBg(@NotNull GuiGraphics guiGraphics, float particleTick, int mouseX, int mouseY) {
        RenderSystem.setShaderTexture(0, LOCATION);
        int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;
        guiGraphics.blit(LOCATION, i, j, 0, 0, this.imageWidth, this.containerRows * 18 + 17);
        guiGraphics.blit(LOCATION, i, j + this.containerRows * 18 + 17, 0, 54, this.imageWidth, 96);
    }

    @Override
    public void render(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        this.renderBackground(guiGraphics, mouseX, mouseY, partialTick);
        super.render(guiGraphics, mouseX, mouseY, partialTick);
        this.renderTooltip(guiGraphics, mouseX, mouseY);
    }

}
