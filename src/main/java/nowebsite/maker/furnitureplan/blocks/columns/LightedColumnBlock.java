package nowebsite.maker.furnitureplan.blocks.columns;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import nowebsite.maker.furnitureplan.blocks.func.BasePropertyBlock;
import nowebsite.maker.furnitureplan.blocks.func.definition.ColumnShape;
import org.jetbrains.annotations.NotNull;

public class LightedColumnBlock extends ColumnBlock {
    public static final BooleanProperty LIT = BlockStateProperties.LIT;

    public LightedColumnBlock(@NotNull BlockState state, Properties properties) {
        super(state, properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(LIT, Boolean.TRUE).setValue(SHAPE, ColumnShape.FULL).setValue(WATERLOGGED, Boolean.FALSE));
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(LIT);
    }
    public void neighborChanged(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Block block, @NotNull BlockPos fromPos, boolean isMoving) {
        if (!level.isClientSide) {
            if (level.hasNeighborSignal(pos)) {
                level.setBlock(pos, state.cycle(LIT), 2);
            } else {
                level.scheduleTick(pos, this, 4);
            }
        }
    }
    @Override
    public BlockState getStateForPlacement(@NotNull BlockPlaceContext context) {
        return this.defaultBlockState().setValue(LIT, context.getLevel().hasNeighborSignal(context.getClickedPos()));
    }
    @Override
    public void tick(@NotNull BlockState state, @NotNull ServerLevel level, @NotNull BlockPos pos, @NotNull RandomSource source) {
        super.tick(state, level, pos, source);
        if (state.getValue(LIT)) {
            level.setBlock(pos, state.cycle(LIT), 2);
        }
    }
    @Override
    public String getSpecificName() {
        return "lighted_" + super.getSpecificName();
    }
    @Override
    public String parentName() {
        return getSpecificName();
    }

    @Override
    protected BasePropertyBlock<ColumnBlock> getSelfNew(BlockState baseState, Properties properties) {
        return new LightedColumnBlock(baseState, properties);
    }
}
