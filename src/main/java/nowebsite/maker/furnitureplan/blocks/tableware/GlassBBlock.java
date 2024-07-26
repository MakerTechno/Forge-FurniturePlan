package nowebsite.maker.furnitureplan.blocks.tableware;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.HalfTransparentBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import nowebsite.maker.furnitureplan.blocks.func.BaseSmallHallBasedBlock;
import nowebsite.maker.furnitureplan.blocks.func.ISimpleBlock;
import nowebsite.maker.furnitureplan.blocks.tableware.blockentities.GlassBBlockEntity;
import nowebsite.maker.furnitureplan.registry.BlockRegistration;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

@SuppressWarnings("deprecation")
public class GlassBBlock extends HalfTransparentBlock implements SimpleWaterloggedBlock, EntityBlock, ISimpleBlock {
    @Override
    protected @NotNull VoxelShape getVisualShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return Shapes.empty();
    }

    @Override
    protected float getShadeBrightness(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos) {
        return 1.0F;
    }

    @Override
    protected boolean propagatesSkylightDown(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos) {
        return true;
    }

    public static final VoxelShape INSIDE = Shapes.box(0.40625, 0.00005, 0.40625, 0.59375, 0.48, 0.59375);
    public static VoxelShape SHAPE = Shapes.empty();
    static {
        SHAPE = Shapes.join(SHAPE, Shapes.box(0.59375, 0, 0.40625, 0.65625, 0.5, 0.65625), BooleanOp.OR);
        SHAPE = Shapes.join(SHAPE, Shapes.box(0.40625, 0, 0.34375, 0.65625, 0.5, 0.40625), BooleanOp.OR);
        SHAPE = Shapes.join(SHAPE, Shapes.box(0.34375, 0, 0.59375, 0.59375, 0.5, 0.65625), BooleanOp.OR);
        SHAPE = Shapes.join(SHAPE, Shapes.box(0.34375, 0, 0.34375, 0.40625, 0.5, 0.59375), BooleanOp.OR);
        SHAPE = Shapes.join(SHAPE, Shapes.box(0.40625, 0, 0.40625, 0.59375, 0.00003, 0.59375), BooleanOp.OR);
    }
    public GlassBBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void setPlacedBy(@NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState state, @Nullable LivingEntity pPlacer, @NotNull ItemStack stack) {
        super.setPlacedBy(level, pos, state, pPlacer, stack);
        CompoundTag tag = stack.();
        if (stack.is(BlockRegistration.GLASS_B_BLOCK_ITEM.get()) && tag != null && tag.contains("BlockEntityTag")){
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity != null) {
                blockEntity.load(tag.getCompound("BlockEntityTag"));
            }
        }
    }

    @Override
    public void onRemove(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState newState, boolean pMovedByPiston) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof GlassBBlockEntity cast){
            cast.dropBottle();
        }
        super.onRemove(state, level, pos, newState, pMovedByPiston);
    }

    @Override
    public @NotNull InteractionResult use(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hit) {
        if (!level.isClientSide) {
            if (!(level.getBlockEntity(pos) instanceof GlassBBlockEntity cast)) {
                throw new IllegalStateException("GlassB block entity at x: " + pos.getX() + ", y: " + pos.getY() + ", z: " + pos.getZ() + " could not be found.");
            }
            ItemStack stack = player.getItemInHand(hand);
            if (cast.getPotionStack().isEmpty() && stack.getItem() instanceof PotionItem) {
                if (!cast.fillPotion(player, player.getAbilities().instabuild ? stack.copy() : stack)) return InteractionResult.PASS;
            } else if (stack.is(Items.GLASS_BOTTLE)) {
                if (!cast.restorePotion(player, player.getAbilities().instabuild ? stack.copy() : stack)) return InteractionResult.PASS;
            } else if (!cast.usePotion(player)) return InteractionResult.PASS;
        }
        return InteractionResult.SUCCESS;
    }
    @Override
    public @NotNull VoxelShape getInteractionShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos) {
        return INSIDE;
    }
    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return SHAPE;
    }
    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return new GlassBBlockEntity(pos, state);
    }
    @Override
    public boolean canSurvive(@NotNull BlockState state, @NotNull LevelReader level, @NotNull BlockPos pos) {
        return BaseSmallHallBasedBlock.canSurvive(level,pos);
    }
    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable BlockGetter level, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
        CompoundTag compoundtag = BlockItem.getBlockEntityData(stack);
        if (compoundtag == null) {
            super.appendHoverText(stack, level, tooltip, flag);
            return;
        }

        ItemStackHandler handler = new ItemStackHandler(2);
        handler.deserializeNBT(compoundtag.getCompound(GlassBBlockEntity.INVENTORY));
        ItemStack stack1 = handler.getStackInSlot(1);
        if (!stack1.isEmpty()) {
            tooltip.add(
                    Component.translatable("item.minecraft.potion")
                            .append(":  ")
                            .append(Component.translatable(PotionUtils.getPotion(stack1).getName("item.minecraft.potion.effect.")))
                            .withStyle(ChatFormatting.GRAY)
            );
        }
        super.appendHoverText(stack, level, tooltip, flag);
    }

    @Override
    public String parentName() {
        return "glass";
    }

    @Override
    public String textureKey() {
        return "particle";
    }

    @Override
    public String textureName() {
        return parentName();
    }
}
