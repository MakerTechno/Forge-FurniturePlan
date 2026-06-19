package nowebsite.maker.furnitureplan.common.block.seating.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import nowebsite.maker.furnitureplan.common.block.abstraction.be.BaseSittableBE;
import nowebsite.maker.furnitureplan.common.block.seating.ChairBlock;
import nowebsite.maker.furnitureplan.common.init.FPBlockReg;
import org.jetbrains.annotations.NotNull;

public class ChairBlockEntity extends BaseSittableBE<@NotNull ChairBlockEntity> {

    private double yOffset = 0.0;

    public ChairBlockEntity(BlockEntityType<? extends ChairBlockEntity> type, BlockPos pos, BlockState blockState) {
        super(type, pos, blockState);
        if (blockState.getBlock() instanceof ChairBlock chairBlock) yOffset = chairBlock.yOff;
    }
    public ChairBlockEntity(BlockPos pos, BlockState blockState) {
        super(FPBlockReg.CHAIR_BLOCK_ENTITY.get(), pos, blockState);
        if (blockState.getBlock() instanceof ChairBlock chairBlock) yOffset = chairBlock.yOff;
    }


    @Override
    public double getYSvOffset() {
        return yOffset;
    }
}
