package nowebsite.maker.furnitureplan.common.block.cooking.utensils;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import nowebsite.maker.furnitureplan.common.block.cooking.utensils.entities.IronPotBlockEntity;
import nowebsite.maker.furnitureplan.utils.voxel.IVoxelHolder;
import nowebsite.maker.furnitureplan.utils.voxel.VoxelShapeBuilder;
import org.jetbrains.annotations.NotNull;

public class IronPotBlock extends HorizontalDirectionalBlock implements EntityBlock, SimpleWaterloggedBlock {
    private static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public IronPotBlock(Properties properties) {super(properties);}
    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return simpleCodec(IronPotBlock::new);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new IronPotBlockEntity(pos, state);
    }
    public static IVoxelHolder SHAPE = VoxelShapeBuilder.ofYRot()
        .or(0.1875, 0, 0.1875, 0.8125, 0.125, 0.8125)
        .or(0.4375, 0.025, -0.1875, 0.5625, 0.0875, 0.1875)
        .build();

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    protected InteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (level.isClientSide()) return InteractionResult.CONSUME;

        if (!(level.getBlockEntity(pos) instanceof IronPotBlockEntity cast)) {
            throw new IllegalStateException("Iron pot block entity at x: " + pos.getX() + ", y: " + pos.getY() + ", z: " + pos.getZ() + " could not be found.");
        }
        if (stack.getComponents().get(DataComponents.FOOD) != null && cast.getFoodStack().isEmpty()) {
            if (cast.placeFood(player, player.getAbilities().instabuild ? stack.copy() : stack)) return InteractionResult.SUCCESS_SERVER;
        }
        return InteractionResult.TRY_WITH_EMPTY_HAND;
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (level.isClientSide()) return InteractionResult.CONSUME;
        if (!(level.getBlockEntity(pos) instanceof IronPotBlockEntity cast)) {
            throw new IllegalStateException("Iron pot block entity at x: " + pos.getX() + ", y: " + pos.getY() + ", z: " + pos.getZ() + " could not be found.");
        }
        if (!cast.getFoodStack().isEmpty()) {
            cast.drops();
            return InteractionResult.SUCCESS_SERVER;
        }
        return InteractionResult.PASS;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        return SHAPE.getShape(state.getValue(FACING));
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, @NotNull BlockState> builder) {
        builder.add(FACING, WATERLOGGED);
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
                defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite())
                :
                blockState.setValue(FACING, context.getHorizontalDirection().getOpposite());
        return blockState.setValue(WATERLOGGED, context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER);
    }

    @Override
    protected BlockState updateShape(BlockState state, LevelReader level, ScheduledTickAccess ticks, BlockPos pos, Direction directionToNeighbour, BlockPos neighbourPos, BlockState neighbourState, RandomSource random) {
        if (directionToNeighbour == Direction.DOWN && !this.canSurvive(state, level, pos)) return Blocks.AIR.defaultBlockState();
        if (state.getValue(WATERLOGGED)) ticks.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        return super.updateShape(state, level, ticks, pos, directionToNeighbour, neighbourPos, neighbourState, random);
    }

}
