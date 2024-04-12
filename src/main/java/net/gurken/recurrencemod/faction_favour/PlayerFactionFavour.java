package net.gurken.recurrencemod.faction_favour;

import net.minecraft.nbt.CompoundTag;

//@AutoRegisterCapability
public class PlayerFactionFavour {

    private int faction_favour;
    private final int MIN_FACTION_FAVOUR = 0;
    private static int MAX_FACTION_FAVOUR = 150;

    public int getFactionFavour() {
        return faction_favour;
    }

    public void addFactionFavour(int add) {
        this.faction_favour = Math.min(faction_favour + add, MAX_FACTION_FAVOUR);
    }

    public void subFactionFavour(int sub) {
        this.faction_favour = Math.max(faction_favour - sub, MIN_FACTION_FAVOUR);
    }
    public static int getMaxFactionFavour() {
        return MAX_FACTION_FAVOUR;
    }

    public void copyFrom(PlayerFactionFavour source) {
        this.faction_favour = source.faction_favour;
    }

    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("faction_favour", faction_favour);
    }

    public void loadNBTData(CompoundTag nbt) {
        faction_favour = nbt.getInt("faction_favour");
    }
}
