package nowebsite.maker.furnitureplan.common.init;

import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import nowebsite.maker.furnitureplan.FurniturePlan;

public class FPTags {

    public static final ResourceKey<Registry<Object>> FURNITURE_REGISTRY = ResourceKey.createRegistryKey(Identifier.fromNamespaceAndPath(FurniturePlan.MOD_ID, "furniture"));

    public static final TagKey<Object> TEST = TagKey.create(FURNITURE_REGISTRY, Identifier.fromNamespaceAndPath(FurniturePlan.MOD_ID, ""));

    public static final TagKey<Block> OAK_FURNITURE = registerForBlock("oak_furniture");
    public static final TagKey<Block> COBBLESTONE_FURNITURE = registerForBlock("cobblestone_furniture");
    public static final TagKey<Block> BRICK_FURNITURE = registerForBlock("brick_furniture");
    public static final TagKey<Block> STONE_BRICK_FURNITURE = registerForBlock("stone_brick_furniture");
    public static final TagKey<Block> MUD_BRICK_FURNITURE = registerForBlock("mud_brick_furniture");
    public static final TagKey<Block> RESIN_BRICK_FURNITURE = registerForBlock("resin_brick_furniture");
    public static final TagKey<Block> NETHER_BRICK_FURNITURE = registerForBlock("nether_brick_furniture");
    public static final TagKey<Block> SANDSTONE_FURNITURE = registerForBlock("sandstone_furniture");
    public static final TagKey<Block> SPRUCE_FURNITURE = registerForBlock("spruce_furniture");
    public static final TagKey<Block> BIRCH_FURNITURE = registerForBlock("birch_furniture");
    public static final TagKey<Block> JUNGLE_FURNITURE = registerForBlock("jungle_furniture");
    public static final TagKey<Block> QUARTZ_FURNITURE = registerForBlock("quartz_furniture");
    public static final TagKey<Block> ACACIA_FURNITURE = registerForBlock("acacia_furniture");
    public static final TagKey<Block> CHERRY_FURNITURE = registerForBlock("cherry_furniture");
    public static final TagKey<Block> DARK_OAK_FURNITURE = registerForBlock("dark_oak_furniture");
    public static final TagKey<Block> PALE_OAK_FURNITURE = registerForBlock("pale_oak_furniture");
    public static final TagKey<Block> MANGROVE_FURNITURE = registerForBlock("mangrove_furniture");
    public static final TagKey<Block> BAMBOO_FURNITURE = registerForBlock("bamboo_furniture");
    public static final TagKey<Block> BAMBOO_MOSAIC_FURNITURE = registerForBlock("bamboo_mosaic_furniture");
    public static final TagKey<Block> PRISMARINE_FURNITURE = registerForBlock("prismarine_furniture");
    public static final TagKey<Block> PRISMARINE_BRICK_FURNITURE = registerForBlock("prismarine_brick_furniture");
    public static final TagKey<Block> DARK_PRISMARINE_FURNITURE = registerForBlock("dark_prismarine_furniture");
    public static final TagKey<Block> RED_SANDSTONE_FURNITURE = registerForBlock("red_sandstone_furniture");
    public static final TagKey<Block> PURPUR_FURNITURE = registerForBlock("purpur_furniture");
    public static final TagKey<Block> POLISHED_GRANITE_FURNITURE = registerForBlock("polished_granite_furniture");
    public static final TagKey<Block> SMOOTH_RED_SANDSTONE_FURNITURE = registerForBlock("smooth_red_sandstone_furniture");
    public static final TagKey<Block> MOSSY_STONE_BRICK_FURNITURE = registerForBlock("mossy_stone_brick_furniture");
    public static final TagKey<Block> POLISHED_DIORITE_FURNITURE = registerForBlock("polished_diorite_furniture");
    public static final TagKey<Block> MOSSY_COBBLESTONE_FURNITURE = registerForBlock("mossy_cobblestone_furniture");
    public static final TagKey<Block> END_STONE_BRICK_FURNITURE = registerForBlock("end_stone_brick_furniture");
    public static final TagKey<Block> STONE_FURNITURE = registerForBlock("stone_furniture");
    public static final TagKey<Block> SMOOTH_SANDSTONE_FURNITURE = registerForBlock("smooth_sandstone_furniture");
    public static final TagKey<Block> SMOOTH_QUARTZ_FURNITURE = registerForBlock("smooth_quartz_furniture");
    public static final TagKey<Block> GRANITE_FURNITURE = registerForBlock("granite_furniture");
    public static final TagKey<Block> ANDESITE_FURNITURE = registerForBlock("andesite_furniture");
    public static final TagKey<Block> RED_NETHER_BRICK_FURNITURE = registerForBlock("red_nether_brick_furniture");
    public static final TagKey<Block> POLISHED_ANDESITE_FURNITURE = registerForBlock("polished_andesite_furniture");
    public static final TagKey<Block> DIORITE_FURNITURE = registerForBlock("diorite_furniture");
    public static final TagKey<Block> CRIMSON_FURNITURE = registerForBlock("crimson_furniture");
    public static final TagKey<Block> WARPED_FURNITURE = registerForBlock("warped_furniture");
    public static final TagKey<Block> BLACKSTONE_FURNITURE = registerForBlock("blackstone_furniture");
    public static final TagKey<Block> POLISHED_BLACKSTONE_BRICK_FURNITURE = registerForBlock("polished_blackstone_brick_furniture");
    public static final TagKey<Block> POLISHED_BLACKSTONE_FURNITURE = registerForBlock("polished_blackstone_furniture");
    public static final TagKey<Block> TUFF_FURNITURE = registerForBlock("tuff_furniture");
    public static final TagKey<Block> POLISHED_TUFF_FURNITURE = registerForBlock("polished_tuff_furniture");
    public static final TagKey<Block> TUFF_BRICK_FURNITURE = registerForBlock("tuff_brick_furniture");
    public static final TagKey<Block> OXIDIZED_CUT_COPPER_FURNITURE = registerForBlock("oxidized_cut_copper_furniture");
    public static final TagKey<Block> WEATHERED_CUT_COPPER_FURNITURE = registerForBlock("weathered_cut_copper_furniture");
    public static final TagKey<Block> EXPOSED_CUT_COPPER_FURNITURE = registerForBlock("exposed_cut_copper_furniture");
    public static final TagKey<Block> CUT_COPPER_FURNITURE = registerForBlock("cut_copper_furniture");
    public static final TagKey<Block> WAXED_OXIDIZED_CUT_COPPER_FURNITURE = registerForBlock("waxed_oxidized_cut_copper_furniture");
    public static final TagKey<Block> WAXED_WEATHERED_CUT_COPPER_FURNITURE = registerForBlock("waxed_weathered_cut_copper_furniture");
    public static final TagKey<Block> WAXED_EXPOSED_CUT_COPPER_FURNITURE = registerForBlock("waxed_exposed_cut_copper_furniture");
    public static final TagKey<Block> WAXED_CUT_COPPER_FURNITURE = registerForBlock("waxed_cut_copper_furniture");
    public static final TagKey<Block> COBBLED_DEEPSLATE_FURNITURE = registerForBlock("cobbled_deepslate_furniture");
    public static final TagKey<Block> POLISHED_DEEPSLATE_FURNITURE = registerForBlock("polished_deepslate_furniture");
    public static final TagKey<Block> DEEPSLATE_TILE_FURNITURE = registerForBlock("deepslate_tile_furniture");
    public static final TagKey<Block> DEEPSLATE_BRICK_FURNITURE = registerForBlock("deepslate_brick_furniture");

    public static final TagKey<Block> BLACK_DYE_FURNITURE = registerForBlock("black_dye_furniture");
    public static final TagKey<Block> BLUE_DYE_FURNITURE = registerForBlock("blue_dye_furniture");
    public static final TagKey<Block> BROWN_DYE_FURNITURE = registerForBlock("brown_dye_furniture");
    public static final TagKey<Block> CYAN_DYE_FURNITURE = registerForBlock("cyan_dye_furniture");
    public static final TagKey<Block> GRAY_DYE_FURNITURE = registerForBlock("gray_dye_furniture");
    public static final TagKey<Block> GREEN_DYE_FURNITURE = registerForBlock("green_dye_furniture");
    public static final TagKey<Block> LIGHT_BLUE_DYE_FURNITURE = registerForBlock("light_blue_dye_furniture");
    public static final TagKey<Block> LIGHT_GRAY_DYE_FURNITURE = registerForBlock("light_gray_dye_furniture");
    public static final TagKey<Block> LIME_DYE_FURNITURE = registerForBlock("lime_dye_furniture");
    public static final TagKey<Block> MAGENTA_DYE_FURNITURE = registerForBlock("magenta_dye_furniture");
    public static final TagKey<Block> ORANGE_DYE_FURNITURE = registerForBlock("orange_dye_furniture");
    public static final TagKey<Block> PINK_DYE_FURNITURE = registerForBlock("pink_dye_furniture");
    public static final TagKey<Block> PURPLE_DYE_FURNITURE = registerForBlock("purple_dye_furniture");
    public static final TagKey<Block> RED_DYE_FURNITURE = registerForBlock("red_dye_furniture");
    public static final TagKey<Block> YELLOW_DYE_FURNITURE = registerForBlock("yellow_dye_furniture");
    public static final TagKey<Block> WHITE_DYE_FURNITURE = registerForBlock("white_dye_furniture");



    public static final TagKey<Block> CHAIR_BLOCK = registerForBlock("chair");
    public static final TagKey<Block> TABLE_BLOCK = registerForBlock("table");
    public static final TagKey<Block> COLUMN_BLOCK = registerForBlock("column");
    public static final TagKey<Block> CARVED_COLUMN_BLOCK = registerForBlock("carved_column");
    public static final TagKey<Block> LIGHTED_COLUMN_BLOCK = registerForBlock("lighted_column");
    public static final TagKey<Block> POT_HOLDER_BLOCK = registerForBlock("pot_holder");
    public static final TagKey<Block> BENCH_BLOCK = registerForBlock("bench");
    public static final TagKey<Block> CUPBOARD_BLOCK = registerForBlock("cupboard");
    public static final TagKey<Block> CABINET_BLOCK = registerForBlock("cabinet");


    private static TagKey<Block> registerForBlock(String id) {
        return BlockTags.create(FurniturePlan.asResource(id));
    }
}
