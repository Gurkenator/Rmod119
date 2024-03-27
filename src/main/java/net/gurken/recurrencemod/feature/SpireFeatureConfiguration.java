package net.gurken.recurrencemod.feature;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;

import java.util.List;

public class SpireFeatureConfiguration implements FeatureConfiguration {
    // CREDIT GOES TO: TeamTwilight | https://github.com/TeamTwilight/twilightforest, from whom this code is adapted.
    // The Twilight Forest uses a custom LGPL License
    // https://github.com/TeamTwilight/twilightforest/blob/1.20.x/LICENSE
    public static final Codec<SpireFeatureConfiguration> CODEC = RecordCodecBuilder.create((p_159816_) -> {
        return p_159816_.group(ResourceLocation.CODEC.listOf().fieldOf("spire_structures").forGetter((p_159830_) -> {
            return p_159830_.spireStructures;
        }), ResourceLocation.CODEC.listOf().fieldOf("overlay_structures").forGetter((p_159828_) -> {
            return p_159828_.overlayStructures;
        }), StructureProcessorType.LIST_CODEC.fieldOf("spire_processors").forGetter((p_204759_) -> {
            return p_204759_.spireProcessors;
        }), StructureProcessorType.LIST_CODEC.fieldOf("overlay_processors").forGetter((p_204757_) -> {
            return p_204757_.overlayProcessors;
        }), Codec.intRange(0, 7).fieldOf("max_empty_corners_allowed").forGetter((p_159818_) -> {
            return p_159818_.maxEmptyCornersAllowed;
        })).apply(p_159816_, SpireFeatureConfiguration::new);
    });
    public final List<ResourceLocation> spireStructures;
    public final List<ResourceLocation> overlayStructures;
    public final Holder<StructureProcessorList> spireProcessors;
    public final Holder<StructureProcessorList> overlayProcessors;
    public final int maxEmptyCornersAllowed;

    public SpireFeatureConfiguration(List<ResourceLocation> p_204751_, List<ResourceLocation> p_204752_, Holder<StructureProcessorList> p_204753_, Holder<StructureProcessorList> p_204754_, int p_204755_) {
        if (p_204751_.isEmpty()) {
            throw new IllegalArgumentException("Spire structure lists need at least one entry");
        } else if (p_204751_.size() != p_204752_.size()) {
            throw new IllegalArgumentException("Spire structure lists must be equal lengths");
        } else {
            this.spireStructures = p_204751_;
            this.overlayStructures = p_204752_;
            this.spireProcessors = p_204753_;
            this.overlayProcessors = p_204754_;
            this.maxEmptyCornersAllowed = p_204755_;
        }
    }
}
