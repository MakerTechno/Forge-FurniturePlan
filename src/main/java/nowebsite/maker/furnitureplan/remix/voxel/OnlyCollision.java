package nowebsite.maker.furnitureplan.remix.voxel;

import net.minecraft.core.Direction;
import net.minecraft.world.phys.shapes.VoxelShape;

/**
 * 简单碰撞箱持有器
 * 所有方向返回同一个形状（适用于不随朝向变化的方块）
 */
public class OnlyCollision implements IVoxelHolder {
    private final VoxelShape shape;
    
    public OnlyCollision(VoxelShape shape) {
        this.shape = shape;
    }
    
    @Override
    public VoxelShape getShape(Direction facing) {
        return this.shape;
    }
}