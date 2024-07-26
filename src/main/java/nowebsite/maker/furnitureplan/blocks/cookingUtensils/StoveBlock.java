package nowebsite.maker.furnitureplan.blocks.cookingUtensils;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import nowebsite.maker.furnitureplan.blocks.func.IHorizontalBlock;
import nowebsite.maker.furnitureplan.blocks.func.definition.StoveShape;
import nowebsite.maker.furnitureplan.registry.BlockRegistration;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("deprecation")
public class StoveBlock extends HorizontalDirectionalBlock implements SimpleWaterloggedBlock, IHorizontalBlock {
    public static final EnumProperty<StoveShape> SHAPE = BlockRegistration.BlockStateRegistration.STOVE_SHAPE;
    public StoveBlock(Properties properties) {
        super(properties);
    }
    @Override
    public @NotNull InteractionResult use(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hitResult) {
        if (!level.isClientSide){
            ItemStack stack = player.getItemInHand(hand);
            if (stack.is(Items.FLINT_AND_STEEL) && !state.getValue(SHAPE).isLit()){
                level.setBlockAndUpdate(pos, state.setValue(SHAPE, state.getValue(SHAPE).litIt()));
                return InteractionResult.SUCCESS;
            } else if (stack.is(BlockRegistration.IRON_POT_BLOCK_ITEM.get()) && !state.getValue(SHAPE).hasPot()) {
                level.setBlockAndUpdate(pos, state.setValue(SHAPE, state.getValue(SHAPE).addPot()));
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.FAIL;
    }
    @Override
    public BlockState playerWillDestroy(@NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState state, @NotNull Player player) {
        this.spawnDestroyParticles(level, player, pos, state);
        if (!level.isClientSide) {
            BlockState newState = Blocks.AIR.defaultBlockState();
            SimpleContainer inventory = new SimpleContainer(1);
            ItemStack stack = ItemStack.EMPTY;
            switch (state.getValue(SHAPE)) {
                case STOVE_AND_POT_LIT -> {
                    newState = state.setValue(SHAPE, StoveShape.STOVE_LIT);
                    stack = new ItemStack(BlockRegistration.IRON_POT_BLOCK_ITEM.get(), 1);
                }
                case STOVE_AND_POT_UNLIT -> {
                    newState = state.setValue(SHAPE, StoveShape.STOVE_UNLIT);
                    stack = new ItemStack(BlockRegistration.IRON_POT_BLOCK_ITEM.get(), 1);
                }
                case STOVE_LIT, STOVE_UNLIT -> stack = new ItemStack(BlockRegistration.STOVE_BLOCK_ITEM.get(), 1);
            }
            inventory.setItem(0, stack);
            Containers.dropContents(level, pos, inventory);
            level.setBlockAndUpdate(pos, newState);
        }
        return state;
    }
    @Override
    public void playerDestroy(@NotNull Level level, @NotNull Player player, @NotNull BlockPos pos, @NotNull BlockState state, @Nullable BlockEntity pBlockEntity, @NotNull ItemStack tool) {
        player.awardStat(Stats.BLOCK_MINED.get(this));
        player.causeFoodExhaustion(0.005F);
    }
    @Override
    public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {
        this.playerWillDestroy(level,pos,state,player);
        return false;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(@NotNull BlockPlaceContext context) {
        return defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite()).setValue(SHAPE, StoveShape.STOVE_UNLIT);
    }

    @Override
    public @NotNull VoxelShape getOcclusionShape(@NotNull BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos pos) {
        return state.getValue(SHAPE).getOccModel(state, getter, pos);
    }
    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return this.getOcclusionShape(state, getter, pos);
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder) {
        builder.add(FACING);
        builder.add(SHAPE);
    }
    @Override
    public void tick(@NotNull BlockState state, @NotNull ServerLevel level, @NotNull BlockPos pos, @NotNull RandomSource source) {
        super.tick(state, level, pos, source);
    }
    @Override
    public int getLightEmission(@NotNull BlockState state, BlockGetter level, BlockPos pos) {
        if (state.getValue(SHAPE).isLit()) {
            return 15;
        } else return 0;
    }

    @Override
    public String parentName() {
        return null;
    }

    @Override
    public String textureKey() {
        return "particle";
    }

    @Override
    public String textureName() {
        return "stove";
    }
}
