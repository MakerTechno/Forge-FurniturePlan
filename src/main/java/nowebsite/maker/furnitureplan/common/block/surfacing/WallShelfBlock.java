package nowebsite.maker.furnitureplan.common.block.surfacing;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import nowebsite.maker.furnitureplan.common.block.abstraction.BasePropertyExtendedBlock;
import nowebsite.maker.furnitureplan.common.block.abstraction.BasePropertyHorizontalDirectionBlock;
import nowebsite.maker.furnitureplan.common.block.abstraction.MulStateGetter;
import nowebsite.maker.furnitureplan.common.block.abstraction.definition.WallShelfShape;
import nowebsite.maker.furnitureplan.common.block.abstraction.generators.HorizontalMulStateBDG;
import nowebsite.maker.furnitureplan.common.block.abstraction.set.FPBlockSetType;
import nowebsite.maker.furnitureplan.common.block.abstraction.set.FPBlockType;
import nowebsite.maker.furnitureplan.common.block.surfacing.entity.WallShelfBlockEntity;
import nowebsite.maker.furnitureplan.common.data.gen.empowered.BlockDataGenerator;
import nowebsite.maker.furnitureplan.common.init.FPBlockReg;
import nowebsite.maker.furnitureplan.utils.interaction.InteractionSpace;
import nowebsite.maker.furnitureplan.utils.interaction.Vec3Utils;
import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.Nullable;

import java.util.List;

public class WallShelfBlock extends BasePropertyHorizontalDirectionBlock<WallShelfBlock> implements EntityBlock, MulStateGetter<WallShelfShape> {
    private static final List<InteractionSpace> SINGLE_SPACES = List.of(
        InteractionSpace.create(0.65625, 0.25, 0.375, 1, 0.5625, 1),
        InteractionSpace.create(0.34375, 0.25, 0.375, 0.65625, 0.5625, 1),
        InteractionSpace.create(0, 0.25, 0.375, 0.34375, 0.5625, 1)
    );

    private static final List<InteractionSpace> BI_SPACES = List.of(
        InteractionSpace.create(0.65625, 0.5, 0.375, 1, 0.8125, 1),
        InteractionSpace.create(0.34375, 0.5, 0.375, 0.65625, 0.8125, 1),
        InteractionSpace.create(0, 0.5, 0.375, 0.34375, 0.8125, 1),
        InteractionSpace.create(0.65625, 0, 0.375, 1, 0.3125, 1),
        InteractionSpace.create(0.34375, 0, 0.375, 0.65625, 0.3125, 1),
        InteractionSpace.create(0, 0, 0.375, 0.34375, 0.3125, 1)
    );

    public static final EnumProperty<@NotNull WallShelfShape> SHAPE = FPBlockReg.BlockStateReg.WALL_SHELF_SHAPE;

    public WallShelfBlock(FPBlockSetType type, BlockState state, Properties properties) {
        super(type, state, properties);
        registerDefaultState(getStateDefinition().any().setValue(SHAPE, WallShelfShape.SINGLE).setValue(WATERLOGGED, Boolean.FALSE).setValue(FACING, Direction.NORTH));
    }

    @Override
    protected BasePropertyExtendedBlock<WallShelfBlock> createNewInstance(BlockState baseState, Properties properties) {
        return new WallShelfBlock(getType(), baseState, properties);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos worldPosition, BlockState blockState) {
        return new WallShelfBlockEntity(worldPosition, blockState);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, @NotNull BlockState> builder) {
        super.createBlockStateDefinition(builder.add(SHAPE));
    }

    @Override
    protected boolean shouldChangedStateKeepBlockEntity(BlockState oldState) {
        return true;
    }

    @Override
    protected InteractionResult useItemOn(ItemStack itemStack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (!(level.getBlockEntity(pos) instanceof WallShelfBlockEntity blockEntity)) {
            throw new IllegalStateException("Wall shelf block entity at x: " + pos.getX() + ", y: " + pos.getY() + ", z: " + pos.getZ() + " could not be found.");
        }

        Direction facing = state.getValue(FACING);
        WallShelfShape shape = state.getValue(SHAPE);
        Vec3 hit = hitResult.getLocation().subtract(pos.getX(), pos.getY(), pos.getZ());
        int index = getInteractionIndex(hit, shape, facing);
        if (index == -1) return InteractionResult.TRY_WITH_EMPTY_HAND;

        if (level.isClientSide()) return InteractionResult.CONSUME;
        if (shape.equals(WallShelfShape.SINGLE)
            && itemStack.getItem() instanceof BlockItem blockItem
            && blockItem.getBlock() instanceof WallShelfBlock wallShelfBlock
            && wallShelfBlock.getType().equals(this.getType())
        ) {
            blockEntity.setBi(true);
            if (!player.getAbilities().instabuild) itemStack.shrink(1);
            level.setBlockAndUpdate(pos, state.setValue(SHAPE, WallShelfShape.BI));
            return InteractionResult.SUCCESS_SERVER;
        }
        if (blockEntity.putItem(player.getAbilities().instabuild ? itemStack.copy() : itemStack, index)) return InteractionResult.SUCCESS_SERVER;
        return InteractionResult.TRY_WITH_EMPTY_HAND;
    }


    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (!(level.getBlockEntity(pos) instanceof WallShelfBlockEntity blockEntity)) {
            throw new IllegalStateException("Wall shelf block entity at x: " + pos.getX() + ", y: " + pos.getY() + ", z: " + pos.getZ() + " could not be found.");
        }

        Direction facing = state.getValue(FACING);
        WallShelfShape shape = state.getValue(SHAPE);
        Vec3 hit = hitResult.getLocation().subtract(pos.getX(), pos.getY(), pos.getZ());
        int index = getInteractionIndex(hit, shape, facing);
        if (index == -1) return InteractionResult.PASS;

        if (level.isClientSide()) return InteractionResult.CONSUME;
        if (player.isShiftKeyDown() && blockEntity.dropItem(index)) return InteractionResult.SUCCESS_SERVER;
        if (player.isShiftKeyDown() && shape.equals(WallShelfShape.BI) && index > 2) {
            blockEntity.dropSecondFloor();
            blockEntity.setBi(false);

            level.setBlockAndUpdate(pos, state.setValue(SHAPE, WallShelfShape.SINGLE));
            return InteractionResult.SUCCESS_SERVER;
        }
        if (blockEntity.tryRotate(index)) return InteractionResult.SUCCESS_SERVER;
        return InteractionResult.FAIL;
    }

    private int getInteractionIndex(Vec3 hit, WallShelfShape shape, Direction facing) {
        List<InteractionSpace> spaces = switch (shape) {
            case SINGLE -> SINGLE_SPACES;
            case BI -> BI_SPACES;
        };

        for (int i = 0; i < spaces.size(); i++) {
            if (Vec3Utils.isInBox(hit, spaces.get(i), facing)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return state.getValue(SHAPE).getOccModel(state);
    }

    @Override
    public EnumProperty<@NotNull WallShelfShape> getContainer() {
        return SHAPE;
    }

    @Override
    public @Nullable BlockDataGenerator<? super @NotNull WallShelfBlock> getGenerator() {
        return new HorizontalMulStateBDG<>() {
            @Override
            public FPBlockType<? extends @NotNull WallShelfBlock> getTemplateType(@NotNull WallShelfBlock block) {
                return FPBlockType.WALL_SHELF;
            }
        };
    }
}
