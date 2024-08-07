package nowebsite.maker.furnitureplan.registry;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import nowebsite.maker.furnitureplan.FurniturePlan;
import nowebsite.maker.furnitureplan.blocks.cookingUtensils.IronPotBlock;
import nowebsite.maker.furnitureplan.blocks.cookingUtensils.StoveBlock;
import nowebsite.maker.furnitureplan.blocks.cookingUtensils.blockentities.IronPotBlockEntity;
import nowebsite.maker.furnitureplan.blocks.func.definition.ColumnShape;
import nowebsite.maker.furnitureplan.blocks.func.definition.StoveShape;
import nowebsite.maker.furnitureplan.blocks.singleblockfurniture.CupboardBlock;
import nowebsite.maker.furnitureplan.blocks.singleblockfurniture.VaseBBlock;
import nowebsite.maker.furnitureplan.blocks.singleblockfurniture.blockentities.CupboardBlockEntity;
import nowebsite.maker.furnitureplan.blocks.singleblockfurniture.LanternBlock;
import nowebsite.maker.furnitureplan.blocks.singleblockfurniture.blockentities.VaseBBlockEntity;
import nowebsite.maker.furnitureplan.blocks.func.definition.TableShape;
import nowebsite.maker.furnitureplan.blocks.tableware.Cutlery;
import nowebsite.maker.furnitureplan.blocks.tableware.FoodPlateBlock;
import nowebsite.maker.furnitureplan.blocks.tableware.GlassBBlock;
import nowebsite.maker.furnitureplan.blocks.tableware.blockentities.FoodPlateBlockEntity;
import nowebsite.maker.furnitureplan.blocks.tableware.blockentities.GlassBBlockEntity;
import nowebsite.maker.furnitureplan.blocks.func.definition.PlateShape;
import nowebsite.maker.furnitureplan.items.BaseBERBlockItem;
import nowebsite.maker.furnitureplan.items.GlassBBlockItem;
import nowebsite.maker.furnitureplan.items.IronPotItem;
import nowebsite.maker.furnitureplan.registry.kindsblock.*;

public class BlockRegistration extends BRUtils{
    public static void init() {
        ChairBlockRegistration.init();
        TableBlockRegistration.init();
        ColumnBlockRegistration.init();
        CarvedColumnBlockRegistration.init();
        LightedColumnBlockRegistration.init();
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(bus);
        BLOCK_ENTITY.register(bus);
    }

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, FurniturePlan.MOD_ID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, FurniturePlan.MOD_ID);


    public static final TagKey<Block> CHAIR_BLOCK = BlockTags.create(new ResourceLocation("furnitureplan", "chair"));

    public static final TagKey<Block> TABLE_BLOCK = BlockTags.create(new ResourceLocation("furnitureplan", "table"));

    public static final TagKey<Block> COLUMN_BLOCK = BlockTags.create(new ResourceLocation("furnitureplan", "column"));

    public static final TagKey<Block> CARVED_COLUMN_BLOCK = BlockTags.create(new ResourceLocation("furnitureplan", "carved_column"));

    public static final TagKey<Block> LIGHTED_COLUMN_BLOCK = BlockTags.create(new ResourceLocation("furnitureplan", "lighted_column"));


    /*For tableware*/
    public static final RegistryObject<Block> CUTLERY_BLOCK = BLOCKS.register("cutlery_block", () -> new Cutlery(getSmallBlockBehaviors().sound(SoundType.STONE)));
    public static final RegistryObject<Item> CUTLERY_ITEM = ItemRegistration.ITEMS.register("cutlery_block", () -> new BlockItem(CUTLERY_BLOCK.get(), new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Block> GLASS_B_BLOCK = BLOCKS.register("glass_b_block", () -> new GlassBBlock(getSmallBlockBehaviors().sound(SoundType.GLASS)));
    public static final RegistryObject<BlockEntityType<GlassBBlockEntity>> GLASS_B_BLOCK_ENTITY = BLOCK_ENTITY.register(
            "glass_b_block_entity",
            () -> BlockEntityType.Builder.of(GlassBBlockEntity::new, GLASS_B_BLOCK.get()).build(null)
    );
    public static final RegistryObject<Item> GLASS_B_BLOCK_ITEM = ItemRegistration.ITEMS.register("glass_b_block", () -> new GlassBBlockItem(GLASS_B_BLOCK.get(), new Item.Properties().stacksTo(2)));

    public static final RegistryObject<Block> FOOD_PLATE_BLOCK = BLOCKS.register("food_plate_block", () -> new FoodPlateBlock(getSmallBlockBehaviors().sound(SoundType.GLASS)));
    public static final RegistryObject<BlockEntityType<FoodPlateBlockEntity>> FOOD_PLATE_BLOCK_ENTITY = BLOCK_ENTITY.register(
            "food_plate_block_entity",
            () -> BlockEntityType.Builder.of(FoodPlateBlockEntity::new, FOOD_PLATE_BLOCK.get()).build(null)
    );
    public static final RegistryObject<Item> FOOD_PLATE_BLOCK_ITEM = ItemRegistration.ITEMS.register("plate", () -> new BlockItem(FOOD_PLATE_BLOCK.get(), new Item.Properties().stacksTo(16)));

    /*Lantern*/
    public static final RegistryObject<Block> LANTERN_BLOCK = BLOCKS.register("lantern_block", () -> new LanternBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).lightLevel(litBlockEmission(15))));
    public static final RegistryObject<Item> LANTERN_ITEM = ItemRegistration.ITEMS.register("lantern_block", () -> new BlockItem(LANTERN_BLOCK.get(), new Item.Properties().stacksTo(16)));


    public static final RegistryObject<Block> IRON_POT_BLOCK = BLOCKS.register("iron_pot_block", () -> new IronPotBlock(getSmallBlockBehaviors().sound(SoundType.ANVIL)));
    public static final RegistryObject<BlockEntityType<IronPotBlockEntity>> IRON_POT_BLOCK_ENTITY = BLOCK_ENTITY.register(
            "iron_pot_block_entity",
            () -> BlockEntityType.Builder.of(IronPotBlockEntity::new, IRON_POT_BLOCK.get()).build(null)
    );
    public static final RegistryObject<Item> IRON_POT_BLOCK_ITEM = ItemRegistration.ITEMS.register("iron_pot_block", () -> new IronPotItem(IRON_POT_BLOCK.get(), new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Block> STOVE_BLOCK = BLOCKS.register("stove_block", () -> new StoveBlock(BlockBehaviour.Properties.of(Material.STONE)));
    public static final RegistryObject<Item> STOVE_BLOCK_ITEM = ItemRegistration.ITEMS.register("stove_block", () -> new BlockItem(STOVE_BLOCK.get(), new Item.Properties()));


    public static final RegistryObject<Block> CUPBOARD_BLOCK = BLOCKS.register("cupboard_block", () -> new CupboardBlock(BlockBehaviour.Properties.copy(Blocks.CHEST).noOcclusion(), BlockRegistration.CUPBOARD_BLOCK_ENTITY::get));
    public static final RegistryObject<BlockEntityType<CupboardBlockEntity>> CUPBOARD_BLOCK_ENTITY = BLOCK_ENTITY.register(
            "cupboard_block_entity",
            () -> BlockEntityType.Builder.of(CupboardBlockEntity::new, CUPBOARD_BLOCK.get()).build(null)
    );
    public static final RegistryObject<Item> CUPBOARD_BLOCK_ITEM = ItemRegistration.ITEMS.register("cupboard_block", () -> new BaseBERBlockItem(CUPBOARD_BLOCK.get(), new Item.Properties()));

    public static final RegistryObject<Block> VASE_B_BLOCK = BLOCKS.register("vase_b_block", () -> new VaseBBlock(BlockBehaviour.Properties.copy(Blocks.FLOWER_POT).noOcclusion()));
    public static final RegistryObject<BlockEntityType<VaseBBlockEntity>> VASE_B_BLOCK_ENTITY = BLOCK_ENTITY.register(
            "vase_b_block_entity",
            () -> BlockEntityType.Builder.of(VaseBBlockEntity::new, VASE_B_BLOCK.get()).build(null)
    );
    public static final RegistryObject<Item> VASE_B_BLOCK_ITEM = ItemRegistration.ITEMS.register("vase_b_block", () -> new BlockItem(VASE_B_BLOCK.get(), new Item.Properties().stacksTo(16)));

    public static class BlockStateRegistration{
        public static void init(){}

        public static final EnumProperty<PlateShape> PLATE_SHAPE = EnumProperty.create("shape", PlateShape.class);
        public static final EnumProperty<StoveShape> STOVE_SHAPE = EnumProperty.create("shape", StoveShape.class);
        public static final EnumProperty<TableShape> TABLE_SHAPE = EnumProperty.create("shape", TableShape.class);
        public static final EnumProperty<ColumnShape> COLUMN_SHAPE = EnumProperty.create("shape", ColumnShape.class);
    }
}
