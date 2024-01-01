package nowebsite.maker.furnitureplan.utils;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.registries.ForgeRegistries;

public class Utils {
    public static final String FLUID_TAG_KEY="furnitureplan:fluid";
    public static FluidStack extractFluid(ItemStack item) {
        if (item.hasTag()) {
            CompoundTag tag = item.getTag();
            if(tag.contains(FLUID_TAG_KEY)) {
                tag=tag.getCompound(FLUID_TAG_KEY);
                Fluid f = ForgeRegistries.FLUIDS.getValue(new ResourceLocation(tag.getString("type")));
                if (f != null&&f!= Fluids.EMPTY) {
                    FluidStack res = new FluidStack(f, 250);
                    if(tag.contains("data")) {
                        CompoundTag ntag = tag.getCompound("data");
                        res.setTag(ntag);
                    }
                    return res;
                }
            }else if (tag.contains("type")) {
                Fluid f = ForgeRegistries.FLUIDS.getValue(new ResourceLocation(tag.getString("type")));
                if (f != null&&f!=Fluids.EMPTY) {
                    FluidStack res = new FluidStack(f, 250);
                    CompoundTag ntag = tag.copy();
                    ntag.remove("type");
                    if (!ntag.isEmpty())
                        res.setTag(ntag);
                    return res;
                }
            }
        }
        return FluidStack.EMPTY;
    }
}
