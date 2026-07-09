package nowebsite.maker.furnitureplan.common.block.decorating.columns;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockState;
import nowebsite.maker.furnitureplan.common.block.abstraction.BasePropertyExtendedBlock;
import nowebsite.maker.furnitureplan.common.block.abstraction.IWeatheringCopper;
import nowebsite.maker.furnitureplan.common.block.abstraction.set.FPBlockSetType;
import org.jetbrains.annotations.NotNull;

public class WeatheredCopperCarvedColumnBlock extends CarvedColumnBlock implements IWeatheringCopper {
    private final WeatherState weatherState;
    public WeatheredCopperCarvedColumnBlock(FPBlockSetType type, @NotNull BlockState state, Properties properties) {
        super(type, state, properties);
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
    protected BasePropertyExtendedBlock<ColumnBlock> createNewInstance(BlockState baseState, Properties properties) {
        return new WeatheredCopperCarvedColumnBlock(getType(), baseState, properties);
    }
}
