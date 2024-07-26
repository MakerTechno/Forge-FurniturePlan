package nowebsite.maker.furnitureplan.items;

import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.ItemStackHandler;
import nowebsite.maker.furnitureplan.blocks.tableware.blockentities.GlassBBlockEntity;
import nowebsite.maker.furnitureplan.registry.BlockRegistration;
import org.jetbrains.annotations.NotNull;

public class GlassBBlockItem extends BlockItem {
    public GlassBBlockItem(Block block, Properties properties) {
        super(block, properties);
    }
    @Override
    @SuppressWarnings("deprecation")
    public @NotNull InteractionResult useOn(@NotNull UseOnContext context) {
        Level level = context.getLevel();
        if (!level.isClientSide) {
            BlockState state = level.getBlockState(context.getClickedPos());
            ItemStack stack = context.getItemInHand();
            ItemStackHandler handler = new ItemStackHandler(2);
            CustomData data = stack.get(DataComponents.CUSTOM_DATA);

            if (data != null && data.contains("BlockEntityTag")) {
                CompoundTag unsafe = data.getUnsafe();
                handler.deserializeNBT(context.getLevel().registryAccess(), unsafe.getCompound("BlockEntityTag").getCompound(GlassBBlockEntity.INVENTORY));

                if (state.is(Blocks.WATER) && (handler.getStackInSlot(1).is(Items.AIR) || handler.getStackInSlot(1).equals(ItemStack.EMPTY))) {
                    handler.setStackInSlot(1, PotionContents.createItemStack(Items.POTION, Potions.WATER));
                    unsafe.getCompound("BlockEntityTag").remove(GlassBBlockEntity.INVENTORY);
                    unsafe.getCompound("BlockEntityTag").put(GlassBBlockEntity.INVENTORY, handler.serializeNBT(context.getLevel().registryAccess()));
                    level.setBlockAndUpdate(context.getClickedPos(), Blocks.AIR.defaultBlockState());
                    return InteractionResult.SUCCESS;

                } else if (state.is(BlockRegistration.FOOD_PLATE_BLOCK.get())) return InteractionResult.PASS;
            }
        }
        else return super.useOn(context);
        return InteractionResult.PASS;
    }
    @Override
    @SuppressWarnings("deprecation")
    protected boolean placeBlock(@NotNull BlockPlaceContext context, @NotNull BlockState state) {
        Level level = context.getLevel();
        if (super.placeBlock(context, state)) {
            if (!level.isClientSide) {
                ItemStack stack = context.getItemInHand();
                ItemStackHandler handler = new ItemStackHandler(2);
                CustomData data = stack.get(DataComponents.CUSTOM_DATA);

                if (data != null && data.copyTag().contains("BlockEntityTag")) {
                    CompoundTag unsafe = data.getUnsafe();
                    handler.deserializeNBT(context.getLevel().registryAccess(), unsafe.getCompound("BlockEntityTag").getCompound(GlassBBlockEntity.INVENTORY));
                }
                if (level.getBlockEntity(context.getClickedPos()) instanceof GlassBBlockEntity cast) {
                    cast.changePotion(handler.getStackInSlot(1));
                }
            }
            return true;
        }
        return false;
    }

}
