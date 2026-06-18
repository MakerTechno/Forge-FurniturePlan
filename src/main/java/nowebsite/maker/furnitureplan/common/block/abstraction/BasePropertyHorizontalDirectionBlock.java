package nowebsite.maker.furnitureplan.common.block.abstraction;

import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import nowebsite.maker.furnitureplan.common.block.abstraction.set.FPBlockSetType;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public abstract class BasePropertyHorizontalDirectionBlock<T extends BasePropertyHorizontalDirectionBlock<T>> extends BasePropertyExtendedBlock<T> implements SimpleWaterloggedBlock {
    public static final EnumProperty<@NotNull Direction> FACING = BlockStateProperties.HORIZONTAL_FACING;

    public BasePropertyHorizontalDirectionBlock(FPBlockSetType type, BlockState state, Consumer<Properties> extraProperties) {
        super(type, state, extraProperties);
        registerDefaultState(stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    /**
     * 仅供给CODEC使用
     */
    public BasePropertyHorizontalDirectionBlock(FPBlockSetType type, BlockState state, Properties properties) {
        super(type, state, properties);
        registerDefaultState(stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    @Override
    @NotNull
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return super.getStateForPlacement(context).setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, @NotNull BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(FACING);
    }

    @Override
    protected BlockState rotate(BlockState state, Rotation rot) {
        return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
    }

    @SuppressWarnings("deprecation")
    @Override
    protected BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }
}
