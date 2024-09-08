package nowebsite.maker.furnitureplan.registry;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.registries.DeferredHolder;
import nowebsite.maker.furnitureplan.registry.kindsblock.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FoldingRegistration {
    private static final List<DeferredHolder<Block, ? extends Block>> CHAIR_BLOCK_SETS =
            new ArrayList<>(List.of(ChairBlockRegistration.OAK_CHAIR));
    static {
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.COBBLESTONE_CHAIR);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.BRICK_CHAIR);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.STONE_BRICK_CHAIR);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.MUD_BRICK_CHAIR);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.NETHER_BRICK_CHAIR);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.SANDSTONE_CHAIR);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.SPRUCE_CHAIR);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.BIRCH_CHAIR);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.JUNGLE_CHAIR);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.QUARTZ_CHAIR);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.ACACIA_CHAIR);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.CHERRY_CHAIR);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.DARK_OAK_CHAIR);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.MANGROVE_CHAIR);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.BAMBOO_CHAIR);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.BAMBOO_MOSAIC_CHAIR);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.PRISMARINE_CHAIR);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.PRISMARINE_BRICK_CHAIR);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.DARK_PRISMARINE_CHAIR);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.RED_SANDSTONE_CHAIR);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.PURPUR_CHAIR);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.POLISHED_GRANITE_CHAIR);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.SMOOTH_RED_SANDSTONE_CHAIR);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.MOSSY_STONE_BRICK_CHAIR);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.POLISHED_DIORITE_CHAIR);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.MOSSY_COBBLESTONE_CHAIR);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.END_STONE_BRICK_CHAIR);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.STONE_CHAIR);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.SMOOTH_SANDSTONE_CHAIR);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.SMOOTH_QUARTZ_CHAIR);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.GRANITE_CHAIR);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.ANDESITE_CHAIR);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.RED_NETHER_BRICK_CHAIR);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.POLISHED_ANDESITE_CHAIR);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.DIORITE_CHAIR);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.CRIMSON_CHAIR);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.WARPED_CHAIR);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.BLACKSTONE_CHAIR);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.POLISHED_BLACKSTONE_BRICK_CHAIR);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.POLISHED_BLACKSTONE_CHAIR);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.OXIDIZED_CUT_COPPER_CHAIR);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.WEATHERED_CUT_COPPER_CHAIR);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.EXPOSED_CUT_COPPER_CHAIR);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.CUT_COPPER_CHAIR);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.WAXED_OXIDIZED_CUT_COPPER_CHAIR);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.WAXED_WEATHERED_CUT_COPPER_CHAIR);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.WAXED_EXPOSED_CUT_COPPER_CHAIR);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.WAXED_CUT_COPPER_CHAIR);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.COBBLED_DEEPSLATE_CHAIR);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.POLISHED_DEEPSLATE_CHAIR);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.DEEPSLATE_TILE_CHAIR);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.DEEPSLATE_BRICK_CHAIR);

        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.TUFF_CHAIR);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.POLISHED_TUFF_CHAIR);
        CHAIR_BLOCK_SETS.add(ChairBlockRegistration.TUFF_BRICK_CHAIR);
    }

    private static final List<DeferredHolder<Item, ? extends Item>> CHAIR_ITEM_SETS =
            new ArrayList<>(List.of(ChairBlockRegistration.OAK_CHAIR_ITEM));
    static {
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.COBBLESTONE_CHAIR_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.BRICK_CHAIR_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.STONE_BRICK_CHAIR_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.MUD_BRICK_CHAIR_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.NETHER_BRICK_CHAIR_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.SANDSTONE_CHAIR_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.SPRUCE_CHAIR_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.BIRCH_CHAIR_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.JUNGLE_CHAIR_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.QUARTZ_CHAIR_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.ACACIA_CHAIR_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.CHERRY_CHAIR_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.DARK_OAK_CHAIR_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.MANGROVE_CHAIR_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.BAMBOO_CHAIR_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.BAMBOO_MOSAIC_CHAIR_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.PRISMARINE_CHAIR_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.PRISMARINE_BRICK_CHAIR_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.DARK_PRISMARINE_CHAIR_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.RED_SANDSTONE_CHAIR_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.PURPUR_CHAIR_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.POLISHED_GRANITE_CHAIR_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.SMOOTH_RED_SANDSTONE_CHAIR_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.MOSSY_STONE_BRICK_CHAIR_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.POLISHED_DIORITE_CHAIR_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.MOSSY_COBBLESTONE_CHAIR_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.END_STONE_BRICK_CHAIR_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.STONE_CHAIR_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.SMOOTH_SANDSTONE_CHAIR_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.SMOOTH_QUARTZ_CHAIR_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.GRANITE_CHAIR_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.ANDESITE_CHAIR_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.RED_NETHER_BRICK_CHAIR_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.POLISHED_ANDESITE_CHAIR_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.DIORITE_CHAIR_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.CRIMSON_CHAIR_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.WARPED_CHAIR_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.BLACKSTONE_CHAIR_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.POLISHED_BLACKSTONE_BRICK_CHAIR_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.POLISHED_BLACKSTONE_CHAIR_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.OXIDIZED_CUT_COPPER_CHAIR_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.WEATHERED_CUT_COPPER_CHAIR_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.EXPOSED_CUT_COPPER_CHAIR_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.CUT_COPPER_CHAIR_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.WAXED_OXIDIZED_CUT_COPPER_CHAIR_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.WAXED_WEATHERED_CUT_COPPER_CHAIR_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.WAXED_EXPOSED_CUT_COPPER_CHAIR_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.WAXED_CUT_COPPER_CHAIR_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.COBBLED_DEEPSLATE_CHAIR_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.POLISHED_DEEPSLATE_CHAIR_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.DEEPSLATE_TILE_CHAIR_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.DEEPSLATE_BRICK_CHAIR_ITEM);
        
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.TUFF_CHAIR_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.POLISHED_TUFF_CHAIR_ITEM);
        CHAIR_ITEM_SETS.add(ChairBlockRegistration.TUFF_BRICK_CHAIR_ITEM);
    }

    private static final List<DeferredHolder<Block, ? extends Block>> TABLE_BLOCK_SETS =
            new ArrayList<>(List.of(TableBlockRegistration.OAK_TABLE));
    static {
        TABLE_BLOCK_SETS.add(TableBlockRegistration.COBBLESTONE_TABLE);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.BRICK_TABLE);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.STONE_BRICK_TABLE);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.MUD_BRICK_TABLE);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.NETHER_BRICK_TABLE);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.SANDSTONE_TABLE);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.SPRUCE_TABLE);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.BIRCH_TABLE);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.JUNGLE_TABLE);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.QUARTZ_TABLE);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.ACACIA_TABLE);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.CHERRY_TABLE);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.DARK_OAK_TABLE);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.MANGROVE_TABLE);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.BAMBOO_TABLE);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.BAMBOO_MOSAIC_TABLE);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.PRISMARINE_TABLE);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.PRISMARINE_BRICK_TABLE);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.DARK_PRISMARINE_TABLE);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.RED_SANDSTONE_TABLE);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.PURPUR_TABLE);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.POLISHED_GRANITE_TABLE);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.SMOOTH_RED_SANDSTONE_TABLE);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.MOSSY_STONE_BRICK_TABLE);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.POLISHED_DIORITE_TABLE);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.MOSSY_COBBLESTONE_TABLE);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.END_STONE_BRICK_TABLE);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.STONE_TABLE);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.SMOOTH_SANDSTONE_TABLE);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.SMOOTH_QUARTZ_TABLE);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.GRANITE_TABLE);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.ANDESITE_TABLE);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.RED_NETHER_BRICK_TABLE);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.POLISHED_ANDESITE_TABLE);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.DIORITE_TABLE);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.CRIMSON_TABLE);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.WARPED_TABLE);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.BLACKSTONE_TABLE);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.POLISHED_BLACKSTONE_BRICK_TABLE);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.POLISHED_BLACKSTONE_TABLE);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.OXIDIZED_CUT_COPPER_TABLE);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.WEATHERED_CUT_COPPER_TABLE);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.EXPOSED_CUT_COPPER_TABLE);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.CUT_COPPER_TABLE);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.WAXED_OXIDIZED_CUT_COPPER_TABLE);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.WAXED_WEATHERED_CUT_COPPER_TABLE);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.WAXED_EXPOSED_CUT_COPPER_TABLE);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.WAXED_CUT_COPPER_TABLE);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.COBBLED_DEEPSLATE_TABLE);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.POLISHED_DEEPSLATE_TABLE);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.DEEPSLATE_TILE_TABLE);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.DEEPSLATE_BRICK_TABLE);

        TABLE_BLOCK_SETS.add(TableBlockRegistration.TUFF_TABLE);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.POLISHED_TUFF_TABLE);
        TABLE_BLOCK_SETS.add(TableBlockRegistration.TUFF_BRICK_TABLE);
    }

    private static final List<DeferredHolder<Item, ? extends Item>> TABLE_ITEM_SETS =
            new ArrayList<>(List.of(TableBlockRegistration.OAK_TABLE_ITEM));
    static {
        TABLE_ITEM_SETS.add(TableBlockRegistration.COBBLESTONE_TABLE_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.BRICK_TABLE_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.STONE_BRICK_TABLE_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.MUD_BRICK_TABLE_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.NETHER_BRICK_TABLE_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.SANDSTONE_TABLE_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.SPRUCE_TABLE_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.BIRCH_TABLE_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.JUNGLE_TABLE_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.QUARTZ_TABLE_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.ACACIA_TABLE_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.CHERRY_TABLE_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.DARK_OAK_TABLE_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.MANGROVE_TABLE_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.BAMBOO_TABLE_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.BAMBOO_MOSAIC_TABLE_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.PRISMARINE_TABLE_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.PRISMARINE_BRICK_TABLE_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.DARK_PRISMARINE_TABLE_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.RED_SANDSTONE_TABLE_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.PURPUR_TABLE_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.POLISHED_GRANITE_TABLE_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.SMOOTH_RED_SANDSTONE_TABLE_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.MOSSY_STONE_BRICK_TABLE_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.POLISHED_DIORITE_TABLE_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.MOSSY_COBBLESTONE_TABLE_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.END_STONE_BRICK_TABLE_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.STONE_TABLE_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.SMOOTH_SANDSTONE_TABLE_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.SMOOTH_QUARTZ_TABLE_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.GRANITE_TABLE_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.ANDESITE_TABLE_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.RED_NETHER_BRICK_TABLE_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.POLISHED_ANDESITE_TABLE_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.DIORITE_TABLE_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.CRIMSON_TABLE_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.WARPED_TABLE_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.BLACKSTONE_TABLE_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.POLISHED_BLACKSTONE_BRICK_TABLE_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.POLISHED_BLACKSTONE_TABLE_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.OXIDIZED_CUT_COPPER_TABLE_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.WEATHERED_CUT_COPPER_TABLE_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.EXPOSED_CUT_COPPER_TABLE_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.CUT_COPPER_TABLE_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.WAXED_OXIDIZED_CUT_COPPER_TABLE_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.WAXED_WEATHERED_CUT_COPPER_TABLE_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.WAXED_EXPOSED_CUT_COPPER_TABLE_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.WAXED_CUT_COPPER_TABLE_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.COBBLED_DEEPSLATE_TABLE_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.POLISHED_DEEPSLATE_TABLE_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.DEEPSLATE_TILE_TABLE_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.DEEPSLATE_BRICK_TABLE_ITEM);

        TABLE_ITEM_SETS.add(TableBlockRegistration.TUFF_TABLE_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.POLISHED_TUFF_TABLE_ITEM);
        TABLE_ITEM_SETS.add(TableBlockRegistration.TUFF_BRICK_TABLE_ITEM);
    }

    private static final List<DeferredHolder<Block, ? extends Block>> COLUMN_BLOCK_SETS =
            new ArrayList<>(List.of(ColumnBlockRegistration.OAK_COLUMN));
    static {
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.COBBLESTONE_COLUMN);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.BRICK_COLUMN);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.STONE_BRICK_COLUMN);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.MUD_BRICK_COLUMN);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.NETHER_BRICK_COLUMN);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.SANDSTONE_COLUMN);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.SPRUCE_COLUMN);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.BIRCH_COLUMN);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.JUNGLE_COLUMN);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.QUARTZ_COLUMN);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.ACACIA_COLUMN);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.CHERRY_COLUMN);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.DARK_OAK_COLUMN);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.MANGROVE_COLUMN);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.BAMBOO_COLUMN);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.BAMBOO_MOSAIC_COLUMN);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.PRISMARINE_COLUMN);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.PRISMARINE_BRICK_COLUMN);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.DARK_PRISMARINE_COLUMN);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.RED_SANDSTONE_COLUMN);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.PURPUR_COLUMN);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.POLISHED_GRANITE_COLUMN);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.SMOOTH_RED_SANDSTONE_COLUMN);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.MOSSY_STONE_BRICK_COLUMN);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.POLISHED_DIORITE_COLUMN);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.MOSSY_COBBLESTONE_COLUMN);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.END_STONE_BRICK_COLUMN);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.STONE_COLUMN);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.SMOOTH_SANDSTONE_COLUMN);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.SMOOTH_QUARTZ_COLUMN);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.GRANITE_COLUMN);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.ANDESITE_COLUMN);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.RED_NETHER_BRICK_COLUMN);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.POLISHED_ANDESITE_COLUMN);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.DIORITE_COLUMN);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.CRIMSON_COLUMN);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.WARPED_COLUMN);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.BLACKSTONE_COLUMN);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.POLISHED_BLACKSTONE_BRICK_COLUMN);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.POLISHED_BLACKSTONE_COLUMN);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.OXIDIZED_CUT_COPPER_COLUMN);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.WEATHERED_CUT_COPPER_COLUMN);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.EXPOSED_CUT_COPPER_COLUMN);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.CUT_COPPER_COLUMN);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.WAXED_OXIDIZED_CUT_COPPER_COLUMN);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.WAXED_WEATHERED_CUT_COPPER_COLUMN);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.WAXED_EXPOSED_CUT_COPPER_COLUMN);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.WAXED_CUT_COPPER_COLUMN);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.COBBLED_DEEPSLATE_COLUMN);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.POLISHED_DEEPSLATE_COLUMN);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.DEEPSLATE_TILE_COLUMN);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.DEEPSLATE_BRICK_COLUMN);

        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.TUFF_COLUMN);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.POLISHED_TUFF_COLUMN);
        COLUMN_BLOCK_SETS.add(ColumnBlockRegistration.TUFF_BRICK_COLUMN);
    }

    private static final List<DeferredHolder<Item, ? extends Item>> COLUMN_ITEM_SETS =
            new ArrayList<>(List.of(ColumnBlockRegistration.OAK_COLUMN_ITEM));
    static {
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.COBBLESTONE_COLUMN_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.BRICK_COLUMN_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.STONE_BRICK_COLUMN_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.MUD_BRICK_COLUMN_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.NETHER_BRICK_COLUMN_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.SANDSTONE_COLUMN_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.SPRUCE_COLUMN_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.BIRCH_COLUMN_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.JUNGLE_COLUMN_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.QUARTZ_COLUMN_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.ACACIA_COLUMN_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.CHERRY_COLUMN_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.DARK_OAK_COLUMN_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.MANGROVE_COLUMN_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.BAMBOO_COLUMN_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.BAMBOO_MOSAIC_COLUMN_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.PRISMARINE_COLUMN_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.PRISMARINE_BRICK_COLUMN_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.DARK_PRISMARINE_COLUMN_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.RED_SANDSTONE_COLUMN_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.PURPUR_COLUMN_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.POLISHED_GRANITE_COLUMN_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.SMOOTH_RED_SANDSTONE_COLUMN_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.MOSSY_STONE_BRICK_COLUMN_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.POLISHED_DIORITE_COLUMN_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.MOSSY_COBBLESTONE_COLUMN_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.END_STONE_BRICK_COLUMN_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.STONE_COLUMN_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.SMOOTH_SANDSTONE_COLUMN_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.SMOOTH_QUARTZ_COLUMN_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.GRANITE_COLUMN_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.ANDESITE_COLUMN_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.RED_NETHER_BRICK_COLUMN_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.POLISHED_ANDESITE_COLUMN_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.DIORITE_COLUMN_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.CRIMSON_COLUMN_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.WARPED_COLUMN_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.BLACKSTONE_COLUMN_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.POLISHED_BLACKSTONE_BRICK_COLUMN_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.POLISHED_BLACKSTONE_COLUMN_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.OXIDIZED_CUT_COPPER_COLUMN_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.WEATHERED_CUT_COPPER_COLUMN_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.EXPOSED_CUT_COPPER_COLUMN_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.CUT_COPPER_COLUMN_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.WAXED_OXIDIZED_CUT_COPPER_COLUMN_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.WAXED_WEATHERED_CUT_COPPER_COLUMN_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.WAXED_EXPOSED_CUT_COPPER_COLUMN_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.WAXED_CUT_COPPER_COLUMN_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.COBBLED_DEEPSLATE_COLUMN_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.POLISHED_DEEPSLATE_COLUMN_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.DEEPSLATE_TILE_COLUMN_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.DEEPSLATE_BRICK_COLUMN_ITEM);

        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.TUFF_COLUMN_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.POLISHED_TUFF_COLUMN_ITEM);
        COLUMN_ITEM_SETS.add(ColumnBlockRegistration.TUFF_BRICK_COLUMN_ITEM);
    }

    private static final List<DeferredHolder<Block, ? extends Block>> CARVED_COLUMN_BLOCK_SETS =
            new ArrayList<>(List.of(CarvedColumnBlockRegistration.OAK_CARVED_COLUMN));
    static {
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.COBBLESTONE_CARVED_COLUMN);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.BRICK_CARVED_COLUMN);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.STONE_BRICK_CARVED_COLUMN);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.MUD_BRICK_CARVED_COLUMN);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.NETHER_BRICK_CARVED_COLUMN);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.SANDSTONE_CARVED_COLUMN);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.SPRUCE_CARVED_COLUMN);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.BIRCH_CARVED_COLUMN);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.JUNGLE_CARVED_COLUMN);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.QUARTZ_CARVED_COLUMN);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.ACACIA_CARVED_COLUMN);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.CHERRY_CARVED_COLUMN);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.DARK_OAK_CARVED_COLUMN);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.MANGROVE_CARVED_COLUMN);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.BAMBOO_CARVED_COLUMN);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.BAMBOO_MOSAIC_CARVED_COLUMN);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.PRISMARINE_CARVED_COLUMN);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.PRISMARINE_BRICK_CARVED_COLUMN);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.DARK_PRISMARINE_CARVED_COLUMN);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.RED_SANDSTONE_CARVED_COLUMN);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.PURPUR_CARVED_COLUMN);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.POLISHED_GRANITE_CARVED_COLUMN);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.SMOOTH_RED_SANDSTONE_CARVED_COLUMN);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.MOSSY_STONE_BRICK_CARVED_COLUMN);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.POLISHED_DIORITE_CARVED_COLUMN);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.MOSSY_COBBLESTONE_CARVED_COLUMN);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.END_STONE_BRICK_CARVED_COLUMN);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.STONE_CARVED_COLUMN);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.SMOOTH_SANDSTONE_CARVED_COLUMN);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.SMOOTH_QUARTZ_CARVED_COLUMN);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.GRANITE_CARVED_COLUMN);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.ANDESITE_CARVED_COLUMN);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.RED_NETHER_BRICK_CARVED_COLUMN);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.POLISHED_ANDESITE_CARVED_COLUMN);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.DIORITE_CARVED_COLUMN);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.CRIMSON_CARVED_COLUMN);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.WARPED_CARVED_COLUMN);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.BLACKSTONE_CARVED_COLUMN);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.POLISHED_BLACKSTONE_BRICK_CARVED_COLUMN);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.POLISHED_BLACKSTONE_CARVED_COLUMN);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.OXIDIZED_CUT_COPPER_CARVED_COLUMN);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.WEATHERED_CUT_COPPER_CARVED_COLUMN);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.EXPOSED_CUT_COPPER_CARVED_COLUMN);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.CUT_COPPER_CARVED_COLUMN);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.WAXED_OXIDIZED_CUT_COPPER_CARVED_COLUMN);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.WAXED_WEATHERED_CUT_COPPER_CARVED_COLUMN);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.WAXED_EXPOSED_CUT_COPPER_CARVED_COLUMN);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.WAXED_CUT_COPPER_CARVED_COLUMN);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.COBBLED_DEEPSLATE_CARVED_COLUMN);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.POLISHED_DEEPSLATE_CARVED_COLUMN);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.DEEPSLATE_TILE_CARVED_COLUMN);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.DEEPSLATE_BRICK_CARVED_COLUMN);

        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.TUFF_CARVED_COLUMN);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.POLISHED_TUFF_CARVED_COLUMN);
        CARVED_COLUMN_BLOCK_SETS.add(CarvedColumnBlockRegistration.TUFF_BRICK_CARVED_COLUMN);
    }

    private static final List<DeferredHolder<Item, ? extends Item>> CARVED_COLUMN_ITEM_SETS =
        new ArrayList<>(List.of(CarvedColumnBlockRegistration.OAK_CARVED_COLUMN_ITEM));
    static {
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.COBBLESTONE_CARVED_COLUMN_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.BRICK_CARVED_COLUMN_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.STONE_BRICK_CARVED_COLUMN_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.MUD_BRICK_CARVED_COLUMN_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.NETHER_BRICK_CARVED_COLUMN_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.SANDSTONE_CARVED_COLUMN_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.SPRUCE_CARVED_COLUMN_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.BIRCH_CARVED_COLUMN_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.JUNGLE_CARVED_COLUMN_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.QUARTZ_CARVED_COLUMN_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.ACACIA_CARVED_COLUMN_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.CHERRY_CARVED_COLUMN_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.DARK_OAK_CARVED_COLUMN_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.MANGROVE_CARVED_COLUMN_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.BAMBOO_CARVED_COLUMN_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.BAMBOO_MOSAIC_CARVED_COLUMN_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.PRISMARINE_CARVED_COLUMN_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.PRISMARINE_BRICK_CARVED_COLUMN_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.DARK_PRISMARINE_CARVED_COLUMN_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.RED_SANDSTONE_CARVED_COLUMN_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.PURPUR_CARVED_COLUMN_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.POLISHED_GRANITE_CARVED_COLUMN_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.SMOOTH_RED_SANDSTONE_CARVED_COLUMN_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.MOSSY_STONE_BRICK_CARVED_COLUMN_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.POLISHED_DIORITE_CARVED_COLUMN_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.MOSSY_COBBLESTONE_CARVED_COLUMN_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.END_STONE_BRICK_CARVED_COLUMN_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.STONE_CARVED_COLUMN_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.SMOOTH_SANDSTONE_CARVED_COLUMN_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.SMOOTH_QUARTZ_CARVED_COLUMN_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.GRANITE_CARVED_COLUMN_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.ANDESITE_CARVED_COLUMN_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.RED_NETHER_BRICK_CARVED_COLUMN_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.POLISHED_ANDESITE_CARVED_COLUMN_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.DIORITE_CARVED_COLUMN_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.CRIMSON_CARVED_COLUMN_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.WARPED_CARVED_COLUMN_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.BLACKSTONE_CARVED_COLUMN_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.POLISHED_BLACKSTONE_BRICK_CARVED_COLUMN_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.POLISHED_BLACKSTONE_CARVED_COLUMN_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.OXIDIZED_CUT_COPPER_CARVED_COLUMN_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.WEATHERED_CUT_COPPER_CARVED_COLUMN_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.EXPOSED_CUT_COPPER_CARVED_COLUMN_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.CUT_COPPER_CARVED_COLUMN_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.WAXED_OXIDIZED_CUT_COPPER_CARVED_COLUMN_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.WAXED_WEATHERED_CUT_COPPER_CARVED_COLUMN_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.WAXED_EXPOSED_CUT_COPPER_CARVED_COLUMN_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.WAXED_CUT_COPPER_CARVED_COLUMN_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.COBBLED_DEEPSLATE_CARVED_COLUMN_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.POLISHED_DEEPSLATE_CARVED_COLUMN_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.DEEPSLATE_TILE_CARVED_COLUMN_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.DEEPSLATE_BRICK_CARVED_COLUMN_ITEM);

        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.TUFF_CARVED_COLUMN_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.POLISHED_TUFF_CARVED_COLUMN_ITEM);
        CARVED_COLUMN_ITEM_SETS.add(CarvedColumnBlockRegistration.TUFF_BRICK_CARVED_COLUMN_ITEM);
    }
    private static final List<DeferredHolder<Block, ? extends Block>> LIGHTED_COLUMN_BLOCK_SETS =
            new ArrayList<>(List.of(LightedColumnBlockRegistration.OAK_LIGHTED_COLUMN));
    static {
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.COBBLESTONE_LIGHTED_COLUMN);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.BRICK_LIGHTED_COLUMN);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.STONE_BRICK_LIGHTED_COLUMN);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.MUD_BRICK_LIGHTED_COLUMN);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.NETHER_BRICK_LIGHTED_COLUMN);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.SANDSTONE_LIGHTED_COLUMN);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.SPRUCE_LIGHTED_COLUMN);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.BIRCH_LIGHTED_COLUMN);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.JUNGLE_LIGHTED_COLUMN);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.QUARTZ_LIGHTED_COLUMN);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.ACACIA_LIGHTED_COLUMN);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.CHERRY_LIGHTED_COLUMN);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.DARK_OAK_LIGHTED_COLUMN);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.MANGROVE_LIGHTED_COLUMN);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.BAMBOO_LIGHTED_COLUMN);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.BAMBOO_MOSAIC_LIGHTED_COLUMN);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.PRISMARINE_LIGHTED_COLUMN);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.PRISMARINE_BRICK_LIGHTED_COLUMN);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.DARK_PRISMARINE_LIGHTED_COLUMN);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.RED_SANDSTONE_LIGHTED_COLUMN);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.PURPUR_LIGHTED_COLUMN);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.POLISHED_GRANITE_LIGHTED_COLUMN);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.SMOOTH_RED_SANDSTONE_LIGHTED_COLUMN);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.MOSSY_STONE_BRICK_LIGHTED_COLUMN);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.POLISHED_DIORITE_LIGHTED_COLUMN);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.MOSSY_COBBLESTONE_LIGHTED_COLUMN);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.END_STONE_BRICK_LIGHTED_COLUMN);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.STONE_LIGHTED_COLUMN);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.SMOOTH_SANDSTONE_LIGHTED_COLUMN);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.SMOOTH_QUARTZ_LIGHTED_COLUMN);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.GRANITE_LIGHTED_COLUMN);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.ANDESITE_LIGHTED_COLUMN);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.RED_NETHER_BRICK_LIGHTED_COLUMN);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.POLISHED_ANDESITE_LIGHTED_COLUMN);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.DIORITE_LIGHTED_COLUMN);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.CRIMSON_LIGHTED_COLUMN);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.WARPED_LIGHTED_COLUMN);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.BLACKSTONE_LIGHTED_COLUMN);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.POLISHED_BLACKSTONE_BRICK_LIGHTED_COLUMN);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.POLISHED_BLACKSTONE_LIGHTED_COLUMN);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.OXIDIZED_CUT_COPPER_LIGHTED_COLUMN);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.WEATHERED_CUT_COPPER_LIGHTED_COLUMN);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.EXPOSED_CUT_COPPER_LIGHTED_COLUMN);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.CUT_COPPER_LIGHTED_COLUMN);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.WAXED_OXIDIZED_CUT_COPPER_LIGHTED_COLUMN);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.WAXED_WEATHERED_CUT_COPPER_LIGHTED_COLUMN);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.WAXED_EXPOSED_CUT_COPPER_LIGHTED_COLUMN);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.WAXED_CUT_COPPER_LIGHTED_COLUMN);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.COBBLED_DEEPSLATE_LIGHTED_COLUMN);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.POLISHED_DEEPSLATE_LIGHTED_COLUMN);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.DEEPSLATE_TILE_LIGHTED_COLUMN);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.DEEPSLATE_BRICK_LIGHTED_COLUMN);

        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.TUFF_LIGHTED_COLUMN);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.POLISHED_TUFF_LIGHTED_COLUMN);
        LIGHTED_COLUMN_BLOCK_SETS.add(LightedColumnBlockRegistration.TUFF_BRICK_LIGHTED_COLUMN);
    }

    private static final List<DeferredHolder<Item, ? extends Item>> LIGHTED_COLUMN_ITEM_SETS =
            new ArrayList<>(List.of(LightedColumnBlockRegistration.OAK_LIGHTED_COLUMN_ITEM));
    static {
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.COBBLESTONE_LIGHTED_COLUMN_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.BRICK_LIGHTED_COLUMN_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.STONE_BRICK_LIGHTED_COLUMN_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.MUD_BRICK_LIGHTED_COLUMN_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.NETHER_BRICK_LIGHTED_COLUMN_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.SANDSTONE_LIGHTED_COLUMN_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.SPRUCE_LIGHTED_COLUMN_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.BIRCH_LIGHTED_COLUMN_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.JUNGLE_LIGHTED_COLUMN_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.QUARTZ_LIGHTED_COLUMN_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.ACACIA_LIGHTED_COLUMN_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.CHERRY_LIGHTED_COLUMN_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.DARK_OAK_LIGHTED_COLUMN_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.MANGROVE_LIGHTED_COLUMN_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.BAMBOO_LIGHTED_COLUMN_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.BAMBOO_MOSAIC_LIGHTED_COLUMN_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.PRISMARINE_LIGHTED_COLUMN_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.PRISMARINE_BRICK_LIGHTED_COLUMN_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.DARK_PRISMARINE_LIGHTED_COLUMN_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.RED_SANDSTONE_LIGHTED_COLUMN_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.PURPUR_LIGHTED_COLUMN_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.POLISHED_GRANITE_LIGHTED_COLUMN_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.SMOOTH_RED_SANDSTONE_LIGHTED_COLUMN_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.MOSSY_STONE_BRICK_LIGHTED_COLUMN_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.POLISHED_DIORITE_LIGHTED_COLUMN_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.MOSSY_COBBLESTONE_LIGHTED_COLUMN_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.END_STONE_BRICK_LIGHTED_COLUMN_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.STONE_LIGHTED_COLUMN_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.SMOOTH_SANDSTONE_LIGHTED_COLUMN_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.SMOOTH_QUARTZ_LIGHTED_COLUMN_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.GRANITE_LIGHTED_COLUMN_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.ANDESITE_LIGHTED_COLUMN_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.RED_NETHER_BRICK_LIGHTED_COLUMN_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.POLISHED_ANDESITE_LIGHTED_COLUMN_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.DIORITE_LIGHTED_COLUMN_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.CRIMSON_LIGHTED_COLUMN_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.WARPED_LIGHTED_COLUMN_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.BLACKSTONE_LIGHTED_COLUMN_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.POLISHED_BLACKSTONE_BRICK_LIGHTED_COLUMN_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.POLISHED_BLACKSTONE_LIGHTED_COLUMN_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.OXIDIZED_CUT_COPPER_LIGHTED_COLUMN_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.WEATHERED_CUT_COPPER_LIGHTED_COLUMN_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.EXPOSED_CUT_COPPER_LIGHTED_COLUMN_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.CUT_COPPER_LIGHTED_COLUMN_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.WAXED_OXIDIZED_CUT_COPPER_LIGHTED_COLUMN_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.WAXED_WEATHERED_CUT_COPPER_LIGHTED_COLUMN_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.WAXED_EXPOSED_CUT_COPPER_LIGHTED_COLUMN_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.WAXED_CUT_COPPER_LIGHTED_COLUMN_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.COBBLED_DEEPSLATE_LIGHTED_COLUMN_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.POLISHED_DEEPSLATE_LIGHTED_COLUMN_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.DEEPSLATE_TILE_LIGHTED_COLUMN_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.DEEPSLATE_BRICK_LIGHTED_COLUMN_ITEM);

        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.TUFF_LIGHTED_COLUMN_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.POLISHED_TUFF_LIGHTED_COLUMN_ITEM);
        LIGHTED_COLUMN_ITEM_SETS.add(LightedColumnBlockRegistration.TUFF_BRICK_LIGHTED_COLUMN_ITEM);
    }

    private static final List<DeferredHolder<Block, ? extends Block>> POT_HOLDER_BLOCK_LIST = new ArrayList<>();
    static {
        POT_HOLDER_BLOCK_LIST.add(PotHolderBlockRegistration.BLACK_POT_HOLDER_BLOCK);
        POT_HOLDER_BLOCK_LIST.add(PotHolderBlockRegistration.BLUE_POT_HOLDER_BLOCK);
        POT_HOLDER_BLOCK_LIST.add(PotHolderBlockRegistration.BROWN_POT_HOLDER_BLOCK);
        POT_HOLDER_BLOCK_LIST.add(PotHolderBlockRegistration.CYAN_POT_HOLDER_BLOCK);
        POT_HOLDER_BLOCK_LIST.add(PotHolderBlockRegistration.GRAY_POT_HOLDER_BLOCK);
        POT_HOLDER_BLOCK_LIST.add(PotHolderBlockRegistration.GREEN_POT_HOLDER_BLOCK);
        POT_HOLDER_BLOCK_LIST.add(PotHolderBlockRegistration.LIGHT_BLUE_POT_HOLDER_BLOCK);
        POT_HOLDER_BLOCK_LIST.add(PotHolderBlockRegistration.LIGHT_GRAY_POT_HOLDER_BLOCK);
        POT_HOLDER_BLOCK_LIST.add(PotHolderBlockRegistration.LIME_POT_HOLDER_BLOCK);
        POT_HOLDER_BLOCK_LIST.add(PotHolderBlockRegistration.MAGENTA_POT_HOLDER_BLOCK);
        POT_HOLDER_BLOCK_LIST.add(PotHolderBlockRegistration.ORANGE_POT_HOLDER_BLOCK);
        POT_HOLDER_BLOCK_LIST.add(PotHolderBlockRegistration.PINK_POT_HOLDER_BLOCK);
        POT_HOLDER_BLOCK_LIST.add(PotHolderBlockRegistration.PURPLE_POT_HOLDER_BLOCK);
        POT_HOLDER_BLOCK_LIST.add(PotHolderBlockRegistration.RED_POT_HOLDER_BLOCK);
        POT_HOLDER_BLOCK_LIST.add(PotHolderBlockRegistration.YELLOW_POT_HOLDER_BLOCK);
        POT_HOLDER_BLOCK_LIST.add(PotHolderBlockRegistration.WHITE_POT_HOLDER_BLOCK);
    }
    private static final List<DeferredHolder<Item, ? extends Item>> POT_HOLDER_ITEM_LIST = new ArrayList<>();
    static {
        POT_HOLDER_ITEM_LIST.add(PotHolderBlockRegistration.BLACK_POT_HOLDER_BLOCK_ITEM);
        POT_HOLDER_ITEM_LIST.add(PotHolderBlockRegistration.BLUE_POT_HOLDER_BLOCK_ITEM);
        POT_HOLDER_ITEM_LIST.add(PotHolderBlockRegistration.BROWN_POT_HOLDER_BLOCK_ITEM);
        POT_HOLDER_ITEM_LIST.add(PotHolderBlockRegistration.CYAN_POT_HOLDER_BLOCK_ITEM);
        POT_HOLDER_ITEM_LIST.add(PotHolderBlockRegistration.GRAY_POT_HOLDER_BLOCK_ITEM);
        POT_HOLDER_ITEM_LIST.add(PotHolderBlockRegistration.GREEN_POT_HOLDER_BLOCK_ITEM);
        POT_HOLDER_ITEM_LIST.add(PotHolderBlockRegistration.LIGHT_BLUE_POT_HOLDER_BLOCK_ITEM);
        POT_HOLDER_ITEM_LIST.add(PotHolderBlockRegistration.LIGHT_GRAY_POT_HOLDER_BLOCK_ITEM);
        POT_HOLDER_ITEM_LIST.add(PotHolderBlockRegistration.LIME_POT_HOLDER_BLOCK_ITEM);
        POT_HOLDER_ITEM_LIST.add(PotHolderBlockRegistration.MAGENTA_POT_HOLDER_BLOCK_ITEM);
        POT_HOLDER_ITEM_LIST.add(PotHolderBlockRegistration.ORANGE_POT_HOLDER_BLOCK_ITEM);
        POT_HOLDER_ITEM_LIST.add(PotHolderBlockRegistration.PINK_POT_HOLDER_BLOCK_ITEM);
        POT_HOLDER_ITEM_LIST.add(PotHolderBlockRegistration.PURPLE_POT_HOLDER_BLOCK_ITEM);
        POT_HOLDER_ITEM_LIST.add(PotHolderBlockRegistration.RED_POT_HOLDER_BLOCK_ITEM);
        POT_HOLDER_ITEM_LIST.add(PotHolderBlockRegistration.YELLOW_POT_HOLDER_BLOCK_ITEM);
        POT_HOLDER_ITEM_LIST.add(PotHolderBlockRegistration.WHITE_POT_HOLDER_BLOCK_ITEM);

    }

    private static final List<DeferredHolder<Block, ? extends Block>> BENCH_BLOCK_SETS =
        new ArrayList<>(List.of(BenchBlockRegistration.OAK_BENCH));
    static {
        BENCH_BLOCK_SETS.add(BenchBlockRegistration.COBBLESTONE_BENCH);
        BENCH_BLOCK_SETS.add(BenchBlockRegistration.BRICK_BENCH);
        BENCH_BLOCK_SETS.add(BenchBlockRegistration.STONE_BRICK_BENCH);
        BENCH_BLOCK_SETS.add(BenchBlockRegistration.MUD_BRICK_BENCH);
        BENCH_BLOCK_SETS.add(BenchBlockRegistration.NETHER_BRICK_BENCH);
        BENCH_BLOCK_SETS.add(BenchBlockRegistration.SANDSTONE_BENCH);
        BENCH_BLOCK_SETS.add(BenchBlockRegistration.SPRUCE_BENCH);
        BENCH_BLOCK_SETS.add(BenchBlockRegistration.BIRCH_BENCH);
        BENCH_BLOCK_SETS.add(BenchBlockRegistration.JUNGLE_BENCH);
        BENCH_BLOCK_SETS.add(BenchBlockRegistration.QUARTZ_BENCH);
        BENCH_BLOCK_SETS.add(BenchBlockRegistration.ACACIA_BENCH);
        BENCH_BLOCK_SETS.add(BenchBlockRegistration.CHERRY_BENCH);
        BENCH_BLOCK_SETS.add(BenchBlockRegistration.DARK_OAK_BENCH);
        BENCH_BLOCK_SETS.add(BenchBlockRegistration.MANGROVE_BENCH);
        BENCH_BLOCK_SETS.add(BenchBlockRegistration.BAMBOO_BENCH);
        BENCH_BLOCK_SETS.add(BenchBlockRegistration.BAMBOO_MOSAIC_BENCH);
        BENCH_BLOCK_SETS.add(BenchBlockRegistration.PRISMARINE_BENCH);
        BENCH_BLOCK_SETS.add(BenchBlockRegistration.PRISMARINE_BRICK_BENCH);
        BENCH_BLOCK_SETS.add(BenchBlockRegistration.DARK_PRISMARINE_BENCH);
        BENCH_BLOCK_SETS.add(BenchBlockRegistration.RED_SANDSTONE_BENCH);
        BENCH_BLOCK_SETS.add(BenchBlockRegistration.PURPUR_BENCH);
        BENCH_BLOCK_SETS.add(BenchBlockRegistration.POLISHED_GRANITE_BENCH);
        BENCH_BLOCK_SETS.add(BenchBlockRegistration.SMOOTH_RED_SANDSTONE_BENCH);
        BENCH_BLOCK_SETS.add(BenchBlockRegistration.MOSSY_STONE_BRICK_BENCH);
        BENCH_BLOCK_SETS.add(BenchBlockRegistration.POLISHED_DIORITE_BENCH);
        BENCH_BLOCK_SETS.add(BenchBlockRegistration.MOSSY_COBBLESTONE_BENCH);
        BENCH_BLOCK_SETS.add(BenchBlockRegistration.END_STONE_BRICK_BENCH);
        BENCH_BLOCK_SETS.add(BenchBlockRegistration.STONE_BENCH);
        BENCH_BLOCK_SETS.add(BenchBlockRegistration.SMOOTH_SANDSTONE_BENCH);
        BENCH_BLOCK_SETS.add(BenchBlockRegistration.SMOOTH_QUARTZ_BENCH);
        BENCH_BLOCK_SETS.add(BenchBlockRegistration.GRANITE_BENCH);
        BENCH_BLOCK_SETS.add(BenchBlockRegistration.ANDESITE_BENCH);
        BENCH_BLOCK_SETS.add(BenchBlockRegistration.RED_NETHER_BRICK_BENCH);
        BENCH_BLOCK_SETS.add(BenchBlockRegistration.POLISHED_ANDESITE_BENCH);
        BENCH_BLOCK_SETS.add(BenchBlockRegistration.DIORITE_BENCH);
        BENCH_BLOCK_SETS.add(BenchBlockRegistration.CRIMSON_BENCH);
        BENCH_BLOCK_SETS.add(BenchBlockRegistration.WARPED_BENCH);
        BENCH_BLOCK_SETS.add(BenchBlockRegistration.BLACKSTONE_BENCH);
        BENCH_BLOCK_SETS.add(BenchBlockRegistration.POLISHED_BLACKSTONE_BRICK_BENCH);
        BENCH_BLOCK_SETS.add(BenchBlockRegistration.POLISHED_BLACKSTONE_BENCH);
        BENCH_BLOCK_SETS.add(BenchBlockRegistration.OXIDIZED_CUT_COPPER_BENCH);
        BENCH_BLOCK_SETS.add(BenchBlockRegistration.WEATHERED_CUT_COPPER_BENCH);
        BENCH_BLOCK_SETS.add(BenchBlockRegistration.EXPOSED_CUT_COPPER_BENCH);
        BENCH_BLOCK_SETS.add(BenchBlockRegistration.CUT_COPPER_BENCH);
        BENCH_BLOCK_SETS.add(BenchBlockRegistration.WAXED_OXIDIZED_CUT_COPPER_BENCH);
        BENCH_BLOCK_SETS.add(BenchBlockRegistration.WAXED_WEATHERED_CUT_COPPER_BENCH);
        BENCH_BLOCK_SETS.add(BenchBlockRegistration.WAXED_EXPOSED_CUT_COPPER_BENCH);
        BENCH_BLOCK_SETS.add(BenchBlockRegistration.WAXED_CUT_COPPER_BENCH);
        BENCH_BLOCK_SETS.add(BenchBlockRegistration.COBBLED_DEEPSLATE_BENCH);
        BENCH_BLOCK_SETS.add(BenchBlockRegistration.POLISHED_DEEPSLATE_BENCH);
        BENCH_BLOCK_SETS.add(BenchBlockRegistration.DEEPSLATE_TILE_BENCH);
        BENCH_BLOCK_SETS.add(BenchBlockRegistration.DEEPSLATE_BRICK_BENCH);

        BENCH_BLOCK_SETS.add(BenchBlockRegistration.TUFF_BENCH);
        BENCH_BLOCK_SETS.add(BenchBlockRegistration.POLISHED_TUFF_BENCH);
        BENCH_BLOCK_SETS.add(BenchBlockRegistration.TUFF_BRICK_BENCH);
    }

    private static final List<DeferredHolder<Item, ? extends Item>> BENCH_ITEM_SETS =
        new ArrayList<>(List.of(BenchBlockRegistration.OAK_BENCH_ITEM));
    static {
        BENCH_ITEM_SETS.add(BenchBlockRegistration.COBBLESTONE_BENCH_ITEM);
        BENCH_ITEM_SETS.add(BenchBlockRegistration.BRICK_BENCH_ITEM);
        BENCH_ITEM_SETS.add(BenchBlockRegistration.STONE_BRICK_BENCH_ITEM);
        BENCH_ITEM_SETS.add(BenchBlockRegistration.MUD_BRICK_BENCH_ITEM);
        BENCH_ITEM_SETS.add(BenchBlockRegistration.NETHER_BRICK_BENCH_ITEM);
        BENCH_ITEM_SETS.add(BenchBlockRegistration.SANDSTONE_BENCH_ITEM);
        BENCH_ITEM_SETS.add(BenchBlockRegistration.SPRUCE_BENCH_ITEM);
        BENCH_ITEM_SETS.add(BenchBlockRegistration.BIRCH_BENCH_ITEM);
        BENCH_ITEM_SETS.add(BenchBlockRegistration.JUNGLE_BENCH_ITEM);
        BENCH_ITEM_SETS.add(BenchBlockRegistration.QUARTZ_BENCH_ITEM);
        BENCH_ITEM_SETS.add(BenchBlockRegistration.ACACIA_BENCH_ITEM);
        BENCH_ITEM_SETS.add(BenchBlockRegistration.CHERRY_BENCH_ITEM);
        BENCH_ITEM_SETS.add(BenchBlockRegistration.DARK_OAK_BENCH_ITEM);
        BENCH_ITEM_SETS.add(BenchBlockRegistration.MANGROVE_BENCH_ITEM);
        BENCH_ITEM_SETS.add(BenchBlockRegistration.BAMBOO_BENCH_ITEM);
        BENCH_ITEM_SETS.add(BenchBlockRegistration.BAMBOO_MOSAIC_BENCH_ITEM);
        BENCH_ITEM_SETS.add(BenchBlockRegistration.PRISMARINE_BENCH_ITEM);
        BENCH_ITEM_SETS.add(BenchBlockRegistration.PRISMARINE_BRICK_BENCH_ITEM);
        BENCH_ITEM_SETS.add(BenchBlockRegistration.DARK_PRISMARINE_BENCH_ITEM);
        BENCH_ITEM_SETS.add(BenchBlockRegistration.RED_SANDSTONE_BENCH_ITEM);
        BENCH_ITEM_SETS.add(BenchBlockRegistration.PURPUR_BENCH_ITEM);
        BENCH_ITEM_SETS.add(BenchBlockRegistration.POLISHED_GRANITE_BENCH_ITEM);
        BENCH_ITEM_SETS.add(BenchBlockRegistration.SMOOTH_RED_SANDSTONE_BENCH_ITEM);
        BENCH_ITEM_SETS.add(BenchBlockRegistration.MOSSY_STONE_BRICK_BENCH_ITEM);
        BENCH_ITEM_SETS.add(BenchBlockRegistration.POLISHED_DIORITE_BENCH_ITEM);
        BENCH_ITEM_SETS.add(BenchBlockRegistration.MOSSY_COBBLESTONE_BENCH_ITEM);
        BENCH_ITEM_SETS.add(BenchBlockRegistration.END_STONE_BRICK_BENCH_ITEM);
        BENCH_ITEM_SETS.add(BenchBlockRegistration.STONE_BENCH_ITEM);
        BENCH_ITEM_SETS.add(BenchBlockRegistration.SMOOTH_SANDSTONE_BENCH_ITEM);
        BENCH_ITEM_SETS.add(BenchBlockRegistration.SMOOTH_QUARTZ_BENCH_ITEM);
        BENCH_ITEM_SETS.add(BenchBlockRegistration.GRANITE_BENCH_ITEM);
        BENCH_ITEM_SETS.add(BenchBlockRegistration.ANDESITE_BENCH_ITEM);
        BENCH_ITEM_SETS.add(BenchBlockRegistration.RED_NETHER_BRICK_BENCH_ITEM);
        BENCH_ITEM_SETS.add(BenchBlockRegistration.POLISHED_ANDESITE_BENCH_ITEM);
        BENCH_ITEM_SETS.add(BenchBlockRegistration.DIORITE_BENCH_ITEM);
        BENCH_ITEM_SETS.add(BenchBlockRegistration.CRIMSON_BENCH_ITEM);
        BENCH_ITEM_SETS.add(BenchBlockRegistration.WARPED_BENCH_ITEM);
        BENCH_ITEM_SETS.add(BenchBlockRegistration.BLACKSTONE_BENCH_ITEM);
        BENCH_ITEM_SETS.add(BenchBlockRegistration.POLISHED_BLACKSTONE_BRICK_BENCH_ITEM);
        BENCH_ITEM_SETS.add(BenchBlockRegistration.POLISHED_BLACKSTONE_BENCH_ITEM);
        BENCH_ITEM_SETS.add(BenchBlockRegistration.OXIDIZED_CUT_COPPER_BENCH_ITEM);
        BENCH_ITEM_SETS.add(BenchBlockRegistration.WEATHERED_CUT_COPPER_BENCH_ITEM);
        BENCH_ITEM_SETS.add(BenchBlockRegistration.EXPOSED_CUT_COPPER_BENCH_ITEM);
        BENCH_ITEM_SETS.add(BenchBlockRegistration.CUT_COPPER_BENCH_ITEM);
        BENCH_ITEM_SETS.add(BenchBlockRegistration.WAXED_OXIDIZED_CUT_COPPER_BENCH_ITEM);
        BENCH_ITEM_SETS.add(BenchBlockRegistration.WAXED_WEATHERED_CUT_COPPER_BENCH_ITEM);
        BENCH_ITEM_SETS.add(BenchBlockRegistration.WAXED_EXPOSED_CUT_COPPER_BENCH_ITEM);
        BENCH_ITEM_SETS.add(BenchBlockRegistration.WAXED_CUT_COPPER_BENCH_ITEM);
        BENCH_ITEM_SETS.add(BenchBlockRegistration.COBBLED_DEEPSLATE_BENCH_ITEM);
        BENCH_ITEM_SETS.add(BenchBlockRegistration.POLISHED_DEEPSLATE_BENCH_ITEM);
        BENCH_ITEM_SETS.add(BenchBlockRegistration.DEEPSLATE_TILE_BENCH_ITEM);
        BENCH_ITEM_SETS.add(BenchBlockRegistration.DEEPSLATE_BRICK_BENCH_ITEM);

        BENCH_ITEM_SETS.add(BenchBlockRegistration.TUFF_BENCH_ITEM);
        BENCH_ITEM_SETS.add(BenchBlockRegistration.POLISHED_TUFF_BENCH_ITEM);
        BENCH_ITEM_SETS.add(BenchBlockRegistration.TUFF_BRICK_BENCH_ITEM);
    }
    private static final List<DeferredHolder<Block, ? extends Block>> CABINET_BLOCK_SETS =
        new ArrayList<>(List.of(CabinetBlockRegistration.OAK_CABINET));
    static {
        CABINET_BLOCK_SETS.add(CabinetBlockRegistration.COBBLESTONE_CABINET);
        CABINET_BLOCK_SETS.add(CabinetBlockRegistration.BRICK_CABINET);
        CABINET_BLOCK_SETS.add(CabinetBlockRegistration.STONE_BRICK_CABINET);
        CABINET_BLOCK_SETS.add(CabinetBlockRegistration.MUD_BRICK_CABINET);
        CABINET_BLOCK_SETS.add(CabinetBlockRegistration.NETHER_BRICK_CABINET);
        CABINET_BLOCK_SETS.add(CabinetBlockRegistration.SANDSTONE_CABINET);
        CABINET_BLOCK_SETS.add(CabinetBlockRegistration.SPRUCE_CABINET);
        CABINET_BLOCK_SETS.add(CabinetBlockRegistration.BIRCH_CABINET);
        CABINET_BLOCK_SETS.add(CabinetBlockRegistration.JUNGLE_CABINET);
        CABINET_BLOCK_SETS.add(CabinetBlockRegistration.QUARTZ_CABINET);
        CABINET_BLOCK_SETS.add(CabinetBlockRegistration.ACACIA_CABINET);
        CABINET_BLOCK_SETS.add(CabinetBlockRegistration.CHERRY_CABINET);
        CABINET_BLOCK_SETS.add(CabinetBlockRegistration.DARK_OAK_CABINET);
        CABINET_BLOCK_SETS.add(CabinetBlockRegistration.MANGROVE_CABINET);
        CABINET_BLOCK_SETS.add(CabinetBlockRegistration.BAMBOO_CABINET);
        CABINET_BLOCK_SETS.add(CabinetBlockRegistration.BAMBOO_MOSAIC_CABINET);
        CABINET_BLOCK_SETS.add(CabinetBlockRegistration.PRISMARINE_CABINET);
        CABINET_BLOCK_SETS.add(CabinetBlockRegistration.PRISMARINE_BRICK_CABINET);
        CABINET_BLOCK_SETS.add(CabinetBlockRegistration.DARK_PRISMARINE_CABINET);
        CABINET_BLOCK_SETS.add(CabinetBlockRegistration.RED_SANDSTONE_CABINET);
        CABINET_BLOCK_SETS.add(CabinetBlockRegistration.PURPUR_CABINET);
        CABINET_BLOCK_SETS.add(CabinetBlockRegistration.POLISHED_GRANITE_CABINET);
        CABINET_BLOCK_SETS.add(CabinetBlockRegistration.SMOOTH_RED_SANDSTONE_CABINET);
        CABINET_BLOCK_SETS.add(CabinetBlockRegistration.MOSSY_STONE_BRICK_CABINET);
        CABINET_BLOCK_SETS.add(CabinetBlockRegistration.POLISHED_DIORITE_CABINET);
        CABINET_BLOCK_SETS.add(CabinetBlockRegistration.MOSSY_COBBLESTONE_CABINET);
        CABINET_BLOCK_SETS.add(CabinetBlockRegistration.END_STONE_BRICK_CABINET);
        CABINET_BLOCK_SETS.add(CabinetBlockRegistration.STONE_CABINET);
        CABINET_BLOCK_SETS.add(CabinetBlockRegistration.SMOOTH_SANDSTONE_CABINET);
        CABINET_BLOCK_SETS.add(CabinetBlockRegistration.SMOOTH_QUARTZ_CABINET);
        CABINET_BLOCK_SETS.add(CabinetBlockRegistration.GRANITE_CABINET);
        CABINET_BLOCK_SETS.add(CabinetBlockRegistration.ANDESITE_CABINET);
        CABINET_BLOCK_SETS.add(CabinetBlockRegistration.RED_NETHER_BRICK_CABINET);
        CABINET_BLOCK_SETS.add(CabinetBlockRegistration.POLISHED_ANDESITE_CABINET);
        CABINET_BLOCK_SETS.add(CabinetBlockRegistration.DIORITE_CABINET);
        CABINET_BLOCK_SETS.add(CabinetBlockRegistration.CRIMSON_CABINET);
        CABINET_BLOCK_SETS.add(CabinetBlockRegistration.WARPED_CABINET);
        CABINET_BLOCK_SETS.add(CabinetBlockRegistration.BLACKSTONE_CABINET);
        CABINET_BLOCK_SETS.add(CabinetBlockRegistration.POLISHED_BLACKSTONE_BRICK_CABINET);
        CABINET_BLOCK_SETS.add(CabinetBlockRegistration.POLISHED_BLACKSTONE_CABINET);
        CABINET_BLOCK_SETS.add(CabinetBlockRegistration.OXIDIZED_CUT_COPPER_CABINET);
        CABINET_BLOCK_SETS.add(CabinetBlockRegistration.WEATHERED_CUT_COPPER_CABINET);
        CABINET_BLOCK_SETS.add(CabinetBlockRegistration.EXPOSED_CUT_COPPER_CABINET);
        CABINET_BLOCK_SETS.add(CabinetBlockRegistration.CUT_COPPER_CABINET);
        CABINET_BLOCK_SETS.add(CabinetBlockRegistration.WAXED_OXIDIZED_CUT_COPPER_CABINET);
        CABINET_BLOCK_SETS.add(CabinetBlockRegistration.WAXED_WEATHERED_CUT_COPPER_CABINET);
        CABINET_BLOCK_SETS.add(CabinetBlockRegistration.WAXED_EXPOSED_CUT_COPPER_CABINET);
        CABINET_BLOCK_SETS.add(CabinetBlockRegistration.WAXED_CUT_COPPER_CABINET);
        CABINET_BLOCK_SETS.add(CabinetBlockRegistration.COBBLED_DEEPSLATE_CABINET);
        CABINET_BLOCK_SETS.add(CabinetBlockRegistration.POLISHED_DEEPSLATE_CABINET);
        CABINET_BLOCK_SETS.add(CabinetBlockRegistration.DEEPSLATE_TILE_CABINET);
        CABINET_BLOCK_SETS.add(CabinetBlockRegistration.DEEPSLATE_BRICK_CABINET);

        CABINET_BLOCK_SETS.add(CabinetBlockRegistration.TUFF_CABINET);
        CABINET_BLOCK_SETS.add(CabinetBlockRegistration.POLISHED_TUFF_CABINET);
        CABINET_BLOCK_SETS.add(CabinetBlockRegistration.TUFF_BRICK_CABINET);
    }

    private static final List<DeferredHolder<Item, ? extends Item>> CABINET_ITEM_SETS =
        new ArrayList<>(List.of(CabinetBlockRegistration.OAK_CABINET_ITEM));
    static {
        CABINET_ITEM_SETS.add(CabinetBlockRegistration.COBBLESTONE_CABINET_ITEM);
        CABINET_ITEM_SETS.add(CabinetBlockRegistration.BRICK_CABINET_ITEM);
        CABINET_ITEM_SETS.add(CabinetBlockRegistration.STONE_BRICK_CABINET_ITEM);
        CABINET_ITEM_SETS.add(CabinetBlockRegistration.MUD_BRICK_CABINET_ITEM);
        CABINET_ITEM_SETS.add(CabinetBlockRegistration.NETHER_BRICK_CABINET_ITEM);
        CABINET_ITEM_SETS.add(CabinetBlockRegistration.SANDSTONE_CABINET_ITEM);
        CABINET_ITEM_SETS.add(CabinetBlockRegistration.SPRUCE_CABINET_ITEM);
        CABINET_ITEM_SETS.add(CabinetBlockRegistration.BIRCH_CABINET_ITEM);
        CABINET_ITEM_SETS.add(CabinetBlockRegistration.JUNGLE_CABINET_ITEM);
        CABINET_ITEM_SETS.add(CabinetBlockRegistration.QUARTZ_CABINET_ITEM);
        CABINET_ITEM_SETS.add(CabinetBlockRegistration.ACACIA_CABINET_ITEM);
        CABINET_ITEM_SETS.add(CabinetBlockRegistration.CHERRY_CABINET_ITEM);
        CABINET_ITEM_SETS.add(CabinetBlockRegistration.DARK_OAK_CABINET_ITEM);
        CABINET_ITEM_SETS.add(CabinetBlockRegistration.MANGROVE_CABINET_ITEM);
        CABINET_ITEM_SETS.add(CabinetBlockRegistration.BAMBOO_CABINET_ITEM);
        CABINET_ITEM_SETS.add(CabinetBlockRegistration.BAMBOO_MOSAIC_CABINET_ITEM);
        CABINET_ITEM_SETS.add(CabinetBlockRegistration.PRISMARINE_CABINET_ITEM);
        CABINET_ITEM_SETS.add(CabinetBlockRegistration.PRISMARINE_BRICK_CABINET_ITEM);
        CABINET_ITEM_SETS.add(CabinetBlockRegistration.DARK_PRISMARINE_CABINET_ITEM);
        CABINET_ITEM_SETS.add(CabinetBlockRegistration.RED_SANDSTONE_CABINET_ITEM);
        CABINET_ITEM_SETS.add(CabinetBlockRegistration.PURPUR_CABINET_ITEM);
        CABINET_ITEM_SETS.add(CabinetBlockRegistration.POLISHED_GRANITE_CABINET_ITEM);
        CABINET_ITEM_SETS.add(CabinetBlockRegistration.SMOOTH_RED_SANDSTONE_CABINET_ITEM);
        CABINET_ITEM_SETS.add(CabinetBlockRegistration.MOSSY_STONE_BRICK_CABINET_ITEM);
        CABINET_ITEM_SETS.add(CabinetBlockRegistration.POLISHED_DIORITE_CABINET_ITEM);
        CABINET_ITEM_SETS.add(CabinetBlockRegistration.MOSSY_COBBLESTONE_CABINET_ITEM);
        CABINET_ITEM_SETS.add(CabinetBlockRegistration.END_STONE_BRICK_CABINET_ITEM);
        CABINET_ITEM_SETS.add(CabinetBlockRegistration.STONE_CABINET_ITEM);
        CABINET_ITEM_SETS.add(CabinetBlockRegistration.SMOOTH_SANDSTONE_CABINET_ITEM);
        CABINET_ITEM_SETS.add(CabinetBlockRegistration.SMOOTH_QUARTZ_CABINET_ITEM);
        CABINET_ITEM_SETS.add(CabinetBlockRegistration.GRANITE_CABINET_ITEM);
        CABINET_ITEM_SETS.add(CabinetBlockRegistration.ANDESITE_CABINET_ITEM);
        CABINET_ITEM_SETS.add(CabinetBlockRegistration.RED_NETHER_BRICK_CABINET_ITEM);
        CABINET_ITEM_SETS.add(CabinetBlockRegistration.POLISHED_ANDESITE_CABINET_ITEM);
        CABINET_ITEM_SETS.add(CabinetBlockRegistration.DIORITE_CABINET_ITEM);
        CABINET_ITEM_SETS.add(CabinetBlockRegistration.CRIMSON_CABINET_ITEM);
        CABINET_ITEM_SETS.add(CabinetBlockRegistration.WARPED_CABINET_ITEM);
        CABINET_ITEM_SETS.add(CabinetBlockRegistration.BLACKSTONE_CABINET_ITEM);
        CABINET_ITEM_SETS.add(CabinetBlockRegistration.POLISHED_BLACKSTONE_BRICK_CABINET_ITEM);
        CABINET_ITEM_SETS.add(CabinetBlockRegistration.POLISHED_BLACKSTONE_CABINET_ITEM);
        CABINET_ITEM_SETS.add(CabinetBlockRegistration.OXIDIZED_CUT_COPPER_CABINET_ITEM);
        CABINET_ITEM_SETS.add(CabinetBlockRegistration.WEATHERED_CUT_COPPER_CABINET_ITEM);
        CABINET_ITEM_SETS.add(CabinetBlockRegistration.EXPOSED_CUT_COPPER_CABINET_ITEM);
        CABINET_ITEM_SETS.add(CabinetBlockRegistration.CUT_COPPER_CABINET_ITEM);
        CABINET_ITEM_SETS.add(CabinetBlockRegistration.WAXED_OXIDIZED_CUT_COPPER_CABINET_ITEM);
        CABINET_ITEM_SETS.add(CabinetBlockRegistration.WAXED_WEATHERED_CUT_COPPER_CABINET_ITEM);
        CABINET_ITEM_SETS.add(CabinetBlockRegistration.WAXED_EXPOSED_CUT_COPPER_CABINET_ITEM);
        CABINET_ITEM_SETS.add(CabinetBlockRegistration.WAXED_CUT_COPPER_CABINET_ITEM);
        CABINET_ITEM_SETS.add(CabinetBlockRegistration.COBBLED_DEEPSLATE_CABINET_ITEM);
        CABINET_ITEM_SETS.add(CabinetBlockRegistration.POLISHED_DEEPSLATE_CABINET_ITEM);
        CABINET_ITEM_SETS.add(CabinetBlockRegistration.DEEPSLATE_TILE_CABINET_ITEM);
        CABINET_ITEM_SETS.add(CabinetBlockRegistration.DEEPSLATE_BRICK_CABINET_ITEM);

        CABINET_ITEM_SETS.add(CabinetBlockRegistration.TUFF_CABINET_ITEM);
        CABINET_ITEM_SETS.add(CabinetBlockRegistration.POLISHED_TUFF_CABINET_ITEM);
        CABINET_ITEM_SETS.add(CabinetBlockRegistration.TUFF_BRICK_CABINET_ITEM);
    }
    public static List<DeferredHolder<Block, ? extends Block>> getChairBlockList() {
        return CHAIR_BLOCK_SETS;
    }

    public static List<DeferredHolder<Item, ? extends Item>> getChairItemList() {
        return CHAIR_ITEM_SETS;
    }

    public static List<DeferredHolder<Block, ? extends Block>> getTableBlockList() {
        return TABLE_BLOCK_SETS;
    }

    public static List<DeferredHolder<Item, ? extends Item>> getTableItemList() {
        return TABLE_ITEM_SETS;
    }

    public static List<DeferredHolder<Block, ? extends Block>> getColumnBlockList() {
        return COLUMN_BLOCK_SETS;
    }

    public static List<DeferredHolder<Item, ? extends Item>> getColumnItemList() {
        return COLUMN_ITEM_SETS;
    }

    public static List<DeferredHolder<Block, ? extends Block>> getCarvedColumnBlockList() {
        return CARVED_COLUMN_BLOCK_SETS;
    }
    public static List<DeferredHolder<Item, ? extends Item>> getCarvedColumnItemList() {
        return CARVED_COLUMN_ITEM_SETS;
    }
    public static List<DeferredHolder<Block, ? extends Block>> getLightedColumnBlockList() {return LIGHTED_COLUMN_BLOCK_SETS;}
    public static List<DeferredHolder<Item, ? extends Item>> getLightedColumnItemList() {
        return LIGHTED_COLUMN_ITEM_SETS;
    }
    public static List<DeferredHolder<Block, ? extends Block>> getPotHolderBlockList() {return POT_HOLDER_BLOCK_LIST;}
    public static List<DeferredHolder<Item, ? extends Item>> getPotHolderItemList() {
        return POT_HOLDER_ITEM_LIST;
    }

    public static List<DeferredHolder<Block, ? extends Block>> getBenchBlockList() {
        return BENCH_BLOCK_SETS;
    }

    public static List<DeferredHolder<Item, ? extends Item>> getBenchItemList() {
        return BENCH_ITEM_SETS;
    }
    public static List<DeferredHolder<Block, ? extends Block>> getCabinetBlockList() {
        return CABINET_BLOCK_SETS;
    }

    public static List<DeferredHolder<Item, ? extends Item>> getCabinetItemList() {
        return CABINET_ITEM_SETS;
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

        PROPERTY_BLOCKS.add(Blocks.TUFF);
        PROPERTY_BLOCKS.add(Blocks.POLISHED_TUFF);
        PROPERTY_BLOCKS.add(Blocks.TUFF_BRICKS);
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

        PROPERTY_TAGS.add(BlockTags.MINEABLE_WITH_PICKAXE);
        PROPERTY_TAGS.add(BlockTags.MINEABLE_WITH_PICKAXE);
        PROPERTY_TAGS.add(BlockTags.MINEABLE_WITH_PICKAXE);
    }

    public static final Map<String, String> PROPERTY_KINDS = new HashMap<>();
    static {
        PROPERTY_KINDS.put("oak", "oak_planks");
        PROPERTY_KINDS.put("cobblestone", "cobblestone");
        PROPERTY_KINDS.put("brick", "bricks");
        PROPERTY_KINDS.put("stone_brick", "stone_bricks");
        PROPERTY_KINDS.put("mud_brick", "mud_bricks");
        PROPERTY_KINDS.put("nether_brick", "nether_bricks");
        PROPERTY_KINDS.put("sandstone", "sandstone_bottom");
        PROPERTY_KINDS.put("spruce", "spruce_planks");
        PROPERTY_KINDS.put("birch", "birch_planks");
        PROPERTY_KINDS.put("jungle", "jungle_planks");
        PROPERTY_KINDS.put("quartz", "quartz_block_top");
        PROPERTY_KINDS.put("acacia", "acacia_planks");
        PROPERTY_KINDS.put("cherry", "cherry_planks");
        PROPERTY_KINDS.put("dark_oak", "dark_oak_planks");
        PROPERTY_KINDS.put("mangrove", "mangrove_planks");
        PROPERTY_KINDS.put("bamboo", "bamboo_planks");
        PROPERTY_KINDS.put("bamboo_mosaic", "bamboo_mosaic");
        PROPERTY_KINDS.put("prismarine", "prismarine");
        PROPERTY_KINDS.put("prismarine_brick", "prismarine_bricks");
        PROPERTY_KINDS.put("dark_prismarine", "dark_prismarine");
        PROPERTY_KINDS.put("red_sandstone", "red_sandstone_bottom");
        PROPERTY_KINDS.put("purpur", "purpur_block");
        PROPERTY_KINDS.put("polished_granite", "polished_granite");
        PROPERTY_KINDS.put("smooth_red_sandstone", "red_sandstone_top");
        PROPERTY_KINDS.put("mossy_stone_brick", "mossy_stone_bricks");
        PROPERTY_KINDS.put("polished_diorite", "polished_diorite");
        PROPERTY_KINDS.put("mossy_cobblestone", "mossy_cobblestone");
        PROPERTY_KINDS.put("end_stone_brick", "end_stone_bricks");
        PROPERTY_KINDS.put("stone", "stone");
        PROPERTY_KINDS.put("smooth_sandstone", "sandstone_top");
        PROPERTY_KINDS.put("smooth_quartz", "quartz_block_bottom");
        PROPERTY_KINDS.put("granite", "granite");
        PROPERTY_KINDS.put("andesite", "andesite");
        PROPERTY_KINDS.put("red_nether_brick", "red_nether_bricks");
        PROPERTY_KINDS.put("polished_andesite", "polished_andesite");
        PROPERTY_KINDS.put("diorite", "diorite");
        PROPERTY_KINDS.put("crimson", "crimson_planks");
        PROPERTY_KINDS.put("warped", "warped_planks");
        PROPERTY_KINDS.put("blackstone", "blackstone");
        PROPERTY_KINDS.put("polished_blackstone_brick", "polished_blackstone_bricks");
        PROPERTY_KINDS.put("polished_blackstone", "polished_blackstone");
        PROPERTY_KINDS.put("oxidized_cut_copper", "oxidized_cut_copper");
        PROPERTY_KINDS.put("weathered_cut_copper", "weathered_cut_copper");
        PROPERTY_KINDS.put("exposed_cut_copper", "exposed_cut_copper");
        PROPERTY_KINDS.put("cut_copper", "cut_copper");
        PROPERTY_KINDS.put("waxed_oxidized_cut_copper", "oxidized_cut_copper");
        PROPERTY_KINDS.put("waxed_weathered_cut_copper", "weathered_cut_copper");
        PROPERTY_KINDS.put("waxed_exposed_cut_copper", "exposed_cut_copper");
        PROPERTY_KINDS.put("waxed_cut_copper", "cut_copper");
        PROPERTY_KINDS.put("cobbled_deepslate", "cobbled_deepslate");
        PROPERTY_KINDS.put("polished_deepslate", "polished_deepslate");
        PROPERTY_KINDS.put("deepslate_tile", "deepslate_tiles");
        PROPERTY_KINDS.put("deepslate_brick", "deepslate_bricks");

        PROPERTY_KINDS.put("tuff", "tuff");
        PROPERTY_KINDS.put("polished_tuff", "polished_tuff");
        PROPERTY_KINDS.put("tuff_brick", "tuff_bricks");
    }


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
        "深板岩砖",

        "凝灰岩",
        "磨制凝灰岩",
        "凝灰岩砖"
    };
    public static final String[] COLOR_KIND_CHINESE_KEY = new String[]{
        "黑",
        "蓝",
        "棕",
        "青",
        "灰",
        "绿",
        "淡蓝",
        "淡灰",
        "黄绿",
        "品红",
        "橙",
        "粉",
        "紫",
        "红",
        "黄",
        "白",
    };
}