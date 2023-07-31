package nowebsite.maker.furnitureplan.registry;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import nowebsite.maker.furnitureplan.registry.kindsblock.ChairBlockRegistration;
import nowebsite.maker.furnitureplan.registry.kindsblock.TableBlockRegistration;

public class FoldingRegistration {
    private static final List<RegistryObject<? extends Block>> CHAIR_BLOCK_SETS = new ArrayList<>(List.of(ChairBlockRegistration.OAK_CHAIRS));
    static {
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.COBBLESTONE_CHAIRS);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.BRICK_CHAIRS);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.STONE_BRICK_CHAIRS);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.MUD_BRICK_CHAIRS);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.NETHER_BRICK_CHAIRS);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.SANDSTONE_CHAIRS);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.SPRUCE_CHAIRS);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.BIRCH_CHAIRS);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.JUNGLE_CHAIRS);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.QUARTZ_CHAIRS);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.ACACIA_CHAIRS);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.CHERRY_CHAIRS);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.DARK_OAK_CHAIRS);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.MANGROVE_CHAIRS);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.BAMBOO_CHAIRS);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.BAMBOO_MOSAIC_CHAIRS);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.PRISMARINE_CHAIRS);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.PRISMARINE_BRICK_CHAIRS);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.DARK_PRISMARINE_CHAIRS);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.RED_SANDSTONE_CHAIRS);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.PURPUR_CHAIRS);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.POLISHED_GRANITE_CHAIRS);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.SMOOTH_RED_SANDSTONE_CHAIRS);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.MOSSY_STONE_BRICK_CHAIRS);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.POLISHED_DIORITE_CHAIRS);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.MOSSY_COBBLESTONE_CHAIRS);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.END_STONE_BRICK_CHAIRS);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.STONE_CHAIRS);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.SMOOTH_SANDSTONE_CHAIRS);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.SMOOTH_QUARTZ_CHAIRS);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.GRANITE_CHAIRS);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.ANDESITE_CHAIRS);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.RED_NETHER_BRICK_CHAIRS);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.POLISHED_ANDESITE_CHAIRS);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.DIORITE_CHAIRS);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.CRIMSON_CHAIRS);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.WARPED_CHAIRS);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.BLACKSTONE_CHAIRS);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.POLISHED_BLACKSTONE_BRICK_CHAIRS);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.POLISHED_BLACKSTONE_CHAIRS);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.OXIDIZED_CUT_COPPER_CHAIRS);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.WEATHERED_CUT_COPPER_CHAIRS);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.EXPOSED_CUT_COPPER_CHAIRS);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.CUT_COPPER_CHAIRS);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.WAXED_OXIDIZED_CUT_COPPER_CHAIRS);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.WAXED_WEATHERED_CUT_COPPER_CHAIRS);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.WAXED_EXPOSED_CUT_COPPER_CHAIRS);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.WAXED_CUT_COPPER_CHAIRS);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.COBBLED_DEEPSLATE_CHAIRS);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.POLISHED_DEEPSLATE_CHAIRS);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.DEEPSLATE_TILE_CHAIRS);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.DEEPSLATE_BRICK_CHAIRS);
    }

    private static final List<RegistryObject<? extends Item>> CHAIR_ITEM_SETS = new ArrayList<>(List.of(ChairBlockRegistration.OAK_CHAIRS_ITEM));
    static {
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.COBBLESTONE_CHAIRS_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.BRICK_CHAIRS_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.STONE_BRICK_CHAIRS_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.MUD_BRICK_CHAIRS_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.NETHER_BRICK_CHAIRS_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.SANDSTONE_CHAIRS_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.SPRUCE_CHAIRS_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.BIRCH_CHAIRS_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.JUNGLE_CHAIRS_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.QUARTZ_CHAIRS_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.ACACIA_CHAIRS_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.CHERRY_CHAIRS_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.DARK_OAK_CHAIRS_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.MANGROVE_CHAIRS_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.BAMBOO_CHAIRS_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.BAMBOO_MOSAIC_CHAIRS_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.PRISMARINE_CHAIRS_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.PRISMARINE_BRICK_CHAIRS_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.DARK_PRISMARINE_CHAIRS_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.RED_SANDSTONE_CHAIRS_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.PURPUR_CHAIRS_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.POLISHED_GRANITE_CHAIRS_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.SMOOTH_RED_SANDSTONE_CHAIRS_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.MOSSY_STONE_BRICK_CHAIRS_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.POLISHED_DIORITE_CHAIRS_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.MOSSY_COBBLESTONE_CHAIRS_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.END_STONE_BRICK_CHAIRS_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.STONE_CHAIRS_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.SMOOTH_SANDSTONE_CHAIRS_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.SMOOTH_QUARTZ_CHAIRS_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.GRANITE_CHAIRS_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.ANDESITE_CHAIRS_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.RED_NETHER_BRICK_CHAIRS_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.POLISHED_ANDESITE_CHAIRS_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.DIORITE_CHAIRS_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.CRIMSON_CHAIRS_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.WARPED_CHAIRS_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.BLACKSTONE_CHAIRS_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.POLISHED_BLACKSTONE_BRICK_CHAIRS_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.POLISHED_BLACKSTONE_CHAIRS_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.OXIDIZED_CUT_COPPER_CHAIRS_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.WEATHERED_CUT_COPPER_CHAIRS_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.EXPOSED_CUT_COPPER_CHAIRS_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.CUT_COPPER_CHAIRS_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.WAXED_OXIDIZED_CUT_COPPER_CHAIRS_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.WAXED_WEATHERED_CUT_COPPER_CHAIRS_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.WAXED_EXPOSED_CUT_COPPER_CHAIRS_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.WAXED_CUT_COPPER_CHAIRS_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.COBBLED_DEEPSLATE_CHAIRS_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.POLISHED_DEEPSLATE_CHAIRS_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.DEEPSLATE_TILE_CHAIRS_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.DEEPSLATE_BRICK_CHAIRS_ITEM);
    }

    private static final List<RegistryObject<? extends Block>> TABLE_BLOCK_SETS = new ArrayList<>(List.of(TableBlockRegistration.OAK_TABLES));
    static {
        TABLE_BLOCK_SETS.add(TableBlockRegistration.COBBLESTONE_TABLES);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.BRICK_TABLES);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.STONE_BRICK_TABLES);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.MUD_BRICK_TABLES);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.NETHER_BRICK_TABLES);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.SANDSTONE_TABLES);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.SPRUCE_TABLES);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.BIRCH_TABLES);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.JUNGLE_TABLES);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.QUARTZ_TABLES);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.ACACIA_TABLES);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.CHERRY_TABLES);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.DARK_OAK_TABLES);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.MANGROVE_TABLES);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.BAMBOO_TABLES);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.BAMBOO_MOSAIC_TABLES);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.PRISMARINE_TABLES);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.PRISMARINE_BRICK_TABLES);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.DARK_PRISMARINE_TABLES);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.RED_SANDSTONE_TABLES);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.PURPUR_TABLES);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.POLISHED_GRANITE_TABLES);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.SMOOTH_RED_SANDSTONE_TABLES);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.MOSSY_STONE_BRICK_TABLES);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.POLISHED_DIORITE_TABLES);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.MOSSY_COBBLESTONE_TABLES);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.END_STONE_BRICK_TABLES);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.STONE_TABLES);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.SMOOTH_SANDSTONE_TABLES);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.SMOOTH_QUARTZ_TABLES);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.GRANITE_TABLES);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.ANDESITE_TABLES);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.RED_NETHER_BRICK_TABLES);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.POLISHED_ANDESITE_TABLES);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.DIORITE_TABLES);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.CRIMSON_TABLES);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.WARPED_TABLES);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.BLACKSTONE_TABLES);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.POLISHED_BLACKSTONE_BRICK_TABLES);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.POLISHED_BLACKSTONE_TABLES);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.OXIDIZED_CUT_COPPER_TABLES);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.WEATHERED_CUT_COPPER_TABLES);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.EXPOSED_CUT_COPPER_TABLES);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.CUT_COPPER_TABLES);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.WAXED_OXIDIZED_CUT_COPPER_TABLES);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.WAXED_WEATHERED_CUT_COPPER_TABLES);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.WAXED_EXPOSED_CUT_COPPER_TABLES);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.WAXED_CUT_COPPER_TABLES);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.COBBLED_DEEPSLATE_TABLES);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.POLISHED_DEEPSLATE_TABLES);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.DEEPSLATE_TILE_TABLES);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.DEEPSLATE_BRICK_TABLES);
    }

    private static final List<RegistryObject<? extends Item>> TABLE_ITEM_SETS = new ArrayList<>(List.of(TableBlockRegistration.OAK_TABLES_ITEM));
    static {
        TABLE_ITEM_SETS.add(TableBlockRegistration.COBBLESTONE_TABLES_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.BRICK_TABLES_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.STONE_BRICK_TABLES_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.MUD_BRICK_TABLES_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.NETHER_BRICK_TABLES_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.SANDSTONE_TABLES_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.SPRUCE_TABLES_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.BIRCH_TABLES_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.JUNGLE_TABLES_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.QUARTZ_TABLES_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.ACACIA_TABLES_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.CHERRY_TABLES_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.DARK_OAK_TABLES_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.MANGROVE_TABLES_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.BAMBOO_TABLES_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.BAMBOO_MOSAIC_TABLES_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.PRISMARINE_TABLES_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.PRISMARINE_BRICK_TABLES_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.DARK_PRISMARINE_TABLES_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.RED_SANDSTONE_TABLES_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.PURPUR_TABLES_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.POLISHED_GRANITE_TABLES_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.SMOOTH_RED_SANDSTONE_TABLES_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.MOSSY_STONE_BRICK_TABLES_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.POLISHED_DIORITE_TABLES_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.MOSSY_COBBLESTONE_TABLES_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.END_STONE_BRICK_TABLES_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.STONE_TABLES_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.SMOOTH_SANDSTONE_TABLES_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.SMOOTH_QUARTZ_TABLES_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.GRANITE_TABLES_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.ANDESITE_TABLES_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.RED_NETHER_BRICK_TABLES_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.POLISHED_ANDESITE_TABLES_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.DIORITE_TABLES_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.CRIMSON_TABLES_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.WARPED_TABLES_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.BLACKSTONE_TABLES_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.POLISHED_BLACKSTONE_BRICK_TABLES_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.POLISHED_BLACKSTONE_TABLES_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.OXIDIZED_CUT_COPPER_TABLES_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.WEATHERED_CUT_COPPER_TABLES_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.EXPOSED_CUT_COPPER_TABLES_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.CUT_COPPER_TABLES_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.WAXED_OXIDIZED_CUT_COPPER_TABLES_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.WAXED_WEATHERED_CUT_COPPER_TABLES_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.WAXED_EXPOSED_CUT_COPPER_TABLES_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.WAXED_CUT_COPPER_TABLES_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.COBBLED_DEEPSLATE_TABLES_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.POLISHED_DEEPSLATE_TABLES_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.DEEPSLATE_TILE_TABLES_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.DEEPSLATE_BRICK_TABLES_ITEM);
    }


    public static List<RegistryObject<? extends Block>> getChairBlockLists() {
        return CHAIR_BLOCK_SETS;
    }

    public static List<RegistryObject<? extends Item>> getChairItemLists() {
        return CHAIR_ITEM_SETS;
    }

    public static List<RegistryObject<? extends Block>> getTableBlockLists() {
        return TABLE_BLOCK_SETS;
    }

    public static List<RegistryObject<? extends Item>> getTableItemLists() {
        return TABLE_ITEM_SETS;
    }


    public static final List<TagKey<Block>> PROPERTY_TAGS = new ArrayList<>();
    static {
        PROPERTY_TAGS.add(BlockTags.MINEABLE_WITH_AXE);
        PROPERTY_TAGS.add(BlockTags.MINEABLE_WITH_PICKAXE);
        PROPERTY_TAGS.add(BlockTags.MINEABLE_WITH_PICKAXE);
        PROPERTY_TAGS.add(BlockTags.MINEABLE_WITH_PICKAXE);
        PROPERTY_TAGS.add(BlockTags.MINEABLE_WITH_PICKAXE);
        PROPERTY_TAGS.add(BlockTags.MINEABLE_WITH_PICKAXE);
        PROPERTY_TAGS.add(BlockTags.MINEABLE_WITH_PICKAXE);
        PROPERTY_TAGS.add(BlockTags.MINEABLE_WITH_AXE);
        PROPERTY_TAGS.add(BlockTags.MINEABLE_WITH_AXE);
        PROPERTY_TAGS.add(BlockTags.MINEABLE_WITH_AXE);
        PROPERTY_TAGS.add(BlockTags.MINEABLE_WITH_PICKAXE);
        PROPERTY_TAGS.add(BlockTags.MINEABLE_WITH_AXE);
        PROPERTY_TAGS.add(BlockTags.MINEABLE_WITH_AXE);
        PROPERTY_TAGS.add(BlockTags.MINEABLE_WITH_AXE);
        PROPERTY_TAGS.add(BlockTags.MINEABLE_WITH_AXE);
        PROPERTY_TAGS.add(BlockTags.MINEABLE_WITH_AXE);
        PROPERTY_TAGS.add(BlockTags.MINEABLE_WITH_AXE);
        PROPERTY_TAGS.add(BlockTags.MINEABLE_WITH_PICKAXE);
        PROPERTY_TAGS.add(BlockTags.MINEABLE_WITH_PICKAXE);
        PROPERTY_TAGS.add(BlockTags.MINEABLE_WITH_PICKAXE);
        PROPERTY_TAGS.add(BlockTags.MINEABLE_WITH_PICKAXE);
        PROPERTY_TAGS.add(BlockTags.MINEABLE_WITH_PICKAXE);
        PROPERTY_TAGS.add(BlockTags.MINEABLE_WITH_PICKAXE);
        PROPERTY_TAGS.add(BlockTags.MINEABLE_WITH_PICKAXE);
        PROPERTY_TAGS.add(BlockTags.MINEABLE_WITH_PICKAXE);
        PROPERTY_TAGS.add(BlockTags.MINEABLE_WITH_PICKAXE);
        PROPERTY_TAGS.add(BlockTags.MINEABLE_WITH_PICKAXE);
        PROPERTY_TAGS.add(BlockTags.MINEABLE_WITH_PICKAXE);
        PROPERTY_TAGS.add(BlockTags.MINEABLE_WITH_PICKAXE);
        PROPERTY_TAGS.add(BlockTags.MINEABLE_WITH_PICKAXE);
        PROPERTY_TAGS.add(BlockTags.MINEABLE_WITH_PICKAXE);
        PROPERTY_TAGS.add(BlockTags.MINEABLE_WITH_PICKAXE);
        PROPERTY_TAGS.add(BlockTags.MINEABLE_WITH_PICKAXE);
        PROPERTY_TAGS.add(BlockTags.MINEABLE_WITH_PICKAXE);
        PROPERTY_TAGS.add(BlockTags.MINEABLE_WITH_PICKAXE);
        PROPERTY_TAGS.add(BlockTags.MINEABLE_WITH_PICKAXE);
        PROPERTY_TAGS.add(BlockTags.MINEABLE_WITH_AXE);
        PROPERTY_TAGS.add(BlockTags.MINEABLE_WITH_AXE);
        PROPERTY_TAGS.add(BlockTags.MINEABLE_WITH_PICKAXE);
        PROPERTY_TAGS.add(BlockTags.MINEABLE_WITH_PICKAXE);
        PROPERTY_TAGS.add(BlockTags.MINEABLE_WITH_PICKAXE);
        PROPERTY_TAGS.add(BlockTags.MINEABLE_WITH_PICKAXE);
        PROPERTY_TAGS.add(BlockTags.MINEABLE_WITH_PICKAXE);
        PROPERTY_TAGS.add(BlockTags.MINEABLE_WITH_PICKAXE);
        PROPERTY_TAGS.add(BlockTags.MINEABLE_WITH_PICKAXE);
        PROPERTY_TAGS.add(BlockTags.MINEABLE_WITH_PICKAXE);
        PROPERTY_TAGS.add(BlockTags.MINEABLE_WITH_PICKAXE);
        PROPERTY_TAGS.add(BlockTags.MINEABLE_WITH_PICKAXE);
        PROPERTY_TAGS.add(BlockTags.MINEABLE_WITH_PICKAXE);
        PROPERTY_TAGS.add(BlockTags.MINEABLE_WITH_PICKAXE);
        PROPERTY_TAGS.add(BlockTags.MINEABLE_WITH_PICKAXE);
        PROPERTY_TAGS.add(BlockTags.MINEABLE_WITH_PICKAXE);
        PROPERTY_TAGS.add(BlockTags.MINEABLE_WITH_PICKAXE);
    }


    public static final String[] PROPERTY_KINDS = new String[]{
            "oak_planks",
            "cobblestone",
            "bricks",
            "stone_bricks",
            "mud_bricks",
            "nether_bricks",
            "sandstone_bottom",
            "spruce_planks",
            "birch_planks",
            "jungle_planks",
            "quartz_block_top",
            "acacia_planks",
            "cherry_planks",
            "dark_oak_planks",
            "mangrove_planks",
            "bamboo_planks",
            "bamboo_mosaic",
            "prismarine",
            "prismarine_bricks",
            "dark_prismarine",
            "red_sandstone_bottom",
            "purpur_block",
            "polished_granite",
            "red_sandstone_top",
            "mossy_stone_bricks",
            "polished_diorite",
            "mossy_cobblestone",
            "end_stone_bricks",
            "stone",
            "sandstone_top",
            "quartz_block_bottom",
            "granite",
            "andesite",
            "red_nether_bricks",
            "polished_andesite",
            "diorite",
            "crimson_planks",
            "warped_planks",
            "blackstone",
            "polished_blackstone_bricks",
            "polished_blackstone",
            "oxidized_cut_copper",
            "weathered_cut_copper",
            "exposed_cut_copper",
            "cut_copper",
            "oxidized_cut_copper",
            "weathered_cut_copper",
            "exposed_cut_copper",
            "cut_copper",
            "cobbled_deepslate",
            "polished_deepslate",
            "deepslate_tiles",
            "deepslate_bricks"
    };
    public static final String[] PROPERTY_KINDS_CHINESE_KEY = new String[]{
            "橡木",
            "圆石",
            "砖",
            "石砖",
            "泥砖",
            "下界砖",
            "砂岩",
            "云杉木",
            "白桦木",
            "从林木",
            "石英",
            "金合欢木",
            "樱花木",
            "深色橡木",
            "红树木板",
            "竹板",
            "编织竹板",
            "海晶石",
            "海晶石砖",
            "暗海晶石",
            "红砂岩",
            "紫珀",
            "磨制花岗岩",
            "平滑红砂岩",
            "苔石砖",
            "磨制闪长岩",
            "苔石",
            "末地石砖",
            "石",
            "平滑砂岩",
            "平滑石英",
            "花岗岩",
            "安山岩",
            "红色下界砖",
            "磨制安山岩",
            "闪长岩",
            "绯红木",
            "诡异木",
            "黑石",
            "磨制黑石砖",
            "磨制黑石",
            "氧化的切制铜",
            "锈蚀的切制铜",
            "斑驳的切制铜",
            "切制铜",
            "氧化的涂蜡切制铜",
            "锈蚀的涂蜡切制铜",
            "斑驳的涂蜡切制铜",
            "涂蜡切制铜",
            "深板岩圆石",
            "磨制的深板岩",
            "深板岩瓦",
            "深板岩砖"
    };
}