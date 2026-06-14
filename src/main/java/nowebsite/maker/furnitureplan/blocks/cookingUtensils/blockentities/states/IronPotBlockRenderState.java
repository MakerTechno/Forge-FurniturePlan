package nowebsite.maker.furnitureplan.blocks.cookingUtensils.blockentities.states;

import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.core.Direction;

public class IronPotBlockRenderState extends BlockEntityRenderState {
    public ItemStackRenderState itemInPotState;
    public Direction facing = Direction.NORTH;
}