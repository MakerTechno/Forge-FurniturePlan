package nowebsite.maker.furnitureplan.blocks.columns;

import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class CarvedColumnBlock extends ColumnBlock {

    public CarvedColumnBlock(@NotNull BlockState state, Properties properties) {
        super(state, properties);
    }

    @Override
    public String getSpecificName() {
        return "carved_" + super.getSpecificName();
    }

    @Override
    public String parentName() {
        return getSpecificName();
    }
}