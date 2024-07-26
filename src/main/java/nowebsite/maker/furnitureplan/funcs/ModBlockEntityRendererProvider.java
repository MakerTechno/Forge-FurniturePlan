package nowebsite.maker.furnitureplan.funcs;

import net.minecraft.client.gui.Font;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.world.level.block.entity.BlockEntity;

@SuppressWarnings("unused")
public interface ModBlockEntityRendererProvider<T extends BlockEntity> extends BlockEntityRendererProvider<T> {
    class ModContext extends Context{
        public ModContext(BlockEntityRenderDispatcher pBlockEntityRenderDispatcher, BlockRenderDispatcher pBlockRenderDispatcher, ItemRenderer pItemRenderer, EntityRenderDispatcher pEntityRenderer, EntityModelSet pModelSet, Font pFont) {
            super(pBlockEntityRenderDispatcher, pBlockRenderDispatcher, pItemRenderer, pEntityRenderer, pModelSet, pFont);
        }
    }
}
