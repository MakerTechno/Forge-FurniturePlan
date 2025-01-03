package nowebsite.maker.furnitureplan.blocks.singleblockfurniture;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.registries.DeferredHolder;
import nowebsite.maker.furnitureplan.FurniturePlan;
import nowebsite.maker.furnitureplan.blocks.func.BasePropertyBlock;
import nowebsite.maker.furnitureplan.blocks.func.IVarietyBlock;
import nowebsite.maker.furnitureplan.blocks.singleblockfurniture.blockentities.BenchBlockEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

import static nowebsite.maker.furnitureplan.blocks.voxel.VoxelShapeReference.BENCH_VOXEL;

public class BenchBlock extends BasePropertyBlock<BenchBlock> implements EntityBlock, IVarietyBlock {
    public final DeferredHolder<BlockEntityType<?>, BlockEntityType<BenchBlockEntity>> TYPE;
    public BenchBlock(DeferredHolder<BlockEntityType<?>, BlockEntityType<BenchBlockEntity>> type, @NotNull BlockState state, Properties properties) {
        super(state, properties);
        this.TYPE = type;
        this.registerDefaultState(this.getStateDefinition().any().setValue(WATERLOGGED, Boolean.FALSE));
    }
    @Override
    public boolean useShapeForLightOcclusion(@NotNull BlockState pState) {
        return true;
    }
    @Override
    protected BasePropertyBlock<BenchBlock> getSelfNew(BlockState baseState, Properties properties) {
        return new BenchBlock(TYPE, baseState, properties);
    }
    @Override
    public void destroy(@NotNull LevelAccessor level, @NotNull BlockPos pos, @NotNull BlockState state) {
        try {
            Objects.requireNonNull(level.getBlockEntity(pos)).setRemoved();
        } catch (Exception ignore) {}
        super.destroy(level, pos, state);
    }
    @Override
    protected @NotNull ItemInteractionResult useItemOn(@NotNull ItemStack stack, @NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hitResult) {
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }
    @Override
    protected @NotNull InteractionResult useWithoutItem(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull BlockHitResult hitResult) {
        InteractionResult resultA;
        if (!level.isClientSide) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof BenchBlockEntity benchBlock) {
                resultA = benchBlock.useAct(level, pos, player/*, state.getValue(FACING)*/);
            } else {
                FurniturePlan.LOGGER.error("? Where's my bench block entity???");
                resultA = InteractionResult.FAIL;
            }
        } else {
            resultA = InteractionResult.PASS;
        }
        return resultA;
    }
    @Override
    protected @NotNull VoxelShape getOcclusionShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos) {
        return BENCH_VOXEL;
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(@NotNull Level level, @NotNull BlockState state, @NotNull BlockEntityType<T> blockEntityType) {
        return level.isClientSide() ? null : (level1, pos, blockState, t) -> {
            if (t instanceof BenchBlockEntity blockEntity) blockEntity.tickAtServer();
        };
    }
    @Override
    public String parentName() {
        return "bench";
    }
    @Override
    public String getSpecificName() {
        return "bench";
    }
    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return new BenchBlockEntity(this.TYPE, pos, state);
    }
}
