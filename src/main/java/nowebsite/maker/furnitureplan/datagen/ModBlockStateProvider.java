package nowebsite.maker.furnitureplan.datagen;

import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.VariantBlockStateBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import nowebsite.maker.furnitureplan.FurniturePlan;
import nowebsite.maker.furnitureplan.blocks.cookingUtensils.StoveBlock;
import nowebsite.maker.furnitureplan.blocks.tableware.FoodPlateBlock;
import nowebsite.maker.furnitureplan.registry.BlockRegistration;
import nowebsite.maker.furnitureplan.registry.FoldingRegistration;
import nowebsite.maker.furnitureplan.utils.ModelSR;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@SuppressWarnings("deprecation")
public class ModBlockStateProvider extends BlockStateProvider {
    public final ExistingFileHelper HELPER;

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper helper) {
        super(output, FurniturePlan.MOD_ID, helper);
        this.HELPER = helper;
    }

    protected void registerStatesAndModels() {
        addKindsAsHorizontalBlock(FoldingRegistration.getChairBlockLists(), "chair_block");
        addKindsAsSimpleBlock(FoldingRegistration.getTableBlockLists(), "table_block");
        addKindsAsSimpleBlock(FoldingRegistration.getColumnBlockLists(), "column_block");
        addKindsAsSimpleBlock(FoldingRegistration.getCarvedColumnBlockLists(), "carved_column_block");
        addKindsAsSimpleBlock(FoldingRegistration.getLightedColumnBlockLists(), "lighted_column_block");

        registerEnumWithHorizontalBlock(BlockRegistration.FOOD_PLATE_BLOCK.get(),
                "particle",
                FoodPlateBlock.SHAPE_DEF
        );
        simpleBlock(BlockRegistration.GLASS_B_BLOCK.get(), models().singleTexture(
                keyName(BlockRegistration.GLASS_B_BLOCK.get()),
                modLoc("block/glass"), "particle",
                modLoc("block/glass")
        ));
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

    public void addKindsAsHorizontalBlock(@NotNull List<RegistryObject<? extends Block>> list, String modelCap) {
        assert list.size() <= FoldingRegistration.PROPERTY_KINDS.length;
        int count = 0;
        for(RegistryObject<? extends Block> ro : list) {
            horizontalBlock(ro.get(), models().singleTexture(
                    keyName(ro.get()),
                    modLoc("block/" + modelCap), "particle",
                    mcLoc("block/" + FoldingRegistration.PROPERTY_KINDS[count])
                    ));
            count++;
        }
    }
    public void addKindsAsSimpleBlock(@NotNull List<RegistryObject<? extends Block>> list, String modelCap) {
        assert list.size() <= FoldingRegistration.PROPERTY_KINDS.length;
        int count = 0;
        for(RegistryObject<? extends Block> ro : list) {
            simpleBlock(ro.get(), models().singleTexture(
                    keyName(ro.get()),
                    modLoc("block/" + modelCap), "particle",
                    mcLoc("block/" + FoldingRegistration.PROPERTY_KINDS[count])
            ));
            count++;
        }
    }

    @SuppressWarnings("unused")
    public  <T extends Enum<T> & ModelSR, R extends EnumProperty<T>,
            B extends Enum<B> & StringRepresentable, E extends Property<B>> void registerEnumWithMultiStateBlock(
            Block block,
            String key, ResourceLocation texture,
            @NotNull R baseKind,
            E overKind
    ){
        VariantBlockStateBuilder builder = getVariantBuilder(block);

        for (T type : baseKind.getPossibleValues()) {

            for (B type2 : overKind.getPossibleValues()){
                String name = name(block)+ "_"+ type.toString();

                ModelFile modelFile = models()
                        .withExistingParent(name, type.getModel())
                        .texture(key,texture);

                builder.partialState().with(baseKind, type)
                        .with(overKind, type2)
                        .modelForState()
                        .modelFile(modelFile)
                        .addModel();
            }
        }
    }
    public  <T extends Enum<T> & ModelSR, R extends EnumProperty<T>> void registerEnumWithHorizontalBlock(
            Block block,
            String key,
            R baseKind
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
    public ResourceLocation key(Block b) {
        return BuiltInRegistries.BLOCK.getKey(b);
    }
    public String keyName(Block b){
        return key(b).toString();
    }
    public String name(Block b) {return key(b).getPath();}
}
