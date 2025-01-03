package nowebsite.maker.furnitureplan.blocks.multiaffected.blockentities.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.core.Direction;
import net.minecraft.world.phys.Vec3;
import nowebsite.maker.furnitureplan.blocks.multiaffected.PotHolder;
import nowebsite.maker.furnitureplan.blocks.multiaffected.blockentities.PotHolderBlockEntity;
import org.jetbrains.annotations.NotNull;
import org.joml.Quaternionf;

import java.util.List;

public class PotHolderBlockEntityRenderer implements BlockEntityRenderer<PotHolderBlockEntity> {
    private static final float scale = .6f;
    public static final List<Vec3> locations = List.of(
        new Vec3(0, .46875/scale, .203125/scale),
        new Vec3(0, .84375/scale, -.265625/scale),
        new Vec3(0, .53125/scale, -.046875/scale)
    );
    @SuppressWarnings("deprecation")
    @Override
    public void render(@NotNull PotHolderBlockEntity blockEntity, float partialTick, @NotNull PoseStack poseStack, @NotNull MultiBufferSource buffer, int packedLight, int packedOverlay) {
        BlockRenderDispatcher dispatcher = Minecraft.getInstance().getBlockRenderer();
        poseStack.pushPose();
        poseStack.scale(scale, scale, scale);
        poseStack.translate((1-scale)/2/scale, 0, (1-scale)/2/scale);
        Direction facing = blockEntity.getBlockState().getValue(PotHolder.FACING);
        Quaternionf rotateContext;
        switch (facing) {
            case EAST -> rotateContext = Axis.YP.rotationDegrees(90);
            case SOUTH -> rotateContext = Axis.YP.rotationDegrees(0);
            case WEST -> rotateContext = Axis.YP.rotationDegrees(270);
            default -> rotateContext = Axis.YP.rotationDegrees(180);
        }
        for (int i = 0; i < 3; i++) {
            poseStack.pushPose();
            Vec3 nowPos = locations.get(i);
            poseStack.translate(nowPos.x, nowPos.y, nowPos.z);
            poseStack.rotateAround(rotateContext, (float) (.5-nowPos.x), (float) (.5-nowPos.y), (float) (.5-nowPos.z));
            poseStack.rotateAround(Axis.YP.rotationDegrees(90*i), .5f, .5f, .5f);
            dispatcher.renderSingleBlock(blockEntity.getStateAt(i), poseStack, buffer, packedLight, packedOverlay);
            poseStack.popPose();
        }
        poseStack.popPose();
    }
}
