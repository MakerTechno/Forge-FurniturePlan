package nowebsite.maker.furnitureplan.blocks.voxel;

import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class VoxelShapeReference {
    public static final VoxelShape CUPBOARD_VOXEL = Shapes.or(
        Shapes.box(0, 0, 0, 0.0625, 0.125, 0.0625),
        Shapes.box(0, 0.0625, 0.0625, 0.0625, 0.125, 0.125),
        Shapes.box(0.0625, 0.0625, 0, 0.125, 0.125, 0.0625),
        Shapes.box(0, 0, 0.9375, 0.0625, 0.125, 1),
        Shapes.box(0.0625, 0.0625, 0.9375, 0.125, 0.125, 1),
        Shapes.box(0, 0.0625, 0.875, 0.0625, 0.125, 0.9375),
        Shapes.box(0.9375, 0, 0.9375, 1, 0.125, 1),
        Shapes.box(0.9375, 0.0625, 0.875, 1, 0.125, 0.9375),
        Shapes.box(0.875, 0.0625, 0.9375, 0.9375, 0.125, 1),
        Shapes.box(0.9375, 0, 0, 1, 0.125, 0.0625),
        Shapes.box(0.875, 0.0625, 0, 0.9375, 0.125, 0.0625),
        Shapes.box(0.9375, 0.0625, 0.0625, 1, 0.125, 0.125),
        Shapes.box(0, 0.125, 0, 1, 0.1875, 1),
        Shapes.box(0.03125, 0.1875, 0.03125, 0.96875, 0.9375, 0.96875),
        Shapes.box(0, 0.9375, 0, 1, 1, 1)
    );
}
