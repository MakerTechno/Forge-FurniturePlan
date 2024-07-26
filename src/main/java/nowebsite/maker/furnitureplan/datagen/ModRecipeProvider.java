package nowebsite.maker.furnitureplan.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
import nowebsite.maker.furnitureplan.registry.ItemRegistration;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput recipeOutput) {
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemRegistration.GRAVER.get(), 2)
                    .define('I', Items.IRON_NUGGET)
                    .define('S', Items.STICK)
                    .pattern("I I")
                    .pattern("ISI")
                    .pattern(" S ")
                    .unlockedBy("has_iron_nugget", has(Items.IRON_NUGGET))
                    .save(recipeOutput);
    }
}
