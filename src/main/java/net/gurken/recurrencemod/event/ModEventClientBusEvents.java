package net.gurken.recurrencemod.event;

import net.gurken.recurrencemod.RecurrenceMod;
import net.gurken.recurrencemod.block.entity.ModBlockEntities;
import net.gurken.recurrencemod.block.entity.renderer.NomadFactionForgeBlockEntityRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = RecurrenceMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventClientBusEvents {
    @SubscribeEvent
    public static void registerBER(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(ModBlockEntities.NOMAD_FACTION_FORGE_BE.get(),
                NomadFactionForgeBlockEntityRenderer::new);
    }
}
