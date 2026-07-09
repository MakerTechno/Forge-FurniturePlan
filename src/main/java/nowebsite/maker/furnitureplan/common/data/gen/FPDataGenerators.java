package nowebsite.maker.furnitureplan.common.data.gen;

import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import nowebsite.maker.furnitureplan.FurniturePlan;
import nowebsite.maker.furnitureplan.common.data.gen.empowered.AutoGenBlockData;
import nowebsite.maker.furnitureplan.common.data.gen.empowered.BlockDataGenerator;
import nowebsite.maker.furnitureplan.common.init.FPBlockReg;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 功能: 所有数据生成器的中心注册器，虽属事件部分但仍乐意将其放于此处。
 */
@EventBusSubscriber(modid = FurniturePlan.MOD_ID)
public class FPDataGenerators {
    public static final Map<Block, BlockDataGenerator<?>> GENERATORS = new LinkedHashMap<>();
    @SubscribeEvent
    public static void gatherClientData(GatherDataEvent.Client event) {
        FPBlockReg.BLOCKS.getEntries().stream().sorted(Comparator.comparing(DeferredHolder::getRegisteredName)).forEach(holder -> {
            if (holder.get() instanceof AutoGenBlockData<?> block && block.getGenerator() != null) {
                GENERATORS.put(holder.get(), block.getGenerator());
            }
        });
        event.createProvider(FPModelProvider::new);
        event.createProvider(FPBlockTagsProvider::new);
        event.createProvider(FPItemTagsProvider::new);
        event.createProvider((FPLootTableProvider::new));
        event.createProvider(FPChineseProvider::new);
        event.createProvider(FPEnglishProvider::new);
        event.createProvider(FPRecipeProvider.Runner::new);
        event.createProvider(FPDataMapProvider::new);
    }
    /*@SubscribeEvent
    public void gatherServerData(GatherDataEvent.Server event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookup = event.getLookupProvider();
    }*/
}
