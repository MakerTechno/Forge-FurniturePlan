package nowebsite.maker.furnitureplan.blocks.tableware;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import nowebsite.maker.furnitureplan.blocks.tableware.blockentities.FoodPlateBlockEntity;
import nowebsite.maker.furnitureplan.registry.BlockRegistration;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("deprecation")
public class FoodPlateBlock extends HorizontalDirectionalBlock implements EntityBlock, SimpleWaterloggedBlock {
    public FoodPlateBlock(Properties properties) {super(properties);}
    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return new FoodPlateBlockEntity(pos, state);
    }
    private static VoxelShape SHAPE = Shapes.empty();
    static {
        SHAPE = Shapes.join(SHAPE, Shapes.box(0.3125, 0, 0.3125, 0.6875, 0.03125, 0.6875), BooleanOp.OR);
        SHAPE = Shapes.join(SHAPE, Shapes.box(0.375, 0, 0.6875, 0.625, 0.03125, 0.75), BooleanOp.OR);
        SHAPE = Shapes.join(SHAPE, Shapes.box(0.6875, 0.03125, 0.625, 0.75, 0.0625, 0.6875), BooleanOp.OR);
        SHAPE = Shapes.join(SHAPE, Shapes.box(0.6875, 0.03125, 0.3125, 0.75, 0.0625, 0.375), BooleanOp.OR);
        SHAPE = Shapes.join(SHAPE, Shapes.box(0.25, 0, 0.375, 0.3125, 0.03125, 0.625), BooleanOp.OR);
        SHAPE = Shapes.join(SHAPE, Shapes.box(0.6875, 0, 0.375, 0.75, 0.03125, 0.625), BooleanOp.OR);
        SHAPE = Shapes.join(SHAPE, Shapes.box(0.75, 0.03125, 0.375, 0.8125, 0.0625, 0.625), BooleanOp.OR);
        SHAPE = Shapes.join(SHAPE, Shapes.box(0.1875, 0.03125, 0.375, 0.25, 0.0625, 0.625), BooleanOp.OR);
        SHAPE = Shapes.join(SHAPE, Shapes.box(0.25, 0.03125, 0.3125, 0.3125, 0.0625, 0.375), BooleanOp.OR);
        SHAPE = Shapes.join(SHAPE, Shapes.box(0.3125, 0.03125, 0.6875, 0.375, 0.0625, 0.75), BooleanOp.OR);
        SHAPE = Shapes.join(SHAPE, Shapes.box(0.25, 0.03125, 0.625, 0.3125, 0.0625, 0.6875), BooleanOp.OR);
        SHAPE = Shapes.join(SHAPE, Shapes.box(0.625, 0.03125, 0.25, 0.6875, 0.0625, 0.3125), BooleanOp.OR);
        SHAPE = Shapes.join(SHAPE, Shapes.box(0.3125, 0.03125, 0.25, 0.375, 0.0625, 0.3125), BooleanOp.OR);
        SHAPE = Shapes.join(SHAPE, Shapes.box(0.625, 0.03125, 0.6875, 0.6875, 0.0625, 0.75), BooleanOp.OR);
        SHAPE = Shapes.join(SHAPE, Shapes.box(0.375, 0, 0.25, 0.625, 0.03125, 0.3125), BooleanOp.OR);
        SHAPE = Shapes.join(SHAPE, Shapes.box(0.375, 0.03125, 0.1875, 0.625, 0.0625, 0.25), BooleanOp.OR);
        SHAPE = Shapes.join(SHAPE, Shapes.box(0.375, 0.03125, 0.75, 0.625, 0.0625, 0.8125), BooleanOp.OR);
    }
    @Override
    public @NotNull RenderShape getRenderShape(@NotNull BlockState state) {
        return RenderShape.MODEL;
    }
    @Override
    public void onRemove(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState newState, boolean movedByPiston) {
        if (state.getBlock() != newState.getBlock()){
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof FoodPlateBlockEntity cast) {
                cast.drops();
            }
        }
        super.onRemove(state, level, pos, newState, movedByPiston);
    }
    @Override
    public @NotNull InteractionResult use(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hitResult) {
        if (!level.isClientSide) {
            if (!(level.getBlockEntity(pos) instanceof FoodPlateBlockEntity cast)) {
                throw new IllegalStateException("Food plate block entity at x: " + pos.getX() + ", y: " + pos.getY() + ", z: " + pos.getZ() + " could not be found.");
            }
            ItemStack stack = player.getItemInHand(hand);
            if (stack.is(BlockRegistration.CUTLERY_ITEM.get())){
                BlockState newState = BlockRegistration.FOOD_PLATE_AND_CUTLERY_BLOCK.get().defaultBlockState().setValue(FoodPlateAndCutleryBlock.FACING, state.getValue(FACING));
                level.setBlock(pos, newState, 3);
                if (!player.getAbilities().instabuild)stack.shrink(1);
            } else if (stack.is(BlockRegistration.GLASS_B_BLOCK_ITEM.get())){
                BlockState newState = BlockRegistration.FOOD_PLATE_AND_GLASS_BLOCK.get().defaultBlockState().setValue(FoodPlateAndGlassBlock.FACING, state.getValue(FACING));
                level.setBlockAndUpdate(pos, newState);
                level.sendBlockUpdated(pos, state, newState, 2);
                if (!player.getAbilities().instabuild)stack.shrink(1);
            } else if (stack.getFoodProperties(player) != null && cast.getFoodStack().isEmpty()) {
                if (!cast.placeFood(player, player.getAbilities().instabuild ? stack.copy() : stack)) return InteractionResult.PASS;
            } else if (!cast.getFoodStack().isEmpty()) cast.drops();
        }
        return InteractionResult.SUCCESS;
    }
    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return this.getOcclusionShape(state, getter, pos);
    }
    @Override
    public BlockState getStateForPlacement(@NotNull BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
    @Override
    public @NotNull VoxelShape getOcclusionShape(@NotNull BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos pos) {
        return SHAPE;
    }
}
