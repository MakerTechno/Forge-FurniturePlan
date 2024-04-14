package nowebsite.maker.furnitureplan.utils;

import net.minecraft.core.Direction;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

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
}
