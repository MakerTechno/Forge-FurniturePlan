package nowebsite.maker.furnitureplan.blocks.singleblockfurniture.blockentities.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.client.model.data.ModelData;
import nowebsite.maker.furnitureplan.blocks.singleblockfurniture.blockentities.VaseBBlockEntity;
import org.jetbrains.annotations.NotNull;

public class VaseBBlockEntityRenderer implements BlockEntityRenderer<VaseBBlockEntity> {
    @Override
    public void render(@NotNull VaseBBlockEntity blockEntity, float partialTick, @NotNull PoseStack poseStack, @NotNull MultiBufferSource bufferSource, int packedLight, int packedOverlay) {

        //poseStack.mulPose(Axis.XP.rotationDegrees(90.0F));

        Item item = blockEntity.getFlowerStack().getItem();
        BlockState state = item instanceof BlockItem?((BlockItem)item).getBlock().defaultBlockState():null;
        if (state == null) {
            if (!blockEntity.getFlowerStack().isEmpty()) {
                poseStack.pushPose();
                poseStack.translate(0.5f, 0.9f, 0.5f);
                poseStack.scale(0.4f, 0.4f, 0.4f);
                ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
                itemRenderer.renderStatic(blockEntity.getFlowerStack(), ItemDisplayContext.FIXED, packedLight, packedOverlay, poseStack, bufferSource, blockEntity.getLevel(), 1);
                poseStack.popPose();
            }
            return;
        }
        if (state.is(Blocks.AIR)) {
            return;
        }
        poseStack.pushPose();
        poseStack.translate(0.5f, 0.9f, 0.5f);
        poseStack.scale(0.4f, 0.4f, 0.4f);
        Minecraft.getInstance().getBlockRenderer().renderSingleBlock(state, poseStack, bufferSource, packedLight, packedOverlay, ModelData.EMPTY, RenderType.cutoutMipped());
        poseStack.popPose();
    }
}