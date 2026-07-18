package nowebsite.maker.furnitureplan.integration.jei;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.recipe.types.IRecipeType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.network.chat.Component;
import nowebsite.maker.furnitureplan.FurniturePlan;
import nowebsite.maker.furnitureplan.common.init.FPItemReg;
import org.jetbrains.annotations.NotNull;

// Category
public class GraverConversionCategory implements IRecipeCategory<GraverConversionRecipe> {
    public static final IRecipeType<GraverConversionRecipe> TYPE = IRecipeType.create(FurniturePlan.MOD_ID, "graver_conversion", GraverConversionRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public GraverConversionCategory(IGuiHelper guiHelper) {
        this.background = guiHelper.createDrawable(FurniturePlan.asResource("textures/gui/graver_jei.png"), 0, 0, 190, 120);
        this.icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, FPItemReg.GRAVER.get().getDefaultInstance());
    }

    @Override
    public @NotNull IRecipeType<GraverConversionRecipe> getRecipeType() {
        return TYPE;
    }


    @Override
    public @NotNull Component getTitle() {
        return Component.translatable("tip.furnitureplan.jei.carve");
    }

    @Override
    public int getWidth() {
        return 150;
    }

    @Override
    public int getHeight() {
        return 120;
    }

    @Override
    public IDrawable getIcon() {
        return icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, @NotNull GraverConversionRecipe recipe, @NotNull IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.CRAFTING_STATION, 69, 31).add(FPItemReg.GRAVER.get().getDefaultInstance());

        builder.addSlot(RecipeIngredientRole.INPUT, 29, 53).addItemStacks(recipe.inputs());
        builder.addSlot(RecipeIngredientRole.OUTPUT, 107, 53).addItemStacks(recipe.outputs());
        builder.addSlot(RecipeIngredientRole.OUTPUT, 101, 85).add(FPItemReg.SAWDUST.get());
        builder.addSlot(RecipeIngredientRole.OUTPUT, 123, 85).add(FPItemReg.DETRITUS.get());
    }

    @Override
    public void draw(@NotNull GraverConversionRecipe recipe, @NotNull IRecipeSlotsView recipeSlotsView, @NotNull GuiGraphicsExtractor guiGraphics, double mouseX, double mouseY) {
        background.draw(guiGraphics);
        guiGraphics.centeredText(Minecraft.getInstance().font, Component.translatable("tip.furnitureplan.jei.text"), 76, 10, 0xFF0065FF);
    }

}