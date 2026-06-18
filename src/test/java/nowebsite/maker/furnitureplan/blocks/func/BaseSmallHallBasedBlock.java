package nowebsite.maker.furnitureplan.blocks.func;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelReader;
import org.jetbrains.annotations.NotNull;

public class BaseSmallHallBasedBlock {
    public static boolean needsDownsideSupport(@NotNull LevelReader level, @NotNull BlockPos pos) {
        return canAttach(level, pos, Direction.UP.getOpposite());
    }
    public static boolean needsUpsideSupport(@NotNull LevelReader level, @NotNull BlockPos pos) {
        return canAttach(level, pos, Direction.DOWN.getOpposite());
    }
    public static boolean canAttach(@NotNull LevelReader pReader, @NotNull BlockPos pPos, Direction pDirection) {
        BlockPos blockpos = pPos.relative(pDirection);
        return pReader.getBlockState(blockpos).isFaceSturdy(pReader, blockpos, pDirection.getOpposite());
    }
}
