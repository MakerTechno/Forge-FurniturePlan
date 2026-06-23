package nowebsite.maker.furnitureplan.common.block.abstraction;

import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface MulStateGetter<S extends Enum<S> & StringRepresentable> {
    EnumProperty<@NotNull S> getContainer();

    default List<S> getEnumPropertyObjects() {
        return getContainer().getPossibleValues();
    }
}
