package nowebsite.maker.furnitureplan.blocks.cookingUtensils;

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
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import nowebsite.maker.furnitureplan.blocks.cookingUtensils.blockentities.IronPotBlockEntity;
import nowebsite.maker.furnitureplan.blocks.func.IHorizontalBlock;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("deprecation")
public class IronPotBlock extends HorizontalDirectionalBlock implements EntityBlock, SimpleWaterloggedBlock, IHorizontalBlock {
    public IronPotBlock(Properties properties) {super(properties);}
    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return new IronPotBlockEntity(pos, state);
    }
    private static final VoxelShape SHAPE_N, SHAPE_E, SHAPE_S, SHAPE_W;
    static {
        SHAPE_N = Shapes.or(
                Shapes.box(0.25, 0, 0.25, 0.75, 0.03125, 0.75),
                Shapes.box(0.3125, 0, 0.75, 0.6875, 0.03125, 0.8125),
                Shapes.box(0.3125, 0, 0.1875, 0.6875, 0.03125, 0.25),
                Shapes.box(0.1875, 0, 0.3125, 0.25, 0.03125, 0.6875),
                Shapes.box(0.75, 0, 0.3125, 0.8125, 0.03125, 0.6875),
                Shapes.box(0.8125, 0.03125, 0.3125, 0.875, 0.0625, 0.6875),
                Shapes.box(0.125, 0.03125, 0.3125, 0.1875, 0.0625, 0.6875),
                Shapes.box(0.3125, 0.03125, 0.8125, 0.6875, 0.0625, 0.875),
                Shapes.box(0.3125, 0.03125, 0.125, 0.6875, 0.0625, 0.1875),
                Shapes.box(0.25, 0.03125, 0.1875, 0.3125, 0.0625, 0.25),
                Shapes.box(0.6875, 0.03125, 0.1875, 0.75, 0.0625, 0.25),
                Shapes.box(0.25, 0.03125, 0.75, 0.3125, 0.0625, 0.8125),
                Shapes.box(0.6875, 0.03125, 0.75, 0.75, 0.0625, 0.8125),
                Shapes.box(0.75, 0.03125, 0.6875, 0.8125, 0.0625, 0.75),
                Shapes.box(0.75, 0.03125, 0.25, 0.8125, 0.0625, 0.3125),
                Shapes.box(0.1875, 0.03125, 0.6875, 0.25, 0.0625, 0.75),
                Shapes.box(0.1875, 0.03125, 0.25, 0.25, 0.0625, 0.3125),
                Shapes.box(0.375, 0.03125, 0.0625, 0.625, 0.0625, 0.125),
                Shapes.box(0.453125, 0.03125, -0.25, 0.546875, 0.0625, 0.0625)
        );
        SHAPE_E = Shapes.or(
                Shapes.box(0.25, 0, 0.25, 0.75, 0.03125, 0.75),
                Shapes.box(0.1875, 0, 0.3125, 0.25, 0.03125, 0.6875),
                Shapes.box(0.75, 0, 0.3125, 0.8125, 0.03125, 0.6875),
                Shapes.box(0.3125, 0, 0.1875, 0.6875, 0.03125, 0.25),
                Shapes.box(0.3125, 0, 0.75, 0.6875, 0.03125, 0.8125),
                Shapes.box(0.3125, 0.03125, 0.8125, 0.6875, 0.0625, 0.875),
                Shapes.box(0.3125, 0.03125, 0.125, 0.6875, 0.0625, 0.1875),
                Shapes.box(0.125, 0.03125, 0.3125, 0.1875, 0.0625, 0.6875),
                Shapes.box(0.8125, 0.03125, 0.3125, 0.875, 0.0625, 0.6875),
                Shapes.box(0.75, 0.03125, 0.25, 0.8125, 0.0625, 0.3125),
                Shapes.box(0.75, 0.03125, 0.6875, 0.8125, 0.0625, 0.75),
                Shapes.box(0.1875, 0.03125, 0.25, 0.25, 0.0625, 0.3125),
                Shapes.box(0.1875, 0.03125, 0.6875, 0.25, 0.0625, 0.75),
                Shapes.box(0.25, 0.03125, 0.75, 0.3125, 0.0625, 0.8125),
                Shapes.box(0.6875, 0.03125, 0.75, 0.75, 0.0625, 0.8125),
                Shapes.box(0.25, 0.03125, 0.1875, 0.3125, 0.0625, 0.25),
                Shapes.box(0.6875, 0.03125, 0.1875, 0.75, 0.0625, 0.25),
                Shapes.box(0.875, 0.03125, 0.375, 0.9375, 0.0625, 0.625),
                Shapes.box(0.9375, 0.03125, 0.453125, 1.25, 0.0625, 0.546875)
        );
        SHAPE_S = Shapes.or(
                Shapes.box(0.25, 0, 0.25, 0.75, 0.03125, 0.75),
                Shapes.box(0.3125, 0, 0.1875, 0.6875, 0.03125, 0.25),
                Shapes.box(0.3125, 0, 0.75, 0.6875, 0.03125, 0.8125),
                Shapes.box(0.75, 0, 0.3125, 0.8125, 0.03125, 0.6875),
                Shapes.box(0.1875, 0, 0.3125, 0.25, 0.03125, 0.6875),
                Shapes.box(0.125, 0.03125, 0.3125, 0.1875, 0.0625, 0.6875),
                Shapes.box(0.8125, 0.03125, 0.3125, 0.875, 0.0625, 0.6875),
                Shapes.box(0.3125, 0.03125, 0.125, 0.6875, 0.0625, 0.1875),
                Shapes.box(0.3125, 0.03125, 0.8125, 0.6875, 0.0625, 0.875),
                Shapes.box(0.6875, 0.03125, 0.75, 0.75, 0.0625, 0.8125),
                Shapes.box(0.25, 0.03125, 0.75, 0.3125, 0.0625, 0.8125),
                Shapes.box(0.6875, 0.03125, 0.1875, 0.75, 0.0625, 0.25),
                Shapes.box(0.25, 0.03125, 0.1875, 0.3125, 0.0625, 0.25),
                Shapes.box(0.1875, 0.03125, 0.25, 0.25, 0.0625, 0.3125),
                Shapes.box(0.1875, 0.03125, 0.6875, 0.25, 0.0625, 0.75),
                Shapes.box(0.75, 0.03125, 0.25, 0.8125, 0.0625, 0.3125),
                Shapes.box(0.75, 0.03125, 0.6875, 0.8125, 0.0625, 0.75),
                Shapes.box(0.375, 0.03125, 0.875, 0.625, 0.0625, 0.9375),
                Shapes.box(0.453125, 0.03125, 0.9375, 0.546875, 0.0625, 1.25)
        );
        SHAPE_W = Shapes.or(
                Shapes.box(0.25, 0, 0.25, 0.75, 0.03125, 0.75),
                Shapes.box(0.75, 0, 0.3125, 0.8125, 0.03125, 0.6875),
                Shapes.box(0.1875, 0, 0.3125, 0.25, 0.03125, 0.6875),
                Shapes.box(0.3125, 0, 0.75, 0.6875, 0.03125, 0.8125),
                Shapes.box(0.3125, 0, 0.1875, 0.6875, 0.03125, 0.25),
                Shapes.box(0.3125, 0.03125, 0.125, 0.6875, 0.0625, 0.1875),
                Shapes.box(0.3125, 0.03125, 0.8125, 0.6875, 0.0625, 0.875),
                Shapes.box(0.8125, 0.03125, 0.3125, 0.875, 0.0625, 0.6875),
                Shapes.box(0.125, 0.03125, 0.3125, 0.1875, 0.0625, 0.6875),
                Shapes.box(0.1875, 0.03125, 0.6875, 0.25, 0.0625, 0.75),
                Shapes.box(0.1875, 0.03125, 0.25, 0.25, 0.0625, 0.3125),
                Shapes.box(0.75, 0.03125, 0.6875, 0.8125, 0.0625, 0.75),
                Shapes.box(0.75, 0.03125, 0.25, 0.8125, 0.0625, 0.3125),
                Shapes.box(0.6875, 0.03125, 0.1875, 0.75, 0.0625, 0.25),
                Shapes.box(0.25, 0.03125, 0.1875, 0.3125, 0.0625, 0.25),
                Shapes.box(0.6875, 0.03125, 0.75, 0.75, 0.0625, 0.8125),
                Shapes.box(0.25, 0.03125, 0.75, 0.3125, 0.0625, 0.8125),
                Shapes.box(0.0625, 0.03125, 0.375, 0.125, 0.0625, 0.625),
                Shapes.box(-0.25, 0.03125, 0.453125, 0.0625, 0.0625, 0.546875)
        );
    }
    @Override
    public @NotNull RenderShape getRenderShape(@NotNull BlockState state) {
        return RenderShape.MODEL;
    }
    @Override
    public void onRemove(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState newState, boolean movedByPiston) {
        if (state.getBlock() != newState.getBlock()){
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof IronPotBlockEntity cast) {
                cast.drops();
            }
        }
        super.onRemove(state, level, pos, newState, movedByPiston);
    }
    @Override
    public @NotNull InteractionResult use(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hitResult) {
        if (!level.isClientSide) {
            if (!(level.getBlockEntity(pos) instanceof IronPotBlockEntity cast)) {
                throw new IllegalStateException("Iron pot block entity at x: " + pos.getX() + ", y: " + pos.getY() + ", z: " + pos.getZ() + " could not be found.");
            }
            ItemStack stack = player.getItemInHand(hand);
            if (stack.getFoodProperties(player) != null && cast.getFoodStack().isEmpty()) {
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
        return switch (state.getValue(FACING)) {
            case EAST -> SHAPE_E;
            case SOUTH -> SHAPE_S;
            case WEST -> SHAPE_W;
            default -> SHAPE_N;
        };
    }

    @Override
    public String parentName() {
        return "iron_pot";
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
