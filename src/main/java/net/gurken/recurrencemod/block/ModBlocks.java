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
                    .strength(6f, 9f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> GLIMMERING_SCORCHSTONE = registerBlock("glimmering_scorchstone",
            () -> new ModGlimmeringBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(3f, 3f).requiresCorrectToolForDrops().randomTicks()));
    public static final RegistryObject<Block> DUSTSTONE = registerBlock("duststone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(6f, 9f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> PALESTONE = registerBlock("palestone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(6f, 9f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> FRACTURESTONE = registerBlock("fracturestone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(6f, 9f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SCORCHSLATE = registerBlock("scorchslate",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(6f, 9f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> FUMESTONE = registerBlock("fumestone",
            () -> new ModFumeBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(3f, 3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SPIRESTONE = registerBlock("spirestone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(6f, 9f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> SCORCHSTONE_RUBBLE = registerBlock("scorchstone_rubble",
            () -> new ModRubbleBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(3f, 4.5f).noCollission().noOcclusion()));

    public static final RegistryObject<Block> SCRAP_BLOCK = registerBlock("scrap_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .strength(1.5f, 1.5f)));
    public static final RegistryObject<Block> METAL_BEAM = registerBlock("metal_beam",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .strength(4f, 4f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> PIPE = registerBlock("pipe",
            () -> new ModPipeBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()
                    .strength(4f, 4f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> METAL_STRUTS = registerBlock("metal_struts",
            () -> new ModStrutBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()
                    .strength(4f, 4f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> RANCID_CARPET = registerBlock("rancid_carpet",
            () -> new CarpetBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CARPET)
                    .strength(0.5f, 1f).noOcclusion()));
    public static final RegistryObject<Block> TIRE = registerBlock("tire",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .strength(2.0f, 2.0f), 10, 20));
    public static final RegistryObject<Block> METAL_BARS_BLOCK = registerBlock("metal_bars_block",
            () -> new HalfTransparentBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BARS)
                    .strength(2f, 2f).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> METAL_BARS_SLAB = registerBlock("metal_bars_slab",
            () -> new HalfTransparentSlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BARS)
                    .strength(2f, 2f).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> METAL_DOOR = registerBlock("metal_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2f, 2f).requiresCorrectToolForDrops().noOcclusion(), BlockSetType.STONE));
    public static final RegistryObject<Block> METAL_TRAPDOOR = registerBlock("metal_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2f, 2f).requiresCorrectToolForDrops().noOcclusion(), BlockSetType.STONE));

    public static final RegistryObject<Block> SPIRESTONE_BRICKS = registerBlock("spirestone_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)
                    .strength(6f, 9f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SPIRESTONE_BRICK_STAIRS = registerBlock("spirestone_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.SPIRESTONE_BRICKS.get().defaultBlockState(),BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS)
                    .strength(6f, 9f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SPIRESTONE_BRICK_SLAB = registerBlock("spirestone_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)
                    .strength(6f, 9f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> PALESTONE_BRICKS = registerBlock("palestone_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)
                    .strength(6f, 9f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> PALESTONE_BRICK_STAIRS = registerBlock("palestone_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.PALESTONE_BRICKS.get().defaultBlockState(),BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS)
                    .strength(6f, 9f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> PALESTONE_BRICK_SLAB = registerBlock("palestone_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)
                    .strength(6f, 9f).requiresCorrectToolForDrops()));

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

    public static final RegistryObject<Block> DIAMOND_CLUSTER = registerBlock("diamond_cluster",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK)
                    .strength(6f, 9f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> EMERALD_CLUSTER = registerBlock("emerald_cluster",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_BLOCK)
                    .strength(6f, 9f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SKELETON_BLOCK = registerBlock("skeleton_block",
            () -> new SkeletonBlock(BlockBehaviour.Properties.copy(Blocks.SKELETON_SKULL)
                    .strength(6.0f, 18.0f).noOcclusion().noCollission()));
    public static final RegistryObject<Block> SCATTERED_SKELETON_BLOCK = registerBlock("scattered_skeleton_block",
            () -> new SkeletonBlock(BlockBehaviour.Properties.copy(Blocks.SKELETON_SKULL)
                    .strength(6.0f, 18.0f).noOcclusion().noCollission()));

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
        else
            return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {

        BLOCKS.register(eventBus);
    }
}
