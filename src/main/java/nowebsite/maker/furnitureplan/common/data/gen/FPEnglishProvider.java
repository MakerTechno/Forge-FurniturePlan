package nowebsite.maker.furnitureplan.common.data.gen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import nowebsite.maker.furnitureplan.FurniturePlan;
import nowebsite.maker.furnitureplan.common.init.FPBlockReg;
import nowebsite.maker.furnitureplan.common.init.FPItemReg;

import java.util.Arrays;
import java.util.stream.Collectors;

public class FPEnglishProvider extends LanguageProvider {
    public FPEnglishProvider(PackOutput output) {
        super(output, FurniturePlan.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add("itemGroup.furniture.miscellaneous", "Furniture Plan: Miscellaneous");
        add("itemGroup.furniture.sitting", "Furniture Plan: Sitting");
        add("itemGroup.furniture.surfacing", "Furniture Plan: Surfacing");
        add("itemGroup.furniture.decorating", "Furniture Plan: Decorating");
        add("itemGroup.furniture.storaging", "Furniture Plan: Storaging");
        FPBlockReg.BLOCKS.getEntries().forEach(block -> add(block.get(), toTitleCase(block.getId().getPath())));

        add(FPBlockReg.IRON_POT_ITEM.get(), "Iron Pot");
        add(FPBlockReg.GRASS_GRASS_ITEM.get(), "Grass!?");
        add(FPBlockReg.FOOD_PLATE_BLOCK_ITEM.get(), "Food plate");
        add(FPBlockReg.GLASS_B_BLOCK_ITEM.get(), "Glass bottle");
        add(FPBlockReg.CUTLERY_ITEM.get(), "Cutlery");
        add(FPItemReg.AGERATUM_GUIDEBOOK.get(), "Furniture Plan Guidebook");
        add("item.furnitureplan.grass_grass.desc", "Maybe you can try to eat it(?)");
        add("item.furnitureplan.food_plate.desc", "You can put bottle and cutlery on it, and put a food on it");
        add("item.furnitureplan.cutlery.desc", "You can also put it on a plate");
        add("item.furnitureplan.glass.desc", "You can also put it on a plate or click on water source,\nor right click glass block with an potion item in hand.");


        add("advancements.furniture.root.title", "Let's carve a furniture!");
        add("advancements.furniture.root.description", "Get a furniture graver");
        add("advancements.furniture.grassit.title", "It's worth it a grass");
        add("advancements.furniture.grassit.description", "Try to eat a grass(furnitureplan)");
        add("furnitureplan.networking.failed", "Failed to sync data.");
        add("block.furnitureplan.cupboard_block", "Cupboard");
    }

    public static String toTitleCase(String raw) {
        return Arrays.stream(raw.split("_"))
            .map(word -> Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase())
            .collect(Collectors.joining(" "));
    }
}
