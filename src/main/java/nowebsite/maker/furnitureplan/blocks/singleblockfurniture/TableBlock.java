package nowebsite.maker.furnitureplan.blocks.singleblockfurniture;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import nowebsite.maker.furnitureplan.blocks.func.BasePropertyBlock;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("deprecation")
public class TableBlock extends BasePropertyBlock implements SimpleWaterloggedBlock {
    private static VoxelShape SHAPE = Shapes.empty();
    static {
        SHAPE = Shapes.join(SHAPE, Shapes.box(0.125, 0.0, 0.125, 0.25, 0.875, 0.25), BooleanOp.OR);
        SHAPE = Shapes.join(SHAPE, Shapes.box(0.75, 0.0, 0.125, 0.875, 0.875, 0.25), BooleanOp.OR);
        SHAPE = Shapes.join(SHAPE, Shapes.box(0.125, 0.0, 0.75, 0.25, 0.875, 0.875), BooleanOp.OR);
        SHAPE = Shapes.join(SHAPE, Shapes.box(0.75, 0.0, 0.75, 0.875, 0.875, 0.875), BooleanOp.OR);
        SHAPE = Shapes.join(SHAPE, Shapes.box(0.0, 0.875, 0.0, 1.0, 1.0, 1.0), BooleanOp.OR);
    }
    public TableBlock(@NotNull BlockState state, Properties properties) {
        super(state, properties);
    }
    @Override
    public @NotNull VoxelShape getOcclusionShape(@NotNull BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos pos) {
        return SHAPE;
    }
}

