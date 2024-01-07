package net.gurken.recurrencemod.entity;

import net.gurken.recurrencemod.RecurrenceMod;
import net.gurken.recurrencemod.entity.custom.RaiderEntity;
import net.gurken.recurrencemod.entity.custom.SappingRazorProjectileEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, RecurrenceMod.MOD_ID);

    public static final RegistryObject<EntityType<RaiderEntity>> RAIDER =
            ENTITY_TYPES.register("raider", () -> EntityType.Builder.of(RaiderEntity::new, MobCategory.CREATURE)
                    .sized(0.8f, 2.0f).build("raider"));

    public static final RegistryObject<EntityType<SappingRazorProjectileEntity>> SAPPING_RAZOR_PROJECTILE =
            ENTITY_TYPES.register("sapping_razor_projectile",
                    () -> EntityType.Builder.<SappingRazorProjectileEntity>of(SappingRazorProjectileEntity::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f).build("sapping_razor_projectile"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
