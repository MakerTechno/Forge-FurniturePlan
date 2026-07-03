package nowebsite.maker.furnitureplan.common.block.abstraction.set;

import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;

public class FPColorfulSetType extends FPBlockSetType{
    public static final List<FPColorfulSetType> TYPES = new ArrayList<>();
    private final DyeColor color;
    private final Item dye;
    private final Item dyeConcrete;
    private final Identifier dyeConcreteTexLoc;

    public FPColorfulSetType(String name, DyeColor color, Item dye, Item dyeConcrete, Block base, boolean copyAll, Supplier<List<TagKey<Block>>> key, Function<Map<String, String>, Boolean> transInit) {
        super(name, base, copyAll, key, transInit);
        this.color = color;
        this.dye = dye;
        this.dyeConcrete = dyeConcrete;
        this.dyeConcreteTexLoc = Identifier.withDefaultNamespace("block/" + color.getName() + "_concrete");
        TYPES.add(this);
    }

    public DyeColor getColor() {
        return color;
    }

    public Item getDye() {
        return dye;
    }

    public Item getDyeConcrete() {
        return dyeConcrete;
    }

    @Override
    public Identifier getTexture() {
        return dyeConcreteTexLoc;
    }
}
