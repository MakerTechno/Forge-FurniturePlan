package nowebsite.maker.furnitureplan.registry;

import net.minecraft.core.Holder;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.component.SuspiciousStewEffects;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import oshi.util.tuples.Pair;

import java.util.ArrayList;
import java.util.List;
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
        return BlockBehaviour.Properties.of()
                .mapColor(MapColor.NONE)
                .instabreak()
                .pushReaction(PushReaction.DESTROY)
                .strength(0.2f)
                .noOcclusion()
                .noCollission()
                .isRedstoneConductor(BRUtils::never)
                .isViewBlocking(BRUtils::never);
    }
    @SafeVarargs
    protected static SuspiciousStewEffects makeEffectList(Pair<Holder<MobEffect>, Float> ...effects) {
        List<SuspiciousStewEffects.Entry> suspiciousStewEffects = new ArrayList<>();
        for (Pair<Holder<MobEffect>, Float> effect : effects) {
            suspiciousStewEffects.add(
                new SuspiciousStewEffects.Entry(
                    effect.getA(),
                    Mth.floor(effect.getB() * 20.0F)
                )
            );
        }
        return new SuspiciousStewEffects(suspiciousStewEffects);
    }
}
