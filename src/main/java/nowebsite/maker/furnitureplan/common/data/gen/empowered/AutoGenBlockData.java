package nowebsite.maker.furnitureplan.common.data.gen.empowered;

import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

public interface AutoGenBlockData<T extends Block> {
    @Nullable BlockDataGenerator<? super T> getGenerator();
}
