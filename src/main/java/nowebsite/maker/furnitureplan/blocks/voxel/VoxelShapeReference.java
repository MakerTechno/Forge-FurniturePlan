package nowebsite.maker.furnitureplan.blocks.voxel;

import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class VoxelShapeReference {
    public static final VoxelShape CHAIR_SHAPE_N = Shapes.or(
            Shapes.box(0.125, 0.0, 0.125, 0.25, 0.3125, 0.25),
            Shapes.box(0.125, 0.0, 0.75, 0.25, 0.3125, 0.875),
            Shapes.box(0.75, 0.0, 0.125, 0.875, 0.3125, 0.25),
            Shapes.box(0.75, 0.0, 0.6875, 0.875, 0.3125, 0.8125),
            Shapes.box(0.0, 0.3125, 0.0, 1.0, 0.4375, 1.0),
            Shapes.box(0.25, 0.4375, 0.875, 0.375, 0.5625, 1.0),
            Shapes.box(0.625, 0.4375, 0.875, 0.75, 0.5625, 1.0),
            Shapes.box(0.0, 0.5625, 0.875, 1.0, 1.0, 1.0)
    ),
    CHAIR_SHAPE_E = Shapes.or(
            Shapes.box(0.75, 0.0, 0.125, 0.875, 0.3125, 0.25),
            Shapes.box(0.125, 0.0, 0.125, 0.25, 0.3125, 0.25),
            Shapes.box(0.75, 0.0, 0.75, 0.875, 0.3125, 0.875),
            Shapes.box(0.1875, 0.0, 0.75, 0.3125, 0.3125, 0.875),
            Shapes.box(0.0, 0.3125, 0.0, 1.0, 0.4375, 1.0),
            Shapes.box(0.0, 0.4375, 0.25, 0.125, 0.5625, 0.375),
            Shapes.box(0.0, 0.4375, 0.625, 0.125, 0.5625, 0.75),
            Shapes.box(0.0, 0.5625, 0.0, 0.125, 1.0, 1.0)
    ),
    CHAIR_SHAPE_S = Shapes.or(
            Shapes.box(0.75, 0.0, 0.75, 0.875, 0.3125, 0.875),
            Shapes.box(0.75, 0.0, 0.125, 0.875, 0.3125, 0.25),
            Shapes.box(0.125, 0.0, 0.75, 0.25, 0.3125, 0.875),
            Shapes.box(0.125, 0.0, 0.1875, 0.25, 0.3125, 0.3125),
            Shapes.box(0.0, 0.3125, 0.0, 1.0, 0.4375, 1.0),
            Shapes.box(0.625, 0.4375, 0.0, 0.75, 0.5625, 0.125),
            Shapes.box(0.25, 0.4375, 0.0, 0.375, 0.5625, 0.125),
            Shapes.box(0.0, 0.5625, 0.0, 1.0, 1.0, 0.125)
    ),

    CHAIR_SHAPE_W = Shapes.or(
            Shapes.box(0.125, 0.0, 0.75, 0.25, 0.3125, 0.875),
            Shapes.box(0.75, 0.0, 0.75, 0.875, 0.3125, 0.875),
            Shapes.box(0.125, 0.0, 0.125, 0.25, 0.3125, 0.25),
            Shapes.box(0.6875, 0.0, 0.125, 0.8125, 0.3125, 0.25),
            Shapes.box(0.0, 0.3125, 0.0, 1.0, 0.4375, 1.0),
            Shapes.box(0.875, 0.4375, 0.625, 1.0, 0.5625, 0.75),
            Shapes.box(0.875, 0.4375, 0.25, 1.0, 0.5625, 0.375),
            Shapes.box(0.875, 0.5625, 0.0, 1.0, 1.0, 1.0)
    );
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
    public static final VoxelShape BENCH_VOXEL = Shapes.or(
        Shapes.box(0.75, 0, 0.75, 0.875, 0.25, 0.875),
        Shapes.box(0.125, 0, 0.75, 0.25, 0.25, 0.875),
        Shapes.box(0.125, 0, 0.125, 0.25, 0.25, 0.25),
        Shapes.box(0.0625, 0.25, 0.0625, 0.9375, 0.375, 0.9375),
        Shapes.box(0.75, 0, 0.125, 0.875, 0.25, 0.25)
    );
}
