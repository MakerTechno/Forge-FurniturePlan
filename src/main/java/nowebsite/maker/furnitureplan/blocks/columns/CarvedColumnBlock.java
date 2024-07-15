package nowebsite.maker.furnitureplan.blocks.columns;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class CarvedColumnBlock extends ColumnBlock {
    private static final VoxelShape SHAPE;
    static {
        /*This is optimized for higher performance, and as a result, fewer details.*/
        SHAPE = Shapes.or(Shapes.box(0.0625, 0, 0.125, 0.9375, 0.0625, 0.875),
                Shapes.box(0.125, 0, 0.0625, 0.875, 0.0625, 0.125),
                Shapes.box(0.125, 0, 0.875, 0.875, 0.0625, 0.9375),
                Shapes.box(0.125, 0.0625, 0.1875, 0.875, 0.125, 0.8125),
                Shapes.box(0.1875, 0.0625, 0.125, 0.8125, 0.125, 0.1875),
                Shapes.box(0.1875, 0.0625, 0.8125, 0.8125, 0.125, 0.875),
                Shapes.box(0.0625, 0.9375, 0.125, 0.9375, 1, 0.875),
                Shapes.box(0.125, 0.9375, 0.0625, 0.875, 1, 0.125),
                Shapes.box(0.125, 0.9375, 0.875, 0.875, 1, 0.9375),
                Shapes.box(0.125, 0.875, 0.1875, 0.875, 0.9375, 0.8125),
                Shapes.box(0.1875, 0.875, 0.125, 0.8125, 0.9375, 0.1875),
                Shapes.box(0.1875, 0.875, 0.8125, 0.8125, 0.9375, 0.875),
                Shapes.box(0.1875, 0.125, 0.1875, 0.8125, 0.875, 0.8125)
        );
    }
    public CarvedColumnBlock(@NotNull BlockState state, Properties properties) {
        super(state, properties);
    }
    @Override
    public @NotNull VoxelShape getOcclusionShape(@NotNull BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos pos) {
        return SHAPE;
    }
}