package nowebsite.maker.furnitureplan.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import nowebsite.maker.furnitureplan.FurniturePlan;
import nowebsite.maker.furnitureplan.blocks.cookingUtensils.IronPotBlock;
import nowebsite.maker.furnitureplan.blocks.cookingUtensils.StoveBlock;
import nowebsite.maker.furnitureplan.blocks.cookingUtensils.blockentities.IronPotBlockEntity;
import nowebsite.maker.furnitureplan.blocks.func.definition.*;
import nowebsite.maker.furnitureplan.blocks.singleblockfurniture.CupboardBlock;
import nowebsite.maker.furnitureplan.blocks.singleblockfurniture.LanternBlock;
import nowebsite.maker.furnitureplan.blocks.singleblockfurniture.TableLampBlock;
import nowebsite.maker.furnitureplan.blocks.singleblockfurniture.VaseBBlock;
import nowebsite.maker.furnitureplan.blocks.singleblockfurniture.blockentities.CupboardBlockEntity;
import nowebsite.maker.furnitureplan.blocks.singleblockfurniture.blockentities.VaseBBlockEntity;
import nowebsite.maker.furnitureplan.blocks.tableware.Cutlery;
import nowebsite.maker.furnitureplan.blocks.tableware.FoodPlateBlock;
import nowebsite.maker.furnitureplan.blocks.tableware.GlassBBlock;
import nowebsite.maker.furnitureplan.blocks.tableware.blockentities.FoodPlateBlockEntity;
import nowebsite.maker.furnitureplan.blocks.tableware.blockentities.GlassBBlockEntity;
import nowebsite.maker.furnitureplan.items.BaseBERBlockItem;
import nowebsite.maker.furnitureplan.items.GlassBBlockItem;
import nowebsite.maker.furnitureplan.items.IronPotItem;
import nowebsite.maker.furnitureplan.registry.kindsblock.*;
import oshi.util.tuples.Pair;

public class BlockRegistration extends BRUtils{
    public static void init() {
        ChairBlockRegistration.init();
        TableBlockRegistration.init();
        ColumnBlockRegistration.init();
        CarvedColumnBlockRegistration.init();
        LightedColumnBlockRegistration.init();
        PotHolderBlockRegistration.init();
        BenchBlockRegistration.init();
    }

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.createBlocks(FurniturePlan.MOD_ID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, FurniturePlan.MOD_ID);


    public static final TagKey<Block> CHAIR_BLOCK = BlockTags.create(ResourceLocation.fromNamespaceAndPath(FurniturePlan.MOD_ID, "chair"));
    public static final TagKey<Block> TABLE_BLOCK = BlockTags.create(ResourceLocation.fromNamespaceAndPath(FurniturePlan.MOD_ID, "table"));
    public static final TagKey<Block> COLUMN_BLOCK = BlockTags.create(ResourceLocation.fromNamespaceAndPath(FurniturePlan.MOD_ID, "column"));

    public static final TagKey<Block> CARVED_COLUMN_BLOCK = BlockTags.create(ResourceLocation.fromNamespaceAndPath(FurniturePlan.MOD_ID, "carved_column"));

    public static final TagKey<Block> LIGHTED_COLUMN_BLOCK = BlockTags.create(ResourceLocation.fromNamespaceAndPath(FurniturePlan.MOD_ID, "lighted_column"));
    public static final TagKey<Block> POT_HOLDER_BLOCK = BlockTags.create(ResourceLocation.fromNamespaceAndPath(FurniturePlan.MOD_ID, "pot_holder"));
    public static final TagKey<Block> BENCH_BLOCK = BlockTags.create(ResourceLocation.fromNamespaceAndPath(FurniturePlan.MOD_ID, "bench"));


    /*For tableware*/
    public static final DeferredHolder<Block, Block> CUTLERY_BLOCK = BLOCKS.register("cutlery_block", () -> new Cutlery(getSmallBlockBehaviors().sound(SoundType.STONE)));
    public static final DeferredHolder<Item, Item> CUTLERY_ITEM = ItemRegistration.ITEMS.register("cutlery_block", () -> new BlockItem(CUTLERY_BLOCK.get(), new Item.Properties().stacksTo(16)));
    public static final DeferredHolder<Block, Block> GLASS_B_BLOCK = BLOCKS.register("glass_b_block", () -> new GlassBBlock(getSmallBlockBehaviors().sound(SoundType.GLASS)));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<GlassBBlockEntity>> GLASS_B_BLOCK_ENTITY = BLOCK_ENTITY.register(
            "glass_b_block_entity",
            () -> BlockEntityType.Builder.of(GlassBBlockEntity::new, GLASS_B_BLOCK.get()).build(null)
    );
    public static final DeferredHolder<Item, Item> GLASS_B_BLOCK_ITEM = ItemRegistration.ITEMS.register("glass_b_block", () -> new GlassBBlockItem(GLASS_B_BLOCK.get(), new Item.Properties().stacksTo(2)));

    public static final DeferredHolder<Block, Block> FOOD_PLATE_BLOCK = BLOCKS.register("food_plate_block", () -> new FoodPlateBlock(getSmallBlockBehaviors().sound(SoundType.GLASS)));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<FoodPlateBlockEntity>> FOOD_PLATE_BLOCK_ENTITY = BLOCK_ENTITY.register(
            "food_plate_block_entity",
            () -> BlockEntityType.Builder.of(FoodPlateBlockEntity::new, FOOD_PLATE_BLOCK.get()).build(null)
    );
    public static final DeferredHolder<Item, Item> FOOD_PLATE_BLOCK_ITEM = ItemRegistration.ITEMS.register("plate", () -> new BlockItem(FOOD_PLATE_BLOCK.get(), new Item.Properties().stacksTo(16)));

    /*Lantern*/
    public static final DeferredHolder<Block, Block> LANTERN_BLOCK = BLOCKS.register("lantern_block", () -> new LanternBlock(BlockBehaviour.Properties.ofLegacyCopy(Blocks.OAK_PLANKS).lightLevel(litBlockEmission(15))));
    public static final DeferredHolder<Item, Item> LANTERN_ITEM = ItemRegistration.ITEMS.register("lantern_block", () -> new BlockItem(LANTERN_BLOCK.get(), new Item.Properties().stacksTo(16)));


    public static final DeferredHolder<Block, Block> IRON_POT_BLOCK = BLOCKS.register("iron_pot_block", () -> new IronPotBlock(getSmallBlockBehaviors().sound(SoundType.ANVIL)));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<IronPotBlockEntity>> IRON_POT_BLOCK_ENTITY = BLOCK_ENTITY.register(
            "iron_pot_block_entity",
            () -> BlockEntityType.Builder.of(IronPotBlockEntity::new, IRON_POT_BLOCK.get()).build(null)
    );
    public static final DeferredHolder<Item, Item> IRON_POT_BLOCK_ITEM = ItemRegistration.ITEMS.register("iron_pot_block", () -> new IronPotItem(IRON_POT_BLOCK.get(), new Item.Properties().stacksTo(1)));

    public static final DeferredHolder<Block, Block> STOVE_BLOCK = BLOCKS.register("stove_block", () -> new StoveBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).strength(3.0F).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredHolder<Item, Item> STOVE_BLOCK_ITEM = ItemRegistration.ITEMS.register("stove_block", () -> new BlockItem(STOVE_BLOCK.get(), new Item.Properties()));


    public static final DeferredHolder<Block, Block> CUPBOARD_BLOCK = BLOCKS.register("cupboard_block", () -> new CupboardBlock(BlockBehaviour.Properties.ofLegacyCopy(Blocks.CHEST).noOcclusion(), BlockRegistration.CUPBOARD_BLOCK_ENTITY::get));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CupboardBlockEntity>> CUPBOARD_BLOCK_ENTITY = BLOCK_ENTITY.register(
            "cupboard_block_entity",
            () -> BlockEntityType.Builder.of(CupboardBlockEntity::new, CUPBOARD_BLOCK.get()).build(null)
    );
    public static final DeferredHolder<Item, Item> CUPBOARD_BLOCK_ITEM = ItemRegistration.ITEMS.register("cupboard_block", () -> new BaseBERBlockItem(CUPBOARD_BLOCK.get(), new Item.Properties()));

    public static final DeferredHolder<Block, Block> VASE_B_BLOCK = BLOCKS.register("vase_b_block", () -> new VaseBBlock(BlockBehaviour.Properties.ofLegacyCopy(Blocks.FLOWER_POT).noOcclusion()));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<VaseBBlockEntity>> VASE_B_BLOCK_ENTITY = BLOCK_ENTITY.register(
            "vase_b_block_entity",
            () -> BlockEntityType.Builder.of(VaseBBlockEntity::new, VASE_B_BLOCK.get()).build(null)
    );
    public static final DeferredHolder<Item, Item> VASE_B_BLOCK_ITEM = ItemRegistration.ITEMS.register("vase_b_block", () -> new BlockItem(VASE_B_BLOCK.get(), new Item.Properties().stacksTo(16)));

    public static final DeferredHolder<Block, Block> TABLE_LAMP = BLOCKS.register("table_lamp", () -> new TableLampBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2, 3).noOcclusion().lightLevel(state -> state.getValue(TableLampBlock.LIT_E).isLit() ? 15 : 0)));
    public static final DeferredHolder<Item, Item> TABLE_LAMP_ITEM = ItemRegistration.ITEMS.register("table_lamp", () -> new BlockItem(TABLE_LAMP.get(), new Item.Properties()));
    public static final DeferredHolder<Block, Block> GRASS_GRASS = BLOCKS.register("grass_grass",
        () -> new FlowerBlock(
            makeEffectList(
                new Pair<>(MobEffects.DARKNESS, 2F)
            ) ,
            BlockBehaviour.Properties.of()
                .mapColor(MapColor.PLANT)
                .noCollission()
                .instabreak()
                .sound(SoundType.GRASS)
                .offsetType(BlockBehaviour.OffsetType.XZ)
                .pushReaction(PushReaction.DESTROY)
        )
    );
    public static final DeferredHolder<Item, Item> GRASS_GRASS_ITEM = ItemRegistration.ITEMS.register("grass_grass", () -> new BlockItem(
        GRASS_GRASS.get(),
        new Item.Properties().food(
            new FoodProperties.Builder()
                .nutrition(2)
                .saturationModifier(0.1F)
                .effect(() -> new MobEffectInstance(MobEffects.DARKNESS, 200, 255), 1.0F)
                .build()
        )
    ));




    public static class BlockStateRegistration{
        public static void init(){}

        public static final EnumProperty<PlateShape> PLATE_SHAPE = EnumProperty.create("shape", PlateShape.class);
        public static final EnumProperty<StoveShape> STOVE_SHAPE = EnumProperty.create("shape", StoveShape.class);
        public static final EnumProperty<TableShape> TABLE_SHAPE = EnumProperty.create("shape", TableShape.class);
        public static final EnumProperty<ColumnShape> COLUMN_SHAPE = EnumProperty.create("shape", ColumnShape.class);
        public static final EnumProperty<TableLampShape> TABLE_LAMP_SHAPE = EnumProperty.create("shape", TableLampShape.class);
        public static final EnumProperty<PotHolderPart> POT_HOLDER_PART = EnumProperty.create("part", PotHolderPart.class);
    }
}
