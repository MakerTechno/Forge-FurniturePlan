package nowebsite.maker.furnitureplan.blocks.tableware;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.PotionItem;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.items.ItemStackHandler;
import nowebsite.maker.furnitureplan.blocks.func.BaseSmallHallBasedBlock;
import nowebsite.maker.furnitureplan.blocks.func.IHorizontalBlock;
import nowebsite.maker.furnitureplan.blocks.func.definition.PlateShape;
import nowebsite.maker.furnitureplan.blocks.tableware.blockentities.FoodPlateBlockEntity;
import nowebsite.maker.furnitureplan.items.GlassBBlockItem;
import nowebsite.maker.furnitureplan.registry.BlockRegistration;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

@SuppressWarnings("deprecation")
public class FoodPlateBlock extends HorizontalDirectionalBlock implements EntityBlock, SimpleWaterloggedBlock, IHorizontalBlock {
    public static final EnumProperty<PlateShape> SHAPE_DEF = BlockRegistration.BlockStateRegistration.PLATE_SHAPE;
    public FoodPlateBlock(Properties properties) {super(properties);}

    @Override
    protected @NotNull MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return simpleCodec(FoodPlateBlock::new);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return new FoodPlateBlockEntity(pos, state);
    }
    @Override
    public @NotNull RenderShape getRenderShape(@NotNull BlockState state) {
        return RenderShape.MODEL;
    }
    @Override
    protected @NotNull InteractionResult useWithoutItem(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull BlockHitResult hitResult) {
        if (!level.isClientSide) {
            if (!(level.getBlockEntity(pos) instanceof FoodPlateBlockEntity cast)) {
                throw new IllegalStateException("Food plate block entity at x: " + pos.getX() + ", y: " + pos.getY() + ", z: " + pos.getZ() + " could not be found.");
            }
            PlateShape shape = state.getValue(SHAPE_DEF);
            boolean flag1 = shape.hasCutlery(), flag2 = shape.hasGlass();
            if (flag1 && !cast.getFoodStack().isEmpty() && player.getFoodData().needsFood()) {
                player.eat(player.level(), cast.getFoodStack());
                cast.changeFood(new ItemStack(Items.AIR));
                player.getFoodData().setSaturation(player.getFoodData().getSaturationLevel() + 1);
            }
            else if (flag2 && !cast.usePotion(player)){
                if (cast.getFoodStack() == null) return InteractionResult.FAIL;
                cast.drops();
            }
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    protected @NotNull ItemInteractionResult useItemOn(@NotNull ItemStack stack, @NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hitResult) {
        if (!level.isClientSide) {
            if (!(level.getBlockEntity(pos) instanceof FoodPlateBlockEntity cast)) {
                throw new IllegalStateException("Food plate block entity at x: " + pos.getX() + ", y: " + pos.getY() + ", z: " + pos.getZ() + " could not be found.");
            }
            PlateShape shape = state.getValue(SHAPE_DEF);
            boolean flag1 = shape.hasCutlery(), flag2 = shape.hasGlass();
            if (stack.is(BlockRegistration.CUTLERY_ITEM.get())) {
                if (flag1) return ItemInteractionResult.FAIL;
                BlockState newState = BlockRegistration.FOOD_PLATE_BLOCK.get().defaultBlockState().setValue(FACING, state.getValue(FACING)).setValue(SHAPE_DEF, shape.addCutlery());
                level.setBlockAndUpdate(pos, newState);
                if (!player.getAbilities().instabuild && !newState.getValue(SHAPE_DEF).equals(shape)) stack.shrink(1);
            } else if (stack.is(BlockRegistration.GLASS_B_BLOCK_ITEM.get())) {
                if (flag2) return ItemInteractionResult.FAIL;
                BlockState newState = BlockRegistration.FOOD_PLATE_BLOCK.get().defaultBlockState().setValue(FACING, state.getValue(FACING)).setValue(SHAPE_DEF, shape.addGlass());
                level.setBlockAndUpdate(pos, newState);
                if (!player.getAbilities().instabuild && !newState.getValue(SHAPE_DEF).equals(shape)) stack.shrink(1);

                ItemStackHandler handler = new ItemStackHandler(2);
                GlassBBlockItem.loadFromEntityData(level.registryAccess(), stack, handler);

                cast.changePotion(handler.getStackInSlot(1));
            } else if (stack.getFoodProperties(player) != null && cast.getFoodStack().isEmpty()) {
                if (!cast.placeFood(player, player.getAbilities().instabuild ? stack.copy() : stack))
                    return ItemInteractionResult.FAIL;
            } else if (flag2 && cast.getPotionStack().isEmpty() && stack.getItem() instanceof PotionItem) {
                if (!cast.fillPotion(player, player.getAbilities().instabuild ? stack.copy() : stack))
                    return ItemInteractionResult.FAIL;
            } else if (flag2 && cast.restorePotion(player, player.getAbilities().instabuild ? stack.copy() : stack))
                return ItemInteractionResult.SUCCESS;
            else return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
            return ItemInteractionResult.SUCCESS;
        }
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }
    @Override
    public boolean onDestroyedByPlayer(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, boolean willHarvest, @NotNull FluidState fluid) {
        PlateShape shape =  state.isAir() ? null : state.getValue(SHAPE_DEF).getNext();
        BlockState newState = shape == null ? Blocks.AIR.defaultBlockState() : BlockRegistration.FOOD_PLATE_BLOCK.get().defaultBlockState().setValue(FACING, state.getValue(FACING)).setValue(SHAPE_DEF,shape);
        if (newState.isAir() || state.getValue(SHAPE_DEF).getNext() == newState.getValue(SHAPE_DEF)){
            if (willHarvest && level.getBlockEntity(pos) instanceof FoodPlateBlockEntity cast) {
                SimpleContainer inventory = new SimpleContainer(1);
                ItemStack stack = ItemStack.EMPTY;
                if (canSurvive(state, level, pos)) {
                    switch (state.getValue(SHAPE_DEF)) {
                        case PLATE_AND_GLASS_SHAPE -> cast.dropBottle();
                        case PLATE_AND_CUTLERY_SHAPE, PLATE_AND_GLASS_AND_CUTLERY_SHAPE -> stack = new ItemStack(BlockRegistration.CUTLERY_ITEM.get(), 1);
                        case PLATE_SHAPE -> {
                            stack = new ItemStack(BlockRegistration.FOOD_PLATE_BLOCK_ITEM.get(), 1);
                            cast.drops();
                        }
                    }
                } else {
                    if (state.getValue(SHAPE_DEF).hasCutlery()) stack = new ItemStack(BlockRegistration.CUTLERY_ITEM.get(), 1);
                    cast.drops();
                    cast.dropBottle();
                }
                inventory.setItem(0, stack);
                Containers.dropContents(level, pos, inventory);
            }
        }
        level.setBlockAndUpdate(pos, newState);
        return shape == null;
    }
    /**From {@link FaceAttachedHorizontalDirectionalBlock}*/
    @Override
    public boolean canSurvive(@NotNull BlockState state, @NotNull LevelReader level, @NotNull BlockPos pos) {
        return BaseSmallHallBasedBlock.canSurvive(level, pos);
    }
    public @NotNull BlockState updateShape(@NotNull BlockState state, @NotNull Direction facing, @NotNull BlockState facingState, @NotNull LevelAccessor level, @NotNull BlockPos currentPos, @NotNull BlockPos facingPos) {
        return Direction.UP.getOpposite() == facing && !state.canSurvive(level, currentPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, facing, facingState, level, currentPos, facingPos);
    }
    public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return this.getOcclusionShape(state, getter, pos);
    }
    @Override
    public BlockState getStateForPlacement(@NotNull BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite()).setValue(SHAPE_DEF, PlateShape.PLATE_SHAPE);
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder) {
        builder.add(FACING);
        builder.add(SHAPE_DEF);
    }
    @Override
    public @NotNull VoxelShape getOcclusionShape(@NotNull BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos pos) {
        return Objects.requireNonNull(state.getValue(SHAPE_DEF).getOccModel(state, getter, pos));
    }

    @Override
    protected boolean isPathfindable(@NotNull BlockState state, @NotNull PathComputationType pathComputationType) {
        return true;
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
        return null;
    }
}
