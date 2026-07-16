package nowebsite.maker.furnitureplan.common.block.surfacing;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
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
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import nowebsite.maker.furnitureplan.FurniturePlan;
import nowebsite.maker.furnitureplan.common.block.abstraction.BlockSetGetter;
import nowebsite.maker.furnitureplan.common.block.abstraction.MulStateGetter;
import nowebsite.maker.furnitureplan.common.block.abstraction.definition.PotHolderPart;
import nowebsite.maker.furnitureplan.common.block.abstraction.generators.HorizontalMulStateBDG;
import nowebsite.maker.furnitureplan.common.block.abstraction.set.FPBlockSetType;
import nowebsite.maker.furnitureplan.common.block.abstraction.set.FPBlockType;
import nowebsite.maker.furnitureplan.common.block.abstraction.set.FPColorfulSetType;
import nowebsite.maker.furnitureplan.common.block.surfacing.entity.PotHolderBlockEntity;
import nowebsite.maker.furnitureplan.common.data.gen.empowered.AutoGenBlockData;
import nowebsite.maker.furnitureplan.common.data.gen.empowered.BlockDataGenerator;
import nowebsite.maker.furnitureplan.common.init.FPBlockReg;
import nowebsite.maker.furnitureplan.common.init.FPTags;
import nowebsite.maker.furnitureplan.utils.Interaction.InteractionSpace;
import nowebsite.maker.furnitureplan.utils.Interaction.Vec3Utils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PotHolderBlock extends BaseEntityBlock implements SimpleWaterloggedBlock, AutoGenBlockData<@NotNull PotHolderBlock>, BlockSetGetter, MulStateGetter<PotHolderPart> {
    private static final InteractionSpace IR1, IR2_1, IR2_2_1, IR2_2_2, IR3;
    static {
        IR1 = InteractionSpace.create(0.25, 0.4375, 0.0000625, 0.75, 1, 0.4999375);
        IR2_1 = InteractionSpace.create(0.25, 0.8125, 0.6250625, 0.75, 1, 0.9999375);
        IR2_2_1 = InteractionSpace.create(0.25, 0, 0.6250625, 0.75, 0.125, 0.9999375);
        IR2_2_2 = InteractionSpace.create(0.25, 0.125, 0.7500625, 0.75, 0.4375, 0.9999375);
        IR3 = InteractionSpace.create(0.25, 0.5, 0.265625, 0.75, 0.9999375, 0.828125);
    }
    private final MapCodec<PotHolderBlock> codec;
    public static final EnumProperty<@NotNull Direction> FACING = HorizontalDirectionalBlock.FACING;
    public static final EnumProperty<@NotNull PotHolderPart> PART = FPBlockReg.BlockStateReg.POT_HOLDER_PART;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    private final int colorId;
    private final FPColorfulSetType type;
    public PotHolderBlock(FPColorfulSetType type, Properties properties) {
        super(properties.mapColor(type.getColor().getMapColor()));
        this.colorId = type.getColor().getId();
        this.type = type;
        this.registerDefaultState(this.getStateDefinition().any().setValue(PART, PotHolderPart.BASE).setValue(WATERLOGGED, false));
        this.codec = RecordCodecBuilder.mapCodec(
            potHolderInstance -> potHolderInstance.group(
                propertiesCodec(),
                Codec.INT.fieldOf("colorId").forGetter(holder -> holder.colorId)
            ).apply(potHolderInstance, (_, _) -> new PotHolderBlock(type, properties))
        );
    }
    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return codec;
    }
    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new PotHolderBlockEntity(pos, state);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (level.isClientSide()) return InteractionResult.CONSUME;
        if (level.getBlockEntity(pos) instanceof PotHolderBlockEntity blockEntity) {
            Direction facing = state.getValue(FACING);
            boolean isFoot = state.getValue(PART).equals(PotHolderPart.BASE);
            Vec3 hit = hitResult.getLocation().subtract(pos.getX(), pos.getY(), pos.getZ());

            for (int i = 0; i < 3; i++){
                if (Vec3Utils.isInBox(hit, switchBox(i, isFoot), facing)) {
                    if (i == 1 && !isFoot) {
                        if (level.getBlockEntity(pos.below()) instanceof PotHolderBlockEntity blockEntity1) blockEntity = blockEntity1;
                        else return InteractionResult.FAIL;
                    }
                    if (blockEntity.tryDropSth(i)) return InteractionResult.SUCCESS_SERVER;
                }
            }
            return InteractionResult.PASS;
        }
        return super.useWithoutItem(state, level, pos, player, hitResult);
    }

    @Override
    protected InteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (level.isClientSide()) return InteractionResult.CONSUME;
        if (level.getBlockEntity(pos) instanceof PotHolderBlockEntity blockEntity) {
            Direction facing = state.getValue(FACING);
            boolean isFoot = state.getValue(PART).equals(PotHolderPart.BASE);
            Vec3 hit = hitResult.getLocation().subtract(pos.getX(), pos.getY(), pos.getZ());

            for (int i = 0; i < 3; i++){
                if (Vec3Utils.isInBox(hit, switchBox(i, isFoot), facing)) {
                    if (i == 1 && !isFoot) {
                        if (level.getBlockEntity(pos.below()) instanceof PotHolderBlockEntity blockEntity1) blockEntity = blockEntity1;
                        else return InteractionResult.FAIL;
                    }
                    if (stack.is(Items.FLOWER_POT) && blockEntity.setPotAt(i, true)) {
                        if (!player.getAbilities().instabuild) stack.shrink(1);
                        return InteractionResult.SUCCESS_SERVER;
                    } else if (stack.getItem() instanceof BlockItem blockItem && blockEntity.setPlantAt(i, blockItem)) {
                        if (!player.getAbilities().instabuild) stack.shrink(1);
                        return InteractionResult.SUCCESS_SERVER;
                    }
                }
            }
            return InteractionResult.TRY_WITH_EMPTY_HAND;
        }
        return super.useItemOn(stack, state, level, pos, player, hand, hitResult);
    }
    @Override
    protected List<ItemStack> getDrops(BlockState state, LootParams.Builder params) {
        if (state.getValue(PART).equals(PotHolderPart.HEAD)) return List.of();
        return super.getDrops(state, params);
    }
    @Override
    public BlockState playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
        if (!level.isClientSide() && player.isCreative()) {
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
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        super.setPlacedBy(level, pos, state, placer, stack);
        if (!level.isClientSide()) {
            BlockPos blockpos = pos.above();
            BlockState newState = defaultBlockState().setValue(PART, PotHolderPart.HEAD).setValue(FACING, state.getValue(FACING));
            if (level.getBlockState(blockpos).is(Blocks.WATER)) newState = newState.setValue(WATERLOGGED, true);
            level.setBlock(blockpos, newState, Block.UPDATE_ALL);
            state.updateNeighbourShapes(level, pos, Block.UPDATE_ALL);
        }
    }

    private List<InteractionSpace> switchBox(int index, boolean isFoot) {
        if (index == 0 && isFoot) return List.of(IR1);

        else if (index == 1) {
            if (isFoot) return List.of(IR2_1);
            else return List.of(IR2_2_1, IR2_2_2);
        }

        else if (index == 2 && !isFoot) return List.of(IR3);

        else return List.of();
    }

    @Override
    protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        if (state.getValue(PART).equals(PotHolderPart.BASE)) return canSupportCenter(level, pos.below(), Direction.UP);
        return super.canSurvive(state, level, pos);
    }

    @Override
    protected BlockState updateShape(BlockState state, LevelReader level, ScheduledTickAccess ticks, BlockPos currentPos, Direction directionToNeighbour, BlockPos neighbourPos, BlockState neighbourState, RandomSource random) {
        if (directionToNeighbour == Direction.DOWN && !this.canSurvive(state, level, currentPos)) return Blocks.AIR.defaultBlockState();
        if (state.getValue(WATERLOGGED)) ticks.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        if (directionToNeighbour == getNeighbourDirection(state.getValue(PART))) {
            return neighbourState.is(this) && neighbourState.getValue(PART) != state.getValue(PART)
                ? state
                : Blocks.AIR.defaultBlockState();
        } else {
            return super.updateShape(state, level, ticks, currentPos, directionToNeighbour, neighbourPos, neighbourState, random);
        }
    }

    private static Direction getNeighbourDirection(PotHolderPart part) {
        return part == PotHolderPart.BASE ? Direction.UP : Direction.UP.getOpposite();
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, @NotNull BlockState> builder) {
        builder.add(FACING, PART, WATERLOGGED);
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
    protected FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }
    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return state.getValue(PART).getOccModel(state);
    }

    @Override
    public FPBlockSetType getType() {
        return type;
    }

    @Override
    public EnumProperty<@NotNull PotHolderPart> getContainer() {
        return PART;
    }

    @Override
    public @Nullable BlockDataGenerator<? super PotHolderBlock> getGenerator() {
        return new HorizontalMulStateBDG<>() {
            @Override
            public FPBlockType<? extends @NotNull PotHolderBlock> getTemplateType(PotHolderBlock block) {
                return FPBlockType.POT_HOLDER;
            }

            @Override
            public void addBlockTags(PotHolderBlock block, BlockTagsProvider provider, List<TagKey<Block>> keys) {
                super.addBlockTags(block, provider, keys);
                keys.add(FPTags.POT_HOLDER_BLOCK);
            }

            @Override
            public Identifier getItemTemplate() {
                return FurniturePlan.asResource("item/pot_holder");
            }
        };
    }
}
