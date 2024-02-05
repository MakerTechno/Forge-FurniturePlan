package nowebsite.maker.furnitureplan.blocks.cookingUtensils;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RedstoneTorchBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import nowebsite.maker.furnitureplan.registry.BlockRegistration;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("deprecation")
public class StoveBlock extends Block implements SimpleWaterloggedBlock {
    public static final BooleanProperty LIT = RedstoneTorchBlock.LIT;
    private static final VoxelShape SHAPE = Shapes.box(0, 0, 0, 1, 0.0625, 1);
    public StoveBlock(Properties properties) {
        super(properties);
    }
    @Override
    public @NotNull InteractionResult use(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hitResult) {
        if (!level.isClientSide){
            ItemStack stack = player.getItemInHand(hand);
            if (stack.is(Items.FLINT_AND_STEEL) && !state.getValue(LIT)){
                BlockState state1 = BlockRegistration.LANTERN_BLOCK.get().defaultBlockState().setValue(LIT, Boolean.TRUE);
                level.setBlockAndUpdate(pos, state1);
                return InteractionResult.SUCCESS;
            } else if (!stack.is(Items.FLINT_AND_STEEL)) {
                BlockState state1 = BlockRegistration.LANTERN_BLOCK.get().defaultBlockState().setValue(LIT, Boolean.FALSE);
                level.setBlockAndUpdate(pos, state1);
            }
        }
        return InteractionResult.FAIL;
    }
    @Override
    public @NotNull VoxelShape getOcclusionShape(@NotNull BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos pos) {
        return SHAPE;
    }
    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return this.getOcclusionShape(state, getter, pos);
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder) {
        builder.add(LIT);
    }
    @Override
    public void tick(@NotNull BlockState state, @NotNull ServerLevel level, @NotNull BlockPos pos, @NotNull RandomSource source) {
        super.tick(state, level, pos, source);
    }
    @Override
    public int getLightEmission(@NotNull BlockState state, BlockGetter level, BlockPos pos) {
        if (state.getValue(LIT)) {
            return 15;
        } else return 0;
    }
}
