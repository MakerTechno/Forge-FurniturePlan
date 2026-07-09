package nowebsite.maker.furnitureplan.common.block.storaging;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockState;
import nowebsite.maker.furnitureplan.common.block.abstraction.BasePropertyHorizontalDirectionBlock;
import nowebsite.maker.furnitureplan.common.block.abstraction.IWeatheringCopper;
import nowebsite.maker.furnitureplan.common.block.abstraction.set.FPBlockSetType;
import nowebsite.maker.furnitureplan.common.block.abstraction.set.FPColorfulSetType;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class WeatheredCopperCabinet extends CabinetBlock implements IWeatheringCopper {
    private final WeatherState weatherState;
    public WeatheredCopperCabinet(FPBlockSetType type, @Nullable FPColorfulSetType frameType, Properties properties, BlockState base) {
        super(type, frameType, properties, base);
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
    protected BasePropertyHorizontalDirectionBlock<CabinetBlock> createNewInstance(BlockState baseState, Properties properties) {
        return new WeatheredCopperCabinet(getType(), getFrameType(), properties, baseState);
    }
}
