package nowebsite.maker.furnitureplan.common.data.gen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import nowebsite.maker.furnitureplan.FurniturePlan;

import java.util.concurrent.CompletableFuture;

public class FPRecipeProvider extends RecipeProvider {
    protected FPRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    @Override
    protected void buildRecipes() {

    }

    public static class Runner extends RecipeProvider.Runner {

        protected Runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
            super(packOutput, registries);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
            return new FPRecipeProvider(registries, output);
        }

        @Override
        public String getName() {
            return "Recipe Gen For:"+ FurniturePlan.MOD_ID;
        }
    }
}
