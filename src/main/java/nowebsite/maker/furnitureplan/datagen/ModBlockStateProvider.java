package nowebsite.maker.furnitureplan.datagen;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import nowebsite.maker.furnitureplan.FurniturePlan;
import nowebsite.maker.furnitureplan.registry.BlockRegistration;
import nowebsite.maker.furnitureplan.registry.FoldingRegistration;
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

        horizontalBlock(BlockRegistration.FOOD_PLATE_BLOCK.get(), models().singleTexture(
                BuiltInRegistries.BLOCK.getKey(BlockRegistration.FOOD_PLATE_BLOCK.get()).toString(),
                modLoc("block/plate"), "particle",
                modLoc("block/plate")
        ));
        horizontalBlock(BlockRegistration.CUTLERY_BLOCK.get(), models().singleTexture(
                BuiltInRegistries.BLOCK.getKey(BlockRegistration.CUTLERY_BLOCK.get()).toString(),
                modLoc("block/cutlery"), "particle",
                mcLoc("block/stone")
        ));
        horizontalBlock(BlockRegistration.FOOD_PLATE_AND_CUTLERY_BLOCK.get(), models().singleTexture(
                BuiltInRegistries.BLOCK.getKey(BlockRegistration.FOOD_PLATE_AND_CUTLERY_BLOCK.get()).toString(),
                modLoc("block/plate_and_cutlery"), "particle",
                mcLoc("block/stone")
        ));
        horizontalBlock(BlockRegistration.FOOD_PLATE_AND_GLASS_BLOCK.get(), models().singleTexture(
                BuiltInRegistries.BLOCK.getKey(BlockRegistration.FOOD_PLATE_AND_GLASS_BLOCK.get()).toString(),
                modLoc("block/plate_and_glass"), "particle",
                modLoc("block/glass")
        ));
        horizontalBlock(BlockRegistration.FOOD_PLATE_AND_GLASS_AND_CUTLERY_BLOCK.get(), models().singleTexture(
                BuiltInRegistries.BLOCK.getKey(BlockRegistration.FOOD_PLATE_AND_GLASS_AND_CUTLERY_BLOCK.get()).toString(),
                modLoc("block/plate_and_glass_and_cutlery"), "particle",
                mcLoc("block/stone")
        ));
        simpleBlock(BlockRegistration.GLASS_B_BLOCK.get(), models().singleTexture(
                BuiltInRegistries.BLOCK.getKey(BlockRegistration.GLASS_B_BLOCK.get()).toString(),
                modLoc("block/glass"), "particle",
                modLoc("block/glass")
        ));
    }

    public void addKindsAsHorizontalBlock(@NotNull List<RegistryObject<? extends Block>> list, String modelCap) {
        assert list.size() <= FoldingRegistration.PROPERTY_KINDS.length;
        int count = 0;
        for(RegistryObject<? extends Block> ro : list) {
            horizontalBlock(ro.get(), models().singleTexture(
                    BuiltInRegistries.BLOCK.getKey(ro.get()).toString(),
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
                    BuiltInRegistries.BLOCK.getKey(ro.get()).toString(),
                    modLoc("block/" + modelCap), "particle",
                    mcLoc("block/" + FoldingRegistration.PROPERTY_KINDS[count])
            ));
            count++;
        }
    }
}
