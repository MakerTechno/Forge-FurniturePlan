package nowebsite.maker.furnitureplan.common.block.storaging.entity.renderer.state;

import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;

public class CabinetBlockRenderState extends BlockEntityRenderState {
    public boolean shouldRender, needTranslucent;
    public float yRot, openness;
    public TextureAtlasSprite doorSprite, handleSprite;
}
