package nowebsite.maker.furnitureplan.remix.voxel;

import net.minecraft.world.phys.AABB;

/**
 * AABB 变换工具类
 * 提供绕各轴旋转90度、180度、270度的变换方法
 * <p>
 * 坐标系说明：
 * - X轴: 东(+) / 西(-)
 * - Y轴: 上(+) / 下(-)  
 * - Z轴: 南(+) / 北(-)
 * <p>
 * 所有变换均在 [0,1] 区间内进行
 */
@SuppressWarnings("SuspiciousNameCombination")
public class AABBTransformHelper {
    
    // ==================== 绕 Y 轴旋转 ====================
    
    /**
     * 绕 Y 轴顺时针旋转90度
     * 变换公式: (x, z) -> (z, 1-x)
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
     * 变换公式: (x, z) -> (1-z, x)
     */
    public static AABB rotateCounterYClockwise(AABB box) {
        double newMinX = 1 - box.maxZ;
        double newMinZ = box.minX;
        double newMaxX = 1 - box.minZ;
        double newMaxZ = box.maxX;
        return new AABB(newMinX, box.minY, newMinZ, newMaxX, box.maxY, newMaxZ);
    }
    
    // ==================== 绕 X 轴旋转 ====================
    
    /**
     * 绕 X 轴顺时针旋转90度
     * 变换公式: (y, z) -> (z, 1-y)
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
     * 变换公式: (y, z) -> (1-z, y)
     */
    public static AABB rotateCounterXClockwise(AABB box) {
        double newMinY = 1 - box.maxZ;
        double newMinZ = box.minY;
        double newMaxY = 1 - box.minZ;
        double newMaxZ = box.maxY;
        return new AABB(box.minX, newMinY, newMinZ, box.maxX, newMaxY, newMaxZ);
    }
    
    // ==================== 绕 Z 轴旋转 ====================
    
    /**
     * 绕 Z 轴顺时针旋转90度
     * 变换公式: (x, y) -> (y, 1-x)
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
     * 变换公式: (x, y) -> (1-y, x)
     */
    public static AABB rotateCounterZClockwise(AABB box) {
        double newMinX = 1 - box.maxY;
        double newMinY = box.minX;
        double newMaxX = 1 - box.minY;
        double newMaxY = box.maxX;
        return new AABB(newMinX, newMinY, box.minZ, newMaxX, newMaxY, box.maxZ);
    }
    
    // ==================== 便捷方法 ====================
    
    /**
     * 从六个坐标值创建 AABB
     * @param x1 最小X
     * @param y1 最小Y
     * @param z1 最小Z
     * @param x2 最大X
     * @param y2 最大Y
     * @param z2 最大Z
     */
    public static AABB of(double x1, double y1, double z1, double x2, double y2, double z2) {
        return new AABB(x1, y1, z1, x2, y2, z2);
    }
}