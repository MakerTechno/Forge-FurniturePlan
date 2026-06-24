package nowebsite.maker.furnitureplan.common.init;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.SuspiciousStewEffects;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
import net.minecraft.world.item.equipment.ArmorMaterials;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import nowebsite.maker.furnitureplan.FurniturePlan;
import nowebsite.maker.furnitureplan.common.block.abstraction.definition.*;
import nowebsite.maker.furnitureplan.common.block.abstraction.set.FPBlockSet;
import nowebsite.maker.furnitureplan.common.block.abstraction.set.FPBlockSetType;
import nowebsite.maker.furnitureplan.common.block.abstraction.set.FPColorfulSetType;
import nowebsite.maker.furnitureplan.common.block.cooking.utensils.IronPotBlock;
import nowebsite.maker.furnitureplan.common.block.cooking.utensils.entities.IronPotBlockEntity;
import nowebsite.maker.furnitureplan.common.block.decorating.LanternBlock;
import nowebsite.maker.furnitureplan.common.block.decorating.TableLampBlock;
import nowebsite.maker.furnitureplan.common.block.decorating.columns.CarvedColumnBlock;
import nowebsite.maker.furnitureplan.common.block.decorating.columns.ColumnBlock;
import nowebsite.maker.furnitureplan.common.block.decorating.columns.LightedColumnBlock;
import nowebsite.maker.furnitureplan.common.block.seating.BenchBlock;
import nowebsite.maker.furnitureplan.common.block.seating.ChairBlock;
import nowebsite.maker.furnitureplan.common.block.seating.entity.BenchBlockEntity;
import nowebsite.maker.furnitureplan.common.block.seating.entity.ChairBlockEntity;
import nowebsite.maker.furnitureplan.common.block.storaging.CupboardBlock;
import nowebsite.maker.furnitureplan.common.block.storaging.entity.CupboardBlockEntity;
import nowebsite.maker.furnitureplan.common.block.surfacing.PotHolderBlock;
import nowebsite.maker.furnitureplan.common.block.surfacing.TableBlock;
import nowebsite.maker.furnitureplan.common.block.surfacing.entity.PotHolderBlockEntity;
import nowebsite.maker.furnitureplan.common.item.IronPotItem;
import org.apache.logging.log4j.util.Lazy;
import org.jetbrains.annotations.NotNull;
import oshi.util.tuples.Pair;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class FPBlockReg {
    public static void touch() {

    }

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(FurniturePlan.MOD_ID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, FurniturePlan.MOD_ID);

    public static final DeferredBlock<@NotNull IronPotBlock> IRON_POT_BLOCK = BLOCKS.register("iron_pot", name -> new IronPotBlock(BlockBehaviour.Properties.of().setId(getId(name)).sound(SoundType.ANVIL)));
    public static final DeferredItem<@NotNull IronPotItem> IRON_POT_ITEM = FPItemReg.ITEMS.register("iron_pot", name -> new IronPotItem(IRON_POT_BLOCK.get(), new Item.Properties().setId(getItemId(name))));
    public static final DeferredHolder<BlockEntityType<?>, @NotNull BlockEntityType<@NotNull IronPotBlockEntity>> IRON_POT_BE = BLOCK_ENTITIES.register(
        "iron_pot",
        () -> new BlockEntityType<>(IronPotBlockEntity::new, IRON_POT_BLOCK.get())
    );

    public static final DeferredBlock<@NotNull LanternBlock> LANTERN_BLOCK_P1 = registerWithItem("lantern_pattern_1", name -> new LanternBlock(BlockBehaviour.Properties.of().setId(getId(name))));
    public static final DeferredBlock<@NotNull LanternBlock> LANTERN_BLOCK_P2 = registerWithItem("lantern_pattern_2", name -> new LanternBlock(BlockBehaviour.Properties.of().setId(getId(name))));
    public static final DeferredBlock<@NotNull TableLampBlock> TABLE_LAMP_BLOCK = registerWithItem("table_lamp", name -> new TableLampBlock(BlockBehaviour.Properties.of().setId(getId(name))));


    public static final DeferredHolder<Block, Block> STOVE_BLOCK = BLOCKS.register("stove_block", name -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).strength(3.0F).requiresCorrectToolForDrops().sound(SoundType.STONE).setId(getId(name))));
    public static final DeferredHolder<Item, Item> STOVE_BLOCK_ITEM = FPItemReg.ITEMS.register("stove_block", name -> new BlockItem(STOVE_BLOCK.get(), new Item.Properties().setId(getItemId(name))));

    public static final DeferredHolder<Block, Block> WATER_DISPENSER = BLOCKS.register("water_dispenser", name -> new Block(BlockBehaviour.Properties.of().setId(getId(name))));
    public static final DeferredHolder<Item, Item> WATER_DISPENSER_ITEM = FPItemReg.ITEMS.register("water_dispenser", name -> new BlockItem(WATER_DISPENSER.get(), new Item.Properties().setId(getItemId(name))));

    public static final DeferredHolder<Block, Block> BOTTLE = BLOCKS.register("water_bottle", name -> new Block(BlockBehaviour.Properties.of().noOcclusion().setId(getId(name))));
    public static final DeferredHolder<Item, Item> BOTTLE_ITEM = FPItemReg.ITEMS.register("water_bottle", name -> new BlockItem(BOTTLE.get(), new Item.Properties().setId(getItemId(name))));

    /*For tableware*/
    public static final DeferredHolder<Block, Block> CUTLERY_BLOCK = BLOCKS.register("cutlery_block", name -> new Block(getSmallBlockBehaviors().sound(SoundType.STONE).setId(getId(name))));
    public static final DeferredHolder<Item, Item> CUTLERY_ITEM = FPItemReg.ITEMS.register("cutlery_block", name -> new BlockItem(CUTLERY_BLOCK.get(), new Item.Properties().stacksTo(16).setId(getItemId(name))));
    public static final DeferredHolder<Block, Block> GLASS_B_BLOCK = BLOCKS.register("glass_b_block", name -> new Block(getSmallBlockBehaviors().sound(SoundType.GLASS).setId(getId(name))));
    /*public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<GlassBBlockEntity>> GLASS_B_BLOCK_ENTITY = BLOCK_ENTITIES.register(
        "glass_b_block_entity",
        () -> BlockEntityType.Builder.of(GlassBBlockEntity::new, GLASS_B_BLOCK.get()).build(null)
    );*/
    public static final DeferredHolder<Item, Item> GLASS_B_BLOCK_ITEM = FPItemReg.ITEMS.register("glass_b_block", name -> new BlockItem(GLASS_B_BLOCK.get(), new Item.Properties().stacksTo(2).setId(getItemId(name))));

    public static final DeferredHolder<Block, Block> FOOD_PLATE_BLOCK = BLOCKS.register("food_plate_block", name -> new Block(getSmallBlockBehaviors().sound(SoundType.GLASS).setId(getId(name))));
    /*public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<FoodPlateBlockEntity>> FOOD_PLATE_BLOCK_ENTITY = BLOCK_ENTITIES.register(
        "food_plate_block_entity",
        () -> BlockEntityType.Builder.of(FoodPlateBlockEntity::new, FOOD_PLATE_BLOCK.get()).build(null)
    );*/
    public static final DeferredHolder<Item, Item> FOOD_PLATE_BLOCK_ITEM = FPItemReg.ITEMS.register("plate", name -> new BlockItem(FOOD_PLATE_BLOCK.get(), new Item.Properties().stacksTo(16).setId(getItemId(name))));
    public static final DeferredHolder<Block, Block> CABINET = registerWithItem("cabinet", name -> new Block(getSmallBlockBehaviors().sound(SoundType.GLASS).setId(getId(name))));

    public static final List<FPBlockSet> AUTO_FURNITURE_SET = FPBlockSetType.TYPES.stream().map(type -> new FPBlockSet.Builder(type, type.getBase(), type.shouldCopyAll()).build()).toList();
    public static final Lazy<List<ChairBlock>> CHAIRS = Lazy.lazy(() -> AUTO_FURNITURE_SET.stream().map(set -> set.CHAIR.get()).toList());
    public static final Lazy<List<BenchBlock>> BENCHES = Lazy.lazy(() -> AUTO_FURNITURE_SET.stream().map(set -> set.BENCH.get()).toList());
    public static final Lazy<List<ColumnBlock>> COLUMNS = Lazy.lazy(() -> AUTO_FURNITURE_SET.stream().map(set -> set.COLUMN.get()).toList());
    public static final Lazy<List<CarvedColumnBlock>> CARVED_COLUMNS = Lazy.lazy(() -> AUTO_FURNITURE_SET.stream().map(set -> set.CARVED_COLUMN.get()).toList());
    public static final Lazy<List<LightedColumnBlock>> LIGHTED_COLUMNS = Lazy.lazy(() -> AUTO_FURNITURE_SET.stream().map(set -> set.LIGHTED_COLUMN.get()).toList());
    public static final Lazy<List<TableBlock>> TABLES = Lazy.lazy(() -> AUTO_FURNITURE_SET.stream().map(set -> set.TABLE.get()).toList());

    public static final Lazy<List<PotHolderBlock>> POT_HOLDERS = Lazy.lazy(() -> FPBlockReg.AUTO_FURNITURE_SET.stream()
        .filter(set -> set.materialType instanceof FPColorfulSetType)
        .map(set -> set.POT_HOLDER.get())
        .toList()
    );
    public static final Lazy<List<CupboardBlock>> CUPBOARDS = Lazy.lazy(() -> AUTO_FURNITURE_SET.stream().map(set -> set.CUPBOARD.get()).toList());

    public static final Lazy<FPBlockSet> OXIDIZED_COPPERS = Lazy.lazy(() -> FPBlockReg.AUTO_FURNITURE_SET.stream()
        .filter(set -> set.materialType.equals(FPBlockSetTypes.OXIDIZED_CUT_COPPER_SET))
        .findFirst().orElse(null));
    public static final Lazy<FPBlockSet> WEATHERED_COPPERS = Lazy.lazy(() -> FPBlockReg.AUTO_FURNITURE_SET.stream()
        .filter(set -> set.materialType.equals(FPBlockSetTypes.WEATHERED_CUT_COPPER_SET))
        .findFirst().orElse(null));
    public static final Lazy<FPBlockSet> EXPOSED_COPPERS = Lazy.lazy(() -> FPBlockReg.AUTO_FURNITURE_SET.stream()
        .filter(set -> set.materialType.equals(FPBlockSetTypes.EXPOSED_CUT_COPPER_SET))
        .findFirst().orElse(null));
    public static final Lazy<FPBlockSet> CUT_COPPERS = Lazy.lazy(() -> FPBlockReg.AUTO_FURNITURE_SET.stream()
        .filter(set -> set.materialType.equals(FPBlockSetTypes.CUT_COPPER_SET))
        .findFirst().orElse(null));

    public static final DeferredHolder<Block,@NotNull Block> GRASS_GRASS = BLOCKS.register("grass_grass",
        name -> new FlowerBlock(
            makeEffectList(
                new Pair<>(MobEffects.DARKNESS, 2F)
            ) ,
            BlockBehaviour.Properties.of()
                .setId(getId(name))
                .mapColor(MapColor.PLANT)
                .noCollision()
                .instabreak()
                .sound(SoundType.GRASS)
                .offsetType(BlockBehaviour.OffsetType.XZ)
                .pushReaction(PushReaction.DESTROY)
        )
    );
    public static final Consumable GRASS_EFFECT = Consumable.builder()
        .onConsume(
            new ApplyStatusEffectsConsumeEffect(
                List.of(new MobEffectInstance(MobEffects.DARKNESS, 200, 255), new MobEffectInstance(MobEffects.SPEED, 200, 5))
            )
        )
        .build();
    public static final DeferredHolder<Item, @NotNull Item> GRASS_GRASS_ITEM = FPItemReg.ITEMS.register("grass_grass", name -> new BlockItem(
        GRASS_GRASS.get(),
        new Item.Properties().food(
            new FoodProperties.Builder()
                .nutrition(2)
                .saturationModifier(0.1F)
                .build(),
            GRASS_EFFECT
        )
            .setId(getItemId(name))
            .humanoidArmor(ArmorMaterials.LEATHER, ArmorType.HELMET)
            .humanoidArmor(ArmorMaterials.LEATHER, ArmorType.BODY)
            .humanoidArmor(ArmorMaterials.LEATHER, ArmorType.CHESTPLATE)
            .humanoidArmor(ArmorMaterials.LEATHER, ArmorType.BOOTS)
    ) {
        @SuppressWarnings("deprecation")
        @Override
        public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
            super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
            builder.accept(Component.translatable("item.furnitureplan.grass_grass.desc"));
        }
    });
    public static final DeferredHolder<BlockEntityType<?>, @NotNull BlockEntityType<@NotNull ChairBlockEntity>> CHAIR_BLOCK_ENTITY = BLOCK_ENTITIES.register(
        "chair_block_entity",
        () -> new BlockEntityType<>(
            ChairBlockEntity::new,
            new HashSet<>(CHAIRS.get())
        )
    );
    public static final DeferredHolder<BlockEntityType<?>, @NotNull BlockEntityType<@NotNull BenchBlockEntity>> BENCH_BLOCK_ENTITY = BLOCK_ENTITIES.register(
        "bench_block_entity",
        () -> new BlockEntityType<>(
            BenchBlockEntity::new,
            new HashSet<>(BENCHES.get())
        )
    );
    public static final DeferredHolder<BlockEntityType<?>, @NotNull BlockEntityType<@NotNull PotHolderBlockEntity>> POT_HOLDER_BLOCK_ENTITY = BLOCK_ENTITIES.register(
        "pot_holder_block_entity",
        () -> new BlockEntityType<>(
            PotHolderBlockEntity::new,
            new HashSet<>(POT_HOLDERS.get())
        )
    );

    public static final DeferredHolder<BlockEntityType<?>, @NotNull BlockEntityType<@NotNull CupboardBlockEntity>> CUPBOARD_BLOCK_ENTITY = BLOCK_ENTITIES.register(
        "cupboard_block_entity",
        () -> new BlockEntityType<>(
            CupboardBlockEntity::new,
            new HashSet<>(CUPBOARDS.get())
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
    private static @NotNull ResourceKey<Item> getItemId(Identifier name) {
        return ResourceKey.create(Registries.ITEM, name);
    }

    protected static BlockBehaviour.@NotNull Properties getSmallBlockBehaviors(){
        return BlockBehaviour.Properties.of()
            .mapColor(MapColor.NONE)
            .instabreak()
            .pushReaction(PushReaction.DESTROY)
            .strength(0.2f)
            .noOcclusion()
            .noCollision()
            .isRedstoneConductor(FPBlockReg::never)
            .isViewBlocking(FPBlockReg::never);
    }
    @SafeVarargs
    protected static SuspiciousStewEffects makeEffectList(Pair<Holder<MobEffect>, Float> ...effects) {
        List<SuspiciousStewEffects.Entry> suspiciousStewEffects = new ArrayList<>();
        for (Pair<Holder<MobEffect>, Float> effect : effects) {
            suspiciousStewEffects.add(
                new SuspiciousStewEffects.Entry(
                    effect.getA(),
                    Mth.floor(effect.getB() * 20.0F)
                )
            );
        }
        return new SuspiciousStewEffects(suspiciousStewEffects);
    }
    private static <A,B,C> boolean never(A a, B b, C c) {
        return false;
    }

    public static final class BlockStateReg {
        public static void init(){}

        public static final EnumProperty<@NotNull ColumnShape> COLUMN_SHAPE = EnumProperty.create("shape", ColumnShape.class);
        public static final EnumProperty<@NotNull TableShape> TABLE_SHAPE = EnumProperty.create("shape", TableShape.class);
        public static final EnumProperty<@NotNull TableLampShape> TABLE_LAMP_SHAPE = EnumProperty.create("shape", TableLampShape.class);
        public static final EnumProperty<@NotNull PotHolderPart> POT_HOLDER_PART = EnumProperty.create("part", PotHolderPart.class);
        public static final EnumProperty<@NotNull BottleDefine> BOTTLE_DEFINE = EnumProperty.create("define", BottleDefine.class);
        public static final EnumProperty<@NotNull StoveShape> STOVE_SHAPE = EnumProperty.create("define", StoveShape.class);
    }

}
