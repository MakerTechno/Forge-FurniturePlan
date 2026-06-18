package nowebsite.maker.furnitureplan.utils.voxel;

import net.minecraft.world.phys.AABB;

/**
 * AABB 变换工具类
 * 提供绕各轴旋转90度、180度、270度的变换方法
 * <p>
 * 坐标系说明：
 * <ul>
 *   <li>X轴: 东(+) / 西(-)</li>
 *   <li>Y轴: 上(+) / 下(-)</li>
 *   <li>Z轴: 南(+) / 北(-)</li>
 * </ul>
 * 所有变换均在 [0,1] 区间内进行
 * <p>
 * 使用示例：
 * <pre>
 * AABB box = new AABB(0.25, 0, 0.25, 0.75, 0.5, 0.75);
 * AABB rotated = AABBTransformHelper.rotateYClockwise(box);
 * </pre>
 */
@SuppressWarnings("SuspiciousNameCombination")
public final class AABBTransformHelper {

    // ==================== 绕 Y 轴旋转 ====================

    /**
     * 绕 Y 轴顺时针旋转90度
     * <p>
     * 变换公式: (x, z) -> (z, 1-x)
     *
     * @param box 原始AABB
     * @return 旋转后的AABB
     */
    public static AABB rotateYClockwise(AABB box) {
        double newMinX = box.minZ;
        double newMinZ = 1 - box.maxX;
        double newMaxX = box.maxZ;
        double newMaxZ = 1 - box.minX;
        return new AABB(newMinX, box.minY, newMinZ, newMaxX, box.maxY, newMaxZ);
    }

    /**
     * 绕 Y 轴逆时针旋转90度
     * <p>
     * 变换公式: (x, z) -> (1-z, x)
     *
     * @param box 原始AABB
     * @return 旋转后的AABB
     */
    public static AABB rotateCounterYClockwise(AABB box) {
        double newMinX = 1 - box.maxZ;
        double newMinZ = box.minX;
        double newMaxX = 1 - box.minZ;
        double newMaxZ = box.maxX;
        return new AABB(newMinX, box.minY, newMinZ, newMaxX, box.maxY, newMaxZ);
    }

    /**
     * 绕 Y 轴旋转180度
     * <p>
     * 变换公式: (x, z) -> (1-x, 1-z)
     *
     * @param box 原始AABB
     * @return 旋转后的AABB
     */
    public static AABB rotateY180(AABB box) {
        return rotateYClockwise(rotateYClockwise(box));
    }

    // ==================== 绕 X 轴旋转 ====================

    /**
     * 绕 X 轴顺时针旋转90度
     * <p>
     * 变换公式: (y, z) -> (z, 1-y)
     *
     * @param box 原始AABB
     * @return 旋转后的AABB
     */
    public static AABB rotateXClockwise(AABB box) {
        double newMinY = box.minZ;
        double newMinZ = 1 - box.maxY;
        double newMaxY = box.maxZ;
        double newMaxZ = 1 - box.minY;
        return new AABB(box.minX, newMinY, newMinZ, box.maxX, newMaxY, newMaxZ);
    }

    /**
     * 绕 X 轴逆时针旋转90度
     * <p>
     * 变换公式: (y, z) -> (1-z, y)
     *
     * @param box 原始AABB
     * @return 旋转后的AABB
     */
    public static AABB rotateCounterXClockwise(AABB box) {
        double newMinY = 1 - box.maxZ;
        double newMinZ = box.minY;
        double newMaxY = 1 - box.minZ;
        double newMaxZ = box.maxY;
        return new AABB(box.minX, newMinY, newMinZ, box.maxX, newMaxY, newMaxZ);
    }

    /**
     * 绕 X 轴旋转180度
     * <p>
     * 变换公式: (y, z) -> (1-y, 1-z)
     *
     * @param box 原始AABB
     * @return 旋转后的AABB
     */
    public static AABB rotateX180(AABB box) {
        return rotateXClockwise(rotateXClockwise(box));
    }

    // ==================== 绕 Z 轴旋转 ====================

    /**
     * 绕 Z 轴顺时针旋转90度
     * <p>
     * 变换公式: (x, y) -> (y, 1-x)
     *
     * @param box 原始AABB
     * @return 旋转后的AABB
     */
    public static AABB rotateZClockwise(AABB box) {
        double newMinX = box.minY;
        double newMinY = 1 - box.maxX;
        double newMaxX = box.maxY;
        double newMaxY = 1 - box.minX;
        return new AABB(newMinX, newMinY, box.minZ, newMaxX, newMaxY, box.maxZ);
    }

    /**
     * 绕 Z 轴逆时针旋转90度
     * <p>
     * 变换公式: (x, y) -> (1-y, x)
     *
     * @param box 原始AABB
     * @return 旋转后的AABB
     */
    public static AABB rotateCounterZClockwise(AABB box) {
        double newMinX = 1 - box.maxY;
        double newMinY = box.minX;
        double newMaxX = 1 - box.minY;
        double newMaxY = box.maxX;
        return new AABB(newMinX, newMinY, box.minZ, newMaxX, newMaxY, box.maxZ);
    }

    /**
     * 绕 Z 轴旋转180度
     * <p>
     * 变换公式: (x, y) -> (1-x, 1-y)
     *
     * @param box 原始AABB
     * @return 旋转后的AABB
     */
    public static AABB rotateZ180(AABB box) {
        return rotateZClockwise(rotateZClockwise(box));
    }

    // ==================== 通用旋转方法 ====================

    /**
     * 根据旋转轴和角度旋转AABB
     *
     * @param box 原始AABB
     * @param axis 旋转轴
     * @param degrees 旋转角度（90的倍数）
     * @param clockwise 是否顺时针
     * @return 旋转后的AABB
     */
    public static AABB rotate(AABB box, RotateCollision.Axis axis, int degrees, boolean clockwise) {
        if (degrees % 90 != 0) {
            throw new IllegalArgumentException("Degrees must be a multiple of 90");
        }

        int times = (degrees / 90) % 4;
        AABB result = box;

        for (int i = 0; i < times; i++) {
            result = switch (axis) {
                case X -> clockwise ? rotateXClockwise(result) : rotateCounterXClockwise(result);
                case Y -> clockwise ? rotateYClockwise(result) : rotateCounterYClockwise(result);
                case Z -> clockwise ? rotateZClockwise(result) : rotateCounterZClockwise(result);
            };
        }

        return result;
    }
}