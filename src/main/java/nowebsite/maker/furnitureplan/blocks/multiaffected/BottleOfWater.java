package nowebsite.maker.furnitureplan.blocks.multiaffected;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import nowebsite.maker.furnitureplan.blocks.func.ILocalDefine;
import nowebsite.maker.furnitureplan.blocks.func.definition.BottleDefine;
import nowebsite.maker.furnitureplan.registry.BlockRegistration;
import org.jetbrains.annotations.NotNull;

public class BottleOfWater extends Block implements ILocalDefine {
    public static final EnumProperty<BottleDefine> REF = BlockRegistration.BlockStateRegistration.BOTTLE_DEFINE;
    public BottleOfWater(Properties properties) {
        super(properties);
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder) {
        builder.add(REF);
    }

    @Override
    protected void onPlace(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState oldState, boolean movedByPiston) {
        super.onPlace(state, level, pos, oldState, movedByPiston);
        level.setBlock(pos, level.getBlockState(pos.below()).getBlock() instanceof WaterDispenser ? state.setValue(REF, BottleDefine.INSERT) : state.setValue(REF, BottleDefine.NORMAL), 35);
    }

    @Override
    protected BlockState updateShape(BlockState state, LevelReader level, ScheduledTickAccess ticks, BlockPos pos, Direction directionToNeighbour, BlockPos neighbourPos, BlockState neighbourState, RandomSource random) {
        super.updateShape(state, level, ticks, pos, directionToNeighbour, neighbourPos, neighbourState, random);
        return (level.getBlockState(pos.below()).getBlock() instanceof WaterDispenser)?
            state.setValue(REF, BottleDefine.INSERT):
            state.setValue(REF, BottleDefine.NORMAL);
    }

    @Override
    public String parentName() {
        return null;
    }

    @Override
    protected @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return state.getValue(REF).getOccModel(state);
    }

    @Override
    public String textureKey() {
        return "particle";
    }
    @Override
    public String textureName() {
        return null;
    }
}
