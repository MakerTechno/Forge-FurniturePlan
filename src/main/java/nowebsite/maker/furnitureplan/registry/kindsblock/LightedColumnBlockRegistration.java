package nowebsite.maker.furnitureplan.registry.kindsblock;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.RegistryObject;
import nowebsite.maker.furnitureplan.blocks.LightedColumnBlock;
import nowebsite.maker.furnitureplan.blocks.WeatheredCopperLightedColumn;
import nowebsite.maker.furnitureplan.registry.BlockRegistration;
import nowebsite.maker.furnitureplan.registry.ItemRegistration;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class LightedColumnBlockRegistration {
    public static void init(){}
    
    public static final RegistryObject<LightedColumnBlock> OAK_LIGHTED_COLUMNS = BlockRegistration.BLOCKS.register("oak_lighted_columns", () -> usageLightedColumnBlock(Blocks.OAK_PLANKS));
    public static final RegistryObject<LightedColumnBlock> COBBLESTONE_LIGHTED_COLUMNS = BlockRegistration.BLOCKS.register("cobblestone_lighted_columns", () -> usageLightedColumnBlock(Blocks.COBBLESTONE));
    public static final RegistryObject<LightedColumnBlock> BRICK_LIGHTED_COLUMNS = BlockRegistration.BLOCKS.register("brick_lighted_columns", () -> usageLightedColumnBlock(Blocks.BRICKS));
    public static final RegistryObject<LightedColumnBlock> STONE_BRICK_LIGHTED_COLUMNS = BlockRegistration.BLOCKS.register("stone_brick_lighted_columns", () -> usageLightedColumnBlock(Blocks.STONE_BRICKS));
    public static final RegistryObject<LightedColumnBlock> MUD_BRICK_LIGHTED_COLUMNS = BlockRegistration.BLOCKS.register("mud_brick_lighted_columns", () -> usageLightedColumnBlock(Blocks.MUD_BRICKS));
    public static final RegistryObject<LightedColumnBlock> NETHER_BRICK_LIGHTED_COLUMNS = BlockRegistration.BLOCKS.register("nether_brick_lighted_columns", () -> usageLightedColumnBlock(Blocks.NETHER_BRICKS));
    public static final RegistryObject<LightedColumnBlock> SANDSTONE_LIGHTED_COLUMNS = BlockRegistration.BLOCKS.register("sandstone_lighted_columns", () -> usageLightedColumnBlock(Blocks.SANDSTONE));
    public static final RegistryObject<LightedColumnBlock> SPRUCE_LIGHTED_COLUMNS = BlockRegistration.BLOCKS.register("spruce_lighted_columns", () -> usageLightedColumnBlock(Blocks.SPRUCE_PLANKS));
    public static final RegistryObject<LightedColumnBlock> BIRCH_LIGHTED_COLUMNS = BlockRegistration.BLOCKS.register("birch_lighted_columns", () -> usageLightedColumnBlock(Blocks.BIRCH_PLANKS));
    public static final RegistryObject<LightedColumnBlock> JUNGLE_LIGHTED_COLUMNS = BlockRegistration.BLOCKS.register("jungle_lighted_columns", () -> usageLightedColumnBlock(Blocks.JUNGLE_PLANKS));
    public static final RegistryObject<LightedColumnBlock> QUARTZ_LIGHTED_COLUMNS = BlockRegistration.BLOCKS.register("quartz_lighted_columns", () -> usageLightedColumnBlock(Blocks.QUARTZ_BLOCK));
    public static final RegistryObject<LightedColumnBlock> ACACIA_LIGHTED_COLUMNS = BlockRegistration.BLOCKS.register("acacia_lighted_columns", () -> usageLightedColumnBlock(Blocks.ACACIA_PLANKS));
    public static final RegistryObject<LightedColumnBlock> CHERRY_LIGHTED_COLUMNS = BlockRegistration.BLOCKS.register("cherry_lighted_columns", () -> usageLightedColumnBlock(Blocks.CHERRY_PLANKS));
    public static final RegistryObject<LightedColumnBlock> DARK_OAK_LIGHTED_COLUMNS = BlockRegistration.BLOCKS.register("dark_oak_lighted_columns", () -> usageLightedColumnBlock(Blocks.DARK_OAK_PLANKS));
    public static final RegistryObject<LightedColumnBlock> MANGROVE_LIGHTED_COLUMNS = BlockRegistration.BLOCKS.register("mangrove_lighted_columns", () -> usageLightedColumnBlock(Blocks.MANGROVE_PLANKS));
    public static final RegistryObject<LightedColumnBlock> BAMBOO_LIGHTED_COLUMNS = BlockRegistration.BLOCKS.register("bamboo_lighted_columns", () -> usageLightedColumnBlock(Blocks.BAMBOO_PLANKS));
    public static final RegistryObject<LightedColumnBlock> BAMBOO_MOSAIC_LIGHTED_COLUMNS = BlockRegistration.BLOCKS.register("bamboo_mosaic_lighted_columns", () -> usageLightedColumnBlock(Blocks.BAMBOO_MOSAIC));
    public static final RegistryObject<LightedColumnBlock> PRISMARINE_LIGHTED_COLUMNS = BlockRegistration.BLOCKS.register("prismarine_lighted_columns", () -> usageLightedColumnBlock(Blocks.PRISMARINE));
    public static final RegistryObject<LightedColumnBlock> PRISMARINE_BRICK_LIGHTED_COLUMNS = BlockRegistration.BLOCKS.register("prismarine_brick_lighted_columns", () -> usageLightedColumnBlock(Blocks.PRISMARINE_BRICKS));
    public static final RegistryObject<LightedColumnBlock> DARK_PRISMARINE_LIGHTED_COLUMNS = BlockRegistration.BLOCKS.register("dark_prismarine_lighted_columns", () -> usageLightedColumnBlock(Blocks.DARK_PRISMARINE));
    public static final RegistryObject<LightedColumnBlock> RED_SANDSTONE_LIGHTED_COLUMNS = BlockRegistration.BLOCKS.register("red_sandstone_lighted_columns", () -> usageLightedColumnBlock(Blocks.RED_SANDSTONE));
    public static final RegistryObject<LightedColumnBlock> PURPUR_LIGHTED_COLUMNS = BlockRegistration.BLOCKS.register("purpur_lighted_columns", () -> usageLightedColumnBlock(Blocks.PURPUR_BLOCK));
    public static final RegistryObject<LightedColumnBlock> POLISHED_GRANITE_LIGHTED_COLUMNS = BlockRegistration.BLOCKS.register("polished_granite_lighted_columns", () -> usageLightedColumnBlock(Blocks.POLISHED_GRANITE));
    public static final RegistryObject<LightedColumnBlock> SMOOTH_RED_SANDSTONE_LIGHTED_COLUMNS = BlockRegistration.BLOCKS.register("smooth_red_sandstone_lighted_columns", () -> usageLightedColumnBlock(Blocks.SMOOTH_RED_SANDSTONE));
    public static final RegistryObject<LightedColumnBlock> MOSSY_STONE_BRICK_LIGHTED_COLUMNS = BlockRegistration.BLOCKS.register("mossy_stone_brick_lighted_columns", () -> usageLightedColumnBlock(Blocks.MOSSY_STONE_BRICKS));
    public static final RegistryObject<LightedColumnBlock> POLISHED_DIORITE_LIGHTED_COLUMNS = BlockRegistration.BLOCKS.register("polished_diorite_lighted_columns", () -> usageLightedColumnBlock(Blocks.POLISHED_DIORITE));
    public static final RegistryObject<LightedColumnBlock> MOSSY_COBBLESTONE_LIGHTED_COLUMNS = BlockRegistration.BLOCKS.register("mossy_cobblestone_lighted_columns", () -> usageLightedColumnBlock(Blocks.MOSSY_COBBLESTONE));
    public static final RegistryObject<LightedColumnBlock> END_STONE_BRICK_LIGHTED_COLUMNS = BlockRegistration.BLOCKS.register("end_stone_brick_lighted_columns", () -> usageLightedColumnBlock(Blocks.END_STONE_BRICKS));
    public static final RegistryObject<LightedColumnBlock> STONE_LIGHTED_COLUMNS = BlockRegistration.BLOCKS.register("stone_lighted_columns", () -> usageLightedColumnBlock(Blocks.STONE));
    public static final RegistryObject<LightedColumnBlock> SMOOTH_SANDSTONE_LIGHTED_COLUMNS = BlockRegistration.BLOCKS.register("smooth_sandstone_lighted_columns", () -> usageLightedColumnBlock(Blocks.SMOOTH_SANDSTONE));
    public static final RegistryObject<LightedColumnBlock> SMOOTH_QUARTZ_LIGHTED_COLUMNS = BlockRegistration.BLOCKS.register("smooth_quartz_lighted_columns", () -> usageLightedColumnBlock(Blocks.SMOOTH_QUARTZ));
    public static final RegistryObject<LightedColumnBlock> GRANITE_LIGHTED_COLUMNS = BlockRegistration.BLOCKS.register("granite_lighted_columns", () -> usageLightedColumnBlock(Blocks.GRANITE));
    public static final RegistryObject<LightedColumnBlock> ANDESITE_LIGHTED_COLUMNS = BlockRegistration.BLOCKS.register("andesite_lighted_columns", () -> usageLightedColumnBlock(Blocks.ANDESITE));
    public static final RegistryObject<LightedColumnBlock> RED_NETHER_BRICK_LIGHTED_COLUMNS = BlockRegistration.BLOCKS.register("red_nether_brick_lighted_columns", () -> usageLightedColumnBlock(Blocks.RED_NETHER_BRICKS));
    public static final RegistryObject<LightedColumnBlock> POLISHED_ANDESITE_LIGHTED_COLUMNS = BlockRegistration.BLOCKS.register("polished_andesite_lighted_columns", () -> usageLightedColumnBlock(Blocks.POLISHED_ANDESITE));
    public static final RegistryObject<LightedColumnBlock> DIORITE_LIGHTED_COLUMNS = BlockRegistration.BLOCKS.register("diorite_lighted_columns", () -> usageLightedColumnBlock(Blocks.DIORITE));
    public static final RegistryObject<LightedColumnBlock> CRIMSON_LIGHTED_COLUMNS = BlockRegistration.BLOCKS.register("crimson_lighted_columns", () -> usageLightedColumnBlock(Blocks.CRIMSON_PLANKS));
    public static final RegistryObject<LightedColumnBlock> WARPED_LIGHTED_COLUMNS = BlockRegistration.BLOCKS.register("warped_lighted_columns", () -> usageLightedColumnBlock(Blocks.WARPED_PLANKS));
    public static final RegistryObject<LightedColumnBlock> BLACKSTONE_LIGHTED_COLUMNS = BlockRegistration.BLOCKS.register("blackstone_lighted_columns", () -> usageLightedColumnBlock(Blocks.BLACKSTONE));
    public static final RegistryObject<LightedColumnBlock> POLISHED_BLACKSTONE_BRICK_LIGHTED_COLUMNS = BlockRegistration.BLOCKS.register("polished_blackstone_brick_lighted_columns", () -> usageLightedColumnBlock(Blocks.POLISHED_BLACKSTONE_BRICKS));
    public static final RegistryObject<LightedColumnBlock> POLISHED_BLACKSTONE_LIGHTED_COLUMNS = BlockRegistration.BLOCKS.register("polished_blackstone_lighted_columns", () -> usageLightedColumnBlock(Blocks.POLISHED_BLACKSTONE));
    public static final RegistryObject<WeatheredCopperLightedColumn> OXIDIZED_CUT_COPPER_LIGHTED_COLUMNS = BlockRegistration.BLOCKS.register("oxidized_cut_copper_lighted_columns", () -> usageWeatheredLightedColumn(Blocks.OXIDIZED_CUT_COPPER, WeatheringCopper.WeatherState.OXIDIZED));
    public static final RegistryObject<WeatheredCopperLightedColumn> WEATHERED_CUT_COPPER_LIGHTED_COLUMNS = BlockRegistration.BLOCKS.register("weathered_cut_copper_lighted_columns", () -> usageWeatheredLightedColumn(Blocks.WEATHERED_CUT_COPPER, WeatheringCopper.WeatherState.WEATHERED));
    public static final RegistryObject<WeatheredCopperLightedColumn> EXPOSED_CUT_COPPER_LIGHTED_COLUMNS = BlockRegistration.BLOCKS.register("exposed_cut_copper_lighted_columns", () -> usageWeatheredLightedColumn(Blocks.EXPOSED_CUT_COPPER, WeatheringCopper.WeatherState.EXPOSED));
    public static final RegistryObject<WeatheredCopperLightedColumn> CUT_COPPER_LIGHTED_COLUMNS = BlockRegistration.BLOCKS.register("cut_copper_lighted_columns", () -> usageWeatheredLightedColumn(Blocks.CUT_COPPER, WeatheringCopper.WeatherState.UNAFFECTED));
    public static final RegistryObject<LightedColumnBlock> WAXED_OXIDIZED_CUT_COPPER_LIGHTED_COLUMNS = BlockRegistration.BLOCKS.register("waxed_oxidized_cut_copper_lighted_columns", () -> usageLightedColumnBlock(Blocks.WAXED_OXIDIZED_CUT_COPPER));
    public static final RegistryObject<LightedColumnBlock> WAXED_WEATHERED_CUT_COPPER_LIGHTED_COLUMNS = BlockRegistration.BLOCKS.register("waxed_weathered_cut_copper_lighted_columns", () -> usageLightedColumnBlock(Blocks.WAXED_WEATHERED_CUT_COPPER));
    public static final RegistryObject<LightedColumnBlock> WAXED_EXPOSED_CUT_COPPER_LIGHTED_COLUMNS = BlockRegistration.BLOCKS.register("waxed_exposed_cut_copper_lighted_columns", () -> usageLightedColumnBlock(Blocks.WAXED_EXPOSED_CUT_COPPER));
    public static final RegistryObject<LightedColumnBlock> WAXED_CUT_COPPER_LIGHTED_COLUMNS = BlockRegistration.BLOCKS.register("waxed_cut_copper_lighted_columns", () -> usageLightedColumnBlock(Blocks.WAXED_CUT_COPPER));
    public static final RegistryObject<LightedColumnBlock> COBBLED_DEEPSLATE_LIGHTED_COLUMNS = BlockRegistration.BLOCKS.register("cobbled_deepslate_lighted_columns", () -> usageLightedColumnBlock(Blocks.COBBLED_DEEPSLATE));
    public static final RegistryObject<LightedColumnBlock> POLISHED_DEEPSLATE_LIGHTED_COLUMNS = BlockRegistration.BLOCKS.register("polished_deepslate_lighted_columns", () -> usageLightedColumnBlock(Blocks.POLISHED_DEEPSLATE));
    public static final RegistryObject<LightedColumnBlock> DEEPSLATE_TILE_LIGHTED_COLUMNS = BlockRegistration.BLOCKS.register("deepslate_tile_lighted_columns", () -> usageLightedColumnBlock(Blocks.DEEPSLATE_TILES));
    public static final RegistryObject<LightedColumnBlock> DEEPSLATE_BRICK_LIGHTED_COLUMNS = BlockRegistration.BLOCKS.register("deepslate_brick_lighted_columns", () -> usageLightedColumnBlock(Blocks.DEEPSLATE_BRICKS));
    public static final RegistryObject<BlockItem> OAK_LIGHTED_COLUMNS_ITEM = ItemRegistration.ITEMS.register("oak_lighted_columns", () -> new BlockItem(OAK_LIGHTED_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> COBBLESTONE_LIGHTED_COLUMNS_ITEM = ItemRegistration.ITEMS.register("cobblestone_lighted_columns", () -> new BlockItem(COBBLESTONE_LIGHTED_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> BRICK_LIGHTED_COLUMNS_ITEM = ItemRegistration.ITEMS.register("brick_lighted_columns", () -> new BlockItem(BRICK_LIGHTED_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> STONE_BRICK_LIGHTED_COLUMNS_ITEM = ItemRegistration.ITEMS.register("stone_brick_lighted_columns", () -> new BlockItem(STONE_BRICK_LIGHTED_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> MUD_BRICK_LIGHTED_COLUMNS_ITEM = ItemRegistration.ITEMS.register("mud_brick_lighted_columns", () -> new BlockItem(MUD_BRICK_LIGHTED_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> NETHER_BRICK_LIGHTED_COLUMNS_ITEM = ItemRegistration.ITEMS.register("nether_brick_lighted_columns", () -> new BlockItem(NETHER_BRICK_LIGHTED_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> SANDSTONE_LIGHTED_COLUMNS_ITEM = ItemRegistration.ITEMS.register("sandstone_lighted_columns", () -> new BlockItem(SANDSTONE_LIGHTED_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> SPRUCE_LIGHTED_COLUMNS_ITEM = ItemRegistration.ITEMS.register("spruce_lighted_columns", () -> new BlockItem(SPRUCE_LIGHTED_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> BIRCH_LIGHTED_COLUMNS_ITEM = ItemRegistration.ITEMS.register("birch_lighted_columns", () -> new BlockItem(BIRCH_LIGHTED_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> JUNGLE_LIGHTED_COLUMNS_ITEM = ItemRegistration.ITEMS.register("jungle_lighted_columns", () -> new BlockItem(JUNGLE_LIGHTED_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> QUARTZ_LIGHTED_COLUMNS_ITEM = ItemRegistration.ITEMS.register("quartz_lighted_columns", () -> new BlockItem(QUARTZ_LIGHTED_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> ACACIA_LIGHTED_COLUMNS_ITEM = ItemRegistration.ITEMS.register("acacia_lighted_columns", () -> new BlockItem(ACACIA_LIGHTED_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> CHERRY_LIGHTED_COLUMNS_ITEM = ItemRegistration.ITEMS.register("cherry_lighted_columns", () -> new BlockItem(CHERRY_LIGHTED_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> DARK_OAK_LIGHTED_COLUMNS_ITEM = ItemRegistration.ITEMS.register("dark_oak_lighted_columns", () -> new BlockItem(DARK_OAK_LIGHTED_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> MANGROVE_LIGHTED_COLUMNS_ITEM = ItemRegistration.ITEMS.register("mangrove_lighted_columns", () -> new BlockItem(MANGROVE_LIGHTED_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> BAMBOO_LIGHTED_COLUMNS_ITEM = ItemRegistration.ITEMS.register("bamboo_lighted_columns", () -> new BlockItem(BAMBOO_LIGHTED_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> BAMBOO_MOSAIC_LIGHTED_COLUMNS_ITEM = ItemRegistration.ITEMS.register("bamboo_mosaic_lighted_columns", () -> new BlockItem(BAMBOO_MOSAIC_LIGHTED_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> PRISMARINE_LIGHTED_COLUMNS_ITEM = ItemRegistration.ITEMS.register("prismarine_lighted_columns", () -> new BlockItem(PRISMARINE_LIGHTED_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> PRISMARINE_BRICK_LIGHTED_COLUMNS_ITEM = ItemRegistration.ITEMS.register("prismarine_brick_lighted_columns", () -> new BlockItem(PRISMARINE_BRICK_LIGHTED_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> DARK_PRISMARINE_LIGHTED_COLUMNS_ITEM = ItemRegistration.ITEMS.register("dark_prismarine_lighted_columns", () -> new BlockItem(DARK_PRISMARINE_LIGHTED_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> RED_SANDSTONE_LIGHTED_COLUMNS_ITEM = ItemRegistration.ITEMS.register("red_sandstone_lighted_columns", () -> new BlockItem(RED_SANDSTONE_LIGHTED_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> PURPUR_LIGHTED_COLUMNS_ITEM = ItemRegistration.ITEMS.register("purpur_lighted_columns", () -> new BlockItem(PURPUR_LIGHTED_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> POLISHED_GRANITE_LIGHTED_COLUMNS_ITEM = ItemRegistration.ITEMS.register("polished_granite_lighted_columns", () -> new BlockItem(POLISHED_GRANITE_LIGHTED_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> SMOOTH_RED_SANDSTONE_LIGHTED_COLUMNS_ITEM = ItemRegistration.ITEMS.register("smooth_red_sandstone_lighted_columns", () -> new BlockItem(SMOOTH_RED_SANDSTONE_LIGHTED_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> MOSSY_STONE_BRICK_LIGHTED_COLUMNS_ITEM = ItemRegistration.ITEMS.register("mossy_stone_brick_lighted_columns", () -> new BlockItem(MOSSY_STONE_BRICK_LIGHTED_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> POLISHED_DIORITE_LIGHTED_COLUMNS_ITEM = ItemRegistration.ITEMS.register("polished_diorite_lighted_columns", () -> new BlockItem(POLISHED_DIORITE_LIGHTED_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> MOSSY_COBBLESTONE_LIGHTED_COLUMNS_ITEM = ItemRegistration.ITEMS.register("mossy_cobblestone_lighted_columns", () -> new BlockItem(MOSSY_COBBLESTONE_LIGHTED_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> END_STONE_BRICK_LIGHTED_COLUMNS_ITEM = ItemRegistration.ITEMS.register("end_stone_brick_lighted_columns", () -> new BlockItem(END_STONE_BRICK_LIGHTED_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> STONE_LIGHTED_COLUMNS_ITEM = ItemRegistration.ITEMS.register("stone_lighted_columns", () -> new BlockItem(STONE_LIGHTED_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> SMOOTH_SANDSTONE_LIGHTED_COLUMNS_ITEM = ItemRegistration.ITEMS.register("smooth_sandstone_lighted_columns", () -> new BlockItem(SMOOTH_SANDSTONE_LIGHTED_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> SMOOTH_QUARTZ_LIGHTED_COLUMNS_ITEM = ItemRegistration.ITEMS.register("smooth_quartz_lighted_columns", () -> new BlockItem(SMOOTH_QUARTZ_LIGHTED_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> GRANITE_LIGHTED_COLUMNS_ITEM = ItemRegistration.ITEMS.register("granite_lighted_columns", () -> new BlockItem(GRANITE_LIGHTED_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> ANDESITE_LIGHTED_COLUMNS_ITEM = ItemRegistration.ITEMS.register("andesite_lighted_columns", () -> new BlockItem(ANDESITE_LIGHTED_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> RED_NETHER_BRICK_LIGHTED_COLUMNS_ITEM = ItemRegistration.ITEMS.register("red_nether_brick_lighted_columns", () -> new BlockItem(RED_NETHER_BRICK_LIGHTED_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> POLISHED_ANDESITE_LIGHTED_COLUMNS_ITEM = ItemRegistration.ITEMS.register("polished_andesite_lighted_columns", () -> new BlockItem(POLISHED_ANDESITE_LIGHTED_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> DIORITE_LIGHTED_COLUMNS_ITEM = ItemRegistration.ITEMS.register("diorite_lighted_columns", () -> new BlockItem(DIORITE_LIGHTED_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> CRIMSON_LIGHTED_COLUMNS_ITEM = ItemRegistration.ITEMS.register("crimson_lighted_columns", () -> new BlockItem(CRIMSON_LIGHTED_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> WARPED_LIGHTED_COLUMNS_ITEM = ItemRegistration.ITEMS.register("warped_lighted_columns", () -> new BlockItem(WARPED_LIGHTED_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> BLACKSTONE_LIGHTED_COLUMNS_ITEM = ItemRegistration.ITEMS.register("blackstone_lighted_columns", () -> new BlockItem(BLACKSTONE_LIGHTED_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> POLISHED_BLACKSTONE_BRICK_LIGHTED_COLUMNS_ITEM = ItemRegistration.ITEMS.register("polished_blackstone_brick_lighted_columns", () -> new BlockItem(POLISHED_BLACKSTONE_BRICK_LIGHTED_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> POLISHED_BLACKSTONE_LIGHTED_COLUMNS_ITEM = ItemRegistration.ITEMS.register("polished_blackstone_lighted_columns", () -> new BlockItem(POLISHED_BLACKSTONE_LIGHTED_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> OXIDIZED_CUT_COPPER_LIGHTED_COLUMNS_ITEM = ItemRegistration.ITEMS.register("oxidized_cut_copper_lighted_columns", () -> new BlockItem(OXIDIZED_CUT_COPPER_LIGHTED_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> WEATHERED_CUT_COPPER_LIGHTED_COLUMNS_ITEM = ItemRegistration.ITEMS.register("weathered_cut_copper_lighted_columns", () -> new BlockItem(WEATHERED_CUT_COPPER_LIGHTED_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> EXPOSED_CUT_COPPER_LIGHTED_COLUMNS_ITEM = ItemRegistration.ITEMS.register("exposed_cut_copper_lighted_columns", () -> new BlockItem(EXPOSED_CUT_COPPER_LIGHTED_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> CUT_COPPER_LIGHTED_COLUMNS_ITEM = ItemRegistration.ITEMS.register("cut_copper_lighted_columns", () -> new BlockItem(CUT_COPPER_LIGHTED_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> WAXED_OXIDIZED_CUT_COPPER_LIGHTED_COLUMNS_ITEM = ItemRegistration.ITEMS.register("waxed_oxidized_cut_copper_lighted_columns", () -> new BlockItem(WAXED_OXIDIZED_CUT_COPPER_LIGHTED_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> WAXED_WEATHERED_CUT_COPPER_LIGHTED_COLUMNS_ITEM = ItemRegistration.ITEMS.register("waxed_weathered_cut_copper_lighted_columns", () -> new BlockItem(WAXED_WEATHERED_CUT_COPPER_LIGHTED_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> WAXED_EXPOSED_CUT_COPPER_LIGHTED_COLUMNS_ITEM = ItemRegistration.ITEMS.register("waxed_exposed_cut_copper_lighted_columns", () -> new BlockItem(WAXED_EXPOSED_CUT_COPPER_LIGHTED_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> WAXED_CUT_COPPER_LIGHTED_COLUMNS_ITEM = ItemRegistration.ITEMS.register("waxed_cut_copper_lighted_columns", () -> new BlockItem(WAXED_CUT_COPPER_LIGHTED_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> COBBLED_DEEPSLATE_LIGHTED_COLUMNS_ITEM = ItemRegistration.ITEMS.register("cobbled_deepslate_lighted_columns", () -> new BlockItem(COBBLED_DEEPSLATE_LIGHTED_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> POLISHED_DEEPSLATE_LIGHTED_COLUMNS_ITEM = ItemRegistration.ITEMS.register("polished_deepslate_lighted_columns", () -> new BlockItem(POLISHED_DEEPSLATE_LIGHTED_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> DEEPSLATE_TILE_LIGHTED_COLUMNS_ITEM = ItemRegistration.ITEMS.register("deepslate_tile_lighted_columns", () -> new BlockItem(DEEPSLATE_TILE_LIGHTED_COLUMNS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> DEEPSLATE_BRICK_LIGHTED_COLUMNS_ITEM = ItemRegistration.ITEMS.register("deepslate_brick_lighted_columns", () -> new BlockItem(DEEPSLATE_BRICK_LIGHTED_COLUMNS.get(), new Item.Properties()));

    @Contract("_ -> new")
    public static @NotNull LightedColumnBlock usageLightedColumnBlock(@NotNull Block propertyBlock) {
        return new LightedColumnBlock(propertyBlock.defaultBlockState(), BlockBehaviour.Properties.copy(propertyBlock));
    }

    @Contract("_, _ -> new")
    public static @NotNull WeatheredCopperLightedColumn usageWeatheredLightedColumn(@NotNull Block propertyBlock, WeatheringCopper.WeatherState weatherState) {
        return new WeatheredCopperLightedColumn(propertyBlock.defaultBlockState(), BlockBehaviour.Properties.copy(propertyBlock), weatherState);
    }
}
