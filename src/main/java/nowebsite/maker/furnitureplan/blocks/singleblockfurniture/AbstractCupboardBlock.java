package nowebsite.maker.furnitureplan.blocks.singleblockfurniture;

import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public abstract class AbstractCupboardBlock<BE extends BlockEntity> extends BaseEntityBlock {
    protected final Supplier<BlockEntityType<? extends BE>> blockEntityType;
    protected AbstractCupboardBlock(Properties properties, Supplier<BlockEntityType<? extends BE>> blockEntityType) {
        super(properties);
        this.blockEntityType = blockEntityType;
    }

}
