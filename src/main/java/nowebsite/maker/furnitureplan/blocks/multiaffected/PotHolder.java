package nowebsite.maker.furnitureplan.blocks.multiaffected;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import nowebsite.maker.furnitureplan.blocks.func.BaseSmallHallBasedBlock;
import nowebsite.maker.furnitureplan.blocks.func.IColorfulBlock;
import nowebsite.maker.furnitureplan.blocks.func.IHorizontalBlock;
import nowebsite.maker.furnitureplan.blocks.func.definition.PotHolderPart;
import nowebsite.maker.furnitureplan.blocks.multiaffected.blockentities.PotHolderBlockEntity;
import nowebsite.maker.furnitureplan.registry.BlockRegistration;
import nowebsite.maker.furnitureplan.utils.RCube;
import nowebsite.maker.furnitureplan.utils.Vec3Utils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PotHolder extends BaseEntityBlock implements IHorizontalBlock, IColorfulBlock, SimpleWaterloggedBlock {
    private static final RCube N1, E1, S1, W1, N2_1, E2_1, S2_1, W2_1, N2_2_1, E2_2_1, S2_2_1, W2_2_1, N2_2_2, E2_2_2, S2_2_2, W2_2_2, N3, E3, S3, W3;
    static {
        N1 = RCube.create(0.25, 0.4375, 0.0000625, 0.75, 1, 0.49993750000000003);
        E1 = RCube.create(0.5000625, 0.4375, 0.25, 0.9999374999999999, 1, 0.75);
        S1 = RCube.create(0.25, 0.4375, 0.5000625, 0.75, 1, 0.9999374999999999);
        W1 = RCube.create(0.00006250000000007638, 0.4375, 0.25, 0.49993750000000003, 1, 0.75);
        N2_1 = RCube.create(0.25, 0.8125, 0.6250625, 0.75, 1, 0.9999374999999999);
        E2_1 = RCube.create(0.00006250000000007638, 0.8125, 0.25, 0.37493750000000003, 1, 0.75);
        S2_1 = RCube.create(0.25, 0.8125, 0.00006250000000007638, 0.75, 1, 0.37493750000000003);
        W2_1 = RCube.create(0.6250625, 0.8125, 0.25, 0.9999374999999999, 1, 0.75);
        N2_2_1 = RCube.create(0.25, 0, 0.6250625, 0.75, 0.125, 0.9999374999999999);
        E2_2_1 = RCube.create(0.00006250000000007638, 0, 0.25, 0.37493750000000003, 0.125, 0.75);
        S2_2_1 = RCube.create(0.25, 0, 0.00006250000000007638, 0.75, 0.125, 0.37493750000000003);
        W2_2_1 = RCube.create(0.6250625, 0, 0.25, 0.9999374999999999, 0.125, 0.75);
        N2_2_2 = RCube.create(0.25, 0.125, 0.7500625, 0.75, 0.4375, 0.9999374999999999);
        E2_2_2 = RCube.create(0.00006250000000007638, 0.125, 0.25, 0.24993750000000003, 0.4375, 0.75);
        S2_2_2 = RCube.create(0.25, 0.125, 0.00006250000000007638, 0.75, 0.4375, 0.24993750000000003);
        W2_2_2 = RCube.create(0.7500625, 0.125, 0.25, 0.9999374999999999, 0.4375, 0.75);
        N3 = RCube.create(0.25, 0.5, 0.265625, 0.75, 0.9999374999999999, 0.828125);
        E3 = RCube.create(0.171875, 0.5, 0.25, 0.734375, 0.9999374999999999, 0.75);
        S3 = RCube.create(0.25, 0.5, 0.171875, 0.75, 0.9999374999999999, 0.734375);
        W3 = RCube.create(0.265625, 0.5, 0.25, 0.828125, 0.9999374999999999, 0.75);
    }
    private static final MapCodec<PotHolder> CODEC = RecordCodecBuilder.mapCodec(
        potHolderInstance -> potHolderInstance.group(
            propertiesCodec(),
            Codec.INT.fieldOf("colorId").forGetter(holder -> holder.colorId)
        ).apply(potHolderInstance, PotHolder::new)
    );
    public static final EnumProperty<Direction> FACING = HorizontalDirectionalBlock.FACING;
    public static final EnumProperty<PotHolderPart> PART = BlockRegistration.BlockStateRegistration.POT_HOLDER_PART;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    private final int colorId;
    public PotHolder(@NotNull Properties properties, int id) {
        super(properties.mapColor(COLOR_LIST.get(id)));
        this.colorId = id;
        this.registerDefaultState(this.getStateDefinition().any().setValue(PART, PotHolderPart.BASE));
    }
    @Override
    protected @NotNull MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }
    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return new PotHolderBlockEntity(pos, state);
    }

    @Override
    protected @NotNull InteractionResult useWithoutItem(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull BlockHitResult hitResult) {
        if (!level.isClientSide && level.getBlockEntity(pos) instanceof PotHolderBlockEntity blockEntity) {
            Direction facing = state.getValue(FACING);
            boolean isFoot = state.getValue(PART).equals(PotHolderPart.BASE);
            Vec3 hit = hitResult.getLocation().subtract(pos.getX(), pos.getY(), pos.getZ());

            for (int i = 0; i < 3; i++){
                if (Vec3Utils.isInBox(hit, switchBox(facing, i, isFoot))) {
                    if (i == 1 && !isFoot) {
                        if (level.getBlockEntity(pos.below()) instanceof PotHolderBlockEntity blockEntity1) blockEntity = blockEntity1;
                        else return InteractionResult.FAIL;
                    }
                    if (blockEntity.tryDropSth(i)) return InteractionResult.SUCCESS;
                }
            }
            return InteractionResult.PASS;
        }
        return super.useWithoutItem(state, level, pos, player, hitResult);
    }

    @Override
    protected @NotNull ItemInteractionResult useItemOn(@NotNull ItemStack stack, @NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hitResult) {
        if (!level.isClientSide && level.getBlockEntity(pos) instanceof PotHolderBlockEntity blockEntity) {
            Direction facing = state.getValue(FACING);
            boolean isFoot = state.getValue(PART).equals(PotHolderPart.BASE);
            Vec3 hit = hitResult.getLocation().subtract(pos.getX(), pos.getY(), pos.getZ());

            for (int i = 0; i < 3; i++){
                if (Vec3Utils.isInBox(hit, switchBox(facing, i, isFoot))) {
                    if (i == 1 && !isFoot) {
                        if (level.getBlockEntity(pos.below()) instanceof PotHolderBlockEntity blockEntity1) blockEntity = blockEntity1;
                        else return ItemInteractionResult.FAIL;
                    }
                    if (stack.is(Items.FLOWER_POT) && blockEntity.setPotAt(i, true)) {
                        if (!player.getAbilities().instabuild) stack.shrink(1);
                        return ItemInteractionResult.SUCCESS;
                    } else if (stack.getItem() instanceof BlockItem blockItem && blockEntity.setPlantAt(i, blockItem)) {
                        if (!player.getAbilities().instabuild) stack.shrink(1);
                        return ItemInteractionResult.SUCCESS;
                    }
                }
            }
            return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        }
        return super.useItemOn(stack, state, level, pos, player, hand, hitResult);
    }
    @Override
    protected @NotNull List<ItemStack> getDrops(@NotNull BlockState state, LootParams.@NotNull Builder params) {
        if (state.getValue(PART).equals(PotHolderPart.HEAD)) return List.of();
        return super.getDrops(state, params);
    }
    @Override
    public @NotNull BlockState playerWillDestroy(@NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState state, @NotNull Player player) {
        if (!level.isClientSide && player.isCreative()) {
            PotHolderPart part = state.getValue(PART);
            if (part == PotHolderPart.BASE) {
                BlockPos blockpos = pos.relative(Direction.DOWN.getOpposite());
                BlockState blockstate = level.getBlockState(blockpos);
                if (blockstate.is(this) && blockstate.getValue(PART) == PotHolderPart.HEAD) {
                    level.setBlock(blockpos, Blocks.AIR.defaultBlockState(), 35);
                    spawnDestroyParticles(level, player, blockpos, blockstate);
                }
            }
        }
        return super.playerWillDestroy(level, pos, state, player);
    }
    @Override
    public void setPlacedBy(@NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState state, @Nullable LivingEntity placer, @NotNull ItemStack stack) {
        super.setPlacedBy(level, pos, state, placer, stack);
        if (!level.isClientSide) {
            BlockPos blockpos = pos.relative(Direction.DOWN.getOpposite());
            level.setBlock(blockpos, state.setValue(PART, PotHolderPart.HEAD), 3);
            level.blockUpdated(pos, Blocks.AIR);
            state.updateNeighbourShapes(level, pos, 3);
        }
    }
    private List<RCube> switchBox(Direction direction, int index, boolean isFoot) {
        if (index == 0 && isFoot) {
            return switch (direction) {
                case NORTH -> List.of(N1);
                case EAST -> List.of(E1);
                case SOUTH -> List.of(S1);
                case WEST -> List.of(W1);
                default -> List.of();
            };
        } else if (index == 1) {
            if (isFoot) {
                return switch (direction) {
                    case NORTH -> List.of(N2_1);
                    case EAST -> List.of(E2_1);
                    case SOUTH -> List.of(S2_1);
                    case WEST -> List.of(W2_1);
                    default -> List.of();
                };
            }else {
                return switch (direction) {
                    case NORTH -> List.of(N2_2_1, N2_2_2);
                    case EAST -> List.of(E2_2_1, E2_2_2);
                    case SOUTH -> List.of(S2_2_1, S2_2_2);
                    case WEST -> List.of(W2_2_1, W2_2_2);
                    default -> List.of();
                };
            }
        } else if (index == 2 && !isFoot){
            return switch (direction) {
                case NORTH -> List.of(N3);
                case EAST -> List.of(E3);
                case SOUTH -> List.of(S3);
                case WEST -> List.of(W3);
                default -> List.of();
            };
        } else return List.of();
    }

    @Override
    protected boolean canSurvive(@NotNull BlockState state, @NotNull LevelReader level, @NotNull BlockPos pos) {
        if (state.getValue(PART).equals(PotHolderPart.BASE)) return BaseSmallHallBasedBlock.needsDownsideSupport(level, pos);
        return super.canSurvive(state, level, pos);
    }
    @Override
    protected @NotNull BlockState updateShape(@NotNull BlockState state, @NotNull Direction facing, @NotNull BlockState facingState, @NotNull LevelAccessor level, @NotNull BlockPos currentPos, @NotNull BlockPos facingPos) {
        if (facing == Direction.DOWN && !this.canSurvive(state, level, currentPos)) return Blocks.AIR.defaultBlockState();
        if (state.getValue(WATERLOGGED)) level.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        if (facing == getNeighbourDirection(state.getValue(PART))) {
            return facingState.is(this) && facingState.getValue(PART) != state.getValue(PART)
                ? state
                : Blocks.AIR.defaultBlockState();
        } else {
            return super.updateShape(state, facing, facingState, level, currentPos, facingPos);
        }
    }
    private static Direction getNeighbourDirection(PotHolderPart part) {
        return part == PotHolderPart.BASE ? Direction.UP : Direction.UP.getOpposite();
    }
    @Override
    protected void onRemove(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState newState, boolean movedByPiston) {
        if (newState.isAir()) {
            if (level.getBlockEntity(pos) instanceof PotHolderBlockEntity blockEntity){
                blockEntity.dropAll();
            }
        }
        super.onRemove(state, level, pos, newState, movedByPiston);
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder) {
        builder.add(FACING, PART, WATERLOGGED);
    }
    @Override
    public BlockState getStateForPlacement(@NotNull BlockPlaceContext context) {
        BlockState blockState = super.getStateForPlacement(context);
        blockState =
            blockState == null ?
                defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite())
                :
                blockState.setValue(FACING, context.getHorizontalDirection().getOpposite());
        return blockState.setValue(WATERLOGGED, context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER);
    }
    @Override
    protected @NotNull FluidState getFluidState(@NotNull BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }
    @Override
    protected @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return getOcclusionShape(state, level, pos);
    }
    @Override
    protected @NotNull VoxelShape getOcclusionShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos) {
        return state.getValue(PART).getOccModel(state, level, pos);
    }
    @SuppressWarnings("deprecation")
    @Override
    protected @NotNull RenderShape getRenderShape(@NotNull BlockState state) {
        return RenderShape.MODEL;
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
    @Override
    public int getId() {
        return colorId;
    }
}
