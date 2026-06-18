package nowebsite.maker.furnitureplan.common.block.abstraction.generators;

import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.block.Block;
import nowebsite.maker.furnitureplan.common.block.abstraction.BlockSetGetter;
import nowebsite.maker.furnitureplan.common.block.abstraction.MulStateGetter;

public abstract class SingleMulStateBDG<S extends Enum<S> & StringRepresentable, T extends Block & BlockSetGetter & MulStateGetter<S>> extends HorizontalBDG<T> {

}
