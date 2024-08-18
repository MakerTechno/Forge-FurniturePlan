package nowebsite.maker.furnitureplan.items;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.items.ItemStackHandler;
import nowebsite.maker.furnitureplan.blocks.tableware.blockentities.GlassBBlockEntity;
import nowebsite.maker.furnitureplan.registry.BlockRegistration;
import org.jetbrains.annotations.NotNull;

public class GlassBBlockItem extends BlockItem {
    public GlassBBlockItem(Block block, Properties properties) {
        super(block, properties);
    }
    @Override
    public @NotNull InteractionResult useOn(@NotNull UseOnContext context) {
        Level level = context.getLevel();
        Player player = context.getPlayer();
        if (player == null) return super.useOn(context);
        ItemStack itemStack = player.getItemInHand(context.getHand());
        BlockHitResult hitResult = getPlayerPOVHitResult(level, player, ClipContext.Fluid.SOURCE_ONLY);
        if (hitResult.getType() != HitResult.Type.MISS) {
            if (hitResult.getType() == HitResult.Type.BLOCK) {
                BlockPos blockPos = hitResult.getBlockPos();
                ItemStackHandler handler = new ItemStackHandler(2);
                loadFromEntityTag(itemStack, handler);

                if (!level.mayInteract(player, blockPos) || !handler.getStackInSlot(1).isEmpty() || !level.mayInteract(player, blockPos)) {
                    return super.useOn(context);
                }

                if (level.getFluidState(blockPos).is(FluidTags.WATER)) {
                    level.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.BOTTLE_FILL, SoundSource.NEUTRAL, 1.0F, 1.0F);
                    level.gameEvent(player, GameEvent.FLUID_PICKUP, blockPos);

                    handler.setStackInSlot(1, PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.WATER));
                    itemStack.shrink(1);
                    saveToEntityTag(itemStack, handler);

                    return InteractionResult.SUCCESS;
                }
            }
        }
        if (!level.isClientSide) {
            BlockState state = level.getBlockState(context.getClickedPos());
            if (state.is(BlockRegistration.FOOD_PLATE_BLOCK.get())) return InteractionResult.PASS;
        }
        return super.useOn(context);
    }
    public static void loadFromEntityTag(@NotNull ItemStack stack, ItemStackHandler handler){
        if (stack.getTag() != null && stack.getTag().contains("BlockEntityTag")) {
            handler.deserializeNBT(stack.getTag().getCompound("BlockEntityTag").getCompound(GlassBBlockEntity.INVENTORY));
        }
    }
    public static void saveToEntityTag(@NotNull ItemStack stack, ItemStackHandler handler) {
        if (stack.getTag() == null){
            BlockItem.setBlockEntityData(
                    stack,
                    BlockRegistration.GLASS_B_BLOCK_ENTITY.get(),
                    new GlassBBlockEntity(
                            BlockPos.ZERO,
                            BlockRegistration.GLASS_B_BLOCK.get().defaultBlockState()
                    ).saveWithoutMetadata()
            );
        }
        CompoundTag tag = stack.getTag().getCompound("BlockEntityTag");
        if (tag.get(GlassBBlockEntity.INVENTORY) != null) tag.remove(GlassBBlockEntity.INVENTORY);
        tag.put(GlassBBlockEntity.INVENTORY, handler.serializeNBT());
    }
}
