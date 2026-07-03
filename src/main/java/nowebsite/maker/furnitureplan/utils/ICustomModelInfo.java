package nowebsite.maker.furnitureplan.utils;

import net.minecraft.resources.Identifier;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;
import nowebsite.maker.furnitureplan.FurniturePlan;
import org.jetbrains.annotations.NotNull;

public interface ICustomModelInfo extends StringRepresentable {
    Identifier getModel(Block block);
    VoxelShape getOccModel(@NotNull BlockState state);

    default Identifier blockTemplateLoc(String name){
        return Identifier.fromNamespaceAndPath(FurniturePlan.MOD_ID, "block/template/" + name);
    }
}
