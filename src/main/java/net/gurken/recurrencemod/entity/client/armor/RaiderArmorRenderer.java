package net.gurken.recurrencemod.entity.client.armor;

import net.gurken.recurrencemod.entity.client.armor.RaiderArmorModel;
import net.gurken.recurrencemod.item.custom.RaiderArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.renderer.GeoRenderer;

public class RaiderArmorRenderer extends GeoArmorRenderer<RaiderArmorItem> {
    public RaiderArmorRenderer() {
        super(new DefaultedItemGeoModel(new ResourceLocation("recurrencemod", "armor/raider_armor")));
    }
}
