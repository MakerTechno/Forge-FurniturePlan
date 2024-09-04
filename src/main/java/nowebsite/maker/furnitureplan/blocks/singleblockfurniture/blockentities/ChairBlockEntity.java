package nowebsite.maker.furnitureplan.blocks.singleblockfurniture.blockentities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.registries.DeferredHolder;
import nowebsite.maker.furnitureplan.blocks.singleblockfurniture.ChairBlock;
import org.jetbrains.annotations.NotNull;

public class ChairBlockEntity extends BaseSittableBE<ChairBlockEntity> {
    public ChairBlockEntity(@NotNull DeferredHolder<BlockEntityType<?>, BlockEntityType<ChairBlockEntity>> type, BlockPos pos, BlockState blockState) {
        super(type, pos, blockState);
    }
    @Override
    void newOneFromBlock() {
        if (containerBlock.getBlock() instanceof ChairBlock chairBlock){
            chairBlock.newBlockEntity(this.getBlockPos(), containerBlock);
        }
    }

    @Override
    double getYSvOffset() {
        return 0.48;
    }
}
