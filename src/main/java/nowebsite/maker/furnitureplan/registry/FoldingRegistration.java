package nowebsite.maker.furnitureplan.registry;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.RegistryObject;
import nowebsite.maker.furnitureplan.registry.kindsblock.*;

public class FoldingRegistration {
    private static final List<RegistryObject<? extends Block>> CHAIR_BLOCK_SETS =
            new ArrayList<>(List.of(ChairBlockRegistration.OAK_CHAIRS));
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

    private static final List<RegistryObject<? extends Item>> CHAIR_ITEM_SETS =
            new ArrayList<>(List.of(ChairBlockRegistration.OAK_CHAIRS_ITEM));
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

    private static final List<RegistryObject<? extends Block>> TABLE_BLOCK_SETS =
            new ArrayList<>(List.of(TableBlockRegistration.OAK_TABLES));
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

    private static final List<RegistryObject<? extends Item>> TABLE_ITEM_SETS =
            new ArrayList<>(List.of(TableBlockRegistration.OAK_TABLES_ITEM));
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

    private static final List<RegistryObject<? extends Block>> COLUMN_BLOCK_SETS =
            new ArrayList<>(List.of(ColumnBlockRegistration.OAK_COLUMNS));
    static {
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.COBBLESTONE_COLUMNS);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.BRICK_COLUMNS);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.STONE_BRICK_COLUMNS);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.MUD_BRICK_COLUMNS);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.NETHER_BRICK_COLUMNS);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.SANDSTONE_COLUMNS);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.SPRUCE_COLUMNS);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.BIRCH_COLUMNS);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.JUNGLE_COLUMNS);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.QUARTZ_COLUMNS);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.ACACIA_COLUMNS);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.CHERRY_COLUMNS);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.DARK_OAK_COLUMNS);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.MANGROVE_COLUMNS);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.BAMBOO_COLUMNS);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.BAMBOO_MOSAIC_COLUMNS);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.PRISMARINE_COLUMNS);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.PRISMARINE_BRICK_COLUMNS);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.DARK_PRISMARINE_COLUMNS);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.RED_SANDSTONE_COLUMNS);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.PURPUR_COLUMNS);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.POLISHED_GRANITE_COLUMNS);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.SMOOTH_RED_SANDSTONE_COLUMNS);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.MOSSY_STONE_BRICK_COLUMNS);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.POLISHED_DIORITE_COLUMNS);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.MOSSY_COBBLESTONE_COLUMNS);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.END_STONE_BRICK_COLUMNS);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.STONE_COLUMNS);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.SMOOTH_SANDSTONE_COLUMNS);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.SMOOTH_QUARTZ_COLUMNS);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.GRANITE_COLUMNS);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.ANDESITE_COLUMNS);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.RED_NETHER_BRICK_COLUMNS);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.POLISHED_ANDESITE_COLUMNS);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.DIORITE_COLUMNS);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.CRIMSON_COLUMNS);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.WARPED_COLUMNS);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.BLACKSTONE_COLUMNS);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.POLISHED_BLACKSTONE_BRICK_COLUMNS);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.POLISHED_BLACKSTONE_COLUMNS);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.OXIDIZED_CUT_COPPER_COLUMNS);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.WEATHERED_CUT_COPPER_COLUMNS);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.EXPOSED_CUT_COPPER_COLUMNS);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.CUT_COPPER_COLUMNS);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.WAXED_OXIDIZED_CUT_COPPER_COLUMNS);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.WAXED_WEATHERED_CUT_COPPER_COLUMNS);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.WAXED_EXPOSED_CUT_COPPER_COLUMNS);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.WAXED_CUT_COPPER_COLUMNS);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.COBBLED_DEEPSLATE_COLUMNS);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.POLISHED_DEEPSLATE_COLUMNS);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.DEEPSLATE_TILE_COLUMNS);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.DEEPSLATE_BRICK_COLUMNS);
    }

    private static final List<RegistryObject<? extends Item>> COLUMN_ITEM_SETS =
            new ArrayList<>(List.of(ColumnBlockRegistration.OAK_COLUMNS_ITEM));
    static {
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.COBBLESTONE_COLUMNS_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.BRICK_COLUMNS_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.STONE_BRICK_COLUMNS_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.MUD_BRICK_COLUMNS_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.NETHER_BRICK_COLUMNS_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.SANDSTONE_COLUMNS_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.SPRUCE_COLUMNS_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.BIRCH_COLUMNS_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.JUNGLE_COLUMNS_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.QUARTZ_COLUMNS_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.ACACIA_COLUMNS_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.CHERRY_COLUMNS_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.DARK_OAK_COLUMNS_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.MANGROVE_COLUMNS_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.BAMBOO_COLUMNS_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.BAMBOO_MOSAIC_COLUMNS_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.PRISMARINE_COLUMNS_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.PRISMARINE_BRICK_COLUMNS_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.DARK_PRISMARINE_COLUMNS_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.RED_SANDSTONE_COLUMNS_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.PURPUR_COLUMNS_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.POLISHED_GRANITE_COLUMNS_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.SMOOTH_RED_SANDSTONE_COLUMNS_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.MOSSY_STONE_BRICK_COLUMNS_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.POLISHED_DIORITE_COLUMNS_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.MOSSY_COBBLESTONE_COLUMNS_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.END_STONE_BRICK_COLUMNS_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.STONE_COLUMNS_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.SMOOTH_SANDSTONE_COLUMNS_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.SMOOTH_QUARTZ_COLUMNS_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.GRANITE_COLUMNS_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.ANDESITE_COLUMNS_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.RED_NETHER_BRICK_COLUMNS_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.POLISHED_ANDESITE_COLUMNS_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.DIORITE_COLUMNS_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.CRIMSON_COLUMNS_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.WARPED_COLUMNS_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.BLACKSTONE_COLUMNS_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.POLISHED_BLACKSTONE_BRICK_COLUMNS_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.POLISHED_BLACKSTONE_COLUMNS_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.OXIDIZED_CUT_COPPER_COLUMNS_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.WEATHERED_CUT_COPPER_COLUMNS_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.EXPOSED_CUT_COPPER_COLUMNS_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.CUT_COPPER_COLUMNS_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.WAXED_OXIDIZED_CUT_COPPER_COLUMNS_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.WAXED_WEATHERED_CUT_COPPER_COLUMNS_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.WAXED_EXPOSED_CUT_COPPER_COLUMNS_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.WAXED_CUT_COPPER_COLUMNS_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.COBBLED_DEEPSLATE_COLUMNS_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.POLISHED_DEEPSLATE_COLUMNS_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.DEEPSLATE_TILE_COLUMNS_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.DEEPSLATE_BRICK_COLUMNS_ITEM);
    }

    private static final List<RegistryObject<? extends Block>> CARVED_COLUMN_BLOCK_SETS =
            new ArrayList<>(List.of(CarvedColumnBlockRegistration.OAK_CARVED_COLUMNS));
    static {
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.COBBLESTONE_CARVED_COLUMNS);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.BRICK_CARVED_COLUMNS);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.STONE_BRICK_CARVED_COLUMNS);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.MUD_BRICK_CARVED_COLUMNS);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.NETHER_BRICK_CARVED_COLUMNS);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.SANDSTONE_CARVED_COLUMNS);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.SPRUCE_CARVED_COLUMNS);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.BIRCH_CARVED_COLUMNS);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.JUNGLE_CARVED_COLUMNS);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.QUARTZ_CARVED_COLUMNS);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.ACACIA_CARVED_COLUMNS);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.CHERRY_CARVED_COLUMNS);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.DARK_OAK_CARVED_COLUMNS);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.MANGROVE_CARVED_COLUMNS);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.BAMBOO_CARVED_COLUMNS);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.BAMBOO_MOSAIC_CARVED_COLUMNS);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.PRISMARINE_CARVED_COLUMNS);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.PRISMARINE_BRICK_CARVED_COLUMNS);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.DARK_PRISMARINE_CARVED_COLUMNS);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.RED_SANDSTONE_CARVED_COLUMNS);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.PURPUR_CARVED_COLUMNS);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.POLISHED_GRANITE_CARVED_COLUMNS);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.SMOOTH_RED_SANDSTONE_CARVED_COLUMNS);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.MOSSY_STONE_BRICK_CARVED_COLUMNS);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.POLISHED_DIORITE_CARVED_COLUMNS);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.MOSSY_COBBLESTONE_CARVED_COLUMNS);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.END_STONE_BRICK_CARVED_COLUMNS);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.STONE_CARVED_COLUMNS);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.SMOOTH_SANDSTONE_CARVED_COLUMNS);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.SMOOTH_QUARTZ_CARVED_COLUMNS);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.GRANITE_CARVED_COLUMNS);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.ANDESITE_CARVED_COLUMNS);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.RED_NETHER_BRICK_CARVED_COLUMNS);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.POLISHED_ANDESITE_CARVED_COLUMNS);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.DIORITE_CARVED_COLUMNS);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.CRIMSON_CARVED_COLUMNS);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.WARPED_CARVED_COLUMNS);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.BLACKSTONE_CARVED_COLUMNS);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.POLISHED_BLACKSTONE_BRICK_CARVED_COLUMNS);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.POLISHED_BLACKSTONE_CARVED_COLUMNS);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.OXIDIZED_CUT_COPPER_CARVED_COLUMNS);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.WEATHERED_CUT_COPPER_CARVED_COLUMNS);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.EXPOSED_CUT_COPPER_CARVED_COLUMNS);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.CUT_COPPER_CARVED_COLUMNS);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.WAXED_OXIDIZED_CUT_COPPER_CARVED_COLUMNS);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.WAXED_WEATHERED_CUT_COPPER_CARVED_COLUMNS);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.WAXED_EXPOSED_CUT_COPPER_CARVED_COLUMNS);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.WAXED_CUT_COPPER_CARVED_COLUMNS);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.COBBLED_DEEPSLATE_CARVED_COLUMNS);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.POLISHED_DEEPSLATE_CARVED_COLUMNS);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.DEEPSLATE_TILE_CARVED_COLUMNS);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.DEEPSLATE_BRICK_CARVED_COLUMNS);
    }

    private static final List<RegistryObject<? extends Item>> CARVED_COLUMN_ITEM_SETS =
            new ArrayList<>(List.of(CarvedColumnBlockRegistration.OAK_CARVED_COLUMNS_ITEM));
    static {
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.COBBLESTONE_CARVED_COLUMNS_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.BRICK_CARVED_COLUMNS_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.STONE_BRICK_CARVED_COLUMNS_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.MUD_BRICK_CARVED_COLUMNS_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.NETHER_BRICK_CARVED_COLUMNS_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.SANDSTONE_CARVED_COLUMNS_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.SPRUCE_CARVED_COLUMNS_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.BIRCH_CARVED_COLUMNS_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.JUNGLE_CARVED_COLUMNS_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.QUARTZ_CARVED_COLUMNS_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.ACACIA_CARVED_COLUMNS_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.CHERRY_CARVED_COLUMNS_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.DARK_OAK_CARVED_COLUMNS_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.MANGROVE_CARVED_COLUMNS_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.BAMBOO_CARVED_COLUMNS_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.BAMBOO_MOSAIC_CARVED_COLUMNS_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.PRISMARINE_CARVED_COLUMNS_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.PRISMARINE_BRICK_CARVED_COLUMNS_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.DARK_PRISMARINE_CARVED_COLUMNS_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.RED_SANDSTONE_CARVED_COLUMNS_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.PURPUR_CARVED_COLUMNS_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.POLISHED_GRANITE_CARVED_COLUMNS_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.SMOOTH_RED_SANDSTONE_CARVED_COLUMNS_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.MOSSY_STONE_BRICK_CARVED_COLUMNS_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.POLISHED_DIORITE_CARVED_COLUMNS_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.MOSSY_COBBLESTONE_CARVED_COLUMNS_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.END_STONE_BRICK_CARVED_COLUMNS_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.STONE_CARVED_COLUMNS_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.SMOOTH_SANDSTONE_CARVED_COLUMNS_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.SMOOTH_QUARTZ_CARVED_COLUMNS_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.GRANITE_CARVED_COLUMNS_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.ANDESITE_CARVED_COLUMNS_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.RED_NETHER_BRICK_CARVED_COLUMNS_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.POLISHED_ANDESITE_CARVED_COLUMNS_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.DIORITE_CARVED_COLUMNS_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.CRIMSON_CARVED_COLUMNS_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.WARPED_CARVED_COLUMNS_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.BLACKSTONE_CARVED_COLUMNS_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.POLISHED_BLACKSTONE_BRICK_CARVED_COLUMNS_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.POLISHED_BLACKSTONE_CARVED_COLUMNS_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.OXIDIZED_CUT_COPPER_CARVED_COLUMNS_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.WEATHERED_CUT_COPPER_CARVED_COLUMNS_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.EXPOSED_CUT_COPPER_CARVED_COLUMNS_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.CUT_COPPER_CARVED_COLUMNS_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.WAXED_OXIDIZED_CUT_COPPER_CARVED_COLUMNS_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.WAXED_WEATHERED_CUT_COPPER_CARVED_COLUMNS_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.WAXED_EXPOSED_CUT_COPPER_CARVED_COLUMNS_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.WAXED_CUT_COPPER_CARVED_COLUMNS_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.COBBLED_DEEPSLATE_CARVED_COLUMNS_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.POLISHED_DEEPSLATE_CARVED_COLUMNS_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.DEEPSLATE_TILE_CARVED_COLUMNS_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.DEEPSLATE_BRICK_CARVED_COLUMNS_ITEM);
    }

    private static final List<RegistryObject<? extends Block>> LIGHTED_COLUMN_BLOCK_SETS =
            new ArrayList<>(List.of(LightedColumnBlockRegistration.OAK_LIGHTED_COLUMNS));
    static {
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.COBBLESTONE_LIGHTED_COLUMNS);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.BRICK_LIGHTED_COLUMNS);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.STONE_BRICK_LIGHTED_COLUMNS);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.MUD_BRICK_LIGHTED_COLUMNS);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.NETHER_BRICK_LIGHTED_COLUMNS);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.SANDSTONE_LIGHTED_COLUMNS);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.SPRUCE_LIGHTED_COLUMNS);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.BIRCH_LIGHTED_COLUMNS);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.JUNGLE_LIGHTED_COLUMNS);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.QUARTZ_LIGHTED_COLUMNS);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.ACACIA_LIGHTED_COLUMNS);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.CHERRY_LIGHTED_COLUMNS);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.DARK_OAK_LIGHTED_COLUMNS);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.MANGROVE_LIGHTED_COLUMNS);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.BAMBOO_LIGHTED_COLUMNS);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.BAMBOO_MOSAIC_LIGHTED_COLUMNS);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.PRISMARINE_LIGHTED_COLUMNS);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.PRISMARINE_BRICK_LIGHTED_COLUMNS);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.DARK_PRISMARINE_LIGHTED_COLUMNS);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.RED_SANDSTONE_LIGHTED_COLUMNS);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.PURPUR_LIGHTED_COLUMNS);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.POLISHED_GRANITE_LIGHTED_COLUMNS);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.SMOOTH_RED_SANDSTONE_LIGHTED_COLUMNS);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.MOSSY_STONE_BRICK_LIGHTED_COLUMNS);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.POLISHED_DIORITE_LIGHTED_COLUMNS);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.MOSSY_COBBLESTONE_LIGHTED_COLUMNS);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.END_STONE_BRICK_LIGHTED_COLUMNS);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.STONE_LIGHTED_COLUMNS);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.SMOOTH_SANDSTONE_LIGHTED_COLUMNS);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.SMOOTH_QUARTZ_LIGHTED_COLUMNS);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.GRANITE_LIGHTED_COLUMNS);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.ANDESITE_LIGHTED_COLUMNS);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.RED_NETHER_BRICK_LIGHTED_COLUMNS);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.POLISHED_ANDESITE_LIGHTED_COLUMNS);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.DIORITE_LIGHTED_COLUMNS);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.CRIMSON_LIGHTED_COLUMNS);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.WARPED_LIGHTED_COLUMNS);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.BLACKSTONE_LIGHTED_COLUMNS);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.POLISHED_BLACKSTONE_BRICK_LIGHTED_COLUMNS);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.POLISHED_BLACKSTONE_LIGHTED_COLUMNS);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.OXIDIZED_CUT_COPPER_LIGHTED_COLUMNS);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.WEATHERED_CUT_COPPER_LIGHTED_COLUMNS);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.EXPOSED_CUT_COPPER_LIGHTED_COLUMNS);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.CUT_COPPER_LIGHTED_COLUMNS);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.WAXED_OXIDIZED_CUT_COPPER_LIGHTED_COLUMNS);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.WAXED_WEATHERED_CUT_COPPER_LIGHTED_COLUMNS);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.WAXED_EXPOSED_CUT_COPPER_LIGHTED_COLUMNS);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.WAXED_CUT_COPPER_LIGHTED_COLUMNS);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.COBBLED_DEEPSLATE_LIGHTED_COLUMNS);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.POLISHED_DEEPSLATE_LIGHTED_COLUMNS);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.DEEPSLATE_TILE_LIGHTED_COLUMNS);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.DEEPSLATE_BRICK_LIGHTED_COLUMNS);
    }

    private static final List<RegistryObject<? extends Item>> LIGHTED_COLUMN_ITEM_SETS =
            new ArrayList<>(List.of(LightedColumnBlockRegistration.OAK_LIGHTED_COLUMNS_ITEM));
    static {
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.COBBLESTONE_LIGHTED_COLUMNS_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.BRICK_LIGHTED_COLUMNS_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.STONE_BRICK_LIGHTED_COLUMNS_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.MUD_BRICK_LIGHTED_COLUMNS_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.NETHER_BRICK_LIGHTED_COLUMNS_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.SANDSTONE_LIGHTED_COLUMNS_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.SPRUCE_LIGHTED_COLUMNS_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.BIRCH_LIGHTED_COLUMNS_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.JUNGLE_LIGHTED_COLUMNS_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.QUARTZ_LIGHTED_COLUMNS_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.ACACIA_LIGHTED_COLUMNS_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.CHERRY_LIGHTED_COLUMNS_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.DARK_OAK_LIGHTED_COLUMNS_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.MANGROVE_LIGHTED_COLUMNS_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.BAMBOO_LIGHTED_COLUMNS_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.BAMBOO_MOSAIC_LIGHTED_COLUMNS_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.PRISMARINE_LIGHTED_COLUMNS_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.PRISMARINE_BRICK_LIGHTED_COLUMNS_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.DARK_PRISMARINE_LIGHTED_COLUMNS_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.RED_SANDSTONE_LIGHTED_COLUMNS_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.PURPUR_LIGHTED_COLUMNS_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.POLISHED_GRANITE_LIGHTED_COLUMNS_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.SMOOTH_RED_SANDSTONE_LIGHTED_COLUMNS_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.MOSSY_STONE_BRICK_LIGHTED_COLUMNS_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.POLISHED_DIORITE_LIGHTED_COLUMNS_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.MOSSY_COBBLESTONE_LIGHTED_COLUMNS_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.END_STONE_BRICK_LIGHTED_COLUMNS_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.STONE_LIGHTED_COLUMNS_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.SMOOTH_SANDSTONE_LIGHTED_COLUMNS_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.SMOOTH_QUARTZ_LIGHTED_COLUMNS_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.GRANITE_LIGHTED_COLUMNS_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.ANDESITE_LIGHTED_COLUMNS_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.RED_NETHER_BRICK_LIGHTED_COLUMNS_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.POLISHED_ANDESITE_LIGHTED_COLUMNS_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.DIORITE_LIGHTED_COLUMNS_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.CRIMSON_LIGHTED_COLUMNS_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.WARPED_LIGHTED_COLUMNS_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.BLACKSTONE_LIGHTED_COLUMNS_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.POLISHED_BLACKSTONE_BRICK_LIGHTED_COLUMNS_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.POLISHED_BLACKSTONE_LIGHTED_COLUMNS_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.OXIDIZED_CUT_COPPER_LIGHTED_COLUMNS_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.WEATHERED_CUT_COPPER_LIGHTED_COLUMNS_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.EXPOSED_CUT_COPPER_LIGHTED_COLUMNS_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.CUT_COPPER_LIGHTED_COLUMNS_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.WAXED_OXIDIZED_CUT_COPPER_LIGHTED_COLUMNS_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.WAXED_WEATHERED_CUT_COPPER_LIGHTED_COLUMNS_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.WAXED_EXPOSED_CUT_COPPER_LIGHTED_COLUMNS_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.WAXED_CUT_COPPER_LIGHTED_COLUMNS_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.COBBLED_DEEPSLATE_LIGHTED_COLUMNS_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.POLISHED_DEEPSLATE_LIGHTED_COLUMNS_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.DEEPSLATE_TILE_LIGHTED_COLUMNS_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.DEEPSLATE_BRICK_LIGHTED_COLUMNS_ITEM);
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

    public static List<RegistryObject<? extends Block>> getColumnBlockLists() {
        return COLUMN_BLOCK_SETS;
    }

    public static List<RegistryObject<? extends Item>> getColumnItemLists() {
        return COLUMN_ITEM_SETS;
    }

    public static List<RegistryObject<? extends Block>> getCarvedColumnBlockLists() {
        return CARVED_COLUMN_BLOCK_SETS;
    }

    public static List<RegistryObject<? extends Item>> getCarvedColumnItemLists() {
        return CARVED_COLUMN_ITEM_SETS;
    }

    public static List<RegistryObject<? extends Block>> getLightedColumnBlockLists() {return LIGHTED_COLUMN_BLOCK_SETS;}

    public static List<RegistryObject<? extends Item>> getLightedColumnItemLists() {
        return LIGHTED_COLUMN_ITEM_SETS;
    }

    private static final List<Block> PROPERTY_BLOCKS = new ArrayList<>();
    static {
        PROPERTY_BLOCKS.add(Blocks.OAK_PLANKS);
        PROPERTY_BLOCKS.add(Blocks.COBBLESTONE);
        PROPERTY_BLOCKS.add(Blocks.BRICKS);
        PROPERTY_BLOCKS.add(Blocks.STONE_BRICKS);
        PROPERTY_BLOCKS.add(Blocks.MUD_BRICKS);
        PROPERTY_BLOCKS.add(Blocks.NETHER_BRICKS);
        PROPERTY_BLOCKS.add(Blocks.SANDSTONE);
        PROPERTY_BLOCKS.add(Blocks.SPRUCE_PLANKS);
        PROPERTY_BLOCKS.add(Blocks.BIRCH_PLANKS);
        PROPERTY_BLOCKS.add(Blocks.JUNGLE_PLANKS);
        PROPERTY_BLOCKS.add(Blocks.QUARTZ_BLOCK);
        PROPERTY_BLOCKS.add(Blocks.ACACIA_PLANKS);
        PROPERTY_BLOCKS.add(Blocks.CHERRY_PLANKS);
        PROPERTY_BLOCKS.add(Blocks.DARK_OAK_PLANKS);
        PROPERTY_BLOCKS.add(Blocks.MANGROVE_PLANKS);
        PROPERTY_BLOCKS.add(Blocks.BAMBOO_PLANKS);
        PROPERTY_BLOCKS.add(Blocks.BAMBOO_MOSAIC);
        PROPERTY_BLOCKS.add(Blocks.PRISMARINE);
        PROPERTY_BLOCKS.add(Blocks.PRISMARINE_BRICKS);
        PROPERTY_BLOCKS.add(Blocks.DARK_PRISMARINE);
        PROPERTY_BLOCKS.add(Blocks.RED_SANDSTONE);
        PROPERTY_BLOCKS.add(Blocks.PURPUR_BLOCK);
        PROPERTY_BLOCKS.add(Blocks.POLISHED_GRANITE);
        PROPERTY_BLOCKS.add(Blocks.SMOOTH_RED_SANDSTONE);
        PROPERTY_BLOCKS.add(Blocks.MOSSY_STONE_BRICKS);
        PROPERTY_BLOCKS.add(Blocks.POLISHED_DIORITE);
        PROPERTY_BLOCKS.add(Blocks.MOSSY_COBBLESTONE);
        PROPERTY_BLOCKS.add(Blocks.END_STONE_BRICKS);
        PROPERTY_BLOCKS.add(Blocks.STONE);
        PROPERTY_BLOCKS.add(Blocks.SMOOTH_SANDSTONE);
        PROPERTY_BLOCKS.add(Blocks.SMOOTH_QUARTZ);
        PROPERTY_BLOCKS.add(Blocks.GRANITE);
        PROPERTY_BLOCKS.add(Blocks.ANDESITE);
        PROPERTY_BLOCKS.add(Blocks.RED_NETHER_BRICKS);
        PROPERTY_BLOCKS.add(Blocks.POLISHED_ANDESITE);
        PROPERTY_BLOCKS.add(Blocks.DIORITE);
        PROPERTY_BLOCKS.add(Blocks.CRIMSON_PLANKS);
        PROPERTY_BLOCKS.add(Blocks.WARPED_PLANKS);
        PROPERTY_BLOCKS.add(Blocks.BLACKSTONE);
        PROPERTY_BLOCKS.add(Blocks.POLISHED_BLACKSTONE_BRICKS);
        PROPERTY_BLOCKS.add(Blocks.POLISHED_BLACKSTONE);
        PROPERTY_BLOCKS.add(Blocks.OXIDIZED_CUT_COPPER);
        PROPERTY_BLOCKS.add(Blocks.WEATHERED_CUT_COPPER);
        PROPERTY_BLOCKS.add(Blocks.EXPOSED_CUT_COPPER);
        PROPERTY_BLOCKS.add(Blocks.CUT_COPPER);
        PROPERTY_BLOCKS.add(Blocks.WAXED_OXIDIZED_CUT_COPPER);
        PROPERTY_BLOCKS.add(Blocks.WAXED_WEATHERED_CUT_COPPER);
        PROPERTY_BLOCKS.add(Blocks.WAXED_EXPOSED_CUT_COPPER);
        PROPERTY_BLOCKS.add(Blocks.WAXED_CUT_COPPER);
        PROPERTY_BLOCKS.add(Blocks.COBBLED_DEEPSLATE);
        PROPERTY_BLOCKS.add(Blocks.POLISHED_DEEPSLATE);
        PROPERTY_BLOCKS.add(Blocks.DEEPSLATE_TILES);
        PROPERTY_BLOCKS.add(Blocks.DEEPSLATE_BRICKS);
    }
    public static List<Block> getPropertyBlocks() {
        return PROPERTY_BLOCKS;
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