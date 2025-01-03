package nowebsite.maker.furnitureplan.blocks.columns;

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
