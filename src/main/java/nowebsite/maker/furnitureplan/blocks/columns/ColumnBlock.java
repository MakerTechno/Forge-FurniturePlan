package nowebsite.maker.furnitureplan.blocks.columns;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import nowebsite.maker.furnitureplan.blocks.func.BasePropertyBlock;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("deprecation")
public class ColumnBlock extends BasePropertyBlock implements SimpleWaterloggedBlock {
    protected static final VoxelShape SHAPE;
    static {
        SHAPE = Shapes.or(
                Shapes.box(0.0625, 0, 0.125, 0.9375, 0.0625, 0.875),
                Shapes.box(0.125, 0, 0.0625, 0.875, 0.0625, 0.125),
                Shapes.box(0.125, 0, 0.875, 0.875, 0.0625, 0.9375),
                Shapes.box(0.125, 0.0625, 0.1875, 0.875, 0.125, 0.8125),
                Shapes.box(0.1875, 0.0625, 0.125, 0.8125, 0.125, 0.1875),
                Shapes.box(0.25, 0.125, 0.75, 0.75, 0.875, 0.8125),
                Shapes.box(0.1875, 0.125, 0.25, 0.8125, 0.875, 0.75),
                Shapes.box(0.1875, 0.0625, 0.8125, 0.8125, 0.125, 0.875),
                Shapes.box(0.25, 0.125, 0.1875, 0.75, 0.875, 0.25),
                Shapes.box(0.0625, 0.9375, 0.125, 0.9375, 1, 0.875),
                Shapes.box(0.125, 0.9375, 0.0625, 0.875, 1, 0.125),
                Shapes.box(0.125, 0.9375, 0.875, 0.875, 1, 0.9375),
                Shapes.box(0.125, 0.875, 0.1875, 0.875, 0.9375, 0.8125),
                Shapes.box(0.1875, 0.875, 0.125, 0.8125, 0.9375, 0.1875),
                Shapes.box(0.1875, 0.875, 0.8125, 0.8125, 0.9375, 0.875)
        );
    }
    public ColumnBlock(@NotNull BlockState state, Properties properties) {
        super(state, properties);
    }
    @Override
    public @NotNull VoxelShape getOcclusionShape(@NotNull BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos pos) {
        return SHAPE;
    }
}
