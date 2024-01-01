package nowebsite.maker.furnitureplan.items;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import nowebsite.maker.furnitureplan.blocks.tableware.GlassBBlock;
import nowebsite.maker.furnitureplan.blocks.tableware.blockentities.GlassBBlockEntity;
import org.jetbrains.annotations.NotNull;

public class GlassBBlockItem extends BlockItem {
    public GlassBBlockItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public void onDestroyed(@NotNull ItemEntity itemEntity) {
        if (this.getBlock() instanceof GlassBBlock) {
            ItemStack itemstack = itemEntity.getItem();
            CompoundTag compoundtag = getBlockEntityData(itemstack);
            if (compoundtag != null && compoundtag.contains(GlassBBlockEntity.INVENTORY)) {
                onContainerDestroyed(itemEntity, itemstack);
            }
        }
    }

    public static void onContainerDestroyed(ItemEntity pItemEntity, ItemStack stack) {
        Level level = pItemEntity.level;
        if (!level.isClientSide) {
            level.addFreshEntity(new ItemEntity(level, pItemEntity.getX(), pItemEntity.getY(), pItemEntity.getZ(), stack));
        }
    }
}
