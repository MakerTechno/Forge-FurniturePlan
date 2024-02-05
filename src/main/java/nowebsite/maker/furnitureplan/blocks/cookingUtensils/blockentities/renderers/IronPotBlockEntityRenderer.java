package nowebsite.maker.furnitureplan.blocks.cookingUtensils.blockentities.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import nowebsite.maker.furnitureplan.blocks.cookingUtensils.IronPotBlock;
import nowebsite.maker.furnitureplan.blocks.cookingUtensils.blockentities.IronPotBlockEntity;
import org.jetbrains.annotations.NotNull;

public class IronPotBlockEntityRenderer implements BlockEntityRenderer<IronPotBlockEntity> {
    @Override
    public void render(@NotNull IronPotBlockEntity blockEntity, float partialTick, @NotNull PoseStack poseStack, @NotNull MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        /*Food render*/
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        ItemStack stack = blockEntity.getFoodStack();
        poseStack.pushPose();
        poseStack.translate(0.5f, 0.05f, 0.5f);
        poseStack.scale(0.7f, 0.5f, 0.7f);
        poseStack.mulPose(Axis.XP.rotationDegrees(90.0F));
        switch (blockEntity.getBlockState().getValue(IronPotBlock.FACING)){
            case NORTH -> poseStack.mulPose(Axis.ZP.rotationDegrees(0));
            case EAST -> poseStack.mulPose(Axis.ZP.rotationDegrees(90));
            case SOUTH -> poseStack.mulPose(Axis.ZP.rotationDegrees(180));
            case WEST -> poseStack.mulPose(Axis.ZP.rotationDegrees(270));
        }
        itemRenderer.renderStatic(stack, ItemDisplayContext.FIXED, packedLight, packedOverlay, poseStack, bufferSource, blockEntity.getLevel(), 1);
        poseStack.popPose();
    }
}
