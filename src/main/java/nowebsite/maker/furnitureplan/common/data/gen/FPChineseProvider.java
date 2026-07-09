package nowebsite.maker.furnitureplan.common.data.gen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.LanguageProvider;
import nowebsite.maker.furnitureplan.FurniturePlan;
import nowebsite.maker.furnitureplan.common.data.gen.empowered.BlockDataGenerator;
import nowebsite.maker.furnitureplan.common.init.FPBlockReg;

public class FPChineseProvider extends LanguageProvider {
    public static final String LOCALE = "zh_cn";
    public FPChineseProvider(PackOutput output) {
        super(output, FurniturePlan.MOD_ID, LOCALE);
    }

    @Override
    protected void addTranslations() {
        add("itemGroup.furniture.miscellaneous", "家具计划: 杂项");
        add("itemGroup.furniture.sitting", "家具计划: 可乘坐类");
        add("itemGroup.furniture.surfacing", "家具计划: 置具台类");
        add("itemGroup.furniture.decorating", "家具计划: 装饰类");
        add("itemGroup.furniture.storaging", "家具计划: 存储类");
        add(FPBlockReg.IRON_POT_BLOCK.get(), "铁锅");
        add(FPBlockReg.LANTERN_BLOCK_P1.get(), "灯笼 样式1");
        add(FPBlockReg.LANTERN_BLOCK_P2.get(), "灯笼 样式2");
        add(FPBlockReg.TABLE_LAMP_BLOCK.get(), "台灯");
        FPDataGenerators.GENERATORS.forEach(this::invokeGenerator);
        add(FPBlockReg.IRON_POT_ITEM.get(), "看起来很疼的铁锅");
        add(FPBlockReg.GRASS_GRASS_ITEM.get(), "草(物理意义上的)");
        add(FPBlockReg.FOOD_PLATE_BLOCK_ITEM.get(), "盘子");
        add(FPBlockReg.GLASS_B_BLOCK_ITEM.get(), "玻璃杯");
        add(FPBlockReg.CUTLERY_ITEM.get(), "餐具");
        add("item.furnitureplan.grass_grass.desc", "这玩意能吃!?");
        add("advancements.furniture.root.title", "开始雕刻家具吧!");
        add("advancements.furniture.root.description", "获取一个家具计划雕刻刀");
        add("advancements.furniture.grassit.title", "令人眼前一黑的好活");
        add("advancements.furniture.grassit.description", "吃下一颗来自家具计划的草");
        add("furnitureplan.networking.failed", "在同步数据时发生错误。");
        add("block.furnitureplan.cupboard_block", "橱柜");
    }


    @SuppressWarnings("unchecked")
    private <T extends Block> void  invokeGenerator(Block block, BlockDataGenerator<?> generator) {
        BlockDataGenerator<T> typeGenerator = (BlockDataGenerator<T>) generator;
        add(block, typeGenerator.getChineseTranslation((T)block));
    }
}
