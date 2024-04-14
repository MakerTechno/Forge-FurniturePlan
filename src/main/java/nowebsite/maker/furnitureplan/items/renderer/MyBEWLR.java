package nowebsite.maker.furnitureplan.items.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import nowebsite.maker.furnitureplan.blocks.singleblockfurniture.blockentities.CupboardBlockEntity;
import nowebsite.maker.furnitureplan.registry.BlockRegistration;
import org.jetbrains.annotations.NotNull;

public class MyBEWLR extends BlockEntityWithoutLevelRenderer {
    private final CupboardBlockEntity cupboard = new CupboardBlockEntity(BlockPos.ZERO, BlockRegistration.CUPBOARD_BLOCK.get().defaultBlockState());
    private final BlockEntityRenderDispatcher blockEntityRenderDispatcher;

    public MyBEWLR(BlockEntityRenderDispatcher renderDispatcher, EntityModelSet modelSet) {
        super(renderDispatcher, modelSet);
        this.blockEntityRenderDispatcher = renderDispatcher;
    }

    @Override
    public void renderByItem(@NotNull ItemStack pStack, @NotNull ItemDisplayContext pDisplayContext, @NotNull PoseStack pPoseStack, @NotNull MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay) {
        Item item = pStack.getItem();
        if (item instanceof BlockItem) {
            Block block = ((BlockItem)item).getBlock();
            BlockState blockstate = block.defaultBlockState();
            BlockEntity blockEntity = null;
            if (blockstate.is(BlockRegistration.CUPBOARD_BLOCK.get())) blockEntity = this.cupboard;

            if (blockEntity != null)
                this.blockEntityRenderDispatcher.renderItem(blockEntity, pPoseStack, pBuffer, pPackedLight, pPackedOverlay);
        }
    }
}
