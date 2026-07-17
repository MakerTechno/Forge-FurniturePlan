package nowebsite.maker.furnitureplan.common.block.abstraction;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import nowebsite.maker.furnitureplan.common.block.abstraction.set.FPBlockSetType;
import nowebsite.maker.furnitureplan.common.data.gen.empowered.AutoGenBlockData;
import nowebsite.maker.furnitureplan.common.init.FPBlockSetTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

/**
 * 基础的多种材料属性的变体方块，预留了很多有关生成的方法。
 */
public abstract class BasePropertyExtendedBlock<T extends BasePropertyExtendedBlock<T>> extends Block implements SimpleWaterloggedBlock, BlockSetGetter, AutoGenBlockData<@NotNull T> {
    public final MapCodec<BasePropertyExtendedBlock<T>> codec = RecordCodecBuilder.mapCodec(
            instance -> instance.group(
                    BlockState.CODEC.fieldOf("base_state").forGetter(block -> block.baseState),
                    propertiesCodec()
            ).apply(instance, this::createNewInstance)
    );
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public final Block base;
    protected final BlockState baseState;
    private final FPBlockSetType type;

    @SuppressWarnings("deprecation")
    public static Properties calcProperties(FPBlockSetType type, Block block, Consumer<Properties> extraPropApplier) {
        Properties newProp = Properties.ofLegacyCopy(block);
        newProp = FPBlockSetTypes.isTranslucent(type) ? newProp.noOcclusion() : newProp;
        extraPropApplier.accept(newProp);
        return newProp;
    }

    public BasePropertyExtendedBlock(FPBlockSetType type, BlockState state, Consumer<Properties> extraProperties) {
        super(calcProperties(type, state.getBlock(), extraProperties));
        this.type = type;
        this.base = state.getBlock();
        this.baseState = state;
        registerDefaultState(stateDefinition.any().setValue(BlockStateProperties.WATERLOGGED, false));
    }

    /**
     * 仅供给CODEC使用
     */
    public BasePropertyExtendedBlock(FPBlockSetType type, BlockState state, Properties properties) {
        super(FPBlockSetTypes.isTranslucent(type) ? properties.noOcclusion() : properties);
        this.type = type;
        this.base = state.getBlock();
        this.baseState = state;
        registerDefaultState(stateDefinition.any().setValue(BlockStateProperties.WATERLOGGED, false));
    }

    @Override
    protected BlockState updateShape(BlockState state, LevelReader level, ScheduledTickAccess ticks, BlockPos pos, Direction directionToNeighbour, BlockPos neighbourPos, BlockState neighbourState, RandomSource random) {
        if (state.getValue(WATERLOGGED)) {
            ticks.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }
        return super.updateShape(state, level, ticks, pos, directionToNeighbour, neighbourPos, neighbourState, random);
    }

    @Override
    protected boolean propagatesSkylightDown(BlockState state) {
        return !state.getValue(WATERLOGGED);
    }

    @Override
    public FluidState getFluidState(BlockState pState) {
        return pState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pState);
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState blockState = super.getStateForPlacement(context);
        return
            blockState == null ?
                defaultBlockState().setValue(WATERLOGGED, context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER)
                :
                blockState.setValue(WATERLOGGED, context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, @NotNull BlockState> builder) {
        builder.add(WATERLOGGED);
    }

    @SuppressWarnings("deprecation")
    @Override
    public float getExplosionResistance() {
        return this.base.getExplosionResistance();
    }


    @Override
    protected boolean isPathfindable(BlockState state, PathComputationType pathComputationType) {
        return false;
    }

    @Override
    protected MapCodec<? extends Block> codec() {
        return codec;
    }

    protected abstract BasePropertyExtendedBlock<T> createNewInstance(BlockState baseState, Properties properties);

    public FPBlockSetType getType() {
        return type;
    }

}
