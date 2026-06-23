package nowebsite.maker.furnitureplan.common.block.abstraction.definition;

import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import nowebsite.maker.furnitureplan.utils.ICustomModelInfo;
import org.jetbrains.annotations.NotNull;

public enum StoveShape implements ICustomModelInfo {
    STOVE_LIT("on"),
    STOVE_UNLIT("off");
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
            case STOVE_LIT -> true;
            case STOVE_UNLIT -> false;
        };
    }

    public StoveShape litIt(){
        if (!isLit()) {
            return STOVE_LIT;
        } else return this;
    }
    @Override
    public @NotNull String getSerializedName() {
        return this.name;
    }

    @Override
    public Identifier getModel(Block block) {
        return switch (this){
            case STOVE_LIT -> blockTemplateLoc("stove_on");
            case STOVE_UNLIT -> blockTemplateLoc("stove_off");
        };
    }


    @Override
    public VoxelShape getOccModel(@NotNull BlockState state) {
        return Shapes.block();
    }

}
