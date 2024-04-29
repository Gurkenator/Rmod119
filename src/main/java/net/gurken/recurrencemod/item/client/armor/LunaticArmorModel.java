package net.gurken.recurrencemod.item.client.armor;

import net.gurken.recurrencemod.RecurrenceMod;
import net.gurken.recurrencemod.item.custom.LunaticArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class LunaticArmorModel extends GeoModel<LunaticArmorItem> {
    @Override
    public ResourceLocation getModelResource(LunaticArmorItem animatable) {
        return new ResourceLocation(RecurrenceMod.MOD_ID, "geo/lunatic_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(LunaticArmorItem animatable) {
        return new ResourceLocation(RecurrenceMod.MOD_ID, "textures/item/armor/raider_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(LunaticArmorItem animatable) {
        return new ResourceLocation(RecurrenceMod.MOD_ID, "animations/item/armor/lunatic_armor_animation.json");
    }
}