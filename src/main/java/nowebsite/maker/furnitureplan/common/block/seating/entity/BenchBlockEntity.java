package nowebsite.maker.furnitureplan.common.block.seating.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import nowebsite.maker.furnitureplan.common.block.abstraction.be.BaseSittableBE;
import nowebsite.maker.furnitureplan.common.init.FPBlockReg;
import org.jetbrains.annotations.NotNull;

public class BenchBlockEntity extends BaseSittableBE<@NotNull BenchBlockEntity> {
    public BenchBlockEntity(@NotNull BlockEntityType<@NotNull BenchBlockEntity> type, BlockPos pos, BlockState blockState) {
        super(type, pos, blockState);
    }
    public BenchBlockEntity(BlockPos pos, BlockState blockState) {
        super(FPBlockReg.BENCH_BLOCK_ENTITY.get(), pos, blockState);
    }

    @Override
    public double getYSvOffset() {
        return 0.35;
    }
}
