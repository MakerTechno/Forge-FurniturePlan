package nowebsite.maker.furnitureplan.common.init;

import net.minecraft.tags.BlockTags;
import nowebsite.maker.furnitureplan.common.block.abstraction.set.FPBlockSetType;

import java.util.List;

/**
 * 仅静态存储。
 */
@SuppressWarnings("unused")
public class FPBlockSetTypes {
    public static void touch() {}
    public static final FPBlockSetType OAK_SET = new FPBlockSetType(
        "oak",
        () -> List.of(FPTags.OAK_FURNITURE, BlockTags.MINEABLE_WITH_AXE),
        map -> {
            map.put("zh_cn", "橡木");
            return true;
        },
        "oak_planks"
    );
    public static final FPBlockSetType COBBLESTONE_SET = new FPBlockSetType(
        "cobblestone",
        () -> List.of(FPTags.COBBLESTONE_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put("zh_cn", "圆石");
            return true;
        });
    public static final FPBlockSetType BRICK_SET = new FPBlockSetType(
        "brick",
        () -> List.of(FPTags.BRICK_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put("zh_cn", "红砖");
            return true;
        },
        "bricks"
    );
    public static final FPBlockSetType STONE_BRICK_SET = new FPBlockSetType(
        "stone_brick",
        () -> List.of(FPTags.STONE_BRICK_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put("zh_cn", "石砖");
            return true;
        },
        "stone_bricks"
    );
    public static final FPBlockSetType MUD_BRICK_SET = new FPBlockSetType(
        "mud_brick",
        () -> List.of(FPTags.MUD_BRICK_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put("zh_cn", "泥砖");
            return true;
        },
        "mud_bricks"
    );
    public static final FPBlockSetType RESIN_BRICK_SET = new FPBlockSetType(
        "resin_brick",
        () -> List.of(FPTags.RESIN_BRICK_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put("zh_cn", "树脂砖");
            return true;
        },
        "resin_bricks");
    public static final FPBlockSetType NETHER_BRICK_SET = new FPBlockSetType(
        "nether_brick",
        () -> List.of(FPTags.NETHER_BRICK_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put("zh_cn", "下界砖");
            return true;
        },
        "nether_bricks"
    );
    public static final FPBlockSetType SANDSTONE_SET = new FPBlockSetType(
        "sandstone",
        () -> List.of(FPTags.SANDSTONE_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put("zh_cn", "砂岩");
            return true;
        },
        "sandstone_bottom"
    );
    public static final FPBlockSetType SPRUCE_SET = new FPBlockSetType(
        "spruce",
        () -> List.of(FPTags.SPRUCE_FURNITURE, BlockTags.MINEABLE_WITH_AXE),
        map -> {
            map.put("zh_cn", "云杉木");
            return true;
        },
        "spruce_planks"
    );
    public static final FPBlockSetType BIRCH_SET = new FPBlockSetType(
        "birch",
        () -> List.of(FPTags.BIRCH_FURNITURE, BlockTags.MINEABLE_WITH_AXE),
        map -> {
            map.put("zh_cn", "白桦木");
            return true;
        },
        "birch_planks"
    );
    public static final FPBlockSetType JUNGLE_SET = new FPBlockSetType(
        "jungle",
        () -> List.of(FPTags.JUNGLE_FURNITURE, BlockTags.MINEABLE_WITH_AXE),
        map -> {
            map.put("zh_cn", "丛林木");
            return true;
        },
        "jungle_planks"
    );
    public static final FPBlockSetType QUARTZ_SET = new FPBlockSetType(
        "quartz",
        () -> List.of(FPTags.QUARTZ_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put("zh_cn", "石英");
            return true;
        },
        "quartz_block_top"
    );
    public static final FPBlockSetType ACACIA_SET = new FPBlockSetType(
        "acacia",
        () -> List.of(FPTags.ACACIA_FURNITURE, BlockTags.MINEABLE_WITH_AXE),
        map -> {
            map.put("zh_cn", "金合欢木");
            return true;
        },
        "acacia_planks"
    );
    public static final FPBlockSetType CHERRY_SET = new FPBlockSetType(
        "cherry",
        () -> List.of(FPTags.CHERRY_FURNITURE, BlockTags.MINEABLE_WITH_AXE),
        map -> {
            map.put("zh_cn", "樱花木");
            return true;
        },
        "cherry_planks"
    );
    public static final FPBlockSetType DARK_OAK_SET = new FPBlockSetType(
        "dark_oak",
        () -> List.of(FPTags.DARK_OAK_FURNITURE, BlockTags.MINEABLE_WITH_AXE),
        map -> {
            map.put("zh_cn", "深色橡木");
            return true;
        },
        "dark_oak_planks"
    );
    public static final FPBlockSetType PALE_OAK_SET = new FPBlockSetType(
        "pale_oak",
        () -> List.of(FPTags.PALE_OAK_FURNITURE, BlockTags.MINEABLE_WITH_AXE),
        map -> {
            map.put("zh_cn", "苍白橡木");
            return true;
        },
        "pale_oak_planks"
    );
    public static final FPBlockSetType MANGROVE_SET = new FPBlockSetType(
        "mangrove",
        () -> List.of(FPTags.MANGROVE_FURNITURE, BlockTags.MINEABLE_WITH_AXE),
        map -> {
            map.put("zh_cn", "红树木");
            return true;
        },
        "mangrove_planks"
    );
    public static final FPBlockSetType BAMBOO_SET = new FPBlockSetType(
        "bamboo",
        () -> List.of(FPTags.BAMBOO_FURNITURE, BlockTags.MINEABLE_WITH_AXE),
        map -> {
            map.put("zh_cn", "竹");
            return true;
        },
        "bamboo_planks"
    );
    public static final FPBlockSetType BAMBOO_MOSAIC_SET = new FPBlockSetType(
        "bamboo_mosaic",
        () -> List.of(FPTags.BAMBOO_MOSAIC_FURNITURE, BlockTags.MINEABLE_WITH_AXE),
        map -> {
            map.put("zh_cn", "竹马赛克");
            return true;
        });
    public static final FPBlockSetType PRISMARINE_SET = new FPBlockSetType(
        "prismarine",
        () -> List.of(FPTags.PRISMARINE_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put("zh_cn", "海晶石");
            return true;
        });
    public static final FPBlockSetType PRISMARINE_BRICK_SET = new FPBlockSetType(
        "prismarine_brick",
        () -> List.of(FPTags.PRISMARINE_BRICK_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put("zh_cn", "海晶石砖");
            return true;
        },
        "prismarine_bricks"
    );
    public static final FPBlockSetType DARK_PRISMARINE_SET = new FPBlockSetType(
        "dark_prismarine",
        () -> List.of(FPTags.DARK_PRISMARINE_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put("zh_cn", "暗海晶石");
            return true;
        });
    public static final FPBlockSetType RED_SANDSTONE_SET = new FPBlockSetType(
        "red_sandstone",
        () -> List.of(FPTags.RED_SANDSTONE_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put("zh_cn", "红砂岩");
            return true;
        },
        "red_sandstone_bottom"
    );
    public static final FPBlockSetType PURPUR_SET = new FPBlockSetType(
        "purpur",
        () -> List.of(FPTags.PURPUR_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put("zh_cn", "紫珀");
            return true;
        },
        "purpur_block"
    );
    public static final FPBlockSetType POLISHED_GRANITE_SET = new FPBlockSetType(
        "polished_granite",
        () -> List.of(FPTags.POLISHED_GRANITE_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put("zh_cn", "磨制花岗岩");
            return true;
        });
    public static final FPBlockSetType SMOOTH_RED_SANDSTONE_SET = new FPBlockSetType(
        "smooth_red_sandstone",
        () -> List.of(FPTags.SMOOTH_RED_SANDSTONE_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put("zh_cn", "平滑红砂岩");
            return true;
        },
        "red_sandstone_top"
    );
    public static final FPBlockSetType MOSSY_STONE_BRICK_SET = new FPBlockSetType(
        "mossy_stone_brick",
        () -> List.of(FPTags.MOSSY_STONE_BRICK_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put("zh_cn", "苔石砖");
            return true;
        },
        "mossy_stone_bricks"
    );
    public static final FPBlockSetType POLISHED_DIORITE_SET = new FPBlockSetType(
        "polished_diorite",
        () -> List.of(FPTags.POLISHED_DIORITE_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put("zh_cn", "磨制闪长岩");
            return true;
        });
    public static final FPBlockSetType MOSSY_COBBLESTONE_SET = new FPBlockSetType(
        "mossy_cobblestone",
        () -> List.of(FPTags.MOSSY_COBBLESTONE_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put("zh_cn", "苔石");
            return true;
        });
    public static final FPBlockSetType END_STONE_BRICK_SET = new FPBlockSetType(
        "end_stone_brick",
        () -> List.of(FPTags.END_STONE_BRICK_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put("zh_cn", "末地石砖");
            return true;
        },
        "end_stone_bricks"
    );
    public static final FPBlockSetType STONE_SET = new FPBlockSetType(
        "stone",
        () -> List.of(FPTags.STONE_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put("zh_cn", "石头");
            return true;
        });
    public static final FPBlockSetType SMOOTH_SANDSTONE_SET = new FPBlockSetType(
        "smooth_sandstone",
        () -> List.of(FPTags.SMOOTH_SANDSTONE_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put("zh_cn", "平滑砂岩");
            return true;
        },
        "sandstone_top"
    );
    public static final FPBlockSetType SMOOTH_QUARTZ_SET = new FPBlockSetType(
        "smooth_quartz",
        () -> List.of(FPTags.SMOOTH_QUARTZ_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put("zh_cn", "平滑石英");
            return true;
        },
        "quartz_block_bottom"
    );
    public static final FPBlockSetType GRANITE_SET = new FPBlockSetType(
        "granite",
        () -> List.of(FPTags.GRANITE_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put("zh_cn", "花岗岩");
            return true;
        });
    public static final FPBlockSetType ANDESITE_SET = new FPBlockSetType(
        "andesite",
        () -> List.of(FPTags.ANDESITE_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put("zh_cn", "安山岩");
            return true;
        });
    public static final FPBlockSetType RED_NETHER_BRICK_SET = new FPBlockSetType(
        "red_nether_brick",
        () -> List.of(FPTags.RED_NETHER_BRICK_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put("zh_cn", "红色下界砖");
            return true;
        },
        "red_nether_bricks"
    );
    public static final FPBlockSetType POLISHED_ANDESITE_SET = new FPBlockSetType(
        "polished_andesite",
        () -> List.of(FPTags.POLISHED_ANDESITE_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put("zh_cn", "磨制安山岩");
            return true;
        });
    public static final FPBlockSetType DIORITE_SET = new FPBlockSetType(
        "diorite",
        () -> List.of(FPTags.DIORITE_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put("zh_cn", "闪长岩");
            return true;
        });
    public static final FPBlockSetType CRIMSON_SET = new FPBlockSetType(
        "crimson",
        () -> List.of(FPTags.CRIMSON_FURNITURE, BlockTags.MINEABLE_WITH_AXE),
        map -> {
            map.put("zh_cn", "绯红木");
            return true;
        },
        "crimson_planks"
    );
    public static final FPBlockSetType WARPED_SET = new FPBlockSetType(
        "warped",
        () -> List.of(FPTags.WARPED_FURNITURE, BlockTags.MINEABLE_WITH_AXE),
        map -> {
            map.put("zh_cn", "诡异木");
            return true;
        },
        "warped_planks"
    );
    public static final FPBlockSetType BLACKSTONE_SET = new FPBlockSetType(
        "blackstone",
        () -> List.of(FPTags.BLACKSTONE_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put("zh_cn", "黑石");
            return true;
        });
    public static final FPBlockSetType POLISHED_BLACKSTONE_BRICK_SET = new FPBlockSetType(
        "polished_blackstone_brick",
        () -> List.of(FPTags.POLISHED_BLACKSTONE_BRICK_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put("zh_cn", "磨制黑石砖");
            return true;
        },
        "polished_blackstone_bricks"
    );
    public static final FPBlockSetType POLISHED_BLACKSTONE_SET = new FPBlockSetType(
        "polished_blackstone",
        () -> List.of(FPTags.POLISHED_BLACKSTONE_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put("zh_cn", "磨制黑石");
            return true;
        });
    public static final FPBlockSetType TUFF_SET = new FPBlockSetType(
        "tuff",
        () -> List.of(FPTags.TUFF_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put("zh_cn", "凝灰岩");
            return true;
        });
    public static final FPBlockSetType POLISHED_TUFF_SET = new FPBlockSetType(
        "polished_tuff",
        () -> List.of(FPTags.POLISHED_TUFF_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put("zh_cn", "磨制凝灰岩");
            return true;
        });
    public static final FPBlockSetType TUFF_BRICK_SET = new FPBlockSetType(
        "tuff_brick",
        () -> List.of(FPTags.TUFF_BRICK_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put("zh_cn", "凝灰岩砖");
            return true;
        },
        "tuff_bricks"
    );
    public static final FPBlockSetType OXIDIZED_CUT_COPPER_SET = new FPBlockSetType(
        "oxidized_cut_copper",
        () -> List.of(FPTags.OXIDIZED_CUT_COPPER_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put("zh_cn", "氧化的切制铜");
            return true;
        });
    public static final FPBlockSetType WEATHERED_CUT_COPPER_SET = new FPBlockSetType(
        "weathered_cut_copper",
        () -> List.of(FPTags.WEATHERED_CUT_COPPER_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put("zh_cn", "锈蚀的切制铜");
            return true;
        });
    public static final FPBlockSetType EXPOSED_CUT_COPPER_SET = new FPBlockSetType(
        "exposed_cut_copper",
        () -> List.of(FPTags.EXPOSED_CUT_COPPER_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put("zh_cn", "斑驳的切制铜");
            return true;
        });
    public static final FPBlockSetType CUT_COPPER_SET = new FPBlockSetType(
        "cut_copper",
        () -> List.of(FPTags.CUT_COPPER_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put("zh_cn", "切制铜");
            return true;
        });
    public static final FPBlockSetType WAXED_OXIDIZED_CUT_COPPER_SET = new FPBlockSetType(
        "waxed_oxidized_cut_copper",
        () -> List.of(FPTags.WAXED_OXIDIZED_CUT_COPPER_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put("zh_cn", "涂蜡的氧化切制铜");
            return true;
        },
        "oxidized_cut_copper"
    );
    public static final FPBlockSetType WAXED_WEATHERED_CUT_COPPER_SET = new FPBlockSetType(
        "waxed_weathered_cut_copper",
        () -> List.of(FPTags.WAXED_WEATHERED_CUT_COPPER_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put("zh_cn", "涂蜡的锈蚀切制铜");
            return true;
        },
        "weathered_cut_copper"
    );
    public static final FPBlockSetType WAXED_EXPOSED_CUT_COPPER_SET = new FPBlockSetType(
        "waxed_exposed_cut_copper",
        () -> List.of(FPTags.WAXED_EXPOSED_CUT_COPPER_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put("zh_cn", "涂蜡的斑驳切制铜");
            return true;
        },
        "exposed_cut_copper"
    );
    public static final FPBlockSetType WAXED_CUT_COPPER_SET = new FPBlockSetType(
        "waxed_cut_copper",
        () -> List.of(FPTags.WAXED_CUT_COPPER_FURNITURE),
        map -> {
            map.put("zh_cn", "涂蜡的切制铜");
            return true;
        },
        "cut_copper"
    );
    public static final FPBlockSetType COBBLED_DEEPSLATE_SET = new FPBlockSetType(
        "cobbled_deepslate",
        () -> List.of(FPTags.COBBLED_DEEPSLATE_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put("zh_cn", "深板岩圆石");
            return true;
        });
    public static final FPBlockSetType POLISHED_DEEPSLATE_SET = new FPBlockSetType(
        "polished_deepslate",
        () -> List.of(FPTags.POLISHED_DEEPSLATE_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put("zh_cn", "磨制深板岩");
            return true;
        });
    public static final FPBlockSetType DEEPSLATE_TILE_SET = new FPBlockSetType(
        "deepslate_tile",
        () -> List.of(FPTags.DEEPSLATE_TILE_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put("zh_cn", "深板岩瓦");
            return true;
        },
        "deepslate_tiles"
    );
    public static final FPBlockSetType DEEPSLATE_BRICK_SET = new FPBlockSetType(
        "deepslate_brick",
        () -> List.of(FPTags.DEEPSLATE_BRICK_FURNITURE, BlockTags.MINEABLE_WITH_PICKAXE),
        map -> {
            map.put("zh_cn", "深板岩砖");
            return true;
        },
        "deepslate_bricks"
    );

}
