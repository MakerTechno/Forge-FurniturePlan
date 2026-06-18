package nowebsite.maker.furnitureplan.remix.voxel;

import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.VoxelShape;
import nowebsite.maker.furnitureplan.utils.voxel.IVoxelHolder;
import nowebsite.maker.furnitureplan.utils.voxel.OnlyCollision;
import nowebsite.maker.furnitureplan.utils.voxel.RotateCollision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 体素形状工具类
 * 提供 Builder 模式构建 IVoxelHolder，支持自动旋转变换
 * <p>
 * 使用示例：
 * <pre>
 * // 简单形状（不旋转）
 * IVoxelHolder leg = VoxelShapeBuilder.ofSimple()
 *     .add(0.25, 0, 0.25, 0.75, 0.5, 0.75, BooleanOp.OR)
 *     .build();
 * 
 * // 绕Y轴旋转的形状（自动生成4个方向）
 * IVoxelHolder chairBack = VoxelShapeBuilder.ofYRot()
 *     .add(0.375, 0.5, 0, 0.625, 1, 0.125, BooleanOp.OR)
 *     .add(0.375, 0.5, 0.875, 0.625, 1, 1, BooleanOp.OR)
 *     .build();
 * </pre>
 */
public class VoxelShapeUtil {
    
    /**
     * 便捷方法：从六个坐标值创建 AABB
     */
    public static AABB box(double x1, double y1, double z1, double x2, double y2, double z2) {
        return new AABB(x1, y1, z1, x2, y2, z2);
    }
    
    /**
     * VoxelShape 构建器
     */
    public static final class VoxelShapeBuilder {
        
        private final nowebsite.maker.furnitureplan.utils.voxel.VoxelType type;           // 旋转类型
        private final List<nowebsite.maker.furnitureplan.utils.voxel.VoxelShapeBuilder.ShapeEntry> entries; // 存储的 ShapeEntry 列表
        
        private VoxelShapeBuilder(nowebsite.maker.furnitureplan.utils.voxel.VoxelType type) {
            this.type = type;
            this.entries = new ArrayList<>();
        }
        
        // ==================== 静态工厂方法 ====================
        
        /** 创建简单类型构建器（所有方向形状相同） */
        public static nowebsite.maker.furnitureplan.utils.voxel.VoxelShapeBuilder ofSimple() {
            return new nowebsite.maker.furnitureplan.utils.voxel.VoxelShapeBuilder(nowebsite.maker.furnitureplan.utils.voxel.VoxelType.ONLY);
        }
        
        /** 创建绕 X 轴旋转类型构建器 */
        public static nowebsite.maker.furnitureplan.utils.voxel.VoxelShapeBuilder ofXRot() {
            return new nowebsite.maker.furnitureplan.utils.voxel.VoxelShapeBuilder(nowebsite.maker.furnitureplan.utils.voxel.VoxelType.X_ROTATE);
        }
        
        /** 创建绕 Y 轴旋转类型构建器 */
        public static nowebsite.maker.furnitureplan.utils.voxel.VoxelShapeBuilder ofYRot() {
            return new nowebsite.maker.furnitureplan.utils.voxel.VoxelShapeBuilder(nowebsite.maker.furnitureplan.utils.voxel.VoxelType.Y_ROTATE);
        }
        
        /** 创建绕 Z 轴旋转类型构建器 */
        public static nowebsite.maker.furnitureplan.utils.voxel.VoxelShapeBuilder ofZRot() {
            return new nowebsite.maker.furnitureplan.utils.voxel.VoxelShapeBuilder(nowebsite.maker.furnitureplan.utils.voxel.VoxelType.Z_ROTATE);
        }
        
        // ==================== 添加形状方法 ====================
        
        /** 添加一个 ShapeEntry */
        public nowebsite.maker.furnitureplan.utils.voxel.VoxelShapeBuilder add(nowebsite.maker.furnitureplan.utils.voxel.VoxelShapeBuilder.ShapeEntry entry) {
            this.entries.add(entry);
            return this;
        }
        
        /** 添加 AABB 和 BooleanOp */
        public nowebsite.maker.furnitureplan.utils.voxel.VoxelShapeBuilder add(AABB shape, BooleanOp op) {
            this.entries.add(new nowebsite.maker.furnitureplan.utils.voxel.VoxelShapeBuilder.ShapeEntry(shape, op));
            return this;
        }
        
        /** 便捷方法：通过六参数添加 AABB */
        public nowebsite.maker.furnitureplan.utils.voxel.VoxelShapeBuilder add(double x1, double y1, double z1, double x2, double y2, double z2, BooleanOp op) {
            return add(new AABB(x1, y1, z1, x2, y2, z2), op);
        }
        
        /** 批量添加多个 ShapeEntry */
        public nowebsite.maker.furnitureplan.utils.voxel.VoxelShapeBuilder addAll(nowebsite.maker.furnitureplan.utils.voxel.VoxelShapeBuilder.ShapeEntry... entries) {
            this.entries.addAll(Arrays.asList(entries));
            return this;
        }
        
        // ==================== 构建方法 ====================
        
        /** 构建最终的 IVoxelHolder */
        public nowebsite.maker.furnitureplan.utils.voxel.IVoxelHolder build() {
            if (entries.isEmpty()) {
                throw new IllegalStateException("No shapes added to builder");
            }
            
            // 转换为数组供工具类使用
            nowebsite.maker.furnitureplan.utils.voxel.VoxelShapeBuilder.ShapeEntry[] entryArray = entries.toArray(new nowebsite.maker.furnitureplan.utils.voxel.VoxelShapeBuilder.ShapeEntry[0]);
            
            return switch (type) {
                case ONLY -> new OnlyCollision(ShapeBuilderHelper.buildShapeFromEntries(entryArray));
                case X_ROTATE -> buildRotated(nowebsite.maker.furnitureplan.utils.voxel.RotateCollision.Axis.X, entryArray);
                case Y_ROTATE -> buildRotated(nowebsite.maker.furnitureplan.utils.voxel.RotateCollision.Axis.Y, entryArray);
                case Z_ROTATE -> buildRotated(nowebsite.maker.furnitureplan.utils.voxel.RotateCollision.Axis.Z, entryArray);
            };
        }
        
        /**
         * 构建旋转类型的 IVoxelHolder
         */
        private IVoxelHolder buildRotated(nowebsite.maker.furnitureplan.utils.voxel.RotateCollision.Axis axis, nowebsite.maker.furnitureplan.utils.voxel.VoxelShapeBuilder.ShapeEntry[] entries) {
            List<VoxelShape> directionShapes = ShapeBuilderHelper.buildRotatedShapes(entries, axis);
            return new RotateCollision(axis,
                directionShapes.get(0), directionShapes.get(1),
                directionShapes.get(2), directionShapes.get(3)
            );
        }
    }
    
    /**
     * 体素形状类型枚举
     * ONLY: 所有方向相同
     * X_ROTATE: 绕 X 轴旋转
     * Y_ROTATE: 绕 Y 轴旋转
     * Z_ROTATE: 绕 Z 轴旋转
     */
    public enum VoxelType {
        ONLY, X_ROTATE, Y_ROTATE, Z_ROTATE
    }
}