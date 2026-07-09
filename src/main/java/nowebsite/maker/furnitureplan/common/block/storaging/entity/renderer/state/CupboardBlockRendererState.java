package nowebsite.maker.furnitureplan.common.block.storaging.entity.renderer.state;

import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.Direction;

public class CupboardBlockRendererState extends BlockEntityRenderState {
    public Direction facing;
    public float openness1, openness2, openness3;
    public TextureAtlasSprite sprite;
    public boolean needTransparent;
}
