package nowebsite.maker.furnitureplan.blocks.singleblockfurniture.blockentities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.registries.DeferredHolder;
import nowebsite.maker.furnitureplan.blocks.singleblockfurniture.BenchBlock;
import org.jetbrains.annotations.NotNull;

public class BenchBlockEntity extends BaseSittableBE<BenchBlockEntity> {
    public BenchBlockEntity(@NotNull DeferredHolder<BlockEntityType<?>, BlockEntityType<BenchBlockEntity>> type, BlockPos pos, BlockState blockState) {
        super(type, pos, blockState);
    }
    @Override
    void newOneFromBlock() {
        if (containerBlock.getBlock() instanceof BenchBlock benchBlock){
            benchBlock.newBlockEntity(this.getBlockPos(), containerBlock);
        }
    }

    @Override
    double getYSvOffset() {
        return 0.35;
    }
}
