package net.gurken.recurrencemod.item.client.armor;

import net.gurken.recurrencemod.item.custom.RuinatedArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class RuinatedArmorRenderer extends GeoArmorRenderer<RuinatedArmorItem> {
    public RuinatedArmorRenderer() {
        super(new DefaultedItemGeoModel(new ResourceLocation("recurrencemod", "armor/ruinated_armor")));
    }
    //fromNamespaceAndPath
}
