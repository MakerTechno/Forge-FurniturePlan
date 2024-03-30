package nowebsite.maker.furnitureplan.items;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import nowebsite.maker.furnitureplan.blocks.single.blockentities.CupboardBlockEntity;

import java.util.function.Supplier;

public class CupboardItem extends BaseBERBlockItem<CupboardBlockEntity> {

    public CupboardItem(Block pBlock, Properties pProperties) {
        super(pBlock, pProperties);
    }

    @Override
    public Supplier<CupboardBlockEntity> getBE() {
        return () -> new CupboardBlockEntity(BlockPos.ZERO, getBlock().defaultBlockState());
    }
}
