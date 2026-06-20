package nowebsite.maker.furnitureplan.common.data.gen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.LanguageProvider;
import nowebsite.maker.furnitureplan.FurniturePlan;
import nowebsite.maker.furnitureplan.common.block.abstraction.BlockSetGetter;
import nowebsite.maker.furnitureplan.common.data.gen.empowered.BlockDataGenerator;
import nowebsite.maker.furnitureplan.common.init.FPBlockReg;

public class FPChineseProvider extends LanguageProvider {
    public static final String LOCALE = "zh_cn";
    public FPChineseProvider(PackOutput output) {
        super(output, FurniturePlan.MOD_ID, LOCALE);
    }

    @Override
    protected void addTranslations() {
        add("itemGroup.furniture", "家具计划");
        add(FPBlockReg.IRON_POT_BLOCK.get(), "铁锅");
        add(FPBlockReg.LANTERN_BLOCK_P1.get(), "灯笼 样式1");
        add(FPBlockReg.LANTERN_BLOCK_P2.get(), "灯笼 样式2");
        add(FPBlockReg.TABLE_LAMP_BLOCK.get(), "台灯");
        FPDataGenerators.GENERATORS.forEach(this::invokeGenerator);
    }


    @SuppressWarnings("unchecked")
    private <T extends Block> void  invokeGenerator(Block block, BlockDataGenerator<?> generator) {
        BlockDataGenerator<T> typeGenerator = (BlockDataGenerator<T>) generator;
        add(block, ((BlockSetGetter) block).getType().getTranslations().get(LOCALE) + typeGenerator.getTemplateType((T)block).getTranslations().get(LOCALE));
    }
}
