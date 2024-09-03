package nowebsite.maker.furnitureplan.blocks.func;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.List;


public interface IColorfulBlock {
    List<Item> DYE_LIST = List.of(
        Items.BLACK_DYE,
        Items.BLUE_DYE,
        Items.BROWN_DYE,
        Items.CYAN_DYE,
        Items.GRAY_DYE,
        Items.GREEN_DYE,
        Items.LIGHT_BLUE_DYE,
        Items.LIGHT_GRAY_DYE,
        Items.LIME_DYE,
        Items.MAGENTA_DYE,
        Items.ORANGE_DYE,
        Items.PINK_DYE,
        Items.PURPLE_DYE,
        Items.RED_DYE,
        Items.YELLOW_DYE,
        Items.WHITE_DYE
    );
    List<DyeColor> COLOR_LIST = List.of(
        DyeColor.BLACK,
        DyeColor.BLUE,
        DyeColor.BROWN,
        DyeColor.CYAN,
        DyeColor.GRAY,
        DyeColor.GREEN,
        DyeColor.LIGHT_BLUE,
        DyeColor.LIGHT_GRAY,
        DyeColor.LIME,
        DyeColor.MAGENTA,
        DyeColor.ORANGE,
        DyeColor.PINK,
        DyeColor.PURPLE,
        DyeColor.RED,
        DyeColor.YELLOW,
        DyeColor.WHITE
    );
    List<ResourceLocation> CONCRETE_TEXTURE_LIST = List.of(
        mcTxrLoc("black_concrete"),
        mcTxrLoc("blue_concrete"),
        mcTxrLoc("brown_concrete"),
        mcTxrLoc("cyan_concrete"),
        mcTxrLoc("gray_concrete"),
        mcTxrLoc("green_concrete"),
        mcTxrLoc("light_blue_concrete"),
        mcTxrLoc("light_gray_concrete"),
        mcTxrLoc("lime_concrete"),
        mcTxrLoc("magenta_concrete"),
        mcTxrLoc("orange_concrete"),
        mcTxrLoc("pink_concrete"),
        mcTxrLoc("purple_concrete"),
        mcTxrLoc("red_concrete"),
        mcTxrLoc("yellow_concrete"),
        mcTxrLoc("white_concrete")
    );
    default ResourceLocation getConcreteTextureByID() {
        return CONCRETE_TEXTURE_LIST.get(getId());
    }
    int getId();
    static ResourceLocation mcTxrLoc(String name) {
        return ResourceLocation.parse("block/" + name);
    }
    static ResourceLocation of(int index){
        return CONCRETE_TEXTURE_LIST.get(index);
    }
}
