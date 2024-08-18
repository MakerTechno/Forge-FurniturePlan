package nowebsite.maker.furnitureplan.datagen;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.RegistryObject;
import nowebsite.maker.furnitureplan.FurniturePlan;
import nowebsite.maker.furnitureplan.registry.BlockRegistration;
import nowebsite.maker.furnitureplan.registry.FoldingRegistration;
import nowebsite.maker.furnitureplan.registry.ItemRegistration;
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
        add("tip.furnitureplan.shiftdown", "Press SHIFT for more info.");
        add("tip.furnitureplan.graver", "This graver can grave some of the blocks to mod's block.\nActually, the kinds of block it can grave is just the kind of blocks which could be used to make stairs.");
        add(ItemRegistration.DETRITUS.get(), "Detritus");
        add(ItemRegistration.SAWDUST.get(), "Sawdust");
        add(ItemRegistration.GRAVER.get(), "Furniture plan-graver");
        transformKinds(FoldingRegistration.getChairBlockLists());
        transformKinds(FoldingRegistration.getTableBlockLists());
        transformKinds(FoldingRegistration.getColumnBlockLists());
        transformKinds(FoldingRegistration.getCarvedColumnBlockLists());
        transformKinds(FoldingRegistration.getLightedColumnBlockLists());

        add(BlockRegistration.FOOD_PLATE_BLOCK_ITEM.get(), "Food plate");
        add(BlockRegistration.GLASS_B_BLOCK_ITEM.get(), "Glass bottle");
        add(BlockRegistration.CUTLERY_ITEM.get(), "Cutlery");
        add(BlockRegistration.LANTERN_ITEM.get(), "Lantern");
        add(BlockRegistration.IRON_POT_BLOCK_ITEM.get(), "Iron pot");
        add(BlockRegistration.STOVE_BLOCK_ITEM.get(), "Stove");
        add(BlockRegistration.CUPBOARD_BLOCK_ITEM.get(), "Cupboard");
        add(BlockRegistration.VASE_B_BLOCK_ITEM.get(), "Vase");
    }

    public void transformKinds(@NotNull List<RegistryObject<? extends Block>> list) {
        assert list.size() <= FoldingRegistration.PROPERTY_KINDS.size();
        for(RegistryObject<? extends Block> ro : list) {
            String s = BuiltInRegistries.BLOCK.getKey(ro.get()).getPath().replace('_', ' ');
            add(ro.get(), s.substring(0, 1).toUpperCase(Locale.ROOT) + s.substring(1));
        }
    }
}
