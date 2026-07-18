package nowebsite.maker.furnitureplan.integration.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.resources.Identifier;
import nowebsite.maker.furnitureplan.FurniturePlan;
import nowebsite.maker.furnitureplan.common.init.FPBlockReg;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@JeiPlugin
public class FPJEIPlugin  implements IModPlugin {
    @Override
    public @NotNull Identifier getPluginUid() {
        return FurniturePlan.asResource("jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new GraverConversionCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(@NotNull IRecipeRegistration registration) {
        List<GraverConversionRecipe> recipes = new ArrayList<>();

        recipes.add(new GraverConversionRecipe(
            FPBlockReg.CHAIRS.get().stream().map(block -> block.getType().getCarvingBase().asItem().getDefaultInstance()).toList(),
            FPBlockReg.CHAIRS.get().stream().map(block -> block.asItem().getDefaultInstance()).toList()
        ));
        recipes.add(new GraverConversionRecipe(
            FPBlockReg.BENCHES.get().stream().map(block -> block.getType().getCarvingBase().asItem().getDefaultInstance()).toList(),
            FPBlockReg.BENCHES.get().stream().map(block -> block.asItem().getDefaultInstance()).toList()
        ));
        recipes.add(new GraverConversionRecipe(
            FPBlockReg.COLUMNS.get().stream().map(block -> block.getType().getCarvingBase().asItem().getDefaultInstance()).toList(),
            FPBlockReg.COLUMNS.get().stream().map(block -> block.asItem().getDefaultInstance()).toList()
        ));
        recipes.add(new GraverConversionRecipe(
            FPBlockReg.CARVED_COLUMNS.get().stream().map(block -> block.getType().getCarvingBase().asItem().getDefaultInstance()).toList(),
            FPBlockReg.CARVED_COLUMNS.get().stream().map(block -> block.asItem().getDefaultInstance()).toList()
        ));
        recipes.add(new GraverConversionRecipe(
            FPBlockReg.LIGHTED_COLUMNS.get().stream().map(block -> block.getType().getCarvingBase().asItem().getDefaultInstance()).toList(),
            FPBlockReg.LIGHTED_COLUMNS.get().stream().map(block -> block.asItem().getDefaultInstance()).toList()
        ));
        recipes.add(new GraverConversionRecipe(
            FPBlockReg.TABLES.get().stream().map(block -> block.getType().getCarvingBase().asItem().getDefaultInstance()).toList(),
            FPBlockReg.TABLES.get().stream().map(block -> block.asItem().getDefaultInstance()).toList()
        ));
        recipes.add(new GraverConversionRecipe(
            FPBlockReg.CUPBOARDS.get().stream().map(block -> block.getType().getCarvingBase().asItem().getDefaultInstance()).toList(),
            FPBlockReg.CUPBOARDS.get().stream().map(block -> block.asItem().getDefaultInstance()).toList()
        ));
        recipes.add(new GraverConversionRecipe(
            FPBlockReg.CABINETS.get().stream().filter(block -> block.getFrameType() == null).map(block -> block.getType().getCarvingBase().asItem().getDefaultInstance()).toList(),
            FPBlockReg.CABINETS.get().stream().filter(block -> block.getFrameType() == null).map(block -> block.asItem().getDefaultInstance()).toList()
        ));

        registration.addRecipes(GraverConversionCategory.TYPE, recipes);
    }

}
