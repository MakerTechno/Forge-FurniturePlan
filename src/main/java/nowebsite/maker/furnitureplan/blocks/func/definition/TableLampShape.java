package nowebsite.maker.furnitureplan.blocks.func.definition;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import nowebsite.maker.furnitureplan.utils.ModelSR;
import org.jetbrains.annotations.NotNull;

public enum TableLampShape implements ModelSR {
    ON("on"),
    OFF("off");
    private final String name;
    TableLampShape(String name) {
        this.name = name;
    }
    @Override
    public ResourceLocation getModel(Block block) {
        return modLoc("table_lamp_x" + this.getSerializedName());
    }
    @Override
    public ResourceLocation getTexture() {
        return modLoc("block/table_lamp");   //Use only as particle
    }
    private static final VoxelShape SHAPE = Shapes.or(
        Shapes.box(0.3125, 0, 0.3125, 0.6875, 0.0625, 0.6875),
        Shapes.box(0.453125, 0.0625, 0.453125, 0.546875, 0.4375, 0.546875),
        Shapes.box(0.1875, 0.4375, 0.1875, 0.8125, 0.8125, 0.8125)
    );
    @Override
    public VoxelShape getOccModel(@NotNull BlockState state, BlockGetter getter, BlockPos pos) {
        return SHAPE;
    }
    @Override
    public @NotNull String getSerializedName() {
        return this.name;
    }
    public boolean isLit(){
        return switch (this) {
            case ON -> true;
            case OFF -> false;
        };
    }
}
