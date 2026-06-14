package nowebsite.maker.furnitureplan.remix.voxel;

import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.BooleanOp;
import nowebsite.maker.furnitureplan.remix.voxel.processor.AutoShape;

/**
 * 形状条目，包含 AABB 和对应的 BooleanOp
 * 用于 {@link AutoShape} 注解的字段
 */
public final class ShapeEntry {
    private final AABB box;
    private final BooleanOp op;
    
    public ShapeEntry(AABB box, BooleanOp op) {
        this.box = box;
        this.op = op;
    }
    
    public ShapeEntry(double x1, double y1, double z1, double x2, double y2, double z2, BooleanOp op) {
        this(new AABB(x1, y1, z1, x2, y2, z2), op);
    }
    
    public AABB getBox() {
        return box;
    }
    
    public BooleanOp getOp() {
        return op;
    }
}