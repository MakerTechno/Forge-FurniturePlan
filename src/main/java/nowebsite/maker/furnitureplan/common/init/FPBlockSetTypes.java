package nowebsite.maker.furnitureplan.common.init;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import nowebsite.maker.furnitureplan.common.block.abstraction.set.FPBlockSetType;
import nowebsite.maker.furnitureplan.common.block.abstraction.set.FPColorfulSetType;
import nowebsite.maker.furnitureplan.common.data.gen.FPChineseProvider;

import java.util.List;

/**
 * 仅静态存储。
 */
@SuppressWarnings("unused")
public class FPBlockSetTypes {
    public static void touch() {}
    public static final FPBlockSetType OAK_SET = new FPBlockSetType(
        "oak",
        Blocks.OAK_PLANKS,
        true,
        () -> List.of(FPTags.OAK_FURNITURE, BlockTags.MINEABLE_WITH_AXE),
        map -> {
            map.put(FPChineseProvider.LOCALE, "橡木");
            return true;
        },
        "oak_planks"
    );
    public static final FPBlockSetType COBBLESTONE_SET = new FPBlockSetType(
        "cobblestone",
        Blocks.COBBLESTONE,
        true,
        () -> List.of(FPTags.COBBLESTONE_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put(FPChineseProvider.LOCALE, "圆石");
            return true;
        });
    public static final FPBlockSetType BRICK_SET = new FPBlockSetType(
        "brick",
        Blocks.BRICKS,
        true,
        () -> List.of(FPTags.BRICK_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put(FPChineseProvider.LOCALE, "红砖");
            return true;
        },
        "bricks"
    );
    public static final FPBlockSetType STONE_BRICK_SET = new FPBlockSetType(
        "stone_brick",
        Blocks.STONE_BRICKS,
        true,
        () -> List.of(FPTags.STONE_BRICK_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put(FPChineseProvider.LOCALE, "石砖");
            return true;
        },
        "stone_bricks"
    );
    public static final FPBlockSetType MUD_BRICK_SET = new FPBlockSetType(
        "mud_brick",
        Blocks.MUD_BRICKS,
        true,
        () -> List.of(FPTags.MUD_BRICK_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put(FPChineseProvider.LOCALE, "泥砖");
            return true;
        },
        "mud_bricks"
    );
    public static final FPBlockSetType RESIN_BRICK_SET = new FPBlockSetType(
        "resin_brick",
        Blocks.RESIN_BRICKS,
        true,
        () -> List.of(FPTags.RESIN_BRICK_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put(FPChineseProvider.LOCALE, "树脂砖");
            return true;
        },
        "resin_bricks");
    public static final FPBlockSetType NETHER_BRICK_SET = new FPBlockSetType(
        "nether_brick",
        Blocks.NETHER_BRICKS,
        true,
        () -> List.of(FPTags.NETHER_BRICK_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put(FPChineseProvider.LOCALE, "下界砖");
            return true;
        },
        "nether_bricks"
    );
    public static final FPBlockSetType SANDSTONE_SET = new FPBlockSetType(
        "sandstone",
        Blocks.SANDSTONE,
        true,
        () -> List.of(FPTags.SANDSTONE_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put(FPChineseProvider.LOCALE, "砂岩");
            return true;
        },
        "sandstone_bottom"
    );
    public static final FPBlockSetType SPRUCE_SET = new FPBlockSetType(
        "spruce",
        Blocks.SPRUCE_PLANKS,
        true,
        () -> List.of(FPTags.SPRUCE_FURNITURE, BlockTags.MINEABLE_WITH_AXE),
        map -> {
            map.put(FPChineseProvider.LOCALE, "云杉木");
            return true;
        },
        "spruce_planks"
    );
    public static final FPBlockSetType BIRCH_SET = new FPBlockSetType(
        "birch",
        Blocks.BIRCH_PLANKS,
        true,
        () -> List.of(FPTags.BIRCH_FURNITURE, BlockTags.MINEABLE_WITH_AXE),
        map -> {
            map.put(FPChineseProvider.LOCALE, "白桦木");
            return true;
        },
        "birch_planks"
    );
    public static final FPBlockSetType JUNGLE_SET = new FPBlockSetType(
        "jungle",
        Blocks.JUNGLE_PLANKS,
        true,
        () -> List.of(FPTags.JUNGLE_FURNITURE, BlockTags.MINEABLE_WITH_AXE),
        map -> {
            map.put(FPChineseProvider.LOCALE, "丛林木");
            return true;
        },
        "jungle_planks"
    );
    public static final FPBlockSetType QUARTZ_SET = new FPBlockSetType(
        "quartz",
        Blocks.QUARTZ_BLOCK,
        true,
        () -> List.of(FPTags.QUARTZ_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put(FPChineseProvider.LOCALE, "石英");
            return true;
        },
        "quartz_block_top"
    );
    public static final FPBlockSetType ACACIA_SET = new FPBlockSetType(
        "acacia",
        Blocks.ACACIA_PLANKS,
        true,
        () -> List.of(FPTags.ACACIA_FURNITURE, BlockTags.MINEABLE_WITH_AXE),
        map -> {
            map.put(FPChineseProvider.LOCALE, "金合欢木");
            return true;
        },
        "acacia_planks"
    );
    public static final FPBlockSetType CHERRY_SET = new FPBlockSetType(
        "cherry",
        Blocks.CHERRY_PLANKS,
        true,
        () -> List.of(FPTags.CHERRY_FURNITURE, BlockTags.MINEABLE_WITH_AXE),
        map -> {
            map.put(FPChineseProvider.LOCALE, "樱花木");
            return true;
        },
        "cherry_planks"
    );
    public static final FPBlockSetType DARK_OAK_SET = new FPBlockSetType(
        "dark_oak",
        Blocks.DARK_OAK_PLANKS,
        true,
        () -> List.of(FPTags.DARK_OAK_FURNITURE, BlockTags.MINEABLE_WITH_AXE),
        map -> {
            map.put(FPChineseProvider.LOCALE, "深色橡木");
            return true;
        },
        "dark_oak_planks"
    );
    public static final FPBlockSetType PALE_OAK_SET = new FPBlockSetType(
        "pale_oak",
        Blocks.PALE_OAK_PLANKS,
        true,
        () -> List.of(FPTags.PALE_OAK_FURNITURE, BlockTags.MINEABLE_WITH_AXE),
        map -> {
            map.put(FPChineseProvider.LOCALE, "苍白橡木");
            return true;
        },
        "pale_oak_planks"
    );
    public static final FPBlockSetType MANGROVE_SET = new FPBlockSetType(
        "mangrove",
        Blocks.MANGROVE_PLANKS,
        true,
        () -> List.of(FPTags.MANGROVE_FURNITURE, BlockTags.MINEABLE_WITH_AXE),
        map -> {
            map.put(FPChineseProvider.LOCALE, "红树木");
            return true;
        },
        "mangrove_planks"
    );
    public static final FPBlockSetType BAMBOO_SET = new FPBlockSetType(
        "bamboo",
        Blocks.BAMBOO_PLANKS,
        true,
        () -> List.of(FPTags.BAMBOO_FURNITURE, BlockTags.MINEABLE_WITH_AXE),
        map -> {
            map.put(FPChineseProvider.LOCALE, "竹");
            return true;
        },
        "bamboo_planks"
    );
    public static final FPBlockSetType BAMBOO_MOSAIC_SET = new FPBlockSetType(
        "bamboo_mosaic",
        Blocks.BAMBOO_MOSAIC,
        true,
        () -> List.of(FPTags.BAMBOO_MOSAIC_FURNITURE, BlockTags.MINEABLE_WITH_AXE),
        map -> {
            map.put(FPChineseProvider.LOCALE, "竹马赛克");
            return true;
        });
    public static final FPBlockSetType PRISMARINE_SET = new FPBlockSetType(
        "prismarine",
        Blocks.PRISMARINE,
        true,
        () -> List.of(FPTags.PRISMARINE_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put(FPChineseProvider.LOCALE, "海晶石");
            return true;
        });
    public static final FPBlockSetType PRISMARINE_BRICK_SET = new FPBlockSetType(
        "prismarine_brick",
        Blocks.PRISMARINE_BRICKS,
        true,
        () -> List.of(FPTags.PRISMARINE_BRICK_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put(FPChineseProvider.LOCALE, "海晶石砖");
            return true;
        },
        "prismarine_bricks"
    );
    public static final FPBlockSetType DARK_PRISMARINE_SET = new FPBlockSetType(
        "dark_prismarine",
        Blocks.DARK_PRISMARINE,
        true,
        () -> List.of(FPTags.DARK_PRISMARINE_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put(FPChineseProvider.LOCALE, "暗海晶石");
            return true;
        });
    public static final FPBlockSetType RED_SANDSTONE_SET = new FPBlockSetType(
        "red_sandstone",
        Blocks.RED_SANDSTONE,
        true,
        () -> List.of(FPTags.RED_SANDSTONE_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put(FPChineseProvider.LOCALE, "红砂岩");
            return true;
        },
        "red_sandstone_bottom"
    );
    public static final FPBlockSetType PURPUR_SET = new FPBlockSetType(
        "purpur",
        Blocks.PURPUR_BLOCK,
        true,
        () -> List.of(FPTags.PURPUR_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put(FPChineseProvider.LOCALE, "紫珀");
            return true;
        },
        "purpur_block"
    );
    public static final FPBlockSetType POLISHED_GRANITE_SET = new FPBlockSetType(
        "polished_granite",
        Blocks.POLISHED_GRANITE,
        true,
        () -> List.of(FPTags.POLISHED_GRANITE_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put(FPChineseProvider.LOCALE, "磨制花岗岩");
            return true;
        });
    public static final FPBlockSetType SMOOTH_RED_SANDSTONE_SET = new FPBlockSetType(
        "smooth_red_sandstone",
        Blocks.SMOOTH_RED_SANDSTONE,
        true,
        () -> List.of(FPTags.SMOOTH_RED_SANDSTONE_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put(FPChineseProvider.LOCALE, "平滑红砂岩");
            return true;
        },
        "red_sandstone_top"
    );
    public static final FPBlockSetType MOSSY_STONE_BRICK_SET = new FPBlockSetType(
        "mossy_stone_brick",
        Blocks.MOSSY_STONE_BRICKS,
        true,
        () -> List.of(FPTags.MOSSY_STONE_BRICK_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put(FPChineseProvider.LOCALE, "苔石砖");
            return true;
        },
        "mossy_stone_bricks"
    );
    public static final FPBlockSetType POLISHED_DIORITE_SET = new FPBlockSetType(
        "polished_diorite",
        Blocks.POLISHED_DIORITE,
        true,
        () -> List.of(FPTags.POLISHED_DIORITE_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put(FPChineseProvider.LOCALE, "磨制闪长岩");
            return true;
        });
    public static final FPBlockSetType MOSSY_COBBLESTONE_SET = new FPBlockSetType(
        "mossy_cobblestone",
        Blocks.MOSSY_COBBLESTONE,
        true,
        () -> List.of(FPTags.MOSSY_COBBLESTONE_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put(FPChineseProvider.LOCALE, "苔石");
            return true;
        });
    public static final FPBlockSetType END_STONE_BRICK_SET = new FPBlockSetType(
        "end_stone_brick",
        Blocks.END_STONE_BRICKS,
        true,
        () -> List.of(FPTags.END_STONE_BRICK_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put(FPChineseProvider.LOCALE, "末地石砖");
            return true;
        },
        "end_stone_bricks"
    );
    public static final FPBlockSetType STONE_SET = new FPBlockSetType(
        "stone",
        Blocks.STONE,
        true,
        () -> List.of(FPTags.STONE_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put(FPChineseProvider.LOCALE, "石");
            return true;
        });
    public static final FPBlockSetType SMOOTH_SANDSTONE_SET = new FPBlockSetType(
        "smooth_sandstone",
        Blocks.SMOOTH_SANDSTONE,
        true,
        () -> List.of(FPTags.SMOOTH_SANDSTONE_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put(FPChineseProvider.LOCALE, "平滑砂岩");
            return true;
        },
        "sandstone_top"
    );
    public static final FPBlockSetType SMOOTH_QUARTZ_SET = new FPBlockSetType(
        "smooth_quartz",
        Blocks.SMOOTH_QUARTZ,
        true,
        () -> List.of(FPTags.SMOOTH_QUARTZ_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put(FPChineseProvider.LOCALE, "平滑石英");
            return true;
        },
        "quartz_block_bottom"
    );
    public static final FPBlockSetType GRANITE_SET = new FPBlockSetType(
        "granite",
        Blocks.GRANITE,
        true,
        () -> List.of(FPTags.GRANITE_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put(FPChineseProvider.LOCALE, "花岗岩");
            return true;
        });
    public static final FPBlockSetType ANDESITE_SET = new FPBlockSetType(
        "andesite",
        Blocks.ANDESITE,
        true,
        () -> List.of(FPTags.ANDESITE_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put(FPChineseProvider.LOCALE, "安山岩");
            return true;
        });
    public static final FPBlockSetType RED_NETHER_BRICK_SET = new FPBlockSetType(
        "red_nether_brick",
        Blocks.RED_NETHER_BRICKS,
        true,
        () -> List.of(FPTags.RED_NETHER_BRICK_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put(FPChineseProvider.LOCALE, "红色下界砖");
            return true;
        },
        "red_nether_bricks"
    );
    public static final FPBlockSetType POLISHED_ANDESITE_SET = new FPBlockSetType(
        "polished_andesite",
        Blocks.POLISHED_ANDESITE,
        true,
        () -> List.of(FPTags.POLISHED_ANDESITE_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put(FPChineseProvider.LOCALE, "磨制安山岩");
            return true;
        });
    public static final FPBlockSetType DIORITE_SET = new FPBlockSetType(
        "diorite",
        Blocks.DIORITE,
        true,
        () -> List.of(FPTags.DIORITE_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put(FPChineseProvider.LOCALE, "闪长岩");
            return true;
        });
    public static final FPBlockSetType CRIMSON_SET = new FPBlockSetType(
        "crimson",
        Blocks.CRIMSON_PLANKS,
        true,
        () -> List.of(FPTags.CRIMSON_FURNITURE, BlockTags.MINEABLE_WITH_AXE),
        map -> {
            map.put(FPChineseProvider.LOCALE, "绯红木");
            return true;
        },
        "crimson_planks"
    );
    public static final FPBlockSetType WARPED_SET = new FPBlockSetType(
        "warped",
        Blocks.WARPED_PLANKS,
        true,
        () -> List.of(FPTags.WARPED_FURNITURE, BlockTags.MINEABLE_WITH_AXE),
        map -> {
            map.put(FPChineseProvider.LOCALE, "诡异木");
            return true;
        },
        "warped_planks"
    );
    public static final FPBlockSetType BLACKSTONE_SET = new FPBlockSetType(
        "blackstone",
        Blocks.BLACKSTONE,
        true,
        () -> List.of(FPTags.BLACKSTONE_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put(FPChineseProvider.LOCALE, "黑石");
            return true;
        });
    public static final FPBlockSetType POLISHED_BLACKSTONE_BRICK_SET = new FPBlockSetType(
        "polished_blackstone_brick",
        Blocks.POLISHED_BLACKSTONE_BRICKS,
        true,
        () -> List.of(FPTags.POLISHED_BLACKSTONE_BRICK_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put(FPChineseProvider.LOCALE, "磨制黑石砖");
            return true;
        },
        "polished_blackstone_bricks"
    );
    public static final FPBlockSetType POLISHED_BLACKSTONE_SET = new FPBlockSetType(
        "polished_blackstone",
        Blocks.POLISHED_BLACKSTONE,
        true,
        () -> List.of(FPTags.POLISHED_BLACKSTONE_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put(FPChineseProvider.LOCALE, "磨制黑石");
            return true;
        });
    public static final FPBlockSetType TUFF_SET = new FPBlockSetType(
        "tuff",
        Blocks.TUFF,
        true,
        () -> List.of(FPTags.TUFF_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put(FPChineseProvider.LOCALE, "凝灰岩");
            return true;
        });
    public static final FPBlockSetType POLISHED_TUFF_SET = new FPBlockSetType(
        "polished_tuff",
        Blocks.POLISHED_TUFF,
        true,
        () -> List.of(FPTags.POLISHED_TUFF_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put(FPChineseProvider.LOCALE, "磨制凝灰岩");
            return true;
        });
    public static final FPBlockSetType TUFF_BRICK_SET = new FPBlockSetType(
        "tuff_brick",
        Blocks.TUFF_BRICKS,
        true,
        () -> List.of(FPTags.TUFF_BRICK_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put(FPChineseProvider.LOCALE, "凝灰岩砖");
            return true;
        },
        "tuff_bricks"
    );
    public static final FPBlockSetType OXIDIZED_CUT_COPPER_SET = new FPBlockSetType(
        "oxidized_cut_copper",
        Blocks.OXIDIZED_CUT_COPPER,
        true,
        () -> List.of(FPTags.OXIDIZED_CUT_COPPER_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put(FPChineseProvider.LOCALE, "氧化的切制铜");
            return true;
        });
    public static final FPBlockSetType WEATHERED_CUT_COPPER_SET = new FPBlockSetType(
        "weathered_cut_copper",
        Blocks.WEATHERED_CUT_COPPER,
        true,
        () -> List.of(FPTags.WEATHERED_CUT_COPPER_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put(FPChineseProvider.LOCALE, "锈蚀的切制铜");
            return true;
        });
    public static final FPBlockSetType EXPOSED_CUT_COPPER_SET = new FPBlockSetType(
        "exposed_cut_copper",
        Blocks.EXPOSED_CUT_COPPER,
        true,
        () -> List.of(FPTags.EXPOSED_CUT_COPPER_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put(FPChineseProvider.LOCALE, "斑驳的切制铜");
            return true;
        });
    public static final FPBlockSetType CUT_COPPER_SET = new FPBlockSetType(
        "cut_copper",
        Blocks.CUT_COPPER,
        true,
        () -> List.of(FPTags.CUT_COPPER_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put(FPChineseProvider.LOCALE, "切制铜");
            return true;
        });
    public static final FPBlockSetType WAXED_OXIDIZED_CUT_COPPER_SET = new FPBlockSetType(
        "waxed_oxidized_cut_copper",
        Blocks.WAXED_OXIDIZED_CUT_COPPER,
        true,
        () -> List.of(FPTags.WAXED_OXIDIZED_CUT_COPPER_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put(FPChineseProvider.LOCALE, "涂蜡的氧化切制铜");
            return true;
        },
        "oxidized_cut_copper"
    );
    public static final FPBlockSetType WAXED_WEATHERED_CUT_COPPER_SET = new FPBlockSetType(
        "waxed_weathered_cut_copper",
        Blocks.WAXED_WEATHERED_CUT_COPPER,
        true,
        () -> List.of(FPTags.WAXED_WEATHERED_CUT_COPPER_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put(FPChineseProvider.LOCALE, "涂蜡的锈蚀切制铜");
            return true;
        },
        "weathered_cut_copper"
    );
    public static final FPBlockSetType WAXED_EXPOSED_CUT_COPPER_SET = new FPBlockSetType(
        "waxed_exposed_cut_copper",
        Blocks.WAXED_EXPOSED_CUT_COPPER,
        true,
        () -> List.of(FPTags.WAXED_EXPOSED_CUT_COPPER_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put(FPChineseProvider.LOCALE, "涂蜡的斑驳切制铜");
            return true;
        },
        "exposed_cut_copper"
    );
    public static final FPBlockSetType WAXED_CUT_COPPER_SET = new FPBlockSetType(
        "waxed_cut_copper",
        Blocks.WAXED_CUT_COPPER,
        true,
        () -> List.of(FPTags.WAXED_CUT_COPPER_FURNITURE),
        map -> {
            map.put(FPChineseProvider.LOCALE, "涂蜡的切制铜");
            return true;
        },
        "cut_copper"
    );
    public static final FPBlockSetType COBBLED_DEEPSLATE_SET = new FPBlockSetType(
        "cobbled_deepslate",
        Blocks.COBBLED_DEEPSLATE,
        true,
        () -> List.of(FPTags.COBBLED_DEEPSLATE_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put(FPChineseProvider.LOCALE, "深板岩圆石");
            return true;
        });
    public static final FPBlockSetType POLISHED_DEEPSLATE_SET = new FPBlockSetType(
        "polished_deepslate",
        Blocks.POLISHED_DEEPSLATE,
        true,
        () -> List.of(FPTags.POLISHED_DEEPSLATE_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put(FPChineseProvider.LOCALE, "磨制深板岩");
            return true;
        });
    public static final FPBlockSetType DEEPSLATE_TILE_SET = new FPBlockSetType(
        "deepslate_tile",
        Blocks.DEEPSLATE_TILES,
        true,
        () -> List.of(FPTags.DEEPSLATE_TILE_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put(FPChineseProvider.LOCALE, "深板岩瓦");
            return true;
        },
        "deepslate_tiles"
    );
    public static final FPBlockSetType DEEPSLATE_BRICK_SET = new FPBlockSetType(
        "deepslate_brick",
        Blocks.DEEPSLATE_BRICKS,
        true,
        () -> List.of(FPTags.DEEPSLATE_BRICK_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put(FPChineseProvider.LOCALE, "深板岩砖");
            return true;
        },
        "deepslate_bricks"
    );


    public static final FPColorfulSetType BLACK_SET = new FPColorfulSetType(
        "black",
        DyeColor.BLACK,
        Items.BLACK_DYE,
        Items.BLACK_CONCRETE,
        Blocks.BLACK_CONCRETE,
        true,
        () -> List.of(),
        map -> {
            map.put(FPChineseProvider.LOCALE, "黑色混凝土");
            return true;
        }
    );
    public static final FPColorfulSetType BLUE_SET = new FPColorfulSetType(
        "blue",
        DyeColor.BLUE,
        Items.BLUE_DYE,
        Items.BLUE_CONCRETE,
        Blocks.BLUE_CONCRETE,
        true,
        () -> List.of(),
        map -> {
            map.put(FPChineseProvider.LOCALE, "蓝色混凝土");
            return true;
        }
    );
    public static final FPColorfulSetType BROWN_SET = new FPColorfulSetType(
        "brown",
        DyeColor.BROWN,
        Items.BROWN_DYE,
        Items.BROWN_CONCRETE,
        Blocks.BROWN_CONCRETE,
        true,
        () -> List.of(),
        map -> {
            map.put(FPChineseProvider.LOCALE, "棕色混凝土");
            return true;
        }
    );
    public static final FPColorfulSetType CYAN_SET = new FPColorfulSetType(
        "cyan",
        DyeColor.CYAN,
        Items.CYAN_DYE,
        Items.CYAN_CONCRETE,
        Blocks.CYAN_CONCRETE,
        true,
        () -> List.of(),
        map -> {
            map.put(FPChineseProvider.LOCALE, "青色混凝土");
            return true;
        }
    );
    public static final FPColorfulSetType GRAY_SET = new FPColorfulSetType(
        "gray",
        DyeColor.GRAY,
        Items.GRAY_DYE,
        Items.GRAY_CONCRETE,
        Blocks.GRAY_CONCRETE,
        true,
        () -> List.of(),
        map -> {
            map.put(FPChineseProvider.LOCALE, "灰色混凝土");
            return true;
        }
    );
    public static final FPColorfulSetType GREEN_SET = new FPColorfulSetType(
        "green",
        DyeColor.GREEN,
        Items.GREEN_DYE,
        Items.GREEN_CONCRETE,
        Blocks.GREEN_CONCRETE,
        true,
        () -> List.of(),
        map -> {
            map.put(FPChineseProvider.LOCALE, "绿色混凝土");
            return true;
        }
    );
    public static final FPColorfulSetType LIGHT_BLUE_SET = new FPColorfulSetType(
        "light_blue",
        DyeColor.LIGHT_BLUE,
        Items.LIGHT_BLUE_DYE,
        Items.LIGHT_BLUE_CONCRETE,
        Blocks.LIGHT_BLUE_CONCRETE,
        true,
        () -> List.of(),
        map -> {
            map.put(FPChineseProvider.LOCALE, "淡蓝色混凝土");
            return true;
        }
    );
    public static final FPColorfulSetType LIGHT_GRAY_SET = new FPColorfulSetType(
        "light_gray",
        DyeColor.LIGHT_GRAY,
        Items.LIGHT_GRAY_DYE,
        Items.LIGHT_GRAY_CONCRETE,
        Blocks.LIGHT_GRAY_CONCRETE,
        true,
        () -> List.of(),
        map -> {
            map.put(FPChineseProvider.LOCALE, "淡灰色混凝土");
            return true;
        }
    );
    public static final FPColorfulSetType LIME_SET = new FPColorfulSetType(
        "lime",
        DyeColor.LIME,
        Items.LIME_DYE,
        Items.LIME_CONCRETE,
        Blocks.LIME_CONCRETE,
        true,
        () -> List.of(),
        map -> {
            map.put(FPChineseProvider.LOCALE, "莱姆混凝土");
            return true;
        }
    );
    public static final FPColorfulSetType MAGENTA_SET = new FPColorfulSetType(
        "magenta",
        DyeColor.MAGENTA,
        Items.MAGENTA_DYE,
        Items.MAGENTA_CONCRETE,
        Blocks.MAGENTA_CONCRETE,
        true,
        () -> List.of(),
        map -> {
            map.put(FPChineseProvider.LOCALE, "品红色混凝土");
            return true;
        }
    );
    public static final FPColorfulSetType ORANGE_SET = new FPColorfulSetType(
        "orange",
        DyeColor.ORANGE,
        Items.ORANGE_DYE,
        Items.ORANGE_CONCRETE,
        Blocks.ORANGE_CONCRETE,
        true,
        () -> List.of(),
        map -> {
            map.put(FPChineseProvider.LOCALE, "橘色混凝土");
            return true;
        }
    );
    public static final FPColorfulSetType PINK_SET = new FPColorfulSetType(
        "pink",
        DyeColor.PINK,
        Items.PINK_DYE,
        Items.PINK_CONCRETE,
        Blocks.PINK_CONCRETE,
        true,
        () -> List.of(),
        map -> {
            map.put(FPChineseProvider.LOCALE, "粉色混凝土");
            return true;
        }
    );
    public static final FPColorfulSetType PURPLE_SET = new FPColorfulSetType(
        "purple",
        DyeColor.PURPLE,
        Items.PURPLE_DYE,
        Items.PURPLE_CONCRETE,
        Blocks.PURPLE_CONCRETE,
        true,
        () -> List.of(),
        map -> {
            map.put(FPChineseProvider.LOCALE, "紫色混凝土");
            return true;
        }
    );
    public static final FPColorfulSetType RED_SET = new FPColorfulSetType(
        "red",
        DyeColor.RED,
        Items.RED_DYE,
        Items.RED_CONCRETE,
        Blocks.RED_CONCRETE,
        true,
        () -> List.of(),
        map -> {
            map.put(FPChineseProvider.LOCALE, "红色混凝土");
            return true;
        }
    );
    public static final FPColorfulSetType YELLOW_SET = new FPColorfulSetType(
        "yellow",
        DyeColor.YELLOW,
        Items.YELLOW_DYE,
        Items.YELLOW_CONCRETE,
        Blocks.YELLOW_CONCRETE,
        true,
        () -> List.of(),
        map -> {
            map.put(FPChineseProvider.LOCALE, "黄色混凝土");
            return true;
        }
    );
    public static final FPColorfulSetType WHITE_SET = new FPColorfulSetType(
        "white",
        DyeColor.WHITE,
        Items.WHITE_DYE,
        Items.WHITE_CONCRETE,
        Blocks.WHITE_CONCRETE,
        true,
        () -> List.of(),
        map -> {
            map.put(FPChineseProvider.LOCALE, "白色混凝土");
            return true;
        }
    );
}
