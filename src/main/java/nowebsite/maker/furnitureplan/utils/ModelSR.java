package nowebsite.maker.furnitureplan.utils;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;
import nowebsite.maker.furnitureplan.FurniturePlan;
import org.jetbrains.annotations.NotNull;

public interface ModelSR extends StringRepresentable {
    ResourceLocation getModel(Block block);
    ResourceLocation getTexture();
    VoxelShape getOccModel(@NotNull BlockState state, BlockGetter getter, BlockPos pos);

    default ResourceLocation modLoc(String name){
        return new ResourceLocation(FurniturePlan.MOD_ID, name);
    }
}
