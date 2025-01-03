package nowebsite.maker.furnitureplan.tools;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

@SuppressWarnings("unused")
public class Tools {

    public static void spawnInWorld(Level level, BlockPos pos, ItemStack remaining) {
        if (!remaining.isEmpty()) {
            ItemEntity entityItem = new ItemEntity(level, pos.getX() + .5, pos.getY() + .5, pos.getZ() + .5, remaining);
            entityItem.setPickUpDelay(40);
            entityItem.setDeltaMovement(entityItem.getDeltaMovement().multiply(0, 1, 0));
            level.addFreshEntity(entityItem);
        }
    }
}
