package nowebsite.maker.furnitureplan.registry.kindsblock;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraftforge.registries.RegistryObject;
import nowebsite.maker.furnitureplan.blocks.singleblockfurniture.TableBlock;
import nowebsite.maker.furnitureplan.blocks.columns.WeatheredCopperTable;
import nowebsite.maker.furnitureplan.registry.BlockRegistration;
import nowebsite.maker.furnitureplan.registry.ItemRegistration;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class TableBlockRegistration {
    public static void init() {}

    public static final RegistryObject<TableBlock> OAK_TABLES = BlockRegistration.BLOCKS.register("oak_tables", () -> usageTableBlock(Blocks.OAK_PLANKS));
    public static final RegistryObject<TableBlock> COBBLESTONE_TABLES = BlockRegistration.BLOCKS.register("cobblestone_tables", () -> usageTableBlock(Blocks.COBBLESTONE));
    public static final RegistryObject<TableBlock> BRICK_TABLES = BlockRegistration.BLOCKS.register("brick_tables", () -> usageTableBlock(Blocks.BRICKS));
    public static final RegistryObject<TableBlock> STONE_BRICK_TABLES = BlockRegistration.BLOCKS.register("stone_brick_tables", () -> usageTableBlock(Blocks.STONE_BRICKS));
    public static final RegistryObject<TableBlock> MUD_BRICK_TABLES = BlockRegistration.BLOCKS.register("mud_brick_tables", () -> usageTableBlock(Blocks.MUD_BRICKS));
    public static final RegistryObject<TableBlock> NETHER_BRICK_TABLES = BlockRegistration.BLOCKS.register("nether_brick_tables", () -> usageTableBlock(Blocks.NETHER_BRICKS));
    public static final RegistryObject<TableBlock> SANDSTONE_TABLES = BlockRegistration.BLOCKS.register("sandstone_tables", () -> usageTableBlock(Blocks.SANDSTONE));
    public static final RegistryObject<TableBlock> SPRUCE_TABLES = BlockRegistration.BLOCKS.register("spruce_tables", () -> usageTableBlock(Blocks.SPRUCE_PLANKS));
    public static final RegistryObject<TableBlock> BIRCH_TABLES = BlockRegistration.BLOCKS.register("birch_tables", () -> usageTableBlock(Blocks.BIRCH_PLANKS));
    public static final RegistryObject<TableBlock> JUNGLE_TABLES = BlockRegistration.BLOCKS.register("jungle_tables", () -> usageTableBlock(Blocks.JUNGLE_PLANKS));
    public static final RegistryObject<TableBlock> QUARTZ_TABLES = BlockRegistration.BLOCKS.register("quartz_tables", () -> usageTableBlock(Blocks.QUARTZ_BLOCK));
    public static final RegistryObject<TableBlock> ACACIA_TABLES = BlockRegistration.BLOCKS.register("acacia_tables", () -> usageTableBlock(Blocks.ACACIA_PLANKS));
    public static final RegistryObject<TableBlock> CHERRY_TABLES = BlockRegistration.BLOCKS.register("cherry_tables", () -> usageTableBlock(Blocks.CHERRY_PLANKS));
    public static final RegistryObject<TableBlock> DARK_OAK_TABLES = BlockRegistration.BLOCKS.register("dark_oak_tables", () -> usageTableBlock(Blocks.DARK_OAK_PLANKS));
    public static final RegistryObject<TableBlock> MANGROVE_TABLES = BlockRegistration.BLOCKS.register("mangrove_tables", () -> usageTableBlock(Blocks.MANGROVE_PLANKS));
    public static final RegistryObject<TableBlock> BAMBOO_TABLES = BlockRegistration.BLOCKS.register("bamboo_tables", () -> usageTableBlock(Blocks.BAMBOO_PLANKS));
    public static final RegistryObject<TableBlock> BAMBOO_MOSAIC_TABLES = BlockRegistration.BLOCKS.register("bamboo_mosaic_tables", () -> usageTableBlock(Blocks.BAMBOO_MOSAIC));
    public static final RegistryObject<TableBlock> PRISMARINE_TABLES = BlockRegistration.BLOCKS.register("prismarine_tables", () -> usageTableBlock(Blocks.PRISMARINE));
    public static final RegistryObject<TableBlock> PRISMARINE_BRICK_TABLES = BlockRegistration.BLOCKS.register("prismarine_brick_tables", () -> usageTableBlock(Blocks.PRISMARINE_BRICKS));
    public static final RegistryObject<TableBlock> DARK_PRISMARINE_TABLES = BlockRegistration.BLOCKS.register("dark_prismarine_tables", () -> usageTableBlock(Blocks.DARK_PRISMARINE));
    public static final RegistryObject<TableBlock> RED_SANDSTONE_TABLES = BlockRegistration.BLOCKS.register("red_sandstone_tables", () -> usageTableBlock(Blocks.RED_SANDSTONE));
    public static final RegistryObject<TableBlock> PURPUR_TABLES = BlockRegistration.BLOCKS.register("purpur_tables", () -> usageTableBlock(Blocks.PURPUR_BLOCK));
    public static final RegistryObject<TableBlock> POLISHED_GRANITE_TABLES = BlockRegistration.BLOCKS.register("polished_granite_tables", () -> usageTableBlock(Blocks.POLISHED_GRANITE));
    public static final RegistryObject<TableBlock> SMOOTH_RED_SANDSTONE_TABLES = BlockRegistration.BLOCKS.register("smooth_red_sandstone_tables", () -> usageTableBlock(Blocks.SMOOTH_RED_SANDSTONE));
    public static final RegistryObject<TableBlock> MOSSY_STONE_BRICK_TABLES = BlockRegistration.BLOCKS.register("mossy_stone_brick_tables", () -> usageTableBlock(Blocks.MOSSY_STONE_BRICKS));
    public static final RegistryObject<TableBlock> POLISHED_DIORITE_TABLES = BlockRegistration.BLOCKS.register("polished_diorite_tables", () -> usageTableBlock(Blocks.POLISHED_DIORITE));
    public static final RegistryObject<TableBlock> MOSSY_COBBLESTONE_TABLES = BlockRegistration.BLOCKS.register("mossy_cobblestone_tables", () -> usageTableBlock(Blocks.MOSSY_COBBLESTONE));
    public static final RegistryObject<TableBlock> END_STONE_BRICK_TABLES = BlockRegistration.BLOCKS.register("end_stone_brick_tables", () -> usageTableBlock(Blocks.END_STONE_BRICKS));
    public static final RegistryObject<TableBlock> STONE_TABLES = BlockRegistration.BLOCKS.register("stone_tables", () -> usageTableBlock(Blocks.STONE));
    public static final RegistryObject<TableBlock> SMOOTH_SANDSTONE_TABLES = BlockRegistration.BLOCKS.register("smooth_sandstone_tables", () -> usageTableBlock(Blocks.SMOOTH_SANDSTONE));
    public static final RegistryObject<TableBlock> SMOOTH_QUARTZ_TABLES = BlockRegistration.BLOCKS.register("smooth_quartz_tables", () -> usageTableBlock(Blocks.SMOOTH_QUARTZ));
    public static final RegistryObject<TableBlock> GRANITE_TABLES = BlockRegistration.BLOCKS.register("granite_tables", () -> usageTableBlock(Blocks.GRANITE));
    public static final RegistryObject<TableBlock> ANDESITE_TABLES = BlockRegistration.BLOCKS.register("andesite_tables", () -> usageTableBlock(Blocks.ANDESITE));
    public static final RegistryObject<TableBlock> RED_NETHER_BRICK_TABLES = BlockRegistration.BLOCKS.register("red_nether_brick_tables", () -> usageTableBlock(Blocks.RED_NETHER_BRICKS));
    public static final RegistryObject<TableBlock> POLISHED_ANDESITE_TABLES = BlockRegistration.BLOCKS.register("polished_andesite_tables", () -> usageTableBlock(Blocks.POLISHED_ANDESITE));
    public static final RegistryObject<TableBlock> DIORITE_TABLES = BlockRegistration.BLOCKS.register("diorite_tables", () -> usageTableBlock(Blocks.DIORITE));
    public static final RegistryObject<TableBlock> CRIMSON_TABLES = BlockRegistration.BLOCKS.register("crimson_tables", () -> usageTableBlock(Blocks.CRIMSON_PLANKS));
    public static final RegistryObject<TableBlock> WARPED_TABLES = BlockRegistration.BLOCKS.register("warped_tables", () -> usageTableBlock(Blocks.WARPED_PLANKS));
    public static final RegistryObject<TableBlock> BLACKSTONE_TABLES = BlockRegistration.BLOCKS.register("blackstone_tables", () -> usageTableBlock(Blocks.BLACKSTONE));
    public static final RegistryObject<TableBlock> POLISHED_BLACKSTONE_BRICK_TABLES = BlockRegistration.BLOCKS.register("polished_blackstone_brick_tables", () -> usageTableBlock(Blocks.POLISHED_BLACKSTONE_BRICKS));
    public static final RegistryObject<TableBlock> POLISHED_BLACKSTONE_TABLES = BlockRegistration.BLOCKS.register("polished_blackstone_tables", () -> usageTableBlock(Blocks.POLISHED_BLACKSTONE));
    public static final RegistryObject<WeatheredCopperTable> OXIDIZED_CUT_COPPER_TABLES = BlockRegistration.BLOCKS.register("oxidized_cut_copper_tables", () -> usageWeatheredTable(Blocks.OXIDIZED_CUT_COPPER, WeatheringCopper.WeatherState.OXIDIZED));
    public static final RegistryObject<WeatheredCopperTable> WEATHERED_CUT_COPPER_TABLES = BlockRegistration.BLOCKS.register("weathered_cut_copper_tables", () -> usageWeatheredTable(Blocks.WEATHERED_CUT_COPPER, WeatheringCopper.WeatherState.WEATHERED));
    public static final RegistryObject<WeatheredCopperTable> EXPOSED_CUT_COPPER_TABLES = BlockRegistration.BLOCKS.register("exposed_cut_copper_tables", () -> usageWeatheredTable(Blocks.EXPOSED_CUT_COPPER, WeatheringCopper.WeatherState.EXPOSED));
    public static final RegistryObject<WeatheredCopperTable> CUT_COPPER_TABLES = BlockRegistration.BLOCKS.register("cut_copper_tables", () -> usageWeatheredTable(Blocks.CUT_COPPER, WeatheringCopper.WeatherState.UNAFFECTED));
    public static final RegistryObject<TableBlock> WAXED_OXIDIZED_CUT_COPPER_TABLES = BlockRegistration.BLOCKS.register("waxed_oxidized_cut_copper_tables", () -> usageTableBlock(Blocks.WAXED_OXIDIZED_CUT_COPPER));
    public static final RegistryObject<TableBlock> WAXED_WEATHERED_CUT_COPPER_TABLES = BlockRegistration.BLOCKS.register("waxed_weathered_cut_copper_tables", () -> usageTableBlock(Blocks.WAXED_WEATHERED_CUT_COPPER));
    public static final RegistryObject<TableBlock> WAXED_EXPOSED_CUT_COPPER_TABLES = BlockRegistration.BLOCKS.register("waxed_exposed_cut_copper_tables", () -> usageTableBlock(Blocks.WAXED_EXPOSED_CUT_COPPER));
    public static final RegistryObject<TableBlock> WAXED_CUT_COPPER_TABLES = BlockRegistration.BLOCKS.register("waxed_cut_copper_tables", () -> usageTableBlock(Blocks.WAXED_CUT_COPPER));
    public static final RegistryObject<TableBlock> COBBLED_DEEPSLATE_TABLES = BlockRegistration.BLOCKS.register("cobbled_deepslate_tables", () -> usageTableBlock(Blocks.COBBLED_DEEPSLATE));
    public static final RegistryObject<TableBlock> POLISHED_DEEPSLATE_TABLES = BlockRegistration.BLOCKS.register("polished_deepslate_tables", () -> usageTableBlock(Blocks.POLISHED_DEEPSLATE));
    public static final RegistryObject<TableBlock> DEEPSLATE_TILE_TABLES = BlockRegistration.BLOCKS.register("deepslate_tile_tables", () -> usageTableBlock(Blocks.DEEPSLATE_TILES));
    public static final RegistryObject<TableBlock> DEEPSLATE_BRICK_TABLES = BlockRegistration.BLOCKS.register("deepslate_brick_tables", () -> usageTableBlock(Blocks.DEEPSLATE_BRICKS));
    public static final RegistryObject<BlockItem> OAK_TABLES_ITEM = ItemRegistration.ITEMS.register("oak_tables", () -> new BlockItem(OAK_TABLES.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> COBBLESTONE_TABLES_ITEM = ItemRegistration.ITEMS.register("cobblestone_tables", () -> new BlockItem(COBBLESTONE_TABLES.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> BRICK_TABLES_ITEM = ItemRegistration.ITEMS.register("brick_tables", () -> new BlockItem(BRICK_TABLES.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> STONE_BRICK_TABLES_ITEM = ItemRegistration.ITEMS.register("stone_brick_tables", () -> new BlockItem(STONE_BRICK_TABLES.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> MUD_BRICK_TABLES_ITEM = ItemRegistration.ITEMS.register("mud_brick_tables", () -> new BlockItem(MUD_BRICK_TABLES.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> NETHER_BRICK_TABLES_ITEM = ItemRegistration.ITEMS.register("nether_brick_tables", () -> new BlockItem(NETHER_BRICK_TABLES.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> SANDSTONE_TABLES_ITEM = ItemRegistration.ITEMS.register("sandstone_tables", () -> new BlockItem(SANDSTONE_TABLES.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> SPRUCE_TABLES_ITEM = ItemRegistration.ITEMS.register("spruce_tables", () -> new BlockItem(SPRUCE_TABLES.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> BIRCH_TABLES_ITEM = ItemRegistration.ITEMS.register("birch_tables", () -> new BlockItem(BIRCH_TABLES.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> JUNGLE_TABLES_ITEM = ItemRegistration.ITEMS.register("jungle_tables", () -> new BlockItem(JUNGLE_TABLES.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> QUARTZ_TABLES_ITEM = ItemRegistration.ITEMS.register("quartz_tables", () -> new BlockItem(QUARTZ_TABLES.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> ACACIA_TABLES_ITEM = ItemRegistration.ITEMS.register("acacia_tables", () -> new BlockItem(ACACIA_TABLES.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> CHERRY_TABLES_ITEM = ItemRegistration.ITEMS.register("cherry_tables", () -> new BlockItem(CHERRY_TABLES.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> DARK_OAK_TABLES_ITEM = ItemRegistration.ITEMS.register("dark_oak_tables", () -> new BlockItem(DARK_OAK_TABLES.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> MANGROVE_TABLES_ITEM = ItemRegistration.ITEMS.register("mangrove_tables", () -> new BlockItem(MANGROVE_TABLES.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> BAMBOO_TABLES_ITEM = ItemRegistration.ITEMS.register("bamboo_tables", () -> new BlockItem(BAMBOO_TABLES.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> BAMBOO_MOSAIC_TABLES_ITEM = ItemRegistration.ITEMS.register("bamboo_mosaic_tables", () -> new BlockItem(BAMBOO_MOSAIC_TABLES.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> PRISMARINE_TABLES_ITEM = ItemRegistration.ITEMS.register("prismarine_tables", () -> new BlockItem(PRISMARINE_TABLES.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> PRISMARINE_BRICK_TABLES_ITEM = ItemRegistration.ITEMS.register("prismarine_brick_tables", () -> new BlockItem(PRISMARINE_BRICK_TABLES.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> DARK_PRISMARINE_TABLES_ITEM = ItemRegistration.ITEMS.register("dark_prismarine_tables", () -> new BlockItem(DARK_PRISMARINE_TABLES.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> RED_SANDSTONE_TABLES_ITEM = ItemRegistration.ITEMS.register("red_sandstone_tables", () -> new BlockItem(RED_SANDSTONE_TABLES.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> PURPUR_TABLES_ITEM = ItemRegistration.ITEMS.register("purpur_tables", () -> new BlockItem(PURPUR_TABLES.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> POLISHED_GRANITE_TABLES_ITEM = ItemRegistration.ITEMS.register("polished_granite_tables", () -> new BlockItem(POLISHED_GRANITE_TABLES.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> SMOOTH_RED_SANDSTONE_TABLES_ITEM = ItemRegistration.ITEMS.register("smooth_red_sandstone_tables", () -> new BlockItem(SMOOTH_RED_SANDSTONE_TABLES.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> MOSSY_STONE_BRICK_TABLES_ITEM = ItemRegistration.ITEMS.register("mossy_stone_brick_tables", () -> new BlockItem(MOSSY_STONE_BRICK_TABLES.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> POLISHED_DIORITE_TABLES_ITEM = ItemRegistration.ITEMS.register("polished_diorite_tables", () -> new BlockItem(POLISHED_DIORITE_TABLES.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> MOSSY_COBBLESTONE_TABLES_ITEM = ItemRegistration.ITEMS.register("mossy_cobblestone_tables", () -> new BlockItem(MOSSY_COBBLESTONE_TABLES.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> END_STONE_BRICK_TABLES_ITEM = ItemRegistration.ITEMS.register("end_stone_brick_tables", () -> new BlockItem(END_STONE_BRICK_TABLES.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> STONE_TABLES_ITEM = ItemRegistration.ITEMS.register("stone_tables", () -> new BlockItem(STONE_TABLES.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> SMOOTH_SANDSTONE_TABLES_ITEM = ItemRegistration.ITEMS.register("smooth_sandstone_tables", () -> new BlockItem(SMOOTH_SANDSTONE_TABLES.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> SMOOTH_QUARTZ_TABLES_ITEM = ItemRegistration.ITEMS.register("smooth_quartz_tables", () -> new BlockItem(SMOOTH_QUARTZ_TABLES.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> GRANITE_TABLES_ITEM = ItemRegistration.ITEMS.register("granite_tables", () -> new BlockItem(GRANITE_TABLES.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> ANDESITE_TABLES_ITEM = ItemRegistration.ITEMS.register("andesite_tables", () -> new BlockItem(ANDESITE_TABLES.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> RED_NETHER_BRICK_TABLES_ITEM = ItemRegistration.ITEMS.register("red_nether_brick_tables", () -> new BlockItem(RED_NETHER_BRICK_TABLES.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> POLISHED_ANDESITE_TABLES_ITEM = ItemRegistration.ITEMS.register("polished_andesite_tables", () -> new BlockItem(POLISHED_ANDESITE_TABLES.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> DIORITE_TABLES_ITEM = ItemRegistration.ITEMS.register("diorite_tables", () -> new BlockItem(DIORITE_TABLES.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> CRIMSON_TABLES_ITEM = ItemRegistration.ITEMS.register("crimson_tables", () -> new BlockItem(CRIMSON_TABLES.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> WARPED_TABLES_ITEM = ItemRegistration.ITEMS.register("warped_tables", () -> new BlockItem(WARPED_TABLES.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> BLACKSTONE_TABLES_ITEM = ItemRegistration.ITEMS.register("blackstone_tables", () -> new BlockItem(BLACKSTONE_TABLES.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> POLISHED_BLACKSTONE_BRICK_TABLES_ITEM = ItemRegistration.ITEMS.register("polished_blackstone_brick_tables", () -> new BlockItem(POLISHED_BLACKSTONE_BRICK_TABLES.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> POLISHED_BLACKSTONE_TABLES_ITEM = ItemRegistration.ITEMS.register("polished_blackstone_tables", () -> new BlockItem(POLISHED_BLACKSTONE_TABLES.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> OXIDIZED_CUT_COPPER_TABLES_ITEM = ItemRegistration.ITEMS.register("oxidized_cut_copper_tables", () -> new BlockItem(OXIDIZED_CUT_COPPER_TABLES.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> WEATHERED_CUT_COPPER_TABLES_ITEM = ItemRegistration.ITEMS.register("weathered_cut_copper_tables", () -> new BlockItem(WEATHERED_CUT_COPPER_TABLES.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> EXPOSED_CUT_COPPER_TABLES_ITEM = ItemRegistration.ITEMS.register("exposed_cut_copper_tables", () -> new BlockItem(EXPOSED_CUT_COPPER_TABLES.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> CUT_COPPER_TABLES_ITEM = ItemRegistration.ITEMS.register("cut_copper_tables", () -> new BlockItem(CUT_COPPER_TABLES.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> WAXED_OXIDIZED_CUT_COPPER_TABLES_ITEM = ItemRegistration.ITEMS.register("waxed_oxidized_cut_copper_tables", () -> new BlockItem(WAXED_OXIDIZED_CUT_COPPER_TABLES.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> WAXED_WEATHERED_CUT_COPPER_TABLES_ITEM = ItemRegistration.ITEMS.register("waxed_weathered_cut_copper_tables", () -> new BlockItem(WAXED_WEATHERED_CUT_COPPER_TABLES.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> WAXED_EXPOSED_CUT_COPPER_TABLES_ITEM = ItemRegistration.ITEMS.register("waxed_exposed_cut_copper_tables", () -> new BlockItem(WAXED_EXPOSED_CUT_COPPER_TABLES.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> WAXED_CUT_COPPER_TABLES_ITEM = ItemRegistration.ITEMS.register("waxed_cut_copper_tables", () -> new BlockItem(WAXED_CUT_COPPER_TABLES.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> COBBLED_DEEPSLATE_TABLES_ITEM = ItemRegistration.ITEMS.register("cobbled_deepslate_tables", () -> new BlockItem(COBBLED_DEEPSLATE_TABLES.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> POLISHED_DEEPSLATE_TABLES_ITEM = ItemRegistration.ITEMS.register("polished_deepslate_tables", () -> new BlockItem(POLISHED_DEEPSLATE_TABLES.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> DEEPSLATE_TILE_TABLES_ITEM = ItemRegistration.ITEMS.register("deepslate_tile_tables", () -> new BlockItem(DEEPSLATE_TILE_TABLES.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> DEEPSLATE_BRICK_TABLES_ITEM = ItemRegistration.ITEMS.register("deepslate_brick_tables", () -> new BlockItem(DEEPSLATE_BRICK_TABLES.get(), new Item.Properties()));

    @Contract("_ -> new")
    public static @NotNull TableBlock usageTableBlock(Block propertyBlock) {
        return new TableBlock(propertyBlock.defaultBlockState(), Properties.copy(propertyBlock));
    }

    @Contract("_, _ -> new")
    public static @NotNull WeatheredCopperTable usageWeatheredTable(Block propertyBlock, WeatheringCopper.WeatherState weatherState) {
        return new WeatheredCopperTable(propertyBlock.defaultBlockState(), Properties.copy(propertyBlock), weatherState);
    }
}
