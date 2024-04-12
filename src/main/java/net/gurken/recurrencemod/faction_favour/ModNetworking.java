package net.gurken.recurrencemod.faction_favour;

import net.gurken.recurrencemod.RecurrenceMod;
import net.gurken.recurrencemod.faction_favour.packet.FactionFavourC2SPacket;
import net.gurken.recurrencemod.faction_favour.packet.FactionFavourDataSyncS2CPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;

public class ModNetworking {
    private static SimpleChannel INSTANCE;
    private static int packetId = 0;
    private static int id() {
        return packetId++;
    }

    public static void register() {
        SimpleChannel net = NetworkRegistry.ChannelBuilder
                .named(new ResourceLocation(RecurrenceMod.MOD_ID, "messages"))
                .networkProtocolVersion(() -> "1.0")
                .clientAcceptedVersions(s -> true)
                .serverAcceptedVersions(s -> true)
                .simpleChannel();

        INSTANCE = net;

        net.messageBuilder(FactionFavourC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(FactionFavourC2SPacket::new)
                .encoder(FactionFavourC2SPacket::toBytes)
                .consumerMainThread(FactionFavourC2SPacket::handle)
                .add();

        net.messageBuilder(FactionFavourDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
                .decoder(FactionFavourDataSyncS2CPacket::new)
                .encoder(FactionFavourDataSyncS2CPacket::toBytes)
                .consumerMainThread(FactionFavourDataSyncS2CPacket::handle)
                .add();
    }

    public static <MSG> void sendToServer(MSG message) {
        INSTANCE.sendToServer(message);
    }

    public static <MSG> void sendToPlayer(MSG message, ServerPlayer player) {
        INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), message);
    }
}
