package nowebsite.maker.furnitureplan.common.data.gen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import nowebsite.maker.furnitureplan.FurniturePlan;
import nowebsite.maker.furnitureplan.common.init.FPBlockReg;

public class FPChineseProvider extends LanguageProvider {
    public FPChineseProvider(PackOutput output) {
        super(output, FurniturePlan.MOD_ID, "zh_cn");
    }

    @Override
    protected void addTranslations() {
        add(FPBlockReg.IRON_POT_ITEM.get(), "铁锅");
        //FPDataGenerators.GENERATORS.forEach((block, blockDataGenerator) -> blockDataGenerator);
    }
}
