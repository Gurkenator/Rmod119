package net.gurken.recurrencemod;

import com.mojang.logging.LogUtils;
import net.gurken.recurrencemod.block.ModBlocks;
import net.gurken.recurrencemod.entity.ModBlockEntities;
import net.gurken.recurrencemod.item.ModCreativeModeTab;
import net.gurken.recurrencemod.item.ModItems;
import net.gurken.recurrencemod.screen.ModMenuTypes;
import net.gurken.recurrencemod.screen.SkeletonBlockScreen;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(RecurrenceMod.MOD_ID)

public class RecurrenceMod
{
    public static final String MOD_ID = "recurrencemod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public RecurrenceMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() ->
        {
            // Weights are kept intentionally low as we add minimal biomes
            //Regions.register(new ModRegion1(new ResourceLocation(MOD_ID, "overworld_1"), 2));
            //Regions.register(new ModRegion2(new ResourceLocation(MOD_ID, "overworld_2"), 2));

            // Register our surface rules
            //SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MOD_ID, ModSurfaceRuleData.makeRules());
        });
    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if(event.getTab() == ModCreativeModeTab.RECURRENCE_TAB) {
            event.accept(ModBlocks.SCORCHSTONE);
            event.accept(ModBlocks.GLIMMERING_SCORCHSTONE);
            event.accept(ModBlocks.ASHSTONE);
            event.accept(ModBlocks.DUSTSTONE);
            event.accept(ModBlocks.FRACTURESTONE);
            event.accept(ModBlocks.SPIRESTONE);

            event.accept(ModBlocks.SCRAP_BLOCK);
            event.accept(ModBlocks.TIRE);
            event.accept(ModBlocks.RANCID_CARPET);
            event.accept(ModBlocks.METAL_BEAM);
            event.accept(ModBlocks.CRATE_FOOD);
            event.accept(ModBlocks.CRATE_COMMON);
            event.accept(ModBlocks.CRATE_GOOD);
            event.accept(ModBlocks.CRATE_RARE);
            event.accept(ModBlocks.CRATE_EPIC);
            event.accept(ModBlocks.CRATE_LEGENDARY);

            event.accept(ModItems.KNIFE_SWORD);
            event.accept(ModItems.BROKEN_SWORD);
            event.accept(ModItems.BAT_SWORD);
            event.accept(ModItems.CANNED_MEAT);
            event.accept(ModItems.CANNED_VEGETABLES);
            event.accept(ModItems.CANNED_SOUP);
            event.accept(ModItems.BOTTLED_WATER);
            event.accept(ModItems.ROTTEN_WOOD);
            event.accept(ModItems.COPPER_SCRAPS);
            event.accept(ModItems.TIN_SCRAPS);
            event.accept(ModItems.IRON_SCRAPS);
            event.accept(ModItems.LEAD_SCRAPS);
            event.accept(ModItems.ALUMINIUM_SCRAPS);
            event.accept(ModItems.NICKEL_SCRAPS);
            event.accept(ModItems.SILVER_SCRAPS);
            event.accept(ModItems.GOLD_SCRAPS);
            event.accept(ModItems.COBALT_SCRAPS);

            event.accept(ModBlocks.GRAFFITI_SPRAY_BLUE);
            event.accept(ModBlocks.GRAFFITI_SPRAY_RED);
            event.accept(ModBlocks.GRAFFITI_SPRAY_YELLOW);
            event.accept(ModBlocks.GRAFFITI_SPRAY_GREEN);
            event.accept(ModBlocks.GRAFFITI_SPRAY_ORANGE);
            event.accept(ModBlocks.GRAFFITI_SPRAY_PURPLE);
            event.accept(ModBlocks.GRAFFITI_SPRAY_LIGHT_GREY);

            event.accept(ModItems.RAIDER_SWORD);
            event.accept(ModItems.RAIDER_AXE);
            event.accept(ModItems.RAIDER_HELMET);
            event.accept(ModItems.RAIDER_CHESTPLATE);
            event.accept(ModItems.RAIDER_LEGGINGS);
            event.accept(ModItems.RAIDER_BOOTS);
            event.accept(ModItems.RAIDER_PLATINGS);

            event.accept(ModItems.CHAINSWORD);
            event.accept(ModItems.CHEMDRILL);
            event.accept(ModItems.LUNATIC_PLATINGS);

            event.accept(ModItems.NOMAD_SWORD);

            event.accept(ModItems.BLUE_PILLS);
            event.accept(ModItems.RED_PILLS);
            event.accept(ModItems.YELLOW_PILLS);
            event.accept(ModItems.GREEN_PILLS);

            event.accept(ModItems.GAMBLER_SWORD);
            event.accept(ModItems.BLOOD_SWORD);
            event.accept(ModItems.SPEED_SWORD);

            event.accept(ModBlocks.SKELETON_BLOCK_1);
            event.accept(ModBlocks.SKELETON_BLOCK_2);
        }

        if(event.getTab() == CreativeModeTabs.COMBAT) {
            event.accept(ModItems.KNIFE_SWORD);
            event.accept(ModItems.BAT_SWORD);
            event.accept(ModItems.BROKEN_SWORD);

            event.accept(ModItems.RAIDER_SWORD);
            event.accept(ModItems.RAIDER_AXE);
            event.accept(ModItems.RAIDER_HELMET);
            event.accept(ModItems.RAIDER_CHESTPLATE);
            event.accept(ModItems.RAIDER_LEGGINGS);
            event.accept(ModItems.RAIDER_BOOTS);

            event.accept(ModItems.CHAINSWORD);

            event.accept(ModItems.GAMBLER_SWORD);
            event.accept(ModItems.BLOOD_SWORD);
            event.accept(ModItems.SPEED_SWORD);
        }
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            MenuScreens.register(ModMenuTypes.SKELETON_BLOCK_MENU.get(), SkeletonBlockScreen::new);
        }
    }
}
