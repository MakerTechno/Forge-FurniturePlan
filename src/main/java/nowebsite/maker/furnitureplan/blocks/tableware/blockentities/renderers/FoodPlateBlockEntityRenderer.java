package nowebsite.maker.furnitureplan.blocks.tableware.blockentities.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.Direction;
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;
import nowebsite.maker.furnitureplan.blocks.tableware.FoodPlateBlock;
import nowebsite.maker.furnitureplan.blocks.tableware.blockentities.FoodPlateBlockEntity;
import nowebsite.maker.furnitureplan.utils.Couple;
import nowebsite.maker.furnitureplan.utils.GUIUtil;
import org.jetbrains.annotations.NotNull;
import org.joml.AxisAngle4f;
import org.joml.Quaternionf;
import org.joml.Vector3f;

public class FoodPlateBlockEntityRenderer implements BlockEntityRenderer<FoodPlateBlockEntity> {
    @SuppressWarnings("all")
    public static final Couple<Vec3, Vec3, Quaternionf>[] rots=new Couple[] {
        Couple.of(Vec3.ZERO.add(0.40625,0,0.40625), new Vec3(0.5f, 1.0666f, 0.5f), new Quaternionf()),//side
        Couple.of(Vec3.ZERO.add(0.40625,0,0.59375), new Vec3(0.5f, 1.0666f, 0.5f), new Quaternionf(new AxisAngle4f((float) (Math.PI/2),0,1,0))),//side
        Couple.of(Vec3.ZERO.add(0.59375,0,0.59375), new Vec3(0.5f, 1.0666f, 0.5f), new Quaternionf(new AxisAngle4f((float) (Math.PI),0,1,0))),//side
        Couple.of(Vec3.ZERO.add(0.59375,0,0.40625), new Vec3(0.5f, 1.0666f, 0.5f), new Quaternionf(new AxisAngle4f(-(float) (Math.PI/2),0,1,0))), //side
        Couple.of(Vec3.ZERO.add(0.40625, 0.4, 0.40625), new Vec3(0.5f, 0.5f, 0.5f), new Quaternionf(new AxisAngle4f((float) (Math.PI/2),1,0,0))),//top
        Couple.of(Vec3.ZERO.add(0.40625,0.00003,0.59375), new Vec3(0.5f, 0.5f, 0.5f), new Quaternionf(new AxisAngle4f(-(float) (Math.PI/2),1,0,0)))//bottom
    };
    @Override
    public void render(@NotNull FoodPlateBlockEntity blockEntity, float partialTick, @NotNull PoseStack poseStack, @NotNull MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        /*Food render*/
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        ItemStack stack = blockEntity.getFoodStack();
        Direction facing = blockEntity.getBlockState().getValue(FoodPlateBlock.FACING);
        poseStack.pushPose();
        poseStack.translate(0.5f, 0.05f, 0.5f);
        poseStack.scale(0.5f, 0.5f, 0.5f);
        poseStack.mulPose(Axis.XP.rotationDegrees(90.0F));
        switch (facing){
            case NORTH -> poseStack.mulPose(Axis.ZP.rotationDegrees(0));
            case EAST -> poseStack.mulPose(Axis.ZP.rotationDegrees(90));
            case SOUTH -> poseStack.mulPose(Axis.ZP.rotationDegrees(180));
            case WEST -> poseStack.mulPose(Axis.ZP.rotationDegrees(270));
        }
        itemRenderer.renderStatic(stack, ItemDisplayContext.FIXED, packedLight, packedOverlay, poseStack, bufferSource, blockEntity.getLevel(), 1);
        poseStack.popPose();


        /*Fluid render*/
        ItemStack potionStack = blockEntity.getPotionStack();
        if(!potionStack.is(Items.POTION)) return;
        TextureAtlasSprite sprite = Minecraft.getInstance().getModelManager().getAtlas(InventoryMenu.BLOCK_ATLAS).getSprite(TextureMapping.getBlockTexture(Blocks.WHITE_CONCRETE));
        Vector3f clr = GUIUtil.colorCast(PotionUtils.getColor(potionStack));
        poseStack.pushPose();
        VertexConsumer builder = bufferSource.getBuffer(RenderType.translucent());
        switch (facing){
            case NORTH -> poseStack.translate(0.4472f, 0, 0.4152f);
            case EAST -> poseStack.translate(-0.241f, 0, 0.4472f);
            case SOUTH -> poseStack.translate(-0.272f, 0, -0.241f);
            case WEST -> poseStack.translate(0.4152f, 0, -0.272f);
        }
        poseStack.scale(0.825f, 0.8f, 0.825f);

        float alpha = 0.8f;
        for(Couple<Vec3, Vec3, Quaternionf> p : rots) {
            poseStack.pushPose();
            poseStack.translate(p.first().x, p.first().y, p.first().z);
            poseStack.mulPose(p.third());//rotate
            poseStack.scale((float) p.second().x, (float) p.second().y, (float) p.second().z);
            GUIUtil.drawTexturedColoredRect(
                    builder, poseStack, 0, 0, 3/8f, 3/8f,
                    clr.x(), clr.y(), clr.z(), alpha,
                    sprite.getU0(), sprite.getU1(), sprite.getV0(), sprite.getV1(),
                    packedLight, packedOverlay
            );
            poseStack.popPose();
        }
        poseStack.popPose();
    }
}
