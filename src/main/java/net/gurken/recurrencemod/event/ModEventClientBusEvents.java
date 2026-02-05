package net.gurken.recurrencemod.event;

import net.gurken.recurrencemod.RecurrenceMod;
import net.gurken.recurrencemod.block.entity.ModBlockEntities;
import net.gurken.recurrencemod.block.entity.renderer.LunaticFactionForgeBlockEntityRenderer;
import net.gurken.recurrencemod.block.entity.renderer.NomadFactionForgeBlockEntityRenderer;
import net.gurken.recurrencemod.faction_favour.ModNetworking;
import net.gurken.recurrencemod.faction_favour.packet.FactionFavourC2SPacket;
import net.gurken.recurrencemod.util.KeyBinding;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.ChestRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = RecurrenceMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventClientBusEvents {
    @SubscribeEvent
    public static void registerBER(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(ModBlockEntities.NOMAD_FACTION_FORGE_BE.get(),
                NomadFactionForgeBlockEntityRenderer::new);
        event.registerBlockEntityRenderer(ModBlockEntities.LUNATIC_FACTION_FORGE_BE.get(),
                LunaticFactionForgeBlockEntityRenderer::new);
    }

    @Mod.EventBusSubscriber(modid = RecurrenceMod.MOD_ID, value = Dist.CLIENT)
    public static class ClientForgeEvents {
        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event) {
            if(KeyBinding.FACTION_KEY.consumeClick()) {
                ModNetworking.sendToServer((new FactionFavourC2SPacket()));
            }
        }
    }

    @Mod.EventBusSubscriber(modid = RecurrenceMod.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents {
        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event) {
            event.register(KeyBinding.FACTION_KEY);
        }
    }
}
