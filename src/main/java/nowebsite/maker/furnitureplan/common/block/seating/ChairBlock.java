package nowebsite.maker.furnitureplan.common.block.seating;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import nowebsite.maker.furnitureplan.FurniturePlan;
import nowebsite.maker.furnitureplan.common.block.abstraction.BasePropertyHorizontalDirectionBlock;
import nowebsite.maker.furnitureplan.common.block.abstraction.be.BaseSittableBE;
import nowebsite.maker.furnitureplan.common.block.abstraction.generators.HorizontalBDG;
import nowebsite.maker.furnitureplan.common.block.abstraction.set.FPBlockSetType;
import nowebsite.maker.furnitureplan.common.block.abstraction.set.FPBlockType;
import nowebsite.maker.furnitureplan.common.block.seating.entity.ChairBlockEntity;
import nowebsite.maker.furnitureplan.common.data.gen.empowered.BlockDataGenerator;
import nowebsite.maker.furnitureplan.common.init.FPTags;
import nowebsite.maker.furnitureplan.utils.voxel.IVoxelHolder;
import nowebsite.maker.furnitureplan.utils.voxel.VoxelShapeBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.function.Consumer;


public class ChairBlock extends BasePropertyHorizontalDirectionBlock<ChairBlock> implements EntityBlock {
    public static final IVoxelHolder SHAPE = VoxelShapeBuilder.ofYRot()
        .or(0.125, 0, 0.125, 0.25, 0.3125, 0.25)
        .or(0.125, 0, 0.75, 0.25, 0.3125, 0.875)
        .or(0.75, 0, 0.125, 0.875, 0.3125, 0.25)
        .or(0.75, 0, 0.6875, 0.875, 0.3125, 0.8125)
        .or(0, 0.3125, 0, 1, 0.4375, 1)
        .or(0.25, 0.4375, 0.875, 0.375, 0.5625, 1)
        .or(0.625, 0.4375, 0.875, 0.75, 0.5625, 1)
        .or(0, 0.5625, 0.875, 1, 1, 1)
        .build();
    public final float yOff;

    public ChairBlock(FPBlockSetType type, BlockState state, Consumer<Properties> extraProperties, float yOff) {
        super(type, state, extraProperties);
        this.yOff = yOff;
    }

    /**
     * 仅供给CODEC使用
     */
    public ChairBlock(FPBlockSetType type, BlockState state, Properties properties, float yOff) {
        super(type, state, properties);
        this.yOff = yOff;
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext collisionContext) {
        return SHAPE.getShape(state.getValue(FACING));
    }

    @Override
    protected boolean useShapeForLightOcclusion(BlockState state) {
        return true;
    }

/*  When the behavior goes wrong, check if parent class still use this.

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }
*/

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (level.isClientSide()) return InteractionResult.PASS;
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (!(blockEntity instanceof ChairBlockEntity chairBlock)) {
            FurniturePlan.LOGGER.error("ChairBE block entity is missing, it's an unexpected state.");
            return InteractionResult.FAIL;
        }
        return chairBlock.useAct(level, pos, player);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new ChairBlockEntity(blockPos, blockState);
    }

    @Override
    @Nullable
    public <E extends BlockEntity> BlockEntityTicker<E> getTicker(Level level, BlockState state, BlockEntityType<E> blockEntityType) {
        return level.isClientSide() ? null : (_, _, _, t) -> {
            if (t instanceof BaseSittableBE<?> blockEntity) blockEntity.tickAtServer();
        };
    }

    @Override
    protected BasePropertyHorizontalDirectionBlock<ChairBlock> createNewInstance(BlockState baseState, Properties properties) {
        return new ChairBlock(getType(), baseState, properties, yOff);
    }

    @Override
    public @Nullable BlockDataGenerator<? super ChairBlock> getGenerator() {
        return new HorizontalBDG<>() {
            @Override
            public FPBlockType<? extends @NotNull ChairBlock> getTemplateType(ChairBlock block) {
                return getBlockType();
            }

            @Override
            public void addBlockTags(ChairBlock block, BlockTagsProvider provider, HashSet<TagKey<Block>> keys) {
                super.addBlockTags(block, provider, keys);
                keys.add(FPTags.CHAIR_BLOCK);
            }
        };
    }

    public FPBlockType<? extends @NotNull ChairBlock> getBlockType() {
        return FPBlockType.CHAIR;
    }

}
