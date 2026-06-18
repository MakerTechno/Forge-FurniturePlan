package nowebsite.maker.furnitureplan.common.block.abstraction.set;

import it.unimi.dsi.fastutil.objects.ObjectArraySet;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.registries.DeferredBlock;
import nowebsite.maker.furnitureplan.common.block.seating.BenchBlock;
import nowebsite.maker.furnitureplan.common.block.seating.ChairBlock;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.UnmodifiableView;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class FPBlockType<T extends Block> {

    private final String name;
    private final Set<DeferredBlock<T>> registered = new ObjectArraySet<>();

    private static final Map<String, FPBlockType<?>> REGISTRY = new ConcurrentHashMap<>();

    private FPBlockType(String name) {
        this.name = name;
    }

    public static <T extends Block> FPBlockType<T> create(String id) {
        FPBlockType<T> type = new FPBlockType<>(id);
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

    @Contract(pure = true)
    public static @UnmodifiableView Map<String, FPBlockType<?>> registry() {
        return Collections.unmodifiableMap(REGISTRY);
    }

    @Override
    public String toString() {
        return this.name;
    }

    public static final FPBlockType<@NotNull ChairBlock> CHAIR = create("chair");
    public static final FPBlockType<@NotNull BenchBlock> BENCH = create("bench");
}
