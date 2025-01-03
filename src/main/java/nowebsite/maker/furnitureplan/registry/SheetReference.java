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
    public static final Map<Block, ResourceLocation> FIX_TRANS_LIST = new HashMap<>();
    static {
        FIX_TRANS_LIST.put(Blocks.QUARTZ_BLOCK, ResourceLocation.parse("block/quartz_block_top"));
        FIX_TRANS_LIST.put(Blocks.SMOOTH_RED_SANDSTONE, ResourceLocation.parse("block/red_sandstone_top"));
        FIX_TRANS_LIST.put(Blocks.SMOOTH_SANDSTONE, ResourceLocation.parse("block/sandstone_top"));
        FIX_TRANS_LIST.put(Blocks.SMOOTH_QUARTZ, ResourceLocation.parse("block/quartz_block_bottom"));
    }
}
