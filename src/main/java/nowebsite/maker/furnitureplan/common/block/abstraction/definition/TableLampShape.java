package nowebsite.maker.furnitureplan.common.block.abstraction.definition;

import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import nowebsite.maker.furnitureplan.utils.ICustomModelInfo;
import org.jetbrains.annotations.NotNull;

public enum TableLampShape implements ICustomModelInfo {
    OFF("off"), ON("on");
    private final String name;
    TableLampShape(String name) {
        this.name = name;
    }

    @Override
    public Identifier getModel(Block block) {
        return blockTemplateLoc("table_lamp_" + name);
    }

    private static final VoxelShape SHAPE = Shapes.or(
        Shapes.box(0.3125, 0, 0.3125, 0.6875, 0.0625, 0.6875),
        Shapes.box(0.453125, 0.0625, 0.453125, 0.546875, 0.75, 0.546875),
        Shapes.box(0.25, 0.75, 0.25, 0.75, 0.8125, 0.75),
        Shapes.box(0.25, 0.4375, 0.1875, 0.75, 0.8125, 0.25),
        Shapes.box(0.25, 0.4375, 0.75, 0.75, 0.8125, 0.8125),
        Shapes.box(0.1875, 0.4375, 0.1875, 0.25, 0.8125, 0.8125),
        Shapes.box(0.75, 0.4375, 0.1875, 0.8125, 0.8125, 0.8125)
    );
    @Override
    public VoxelShape getOccModel(@NotNull BlockState state) {
        return SHAPE;
    }
    @Override
    public @NotNull String getSerializedName() {
        return this.name;
    }
    public boolean isLit(){
        return this.equals(ON);
    }
}
