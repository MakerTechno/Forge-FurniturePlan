package nowebsite.maker.furnitureplan.utils;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("unused")
public class Utils {
    public static final String FLUID_TAG_KEY="furnitureplan:fluid";
    public static FluidStack extractFluid(@NotNull ItemStack item) {
        if (item.hasTag()) {
            CompoundTag tag = item.getTag();
            if (tag != null && tag.contains(FLUID_TAG_KEY)) {
                tag = tag.getCompound(FLUID_TAG_KEY);
                Fluid f = ForgeRegistries.FLUIDS.getValue(new ResourceLocation(tag.getString("type")));
                if (f != null && f != Fluids.EMPTY) {
                    FluidStack res = new FluidStack(f, 250);
                    if (tag.contains("data")) {
                        CompoundTag newTag = tag.getCompound("data");
                        res.setTag(newTag);
                    }
                    return res;
                }
            }
        }
        return FluidStack.EMPTY;
    }
}
