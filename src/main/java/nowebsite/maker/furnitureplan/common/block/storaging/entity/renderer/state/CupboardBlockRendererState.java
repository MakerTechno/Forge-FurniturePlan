package nowebsite.maker.furnitureplan.common.block.storaging.entity.renderer.state;

import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.Direction;

public class CupboardBlockRendererState extends BlockEntityRenderState {
    public Direction facing;
    public float openess1, openess2, openess3;
    public TextureAtlasSprite sprite;
}
