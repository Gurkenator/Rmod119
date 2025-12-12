package net.gurken.recurrencemod.block;

import net.gurken.recurrencemod.RecurrenceMod;
import net.gurken.recurrencemod.block.custom.*;
import net.gurken.recurrencemod.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, RecurrenceMod.MOD_ID);

    public static final RegistryObject<Block> SCORCHSTONE = registerBlock("scorchstone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(4f, 6f).mapColor(MapColor.COLOR_BLACK).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> GLIMMERING_SCORCHSTONE = registerBlock("glimmering_scorchstone",
            () -> new ModGlimmeringBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(4f, 6f).mapColor(MapColor.COLOR_ORANGE).requiresCorrectToolForDrops().randomTicks()));
    public static final RegistryObject<Block> DUSTSTONE = registerBlock("duststone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(4f, 6f).mapColor(MapColor.COLOR_GRAY).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> ASHSTONE = registerBlock("ashstone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(4f, 6f).mapColor(MapColor.SNOW).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> FRACTURESTONE = registerBlock("fracturestone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(4f, 3f).mapColor(MapColor.COLOR_LIGHT_GRAY).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SCORCHSLATE = registerBlock("scorchslate",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(6f, 9f).mapColor(MapColor.COLOR_BLACK).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SCORCHSHALE = registerBlock("scorchshale",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2f, 3f).mapColor(MapColor.COLOR_BLACK).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> SCORCHSCALE = registerBlock("scorchscale",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2f, 3f).mapColor(MapColor.COLOR_BLACK).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> SCORCHSHELL = registerBlock("scorchshell",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2f, 3f).mapColor(MapColor.COLOR_BLACK).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> FUMESTONE = registerBlock("fumestone",
            () -> new ModFumeBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(4f, 3f).mapColor(MapColor.COLOR_LIGHT_GRAY).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SPIRESTONE = registerBlock("spirestone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(4f, 6f).mapColor(MapColor.COLOR_GRAY).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> SCORCHSTONE_RUBBLE = registerBlock("scorchstone_rubble",
            () -> new ModRubbleBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(1.5f, 3f).mapColor(MapColor.COLOR_BLACK).noCollission().noOcclusion()));

    public static final RegistryObject<Block> SCRAP_BLOCK = registerBlock("scrap_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .strength(1.5f, 1.5f).mapColor(MapColor.METAL)));
    public static final RegistryObject<Block> IRON_BEAM = registerBlock("iron_beam",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .strength(4f, 4f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> COPPER_BEAM = registerBlock("copper_beam",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.COPPER_BLOCK)
                    .strength(4f, 4f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> TIN_PILLAR = registerBlock("tin_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .strength(4f, 4f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> WARNING_PANEL_LEAD = registerBlock("warning_panel_lead",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .strength(4f, 4f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> WARNING_PANEL_TIN = registerBlock("warning_panel_tin",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .strength(4f, 4f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> BOLTED_SCRAPS_BLOCK = registerBlock("bolted_scraps_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .strength(4f, 4f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> PLATED_IRON_PILLAR = registerBlock("plated_iron_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .strength(4f, 4f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> LEAD_PANELLING = registerBlock("lead_panelling",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .strength(4f, 4f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> COPPER_PANELLING = registerBlock("copper_panelling",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COPPER_BLOCK)
                    .strength(4f, 4f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> RUSTY_GRATING = registerBlock("rusty_grating",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COPPER_BLOCK)
                    .strength(4f, 4f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> RUSTY_PLATING = registerBlock("rusty_plating",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COPPER_BLOCK)
                    .strength(4f, 4f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> METAL_GRATING = registerBlock("metal_grating",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .strength(4f, 4f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> METAL_PLATING = registerBlock("metal_plating",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .strength(4f, 4f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> PIPE = registerBlock("pipe",
            () -> new ModPipeBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()
                    .strength(3f, 4.5f).mapColor(MapColor.COLOR_YELLOW).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> STEEL_PIPE = registerBlock("steel_pipe",
            () -> new ModPipeBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()
                    .strength(3f, 4.5f).mapColor(MapColor.COLOR_GRAY).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> LEAD_FRAMED_GLASS = registerBlock("lead_framed_glass",
            () -> new GlassBlock(BlockBehaviour.Properties.copy(Blocks.GLASS)));

    public static final RegistryObject<Block> LIGHTBULB = registerBlock("lightbulb",
            () -> new LightbulbBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).lightLevel((p_50755_) -> 11)
                    .strength(0.5f, 0.5f).sound(SoundType.GLASS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> COPPER_WIRING = registerBlock("copper_wiring",
            () -> new ModWiringBlock(BlockBehaviour.Properties.of().noOcclusion().noCollission()
                    .strength(1f, 1f).mapColor(MapColor.COLOR_ORANGE).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> PIPING = registerBlock("piping",
            () -> new ClimbablePipingBlock(BlockBehaviour.Properties.of().noOcclusion()
                    .strength(1f, 1f).mapColor(MapColor.COLOR_ORANGE).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> METAL_STRUTS = registerBlock("metal_struts",
            () -> new ModStrutBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()
                    .strength(3f, 3f).mapColor(MapColor.COLOR_GRAY).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> RANCID_CARPET = registerBlock("rancid_carpet",
            () -> new CarpetBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CARPET)
                    .strength(0.1f, 0.1f).sound(SoundType.WOOL).mapColor(MapColor.COLOR_LIGHT_GRAY).ignitedByLava()));
    public static final RegistryObject<Block> TIRE = registerBlock("tire",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .strength(2.0f, 2.0f).mapColor(MapColor.COLOR_GRAY), 10, 20));
    public static final RegistryObject<Block> LARGE_TIRE = registerBlock("large_tire",
            () -> new ModFlammableBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .strength(2.0f, 2.0f).mapColor(MapColor.COLOR_GRAY), 10, 20));
    public static final RegistryObject<Block> METAL_BARS_BLOCK = registerBlock("metal_bars_block",
            () -> new HalfTransparentBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BARS)
                    .strength(0.5f, 0.6f).requiresCorrectToolForDrops().sound(SoundType.METAL).noOcclusion()));
    public static final RegistryObject<Block> METAL_BARS_SLAB = registerBlock("metal_bars_slab",
            () -> new HalfTransparentSlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BARS)
                    .strength(0.5f, 0.6f).requiresCorrectToolForDrops().sound(SoundType.METAL).noOcclusion()));
    public static final RegistryObject<Block> METAL_DOOR = registerBlock("metal_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2f, 2f).requiresCorrectToolForDrops().sound(SoundType.METAL).noOcclusion(), BlockSetType.STONE));
    public static final RegistryObject<Block> METAL_TRAPDOOR = registerBlock("metal_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2f, 2f).requiresCorrectToolForDrops().sound(SoundType.METAL).noOcclusion(), BlockSetType.STONE));

    public static final RegistryObject<Block> SCORCHSTONE_BRICKS = registerBlock("scorchstone_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)
                    .strength(4f, 6f).mapColor(MapColor.COLOR_BLACK).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> FUSED_SCORCHSTONE = registerBlock("fused_scorchstone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)
                    .strength(4f, 6f).mapColor(MapColor.COLOR_BLACK).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SCORCHSTONE_BRICK_STAIRS = registerBlock("scorchstone_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.SCORCHSTONE_BRICKS.get().defaultBlockState(),BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS)
                    .strength(4f, 6f).mapColor(MapColor.COLOR_BLACK).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SCORCHSTONE_BRICK_SLAB = registerBlock("scorchstone_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)
                    .strength(4f, 6f).mapColor(MapColor.COLOR_BLACK).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> SCORCHSLATE_BRICKS = registerBlock("scorchslate_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)
                    .strength(6f, 9f).mapColor(MapColor.COLOR_BLACK).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> FUSED_SCORCHSLATE = registerBlock("fused_scorchslate",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)
                    .strength(6f, 9f).mapColor(MapColor.COLOR_BLACK).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SCORCHSLATE_BRICK_STAIRS = registerBlock("scorchslate_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.SCORCHSLATE_BRICKS.get().defaultBlockState(),BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS)
                    .strength(6f, 9f).mapColor(MapColor.COLOR_BLACK).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SCORCHSLATE_BRICK_SLAB = registerBlock("scorchslate_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)
                    .strength(6f, 9f).mapColor(MapColor.COLOR_BLACK).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> SCORCHSHALE_BRICKS = registerBlock("scorchshale_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)
                    .strength(2f, 3f).mapColor(MapColor.COLOR_BLACK).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> FUSED_SCORCHSHALE = registerBlock("fused_scorchshale",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)
                    .strength(2f, 3f).mapColor(MapColor.COLOR_BLACK).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SCORCHSHALE_BRICK_STAIRS = registerBlock("scorchshale_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.SCORCHSHALE_BRICKS.get().defaultBlockState(),BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS)
                    .strength(2f, 3f).mapColor(MapColor.COLOR_BLACK).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SCORCHSHALE_BRICK_SLAB = registerBlock("scorchshale_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)
                    .strength(2f, 3f).mapColor(MapColor.COLOR_BLACK).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SPIRESTONE_BRICKS = registerBlock("spirestone_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)
                    .strength(4f, 6f).mapColor(MapColor.COLOR_GRAY).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SPIRESTONE_BRICK_STAIRS = registerBlock("spirestone_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.SPIRESTONE_BRICKS.get().defaultBlockState(),BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS)
                    .strength(4f, 6f).mapColor(MapColor.COLOR_GRAY).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SPIRESTONE_BRICK_SLAB = registerBlock("spirestone_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)
                    .strength(4f, 6f).mapColor(MapColor.COLOR_GRAY).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> ASHSTONE_BRICKS = registerBlock("ashstone_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)
                    .strength(4f, 6f).mapColor(MapColor.COLOR_LIGHT_GRAY).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> ASHSTONE_BRICK_STAIRS = registerBlock("ashstone_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.ASHSTONE_BRICKS.get().defaultBlockState(),BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS)
                    .strength(4f, 6f).mapColor(MapColor.COLOR_LIGHT_GRAY).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> ASHSTONE_BRICK_SLAB = registerBlock("ashstone_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)
                    .strength(4f, 6f).mapColor(MapColor.COLOR_LIGHT_GRAY).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> GRAFFITI_SPRAY_BLUE = registerBlock("graffiti_spray_blue",
            () -> new ModMultifaceBlock(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.SNARE)
                    .strength(0.5f, 1.0f).noOcclusion().instabreak().noCollission()));
    public static final RegistryObject<Block> GRAFFITI_SPRAY_RED = registerBlock("graffiti_spray_red",
            () -> new ModMultifaceBlock(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.SNARE)
                    .strength(0.5f, 1.0f).noOcclusion().instabreak().noCollission()));
    public static final RegistryObject<Block> GRAFFITI_SPRAY_YELLOW = registerBlock("graffiti_spray_yellow",
            () -> new ModMultifaceBlock(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.SNARE)
                    .strength(0.5f, 1.0f).noOcclusion().instabreak().noCollission()));
    public static final RegistryObject<Block> GRAFFITI_SPRAY_GREEN = registerBlock("graffiti_spray_green",
            () -> new ModMultifaceBlock(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.SNARE)
                    .strength(0.5f, 1.0f).noOcclusion().instabreak().noCollission()));
    public static final RegistryObject<Block> GRAFFITI_SPRAY_ORANGE = registerBlock("graffiti_spray_orange",
            () -> new ModMultifaceBlock(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.SNARE)
                    .strength(0.5f, 1.0f).noOcclusion().instabreak().noCollission()));
    public static final RegistryObject<Block> GRAFFITI_SPRAY_PURPLE = registerBlock("graffiti_spray_purple",
            () -> new ModMultifaceBlock(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.SNARE)
                    .strength(0.5f, 1.0f).noOcclusion().instabreak().noCollission()));
    public static final RegistryObject<Block> GRAFFITI_SPRAY_LIGHT_GREY = registerBlock("graffiti_spray_light_grey",
            () -> new ModMultifaceBlock(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.SNARE)
                    .strength(0.5f, 1.0f).noOcclusion().instabreak().noCollission()));
    public static final RegistryObject<Block> GRAFFITI_SPRAY_LIGHT_GREEN = registerBlock("graffiti_spray_light_green",
            () -> new ModMultifaceBlock(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.SNARE)
                    .strength(0.5f, 1.0f).noOcclusion().instabreak().noCollission()));
    public static final RegistryObject<Block> GRAFFITI_SPRAY_DARK_GREY = registerBlock("graffiti_spray_dark_grey",
            () -> new ModMultifaceBlock(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.SNARE)
                    .strength(0.5f, 1.0f).noOcclusion().instabreak().noCollission()));
    public static final RegistryObject<Block> GRAFFITI_SPRAY_WHITE = registerBlock("graffiti_spray_white",
            () -> new ModMultifaceBlock(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.SNARE)
                    .strength(0.5f, 1.0f).noOcclusion().instabreak().noCollission()));
    public static final RegistryObject<Block> GRAFFITI_SPRAY_PINK = registerBlock("graffiti_spray_pink",
            () -> new ModMultifaceBlock(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.SNARE)
                    .strength(0.5f, 1.0f).noOcclusion().instabreak().noCollission()));

    public static final RegistryObject<Block> CRATE_FOOD = registerBlock("crate_food",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)
                    .strength(1.8f, 3.0f), UniformInt.of(1, 2)));
    public static final RegistryObject<Block> CRATE_COMMON = registerBlock("crate_common",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)
                    .strength(1.8f, 3.0f), UniformInt.of(1, 2)));
    public static final RegistryObject<Block> CRATE_GOOD = registerBlock("crate_good",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)
                    .strength(1.8f, 3.0f), UniformInt.of(1, 2)));
    public static final RegistryObject<Block> CRATE_RARE = registerBlock("crate_rare",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)
                    .strength(1.8f, 3.0f), UniformInt.of(1, 2)));
    public static final RegistryObject<Block> CRATE_EPIC = registerBlock("crate_epic",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)
                    .strength(1.8f, 3.0f), UniformInt.of(1, 2)));
    public static final RegistryObject<Block> CRATE_LEGENDARY = registerBlock("crate_legendary",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)
                    .strength(1.8f, 3.0f), UniformInt.of(1, 2)));

    public static final RegistryObject<Block> DIAMOND_DEPOSIT = registerBlock("diamond_deposit",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK)
                    .strength(5f, 6f).mapColor(MapColor.DIAMOND).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> EMERALD_DEPOSIT = registerBlock("emerald_deposit",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_BLOCK)
                    .strength(5f, 6f).mapColor(MapColor.EMERALD).requiresCorrectToolForDrops()));
    public static final RegistryObject<ModClusterBlock> DIAMOND_CLUSTER = registerBlock("diamond_cluster",
            () -> new ModClusterBlock(3, BlockBehaviour.Properties.copy(Blocks.AMETHYST_CLUSTER)
                    .strength(1.5f).forceSolidOn().noOcclusion().mapColor(MapColor.DIAMOND).requiresCorrectToolForDrops()));
    public static final RegistryObject<ModClusterBlock> EMERALD_CLUSTER = registerBlock("emerald_cluster",
            () -> new ModClusterBlock(3, BlockBehaviour.Properties.copy(Blocks.AMETHYST_CLUSTER)
                    .strength(1.5f).forceSolidOn().noOcclusion().mapColor(MapColor.EMERALD).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> BATTERY = registerBlock("battery",
            () -> new BatteryBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .strength(2.0f, 5.0f)));
    public static final RegistryObject<Block> SKELETON_BLOCK = registerBlock("skeleton_block",
            () -> new SkeletonBlock(BlockBehaviour.Properties.copy(Blocks.SKELETON_SKULL)
                    .strength(6.0f, 18.0f).noOcclusion().noCollission().mapColor(MapColor.TERRACOTTA_WHITE)));
    public static final RegistryObject<Block> SCATTERED_SKELETON_BLOCK = registerBlock("scattered_skeleton_block",
            () -> new SkeletonBlock(BlockBehaviour.Properties.copy(Blocks.SKELETON_SKULL)
                    .strength(6.0f, 18.0f).noOcclusion().noCollission().mapColor(MapColor.TERRACOTTA_WHITE)));

    public static final RegistryObject<Block> NOMAD_FACTION_FORGE = registerBlock("nomad_faction_forge",
            () -> new NomadFactionForgeBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> LUNATIC_FACTION_FORGE = registerBlock("lunatic_faction_forge",
            () -> new LunaticFactionForgeBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));

    public static final RegistryObject<Block> SKELETON_BLOCK_ADJUSTABLE = registerBlock("skeleton_block_adjustable",
            () -> new SkeletonBlock(BlockBehaviour.Properties.copy(Blocks.SKELETON_SKULL)
                    .strength(6.0f, 18.0f).noOcclusion().noCollission().mapColor(MapColor.TERRACOTTA_WHITE)));

    public static final RegistryObject<Block> PROXY_BLOCK_1 = registerBlock("proxy_block_1",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(-1.0F, 3600000.0F).noLootTable()));
    public static final RegistryObject<Block> PROXY_BLOCK_2 = registerBlock("proxy_block_2",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(-1.0F, 3600000.0F).noLootTable()));
    public static final RegistryObject<Block> PROXY_BLOCK_3 = registerBlock("proxy_block_3",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(-1.0F, 3600000.0F).noLootTable()));
    public static final RegistryObject<Block> PROXY_BLOCK_4 = registerBlock("proxy_block_4",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(-1.0F, 3600000.0F).noLootTable()));
    public static final RegistryObject<Block> PROXY_BLOCK_5 = registerBlock("proxy_block_5",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(-1.0F, 3600000.0F).noLootTable()));
    public static final RegistryObject<Block> PROXY_BLOCK_6 = registerBlock("proxy_block_6",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(-1.0F, 3600000.0F).noLootTable()));
    public static final RegistryObject<Block> PROXY_BLOCK_7 = registerBlock("proxy_block_7",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(-1.0F, 3600000.0F).noLootTable()));
    public static final RegistryObject<Block> PROXY_BLOCK_8 = registerBlock("proxy_block_8",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(-1.0F, 3600000.0F).noLootTable()));
    public static final RegistryObject<Block> PROXY_BLOCK_9 = registerBlock("proxy_block_9",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(-1.0F, 3600000.0F).noLootTable()));
    public static final RegistryObject<Block> PROXY_BLOCK_10 = registerBlock("proxy_block_10",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(-1.0F, 3600000.0F).noLootTable()));
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        if (name.equals("rancid_carpet"))
            return ModItems.ITEMS.register(name,() -> new RancidCarpetBlockItem(block.get(), new Item.Properties()));
        else if (name.equals("tire"))
            return ModItems.ITEMS.register(name,() -> new TireBlockItem(block.get(), new Item.Properties()));
        else if (name.equals("large_tire"))
            return ModItems.ITEMS.register(name,() -> new TireBlockItem(block.get(), new Item.Properties()));
        else
            return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {

        BLOCKS.register(eventBus);
    }
}
