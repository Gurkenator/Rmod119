package net.gurken.recurrencemod.event;

import net.gurken.recurrencemod.RecurrenceMod;
import net.gurken.recurrencemod.entity.ModEntities;
import net.gurken.recurrencemod.entity.client.RaiderModel;
import net.gurken.recurrencemod.entity.client.SappingRazorModel;
import net.gurken.recurrencemod.entity.custom.RaiderEntity;
import net.gurken.recurrencemod.entity.layers.ModModelLayers;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = RecurrenceMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.RAIDER_LAYER, RaiderModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.SAPPING_RAZOR_PROJECTILE_LAYER, SappingRazorModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.RAIDER.get(), RaiderEntity.createAttributes().build());
    }
}
