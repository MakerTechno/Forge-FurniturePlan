package nowebsite.maker.furnitureplan.common.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import nowebsite.maker.furnitureplan.FurniturePlan;
import nowebsite.maker.furnitureplan.common.block.abstraction.definition.*;
import nowebsite.maker.furnitureplan.common.block.abstraction.set.FPBlockSet;
import nowebsite.maker.furnitureplan.common.block.abstraction.set.FPBlockSetType;
import nowebsite.maker.furnitureplan.common.block.cooking.utensils.IronPotBlock;
import nowebsite.maker.furnitureplan.common.block.cooking.utensils.entities.IronPotBlockEntity;
import nowebsite.maker.furnitureplan.common.block.seating.entity.BenchBlockEntity;
import nowebsite.maker.furnitureplan.common.block.seating.entity.ChairBlockEntity;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class FPBlockReg {
    public static void touch() {

    }

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(FurniturePlan.MOD_ID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, FurniturePlan.MOD_ID);

    public static final DeferredBlock<@NotNull IronPotBlock> IRON_POT_BLOCK = BLOCKS.register("iron_pot", name -> new IronPotBlock(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, name))));
    public static final DeferredItem<@NotNull BlockItem> IRON_POT_ITEM = FPItemReg.ITEMS.registerSimpleBlockItem(IRON_POT_BLOCK);
    public static final DeferredHolder<BlockEntityType<?>, @NotNull BlockEntityType<@NotNull IronPotBlockEntity>> IRON_POT_BE = BLOCK_ENTITIES.register(
        "iron_pot",
        () -> new BlockEntityType<>(IronPotBlockEntity::new, IRON_POT_BLOCK.get())
    );

    public static final Set<FPBlockSet> AUTO_FURNITURE_SET = new HashSet<>();
    static {
        FPBlockSetType.TYPES.forEach(type -> {
            AUTO_FURNITURE_SET.add(new FPBlockSet.Builder(type, type.getBase(), type.shouldCopyAll()).build());
        });
    }

    public static final DeferredHolder<BlockEntityType<?>, @NotNull BlockEntityType<@NotNull ChairBlockEntity>> CHAIR_BLOCK_ENTITY = BLOCK_ENTITIES.register(
        "chair_block_entity",
        () -> new BlockEntityType<>(
            ChairBlockEntity::new,
            AUTO_FURNITURE_SET.stream().map(set -> set.CHAIR.get()).collect(Collectors.toSet())
        )
    );
    public static final DeferredHolder<BlockEntityType<?>, @NotNull BlockEntityType<@NotNull BenchBlockEntity>> BENCH_BLOCK_ENTITY = BLOCK_ENTITIES.register(
        "bench_block_entity",
        () -> new BlockEntityType<>(
            BenchBlockEntity::new,
            AUTO_FURNITURE_SET.stream().map(set -> set.BENCH.get()).collect(Collectors.toSet())
        )
    );



    public static <B extends Block> DeferredBlock<B> registerWithItem(String id, Supplier<B> block) {
        return registerWithItem(id, block, new Item.Properties());
    }

    public static <B extends Block> DeferredBlock<B> registerWithItem(String id, Supplier<B> block, Function<B, BlockItem> item) {
        DeferredBlock<B> object = BLOCKS.register(id, block);
        FPItemReg.ITEMS.register(id, () -> item.apply(object.get()));
        return object;
    }

    public static <B extends Block> DeferredBlock<B> registerWithItem(String id, Supplier<B> block, Item.Properties properties) {
        DeferredBlock<B> object = BLOCKS.register(id, block);
        FPItemReg.ITEMS.registerSimpleBlockItem(object, () -> properties);
        return object;
    }

    public static <B extends Block> DeferredBlock<B> registerWithoutItem(String id, Supplier<B> block) {
        return BLOCKS.register(id, block);
    }
    public static ToIntFunction<BlockState> litBlockEmission(int lightValue) {
        return blockState -> blockState.getValue(BlockStateProperties.LIT) ? lightValue : 0;
    }

    public static final class BlockStateReg {
        public static void init(){}

        public static final EnumProperty<@NotNull PlateShape> PLATE_SHAPE = EnumProperty.create("shape", PlateShape.class);
        public static final EnumProperty<@NotNull StoveShape> STOVE_SHAPE = EnumProperty.create("shape", StoveShape.class);
        public static final EnumProperty<@NotNull TableShape> TABLE_SHAPE = EnumProperty.create("shape", TableShape.class);
        public static final EnumProperty<@NotNull ColumnShape> COLUMN_SHAPE = EnumProperty.create("shape", ColumnShape.class);
        public static final EnumProperty<@NotNull TableLampShape> TABLE_LAMP_SHAPE = EnumProperty.create("shape", TableLampShape.class);
        public static final EnumProperty<@NotNull PotHolderPart> POT_HOLDER_PART = EnumProperty.create("part", PotHolderPart.class);
        public static final EnumProperty<@NotNull BottleDefine> BOTTLE_DEFINE = EnumProperty.create("define", BottleDefine.class);
    }

}
