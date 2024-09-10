package nowebsite.maker.furnitureplan.blocks.singleblockfurniture;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.ChangeOverTimeBlock;
import net.minecraft.world.level.block.state.BlockState;
import nowebsite.maker.furnitureplan.blocks.func.IWeatheringCopper;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class WeatheredCopperCabinet extends CabinetBlock implements IWeatheringCopper {
    private final WeatherState weatherState;
    public WeatheredCopperCabinet(@NotNull BlockState state, Properties properties, WeatherState weatherState, boolean hasDoorRendered) {
        super(properties, state, hasDoorRendered);
        this.weatherState = weatherState;
    }
    @Override
    public void randomTick(@NotNull BlockState state, @NotNull ServerLevel level, @NotNull BlockPos pos, @NotNull RandomSource source) {
        this.changeOverTime(state, level, pos, source);
    }
    @Override
    public boolean isRandomlyTicking(@NotNull BlockState state) {
        return IWeatheringCopper.getNext(state.getBlock()).isPresent();
    }

    @Override
    public @NotNull Optional<BlockState> getNextState(@NotNull BlockState state, @NotNull ServerLevel level, @NotNull BlockPos pos, @NotNull RandomSource random) {
        int i = this.getAge().ordinal();
        int j = 0;
        int k = 0;

        for (BlockPos blockpos : BlockPos.withinManhattan(pos, 4, 4, 4)) {
            int l = blockpos.distManhattan(pos);
            if (l > 4) {
                break;
            }

            if (!blockpos.equals(pos) && level.getBlockState(blockpos).getBlock() instanceof ChangeOverTimeBlock<?> changeovertimeblock) {
                Enum<?> oenum = changeovertimeblock.getAge();
                if (this.getAge().getClass() == oenum.getClass()) {
                    int i1 = oenum.ordinal();
                    if (i1 < i) {
                        return Optional.empty();
                    }

                    if (i1 > i) {
                        k++;
                    } else {
                        j++;
                    }
                }
            }
        }

        float f = (float)(k + 1) / (float)(k + j + 1);
        float f1 = f * f * this.getChanceModifier();
        float next = random.nextFloat();
        if ( next < f1){
            this.getNext(state).ifPresent((p_153039_)->{
                level.removeBlockEntity(pos);
                level.removeBlock(pos,true);
                level.setBlockAndUpdate(pos,p_153039_);
            });
        }
        return next < f1 ? this.getNext(state) : Optional.empty();
    }
    @Override
    public @NotNull WeatherState getAge() {
        return this.weatherState;
    }

    @Override
    protected @NotNull CabinetBlock getSelfNew(Properties properties, BlockState baseState, boolean hasDoorRendered) {
        return new WeatheredCopperCabinet(baseState, properties, this.weatherState, hasDoorRendered);
    }
}
