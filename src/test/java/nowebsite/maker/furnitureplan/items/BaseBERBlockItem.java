package nowebsite.maker.furnitureplan.items;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import nowebsite.maker.furnitureplan.items.renderer.MyBEWLR;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class BaseBERBlockItem extends BlockItem {
    public BaseBERBlockItem(Block pBlock, Properties pProperties) {
        super(pBlock, pProperties);
    }
    @Override
    public void initializeClient(@NotNull Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            @Override
            public @NotNull BlockEntityWithoutLevelRenderer getCustomRenderer() {
                return new MyBEWLR(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
            }
        });
    }

}
