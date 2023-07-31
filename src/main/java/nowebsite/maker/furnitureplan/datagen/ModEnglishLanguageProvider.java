package nowebsite.maker.furnitureplan.datagen;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.RegistryObject;
import nowebsite.maker.furnitureplan.FurniturePlan;
import nowebsite.maker.furnitureplan.registry.FoldingRegistration;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Locale;

@SuppressWarnings("deprecation")
public class ModEnglishLanguageProvider extends LanguageProvider {
    public ModEnglishLanguageProvider(PackOutput packOutput, String locale) {
        super(packOutput, FurniturePlan.MOD_ID, locale);
    }

    protected void addTranslations() {
        add("itemGroup.furniture", "Furniture Plan");
        add("msg.furnitureplan.sit", "Something wrong happened, it's the reason why you can't sit on this block.");
        transformKinds(FoldingRegistration.getChairBlockLists());
        transformKinds(FoldingRegistration.getTableBlockLists());
    }

    public void transformKinds(@NotNull List<RegistryObject<? extends Block>> list) {
        assert list.size() <= FoldingRegistration.PROPERTY_KINDS.length;
        for(RegistryObject<? extends Block> ro : list) {
            String s = BuiltInRegistries.BLOCK.getKey(ro.get()).getPath().replace('_', ' ');
            add(ro.get(), s.substring(0, 1).toUpperCase(Locale.ROOT) + s.substring(1));
        }
    }
}
