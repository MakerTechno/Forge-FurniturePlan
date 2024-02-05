package nowebsite.maker.furnitureplan.utils;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.StringRepresentable;
import nowebsite.maker.furnitureplan.FurniturePlan;

public interface ModelSR extends StringRepresentable {
    ResourceLocation getModel();
    ResourceLocation getTexture();
    default ResourceLocation modLoc(String name){
        return new ResourceLocation(FurniturePlan.MOD_ID, name);
    }
}
