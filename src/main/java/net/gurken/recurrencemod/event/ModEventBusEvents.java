package net.gurken.recurrencemod.event;

import net.gurken.recurrencemod.RecurrenceMod;
import net.gurken.recurrencemod.entity.ModEntities;
import net.gurken.recurrencemod.entity.client.RaiderModel;
import net.gurken.recurrencemod.entity.client.VagabondThrowingKnifeModel;
import net.gurken.recurrencemod.entity.custom.RaiderEntity;
import net.gurken.recurrencemod.entity.layers.ModModelLayers;
import net.gurken.recurrencemod.faction_favour.ModNetworking;
import net.gurken.recurrencemod.faction_favour.PlayerFactionFavour;
import net.gurken.recurrencemod.faction_favour.PlayerFactionFavourProvider;
import net.gurken.recurrencemod.faction_favour.packet.FactionFavourDataSyncS2CPacket;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = RecurrenceMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.RAIDER_LAYER, RaiderModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.VAGABOND_THROWING_KNIFE_LAYER, VagabondThrowingKnifeModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.RAIDER.get(), RaiderEntity.createAttributes().build());
    }
}
