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
        transformKinds(FoldingRegistration.getChairBlockLists(), null, "椅");
        transformKinds(FoldingRegistration.getTableBlockLists(), null, "桌");
        transformKinds(FoldingRegistration.getColumnBlockLists(), null, "柱");
        transformKinds(FoldingRegistration.getCarvedColumnBlockLists(), "雕刻", "柱");
        transformKinds(FoldingRegistration.getLightedColumnBlockLists(), "嵌灯", "柱");
        add(ItemRegistration.DETRITUS.get(), "碎石屑");
        add(ItemRegistration.SAWDUST.get(), "木屑");
        add(ItemRegistration.GRAVER.get(), "家具计划-雕刻刀");
        add("tip.furnitureplan.shiftdown", "按下SHIFT查看详细信息");
        add("tip.furnitureplan.graver", "这个雕刻刀可以将一些方块雕刻成模组物品\n实际上，可雕刻的方块种类和制作各种楼梯的方块种类一样多");
        add(BlockRegistration.FOOD_PLATE_BLOCK_ITEM.get(), "盘子");
        add(BlockRegistration.GLASS_B_BLOCK_ITEM.get(), "玻璃杯");
        add(BlockRegistration.CUTLERY_ITEM.get(), "餐具");
        add(BlockRegistration.LANTERN_ITEM.get(), "灯笼");
        add(BlockRegistration.IRON_POT_BLOCK_ITEM.get(), "铁锅");
        add(BlockRegistration.STOVE_BLOCK_ITEM.get(), "灶台");
        add(BlockRegistration.CUPBOARD_BLOCK_ITEM.get(), "橱柜");
        add(BlockRegistration.VASE_B_BLOCK_ITEM.get(), "花瓶");
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
}
