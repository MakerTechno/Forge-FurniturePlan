package nowebsite.maker.furnitureplan.common.item;

import net.minecraft.core.BlockPos;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.ProblemReporter;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.component.TypedEntityData;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.storage.TagValueOutput;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import nowebsite.maker.furnitureplan.FurniturePlan;
import nowebsite.maker.furnitureplan.common.block.cooking.utensils.entities.GlassBBlockEntity;
import nowebsite.maker.furnitureplan.common.block.cooking.utensils.entities.HasGlassEntity;
import nowebsite.maker.furnitureplan.common.init.FPBlockReg;

import java.awt.*;
import java.util.function.Consumer;

public class GlassBBlockItem extends BlockItem {
    public GlassBBlockItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        BlockHitResult hitBlock = getPlayerPOVHitResult(level, player, ClipContext.Fluid.SOURCE_ONLY);

        if (level.isClientSide()) return InteractionResult.CONSUME;
        if (hitBlock.getType().equals(HitResult.Type.MISS) || !hitBlock.getType().equals(HitResult.Type.BLOCK)) return InteractionResult.FAIL;

        ItemStack stackInHand = player.getItemInHand(hand);
        BlockPos blockPos = hitBlock.getBlockPos();
        GlassBBlockEntity blockEntity = new GlassBBlockEntity(BlockPos.ZERO, FPBlockReg.GLASS_B_BLOCK.get().defaultBlockState());
        ItemStack potionInside = readItemContentsFromData(level, stackInHand, blockEntity);

        if (!level.mayInteract(player, blockPos) || !potionInside.isEmpty()) return InteractionResult.FAIL;
        else if (level.getBlockState(blockPos).is(FPBlockReg.FOOD_PLATE_BLOCK.get())) return InteractionResult.PASS;
        else if (!level.getFluidState(blockPos).is(FluidTags.WATER)) return InteractionResult.FAIL;


        player.awardStat(Stats.ITEM_USED.get(this));
        level.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.BOTTLE_FILL, SoundSource.NEUTRAL, 1.0F, 1.0F);
        level.gameEvent(player, GameEvent.FLUID_PICKUP, blockPos);

        blockEntity.changePotion(PotionContents.createItemStack(Items.POTION, Potions.WATER));
        ItemStack newStack = player.getAbilities().instabuild ? stackInHand.copyWithCount(1) : stackInHand.split(1);
        saveDataToItem(newStack, player.registryAccess(), blockEntity);
        if (player.getInventory().getFreeSlot() != -1) {
            player.getInventory().add(newStack.copy());
            player.getInventory().setChanged();
        }
        else player.drop(newStack, false,false);
        return InteractionResult.SUCCESS_SERVER;
    }



    public static <T extends BlockEntity & HasGlassEntity> ItemStack readItemContentsFromData(Level level, ItemStack stack, T blockEntity) {
        TypedEntityData<BlockEntityType<?>> customData = stack.get(DataComponents.BLOCK_ENTITY_DATA);
        if (customData != null) {
            BlockEntityType<?> type = blockEntity.getType();
            if (type != customData.type()) return ItemStack.EMPTY;
            customData.loadInto(blockEntity, level.registryAccess());
            return blockEntity.getPotionStack();
        }
        return ItemStack.EMPTY;
    }

    public static void saveDataToItem(ItemStack stack, RegistryAccess access, BlockEntity blockEntity){
        try (ProblemReporter.ScopedCollector reporter = new ProblemReporter.ScopedCollector(blockEntity.problemPath(), FurniturePlan.LOGGER)) {
            TagValueOutput valueOutput = TagValueOutput.createWithContext(reporter, access);
            blockEntity.saveWithoutMetadata(valueOutput);
            BlockItem.setBlockEntityData(stack, FPBlockReg.GLASS_B_BLOCK_ENTITY.get(), valueOutput);
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
        super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
        builder.accept(Component.translatable("item.furnitureplan.glass.desc"));
        Level level = context.level();
        if (level == null) return;
        GlassBBlockEntity blockEntity = new GlassBBlockEntity(BlockPos.ZERO, FPBlockReg.GLASS_B_BLOCK.get().defaultBlockState());
        GlassBBlockItem.readItemContentsFromData(level, itemStack, blockEntity);
        ItemStack potionStack = blockEntity.getPotionStack();
        PotionContents potioncontents = potionStack.getOrDefault(DataComponents.POTION_CONTENTS, PotionContents.EMPTY);
        if (potioncontents.potion().isPresent()) {
            builder.accept(
                Component.translatable("item.minecraft.potion")
                    .append(":  ")
                    .withColor(Color.GRAY.getRGB())
                    .append(potionStack.getItemName())
                    .withColor(potioncontents.getColor())
            );
        }
    }
}
