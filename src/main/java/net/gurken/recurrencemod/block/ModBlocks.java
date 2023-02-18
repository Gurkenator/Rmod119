package net.gurken.recurrencemod.block;

import net.gurken.recurrencemod.RecurrenceMod;
import net.gurken.recurrencemod.block.custom.*;
import net.gurken.recurrencemod.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CarpetBlock;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, RecurrenceMod.MOD_ID);

    public static final RegistryObject<Block> SCORCHSTONE = registerBlock("scorchstone",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops().explosionResistance(9f)));
    public static final RegistryObject<Block> SCRAP_BLOCK = registerBlock("scrap_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(1.5f).explosionResistance(1.5f)));

    public static final RegistryObject<Block> METAL_BEAM = registerBlock("metal_beam",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(4f).requiresCorrectToolForDrops().explosionResistance(9f)));
    public static final RegistryObject<Block> RANCID_CARPET = registerBlock("rancid_carpet",
            () -> new CarpetBlock(BlockBehaviour.Properties.of(Material.DECORATION)
                    .strength(0.5f).noOcclusion().explosionResistance(1f)));
    public static final RegistryObject<Block> TIRE = registerBlock("tire",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(2.0f).explosionResistance(2.0f), 10, 20));
    public static final RegistryObject<Block> GRAFFITI_SPRAY_BLUE = registerBlock("graffiti_spray_blue",
            () -> new ModMultifaceBlock(BlockBehaviour.Properties.of(Material.DECORATION)
                    .strength(0.5f).noOcclusion().explosionResistance(1f).instabreak().noCollission()));
    public static final RegistryObject<Block> GRAFFITI_SPRAY_RED = registerBlock("graffiti_spray_red",
            () -> new ModMultifaceBlock(BlockBehaviour.Properties.of(Material.DECORATION)
                    .strength(0.5f).noOcclusion().explosionResistance(1f).instabreak().noCollission()));
    public static final RegistryObject<Block> GRAFFITI_SPRAY_YELLOW = registerBlock("graffiti_spray_yellow",
            () -> new ModMultifaceBlock(BlockBehaviour.Properties.of(Material.DECORATION)
                    .strength(0.5f).noOcclusion().explosionResistance(1f).instabreak().noCollission()));
    public static final RegistryObject<Block> GRAFFITI_SPRAY_GREEN = registerBlock("graffiti_spray_green",
            () -> new ModMultifaceBlock(BlockBehaviour.Properties.of(Material.DECORATION)
                    .strength(0.5f).noOcclusion().explosionResistance(1f).instabreak().noCollission()));
    public static final RegistryObject<Block> GRAFFITI_SPRAY_ORANGE = registerBlock("graffiti_spray_orange",
            () -> new ModMultifaceBlock(BlockBehaviour.Properties.of(Material.DECORATION)
                    .strength(0.5f).noOcclusion().explosionResistance(1f).instabreak().noCollission()));
    public static final RegistryObject<Block> GRAFFITI_SPRAY_PURPLE = registerBlock("graffiti_spray_purple",
            () -> new ModMultifaceBlock(BlockBehaviour.Properties.of(Material.DECORATION)
                    .strength(0.5f).noOcclusion().explosionResistance(1f).instabreak().noCollission()));
    public static final RegistryObject<Block> GRAFFITI_SPRAY_LIGHT_GREY = registerBlock("graffiti_spray_light_grey",
            () -> new ModMultifaceBlock(BlockBehaviour.Properties.of(Material.DECORATION)
                    .strength(0.5f).noOcclusion().explosionResistance(1f).instabreak().noCollission()));

    public static final RegistryObject<Block> CRATE_FOOD = registerBlock("crate_food",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(1.8f).explosionResistance(3f), UniformInt.of(1, 2)));
    public static final RegistryObject<Block> CRATE_COMMON = registerBlock("crate_common",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(1.8f).explosionResistance(3f), UniformInt.of(1, 2)));
    public static final RegistryObject<Block> CRATE_GOOD = registerBlock("crate_good",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(1.8f).explosionResistance(3f), UniformInt.of(1, 2)));
    public static final RegistryObject<Block> CRATE_RARE = registerBlock("crate_rare",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(1.8f).explosionResistance(3f), UniformInt.of(1, 2)));
    public static final RegistryObject<Block> CRATE_EPIC = registerBlock("crate_epic",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(1.8f).explosionResistance(3f), UniformInt.of(1, 2)));
    public static final RegistryObject<Block> CRATE_LEGENDARY = registerBlock("crate_legendary",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(1.8f).explosionResistance(3f), UniformInt.of(1, 2)));

    public static final RegistryObject<Block> SKELETON_BLOCK_1 = registerBlock("skeleton_block_1",
            () -> new SkeletonBlock(BlockBehaviour.Properties.of(Material.DECORATION)
                    .strength(6.0f).noOcclusion().explosionResistance(18f).noCollission()));
    public static final RegistryObject<Block> SKELETON_BLOCK_2 = registerBlock("skeleton_block_2",
            () -> new SkeletonBlock(BlockBehaviour.Properties.of(Material.DECORATION)
                    .strength(6.0f).noOcclusion().explosionResistance(18f).noCollission()));
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
