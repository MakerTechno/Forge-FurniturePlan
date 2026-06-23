package nowebsite.maker.furnitureplan.common.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import nowebsite.maker.furnitureplan.FurniturePlan;
import org.jetbrains.annotations.NotNull;

public class FPCreativeModTabReg {
    public static void touch() {

    }

    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FurniturePlan.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, @NotNull CreativeModeTab> MISCELLANEOUS = TABS.register(
        "miscellaneous",
        () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.furniture.miscellaneous"))
            .icon(() -> new ItemStack(FPBlockReg.TABLE_LAMP_BLOCK.get()))
            .build()
    );
    public static final DeferredHolder<CreativeModeTab, @NotNull CreativeModeTab> SITTING = TABS.register(
        "sitting",
        () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.furniture.sitting"))
            .icon(() -> new ItemStack(FPBlockReg.AUTO_FURNITURE_SET.stream()
                .filter(set -> set.materialType.equals(FPBlockSetTypes.OAK_SET))
                .findFirst()
                .map(set -> (Block)set.CHAIR.get())
                .orElse(Blocks.LANTERN)
            )).build()
    );
    public static final DeferredHolder<CreativeModeTab, @NotNull CreativeModeTab> SURFACING = TABS.register(
        "surfacing",
        () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.furniture.surfacing"))
            .icon(() -> new ItemStack(FPBlockReg.AUTO_FURNITURE_SET.stream()
                .filter(set -> set.materialType.equals(FPBlockSetTypes.MOSSY_COBBLESTONE_SET))
                .findFirst()
                .map(set -> (Block)set.TABLE.get())
                .orElse(Blocks.LANTERN)
            )).build());
    public static final DeferredHolder<CreativeModeTab, @NotNull CreativeModeTab> DECORATING = TABS.register(
        "decorating",
        () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.furniture.decorating"))
            .icon(() -> new ItemStack(FPBlockReg.AUTO_FURNITURE_SET.stream()
                .filter(set -> set.materialType.equals(FPBlockSetTypes.MUD_BRICK_SET))
                .findFirst()
                .map(set -> (Block)set.LIGHTED_COLUMN.get())
                .orElse(Blocks.LANTERN)
            )).build());
    public static final DeferredHolder<CreativeModeTab, @NotNull CreativeModeTab> STORAGING = TABS.register(
        "storaging",
        () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.furniture.storaging"))
            .icon(() -> new ItemStack(FPBlockReg.AUTO_FURNITURE_SET.stream()
                .filter(set -> set.materialType.equals(FPBlockSetTypes.SPRUCE_SET))
                .findFirst()
                .map(set -> (Block)set.CUPBOARD.get())
                .orElse(Blocks.LANTERN)
            )).build());

    public static void registerCreativeTabs(BuildCreativeModeTabContentsEvent event) {
        if (event.getTab().equals(MISCELLANEOUS.get())) {
            event.accept(FPBlockReg.TABLE_LAMP_BLOCK.get());
            event.accept(FPBlockReg.LANTERN_BLOCK_P1.get());
            event.accept(FPBlockReg.LANTERN_BLOCK_P2.get());
            event.accept(FPBlockReg.IRON_POT_ITEM.get());
            event.accept(FPBlockReg.GRASS_GRASS_ITEM.get());
        }
        if (event.getTab().equals(SITTING.get())) {
            event.acceptAll(FPBlockReg.CHAIRS.get().stream().map(Block::asItem).map(Item::getDefaultInstance).toList());
            event.acceptAll(FPBlockReg.BENCHES.get().stream().map(Block::asItem).map(Item::getDefaultInstance).toList());
        }
        if (event.getTab().equals(SURFACING.get())) {
            event.acceptAll(FPBlockReg.TABLES.get().stream().map(Block::asItem).map(Item::getDefaultInstance).toList());
            event.acceptAll(FPBlockReg.POT_HOLDERS.get().stream().map(Block::asItem).map(Item::getDefaultInstance).toList());
        }
        if (event.getTab().equals(DECORATING.get())) {
            event.acceptAll(FPBlockReg.COLUMNS.get().stream().map(Block::asItem).map(Item::getDefaultInstance).toList());
            event.acceptAll(FPBlockReg.CARVED_COLUMNS.get().stream().map(Block::asItem).map(Item::getDefaultInstance).toList());
            event.acceptAll(FPBlockReg.LIGHTED_COLUMNS.get().stream().map(Block::asItem).map(Item::getDefaultInstance).toList());
        }
        if (event.getTab().equals(STORAGING.get())) {
            event.acceptAll(FPBlockReg.CUPBOARDS.get().stream().map(Block::asItem).map(Item::getDefaultInstance).toList());
        }
    }
}
