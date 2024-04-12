package net.gurken.recurrencemod.item;

import net.gurken.recurrencemod.RecurrenceMod;
import net.gurken.recurrencemod.entity.ModEntities;
import net.gurken.recurrencemod.item.custom.*;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, RecurrenceMod.MOD_ID);

    public static final RegistryObject<Item> ROTTEN_WOOD = ITEMS.register("rotten_wood",
            () -> new RottenWoodItem(new Item.Properties()));
    public static final RegistryObject<Item> RAIDER_PLATINGS = ITEMS.register("raider_platings",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LUNATIC_PLATINGS = ITEMS.register("lunatic_platings",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> IRON_SCRAPS = ITEMS.register("iron_scraps",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COPPER_SCRAPS = ITEMS.register("copper_scraps",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TIN_SCRAPS = ITEMS.register("tin_scraps",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LEAD_SCRAPS = ITEMS.register("lead_scraps",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ALUMINIUM_SCRAPS = ITEMS.register("aluminium_scraps",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NICKEL_SCRAPS = ITEMS.register("nickel_scraps",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SILVER_SCRAPS = ITEMS.register("silver_scraps",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GOLD_SCRAPS = ITEMS.register("gold_scraps",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COBALT_SCRAPS = ITEMS.register("cobalt_scraps",
            () -> new Item(new Item.Properties()));

    //attack value, speed value
    public static final RegistryObject<Item> RAIDER_SWORD = ITEMS.register("raider_sword",
            () -> new SwordItem(ModTiers.RAIDER, 0, -1.4F,
                    new Item.Properties()));
    public static final RegistryObject<Item> RAIDER_AXE = ITEMS.register("raider_axe",
            () -> new AxeItem(ModTiers.RAIDER, 3, -3.2F,
                    new Item.Properties()));

    public static final RegistryObject<Item> KNIFE_SWORD = ITEMS.register("knife_sword",
            () -> new SwordItem(ModTiers.IRON_SCRAPS_KNIFE, 0, -2.3F,
                    new Item.Properties()));
    public static final RegistryObject<Item> BROKEN_SWORD = ITEMS.register("broken_sword",
            () -> new SwordItem(ModTiers.IRON_SCRAPS_BROKEN, 0, -2.4F,
                    new Item.Properties()));
    public static final RegistryObject<Item> BAT_SWORD = ITEMS.register("bat_sword",
            () -> new BatSwordItem(ModTiers.ROTTEN_WOOD, 0, -2.1F,
                    new Item.Properties()));

    public static final RegistryObject<Item> GAMBLER_SWORD = ITEMS.register("gambler_sword",
            () -> new GamblerSwordItem(ModTiers.BONE, 3, -2.3F,
                    new Item.Properties()));
    public static final RegistryObject<Item> BLOOD_SWORD = ITEMS.register("blood_sword",
            () -> new BloodSwordItem(ModTiers.BONE, 1, -2.4F,
                    new Item.Properties()));
    public static final RegistryObject<Item> SPEED_SWORD = ITEMS.register("speed_sword",
            () -> new SpeedSwordItem(ModTiers.BONE, 1, -2.1F,
                    new Item.Properties()));

    public static final RegistryObject<Item> RAIDER_HELMET = ITEMS.register("raider_helmet",
            () -> new RaiderArmorItem(ModArmorMaterials.RAIDER, ArmorItem.Type.HELMET,
                    new Item.Properties()));
    public static final RegistryObject<Item> RAIDER_CHESTPLATE = ITEMS.register("raider_chestplate",
            () -> new RaiderArmorItem(ModArmorMaterials.RAIDER, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties()));
    public static final RegistryObject<Item> RAIDER_LEGGINGS = ITEMS.register("raider_leggings",
            () -> new RaiderArmorItem(ModArmorMaterials.RAIDER, ArmorItem.Type.LEGGINGS,
                    new Item.Properties()));
    public static final RegistryObject<Item> RAIDER_BOOTS = ITEMS.register("raider_boots",
            () -> new RaiderArmorItem(ModArmorMaterials.RAIDER, ArmorItem.Type.BOOTS,
                    new Item.Properties()));
    public static final RegistryObject<Item> RAIDER_SPAWN_EGG = ITEMS.register("raider_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.RAIDER, 0x423d3d, 0x191717,
                    new Item.Properties()));

    public static final RegistryObject<Item> LUNATIC_CHAINSWORD = ITEMS.register("lunatic_chainsword",
            () -> new LunaticChainswordItem(ModTiers.LUNATIC, 0, -1.4F,
                    new Item.Properties()));
    public static final RegistryObject<Item> CHEMDRILL = ITEMS.register("chemdrill",
            () -> new PickaxeItem(ModTiers.LUNATIC, 3, -3.2F,
                    new Item.Properties()));
    public static final RegistryObject<Item> NOMAD_SWORD = ITEMS.register("nomad_sword",
            () -> new NomadSwordItem(ModTiers.NOMAD, 3, -3.2F,
                    new Item.Properties()));
    public static final RegistryObject<Item> VAGABOND_SWORD = ITEMS.register("vagabond_sword",
            () -> new VagabondSwordItem(ModTiers.NOMAD, 3,-3.2F,
                    new Item.Properties()));
    public static final RegistryObject<Item> VAGABOND_THROWING_KNIFE = ITEMS.register("vagabond_throwing_knife",
            () -> new VagabondThrowingKnifeItem(new Item.Properties().stacksTo(16)));


    public static final RegistryObject<Item> CANNED_MEAT = ITEMS.register("canned_meat",
            () -> new Item(new Item.Properties().food(ModFoods.CANNED_MEAT)));
    public static final RegistryObject<Item> CANNED_VEGETABLES = ITEMS.register("canned_vegetables",
            () -> new Item(new Item.Properties().food(ModFoods.CANNED_VEGETABLES)));
    public static final RegistryObject<Item> CANNED_SOUP = ITEMS.register("canned_soup",
            () -> new Item(new Item.Properties().food(ModFoods.CANNED_SOUP)));
    public static final RegistryObject<Item> BOTTLED_WATER = ITEMS.register("bottled_water",
            () -> new DrinkableItem(new Item.Properties()));

    public static final RegistryObject<Item> BLUE_PILLS = ITEMS.register("blue_pills",
            () -> new BluePillsItem(new Item.Properties().food(ModFoods.BLUE_PILLS)));
    public static final RegistryObject<Item> RED_PILLS = ITEMS.register("red_pills",
            () -> new RedPillsItem(new Item.Properties().food(ModFoods.RED_PILLS)));
    public static final RegistryObject<Item> YELLOW_PILLS = ITEMS.register("yellow_pills",
            () -> new YellowPillsItem(new Item.Properties().food(ModFoods.YELLOW_PILLS)));
    public static final RegistryObject<Item> GREEN_PILLS = ITEMS.register("green_pills",
            () -> new GreenPillsItem(new Item.Properties().food(ModFoods.GREEN_PILLS)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
