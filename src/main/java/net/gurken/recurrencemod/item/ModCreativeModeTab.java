package net.gurken.recurrencemod.item;

import net.gurken.recurrencemod.RecurrenceMod;
import net.gurken.recurrencemod.block.ModBlocks;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = RecurrenceMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTab {
    public static CreativeModeTab RECURRENCE_TAB;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
        RECURRENCE_TAB = event.registerCreativeModeTab(new ResourceLocation(RecurrenceMod.MOD_ID, "recurrence_mod_tab"),
                builder -> builder.icon(() -> new ItemStack(ModBlocks.SCORCHSTONE.get())).title(Component.literal("Recurrence")).build());
    }
}