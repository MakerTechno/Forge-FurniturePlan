package nowebsite.maker.furnitureplan.utils.interaction;

import net.minecraft.core.Direction;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@SuppressWarnings("unused")
public class Vec3Utils {
    @Contract(pure = true)
    public static double getYFromHit(@NotNull Direction facing, Vec3 hit) {
        return switch (facing) {
            case UP, DOWN, NORTH -> 1 - hit.x;
            case SOUTH -> hit.x;
            case WEST -> hit.z;
            case EAST -> 1 - hit.z;
        };
    }
    @Contract(pure = true)
    public static double getXFromHit(@NotNull Direction facing, Vec3 hit) {
        return switch (facing) {
            case UP -> hit.z;
            case DOWN -> 1 - hit.z;
            case NORTH, SOUTH, WEST, EAST -> hit.y;
        };
    }
    @Contract(pure = true)
    public static double getDepthFromHit(@NotNull Direction facing, Vec3 hit) {
        return switch (facing) {
            case UP, DOWN -> hit.y;
            case NORTH, SOUTH -> hit.z;
            case EAST, WEST ->  hit.x;
        };
    }

    public static boolean isInBox(Vec3 point, @NotNull InteractionSpace cube, Direction blockFacing){
        return cube.getShape(blockFacing).contains(point);
    }
    public static boolean isInBox(Vec3 point, @NotNull List<InteractionSpace> list, Direction blockFacing) {
        for (InteractionSpace cube : list) {
            if (isInBox(point, cube, blockFacing)) return true;
        }
        return false;
    }
}
