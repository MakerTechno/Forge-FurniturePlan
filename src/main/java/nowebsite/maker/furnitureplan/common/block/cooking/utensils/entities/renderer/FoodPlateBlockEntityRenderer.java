package nowebsite.maker.furnitureplan.common.block.cooking.utensils.entities.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.item.ItemModelResolver;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.phys.Vec3;
import nowebsite.maker.furnitureplan.common.block.cooking.utensils.FoodPlateBlock;
import nowebsite.maker.furnitureplan.common.block.cooking.utensils.entities.FoodPlateBlockEntity;
import nowebsite.maker.furnitureplan.common.block.cooking.utensils.entities.renderer.state.FoodPlateBlockRenderState;
import nowebsite.maker.furnitureplan.utils.GUIUtil;
import nowebsite.maker.furnitureplan.utils.uvmodel.CubeModel;
import nowebsite.maker.furnitureplan.utils.uvmodel.CubeRendererHelper;
import nowebsite.maker.furnitureplan.utils.uvmodel.FPCubeDefinition;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;
import org.jspecify.annotations.Nullable;

public class FoodPlateBlockEntityRenderer implements BlockEntityRenderer<@NotNull FoodPlateBlockEntity, @NotNull FoodPlateBlockRenderState> {
    public static final CubeModel POTION = new FPCubeDefinition()
        .model(12.501f, 0.5f, 12.001f, 2.498f, 4.7016f, 2.498f)
        .north(2f, 1f, 3f, 2f, 0)
        .east(3f, 1f, 4f, 2f, 0)
        .south(3f, 2f, 4f, 3f, 0)
        .west(3f, 3f, 4f, 4f, 0)
        .up(0f, 0f, 1f, 1f, 0)
        .down(0f, 0f, 1f, 1f, 0)
        .build();

    private final ItemModelResolver resolver;
    private final TextureAtlasSprite textureSprite;
    public FoodPlateBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
        this.resolver = context.itemModelResolver();
        this.textureSprite = context.sprites().get(Sheets.BLOCKS_MAPPER.defaultNamespaceApply("water_still"));
    }

    @Override
    public FoodPlateBlockRenderState createRenderState() {
        return new FoodPlateBlockRenderState();
    }

    @Override
    public void extractRenderState(FoodPlateBlockEntity blockEntity, FoodPlateBlockRenderState state, float partialTicks, Vec3 cameraPosition, ModelFeatureRenderer.@Nullable CrumblingOverlay breakProgress) {
        BlockEntityRenderer.super.extractRenderState(blockEntity, state, partialTicks, cameraPosition, breakProgress);
        state.facing = blockEntity.getBlockState().getValue(FoodPlateBlock.FACING).toYRot() + 180;
        int seed = (int)blockEntity.getBlockPos().asLong();
        ItemStackRenderState itemState = new ItemStackRenderState();
        resolver.updateForTopItem(itemState, blockEntity.getFoodStack(), ItemDisplayContext.FIXED, blockEntity.getLevel(), null, seed);
        state.foodItem = itemState;
        ItemStack potion = blockEntity.getPotionStack();
        if(!potion.is(Items.POTION)) {
            state.shouldRender = false;
            return;
        }
        Vector3f clr = GUIUtil.colorCast(potion.getOrDefault(DataComponents.POTION_CONTENTS, PotionContents.EMPTY).getColor());
        state.r = clr.x;
        state.g = clr.y;
        state.b = clr.z;
        state.a = 0.6f;
        state.shouldRender = true;
    }

    @Override
    public void submit(FoodPlateBlockRenderState state, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, CameraRenderState camera) {
        /*Food render*/
        poseStack.pushPose();
        poseStack.translate(0.5f, 0.5f, 0.5f);
        poseStack.mulPose(Axis.YP.rotationDegrees(-state.facing));
        poseStack.translate(-0.5f, -0.5f, -0.5f);

        ItemStackRenderState itemState = state.foodItem;
        if (itemState != null && !itemState.isEmpty()) {
            poseStack.pushPose();
            poseStack.translate(0.5f, 0.05f, 0.5f);
            poseStack.scale(0.5f, 0.5f, 0.5f);
            poseStack.mulPose(Axis.XP.rotationDegrees(90.0F));
            itemState.submit(poseStack, submitNodeCollector, state.lightCoords, OverlayTexture.NO_OVERLAY, 0);
            poseStack.popPose();
        }
        if (!state.shouldRender) {
            poseStack.popPose();
            return;
        }

        submitNodeCollector.submitCustomGeometry(
            poseStack, RenderTypes.entityTranslucent(textureSprite.atlasLocation()),
            (pose, buffer) -> CubeRendererHelper.renderWithColor(POTION, textureSprite.wrap(buffer), pose, state.r, state.g, state.b, state.a, state.lightCoords, OverlayTexture.NO_OVERLAY)
        );
        poseStack.popPose();


    }
}
