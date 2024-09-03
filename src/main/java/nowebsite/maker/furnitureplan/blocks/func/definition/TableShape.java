package nowebsite.maker.furnitureplan.blocks.func.definition;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import nowebsite.maker.furnitureplan.utils.ModelSR;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public enum TableShape implements ModelSR {
    FULL("full"),
    SIDE("side"),
    SINGLE("single"),
    PANE("pane");

    private final String name;
    TableShape(String name){
        this.name = name;
    }
    @Override
    public ResourceLocation getModel(Block block) {
        return modLoc("table_" + this.getSerializedName());
    }

    @Contract(pure = true)
    @Override
    public @Nullable ResourceLocation getTexture() {
        return null; // We choose it at a texture list.
    }
    private static final VoxelShape TOP, NE_C, ES_C, SW_C, WN_C, NE_M, ES_M, SW_M, WN_M, N_M, E_M, S_M, W_M, ALL;
    static {
        TOP = Shapes.box(0, 0.875, 0, 1, 1, 1);
        NE_C = Shapes.box(0.75, 0, 0.125, 0.875, 0.875, 0.25);
        ES_C = Shapes.box(0.75, 0, 0.75, 0.875, 0.875, 0.875);
        SW_C = Shapes.box(0.125, 0, 0.75, 0.25, 0.875, 0.875);
        WN_C = Shapes.box(0.125, 0, 0.125, 0.25, 0.875, 0.25);
        NE_M = Shapes.or(TOP, NE_C);
        ES_M = Shapes.or(TOP,ES_C);
        SW_M = Shapes.or(TOP, SW_C);
        WN_M = Shapes.or(TOP, WN_C);
        N_M = Shapes.or(NE_M, WN_C);
        E_M = Shapes.or(ES_M, NE_C);
        S_M = Shapes.or(SW_M, ES_C);
        W_M = Shapes.or(WN_M, SW_C);
        ALL = Shapes.or(TOP, NE_C, ES_C, SW_C, WN_C);
    }
    @Override
    public VoxelShape getOccModel(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos) {
        return switch (this) {
            case FULL -> ALL;
            case PANE -> TOP;
            case SIDE -> switchSideOcc(state.getValue(HorizontalDirectionalBlock.FACING));
            case SINGLE -> switchSingleOcc(state.getValue(HorizontalDirectionalBlock.FACING));
        };
    }
    @Contract(pure = true)
    private VoxelShape switchSideOcc(@NotNull Direction direction) {
        return switch (direction) {
            case NORTH -> N_M;
            case EAST -> E_M;
            case SOUTH -> S_M;
            case WEST -> W_M;
            default -> null;
        };
    }
    @Contract(pure = true)
    private VoxelShape switchSingleOcc(@NotNull Direction direction) {
        return switch (direction) {
            case NORTH -> NE_M;
            case EAST -> ES_M;
            case SOUTH -> SW_M;
            case WEST -> WN_M;
            default -> null;
        };
    }
    @Override
    public @NotNull String getSerializedName() {
        return name;
    }
}
