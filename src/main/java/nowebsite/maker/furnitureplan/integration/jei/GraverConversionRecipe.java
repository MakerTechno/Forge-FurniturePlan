package nowebsite.maker.furnitureplan.integration.jei;

import net.minecraft.world.item.ItemStack;

import java.util.List;

// 定义转换配方对象
public record GraverConversionRecipe(List<ItemStack> inputs, List<ItemStack> outputs) {}

