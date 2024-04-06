package net.gurken.recurrencemod.datagen;

import net.gurken.recurrencemod.datagen.custom.NomadFactionForgeRecipeBuilder;
import net.gurken.recurrencemod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        new NomadFactionForgeRecipeBuilder(ModItems.IRON_SCRAPS.get(), Items.NETHERITE_INGOT, Items.BUCKET, Items.BONE, ModItems.NOMAD_SWORD.get(), 1)
                .unlockedBy("has_copper_scraps", has(ModItems.COPPER_SCRAPS.get())).save(pWriter);
    }
}
