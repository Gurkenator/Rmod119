package net.gurken.recurrencemod.faction_favour.packet;

import net.gurken.recurrencemod.client.ClientFactionFavourData;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class FactionFavourDataSyncS2CPacket {
    private final int faction_favour;

    public FactionFavourDataSyncS2CPacket(int faction_favour) {
        this.faction_favour = faction_favour;
    }

    public FactionFavourDataSyncS2CPacket(FriendlyByteBuf buf) {
        this.faction_favour = buf.readInt();
    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeInt(faction_favour);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            // HERE WE ARE ON THE CLIENT!
            ClientFactionFavourData.set(faction_favour);
        });
        return true;
    }
}
