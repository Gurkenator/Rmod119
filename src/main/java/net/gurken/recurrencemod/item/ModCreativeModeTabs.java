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
    public static RegistryObject<CreativeModeTab> RECURRENCE_BLOCKS_TAB = CREATIVE_MODE_TABS.register("recurrence_blocks_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.SCORCHSTONE.get()))
                    .title(Component.translatable("creativemodetab.recurrence_blocks_tab")).build());
    public static RegistryObject<CreativeModeTab> RECURRENCE_MATERIALS_TAB = CREATIVE_MODE_TABS.register("recurrence_materials_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.COPPER_SCRAPS.get()))
                    .title(Component.translatable("creativemodetab.recurrence_materials_tab")).build());
    public static RegistryObject<CreativeModeTab> RECURRENCE_FACTIONS_TAB = CREATIVE_MODE_TABS.register("recurrence_factions_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.RAIDER_SWORD.get()))
                    .title(Component.translatable("creativemodetab.recurrence_factions_tab")).build());
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}