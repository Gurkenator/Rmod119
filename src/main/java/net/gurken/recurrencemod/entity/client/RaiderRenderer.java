package net.gurken.recurrencemod.entity.client;

import net.gurken.recurrencemod.RecurrenceMod;
import net.gurken.recurrencemod.entity.custom.RaiderEntity;
import net.gurken.recurrencemod.entity.layers.ModModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class RaiderRenderer extends MobRenderer<RaiderEntity, RaiderModel<RaiderEntity>> {
    private static final ResourceLocation RAIDER_LOCATION = new ResourceLocation(RecurrenceMod.MOD_ID, "textures/entity/raider_v1.png");

    public RaiderRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new RaiderModel<>(pContext.bakeLayer(ModModelLayers.RAIDER_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(RaiderEntity pEntity) {
        return RAIDER_LOCATION;
    }
}
