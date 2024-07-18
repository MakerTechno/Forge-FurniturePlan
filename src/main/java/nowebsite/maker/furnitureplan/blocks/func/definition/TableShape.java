package nowebsite.maker.furnitureplan.blocks.func.definition;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import nowebsite.maker.furnitureplan.registry.BlockRegistration;
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
    public VoxelShape getOccModel(@NotNull BlockState state, BlockGetter level, BlockPos pos) {
        int countState =
                (level.getBlockState(pos.north()).is(BlockRegistration.TABLE_BLOCK) ? 1 : 0)
                        + (level.getBlockState(pos.east()).is(BlockRegistration.TABLE_BLOCK) ? 2 : 0)
                        + (level.getBlockState(pos.south()).is(BlockRegistration.TABLE_BLOCK) ? 4 : 0)
                        + (level.getBlockState(pos.west()).is(BlockRegistration.TABLE_BLOCK) ? 8 : 0);
        return switch (countState) {
            case 0 -> ALL;
            case 1 -> S_M;
            case 2 -> W_M;
            case 3 -> SW_M;
            case 4 -> N_M;
            case 6 -> WN_M;
            case 8 -> E_M;
            case 9 -> ES_M;
            case 12 -> NE_M;
            default -> TOP;
        };
    }

    @Override
    public @NotNull String getSerializedName() {
        return name;
    }
}
