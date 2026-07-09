package nowebsite.maker.furnitureplan.common.block.seating;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockState;
import nowebsite.maker.furnitureplan.common.block.abstraction.BasePropertyHorizontalDirectionBlock;
import nowebsite.maker.furnitureplan.common.block.abstraction.IWeatheringCopper;
import nowebsite.maker.furnitureplan.common.block.abstraction.set.FPBlockSetType;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class WeatheredCopperChairBlock extends ChairBlock implements IWeatheringCopper {
    private final WeatherState weatherState;

    public WeatheredCopperChairBlock(FPBlockSetType type, BlockState state, Consumer<Properties> extraProperties, float yOff) {
        super(type, state, extraProperties, yOff);
        this.weatherState = IWeatheringCopper.getStateBySet(type);
    }
    public WeatheredCopperChairBlock(FPBlockSetType type, BlockState state, Properties properties, float yOff) {
        super(type, state, properties, yOff);
        this.weatherState = IWeatheringCopper.getStateBySet(type);
    }

    @Override
    public void randomTick(@NotNull BlockState state, @NotNull ServerLevel level, @NotNull BlockPos pos, @NotNull RandomSource source) {
        this.changeOverTime(state, level, pos, source);
    }
    @Override
    public boolean isRandomlyTicking(@NotNull BlockState state) {
        return WeatheringCopper.getNext(state.getBlock()).isPresent();
    }
    @Override
    public @NotNull WeatherState getAge() {
        return this.weatherState;
    }

    @Override
    protected BasePropertyHorizontalDirectionBlock<ChairBlock> createNewInstance(BlockState baseState, Properties properties) {
        return new WeatheredCopperChairBlock(getType(), baseState, properties, yOff);
    }
}
