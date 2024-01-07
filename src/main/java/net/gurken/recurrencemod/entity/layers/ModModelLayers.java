package net.gurken.recurrencemod.entity.layers;

import net.gurken.recurrencemod.RecurrenceMod;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class ModModelLayers {
    public static final ModelLayerLocation RAIDER_LAYER = new ModelLayerLocation(
            new ResourceLocation(RecurrenceMod.MOD_ID, "raider_layer"), "raider_layer");

    public static final ModelLayerLocation SAPPING_RAZOR_PROJECTILE_LAYER = new ModelLayerLocation(
            new ResourceLocation(RecurrenceMod.MOD_ID, "sapping_razor_projectile_layer"), "sapping_razor_projectile_layer");
}
