package net.gurken.recurrencemod.compat;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.gurken.recurrencemod.RecurrenceMod;
import net.gurken.recurrencemod.block.ModBlocks;
import net.gurken.recurrencemod.recipe.NomadFactionForgeRecipe;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class NomadFactionForgeRecipeCategory implements IRecipeCategory<NomadFactionForgeRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(RecurrenceMod.MOD_ID, "nomad_faction_forge");
    public static final ResourceLocation TEXTURE = new ResourceLocation(RecurrenceMod.MOD_ID,
            "textures/gui/nomad_faction_forge_nei.png");

    public static final RecipeType<NomadFactionForgeRecipe> NOMAD_FACTION_FORGE_TYPE =
            new RecipeType<>(UID, NomadFactionForgeRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public NomadFactionForgeRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 100);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.NOMAD_FACTION_FORGE.get()));
    }


    @Override
    public RecipeType<NomadFactionForgeRecipe> getRecipeType() {
        return NOMAD_FACTION_FORGE_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("blockentity.recurrencemod.nomad_faction_forge");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, NomadFactionForgeRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 55, 17).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 105, 17).addIngredients(recipe.getIngredients().get(1));
        builder.addSlot(RecipeIngredientRole.INPUT, 55, 67).addIngredients(recipe.getIngredients().get(2));
        builder.addSlot(RecipeIngredientRole.INPUT, 105, 67).addIngredients(recipe.getIngredients().get(3));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 80, 42).addItemStack(recipe.getResultItem(null));
    }
}
