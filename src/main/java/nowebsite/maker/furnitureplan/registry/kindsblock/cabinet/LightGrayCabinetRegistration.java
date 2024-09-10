package nowebsite.maker.furnitureplan.registry.kindsblock.cabinet;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredHolder;
import nowebsite.maker.furnitureplan.blocks.singleblockfurniture.ColorfulBorderedCabinet;
import nowebsite.maker.furnitureplan.blocks.singleblockfurniture.WeatheredColorfulBorderedCopperCabinet;
import nowebsite.maker.furnitureplan.blocks.singleblockfurniture.blockentities.CabinetBlockEntity;
import nowebsite.maker.furnitureplan.registry.BlockRegistration;
import nowebsite.maker.furnitureplan.registry.ItemRegistration;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class LightGrayCabinetRegistration {
    public static void init(){
    }
    public static final DeferredHolder<Block, ColorfulBorderedCabinet> OAK_CABINET = BlockRegistration.BLOCKS.register("oak_cabinet_light_gray", () -> usageColorfulBorderedCabinet(Blocks.OAK_PLANKS));
    public static final DeferredHolder<Block, ColorfulBorderedCabinet> COBBLESTONE_CABINET = BlockRegistration.BLOCKS.register("cobblestone_cabinet_light_gray", () -> usageColorfulBorderedCabinet(Blocks.COBBLESTONE));
    public static final DeferredHolder<Block, ColorfulBorderedCabinet> BRICK_CABINET = BlockRegistration.BLOCKS.register("brick_cabinet_light_gray", () -> usageColorfulBorderedCabinet(Blocks.BRICKS));
    public static final DeferredHolder<Block, ColorfulBorderedCabinet> STONE_BRICK_CABINET = BlockRegistration.BLOCKS.register("stone_brick_cabinet_light_gray", () -> usageColorfulBorderedCabinet(Blocks.STONE_BRICKS));
    public static final DeferredHolder<Block, ColorfulBorderedCabinet> MUD_BRICK_CABINET = BlockRegistration.BLOCKS.register("mud_brick_cabinet_light_gray", () -> usageColorfulBorderedCabinet(Blocks.MUD_BRICKS));
    public static final DeferredHolder<Block, ColorfulBorderedCabinet> NETHER_BRICK_CABINET = BlockRegistration.BLOCKS.register("nether_brick_cabinet_light_gray", () -> usageColorfulBorderedCabinet(Blocks.NETHER_BRICKS));
    public static final DeferredHolder<Block, ColorfulBorderedCabinet> SANDSTONE_CABINET = BlockRegistration.BLOCKS.register("sandstone_cabinet_light_gray", () -> usageColorfulBorderedCabinet(Blocks.SANDSTONE));
    public static final DeferredHolder<Block, ColorfulBorderedCabinet> SPRUCE_CABINET = BlockRegistration.BLOCKS.register("spruce_cabinet_light_gray", () -> usageColorfulBorderedCabinet(Blocks.SPRUCE_PLANKS));
    public static final DeferredHolder<Block, ColorfulBorderedCabinet> BIRCH_CABINET = BlockRegistration.BLOCKS.register("birch_cabinet_light_gray", () -> usageColorfulBorderedCabinet(Blocks.BIRCH_PLANKS));
    public static final DeferredHolder<Block, ColorfulBorderedCabinet> JUNGLE_CABINET = BlockRegistration.BLOCKS.register("jungle_cabinet_light_gray", () -> usageColorfulBorderedCabinet(Blocks.JUNGLE_PLANKS));
    public static final DeferredHolder<Block, ColorfulBorderedCabinet> QUARTZ_CABINET = BlockRegistration.BLOCKS.register("quartz_cabinet_light_gray", () -> usageColorfulBorderedCabinet(Blocks.QUARTZ_BLOCK));
    public static final DeferredHolder<Block, ColorfulBorderedCabinet> ACACIA_CABINET = BlockRegistration.BLOCKS.register("acacia_cabinet_light_gray", () -> usageColorfulBorderedCabinet(Blocks.ACACIA_PLANKS));
    public static final DeferredHolder<Block, ColorfulBorderedCabinet> CHERRY_CABINET = BlockRegistration.BLOCKS.register("cherry_cabinet_light_gray", () -> usageColorfulBorderedCabinet(Blocks.CHERRY_PLANKS));
    public static final DeferredHolder<Block, ColorfulBorderedCabinet> DARK_OAK_CABINET = BlockRegistration.BLOCKS.register("dark_oak_cabinet_light_gray", () -> usageColorfulBorderedCabinet(Blocks.DARK_OAK_PLANKS));
    public static final DeferredHolder<Block, ColorfulBorderedCabinet> MANGROVE_CABINET = BlockRegistration.BLOCKS.register("mangrove_cabinet_light_gray", () -> usageColorfulBorderedCabinet(Blocks.MANGROVE_PLANKS));
    public static final DeferredHolder<Block, ColorfulBorderedCabinet> BAMBOO_CABINET = BlockRegistration.BLOCKS.register("bamboo_cabinet_light_gray", () -> usageColorfulBorderedCabinet(Blocks.BAMBOO_PLANKS));
    public static final DeferredHolder<Block, ColorfulBorderedCabinet> BAMBOO_MOSAIC_CABINET = BlockRegistration.BLOCKS.register("bamboo_mosaic_cabinet_light_gray", () -> usageColorfulBorderedCabinet(Blocks.BAMBOO_MOSAIC));
    public static final DeferredHolder<Block, ColorfulBorderedCabinet> PRISMARINE_CABINET = BlockRegistration.BLOCKS.register("prismarine_cabinet_light_gray", () -> usageColorfulBorderedCabinet(Blocks.PRISMARINE));
    public static final DeferredHolder<Block, ColorfulBorderedCabinet> PRISMARINE_BRICK_CABINET = BlockRegistration.BLOCKS.register("prismarine_brick_cabinet_light_gray", () -> usageColorfulBorderedCabinet(Blocks.PRISMARINE_BRICKS));
    public static final DeferredHolder<Block, ColorfulBorderedCabinet> DARK_PRISMARINE_CABINET = BlockRegistration.BLOCKS.register("dark_prismarine_cabinet_light_gray", () -> usageColorfulBorderedCabinet(Blocks.DARK_PRISMARINE));
    public static final DeferredHolder<Block, ColorfulBorderedCabinet> RED_SANDSTONE_CABINET = BlockRegistration.BLOCKS.register("red_sandstone_cabinet_light_gray", () -> usageColorfulBorderedCabinet(Blocks.RED_SANDSTONE));
    public static final DeferredHolder<Block, ColorfulBorderedCabinet> PURPUR_CABINET = BlockRegistration.BLOCKS.register("purpur_cabinet_light_gray", () -> usageColorfulBorderedCabinet(Blocks.PURPUR_BLOCK));
    public static final DeferredHolder<Block, ColorfulBorderedCabinet> POLISHED_GRANITE_CABINET = BlockRegistration.BLOCKS.register("polished_granite_cabinet_light_gray", () -> usageColorfulBorderedCabinet(Blocks.POLISHED_GRANITE));
    public static final DeferredHolder<Block, ColorfulBorderedCabinet> SMOOTH_RED_SANDSTONE_CABINET = BlockRegistration.BLOCKS.register("smooth_red_sandstone_cabinet_light_gray", () -> usageColorfulBorderedCabinet(Blocks.SMOOTH_RED_SANDSTONE));
    public static final DeferredHolder<Block, ColorfulBorderedCabinet> MOSSY_STONE_BRICK_CABINET = BlockRegistration.BLOCKS.register("mossy_stone_brick_cabinet_light_gray", () -> usageColorfulBorderedCabinet(Blocks.MOSSY_STONE_BRICKS));
    public static final DeferredHolder<Block, ColorfulBorderedCabinet> POLISHED_DIORITE_CABINET = BlockRegistration.BLOCKS.register("polished_diorite_cabinet_light_gray", () -> usageColorfulBorderedCabinet(Blocks.POLISHED_DIORITE));
    public static final DeferredHolder<Block, ColorfulBorderedCabinet> MOSSY_COBBLESTONE_CABINET = BlockRegistration.BLOCKS.register("mossy_cobblestone_cabinet_light_gray", () -> usageColorfulBorderedCabinet(Blocks.MOSSY_COBBLESTONE));
    public static final DeferredHolder<Block, ColorfulBorderedCabinet> END_STONE_BRICK_CABINET = BlockRegistration.BLOCKS.register("end_stone_brick_cabinet_light_gray", () -> usageColorfulBorderedCabinet(Blocks.END_STONE_BRICKS));
    public static final DeferredHolder<Block, ColorfulBorderedCabinet> STONE_CABINET = BlockRegistration.BLOCKS.register("stone_cabinet_light_gray", () -> usageColorfulBorderedCabinet(Blocks.STONE));
    public static final DeferredHolder<Block, ColorfulBorderedCabinet> SMOOTH_SANDSTONE_CABINET = BlockRegistration.BLOCKS.register("smooth_sandstone_cabinet_light_gray", () -> usageColorfulBorderedCabinet(Blocks.SMOOTH_SANDSTONE));
    public static final DeferredHolder<Block, ColorfulBorderedCabinet> SMOOTH_QUARTZ_CABINET = BlockRegistration.BLOCKS.register("smooth_quartz_cabinet_light_gray", () -> usageColorfulBorderedCabinet(Blocks.SMOOTH_QUARTZ));
    public static final DeferredHolder<Block, ColorfulBorderedCabinet> GRANITE_CABINET = BlockRegistration.BLOCKS.register("granite_cabinet_light_gray", () -> usageColorfulBorderedCabinet(Blocks.GRANITE));
    public static final DeferredHolder<Block, ColorfulBorderedCabinet> ANDESITE_CABINET = BlockRegistration.BLOCKS.register("andesite_cabinet_light_gray", () -> usageColorfulBorderedCabinet(Blocks.ANDESITE));
    public static final DeferredHolder<Block, ColorfulBorderedCabinet> RED_NETHER_BRICK_CABINET = BlockRegistration.BLOCKS.register("red_nether_brick_cabinet_light_gray", () -> usageColorfulBorderedCabinet(Blocks.RED_NETHER_BRICKS));
    public static final DeferredHolder<Block, ColorfulBorderedCabinet> POLISHED_ANDESITE_CABINET = BlockRegistration.BLOCKS.register("polished_andesite_cabinet_light_gray", () -> usageColorfulBorderedCabinet(Blocks.POLISHED_ANDESITE));
    public static final DeferredHolder<Block, ColorfulBorderedCabinet> DIORITE_CABINET = BlockRegistration.BLOCKS.register("diorite_cabinet_light_gray", () -> usageColorfulBorderedCabinet(Blocks.DIORITE));
    public static final DeferredHolder<Block, ColorfulBorderedCabinet> CRIMSON_CABINET = BlockRegistration.BLOCKS.register("crimson_cabinet_light_gray", () -> usageColorfulBorderedCabinet(Blocks.CRIMSON_PLANKS));
    public static final DeferredHolder<Block, ColorfulBorderedCabinet> WARPED_CABINET = BlockRegistration.BLOCKS.register("warped_cabinet_light_gray", () -> usageColorfulBorderedCabinet(Blocks.WARPED_PLANKS));
    public static final DeferredHolder<Block, ColorfulBorderedCabinet> BLACKSTONE_CABINET = BlockRegistration.BLOCKS.register("blackstone_cabinet_light_gray", () -> usageColorfulBorderedCabinet(Blocks.BLACKSTONE));
    public static final DeferredHolder<Block, ColorfulBorderedCabinet> POLISHED_BLACKSTONE_BRICK_CABINET = BlockRegistration.BLOCKS.register("polished_blackstone_brick_cabinet_light_gray", () -> usageColorfulBorderedCabinet(Blocks.POLISHED_BLACKSTONE_BRICKS));
    public static final DeferredHolder<Block, ColorfulBorderedCabinet> POLISHED_BLACKSTONE_CABINET = BlockRegistration.BLOCKS.register("polished_blackstone_cabinet_light_gray", () -> usageColorfulBorderedCabinet(Blocks.POLISHED_BLACKSTONE));
    public static final DeferredHolder<Block, WeatheredColorfulBorderedCopperCabinet> OXIDIZED_CUT_COPPER_CABINET = BlockRegistration.BLOCKS.register("oxidized_cut_copper_cabinet_light_gray", () -> usageWeatheredCabinet(Blocks.OXIDIZED_CUT_COPPER, WeatheringCopper.WeatherState.OXIDIZED));
    public static final DeferredHolder<Block, WeatheredColorfulBorderedCopperCabinet> WEATHERED_CUT_COPPER_CABINET = BlockRegistration.BLOCKS.register("weathered_cut_copper_cabinet_light_gray", () -> usageWeatheredCabinet(Blocks.WEATHERED_CUT_COPPER, WeatheringCopper.WeatherState.WEATHERED));
    public static final DeferredHolder<Block, WeatheredColorfulBorderedCopperCabinet> EXPOSED_CUT_COPPER_CABINET = BlockRegistration.BLOCKS.register("exposed_cut_copper_cabinet_light_gray", () -> usageWeatheredCabinet(Blocks.EXPOSED_CUT_COPPER, WeatheringCopper.WeatherState.EXPOSED));
    public static final DeferredHolder<Block, WeatheredColorfulBorderedCopperCabinet> CUT_COPPER_CABINET = BlockRegistration.BLOCKS.register("cut_copper_cabinet_light_gray", () -> usageWeatheredCabinet(Blocks.CUT_COPPER, WeatheringCopper.WeatherState.UNAFFECTED));
    public static final DeferredHolder<Block, ColorfulBorderedCabinet> WAXED_OXIDIZED_CUT_COPPER_CABINET = BlockRegistration.BLOCKS.register("waxed_oxidized_cut_copper_cabinet_light_gray", () -> usageColorfulBorderedCabinet(Blocks.WAXED_OXIDIZED_CUT_COPPER));
    public static final DeferredHolder<Block, ColorfulBorderedCabinet> WAXED_WEATHERED_CUT_COPPER_CABINET = BlockRegistration.BLOCKS.register("waxed_weathered_cut_copper_cabinet_light_gray", () -> usageColorfulBorderedCabinet(Blocks.WAXED_WEATHERED_CUT_COPPER));
    public static final DeferredHolder<Block, ColorfulBorderedCabinet> WAXED_EXPOSED_CUT_COPPER_CABINET = BlockRegistration.BLOCKS.register("waxed_exposed_cut_copper_cabinet_light_gray", () -> usageColorfulBorderedCabinet(Blocks.WAXED_EXPOSED_CUT_COPPER));
    public static final DeferredHolder<Block, ColorfulBorderedCabinet> WAXED_CUT_COPPER_CABINET = BlockRegistration.BLOCKS.register("waxed_cut_copper_cabinet_light_gray", () -> usageColorfulBorderedCabinet(Blocks.WAXED_CUT_COPPER));
    public static final DeferredHolder<Block, ColorfulBorderedCabinet> COBBLED_DEEPSLATE_CABINET = BlockRegistration.BLOCKS.register("cobbled_deepslate_cabinet_light_gray", () -> usageColorfulBorderedCabinet(Blocks.COBBLED_DEEPSLATE));
    public static final DeferredHolder<Block, ColorfulBorderedCabinet> POLISHED_DEEPSLATE_CABINET = BlockRegistration.BLOCKS.register("polished_deepslate_cabinet_light_gray", () -> usageColorfulBorderedCabinet(Blocks.POLISHED_DEEPSLATE));
    public static final DeferredHolder<Block, ColorfulBorderedCabinet> DEEPSLATE_TILE_CABINET = BlockRegistration.BLOCKS.register("deepslate_tile_cabinet_light_gray", () -> usageColorfulBorderedCabinet(Blocks.DEEPSLATE_TILES));
    public static final DeferredHolder<Block, ColorfulBorderedCabinet> DEEPSLATE_BRICK_CABINET = BlockRegistration.BLOCKS.register("deepslate_brick_cabinet_light_gray", () -> usageColorfulBorderedCabinet(Blocks.DEEPSLATE_BRICKS));
    public static final DeferredHolder<Item, BlockItem> OAK_CABINET_ITEM = ItemRegistration.ITEMS.register("oak_cabinet_light_gray", () -> new BlockItem(OAK_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> COBBLESTONE_CABINET_ITEM = ItemRegistration.ITEMS.register("cobblestone_cabinet_light_gray", () -> new BlockItem(COBBLESTONE_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> BRICK_CABINET_ITEM = ItemRegistration.ITEMS.register("brick_cabinet_light_gray", () -> new BlockItem(BRICK_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> STONE_BRICK_CABINET_ITEM = ItemRegistration.ITEMS.register("stone_brick_cabinet_light_gray", () -> new BlockItem(STONE_BRICK_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> MUD_BRICK_CABINET_ITEM = ItemRegistration.ITEMS.register("mud_brick_cabinet_light_gray", () -> new BlockItem(MUD_BRICK_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> NETHER_BRICK_CABINET_ITEM = ItemRegistration.ITEMS.register("nether_brick_cabinet_light_gray", () -> new BlockItem(NETHER_BRICK_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> SANDSTONE_CABINET_ITEM = ItemRegistration.ITEMS.register("sandstone_cabinet_light_gray", () -> new BlockItem(SANDSTONE_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> SPRUCE_CABINET_ITEM = ItemRegistration.ITEMS.register("spruce_cabinet_light_gray", () -> new BlockItem(SPRUCE_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> BIRCH_CABINET_ITEM = ItemRegistration.ITEMS.register("birch_cabinet_light_gray", () -> new BlockItem(BIRCH_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> JUNGLE_CABINET_ITEM = ItemRegistration.ITEMS.register("jungle_cabinet_light_gray", () -> new BlockItem(JUNGLE_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> QUARTZ_CABINET_ITEM = ItemRegistration.ITEMS.register("quartz_cabinet_light_gray", () -> new BlockItem(QUARTZ_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> ACACIA_CABINET_ITEM = ItemRegistration.ITEMS.register("acacia_cabinet_light_gray", () -> new BlockItem(ACACIA_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> CHERRY_CABINET_ITEM = ItemRegistration.ITEMS.register("cherry_cabinet_light_gray", () -> new BlockItem(CHERRY_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> DARK_OAK_CABINET_ITEM = ItemRegistration.ITEMS.register("dark_oak_cabinet_light_gray", () -> new BlockItem(DARK_OAK_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> MANGROVE_CABINET_ITEM = ItemRegistration.ITEMS.register("mangrove_cabinet_light_gray", () -> new BlockItem(MANGROVE_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> BAMBOO_CABINET_ITEM = ItemRegistration.ITEMS.register("bamboo_cabinet_light_gray", () -> new BlockItem(BAMBOO_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> BAMBOO_MOSAIC_CABINET_ITEM = ItemRegistration.ITEMS.register("bamboo_mosaic_cabinet_light_gray", () -> new BlockItem(BAMBOO_MOSAIC_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> PRISMARINE_CABINET_ITEM = ItemRegistration.ITEMS.register("prismarine_cabinet_light_gray", () -> new BlockItem(PRISMARINE_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> PRISMARINE_BRICK_CABINET_ITEM = ItemRegistration.ITEMS.register("prismarine_brick_cabinet_light_gray", () -> new BlockItem(PRISMARINE_BRICK_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> DARK_PRISMARINE_CABINET_ITEM = ItemRegistration.ITEMS.register("dark_prismarine_cabinet_light_gray", () -> new BlockItem(DARK_PRISMARINE_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> RED_SANDSTONE_CABINET_ITEM = ItemRegistration.ITEMS.register("red_sandstone_cabinet_light_gray", () -> new BlockItem(RED_SANDSTONE_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> PURPUR_CABINET_ITEM = ItemRegistration.ITEMS.register("purpur_cabinet_light_gray", () -> new BlockItem(PURPUR_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> POLISHED_GRANITE_CABINET_ITEM = ItemRegistration.ITEMS.register("polished_granite_cabinet_light_gray", () -> new BlockItem(POLISHED_GRANITE_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> SMOOTH_RED_SANDSTONE_CABINET_ITEM = ItemRegistration.ITEMS.register("smooth_red_sandstone_cabinet_light_gray", () -> new BlockItem(SMOOTH_RED_SANDSTONE_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> MOSSY_STONE_BRICK_CABINET_ITEM = ItemRegistration.ITEMS.register("mossy_stone_brick_cabinet_light_gray", () -> new BlockItem(MOSSY_STONE_BRICK_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> POLISHED_DIORITE_CABINET_ITEM = ItemRegistration.ITEMS.register("polished_diorite_cabinet_light_gray", () -> new BlockItem(POLISHED_DIORITE_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> MOSSY_COBBLESTONE_CABINET_ITEM = ItemRegistration.ITEMS.register("mossy_cobblestone_cabinet_light_gray", () -> new BlockItem(MOSSY_COBBLESTONE_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> END_STONE_BRICK_CABINET_ITEM = ItemRegistration.ITEMS.register("end_stone_brick_cabinet_light_gray", () -> new BlockItem(END_STONE_BRICK_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> STONE_CABINET_ITEM = ItemRegistration.ITEMS.register("stone_cabinet_light_gray", () -> new BlockItem(STONE_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> SMOOTH_SANDSTONE_CABINET_ITEM = ItemRegistration.ITEMS.register("smooth_sandstone_cabinet_light_gray", () -> new BlockItem(SMOOTH_SANDSTONE_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> SMOOTH_QUARTZ_CABINET_ITEM = ItemRegistration.ITEMS.register("smooth_quartz_cabinet_light_gray", () -> new BlockItem(SMOOTH_QUARTZ_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> GRANITE_CABINET_ITEM = ItemRegistration.ITEMS.register("granite_cabinet_light_gray", () -> new BlockItem(GRANITE_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> ANDESITE_CABINET_ITEM = ItemRegistration.ITEMS.register("andesite_cabinet_light_gray", () -> new BlockItem(ANDESITE_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> RED_NETHER_BRICK_CABINET_ITEM = ItemRegistration.ITEMS.register("red_nether_brick_cabinet_light_gray", () -> new BlockItem(RED_NETHER_BRICK_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> POLISHED_ANDESITE_CABINET_ITEM = ItemRegistration.ITEMS.register("polished_andesite_cabinet_light_gray", () -> new BlockItem(POLISHED_ANDESITE_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> DIORITE_CABINET_ITEM = ItemRegistration.ITEMS.register("diorite_cabinet_light_gray", () -> new BlockItem(DIORITE_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> CRIMSON_CABINET_ITEM = ItemRegistration.ITEMS.register("crimson_cabinet_light_gray", () -> new BlockItem(CRIMSON_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> WARPED_CABINET_ITEM = ItemRegistration.ITEMS.register("warped_cabinet_light_gray", () -> new BlockItem(WARPED_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> BLACKSTONE_CABINET_ITEM = ItemRegistration.ITEMS.register("blackstone_cabinet_light_gray", () -> new BlockItem(BLACKSTONE_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> POLISHED_BLACKSTONE_BRICK_CABINET_ITEM = ItemRegistration.ITEMS.register("polished_blackstone_brick_cabinet_light_gray", () -> new BlockItem(POLISHED_BLACKSTONE_BRICK_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> POLISHED_BLACKSTONE_CABINET_ITEM = ItemRegistration.ITEMS.register("polished_blackstone_cabinet_light_gray", () -> new BlockItem(POLISHED_BLACKSTONE_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> OXIDIZED_CUT_COPPER_CABINET_ITEM = ItemRegistration.ITEMS.register("oxidized_cut_copper_cabinet_light_gray", () -> new BlockItem(OXIDIZED_CUT_COPPER_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> WEATHERED_CUT_COPPER_CABINET_ITEM = ItemRegistration.ITEMS.register("weathered_cut_copper_cabinet_light_gray", () -> new BlockItem(WEATHERED_CUT_COPPER_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> EXPOSED_CUT_COPPER_CABINET_ITEM = ItemRegistration.ITEMS.register("exposed_cut_copper_cabinet_light_gray", () -> new BlockItem(EXPOSED_CUT_COPPER_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> CUT_COPPER_CABINET_ITEM = ItemRegistration.ITEMS.register("cut_copper_cabinet_light_gray", () -> new BlockItem(CUT_COPPER_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> WAXED_OXIDIZED_CUT_COPPER_CABINET_ITEM = ItemRegistration.ITEMS.register("waxed_oxidized_cut_copper_cabinet_light_gray", () -> new BlockItem(WAXED_OXIDIZED_CUT_COPPER_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> WAXED_WEATHERED_CUT_COPPER_CABINET_ITEM = ItemRegistration.ITEMS.register("waxed_weathered_cut_copper_cabinet_light_gray", () -> new BlockItem(WAXED_WEATHERED_CUT_COPPER_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> WAXED_EXPOSED_CUT_COPPER_CABINET_ITEM = ItemRegistration.ITEMS.register("waxed_exposed_cut_copper_cabinet_light_gray", () -> new BlockItem(WAXED_EXPOSED_CUT_COPPER_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> WAXED_CUT_COPPER_CABINET_ITEM = ItemRegistration.ITEMS.register("waxed_cut_copper_cabinet_light_gray", () -> new BlockItem(WAXED_CUT_COPPER_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> COBBLED_DEEPSLATE_CABINET_ITEM = ItemRegistration.ITEMS.register("cobbled_deepslate_cabinet_light_gray", () -> new BlockItem(COBBLED_DEEPSLATE_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> POLISHED_DEEPSLATE_CABINET_ITEM = ItemRegistration.ITEMS.register("polished_deepslate_cabinet_light_gray", () -> new BlockItem(POLISHED_DEEPSLATE_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> DEEPSLATE_TILE_CABINET_ITEM = ItemRegistration.ITEMS.register("deepslate_tile_cabinet_light_gray", () -> new BlockItem(DEEPSLATE_TILE_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> DEEPSLATE_BRICK_CABINET_ITEM = ItemRegistration.ITEMS.register("deepslate_brick_cabinet_light_gray", () -> new BlockItem(DEEPSLATE_BRICK_CABINET.get(), new Item.Properties()));


    public static final DeferredHolder<Block, ColorfulBorderedCabinet> TUFF_CABINET = BlockRegistration.BLOCKS.register("tuff_cabinet_light_gray", () -> usageColorfulBorderedCabinet(Blocks.TUFF));
    public static final DeferredHolder<Block, ColorfulBorderedCabinet> POLISHED_TUFF_CABINET = BlockRegistration.BLOCKS.register("polished_tuff_cabinet_light_gray", () -> usageColorfulBorderedCabinet(Blocks.POLISHED_TUFF));
    public static final DeferredHolder<Block, ColorfulBorderedCabinet> TUFF_BRICK_CABINET = BlockRegistration.BLOCKS.register("tuff_brick_cabinet_light_gray", () -> usageColorfulBorderedCabinet(Blocks.TUFF_BRICKS));
    public static final DeferredHolder<Item, BlockItem> TUFF_CABINET_ITEM = ItemRegistration.ITEMS.register("tuff_cabinet_light_gray", () -> new BlockItem(TUFF_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> POLISHED_TUFF_CABINET_ITEM = ItemRegistration.ITEMS.register("polished_tuff_cabinet_light_gray", () -> new BlockItem(POLISHED_TUFF_CABINET.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> TUFF_BRICK_CABINET_ITEM = ItemRegistration.ITEMS.register("tuff_brick_cabinet_light_gray", () -> new BlockItem(TUFF_BRICK_CABINET.get(), new Item.Properties()));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CabinetBlockEntity>> LIGHT_GRAY_CABINET_BLOCK_ENTITY = BlockRegistration.BLOCK_ENTITY.register("light_gray_cabinet_block_entity",
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

    @Contract("_ -> new")
    @SuppressWarnings("deprecation")
    public static @NotNull ColorfulBorderedCabinet usageColorfulBorderedCabinet(@NotNull Block propertyBlock) {
        return new ColorfulBorderedCabinet(BlockBehaviour.Properties.ofLegacyCopy(propertyBlock).noOcclusion(), propertyBlock.defaultBlockState(), true, 7);
    }

    @Contract("_, _ -> new")
    @SuppressWarnings("deprecation")
    public static @NotNull WeatheredColorfulBorderedCopperCabinet usageWeatheredCabinet(@NotNull Block propertyBlock, WeatheringCopper.WeatherState weatherState) {
        return new WeatheredColorfulBorderedCopperCabinet(propertyBlock.defaultBlockState(), BlockBehaviour.Properties.ofLegacyCopy(propertyBlock), weatherState, true, 7);
    }
}
