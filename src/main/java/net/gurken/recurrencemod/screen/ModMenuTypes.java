package net.gurken.recurrencemod.screen;

import net.gurken.recurrencemod.RecurrenceMod;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, RecurrenceMod.MOD_ID);

    public static final RegistryObject<MenuType<SkeletonBlockMenu>> SKELETON_BLOCK_MENU =
            registerMenuType(SkeletonBlockMenu::new, "skeleton_block_menu");

    public static final RegistryObject<MenuType<NomadFactionForgeMenu>> NOMAD_FACTION_FORGE_MENU =
            registerMenuType(NomadFactionForgeMenu::new, "nomad_faction_forge_menu");


    private static <T extends AbstractContainerMenu> RegistryObject<MenuType<T>> registerMenuType(IContainerFactory<T> factory,
                                                                                                  String name) {
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}
