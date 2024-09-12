package net.gurken.recurrencemod.item.client.armor;

import net.gurken.recurrencemod.item.custom.NomadArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class NomadArmorRenderer extends GeoArmorRenderer<NomadArmorItem> {
    public NomadArmorRenderer() {
        super(new DefaultedItemGeoModel(new ResourceLocation("recurrencemod", "armor/nomad_armor")));
    }
}
