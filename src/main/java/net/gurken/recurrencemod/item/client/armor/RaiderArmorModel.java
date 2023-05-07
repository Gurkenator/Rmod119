package net.gurken.recurrencemod.item.client.armor;

import net.gurken.recurrencemod.RecurrenceMod;
import net.gurken.recurrencemod.item.custom.RaiderArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class RaiderArmorModel extends GeoModel<RaiderArmorItem> {
    @Override
    public ResourceLocation getModelResource(RaiderArmorItem animatable) {
        return new ResourceLocation(RecurrenceMod.MOD_ID, "geo/raider_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(RaiderArmorItem animatable) {
        return new ResourceLocation(RecurrenceMod.MOD_ID, "textures/item/armor/raider_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(RaiderArmorItem animatable) {
        return new ResourceLocation(RecurrenceMod.MOD_ID, "animations/raider_armor_animation.json");
    }
}
