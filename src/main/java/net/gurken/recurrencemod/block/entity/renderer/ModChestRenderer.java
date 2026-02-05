package net.gurken.recurrencemod.block.entity.renderer;

import net.gurken.recurrencemod.RecurrenceMod;
import net.gurken.recurrencemod.block.entity.MakeshiftChestBlockEntity;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.ChestRenderer;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.properties.ChestType;

public class ModChestRenderer extends ChestRenderer<MakeshiftChestBlockEntity> {
    private static final Material MATERIAL = chestMaterial("iron_chest");

    public ModChestRenderer(BlockEntityRendererProvider.Context pContext) {
        super(pContext);
    }

    @Override
    protected Material getMaterial(MakeshiftChestBlockEntity blockEntity, ChestType chestType) {
        return MATERIAL;
    }

    public static Material chestMaterial(String name) {
        return new Material(Sheets.CHEST_SHEET, new ResourceLocation(RecurrenceMod.MOD_ID, "entity/chest/" + name));
    }
}
