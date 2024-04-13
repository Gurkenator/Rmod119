package net.gurken.recurrencemod.event;

import com.mojang.brigadier.CommandDispatcher;
import net.gurken.recurrencemod.RecurrenceMod;
import net.gurken.recurrencemod.command.FactionFavorCommand;
import net.gurken.recurrencemod.faction_favour.ModNetworking;
import net.gurken.recurrencemod.faction_favour.PlayerFactionFavour;
import net.gurken.recurrencemod.faction_favour.PlayerFactionFavourProvider;
import net.gurken.recurrencemod.faction_favour.packet.FactionFavourDataSyncS2CPacket;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.server.command.ConfigCommand;

@Mod.EventBusSubscriber(modid = RecurrenceMod.MOD_ID)
public class ModEvents {
    @SubscribeEvent
    public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event) {
        if(event.getObject() instanceof Player) {
            if(!event.getObject().getCapability(PlayerFactionFavourProvider.PLAYER_FACTION_FAVOUR).isPresent()) {
                event.addCapability(new ResourceLocation(RecurrenceMod.MOD_ID, "properties"), new PlayerFactionFavourProvider());
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event) {
        if(event.isWasDeath()) {
            event.getOriginal().getCapability(PlayerFactionFavourProvider.PLAYER_FACTION_FAVOUR).ifPresent(oldStore -> {
                event.getOriginal().getCapability(PlayerFactionFavourProvider.PLAYER_FACTION_FAVOUR).ifPresent(newStore -> {
                    newStore.copyFrom(oldStore);
                });
            });
        }
    }

    @SubscribeEvent
    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
        event.register(PlayerFactionFavour.class);
    }

    @SubscribeEvent
    public static void onPlayerTick(final TickEvent.PlayerTickEvent event) {
        if(event.side == LogicalSide.SERVER) {
            event.player.getCapability(PlayerFactionFavourProvider.PLAYER_FACTION_FAVOUR).ifPresent(faction_favour -> {
                if(faction_favour.getFactionFavour() > 0 && event.player.getRandom().nextFloat() < 0.005f) { // Once Every 10 Seconds on Avg
                    faction_favour.subFactionFavour(1);
                    event.player.sendSystemMessage(Component.literal("Subtracted Faction Favour"));
                    ModNetworking.sendToPlayer(new FactionFavourDataSyncS2CPacket(faction_favour.getFactionFavour()), ((ServerPlayer) event.player));
                }
            });
        }
    }

    @SubscribeEvent
    public static void onPlayerJoinWorld(EntityJoinLevelEvent event) {
        if(!event.getLevel().isClientSide()) {
            if(event.getEntity() instanceof ServerPlayer player) {
                player.getCapability(PlayerFactionFavourProvider.PLAYER_FACTION_FAVOUR).ifPresent(faction_favour -> {
                    ModNetworking.sendToPlayer(new FactionFavourDataSyncS2CPacket(faction_favour.getFactionFavour()), player);
                });
            }
        }
    }

    @SubscribeEvent
    public static void onCommandsRegister(RegisterCommandsEvent event) {
        new FactionFavorCommand(event.getDispatcher());

        ConfigCommand.register(event.getDispatcher());
    }
}
