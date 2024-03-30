package nowebsite.maker.furnitureplan.utils;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;
import nowebsite.maker.furnitureplan.FurniturePlan;
import org.jetbrains.annotations.NotNull;

public interface ModelSR extends StringRepresentable {
    ResourceLocation getModel();
    ResourceLocation getTexture();
    VoxelShape getOccModel(@NotNull BlockState state);
    default ResourceLocation modLoc(String name){
        return new ResourceLocation(FurniturePlan.MOD_ID, name);
    }
}
