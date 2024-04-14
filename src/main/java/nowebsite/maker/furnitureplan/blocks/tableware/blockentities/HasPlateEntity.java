package nowebsite.maker.furnitureplan.blocks.tableware.blockentities;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.extensions.IForgeBlockEntity;
import net.minecraftforge.items.ItemStackHandler;

public interface HasPlateEntity {
    void changeFood(ItemStack stack);
}
