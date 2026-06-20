package nowebsite.maker.furnitureplan.common.data.gen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import nowebsite.maker.furnitureplan.FurniturePlan;
import nowebsite.maker.furnitureplan.common.init.FPBlockReg;
import nowebsite.maker.furnitureplan.common.init.FPCreativeModTabReg;

import java.util.Arrays;
import java.util.stream.Collectors;

public class FPEnglishProvider extends LanguageProvider {
    public FPEnglishProvider(PackOutput output) {
        super(output, FurniturePlan.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add("itemGroup.furniture", "Furniture plan");
        FPBlockReg.BLOCKS.getEntries().forEach(block -> add(block.get(), toTitleCase(block.getId().getPath())));
    }

    public static String capitalize(String str) {
        if (str.isEmpty()) return str;
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }

    public static String toTitleCase(String raw) {
        return Arrays.stream(raw.split("_"))
            .map(word -> Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase())
            .collect(Collectors.joining(" "));
    }
}
