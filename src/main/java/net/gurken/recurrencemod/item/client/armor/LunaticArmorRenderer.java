package net.gurken.recurrencemod.item.client.armor;

import net.gurken.recurrencemod.item.custom.LunaticArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class LunaticArmorRenderer extends GeoArmorRenderer<LunaticArmorItem> {
    public LunaticArmorRenderer() {
        super(new DefaultedItemGeoModel(new ResourceLocation("recurrencemod", "armor/raider_armor")));
    }
}
