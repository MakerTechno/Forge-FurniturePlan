package nowebsite.maker.furnitureplan.registry;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Material;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.function.ToIntFunction;

public class BRUtils {
    @Contract(pure = true)
    protected static @NotNull ToIntFunction<BlockState> litBlockEmission(int lightValue) {
        return (state) -> state.getValue(BlockStateProperties.LIT) ? lightValue : 0;
    }
    private static <A,B,C> boolean never(A a, B b, C c) {
        return false;
    }

    protected static BlockBehaviour.@NotNull Properties getSmallBlockBehaviors(){
        return BlockBehaviour.Properties.of(Material.DECORATION)
                .strength(0.2f)
                .noOcclusion()
                .isRedstoneConductor(BRUtils::never)
                .isViewBlocking(BRUtils::never);
    }
}
