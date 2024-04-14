package nowebsite.maker.furnitureplan.blocks.singleblockfurniture.blockentities.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import nowebsite.maker.furnitureplan.blocks.singleblockfurniture.blockentities.VaseBBlockEntity;
import org.jetbrains.annotations.NotNull;

public class VaseBBlockEntityRenderer implements BlockEntityRenderer<VaseBBlockEntity> {
    @Override
    public void render(@NotNull VaseBBlockEntity blockEntity, float partialTick, @NotNull PoseStack poseStack, @NotNull MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        /*Food render*/
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        ItemStack stack = blockEntity.getFlowerStack();
        poseStack.pushPose();
        poseStack.translate(0.5f, 0.9f, 0.5f);
        poseStack.scale(0.4f, 0.4f, 0.4f);
        //poseStack.mulPose(Axis.XP.rotationDegrees(90.0F));
        itemRenderer.renderStatic(stack, ItemDisplayContext.FIXED, packedLight, packedOverlay, poseStack, bufferSource, blockEntity.getLevel(), 1);
        poseStack.popPose();
    }
}