package nowebsite.maker.furnitureplan.utils.voxel;

import net.minecraft.core.Direction;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * VoxelShapeBuilder - 体素形状构建器
 * <p>
 * 用于以流式API构建复杂的VoxelShape，支持：
 * <ul>
 *   <li>or操作：同层级内添加多个box（并集）</li>
 *   <li>join中间件：支持嵌套的join操作，使用startJoin()/finishJoin()管理</li>
 *   <li>自动旋转：支持绕X/Y/Z轴旋转生成4个方向的形状</li>
 * </ul>
 * <p>
 * 使用示例：
 * <pre>
 * // 简单形状
 * IVoxelHolder leg = VoxelShapeBuilder.ofSimple()
 *     .or(0.25, 0, 0.25, 0.75, 0.5, 0.75)
 *     .build();
 *
 * // 绕Y轴旋转的形状（自动生成4个方向）
 * IVoxelHolder chairBack = VoxelShapeBuilder.ofYRot()
 *     .or(0.375, 0.5, 0, 0.625, 1, 0.125)
 *     .or(0.375, 0.5, 0.875, 0.625, 1, 1)
 *     .build();
 *
 * // join操作（使用ONLY_FIRST取第一个操作数）
 * IVoxelHolder shape = VoxelShapeBuilder.ofYRot()
 *     .startJoin()
 *         .or(0, 0, 0, 1, 1, 1)
 *         .next()
 *         .or(0.0625, 0.0625, 0.0625, 0.9375, 0.9375, 0.9375)
 *         .finishJoin(BooleanOp.ONLY_FIRST)
 *     .build();
 *
 * // join操作（交集）
 * IVoxelHolder complex = VoxelShapeBuilder.ofYRot()
 *     .startJoin()
 *         .or(0.25, 0, 0.33, 0.29, 0.21, 1)
 *         .or(0, 0, 0, 0.29, 0.33, 0.8)
 *         .next()
 *         .or(0.1, 0.1, 0.1, 0.9, 0.9, 0.9)
 *         .or(0.15, 0.15, 0.15, 0.85, 0.85, 0.85)
 *         .finishJoin(BooleanOp.AND)
 *     .build();
 *
 * // 嵌套join
 * IVoxelHolder nested = VoxelShapeBuilder.ofYRot()
 *     .startJoin()
 *         .or(0, 0, 0, 1, 1, 1)
 *         .next()
 *         .startJoin()                // 嵌套join作为第二个操作数
 *             .or(0.2, 0.2, 0.2, 0.8, 0.8, 0.8)
 *             .next()
 *             .or(0.3, 0.3, 0.3, 0.7, 0.7, 0.7)
 *             .finishJoin(BooleanOp.OR)
 *         .finishJoin(BooleanOp.AND)
 *     .build();
 * </pre>
 */
public final class VoxelShapeBuilder {

    private final VoxelType type;
    private final Deque<JoinMiddleware> middlewareStack;
    private JoinMiddleware currentMiddleware;
    /** 根级别的AABB（不在任何join中） */
    private final List<AABB> rootBoxes = new ArrayList<>();
    /** 根级别的join结果（已完成的join） */
    private final List<VoxelShape> rootJoins = new ArrayList<>();

    // ==================== 内部数据结构 ====================

    /**
     * Join中间件状态
     */
    private enum MiddlewareState {
        /** 正在构建第一个操作数 */
        BUILDING_FIRST,
        /** 正在构建第二个操作数 */
        BUILDING_SECOND,
        /** 已完成（finishJoin已调用） */
        COMPLETED
    }

    /**
     * Join中间件 - 管理一个join操作的两个操作数
     * <p>
     * 每个中间件包含两个操作数列表，每个操作数由多个AABB组成（OR操作）。
     * 最终通过Shapes.join()将两个操作数合并。
     */
    private static final class JoinMiddleware {
        /** 第一个操作数的AABB列表（OR并集） */
        private final List<AABB> firstOperand = new ArrayList<>();
        /** 第二个操作数的AABB列表（OR并集） */
        private final List<AABB> secondOperand = new ArrayList<>();
        /** 当前状态 */
        private MiddlewareState state = MiddlewareState.BUILDING_FIRST;
        /** 父级中间件（用于嵌套） */
        @Nullable
        private final JoinMiddleware parent;
        /** 当前操作数中是否有内容 */
        private boolean hasContent = false;
        /** 是否已完成join */
        private boolean completed = false;
        /** 完成时使用的操作符 */
        private BooleanOp completedOp = null;
        /** 完成时生成的形状 */
        private VoxelShape completedShape = null;

        JoinMiddleware(@Nullable JoinMiddleware parent) {
            this.parent = parent;
        }

        /**
         * 向当前操作数添加一个AABB
         */
        void addBox(AABB box) {
            if (completed) {
                throw new IllegalStateException("Cannot add box to completed join middleware.");
            }
            if (state == MiddlewareState.BUILDING_FIRST) {
                firstOperand.add(box);
            } else if (state == MiddlewareState.BUILDING_SECOND) {
                secondOperand.add(box);
            } else {
                throw new IllegalStateException("Cannot add box: middleware in state " + state);
            }
            hasContent = true;
        }

        /**
         * 切换到下一个操作数
         */
        void next() {
            if (completed) {
                throw new IllegalStateException("Cannot switch: join already completed.");
            }
            if (firstOperand.isEmpty()) {
                throw new IllegalStateException("Cannot switch to second operand: no boxes added to first operand");
            }
            state = MiddlewareState.BUILDING_SECOND;
        }

        /**
         * 检查当前操作数是否为空
         */
        boolean isCurrentEmpty() {
            if (state == MiddlewareState.BUILDING_FIRST) {
                return firstOperand.isEmpty();
            } else if (state == MiddlewareState.BUILDING_SECOND) {
                return secondOperand.isEmpty();
            }
            return true;
        }

        /**
         * 检查两个操作数是否都已填充
         */
        boolean isReady() {
            return !firstOperand.isEmpty() && !secondOperand.isEmpty();
        }

        /**
         * 检查是否已完成
         */
        boolean isCompleted() {
            return completed;
        }

        /**
         * 构建第一个操作数的VoxelShape
         */
        VoxelShape buildFirst() {
            return buildShapeFromAABBs(firstOperand);
        }

        /**
         * 构建第二个操作数的VoxelShape
         */
        VoxelShape buildSecond() {
            return buildShapeFromAABBs(secondOperand);
        }

        /**
         * 执行join操作
         */
        VoxelShape join(BooleanOp op) {
            if (!isReady()) {
                throw new IllegalStateException("Join not ready: first=" + !firstOperand.isEmpty() + ", second=" + !secondOperand.isEmpty());
            }
            VoxelShape first = buildFirst();
            VoxelShape second = buildSecond();
            return Shapes.join(first, second, op);
        }

        /**
         * 完成join操作
         */
        void complete(BooleanOp op) {
            if (completed) {
                return;
            }
            if (!isReady()) {
                throw new IllegalStateException("Cannot complete join: both operands must have at least one box.");
            }
            this.completed = true;
            this.completedOp = op;
            this.completedShape = join(op);
            this.state = MiddlewareState.COMPLETED;
        }

        /**
         * 获取完成的形状
         */
        VoxelShape getCompletedShape() {
            if (!completed) {
                throw new IllegalStateException("Join not completed yet.");
            }
            return completedShape;
        }

        /**
         * 从AABB列表构建VoxelShape（OR操作）
         */
        private static VoxelShape buildShapeFromAABBs(List<AABB> boxes) {
            if (boxes.isEmpty()) {
                return Shapes.empty();
            }
            VoxelShape result = Shapes.box(
                boxes.getFirst().minX, boxes.getFirst().minY, boxes.getFirst().minZ,
                boxes.getFirst().maxX, boxes.getFirst().maxY, boxes.getFirst().maxZ
            );
            for (int i = 1; i < boxes.size(); i++) {
                AABB box = boxes.get(i);
                result = Shapes.or(result, Shapes.box(
                    box.minX, box.minY, box.minZ,
                    box.maxX, box.maxY, box.maxZ
                ));
            }
            return result;
        }

        boolean hasContent() {
            return hasContent;
        }

        /**
         * 获取当前操作数的AABB列表（用于调试）
         */
        List<AABB> getCurrentOperand() {
            return state == MiddlewareState.BUILDING_FIRST ? firstOperand : secondOperand;
        }
    }

    // ==================== 构造函数 ====================

    private VoxelShapeBuilder(VoxelType type) {
        this.type = type;
        this.middlewareStack = new ArrayDeque<>();
        this.currentMiddleware = null;
    }

    // ==================== 静态工厂方法 ====================

    /**
     * 创建简单类型构建器（所有方向形状相同）
     *
     * @return VoxelShapeBuilder实例
     */
    public static VoxelShapeBuilder ofSimple() {
        return new VoxelShapeBuilder(VoxelType.ONLY);
    }

    /**
     * 创建绕 X 轴旋转类型构建器
     *
     * @return VoxelShapeBuilder实例
     */
    public static VoxelShapeBuilder ofXRot() {
        return new VoxelShapeBuilder(VoxelType.X_ROTATE);
    }

    /**
     * 创建绕 Y 轴旋转类型构建器
     *
     * @return VoxelShapeBuilder实例
     */
    public static VoxelShapeBuilder ofYRot() {
        return new VoxelShapeBuilder(VoxelType.Y_ROTATE);
    }

    /**
     * 创建绕 Z 轴旋转类型构建器
     *
     * @return VoxelShapeBuilder实例
     */
    public static VoxelShapeBuilder ofZRot() {
        return new VoxelShapeBuilder(VoxelType.Z_ROTATE);
    }

    // ==================== Join中间件管理 ====================

    /**
     * 开启一个新的join中间件
     * <p>
     * 之后添加的AABB将属于join的第一个操作数。
     * 调用 {@link #next()} 切换到第二个操作数。
     * 调用 {@link #finishJoin(BooleanOp)} 完成join。
     *
     * @return this
     * @throws IllegalStateException 如果已经在join中间件中且未完成
     */
    public VoxelShapeBuilder startJoin() {
        if (currentMiddleware != null && !currentMiddleware.isCompleted()) {
            throw new IllegalStateException("Already inside an incomplete join middleware. Call finishJoin() first.");
        }
        // 如果当前中间件已完成，将其结果添加到根级
        if (currentMiddleware != null && currentMiddleware.isCompleted()) {
            rootJoins.add(currentMiddleware.getCompletedShape());
            currentMiddleware = null;
        }

        JoinMiddleware newMiddleware = new JoinMiddleware(currentMiddleware);
        if (currentMiddleware != null) {
            // 嵌套join：将当前中间件压栈
            middlewareStack.push(currentMiddleware);
        }
        currentMiddleware = newMiddleware;
        return this;
    }

    /**
     * 切换到join的下一个操作数
     * <p>
     * 从第一个操作数切换到第二个操作数。
     * 如果当前操作数为空，会抛出异常。
     *
     * @return this
     * @throws IllegalStateException 如果不在join中间件中，或当前操作数为空
     */
    public VoxelShapeBuilder next() {
        if (currentMiddleware == null) {
            throw new IllegalStateException("Not inside a join middleware. Call startJoin() first.");
        }
        if (currentMiddleware.isCompleted()) {
            throw new IllegalStateException("Cannot switch: join already completed.");
        }
        if (currentMiddleware.isCurrentEmpty()) {
            throw new IllegalStateException("Cannot switch to next operand: current operand is empty.");
        }
        currentMiddleware.next();
        return this;
    }

    /**
     * 完成当前的join中间件
     * <p>
     * 使用指定的布尔操作符合并两个操作数，并将结果添加到父级上下文中。
     * 如果是嵌套join，结果会添加到父级中间件的当前操作数中。
     *
     * @param op 布尔操作符（AND、OR、ONLY_FIRST、ONLY_SECOND等）
     * @return this
     * @throws IllegalStateException 如果不在join中间件中，或操作数未准备就绪
     */
    public VoxelShapeBuilder finishJoin(BooleanOp op) {
        if (currentMiddleware == null) {
            throw new IllegalStateException("Not inside a join middleware. Call startJoin() first.");
        }
        if (currentMiddleware.isCompleted()) {
            throw new IllegalStateException("Join already completed.");
        }

        // 完成join操作
        currentMiddleware.complete(op);
        VoxelShape result = currentMiddleware.getCompletedShape();

        // 获取父级中间件
        JoinMiddleware parent = currentMiddleware.parent;

        if (parent != null) {
            // 嵌套join：将结果提取为AABB添加到父级中间件的当前操作数
            List<AABB> resultBoxes = extractAABBs(result);
            for (AABB box : resultBoxes) {
                parent.addBox(box);
            }
            // 弹出当前中间件
            currentMiddleware = parent;
            middlewareStack.pop();
        } else {
            // 顶层join：将结果添加到根级
            rootJoins.add(result);
            // 清空当前中间件（已完成）
            // 注意：不清空currentMiddleware，但标记为已完成
            // 这样后续startJoin会处理它
        }

        return this;
    }

    /**
     * 从VoxelShape提取AABB到列表
     */
    private List<AABB> extractAABBs(VoxelShape shape) {
        List<AABB> boxes = new ArrayList<>();
        if (shape.isEmpty()) {
            return boxes;
        }
        try {
            boxes.addAll(shape.toAabbs());
        } catch (Exception e) {
            AABB bounds = shape.bounds();
            if (!bounds.equals(new AABB(0, 0, 0, 0, 0, 0))) {
                boxes.add(bounds);
            }
        }
        return boxes;
    }

    // ==================== 添加形状方法 ====================

    /**
     * 添加一个AABB到当前构建上下文
     * <p>
     * 如果在join中间件中，AABB会添加到当前操作数。
     * 如果不在join中间件中，AABB会添加到最终结果中。
     *
     * @param box AABB
     * @return this
     */
    private VoxelShapeBuilder addBox(AABB box) {
        if (currentMiddleware != null) {
            if (currentMiddleware.isCompleted()) {
                // 如果中间件已完成，将box添加到根级
                rootBoxes.add(box);
            } else {
                // 在join中间件中，添加到当前操作数
                currentMiddleware.addBox(box);
            }
        } else {
            // 不在join中间件中，添加到最终结果
            rootBoxes.add(box);
        }
        return this;
    }

    /**
     * 添加一个OR操作的box（同层级内）
     * <p>
     * 多次调用or()会在同一个OR层级内添加多个box，最终合并为一个OR操作。
     * 如果在join中间件中，box会添加到当前操作数。
     *
     * @param x1 最小X
     * @param y1 最小Y
     * @param z1 最小Z
     * @param x2 最大X
     * @param y2 最大Y
     * @param z2 最大Z
     * @return this
     */
    public VoxelShapeBuilder or(double x1, double y1, double z1, double x2, double y2, double z2) {
        return addBox(new AABB(x1, y1, z1, x2, y2, z2));
    }

    /**
     * 添加一个OR操作的box
     *
     * @param box AABB
     * @return this
     */
    public VoxelShapeBuilder or(AABB box) {
        return addBox(box);
    }

    /**
     * 便捷方法：使用AND操作符创建join
     * <p>
     * 等价于 startJoin()...next()...finishJoin(BooleanOp.AND)
     *
     * @param x1 最小X
     * @param y1 最小Y
     * @param z1 最小Z
     * @param x2 最大X
     * @param y2 最大Y
     * @param z2 最大Z
     * @return this
     */
    public VoxelShapeBuilder and(double x1, double y1, double z1, double x2, double y2, double z2) {
        return startJoin()
            .or(x1, y1, z1, x2, y2, z2)
            .next()
            .finishJoin(BooleanOp.AND);
    }

    /**
     * 便捷方法：使用AND操作符创建join
     *
     * @param box AABB
     * @return this
     */
    public VoxelShapeBuilder and(AABB box) {
        return and(box.minX, box.minY, box.minZ, box.maxX, box.maxY, box.maxZ);
    }

    /**
     * 便捷方法：使用OR操作符创建join
     *
     * @param x1 最小X
     * @param y1 最小Y
     * @param z1 最小Z
     * @param x2 最大X
     * @param y2 最大Y
     * @param z2 最大Z
     * @return this
     */
    public VoxelShapeBuilder orJoin(double x1, double y1, double z1, double x2, double y2, double z2) {
        return startJoin()
            .or(x1, y1, z1, x2, y2, z2)
            .next()
            .finishJoin(BooleanOp.OR);
    }

    // ==================== 构建最终形状 ====================

    /**
     * 构建最终的IVoxelHolder
     * <p>
     * 根据旋转类型，生成对应方向的VoxelShape。
     *
     * @return IVoxelHolder实例
     * @throws IllegalStateException 如果有未完成的操作
     */
    public IVoxelHolder build() {
        // 检查是否有未完成的join中间件
        if (currentMiddleware != null && !currentMiddleware.isCompleted()) {
            throw new IllegalStateException("Cannot build: join middleware incomplete. Call finishJoin() first.");
        }

        // 构建基础形状
        VoxelShape baseShape = buildBaseShape();

        return switch (type) {
            case ONLY -> new OnlyCollision(baseShape);
            case X_ROTATE -> buildRotatedHolder(baseShape, RotateCollision.Axis.X);
            case Y_ROTATE -> buildRotatedHolder(baseShape, RotateCollision.Axis.Y);
            case Z_ROTATE -> buildRotatedHolder(baseShape, RotateCollision.Axis.Z);
        };
    }

    /**
     * 构建基础形状
     */
    private VoxelShape buildBaseShape() {
        List<AABB> allBoxes = new ArrayList<>(rootBoxes);

        // 如果有已完成的中间件，提取其形状的AABB
        if (currentMiddleware != null && currentMiddleware.isCompleted()) {
            VoxelShape completedShape = currentMiddleware.getCompletedShape();
            allBoxes.addAll(extractAABBs(completedShape));
        }

        // 添加根级的join结果
        for (VoxelShape joinResult : rootJoins) {
            allBoxes.addAll(extractAABBs(joinResult));
        }

        // 检查栈中是否有未处理的中间件
        for (JoinMiddleware middleware : middlewareStack) {
            if (middleware.isCompleted()) {
                allBoxes.addAll(extractAABBs(middleware.getCompletedShape()));
            } else if (middleware.hasContent()) {
                // 未完成的中间件，提取当前操作数的AABB
                allBoxes.addAll(middleware.getCurrentOperand());
            }
        }

        if (allBoxes.isEmpty()) {
            return Shapes.empty();
        }

        VoxelShape result = Shapes.box(
            allBoxes.getFirst().minX, allBoxes.getFirst().minY, allBoxes.getFirst().minZ,
            allBoxes.getFirst().maxX, allBoxes.getFirst().maxY, allBoxes.getFirst().maxZ
        );
        for (int i = 1; i < allBoxes.size(); i++) {
            AABB box = allBoxes.get(i);
            result = Shapes.or(result, Shapes.box(
                box.minX, box.minY, box.minZ,
                box.maxX, box.maxY, box.maxZ
            ));
        }
        return result;
    }

    /**
     * 构建旋转形状持有器
     */
    private IVoxelHolder buildRotatedHolder(VoxelShape baseShapeA, RotateCollision.Axis axis) {
        VoxelShape shapeB = rotateShape(baseShapeA, axis, false);  // 顺时针90度
        VoxelShape shapeC = rotateShape(shapeB, axis, false);     // 180度
        VoxelShape shapeD = rotateShape(baseShapeA, axis, true); // 逆时针90度

        return new RotateCollision(axis, baseShapeA, shapeB, shapeC, shapeD);
    }

    /**
     * 旋转形状
     */
    private VoxelShape rotateShape(VoxelShape shape, RotateCollision.Axis axis, boolean clockwise) {
        return rotateVoxelShape(shape, axis, clockwise);
    }

    /**
     * 旋转VoxelShape
     */
    private VoxelShape rotateVoxelShape(VoxelShape shape, RotateCollision.Axis axis, boolean clockwise) {
        if (shape.isEmpty()) {
            return Shapes.empty();
        }

        List<AABB> boxes = extractAABBs(shape);
        if (boxes.isEmpty()) {
            return Shapes.empty();
        }

        VoxelShape result = Shapes.empty();
        for (AABB box : boxes) {
            AABB rotated = switch (axis) {
                case X -> clockwise
                    ? AABBTransformHelper.rotateXClockwise(box)
                    : AABBTransformHelper.rotateCounterXClockwise(box);
                case Y -> clockwise
                    ? AABBTransformHelper.rotateYClockwise(box)
                    : AABBTransformHelper.rotateCounterYClockwise(box);
                case Z -> clockwise
                    ? AABBTransformHelper.rotateZClockwise(box)
                    : AABBTransformHelper.rotateCounterZClockwise(box);
            };
            VoxelShape boxShape = Shapes.box(
                rotated.minX, rotated.minY, rotated.minZ,
                rotated.maxX, rotated.maxY, rotated.maxZ
            );
            result = result.isEmpty() ? boxShape : Shapes.or(result, boxShape);
        }
        return result;
    }

    // ==================== 便捷方法 ====================

    /**
     * 构建并立即获取VoxelShape（仅用于简单类型）
     *
     * @return VoxelShape
     */
    public VoxelShape buildShape() {
        return build().getShape(Direction.NORTH);
    }

    /**
     * 清空所有条目（重置构建器）
     *
     * @return this
     */
    public VoxelShapeBuilder clear() {
        middlewareStack.clear();
        currentMiddleware = null;
        rootBoxes.clear();
        rootJoins.clear();
        return this;
    }

    // ==================== 调试方法 ====================

    /**
     * 检查构建器是否为空
     *
     * @return true如果为空
     */
    public boolean isEmpty() {
        return rootBoxes.isEmpty() &&
            rootJoins.isEmpty() &&
            (currentMiddleware == null || !currentMiddleware.hasContent()) &&
            middlewareStack.isEmpty();
    }

    /**
     * 获取当前join嵌套深度（用于调试）
     *
     * @return 嵌套深度
     */
    public int getJoinDepth() {
        return middlewareStack.size() + (currentMiddleware != null ? 1 : 0);
    }

    /**
     * 检查是否在join中间件中
     *
     * @return true如果在join中间件中
     */
    public boolean isInJoin() {
        return currentMiddleware != null;
    }
}