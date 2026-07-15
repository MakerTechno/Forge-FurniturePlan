package nowebsite.maker.furnitureplan.utils.display;

import net.minecraft.client.renderer.block.BlockModelRenderState;
import net.minecraft.client.renderer.block.BlockModelResolver;
import net.minecraft.client.renderer.block.model.BlockDisplayContext;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.item.ItemModelResolver;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class FPItemDisplayState {
    public static final BlockDisplayContext BLOCK_DISPLAY_CONTEXT = BlockDisplayContext.create();

    public ItemStackRenderState itemRenderState = new ItemStackRenderState();
    public BlockModelRenderState blockRenderState = new BlockModelRenderState();
    public @Nullable BlockEntityRenderState blockEntityRenderState = null;
    public @Nullable BlockEntityRenderer<@NotNull BlockEntity, @NotNull BlockEntityRenderState> blockEntityRenderer = null;
    public float rotation = 0;

    public FPItemDisplayState() {}

    public void extractDisplayState(
        int seed, @Nullable Level clientLevel, int lightCoords, float holderYRot, FPDisplayableItemStack display,
        ItemStack stack,
        ItemModelResolver itemModelResolver, BlockModelResolver blockModelResolver, BlockEntityRenderDispatcher dispatcher,
        float partialTicks, Vec3 cameraPosition, ModelFeatureRenderer.@Nullable CrumblingOverlay breakProgress
    ) {
        if (stack.isEmpty()) return;
        extractRotation(holderYRot, display);

        BlockState blockState = display.getBlockStateCache();
        if (blockState == null || blockState.isEmpty()) {
            extractItemState(seed, clientLevel, stack, itemModelResolver);
            return;
        }

        blockModelResolver.update(blockRenderState, blockState, BLOCK_DISPLAY_CONTEXT);

        BlockEntity toRend = display.getBlockEntityCache();
        if (toRend != null) tryGenerateBER(lightCoords, partialTicks, cameraPosition, dispatcher, breakProgress, toRend);
        else {
            blockEntityRenderer = null;
            blockEntityRenderState = null;
        }
    }

    private void extractRotation(float holderYRot, FPDisplayableItemStack display) {
        Direction facing = display.getDisplayFacing();
        if (facing != null) {
            this.rotation = facing.toYRot() + 180 - holderYRot;
        } else this.rotation = 0;
    }

    private void extractItemState(int seed, @Nullable Level clientLevel, ItemStack stack, ItemModelResolver itemModelResolver) {
        itemModelResolver.updateForTopItem(itemRenderState, stack, ItemDisplayContext.FIXED, clientLevel, null, seed);
    }

    private void tryGenerateBER(int lightCoords, float partialTicks, Vec3 cameraPosition, BlockEntityRenderDispatcher dispatcher, ModelFeatureRenderer.@Nullable CrumblingOverlay breakProgress, BlockEntity toRend) {
        try {
            blockEntityRenderer = dispatcher.getRenderer(toRend);
            if (blockEntityRenderer == null) return;
            BlockEntityRenderState innerState = blockEntityRenderer.createRenderState();
            blockEntityRenderer.extractRenderState(toRend, innerState, partialTicks, cameraPosition, breakProgress);
            innerState.lightCoords = lightCoords; // as inner BE's level is null, it will extract full brightness. So we setItem it twice here
            blockEntityRenderState = innerState;
        } catch (Exception ignore) {}
    }

}
