package nowebsite.maker.furnitureplan.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class WeatheredCopperTable extends TableBlock implements IWeatheringCopper{
    private final WeatherState weatherState;
    public WeatheredCopperTable(@NotNull BlockState state, Properties properties, WeatherState weatherState) {
        super(state, properties);
        this.weatherState = weatherState;
    }

    @Override
    public boolean isRandomlyTicking(@NotNull BlockState state) {
        return IWeatheringCopper.getNext(state.getBlock()).isPresent();
    }

    @Override
    public void randomTick(@NotNull BlockState state, @NotNull ServerLevel level, @NotNull BlockPos pos, @NotNull RandomSource source) {
        this.onRandomTick(state, level, pos, source);
    }

    @Override
    public @NotNull WeatherState getAge() {
        return this.weatherState;
    }
}

