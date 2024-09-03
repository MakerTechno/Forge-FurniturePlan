package nowebsite.maker.furnitureplan.utils;

import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public record RCube(Vec3 from, Vec3 end) {
    @Contract("_, _, _, _, _, _ -> new")
    public static @NotNull RCube create(double d1, double d2, double d3, double s1, double s2, double s3) {
        return new RCube(new Vec3(d1, d2, d3), new Vec3(s1, s2, s3));
    }
}
