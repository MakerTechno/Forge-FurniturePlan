package nowebsite.maker.furnitureplan.common.block.abstraction.set;

import it.unimi.dsi.fastutil.objects.ObjectArraySet;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import nowebsite.maker.furnitureplan.common.block.decorating.columns.CarvedColumnBlock;
import nowebsite.maker.furnitureplan.common.block.decorating.columns.ColumnBlock;
import nowebsite.maker.furnitureplan.common.block.decorating.columns.LightedColumnBlock;
import nowebsite.maker.furnitureplan.common.block.seating.BenchBlock;
import nowebsite.maker.furnitureplan.common.block.seating.ChairBlock;
import nowebsite.maker.furnitureplan.common.block.storaging.CabinetBlock;
import nowebsite.maker.furnitureplan.common.block.storaging.CupboardBlock;
import nowebsite.maker.furnitureplan.common.block.surfacing.MoonShelfBlock;
import nowebsite.maker.furnitureplan.common.block.surfacing.PotHolderBlock;
import nowebsite.maker.furnitureplan.common.block.surfacing.TableBlock;
import nowebsite.maker.furnitureplan.common.block.surfacing.WallShelfBlock;
import nowebsite.maker.furnitureplan.common.data.gen.FPChineseProvider;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.UnmodifiableView;

import java.util.*;
import java.util.function.Consumer;

public class FPBlockType<T extends Block> {

    private final String name;
    private final boolean withHover;
    private final String hoverKey;
    private final Set<DeferredBlock<T>> registered = new ObjectArraySet<>();
    private final Map<String, String> translations = new HashMap<>();

    private static final Map<String, FPBlockType<?>> REGISTRY = new LinkedHashMap<>();

    private FPBlockType(String name, Consumer<Map<String, String>> transInit) {
        this(name, transInit, false, null);
    }
    private FPBlockType(String name, Consumer<Map<String, String>> transInit, boolean withHover, @Nullable String hoverKey) {
        this.name = name;
        transInit.accept(translations);
        this.withHover = withHover;
        this.hoverKey = hoverKey;
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

    @SuppressWarnings("unused")
    public Set<DeferredBlock<T>> getAll() {
        return Collections.unmodifiableSet(registered);
    }

    public Map<String, String> getTranslations() {
        return translations;
    }

    public boolean isWithHover() {
        return withHover;
    }

    public String getHoverKey() {
        return hoverKey;
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
    public static final FPBlockType<@NotNull ColumnBlock> COLUMN = create("column", map -> map.put(FPChineseProvider.LOCALE, "柱"));
    public static final FPBlockType<@NotNull CarvedColumnBlock> CARVED_COLUMN = create("carved_column", map -> map.put(FPChineseProvider.LOCALE, "雕纹柱"));
    public static final FPBlockType<@NotNull LightedColumnBlock> LIGHTED_COLUMN = create("lighted_column", map -> map.put(FPChineseProvider.LOCALE, "嵌灯柱"));
    public static final FPBlockType<@NotNull PotHolderBlock> POT_HOLDER = create("pot_holder", map -> map.put(FPChineseProvider.LOCALE, "花架"));
    public static final FPBlockType<@NotNull TableBlock> TABLE = create("table", map -> map.put(FPChineseProvider.LOCALE, "桌"));
    public static final FPBlockType<@NotNull CupboardBlock> CUPBOARD = create("cupboard", map -> map.put(FPChineseProvider.LOCALE, "橱柜"));
    public static final FPBlockType<@NotNull CabinetBlock> CABINET = create("cabinet", map -> map.put(FPChineseProvider.LOCALE, "柜子"));
    public static final FPBlockType<@NotNull MoonShelfBlock> MOON_SHELF = create("moon_shelf", map -> map.put(FPChineseProvider.LOCALE, "圆月架"));
    public static final FPBlockType<@NotNull WallShelfBlock> WALL_SHELF = create("wall_shelf", map -> map.put(FPChineseProvider.LOCALE, "墙架"));
}
