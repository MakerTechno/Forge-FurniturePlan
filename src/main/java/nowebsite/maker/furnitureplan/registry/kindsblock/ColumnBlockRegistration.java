package nowebsite.maker.furnitureplan.registry.kindsblock;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.RegistryObject;
import nowebsite.maker.furnitureplan.blocks.columns.ColumnBlock;
import nowebsite.maker.furnitureplan.blocks.columns.WeatheredCopperColumn;
import nowebsite.maker.furnitureplan.registry.BlockRegistration;
import nowebsite.maker.furnitureplan.registry.ItemRegistration;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class ColumnBlockRegistration {
    public static void init(){}

    public static final RegistryObject<ColumnBlock> OAK_COLUMNS = BlockRegistration.BLOCKS.register("oak_columns", () -> usageColumnBlock(Blocks.OAK_PLANKS));
    public static final RegistryObject<ColumnBlock> COBBLESTONE_COLUMNS = BlockRegistration.BLOCKS.register("cobblestone_columns", () -> usageColumnBlock(Blocks.COBBLESTONE));
    public static final RegistryObject<ColumnBlock> BRICK_COLUMNS = BlockRegistration.BLOCKS.register("brick_columns", () -> usageColumnBlock(Blocks.BRICKS));
    public static final RegistryObject<ColumnBlock> STONE_BRICK_COLUMNS = BlockRegistration.BLOCKS.register("stone_brick_columns", () -> usageColumnBlock(Blocks.STONE_BRICKS));
    public static final RegistryObject<ColumnBlock> MUD_BRICK_COLUMNS = BlockRegistration.BLOCKS.register("mud_brick_columns", () -> usageColumnBlock(Blocks.MUD_BRICKS));
    public static final RegistryObject<ColumnBlock> NETHER_BRICK_COLUMNS = BlockRegistration.BLOCKS.register("nether_brick_columns", () -> usageColumnBlock(Blocks.NETHER_BRICKS));
    public static final RegistryObject<ColumnBlock> SANDSTONE_COLUMNS = BlockRegistration.BLOCKS.register("sandstone_columns", () -> usageColumnBlock(Blocks.SANDSTONE));
    public static final RegistryObject<ColumnBlock> SPRUCE_COLUMNS = BlockRegistration.BLOCKS.register("spruce_columns", () -> usageColumnBlock(Blocks.SPRUCE_PLANKS));
    public static final RegistryObject<ColumnBlock> BIRCH_COLUMNS = BlockRegistration.BLOCKS.register("birch_columns", () -> usageColumnBlock(Blocks.BIRCH_PLANKS));
    public static final RegistryObject<ColumnBlock> JUNGLE_COLUMNS = BlockRegistration.BLOCKS.register("jungle_columns", () -> usageColumnBlock(Blocks.JUNGLE_PLANKS));
    public static final RegistryObject<ColumnBlock> QUARTZ_COLUMNS = BlockRegistration.BLOCKS.register("quartz_columns", () -> usageColumnBlock(Blocks.QUARTZ_BLOCK));
    public static final RegistryObject<ColumnBlock> ACACIA_COLUMNS = BlockRegistration.BLOCKS.register("acacia_columns", () -> usageColumnBlock(Blocks.ACACIA_PLANKS));
    public static final RegistryObject<ColumnBlock> CHERRY_COLUMNS = BlockRegistration.BLOCKS.register("cherry_columns", () -> usageColumnBlock(Blocks.CHERRY_PLANKS));
    public static final RegistryObject<ColumnBlock> DARK_OAK_COLUMNS = BlockRegistration.BLOCKS.register("dark_oak_columns", () -> usageColumnBlock(Blocks.DARK_OAK_PLANKS));
    public static final RegistryObject<ColumnBlock> MANGROVE_COLUMNS = BlockRegistration.BLOCKS.register("mangrove_columns", () -> usageColumnBlock(Blocks.MANGROVE_PLANKS));
    public static final RegistryObject<ColumnBlock> BAMBOO_COLUMNS = BlockRegistration.BLOCKS.register("bamboo_columns", () -> usageColumnBlock(Blocks.BAMBOO_PLANKS));
    public static final RegistryObject<ColumnBlock> BAMBOO_MOSAIC_COLUMNS = BlockRegistration.BLOCKS.register("bamboo_mosaic_columns", () -> usageColumnBlock(Blocks.BAMBOO_MOSAIC));
    public static final RegistryObject<ColumnBlock> PRISMARINE_COLUMNS = BlockRegistration.BLOCKS.register("prismarine_columns", () -> usageColumnBlock(Blocks.PRISMARINE));
    public static final RegistryObject<ColumnBlock> PRISMARINE_BRICK_COLUMNS = BlockRegistration.BLOCKS.register("prismarine_brick_columns", () -> usageColumnBlock(Blocks.PRISMARINE_BRICKS));
    public static final RegistryObject<ColumnBlock> DARK_PRISMARINE_COLUMNS = BlockRegistration.BLOCKS.register("dark_prismarine_columns", () -> usageColumnBlock(Blocks.DARK_PRISMARINE));
    public static final RegistryObject<ColumnBlock> RED_SANDSTONE_COLUMNS = BlockRegistration.BLOCKS.register("red_sandstone_columns", () -> usageColumnBlock(Blocks.RED_SANDSTONE));
    public static final RegistryObject<ColumnBlock> PURPUR_COLUMNS = BlockRegistration.BLOCKS.register("purpur_columns", () -> usageColumnBlock(Blocks.PURPUR_BLOCK));
    public static final RegistryObject<ColumnBlock> POLISHED_GRANITE_COLUMNS = BlockRegistration.BLOCKS.register("polished_granite_columns", () -> usageColumnBlock(Blocks.POLISHED_GRANITE));
    public static final RegistryObject<ColumnBlock> SMOOTH_RED_SANDSTONE_COLUMNS = BlockRegistration.BLOCKS.register("smooth_red_sandstone_columns", () -> usageColumnBlock(Blocks.SMOOTH_RED_SANDSTONE));
    public static final RegistryObject<ColumnBlock> MOSSY_STONE_BRICK_COLUMNS = BlockRegistration.BLOCKS.register("mossy_stone_brick_columns", () -> usageColumnBlock(Blocks.MOSSY_STONE_BRICKS));
    public static final RegistryObject<ColumnBlock> POLISHED_DIORITE_COLUMNS = BlockRegistration.BLOCKS.register("polished_diorite_columns", () -> usageColumnBlock(Blocks.POLISHED_DIORITE));
    public static final RegistryObject<ColumnBlock> MOSSY_COBBLESTONE_COLUMNS = BlockRegistration.BLOCKS.register("mossy_cobblestone_columns", () -> usageColumnBlock(Blocks.MOSSY_COBBLESTONE));
    public static final RegistryObject<ColumnBlock> END_STONE_BRICK_COLUMNS = BlockRegistration.BLOCKS.register("end_stone_brick_columns", () -> usageColumnBlock(Blocks.END_STONE_BRICKS));
    public static final RegistryObject<ColumnBlock> STONE_COLUMNS = BlockRegistration.BLOCKS.register("stone_columns", () -> usageColumnBlock(Blocks.STONE));
    public static final RegistryObject<ColumnBlock> SMOOTH_SANDSTONE_COLUMNS = BlockRegistration.BLOCKS.register("smooth_sandstone_columns", () -> usageColumnBlock(Blocks.SMOOTH_SANDSTONE));
    public static final RegistryObject<ColumnBlock> SMOOTH_QUARTZ_COLUMNS = BlockRegistration.BLOCKS.register("smooth_quartz_columns", () -> usageColumnBlock(Blocks.SMOOTH_QUARTZ));
    public static final RegistryObject<ColumnBlock> GRANITE_COLUMNS = BlockRegistration.BLOCKS.register("granite_columns", () -> usageColumnBlock(Blocks.GRANITE));
    public static final RegistryObject<ColumnBlock> ANDESITE_COLUMNS = BlockRegistration.BLOCKS.register("andesite_columns", () -> usageColumnBlock(Blocks.ANDESITE));
    public static final RegistryObject<ColumnBlock> RED_NETHER_BRICK_COLUMNS = BlockRegistration.BLOCKS.register("red_nether_brick_columns", () -> usageColumnBlock(Blocks.RED_NETHER_BRICKS));
    public static final RegistryObject<ColumnBlock> POLISHED_ANDESITE_COLUMNS = BlockRegistration.BLOCKS.register("polished_andesite_columns", () -> usageColumnBlock(Blocks.POLISHED_ANDESITE));
    public static final RegistryObject<ColumnBlock> DIORITE_COLUMNS = BlockRegistration.BLOCKS.register("diorite_columns", () -> usageColumnBlock(Blocks.DIORITE));
    public static final RegistryObject<ColumnBlock> CRIMSON_COLUMNS = BlockRegistration.BLOCKS.register("crimson_columns", () -> usageColumnBlock(Blocks.CRIMSON_PLANKS));
    public static final RegistryObject<ColumnBlock> WARPED_COLUMNS = BlockRegistration.BLOCKS.register("warped_columns", () -> usageColumnBlock(Blocks.WARPED_PLANKS));
    public static final RegistryObject<ColumnBlock> BLACKSTONE_COLUMNS = BlockRegistration.BLOCKS.register("blackstone_columns", () -> usageColumnBlock(Blocks.BLACKSTONE));
    public static final RegistryObject<ColumnBlock> POLISHED_BLACKSTONE_BRICK_COLUMNS = BlockRegistration.BLOCKS.register("polished_blackstone_brick_columns", () -> usageColumnBlock(Blocks.POLISHED_BLACKSTONE_BRICKS));
    public static final RegistryObject<ColumnBlock> POLISHED_BLACKSTONE_COLUMNS = BlockRegistration.BLOCKS.register("polished_blackstone_columns", () -> usageColumnBlock(Blocks.POLISHED_BLACKSTONE));
    public static final RegistryObject<WeatheredCopperColumn> OXIDIZED_CUT_COPPER_COLUMNS = BlockRegistration.BLOCKS.register("oxidized_cut_copper_columns", () -> usageWeatheredColumn(Blocks.OXIDIZED_CUT_COPPER, WeatheringCopper.WeatherState.OXIDIZED));
    public static final RegistryObject<WeatheredCopperColumn> WEATHERED_CUT_COPPER_COLUMNS = BlockRegistration.BLOCKS.register("weathered_cut_copper_columns", () -> usageWeatheredColumn(Blocks.WEATHERED_CUT_COPPER, WeatheringCopper.WeatherState.WEATHERED));
    public static final RegistryObject<WeatheredCopperColumn> EXPOSED_CUT_COPPER_COLUMNS = BlockRegistration.BLOCKS.register("exposed_cut_copper_columns", () -> usageWeatheredColumn(Blocks.EXPOSED_CUT_COPPER, WeatheringCopper.WeatherState.EXPOSED));
    public static final RegistryObject<WeatheredCopperColumn> CUT_COPPER_COLUMNS = BlockRegistration.BLOCKS.register("cut_copper_columns", () -> usageWeatheredColumn(Blocks.CUT_COPPER, WeatheringCopper.WeatherState.UNAFFECTED));
    public static final RegistryObject<ColumnBlock> WAXED_OXIDIZED_CUT_COPPER_COLUMNS = BlockRegistration.BLOCKS.register("waxed_oxidized_cut_copper_columns", () -> usageColumnBlock(Blocks.WAXED_OXIDIZED_CUT_COPPER));
    public static final RegistryObject<ColumnBlock> WAXED_WEATHERED_CUT_COPPER_COLUMNS = BlockRegistration.BLOCKS.register("waxed_weathered_cut_copper_columns", () -> usageColumnBlock(Blocks.WAXED_WEATHERED_CUT_COPPER));
    public static final RegistryObject<ColumnBlock> WAXED_EXPOSED_CUT_COPPER_COLUMNS = BlockRegistration.BLOCKS.register("waxed_exposed_cut_copper_columns", () -> usageColumnBlock(Blocks.WAXED_EXPOSED_CUT_COPPER));
    public static final RegistryObject<ColumnBlock> WAXED_CUT_COPPER_COLUMNS = BlockRegistration.BLOCKS.register("waxed_cut_copper_columns", () -> usageColumnBlock(Blocks.WAXED_CUT_COPPER));
    public static final RegistryObject<ColumnBlock> COBBLED_DEEPSLATE_COLUMNS = BlockRegistration.BLOCKS.register("cobbled_deepslate_columns", () -> usageColumnBlock(Blocks.COBBLED_DEEPSLATE));
    public static final RegistryObject<ColumnBlock> POLISHED_DEEPSLATE_COLUMNS = BlockRegistration.BLOCKS.register("polished_deepslate_columns", () -> usageColumnBlock(Blocks.POLISHED_DEEPSLATE));
    public static final RegistryObject<ColumnBlock> DEEPSLATE_TILE_COLUMNS = BlockRegistration.BLOCKS.register("deepslate_tile_columns", () -> usageColumnBlock(Blocks.DEEPSLATE_TILES));
    public static final RegistryObject<ColumnBlock> DEEPSLATE_BRICK_COLUMNS = BlockRegistration.BLOCKS.register("deepslate_brick_columns", () -> usageColumnBlock(Blocks.DEEPSLATE_BRICKS));
    public static final RegistryObject<BlockItem> OAK_COLUMNS_ITEM = ItemRegistration.ITEMS.register("oak_columns", () -> new BlockItem(OAK_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> COBBLESTONE_COLUMNS_ITEM = ItemRegistration.ITEMS.register("cobblestone_columns", () -> new BlockItem(COBBLESTONE_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> BRICK_COLUMNS_ITEM = ItemRegistration.ITEMS.register("brick_columns", () -> new BlockItem(BRICK_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> STONE_BRICK_COLUMNS_ITEM = ItemRegistration.ITEMS.register("stone_brick_columns", () -> new BlockItem(STONE_BRICK_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> MUD_BRICK_COLUMNS_ITEM = ItemRegistration.ITEMS.register("mud_brick_columns", () -> new BlockItem(MUD_BRICK_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> NETHER_BRICK_COLUMNS_ITEM = ItemRegistration.ITEMS.register("nether_brick_columns", () -> new BlockItem(NETHER_BRICK_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> SANDSTONE_COLUMNS_ITEM = ItemRegistration.ITEMS.register("sandstone_columns", () -> new BlockItem(SANDSTONE_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> SPRUCE_COLUMNS_ITEM = ItemRegistration.ITEMS.register("spruce_columns", () -> new BlockItem(SPRUCE_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> BIRCH_COLUMNS_ITEM = ItemRegistration.ITEMS.register("birch_columns", () -> new BlockItem(BIRCH_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> JUNGLE_COLUMNS_ITEM = ItemRegistration.ITEMS.register("jungle_columns", () -> new BlockItem(JUNGLE_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> QUARTZ_COLUMNS_ITEM = ItemRegistration.ITEMS.register("quartz_columns", () -> new BlockItem(QUARTZ_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> ACACIA_COLUMNS_ITEM = ItemRegistration.ITEMS.register("acacia_columns", () -> new BlockItem(ACACIA_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> CHERRY_COLUMNS_ITEM = ItemRegistration.ITEMS.register("cherry_columns", () -> new BlockItem(CHERRY_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> DARK_OAK_COLUMNS_ITEM = ItemRegistration.ITEMS.register("dark_oak_columns", () -> new BlockItem(DARK_OAK_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> MANGROVE_COLUMNS_ITEM = ItemRegistration.ITEMS.register("mangrove_columns", () -> new BlockItem(MANGROVE_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> BAMBOO_COLUMNS_ITEM = ItemRegistration.ITEMS.register("bamboo_columns", () -> new BlockItem(BAMBOO_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> BAMBOO_MOSAIC_COLUMNS_ITEM = ItemRegistration.ITEMS.register("bamboo_mosaic_columns", () -> new BlockItem(BAMBOO_MOSAIC_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> PRISMARINE_COLUMNS_ITEM = ItemRegistration.ITEMS.register("prismarine_columns", () -> new BlockItem(PRISMARINE_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> PRISMARINE_BRICK_COLUMNS_ITEM = ItemRegistration.ITEMS.register("prismarine_brick_columns", () -> new BlockItem(PRISMARINE_BRICK_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> DARK_PRISMARINE_COLUMNS_ITEM = ItemRegistration.ITEMS.register("dark_prismarine_columns", () -> new BlockItem(DARK_PRISMARINE_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> RED_SANDSTONE_COLUMNS_ITEM = ItemRegistration.ITEMS.register("red_sandstone_columns", () -> new BlockItem(RED_SANDSTONE_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> PURPUR_COLUMNS_ITEM = ItemRegistration.ITEMS.register("purpur_columns", () -> new BlockItem(PURPUR_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> POLISHED_GRANITE_COLUMNS_ITEM = ItemRegistration.ITEMS.register("polished_granite_columns", () -> new BlockItem(POLISHED_GRANITE_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> SMOOTH_RED_SANDSTONE_COLUMNS_ITEM = ItemRegistration.ITEMS.register("smooth_red_sandstone_columns", () -> new BlockItem(SMOOTH_RED_SANDSTONE_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> MOSSY_STONE_BRICK_COLUMNS_ITEM = ItemRegistration.ITEMS.register("mossy_stone_brick_columns", () -> new BlockItem(MOSSY_STONE_BRICK_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> POLISHED_DIORITE_COLUMNS_ITEM = ItemRegistration.ITEMS.register("polished_diorite_columns", () -> new BlockItem(POLISHED_DIORITE_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> MOSSY_COBBLESTONE_COLUMNS_ITEM = ItemRegistration.ITEMS.register("mossy_cobblestone_columns", () -> new BlockItem(MOSSY_COBBLESTONE_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> END_STONE_BRICK_COLUMNS_ITEM = ItemRegistration.ITEMS.register("end_stone_brick_columns", () -> new BlockItem(END_STONE_BRICK_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> STONE_COLUMNS_ITEM = ItemRegistration.ITEMS.register("stone_columns", () -> new BlockItem(STONE_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> SMOOTH_SANDSTONE_COLUMNS_ITEM = ItemRegistration.ITEMS.register("smooth_sandstone_columns", () -> new BlockItem(SMOOTH_SANDSTONE_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> SMOOTH_QUARTZ_COLUMNS_ITEM = ItemRegistration.ITEMS.register("smooth_quartz_columns", () -> new BlockItem(SMOOTH_QUARTZ_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> GRANITE_COLUMNS_ITEM = ItemRegistration.ITEMS.register("granite_columns", () -> new BlockItem(GRANITE_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> ANDESITE_COLUMNS_ITEM = ItemRegistration.ITEMS.register("andesite_columns", () -> new BlockItem(ANDESITE_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> RED_NETHER_BRICK_COLUMNS_ITEM = ItemRegistration.ITEMS.register("red_nether_brick_columns", () -> new BlockItem(RED_NETHER_BRICK_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> POLISHED_ANDESITE_COLUMNS_ITEM = ItemRegistration.ITEMS.register("polished_andesite_columns", () -> new BlockItem(POLISHED_ANDESITE_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> DIORITE_COLUMNS_ITEM = ItemRegistration.ITEMS.register("diorite_columns", () -> new BlockItem(DIORITE_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> CRIMSON_COLUMNS_ITEM = ItemRegistration.ITEMS.register("crimson_columns", () -> new BlockItem(CRIMSON_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> WARPED_COLUMNS_ITEM = ItemRegistration.ITEMS.register("warped_columns", () -> new BlockItem(WARPED_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> BLACKSTONE_COLUMNS_ITEM = ItemRegistration.ITEMS.register("blackstone_columns", () -> new BlockItem(BLACKSTONE_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> POLISHED_BLACKSTONE_BRICK_COLUMNS_ITEM = ItemRegistration.ITEMS.register("polished_blackstone_brick_columns", () -> new BlockItem(POLISHED_BLACKSTONE_BRICK_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> POLISHED_BLACKSTONE_COLUMNS_ITEM = ItemRegistration.ITEMS.register("polished_blackstone_columns", () -> new BlockItem(POLISHED_BLACKSTONE_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> OXIDIZED_CUT_COPPER_COLUMNS_ITEM = ItemRegistration.ITEMS.register("oxidized_cut_copper_columns", () -> new BlockItem(OXIDIZED_CUT_COPPER_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> WEATHERED_CUT_COPPER_COLUMNS_ITEM = ItemRegistration.ITEMS.register("weathered_cut_copper_columns", () -> new BlockItem(WEATHERED_CUT_COPPER_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> EXPOSED_CUT_COPPER_COLUMNS_ITEM = ItemRegistration.ITEMS.register("exposed_cut_copper_columns", () -> new BlockItem(EXPOSED_CUT_COPPER_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> CUT_COPPER_COLUMNS_ITEM = ItemRegistration.ITEMS.register("cut_copper_columns", () -> new BlockItem(CUT_COPPER_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> WAXED_OXIDIZED_CUT_COPPER_COLUMNS_ITEM = ItemRegistration.ITEMS.register("waxed_oxidized_cut_copper_columns", () -> new BlockItem(WAXED_OXIDIZED_CUT_COPPER_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> WAXED_WEATHERED_CUT_COPPER_COLUMNS_ITEM = ItemRegistration.ITEMS.register("waxed_weathered_cut_copper_columns", () -> new BlockItem(WAXED_WEATHERED_CUT_COPPER_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> WAXED_EXPOSED_CUT_COPPER_COLUMNS_ITEM = ItemRegistration.ITEMS.register("waxed_exposed_cut_copper_columns", () -> new BlockItem(WAXED_EXPOSED_CUT_COPPER_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> WAXED_CUT_COPPER_COLUMNS_ITEM = ItemRegistration.ITEMS.register("waxed_cut_copper_columns", () -> new BlockItem(WAXED_CUT_COPPER_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> COBBLED_DEEPSLATE_COLUMNS_ITEM = ItemRegistration.ITEMS.register("cobbled_deepslate_columns", () -> new BlockItem(COBBLED_DEEPSLATE_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> POLISHED_DEEPSLATE_COLUMNS_ITEM = ItemRegistration.ITEMS.register("polished_deepslate_columns", () -> new BlockItem(POLISHED_DEEPSLATE_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> DEEPSLATE_TILE_COLUMNS_ITEM = ItemRegistration.ITEMS.register("deepslate_tile_columns", () -> new BlockItem(DEEPSLATE_TILE_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> DEEPSLATE_BRICK_COLUMNS_ITEM = ItemRegistration.ITEMS.register("deepslate_brick_columns", () -> new BlockItem(DEEPSLATE_BRICK_COLUMNS.get(), new Item.Properties()));

    @Contract("_ -> new")
    public static @NotNull ColumnBlock usageColumnBlock(@NotNull Block propertyBlock) {
        return new ColumnBlock(propertyBlock.defaultBlockState(), BlockBehaviour.Properties.copy(propertyBlock));
    }

    @Contract("_, _ -> new")
    public static @NotNull WeatheredCopperColumn usageWeatheredColumn(@NotNull Block propertyBlock, WeatheringCopper.WeatherState weatherState) {
        return new WeatheredCopperColumn(propertyBlock.defaultBlockState(), BlockBehaviour.Properties.copy(propertyBlock), weatherState);
    }
}
