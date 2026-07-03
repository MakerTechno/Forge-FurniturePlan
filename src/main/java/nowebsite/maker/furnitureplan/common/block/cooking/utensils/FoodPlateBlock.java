package nowebsite.maker.furnitureplan.common.block.cooking.utensils;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.PotionItem;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import nowebsite.maker.furnitureplan.common.block.abstraction.definition.PlateShape;
import nowebsite.maker.furnitureplan.common.block.cooking.utensils.entities.FoodPlateBlockEntity;
import nowebsite.maker.furnitureplan.common.block.cooking.utensils.entities.GlassBBlockEntity;
import nowebsite.maker.furnitureplan.common.init.FPBlockReg;
import nowebsite.maker.furnitureplan.common.item.GlassBBlockItem;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class FoodPlateBlock extends HorizontalDirectionalBlock implements EntityBlock, SimpleWaterloggedBlock {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final EnumProperty<@NotNull PlateShape> SHAPE_DEF = FPBlockReg.BlockStateReg.PLATE_SHAPE;
    public FoodPlateBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(WATERLOGGED, Boolean.FALSE).setValue(SHAPE_DEF, PlateShape.PLATE_SHAPE));
    }

    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return simpleCodec(FoodPlateBlock::new);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new FoodPlateBlockEntity(pos, state);
    }

    @Override
    protected boolean shouldChangedStateKeepBlockEntity(BlockState oldState) {
        return true;
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }
    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (level.isClientSide()) return InteractionResult.CONSUME;
        if (!(level.getBlockEntity(pos) instanceof FoodPlateBlockEntity cast)) {
            throw new IllegalStateException("Food plate block entity at x: " + pos.getX() + ", y: " + pos.getY() + ", z: " + pos.getZ() + " could not be found.");
        }

        PlateShape shape = state.getValue(SHAPE_DEF);
        boolean hasCutlery = shape.hasCutlery(), hasGlass = shape.hasGlass();

        /* This part, we try to remove something like glass bottle out of this block. */
        if (player.isShiftKeyDown()) {
            SimpleContainer popInventory = new SimpleContainer(1);
            ItemStack resultStack = ItemStack.EMPTY;
            BlockState newState = null;

            if (canSurvive(state, level, pos)) {
                switch (shape) {
                    case PLATE_AND_GLASS_SHAPE -> cast.dropBottle();
                    case PLATE_AND_CUTLERY_SHAPE, PLATE_AND_GLASS_AND_CUTLERY_SHAPE -> resultStack = new ItemStack(FPBlockReg.CUTLERY_ITEM.get(), 1);
                    case PLATE_SHAPE -> {
                        resultStack = new ItemStack(FPBlockReg.FOOD_PLATE_BLOCK_ITEM.get(), 1);
                        cast.popFood();
                    }
                }

                if (shape.getNext() != null) newState = state.setValue(SHAPE_DEF, shape.getNext());
                // else, it should be the remove of plate, so we needn't operate anymore.

            } else { // if it can't survive, this means it's in an unstable place, we should drop it all.
                if (hasCutlery) resultStack = new ItemStack(FPBlockReg.CUTLERY_ITEM.get(), 1);
                cast.popFood();
                cast.dropBottle();
            }
            // final output.
            popInventory.setItem(0, resultStack);
            Containers.dropContents(level, pos, popInventory);
            level.setBlock(pos, newState == null ? Blocks.AIR.defaultBlockState() : newState, 2);
        }

        /* This part, we try to interact with the food placed in the block(entity). */
        else if (hasCutlery && !cast.getFoodStack().isEmpty() && player.getFoodData().needsFood()) {
            Consumable consumable = cast.getFoodStack().get(DataComponents.CONSUMABLE);
            if (consumable != null) {
                consumable.onConsume(level, player, cast.getFoodStack());
                cast.changeFood(new ItemStack(Items.AIR));
                player.getFoodData().setSaturation(player.getFoodData().getSaturationLevel() + 1);
            }
        }
        /* This part, we try to interact with the drink placed in the block(entity). */
        else if (hasGlass && !cast.usePotion(player)) return InteractionResult.FAIL;

        else if (cast.getFoodStack().isEmpty())return InteractionResult.FAIL;
        else cast.popFood();

        return InteractionResult.SUCCESS_SERVER;
    }

    @Override
    protected InteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (level.isClientSide()) return InteractionResult.CONSUME;
        if (!(level.getBlockEntity(pos) instanceof FoodPlateBlockEntity cast)) {
            throw new IllegalStateException("Food plate block entity at x: " + pos.getX() + ", y: " + pos.getY() + ", z: " + pos.getZ() + " could not be found.");
        }
        PlateShape shape = state.getValue(SHAPE_DEF);
        boolean hasCutlery = shape.hasCutlery(), hasGlass = shape.hasGlass();

        if (stack.is(FPBlockReg.CUTLERY_ITEM.get())) {
            if (hasCutlery) return InteractionResult.TRY_WITH_EMPTY_HAND;

            BlockState newState = FPBlockReg.FOOD_PLATE_BLOCK.get().defaultBlockState().setValue(FACING, state.getValue(FACING)).setValue(SHAPE_DEF, shape.addCutlery());
            level.setBlockAndUpdate(pos, newState);
            if (!player.getAbilities().instabuild && !newState.getValue(SHAPE_DEF).equals(shape)) stack.shrink(1);
            // To end success.

        } else if (stack.is(FPBlockReg.GLASS_B_BLOCK_ITEM.get())) {
            if (hasGlass) return InteractionResult.TRY_WITH_EMPTY_HAND;

            BlockState newState = FPBlockReg.FOOD_PLATE_BLOCK.get().defaultBlockState().setValue(FACING, state.getValue(FACING)).setValue(SHAPE_DEF, shape.addGlass());
            level.setBlockAndUpdate(pos, newState);
            if (!player.getAbilities().instabuild && !newState.getValue(SHAPE_DEF).equals(shape)) stack.shrink(1);
            GlassBBlockEntity glassBBlockEntity = new GlassBBlockEntity(BlockPos.ZERO, FPBlockReg.GLASS_B_BLOCK.get().defaultBlockState());
            GlassBBlockItem.readItemContentsFromData(level, stack, glassBBlockEntity);
            cast.changePotion(glassBBlockEntity.getPotionStack());
            // To end success.

        } else if (stack.get(DataComponents.FOOD) != null && cast.getFoodStack().isEmpty()) {
            if (!cast.placeFood(player, player.getAbilities().instabuild ? stack.copy() : stack))
                return InteractionResult.TRY_WITH_EMPTY_HAND;
            // To end success.

        } else if (hasGlass && cast.getPotionStack().isEmpty() && stack.getItem() instanceof PotionItem) {
            if (!cast.fillPotion(player, player.getAbilities().instabuild ? stack.copy() : stack))
                return InteractionResult.FAIL;
            // To end success.

        } else if (hasGlass && cast.restorePotion(player, player.getAbilities().instabuild ? stack.copy() : stack))
            return InteractionResult.SUCCESS_SERVER;
        else return InteractionResult.TRY_WITH_EMPTY_HAND;

        return InteractionResult.SUCCESS_SERVER;
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        return canSupportCenter(level, pos.below(), Direction.UP);
    }
    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        return state.getValue(SHAPE_DEF).getOccModel(state);
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, @NotNull BlockState> builder) {
        builder.add(FACING, SHAPE_DEF, WATERLOGGED);
    }
    @Override
    protected FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState blockState = super.getStateForPlacement(context);
        blockState =
            blockState == null ?
                defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite()).setValue(SHAPE_DEF, PlateShape.PLATE_SHAPE)
                :
                blockState.setValue(FACING, context.getHorizontalDirection().getOpposite()).setValue(SHAPE_DEF, PlateShape.PLATE_SHAPE);
        return blockState.setValue(WATERLOGGED, context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER);
    }

    @Override
    protected BlockState updateShape(BlockState state, LevelReader level, ScheduledTickAccess ticks, BlockPos pos, Direction directionToNeighbour, BlockPos neighbourPos, BlockState neighbourState, RandomSource random) {
        if (directionToNeighbour == Direction.DOWN && !this.canSurvive(state, level, pos)) return Blocks.AIR.defaultBlockState();
        if (state.getValue(WATERLOGGED)) ticks.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        return super.updateShape(state, level, ticks, pos, directionToNeighbour, neighbourPos, neighbourState, random);
    }

    @Override
    protected boolean isPathfindable(BlockState state, PathComputationType pathComputationType) {
        return true;
    }
}
