package nowebsite.maker.furnitureplan.common.block.storaging.entity.renderer.state;

import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;

public class CupboardBlockRendererState extends BlockEntityRenderState {
    public Direction facing;
    public Identifier textureBase;
    public float openess1, openess2, openess3;
}
