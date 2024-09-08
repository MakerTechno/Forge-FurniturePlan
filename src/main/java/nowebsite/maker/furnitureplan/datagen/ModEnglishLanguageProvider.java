package nowebsite.maker.furnitureplan.datagen;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.neoforged.neoforge.registries.DeferredHolder;
import nowebsite.maker.furnitureplan.FurniturePlan;
import nowebsite.maker.furnitureplan.items.Graver;
import nowebsite.maker.furnitureplan.registry.BlockRegistration;
import nowebsite.maker.furnitureplan.registry.FoldingRegistration;
import nowebsite.maker.furnitureplan.registry.ItemRegistration;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Locale;

public class ModEnglishLanguageProvider extends LanguageProvider {
    public ModEnglishLanguageProvider(PackOutput packOutput, String locale) {
        super(packOutput, FurniturePlan.MOD_ID, locale);
    }

    protected void addTranslations() {
        add("itemGroup.furniture", "Furniture Plan");
        add("msg.furnitureplan.sit", "Something wrong happened, it's the reason why you can't sit on this block.");
        add("tip.furnitureplan.shiftdown", "Press SHIFT for more info.");
        add("tip.furnitureplan.click", "Right click air to switch carve kinds.");
        add("tip.furnitureplan.graver", "This graver can grave some of the state1 to mod's block.\nActually, the kinds of block it can grave is just the kind of state1 which could be used to make stairs.");
        add("tip.furnitureplan.graver.kind", "Kind: ");
        add("tip.furnitureplan.graver.kind_change", "Now carve target: ");
        for (Graver.GraveKind kind : Graver.GraveKind.values()) {
            add("tip.furnitureplan.graver.kind." + kind.name().toLowerCase(Locale.ROOT), kind.name().toLowerCase(Locale.ROOT));
        }
        add(ItemRegistration.DETRITUS.get(), "Detritus");
        add(ItemRegistration.SAWDUST.get(), "Sawdust");
        add(ItemRegistration.GRAVER.get(), "Furniture plan-graver");
        transformKinds(FoldingRegistration.getChairBlockList());
        transformKinds(FoldingRegistration.getTableBlockList());
        transformKinds(FoldingRegistration.getColumnBlockList());
        transformKinds(FoldingRegistration.getCarvedColumnBlockList());
        transformKinds(FoldingRegistration.getLightedColumnBlockList());

        add(BlockRegistration.FOOD_PLATE_BLOCK_ITEM.get(), "Food plate");
        add(BlockRegistration.GLASS_B_BLOCK_ITEM.get(), "Glass bottle");
        add(BlockRegistration.CUTLERY_ITEM.get(), "Cutlery");
        add(BlockRegistration.LANTERN_ITEM.get(), "Lantern");
        add(BlockRegistration.IRON_POT_BLOCK_ITEM.get(), "Iron pot");
        add(BlockRegistration.STOVE_BLOCK_ITEM.get(), "Stove");
        add(BlockRegistration.CUPBOARD_BLOCK_ITEM.get(), "Cupboard");
        add(BlockRegistration.VASE_B_BLOCK_ITEM.get(), "Vase(Deprecated)");
        add(BlockRegistration.TABLE_LAMP_ITEM.get(), "Table lamp");
        add(BlockRegistration.GRASS_GRASS_ITEM.get(), "Grass(In fact)");
        add("advancements.furniture.root.title", "Let's carve a furniture!");
        add("advancements.furniture.root.description", "Get a furniture graver");
        add("advancements.furniture.grassit.title", "It's worth it a grass");
        add("advancements.furniture.grassit.description", "Try to eat a grass(furnitureplan)");
        add("furnitureplan.networking.failed", "Failed to sync data.");
        transformKinds(FoldingRegistration.getPotHolderBlockList());
        transformKinds(FoldingRegistration.getBenchBlockList());
        transformKinds(FoldingRegistration.getCabinetBlockList());
    }

    public void transformKinds(@NotNull List<DeferredHolder<Block, ? extends Block>> list) {
        assert list.size() <= FoldingRegistration.PROPERTY_KINDS.size();
        for(DeferredHolder<Block, ? extends Block> ro : list) {
            String s = BuiltInRegistries.BLOCK.getKey(ro.get()).getPath().replace('_', ' ');
            add(ro.get(), s.substring(0, 1).toUpperCase(Locale.ROOT) + s.substring(1));
        }
    }
}
