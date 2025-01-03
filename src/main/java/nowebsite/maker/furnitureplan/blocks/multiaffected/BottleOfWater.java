package nowebsite.maker.furnitureplan.blocks.multiaffected;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
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
    protected @NotNull BlockState updateShape(@NotNull BlockState state, @NotNull Direction direction, @NotNull BlockState neighborState, @NotNull LevelAccessor level, @NotNull BlockPos pos, @NotNull BlockPos neighborPos) {
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
        return getOcclusionShape(state, level, pos);
    }

    @Override
    protected @NotNull VoxelShape getOcclusionShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos) {
        return state.getValue(REF).getOccModel(state, level, pos);
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
