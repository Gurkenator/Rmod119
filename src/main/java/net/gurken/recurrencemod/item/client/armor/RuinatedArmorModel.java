package net.gurken.recurrencemod.item.client.armor;

import net.gurken.recurrencemod.RecurrenceMod;
import net.gurken.recurrencemod.item.custom.RaiderArmorItem;
import net.gurken.recurrencemod.item.custom.RuinatedArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class RuinatedArmorModel extends GeoModel<RuinatedArmorItem> {
    @Override
    public ResourceLocation getModelResource(RuinatedArmorItem animatable) {
        return new ResourceLocation(RecurrenceMod.MOD_ID, "geo/ruinated_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(RuinatedArmorItem animatable) {
        return new ResourceLocation(RecurrenceMod.MOD_ID, "textures/item/armor/ruinated_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(RuinatedArmorItem animatable) {
        return new ResourceLocation(RecurrenceMod.MOD_ID, "animations/item/armor/ruinated_armor_animation.json");
    }
}
