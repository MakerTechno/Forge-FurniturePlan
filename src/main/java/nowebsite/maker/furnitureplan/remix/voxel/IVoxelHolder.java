package nowebsite.maker.furnitureplan.remix.voxel;

import net.minecraft.core.Direction;
import net.minecraft.world.phys.shapes.VoxelShape;

/**
 * 体素形状持有器接口
 * 用于统一管理方块在不同方向下的碰撞箱/轮廓箱
 */
public interface IVoxelHolder {
    /**
     * 根据方向获取对应的体素形状
     * @param facing 方块朝向
     * @return 对应方向的VoxelShape
     */
    VoxelShape getShape(Direction facing);
    
    /**
     * 根据方向和种子获取体素形状（用于随机变体）
     * @param facing 方块朝向
     * @param seed 随机种子
     * @return 对应方向的VoxelShape
     */
    default VoxelShape getShape(Direction facing, int seed) {
        return getShape(facing);
    }
}