package nowebsite.maker.furnitureplan.registry;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import nowebsite.maker.furnitureplan.FurniturePlan;
import nowebsite.maker.furnitureplan.blocks.tableware.*;
import nowebsite.maker.furnitureplan.blocks.tableware.blockentities.*;
import nowebsite.maker.furnitureplan.registry.kindsblock.*;
import org.jetbrains.annotations.NotNull;

public class BlockRegistration {
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
    public static final RegistryObject<Item> GLASS_B_BLOCK_ITEM = ItemRegistration.ITEMS.register("glass_b_block", () -> new BlockItem(GLASS_B_BLOCK.get(), new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Block> FOOD_PLATE_BLOCK = BLOCKS.register("food_plate_block", () -> new FoodPlateBlock(getSmallBlockBehaviors().sound(SoundType.GLASS)));
    public static final RegistryObject<BlockEntityType<FoodPlateBlockEntity>> FOOD_PLATE_BLOCK_ENTITY = BLOCK_ENTITY.register(
            "food_plate_block_entity",
            () -> BlockEntityType.Builder.of(FoodPlateBlockEntity::new, FOOD_PLATE_BLOCK.get()).build(null)
    );
    public static final RegistryObject<Item> FOOD_PLATE_BLOCK_ITEM = ItemRegistration.ITEMS.register("food_plate_block", () -> new BlockItem(FOOD_PLATE_BLOCK.get(), new Item.Properties().stacksTo(16)));


    public static final RegistryObject<Block> FOOD_PLATE_AND_CUTLERY_BLOCK = BLOCKS.register("food_plate_and_cutlery_block", () -> new FoodPlateAndCutleryBlock(getSmallBlockBehaviors().sound(SoundType.STONE)));
    public static final RegistryObject<BlockEntityType<FoodPlateAndCutleryBlockEntity>> FOOD_PLATE_AND_CUTLERY_BLOCK_ENTITY = BLOCK_ENTITY.register(
            "food_plate_and_cutlery_block_entity",
            () -> BlockEntityType.Builder.of(FoodPlateAndCutleryBlockEntity::new, FOOD_PLATE_AND_CUTLERY_BLOCK.get()).build(null)
    );
    public static final RegistryObject<Block> FOOD_PLATE_AND_GLASS_BLOCK = BLOCKS.register("food_plate_and_glass_block", () -> new FoodPlateAndGlassBlock(getSmallBlockBehaviors().sound(SoundType.GLASS)));
    public static final RegistryObject<BlockEntityType<FoodPlateAndGlassBlockEntity>> FOOD_PLATE_AND_GLASS_BLOCK_ENTITY = BLOCK_ENTITY.register(
            "food_plate_and_glass_block_entity",
            () -> BlockEntityType.Builder.of(FoodPlateAndGlassBlockEntity::new, FOOD_PLATE_AND_GLASS_BLOCK.get()).build(null)
    );
    public static final RegistryObject<Block> FOOD_PLATE_AND_GLASS_AND_CUTLERY_BLOCK = BLOCKS.register("food_plate_and_glass_and_cutlery_block", () -> new FoodPlateAndGlassAndCutleryBlock(getSmallBlockBehaviors().sound(SoundType.STONE)));
    public static final RegistryObject<BlockEntityType<FoodPlateAndGlassAndCutleryBlockEntity>> FOOD_PLATE_AND_GLASS_AND_CUTLERY_BLOCK_ENTITY = BLOCK_ENTITY.register(
            "food_plate_and_glass_and_cutlery_block_entity",
            () -> BlockEntityType.Builder.of(FoodPlateAndGlassAndCutleryBlockEntity::new, FOOD_PLATE_AND_GLASS_AND_CUTLERY_BLOCK.get()).build(null)
    );


    private static <A,B,C> boolean never(A a, B b, C c) {
        return false;
    }
    private static <A,B,C,D> boolean never(A a, B b, C c, D d) {
        return false;
    }

    public static BlockBehaviour.@NotNull Properties getSmallBlockBehaviors(){
        return BlockBehaviour.Properties.of(Material.DECORATION)
                .strength(0.2f)
                .noOcclusion()
                .isRedstoneConductor(BlockRegistration::never)
                .isViewBlocking(BlockRegistration::never);
    }
}
