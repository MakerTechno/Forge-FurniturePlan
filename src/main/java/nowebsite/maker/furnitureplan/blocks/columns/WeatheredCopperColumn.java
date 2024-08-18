package nowebsite.maker.furnitureplan.blocks.columns;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;
import nowebsite.maker.furnitureplan.blocks.func.IWeatheringCopper;
import org.jetbrains.annotations.NotNull;

public class WeatheredCopperColumn extends ColumnBlock implements IWeatheringCopper {
    private final WeatherState weatherState;
    public WeatheredCopperColumn(@NotNull BlockState state, Properties properties, WeatherState weatherState) {
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
