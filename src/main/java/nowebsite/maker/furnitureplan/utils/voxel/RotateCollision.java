package nowebsite.maker.furnitureplan.utils.voxel;

import net.minecraft.core.Direction;
import net.minecraft.world.phys.shapes.VoxelShape;

/**
 * 旋转碰撞箱持有器
 * 根据旋转轴，将4个形状映射到不同的朝向
 * <p>
 * 映射规则：
 * <ul>
 *   <li>X轴旋转: NORTH -> A, UP -> B, SOUTH -> C, DOWN -> D</li>
 *   <li>Y轴旋转: NORTH -> A, EAST -> B, SOUTH -> C, WEST -> D</li>
 *   <li>Z轴旋转: EAST -> A, UP -> B, WEST -> C, DOWN -> D</li>
 * </ul>
 * <p>
 * 对于不支持的方向，返回空形状（Shapes.empty()）
 *
 * @see VoxelShapeBuilder 用于构建此类的实例
 */
public class RotateCollision implements IVoxelHolder {

    /**
     * 旋转轴枚举
     */
    public enum Axis {
        /** 绕X轴旋转（南北-上下） */
        X,
        /** 绕Y轴旋转（水平旋转） */
        Y,
        /** 绕Z轴旋转（东西-上下） */
        Z
    }
    
    private final Axis axis;
    private final VoxelShape shapeA, shapeB, shapeC, shapeD;
    
    /**
     * 构造一个旋转碰撞箱持有器
     *
     * @param axis 旋转轴
     * @param shapeA 第一个形状（对应映射规则中的A）
     * @param shapeB 第二个形状（对应映射规则中的B）
     * @param shapeC 第三个形状（对应映射规则中的C）
     * @param shapeD 第四个形状（对应映射规则中的D）
     */
    public RotateCollision(Axis axis, VoxelShape shapeA, VoxelShape shapeB, VoxelShape shapeC, VoxelShape shapeD) {
        this.axis = axis;
        this.shapeA = shapeA;
        this.shapeB = shapeB;
        this.shapeC = shapeC;
        this.shapeD = shapeD;
    }

    public Axis getAxis() {
        return axis;
    }

    @Override
    public VoxelShape getShape(Direction facing) {
        return switch (this.axis) {
            case X -> switch (facing) {
                case NORTH -> this.shapeA;
                case UP -> this.shapeB;
                case SOUTH -> this.shapeC;
                case DOWN -> this.shapeD;
                default -> throw new IllegalArgumentException("Direction " + facing + " not supported for X axis rotation");
            };
            case Y -> switch (facing) {
                case NORTH -> this.shapeA;
                case EAST -> this.shapeB;
                case SOUTH -> this.shapeC;
                case WEST -> this.shapeD;
                default -> throw new IllegalArgumentException("Direction " + facing + " not supported for Y axis rotation");
            };
            case Z -> switch (facing) {
                case EAST -> this.shapeA;
                case UP -> this.shapeB;
                case WEST -> this.shapeC;
                case DOWN -> this.shapeD;
                default -> throw new IllegalArgumentException("Direction " + facing + " not supported for Z axis rotation");
            };
        };
    }
}