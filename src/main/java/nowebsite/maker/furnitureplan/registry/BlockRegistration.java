package nowebsite.maker.furnitureplan.registry;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import nowebsite.maker.furnitureplan.FurniturePlan;
import nowebsite.maker.furnitureplan.blocks.FoodPlateBlock;
import nowebsite.maker.furnitureplan.blocks.blockentities.FoodPlateBlockEntity;
import nowebsite.maker.furnitureplan.registry.kindsblock.*;

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

    public static final RegistryObject<Block> FOOD_PLATE_BLOCK = BLOCKS.register("food_plate_block", () -> new FoodPlateBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));

    public static final RegistryObject<BlockEntityType<FoodPlateBlockEntity>> FOOD_PLATE_BLOCK_ENTITY = BLOCK_ENTITY.register(
            "food_plate_block_entity",
            () -> BlockEntityType.Builder.of(FoodPlateBlockEntity::new, FOOD_PLATE_BLOCK.get()).build(null)
    );
    public static final RegistryObject<Item> FOOD_PLATE_BLOCK_ITEM = ItemRegistration.ITEMS.register("food_plate_block", () -> new BlockItem(FOOD_PLATE_BLOCK.get(), new Item.Properties().stacksTo(16)));

}
