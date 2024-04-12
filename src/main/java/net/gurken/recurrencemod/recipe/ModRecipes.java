package net.gurken.recurrencemod.recipe;

import net.gurken.recurrencemod.RecurrenceMod;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, RecurrenceMod.MOD_ID);

    public static final RegistryObject<RecipeSerializer<NomadFactionForgeRecipe>> NOMAD_FACTION_FORGE_SERIALIZER =
            SERIALIZERS.register("nomad_faction_forge", () -> NomadFactionForgeRecipe.Serializer.INSTANCE);

    public static final RegistryObject<RecipeSerializer<LunaticFactionForgeRecipe>> LUNATIC_FACTION_FORGE_SERIALIZER =
            SERIALIZERS.register("lunatic_faction_forge", () -> LunaticFactionForgeRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}
