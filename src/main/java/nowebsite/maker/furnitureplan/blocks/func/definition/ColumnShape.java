package nowebsite.maker.furnitureplan.blocks.func.definition;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import nowebsite.maker.furnitureplan.blocks.columns.CarvedColumnBlock;
import nowebsite.maker.furnitureplan.blocks.columns.ColumnBlock;
import nowebsite.maker.furnitureplan.blocks.columns.LightedColumnBlock;
import nowebsite.maker.furnitureplan.utils.ModelSR;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public enum ColumnShape implements ModelSR {
    FULL("full"),
    BASE("base"),
    CONNECT("connect"),
    TOP("top");
    private final String name;
    ColumnShape(String name) {
        this.name = name;
    }
    @Override
    public ResourceLocation getModel(Block block) {
        return modLoc(
                (block instanceof CarvedColumnBlock ? "carved_" : "") +
                        (block instanceof LightedColumnBlock ? "lighted_" : "") +
                        "column_" +
                        getSerializedName()
        );
    }

    @Contract(pure = true)
    @Override
    public @Nullable ResourceLocation getTexture() {
        return null;// We choose it at a texture list.
    }

    public static final VoxelShape NORMAL_TOP, NORMAL_MIDDLE, NORMAL_BOTTOM, NORMAL_UP_CONNECT, NORMAL_DOWN_CONNECT;
    public static final VoxelShape CARVED_MIDDLE, CARVED_UP_CONNECT, CARVED_DOWN_CONNECT;
    public static final VoxelShape LIGHTED_MIDDLE;
    public static final VoxelShape COLUMN_FULL, COLUMN_BASE, COLUMN_CONNECT, COLUMN_TOP;
    public static final VoxelShape CARVED_COLUMN_FULL, CARVED_COLUMN_BASE, CARVED_COLUMN_CONNECT, CARVED_COLUMN_TOP;
    public static final VoxelShape LIGHTED_COLUMN_FULL, LIGHTED_COLUMN_BASE, LIGHTED_COLUMN_CONNECT, LIGHTED_COLUMN_TOP;
    static {
        NORMAL_TOP = Shapes.or(
                Shapes.box(0.1875, 0.875, 0.8125, 0.8125, 0.9375, 0.875),
                Shapes.box(0.1875, 0.875, 0.125, 0.8125, 0.9375, 0.1875),
                Shapes.box(0.125, 0.875, 0.1875, 0.875, 0.9375, 0.8125),
                Shapes.box(0.125, 0.9375, 0.875, 0.875, 1, 0.9375),
                Shapes.box(0.125, 0.9375, 0.0625, 0.875, 1, 0.125),
                Shapes.box(0.0625, 0.9375, 0.125, 0.9375, 1, 0.875)
        );
        NORMAL_MIDDLE = Shapes.or(
                Shapes.box(0.1875, 0.125, 0.25, 0.8125, 0.875, 0.75),
                Shapes.box(0.25, 0.125, 0.75, 0.75, 0.875, 0.8125),
                Shapes.box(0.25, 0.125, 0.1875, 0.75, 0.875, 0.25)
        );
        NORMAL_BOTTOM = Shapes.or(
                Shapes.box(0.1875, 0.0625, 0.125, 0.8125, 0.125, 0.1875),
                Shapes.box(0.125, 0.0625, 0.1875, 0.875, 0.125, 0.8125),
                Shapes.box(0.1875, 0.0625, 0.8125, 0.8125, 0.125, 0.875),
                Shapes.box(0.125, 0, 0.0625, 0.875, 0.0625, 0.125),
                Shapes.box(0.0625, 0, 0.125, 0.9375, 0.0625, 0.875),
                Shapes.box(0.125, 0, 0.875, 0.875, 0.0625, 0.9375)
        );
        NORMAL_UP_CONNECT = Shapes.or(
                Shapes.box(0.1875, 0.875, 0.25, 0.8125, 1, 0.75),
                Shapes.box(0.25, 0.875, 0.75, 0.75, 1, 0.8125),
                Shapes.box(0.25, 0.875, 0.1875, 0.75, 1, 0.25)
        );
        NORMAL_DOWN_CONNECT = Shapes.or(
                Shapes.box(0.1875, 0, 0.25, 0.8125, 0.125, 0.75),
                Shapes.box(0.25, 0, 0.75, 0.75, 0.125, 0.8125),
                Shapes.box(0.25, 0, 0.1875, 0.75, 0.125, 0.25)
        );
        CARVED_MIDDLE = Shapes.or(
                Shapes.box(0.25, 0.125, 0.25, 0.75, 0.875, 0.75),
                Shapes.box(0.1875, 0.125, 0.1875, 0.8125, 0.1875, 0.25),
                Shapes.box(0.1875, 0.25, 0.1875, 0.8125, 0.3125, 0.25),
                Shapes.box(0.1875, 0.375, 0.1875, 0.8125, 0.4375, 0.25),
                Shapes.box(0.1875, 0.5, 0.1875, 0.8125, 0.5625, 0.25),
                Shapes.box(0.1875, 0.625, 0.1875, 0.8125, 0.6875, 0.25),
                Shapes.box(0.1875, 0.75, 0.1875, 0.8125, 0.8125, 0.25),
                Shapes.box(0.1875, 0.125, 0.75, 0.8125, 0.1875, 0.8125),
                Shapes.box(0.1875, 0.25, 0.75, 0.8125, 0.3125, 0.8125),
                Shapes.box(0.1875, 0.375, 0.75, 0.8125, 0.4375, 0.8125),
                Shapes.box(0.1875, 0.5, 0.75, 0.8125, 0.5625, 0.8125),
                Shapes.box(0.1875, 0.625, 0.75, 0.8125, 0.6875, 0.8125),
                Shapes.box(0.1875, 0.75, 0.75, 0.8125, 0.8125, 0.8125),
                Shapes.box(0.75, 0.125, 0.25, 0.8125, 0.1875, 0.75),
                Shapes.box(0.75, 0.25, 0.25, 0.8125, 0.3125, 0.75),
                Shapes.box(0.75, 0.375, 0.25, 0.8125, 0.4375, 0.75),
                Shapes.box(0.75, 0.5, 0.25, 0.8125, 0.5625, 0.75),
                Shapes.box(0.75, 0.625, 0.25, 0.8125, 0.6875, 0.75),
                Shapes.box(0.75, 0.75, 0.25, 0.8125, 0.8125, 0.75),
                Shapes.box(0.1875, 0.125, 0.25, 0.25, 0.1875, 0.75),
                Shapes.box(0.1875, 0.25, 0.25, 0.25, 0.3125, 0.75),
                Shapes.box(0.1875, 0.375, 0.25, 0.25, 0.4375, 0.75),
                Shapes.box(0.1875, 0.5, 0.25, 0.25, 0.5625, 0.75),
                Shapes.box(0.1875, 0.625, 0.25, 0.25, 0.6875, 0.75),
                Shapes.box(0.1875, 0.75, 0.25, 0.25, 0.8125, 0.75)
        );
        CARVED_UP_CONNECT = Shapes.or(
                Shapes.box(0.25, 0.875, 0.25, 0.75, 1, 0.75),
                Shapes.box(0.1875, 0.875, 0.1875, 0.8125, 0.9375, 0.25),
                Shapes.box(0.75, 0.875, 0.25, 0.8125, 0.9375, 0.75),
                Shapes.box(0.1875, 0.875, 0.75, 0.8125, 0.9375, 0.8125),
                Shapes.box(0.1875, 0.875, 0.25, 0.25, 0.9375, 0.75)
        );
        CARVED_DOWN_CONNECT = Shapes.or(
                Shapes.box(0.25, 0, 0.25, 0.75, 0.125, 0.75),
                Shapes.box(0.1875, 0, 0.1875, 0.8125, 0.0625, 0.25),
                Shapes.box(0.75, 0, 0.25, 0.8125, 0.0625, 0.75),
                Shapes.box(0.1875, 0, 0.75, 0.8125, 0.0625, 0.8125),
                Shapes.box(0.1875, 0, 0.25, 0.25, 0.0625, 0.75)
        );
        LIGHTED_MIDDLE = Shapes.or(
                Shapes.box(0.25, 0.125, 0.75, 0.75, 0.375, 0.8125),
                Shapes.box(0.1875, 0.125, 0.25, 0.8125, 0.375, 0.75),
                Shapes.box(0.25, 0.125, 0.1875, 0.75, 0.375, 0.25),
                Shapes.box(0.25, 0.625, 0.75, 0.75, 0.875, 0.8125),
                Shapes.box(0.1875, 0.625, 0.25, 0.8125, 0.875, 0.75),
                Shapes.box(0.25, 0.625, 0.1875, 0.75, 0.875, 0.25),
                Shapes.box(0.25, 0.375, 0.25, 0.375, 0.625, 0.375),
                Shapes.box(0.625, 0.375, 0.625, 0.75, 0.625, 0.75),
                Shapes.box(0.625, 0.375, 0.25, 0.75, 0.625, 0.375),
                Shapes.box(0.375, 0.375, 0.375, 0.625, 0.625, 0.625),
                Shapes.box(0.375, 0.375, 0.25, 0.625, 0.625, 0.375),
                Shapes.box(0.375, 0.375, 0.625, 0.625, 0.625, 0.75),
                Shapes.box(0.25, 0.375, 0.625, 0.375, 0.625, 0.75),
                Shapes.box(0.625, 0.375, 0.375, 0.75, 0.625, 0.625),
                Shapes.box(0.25, 0.375, 0.375, 0.375, 0.625, 0.625)
        );
        COLUMN_FULL = Shapes.or(NORMAL_BOTTOM, NORMAL_MIDDLE, NORMAL_TOP);
        COLUMN_BASE = Shapes.or(NORMAL_BOTTOM, NORMAL_MIDDLE, NORMAL_UP_CONNECT);
        COLUMN_CONNECT = Shapes.or(NORMAL_DOWN_CONNECT, NORMAL_MIDDLE, NORMAL_UP_CONNECT);
        COLUMN_TOP = Shapes.or(NORMAL_DOWN_CONNECT, NORMAL_MIDDLE, NORMAL_TOP);

        CARVED_COLUMN_FULL = Shapes.or(NORMAL_BOTTOM, CARVED_MIDDLE, NORMAL_TOP);
        CARVED_COLUMN_BASE = Shapes.or(NORMAL_BOTTOM, CARVED_MIDDLE, CARVED_UP_CONNECT);
        CARVED_COLUMN_CONNECT = Shapes.or(CARVED_DOWN_CONNECT, CARVED_MIDDLE, CARVED_UP_CONNECT);
        CARVED_COLUMN_TOP = Shapes.or(CARVED_DOWN_CONNECT, CARVED_MIDDLE, NORMAL_TOP);

        LIGHTED_COLUMN_FULL = Shapes.or(NORMAL_BOTTOM, LIGHTED_MIDDLE, NORMAL_TOP);
        LIGHTED_COLUMN_BASE = Shapes.or(NORMAL_BOTTOM, LIGHTED_MIDDLE, NORMAL_UP_CONNECT);
        LIGHTED_COLUMN_CONNECT = Shapes.or(NORMAL_DOWN_CONNECT, LIGHTED_MIDDLE, NORMAL_UP_CONNECT);
        LIGHTED_COLUMN_TOP = Shapes.or(NORMAL_DOWN_CONNECT, LIGHTED_MIDDLE, NORMAL_TOP);
    }
    @Override
    public VoxelShape getOccModel(@NotNull BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos pos) {
        int countState =
                (getter.getBlockState(pos.below()).getBlock() instanceof ColumnBlock ? 1 : 0)
                        + (getter.getBlockState(pos.above()).getBlock() instanceof ColumnBlock ? 2 : 0);
        if(state.getBlock() instanceof CarvedColumnBlock) {
            return switch (countState){
                case 1 -> CARVED_COLUMN_TOP;
                case 2 -> CARVED_COLUMN_BASE;
                case 3 -> CARVED_COLUMN_CONNECT;
                default -> CARVED_COLUMN_FULL;
            };
        } else if (state.getBlock() instanceof LightedColumnBlock) {
            return switch (countState){
                case 1 -> LIGHTED_COLUMN_TOP;
                case 2 -> LIGHTED_COLUMN_BASE;
                case 3 -> LIGHTED_COLUMN_CONNECT;
                default -> LIGHTED_COLUMN_FULL;
            };
        } else {
            return switch (countState){
                case 1 -> COLUMN_TOP;
                case 2 -> COLUMN_BASE;
                case 3 -> COLUMN_CONNECT;
                default -> COLUMN_FULL;
            };
        }
    }

    @Override
    public @NotNull String getSerializedName() {return name;}
}
