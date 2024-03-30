package nowebsite.maker.furnitureplan.items.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class MyBEWLR <T extends BlockEntity> extends BlockEntityWithoutLevelRenderer {
    private final Supplier<T> te;
    private final BlockEntityRenderDispatcher blockEntityRenderDispatcher;

    public MyBEWLR(BlockEntityRenderDispatcher renderDispatcher, EntityModelSet modelSet, Supplier<T> te) {
        super(renderDispatcher, modelSet);

        this.te = te;
        this.blockEntityRenderDispatcher = renderDispatcher;
    }

    @Override
    public void renderByItem(@NotNull ItemStack pStack, @NotNull ItemDisplayContext pDisplayContext, @NotNull PoseStack pPoseStack, @NotNull MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay) {
        this.blockEntityRenderDispatcher.renderItem(this.te.get(), pPoseStack, pBuffer, pPackedLight, pPackedOverlay);
    }
}
