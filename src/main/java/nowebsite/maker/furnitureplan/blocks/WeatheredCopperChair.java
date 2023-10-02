package nowebsite.maker.furnitureplan.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.RegistryObject;
import nowebsite.maker.furnitureplan.blocks.blockentities.ChairBlockEntity;
import org.jetbrains.annotations.NotNull;

public class WeatheredCopperChair extends ChairBlock implements IWeatheringCopper{
    private final IWeatheringCopper.WeatherState weatherState;
    public WeatheredCopperChair(RegistryObject<BlockEntityType<ChairBlockEntity>> type, @NotNull BlockState state, Properties properties, WeatheringCopper.WeatherState weatherState) {
        super(type, state, properties);
        this.weatherState = weatherState;
    }

    @Override
    public void randomTick(@NotNull BlockState state, @NotNull ServerLevel level, @NotNull BlockPos pos, @NotNull RandomSource source) {
        this.onRandomTick(state, level, pos, source);
    }

    @Override
    public boolean isRandomlyTicking(@NotNull BlockState state) {
        return IWeatheringCopper.getNext(state.getBlock()).isPresent();
    }

    @Override
    public @NotNull WeatherState getAge() {
        return this.weatherState;
    }
}
