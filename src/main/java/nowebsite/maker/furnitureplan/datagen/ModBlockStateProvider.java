package nowebsite.maker.furnitureplan.datagen;

import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.client.model.generators.VariantBlockStateBuilder;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import nowebsite.maker.furnitureplan.FurniturePlan;
import nowebsite.maker.furnitureplan.blocks.func.*;
import nowebsite.maker.furnitureplan.registry.BlockRegistration;
import nowebsite.maker.furnitureplan.registry.FoldingRegistration;
import nowebsite.maker.furnitureplan.utils.ModelSR;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ModBlockStateProvider extends BlockStateProvider {
    public final ExistingFileHelper HELPER;

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper helper) {
        super(output, FurniturePlan.MOD_ID, helper);
        this.HELPER = helper;
    }

    protected void registerStatesAndModels() {
        BlockRegistration.BLOCKS.getEntries().forEach(blockRegistryObject -> {
            Block type = blockRegistryObject.get();
            String name = keyName(type);
            if (type instanceof ILocalDefine define){
                if (hasProperties(type)) {
                    registerEnumWithMultiStateBlock(
                        type,
                        define.textureKey(),
                        textureSwitch(define, name),
                        fromModSource(define.parentName()));
                } else if (type instanceof ISimpleBlock simpleBlock) {
                    simpleBlock(type, models().singleTexture(
                        name,
                        fromModSource(simpleBlock.parentName()),
                        simpleBlock.textureKey(),
                        textureSwitch(simpleBlock, name)
                    ));
                } else if (type instanceof IHorizontalBlock horizontalBlock){
                    horizontalBlock(type, models().singleTexture(
                        name,
                        fromModSource(horizontalBlock.parentName()),
                        horizontalBlock.textureKey(),
                        textureSwitch(horizontalBlock, name)
                    ));
                }
            } else if (type instanceof FlowerBlock) {
                simpleBlock(type, models().singleTexture(
                    name,
                    modLoc("grass_cul"),
                    "cross",
                    fromModSource("grass_grass")
                ));
            }
        });
    }

    private record Result(VariantBlockStateBuilder.PartialBlockstate build, int xRot, int yRot, boolean flag) {}
    public <T extends Comparable<T>> void registerStateWithProperties(List<Property<T>> propertyList, VariantBlockStateBuilder builder, Block block, String key, ResourceLocation texture, ResourceLocation model){
        List<List<T>> probableValues = generateCombinations(propertyList);

        ModelFile modelFile = models()
                .withExistingParent(name(block), model)
                .texture(key, texture);

        for (List<T> currentPropertyList : probableValues) {
            VariantBlockStateBuilder.PartialBlockstate build = builder.partialState();

            Result result = generateBases(propertyList, currentPropertyList, build, 0);

            ConfiguredModel.Builder<VariantBlockStateBuilder> endOfBuildSingle= result.build().modelForState().modelFile(modelFile);
            if (result.flag()) endOfBuildSingle = endOfBuildSingle.rotationY((result.yRot() +180) % 360).rotationX(result.xRot()).uvLock(((result.yRot() +180) % 360 != 0 || result.xRot() != 0) && (block instanceof IUVLockedBlock));
            endOfBuildSingle.addModel();
        }
    }


    @SuppressWarnings({"unused", "unchecked"})
    public <T extends Comparable<T>, M extends Enum<M> & ModelSR> void registerEnumWithMultiStateBlock(Block block, String key, ResourceLocation texture, ResourceLocation probableModel) {
        VariantBlockStateBuilder builder = getVariantBuilder(block);

        /*Change all properties into every possible list*/
        List<Property<T>> propertyList= new ArrayList<>(block.defaultBlockState().getProperties().stream().map(property -> (Property<T>) property).toList());

        Property<T> tmp = propertyList.get(0);

        int currentManagedProp = doModelSRCheck(propertyList, block);

        if (currentManagedProp == -1) {
            registerStateWithProperties(propertyList, builder, block, key, texture, probableModel);
            return;
        }

        propertyList.set(0, propertyList.get(currentManagedProp));
        propertyList.set(currentManagedProp, tmp);

        List<List<T>> probableValues = generateCombinations(propertyList);

        /*Build for every list's value.*/
        for (List<T> currentPropertyList : probableValues) {
            M nowFirst = (M) currentPropertyList.get(0);
            EnumProperty<M> modelProperty = (EnumProperty<M>) propertyList.get(0);

            ModelFile modelFile = models()
                    .withExistingParent(name(block) + "_" + nowFirst.getSerializedName(), nowFirst.getModel(block))
                    .texture(key, nowFirst.getTexture() == null ? texture : nowFirst.getTexture());

            VariantBlockStateBuilder.PartialBlockstate build = builder.partialState().with(modelProperty, nowFirst);

            Result result = generateBases(propertyList, currentPropertyList, build, 1);

            ConfiguredModel.Builder<VariantBlockStateBuilder> endOfBuildSingle= result.build().modelForState().modelFile(modelFile);
            if (result.flag()) endOfBuildSingle = endOfBuildSingle.rotationY((result.yRot() +180) % 360).rotationX(result.xRot()).uvLock(((result.yRot() +180) % 360 != 0 || result.xRot() != 0) && (block instanceof IUVLockedBlock));
            endOfBuildSingle.addModel();
        }
    }

    @Contract("_, _, _, _ -> new")
    @NotNull
    private static <T extends Comparable<T>> Result generateBases(List<Property<T>> propertyList, @NotNull List<T> currentPropertyList, VariantBlockStateBuilder.PartialBlockstate build, int startPoint) {
        int xRot = 0, yRot = 0;
        boolean flag = false;

        for (int j = startPoint; j < currentPropertyList.size(); j++) {
            Property<T> valueProperty = propertyList.get(j);
            T value = currentPropertyList.get(j);
            if (value instanceof Direction direction) {
                flag = true;
                if (direction.equals(Direction.UP)) xRot = 180;
                switch (direction){
                    case NORTH -> yRot = 180;
                    case EAST -> yRot = 270;
                    case WEST -> yRot = 90;
                }
            }
            build = build.with(valueProperty, value);
        }
        return new Result(build, xRot, yRot, flag);
    }


    private static <T extends Comparable<T>> @NotNull List<List<T>> generateCombinations(List<Property<T>> source){
        List<List<T>> result = new ArrayList<>();
        generateCombinations(source, result, 0);
        return result;
    }
    @SafeVarargs
    private static <T extends Comparable<T>> void generateCombinations(@NotNull List<Property<T>> source, List<List<T>> result, int floor, T ...values){
        Property<T> property = source.get(floor);
        for (T value: property.getPossibleValues()) {
            T[] listNew = Arrays.copyOf(values, values.length + 1);
            listNew[values.length] =  value;
            if (floor < source.size() - 1) generateCombinations(source, result, floor + 1, listNew);
            else result.add(new ArrayList<>(Arrays.asList(listNew)));
        }
    }

    public static ResourceLocation key(Block b) {
        return BuiltInRegistries.BLOCK.getKey(b);
    }
    public static String keyName(Block b){
        return key(b).toString();
    }
    public static String name(Block b) {return key(b).getPath();}
    public ResourceLocation forVanillaVariety(@NotNull String registryName, String specificNameEnd){
        return mcLoc("block/" + FoldingRegistration.PROPERTY_KINDS.get(registryName.split("_"+specificNameEnd)[0].split(FurniturePlan.MOD_ID+":")[1]));
    }
    public ResourceLocation fromVanillaSource(String name){
        return mcLoc("block/" + name);
    }
    public ResourceLocation fromModSource(String name){
        return modLoc("block/" + name);
    }
    public ResourceLocation textureSwitch(ILocalDefine block, String registeredName){
        return block instanceof IVarietyBlock varietyBlock
            ? forVanillaVariety(registeredName, varietyBlock.getSpecificName())
            : block.fromVanilla()
            ? fromVanillaSource(block.textureName())
            : block instanceof IColorfulBlock colorfulBlock
            ? colorfulBlock.getConcreteTextureByID()
            : fromModSource(block.textureName());
    }
    @SuppressWarnings("unchecked")
    public static <T extends Comparable<T>> boolean hasProperties(@NotNull Block block) {
        return !block.defaultBlockState().getProperties().stream().map(property -> (Property<T>) property).toList().isEmpty();
    }

    @SuppressWarnings("unchecked")
    public static <T extends Comparable<T>, M extends Enum<M> & ModelSR> int doModelSRCheck(@NotNull List<Property<T>> propertyList, Block block) {
        int currentManagedProp = 0;
        for (int i = 0; i < propertyList.size(); i++){
            try {
                EnumProperty<M> test = (EnumProperty<M>) propertyList.get(i);
                test.getPossibleValues().forEach(m -> m.getModel(block));
                currentManagedProp = i;
                break;
            } catch (Exception ignore){}
            if (i == propertyList.size() - 1) currentManagedProp = -1;
        }
        return currentManagedProp;
    }
}