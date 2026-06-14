package nowebsite.maker.furnitureplan.remix.voxel;

import net.minecraft.core.Direction;
import net.minecraft.world.phys.shapes.VoxelShape;

/**
 * 旋转碰撞箱持有器
 * 根据旋转轴，将4个形状映射到不同的朝向
 * <p>
 * 映射规则：
 * - X轴旋转: NORTH -> A, UP -> B, SOUTH -> C, DOWN -> D
 * - Y轴旋转: NORTH -> A, EAST -> B, SOUTH -> C, WEST -> D
 * - Z轴旋转: EAST -> A, UP -> B, WEST -> C, DOWN -> D
 */
public class RotateCollision implements IVoxelHolder {
    public enum Axis {
        X, Y, Z
    }
    
    private final Axis axis;
    private final VoxelShape shapeA, shapeB, shapeC, shapeD;
    
    public RotateCollision(Axis axis, VoxelShape shapeA, VoxelShape shapeB, VoxelShape shapeC, VoxelShape shapeD) {
        this.axis = axis;
        this.shapeA = shapeA;
        this.shapeB = shapeB;
        this.shapeC = shapeC;
        this.shapeD = shapeD;
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