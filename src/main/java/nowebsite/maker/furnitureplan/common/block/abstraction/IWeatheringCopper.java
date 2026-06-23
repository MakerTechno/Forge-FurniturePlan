package nowebsite.maker.furnitureplan.common.block.abstraction;

import com.google.common.base.Suppliers;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockState;
import nowebsite.maker.furnitureplan.common.block.abstraction.set.FPBlockSetType;
import nowebsite.maker.furnitureplan.common.init.FPBlockReg;
import nowebsite.maker.furnitureplan.common.init.FPBlockSetTypes;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;
import java.util.function.Supplier;

public interface IWeatheringCopper extends WeatheringCopper {
    Supplier<BiMap<Block, Block>> NEXT_BY_BLOCK = Suppliers.memoize(
        () -> ImmutableBiMap.<Block, Block>builder()
            .put(FPBlockReg.CUT_COPPERS.get().CHAIR.get(), FPBlockReg.EXPOSED_COPPERS.get().CHAIR.get())
            .put(FPBlockReg.EXPOSED_COPPERS.get().CHAIR.get(), FPBlockReg.WEATHERED_COPPERS.get().CHAIR.get())
            .put(FPBlockReg.WEATHERED_COPPERS.get().CHAIR.get(), FPBlockReg.OXIDIZED_COPPERS.get().CHAIR.get())

            .put(FPBlockReg.CUT_COPPERS.get().BENCH.get(), FPBlockReg.EXPOSED_COPPERS.get().BENCH.get())
            .put(FPBlockReg.EXPOSED_COPPERS.get().BENCH.get(), FPBlockReg.WEATHERED_COPPERS.get().BENCH.get())
            .put(FPBlockReg.WEATHERED_COPPERS.get().BENCH.get(), FPBlockReg.OXIDIZED_COPPERS.get().BENCH.get())

            .put(FPBlockReg.CUT_COPPERS.get().TABLE.get(), FPBlockReg.EXPOSED_COPPERS.get().TABLE.get())
            .put(FPBlockReg.EXPOSED_COPPERS.get().TABLE.get(), FPBlockReg.WEATHERED_COPPERS.get().TABLE.get())
            .put(FPBlockReg.WEATHERED_COPPERS.get().TABLE.get(), FPBlockReg.OXIDIZED_COPPERS.get().TABLE.get())

            .put(FPBlockReg.CUT_COPPERS.get().COLUMN.get(), FPBlockReg.EXPOSED_COPPERS.get().COLUMN.get())
            .put(FPBlockReg.EXPOSED_COPPERS.get().COLUMN.get(), FPBlockReg.WEATHERED_COPPERS.get().COLUMN.get())
            .put(FPBlockReg.WEATHERED_COPPERS.get().COLUMN.get(), FPBlockReg.OXIDIZED_COPPERS.get().COLUMN.get())

            .put(FPBlockReg.CUT_COPPERS.get().CARVED_COLUMN.get(), FPBlockReg.EXPOSED_COPPERS.get().CARVED_COLUMN.get())
            .put(FPBlockReg.EXPOSED_COPPERS.get().CARVED_COLUMN.get(), FPBlockReg.WEATHERED_COPPERS.get().CARVED_COLUMN.get())
            .put(FPBlockReg.WEATHERED_COPPERS.get().CARVED_COLUMN.get(), FPBlockReg.OXIDIZED_COPPERS.get().CARVED_COLUMN.get())

            .put(FPBlockReg.CUT_COPPERS.get().LIGHTED_COLUMN.get(), FPBlockReg.EXPOSED_COPPERS.get().LIGHTED_COLUMN.get())
            .put(FPBlockReg.EXPOSED_COPPERS.get().LIGHTED_COLUMN.get(), FPBlockReg.WEATHERED_COPPERS.get().LIGHTED_COLUMN.get())
            .put(FPBlockReg.WEATHERED_COPPERS.get().LIGHTED_COLUMN.get(), FPBlockReg.OXIDIZED_COPPERS.get().LIGHTED_COLUMN.get())

            .put(FPBlockReg.CUT_COPPERS.get().CUPBOARD.get(), FPBlockReg.EXPOSED_COPPERS.get().CUPBOARD.get())
            .put(FPBlockReg.EXPOSED_COPPERS.get().CUPBOARD.get(), FPBlockReg.WEATHERED_COPPERS.get().CUPBOARD.get())
            .put(FPBlockReg.WEATHERED_COPPERS.get().CUPBOARD.get(), FPBlockReg.OXIDIZED_COPPERS.get().CUPBOARD.get())


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

    static WeatherState getStateBySet(FPBlockSetType type) {
        if (type.equals(FPBlockSetTypes.EXPOSED_CUT_COPPER_SET)) return WeatherState.EXPOSED;
        if (type.equals(FPBlockSetTypes.WEATHERED_CUT_COPPER_SET)) return WeatherState.WEATHERED;
        if (type.equals(FPBlockSetTypes.OXIDIZED_CUT_COPPER_SET)) return WeatherState.OXIDIZED;
        return WeatherState.UNAFFECTED;
    }

    static boolean isWeatheringType(FPBlockSetType type) {
        return type.equals(FPBlockSetTypes.CUT_COPPER_SET) ||
            type.equals(FPBlockSetTypes.EXPOSED_CUT_COPPER_SET) ||
            type.equals(FPBlockSetTypes.WEATHERED_CUT_COPPER_SET) ||
            type.equals(FPBlockSetTypes.OXIDIZED_CUT_COPPER_SET);
    }
}
