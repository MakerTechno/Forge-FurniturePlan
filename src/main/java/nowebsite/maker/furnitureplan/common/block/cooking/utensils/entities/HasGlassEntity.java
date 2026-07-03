package nowebsite.maker.furnitureplan.common.block.cooking.utensils.entities;

import net.minecraft.world.item.ItemStack;

public interface HasGlassEntity {
    void changePotion(ItemStack stack);
    ItemStack getPotionStack();
}
