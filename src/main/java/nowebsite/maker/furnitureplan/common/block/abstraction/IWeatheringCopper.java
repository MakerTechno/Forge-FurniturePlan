package nowebsite.maker.furnitureplan.common.block.abstraction;

import net.minecraft.world.level.block.WeatheringCopper;
import nowebsite.maker.furnitureplan.common.block.abstraction.set.FPBlockSetType;
import nowebsite.maker.furnitureplan.common.init.FPBlockSetTypes;

public interface IWeatheringCopper extends WeatheringCopper {
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
