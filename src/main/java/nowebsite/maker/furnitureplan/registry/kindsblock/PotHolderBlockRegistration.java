package nowebsite.maker.furnitureplan.registry.kindsblock;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredHolder;
import nowebsite.maker.furnitureplan.blocks.singleblockfurniture.PotHolder;
import nowebsite.maker.furnitureplan.blocks.singleblockfurniture.blockentities.PotHolderBlockEntity;
import nowebsite.maker.furnitureplan.registry.BlockRegistration;
import nowebsite.maker.furnitureplan.registry.ItemRegistration;

@SuppressWarnings("all")
public class PotHolderBlockRegistration {
    public static void init() {}
    public static final DeferredHolder<Block, Block> BLACK_POT_HOLDER_BLOCK = BlockRegistration.BLOCKS.register("black_pot_holder_block", () -> new PotHolder(BlockBehaviour.Properties.ofLegacyCopy(Blocks.GRAY_CONCRETE).noOcclusion(), 0));
    public static final DeferredHolder<Block, Block> BLUE_POT_HOLDER_BLOCK = BlockRegistration.BLOCKS.register("blue_pot_holder_block", () -> new PotHolder(BlockBehaviour.Properties.ofLegacyCopy(Blocks.GRAY_CONCRETE).noOcclusion(), 1));
    public static final DeferredHolder<Block, Block> BROWN_POT_HOLDER_BLOCK = BlockRegistration.BLOCKS.register("brown_pot_holder_block", () -> new PotHolder(BlockBehaviour.Properties.ofLegacyCopy(Blocks.GRAY_CONCRETE).noOcclusion(), 2));
    public static final DeferredHolder<Block, Block> CYAN_POT_HOLDER_BLOCK = BlockRegistration.BLOCKS.register("cyan_pot_holder_block", () -> new PotHolder(BlockBehaviour.Properties.ofLegacyCopy(Blocks.GRAY_CONCRETE).noOcclusion(), 3));
    public static final DeferredHolder<Block, Block> GRAY_POT_HOLDER_BLOCK = BlockRegistration.BLOCKS.register("gray_pot_holder_block", () -> new PotHolder(BlockBehaviour.Properties.ofLegacyCopy(Blocks.GRAY_CONCRETE).noOcclusion(), 4));
    public static final DeferredHolder<Block, Block> GREEN_POT_HOLDER_BLOCK = BlockRegistration.BLOCKS.register("green_pot_holder_block", () -> new PotHolder(BlockBehaviour.Properties.ofLegacyCopy(Blocks.GRAY_CONCRETE).noOcclusion(), 5));
    public static final DeferredHolder<Block, Block> LIGHT_BLUE_POT_HOLDER_BLOCK = BlockRegistration.BLOCKS.register("light_blue_pot_holder_block", () -> new PotHolder(BlockBehaviour.Properties.ofLegacyCopy(Blocks.GRAY_CONCRETE).noOcclusion(), 6));
    public static final DeferredHolder<Block, Block> LIGHT_GRAY_POT_HOLDER_BLOCK = BlockRegistration.BLOCKS.register("light_gray_pot_holder_block", () -> new PotHolder(BlockBehaviour.Properties.ofLegacyCopy(Blocks.GRAY_CONCRETE).noOcclusion(), 7));
    public static final DeferredHolder<Block, Block> LIME_POT_HOLDER_BLOCK = BlockRegistration.BLOCKS.register("lime_pot_holder_block", () -> new PotHolder(BlockBehaviour.Properties.ofLegacyCopy(Blocks.GRAY_CONCRETE).noOcclusion(), 8));
    public static final DeferredHolder<Block, Block> MAGENTA_POT_HOLDER_BLOCK = BlockRegistration.BLOCKS.register("magenta_pot_holder_block", () -> new PotHolder(BlockBehaviour.Properties.ofLegacyCopy(Blocks.GRAY_CONCRETE).noOcclusion(), 9));
    public static final DeferredHolder<Block, Block> ORANGE_POT_HOLDER_BLOCK = BlockRegistration.BLOCKS.register("orange_pot_holder_block", () -> new PotHolder(BlockBehaviour.Properties.ofLegacyCopy(Blocks.GRAY_CONCRETE).noOcclusion(), 10));
    public static final DeferredHolder<Block, Block> PINK_POT_HOLDER_BLOCK = BlockRegistration.BLOCKS.register("pink_pot_holder_block", () -> new PotHolder(BlockBehaviour.Properties.ofLegacyCopy(Blocks.GRAY_CONCRETE).noOcclusion(), 11));
    public static final DeferredHolder<Block, Block> PURPLE_POT_HOLDER_BLOCK = BlockRegistration.BLOCKS.register("purple_pot_holder_block", () -> new PotHolder(BlockBehaviour.Properties.ofLegacyCopy(Blocks.GRAY_CONCRETE).noOcclusion(), 12));
    public static final DeferredHolder<Block, Block> RED_POT_HOLDER_BLOCK = BlockRegistration.BLOCKS.register("red_pot_holder_block", () -> new PotHolder(BlockBehaviour.Properties.ofLegacyCopy(Blocks.GRAY_CONCRETE).noOcclusion(), 13));
    public static final DeferredHolder<Block, Block> YELLOW_POT_HOLDER_BLOCK = BlockRegistration.BLOCKS.register("yellow_pot_holder_block", () -> new PotHolder(BlockBehaviour.Properties.ofLegacyCopy(Blocks.GRAY_CONCRETE).noOcclusion(), 14));
    public static final DeferredHolder<Block, Block> WHITE_POT_HOLDER_BLOCK = BlockRegistration.BLOCKS.register("white_pot_holder_block", () -> new PotHolder(BlockBehaviour.Properties.ofLegacyCopy(Blocks.GRAY_CONCRETE).noOcclusion(), 15));
    public static final DeferredHolder<Item, Item> BLACK_POT_HOLDER_BLOCK_ITEM = ItemRegistration.ITEMS.register("black_pot_holder_block", () -> new BlockItem(BLACK_POT_HOLDER_BLOCK.get(), new Item.Properties()));
    public static final DeferredHolder<Item, Item> BLUE_POT_HOLDER_BLOCK_ITEM = ItemRegistration.ITEMS.register("blue_pot_holder_block", () -> new BlockItem(BLUE_POT_HOLDER_BLOCK.get(), new Item.Properties()));
    public static final DeferredHolder<Item, Item> BROWN_POT_HOLDER_BLOCK_ITEM = ItemRegistration.ITEMS.register("brown_pot_holder_block", () -> new BlockItem(BROWN_POT_HOLDER_BLOCK.get(), new Item.Properties()));
    public static final DeferredHolder<Item, Item> CYAN_POT_HOLDER_BLOCK_ITEM = ItemRegistration.ITEMS.register("cyan_pot_holder_block", () -> new BlockItem(CYAN_POT_HOLDER_BLOCK.get(), new Item.Properties()));
    public static final DeferredHolder<Item, Item> GRAY_POT_HOLDER_BLOCK_ITEM = ItemRegistration.ITEMS.register("gray_pot_holder_block", () -> new BlockItem(GRAY_POT_HOLDER_BLOCK.get(), new Item.Properties()));
    public static final DeferredHolder<Item, Item> GREEN_POT_HOLDER_BLOCK_ITEM = ItemRegistration.ITEMS.register("green_pot_holder_block", () -> new BlockItem(GREEN_POT_HOLDER_BLOCK.get(), new Item.Properties()));
    public static final DeferredHolder<Item, Item> LIGHT_BLUE_POT_HOLDER_BLOCK_ITEM = ItemRegistration.ITEMS.register("light_blue_pot_holder_block", () -> new BlockItem(LIGHT_BLUE_POT_HOLDER_BLOCK.get(), new Item.Properties()));
    public static final DeferredHolder<Item, Item> LIGHT_GRAY_POT_HOLDER_BLOCK_ITEM = ItemRegistration.ITEMS.register("light_gray_pot_holder_block", () -> new BlockItem(LIGHT_GRAY_POT_HOLDER_BLOCK.get(), new Item.Properties()));
    public static final DeferredHolder<Item, Item> LIME_POT_HOLDER_BLOCK_ITEM = ItemRegistration.ITEMS.register("lime_pot_holder_block", () -> new BlockItem(LIME_POT_HOLDER_BLOCK.get(), new Item.Properties()));
    public static final DeferredHolder<Item, Item> MAGENTA_POT_HOLDER_BLOCK_ITEM = ItemRegistration.ITEMS.register("magenta_pot_holder_block", () -> new BlockItem(MAGENTA_POT_HOLDER_BLOCK.get(), new Item.Properties()));
    public static final DeferredHolder<Item, Item> ORANGE_POT_HOLDER_BLOCK_ITEM = ItemRegistration.ITEMS.register("orange_pot_holder_block", () -> new BlockItem(ORANGE_POT_HOLDER_BLOCK.get(), new Item.Properties()));
    public static final DeferredHolder<Item, Item> PINK_POT_HOLDER_BLOCK_ITEM = ItemRegistration.ITEMS.register("pink_pot_holder_block", () -> new BlockItem(PINK_POT_HOLDER_BLOCK.get(), new Item.Properties()));
    public static final DeferredHolder<Item, Item> PURPLE_POT_HOLDER_BLOCK_ITEM = ItemRegistration.ITEMS.register("purple_pot_holder_block", () -> new BlockItem(PURPLE_POT_HOLDER_BLOCK.get(), new Item.Properties()));
    public static final DeferredHolder<Item, Item> RED_POT_HOLDER_BLOCK_ITEM = ItemRegistration.ITEMS.register("red_pot_holder_block", () -> new BlockItem(RED_POT_HOLDER_BLOCK.get(), new Item.Properties()));
    public static final DeferredHolder<Item, Item> YELLOW_POT_HOLDER_BLOCK_ITEM = ItemRegistration.ITEMS.register("yellow_pot_holder_block", () -> new BlockItem(YELLOW_POT_HOLDER_BLOCK.get(), new Item.Properties()));
    public static final DeferredHolder<Item, Item> WHITE_POT_HOLDER_BLOCK_ITEM = ItemRegistration.ITEMS.register("white_pot_holder_block", () -> new BlockItem(WHITE_POT_HOLDER_BLOCK.get(), new Item.Properties()));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<PotHolderBlockEntity>> POT_HOLDER_BLOCK_ENTITY = BlockRegistration.BLOCK_ENTITY.register(
        "pot_holder_block_entity",
        () -> BlockEntityType.Builder.of(
            PotHolderBlockEntity::new,
            BLACK_POT_HOLDER_BLOCK.get(),
            BLUE_POT_HOLDER_BLOCK.get(),
            BROWN_POT_HOLDER_BLOCK.get(),
            CYAN_POT_HOLDER_BLOCK.get(),
            GRAY_POT_HOLDER_BLOCK.get(),
            GREEN_POT_HOLDER_BLOCK.get(),
            LIGHT_BLUE_POT_HOLDER_BLOCK.get(),
            LIGHT_GRAY_POT_HOLDER_BLOCK.get(),
            LIME_POT_HOLDER_BLOCK.get(),
            MAGENTA_POT_HOLDER_BLOCK.get(),
            ORANGE_POT_HOLDER_BLOCK.get(),
            PINK_POT_HOLDER_BLOCK.get(),
            PURPLE_POT_HOLDER_BLOCK.get(),
            RED_POT_HOLDER_BLOCK.get(),
            YELLOW_POT_HOLDER_BLOCK.get(),
            WHITE_POT_HOLDER_BLOCK.get()
        ).build(null)
    );
}
