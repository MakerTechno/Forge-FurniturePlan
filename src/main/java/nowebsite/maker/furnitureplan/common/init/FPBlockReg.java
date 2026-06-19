package nowebsite.maker.furnitureplan.common.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
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
import net.neoforged.neoforge.registries.DeferredRegister;
import nowebsite.maker.furnitureplan.FurniturePlan;
import nowebsite.maker.furnitureplan.common.block.abstraction.definition.*;
import nowebsite.maker.furnitureplan.common.block.abstraction.set.FPBlockSet;
import nowebsite.maker.furnitureplan.common.block.abstraction.set.FPBlockSetType;
import nowebsite.maker.furnitureplan.common.block.cooking.utensils.IronPotBlock;
import nowebsite.maker.furnitureplan.common.block.cooking.utensils.entities.IronPotBlockEntity;
import nowebsite.maker.furnitureplan.common.block.decorating.LanternBlock;
import nowebsite.maker.furnitureplan.common.block.decorating.TableLampBlock;
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

    public static final DeferredBlock<@NotNull IronPotBlock> IRON_POT_BLOCK = registerWithItem("iron_pot", name -> new IronPotBlock(BlockBehaviour.Properties.of().setId(getId(name))));
    public static final DeferredHolder<BlockEntityType<?>, @NotNull BlockEntityType<@NotNull IronPotBlockEntity>> IRON_POT_BE = BLOCK_ENTITIES.register(
        "iron_pot",
        () -> new BlockEntityType<>(IronPotBlockEntity::new, IRON_POT_BLOCK.get())
    );

    public static final DeferredBlock<@NotNull LanternBlock> LANTERN_BLOCK_P1 = registerWithItem("lantern_pattern_1", name -> new LanternBlock(BlockBehaviour.Properties.of().setId(getId(name))));
    public static final DeferredBlock<@NotNull LanternBlock> LANTERN_BLOCK_P2 = registerWithItem("lantern_pattern_2", name -> new LanternBlock(BlockBehaviour.Properties.of().setId(getId(name))));
    public static final DeferredBlock<@NotNull TableLampBlock> TABLE_LAMP_BLOCK = registerWithItem("table_lamp", name -> new TableLampBlock(BlockBehaviour.Properties.of().setId(getId(name))));

    public static final Set<FPBlockSet> AUTO_FURNITURE_SET = new HashSet<>(FPBlockSetType.TYPES.stream().map(type -> new FPBlockSet.Builder(type, type.getBase(), type.shouldCopyAll()).build()).collect(Collectors.toSet()));

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



    public static <B extends Block> DeferredBlock<B> registerWithItem(String id, Function<Identifier, B> block) {
        return registerWithItem(id, block, new Item.Properties());
    }

    public static <B extends Block> DeferredBlock<B> registerWithItem(String id, Function<Identifier, B> block, Function<B, BlockItem> item) {
        DeferredBlock<B> object = BLOCKS.register(id, block);
        FPItemReg.ITEMS.register(id, () -> item.apply(object.get()));
        return object;
    }

    public static <B extends Block> DeferredBlock<B> registerWithItem(String id, Function<Identifier, B> block, Item.Properties properties) {
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

    private static @NotNull ResourceKey<Block> getId(Identifier name) {
        return ResourceKey.create(Registries.BLOCK, name);
    }

    public static final class BlockStateReg {
        public static void init(){}

        public static final EnumProperty<@NotNull TableShape> TABLE_SHAPE = EnumProperty.create("shape", TableShape.class);
        public static final EnumProperty<@NotNull TableLampShape> TABLE_LAMP_SHAPE = EnumProperty.create("shape", TableLampShape.class);
        public static final EnumProperty<@NotNull PotHolderPart> POT_HOLDER_PART = EnumProperty.create("part", PotHolderPart.class);
        public static final EnumProperty<@NotNull BottleDefine> BOTTLE_DEFINE = EnumProperty.create("define", BottleDefine.class);
    }

}
