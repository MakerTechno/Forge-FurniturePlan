package nowebsite.maker.furnitureplan.remix.voxel.processor;

import nowebsite.maker.furnitureplan.utils.voxel.VoxelType;

import java.lang.annotation.*;

/**
 * 标记需要自动生成 IVoxelHolder 的字段
 * <p>
 * 使用示例：
 * <pre>
 * public class ModShapes {
 *     
 *     // 简单形状（不旋转）
 *     &#64;AutoShape(type = VoxelType.ONLY)
 *     private static final ShapeEntry[] TABLE_LEG = {
 *         new ShapeEntry(box(0.25, 0, 0.25, 0.75, 0.5, 0.75), BooleanOp.OR)
 *     };
 *     
 *     // 绕Y轴旋转的形状
 *     &#64;AutoShape(type = VoxelType.Y_ROTATE)
 *     private static final ShapeEntry[] CHAIR_BACK = {
 *         new ShapeEntry(box(0.375, 0.5, 0, 0.625, 1, 0.125), BooleanOp.OR),
 *         new ShapeEntry(box(0.375, 0.5, 0.875, 0.625, 1, 1), BooleanOp.OR)
 *     };
 * }
 * </pre>
 */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.FIELD)
public @interface AutoShape {
    
    /** 形状类型（ONLY / X_ROTATE / Y_ROTATE / Z_ROTATE） */
    VoxelType type();
    
    /** 生成的常量名称（可选，默认使用原字段名转换） */
    String name() default "";
    
    /** 是否生成（默认 true） */
    boolean generate() default true;
}