package net.gurken.recurrencemod.item;

import net.gurken.recurrencemod.RecurrenceMod;
import net.gurken.recurrencemod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB,
            RecurrenceMod.MOD_ID);
    public static RegistryObject<CreativeModeTab> RECURRENCE_TAB = CREATIVE_MODE_TABS.register("recurrence_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.SCORCHSTONE.get()))
                    .title(Component.translatable("creativemodetab.recurrence_tab")).build());
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}