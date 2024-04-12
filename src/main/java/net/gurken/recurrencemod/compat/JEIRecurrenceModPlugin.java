package net.gurken.recurrencemod.compat;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.gurken.recurrencemod.RecurrenceMod;
import net.gurken.recurrencemod.recipe.LunaticFactionForgeRecipe;
import net.gurken.recurrencemod.recipe.NomadFactionForgeRecipe;
import net.gurken.recurrencemod.screen.LunaticFactionForgeScreen;
import net.gurken.recurrencemod.screen.NomadFactionForgeScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;

@JeiPlugin
public class JEIRecurrenceModPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(RecurrenceMod.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new NomadFactionForgeRecipeCategory(
                registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new LunaticFactionForgeRecipeCategory(
                registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();
        List<NomadFactionForgeRecipe> nomadfactionforgeRecipes = recipeManager.getAllRecipesFor(NomadFactionForgeRecipe.Type.INSTANCE);
        registration.addRecipes(NomadFactionForgeRecipeCategory.NOMAD_FACTION_FORGE_TYPE, nomadfactionforgeRecipes);
        List<LunaticFactionForgeRecipe> lunaticfactionforgeRecipes = recipeManager.getAllRecipesFor(LunaticFactionForgeRecipe.Type.INSTANCE);
        registration.addRecipes(LunaticFactionForgeRecipeCategory.LUNATIC_FACTION_FORGE_TYPE, lunaticfactionforgeRecipes);
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(NomadFactionForgeScreen.class, 74, 24, 30, 8,
                NomadFactionForgeRecipeCategory.NOMAD_FACTION_FORGE_TYPE);
        registration.addRecipeClickArea(NomadFactionForgeScreen.class, 74, 52, 30, 8,
                NomadFactionForgeRecipeCategory.NOMAD_FACTION_FORGE_TYPE);

        registration.addRecipeClickArea(LunaticFactionForgeScreen.class, 74, 24, 30, 8,
                LunaticFactionForgeRecipeCategory.LUNATIC_FACTION_FORGE_TYPE);
        registration.addRecipeClickArea(LunaticFactionForgeScreen.class, 74, 52, 30, 8,
                LunaticFactionForgeRecipeCategory.LUNATIC_FACTION_FORGE_TYPE);
    }
}
