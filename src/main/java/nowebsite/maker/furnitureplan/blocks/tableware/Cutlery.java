package nowebsite.maker.furnitureplan.blocks.tableware;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import nowebsite.maker.furnitureplan.blocks.func.IHorizontalBlock;
import nowebsite.maker.furnitureplan.blocks.func.definition.PlateShape;
import nowebsite.maker.furnitureplan.registry.BlockRegistration;
import org.jetbrains.annotations.NotNull;

import static nowebsite.maker.furnitureplan.blocks.func.definition.PlateShape.*;

@SuppressWarnings("deprecation")
public class Cutlery extends HorizontalDirectionalBlock implements IHorizontalBlock {
    public Cutlery(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResult use(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hitResult) {
        if (!level.isClientSide){
            ItemStack stack = player.getItemInHand(hand);
            if (stack.is(BlockRegistration.FOOD_PLATE_BLOCK_ITEM.get())) {
                BlockState newState = BlockRegistration.FOOD_PLATE_BLOCK.get().defaultBlockState()
                        .setValue(FACING, state.getValue(FACING))
                        .setValue(FoodPlateBlock.SHAPE_DEF, PlateShape.PLATE_AND_CUTLERY_SHAPE);
                level.setBlock(pos, newState, 3);
                if (!player.getAbilities().instabuild) stack.shrink(1);
            }
        }
        return InteractionResult.PASS;
    }
    @Override
    public boolean canSurvive(@NotNull BlockState state, @NotNull LevelReader level, @NotNull BlockPos pos) {
        return canAttach(level, pos, Direction.UP.getOpposite());
    }

    public static boolean canAttach(@NotNull LevelReader pReader, @NotNull BlockPos pPos, Direction pDirection) {
        BlockPos blockpos = pPos.relative(pDirection);
        return pReader.getBlockState(blockpos).isFaceSturdy(pReader, blockpos, pDirection.getOpposite());
    }
    @Override
    public @NotNull RenderShape getRenderShape(@NotNull BlockState state) {
        return RenderShape.MODEL;
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
            case EAST -> CUTLERY_E;
            case SOUTH -> CUTLERY_S;
            case WEST -> CUTLERY_W;
            default -> CUTLERY_N;
        };
    }

    @Override
    public String parentName() {
        return "cutlery";
    }

    @Override
    public String textureKey() {
        return "particle";
    }

    @Override
    public String textureName() {
        return "plate";
    }
}
