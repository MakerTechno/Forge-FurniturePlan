package nowebsite.maker.furnitureplan.common.block.abstraction.set;

import it.unimi.dsi.fastutil.objects.ObjectArraySet;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.registries.DeferredBlock;
import nowebsite.maker.furnitureplan.common.block.seating.BenchBlock;
import nowebsite.maker.furnitureplan.common.block.seating.ChairBlock;
import nowebsite.maker.furnitureplan.common.data.gen.FPChineseProvider;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.UnmodifiableView;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

public class FPBlockType<T extends Block> {

    private final String name;
    private final Set<DeferredBlock<T>> registered = new ObjectArraySet<>();
    private final Map<String, String> translations = new HashMap<>();

    private static final Map<String, FPBlockType<?>> REGISTRY = new ConcurrentHashMap<>();

    private FPBlockType(String name, Consumer<Map<String, String>> transInit) {
        this.name = name;
        transInit.accept(translations);
    }

    public static <T extends Block> FPBlockType<T> create(String id, Consumer<Map<String, String>> transInit) {
        FPBlockType<T> type = new FPBlockType<>(id, transInit);
        REGISTRY.put(id, type);
        return type;
    }

    public String name() {
        return name;
    }

    public void register(DeferredBlock<T> block) {
        registered.add(block);
    }

    public Set<DeferredBlock<T>> getAll() {
        return Collections.unmodifiableSet(registered);
    }

    public Map<String, String> getTranslations() {
        return translations;
    }

    @Contract(pure = true)
    public static @UnmodifiableView Map<String, FPBlockType<?>> registry() {
        return Collections.unmodifiableMap(REGISTRY);
    }

    @Override
    public String toString() {
        return this.name;
    }

    public static final FPBlockType<@NotNull ChairBlock> CHAIR = create("chair", map -> map.put(FPChineseProvider.LOCALE, "椅"));
    public static final FPBlockType<@NotNull BenchBlock> BENCH = create("bench", map -> map.put(FPChineseProvider.LOCALE, "凳"));
}
