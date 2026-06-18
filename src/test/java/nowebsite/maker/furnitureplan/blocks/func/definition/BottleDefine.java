package nowebsite.maker.furnitureplan.blocks.func.definition;

import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import nowebsite.maker.furnitureplan.utils.ICustomModelInfo;
import org.jetbrains.annotations.NotNull;

public enum BottleDefine implements ICustomModelInfo {
    NORMAL("normal"),
    INSERT("insert");
    /*Not the best way to complete, will be restructured.*/
    private final String name;
    BottleDefine(String name) {
        this.name = name;
    }
    @Override
    public Identifier getModel(Block block) {
        return switch (this) {
            case NORMAL -> modTemplateLoc("bottle_normal");
            case INSERT -> modTemplateLoc("bottle_verd");
        };
    }
    @Override
    public Identifier getTexture() {
        return modTemplateLoc("block/bottle");
    }
    public static final VoxelShape SHAPE = Shapes.box(0.125, 0, 0.125, 0.875, 0.9375, 0.875);
    @Override
    public VoxelShape getOccModel(@NotNull BlockState state) {
        return SHAPE;
    }
    @Override
    public @NotNull String getSerializedName() {
        return this.name;
    }
}
