package nowebsite.maker.furnitureplan.registry.kindsblock;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.RegistryObject;
import nowebsite.maker.furnitureplan.blocks.columns.CarvedColumnBlock;
import nowebsite.maker.furnitureplan.blocks.columns.WeatheredCopperCarvedColumnBlock;
import nowebsite.maker.furnitureplan.registry.BlockRegistration;
import nowebsite.maker.furnitureplan.registry.ItemRegistration;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class CarvedColumnBlockRegistration {
    public static void init(){}

    public static final RegistryObject<CarvedColumnBlock> OAK_CARVED_COLUMN = BlockRegistration.BLOCKS.register("oak_carved_column", () -> usageCarvedColumnBlock(Blocks.OAK_PLANKS));
    public static final RegistryObject<CarvedColumnBlock> COBBLESTONE_CARVED_COLUMN = BlockRegistration.BLOCKS.register("cobblestone_carved_column", () -> usageCarvedColumnBlock(Blocks.COBBLESTONE));
    public static final RegistryObject<CarvedColumnBlock> BRICK_CARVED_COLUMN = BlockRegistration.BLOCKS.register("brick_carved_column", () -> usageCarvedColumnBlock(Blocks.BRICKS));
    public static final RegistryObject<CarvedColumnBlock> STONE_BRICK_CARVED_COLUMN = BlockRegistration.BLOCKS.register("stone_brick_carved_column", () -> usageCarvedColumnBlock(Blocks.STONE_BRICKS));
    public static final RegistryObject<CarvedColumnBlock> MUD_BRICK_CARVED_COLUMN = BlockRegistration.BLOCKS.register("mud_brick_carved_column", () -> usageCarvedColumnBlock(Blocks.MUD_BRICKS));
    public static final RegistryObject<CarvedColumnBlock> NETHER_BRICK_CARVED_COLUMN = BlockRegistration.BLOCKS.register("nether_brick_carved_column", () -> usageCarvedColumnBlock(Blocks.NETHER_BRICKS));
    public static final RegistryObject<CarvedColumnBlock> SANDSTONE_CARVED_COLUMN = BlockRegistration.BLOCKS.register("sandstone_carved_column", () -> usageCarvedColumnBlock(Blocks.SANDSTONE));
    public static final RegistryObject<CarvedColumnBlock> SPRUCE_CARVED_COLUMN = BlockRegistration.BLOCKS.register("spruce_carved_column", () -> usageCarvedColumnBlock(Blocks.SPRUCE_PLANKS));
    public static final RegistryObject<CarvedColumnBlock> BIRCH_CARVED_COLUMN = BlockRegistration.BLOCKS.register("birch_carved_column", () -> usageCarvedColumnBlock(Blocks.BIRCH_PLANKS));
    public static final RegistryObject<CarvedColumnBlock> JUNGLE_CARVED_COLUMN = BlockRegistration.BLOCKS.register("jungle_carved_column", () -> usageCarvedColumnBlock(Blocks.JUNGLE_PLANKS));
    public static final RegistryObject<CarvedColumnBlock> QUARTZ_CARVED_COLUMN = BlockRegistration.BLOCKS.register("quartz_carved_column", () -> usageCarvedColumnBlock(Blocks.QUARTZ_BLOCK));
    public static final RegistryObject<CarvedColumnBlock> ACACIA_CARVED_COLUMN = BlockRegistration.BLOCKS.register("acacia_carved_column", () -> usageCarvedColumnBlock(Blocks.ACACIA_PLANKS));
    public static final RegistryObject<CarvedColumnBlock> CHERRY_CARVED_COLUMN = BlockRegistration.BLOCKS.register("cherry_carved_column", () -> usageCarvedColumnBlock(Blocks.CHERRY_PLANKS));
    public static final RegistryObject<CarvedColumnBlock> DARK_OAK_CARVED_COLUMN = BlockRegistration.BLOCKS.register("dark_oak_carved_column", () -> usageCarvedColumnBlock(Blocks.DARK_OAK_PLANKS));
    public static final RegistryObject<CarvedColumnBlock> MANGROVE_CARVED_COLUMN = BlockRegistration.BLOCKS.register("mangrove_carved_column", () -> usageCarvedColumnBlock(Blocks.MANGROVE_PLANKS));
    public static final RegistryObject<CarvedColumnBlock> BAMBOO_CARVED_COLUMN = BlockRegistration.BLOCKS.register("bamboo_carved_column", () -> usageCarvedColumnBlock(Blocks.BAMBOO_PLANKS));
    public static final RegistryObject<CarvedColumnBlock> BAMBOO_MOSAIC_CARVED_COLUMN = BlockRegistration.BLOCKS.register("bamboo_mosaic_carved_column", () -> usageCarvedColumnBlock(Blocks.BAMBOO_MOSAIC));
    public static final RegistryObject<CarvedColumnBlock> PRISMARINE_CARVED_COLUMN = BlockRegistration.BLOCKS.register("prismarine_carved_column", () -> usageCarvedColumnBlock(Blocks.PRISMARINE));
    public static final RegistryObject<CarvedColumnBlock> PRISMARINE_BRICK_CARVED_COLUMN = BlockRegistration.BLOCKS.register("prismarine_brick_carved_column", () -> usageCarvedColumnBlock(Blocks.PRISMARINE_BRICKS));
    public static final RegistryObject<CarvedColumnBlock> DARK_PRISMARINE_CARVED_COLUMN = BlockRegistration.BLOCKS.register("dark_prismarine_carved_column", () -> usageCarvedColumnBlock(Blocks.DARK_PRISMARINE));
    public static final RegistryObject<CarvedColumnBlock> RED_SANDSTONE_CARVED_COLUMN = BlockRegistration.BLOCKS.register("red_sandstone_carved_column", () -> usageCarvedColumnBlock(Blocks.RED_SANDSTONE));
    public static final RegistryObject<CarvedColumnBlock> PURPUR_CARVED_COLUMN = BlockRegistration.BLOCKS.register("purpur_carved_column", () -> usageCarvedColumnBlock(Blocks.PURPUR_BLOCK));
    public static final RegistryObject<CarvedColumnBlock> POLISHED_GRANITE_CARVED_COLUMN = BlockRegistration.BLOCKS.register("polished_granite_carved_column", () -> usageCarvedColumnBlock(Blocks.POLISHED_GRANITE));
    public static final RegistryObject<CarvedColumnBlock> SMOOTH_RED_SANDSTONE_CARVED_COLUMN = BlockRegistration.BLOCKS.register("smooth_red_sandstone_carved_column", () -> usageCarvedColumnBlock(Blocks.SMOOTH_RED_SANDSTONE));
    public static final RegistryObject<CarvedColumnBlock> MOSSY_STONE_BRICK_CARVED_COLUMN = BlockRegistration.BLOCKS.register("mossy_stone_brick_carved_column", () -> usageCarvedColumnBlock(Blocks.MOSSY_STONE_BRICKS));
    public static final RegistryObject<CarvedColumnBlock> POLISHED_DIORITE_CARVED_COLUMN = BlockRegistration.BLOCKS.register("polished_diorite_carved_column", () -> usageCarvedColumnBlock(Blocks.POLISHED_DIORITE));
    public static final RegistryObject<CarvedColumnBlock> MOSSY_COBBLESTONE_CARVED_COLUMN = BlockRegistration.BLOCKS.register("mossy_cobblestone_carved_column", () -> usageCarvedColumnBlock(Blocks.MOSSY_COBBLESTONE));
    public static final RegistryObject<CarvedColumnBlock> END_STONE_BRICK_CARVED_COLUMN = BlockRegistration.BLOCKS.register("end_stone_brick_carved_column", () -> usageCarvedColumnBlock(Blocks.END_STONE_BRICKS));
    public static final RegistryObject<CarvedColumnBlock> STONE_CARVED_COLUMN = BlockRegistration.BLOCKS.register("stone_carved_column", () -> usageCarvedColumnBlock(Blocks.STONE));
    public static final RegistryObject<CarvedColumnBlock> SMOOTH_SANDSTONE_CARVED_COLUMN = BlockRegistration.BLOCKS.register("smooth_sandstone_carved_column", () -> usageCarvedColumnBlock(Blocks.SMOOTH_SANDSTONE));
    public static final RegistryObject<CarvedColumnBlock> SMOOTH_QUARTZ_CARVED_COLUMN = BlockRegistration.BLOCKS.register("smooth_quartz_carved_column", () -> usageCarvedColumnBlock(Blocks.SMOOTH_QUARTZ));
    public static final RegistryObject<CarvedColumnBlock> GRANITE_CARVED_COLUMN = BlockRegistration.BLOCKS.register("granite_carved_column", () -> usageCarvedColumnBlock(Blocks.GRANITE));
    public static final RegistryObject<CarvedColumnBlock> ANDESITE_CARVED_COLUMN = BlockRegistration.BLOCKS.register("andesite_carved_column", () -> usageCarvedColumnBlock(Blocks.ANDESITE));
    public static final RegistryObject<CarvedColumnBlock> RED_NETHER_BRICK_CARVED_COLUMN = BlockRegistration.BLOCKS.register("red_nether_brick_carved_column", () -> usageCarvedColumnBlock(Blocks.RED_NETHER_BRICKS));
    public static final RegistryObject<CarvedColumnBlock> POLISHED_ANDESITE_CARVED_COLUMN = BlockRegistration.BLOCKS.register("polished_andesite_carved_column", () -> usageCarvedColumnBlock(Blocks.POLISHED_ANDESITE));
    public static final RegistryObject<CarvedColumnBlock> DIORITE_CARVED_COLUMN = BlockRegistration.BLOCKS.register("diorite_carved_column", () -> usageCarvedColumnBlock(Blocks.DIORITE));
    public static final RegistryObject<CarvedColumnBlock> CRIMSON_CARVED_COLUMN = BlockRegistration.BLOCKS.register("crimson_carved_column", () -> usageCarvedColumnBlock(Blocks.CRIMSON_PLANKS));
    public static final RegistryObject<CarvedColumnBlock> WARPED_CARVED_COLUMN = BlockRegistration.BLOCKS.register("warped_carved_column", () -> usageCarvedColumnBlock(Blocks.WARPED_PLANKS));
    public static final RegistryObject<CarvedColumnBlock> BLACKSTONE_CARVED_COLUMN = BlockRegistration.BLOCKS.register("blackstone_carved_column", () -> usageCarvedColumnBlock(Blocks.BLACKSTONE));
    public static final RegistryObject<CarvedColumnBlock> POLISHED_BLACKSTONE_BRICK_CARVED_COLUMN = BlockRegistration.BLOCKS.register("polished_blackstone_brick_carved_column", () -> usageCarvedColumnBlock(Blocks.POLISHED_BLACKSTONE_BRICKS));
    public static final RegistryObject<CarvedColumnBlock> POLISHED_BLACKSTONE_CARVED_COLUMN = BlockRegistration.BLOCKS.register("polished_blackstone_carved_column", () -> usageCarvedColumnBlock(Blocks.POLISHED_BLACKSTONE));
    public static final RegistryObject<WeatheredCopperCarvedColumnBlock> OXIDIZED_CUT_COPPER_CARVED_COLUMN = BlockRegistration.BLOCKS.register("oxidized_cut_copper_carved_column", () -> usageWeatheredCarvedColumn(Blocks.OXIDIZED_CUT_COPPER, WeatheringCopper.WeatherState.OXIDIZED));
    public static final RegistryObject<WeatheredCopperCarvedColumnBlock> WEATHERED_CUT_COPPER_CARVED_COLUMN = BlockRegistration.BLOCKS.register("weathered_cut_copper_carved_column", () -> usageWeatheredCarvedColumn(Blocks.WEATHERED_CUT_COPPER, WeatheringCopper.WeatherState.WEATHERED));
    public static final RegistryObject<WeatheredCopperCarvedColumnBlock> EXPOSED_CUT_COPPER_CARVED_COLUMN = BlockRegistration.BLOCKS.register("exposed_cut_copper_carved_column", () -> usageWeatheredCarvedColumn(Blocks.EXPOSED_CUT_COPPER, WeatheringCopper.WeatherState.EXPOSED));
    public static final RegistryObject<WeatheredCopperCarvedColumnBlock> CUT_COPPER_CARVED_COLUMN = BlockRegistration.BLOCKS.register("cut_copper_carved_column", () -> usageWeatheredCarvedColumn(Blocks.CUT_COPPER, WeatheringCopper.WeatherState.UNAFFECTED));
    public static final RegistryObject<CarvedColumnBlock> WAXED_OXIDIZED_CUT_COPPER_CARVED_COLUMN = BlockRegistration.BLOCKS.register("waxed_oxidized_cut_copper_carved_column", () -> usageCarvedColumnBlock(Blocks.WAXED_OXIDIZED_CUT_COPPER));
    public static final RegistryObject<CarvedColumnBlock> WAXED_WEATHERED_CUT_COPPER_CARVED_COLUMN = BlockRegistration.BLOCKS.register("waxed_weathered_cut_copper_carved_column", () -> usageCarvedColumnBlock(Blocks.WAXED_WEATHERED_CUT_COPPER));
    public static final RegistryObject<CarvedColumnBlock> WAXED_EXPOSED_CUT_COPPER_CARVED_COLUMN = BlockRegistration.BLOCKS.register("waxed_exposed_cut_copper_carved_column", () -> usageCarvedColumnBlock(Blocks.WAXED_EXPOSED_CUT_COPPER));
    public static final RegistryObject<CarvedColumnBlock> WAXED_CUT_COPPER_CARVED_COLUMN = BlockRegistration.BLOCKS.register("waxed_cut_copper_carved_column", () -> usageCarvedColumnBlock(Blocks.WAXED_CUT_COPPER));
    public static final RegistryObject<CarvedColumnBlock> COBBLED_DEEPSLATE_CARVED_COLUMN = BlockRegistration.BLOCKS.register("cobbled_deepslate_carved_column", () -> usageCarvedColumnBlock(Blocks.COBBLED_DEEPSLATE));
    public static final RegistryObject<CarvedColumnBlock> POLISHED_DEEPSLATE_CARVED_COLUMN = BlockRegistration.BLOCKS.register("polished_deepslate_carved_column", () -> usageCarvedColumnBlock(Blocks.POLISHED_DEEPSLATE));
    public static final RegistryObject<CarvedColumnBlock> DEEPSLATE_TILE_CARVED_COLUMN = BlockRegistration.BLOCKS.register("deepslate_tile_carved_column", () -> usageCarvedColumnBlock(Blocks.DEEPSLATE_TILES));
    public static final RegistryObject<CarvedColumnBlock> DEEPSLATE_BRICK_CARVED_COLUMN = BlockRegistration.BLOCKS.register("deepslate_brick_carved_column", () -> usageCarvedColumnBlock(Blocks.DEEPSLATE_BRICKS));
    public static final RegistryObject<BlockItem> OAK_CARVED_COLUMN_ITEM = ItemRegistration.ITEMS.register("oak_carved_column", () -> new BlockItem(OAK_CARVED_COLUMN.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> COBBLESTONE_CARVED_COLUMN_ITEM = ItemRegistration.ITEMS.register("cobblestone_carved_column", () -> new BlockItem(COBBLESTONE_CARVED_COLUMN.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> BRICK_CARVED_COLUMN_ITEM = ItemRegistration.ITEMS.register("brick_carved_column", () -> new BlockItem(BRICK_CARVED_COLUMN.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> STONE_BRICK_CARVED_COLUMN_ITEM = ItemRegistration.ITEMS.register("stone_brick_carved_column", () -> new BlockItem(STONE_BRICK_CARVED_COLUMN.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> MUD_BRICK_CARVED_COLUMN_ITEM = ItemRegistration.ITEMS.register("mud_brick_carved_column", () -> new BlockItem(MUD_BRICK_CARVED_COLUMN.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> NETHER_BRICK_CARVED_COLUMN_ITEM = ItemRegistration.ITEMS.register("nether_brick_carved_column", () -> new BlockItem(NETHER_BRICK_CARVED_COLUMN.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> SANDSTONE_CARVED_COLUMN_ITEM = ItemRegistration.ITEMS.register("sandstone_carved_column", () -> new BlockItem(SANDSTONE_CARVED_COLUMN.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> SPRUCE_CARVED_COLUMN_ITEM = ItemRegistration.ITEMS.register("spruce_carved_column", () -> new BlockItem(SPRUCE_CARVED_COLUMN.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> BIRCH_CARVED_COLUMN_ITEM = ItemRegistration.ITEMS.register("birch_carved_column", () -> new BlockItem(BIRCH_CARVED_COLUMN.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> JUNGLE_CARVED_COLUMN_ITEM = ItemRegistration.ITEMS.register("jungle_carved_column", () -> new BlockItem(JUNGLE_CARVED_COLUMN.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> QUARTZ_CARVED_COLUMN_ITEM = ItemRegistration.ITEMS.register("quartz_carved_column", () -> new BlockItem(QUARTZ_CARVED_COLUMN.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> ACACIA_CARVED_COLUMN_ITEM = ItemRegistration.ITEMS.register("acacia_carved_column", () -> new BlockItem(ACACIA_CARVED_COLUMN.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> CHERRY_CARVED_COLUMN_ITEM = ItemRegistration.ITEMS.register("cherry_carved_column", () -> new BlockItem(CHERRY_CARVED_COLUMN.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> DARK_OAK_CARVED_COLUMN_ITEM = ItemRegistration.ITEMS.register("dark_oak_carved_column", () -> new BlockItem(DARK_OAK_CARVED_COLUMN.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> MANGROVE_CARVED_COLUMN_ITEM = ItemRegistration.ITEMS.register("mangrove_carved_column", () -> new BlockItem(MANGROVE_CARVED_COLUMN.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> BAMBOO_CARVED_COLUMN_ITEM = ItemRegistration.ITEMS.register("bamboo_carved_column", () -> new BlockItem(BAMBOO_CARVED_COLUMN.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> BAMBOO_MOSAIC_CARVED_COLUMN_ITEM = ItemRegistration.ITEMS.register("bamboo_mosaic_carved_column", () -> new BlockItem(BAMBOO_MOSAIC_CARVED_COLUMN.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> PRISMARINE_CARVED_COLUMN_ITEM = ItemRegistration.ITEMS.register("prismarine_carved_column", () -> new BlockItem(PRISMARINE_CARVED_COLUMN.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> PRISMARINE_BRICK_CARVED_COLUMN_ITEM = ItemRegistration.ITEMS.register("prismarine_brick_carved_column", () -> new BlockItem(PRISMARINE_BRICK_CARVED_COLUMN.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> DARK_PRISMARINE_CARVED_COLUMN_ITEM = ItemRegistration.ITEMS.register("dark_prismarine_carved_column", () -> new BlockItem(DARK_PRISMARINE_CARVED_COLUMN.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> RED_SANDSTONE_CARVED_COLUMN_ITEM = ItemRegistration.ITEMS.register("red_sandstone_carved_column", () -> new BlockItem(RED_SANDSTONE_CARVED_COLUMN.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> PURPUR_CARVED_COLUMN_ITEM = ItemRegistration.ITEMS.register("purpur_carved_column", () -> new BlockItem(PURPUR_CARVED_COLUMN.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> POLISHED_GRANITE_CARVED_COLUMN_ITEM = ItemRegistration.ITEMS.register("polished_granite_carved_column", () -> new BlockItem(POLISHED_GRANITE_CARVED_COLUMN.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> SMOOTH_RED_SANDSTONE_CARVED_COLUMN_ITEM = ItemRegistration.ITEMS.register("smooth_red_sandstone_carved_column", () -> new BlockItem(SMOOTH_RED_SANDSTONE_CARVED_COLUMN.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> MOSSY_STONE_BRICK_CARVED_COLUMN_ITEM = ItemRegistration.ITEMS.register("mossy_stone_brick_carved_column", () -> new BlockItem(MOSSY_STONE_BRICK_CARVED_COLUMN.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> POLISHED_DIORITE_CARVED_COLUMN_ITEM = ItemRegistration.ITEMS.register("polished_diorite_carved_column", () -> new BlockItem(POLISHED_DIORITE_CARVED_COLUMN.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> MOSSY_COBBLESTONE_CARVED_COLUMN_ITEM = ItemRegistration.ITEMS.register("mossy_cobblestone_carved_column", () -> new BlockItem(MOSSY_COBBLESTONE_CARVED_COLUMN.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> END_STONE_BRICK_CARVED_COLUMN_ITEM = ItemRegistration.ITEMS.register("end_stone_brick_carved_column", () -> new BlockItem(END_STONE_BRICK_CARVED_COLUMN.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> STONE_CARVED_COLUMN_ITEM = ItemRegistration.ITEMS.register("stone_carved_column", () -> new BlockItem(STONE_CARVED_COLUMN.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> SMOOTH_SANDSTONE_CARVED_COLUMN_ITEM = ItemRegistration.ITEMS.register("smooth_sandstone_carved_column", () -> new BlockItem(SMOOTH_SANDSTONE_CARVED_COLUMN.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> SMOOTH_QUARTZ_CARVED_COLUMN_ITEM = ItemRegistration.ITEMS.register("smooth_quartz_carved_column", () -> new BlockItem(SMOOTH_QUARTZ_CARVED_COLUMN.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> GRANITE_CARVED_COLUMN_ITEM = ItemRegistration.ITEMS.register("granite_carved_column", () -> new BlockItem(GRANITE_CARVED_COLUMN.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> ANDESITE_CARVED_COLUMN_ITEM = ItemRegistration.ITEMS.register("andesite_carved_column", () -> new BlockItem(ANDESITE_CARVED_COLUMN.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> RED_NETHER_BRICK_CARVED_COLUMN_ITEM = ItemRegistration.ITEMS.register("red_nether_brick_carved_column", () -> new BlockItem(RED_NETHER_BRICK_CARVED_COLUMN.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> POLISHED_ANDESITE_CARVED_COLUMN_ITEM = ItemRegistration.ITEMS.register("polished_andesite_carved_column", () -> new BlockItem(POLISHED_ANDESITE_CARVED_COLUMN.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> DIORITE_CARVED_COLUMN_ITEM = ItemRegistration.ITEMS.register("diorite_carved_column", () -> new BlockItem(DIORITE_CARVED_COLUMN.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> CRIMSON_CARVED_COLUMN_ITEM = ItemRegistration.ITEMS.register("crimson_carved_column", () -> new BlockItem(CRIMSON_CARVED_COLUMN.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> WARPED_CARVED_COLUMN_ITEM = ItemRegistration.ITEMS.register("warped_carved_column", () -> new BlockItem(WARPED_CARVED_COLUMN.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> BLACKSTONE_CARVED_COLUMN_ITEM = ItemRegistration.ITEMS.register("blackstone_carved_column", () -> new BlockItem(BLACKSTONE_CARVED_COLUMN.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> POLISHED_BLACKSTONE_BRICK_CARVED_COLUMN_ITEM = ItemRegistration.ITEMS.register("polished_blackstone_brick_carved_column", () -> new BlockItem(POLISHED_BLACKSTONE_BRICK_CARVED_COLUMN.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> POLISHED_BLACKSTONE_CARVED_COLUMN_ITEM = ItemRegistration.ITEMS.register("polished_blackstone_carved_column", () -> new BlockItem(POLISHED_BLACKSTONE_CARVED_COLUMN.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> OXIDIZED_CUT_COPPER_CARVED_COLUMN_ITEM = ItemRegistration.ITEMS.register("oxidized_cut_copper_carved_column", () -> new BlockItem(OXIDIZED_CUT_COPPER_CARVED_COLUMN.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> WEATHERED_CUT_COPPER_CARVED_COLUMN_ITEM = ItemRegistration.ITEMS.register("weathered_cut_copper_carved_column", () -> new BlockItem(WEATHERED_CUT_COPPER_CARVED_COLUMN.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> EXPOSED_CUT_COPPER_CARVED_COLUMN_ITEM = ItemRegistration.ITEMS.register("exposed_cut_copper_carved_column", () -> new BlockItem(EXPOSED_CUT_COPPER_CARVED_COLUMN.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> CUT_COPPER_CARVED_COLUMN_ITEM = ItemRegistration.ITEMS.register("cut_copper_carved_column", () -> new BlockItem(CUT_COPPER_CARVED_COLUMN.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> WAXED_OXIDIZED_CUT_COPPER_CARVED_COLUMN_ITEM = ItemRegistration.ITEMS.register("waxed_oxidized_cut_copper_carved_column", () -> new BlockItem(WAXED_OXIDIZED_CUT_COPPER_CARVED_COLUMN.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> WAXED_WEATHERED_CUT_COPPER_CARVED_COLUMN_ITEM = ItemRegistration.ITEMS.register("waxed_weathered_cut_copper_carved_column", () -> new BlockItem(WAXED_WEATHERED_CUT_COPPER_CARVED_COLUMN.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> WAXED_EXPOSED_CUT_COPPER_CARVED_COLUMN_ITEM = ItemRegistration.ITEMS.register("waxed_exposed_cut_copper_carved_column", () -> new BlockItem(WAXED_EXPOSED_CUT_COPPER_CARVED_COLUMN.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> WAXED_CUT_COPPER_CARVED_COLUMN_ITEM = ItemRegistration.ITEMS.register("waxed_cut_copper_carved_column", () -> new BlockItem(WAXED_CUT_COPPER_CARVED_COLUMN.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> COBBLED_DEEPSLATE_CARVED_COLUMN_ITEM = ItemRegistration.ITEMS.register("cobbled_deepslate_carved_column", () -> new BlockItem(COBBLED_DEEPSLATE_CARVED_COLUMN.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> POLISHED_DEEPSLATE_CARVED_COLUMN_ITEM = ItemRegistration.ITEMS.register("polished_deepslate_carved_column", () -> new BlockItem(POLISHED_DEEPSLATE_CARVED_COLUMN.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> DEEPSLATE_TILE_CARVED_COLUMN_ITEM = ItemRegistration.ITEMS.register("deepslate_tile_carved_column", () -> new BlockItem(DEEPSLATE_TILE_CARVED_COLUMN.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> DEEPSLATE_BRICK_CARVED_COLUMN_ITEM = ItemRegistration.ITEMS.register("deepslate_brick_carved_column", () -> new BlockItem(DEEPSLATE_BRICK_CARVED_COLUMN.get(), new Item.Properties()));

    @Contract("_ -> new")
    public static @NotNull CarvedColumnBlock usageCarvedColumnBlock(@NotNull Block propertyBlock) {
        return new CarvedColumnBlock(propertyBlock.defaultBlockState(), BlockBehaviour.Properties.copy(propertyBlock));
    }

    @Contract("_, _ -> new")
    public static @NotNull WeatheredCopperCarvedColumnBlock usageWeatheredCarvedColumn(@NotNull Block propertyBlock, WeatheringCopper.WeatherState weatherState) {
        return new WeatheredCopperCarvedColumnBlock(propertyBlock.defaultBlockState(), BlockBehaviour.Properties.copy(propertyBlock), weatherState);
    }
}
