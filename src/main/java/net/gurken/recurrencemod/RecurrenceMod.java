package net.gurken.recurrencemod;

import com.mojang.logging.LogUtils;
import net.gurken.recurrencemod.block.ModBlocks;
import net.gurken.recurrencemod.block.entity.ModBlockEntities;
import net.gurken.recurrencemod.entity.ModEntities;
import net.gurken.recurrencemod.entity.client.RaiderRenderer;
import net.gurken.recurrencemod.entity.client.VagabondThrowingKnifeRenderer;
import net.gurken.recurrencemod.faction_favour.ModNetworking;
import net.gurken.recurrencemod.init.RecFeatures;
import net.gurken.recurrencemod.item.ModCreativeModeTabs;
import net.gurken.recurrencemod.item.ModItemProperties;
import net.gurken.recurrencemod.item.ModItems;
import net.gurken.recurrencemod.recipe.ModRecipes;
import net.gurken.recurrencemod.screen.LunaticFactionForgeScreen;
import net.gurken.recurrencemod.screen.ModMenuTypes;
import net.gurken.recurrencemod.screen.NomadFactionForgeScreen;
import net.gurken.recurrencemod.screen.SkeletonBlockScreen;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.commands.ExperienceCommand;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import software.bernie.geckolib.GeckoLib;

import java.util.Locale;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(RecurrenceMod.MOD_ID)

public class RecurrenceMod
{
    public static final String MOD_ID = "recurrencemod";
    public static final Logger LOGGER = LogUtils.getLogger();

    public RecurrenceMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);
        ModRecipes.register(modEventBus);
        ModEntities.register(modEventBus);
        RecFeatures.FEATURES.register(modEventBus);

        GeckoLib.initialize();

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }

    public static ResourceLocation prefix(String name) {
        // METHOD ADAPTED FROM: TeamTwilight | https://github.com/TeamTwilight/twilightforest
        return new ResourceLocation(MOD_ID, name.toLowerCase(Locale.ROOT));
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() ->
        {
            ModNetworking.register();
            ComposterBlock.COMPOSTABLES.put(ModItems.ROTTEN_WOOD.get(), 0.3f);

            //TerraBlender
            // Weights are kept intentionally low as we add minimal biomes
            //Regions.register(new ModRegion1(new ResourceLocation(MOD_ID, "overworld_1"), 2));
            //Regions.register(new ModRegion2(new ResourceLocation(MOD_ID, "overworld_2"), 2));

            // Register our surface rules
            //SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MOD_ID, ModSurfaceRuleData.makeRules());
        });
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTab() == ModCreativeModeTabs.RECURRENCE_BLOCKS_TAB.get()) {
            event.accept(ModBlocks.SCORCHSTONE);
            event.accept(ModBlocks.GLIMMERING_SCORCHSTONE);
            event.accept(ModBlocks.DUSTSTONE);
            event.accept(ModBlocks.ASHSTONE);
            event.accept(ModBlocks.FRACTURESTONE);
            event.accept(ModBlocks.FUMESTONE);
            event.accept(ModBlocks.SPIRESTONE);
            event.accept(ModBlocks.SCORCHSLATE);
            event.accept(ModBlocks.SCORCHSHALE);
            event.accept(ModBlocks.SCORCHSCALE);
            event.accept(ModBlocks.SCORCHSHELL);

            event.accept(ModBlocks.SCORCHSTONE_BRICKS);
            event.accept(ModBlocks.FUSED_SCORCHSTONE);
            event.accept(ModBlocks.SCORCHSTONE_BRICK_STAIRS);
            event.accept(ModBlocks.SCORCHSTONE_BRICK_SLAB);

            event.accept(ModBlocks.SCORCHSLATE_BRICKS);
            event.accept(ModBlocks.FUSED_SCORCHSLATE);
            event.accept(ModBlocks.SCORCHSLATE_BRICK_STAIRS);
            event.accept(ModBlocks.SCORCHSLATE_BRICK_SLAB);

            event.accept(ModBlocks.SCORCHSHALE_BRICKS);
            event.accept(ModBlocks.FUSED_SCORCHSHALE);
            event.accept(ModBlocks.SCORCHSHALE_BRICK_STAIRS);
            event.accept(ModBlocks.SCORCHSHALE_BRICK_SLAB);

            event.accept(ModBlocks.SPIRESTONE_BRICKS);
            event.accept(ModBlocks.SPIRESTONE_BRICK_STAIRS);
            event.accept(ModBlocks.SPIRESTONE_BRICK_SLAB);

            event.accept(ModBlocks.ASHSTONE_BRICKS);
            event.accept(ModBlocks.ASHSTONE_BRICK_STAIRS);
            event.accept(ModBlocks.ASHSTONE_BRICK_SLAB);

            event.accept(ModBlocks.SCORCHSTONE_RUBBLE);
            event.accept(ModBlocks.METAL_BARS_BLOCK);
            event.accept(ModBlocks.METAL_BARS_SLAB);
            event.accept(ModBlocks.METAL_DOOR);
            event.accept(ModBlocks.METAL_TRAPDOOR);

            event.accept(ModBlocks.SCRAP_BLOCK);
            event.accept(ModBlocks.TIRE);
            event.accept(ModBlocks.LARGE_TIRE);
            event.accept(ModBlocks.RANCID_CARPET);
            event.accept(ModBlocks.IRON_BEAM);
            event.accept(ModBlocks.COPPER_BEAM);
            event.accept(ModBlocks.TIN_PILLAR);
            event.accept(ModBlocks.WARNING_PANEL_LEAD);
            event.accept(ModBlocks.WARNING_PANEL_TIN);
            event.accept(ModBlocks.BOLTED_SCRAPS_BLOCK);
            event.accept(ModBlocks.PLATED_IRON_PILLAR);
            event.accept(ModBlocks.LEAD_PANELLING);
            event.accept(ModBlocks.COPPER_PANELLING);
            event.accept(ModBlocks.METAL_GRATING);
            event.accept(ModBlocks.RUSTY_GRATING);
            event.accept(ModBlocks.METAL_PLATING);
            event.accept(ModBlocks.RUSTY_PLATING);
            event.accept(ModBlocks.PIPE);
            event.accept(ModBlocks.STEEL_PIPE);
            event.accept(ModBlocks.LEAD_FRAMED_GLASS);
            event.accept(ModBlocks.LIGHTBULB);
            event.accept(ModBlocks.COPPER_WIRING);
            event.accept(ModBlocks.PIPING);
            event.accept(ModBlocks.BATTERY);
            event.accept(ModBlocks.LIGHTBULB);
            event.accept(ModBlocks.METAL_STRUTS);

            event.accept(ModBlocks.CRATE_FOOD);
            event.accept(ModBlocks.CRATE_COMMON);
            event.accept(ModBlocks.CRATE_GOOD);
            event.accept(ModBlocks.CRATE_RARE);
            event.accept(ModBlocks.CRATE_EPIC);
            event.accept(ModBlocks.CRATE_LEGENDARY);

            event.accept(ModBlocks.DIAMOND_DEPOSIT);
            event.accept(ModBlocks.EMERALD_DEPOSIT);
            event.accept(ModBlocks.DIAMOND_CLUSTER);
            event.accept(ModBlocks.EMERALD_CLUSTER);

            event.accept(ModBlocks.GRAFFITI_SPRAY_BLUE);
            event.accept(ModBlocks.GRAFFITI_SPRAY_RED);
            event.accept(ModBlocks.GRAFFITI_SPRAY_YELLOW);
            event.accept(ModBlocks.GRAFFITI_SPRAY_GREEN);
            event.accept(ModBlocks.GRAFFITI_SPRAY_ORANGE);
            event.accept(ModBlocks.GRAFFITI_SPRAY_PURPLE);
            event.accept(ModBlocks.GRAFFITI_SPRAY_LIGHT_GREY);
            event.accept(ModBlocks.GRAFFITI_SPRAY_LIGHT_GREEN);
            event.accept(ModBlocks.GRAFFITI_SPRAY_DARK_GREY);
            event.accept(ModBlocks.GRAFFITI_SPRAY_WHITE);
            event.accept(ModBlocks.GRAFFITI_SPRAY_PINK);

            event.accept(ModBlocks.SKELETON_BLOCK);
            event.accept(ModBlocks.SCATTERED_SKELETON_BLOCK);
            event.accept(ModBlocks.SKELETON_BLOCK_ADJUSTABLE);
        }

        if(event.getTab() == ModCreativeModeTabs.RECURRENCE_MATERIALS_TAB.get()) {
            event.accept(ModItems.KNIFE_SWORD);
            event.accept(ModItems.BAT_SWORD);
            event.accept(ModItems.BROKEN_SWORD);

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

            event.accept(ModItems.GAMBLER_SWORD);
            event.accept(ModItems.BLOOD_SWORD);
            event.accept(ModItems.SPEED_SWORD);
        }

        if(event.getTab() == ModCreativeModeTabs.RECURRENCE_FACTIONS_TAB.get()) {

            event.accept(ModItems.RAIDER_SWORD);
            event.accept(ModItems.RAIDER_AXE);
            event.accept(ModItems.RAIDER_HELMET);
            event.accept(ModItems.RAIDER_CHESTPLATE);
            event.accept(ModItems.RAIDER_LEGGINGS);
            event.accept(ModItems.RAIDER_BOOTS);
            event.accept(ModItems.RAIDER_PLATINGS);
            event.accept(ModItems.RAIDER_SPAWN_EGG);

            event.accept(ModItems.LUNATIC_CHAINSWORD);
            event.accept(ModItems.CHEMDRILL);
            event.accept(ModItems.BLUE_PILLS);
            event.accept(ModItems.RED_PILLS);
            event.accept(ModItems.YELLOW_PILLS);
            event.accept(ModItems.GREEN_PILLS);
            event.accept(ModItems.LUNATIC_PLATINGS);
            event.accept(ModBlocks.LUNATIC_FACTION_FORGE);

            event.accept(ModItems.NOMAD_SWORD);
            event.accept(ModItems.NOMAD_HELMET);
            event.accept(ModItems.NOMAD_CHESTPLATE);
            event.accept(ModItems.NOMAD_LEGGINGS);
            event.accept(ModItems.NOMAD_BOOTS);
            event.accept(ModBlocks.NOMAD_FACTION_FORGE);

            event.accept(ModItems.VAGABOND_SWORD);
            event.accept(ModItems.VAGABOND_THROWING_KNIFE);

            event.accept(ModItems.RUINATED_HELMET);
            event.accept(ModItems.RUINATED_CHESTPLATE);
            event.accept(ModItems.RUINATED_LEGGINGS);
            event.accept(ModItems.RUINATED_BOOTS);
            event.accept(ModItems.RUINATED_PLATINGS);
        }
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            event.enqueueWork(() -> {
                ModItemProperties.addCustomItemProperties();

                MenuScreens.register(ModMenuTypes.SKELETON_BLOCK_MENU.get(), SkeletonBlockScreen::new);
                MenuScreens.register(ModMenuTypes.NOMAD_FACTION_FORGE_MENU.get(), NomadFactionForgeScreen::new);
                MenuScreens.register(ModMenuTypes.LUNATIC_FACTION_FORGE_MENU.get(), LunaticFactionForgeScreen::new);

                EntityRenderers.register(ModEntities.RAIDER.get(), RaiderRenderer::new);

                EntityRenderers.register(ModEntities.VAGABOND_THROWING_KNIFE.get(), VagabondThrowingKnifeRenderer::new);

                ItemBlockRenderTypes.setRenderLayer(ModBlocks.LEAD_FRAMED_GLASS.get(), RenderType.cutout());
            });
        }
    }
}
