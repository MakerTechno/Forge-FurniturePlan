package nowebsite.maker.furnitureplan.registry;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import nowebsite.maker.furnitureplan.FurniturePlan;

import java.util.HashMap;
import java.util.Map;

public class SheetReference {
    public static final ResourceLocation CUPBOARD = ResourceLocation.fromNamespaceAndPath(FurniturePlan.MOD_ID,"textures/block/cupboard.png");
    public static final Map<Block, Block> COPPER_TRANS_LIST = new HashMap<>();
    static {
        COPPER_TRANS_LIST.put(Blocks.WAXED_CUT_COPPER, Blocks.CUT_COPPER);
        COPPER_TRANS_LIST.put(Blocks.WAXED_WEATHERED_CUT_COPPER, Blocks.WEATHERED_CUT_COPPER);
        COPPER_TRANS_LIST.put(Blocks.WAXED_OXIDIZED_CUT_COPPER, Blocks.OXIDIZED_CUT_COPPER);
        COPPER_TRANS_LIST.put(Blocks.WAXED_EXPOSED_CUT_COPPER, Blocks.EXPOSED_CUT_COPPER);
    }
}
