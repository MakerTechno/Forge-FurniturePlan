package nowebsite.maker.furnitureplan.blocks.tableware.blockentities.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;
import nowebsite.maker.furnitureplan.blocks.tableware.blockentities.GlassBBlockEntity;
import nowebsite.maker.furnitureplan.utils.Couple;
import nowebsite.maker.furnitureplan.utils.GUIUtil;
import org.jetbrains.annotations.NotNull;
import org.joml.AxisAngle4f;
import org.joml.Quaternionf;
import org.joml.Vector3f;

public class GlassBBlockEntityRenderer implements BlockEntityRenderer<GlassBBlockEntity> {
    @SuppressWarnings("all")
    public static final Couple<Vec3, Vec3, Quaternionf>[] rots = new Couple[] {
            Couple.of(Vec3.ZERO.add(0.40625,0,0.40625), new Vec3(0.5f, 1.0666f, 0.5f), new Quaternionf()),//side
            Couple.of(Vec3.ZERO.add(0.40625,0,0.59375), new Vec3(0.5f, 1.0666f, 0.5f), new Quaternionf(new AxisAngle4f((float) (Math.PI/2),0,1,0))),//side
            Couple.of(Vec3.ZERO.add(0.59375,0,0.59375), new Vec3(0.5f, 1.0666f, 0.5f), new Quaternionf(new AxisAngle4f((float) (Math.PI),0,1,0))),//side
            Couple.of(Vec3.ZERO.add(0.59375,0,0.40625), new Vec3(0.5f, 1.0666f, 0.5f), new Quaternionf(new AxisAngle4f(-(float) (Math.PI/2),0,1,0))), //side
            Couple.of(Vec3.ZERO.add(0.40625, 0.4, 0.40625), new Vec3(0.5f, 0.5f, 0.5f), new Quaternionf(new AxisAngle4f((float) (Math.PI/2),1,0,0))),//top
            Couple.of(Vec3.ZERO.add(0.40625,0.00003,0.59375), new Vec3(0.5f, 0.5f, 0.5f), new Quaternionf(new AxisAngle4f(-(float) (Math.PI/2),1,0,0)))//bottom
    };
    @Override
    public void render(@NotNull GlassBBlockEntity blockEntity, float partialTick, @NotNull PoseStack poseStack, @NotNull MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        ItemStack stack = blockEntity.getPotionStack();
        if(!stack.is(Items.POTION)) return;

        TextureAtlasSprite sprite = Minecraft.getInstance().getModelManager().getAtlas(InventoryMenu.BLOCK_ATLAS).getSprite(TextureMapping.getBlockTexture(Blocks.WHITE_CONCRETE));
        Vector3f clr = GUIUtil.colorCast(PotionUtils.getColor(stack));

        poseStack.pushPose();
        VertexConsumer builder = bufferSource.getBuffer(RenderType.translucent());

        float alpha = 0.6f;
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
