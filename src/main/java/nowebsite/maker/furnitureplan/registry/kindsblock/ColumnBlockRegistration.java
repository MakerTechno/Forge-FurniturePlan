package nowebsite.maker.furnitureplan.registry.kindsblock;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredHolder;
import nowebsite.maker.furnitureplan.blocks.columns.ColumnBlock;
import nowebsite.maker.furnitureplan.blocks.columns.WeatheredCopperColumn;
import nowebsite.maker.furnitureplan.registry.BlockRegistration;
import nowebsite.maker.furnitureplan.registry.ItemRegistration;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class ColumnBlockRegistration {
    public static void init(){}

    public static final DeferredHolder<Block, ColumnBlock> OAK_COLUMN = BlockRegistration.BLOCKS.register("oak_column", () -> usageColumnBlock(Blocks.OAK_PLANKS));
    public static final DeferredHolder<Block, ColumnBlock> COBBLESTONE_COLUMN = BlockRegistration.BLOCKS.register("cobblestone_column", () -> usageColumnBlock(Blocks.COBBLESTONE));
    public static final DeferredHolder<Block, ColumnBlock> BRICK_COLUMN = BlockRegistration.BLOCKS.register("brick_column", () -> usageColumnBlock(Blocks.BRICKS));
    public static final DeferredHolder<Block, ColumnBlock> STONE_BRICK_COLUMN = BlockRegistration.BLOCKS.register("stone_brick_column", () -> usageColumnBlock(Blocks.STONE_BRICKS));
    public static final DeferredHolder<Block, ColumnBlock> MUD_BRICK_COLUMN = BlockRegistration.BLOCKS.register("mud_brick_column", () -> usageColumnBlock(Blocks.MUD_BRICKS));
    public static final DeferredHolder<Block, ColumnBlock> NETHER_BRICK_COLUMN = BlockRegistration.BLOCKS.register("nether_brick_column", () -> usageColumnBlock(Blocks.NETHER_BRICKS));
    public static final DeferredHolder<Block, ColumnBlock> SANDSTONE_COLUMN = BlockRegistration.BLOCKS.register("sandstone_column", () -> usageColumnBlock(Blocks.SANDSTONE));
    public static final DeferredHolder<Block, ColumnBlock> SPRUCE_COLUMN = BlockRegistration.BLOCKS.register("spruce_column", () -> usageColumnBlock(Blocks.SPRUCE_PLANKS));
    public static final DeferredHolder<Block, ColumnBlock> BIRCH_COLUMN = BlockRegistration.BLOCKS.register("birch_column", () -> usageColumnBlock(Blocks.BIRCH_PLANKS));
    public static final DeferredHolder<Block, ColumnBlock> JUNGLE_COLUMN = BlockRegistration.BLOCKS.register("jungle_column", () -> usageColumnBlock(Blocks.JUNGLE_PLANKS));
    public static final DeferredHolder<Block, ColumnBlock> QUARTZ_COLUMN = BlockRegistration.BLOCKS.register("quartz_column", () -> usageColumnBlock(Blocks.QUARTZ_BLOCK));
    public static final DeferredHolder<Block, ColumnBlock> ACACIA_COLUMN = BlockRegistration.BLOCKS.register("acacia_column", () -> usageColumnBlock(Blocks.ACACIA_PLANKS));
    public static final DeferredHolder<Block, ColumnBlock> CHERRY_COLUMN = BlockRegistration.BLOCKS.register("cherry_column", () -> usageColumnBlock(Blocks.CHERRY_PLANKS));
    public static final DeferredHolder<Block, ColumnBlock> DARK_OAK_COLUMN = BlockRegistration.BLOCKS.register("dark_oak_column", () -> usageColumnBlock(Blocks.DARK_OAK_PLANKS));
    public static final DeferredHolder<Block, ColumnBlock> MANGROVE_COLUMN = BlockRegistration.BLOCKS.register("mangrove_column", () -> usageColumnBlock(Blocks.MANGROVE_PLANKS));
    public static final DeferredHolder<Block, ColumnBlock> BAMBOO_COLUMN = BlockRegistration.BLOCKS.register("bamboo_column", () -> usageColumnBlock(Blocks.BAMBOO_PLANKS));
    public static final DeferredHolder<Block, ColumnBlock> BAMBOO_MOSAIC_COLUMN = BlockRegistration.BLOCKS.register("bamboo_mosaic_column", () -> usageColumnBlock(Blocks.BAMBOO_MOSAIC));
    public static final DeferredHolder<Block, ColumnBlock> PRISMARINE_COLUMN = BlockRegistration.BLOCKS.register("prismarine_column", () -> usageColumnBlock(Blocks.PRISMARINE));
    public static final DeferredHolder<Block, ColumnBlock> PRISMARINE_BRICK_COLUMN = BlockRegistration.BLOCKS.register("prismarine_brick_column", () -> usageColumnBlock(Blocks.PRISMARINE_BRICKS));
    public static final DeferredHolder<Block, ColumnBlock> DARK_PRISMARINE_COLUMN = BlockRegistration.BLOCKS.register("dark_prismarine_column", () -> usageColumnBlock(Blocks.DARK_PRISMARINE));
    public static final DeferredHolder<Block, ColumnBlock> RED_SANDSTONE_COLUMN = BlockRegistration.BLOCKS.register("red_sandstone_column", () -> usageColumnBlock(Blocks.RED_SANDSTONE));
    public static final DeferredHolder<Block, ColumnBlock> PURPUR_COLUMN = BlockRegistration.BLOCKS.register("purpur_column", () -> usageColumnBlock(Blocks.PURPUR_BLOCK));
    public static final DeferredHolder<Block, ColumnBlock> POLISHED_GRANITE_COLUMN = BlockRegistration.BLOCKS.register("polished_granite_column", () -> usageColumnBlock(Blocks.POLISHED_GRANITE));
    public static final DeferredHolder<Block, ColumnBlock> SMOOTH_RED_SANDSTONE_COLUMN = BlockRegistration.BLOCKS.register("smooth_red_sandstone_column", () -> usageColumnBlock(Blocks.SMOOTH_RED_SANDSTONE));
    public static final DeferredHolder<Block, ColumnBlock> MOSSY_STONE_BRICK_COLUMN = BlockRegistration.BLOCKS.register("mossy_stone_brick_column", () -> usageColumnBlock(Blocks.MOSSY_STONE_BRICKS));
    public static final DeferredHolder<Block, ColumnBlock> POLISHED_DIORITE_COLUMN = BlockRegistration.BLOCKS.register("polished_diorite_column", () -> usageColumnBlock(Blocks.POLISHED_DIORITE));
    public static final DeferredHolder<Block, ColumnBlock> MOSSY_COBBLESTONE_COLUMN = BlockRegistration.BLOCKS.register("mossy_cobblestone_column", () -> usageColumnBlock(Blocks.MOSSY_COBBLESTONE));
    public static final DeferredHolder<Block, ColumnBlock> END_STONE_BRICK_COLUMN = BlockRegistration.BLOCKS.register("end_stone_brick_column", () -> usageColumnBlock(Blocks.END_STONE_BRICKS));
    public static final DeferredHolder<Block, ColumnBlock> STONE_COLUMN = BlockRegistration.BLOCKS.register("stone_column", () -> usageColumnBlock(Blocks.STONE));
    public static final DeferredHolder<Block, ColumnBlock> SMOOTH_SANDSTONE_COLUMN = BlockRegistration.BLOCKS.register("smooth_sandstone_column", () -> usageColumnBlock(Blocks.SMOOTH_SANDSTONE));
    public static final DeferredHolder<Block, ColumnBlock> SMOOTH_QUARTZ_COLUMN = BlockRegistration.BLOCKS.register("smooth_quartz_column", () -> usageColumnBlock(Blocks.SMOOTH_QUARTZ));
    public static final DeferredHolder<Block, ColumnBlock> GRANITE_COLUMN = BlockRegistration.BLOCKS.register("granite_column", () -> usageColumnBlock(Blocks.GRANITE));
    public static final DeferredHolder<Block, ColumnBlock> ANDESITE_COLUMN = BlockRegistration.BLOCKS.register("andesite_column", () -> usageColumnBlock(Blocks.ANDESITE));
    public static final DeferredHolder<Block, ColumnBlock> RED_NETHER_BRICK_COLUMN = BlockRegistration.BLOCKS.register("red_nether_brick_column", () -> usageColumnBlock(Blocks.RED_NETHER_BRICKS));
    public static final DeferredHolder<Block, ColumnBlock> POLISHED_ANDESITE_COLUMN = BlockRegistration.BLOCKS.register("polished_andesite_column", () -> usageColumnBlock(Blocks.POLISHED_ANDESITE));
    public static final DeferredHolder<Block, ColumnBlock> DIORITE_COLUMN = BlockRegistration.BLOCKS.register("diorite_column", () -> usageColumnBlock(Blocks.DIORITE));
    public static final DeferredHolder<Block, ColumnBlock> CRIMSON_COLUMN = BlockRegistration.BLOCKS.register("crimson_column", () -> usageColumnBlock(Blocks.CRIMSON_PLANKS));
    public static final DeferredHolder<Block, ColumnBlock> WARPED_COLUMN = BlockRegistration.BLOCKS.register("warped_column", () -> usageColumnBlock(Blocks.WARPED_PLANKS));
    public static final DeferredHolder<Block, ColumnBlock> BLACKSTONE_COLUMN = BlockRegistration.BLOCKS.register("blackstone_column", () -> usageColumnBlock(Blocks.BLACKSTONE));
    public static final DeferredHolder<Block, ColumnBlock> POLISHED_BLACKSTONE_BRICK_COLUMN = BlockRegistration.BLOCKS.register("polished_blackstone_brick_column", () -> usageColumnBlock(Blocks.POLISHED_BLACKSTONE_BRICKS));
    public static final DeferredHolder<Block, ColumnBlock> POLISHED_BLACKSTONE_COLUMN = BlockRegistration.BLOCKS.register("polished_blackstone_column", () -> usageColumnBlock(Blocks.POLISHED_BLACKSTONE));
    public static final DeferredHolder<Block, WeatheredCopperColumn> OXIDIZED_CUT_COPPER_COLUMN = BlockRegistration.BLOCKS.register("oxidized_cut_copper_column", () -> usageWeatheredColumn(Blocks.OXIDIZED_CUT_COPPER, WeatheringCopper.WeatherState.OXIDIZED));
    public static final DeferredHolder<Block, WeatheredCopperColumn> WEATHERED_CUT_COPPER_COLUMN = BlockRegistration.BLOCKS.register("weathered_cut_copper_column", () -> usageWeatheredColumn(Blocks.WEATHERED_CUT_COPPER, WeatheringCopper.WeatherState.WEATHERED));
    public static final DeferredHolder<Block, WeatheredCopperColumn> EXPOSED_CUT_COPPER_COLUMN = BlockRegistration.BLOCKS.register("exposed_cut_copper_column", () -> usageWeatheredColumn(Blocks.EXPOSED_CUT_COPPER, WeatheringCopper.WeatherState.EXPOSED));
    public static final DeferredHolder<Block, WeatheredCopperColumn> CUT_COPPER_COLUMN = BlockRegistration.BLOCKS.register("cut_copper_column", () -> usageWeatheredColumn(Blocks.CUT_COPPER, WeatheringCopper.WeatherState.UNAFFECTED));
    public static final DeferredHolder<Block, ColumnBlock> WAXED_OXIDIZED_CUT_COPPER_COLUMN = BlockRegistration.BLOCKS.register("waxed_oxidized_cut_copper_column", () -> usageColumnBlock(Blocks.WAXED_OXIDIZED_CUT_COPPER));
    public static final DeferredHolder<Block, ColumnBlock> WAXED_WEATHERED_CUT_COPPER_COLUMN = BlockRegistration.BLOCKS.register("waxed_weathered_cut_copper_column", () -> usageColumnBlock(Blocks.WAXED_WEATHERED_CUT_COPPER));
    public static final DeferredHolder<Block, ColumnBlock> WAXED_EXPOSED_CUT_COPPER_COLUMN = BlockRegistration.BLOCKS.register("waxed_exposed_cut_copper_column", () -> usageColumnBlock(Blocks.WAXED_EXPOSED_CUT_COPPER));
    public static final DeferredHolder<Block, ColumnBlock> WAXED_CUT_COPPER_COLUMN = BlockRegistration.BLOCKS.register("waxed_cut_copper_column", () -> usageColumnBlock(Blocks.WAXED_CUT_COPPER));
    public static final DeferredHolder<Block, ColumnBlock> COBBLED_DEEPSLATE_COLUMN = BlockRegistration.BLOCKS.register("cobbled_deepslate_column", () -> usageColumnBlock(Blocks.COBBLED_DEEPSLATE));
    public static final DeferredHolder<Block, ColumnBlock> POLISHED_DEEPSLATE_COLUMN = BlockRegistration.BLOCKS.register("polished_deepslate_column", () -> usageColumnBlock(Blocks.POLISHED_DEEPSLATE));
    public static final DeferredHolder<Block, ColumnBlock> DEEPSLATE_TILE_COLUMN = BlockRegistration.BLOCKS.register("deepslate_tile_column", () -> usageColumnBlock(Blocks.DEEPSLATE_TILES));
    public static final DeferredHolder<Block, ColumnBlock> DEEPSLATE_BRICK_COLUMN = BlockRegistration.BLOCKS.register("deepslate_brick_column", () -> usageColumnBlock(Blocks.DEEPSLATE_BRICKS));
    public static final DeferredHolder<Item, BlockItem> OAK_COLUMN_ITEM = ItemRegistration.ITEMS.register("oak_column", () -> new BlockItem(OAK_COLUMN.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> COBBLESTONE_COLUMN_ITEM = ItemRegistration.ITEMS.register("cobblestone_column", () -> new BlockItem(COBBLESTONE_COLUMN.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> BRICK_COLUMN_ITEM = ItemRegistration.ITEMS.register("brick_column", () -> new BlockItem(BRICK_COLUMN.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> STONE_BRICK_COLUMN_ITEM = ItemRegistration.ITEMS.register("stone_brick_column", () -> new BlockItem(STONE_BRICK_COLUMN.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> MUD_BRICK_COLUMN_ITEM = ItemRegistration.ITEMS.register("mud_brick_column", () -> new BlockItem(MUD_BRICK_COLUMN.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> NETHER_BRICK_COLUMN_ITEM = ItemRegistration.ITEMS.register("nether_brick_column", () -> new BlockItem(NETHER_BRICK_COLUMN.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> SANDSTONE_COLUMN_ITEM = ItemRegistration.ITEMS.register("sandstone_column", () -> new BlockItem(SANDSTONE_COLUMN.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> SPRUCE_COLUMN_ITEM = ItemRegistration.ITEMS.register("spruce_column", () -> new BlockItem(SPRUCE_COLUMN.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> BIRCH_COLUMN_ITEM = ItemRegistration.ITEMS.register("birch_column", () -> new BlockItem(BIRCH_COLUMN.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> JUNGLE_COLUMN_ITEM = ItemRegistration.ITEMS.register("jungle_column", () -> new BlockItem(JUNGLE_COLUMN.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> QUARTZ_COLUMN_ITEM = ItemRegistration.ITEMS.register("quartz_column", () -> new BlockItem(QUARTZ_COLUMN.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> ACACIA_COLUMN_ITEM = ItemRegistration.ITEMS.register("acacia_column", () -> new BlockItem(ACACIA_COLUMN.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> CHERRY_COLUMN_ITEM = ItemRegistration.ITEMS.register("cherry_column", () -> new BlockItem(CHERRY_COLUMN.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> DARK_OAK_COLUMN_ITEM = ItemRegistration.ITEMS.register("dark_oak_column", () -> new BlockItem(DARK_OAK_COLUMN.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> MANGROVE_COLUMN_ITEM = ItemRegistration.ITEMS.register("mangrove_column", () -> new BlockItem(MANGROVE_COLUMN.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> BAMBOO_COLUMN_ITEM = ItemRegistration.ITEMS.register("bamboo_column", () -> new BlockItem(BAMBOO_COLUMN.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> BAMBOO_MOSAIC_COLUMN_ITEM = ItemRegistration.ITEMS.register("bamboo_mosaic_column", () -> new BlockItem(BAMBOO_MOSAIC_COLUMN.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> PRISMARINE_COLUMN_ITEM = ItemRegistration.ITEMS.register("prismarine_column", () -> new BlockItem(PRISMARINE_COLUMN.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> PRISMARINE_BRICK_COLUMN_ITEM = ItemRegistration.ITEMS.register("prismarine_brick_column", () -> new BlockItem(PRISMARINE_BRICK_COLUMN.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> DARK_PRISMARINE_COLUMN_ITEM = ItemRegistration.ITEMS.register("dark_prismarine_column", () -> new BlockItem(DARK_PRISMARINE_COLUMN.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> RED_SANDSTONE_COLUMN_ITEM = ItemRegistration.ITEMS.register("red_sandstone_column", () -> new BlockItem(RED_SANDSTONE_COLUMN.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> PURPUR_COLUMN_ITEM = ItemRegistration.ITEMS.register("purpur_column", () -> new BlockItem(PURPUR_COLUMN.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> POLISHED_GRANITE_COLUMN_ITEM = ItemRegistration.ITEMS.register("polished_granite_column", () -> new BlockItem(POLISHED_GRANITE_COLUMN.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> SMOOTH_RED_SANDSTONE_COLUMN_ITEM = ItemRegistration.ITEMS.register("smooth_red_sandstone_column", () -> new BlockItem(SMOOTH_RED_SANDSTONE_COLUMN.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> MOSSY_STONE_BRICK_COLUMN_ITEM = ItemRegistration.ITEMS.register("mossy_stone_brick_column", () -> new BlockItem(MOSSY_STONE_BRICK_COLUMN.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> POLISHED_DIORITE_COLUMN_ITEM = ItemRegistration.ITEMS.register("polished_diorite_column", () -> new BlockItem(POLISHED_DIORITE_COLUMN.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> MOSSY_COBBLESTONE_COLUMN_ITEM = ItemRegistration.ITEMS.register("mossy_cobblestone_column", () -> new BlockItem(MOSSY_COBBLESTONE_COLUMN.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> END_STONE_BRICK_COLUMN_ITEM = ItemRegistration.ITEMS.register("end_stone_brick_column", () -> new BlockItem(END_STONE_BRICK_COLUMN.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> STONE_COLUMN_ITEM = ItemRegistration.ITEMS.register("stone_column", () -> new BlockItem(STONE_COLUMN.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> SMOOTH_SANDSTONE_COLUMN_ITEM = ItemRegistration.ITEMS.register("smooth_sandstone_column", () -> new BlockItem(SMOOTH_SANDSTONE_COLUMN.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> SMOOTH_QUARTZ_COLUMN_ITEM = ItemRegistration.ITEMS.register("smooth_quartz_column", () -> new BlockItem(SMOOTH_QUARTZ_COLUMN.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> GRANITE_COLUMN_ITEM = ItemRegistration.ITEMS.register("granite_column", () -> new BlockItem(GRANITE_COLUMN.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> ANDESITE_COLUMN_ITEM = ItemRegistration.ITEMS.register("andesite_column", () -> new BlockItem(ANDESITE_COLUMN.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> RED_NETHER_BRICK_COLUMN_ITEM = ItemRegistration.ITEMS.register("red_nether_brick_column", () -> new BlockItem(RED_NETHER_BRICK_COLUMN.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> POLISHED_ANDESITE_COLUMN_ITEM = ItemRegistration.ITEMS.register("polished_andesite_column", () -> new BlockItem(POLISHED_ANDESITE_COLUMN.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> DIORITE_COLUMN_ITEM = ItemRegistration.ITEMS.register("diorite_column", () -> new BlockItem(DIORITE_COLUMN.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> CRIMSON_COLUMN_ITEM = ItemRegistration.ITEMS.register("crimson_column", () -> new BlockItem(CRIMSON_COLUMN.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> WARPED_COLUMN_ITEM = ItemRegistration.ITEMS.register("warped_column", () -> new BlockItem(WARPED_COLUMN.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> BLACKSTONE_COLUMN_ITEM = ItemRegistration.ITEMS.register("blackstone_column", () -> new BlockItem(BLACKSTONE_COLUMN.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> POLISHED_BLACKSTONE_BRICK_COLUMN_ITEM = ItemRegistration.ITEMS.register("polished_blackstone_brick_column", () -> new BlockItem(POLISHED_BLACKSTONE_BRICK_COLUMN.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> POLISHED_BLACKSTONE_COLUMN_ITEM = ItemRegistration.ITEMS.register("polished_blackstone_column", () -> new BlockItem(POLISHED_BLACKSTONE_COLUMN.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> OXIDIZED_CUT_COPPER_COLUMN_ITEM = ItemRegistration.ITEMS.register("oxidized_cut_copper_column", () -> new BlockItem(OXIDIZED_CUT_COPPER_COLUMN.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> WEATHERED_CUT_COPPER_COLUMN_ITEM = ItemRegistration.ITEMS.register("weathered_cut_copper_column", () -> new BlockItem(WEATHERED_CUT_COPPER_COLUMN.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> EXPOSED_CUT_COPPER_COLUMN_ITEM = ItemRegistration.ITEMS.register("exposed_cut_copper_column", () -> new BlockItem(EXPOSED_CUT_COPPER_COLUMN.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> CUT_COPPER_COLUMN_ITEM = ItemRegistration.ITEMS.register("cut_copper_column", () -> new BlockItem(CUT_COPPER_COLUMN.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> WAXED_OXIDIZED_CUT_COPPER_COLUMN_ITEM = ItemRegistration.ITEMS.register("waxed_oxidized_cut_copper_column", () -> new BlockItem(WAXED_OXIDIZED_CUT_COPPER_COLUMN.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> WAXED_WEATHERED_CUT_COPPER_COLUMN_ITEM = ItemRegistration.ITEMS.register("waxed_weathered_cut_copper_column", () -> new BlockItem(WAXED_WEATHERED_CUT_COPPER_COLUMN.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> WAXED_EXPOSED_CUT_COPPER_COLUMN_ITEM = ItemRegistration.ITEMS.register("waxed_exposed_cut_copper_column", () -> new BlockItem(WAXED_EXPOSED_CUT_COPPER_COLUMN.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> WAXED_CUT_COPPER_COLUMN_ITEM = ItemRegistration.ITEMS.register("waxed_cut_copper_column", () -> new BlockItem(WAXED_CUT_COPPER_COLUMN.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> COBBLED_DEEPSLATE_COLUMN_ITEM = ItemRegistration.ITEMS.register("cobbled_deepslate_column", () -> new BlockItem(COBBLED_DEEPSLATE_COLUMN.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> POLISHED_DEEPSLATE_COLUMN_ITEM = ItemRegistration.ITEMS.register("polished_deepslate_column", () -> new BlockItem(POLISHED_DEEPSLATE_COLUMN.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> DEEPSLATE_TILE_COLUMN_ITEM = ItemRegistration.ITEMS.register("deepslate_tile_column", () -> new BlockItem(DEEPSLATE_TILE_COLUMN.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> DEEPSLATE_BRICK_COLUMN_ITEM = ItemRegistration.ITEMS.register("deepslate_brick_column", () -> new BlockItem(DEEPSLATE_BRICK_COLUMN.get(), new Item.Properties()));

    @Contract("_ -> new")
    @SuppressWarnings("deprecation")
    public static @NotNull ColumnBlock usageColumnBlock(@NotNull Block propertyBlock) {
        return new ColumnBlock(propertyBlock.defaultBlockState(), BlockBehaviour.Properties.ofLegacyCopy(propertyBlock));
    }

    @Contract("_, _ -> new")
    @SuppressWarnings("deprecation")
    public static @NotNull WeatheredCopperColumn usageWeatheredColumn(@NotNull Block propertyBlock, WeatheringCopper.WeatherState weatherState) {
        return new WeatheredCopperColumn(propertyBlock.defaultBlockState(), BlockBehaviour.Properties.ofLegacyCopy(propertyBlock), weatherState);
    }
}
