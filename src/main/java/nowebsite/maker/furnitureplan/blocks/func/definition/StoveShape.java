package nowebsite.maker.furnitureplan.blocks.func.definition;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import nowebsite.maker.furnitureplan.blocks.cookingUtensils.StoveBlock;
import nowebsite.maker.furnitureplan.utils.ModelSR;
import org.jetbrains.annotations.NotNull;

public enum StoveShape implements ModelSR {
    STOVE_LIT("l"),
    STOVE_UNLIT("u"),
    STOVE_AND_POT_LIT("pl"),
    STOVE_AND_POT_UNLIT("pu");
    private final String name;
    StoveShape(String name){
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    public String toString() {
        return this.name;
    }
    public boolean isLit(){
        return switch (this){
            case STOVE_LIT, STOVE_AND_POT_LIT -> true;
            case STOVE_UNLIT, STOVE_AND_POT_UNLIT -> false;
        };
    }
    public boolean hasPot(){
        return switch (this){
            case STOVE_LIT, STOVE_UNLIT -> false;
            case STOVE_AND_POT_LIT, STOVE_AND_POT_UNLIT -> true;
        };
    }
    public StoveShape addPot(){
        if (!this.hasPot()){
            if (this.isLit()) return STOVE_AND_POT_LIT;
            else return STOVE_AND_POT_UNLIT;
        } else return this;
    }
    public StoveShape litIt(){
        if (!isLit()) {
            if (this.hasPot()) return STOVE_AND_POT_LIT;
            else return STOVE_LIT;
        } else return this;
    }
    @Override
    public @NotNull String getSerializedName() {
        return this.name;
    }
    public static final VoxelShape STOVE, STOVE_WITH_POT_N, STOVE_WITH_POT_E, STOVE_WITH_POT_S, STOVE_WITH_POT_W;
    static {
        STOVE = Shapes.or(
                Shapes.box(0.0625, 0.0625, 0.0625, 0.9375, 0.125, 0.9375),
                Shapes.box(0, 0, 0, 1, 0.0625, 1),
                Shapes.box(0.1875, 0.125, 0.1875, 0.8125, 0.1875, 0.8125)
        );
        STOVE_WITH_POT_N = Shapes.or(
                STOVE,
                Shapes.box(0.125, 0.1875, 0.125, 0.875, 0.25, 0.875),
                Shapes.box(0.453125, 0.21875, -0.25, 0.546875, 0.25, 0.125)
        );
        STOVE_WITH_POT_E = Shapes.or(
                STOVE,
                Shapes.box(0.125, 0.1875, 0.125, 0.875, 0.25, 0.875),
                Shapes.box(0.875, 0.21875, 0.453125, 1.25, 0.25, 0.546875)
        );
        STOVE_WITH_POT_S = Shapes.or(
                STOVE,
                Shapes.box(0.125, 0.1875, 0.125, 0.875, 0.25, 0.875),
                Shapes.box(0.453125, 0.21875, 0.875, 0.546875, 0.25, 1.25)
        );
        STOVE_WITH_POT_W = Shapes.or(
                STOVE,
                Shapes.box(0.125, 0.1875, 0.125, 0.875, 0.25, 0.875),
                Shapes.box(-0.25, 0.21875, 0.453125, 0.125, 0.25, 0.546875)
        );
    }

    @Override
    public ResourceLocation getModel(Block block) {
        return switch (this){
            case STOVE_LIT -> modLoc("stove");
            case STOVE_UNLIT -> modLoc("stove_off");
            case STOVE_AND_POT_LIT -> modLoc("stove_with_pot");
            case STOVE_AND_POT_UNLIT -> modLoc("stove_with_pot_off");
        };
    }

    @Override
    public ResourceLocation getTexture() {
        return modLoc("block/stove");
    }

    @Override
    public VoxelShape getOccModel(@NotNull BlockState state, BlockGetter getter, BlockPos pos) {
        return switch (this){
            case STOVE_LIT, STOVE_UNLIT -> STOVE;
            case STOVE_AND_POT_LIT, STOVE_AND_POT_UNLIT -> switch (state.getValue(StoveBlock.FACING)){
                case UP, DOWN -> null;
                case NORTH -> STOVE_WITH_POT_N;
                case SOUTH -> STOVE_WITH_POT_S;
                case WEST -> STOVE_WITH_POT_W;
                case EAST -> STOVE_WITH_POT_E;
            } ;
        };
    }

}
