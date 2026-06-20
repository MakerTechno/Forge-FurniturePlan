package nowebsite.maker.furnitureplan.common.block.cooking.utensils.entities.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.item.ItemModelResolver;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.phys.Vec3;
import nowebsite.maker.furnitureplan.common.block.cooking.utensils.IronPotBlock;
import nowebsite.maker.furnitureplan.common.block.cooking.utensils.entities.IronPotBlockEntity;
import nowebsite.maker.furnitureplan.common.block.cooking.utensils.entities.renderers.states.IronPotBlockRenderState;
import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.Nullable;

public class IronPotBlockEntityRenderer implements BlockEntityRenderer<@NotNull IronPotBlockEntity, @NotNull IronPotBlockRenderState> {
    private final ItemModelResolver resolver;

    public IronPotBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
        this.resolver = context.itemModelResolver();
    }

    @Override
    public IronPotBlockRenderState createRenderState() {
        return new IronPotBlockRenderState();
    }

    @Override
    public void extractRenderState(IronPotBlockEntity blockEntity, IronPotBlockRenderState state, float partialTicks, Vec3 cameraPosition, ModelFeatureRenderer.@Nullable CrumblingOverlay breakProgress) {
        BlockEntityRenderer.super.extractRenderState(blockEntity, state, partialTicks, cameraPosition, breakProgress);
        state.facing = blockEntity.getBlockState().getValue(IronPotBlock.FACING);
        int seed = (int)blockEntity.getBlockPos().asLong();
        ItemStackRenderState itemState = new ItemStackRenderState();
        resolver.updateForTopItem(itemState, blockEntity.getFoodStack(), ItemDisplayContext.FIXED, blockEntity.getLevel(), null, seed);
    }

    @Override
    public void submit(IronPotBlockRenderState state, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, CameraRenderState camera) {
        Direction facing = state.facing;
        ItemStackRenderState itemState = state.itemInPotState;
        if (itemState != null && !itemState.isEmpty()) {
            poseStack.pushPose();
            poseStack.translate(0.5f, 0.05f, 0.5f);
            poseStack.scale(0.7f, 0.5f, 0.7f);
            poseStack.mulPose(Axis.XP.rotationDegrees(90.0F));
            poseStack.mulPose(Axis.YP.rotationDegrees(-facing.toYRot()));
            itemState.submit(poseStack, submitNodeCollector, state.lightCoords, OverlayTexture.NO_OVERLAY, 0);
        }
    }
}
