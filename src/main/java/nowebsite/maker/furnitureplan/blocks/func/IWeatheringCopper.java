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
    Supplier<BiMap<Block, Block>> NEXT_BY_BLOCK = Suppliers.memoize(() -> ImmutableBiMap.<Block, Block>builder()
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
            .build());

    Supplier<BiMap<Block, Block>> PREVIOUS_BY_BLOCK = Suppliers.memoize(() -> NEXT_BY_BLOCK.get().inverse());

    static Optional<Block> getPrevious(Block p_154891_) {
        return Optional.ofNullable(PREVIOUS_BY_BLOCK.get().get(p_154891_));
    }

    static Block getFirst(Block p_154898_) {
        Block block = p_154898_;

        for(Block block1 = PREVIOUS_BY_BLOCK.get().get(p_154898_); block1 != null; block1 = PREVIOUS_BY_BLOCK.get().get(block1)) {
            block = block1;
        }

        return block;
    }
    static Optional<BlockState> getPrevious(@NotNull BlockState p_154900_) {
        return getPrevious(p_154900_.getBlock()).map((p_154903_) -> p_154903_.withPropertiesOf(p_154900_));
    }

    static Optional<Block> getNext(Block p_154905_) {
        return Optional.ofNullable(NEXT_BY_BLOCK.get().get(p_154905_));
    }

    static @NotNull BlockState getFirst(@NotNull BlockState p_154907_) {
        return getFirst(p_154907_.getBlock()).withPropertiesOf(p_154907_);
    }

    default @NotNull Optional<BlockState> getNext(@NotNull BlockState p_154893_) {
        return getNext(p_154893_.getBlock()).map((p_154896_) -> p_154896_.withPropertiesOf(p_154893_));
    }

    @Override
    default float getChanceModifier() {
        return WeatheringCopper.super.getChanceModifier();
    }


}
