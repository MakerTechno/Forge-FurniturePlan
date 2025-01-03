package nowebsite.maker.furnitureplan.utils;

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

    @Contract(pure = true)
    public static boolean isInBox(@NotNull Vec3 point, @NotNull Vec3 from, @NotNull Vec3 to) {
        return (point.x >= Math.min(from.x, to.x) && point.x <= Math.max(from.x, to.x)) &&
            (point.y >= Math.min(from.y, to.y) && point.y <= Math.max(from.y, to.y)) &&
            (point.z >= Math.min(from.z, to.z) && point.z <= Math.max(from.z, to.z));
    }
    public static boolean isInBox(Vec3 point, @NotNull RCube cube){
        return isInBox(point, cube.from(), cube.end());
    }
    public static boolean isInBox(Vec3 point, @NotNull List<RCube> list) {
        for (RCube cube : list) {
            if (isInBox(point, cube)) return true;
        }
        return false;
    }
}
