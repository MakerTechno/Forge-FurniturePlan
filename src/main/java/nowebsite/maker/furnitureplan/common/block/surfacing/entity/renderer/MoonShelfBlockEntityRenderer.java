package nowebsite.maker.furnitureplan.common.block.surfacing.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.block.BlockModelRenderState;
import net.minecraft.client.renderer.block.BlockModelResolver;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.item.ItemModelResolver;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import nowebsite.maker.furnitureplan.common.block.surfacing.MoonShelfBlock;
import nowebsite.maker.furnitureplan.common.block.surfacing.entity.MoonShelfBlockEntity;
import nowebsite.maker.furnitureplan.common.block.surfacing.entity.renderer.state.MoonShelfBlockEntityRenderState;
import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.Nullable;

import java.util.List;

public class MoonShelfBlockEntityRenderer implements BlockEntityRenderer<@NotNull MoonShelfBlockEntity, @NotNull MoonShelfBlockEntityRenderState> {
    private static final float SCALE_BLOCK = .26f;
    private static final float SCALE_ITEM = .33f;
    public static final List<Vec3> LOCATIONS = List.of(
        new Vec3(17.5/16f, 24/16f, 9/16f),
        new Vec3(24.25/16f, 19/16f, 9/16f),

        new Vec3(11.75/16f, 21/16f, 9/16f),
        new Vec3(4.25/16f, 21/16f, 9/16f),

        new Vec3(-2/16f, 24/16f, 9/16f),
        new Vec3(-8.5/16f, 19/16f, 9/16f),

        new Vec3(18/16f, 15/16f, 9/16f),
        new Vec3(26.5/16f, 8/16f, 9/16f),
        new Vec3(19/16f, 8/16f, 9/16f),
        new Vec3(20/16f, 2/16f, 9/16f),

        new Vec3(11.5/16f, 8/16f, 9/16f),
        new Vec3(3.25/16f, 8/16f, 9/16f),

        new Vec3(-2/16f, 15/16f, 9/16f),
        new Vec3(-4.5/16f, 8/16f, 9/16f),
        new Vec3(-11.75/16f, 8/16f, 9/16f),
        new Vec3(-4/16f, 2/16f, 9/16f),

        new Vec3(27/16f, -1/16f, 9/16f),
        new Vec3(19.5/16f, -7/16f, 9/16f),

        new Vec3(11.5/16f, -3/16f, 9/16f),
        new Vec3(4/16f, -3/16f, 9/16f),

        new Vec3(-11/16f, -1/16f, 9/16f),
        new Vec3(-4.25/16f, -7/16f, 9/16f)
    );

    private final BlockModelResolver blockModelResolver;
    private final BlockEntityRenderDispatcher dispatcher;
    private final ItemModelResolver itemModelResolver;


    public MoonShelfBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
        this.blockModelResolver = context.blockModelResolver();
        this.itemModelResolver = context.itemModelResolver();
        this.dispatcher = context.blockEntityRenderDispatcher();
    }

    @Override
    public MoonShelfBlockEntityRenderState createRenderState() {
        return new MoonShelfBlockEntityRenderState();
    }

    @Override
    public void extractRenderState(@NotNull MoonShelfBlockEntity blockEntity, @NotNull MoonShelfBlockEntityRenderState state, float partialTicks, Vec3 cameraPosition, ModelFeatureRenderer.@Nullable CrumblingOverlay breakProgress) {
        BlockEntityRenderer.super.extractRenderState(blockEntity, state, partialTicks, cameraPosition, breakProgress);
        state.yRot = blockEntity.getBlockState().getValue(MoonShelfBlock.FACING).toYRot() + 180;

        for (int i = 0; i < state.displays.size(); i++) {
            state.displays.get(i).extractDisplayState(
                (int) blockEntity.getBlockPos().asLong(), blockEntity.getLevel(), state.lightCoords, state.yRot,
                blockEntity.getPoweredItems().getState(i), blockEntity.getItem(i),
                itemModelResolver, blockModelResolver, dispatcher,
                partialTicks, cameraPosition, breakProgress
            );
        }
    }

    @Override
    public void submit(MoonShelfBlockEntityRenderState state, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, CameraRenderState camera) {
        poseStack.pushPose();
        poseStack.translate(0.5, 0.5, 0.5);
        poseStack.mulPose(Axis.YP.rotationDegrees(-state.yRot));
        poseStack.translate(-0.5, -0.5, -0.5);
        for (int i = 0; i < state.displays.size(); i++) {
            poseStack.pushPose();
            submitDisplays(state, poseStack, submitNodeCollector, camera, i);
            poseStack.popPose();
        }
        poseStack.popPose();
    }

    private static void submitDisplays(MoonShelfBlockEntityRenderState state, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, CameraRenderState camera, int i) {
        ItemStackRenderState item = state.displays.get(i).itemRenderState;
        BlockModelRenderState block = state.displays.get(i).blockRenderState;
        Vec3 pos = LOCATIONS.get(i);
        poseStack.translate(-0.125f, 0, -0.125f);
        poseStack.translate(pos.x, pos.y, pos.z);
        if (!block.isEmpty()) {
            submitBlockState(state, poseStack, submitNodeCollector, camera, block, i);
        } else if (!item.isEmpty()) {
            submitItem(state, poseStack, submitNodeCollector, i, item);
        }
    }

    private static void submitItem(MoonShelfBlockEntityRenderState state, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, int i, ItemStackRenderState item) {
        poseStack.translate(0.175, SCALE_ITEM /2, 0);
        float innerRotation = state.displays.get(i).rotation;
        if (innerRotation != 0) {
            poseStack.mulPose(Axis.YP.rotationDegrees(innerRotation));
        }
        poseStack.scale(SCALE_ITEM, SCALE_ITEM, SCALE_ITEM);
        item.submit(poseStack, submitNodeCollector, state.lightCoords, OverlayTexture.NO_OVERLAY, 0);
    }

    private static void submitBlockState(MoonShelfBlockEntityRenderState state, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, CameraRenderState camera, BlockModelRenderState block, int i) {
        poseStack.scale(SCALE_BLOCK, SCALE_BLOCK, SCALE_BLOCK);
        block.submit(poseStack, submitNodeCollector, state.lightCoords, OverlayTexture.NO_OVERLAY, 0);

        BlockEntityRenderer<@NotNull BlockEntity, @NotNull BlockEntityRenderState> renderer = state.displays.get(i).blockEntityRenderer;
        BlockEntityRenderState renderState = state.displays.get(i).blockEntityRenderState;
        if (renderer != null && renderState != null) renderer.submit(renderState, poseStack, submitNodeCollector, camera);
    }

    @Override
    public AABB getRenderBoundingBox(@NotNull MoonShelfBlockEntity blockEntity) {
        return new AABB(blockEntity.getBlockPos()).inflate(1);
    }
}
