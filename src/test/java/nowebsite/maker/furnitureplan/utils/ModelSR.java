package nowebsite.maker.furnitureplan.utils;

import net.minecraft.resources.Identifier;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;
import nowebsite.maker.furnitureplan.FurniturePlan;
import org.jetbrains.annotations.NotNull;

public interface ModelSR extends StringRepresentable {
    Identifier getModel(Block block);
    Identifier getTexture();
    VoxelShape getOccModel(@NotNull BlockState state);

    default Identifier modLoc(String name){
        return Identifier.fromNamespaceAndPath(FurniturePlan.MOD_ID, name);
    }
    default Identifier mcLoc(String name) {
        return Identifier.parse(name);
    }
}
