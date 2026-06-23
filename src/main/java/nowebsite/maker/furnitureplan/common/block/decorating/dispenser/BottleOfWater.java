package nowebsite.maker.furnitureplan.common.block.decorating.dispenser;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import nowebsite.maker.furnitureplan.common.block.abstraction.definition.BottleDefine;
import nowebsite.maker.furnitureplan.common.init.FPBlockReg;
import org.jetbrains.annotations.NotNull;

public class BottleOfWater extends Block {
    public static final EnumProperty<@NotNull BottleDefine> REF = FPBlockReg.BlockStateReg.BOTTLE_DEFINE;
    public BottleOfWater(Properties properties) {
        super(properties);
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, @NotNull BlockState> builder) {
        builder.add(REF);
    }

    @Override
    protected void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean movedByPiston) {
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
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return state.getValue(REF).getOccModel(state);
    }

}
