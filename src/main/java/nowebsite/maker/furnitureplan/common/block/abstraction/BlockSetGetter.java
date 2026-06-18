package nowebsite.maker.furnitureplan.common.block.abstraction;

import nowebsite.maker.furnitureplan.common.block.abstraction.set.FPBlockSetType;

public interface BlockSetGetter {
    /**
     * 方块所属的材质类型
     */
    FPBlockSetType getType();
}
