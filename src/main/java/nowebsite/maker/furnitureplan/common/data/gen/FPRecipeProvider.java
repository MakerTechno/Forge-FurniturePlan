package nowebsite.maker.furnitureplan.common.data.gen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.registries.DeferredBlock;
import nowebsite.maker.furnitureplan.FurniturePlan;
import nowebsite.maker.furnitureplan.common.block.storaging.CabinetBlock;
import nowebsite.maker.furnitureplan.common.block.surfacing.MoonShelfBlock;
import nowebsite.maker.furnitureplan.common.block.surfacing.PotHolderBlock;
import nowebsite.maker.furnitureplan.common.block.surfacing.WallShelfBlock;
import nowebsite.maker.furnitureplan.common.init.FPBlockReg;
import nowebsite.maker.furnitureplan.common.init.FPItemReg;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class FPRecipeProvider extends RecipeProvider {
    protected FPRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    @Override
    protected void buildRecipes() {
        miscellaneous();
        utensils();

        shaped(RecipeCategory.MISC, FPItemReg.GRAVER.get())
            .define('I', Items.IRON_NUGGET)
            .define('S', Items.STICK)
            .pattern("I I")
            .pattern("ISI")
            .pattern(" S ")
            .unlockedBy("has_iron_nugget", has(Items.IRON_NUGGET))
            .save(output);

        for (PotHolderBlock block : FPBlockReg.POT_HOLDERS.get()) {
            shaped(RecipeCategory.BUILDING_BLOCKS, block, 2)
                .define('#', block.getType().getBase())
                .pattern(" # ")
                .pattern(" # ")
                .pattern("# #")
                .unlockedBy("has_needed_concrete", has(block.getType().getBase()))
                .save(output);
        }

        for (MoonShelfBlock block : FPBlockReg.MOON_SHELVES.get()) {
            shaped(RecipeCategory.BUILDING_BLOCKS, block)
                .define('#', block.getType().getBase())
                .pattern(" # ")
                .pattern("###")
                .pattern(" # ")
                .unlockedBy("has_needed_ingredient", has(block.getType().getBase()))
                .save(output);
        }
        for (WallShelfBlock block : FPBlockReg.WALL_SHELVES.get()) {
            shaped(RecipeCategory.BUILDING_BLOCKS, block, 12)
                .define('#', block.getType().getBase())
                .pattern("###")
                .unlockedBy("has_needed_ingredient", has(block.getType().getBase()))
                .save(output);
        }

        for (List<DeferredBlock<@NotNull CabinetBlock>> blocks : FPBlockReg.CABINET_HOLDERS.values()) {
            for (DeferredBlock<@NotNull CabinetBlock> block : blocks) {
                CabinetBlock cabinetBlock = block.get();
                if (cabinetBlock.getFrameType() == null) continue;
                Item dye = cabinetBlock.getFrameType().getDye();
                shapeless(RecipeCategory.BUILDING_BLOCKS, cabinetBlock)
                    .requires(dye)
                    .requires(Ingredient.of(blocks.stream().map(DeferredBlock::get).filter(p_288265_ -> !p_288265_.equals(cabinetBlock))))
                    .group("cabinets")
                    .unlockedBy("has_needed_dye", has(dye))
                    .save(output, "dye_" + getItemName(cabinetBlock));
            }
        }
    }

    private void miscellaneous() {
        shaped(RecipeCategory.MISC, FPBlockReg.GRASS_GRASS_ITEM.get(), 64)
            .define('G', Items.SHORT_GRASS)
            .pattern("G G")
            .pattern("GGG")
            .pattern("G G")
            .unlockedBy("has_grass", has(Items.SHORT_GRASS))
            .save(output);

        shaped(RecipeCategory.BUILDING_BLOCKS, FPBlockReg.SAWDUST_PLANKS.get())
            .define('#', FPItemReg.SAWDUST.get())
            .pattern("###")
            .pattern("###")
            .pattern("###")
            .unlockedBy("has_sawdust", has(FPItemReg.SAWDUST.get()))
            .save(output);

        shaped(RecipeCategory.BUILDING_BLOCKS, FPBlockReg.DETRITUS_BLOCK.get())
            .define('#', FPItemReg.DETRITUS.get())
            .pattern("###")
            .pattern("###")
            .pattern("###")
            .unlockedBy("has_detritus", has(FPItemReg.DETRITUS.get()))
            .save(output);

        shaped(RecipeCategory.MISC, FPBlockReg.LANTERN_BLOCK_P1.get())
            .define('P', Items.PAPER)
            .define('S', Items.STRING)
            .define('T', Items.TORCH)
            .define('R', Items.RED_DYE)
            .define('Y', Items.YELLOW_DYE)
            .pattern("PSP")
            .pattern("PTP")
            .pattern("RPY")
            .unlockedBy("has_paper", has(Items.PAPER))
            .save(output);

        shapeless(RecipeCategory.MISC, FPBlockReg.LANTERN_BLOCK_P1.get())
            .requires(FPBlockReg.LANTERN_BLOCK_P2)
            .unlockedBy("has_paper", has(Items.PAPER))
            .save(output, "lantern_transform_1");

        shapeless(RecipeCategory.MISC, FPBlockReg.LANTERN_BLOCK_P2.get())
            .requires(FPBlockReg.LANTERN_BLOCK_P1)
            .unlockedBy("has_paper", has(Items.PAPER))
            .save(output, "lantern_transform_2");

        shaped(RecipeCategory.MISC, FPBlockReg.TABLE_LAMP_BLOCK.get())
            .define('P', Items.PAPER)
            .define('R', Items.REDSTONE)
            .define('D', Items.DARK_OAK_FENCE)
            .pattern("PRP")
            .pattern("PDP")
            .pattern(" D ")
            .unlockedBy("has_redstone", has(Items.REDSTONE))
            .save(output);
    }

    private void utensils() {
        shapeless(RecipeCategory.MISC, FPBlockReg.FOOD_PLATE_BLOCK_ITEM.get())
            .requires(Items.QUARTZ_BLOCK)
            .unlockedBy("has_quartz", has(Items.QUARTZ))
            .save(output);

        shapeless(RecipeCategory.MISC, FPBlockReg.GLASS_B_BLOCK_ITEM.get())
            .requires(Items.GLASS_PANE)
            .unlockedBy("has_sand", has(Items.SAND))
            .save(output);

        shaped(RecipeCategory.MISC, FPBlockReg.IRON_POT_ITEM.get())
            .define('I', Items.IRON_INGOT)
            .pattern("III")
            .unlockedBy("has_iron", has(Items.IRON_INGOT))
            .save(output);

        shapeless(RecipeCategory.MISC, FPBlockReg.CUTLERY_ITEM.get())
            .requires(Items.IRON_NUGGET, 2)
            .unlockedBy("has_iron_nugget", has(Items.IRON_NUGGET))
            .save(output);
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
