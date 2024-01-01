package nowebsite.maker.furnitureplan.blocks.tableware;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.AbstractGlassBlock;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.items.ItemStackHandler;
import nowebsite.maker.furnitureplan.blocks.tableware.blockentities.GlassBBlockEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

@SuppressWarnings("deprecation")
public class GlassBBlock extends AbstractGlassBlock implements SimpleWaterloggedBlock, EntityBlock {
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
    public void destroy(@NotNull LevelAccessor level, @NotNull BlockPos pos, @NotNull BlockState state) {
        super.destroy(level, pos, state);

    }
    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable BlockGetter level, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
        super.appendHoverText(stack, level, tooltip, flag);
        CompoundTag compoundtag = BlockItem.getBlockEntityData(stack);
        if (compoundtag == null) return;

        ItemStackHandler handler = new ItemStackHandler(1);
        handler.deserializeNBT(compoundtag.copy().getCompound(GlassBBlockEntity.INVENTORY));
        tooltip.add(Component.literal(PotionUtils.getPotion(handler.getStackInSlot(0)).getName("Potion:")));
    }
}
