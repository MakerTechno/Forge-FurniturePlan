package nowebsite.maker.furnitureplan.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.neoforged.neoforge.registries.DeferredHolder;
import nowebsite.maker.furnitureplan.FurniturePlan;
import nowebsite.maker.furnitureplan.registry.BlockRegistration;
import nowebsite.maker.furnitureplan.registry.FoldingRegistration;
import nowebsite.maker.furnitureplan.registry.ItemRegistration;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ModChineseLanguageProvider extends LanguageProvider {
    public ModChineseLanguageProvider(PackOutput packOutput, String locale) {
        super(packOutput, FurniturePlan.MOD_ID, locale);
    }

    protected void addTranslations() {
        add("itemGroup.furniture", "家具计划");
        add("msg.furnitureplan.sit", "出现某些错误导致乘坐方块失败。");
        transformKinds(FoldingRegistration.getChairBlockList(), null, "椅");
        transformKinds(FoldingRegistration.getTableBlockList(), null, "桌");
        transformKinds(FoldingRegistration.getColumnBlockList(), null, "柱");
        transformKinds(FoldingRegistration.getCarvedColumnBlockList(), "雕刻", "柱");
        transformKinds(FoldingRegistration.getLightedColumnBlockList(), "嵌灯", "柱");
        add(ItemRegistration.DETRITUS.get(), "碎石屑");
        add(ItemRegistration.SAWDUST.get(), "木屑");
        add(ItemRegistration.GRAVER.get(), "家具计划-雕刻刀");
        add("tip.furnitureplan.shiftdown", "按下SHIFT查看详细信息");
        add("tip.furnitureplan.click", "右键空气以切换雕刻种类");
        add("tip.furnitureplan.graver", "这个雕刻刀可以将一些方块雕刻成模组物品\n实际上，可雕刻的方块种类和制作各种楼梯的方块种类一样多");
        add("tip.furnitureplan.graver.kind", "种类: ");
        add("tip.furnitureplan.graver.kind.chair", "椅子");
        add("tip.furnitureplan.graver.kind.bench", "凳子");
        add("tip.furnitureplan.graver.kind.table", "桌子");
        add("tip.furnitureplan.graver.kind.column", "柱子");
        add("tip.furnitureplan.graver.kind.carved_column", "雕刻柱子");
        add("tip.furnitureplan.graver.kind.lighted_column", "嵌灯柱子");
        add(BlockRegistration.FOOD_PLATE_BLOCK_ITEM.get(), "盘子");
        add(BlockRegistration.GLASS_B_BLOCK_ITEM.get(), "玻璃杯");
        add(BlockRegistration.CUTLERY_ITEM.get(), "餐具");
        add(BlockRegistration.LANTERN_ITEM.get(), "灯笼");
        add(BlockRegistration.IRON_POT_BLOCK_ITEM.get(), "铁锅");
        add(BlockRegistration.STOVE_BLOCK_ITEM.get(), "灶台");
        add(BlockRegistration.CUPBOARD_BLOCK_ITEM.get(), "橱柜");
        add(BlockRegistration.VASE_B_BLOCK_ITEM.get(), "花瓶(已弃用)");
        add(BlockRegistration.TABLE_LAMP_ITEM.get(), "台灯");
        add(BlockRegistration.GRASS_GRASS_ITEM.get(), "草(字面上、物理上的)");
        add("advancements.furniture.root.title", "开始雕刻家具吧!");
        add("advancements.furniture.root.description", "获取一个家具计划雕刻刀");
        add("advancements.furniture.grassit.title", "令人眼前一黑的好活");
        add("advancements.furniture.grassit.description", "吃下一颗来自家具计划的草");
        add("furnitureplan.networking.failed", "在同步数据时发生错误。");
        transformColors(FoldingRegistration.getPotHolderBlockList(), "色花架");
        transformKinds(FoldingRegistration.getBenchBlockList(), null, "凳");
    }

    public void transformKinds(@NotNull List<DeferredHolder<Block, ? extends Block>> list, String transformHead, String transformEnd) {
        assert list.size() <= FoldingRegistration.PROPERTY_KINDS_CHINESE_KEY.length;
        int count = 0;
        for(DeferredHolder<Block, ? extends Block> ro : list) {
            add(
                ro.get(), (transformHead == null? "" : transformHead) +
                    FoldingRegistration.PROPERTY_KINDS_CHINESE_KEY[count] +
                    (transformEnd == null? "" : transformEnd)
            );
            count++;
        }
    }
    public void transformColors(@NotNull List<DeferredHolder<Block, ? extends Block>> list, String transformEnd) {
        assert list.size() <= FoldingRegistration.COLOR_KIND_CHINESE_KEY.length;
        int count = 0;
        for(DeferredHolder<Block, ? extends Block> ro : list) {
            add(
                ro.get(), FoldingRegistration.COLOR_KIND_CHINESE_KEY[count] +
                    (transformEnd == null? "" : transformEnd)
            );
            count++;
        }
    }
}
