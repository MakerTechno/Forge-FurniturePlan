package nowebsite.maker.furnitureplan.blocks.func;

import com.google.common.base.Suppliers;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockState;
import nowebsite.maker.furnitureplan.registry.kindsblock.*;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;
import java.util.function.Supplier;

public interface IWeatheringCopper extends WeatheringCopper {
    Supplier<BiMap<Block, Block>> NEXT_BY_BLOCK = Suppliers.memoize(
        () -> ImmutableBiMap.<Block, Block>builder()
        //Here are mod's settings.
        .put(ChairBlockRegistration.CUT_COPPER_CHAIR.get(), ChairBlockRegistration.EXPOSED_CUT_COPPER_CHAIR.get())
        .put(ChairBlockRegistration.EXPOSED_CUT_COPPER_CHAIR.get(), ChairBlockRegistration.WEATHERED_CUT_COPPER_CHAIR.get())
        .put(ChairBlockRegistration.WEATHERED_CUT_COPPER_CHAIR.get(), ChairBlockRegistration.OXIDIZED_CUT_COPPER_CHAIR.get())

        .put(TableBlockRegistration.CUT_COPPER_TABLE.get(), TableBlockRegistration.EXPOSED_CUT_COPPER_TABLE.get())
        .put(TableBlockRegistration.EXPOSED_CUT_COPPER_TABLE.get(), TableBlockRegistration.WEATHERED_CUT_COPPER_TABLE.get())
        .put(TableBlockRegistration.WEATHERED_CUT_COPPER_TABLE.get(), TableBlockRegistration.OXIDIZED_CUT_COPPER_TABLE.get())

        .put(ColumnBlockRegistration.CUT_COPPER_COLUMN.get(), ColumnBlockRegistration.EXPOSED_CUT_COPPER_COLUMN.get())
        .put(ColumnBlockRegistration.EXPOSED_CUT_COPPER_COLUMN.get(), ColumnBlockRegistration.WEATHERED_CUT_COPPER_COLUMN.get())
        .put(ColumnBlockRegistration.WEATHERED_CUT_COPPER_COLUMN.get(), ColumnBlockRegistration.OXIDIZED_CUT_COPPER_COLUMN.get())

        .put(CarvedColumnBlockRegistration.CUT_COPPER_CARVED_COLUMN.get(), CarvedColumnBlockRegistration.EXPOSED_CUT_COPPER_CARVED_COLUMN.get())
        .put(CarvedColumnBlockRegistration.EXPOSED_CUT_COPPER_CARVED_COLUMN.get(), CarvedColumnBlockRegistration.WEATHERED_CUT_COPPER_CARVED_COLUMN.get())
        .put(CarvedColumnBlockRegistration.WEATHERED_CUT_COPPER_CARVED_COLUMN.get(), CarvedColumnBlockRegistration.OXIDIZED_CUT_COPPER_CARVED_COLUMN.get())

        .put(LightedColumnBlockRegistration.CUT_COPPER_LIGHTED_COLUMN.get(), LightedColumnBlockRegistration.EXPOSED_CUT_COPPER_LIGHTED_COLUMN.get())
        .put(LightedColumnBlockRegistration.EXPOSED_CUT_COPPER_LIGHTED_COLUMN.get(), LightedColumnBlockRegistration.WEATHERED_CUT_COPPER_LIGHTED_COLUMN.get())
        .put(LightedColumnBlockRegistration.WEATHERED_CUT_COPPER_LIGHTED_COLUMN.get(), LightedColumnBlockRegistration.OXIDIZED_CUT_COPPER_LIGHTED_COLUMN.get())

        .put(BenchBlockRegistration.CUT_COPPER_BENCH.get(), BenchBlockRegistration.EXPOSED_CUT_COPPER_BENCH.get())
        .put(BenchBlockRegistration.EXPOSED_CUT_COPPER_BENCH.get(), BenchBlockRegistration.WEATHERED_CUT_COPPER_BENCH.get())
        .put(BenchBlockRegistration.WEATHERED_CUT_COPPER_BENCH.get(), BenchBlockRegistration.OXIDIZED_CUT_COPPER_BENCH.get())
        .build()
    );

    Supplier<BiMap<Block, Block>> PREVIOUS_BY_BLOCK = Suppliers.memoize(() -> NEXT_BY_BLOCK.get().inverse());

    static Optional<Block> getPrevious(Block block) {
        return Optional.ofNullable(PREVIOUS_BY_BLOCK.get().get(block));
    }
    static Block getFirst(Block block) {
        Block copyBlock = block;

        for(Block block1 = PREVIOUS_BY_BLOCK.get().get(block); block1 != null; block1 = PREVIOUS_BY_BLOCK.get().get(block1)) {
            copyBlock = block1;
        }

        return copyBlock;
    }
    static Optional<BlockState> getPrevious(@NotNull BlockState state) {
        return getPrevious(state.getBlock()).map((block) -> block.withPropertiesOf(state));
    }

    static Optional<Block> getNext(Block block) {
        return Optional.ofNullable(NEXT_BY_BLOCK.get().get(block));
    }

    static @NotNull BlockState getFirst(@NotNull BlockState state) {
        return getFirst(state.getBlock()).withPropertiesOf(state);
    }

    default @NotNull Optional<BlockState> getNext(@NotNull BlockState state) {
        return getNext(state.getBlock()).map((block) -> block.withPropertiesOf(state));
    }

    @Override
    default float getChanceModifier() {
        return WeatheringCopper.super.getChanceModifier();
    }


}
