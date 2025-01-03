package nowebsite.maker.furnitureplan.blocks.singleblockfurniture;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import nowebsite.maker.furnitureplan.blocks.func.ISimpleBlock;
import nowebsite.maker.furnitureplan.blocks.singleblockfurniture.blockentities.VaseBBlockEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("deprecation")
public class VaseBBlock extends Block implements EntityBlock, ISimpleBlock {
    public static final VoxelShape MY_SHAPE;
    public VaseBBlock(Properties pProperties) {
        super(pProperties);
    }
    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return new VaseBBlockEntity(pos, state);
    }
    @Override
    public @NotNull RenderShape getRenderShape(@NotNull BlockState state) {
        return RenderShape.MODEL;
    }
    @Override
    public void onRemove(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState newState, boolean movedByPiston) {
        if (state.getBlock() != newState.getBlock()){
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof VaseBBlockEntity cast) {
                cast.drops();
            }
            super.onRemove(state, level, pos, newState, movedByPiston);
        }
    }

    @Override
    protected @NotNull ItemInteractionResult useItemOn(@NotNull ItemStack stack, @NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hitResult) {
        if (!level.isClientSide) {
            if (!(level.getBlockEntity(pos) instanceof VaseBBlockEntity cast)) {
                throw new IllegalStateException("Vase b block entity at x: " + pos.getX() + ", y: " + pos.getY() + ", z: " + pos.getZ() + " could not be found.");
            }
            boolean flag = false;
            if (stack.getItem() instanceof BlockItem blockItem){
                Block block = blockItem.getBlock();
                flag = block instanceof FlowerBlock || block instanceof DeadBushBlock || block instanceof AzaleaBlock || block instanceof BambooStalkBlock;
            }
            if (flag && cast.getFlowerStack().isEmpty()) {
                cast.placeFlower(player, player.getAbilities().instabuild ? stack.copy() : stack);
            }
            else return ItemInteractionResult.FAIL;
        }
        return ItemInteractionResult.CONSUME;
    }

    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos, @NotNull CollisionContext pContext) {
        return this.getOcclusionShape(pState, pLevel, pPos);
    }

    @Override
    public @NotNull VoxelShape getOcclusionShape(@NotNull BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos) {
        return MY_SHAPE;
    }
    static {
        MY_SHAPE = Shapes.or(
                Shapes.box(0.4375, 0, 0.4375, 0.5625, 0.03125, 0.5625),
                Shapes.box(0.40625, 0.59375, 0.40625, 0.4375, 0.71875, 0.59375),
                Shapes.box(0.5625, 0, 0.4375, 0.59375, 0.125, 0.5625),
                Shapes.box(0.40625, 0, 0.5625, 0.59375, 0.125, 0.59375),
                Shapes.box(0.4375, 0.59375, 0.40625, 0.5625, 0.71875, 0.4375),
                Shapes.box(0.375, 0.125, 0.375, 0.625, 0.25, 0.40625),
                Shapes.box(0.375, 0.125, 0.59375, 0.625, 0.25, 0.625),
                Shapes.box(0.59375, 0.125, 0.40625, 0.625, 0.25, 0.59375),
                Shapes.box(0.34375, 0.25, 0.625, 0.65625, 0.375, 0.65625),
                Shapes.box(0.34375, 0.25, 0.34375, 0.65625, 0.375, 0.375),
                Shapes.box(0.375, 0.125, 0.40625, 0.40625, 0.25, 0.59375),
                Shapes.box(0.34375, 0.25, 0.375, 0.375, 0.375, 0.625),
                Shapes.box(0.625, 0.25, 0.375, 0.65625, 0.375, 0.625),
                Shapes.box(0.3125, 0.375, 0.3125, 0.34375, 0.5, 0.6875),
                Shapes.box(0.65625, 0.375, 0.3125, 0.6875, 0.5, 0.6875),
                Shapes.box(0.34375, 0.375, 0.65625, 0.65625, 0.5, 0.6875),
                Shapes.box(0.34375, 0.375, 0.3125, 0.65625, 0.5, 0.34375),
                Shapes.box(0.34375, 0.5, 0.34375, 0.375, 0.5625, 0.65625),
                Shapes.box(0.625, 0.5, 0.34375, 0.65625, 0.5625, 0.65625),
                Shapes.box(0.375, 0.5, 0.34375, 0.625, 0.5625, 0.375),
                Shapes.box(0.375, 0.5, 0.625, 0.625, 0.5625, 0.65625),
                Shapes.box(0.375, 0.5625, 0.59375, 0.625, 0.59375, 0.625),
                Shapes.box(0.375, 0.5625, 0.375, 0.625, 0.59375, 0.40625),
                Shapes.box(0.59375, 0.5625, 0.40625, 0.625, 0.59375, 0.59375),
                Shapes.box(0.375, 0.5625, 0.40625, 0.40625, 0.59375, 0.59375),
                Shapes.box(0.40625, 0, 0.4375, 0.4375, 0.125, 0.5625),
                Shapes.box(0.40625, 0.59375, 0.40625, 0.4375, 0.71875, 0.59375),
                Shapes.box(0.5625, 0.59375, 0.40625, 0.59375, 0.71875, 0.59375),
                Shapes.box(0.40625, 0, 0.40625, 0.59375, 0.125, 0.4375),
                Shapes.box(0.4375, 0.59375, 0.5625, 0.5625, 0.71875, 0.59375),
                Shapes.box(0.4375, 0.71875, 0.5625, 0.5625, 0.75, 0.625),
                Shapes.box(0.4375, 0.71875, 0.375, 0.5625, 0.75, 0.4375),
                Shapes.box(0.5625, 0.71875, 0.375, 0.625, 0.75, 0.625),
                Shapes.box(0.375, 0.71875, 0.375, 0.4375, 0.75, 0.625)
        );
    }

    @Override
    public String parentName() {
        return "vase";
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
