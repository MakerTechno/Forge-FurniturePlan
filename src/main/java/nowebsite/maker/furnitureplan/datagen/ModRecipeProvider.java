package nowebsite.maker.furnitureplan.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.registries.DeferredHolder;
import nowebsite.maker.furnitureplan.blocks.func.IColorfulBlock;
import nowebsite.maker.furnitureplan.registry.BlockRegistration;
import nowebsite.maker.furnitureplan.registry.FoldingRegistration;
import nowebsite.maker.furnitureplan.registry.ItemRegistration;
import nowebsite.maker.furnitureplan.registry.kindsblock.PotHolderBlockRegistration;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput recipeOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemRegistration.GRAVER.get())
            .define('I', Items.IRON_NUGGET)
            .define('S', Items.STICK)
            .pattern("I I")
            .pattern("ISI")
            .pattern(" S ")
            .unlockedBy("has_iron_nugget", has(Items.IRON_NUGGET))
            .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BlockRegistration.CUPBOARD_BLOCK_ITEM.get())
            .define('O', ItemTags.PLANKS)
            .define('X', Items.CHEST)
            .pattern("OOO")
            .pattern("OXO")
            .pattern("OOO")
            .unlockedBy("has_planks", has(ItemTags.PLANKS))
            .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BlockRegistration.GRASS_GRASS_ITEM.get())
            .define('G', Items.SHORT_GRASS)
            .pattern("G G")
            .pattern("GGG")
            .pattern("G G")
            .unlockedBy("has_grass", has(Items.SHORT_GRASS))
            .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, BlockRegistration.FOOD_PLATE_BLOCK_ITEM.get())
            .requires(Items.QUARTZ_BLOCK)
            .unlockedBy("has_quartz", has(Items.QUARTZ))
            .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, BlockRegistration.GLASS_B_BLOCK_ITEM.get())
            .requires(Items.GLASS_PANE)
            .unlockedBy("has_sand", has(Items.SAND))
            .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, PotHolderBlockRegistration.WHITE_POT_HOLDER_BLOCK_ITEM.get())
            .define('Q', Items.QUARTZ_BLOCK)
            .pattern(" Q ")
            .pattern(" Q ")
            .pattern("Q Q")
            .unlockedBy("has_quartz", has(Items.QUARTZ))
            .save(recipeOutput);
        List<Item> HOLDERS = FoldingRegistration.getPotHolderItemList()
            .stream()
            .map(DeferredHolder::get)
            .map(Item::asItem)
            .toList();
        colorBlockWithDye(recipeOutput, IColorfulBlock.DYE_LIST, HOLDERS, "pot_holder");
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BlockRegistration.IRON_POT_BLOCK_ITEM.get())
            .define('I', Items.IRON_INGOT)
            .pattern("III")
            .unlockedBy("has_iron", has(Items.IRON_INGOT))
            .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BlockRegistration.STOVE_BLOCK_ITEM.get())
            .define('I', Items.IRON_INGOT)
            .define('S', Items.STONE)
            .pattern("I I")
            .pattern("SSS")
            .unlockedBy("has_iron", has(Items.IRON_INGOT))
            .unlockedBy("has_stone", has(Items.STONE))
            .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BlockRegistration.LANTERN_ITEM.get())
            .define('P', Items.PAPER)
            .define('S', Items.STRING)
            .define('T', Items.TORCH)
            .define('R', Items.RED_DYE)
            .define('Y', Items.YELLOW_DYE)
            .pattern("PSP")
            .pattern("PTP")
            .pattern("RPY")
            .unlockedBy("has_paper", has(Items.PAPER))
            .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BlockRegistration.TABLE_LAMP_ITEM.get())
            .define('P', Items.PAPER)
            .define('R', Items.REDSTONE)
            .define('D', Items.DARK_OAK_FENCE)
            .pattern("PRP")
            .pattern("PDP")
            .pattern(" D ")
            .unlockedBy("has_redstone", has(Items.REDSTONE))
            .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, BlockRegistration.CUTLERY_ITEM.get())
            .requires(Items.IRON_NUGGET, 3)
            .unlockedBy("has_iron_nugget", has(Items.IRON_NUGGET))
            .save(recipeOutput);
    }
    // TODO: 2024/9/3 add plate, glass, pot holder, iron pot, stove recipes.
}
