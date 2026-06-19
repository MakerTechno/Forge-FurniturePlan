package nowebsite.maker.furnitureplan.common.block.seating;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import nowebsite.maker.furnitureplan.FurniturePlan;
import nowebsite.maker.furnitureplan.common.block.abstraction.BasePropertyExtendedBlock;
import nowebsite.maker.furnitureplan.common.block.abstraction.generators.DefaultBlockDataGenerator;
import nowebsite.maker.furnitureplan.common.block.abstraction.set.FPBlockSetType;
import nowebsite.maker.furnitureplan.common.block.abstraction.set.FPBlockType;
import nowebsite.maker.furnitureplan.common.block.seating.entity.BenchBlockEntity;
import nowebsite.maker.furnitureplan.common.block.seating.entity.ChairBlockEntity;
import nowebsite.maker.furnitureplan.common.data.gen.empowered.BlockDataGenerator;
import nowebsite.maker.furnitureplan.common.init.FPTags;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.Objects;

public class BenchBlock extends BasePropertyExtendedBlock<BenchBlock> implements EntityBlock {

    public static final VoxelShape SHAPE = Shapes.or(
        Shapes.box(0.75, 0, 0.75, 0.875, 0.25, 0.875),
        Shapes.box(0.125, 0, 0.75, 0.25, 0.25, 0.875),
        Shapes.box(0.125, 0, 0.125, 0.25, 0.25, 0.25),
        Shapes.box(0.0625, 0.25, 0.0625, 0.9375, 0.375, 0.9375),
        Shapes.box(0.75, 0, 0.125, 0.875, 0.25, 0.25)
    );

    public final FPBlockSetType type;

    public BenchBlock(FPBlockSetType type, @NotNull BlockState state, BlockBehaviour.Properties properties) {
        super(type, state, properties);
        this.type = type;
        this.registerDefaultState(this.getStateDefinition().any().setValue(WATERLOGGED, Boolean.FALSE));
    }

    @Override
    public boolean useShapeForLightOcclusion(@NotNull BlockState pState) {
        return true;
    }

    @Override
    protected BasePropertyExtendedBlock<BenchBlock> createNewInstance(BlockState baseState, BlockBehaviour.Properties properties) {
        return new BenchBlock(type, baseState, properties);
    }

    @Override
    public void destroy(@NotNull LevelAccessor level, @NotNull BlockPos pos, @NotNull BlockState state) {
        try {
            Objects.requireNonNull(level.getBlockEntity(pos)).setRemoved();
        } catch (Exception ignore) {}
        super.destroy(level, pos, state);
    }

    @Override
    protected @NotNull InteractionResult useItemOn(@NotNull ItemStack stack, @NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hitResult) {
        return InteractionResult.PASS;
    }

    @Override
    protected @NotNull InteractionResult useWithoutItem(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull BlockHitResult hitResult) {
        if (level.isClientSide()) return InteractionResult.CONSUME;
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (!(blockEntity instanceof BenchBlockEntity benchBlock)) {
            FurniturePlan.LOGGER.error("ChairBE block entity is missing, it's an unexpected state.");
            return InteractionResult.FAIL;
        }
        return benchBlock.useAct(level, pos, player);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(@NotNull Level level, @NotNull BlockState state, @NotNull BlockEntityType<T> blockEntityType) {
        return level.isClientSide() ? null : (_, _, _, t) -> {
            if (t instanceof BenchBlockEntity blockEntity) blockEntity.tickAtServer();
        };
    }
    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return new BenchBlockEntity(pos, state);
    }

    @Override
    public @Nullable BlockDataGenerator<? super @NotNull BenchBlock> getGenerator() {
        return new DefaultBlockDataGenerator<>() {
            @Override
            public FPBlockType<? extends @NotNull BenchBlock> getTemplateType(@NotNull BenchBlock block) {
                return FPBlockType.BENCH;
            }

            @Override
            public void addBlockTags(@NotNull BenchBlock block, BlockTagsProvider provider, HashSet<TagKey<Block>> keys) {
                super.addBlockTags(block, provider, keys);
                keys.add(FPTags.BENCH_BLOCK);
            }
        };
    }
}
