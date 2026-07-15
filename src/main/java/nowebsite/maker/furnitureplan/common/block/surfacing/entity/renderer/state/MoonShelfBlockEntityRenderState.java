package nowebsite.maker.furnitureplan.common.block.surfacing.entity.renderer.state;

import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import nowebsite.maker.furnitureplan.utils.display.FPItemDisplayState;

import java.util.ArrayList;
import java.util.List;

public class MoonShelfBlockEntityRenderState extends BlockEntityRenderState {
    public List<FPItemDisplayState> displays = new ArrayList<>(22);
    public float yRot;
    public MoonShelfBlockEntityRenderState() {
        for (int i = 0; i < 22; i++) {
            displays.add(new FPItemDisplayState());
        }
    }
}
