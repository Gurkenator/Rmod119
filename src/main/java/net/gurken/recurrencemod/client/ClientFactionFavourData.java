package net.gurken.recurrencemod.client;

public class ClientFactionFavourData {
    private static int playerFactionFavour;

    public static void set(int faction_favour) {
        ClientFactionFavourData.playerFactionFavour = faction_favour;
    }

    public static int getPlayerFactionFavour() {
        return playerFactionFavour;
    }
}
