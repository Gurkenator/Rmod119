package net.gurken.recurrencemod.entity;

import net.gurken.recurrencemod.RecurrenceMod;
import net.gurken.recurrencemod.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, RecurrenceMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<SkeletonBlockBlockEntity>> SKELETON_BLOCK =
            BLOCK_ENTITIES.register("skeleton_block", () -> BlockEntityType.Builder.of(SkeletonBlockBlockEntity::new, ModBlocks.SKELETON_BLOCK_1.get(), ModBlocks.SKELETON_BLOCK_2.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
