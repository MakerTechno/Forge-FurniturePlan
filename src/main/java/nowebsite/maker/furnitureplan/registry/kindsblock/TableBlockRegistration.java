package nowebsite.maker.furnitureplan.registry.kindsblock;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.neoforged.neoforge.registries.DeferredHolder;
import nowebsite.maker.furnitureplan.blocks.singleblockfurniture.WeatheredCopperTable;
import nowebsite.maker.furnitureplan.blocks.singleblockfurniture.TableBlock;
import nowebsite.maker.furnitureplan.registry.BlockRegistration;
import nowebsite.maker.furnitureplan.registry.ItemRegistration;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class TableBlockRegistration {
    public static void init() {}

    public static final DeferredHolder<Block, TableBlock> OAK_TABLE = BlockRegistration.BLOCKS.register("oak_table", () -> usageTableBlock(Blocks.OAK_PLANKS));
    public static final DeferredHolder<Block, TableBlock> COBBLESTONE_TABLE = BlockRegistration.BLOCKS.register("cobblestone_table", () -> usageTableBlock(Blocks.COBBLESTONE));
    public static final DeferredHolder<Block, TableBlock> BRICK_TABLE = BlockRegistration.BLOCKS.register("brick_table", () -> usageTableBlock(Blocks.BRICKS));
    public static final DeferredHolder<Block, TableBlock> STONE_BRICK_TABLE = BlockRegistration.BLOCKS.register("stone_brick_table", () -> usageTableBlock(Blocks.STONE_BRICKS));
    public static final DeferredHolder<Block, TableBlock> MUD_BRICK_TABLE = BlockRegistration.BLOCKS.register("mud_brick_table", () -> usageTableBlock(Blocks.MUD_BRICKS));
    public static final DeferredHolder<Block, TableBlock> NETHER_BRICK_TABLE = BlockRegistration.BLOCKS.register("nether_brick_table", () -> usageTableBlock(Blocks.NETHER_BRICKS));
    public static final DeferredHolder<Block, TableBlock> SANDSTONE_TABLE = BlockRegistration.BLOCKS.register("sandstone_table", () -> usageTableBlock(Blocks.SANDSTONE));
    public static final DeferredHolder<Block, TableBlock> SPRUCE_TABLE = BlockRegistration.BLOCKS.register("spruce_table", () -> usageTableBlock(Blocks.SPRUCE_PLANKS));
    public static final DeferredHolder<Block, TableBlock> BIRCH_TABLE = BlockRegistration.BLOCKS.register("birch_table", () -> usageTableBlock(Blocks.BIRCH_PLANKS));
    public static final DeferredHolder<Block, TableBlock> JUNGLE_TABLE = BlockRegistration.BLOCKS.register("jungle_table", () -> usageTableBlock(Blocks.JUNGLE_PLANKS));
    public static final DeferredHolder<Block, TableBlock> QUARTZ_TABLE = BlockRegistration.BLOCKS.register("quartz_table", () -> usageTableBlock(Blocks.QUARTZ_BLOCK));
    public static final DeferredHolder<Block, TableBlock> ACACIA_TABLE = BlockRegistration.BLOCKS.register("acacia_table", () -> usageTableBlock(Blocks.ACACIA_PLANKS));
    public static final DeferredHolder<Block, TableBlock> CHERRY_TABLE = BlockRegistration.BLOCKS.register("cherry_table", () -> usageTableBlock(Blocks.CHERRY_PLANKS));
    public static final DeferredHolder<Block, TableBlock> DARK_OAK_TABLE = BlockRegistration.BLOCKS.register("dark_oak_table", () -> usageTableBlock(Blocks.DARK_OAK_PLANKS));
    public static final DeferredHolder<Block, TableBlock> MANGROVE_TABLE = BlockRegistration.BLOCKS.register("mangrove_table", () -> usageTableBlock(Blocks.MANGROVE_PLANKS));
    public static final DeferredHolder<Block, TableBlock> BAMBOO_TABLE = BlockRegistration.BLOCKS.register("bamboo_table", () -> usageTableBlock(Blocks.BAMBOO_PLANKS));
    public static final DeferredHolder<Block, TableBlock> BAMBOO_MOSAIC_TABLE = BlockRegistration.BLOCKS.register("bamboo_mosaic_table", () -> usageTableBlock(Blocks.BAMBOO_MOSAIC));
    public static final DeferredHolder<Block, TableBlock> PRISMARINE_TABLE = BlockRegistration.BLOCKS.register("prismarine_table", () -> usageTableBlock(Blocks.PRISMARINE));
    public static final DeferredHolder<Block, TableBlock> PRISMARINE_BRICK_TABLE = BlockRegistration.BLOCKS.register("prismarine_brick_table", () -> usageTableBlock(Blocks.PRISMARINE_BRICKS));
    public static final DeferredHolder<Block, TableBlock> DARK_PRISMARINE_TABLE = BlockRegistration.BLOCKS.register("dark_prismarine_table", () -> usageTableBlock(Blocks.DARK_PRISMARINE));
    public static final DeferredHolder<Block, TableBlock> RED_SANDSTONE_TABLE = BlockRegistration.BLOCKS.register("red_sandstone_table", () -> usageTableBlock(Blocks.RED_SANDSTONE));
    public static final DeferredHolder<Block, TableBlock> PURPUR_TABLE = BlockRegistration.BLOCKS.register("purpur_table", () -> usageTableBlock(Blocks.PURPUR_BLOCK));
    public static final DeferredHolder<Block, TableBlock> POLISHED_GRANITE_TABLE = BlockRegistration.BLOCKS.register("polished_granite_table", () -> usageTableBlock(Blocks.POLISHED_GRANITE));
    public static final DeferredHolder<Block, TableBlock> SMOOTH_RED_SANDSTONE_TABLE = BlockRegistration.BLOCKS.register("smooth_red_sandstone_table", () -> usageTableBlock(Blocks.SMOOTH_RED_SANDSTONE));
    public static final DeferredHolder<Block, TableBlock> MOSSY_STONE_BRICK_TABLE = BlockRegistration.BLOCKS.register("mossy_stone_brick_table", () -> usageTableBlock(Blocks.MOSSY_STONE_BRICKS));
    public static final DeferredHolder<Block, TableBlock> POLISHED_DIORITE_TABLE = BlockRegistration.BLOCKS.register("polished_diorite_table", () -> usageTableBlock(Blocks.POLISHED_DIORITE));
    public static final DeferredHolder<Block, TableBlock> MOSSY_COBBLESTONE_TABLE = BlockRegistration.BLOCKS.register("mossy_cobblestone_table", () -> usageTableBlock(Blocks.MOSSY_COBBLESTONE));
    public static final DeferredHolder<Block, TableBlock> END_STONE_BRICK_TABLE = BlockRegistration.BLOCKS.register("end_stone_brick_table", () -> usageTableBlock(Blocks.END_STONE_BRICKS));
    public static final DeferredHolder<Block, TableBlock> STONE_TABLE = BlockRegistration.BLOCKS.register("stone_table", () -> usageTableBlock(Blocks.STONE));
    public static final DeferredHolder<Block, TableBlock> SMOOTH_SANDSTONE_TABLE = BlockRegistration.BLOCKS.register("smooth_sandstone_table", () -> usageTableBlock(Blocks.SMOOTH_SANDSTONE));
    public static final DeferredHolder<Block, TableBlock> SMOOTH_QUARTZ_TABLE = BlockRegistration.BLOCKS.register("smooth_quartz_table", () -> usageTableBlock(Blocks.SMOOTH_QUARTZ));
    public static final DeferredHolder<Block, TableBlock> GRANITE_TABLE = BlockRegistration.BLOCKS.register("granite_table", () -> usageTableBlock(Blocks.GRANITE));
    public static final DeferredHolder<Block, TableBlock> ANDESITE_TABLE = BlockRegistration.BLOCKS.register("andesite_table", () -> usageTableBlock(Blocks.ANDESITE));
    public static final DeferredHolder<Block, TableBlock> RED_NETHER_BRICK_TABLE = BlockRegistration.BLOCKS.register("red_nether_brick_table", () -> usageTableBlock(Blocks.RED_NETHER_BRICKS));
    public static final DeferredHolder<Block, TableBlock> POLISHED_ANDESITE_TABLE = BlockRegistration.BLOCKS.register("polished_andesite_table", () -> usageTableBlock(Blocks.POLISHED_ANDESITE));
    public static final DeferredHolder<Block, TableBlock> DIORITE_TABLE = BlockRegistration.BLOCKS.register("diorite_table", () -> usageTableBlock(Blocks.DIORITE));
    public static final DeferredHolder<Block, TableBlock> CRIMSON_TABLE = BlockRegistration.BLOCKS.register("crimson_table", () -> usageTableBlock(Blocks.CRIMSON_PLANKS));
    public static final DeferredHolder<Block, TableBlock> WARPED_TABLE = BlockRegistration.BLOCKS.register("warped_table", () -> usageTableBlock(Blocks.WARPED_PLANKS));
    public static final DeferredHolder<Block, TableBlock> BLACKSTONE_TABLE = BlockRegistration.BLOCKS.register("blackstone_table", () -> usageTableBlock(Blocks.BLACKSTONE));
    public static final DeferredHolder<Block, TableBlock> POLISHED_BLACKSTONE_BRICK_TABLE = BlockRegistration.BLOCKS.register("polished_blackstone_brick_table", () -> usageTableBlock(Blocks.POLISHED_BLACKSTONE_BRICKS));
    public static final DeferredHolder<Block, TableBlock> POLISHED_BLACKSTONE_TABLE = BlockRegistration.BLOCKS.register("polished_blackstone_table", () -> usageTableBlock(Blocks.POLISHED_BLACKSTONE));
    public static final DeferredHolder<Block, WeatheredCopperTable> OXIDIZED_CUT_COPPER_TABLE = BlockRegistration.BLOCKS.register("oxidized_cut_copper_table", () -> usageWeatheredTable(Blocks.OXIDIZED_CUT_COPPER, WeatheringCopper.WeatherState.OXIDIZED));
    public static final DeferredHolder<Block, WeatheredCopperTable> WEATHERED_CUT_COPPER_TABLE = BlockRegistration.BLOCKS.register("weathered_cut_copper_table", () -> usageWeatheredTable(Blocks.WEATHERED_CUT_COPPER, WeatheringCopper.WeatherState.WEATHERED));
    public static final DeferredHolder<Block, WeatheredCopperTable> EXPOSED_CUT_COPPER_TABLE = BlockRegistration.BLOCKS.register("exposed_cut_copper_table", () -> usageWeatheredTable(Blocks.EXPOSED_CUT_COPPER, WeatheringCopper.WeatherState.EXPOSED));
    public static final DeferredHolder<Block, WeatheredCopperTable> CUT_COPPER_TABLE = BlockRegistration.BLOCKS.register("cut_copper_table", () -> usageWeatheredTable(Blocks.CUT_COPPER, WeatheringCopper.WeatherState.UNAFFECTED));
    public static final DeferredHolder<Block, TableBlock> WAXED_OXIDIZED_CUT_COPPER_TABLE = BlockRegistration.BLOCKS.register("waxed_oxidized_cut_copper_table", () -> usageTableBlock(Blocks.WAXED_OXIDIZED_CUT_COPPER));
    public static final DeferredHolder<Block, TableBlock> WAXED_WEATHERED_CUT_COPPER_TABLE = BlockRegistration.BLOCKS.register("waxed_weathered_cut_copper_table", () -> usageTableBlock(Blocks.WAXED_WEATHERED_CUT_COPPER));
    public static final DeferredHolder<Block, TableBlock> WAXED_EXPOSED_CUT_COPPER_TABLE = BlockRegistration.BLOCKS.register("waxed_exposed_cut_copper_table", () -> usageTableBlock(Blocks.WAXED_EXPOSED_CUT_COPPER));
    public static final DeferredHolder<Block, TableBlock> WAXED_CUT_COPPER_TABLE = BlockRegistration.BLOCKS.register("waxed_cut_copper_table", () -> usageTableBlock(Blocks.WAXED_CUT_COPPER));
    public static final DeferredHolder<Block, TableBlock> COBBLED_DEEPSLATE_TABLE = BlockRegistration.BLOCKS.register("cobbled_deepslate_table", () -> usageTableBlock(Blocks.COBBLED_DEEPSLATE));
    public static final DeferredHolder<Block, TableBlock> POLISHED_DEEPSLATE_TABLE = BlockRegistration.BLOCKS.register("polished_deepslate_table", () -> usageTableBlock(Blocks.POLISHED_DEEPSLATE));
    public static final DeferredHolder<Block, TableBlock> DEEPSLATE_TILE_TABLE = BlockRegistration.BLOCKS.register("deepslate_tile_table", () -> usageTableBlock(Blocks.DEEPSLATE_TILES));
    public static final DeferredHolder<Block, TableBlock> DEEPSLATE_BRICK_TABLE = BlockRegistration.BLOCKS.register("deepslate_brick_table", () -> usageTableBlock(Blocks.DEEPSLATE_BRICKS));
    public static final DeferredHolder<Item, BlockItem> OAK_TABLE_ITEM = ItemRegistration.ITEMS.register("oak_table", () -> new BlockItem(OAK_TABLE.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> COBBLESTONE_TABLE_ITEM = ItemRegistration.ITEMS.register("cobblestone_table", () -> new BlockItem(COBBLESTONE_TABLE.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> BRICK_TABLE_ITEM = ItemRegistration.ITEMS.register("brick_table", () -> new BlockItem(BRICK_TABLE.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> STONE_BRICK_TABLE_ITEM = ItemRegistration.ITEMS.register("stone_brick_table", () -> new BlockItem(STONE_BRICK_TABLE.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> MUD_BRICK_TABLE_ITEM = ItemRegistration.ITEMS.register("mud_brick_table", () -> new BlockItem(MUD_BRICK_TABLE.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> NETHER_BRICK_TABLE_ITEM = ItemRegistration.ITEMS.register("nether_brick_table", () -> new BlockItem(NETHER_BRICK_TABLE.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> SANDSTONE_TABLE_ITEM = ItemRegistration.ITEMS.register("sandstone_table", () -> new BlockItem(SANDSTONE_TABLE.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> SPRUCE_TABLE_ITEM = ItemRegistration.ITEMS.register("spruce_table", () -> new BlockItem(SPRUCE_TABLE.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> BIRCH_TABLE_ITEM = ItemRegistration.ITEMS.register("birch_table", () -> new BlockItem(BIRCH_TABLE.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> JUNGLE_TABLE_ITEM = ItemRegistration.ITEMS.register("jungle_table", () -> new BlockItem(JUNGLE_TABLE.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> QUARTZ_TABLE_ITEM = ItemRegistration.ITEMS.register("quartz_table", () -> new BlockItem(QUARTZ_TABLE.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> ACACIA_TABLE_ITEM = ItemRegistration.ITEMS.register("acacia_table", () -> new BlockItem(ACACIA_TABLE.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> CHERRY_TABLE_ITEM = ItemRegistration.ITEMS.register("cherry_table", () -> new BlockItem(CHERRY_TABLE.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> DARK_OAK_TABLE_ITEM = ItemRegistration.ITEMS.register("dark_oak_table", () -> new BlockItem(DARK_OAK_TABLE.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> MANGROVE_TABLE_ITEM = ItemRegistration.ITEMS.register("mangrove_table", () -> new BlockItem(MANGROVE_TABLE.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> BAMBOO_TABLE_ITEM = ItemRegistration.ITEMS.register("bamboo_table", () -> new BlockItem(BAMBOO_TABLE.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> BAMBOO_MOSAIC_TABLE_ITEM = ItemRegistration.ITEMS.register("bamboo_mosaic_table", () -> new BlockItem(BAMBOO_MOSAIC_TABLE.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> PRISMARINE_TABLE_ITEM = ItemRegistration.ITEMS.register("prismarine_table", () -> new BlockItem(PRISMARINE_TABLE.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> PRISMARINE_BRICK_TABLE_ITEM = ItemRegistration.ITEMS.register("prismarine_brick_table", () -> new BlockItem(PRISMARINE_BRICK_TABLE.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> DARK_PRISMARINE_TABLE_ITEM = ItemRegistration.ITEMS.register("dark_prismarine_table", () -> new BlockItem(DARK_PRISMARINE_TABLE.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> RED_SANDSTONE_TABLE_ITEM = ItemRegistration.ITEMS.register("red_sandstone_table", () -> new BlockItem(RED_SANDSTONE_TABLE.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> PURPUR_TABLE_ITEM = ItemRegistration.ITEMS.register("purpur_table", () -> new BlockItem(PURPUR_TABLE.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> POLISHED_GRANITE_TABLE_ITEM = ItemRegistration.ITEMS.register("polished_granite_table", () -> new BlockItem(POLISHED_GRANITE_TABLE.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> SMOOTH_RED_SANDSTONE_TABLE_ITEM = ItemRegistration.ITEMS.register("smooth_red_sandstone_table", () -> new BlockItem(SMOOTH_RED_SANDSTONE_TABLE.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> MOSSY_STONE_BRICK_TABLE_ITEM = ItemRegistration.ITEMS.register("mossy_stone_brick_table", () -> new BlockItem(MOSSY_STONE_BRICK_TABLE.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> POLISHED_DIORITE_TABLE_ITEM = ItemRegistration.ITEMS.register("polished_diorite_table", () -> new BlockItem(POLISHED_DIORITE_TABLE.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> MOSSY_COBBLESTONE_TABLE_ITEM = ItemRegistration.ITEMS.register("mossy_cobblestone_table", () -> new BlockItem(MOSSY_COBBLESTONE_TABLE.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> END_STONE_BRICK_TABLE_ITEM = ItemRegistration.ITEMS.register("end_stone_brick_table", () -> new BlockItem(END_STONE_BRICK_TABLE.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> STONE_TABLE_ITEM = ItemRegistration.ITEMS.register("stone_table", () -> new BlockItem(STONE_TABLE.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> SMOOTH_SANDSTONE_TABLE_ITEM = ItemRegistration.ITEMS.register("smooth_sandstone_table", () -> new BlockItem(SMOOTH_SANDSTONE_TABLE.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> SMOOTH_QUARTZ_TABLE_ITEM = ItemRegistration.ITEMS.register("smooth_quartz_table", () -> new BlockItem(SMOOTH_QUARTZ_TABLE.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> GRANITE_TABLE_ITEM = ItemRegistration.ITEMS.register("granite_table", () -> new BlockItem(GRANITE_TABLE.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> ANDESITE_TABLE_ITEM = ItemRegistration.ITEMS.register("andesite_table", () -> new BlockItem(ANDESITE_TABLE.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> RED_NETHER_BRICK_TABLE_ITEM = ItemRegistration.ITEMS.register("red_nether_brick_table", () -> new BlockItem(RED_NETHER_BRICK_TABLE.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> POLISHED_ANDESITE_TABLE_ITEM = ItemRegistration.ITEMS.register("polished_andesite_table", () -> new BlockItem(POLISHED_ANDESITE_TABLE.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> DIORITE_TABLE_ITEM = ItemRegistration.ITEMS.register("diorite_table", () -> new BlockItem(DIORITE_TABLE.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> CRIMSON_TABLE_ITEM = ItemRegistration.ITEMS.register("crimson_table", () -> new BlockItem(CRIMSON_TABLE.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> WARPED_TABLE_ITEM = ItemRegistration.ITEMS.register("warped_table", () -> new BlockItem(WARPED_TABLE.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> BLACKSTONE_TABLE_ITEM = ItemRegistration.ITEMS.register("blackstone_table", () -> new BlockItem(BLACKSTONE_TABLE.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> POLISHED_BLACKSTONE_BRICK_TABLE_ITEM = ItemRegistration.ITEMS.register("polished_blackstone_brick_table", () -> new BlockItem(POLISHED_BLACKSTONE_BRICK_TABLE.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> POLISHED_BLACKSTONE_TABLE_ITEM = ItemRegistration.ITEMS.register("polished_blackstone_table", () -> new BlockItem(POLISHED_BLACKSTONE_TABLE.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> OXIDIZED_CUT_COPPER_TABLE_ITEM = ItemRegistration.ITEMS.register("oxidized_cut_copper_table", () -> new BlockItem(OXIDIZED_CUT_COPPER_TABLE.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> WEATHERED_CUT_COPPER_TABLE_ITEM = ItemRegistration.ITEMS.register("weathered_cut_copper_table", () -> new BlockItem(WEATHERED_CUT_COPPER_TABLE.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> EXPOSED_CUT_COPPER_TABLE_ITEM = ItemRegistration.ITEMS.register("exposed_cut_copper_table", () -> new BlockItem(EXPOSED_CUT_COPPER_TABLE.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> CUT_COPPER_TABLE_ITEM = ItemRegistration.ITEMS.register("cut_copper_table", () -> new BlockItem(CUT_COPPER_TABLE.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> WAXED_OXIDIZED_CUT_COPPER_TABLE_ITEM = ItemRegistration.ITEMS.register("waxed_oxidized_cut_copper_table", () -> new BlockItem(WAXED_OXIDIZED_CUT_COPPER_TABLE.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> WAXED_WEATHERED_CUT_COPPER_TABLE_ITEM = ItemRegistration.ITEMS.register("waxed_weathered_cut_copper_table", () -> new BlockItem(WAXED_WEATHERED_CUT_COPPER_TABLE.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> WAXED_EXPOSED_CUT_COPPER_TABLE_ITEM = ItemRegistration.ITEMS.register("waxed_exposed_cut_copper_table", () -> new BlockItem(WAXED_EXPOSED_CUT_COPPER_TABLE.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> WAXED_CUT_COPPER_TABLE_ITEM = ItemRegistration.ITEMS.register("waxed_cut_copper_table", () -> new BlockItem(WAXED_CUT_COPPER_TABLE.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> COBBLED_DEEPSLATE_TABLE_ITEM = ItemRegistration.ITEMS.register("cobbled_deepslate_table", () -> new BlockItem(COBBLED_DEEPSLATE_TABLE.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> POLISHED_DEEPSLATE_TABLE_ITEM = ItemRegistration.ITEMS.register("polished_deepslate_table", () -> new BlockItem(POLISHED_DEEPSLATE_TABLE.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> DEEPSLATE_TILE_TABLE_ITEM = ItemRegistration.ITEMS.register("deepslate_tile_table", () -> new BlockItem(DEEPSLATE_TILE_TABLE.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> DEEPSLATE_BRICK_TABLE_ITEM = ItemRegistration.ITEMS.register("deepslate_brick_table", () -> new BlockItem(DEEPSLATE_BRICK_TABLE.get(), new Item.Properties()));

    
    public static final DeferredHolder<Block, TableBlock> TUFF_TABLE = BlockRegistration.BLOCKS.register("tuff_table", () -> usageTableBlock(Blocks.TUFF));
    public static final DeferredHolder<Block, TableBlock> POLISHED_TUFF_TABLE = BlockRegistration.BLOCKS.register("polished_tuff_table", () -> usageTableBlock(Blocks.POLISHED_TUFF));
    public static final DeferredHolder<Block, TableBlock> TUFF_BRICK_TABLE = BlockRegistration.BLOCKS.register("tuff_brick_table", () -> usageTableBlock(Blocks.TUFF_BRICKS));
    public static final DeferredHolder<Item, BlockItem> TUFF_TABLE_ITEM = ItemRegistration.ITEMS.register("tuff_table", () -> new BlockItem(TUFF_TABLE.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> POLISHED_TUFF_TABLE_ITEM = ItemRegistration.ITEMS.register("polished_tuff_table", () -> new BlockItem(POLISHED_TUFF_TABLE.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> TUFF_BRICK_TABLE_ITEM = ItemRegistration.ITEMS.register("tuff_brick_table", () -> new BlockItem(TUFF_BRICK_TABLE.get(), new Item.Properties()));

    @Contract("_ -> new")
    @SuppressWarnings("deprecation")
    public static @NotNull TableBlock usageTableBlock(Block propertyBlock) {
        return new TableBlock(propertyBlock.defaultBlockState(), Properties.ofLegacyCopy(propertyBlock));
    }

    @Contract("_, _ -> new")
    @SuppressWarnings("deprecation")
    public static @NotNull WeatheredCopperTable usageWeatheredTable(Block propertyBlock, WeatheringCopper.WeatherState weatherState) {
        return new WeatheredCopperTable(propertyBlock.defaultBlockState(), Properties.ofLegacyCopy(propertyBlock), weatherState);
    }
}
