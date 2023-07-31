package nowebsite.maker.furnitureplan.setup;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.RegistryObject;
import nowebsite.maker.furnitureplan.FurniturePlan;
import nowebsite.maker.furnitureplan.registry.FoldingRegistration;
import nowebsite.maker.furnitureplan.registry.ItemRegistration;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@EventBusSubscriber(modid = FurniturePlan.MOD_ID, bus = Bus.MOD)
public class SetupWithEvents {
    public SetupWithEvents() {
    }

    @SubscribeEvent
    public static void registerCreativeModeTab(CreativeModeTabEvent.@NotNull Register event) {
        event.registerCreativeModeTab(
                new ResourceLocation(FurniturePlan.MOD_ID, "main_tab"),
                (builder) -> builder.displayItems((parameters, output) -> {
                    initKindsItem(output, FoldingRegistration.getChairItemLists());
                    initKindsItem(output, FoldingRegistration.getTableItemLists());
                })
                .title(Component.translatable("itemGroup.furniture"))
                .icon(() -> new ItemStack(ItemRegistration.TEST_ITEM.get()))
        );
    }

    public static void initKindsItem(CreativeModeTab.Output output, @NotNull List<RegistryObject<? extends Item>> list) {
        assert list.size() == 53;
        for(RegistryObject<? extends Item> ro : list){
            output.accept(ro.get());
        }
    }
}
