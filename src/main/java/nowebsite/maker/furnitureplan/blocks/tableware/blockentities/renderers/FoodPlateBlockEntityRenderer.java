package nowebsite.maker.furnitureplan.blocks.tableware.blockentities.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import nowebsite.maker.furnitureplan.blocks.tableware.FoodPlateAndGlassAndCutleryBlock;
import nowebsite.maker.furnitureplan.blocks.tableware.blockentities.FoodPlateBlockEntity;
import nowebsite.maker.furnitureplan.utils.Couple;
import org.jetbrains.annotations.NotNull;
import org.joml.AxisAngle4f;
import org.joml.Quaternionf;

public class FoodPlateBlockEntityRenderer implements BlockEntityRenderer<FoodPlateBlockEntity> {
    @SuppressWarnings("all")
    public static final Couple<Vec3, Vec3, Quaternionf>[] rots=new Couple[] {
        Couple.of(Vec3.ZERO.add(0.40625,0,0.40625), new Vec3(0.5f, 1.0666f, 0.5f), new Quaternionf()),//side
        Couple.of(Vec3.ZERO.add(0.40625,0,0.59375), new Vec3(0.5f, 1.0666f, 0.5f), new Quaternionf(new AxisAngle4f((float) (Math.PI/2),0,1,0))),//side
        Couple.of(Vec3.ZERO.add(0.59375,0,0.59375), new Vec3(0.5f, 1.0666f, 0.5f), new Quaternionf(new AxisAngle4f((float) (Math.PI),0,1,0))),//side
        Couple.of(Vec3.ZERO.add(0.59375,0,0.40625), new Vec3(0.5f, 1.0666f, 0.5f), new Quaternionf(new AxisAngle4f(-(float) (Math.PI/2),0,1,0))), //side
        Couple.of(Vec3.ZERO.add(0.40625, 0.4, 0.40625), new Vec3(0.5f, 0.5f, 0.5f), new Quaternionf(new AxisAngle4f((float) (Math.PI/2),1,0,0))),//top
        Couple.of(Vec3.ZERO.add(0.40625,0.00003,-0.40625), new Vec3(0.5f, 0.5f, 0.5f), new Quaternionf(new AxisAngle4f(-(float) (Math.PI/2),1,0,0)))//bottom
    };
    @Override
    public void render(@NotNull FoodPlateBlockEntity blockEntity, float partialTick, @NotNull PoseStack poseStack, @NotNull MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        /*Food render*/
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        ItemStack stack = blockEntity.getFoodStack();
        poseStack.pushPose();
        poseStack.translate(0.5f, 0.05f, 0.5f);
        poseStack.scale(0.5f, 0.5f, 0.5f);
        poseStack.mulPose(Axis.XP.rotationDegrees(90.0F));
        switch (blockEntity.getBlockState().getValue(FoodPlateAndGlassAndCutleryBlock.FACING)){
            case NORTH -> poseStack.mulPose(Axis.ZP.rotationDegrees(0));
            case EAST -> poseStack.mulPose(Axis.ZP.rotationDegrees(90));
            case SOUTH -> poseStack.mulPose(Axis.ZP.rotationDegrees(180));
            case WEST -> poseStack.mulPose(Axis.ZP.rotationDegrees(270));
        }
        itemRenderer.renderStatic(stack, ItemDisplayContext.FIXED, packedLight, packedOverlay, poseStack, bufferSource, blockEntity.getLevel(), 1);
        poseStack.popPose();
    }
}
