package nowebsite.maker.furnitureplan.remix.voxel;

import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * 形状构建辅助类（供生成的代码调用）
 */
public final class ShapeBuilderHelper {
    
    private ShapeBuilderHelper() {}
    
    /**
     * 从 ShapeEntry 数组构建单个 VoxelShape
     * @param entries ShapeEntry 数组（包含 AABB 和 BooleanOp）
     * @return 合并后的 VoxelShape
     */
    public static VoxelShape buildShapeFromEntries(ShapeEntry[] entries) {
        VoxelShape result = Shapes.empty();
        for (ShapeEntry entry : entries) {
            result = Shapes.join(result, Shapes.create(entry.getBox()), entry.getOp());
        }
        return result.optimize();
    }
    
    /**
     * 构建旋转后的四个形状（用于 X/Y/Z 旋转类型）
     * @param entries 原始 ShapeEntry 数组
     * @param axis 旋转轴
     * @return 四个方向的 VoxelShape 列表（顺序对应 A/B/C/D）
     */
    public static List<VoxelShape> buildRotatedShapes(ShapeEntry[] entries, RotateCollision.Axis axis) {
        // 获取四个方向的变换函数
        List<Function<AABB, AABB>> transforms = getTransforms(axis);
        
        List<VoxelShape> result = new ArrayList<>();
        for (Function<AABB, AABB> transform : transforms) {
            VoxelShape shape = Shapes.empty();
            for (ShapeEntry entry : entries) {
                AABB transformed = transform.apply(entry.getBox());
                shape = Shapes.join(shape, Shapes.create(transformed), entry.getOp());
            }
            result.add(shape.optimize());
        }
        return result;
    }
    
    private static List<Function<AABB, AABB>> getTransforms(RotateCollision.Axis axis) {
        return switch (axis) {
            case X -> List.of(
                Function.identity(),
                AABBTransformHelper::rotateXClockwise,
                a -> AABBTransformHelper.rotateXClockwise(AABBTransformHelper.rotateXClockwise(a)),
                AABBTransformHelper::rotateCounterXClockwise
            );
            case Y -> List.of(
                Function.identity(),
                AABBTransformHelper::rotateYClockwise,
                a -> AABBTransformHelper.rotateYClockwise(AABBTransformHelper.rotateYClockwise(a)),
                AABBTransformHelper::rotateCounterYClockwise
            );
            case Z -> List.of(
                Function.identity(),
                AABBTransformHelper::rotateZClockwise,
                a -> AABBTransformHelper.rotateZClockwise(AABBTransformHelper.rotateZClockwise(a)),
                AABBTransformHelper::rotateCounterZClockwise
            );
        };
    }
}