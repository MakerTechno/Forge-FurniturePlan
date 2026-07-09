package nowebsite.maker.furnitureplan.common.block.storaging.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.sprite.SpriteGetter;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.Vec3;
import nowebsite.maker.furnitureplan.FurniturePlan;
import nowebsite.maker.furnitureplan.common.block.abstraction.set.FPBlockSetType;
import nowebsite.maker.furnitureplan.common.block.storaging.CupboardBlock;
import nowebsite.maker.furnitureplan.common.block.storaging.entity.CupboardBlockEntity;
import nowebsite.maker.furnitureplan.common.block.storaging.entity.renderer.state.CupboardBlockRendererState;
import nowebsite.maker.furnitureplan.common.init.FPBlockSetTypes;
import nowebsite.maker.furnitureplan.utils.uvmodel.CubeModel;
import nowebsite.maker.furnitureplan.utils.uvmodel.CubeRendererHelper;
import nowebsite.maker.furnitureplan.utils.uvmodel.FPCubeDefinition;
import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CupboardEntityRenderer implements BlockEntityRenderer<@NotNull CupboardBlockEntity, @NotNull CupboardBlockRendererState> {
    private static final Identifier HANDLER_TEXTURE = FurniturePlan.asResource("textures/block/cupboard_handler.png");
    private static final List<CubeModel> DRAWER_1 = new ArrayList<>();
    private static final CubeModel DRAWER_1_HANDLER;
    private static final List<CubeModel> DRAWER_2 = new ArrayList<>();
    private static final CubeModel DRAWER_2_HANDLER;
    private static final List<CubeModel> DRAWER_3 = new ArrayList<>();
    private static final CubeModel DRAWER_3_HANDLER;

    static {
        DRAWER_1.add(new FPCubeDefinition()
            .model(1.5f, 11.5f, 2.25f, 1.0f, 3.5f, 12.0f)
            .east(2f, 2f, 14f, 5f, 0)
            .south(14f, 2f, 15f, 5f, 0)
            .west(14f, 2f, 2f, 5f, 0)
            .up(14f, 1f, 2f, 2f, 90)
            .down(2f, 4f, 14f, 5f, 90)
            .build()
        );
        DRAWER_1.add(new FPCubeDefinition()
            .model(13.5f, 11.5f, 2.25f, 1.0f, 3.5f, 12.0f)
            .east(2f, 2f, 14f, 5f,0)
            .south(1f, 2f, 2f, 5f,0)
            .west(14f, 2f, 2f, 5f,0)
            .up(14f, 1f, 2f, 2f,90)
            .down(2f, 4f, 14f, 5f,90)
            .build()
        );
        DRAWER_1.add(new FPCubeDefinition()
            .model(2.5f, 11.5f, 13.25f, 11.0f, 3.5f, 1.0f)
            .north(2f, 2f, 14f, 5f,0)
            .south(14f, 2f, 2f, 5f,0)
            .up(14f, 3f, 2f, 2f,0)
            .down(14f, 5f, 2f, 4f,0)
            .build()
        );
        DRAWER_1.add(new FPCubeDefinition()
            .model(1.5f, 11.5f, 0.25f, 13.0f, 3.5f, 2.0f)
            .north(1f, 2f, 15f, 5f,0)
            .east(0f, 2f, 2f, 5f,0)
            .south(15f, 2f, 1f, 5f,0)
            .west(14f, 2f, 16f, 5f,0)
            .up(15f, 3f, 1f, 1f,0)
            .down(15f, 6f, 1f, 4f,0)
            .build()
        );
        DRAWER_1.add(new FPCubeDefinition()
            .model(2.5f, 11.5f, 2.25f, 11.0f, 1.0f, 11.0f)
            .up(2f, 2f, 14f, 14f,0)
            .down(2f, 14f, 14f, 2f,0)
            .build()
        );
        DRAWER_1_HANDLER = new FPCubeDefinition()
            .model(5.5f, 12.67f, 0.249f, 5.0f, 1.1500000000000004f, 0.0f)
            .north(0f, 0f, 5f, 1f,0)
            .build();

        DRAWER_2.add(new FPCubeDefinition()
            .model(1.5f, 7.5f, 2.25f, 1.0f, 3.5f, 12.0f)
            .east(2f, 6f, 14f, 9f,0)
            .south(14f, 6f, 15f, 9f,0)
            .west(14f, 6f, 2f, 9f,0)
            .up(14f, 5f, 2f, 6f,90)
            .down(2f, 8f, 14f, 9f,90)
            .build()
        );
        DRAWER_2.add(new FPCubeDefinition()
            .model(13.5f, 7.5f, 2.25f, 1.0f, 3.5f, 12.0f)
            .east(2f, 6f, 14f, 9f,0)
            .south(1f, 6f, 2f, 9f,0)
            .west(14f, 6f, 2f, 9f,0)
            .up(14f, 5f, 2f, 6f,90)
            .down(2f, 8f, 14f, 9f,90)
            .build()
        );
        DRAWER_2.add(new FPCubeDefinition()
            .model(2.5f, 7.5f, 13.25f, 11.0f, 3.5f, 1.0f)
            .north(2f, 6f, 14f, 9f,0)
            .south(14f, 6f, 2f, 9f,0)
            .up(14f, 7f, 2f, 6f,0)
            .down(14f, 9f, 2f, 8f,0)
            .build()
        );
        DRAWER_2.add(new FPCubeDefinition()
            .model(1.5f, 7.5f, 0.25f, 13.0f, 3.5f, 2.0f)
            .north(1f, 6f, 15f, 9f,0)
            .east(0f, 6f, 2f, 9f,0)
            .south(15f, 6f, 1f, 9f,0)
            .west(14f, 6f, 16f, 9f,0)
            .up(15f, 7f, 1f, 5f,0)
            .down(15f, 10f, 1f, 8f,0)
            .build()
        );
        DRAWER_2.add(new FPCubeDefinition()
            .model(2.5f, 7.5f, 2.25f, 11.0f, 1.0f, 11.0f)
            .up(2f, 2f, 14f, 14f,0)
            .down(2f, 14f, 14f, 2f,0)
            .build()
        );
        DRAWER_2_HANDLER = new FPCubeDefinition()
            .model(5.5f, 8.68f, 0.249f, 5.0f, 1.1600000000000001f, 0.0f)
            .north(0f, 0f, 5f, 1f,0)
            .build();

        DRAWER_3.add(new FPCubeDefinition()
            .model(1.5f, 3f, 2.25f, 1.0f, 4f, 12.0f)
            .east(2f, 10f, 14f, 14f,0)
            .south(14f, 10f, 15f, 14f,0)
            .west(14f, 10f, 2f, 14f,0)
            .up(14f, 9f, 2f, 10f,90)
            .down(2f, 13f, 14f, 14f,90)
            .build()
        );
        DRAWER_3.add(new FPCubeDefinition()
            .model(13.5f, 3f, 2.25f, 1.0f, 4f, 12.0f)
            .east(2f, 10f, 14f, 14f,0)
            .south(1f, 10f, 2f, 14f,0)
            .west(14f, 10f, 2f, 14f,0)
            .up(14f, 9f, 2f, 10f,90)
            .down(2f, 13f, 14f, 14f,90)
            .build()
        );
        DRAWER_3.add(new FPCubeDefinition()
            .model(2.5f, 3f, 13.25f, 11.0f, 4f, 1.0f)
            .north(2f, 10f, 14f, 14f,0)
            .south(14f, 10f, 2f, 14f,0)
            .up(14f, 11f, 2f, 10f,0)
            .down(14f, 14f, 2f, 13f,0)
            .build()
        );
        DRAWER_3.add(new FPCubeDefinition()
            .model(1.5f, 3f, 0.25f, 13.0f, 4f, 2.0f)
            .north(1f, 10f, 15f, 14f,0)
            .east(0f, 10f, 2f, 14f,0)
            .south(15f, 10f, 1f, 14f,0)
            .west(14f, 10f, 16f, 14f,0)
            .up(15f, 11f, 1f, 9f,0)
            .down(15f, 15f, 1f, 13f,0)
            .build()
        );
        DRAWER_3.add(new FPCubeDefinition()
            .model(2.5f, 3f, 2.25f, 11.0f, 1f, 11.0f)
            .up(2f, 2f, 14f, 14f,0)
            .down(2f, 14f, 14f, 2f,0)
            .build()
        );
        DRAWER_3_HANDLER = new FPCubeDefinition()
            .model(5.5f, 5f, 0.249f, 5.0f, 1f, 0.0f)
            .north(0f, 0f, 5f, 1f,0)
            .build();
    }

    private final SpriteGetter textureSource;
    public CupboardEntityRenderer(BlockEntityRendererProvider.Context context){
        this.textureSource = context.sprites();
    }

    @Override
    public CupboardBlockRendererState createRenderState() {
        return new CupboardBlockRendererState();
    }

    @Override
    public void extractRenderState(@NotNull CupboardBlockEntity blockEntity, @NotNull CupboardBlockRendererState state, float partialTicks, Vec3 cameraPosition, ModelFeatureRenderer.@Nullable CrumblingOverlay breakProgress) {
        BlockEntityRenderer.super.extractRenderState(blockEntity, state, partialTicks, cameraPosition, breakProgress);
        state.facing = blockEntity.getBlockState().getValue(BlockStateProperties.HORIZONTAL_FACING);
        FPBlockSetType type = ((CupboardBlock)blockEntity.getBlockState().getBlock()).getType();
        state.openness1 = (float) (1 - Math.pow(1 - blockEntity.getOpenness(0, partialTicks), 3)) * 0.7f;
        state.openness2 = (float) (1 - Math.pow(1 - blockEntity.getOpenness(1, partialTicks), 3)) * 0.7f;
        state.openness3 = (float) (1 - Math.pow(1 - blockEntity.getOpenness(2, partialTicks), 3)) * 0.7f;
        state.sprite = textureSource.get(Sheets.BLOCKS_MAPPER.defaultNamespaceApply(type.getTexture().getPath().split("/")[1]));
        state.needTransparent = FPBlockSetTypes.isTranslucent(type);
    }

    @Override
    public void submit(CupboardBlockRendererState state, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, CameraRenderState camera) {
        poseStack.pushPose();
        float f = state.facing.toYRot()+180;

        poseStack.translate(0.5D, 0.5D, 0.5D);
        poseStack.mulPose(Axis.YP.rotationDegrees(-f));
        poseStack.translate(-0.5D, -0.5D, -0.5D);
        renderDrawers(
            poseStack, submitNodeCollector,
            state.openness1,
            DRAWER_1, DRAWER_1_HANDLER,
            state.sprite,
            state.lightCoords, state.needTransparent
        );
        renderDrawers(
            poseStack, submitNodeCollector,
            state.openness2,
            DRAWER_2, DRAWER_2_HANDLER,
            state.sprite,
            state.lightCoords, state.needTransparent
        );
        renderDrawers(
            poseStack, submitNodeCollector,
            state.openness3,
            DRAWER_3, DRAWER_3_HANDLER,
            state.sprite,
            state.lightCoords, state.needTransparent
        );
        poseStack.popPose();
    }

    private static void renderDrawers(
        PoseStack poseStack, SubmitNodeCollector submitNodeCollector,
        float openess,
        List<CubeModel> models, CubeModel handler,
        TextureAtlasSprite textureBase,
        int lightCoords, boolean needTranslucent
    ) {
        poseStack.pushPose();
        poseStack.translate(0, 0, -openess);
        models.forEach(model ->
            submitNodeCollector.submitCustomGeometry(
                poseStack,
                needTranslucent
                    ? RenderTypes.entityTranslucent(textureBase.atlasLocation())
                    : RenderTypes.entityCutout(textureBase.atlasLocation()),
                (pose, buffer) -> renderPart(model, pose, buffer, textureBase, lightCoords)
            )
        );
        submitNodeCollector.submitCustomGeometry(
            poseStack,
            RenderTypes.entityCutout(HANDLER_TEXTURE),
            (pose, buffer) -> renderPart(handler, pose, buffer, lightCoords)
        );
        poseStack.popPose();
    }

    private static void renderPart(
        CubeModel model,
        PoseStack.Pose pose,
        VertexConsumer builder,
        int light
    ) {
        CubeRendererHelper.render(model, builder, pose, light, OverlayTexture.NO_OVERLAY);
    }

    private static void renderPart(
        CubeModel model,
        PoseStack.Pose pose,
        VertexConsumer builder,
        TextureAtlasSprite sprite,
        int light
    ) {
        CubeRendererHelper.render(model, sprite.wrap(builder), pose, light, OverlayTexture.NO_OVERLAY);
    }

}
