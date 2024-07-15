package nowebsite.maker.furnitureplan.datagen;

import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.VariantBlockStateBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;
import nowebsite.maker.furnitureplan.FurniturePlan;
import nowebsite.maker.furnitureplan.blocks.columns.CarvedColumnBlock;
import nowebsite.maker.furnitureplan.blocks.columns.ColumnBlock;
import nowebsite.maker.furnitureplan.blocks.columns.LightedColumnBlock;
import nowebsite.maker.furnitureplan.blocks.cookingUtensils.StoveBlock;
import nowebsite.maker.furnitureplan.blocks.singleblockfurniture.ChairBlock;
import nowebsite.maker.furnitureplan.blocks.singleblockfurniture.TableBlock;
import nowebsite.maker.furnitureplan.blocks.tableware.FoodPlateBlock;
import nowebsite.maker.furnitureplan.blocks.tableware.GlassBBlock;
import nowebsite.maker.furnitureplan.registry.BlockRegistration;
import nowebsite.maker.furnitureplan.registry.FoldingRegistration;
import nowebsite.maker.furnitureplan.utils.ModelSR;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InvalidPropertiesFormatException;
import java.util.List;

@SuppressWarnings("deprecation")
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

            if (type instanceof ChairBlock)
                addKindsAsHorizontalBlock(type, name, "chair");
            else if (type instanceof TableBlock) {
                try {
                    registerEnumWithMultiStateBlock(type, "particle", forVanillaSource(name, "table"), true);
                } catch (InvalidPropertiesFormatException e) {
                    FurniturePlan.LOGGER.error(e);
                }
            }
            else if (type instanceof ColumnBlock) {
                if (type instanceof CarvedColumnBlock)
                    addKindsAsSimpleBlock(type, name, "carved_column");
                else if (type instanceof LightedColumnBlock)
                    addKindsAsSimpleBlock(type, name, "lighted_column");
                else
                    addKindsAsSimpleBlock(type, name, "column");
            }
            else if (type instanceof FoodPlateBlock)
                registerEnumWithHorizontalBlock(type, "particle", FoodPlateBlock.SHAPE_DEF);
            else if (type instanceof GlassBBlock)
                simpleBlock(type, models().singleTexture(
                        keyName(type),
                        modLoc("block/glass"), "particle",
                        modLoc("block/glass")
                ));


        });

        horizontalBlock(BlockRegistration.CUTLERY_BLOCK.get(), models().singleTexture(
                keyName(BlockRegistration.CUTLERY_BLOCK.get()),
                modLoc("block/cutlery"), "particle",
                modLoc("block/plate")
        ));
        simpleBlock(BlockRegistration.LANTERN_BLOCK.get(), models().singleTexture(
                keyName(BlockRegistration.LANTERN_BLOCK.get()),
                modLoc("block/lantern"), "particle",
                modLoc("block/lantern")
        ));
        horizontalBlock(BlockRegistration.IRON_POT_BLOCK.get(), models().singleTexture(
                keyName(BlockRegistration.IRON_POT_BLOCK.get()),
                modLoc("block/iron_pot"), "particle",
                modLoc("block/iron_pot")
        ));
        registerEnumWithHorizontalBlock(BlockRegistration.STOVE_BLOCK.get(),
                "particle",
                StoveBlock.SHAPE
        );
        horizontalBlock(BlockRegistration.CUPBOARD_BLOCK.get(), models().singleTexture(
                keyName(BlockRegistration.IRON_POT_BLOCK.get()),
                modLoc("block/cupboard"), "particle",
                modLoc("block/cupboard")
        ));
        simpleBlock(BlockRegistration.VASE_B_BLOCK.get(), models().singleTexture(
                keyName(BlockRegistration.VASE_B_BLOCK.get()),
                modLoc("block/vase"), "particle",
                modLoc("block/vase")
        ));
    }

    public void addKindsAsHorizontalBlock(Block type, String registryName, String specificParentName) {
        horizontalBlock(type, models().singleTexture(
                registryName,
                modLoc("block/" + specificParentName), "particle",
                forVanillaSource(registryName, specificParentName)
        ));
    }
    public void addKindsAsSimpleBlock(Block type, String registryName, String specificParentName) {
        simpleBlock(type, models().singleTexture(
                registryName,
                modLoc("block/" + specificParentName), "particle",
                forVanillaSource(registryName, specificParentName)
        ));
    }

    public  <T extends Enum<T> & ModelSR, R extends EnumProperty<T>> void registerEnumWithHorizontalBlock(
            Block block,
            String key,
            @NotNull R baseKind
    ){
        VariantBlockStateBuilder builder = getVariantBuilder(block);

        for (T type : baseKind.getPossibleValues()) {
            String name = name(block)+ "_"+ type.toString();

            ModelFile modelFile = models()
                    .withExistingParent(name, type.getModel())
                    .texture(key, type.getTexture());

            int i = 0;
            for (Direction d : Direction.values()){
                if (d.equals(Direction.DOWN) || d.equals(Direction.UP)) continue;
                switch (d){
                    case NORTH -> i = 180;
                    case EAST -> i = 270;
                    case SOUTH -> i = 0;
                    case WEST -> i = 90;
                }
                builder.partialState().with(baseKind, type)
                        .with(HorizontalDirectionalBlock.FACING, d)
                        .modelForState()
                        .modelFile(modelFile)
                        .rotationY((i+180) % 360)
                        .addModel();
            }
        }
    }

    @SuppressWarnings({"unused", "unchecked"})
    public <T extends Comparable<T>, M extends Enum<M> & ModelSR> void registerEnumWithMultiStateBlock(Block block, String key, ResourceLocation texture, boolean shouldLockUV) throws InvalidPropertiesFormatException {
        VariantBlockStateBuilder builder = getVariantBuilder(block);

        /*Change all properties into every possible list*/
        List<Property<T>> propertyList= new ArrayList<>(block.defaultBlockState().getProperties().stream().map(property -> (Property<T>) property).toList());

        Property<T> tmp = propertyList.get(0);
        int currentManagedProp = 0;
        for (int i = 0; i < propertyList.size(); i++){
            try {
                EnumProperty<M> test = (EnumProperty<M>) propertyList.get(i);
                test.getPossibleValues().forEach(ModelSR::getModel);
                currentManagedProp = i;
                break;
            } catch (Exception ignore){}
            if (i == propertyList.size() - 1) throw new InvalidPropertiesFormatException("We require at least one ModelSR Property.");
        }

        propertyList.set(0, propertyList.get(currentManagedProp));
        propertyList.set(currentManagedProp, tmp);

        List<List<T>> probableValues = generateCombinations(propertyList);

        /*Build for every list's value.*/
        for (List<T> currentPropertyList : probableValues) {
            M nowFirst = (M) currentPropertyList.get(0);
            EnumProperty<M> modelProperty = (EnumProperty<M>) propertyList.get(0);

            ModelFile modelFile = models()
                    .withExistingParent(name(block) + "_" + nowFirst.getSerializedName(), nowFirst.getModel())
                    .texture(key, texture);

            VariantBlockStateBuilder.PartialBlockstate build = builder.partialState().with(modelProperty, nowFirst);

            int xRot = 0, yRot = 0;
            boolean flag = false;

            for (int j = 1; j < currentPropertyList.size(); j++) {
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

            ConfiguredModel.Builder<VariantBlockStateBuilder> endOfBuildSingle= build.modelForState().modelFile(modelFile);
            if (flag) endOfBuildSingle = endOfBuildSingle.rotationY((yRot+180) % 360).rotationX(xRot).uvLock(((yRot+180) % 360 != 0 || xRot != 0) && shouldLockUV);
            endOfBuildSingle.addModel();
        }
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

    public ResourceLocation key(Block b) {
        return BuiltInRegistries.BLOCK.getKey(b);
    }
    public String keyName(Block b){
        return key(b).toString();
    }
    public String name(Block b) {return key(b).getPath();}
    public ResourceLocation forVanillaSource(@NotNull String registryName, String specificNameEnd){
        return mcLoc("block/" + FoldingRegistration.PROPERTY_KINDS.get(registryName.split("_"+specificNameEnd)[0].split(FurniturePlan.MOD_ID+":")[1]));
    }
}
