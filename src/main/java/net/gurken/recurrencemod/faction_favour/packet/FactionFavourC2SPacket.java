package net.gurken.recurrencemod.faction_favour.packet;

import net.gurken.recurrencemod.faction_favour.ModNetworking;
import net.gurken.recurrencemod.faction_favour.PlayerFactionFavourProvider;
import net.minecraft.ChatFormatting;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class FactionFavourC2SPacket {
    public FactionFavourC2SPacket() {

    }

    public FactionFavourC2SPacket(FriendlyByteBuf buf) {

    }

    public void toBytes(FriendlyByteBuf buf) {

    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            // HERE WE ARE ON THE SERVER!
            ServerPlayer player = context.getSender();
            ServerLevel level = player.serverLevel();

            if (hasWaterNearThem(player, level, 2)) {
                //player.sendSystemMessage(Component.literal("Test erfolgreich"));
                player.getCapability(PlayerFactionFavourProvider.PLAYER_FACTION_FAVOUR).ifPresent(faction_favour -> {
                    faction_favour.addFactionFavour(1);
                    player.sendSystemMessage(Component.literal("Current Favour " + faction_favour.getFactionFavour())
                            .withStyle(ChatFormatting.GREEN));
                    ModNetworking.sendToPlayer(new FactionFavourDataSyncS2CPacket(faction_favour.getFactionFavour()), player);
                });
            } else {
                //player.sendSystemMessage(Component.literal("Test gescheitert"));
                player.getCapability(PlayerFactionFavourProvider.PLAYER_FACTION_FAVOUR).ifPresent(faction_favour -> {
                    player.sendSystemMessage(Component.literal("Current Favour " + faction_favour.getFactionFavour())
                            .withStyle(ChatFormatting.RED));
                    ModNetworking.sendToPlayer(new FactionFavourDataSyncS2CPacket(faction_favour.getFactionFavour()), player);
                });
            }
        });
        return true;
        }

        private boolean hasWaterNearThem(ServerPlayer player, ServerLevel level, int size) {
            return level.getBlockStates(player.getBoundingBox().inflate(size))
                    .filter(state -> state.is(Blocks.WATER)).toArray().length > 0;
    }
}
