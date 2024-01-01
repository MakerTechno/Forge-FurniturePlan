package nowebsite.maker.furnitureplan.blocks.tableware;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PotionItem;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import nowebsite.maker.furnitureplan.blocks.tableware.blockentities.FoodPlateAndGlassBlockEntity;
import nowebsite.maker.furnitureplan.registry.BlockRegistration;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

@SuppressWarnings("deprecation")
public class FoodPlateAndGlassBlock extends HorizontalDirectionalBlock implements EntityBlock, SimpleWaterloggedBlock {
    public FoodPlateAndGlassBlock(Properties properties) {super(properties);}
    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return new FoodPlateAndGlassBlockEntity(pos, state);
    }
    private static VoxelShape SHAPE_N = Shapes.empty();
    private static VoxelShape SHAPE_E = Shapes.empty();
    private static VoxelShape SHAPE_S = Shapes.empty();
    private static VoxelShape SHAPE_W = Shapes.empty();
    static {
        SHAPE_N = Shapes.join(SHAPE_N, Shapes.box(0.3125, 0, 0.3125, 0.6875, 0.03125, 0.6875), BooleanOp.OR);
        SHAPE_N = Shapes.join(SHAPE_N, Shapes.box(0.375, 0, 0.6875, 0.625, 0.03125, 0.75), BooleanOp.OR);
        SHAPE_N = Shapes.join(SHAPE_N, Shapes.box(0.6875, 0.03125, 0.625, 0.75, 0.0625, 0.6875), BooleanOp.OR);
        SHAPE_N = Shapes.join(SHAPE_N, Shapes.box(0.6875, 0.03125, 0.3125, 0.75, 0.0625, 0.375), BooleanOp.OR);
        SHAPE_N = Shapes.join(SHAPE_N, Shapes.box(0.25, 0, 0.375, 0.3125, 0.03125, 0.625), BooleanOp.OR);
        SHAPE_N = Shapes.join(SHAPE_N, Shapes.box(0.6875, 0, 0.375, 0.75, 0.03125, 0.625), BooleanOp.OR);
        SHAPE_N = Shapes.join(SHAPE_N, Shapes.box(0.75, 0.03125, 0.375, 0.8125, 0.0625, 0.625), BooleanOp.OR);
        SHAPE_N = Shapes.join(SHAPE_N, Shapes.box(0.1875, 0.03125, 0.375, 0.25, 0.0625, 0.625), BooleanOp.OR);
        SHAPE_N = Shapes.join(SHAPE_N, Shapes.box(0.25, 0.03125, 0.3125, 0.3125, 0.0625, 0.375), BooleanOp.OR);
        SHAPE_N = Shapes.join(SHAPE_N, Shapes.box(0.3125, 0.03125, 0.6875, 0.375, 0.0625, 0.75), BooleanOp.OR);
        SHAPE_N = Shapes.join(SHAPE_N, Shapes.box(0.25, 0.03125, 0.625, 0.3125, 0.0625, 0.6875), BooleanOp.OR);
        SHAPE_N = Shapes.join(SHAPE_N, Shapes.box(0.625, 0.03125, 0.25, 0.6875, 0.0625, 0.3125), BooleanOp.OR);
        SHAPE_N = Shapes.join(SHAPE_N, Shapes.box(0.3125, 0.03125, 0.25, 0.375, 0.0625, 0.3125), BooleanOp.OR);
        SHAPE_N = Shapes.join(SHAPE_N, Shapes.box(0.625, 0.03125, 0.6875, 0.6875, 0.0625, 0.75), BooleanOp.OR);
        SHAPE_N = Shapes.join(SHAPE_N, Shapes.box(0.375, 0, 0.25, 0.625, 0.03125, 0.3125), BooleanOp.OR);
        SHAPE_N = Shapes.join(SHAPE_N, Shapes.box(0.375, 0.03125, 0.1875, 0.625, 0.0625, 0.25), BooleanOp.OR);
        SHAPE_N = Shapes.join(SHAPE_N, Shapes.box(0.375, 0.03125, 0.75, 0.625, 0.0625, 0.8125), BooleanOp.OR);
        SHAPE_N = Shapes.join(SHAPE_N, Shapes.box(0.9375, 0, 0.75, 0.96875, 0.375, 0.9375), BooleanOp.OR);
        SHAPE_N = Shapes.join(SHAPE_N, Shapes.box(0.78125, 0, 0.71875, 0.96875, 0.375, 0.75), BooleanOp.OR);
        SHAPE_N = Shapes.join(SHAPE_N, Shapes.box(0.75, 0, 0.90625, 0.9375, 0.375, 0.9375), BooleanOp.OR);
        SHAPE_N = Shapes.join(SHAPE_N, Shapes.box(0.75, 0, 0.71875, 0.78125, 0.375, 0.90625), BooleanOp.OR);
        SHAPE_N = Shapes.join(SHAPE_N, Shapes.box(0.78125, 0, 0.75, 0.9375, 0.0001, 0.90625), BooleanOp.OR);

        SHAPE_E = Shapes.join(SHAPE_E, Shapes.box(0.3125, 0, 0.3125, 0.6875, 0.03125, 0.6875), BooleanOp.OR);
        SHAPE_E = Shapes.join(SHAPE_E, Shapes.box(0.25, 0, 0.375, 0.3125, 0.03125, 0.625), BooleanOp.OR);
        SHAPE_E = Shapes.join(SHAPE_E, Shapes.box(0.3125, 0.03125, 0.6875, 0.375, 0.0625, 0.75), BooleanOp.OR);
        SHAPE_E = Shapes.join(SHAPE_E, Shapes.box(0.625, 0.03125, 0.6875, 0.6875, 0.0625, 0.75), BooleanOp.OR);
        SHAPE_E = Shapes.join(SHAPE_E, Shapes.box(0.375, 0, 0.25, 0.625, 0.03125, 0.3125), BooleanOp.OR);
        SHAPE_E = Shapes.join(SHAPE_E, Shapes.box(0.375, 0, 0.6875, 0.625, 0.03125, 0.75), BooleanOp.OR);
        SHAPE_E = Shapes.join(SHAPE_E, Shapes.box(0.375, 0.03125, 0.75, 0.625, 0.0625, 0.8125), BooleanOp.OR);
        SHAPE_E = Shapes.join(SHAPE_E, Shapes.box(0.375, 0.03125, 0.1875, 0.625, 0.0625, 0.25), BooleanOp.OR);
        SHAPE_E = Shapes.join(SHAPE_E, Shapes.box(0.625, 0.03125, 0.25, 0.6875, 0.0625, 0.3125), BooleanOp.OR);
        SHAPE_E = Shapes.join(SHAPE_E, Shapes.box(0.25, 0.03125, 0.3125, 0.3125, 0.0625, 0.375), BooleanOp.OR);
        SHAPE_E = Shapes.join(SHAPE_E, Shapes.box(0.3125, 0.03125, 0.25, 0.375, 0.0625, 0.3125), BooleanOp.OR);
        SHAPE_E = Shapes.join(SHAPE_E, Shapes.box(0.6875, 0.03125, 0.625, 0.75, 0.0625, 0.6875), BooleanOp.OR);
        SHAPE_E = Shapes.join(SHAPE_E, Shapes.box(0.6875, 0.03125, 0.3125, 0.75, 0.0625, 0.375), BooleanOp.OR);
        SHAPE_E = Shapes.join(SHAPE_E, Shapes.box(0.25, 0.03125, 0.625, 0.3125, 0.0625, 0.6875), BooleanOp.OR);
        SHAPE_E = Shapes.join(SHAPE_E, Shapes.box(0.6875, 0, 0.375, 0.75, 0.03125, 0.625), BooleanOp.OR);
        SHAPE_E = Shapes.join(SHAPE_E, Shapes.box(0.75, 0.03125, 0.375, 0.8125, 0.0625, 0.625), BooleanOp.OR);
        SHAPE_E = Shapes.join(SHAPE_E, Shapes.box(0.1875, 0.03125, 0.375, 0.25, 0.0625, 0.625), BooleanOp.OR);
        SHAPE_E = Shapes.join(SHAPE_E, Shapes.box(0.0625, 0, 0.9375, 0.25, 0.375, 0.96875), BooleanOp.OR);
        SHAPE_E = Shapes.join(SHAPE_E, Shapes.box(0.25, 0, 0.78125, 0.28125, 0.375, 0.96875), BooleanOp.OR);
        SHAPE_E = Shapes.join(SHAPE_E, Shapes.box(0.0625, 0, 0.75, 0.09375, 0.375, 0.9375), BooleanOp.OR);
        SHAPE_E = Shapes.join(SHAPE_E, Shapes.box(0.09375, 0, 0.75, 0.28125, 0.375, 0.78125), BooleanOp.OR);
        SHAPE_E = Shapes.join(SHAPE_E, Shapes.box(0.09375, 0, 0.78125, 0.25, 0.0001, 0.9375), BooleanOp.OR);

        SHAPE_S = Shapes.join(SHAPE_S, Shapes.box(0.3125, 0, 0.3125, 0.6875, 0.03125, 0.6875), BooleanOp.OR);
        SHAPE_S = Shapes.join(SHAPE_S, Shapes.box(0.375, 0, 0.25, 0.625, 0.03125, 0.3125), BooleanOp.OR);
        SHAPE_S = Shapes.join(SHAPE_S, Shapes.box(0.25, 0.03125, 0.3125, 0.3125, 0.0625, 0.375), BooleanOp.OR);
        SHAPE_S = Shapes.join(SHAPE_S, Shapes.box(0.25, 0.03125, 0.625, 0.3125, 0.0625, 0.6875), BooleanOp.OR);
        SHAPE_S = Shapes.join(SHAPE_S, Shapes.box(0.6875, 0, 0.375, 0.75, 0.03125, 0.625), BooleanOp.OR);
        SHAPE_S = Shapes.join(SHAPE_S, Shapes.box(0.25, 0, 0.375, 0.3125, 0.03125, 0.625), BooleanOp.OR);
        SHAPE_S = Shapes.join(SHAPE_S, Shapes.box(0.1875, 0.03125, 0.375, 0.25, 0.0625, 0.625), BooleanOp.OR);
        SHAPE_S = Shapes.join(SHAPE_S, Shapes.box(0.75, 0.03125, 0.375, 0.8125, 0.0625, 0.625), BooleanOp.OR);
        SHAPE_S = Shapes.join(SHAPE_S, Shapes.box(0.6875, 0.03125, 0.625, 0.75, 0.0625, 0.6875), BooleanOp.OR);
        SHAPE_S = Shapes.join(SHAPE_S, Shapes.box(0.625, 0.03125, 0.25, 0.6875, 0.0625, 0.3125), BooleanOp.OR);
        SHAPE_S = Shapes.join(SHAPE_S, Shapes.box(0.6875, 0.03125, 0.3125, 0.75, 0.0625, 0.375), BooleanOp.OR);
        SHAPE_S = Shapes.join(SHAPE_S, Shapes.box(0.3125, 0.03125, 0.6875, 0.375, 0.0625, 0.75), BooleanOp.OR);
        SHAPE_S = Shapes.join(SHAPE_S, Shapes.box(0.625, 0.03125, 0.6875, 0.6875, 0.0625, 0.75), BooleanOp.OR);
        SHAPE_S = Shapes.join(SHAPE_S, Shapes.box(0.3125, 0.03125, 0.25, 0.375, 0.0625, 0.3125), BooleanOp.OR);
        SHAPE_S = Shapes.join(SHAPE_S, Shapes.box(0.375, 0, 0.6875, 0.625, 0.03125, 0.75), BooleanOp.OR);
        SHAPE_S = Shapes.join(SHAPE_S, Shapes.box(0.375, 0.03125, 0.75, 0.625, 0.0625, 0.8125), BooleanOp.OR);
        SHAPE_S = Shapes.join(SHAPE_S, Shapes.box(0.375, 0.03125, 0.1875, 0.625, 0.0625, 0.25), BooleanOp.OR);
        SHAPE_S = Shapes.join(SHAPE_S, Shapes.box(0.03125, 0, 0.0625, 0.0625, 0.375, 0.25), BooleanOp.OR);
        SHAPE_S = Shapes.join(SHAPE_S, Shapes.box(0.03125, 0, 0.25, 0.21875, 0.375, 0.28125), BooleanOp.OR);
        SHAPE_S = Shapes.join(SHAPE_S, Shapes.box(0.0625, 0, 0.0625, 0.25, 0.375, 0.09375), BooleanOp.OR);
        SHAPE_S = Shapes.join(SHAPE_S, Shapes.box(0.21875, 0, 0.09375, 0.25, 0.375, 0.28125), BooleanOp.OR);
        SHAPE_S = Shapes.join(SHAPE_S, Shapes.box(0.0625, 0, 0.09375, 0.21875, 0.0001, 0.25), BooleanOp.OR);

        SHAPE_W = Shapes.join(SHAPE_W, Shapes.box(0.3125, 0, 0.3125, 0.6875, 0.03125, 0.6875), BooleanOp.OR);
        SHAPE_W = Shapes.join(SHAPE_W, Shapes.box(0.6875, 0, 0.375, 0.75, 0.03125, 0.625), BooleanOp.OR);
        SHAPE_W = Shapes.join(SHAPE_W, Shapes.box(0.625, 0.03125, 0.25, 0.6875, 0.0625, 0.3125), BooleanOp.OR);
        SHAPE_W = Shapes.join(SHAPE_W, Shapes.box(0.3125, 0.03125, 0.25, 0.375, 0.0625, 0.3125), BooleanOp.OR);
        SHAPE_W = Shapes.join(SHAPE_W, Shapes.box(0.375, 0, 0.6875, 0.625, 0.03125, 0.75), BooleanOp.OR);
        SHAPE_W = Shapes.join(SHAPE_W, Shapes.box(0.375, 0, 0.25, 0.625, 0.03125, 0.3125), BooleanOp.OR);
        SHAPE_W = Shapes.join(SHAPE_W, Shapes.box(0.375, 0.03125, 0.1875, 0.625, 0.0625, 0.25), BooleanOp.OR);
        SHAPE_W = Shapes.join(SHAPE_W, Shapes.box(0.375, 0.03125, 0.75, 0.625, 0.0625, 0.8125), BooleanOp.OR);
        SHAPE_W = Shapes.join(SHAPE_W, Shapes.box(0.3125, 0.03125, 0.6875, 0.375, 0.0625, 0.75), BooleanOp.OR);
        SHAPE_W = Shapes.join(SHAPE_W, Shapes.box(0.6875, 0.03125, 0.625, 0.75, 0.0625, 0.6875), BooleanOp.OR);
        SHAPE_W = Shapes.join(SHAPE_W, Shapes.box(0.625, 0.03125, 0.6875, 0.6875, 0.0625, 0.75), BooleanOp.OR);
        SHAPE_W = Shapes.join(SHAPE_W, Shapes.box(0.25, 0.03125, 0.3125, 0.3125, 0.0625, 0.375), BooleanOp.OR);
        SHAPE_W = Shapes.join(SHAPE_W, Shapes.box(0.25, 0.03125, 0.625, 0.3125, 0.0625, 0.6875), BooleanOp.OR);
        SHAPE_W = Shapes.join(SHAPE_W, Shapes.box(0.6875, 0.03125, 0.3125, 0.75, 0.0625, 0.375), BooleanOp.OR);
        SHAPE_W = Shapes.join(SHAPE_W, Shapes.box(0.25, 0, 0.375, 0.3125, 0.03125, 0.625), BooleanOp.OR);
        SHAPE_W = Shapes.join(SHAPE_W, Shapes.box(0.1875, 0.03125, 0.375, 0.25, 0.0625, 0.625), BooleanOp.OR);
        SHAPE_W = Shapes.join(SHAPE_W, Shapes.box(0.75, 0.03125, 0.375, 0.8125, 0.0625, 0.625), BooleanOp.OR);
        SHAPE_W = Shapes.join(SHAPE_W, Shapes.box(0.75, 0, 0.03125, 0.9375, 0.375, 0.0625), BooleanOp.OR);
        SHAPE_W = Shapes.join(SHAPE_W, Shapes.box(0.71875, 0, 0.03125, 0.75, 0.375, 0.21875), BooleanOp.OR);
        SHAPE_W = Shapes.join(SHAPE_W, Shapes.box(0.90625, 0, 0.0625, 0.9375, 0.375, 0.25), BooleanOp.OR);
        SHAPE_W = Shapes.join(SHAPE_W, Shapes.box(0.71875, 0, 0.21875, 0.90625, 0.375, 0.25), BooleanOp.OR);
        SHAPE_W = Shapes.join(SHAPE_W, Shapes.box(0.75, 0, 0.0625, 0.90625, 0.0001, 0.21875), BooleanOp.OR);
    }
    @Override
    public @NotNull RenderShape getRenderShape(@NotNull BlockState state) {
        return RenderShape.MODEL;
    }
    @Override
    public void onRemove(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState newState, boolean movedByPiston) {
        if (state.getBlock() != newState.getBlock() && level.getBlockEntity(pos) instanceof FoodPlateAndGlassBlockEntity cast) cast.drops();
        super.onRemove(state, level, pos, newState, movedByPiston);
    }
    @Override
    public @NotNull InteractionResult use(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hitResult) {
        if (!level.isClientSide) {
            if (!(level.getBlockEntity(pos) instanceof FoodPlateAndGlassBlockEntity cast)) {
                System.out.println(level.getBlockEntity(pos));
                throw new IllegalStateException("Food plate and glass block entity at x: " + pos.getX() + ", y: " + pos.getY() + ", z: " + pos.getZ() + " could not be found.");
            }
            ItemStack stack = player.getItemInHand(hand);
            if (stack.is(BlockRegistration.CUTLERY_ITEM.get())){
                BlockState newState = BlockRegistration.FOOD_PLATE_AND_GLASS_AND_CUTLERY_BLOCK.get().defaultBlockState().setValue(FoodPlateAndGlassAndCutleryBlock.FACING, state.getValue(FoodPlateAndGlassAndCutleryBlock.FACING));
                level.setBlock(pos, newState, 3);
                if (!player.getAbilities().instabuild)stack.shrink(1);
            } else if (stack.getFoodProperties(player) != null && cast.getFoodStack().isEmpty()) {
                if (!cast.placeFood(player, player.getAbilities().instabuild ? stack.copy() : stack)) return InteractionResult.PASS;
            } else if (cast.getPotionStack().isEmpty() && stack.getItem() instanceof PotionItem){
                if (!cast.fillPotion(player, player.getAbilities().instabuild ? stack.copy() : stack)) return InteractionResult.PASS;
            }
            else if (cast.restorePotion(player, player.getAbilities().instabuild ? stack.copy() : stack)) return InteractionResult.SUCCESS;
            else if (!cast.getFoodStack().isEmpty()) cast.drops();
            else if (!cast.usePotion(player)) return InteractionResult.PASS;
        }
        return InteractionResult.SUCCESS;
    }
    @Override
    public void playerDestroy(@NotNull Level level, @NotNull Player player, @NotNull BlockPos pos, @NotNull BlockState state, @Nullable BlockEntity blockEntity, @NotNull ItemStack tool) {
        super.playerDestroy(level, player, pos, state, blockEntity, tool);
        if (!level.isClientSide) level.setBlockAndUpdate(pos, BlockRegistration.FOOD_PLATE_BLOCK.get().defaultBlockState().setValue(FoodPlateBlock.FACING, state.getValue(FACING)));
    }

    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return this.getOcclusionShape(state, getter, pos);
    }
    @Override
    public BlockState getStateForPlacement(@NotNull BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }
    public Direction getDirection(LevelReader levelReader, BlockPos pos){
        return Objects.requireNonNull(levelReader.getBlockEntity(pos)).getBlockState().getValue(FoodPlateAndGlassAndCutleryBlock.FACING);
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
    @Override
    public @NotNull VoxelShape getOcclusionShape(@NotNull BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos pos) {
        return switch (state.getValue(FACING)) {
            case EAST -> SHAPE_E;
            case SOUTH -> SHAPE_S;
            case WEST -> SHAPE_W;
            default -> SHAPE_N;
        };
    }
}
