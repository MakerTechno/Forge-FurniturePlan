package nowebsite.maker.furnitureplan.common.block.surfacing.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.block.BlockModelRenderState;
import net.minecraft.client.renderer.block.BlockModelResolver;
import net.minecraft.client.renderer.block.model.BlockDisplayContext;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.Vec3;
import nowebsite.maker.furnitureplan.common.block.surfacing.entity.PotHolderBlockEntity;
import nowebsite.maker.furnitureplan.common.block.surfacing.entity.renderer.state.PotHolderBlockEntityRenderState;
import org.jetbrains.annotations.NotNull;
import org.joml.Quaternionf;
import org.jspecify.annotations.Nullable;

import java.util.List;

public class PotHolderBlockEntityRenderer implements BlockEntityRenderer<@NotNull PotHolderBlockEntity, @NotNull PotHolderBlockEntityRenderState> {
    public static final BlockDisplayContext BLOCK_DISPLAY_CONTEXT = BlockDisplayContext.create();
    private static final float scale = .6f;
    public static final List<Vec3> locations = List.of(
        new Vec3(0, .46875/scale, .203125/scale),
        new Vec3(0, .84375/scale, -.265625/scale),
        new Vec3(0, .53125/scale, -.046875/scale)
    );

    public BlockModelResolver resolver;

    public PotHolderBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
        this.resolver = context.blockModelResolver();
    }

    @Override
    public PotHolderBlockEntityRenderState createRenderState() {
        return new PotHolderBlockEntityRenderState();
    }

    @Override
    public void extractRenderState(@NotNull PotHolderBlockEntity blockEntity, @NotNull PotHolderBlockEntityRenderState state, float partialTicks, Vec3 cameraPosition, ModelFeatureRenderer.@Nullable CrumblingOverlay breakProgress) {
        BlockEntityRenderer.super.extractRenderState(blockEntity, state, partialTicks, cameraPosition, breakProgress);
        state.facing = blockEntity.getBlockState().getValue(BlockStateProperties.HORIZONTAL_FACING);
        state.blockModelStates = new BlockModelRenderState[3];
        for (int i = 0; i < 3; i++) {
            BlockModelRenderState innerSave = new BlockModelRenderState();
            this.resolver.update(innerSave, blockEntity.getStateAt(i), BLOCK_DISPLAY_CONTEXT);
            state.blockModelStates[i] = innerSave;
        }
    }

    @Override
    public void submit(PotHolderBlockEntityRenderState state, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, CameraRenderState camera) {
        poseStack.pushPose();
        poseStack.scale(scale, scale, scale);
        poseStack.translate((1-scale)/2/scale, 0, (1-scale)/2/scale);
        Direction facing = state.facing;
        Quaternionf rotateContext;
        switch (facing) {
            case EAST -> rotateContext = Axis.YP.rotationDegrees(90);
            case SOUTH -> rotateContext = Axis.YP.rotationDegrees(0);
            case WEST -> rotateContext = Axis.YP.rotationDegrees(270);
            default -> rotateContext = Axis.YP.rotationDegrees(180);
        }
        for (int i = 0; i < 3; i++) {
            if (state.blockModelStates[i] != null) {
                poseStack.pushPose();
                Vec3 nowPos = locations.get(i);
                poseStack.translate(nowPos.x, nowPos.y, nowPos.z);
                poseStack.rotateAround(rotateContext, (float) (.5 - nowPos.x), (float) (.5 - nowPos.y), (float) (.5 - nowPos.z));
                poseStack.rotateAround(Axis.YP.rotationDegrees(90 * i), .5f, .5f, .5f);
                state.blockModelStates[i].submit(poseStack, submitNodeCollector, state.lightCoords, OverlayTexture.NO_OVERLAY, 0);
                poseStack.popPose();
            }
        }
        poseStack.popPose();
    }


}
