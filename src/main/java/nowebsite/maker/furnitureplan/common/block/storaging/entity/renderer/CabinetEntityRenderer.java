package nowebsite.maker.furnitureplan.common.block.storaging.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.sprite.SpriteGetter;
import net.minecraft.world.phys.Vec3;
import nowebsite.maker.furnitureplan.common.block.abstraction.set.FPBlockSetType;
import nowebsite.maker.furnitureplan.common.block.storaging.CabinetBlock;
import nowebsite.maker.furnitureplan.common.block.storaging.entity.CabinetBlockEntity;
import nowebsite.maker.furnitureplan.common.block.storaging.entity.renderer.state.CabinetBlockRenderState;
import nowebsite.maker.furnitureplan.common.init.FPBlockSetTypes;
import nowebsite.maker.furnitureplan.utils.uvmodel.CubeModel;
import nowebsite.maker.furnitureplan.utils.uvmodel.CubeRendererHelper;
import nowebsite.maker.furnitureplan.utils.uvmodel.FPCubeDefinition;
import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.Nullable;

public class CabinetEntityRenderer implements BlockEntityRenderer<@NotNull CabinetBlockEntity, @NotNull CabinetBlockRenderState> {
    public static final CubeModel DOOR = new FPCubeDefinition()
        .model(1.001f, 1.001f, 0.101f, 13.998f, 13.998f, 0.998f)
        .north(1f, 1f, 15f, 15f,0)
        .east(1f, 1f, 2f, 15f,0)
        .south(15f, 1f, 1f, 15f,0)
        .west(14f, 1f, 15f, 15f,0)
        .up(15f, 1f, 1f, 2f,0)
        .down(15f, 14f, 1f, 15f,0)
        .build();
    public static final CubeModel HANDLE = new FPCubeDefinition()
        .model(12f, 7f, 0f, 2f, 2f, 0.1f)
        .north(0f, 0f, 2f, 2f,0)
        .east(0f, 0f, 0.1f, 2f,0)
        .west(0f, 0f, 0.1f, 2f,0)
        .up(0f, 0f, 2f, 0.1f,0)
        .down(0f, 0f, 2f, 0.1f,0)
        .build();

    private final SpriteGetter textureSource;
    public CabinetEntityRenderer(BlockEntityRendererProvider.Context context) {
        this.textureSource = context.sprites();
    }

    @Override
    public CabinetBlockRenderState createRenderState() {
        return new CabinetBlockRenderState();
    }

    @Override
    public void extractRenderState(CabinetBlockEntity blockEntity, CabinetBlockRenderState state, float partialTicks, Vec3 cameraPosition, ModelFeatureRenderer.@Nullable CrumblingOverlay breakProgress) {
        BlockEntityRenderer.super.extractRenderState(blockEntity, state, partialTicks, cameraPosition, breakProgress);
        FPBlockSetType frameType = ((CabinetBlock)blockEntity.getBlockState().getBlock()).getFrameType();
        if (frameType == null) {
            state.shouldRender = false;
            return;
        }
        state.yRot = blockEntity.getBlockState().getValue(CabinetBlock.FACING).toYRot()+180;
        state.openness = (float) (1 - Math.pow(1 - blockEntity.getOpenness(partialTicks), 3)) * 90;
        FPBlockSetType mainType = ((CabinetBlock)blockEntity.getBlockState().getBlock()).getType();
        state.doorSprite = textureSource.get(Sheets.BLOCKS_MAPPER.defaultNamespaceApply(mainType.getTexture().getPath().split("/")[1]));
        state.handleSprite = textureSource.get(Sheets.BLOCKS_MAPPER.defaultNamespaceApply(frameType.getTexture().getPath().split("/")[1]));
        state.shouldRender = true;
        state.needTranslucent = FPBlockSetTypes.isTranslucent(mainType);
    }

    @Override
    public void submit(CabinetBlockRenderState state, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, CameraRenderState camera) {
        if (!state.shouldRender) return;
        poseStack.pushPose();
        poseStack.translate(0.5, 0.5, 0.5);
        poseStack.mulPose(Axis.YP.rotationDegrees(-state.yRot));
        poseStack.translate(-0.5, -0.5, -0.5);
        poseStack.translate(0.0625, 0, 0);
        poseStack.mulPose(Axis.YP.rotationDegrees(state.openness));
        poseStack.translate(-0.0625, 0, 0);

        submitNodeCollector.submitCustomGeometry(
            poseStack,
            state.needTranslucent
                ? RenderTypes.entityTranslucent(state.doorSprite.atlasLocation())
                : RenderTypes.entityCutout(state.doorSprite.atlasLocation()),
            (pose, buffer) -> {
                CubeRendererHelper.render(DOOR, state.doorSprite.wrap(buffer), pose, state.lightCoords, OverlayTexture.NO_OVERLAY);
                CubeRendererHelper.render(HANDLE, state.handleSprite.wrap(buffer), pose, state.lightCoords, OverlayTexture.NO_OVERLAY);
            }
        );

        poseStack.popPose();
    }

    @Override
    public boolean shouldRenderOffScreen() {
        return true;
    }
}
