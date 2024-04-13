package net.gurken.recurrencemod.faction_favour;

import net.gurken.recurrencemod.faction_favour.packet.FactionFavourDataSyncS2CPacket;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fml.loading.progress.Message;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class PlayerFactionFavourProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
    public static Capability<PlayerFactionFavour> PLAYER_FACTION_FAVOUR = CapabilityManager.get(new CapabilityToken<PlayerFactionFavour>() { });

    private PlayerFactionFavour faction_favour = null;
    private final LazyOptional<PlayerFactionFavour> optional = LazyOptional.of(this::createPlayerFactionFavour);

    private PlayerFactionFavour createPlayerFactionFavour() {
        if(this.faction_favour == null) {
            this.faction_favour = new PlayerFactionFavour();
        }

        return this.faction_favour;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if(cap == PLAYER_FACTION_FAVOUR) {
            return optional.cast();
        }

        return LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        createPlayerFactionFavour().saveNBTData(nbt);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        createPlayerFactionFavour().loadNBTData(nbt);
    }
}
