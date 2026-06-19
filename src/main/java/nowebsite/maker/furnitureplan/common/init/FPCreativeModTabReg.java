package nowebsite.maker.furnitureplan.common.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import nowebsite.maker.furnitureplan.FurniturePlan;
import org.jetbrains.annotations.NotNull;

import java.util.stream.Collectors;

public class FPCreativeModTabReg {
    public static void touch() {

    }

    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FurniturePlan.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, @NotNull CreativeModeTab> MAIN_TAB = TABS.register(
        "main_tab",
        () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.furniture"))
            .icon(() -> new ItemStack(FPBlockReg.AUTO_FURNITURE_SET.stream()
                .filter(set -> set.materialType.equals(FPBlockSetTypes.OAK_SET))
                .findFirst()
                .map(set -> (Block)set.CHAIR.get())
                .orElse(Blocks.LANTERN)
            )).build());

    public static void registerCreativeTabs(BuildCreativeModeTabContentsEvent event) {
        if (event.getTab().equals(MAIN_TAB.get())) {
            event.acceptAll(FPItemReg.ITEMS.getEntries().stream().map(DeferredHolder::get).map(ItemStack::new).collect(Collectors.toSet()));
        }
    }
}
