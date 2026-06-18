package nowebsite.maker.furnitureplan.utils.voxel;

/**
 * 体素形状类型枚举
 * <p>
 * 用于指定VoxelShapeBuilder的旋转行为：
 * <ul>
 *   <li>{@link #ONLY}: 所有方向相同</li>
 *   <li>{@link #X_ROTATE}: 绕 X 轴旋转（南北-上下）</li>
 *   <li>{@link #Y_ROTATE}: 绕 Y 轴旋转（水平旋转）</li>
 *   <li>{@link #Z_ROTATE}: 绕 Z 轴旋转（东西-上下）</li>
 * </ul>
 *
 * @see VoxelShapeBuilder
 */
public enum VoxelType {
    /**
     * 所有方向相同
     * 适用于不随朝向变化的方块
     */
    ONLY,

    /**
     * 绕 X 轴旋转
     * 适用于在南北方向和上下方向变化的方块
     * 如：墙上的装饰品、门等
     */
    X_ROTATE,

    /**
     * 绕 Y 轴旋转
     * 适用于水平方向旋转的方块
     * 如：椅子、桌子、床等
     */
    Y_ROTATE,

    /**
     * 绕 Z 轴旋转
     * 适用于在东西方向和上下方向变化的方块
     * 如：横梁、管道等
     */
    Z_ROTATE
}
