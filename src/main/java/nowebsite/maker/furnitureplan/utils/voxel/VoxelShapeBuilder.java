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
 *   <li>push/pop：层级管理，支持嵌套的join操作</li>
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
 * // 嵌套join操作
 * IVoxelHolder complex = VoxelShapeBuilder.ofYRot()
 *     .or(0.25, 0, 0.33, 0.29, 0.21, 1)
 *     .or(0, 0, 0, 0.29, 0.33, 0.8)
 *     .push()
 *         .joinFirst()
 *             .or(0.1, 0.1, 0.1, 0.9, 0.9, 0.9)
 *             .buildFirst()
 *         .joinSecond()
 *             .or(0.2, 0.2, 0.2, 0.8, 0.8, 0.8)
 *             .buildSecond(BooleanOp.AND)
 *     .pop()
 *     .build();
 * </pre>
 */
public final class VoxelShapeBuilder {

    private final VoxelType type;
    private final Deque<Context> contextStack;
    private Context currentContext;

    /**
     * 构建上下文 - 维护当前层级的形状构建状态
     */
    private static final class Context {
        private final List<Entry> entries = new ArrayList<>();
        private ShapeBuilder currentBuilder;
        private BooleanOp pendingOp;
        private boolean isJoinFirst = false;
        private boolean isJoinSecond = false;
        private final Context parent;
        private VoxelShape firstShape;
        private VoxelShape secondShape;

        Context(@Nullable Context parent) {
            this.parent = parent;
        }

        boolean hasPendingOr() {
            return currentBuilder != null && currentBuilder.type == EntryType.OR;
        }

        boolean hasPendingBox() {
            return currentBuilder != null && currentBuilder.type == EntryType.BOX;
        }

        void addEntry(Entry entry) {
            entries.add(entry);
        }

        boolean isEmpty() {
            return entries.isEmpty() && currentBuilder == null;
        }
    }

    /**
     * 条目类型
     */
    private enum EntryType {
        /** OR操作的AABB列表 */
        OR,
        /** 单个Box */
        BOX,
        /** 嵌套的Join操作 */
        JOIN
    }

    /**
     * 形状条目基类
     */
    private static abstract class Entry {
        abstract EntryType getType();
        abstract VoxelShape build();
    }

    /**
     * OR条目 - 包含多个AABB的OR操作
     */
    private static final class OrEntry extends Entry {
        private final List<AABB> boxes = new ArrayList<>();

        OrEntry addBox(AABB box) {
            this.boxes.add(box);
            return this;
        }

        OrEntry addBox(double x1, double y1, double z1, double x2, double y2, double z2) {
            return addBox(new AABB(x1, y1, z1, x2, y2, z2));
        }

        @Override
        EntryType getType() {
            return EntryType.OR;
        }

        @Override
        VoxelShape build() {
            if (boxes.isEmpty()) {
                return Shapes.empty();
            }
            VoxelShape result = Shapes.box(
                boxes.getFirst().minX, boxes.getFirst().minY, boxes.getFirst().minZ,
                boxes.getFirst().maxX, boxes.getFirst().maxY, boxes.getFirst().maxZ
            );
            for (int i = 1; i < boxes.size(); i++) {
                AABB box = boxes.get(i);
                result = Shapes.or(result, Shapes.box(box.minX, box.minY, box.minZ, box.maxX, box.maxY, box.maxZ));
            }
            return result;
        }

        boolean isEmpty() {
            return boxes.isEmpty();
        }
    }

    /**
     * Box条目 - 单个AABB
     */
    private static final class BoxEntry extends Entry {
        private final AABB box;

        BoxEntry(AABB box) {
            this.box = box;
        }

        BoxEntry(double x1, double y1, double z1, double x2, double y2, double z2) {
            this(new AABB(x1, y1, z1, x2, y2, z2));
        }

        @Override
        EntryType getType() {
            return EntryType.BOX;
        }

        @Override
        VoxelShape build() {
            return Shapes.box(box.minX, box.minY, box.minZ, box.maxX, box.maxY, box.maxZ);
        }
    }

    /**
     * Join条目 - 嵌套的Join操作
     */
    private static final class JoinEntry extends Entry {
        private VoxelShape first;
        private VoxelShape second;
        private BooleanOp op;

        JoinEntry setFirst(VoxelShape first) {
            this.first = first;
            return this;
        }

        JoinEntry setSecond(VoxelShape second) {
            this.second = second;
            return this;
        }

        JoinEntry setOp(BooleanOp op) {
            this.op = op;
            return this;
        }

        @Override
        EntryType getType() {
            return EntryType.JOIN;
        }

        @Override
        VoxelShape build() {
            if (first == null || second == null || op == null) {
                throw new IllegalStateException("Join entry incomplete: first=" + first + ", second=" + second + ", op=" + op);
            }
            return Shapes.join(first, second, op);
        }

        boolean isComplete() {
            return first != null && second != null && op != null;
        }
    }

    /**
     * 形状构建器 - 用于构建当前层级的形状
     */
    private static final class ShapeBuilder {
        private final EntryType type;
        private final OrEntry orEntry;
        private final BoxEntry boxEntry;
        private final JoinEntry joinEntry;

        ShapeBuilder(EntryType type) {
            this.type = type;
            this.orEntry = type == EntryType.OR ? new OrEntry() : null;
            this.boxEntry = type == EntryType.BOX ? new BoxEntry(0, 0, 0, 0, 0, 0) : null;
            this.joinEntry = type == EntryType.JOIN ? new JoinEntry() : null;
        }

        ShapeBuilder or(double x1, double y1, double z1, double x2, double y2, double z2) {
            if (type != EntryType.OR) {
                throw new IllegalStateException("Cannot add OR box to non-OR builder");
            }
            orEntry.addBox(x1, y1, z1, x2, y2, z2);
            return this;
        }

        ShapeBuilder or(AABB box) {
            if (type != EntryType.OR) {
                throw new IllegalStateException("Cannot add OR box to non-OR builder");
            }
            orEntry.addBox(box);
            return this;
        }

        ShapeBuilder setFirst(VoxelShape shape) {
            if (type != EntryType.JOIN) {
                throw new IllegalStateException("Cannot set first on non-JOIN builder");
            }
            joinEntry.setFirst(shape);
            return this;
        }

        ShapeBuilder setSecond(VoxelShape shape) {
            if (type != EntryType.JOIN) {
                throw new IllegalStateException("Cannot set second on non-JOIN builder");
            }
            joinEntry.setSecond(shape);
            return this;
        }

        ShapeBuilder setOp(BooleanOp op) {
            if (type != EntryType.JOIN) {
                throw new IllegalStateException("Cannot set op on non-JOIN builder");
            }
            joinEntry.setOp(op);
            return this;
        }

        Entry build() {
            return switch (type) {
                case OR -> orEntry;
                case BOX -> boxEntry;
                case JOIN -> joinEntry;
            };
        }

        boolean isEmpty() {
            return switch (type) {
                case OR -> orEntry.isEmpty();
                case BOX -> false;
                case JOIN -> !joinEntry.isComplete();
            };
        }

        EntryType getType() {
            return type;
        }
    }

    // ==================== 构造函数 ====================

    private VoxelShapeBuilder(VoxelType type) {
        this.type = type;
        this.contextStack = new ArrayDeque<>();
        this.currentContext = new Context(null);
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

    // ==================== 层级管理 ====================

    /**
     * 向下推入新层级（进入嵌套的join操作）
     * <p>
     * 在push之后，需要调用 {@link #joinFirst()} 和 {@link #joinSecond()} 来构建join的两侧，
     * 最后调用 {@link #buildJoin()} 或 {@link #pop()} 完成该层级。
     *
     * @return this
     */
    public VoxelShapeBuilder push() {
        // 完成当前层级的pending builder
        flushCurrentBuilder();

        Context newContext = new Context(currentContext);
        contextStack.push(currentContext);
        currentContext = newContext;
        return this;
    }

    /**
     * 弹出当前层级，返回到父层级
     * <p>
     * 如果当前层级有未完成的join，会自动尝试完成。
     *
     * @return this
     * @throws IllegalStateException 如果当前层级有未完成的操作
     */
    public VoxelShapeBuilder pop() {
        if (contextStack.isEmpty()) {
            throw new IllegalStateException("Cannot pop root context");
        }

        // 完成当前层级的pending builder
        flushCurrentBuilder();

        // 检查当前层级是否有未完成的join
        if (currentContext.pendingOp != null) {
            throw new IllegalStateException("Cannot pop: pending join operation incomplete");
        }

        // 构建当前层级的形状
        VoxelShape shape = buildShapeFromContext(currentContext);

        // 恢复父层级
        Context parent = currentContext.parent;
        contextStack.pop();
        currentContext = parent;

        // 将构建的形状添加到父层级的join中
        if (currentContext != null) {
            if (currentContext.isJoinFirst) {
                currentContext.firstShape = shape;
                currentContext.isJoinFirst = false;
                // 如果second也已经设置，自动完成join
                if (currentContext.secondShape != null && currentContext.pendingOp != null) {
                    completeJoin(currentContext);
                }
                return this;
            } else if (currentContext.isJoinSecond) {
                currentContext.secondShape = shape;
                currentContext.isJoinSecond = false;
                // 如果first已经设置，自动完成join
                if (currentContext.firstShape != null && currentContext.pendingOp != null) {
                    completeJoin(currentContext);
                }
                return this;
            }

            // else 直接添加为普通条目
            currentContext.addEntry(new Entry() {
                @Override
                EntryType getType() {
                    return EntryType.JOIN;
                }
                @Override
                VoxelShape build() {
                    return shape;
                }
            });
        }
        return this;
    }

    // ==================== Join操作 ====================

    /**
     * 开始构建join的第一个操作数
     * <p>
     * 在调用 {@link #push()} 之后，调用此方法表示后续构建的内容将作为join的第一个操作数。
     * 之后需要调用 {@link #buildFirst()} 完成第一个操作数的构建。
     *
     * @return this
     */
    public VoxelShapeBuilder joinFirst() {
        if (currentContext.isJoinFirst || currentContext.isJoinSecond) {
            throw new IllegalStateException("Already in join first or second state");
        }
        flushCurrentBuilder();
        currentContext.isJoinFirst = true;
        return this;
    }

    /**
     * 开始构建join的第二个操作数
     * <p>
     * 在调用 {@link #push()} 之后，调用此方法表示后续构建的内容将作为join的第二个操作数。
     * 之后需要调用 {@link #buildSecond(BooleanOp)} 完成第二个操作数的构建。
     *
     * @return this
     */
    public VoxelShapeBuilder joinSecond() {
        if (currentContext.isJoinFirst || currentContext.isJoinSecond) {
            throw new IllegalStateException("Already in join first or second state");
        }
        flushCurrentBuilder();
        currentContext.isJoinSecond = true;
        return this;
    }

    /**
     * 构建第一个操作数并完成当前层级的join
     * <p>
     * 此方法会pop当前层级，将构建的形状作为join的第一个操作数。
     *
     * @return this
     */
    public VoxelShapeBuilder buildFirst() {
        if (!currentContext.isJoinFirst) {
            throw new IllegalStateException("Not in join first state");
        }
        // 完成当前层级的构建并pop
        return pop();
    }

    /**
     * 构建第二个操作数并完成当前层级的join
     *
     * @param op 布尔操作符
     * @return this
     */
    public VoxelShapeBuilder buildSecond(BooleanOp op) {
        if (!currentContext.isJoinSecond) {
            throw new IllegalStateException("Not in join second state");
        }
        currentContext.pendingOp = op;
        return pop();
    }

    /**
     * 构建join（使用AND操作符）
     *
     * @return this
     */
    public VoxelShapeBuilder buildJoin() {
        return buildSecond(BooleanOp.AND);
    }

    private void completeJoin(Context context) {
        JoinEntry joinEntry = new JoinEntry()
            .setFirst(context.firstShape)
            .setSecond(context.secondShape)
            .setOp(context.pendingOp);
        context.addEntry(joinEntry);
        context.firstShape = null;
        context.secondShape = null;
        context.pendingOp = null;
    }

    // ==================== 添加形状方法 ====================

    /**
     * 添加一个OR操作的box（同层级内）
     * <p>
     * 多次调用or()会在同一个OR层级内添加多个box，最终合并为一个OR操作。
     *
     * @param x1 最小X
     * @param y1 最小Y
     * @param z1 最小Z
     * @param x2 最大X
     * @param y2 最大Y
     * @param z2 最大Z
     * @return this
     * @throws IllegalStateException 如果当前有未完成的box操作
     */
    public VoxelShapeBuilder or(double x1, double y1, double z1, double x2, double y2, double z2) {
        if (currentContext.hasPendingBox()) {
            throw new IllegalStateException("Cannot add OR box while BOX operation is pending. Call build() or complete the box first.");
        }
        if (currentContext.isJoinFirst || currentContext.isJoinSecond) {
            throw new IllegalStateException("Cannot add OR box inside join first/second state. Use push() to create a new layer.");
        }

        if (!currentContext.hasPendingOr()) {
            // 创建新的OR builder
            currentContext.currentBuilder = new ShapeBuilder(EntryType.OR);
        }
        currentContext.currentBuilder.or(x1, y1, z1, x2, y2, z2);
        return this;
    }

    /**
     * 添加一个OR操作的box（同层级内）
     *
     * @param box AABB
     * @return this
     */
    public VoxelShapeBuilder or(AABB box) {
        return or(box.minX, box.minY, box.minZ, box.maxX, box.maxY, box.maxZ);
    }

    /**
     * 添加一个单独的box（不进行布尔运算）
     * <p>
     * box操作会直接返回一个VoxelShape，不与其他形状进行布尔运算。
     * 注意：box操作不能与or操作在同一层级混合使用，否则会报错。
     *
     * @param x1 最小X
     * @param y1 最小Y
     * @param z1 最小Z
     * @param x2 最大X
     * @param y2 最大Y
     * @param z2 最大Z
     * @return this
     * @throws IllegalStateException 如果当前有未完成的or操作
     */
    public VoxelShapeBuilder box(double x1, double y1, double z1, double x2, double y2, double z2) {
        if (currentContext.hasPendingOr()) {
            throw new IllegalStateException("Cannot add BOX while OR operation is pending. Call build() or complete the OR first.");
        }
        if (currentContext.isJoinFirst || currentContext.isJoinSecond) {
            throw new IllegalStateException("Cannot add BOX inside join first/second state. Use push() to create a new layer.");
        }

        flushCurrentBuilder();
        currentContext.addEntry(new BoxEntry(x1, y1, z1, x2, y2, z2));
        return this;
    }

    /**
     * 添加一个单独的box
     *
     * @param box AABB
     * @return this
     */
    public VoxelShapeBuilder box(AABB box) {
        return box(box.minX, box.minY, box.minZ, box.maxX, box.maxY, box.maxZ);
    }

    /**
     * 便捷方法：添加一个AND操作的形状（作为嵌套join）
     * <p>
     * 此方法会自动创建嵌套的join结构，当前形状作为first，传入的形状作为second。
     *
     * @param shape 要AND的形状
     * @return this
     */
    public VoxelShapeBuilder and(VoxelShape shape) {
        return push()
            .joinFirst()
            .buildFirst()
            .joinSecond()
            .buildSecond(BooleanOp.AND);
    }

    /**
     * 便捷方法：添加一个AND操作的box
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
        return and(Shapes.box(x1, y1, z1, x2, y2, z2));
    }

    /**
     * 便捷方法：添加一个AND操作的box
     *
     * @param box AABB
     * @return this
     */
    public VoxelShapeBuilder and(AABB box) {
        return and(box.minX, box.minY, box.minZ, box.maxX, box.maxY, box.maxZ);
    }

    // ==================== 内部辅助方法 ====================

    /**
     * 刷新当前构建器，将pending的builder转换为Entry
     */
    private void flushCurrentBuilder() {
        if (currentContext.currentBuilder != null) {
            if (!currentContext.currentBuilder.isEmpty()) {
                currentContext.addEntry(currentContext.currentBuilder.build());
            }
            currentContext.currentBuilder = null;
        }
    }

    /**
     * 从Context构建VoxelShape
     */
    private VoxelShape buildShapeFromContext(Context context) {
        flushCurrentBuilder();

        if (context.entries.isEmpty()) {
            return Shapes.empty();
        }

        VoxelShape result = context.entries.getFirst().build();
        for (int i = 1; i < context.entries.size(); i++) {
            result = Shapes.or(result, context.entries.get(i).build());
        }
        return result;
    }

    // ==================== 构建方法 ====================

    /**
     * 构建最终的IVoxelHolder
     * <p>
     * 根据旋转类型，生成对应方向的VoxelShape。
     *
     * @return IVoxelHolder实例
     * @throws IllegalStateException 如果有未完成的操作
     */
    public IVoxelHolder build() {
        // 检查是否有未完成的join状态
        if (currentContext.isJoinFirst || currentContext.isJoinSecond) {
            throw new IllegalStateException("Cannot build: still in join first/second state. Call buildFirst() or buildSecond() first.");
        }
        if (!contextStack.isEmpty()) {
            throw new IllegalStateException("Cannot build: " + contextStack.size() + " context(s) still on stack. Call pop() for each.");
        }

        flushCurrentBuilder();
        VoxelShape baseShape = buildShapeFromContext(currentContext);

        return switch (type) {
            case ONLY -> new OnlyCollision(baseShape);
            case X_ROTATE -> buildRotatedHolder(baseShape, RotateCollision.Axis.X);
            case Y_ROTATE -> buildRotatedHolder(baseShape, RotateCollision.Axis.Y);
            case Z_ROTATE -> buildRotatedHolder(baseShape, RotateCollision.Axis.Z);
        };
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
        // 使用AABBTransformHelper的旋转方法
        return rotateVoxelShape(shape, axis, clockwise);
    }

    /**
     * 旋转VoxelShape
     * <p>
     * 由于VoxelShape内部结构复杂，这里使用Shapes的box方法重新构建旋转后的形状。
     * 对于简单形状（由AABB组成），可以通过遍历AABB进行旋转。
     */
    private VoxelShape rotateVoxelShape(VoxelShape shape, RotateCollision.Axis axis, boolean clockwise) {
        if (shape.isEmpty()) {
            return Shapes.empty();
        }

        // 获取形状的所有AABB
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

    /**
     * 从VoxelShape中提取所有AABB
     * <p>
     * 注意：这是一个简化的实现，对于复杂的VoxelShape可能不完美。
     * 在实际使用中，可能需要更复杂的提取逻辑。
     */
    private List<AABB> extractAABBs(VoxelShape shape) {
        List<AABB> boxes = new ArrayList<>();
        // 使用Shapes的toAabbs方法（在Forge中可用）
        try {
            boxes.addAll(shape.toAabbs());
        } catch (Exception e) {
            // 回退方案：如果无法获取AABB，尝试使用VoxelShape的边界框
            AABB bounds = shape.bounds();
            if (!bounds.equals(new AABB(0, 0, 0, 0, 0, 0))) {
                boxes.add(bounds);
            } else {
                boxes.add(new AABB(0, 0, 0, 1, 1, 1));
            }
        }
        return boxes;
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
        contextStack.clear();
        currentContext = new Context(null);
        return this;
    }

    // ==================== 调试方法 ====================

    /**
     * 获取当前条目数量（用于调试）
     *
     * @return 条目数量
     */
    public int getEntryCount() {
        return currentContext.entries.size();
    }

    /**
     * 检查构建器是否为空
     *
     * @return true如果为空
     */
    public boolean isEmpty() {
        return currentContext.entries.isEmpty() && currentContext.currentBuilder == null;
    }

    /**
     * 获取当前层级深度（用于调试）
     *
     * @return 层级深度
     */
    public int getDepth() {
        return contextStack.size();
    }
}