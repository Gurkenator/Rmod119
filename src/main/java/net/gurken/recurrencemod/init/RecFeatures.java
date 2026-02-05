package net.gurken.recurrencemod.init;

import net.gurken.recurrencemod.RecurrenceMod;
import net.gurken.recurrencemod.block.ModBlocks;
import net.gurken.recurrencemod.block.entity.MakeshiftChestBlockEntity;
import net.gurken.recurrencemod.feature.SpireFeature;
import net.gurken.recurrencemod.feature.SpireFeatureConfiguration;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RecFeatures {
    // CREDIT GOES TO: TeamTwilight | https://github.com/TeamTwilight/twilightforest, from whom this code is adapted.
    // The Twilight Forest uses a custom LGPL License
    // https://github.com/TeamTwilight/twilightforest/blob/1.20.x/LICENSE

    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, RecurrenceMod.MOD_ID);
    public static final RegistryObject<Feature<SpireFeatureConfiguration>> SPIRE = FEATURES.register("spire", () -> new SpireFeature(SpireFeatureConfiguration.CODEC));

}
