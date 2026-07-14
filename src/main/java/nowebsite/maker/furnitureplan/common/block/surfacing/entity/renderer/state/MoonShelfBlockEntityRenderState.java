package nowebsite.maker.furnitureplan.common.block.surfacing.entity.renderer.state;

import net.minecraft.client.renderer.block.BlockModelRenderState;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class MoonShelfBlockEntityRenderState extends BlockEntityRenderState {
    public List<ItemStackRenderState> items= new ArrayList<>(22);
    public List<BlockModelRenderState> blocks = new ArrayList<>(22);
    public List<BlockEntityRenderer<@NotNull BlockEntity, @NotNull BlockEntityRenderState>> renderers = new ArrayList<>(22);
    public List<BlockEntityRenderState> renderStates = new ArrayList<>(22);
    public List<Float> rots = new ArrayList<>(22);
    public float yRot;
    public MoonShelfBlockEntityRenderState() {
        for (int i = 0; i < 22; i++) {
            items.add(new ItemStackRenderState());
            blocks.add(new BlockModelRenderState());
            renderers.add(null);
            renderStates.add(null);
            rots.add(null);
        }
    }
}
