package nowebsite.maker.furnitureplan.common.block.cooking.utensils.entities.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.phys.Vec3;
import nowebsite.maker.furnitureplan.common.block.cooking.utensils.entities.GlassBBlockEntity;
import nowebsite.maker.furnitureplan.common.block.cooking.utensils.entities.renderer.state.GlassBBlockRendererState;
import nowebsite.maker.furnitureplan.utils.*;
import nowebsite.maker.furnitureplan.utils.uvmodel.CubeModel;
import nowebsite.maker.furnitureplan.utils.uvmodel.CubeRendererHelper;
import nowebsite.maker.furnitureplan.utils.uvmodel.FPCubeDefinition;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;
import org.jspecify.annotations.Nullable;

public class GlassBBlockEntityRenderer implements BlockEntityRenderer<@NotNull GlassBBlockEntity, @NotNull GlassBBlockRendererState> {
    public static final CubeModel POTION = new FPCubeDefinition()
        .model(6.501f, 0.2f, 6.501f, 2.998f, 7.0f, 2.998f)
        .north(6f, 4f, 9f, 11f, 0)
        .east(6f, 4f, 9f, 11f, 0)
        .south(6f, 4f, 9f, 11f, 0)
        .west(6f, 4f, 9f, 11f, 0)
        .up(6f, 1f, 9f, 4f, 90)
        .down(6f, 11f, 9f, 14f, 90)
        .build();

    private final TextureAtlasSprite textureSprite;
    public GlassBBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
        this.textureSprite = context.sprites().get(Sheets.BLOCKS_MAPPER.defaultNamespaceApply("water_still"));
    }

    @Override
    public GlassBBlockRendererState createRenderState() {
        return new GlassBBlockRendererState();
    }

    @Override
    public void extractRenderState(GlassBBlockEntity blockEntity, GlassBBlockRendererState state, float partialTicks, Vec3 cameraPosition, ModelFeatureRenderer.@Nullable CrumblingOverlay breakProgress) {
        BlockEntityRenderer.super.extractRenderState(blockEntity, state, partialTicks, cameraPosition, breakProgress);
        ItemStack stack = blockEntity.getPotionStack();
        if(!stack.is(Items.POTION)) {
            state.shouldRender = false;
            return;
        }
        Vector3f clr = GUIUtil.colorCast(stack.getOrDefault(DataComponents.POTION_CONTENTS, PotionContents.EMPTY).getColor());
        state.r = clr.x;
        state.g = clr.y;
        state.b = clr.z;
        state.a = 0.6f;
        state.shouldRender = true;
    }

    @Override
    public void submit(GlassBBlockRendererState state, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, CameraRenderState camera) {
        if (!state.shouldRender) return;
        poseStack.pushPose();
        submitNodeCollector.submitCustomGeometry(
            poseStack, RenderTypes.entityTranslucent(textureSprite.atlasLocation()),
            (pose, buffer) -> CubeRendererHelper.renderWithColor(POTION, textureSprite.wrap(buffer), pose, state.r, state.g, state.b, state.a, state.lightCoords, OverlayTexture.NO_OVERLAY)
        );
        poseStack.popPose();
    }
}
