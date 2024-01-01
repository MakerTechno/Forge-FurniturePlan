package nowebsite.maker.furnitureplan.blocks.tableware;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
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
import nowebsite.maker.furnitureplan.blocks.tableware.blockentities.FoodPlateAndCutleryBlockEntity;
import nowebsite.maker.furnitureplan.registry.BlockRegistration;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("deprecation")
public class FoodPlateAndCutleryBlock extends HorizontalDirectionalBlock implements EntityBlock, SimpleWaterloggedBlock {
    public FoodPlateAndCutleryBlock(Properties properties) {super(properties);}
    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return new FoodPlateAndCutleryBlockEntity(pos, state);
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
        SHAPE_N = Shapes.join(SHAPE_N, Shapes.box(0.9375, 0, 0.4375, 0.9625, 0.00625, 0.5625), BooleanOp.OR);
        SHAPE_N = Shapes.join(SHAPE_N, Shapes.box(0.925, 0, 0.1875, 0.9625, 0.0125, 0.4375), BooleanOp.OR);
        SHAPE_N = Shapes.join(SHAPE_N, Shapes.box(0.8375, 0, 0.1875, 0.875, 0.0125, 0.45), BooleanOp.OR);
        SHAPE_N = Shapes.join(SHAPE_N, Shapes.box(0.8375, 0, 0.475, 0.84375, 0.00625, 0.5375), BooleanOp.OR);
        SHAPE_N = Shapes.join(SHAPE_N, Shapes.box(0.853125, 0, 0.475, 0.859375, 0.00625, 0.5375), BooleanOp.OR);
        SHAPE_N = Shapes.join(SHAPE_N, Shapes.box(0.86875, 0, 0.475, 0.875, 0.00625, 0.5375), BooleanOp.OR);
        SHAPE_N = Shapes.join(SHAPE_N, Shapes.box(0.8375, 0, 0.45, 0.875, 0.00625, 0.475), BooleanOp.OR);
        SHAPE_N = Shapes.join(SHAPE_N, Shapes.box(0.0625, 0, 0.1875, 0.1, 0.0125, 0.45), BooleanOp.OR);
        SHAPE_N = Shapes.join(SHAPE_N, Shapes.box(0.05, 0, 0.45, 0.1125, 0.00625, 0.5125), BooleanOp.OR);

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
        SHAPE_E = Shapes.join(SHAPE_E, Shapes.box(0.4375, 0, 0.9375, 0.5625, 0.00625, 0.9625), BooleanOp.OR);
        SHAPE_E = Shapes.join(SHAPE_E, Shapes.box(0.5625, 0, 0.925, 0.8125, 0.0125, 0.9625), BooleanOp.OR);
        SHAPE_E = Shapes.join(SHAPE_E, Shapes.box(0.55, 0, 0.8375, 0.8125, 0.0125, 0.875), BooleanOp.OR);
        SHAPE_E = Shapes.join(SHAPE_E, Shapes.box(0.4625, 0, 0.8375, 0.525, 0.00625, 0.84375), BooleanOp.OR);
        SHAPE_E = Shapes.join(SHAPE_E, Shapes.box(0.4625, 0, 0.853125, 0.525, 0.00625, 0.859375), BooleanOp.OR);
        SHAPE_E = Shapes.join(SHAPE_E, Shapes.box(0.4625, 0, 0.86875, 0.525, 0.00625, 0.875), BooleanOp.OR);
        SHAPE_E = Shapes.join(SHAPE_E, Shapes.box(0.525, 0, 0.8375, 0.55, 0.00625, 0.875), BooleanOp.OR);
        SHAPE_E = Shapes.join(SHAPE_E, Shapes.box(0.55, 0, 0.0625, 0.8125, 0.0125, 0.1), BooleanOp.OR);
        SHAPE_E = Shapes.join(SHAPE_E, Shapes.box(0.4875, 0, 0.05, 0.55, 0.00625, 0.1125), BooleanOp.OR);

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
        SHAPE_S = Shapes.join(SHAPE_S, Shapes.box(0.0375, 0, 0.4375, 0.0625, 0.00625, 0.5625), BooleanOp.OR);
        SHAPE_S = Shapes.join(SHAPE_S, Shapes.box(0.0375, 0, 0.5625, 0.075, 0.0125, 0.8125), BooleanOp.OR);
        SHAPE_S = Shapes.join(SHAPE_S, Shapes.box(0.125, 0, 0.55, 0.1625, 0.0125, 0.8125), BooleanOp.OR);
        SHAPE_S = Shapes.join(SHAPE_S, Shapes.box(0.15625, 0, 0.4625, 0.1625, 0.00625, 0.525), BooleanOp.OR);
        SHAPE_S = Shapes.join(SHAPE_S, Shapes.box(0.140625, 0, 0.4625, 0.146875, 0.00625, 0.525), BooleanOp.OR);
        SHAPE_S = Shapes.join(SHAPE_S, Shapes.box(0.125, 0, 0.4625, 0.13125, 0.00625, 0.525), BooleanOp.OR);
        SHAPE_S = Shapes.join(SHAPE_S, Shapes.box(0.125, 0, 0.525, 0.1625, 0.00625, 0.55), BooleanOp.OR);
        SHAPE_S = Shapes.join(SHAPE_S, Shapes.box(0.9, 0, 0.55, 0.9375, 0.0125, 0.8125), BooleanOp.OR);
        SHAPE_S = Shapes.join(SHAPE_S, Shapes.box(0.8875, 0, 0.4875, 0.95, 0.00625, 0.55), BooleanOp.OR);

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
        SHAPE_W = Shapes.join(SHAPE_W, Shapes.box(0.4375, 0, 0.0375, 0.5625, 0.00625, 0.0625), BooleanOp.OR);
        SHAPE_W = Shapes.join(SHAPE_W, Shapes.box(0.1875, 0, 0.0375, 0.4375, 0.0125, 0.075), BooleanOp.OR);
        SHAPE_W = Shapes.join(SHAPE_W, Shapes.box(0.1875, 0, 0.125, 0.45, 0.0125, 0.1625), BooleanOp.OR);
        SHAPE_W = Shapes.join(SHAPE_W, Shapes.box(0.475, 0, 0.15625, 0.5375, 0.00625, 0.1625), BooleanOp.OR);
        SHAPE_W = Shapes.join(SHAPE_W, Shapes.box(0.475, 0, 0.140625, 0.5375, 0.00625, 0.146875), BooleanOp.OR);
        SHAPE_W = Shapes.join(SHAPE_W, Shapes.box(0.475, 0, 0.125, 0.5375, 0.00625, 0.13125), BooleanOp.OR);
        SHAPE_W = Shapes.join(SHAPE_W, Shapes.box(0.45, 0, 0.125, 0.475, 0.00625, 0.1625), BooleanOp.OR);
        SHAPE_W = Shapes.join(SHAPE_W, Shapes.box(0.1875, 0, 0.9, 0.45, 0.0125, 0.9375), BooleanOp.OR);
        SHAPE_W = Shapes.join(SHAPE_W, Shapes.box(0.45, 0, 0.8875, 0.5125, 0.00625, 0.95), BooleanOp.OR);
    }
    @Override
    public @NotNull RenderShape getRenderShape(@NotNull BlockState state) {
        return RenderShape.MODEL;
    }
    @Override
    public void onRemove(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState newState, boolean movedByPiston) {
        if (state.getBlock() != newState.getBlock() && level.getBlockEntity(pos) instanceof FoodPlateAndCutleryBlockEntity cast) {
            cast.drops();
        }
        super.onRemove(state, level, pos, newState, movedByPiston);
    }
    @Override
    public @NotNull InteractionResult use(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hitResult) {
        if (!level.isClientSide) {
            if (!(level.getBlockEntity(pos) instanceof FoodPlateAndCutleryBlockEntity cast)) {
                throw new IllegalStateException("Food plate and cutlery block entity at x: " + pos.getX() + ", y: " + pos.getY() + ", z: " + pos.getZ() + " could not be found.");
            }
            ItemStack stack = player.getItemInHand(hand);
            if (stack.is(BlockRegistration.GLASS_B_BLOCK_ITEM.get())){
                BlockState newState = BlockRegistration.FOOD_PLATE_AND_GLASS_AND_CUTLERY_BLOCK.get().defaultBlockState().setValue(FoodPlateAndGlassAndCutleryBlock.FACING, state.getValue(FACING));
                level.setBlock(pos, newState, 3);
                if (!player.getAbilities().instabuild)stack.shrink(1);
            } else if (stack.getFoodProperties(player) != null && cast.getFoodStack().isEmpty()) {
                if (!cast.placeFood(player, player.getAbilities().instabuild ? stack.copy() : stack)) return InteractionResult.PASS;
            } else if (!cast.getFoodStack().isEmpty() && player.getFoodData().needsFood()) {
                player.eat(player.level, cast.getFoodStack());
                cast.changeFood(new ItemStack(Items.AIR));
                player.getFoodData().setSaturation(player.getFoodData().getSaturationLevel() + 0.8f);
            } else if (cast.getFoodStack() != null) cast.drops();
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
