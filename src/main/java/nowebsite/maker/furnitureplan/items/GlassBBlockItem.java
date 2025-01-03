package nowebsite.maker.furnitureplan.items;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.neoforged.neoforge.items.ItemStackHandler;
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
                loadFromEntityData(player.registryAccess(), itemStack, handler);

                if (!level.mayInteract(player, blockPos) || !handler.getStackInSlot(1).isEmpty() || !level.mayInteract(player, blockPos)) {
                    return super.useOn(context);
                }

                if (level.getFluidState(blockPos).is(FluidTags.WATER)) {
                    level.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.BOTTLE_FILL, SoundSource.NEUTRAL, 1.0F, 1.0F);
                    level.gameEvent(player, GameEvent.FLUID_PICKUP, blockPos);

                    handler.setStackInSlot(1, PotionContents.createItemStack(Items.POTION, Potions.WATER));
                    ItemStack newStack = itemStack.split(1);
                    saveToEntityData(player.registryAccess(), newStack, handler);
                    if (player.getInventory().getFreeSlot() != -1) player.getInventory().add(newStack);
                    else player.drop(newStack, false,false);

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
    public static void loadFromEntityData(HolderLookup.Provider provider, @NotNull ItemStack stack, ItemStackHandler handler){
        CustomData data = stack.get(DataComponents.BLOCK_ENTITY_DATA);
        if (data != null) {
            CompoundTag copyTag = data.copyTag();
            handler.deserializeNBT(provider, copyTag.getCompound(GlassBBlockEntity.INVENTORY));
        }
    }
    @SuppressWarnings("deprecation")
    public static void saveToEntityData(HolderLookup.Provider provider, @NotNull ItemStack stack, ItemStackHandler handler){
        CustomData data = stack.getOrDefault(DataComponents.BLOCK_ENTITY_DATA, CustomData.EMPTY);
        if (data.isEmpty()) {
            BlockItem.setBlockEntityData(
                    stack,
                    BlockRegistration.GLASS_B_BLOCK_ENTITY.get(),
                    new GlassBBlockEntity(
                            BlockPos.ZERO,
                            BlockRegistration.GLASS_B_BLOCK.get().defaultBlockState()
                    ).saveWithoutMetadata(provider)
            );
            data = stack.getOrDefault(DataComponents.BLOCK_ENTITY_DATA, CustomData.EMPTY);
        }
        CompoundTag unsafeTag = data.getUnsafe();
        if (unsafeTag.get(GlassBBlockEntity.INVENTORY) != null)unsafeTag.remove(GlassBBlockEntity.INVENTORY);
        unsafeTag.put(GlassBBlockEntity.INVENTORY, handler.serializeNBT(provider));
        stack.set(DataComponents.BLOCK_ENTITY_DATA, data);
    }
}
