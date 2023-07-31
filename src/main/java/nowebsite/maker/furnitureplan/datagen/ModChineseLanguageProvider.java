package nowebsite.maker.furnitureplan.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.RegistryObject;
import nowebsite.maker.furnitureplan.FurniturePlan;
import nowebsite.maker.furnitureplan.registry.FoldingRegistration;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ModChineseLanguageProvider extends LanguageProvider {
    public ModChineseLanguageProvider(PackOutput packOutput, String locale) {
        super(packOutput, FurniturePlan.MOD_ID, locale);
    }

    protected void addTranslations() {
        add("itemGroup.furniture", "家具计划");
        add("msg.furnitureplan.sit", "出现某些错误导致乘坐方块失败。");
        transformKinds(FoldingRegistration.getChairBlockLists(), "椅");
        transformKinds(FoldingRegistration.getTableBlockLists(), "桌");
    }

    public void transformKinds(@NotNull List<RegistryObject<? extends Block>> list, String transformKey) {
        assert list.size() <= FoldingRegistration.PROPERTY_KINDS_CHINESE_KEY.length;
        int count = 0;
        for(RegistryObject<? extends Block> ro : list) {
            add(ro.get(), FoldingRegistration.PROPERTY_KINDS_CHINESE_KEY[count] + transformKey);
            count++;
        }
    }
}
