package nowebsite.maker.furnitureplan.common.data.gen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.LanguageProvider;
import nowebsite.maker.furnitureplan.FurniturePlan;
import nowebsite.maker.furnitureplan.common.data.gen.empowered.BlockDataGenerator;
import nowebsite.maker.furnitureplan.common.init.FPBlockReg;
import nowebsite.maker.furnitureplan.common.init.FPItemReg;

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
        add(FPItemReg.AGERATUM_GUIDEBOOK.get(), "家具计划指南书");
        add(FPItemReg.SAWDUST.get(), "木屑");
        add(FPItemReg.DETRITUS.get(), "石粉");
        add(FPBlockReg.SAWDUST_PLANKS.get(), "木屑板");
        add(FPBlockReg.DETRITUS_BLOCK.get(), "石粉板");
        add("item.furnitureplan.grass_grass.desc", "这玩意能吃!?");
        add("item.furnitureplan.food_plate.desc", "你其实可以把杯子和餐叉也放上去, 再放点食物");
        add("item.furnitureplan.cutlery.desc", "你其实也可以把它放在盘子上");
        add("item.furnitureplan.glass.desc", "你其实也可以把它放在盘子上或者右键水源，或者手持药水右键杯子方块");

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
