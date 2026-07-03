package nowebsite.maker.furnitureplan.common.data.gen;

import com.mojang.datafixers.util.Pair;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;
import nowebsite.maker.furnitureplan.FurniturePlan;
import nowebsite.maker.furnitureplan.common.data.gen.empowered.BlockDataGenerator;
import nowebsite.maker.furnitureplan.common.init.FPBlockReg;
import nowebsite.maker.furnitureplan.utils.ICustomModelInfo;
import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * 目标端: 仅客户端
 * 数据生成: 方块模型Model、方块状态BlockState、物品模型Model
 */
public class FPModelProvider extends ModelProvider {
    private final PackOutput output;

    public FPModelProvider(PackOutput output) {
        super(output, FurniturePlan.MOD_ID);
        this.output = output;
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        simpleHorizontalBlockWithItem(FPBlockReg.IRON_POT_BLOCK.get(), blockModels);
        simpleBlockWithItem(FPBlockReg.LANTERN_BLOCK_P1.get(), blockModels);
        simpleBlockWithItem(FPBlockReg.LANTERN_BLOCK_P2.get(), blockModels);
        customModelBlockWithItem(FPBlockReg.TABLE_LAMP_BLOCK.get(), blockModels);
        simpleBlockWithItem(FPBlockReg.GRASS_GRASS.get(), blockModels);
        blockModels.createNonTemplateModelBlock(FPBlockReg.STOVE_BLOCK.get());
        blockModels.createNonTemplateModelBlock(FPBlockReg.WATER_DISPENSER.get());
        blockModels.createNonTemplateModelBlock(FPBlockReg.BOTTLE.get());
        simpleHorizontalBlockWithItem(FPBlockReg.CUTLERY_BLOCK.get(), blockModels, "cutlery_handing", itemModels);
        simpleBlockWithItem(FPBlockReg.GLASS_B_BLOCK.get(), blockModels);
        horizontalCustomModelBlockWithItem(FPBlockReg.FOOD_PLATE_BLOCK.get(), blockModels, false);
        blockModels.createNonTemplateModelBlock(FPBlockReg.CABINET.get());
        FPDataGenerators.GENERATORS.forEach((block, blockDataGenerator) -> invokeGenerator(block, blockDataGenerator, blockModels, itemModels));
    }

    @SuppressWarnings("unchecked")
    private <T extends Block> void  invokeGenerator(Block block, BlockDataGenerator<?> generator, BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        BlockDataGenerator<T> typeGenerator = (BlockDataGenerator<T>) generator;
        typeGenerator.buildModelWithTemplate((T) block, blockModels, itemModels, output);
    }

    public static void simpleBlockWithItem(Block block, BlockModelGenerators generators) {
        MultiVariant model = BlockModelGenerators.plainVariant(TexturedModel.createDefault(
            block1 -> new TextureMapping()
                .put(TextureSlot.PARTICLE, TextureMapping.getBlockTexture(block1)),
            new ModelTemplate(
                Optional.of(getFromTemplate(getName(block))),
                Optional.empty(),
                TextureSlot.PARTICLE
            )).create(block, generators.modelOutput)
        );
        MultiVariantGenerator variant = MultiVariantGenerator.dispatch(block, model);
        generators.blockStateOutput.accept(variant);
    }

    public static void simpleHorizontalBlockWithItem(Block block, BlockModelGenerators generators) {
        generators.createHorizontallyRotatedBlock(block, TexturedModel.createDefault(
            block1 -> new TextureMapping()
                .put(TextureSlot.PARTICLE, TextureMapping.getBlockTexture(block1)),
            new ModelTemplate(
                Optional.of(getFromTemplate(getName(block))),
                Optional.empty(),
                TextureSlot.PARTICLE
            )
        ));
        generators.registerSimpleItemModel(block, getKey(block).withPrefix("block/"));
    }
    public static void simpleHorizontalBlockWithItem(Block block, BlockModelGenerators generators, String itemModelName, ItemModelGenerators itemModel) {
        generators.createHorizontallyRotatedBlock(block, TexturedModel.createDefault(
            block1 -> new TextureMapping()
                .put(TextureSlot.PARTICLE, TextureMapping.getBlockTexture(block1)),
            new ModelTemplate(
                Optional.of(getFromTemplate(getName(block))),
                Optional.empty(),
                TextureSlot.PARTICLE
            )
        ));
        generators.registerSimpleItemModel(block, TexturedModel.createDefault(
            _ -> new TextureMapping(),
            new ModelTemplate(
                Optional.of(FurniturePlan.asResource("item/"+itemModelName)),
                Optional.empty()
            )).createWithSuffix(block, "_item", itemModel.modelOutput));
    }

    @SuppressWarnings("unchecked")
    public static <T extends Comparable<T>, M extends Enum<M> & ICustomModelInfo> void customModelBlockWithItem(Block block, BlockModelGenerators generators) {
        List<Property<@NotNull T>> properties = block.defaultBlockState().getProperties().stream().map(property -> (Property<@NotNull T>) property).toList();

        Property<@NotNull M> modelProp = doModelSRCheck(properties, block);
        PropertyDispatch.C1<MultiVariant, @NotNull M> dispatch = PropertyDispatch.initial(modelProp);
        modelProp.getPossibleValues().stream()
            .map(modelInfo -> new Pair<>(modelInfo, BlockModelGenerators.plainVariant(modelInfo.getModel(block))))
            .forEach(pair -> dispatch.select(pair.getFirst(), pair.getSecond()));

        MultiVariantGenerator variant = MultiVariantGenerator.dispatch(block).with(dispatch);
        generators.blockStateOutput.accept(variant);

        generators.registerSimpleItemModel(block, modelProp.getPossibleValues().getFirst().getModel(block));
    }

    @SuppressWarnings("unchecked")
    public static <T extends Comparable<T>, M extends Enum<M> & ICustomModelInfo> void horizontalCustomModelBlockWithItem(Block block, BlockModelGenerators generators, boolean doLockUV) {
        List<Property<@NotNull T>> properties = block.defaultBlockState().getProperties().stream().map(property -> (Property<@NotNull T>) property).toList();

        Property<@NotNull M> modelProp = doModelSRCheck(properties, block);
        PropertyDispatch.C2<MultiVariant, @NotNull M, @NotNull Direction> dispatch = PropertyDispatch.initial(modelProp, BlockStateProperties.HORIZONTAL_FACING);

        List<Property<@NotNull T>> propertiesSelected = new ArrayList<>();
        propertiesSelected.add((Property<@NotNull T>) modelProp); // It should be here at 1st.
        propertiesSelected.add((Property<@NotNull T>) BlockStateProperties.HORIZONTAL_FACING);

        List<List<T>> propertyCombineResult = new ArrayList<>();
        generateCombinations(propertiesSelected, propertyCombineResult, 0);

        for (List<T> propertyList : propertyCombineResult) {
            ICustomModelInfo info = (ICustomModelInfo) propertyList.getFirst();
            Direction facing = (Direction) propertyList.get(1);
            dispatch.select((M) info, facing, BlockModelGenerators.plainVariant(info.getModel(block)).with(
                switch (facing) {
                    case SOUTH -> BlockModelGenerators.Y_ROT_180;
                    case WEST -> BlockModelGenerators.Y_ROT_270;
                    case EAST -> BlockModelGenerators.Y_ROT_90;
                    default -> BlockModelGenerators.NOP;
                }
            ));
        }

        MultiVariantGenerator variant = MultiVariantGenerator.dispatch(block).with(dispatch);
        if (doLockUV) variant.with(BlockModelGenerators.UV_LOCK);
        generators.blockStateOutput.accept(variant);

        generators.registerSimpleItemModel(block, modelProp.getPossibleValues().getFirst().getModel(block));
    }

    public static Identifier getKey(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block);
    }

    public static String getName(Block block) {
        return getKey(block).getPath();
    }

    public static Identifier getFromTemplate(String name) {
        return FurniturePlan.asResource("block/template/" + name);
    }

    @SuppressWarnings("unchecked")
    public static <T extends Comparable<T>, M extends Enum<M> & ICustomModelInfo> Property<@NotNull M> doModelSRCheck(List<Property<@NotNull T>> propertyList, Block block) {
        for (Property<@NotNull T> tProperty : propertyList) {
            try {
                EnumProperty<@NotNull M> test = (EnumProperty<@NotNull M>) tProperty;
                test.getPossibleValues().forEach(m -> m.getModel(block));
                return test;
            } catch (Exception ignore) {
            }
        }
        throw new InputMismatchException("Can't access any property list that doesn't contains ICustomModelInfo Enum");
    }
    @SafeVarargs
    public static <T extends Comparable<T>> void generateCombinations(@NotNull List<Property<@NotNull T>> source, List<List<T>> result, int floor, T... values){
        Property<@NotNull T> property = source.get(floor);
        for (T value: property.getPossibleValues()) {
            T[] listNew = Arrays.copyOf(values, values.length + 1);
            listNew[values.length] =  value;
            if (floor < source.size() - 1) generateCombinations(source, result, floor + 1, listNew);
            else result.add(new ArrayList<>(Arrays.asList(listNew)));
        }
    }
}
