package nowebsite.maker.furnitureplan.registry.kindsblock;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredHolder;
import nowebsite.maker.furnitureplan.blocks.singleblockfurniture.CabinetBlock;
import nowebsite.maker.furnitureplan.blocks.singleblockfurniture.WeatheredCopperCabinet;
import nowebsite.maker.furnitureplan.blocks.singleblockfurniture.blockentities.CabinetBlockEntity;
import nowebsite.maker.furnitureplan.registry.BlockRegistration;
import nowebsite.maker.furnitureplan.registry.ItemRegistration;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class CabinetBlockRegistration {

    public static void init() {}

    public static final DeferredHolder<Block, CabinetBlock> OAK_CABINET = BlockRegistration.BLOCKS.register("oak_cabinet", () -> usageCabinetBlock(Blocks.OAK_PLANKS, 0));
    public static final DeferredHolder<Block, CabinetBlock> COBBLESTONE_CABINET = BlockRegistration.BLOCKS.register("cobblestone_cabinet", () -> usageCabinetBlock(Blocks.COBBLESTONE, 1));
    public static final DeferredHolder<Block, CabinetBlock> BRICK_CABINET = BlockRegistration.BLOCKS.register("brick_cabinet", () -> usageCabinetBlock(Blocks.BRICKS, 2));
    public static final DeferredHolder<Block, CabinetBlock> STONE_BRICK_CABINET = BlockRegistration.BLOCKS.register("stone_brick_cabinet", () -> usageCabinetBlock(Blocks.STONE_BRICKS, 3));
    public static final DeferredHolder<Block, CabinetBlock> MUD_BRICK_CABINET = BlockRegistration.BLOCKS.register("mud_brick_cabinet", () -> usageCabinetBlock(Blocks.MUD_BRICKS, 4));
    public static final DeferredHolder<Block, CabinetBlock> NETHER_BRICK_CABINET = BlockRegistration.BLOCKS.register("nether_brick_cabinet", () -> usageCabinetBlock(Blocks.NETHER_BRICKS, 5));
    public static final DeferredHolder<Block, CabinetBlock> SANDSTONE_CABINET = BlockRegistration.BLOCKS.register("sandstone_cabinet", () -> usageCabinetBlock(Blocks.SANDSTONE, 6));
    public static final DeferredHolder<Block, CabinetBlock> SPRUCE_CABINET = BlockRegistration.BLOCKS.register("spruce_cabinet", () -> usageCabinetBlock(Blocks.SPRUCE_PLANKS, 7));
    public static final DeferredHolder<Block, CabinetBlock> BIRCH_CABINET = BlockRegistration.BLOCKS.register("birch_cabinet", () -> usageCabinetBlock(Blocks.BIRCH_PLANKS, 8));
    public static final DeferredHolder<Block, CabinetBlock> JUNGLE_CABINET = BlockRegistration.BLOCKS.register("jungle_cabinet", () -> usageCabinetBlock(Blocks.JUNGLE_PLANKS, 9));
    public static final DeferredHolder<Block, CabinetBlock> QUARTZ_CABINET = BlockRegistration.BLOCKS.register("quartz_cabinet", () -> usageCabinetBlock(Blocks.QUARTZ_BLOCK, 10));
    public static final DeferredHolder<Block, CabinetBlock> ACACIA_CABINET = BlockRegistration.BLOCKS.register("acacia_cabinet", () -> usageCabinetBlock(Blocks.ACACIA_PLANKS, 11));
    public static final DeferredHolder<Block, CabinetBlock> CHERRY_CABINET = BlockRegistration.BLOCKS.register("cherry_cabinet", () -> usageCabinetBlock(Blocks.CHERRY_PLANKS, 12));
    public static final DeferredHolder<Block, CabinetBlock> DARK_OAK_CABINET = BlockRegistration.BLOCKS.register("dark_oak_cabinet", () -> usageCabinetBlock(Blocks.DARK_OAK_PLANKS, 13));
    public static final DeferredHolder<Block, CabinetBlock> MANGROVE_CABINET = BlockRegistration.BLOCKS.register("mangrove_cabinet", () -> usageCabinetBlock(Blocks.MANGROVE_PLANKS, 14));
    public static final DeferredHolder<Block, CabinetBlock> BAMBOO_CABINET = BlockRegistration.BLOCKS.register("bamboo_cabinet", () -> usageCabinetBlock(Blocks.BAMBOO_PLANKS, 15));
    public static final DeferredHolder<Block, CabinetBlock> BAMBOO_MOSAIC_CABINET = BlockRegistration.BLOCKS.register("bamboo_mosaic_cabinet", () -> usageCabinetBlock(Blocks.BAMBOO_MOSAIC, 16));
    public static final DeferredHolder<Block, CabinetBlock> PRISMARINE_CABINET = BlockRegistration.BLOCKS.register("prismarine_cabinet", () -> usageCabinetBlock(Blocks.PRISMARINE, 17));
    public static final DeferredHolder<Block, CabinetBlock> PRISMARINE_BRICK_CABINET = BlockRegistration.BLOCKS.register("prismarine_brick_cabinet", () -> usageCabinetBlock(Blocks.PRISMARINE_BRICKS, 18));
    public static final DeferredHolder<Block, CabinetBlock> DARK_PRISMARINE_CABINET = BlockRegistration.BLOCKS.register("dark_prismarine_cabinet", () -> usageCabinetBlock(Blocks.DARK_PRISMARINE, 19));
    public static final DeferredHolder<Block, CabinetBlock> RED_SANDSTONE_CABINET = BlockRegistration.BLOCKS.register("red_sandstone_cabinet", () -> usageCabinetBlock(Blocks.RED_SANDSTONE, 20));
    public static final DeferredHolder<Block, CabinetBlock> PURPUR_CABINET = BlockRegistration.BLOCKS.register("purpur_cabinet", () -> usageCabinetBlock(Blocks.PURPUR_BLOCK, 21));
    public static final DeferredHolder<Block, CabinetBlock> POLISHED_GRANITE_CABINET = BlockRegistration.BLOCKS.register("polished_granite_cabinet", () -> usageCabinetBlock(Blocks.POLISHED_GRANITE, 22));
    public static final DeferredHolder<Block, CabinetBlock> SMOOTH_RED_SANDSTONE_CABINET = BlockRegistration.BLOCKS.register("smooth_red_sandstone_cabinet", () -> usageCabinetBlock(Blocks.SMOOTH_RED_SANDSTONE, 23));
    public static final DeferredHolder<Block, CabinetBlock> MOSSY_STONE_BRICK_CABINET = BlockRegistration.BLOCKS.register("mossy_stone_brick_cabinet", () -> usageCabinetBlock(Blocks.MOSSY_STONE_BRICKS, 24));
    public static final DeferredHolder<Block, CabinetBlock> POLISHED_DIORITE_CABINET = BlockRegistration.BLOCKS.register("polished_diorite_cabinet", () -> usageCabinetBlock(Blocks.POLISHED_DIORITE, 25));
    public static final DeferredHolder<Block, CabinetBlock> MOSSY_COBBLESTONE_CABINET = BlockRegistration.BLOCKS.register("mossy_cobblestone_cabinet", () -> usageCabinetBlock(Blocks.MOSSY_COBBLESTONE, 26));
    public static final DeferredHolder<Block, CabinetBlock> END_STONE_BRICK_CABINET = BlockRegistration.BLOCKS.register("end_stone_brick_cabinet", () -> usageCabinetBlock(Blocks.END_STONE_BRICKS, 27));
    public static final DeferredHolder<Block, CabinetBlock> STONE_CABINET = BlockRegistration.BLOCKS.register("stone_cabinet", () -> usageCabinetBlock(Blocks.STONE, 28));
    public static final DeferredHolder<Block, CabinetBlock> SMOOTH_SANDSTONE_CABINET = BlockRegistration.BLOCKS.register("smooth_sandstone_cabinet", () -> usageCabinetBlock(Blocks.SMOOTH_SANDSTONE, 29));
    public static final DeferredHolder<Block, CabinetBlock> SMOOTH_QUARTZ_CABINET = BlockRegistration.BLOCKS.register("smooth_quartz_cabinet", () -> usageCabinetBlock(Blocks.SMOOTH_QUARTZ, 30));
    public static final DeferredHolder<Block, CabinetBlock> GRANITE_CABINET = BlockRegistration.BLOCKS.register("granite_cabinet", () -> usageCabinetBlock(Blocks.GRANITE, 31));
    public static final DeferredHolder<Block, CabinetBlock> ANDESITE_CABINET = BlockRegistration.BLOCKS.register("andesite_cabinet", () -> usageCabinetBlock(Blocks.ANDESITE, 32));
    public static final DeferredHolder<Block, CabinetBlock> RED_NETHER_BRICK_CABINET = BlockRegistration.BLOCKS.register("red_nether_brick_cabinet", () -> usageCabinetBlock(Blocks.RED_NETHER_BRICKS, 33));
    public static final DeferredHolder<Block, CabinetBlock> POLISHED_ANDESITE_CABINET = BlockRegistration.BLOCKS.register("polished_andesite_cabinet", () -> usageCabinetBlock(Blocks.POLISHED_ANDESITE, 34));
    public static final DeferredHolder<Block, CabinetBlock> DIORITE_CABINET = BlockRegistration.BLOCKS.register("diorite_cabinet", () -> usageCabinetBlock(Blocks.DIORITE, 35));
    public static final DeferredHolder<Block, CabinetBlock> CRIMSON_CABINET = BlockRegistration.BLOCKS.register("crimson_cabinet", () -> usageCabinetBlock(Blocks.CRIMSON_PLANKS, 36));
    public static final DeferredHolder<Block, CabinetBlock> WARPED_CABINET = BlockRegistration.BLOCKS.register("warped_cabinet", () -> usageCabinetBlock(Blocks.WARPED_PLANKS, 37));
    public static final DeferredHolder<Block, CabinetBlock> BLACKSTONE_CABINET = BlockRegistration.BLOCKS.register("blackstone_cabinet", () -> usageCabinetBlock(Blocks.BLACKSTONE, 38));
    public static final DeferredHolder<Block, CabinetBlock> POLISHED_BLACKSTONE_BRICK_CABINET = BlockRegistration.BLOCKS.register("polished_blackstone_brick_cabinet", () -> usageCabinetBlock(Blocks.POLISHED_BLACKSTONE_BRICKS, 39));
    public static final DeferredHolder<Block, CabinetBlock> POLISHED_BLACKSTONE_CABINET = BlockRegistration.BLOCKS.register("polished_blackstone_cabinet", () -> usageCabinetBlock(Blocks.POLISHED_BLACKSTONE, 40));
    public static final DeferredHolder<Block, WeatheredCopperCabinet> OXIDIZED_CUT_COPPER_CABINET = BlockRegistration.BLOCKS.register("oxidized_cut_copper_cabinet", () -> usageWeatheredCabinet(Blocks.OXIDIZED_CUT_COPPER, WeatheringCopper.WeatherState.OXIDIZED, 41));
    public static final DeferredHolder<Block, WeatheredCopperCabinet> WEATHERED_CUT_COPPER_CABINET = BlockRegistration.BLOCKS.register("weathered_cut_copper_cabinet", () -> usageWeatheredCabinet(Blocks.WEATHERED_CUT_COPPER, WeatheringCopper.WeatherState.WEATHERED, 42));
    public static final DeferredHolder<Block, WeatheredCopperCabinet> EXPOSED_CUT_COPPER_CABINET = BlockRegistration.BLOCKS.register("exposed_cut_copper_cabinet", () -> usageWeatheredCabinet(Blocks.EXPOSED_CUT_COPPER, WeatheringCopper.WeatherState.EXPOSED, 43));
    public static final DeferredHolder<Block, WeatheredCopperCabinet> CUT_COPPER_CABINET = BlockRegistration.BLOCKS.register("cut_copper_cabinet", () -> usageWeatheredCabinet(Blocks.CUT_COPPER, WeatheringCopper.WeatherState.UNAFFECTED, 44));
    public static final DeferredHolder<Block, CabinetBlock> WAXED_OXIDIZED_CUT_COPPER_CABINET = BlockRegistration.BLOCKS.register("waxed_oxidized_cut_copper_cabinet", () -> usageCabinetBlock(Blocks.WAXED_OXIDIZED_CUT_COPPER, 45));
    public static final DeferredHolder<Block, CabinetBlock> WAXED_WEATHERED_CUT_COPPER_CABINET = BlockRegistration.BLOCKS.register("waxed_weathered_cut_copper_cabinet", () -> usageCabinetBlock(Blocks.WAXED_WEATHERED_CUT_COPPER, 46));
    public static final DeferredHolder<Block, CabinetBlock> WAXED_EXPOSED_CUT_COPPER_CABINET = BlockRegistration.BLOCKS.register("waxed_exposed_cut_copper_cabinet", () -> usageCabinetBlock(Blocks.WAXED_EXPOSED_CUT_COPPER, 47));
    public static final DeferredHolder<Block, CabinetBlock> WAXED_CUT_COPPER_CABINET = BlockRegistration.BLOCKS.register("waxed_cut_copper_cabinet", () -> usageCabinetBlock(Blocks.WAXED_CUT_COPPER, 48));
    public static final DeferredHolder<Block, CabinetBlock> COBBLED_DEEPSLATE_CABINET = BlockRegistration.BLOCKS.register("cobbled_deepslate_cabinet", () -> usageCabinetBlock(Blocks.COBBLED_DEEPSLATE, 49));
    public static final DeferredHolder<Block, CabinetBlock> POLISHED_DEEPSLATE_CABINET = BlockRegistration.BLOCKS.register("polished_deepslate_cabinet", () -> usageCabinetBlock(Blocks.POLISHED_DEEPSLATE, 50));
    public static final DeferredHolder<Block, CabinetBlock> DEEPSLATE_TILE_CABINET = BlockRegistration.BLOCKS.register("deepslate_tile_cabinet", () -> usageCabinetBlock(Blocks.DEEPSLATE_TILES, 51));
    public static final DeferredHolder<Block, CabinetBlock> DEEPSLATE_BRICK_CABINET = BlockRegistration.BLOCKS.register("deepslate_brick_cabinet", () -> usageCabinetBlock(Blocks.DEEPSLATE_BRICKS,52));
    public static final DeferredHolder<Item, BlockItem> OAK_CABINET_ITEM = ItemRegistration.ITEMS.register("oak_cabinet", () -> new BlockItem(OAK_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> COBBLESTONE_CABINET_ITEM = ItemRegistration.ITEMS.register("cobblestone_cabinet", () -> new BlockItem(COBBLESTONE_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> BRICK_CABINET_ITEM = ItemRegistration.ITEMS.register("brick_cabinet", () -> new BlockItem(BRICK_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> STONE_BRICK_CABINET_ITEM = ItemRegistration.ITEMS.register("stone_brick_cabinet", () -> new BlockItem(STONE_BRICK_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> MUD_BRICK_CABINET_ITEM = ItemRegistration.ITEMS.register("mud_brick_cabinet", () -> new BlockItem(MUD_BRICK_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> NETHER_BRICK_CABINET_ITEM = ItemRegistration.ITEMS.register("nether_brick_cabinet", () -> new BlockItem(NETHER_BRICK_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> SANDSTONE_CABINET_ITEM = ItemRegistration.ITEMS.register("sandstone_cabinet", () -> new BlockItem(SANDSTONE_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> SPRUCE_CABINET_ITEM = ItemRegistration.ITEMS.register("spruce_cabinet", () -> new BlockItem(SPRUCE_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> BIRCH_CABINET_ITEM = ItemRegistration.ITEMS.register("birch_cabinet", () -> new BlockItem(BIRCH_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> JUNGLE_CABINET_ITEM = ItemRegistration.ITEMS.register("jungle_cabinet", () -> new BlockItem(JUNGLE_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> QUARTZ_CABINET_ITEM = ItemRegistration.ITEMS.register("quartz_cabinet", () -> new BlockItem(QUARTZ_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> ACACIA_CABINET_ITEM = ItemRegistration.ITEMS.register("acacia_cabinet", () -> new BlockItem(ACACIA_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> CHERRY_CABINET_ITEM = ItemRegistration.ITEMS.register("cherry_cabinet", () -> new BlockItem(CHERRY_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> DARK_OAK_CABINET_ITEM = ItemRegistration.ITEMS.register("dark_oak_cabinet", () -> new BlockItem(DARK_OAK_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> MANGROVE_CABINET_ITEM = ItemRegistration.ITEMS.register("mangrove_cabinet", () -> new BlockItem(MANGROVE_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> BAMBOO_CABINET_ITEM = ItemRegistration.ITEMS.register("bamboo_cabinet", () -> new BlockItem(BAMBOO_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> BAMBOO_MOSAIC_CABINET_ITEM = ItemRegistration.ITEMS.register("bamboo_mosaic_cabinet", () -> new BlockItem(BAMBOO_MOSAIC_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> PRISMARINE_CABINET_ITEM = ItemRegistration.ITEMS.register("prismarine_cabinet", () -> new BlockItem(PRISMARINE_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> PRISMARINE_BRICK_CABINET_ITEM = ItemRegistration.ITEMS.register("prismarine_brick_cabinet", () -> new BlockItem(PRISMARINE_BRICK_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> DARK_PRISMARINE_CABINET_ITEM = ItemRegistration.ITEMS.register("dark_prismarine_cabinet", () -> new BlockItem(DARK_PRISMARINE_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> RED_SANDSTONE_CABINET_ITEM = ItemRegistration.ITEMS.register("red_sandstone_cabinet", () -> new BlockItem(RED_SANDSTONE_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> PURPUR_CABINET_ITEM = ItemRegistration.ITEMS.register("purpur_cabinet", () -> new BlockItem(PURPUR_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> POLISHED_GRANITE_CABINET_ITEM = ItemRegistration.ITEMS.register("polished_granite_cabinet", () -> new BlockItem(POLISHED_GRANITE_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> SMOOTH_RED_SANDSTONE_CABINET_ITEM = ItemRegistration.ITEMS.register("smooth_red_sandstone_cabinet", () -> new BlockItem(SMOOTH_RED_SANDSTONE_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> MOSSY_STONE_BRICK_CABINET_ITEM = ItemRegistration.ITEMS.register("mossy_stone_brick_cabinet", () -> new BlockItem(MOSSY_STONE_BRICK_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> POLISHED_DIORITE_CABINET_ITEM = ItemRegistration.ITEMS.register("polished_diorite_cabinet", () -> new BlockItem(POLISHED_DIORITE_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> MOSSY_COBBLESTONE_CABINET_ITEM = ItemRegistration.ITEMS.register("mossy_cobblestone_cabinet", () -> new BlockItem(MOSSY_COBBLESTONE_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> END_STONE_BRICK_CABINET_ITEM = ItemRegistration.ITEMS.register("end_stone_brick_cabinet", () -> new BlockItem(END_STONE_BRICK_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> STONE_CABINET_ITEM = ItemRegistration.ITEMS.register("stone_cabinet", () -> new BlockItem(STONE_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> SMOOTH_SANDSTONE_CABINET_ITEM = ItemRegistration.ITEMS.register("smooth_sandstone_cabinet", () -> new BlockItem(SMOOTH_SANDSTONE_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> SMOOTH_QUARTZ_CABINET_ITEM = ItemRegistration.ITEMS.register("smooth_quartz_cabinet", () -> new BlockItem(SMOOTH_QUARTZ_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> GRANITE_CABINET_ITEM = ItemRegistration.ITEMS.register("granite_cabinet", () -> new BlockItem(GRANITE_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> ANDESITE_CABINET_ITEM = ItemRegistration.ITEMS.register("andesite_cabinet", () -> new BlockItem(ANDESITE_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> RED_NETHER_BRICK_CABINET_ITEM = ItemRegistration.ITEMS.register("red_nether_brick_cabinet", () -> new BlockItem(RED_NETHER_BRICK_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> POLISHED_ANDESITE_CABINET_ITEM = ItemRegistration.ITEMS.register("polished_andesite_cabinet", () -> new BlockItem(POLISHED_ANDESITE_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> DIORITE_CABINET_ITEM = ItemRegistration.ITEMS.register("diorite_cabinet", () -> new BlockItem(DIORITE_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> CRIMSON_CABINET_ITEM = ItemRegistration.ITEMS.register("crimson_cabinet", () -> new BlockItem(CRIMSON_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> WARPED_CABINET_ITEM = ItemRegistration.ITEMS.register("warped_cabinet", () -> new BlockItem(WARPED_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> BLACKSTONE_CABINET_ITEM = ItemRegistration.ITEMS.register("blackstone_cabinet", () -> new BlockItem(BLACKSTONE_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> POLISHED_BLACKSTONE_BRICK_CABINET_ITEM = ItemRegistration.ITEMS.register("polished_blackstone_brick_cabinet", () -> new BlockItem(POLISHED_BLACKSTONE_BRICK_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> POLISHED_BLACKSTONE_CABINET_ITEM = ItemRegistration.ITEMS.register("polished_blackstone_cabinet", () -> new BlockItem(POLISHED_BLACKSTONE_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> OXIDIZED_CUT_COPPER_CABINET_ITEM = ItemRegistration.ITEMS.register("oxidized_cut_copper_cabinet", () -> new BlockItem(OXIDIZED_CUT_COPPER_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> WEATHERED_CUT_COPPER_CABINET_ITEM = ItemRegistration.ITEMS.register("weathered_cut_copper_cabinet", () -> new BlockItem(WEATHERED_CUT_COPPER_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> EXPOSED_CUT_COPPER_CABINET_ITEM = ItemRegistration.ITEMS.register("exposed_cut_copper_cabinet", () -> new BlockItem(EXPOSED_CUT_COPPER_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> CUT_COPPER_CABINET_ITEM = ItemRegistration.ITEMS.register("cut_copper_cabinet", () -> new BlockItem(CUT_COPPER_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> WAXED_OXIDIZED_CUT_COPPER_CABINET_ITEM = ItemRegistration.ITEMS.register("waxed_oxidized_cut_copper_cabinet", () -> new BlockItem(WAXED_OXIDIZED_CUT_COPPER_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> WAXED_WEATHERED_CUT_COPPER_CABINET_ITEM = ItemRegistration.ITEMS.register("waxed_weathered_cut_copper_cabinet", () -> new BlockItem(WAXED_WEATHERED_CUT_COPPER_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> WAXED_EXPOSED_CUT_COPPER_CABINET_ITEM = ItemRegistration.ITEMS.register("waxed_exposed_cut_copper_cabinet", () -> new BlockItem(WAXED_EXPOSED_CUT_COPPER_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> WAXED_CUT_COPPER_CABINET_ITEM = ItemRegistration.ITEMS.register("waxed_cut_copper_cabinet", () -> new BlockItem(WAXED_CUT_COPPER_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> COBBLED_DEEPSLATE_CABINET_ITEM = ItemRegistration.ITEMS.register("cobbled_deepslate_cabinet", () -> new BlockItem(COBBLED_DEEPSLATE_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> POLISHED_DEEPSLATE_CABINET_ITEM = ItemRegistration.ITEMS.register("polished_deepslate_cabinet", () -> new BlockItem(POLISHED_DEEPSLATE_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> DEEPSLATE_TILE_CABINET_ITEM = ItemRegistration.ITEMS.register("deepslate_tile_cabinet", () -> new BlockItem(DEEPSLATE_TILE_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> DEEPSLATE_BRICK_CABINET_ITEM = ItemRegistration.ITEMS.register("deepslate_brick_cabinet", () -> new BlockItem(DEEPSLATE_BRICK_CABINET.get(), new Item.Properties()));


    public static final DeferredHolder<Block, CabinetBlock> TUFF_CABINET = BlockRegistration.BLOCKS.register("tuff_cabinet", () -> usageCabinetBlock(Blocks.TUFF, 53));
    public static final DeferredHolder<Block, CabinetBlock> POLISHED_TUFF_CABINET = BlockRegistration.BLOCKS.register("polished_tuff_cabinet", () -> usageCabinetBlock(Blocks.POLISHED_TUFF, 54));
    public static final DeferredHolder<Block, CabinetBlock> TUFF_BRICK_CABINET = BlockRegistration.BLOCKS.register("tuff_brick_cabinet", () -> usageCabinetBlock(Blocks.TUFF_BRICKS, 55));
    public static final DeferredHolder<Item, BlockItem> TUFF_CABINET_ITEM = ItemRegistration.ITEMS.register("tuff_cabinet", () -> new BlockItem(TUFF_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> POLISHED_TUFF_CABINET_ITEM = ItemRegistration.ITEMS.register("polished_tuff_cabinet", () -> new BlockItem(POLISHED_TUFF_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> TUFF_BRICK_CABINET_ITEM = ItemRegistration.ITEMS.register("tuff_brick_cabinet", () -> new BlockItem(TUFF_BRICK_CABINET.get(), new Item.Properties()));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CabinetBlockEntity>> CABINET_BLOCK_ENTITY = BlockRegistration.BLOCK_ENTITY.register("cabinet_block_entity",
        () -> BlockEntityType.Builder.of(CabinetBlockEntity::new, OAK_CABINET.get(),
            COBBLESTONE_CABINET.get(),
            BRICK_CABINET.get(),
            STONE_BRICK_CABINET.get(),
            MUD_BRICK_CABINET.get(),
            NETHER_BRICK_CABINET.get(),
            SANDSTONE_CABINET.get(),
            SPRUCE_CABINET.get(),
            BIRCH_CABINET.get(),
            JUNGLE_CABINET.get(),
            QUARTZ_CABINET.get(),
            ACACIA_CABINET.get(),
            CHERRY_CABINET.get(),
            DARK_OAK_CABINET.get(),
            MANGROVE_CABINET.get(),
            BAMBOO_CABINET.get(),
            BAMBOO_MOSAIC_CABINET.get(),
            PRISMARINE_CABINET.get(),
            PRISMARINE_BRICK_CABINET.get(),
            DARK_PRISMARINE_CABINET.get(),
            RED_SANDSTONE_CABINET.get(),
            PURPUR_CABINET.get(),
            POLISHED_GRANITE_CABINET.get(),
            SMOOTH_RED_SANDSTONE_CABINET.get(),
            MOSSY_STONE_BRICK_CABINET.get(),
            POLISHED_DIORITE_CABINET.get(),
            MOSSY_COBBLESTONE_CABINET.get(),
            END_STONE_BRICK_CABINET.get(),
            STONE_CABINET.get(),
            SMOOTH_SANDSTONE_CABINET.get(),
            SMOOTH_QUARTZ_CABINET.get(),
            GRANITE_CABINET.get(),
            ANDESITE_CABINET.get(),
            RED_NETHER_BRICK_CABINET.get(),
            POLISHED_ANDESITE_CABINET.get(),
            DIORITE_CABINET.get(),
            CRIMSON_CABINET.get(),
            WARPED_CABINET.get(),
            BLACKSTONE_CABINET.get(),
            POLISHED_BLACKSTONE_BRICK_CABINET.get(),
            POLISHED_BLACKSTONE_CABINET.get(),
            OXIDIZED_CUT_COPPER_CABINET.get(),
            WEATHERED_CUT_COPPER_CABINET.get(),
            EXPOSED_CUT_COPPER_CABINET.get(),
            CUT_COPPER_CABINET.get(),
            WAXED_OXIDIZED_CUT_COPPER_CABINET.get(),
            WAXED_WEATHERED_CUT_COPPER_CABINET.get(),
            WAXED_EXPOSED_CUT_COPPER_CABINET.get(),
            WAXED_CUT_COPPER_CABINET.get(),
            COBBLED_DEEPSLATE_CABINET.get(),
            POLISHED_DEEPSLATE_CABINET.get(),
            DEEPSLATE_TILE_CABINET.get(),
            DEEPSLATE_BRICK_CABINET.get(),
            TUFF_CABINET.get(),
            POLISHED_TUFF_CABINET.get(),
            TUFF_BRICK_CABINET.get()
        ).build(null)
    );

    @Contract("_, _ -> new")
    @SuppressWarnings("deprecation")
    public static @NotNull CabinetBlock usageCabinetBlock(@NotNull Block propertyBlock, int mapId) {
        return new CabinetBlock(BlockBehaviour.Properties.ofLegacyCopy(propertyBlock).noOcclusion(), propertyBlock.defaultBlockState(), mapId);
    }

    @Contract("_, _, _ -> new")
    @SuppressWarnings("deprecation")
    public static @NotNull WeatheredCopperCabinet usageWeatheredCabinet(@NotNull Block propertyBlock, WeatheringCopper.WeatherState weatherState, int mapId) {
        return new WeatheredCopperCabinet(propertyBlock.defaultBlockState(), BlockBehaviour.Properties.ofLegacyCopy(propertyBlock), weatherState, mapId);
    }
}
