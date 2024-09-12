package net.gurken.recurrencemod.item.client.armor;

import net.gurken.recurrencemod.RecurrenceMod;
import net.gurken.recurrencemod.item.custom.NomadArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class NomadArmorModel extends GeoModel<NomadArmorItem> {
    @Override
    public ResourceLocation getModelResource(NomadArmorItem animatable) {
        return new ResourceLocation(RecurrenceMod.MOD_ID, "geo/nomad_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(NomadArmorItem animatable) {
        return new ResourceLocation(RecurrenceMod.MOD_ID, "textures/item/armor/nomad_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(NomadArmorItem animatable) {
        return new ResourceLocation(RecurrenceMod.MOD_ID, "animations/item/armor/nomad_armor.animation.json");
    }
}