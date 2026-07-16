package nowebsite.maker.furnitureplan.common.block.surfacing.entity.renderer.state;

import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import nowebsite.maker.furnitureplan.utils.display.FPItemDisplayState;

import java.util.ArrayList;
import java.util.List;

public class WallShelfBlockEntityRenderState extends BlockEntityRenderState {
    public List<FPItemDisplayState> displays = new ArrayList<>(6);
    public float yRot;
    public boolean isBi;
    public WallShelfBlockEntityRenderState() {
        for (int i = 0; i < 6; i++) {
            displays.add(new FPItemDisplayState());
        }
    }
}
