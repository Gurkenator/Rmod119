package net.gurken.recurrencemod.worldgen;

import net.gurken.recurrencemod.RecurrenceMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;

public class ModBiomes {

    public static final ResourceKey<Biome> ARID_PLAINS = register("arid_plains");
    public static final ResourceKey<Biome> BLEAK_PLATEAUS = register("bleak_plateaus");

    private static ResourceKey<Biome> register(String name)
    {
        return ResourceKey.create(Registries.BIOME, new ResourceLocation(RecurrenceMod.MOD_ID, name));
    }
}
