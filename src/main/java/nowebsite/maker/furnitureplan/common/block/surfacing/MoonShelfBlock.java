package nowebsite.maker.furnitureplan.common.block.surfacing;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import nowebsite.maker.furnitureplan.FurniturePlan;
import nowebsite.maker.furnitureplan.common.block.abstraction.BasePropertyExtendedBlock;
import nowebsite.maker.furnitureplan.common.block.abstraction.BasePropertyHorizontalDirectionBlock;
import nowebsite.maker.furnitureplan.common.block.abstraction.BlockSetGetter;
import nowebsite.maker.furnitureplan.common.block.abstraction.MulStateGetter;
import nowebsite.maker.furnitureplan.common.block.abstraction.definition.MoonShelfPart;
import nowebsite.maker.furnitureplan.common.block.abstraction.generators.HorizontalMulStateBDG;
import nowebsite.maker.furnitureplan.common.block.abstraction.set.FPBlockSetType;
import nowebsite.maker.furnitureplan.common.block.abstraction.set.FPBlockType;
import nowebsite.maker.furnitureplan.common.block.surfacing.entity.MoonShelfBlockEntity;
import nowebsite.maker.furnitureplan.common.data.gen.empowered.AutoGenBlockData;
import nowebsite.maker.furnitureplan.common.data.gen.empowered.BlockDataGenerator;
import nowebsite.maker.furnitureplan.common.init.FPBlockReg;
import nowebsite.maker.furnitureplan.utils.Interaction.InteractionSpace;
import nowebsite.maker.furnitureplan.utils.Interaction.Vec3Utils;
import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.Nullable;

import java.util.List;

public class MoonShelfBlock extends BasePropertyHorizontalDirectionBlock<MoonShelfBlock> implements EntityBlock, SimpleWaterloggedBlock, AutoGenBlockData<@NotNull MoonShelfBlock>, BlockSetGetter, MulStateGetter<MoonShelfPart> {
    private static final List<InteractionSpace> SPACES = List.of(
        // 左上 - UP
        InteractionSpace.create(0, 0.4375, 0.25, 0.3125, 0.625, 1),
        // 左上 - DOWN
        InteractionSpace.create(0.3125, 0.125, 0.25, 0.75, 0.3125, 1),

        // 上 - LEFT
        InteractionSpace.create(0.53125, 0.25, 0.25, 0.9375, 0.625, 1),
        // 上 - RIGHT
        InteractionSpace.create(0.0625, 0.25, 0.25, 0.46875, 0.625, 1),

        // 右上 - UP
        InteractionSpace.create(0.6875, 0.4375, 0.25, 1, 0.625, 1),
        // 右上 - DOWN
        InteractionSpace.create(0.25, 0.125, 0.25, 0.6875, 0.3125, 1),

        // 左 - UP
        InteractionSpace.create(0, 0.875, 0.25, 0.4375, 1, 1),
        // 左 - MIDDLE_LEFT
        InteractionSpace.create(0.5, 0.4375, 0.25, 0.9375, 0.6875, 1),
        // 左 - MIDDLE_RIGHT
        InteractionSpace.create(0, 0.4375, 0.25, 0.5, 0.6875, 1),
        // 左 - DOWN
        InteractionSpace.create(0, 0.0625, 0.25, 0.4375, 0.3125, 1),

        // 中 - LEFT
        InteractionSpace.create(0.53125, 0.4375, 0.1875, 1, 0.859375, 1),
        // 中 - RIGHT
        InteractionSpace.create(0, 0.4375, 0.1875, 0.46875, 0.859375, 1),

        // 右 - UP
        InteractionSpace.create(0.5625, 0.875, 0.25, 1, 1, 1),
        // 右 - MIDDLE_LEFT
        InteractionSpace.create(0.5, 0.4375, 0.25, 1, 0.6875, 1),
        // 右 - MIDDLE_RIGHT
        InteractionSpace.create(0.0625, 0.4375, 0.25, 0.5, 0.6875, 1),
        // 右 - DOWN
        InteractionSpace.create(0.5625, 0.0625, 0.25, 1, 0.25, 1),

        // 左下 - UP
        InteractionSpace.create(0.3125, 0.875, 0.25, 0.8125, 1, 1),
        // 左下 - DOWN
        InteractionSpace.create(0, 0.5, 0.25, 0.5, 0.8125, 1),

        // 下 - LEFT
        InteractionSpace.create(0.53125, 0.75, 0.25, 1, 0.9375, 1),
        // 下 - RIGHT
        InteractionSpace.create(0, 0.75, 0.25, 0.46875, 0.9375, 1),

        // 右下 - UP
        InteractionSpace.create(0.1875, 0.875, 0.25, 0.6875, 1, 1),
        // 右下 - DOWN
        InteractionSpace.create(0.5, 0.5, 0.25, 1, 0.8125, 1)
    );
    public static final EnumProperty<@NotNull MoonShelfPart> PART = FPBlockReg.BlockStateReg.MOON_SHELF_PART;

    public MoonShelfBlock(FPBlockSetType type, BlockState base, Properties properties) {
        super(type, base, properties);
        registerDefaultState(getStateDefinition().any().setValue(PART, MoonShelfPart.CENTER).setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, Boolean.FALSE));
    }

    @Override
    protected BasePropertyExtendedBlock<MoonShelfBlock> createNewInstance(BlockState baseState, Properties properties) {
        return new MoonShelfBlock(getType(), baseState, properties);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos worldPosition, BlockState blockState) {
        if (blockState.getValue(PART).equals(MoonShelfPart.CENTER)) return new MoonShelfBlockEntity(worldPosition, blockState);
        return null;
    }

    @Override
    protected boolean shouldChangedStateKeepBlockEntity(BlockState oldState) {
        return true;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, @NotNull BlockState> builder) {
        super.createBlockStateDefinition(builder.add(PART));
    }

    /*
    * 右键: 放上物品/调节方向
    * 右键+Shift: 拿下物品
    */

    @Override
    protected InteractionResult useItemOn(ItemStack itemStack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        BlockPos centerPos = state.getValue(PART).toCenter(pos, state.getValue(FACING), false);
        if (!(level.getBlockEntity(centerPos) instanceof MoonShelfBlockEntity blockEntity)) {
            throw new IllegalStateException("Moon shelf block entity at x: " + centerPos.getX() + ", y: " + centerPos.getY() + ", z: " + centerPos.getZ() + " could not be found.");
        }

        Direction facing = state.getValue(FACING);
        MoonShelfPart part = state.getValue(PART);
        Vec3 hit = hitResult.getLocation().subtract(pos.getX(), pos.getY(), pos.getZ());
        int index = getInteractionIndex(hit, part, facing);
        if (index == -1) return InteractionResult.TRY_WITH_EMPTY_HAND;

        if (level.isClientSide()) return InteractionResult.CONSUME;
        if (blockEntity.putItem(player.getAbilities().instabuild ? itemStack.copy() : itemStack, index)) return InteractionResult.SUCCESS_SERVER;
        return InteractionResult.TRY_WITH_EMPTY_HAND;
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        BlockPos centerPos = state.getValue(PART).toCenter(pos, state.getValue(FACING), false);
        if (!(level.getBlockEntity(centerPos) instanceof MoonShelfBlockEntity blockEntity)) {
            throw new IllegalStateException("Moon shelf block entity at x: " + centerPos.getX() + ", y: " + centerPos.getY() + ", z: " + centerPos.getZ() + " could not be found.");
        }

        Direction facing = state.getValue(FACING);
        MoonShelfPart part = state.getValue(PART);
        Vec3 hit = hitResult.getLocation().subtract(pos.getX(), pos.getY(), pos.getZ());
        int index = getInteractionIndex(hit, part, facing);
        if (index == -1) return InteractionResult.PASS;

        if (level.isClientSide()) return InteractionResult.CONSUME;
        if (player.isShiftKeyDown() && blockEntity.dropItem(index)) return InteractionResult.SUCCESS_SERVER;
        if (blockEntity.tryRotate(index)) return InteractionResult.SUCCESS_SERVER;
        return InteractionResult.FAIL;
    }

    private int getInteractionIndex(Vec3 hit, MoonShelfPart part, Direction facing) {
        int startIndex;
        int count;

        switch (part) {
            case LEFT_UP:
                startIndex = 0;
                count = 2;
                break;
            case UP:
                startIndex = 2;
                count = 2;
                break;
            case RIGHT_UP:
                startIndex = 4;
                count = 2;
                break;
            case LEFT:
                startIndex = 6;
                count = 4;
                break;
            case CENTER:
                startIndex = 10;
                count = 2;
                break;
            case RIGHT:
                startIndex = 12;
                count = 4;
                break;
            case LEFT_DOWN:
                startIndex = 16;
                count = 2;
                break;
            case DOWN:
                startIndex = 18;
                count = 2;
                break;
            case RIGHT_DOWN:
                startIndex = 20;
                count = 2;
                break;
            default:
                return -1;
        }

        for (int i = startIndex; i < startIndex + count; i++) {
            if (Vec3Utils.isInBox(hit, SPACES.get(i), facing)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return state.getValue(PART).getOccModel(state);
    }

    private boolean check(BlockPos probableCenter, Direction facing, Level level, BlockPlaceContext context) {
        return MoonShelfPart.getAllExcept(facing, probableCenter, null).entrySet().stream()
            .allMatch(entry -> {
                if (!canSurvive(defaultBlockState().setValue(PART, entry.getKey()).setValue(FACING, facing), level, entry.getValue())) return false;
                if (!level.getBlockState(entry.getValue()).canBeReplaced(context)) return false;
                return level.getWorldBorder().isWithinBounds(entry.getValue());
            });
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext context) {

        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        Direction facing = context.getHorizontalDirection().getOpposite();

        if (check(pos, facing, level, context)) {
            return super.getStateForPlacement(context);
        }
        return null;
    }

    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, @Nullable LivingEntity by, ItemStack itemStack) {
        if (!level.isClientSide()) {
            Direction facing = state.getValue(FACING);
            MoonShelfPart.getAllExcept(facing, pos, state.getValue(PART)).forEach((part, posNew) -> level.setBlockAndUpdate(posNew, state.setValue(PART, part).setValue(FACING, facing)));
        }
    }

    @Override
    public BlockState playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
        if (!level.isClientSide() && player.preventsBlockDrops()) {
            MoonShelfPart partBase = state.getValue(PART);
            Direction facing = state.getValue(FACING);
            MoonShelfPart.getAllExcept(facing, partBase.toCenter(pos, facing, false), partBase).values().stream()
                .filter(pos0 -> level.getBlockState(pos0).getBlock() instanceof MoonShelfBlock)
                .forEach(posO -> level.destroyBlock(posO, false));
        }
        return super.playerWillDestroy(level, pos, state, player);
    }

    @Override
    public @Nullable BlockDataGenerator<? super @NotNull MoonShelfBlock> getGenerator() {
        return new HorizontalMulStateBDG<>() {
            @Override
            public FPBlockType<? extends @NotNull MoonShelfBlock> getTemplateType(@NotNull MoonShelfBlock block) {
                return FPBlockType.MOON_SHELF;
            }

            @Override
            public Identifier getItemTemplate() {
                return FurniturePlan.asResource("item/moon_shelf");
            }
        };
    }

    @Override
    public EnumProperty<@NotNull MoonShelfPart> getContainer() {
        return PART;
    }
}
