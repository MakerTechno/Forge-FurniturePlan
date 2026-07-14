package nowebsite.maker.furnitureplan.common.block.surfacing.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.block.BlockModelRenderState;
import net.minecraft.client.renderer.block.BlockModelResolver;
import net.minecraft.client.renderer.block.model.BlockDisplayContext;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.item.ItemModelResolver;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import nowebsite.maker.furnitureplan.common.block.surfacing.MoonShelfBlock;
import nowebsite.maker.furnitureplan.common.block.surfacing.entity.MoonShelfBlockEntity;
import nowebsite.maker.furnitureplan.common.block.surfacing.entity.renderer.state.MoonShelfBlockEntityRenderState;
import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.Nullable;

import java.util.List;

public class MoonShelfBlockEntityRenderer implements BlockEntityRenderer<@NotNull MoonShelfBlockEntity, @NotNull MoonShelfBlockEntityRenderState> {
    public static final BlockDisplayContext BLOCK_DISPLAY_CONTEXT = BlockDisplayContext.create();
    private static final float scale = .26f;
    private static final float scaleItem = .33f;
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

        for (int i = 0; i < 22; i++) {
            Direction innerFacing = blockEntity.getItemFacing().get(i);
            if (innerFacing != null) {
                state.rots.set(i, innerFacing.toYRot() + 180 - state.yRot);
            } else state.rots.set(i, null);

            BlockState blockState = blockEntity.getBlockStateCaches().get(i);

            if (blockState.isEmpty()) {
                ItemStack itemStack = blockEntity.getItem(i);
                ItemStackRenderState itemRenderState = state.items.get(i);
                int seed = (int) blockEntity.getBlockPos().asLong();
                itemModelResolver.updateForTopItem(itemRenderState, itemStack, ItemDisplayContext.FIXED, blockEntity.getLevel(), null, seed);
                state.items.set(i, itemRenderState);
                continue;
            }

            BlockModelRenderState blockRenderState = state.blocks.get(i);
            blockModelResolver.update(blockRenderState, blockState, BLOCK_DISPLAY_CONTEXT);
            state.blocks.set(i, blockRenderState);


            BlockEntity toRend = blockEntity.getBlockEntityCaches().get(i);
            if (toRend != null) {
                try {
                    BlockEntityRenderer<@NotNull BlockEntity, @NotNull BlockEntityRenderState> renderer = dispatcher.getRenderer(toRend);
                    if (renderer == null) continue;
                    BlockEntityRenderState innerState = renderer.createRenderState();
                    renderer.extractRenderState(toRend, innerState, partialTicks, cameraPosition, breakProgress);
                    state.renderers.set(i, renderer);
                    state.renderStates.set(i, innerState);
                } catch (Exception ignore) {
                }
            } else {
                state.renderers.set(i, null);
                state.renderStates.set(i, null);
            }
        }
    }

    @Override
    public void submit(MoonShelfBlockEntityRenderState state, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, CameraRenderState camera) {
        poseStack.pushPose();
        poseStack.translate(0.5, 0.5, 0.5);
        poseStack.mulPose(Axis.YP.rotationDegrees(-state.yRot));
        poseStack.translate(-0.5, -0.5, -0.5);
        for (int i = 0; i < 22; i++) {
            ItemStackRenderState item = state.items.get(i);
            BlockModelRenderState block = state.blocks.get(i);

            poseStack.pushPose();
            Vec3 pos = LOCATIONS.get(i);
            poseStack.translate(-0.125f, 0, -0.125f);
            poseStack.translate(pos.x, pos.y, pos.z);
            if (block != null && !block.isEmpty()) {
                poseStack.scale(scale, scale, scale);
                block.submit(poseStack, submitNodeCollector, state.lightCoords, OverlayTexture.NO_OVERLAY, 0);

                BlockEntityRenderer<@NotNull BlockEntity, @NotNull BlockEntityRenderState> renderer = state.renderers.get(i);
                if (renderer != null) renderer.submit(state.renderStates.get(i), poseStack, submitNodeCollector, camera);
            } else if (item != null && !item.isEmpty()) {
                poseStack.translate(0.175, scaleItem/2, 0);
                if (state.rots.get(i) != null) {
                    poseStack.mulPose(Axis.YP.rotationDegrees(state.rots.get(i)));
                }
                poseStack.scale(scaleItem, scaleItem, scaleItem);
                item.submit(poseStack, submitNodeCollector, state.lightCoords, OverlayTexture.NO_OVERLAY, 0);
            }
            poseStack.popPose();
        }
        poseStack.popPose();
    }
}
