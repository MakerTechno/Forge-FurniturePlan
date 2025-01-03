package nowebsite.maker.furnitureplan.blocks.tableware;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.items.ItemStackHandler;
import nowebsite.maker.furnitureplan.blocks.func.BaseSmallHallBasedBlock;
import nowebsite.maker.furnitureplan.blocks.func.ISimpleBlock;
import nowebsite.maker.furnitureplan.blocks.tableware.blockentities.GlassBBlockEntity;
import nowebsite.maker.furnitureplan.items.GlassBBlockItem;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.awt.*;
import java.util.List;

public class GlassBBlock extends HalfTransparentBlock implements SimpleWaterloggedBlock, EntityBlock, ISimpleBlock {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
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
        this.registerDefaultState(this.getStateDefinition().any().setValue(WATERLOGGED, Boolean.FALSE));
    }
    @Override
    protected @NotNull ItemInteractionResult useItemOn(@NotNull ItemStack stack, @NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hitResult) {
        if (!level.isClientSide) {
            if (!(level.getBlockEntity(pos) instanceof GlassBBlockEntity cast)) {
                throw new IllegalStateException("GlassB block entity at x: " + pos.getX() + ", y: " + pos.getY() + ", z: " + pos.getZ() + " could not be found.");
            }
            if (cast.getPotionStack().isEmpty() && stack.getItem() instanceof PotionItem) {
                if (cast.fillPotion(player, player.getAbilities().instabuild ? stack.copy() : stack)) return ItemInteractionResult.CONSUME;
            } else if (stack.is(Items.GLASS_BOTTLE)) {
                if (cast.restorePotion(player, player.getAbilities().instabuild ? stack.copy() : stack)) return ItemInteractionResult.CONSUME;
            }
        }
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }
    @Override
    protected @NotNull InteractionResult useWithoutItem(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull BlockHitResult hitResult) {
        if (!level.isClientSide) {
            if (!(level.getBlockEntity(pos) instanceof GlassBBlockEntity cast)) {
                throw new IllegalStateException("GlassB block entity at x: " + pos.getX() + ", y: " + pos.getY() + ", z: " + pos.getZ() + " could not be found.");
            }
            if (!cast.usePotion(player)) return InteractionResult.PASS;
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
    protected @NotNull FluidState getFluidState(@NotNull BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED);
    }
    @Override
    public boolean canSurvive(@NotNull BlockState state, @NotNull LevelReader level, @NotNull BlockPos pos) {
        return BaseSmallHallBasedBlock.needsDownsideSupport(level,pos);
    }

    @Override
    protected void onRemove(@NotNull BlockState state, Level level, @NotNull BlockPos pos, @NotNull BlockState newState, boolean movedByPiston) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (!(newState.getBlock() instanceof GlassBBlock) && blockEntity instanceof GlassBBlockEntity cast){
            cast.dropBottle();
        }
        super.onRemove(state, level, pos, newState, movedByPiston);
    }

    @Override
    public BlockState getStateForPlacement(@NotNull BlockPlaceContext context) {
        BlockState blockState = super.getStateForPlacement(context);
        return
            blockState == null ?
                defaultBlockState().setValue(WATERLOGGED, context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER)
                :
                blockState.setValue(WATERLOGGED, context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER);
    }
    @Override
    protected @NotNull BlockState updateShape(@NotNull BlockState state, @NotNull Direction direction, @NotNull BlockState neighborState, @NotNull LevelAccessor level, @NotNull BlockPos pos, @NotNull BlockPos neighborPos) {
        if (direction == Direction.DOWN && !this.canSurvive(state, level, pos)) return Blocks.AIR.defaultBlockState();
        if (state.getValue(WATERLOGGED)) level.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        return super.updateShape(state, direction, neighborState, level, pos, neighborPos);
    }
    @Override
    public void appendHoverText(@NotNull ItemStack stack, Item.@NotNull TooltipContext context, @NotNull List<Component> tootipComponents, @NotNull TooltipFlag tooltipFlag) {
        ItemStackHandler handler = new ItemStackHandler(2);
        GlassBBlockItem.loadFromEntityData(context.registries(), stack, handler);
        ItemStack potionStack = handler.getStackInSlot(1);
        PotionContents potioncontents = potionStack.getOrDefault(DataComponents.POTION_CONTENTS, PotionContents.EMPTY);
        if (potioncontents.potion().isPresent()) {
            tootipComponents.add(
                    Component.translatable("item.minecraft.potion")
                            .append(":  ")
                            .withColor(Color.GRAY.getRGB())
                            .append(Component.translatable(potionStack.getDescriptionId()))
                            .withColor(potioncontents.getColor())
            );
        }
        super.appendHoverText(stack, context, tootipComponents, tooltipFlag);
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
