package net.gurken.recurrencemod.item;

import net.gurken.recurrencemod.block.ModBlocks;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModTiers {

    public static final ForgeTier RANCID_CARPET = new ForgeTier(2, 650, 7.0f,
            5.5f, 8, BlockTags.NEEDS_STONE_TOOL,
            () -> Ingredient.of(ModBlocks.RANCID_CARPET.get()));
    public static final ForgeTier RAIDER = new ForgeTier(2, 650, 7.0f,
            5.5f, 8, BlockTags.NEEDS_IRON_TOOL,
            () -> Ingredient.of(ModItems.RAIDER_PLATINGS.get()));

    public static final ForgeTier LUNATIC = new ForgeTier(2, 650, 7.0f,
            5.5f, 8, BlockTags.NEEDS_IRON_TOOL,
            () -> Ingredient.of(ModItems.LUNATIC_PLATINGS.get()));

    public static final ForgeTier NOMAD = new ForgeTier(2, 650, 7.0f,
            5.5f, 8, BlockTags.NEEDS_IRON_TOOL,
            () -> Ingredient.of(ModItems.ALUMINIUM_SCRAPS.get()));

    public static final ForgeTier BONE = new ForgeTier(4, 1500, 8.5f,
            8.0f, 25, BlockTags.NEEDS_DIAMOND_TOOL,
            () -> Ingredient.of(Items.BONE));

    public static final ForgeTier ROTTEN_WOOD = new ForgeTier(0, 20, 8.5f,
            4.0f, 4, BlockTags.NEEDS_STONE_TOOL,
            () -> Ingredient.of(ModItems.ROTTEN_WOOD.get()));

    public static final ForgeTier IRON_SCRAPS_KNIFE = new ForgeTier(2, 100, 8.5f,
            3.0f, 12, BlockTags.NEEDS_STONE_TOOL,
            () -> Ingredient.of(ModItems.IRON_SCRAPS.get()));

    public static final ForgeTier IRON_SCRAPS_BROKEN = new ForgeTier(2, 36, 8.5f,
            2.0f, 8, BlockTags.NEEDS_STONE_TOOL,
            () -> Ingredient.of(ModItems.IRON_SCRAPS.get()));
}
