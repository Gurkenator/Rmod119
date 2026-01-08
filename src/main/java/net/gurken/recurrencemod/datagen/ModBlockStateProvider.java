package net.gurken.recurrencemod.datagen;

import net.gurken.recurrencemod.RecurrenceMod;
import net.gurken.recurrencemod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, RecurrenceMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.SCORCHSTONE);
        blockWithItem(ModBlocks.SCORCHSTONE_BRICKS);
        stairsBlock((StairBlock) ModBlocks.SCORCHSTONE_BRICK_STAIRS.get(), blockTexture(ModBlocks.SCORCHSTONE_BRICKS.get()));
        slabBlock((SlabBlock) ModBlocks.SCORCHSTONE_BRICK_SLAB.get(), blockTexture(ModBlocks.SCORCHSTONE_BRICKS.get()), blockTexture(ModBlocks.SCORCHSTONE_BRICKS.get()));
        blockWithItem(ModBlocks.SCORCHSLATE);
        blockWithItem(ModBlocks.SCORCHSLATE_BRICKS);
        stairsBlock((StairBlock) ModBlocks.SCORCHSLATE_BRICK_STAIRS.get(), blockTexture(ModBlocks.SCORCHSLATE_BRICKS.get()));
        slabBlock((SlabBlock) ModBlocks.SCORCHSLATE_BRICK_SLAB.get(), blockTexture(ModBlocks.SCORCHSLATE_BRICKS.get()), blockTexture(ModBlocks.SCORCHSLATE_BRICKS.get()));
        blockWithItem(ModBlocks.SCORCHSCALE);

    }

    private String name(Block block) {
        return key(block).getPath();
    }

    private ResourceLocation key(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block);
    }

    private void leavesBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().cubeAll(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject, String appendix) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("recurrencemod:block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath() + appendix));
    }
    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("recurrencemod:block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }
    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
