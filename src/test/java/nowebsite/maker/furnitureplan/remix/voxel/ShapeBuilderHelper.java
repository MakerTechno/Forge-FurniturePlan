package nowebsite.maker.furnitureplan.remix.voxel;

import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import nowebsite.maker.furnitureplan.utils.voxel.AABBTransformHelper;
import nowebsite.maker.furnitureplan.utils.voxel.RotateCollision;
import nowebsite.maker.furnitureplan.utils.voxel.VoxelShapeBuilder;

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
    public static VoxelShape buildShapeFromEntries(VoxelShapeBuilder.ShapeEntry[] entries) {
        VoxelShape result = Shapes.empty();
        for (VoxelShapeBuilder.ShapeEntry entry : entries) {
            result = Shapes.join(result, Shapes.create(entry.box()), entry.op());
        }
        return result.optimize();
    }
    
    /**
     * 构建旋转后的四个形状（用于 X/Y/Z 旋转类型）
     * @param entries 原始 ShapeEntry 数组
     * @param axis 旋转轴
     * @return 四个方向的 VoxelShape 列表（顺序对应 A/B/C/D）
     */
    public static List<VoxelShape> buildRotatedShapes(VoxelShapeBuilder.ShapeEntry[] entries, nowebsite.maker.furnitureplan.utils.voxel.RotateCollision.Axis axis) {
        // 获取四个方向的变换函数
        List<Function<AABB, AABB>> transforms = getTransforms(axis);
        
        List<VoxelShape> result = new ArrayList<>();
        for (Function<AABB, AABB> transform : transforms) {
            VoxelShape shape = Shapes.empty();
            for (VoxelShapeBuilder.ShapeEntry entry : entries) {
                AABB transformed = transform.apply(entry.box());
                shape = Shapes.join(shape, Shapes.create(transformed), entry.op());
            }
            result.add(shape.optimize());
        }
        return result;
    }
    
    private static List<Function<AABB, AABB>> getTransforms(RotateCollision.Axis axis) {
        return switch (axis) {
            case X -> List.of(
                Function.identity(),
                nowebsite.maker.furnitureplan.utils.voxel.AABBTransformHelper::rotateXClockwise,
                a -> nowebsite.maker.furnitureplan.utils.voxel.AABBTransformHelper.rotateXClockwise(nowebsite.maker.furnitureplan.utils.voxel.AABBTransformHelper.rotateXClockwise(a)),
                nowebsite.maker.furnitureplan.utils.voxel.AABBTransformHelper::rotateCounterXClockwise
            );
            case Y -> List.of(
                Function.identity(),
                nowebsite.maker.furnitureplan.utils.voxel.AABBTransformHelper::rotateYClockwise,
                a -> nowebsite.maker.furnitureplan.utils.voxel.AABBTransformHelper.rotateYClockwise(nowebsite.maker.furnitureplan.utils.voxel.AABBTransformHelper.rotateYClockwise(a)),
                nowebsite.maker.furnitureplan.utils.voxel.AABBTransformHelper::rotateCounterYClockwise
            );
            case Z -> List.of(
                Function.identity(),
                nowebsite.maker.furnitureplan.utils.voxel.AABBTransformHelper::rotateZClockwise,
                a -> nowebsite.maker.furnitureplan.utils.voxel.AABBTransformHelper.rotateZClockwise(nowebsite.maker.furnitureplan.utils.voxel.AABBTransformHelper.rotateZClockwise(a)),
                AABBTransformHelper::rotateCounterZClockwise
            );
        };
    }
}