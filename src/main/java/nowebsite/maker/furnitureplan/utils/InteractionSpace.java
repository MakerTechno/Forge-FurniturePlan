package nowebsite.maker.furnitureplan.utils;

import net.minecraft.core.Direction;
import net.minecraft.world.phys.AABB;
import nowebsite.maker.furnitureplan.utils.voxel.AABBTransformHelper;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public record InteractionSpace(AABB boxN, AABB boxE, AABB boxS, AABB boxW) {
    @Contract("_, _, _, _, _, _ -> new")
    public static @NotNull InteractionSpace create(double d1, double d2, double d3, double s1, double s2, double s3) {
        AABB originN = new AABB(d1, d2, d3, s1, s2, s3);
        return new InteractionSpace(
            originN,
            AABBTransformHelper.rotateCounterYClockwise(originN),
            AABBTransformHelper.rotateY180(originN),
            AABBTransformHelper.rotateYClockwise(originN)
        );
    }

    public AABB getShape(Direction facing) {
        return switch (facing) {
            case NORTH -> this.boxN;
            case EAST -> this.boxE;
            case SOUTH -> this.boxS;
            case WEST -> this.boxW;
            default -> throw new IllegalArgumentException("Direction " + facing + " not supported for Y axis rotation");
        };
    }
}
