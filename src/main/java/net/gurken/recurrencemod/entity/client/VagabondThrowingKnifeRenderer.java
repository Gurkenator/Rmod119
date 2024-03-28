package net.gurken.recurrencemod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.gurken.recurrencemod.RecurrenceMod;
import net.gurken.recurrencemod.entity.custom.VagabondThrowingKnifeEntity;
import net.gurken.recurrencemod.entity.layers.ModModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class VagabondThrowingKnifeRenderer extends EntityRenderer<VagabondThrowingKnifeEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(RecurrenceMod.MOD_ID, "textures/entity/vagabond_throwing_knife.png");
    protected VagabondThrowingKnifeModel model;

    public VagabondThrowingKnifeRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
        model = new VagabondThrowingKnifeModel(pContext.bakeLayer(ModModelLayers.VAGABOND_THROWING_KNIFE_LAYER));
        this.shadowRadius = 0.2f;
    }

    public void render(VagabondThrowingKnifeEntity entity, float pEntityYaw, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        pPoseStack.pushPose();
        pPoseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(pPartialTick, entity.yRotO, entity.getYRot()) - 90.0F));
        pPoseStack.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(pPartialTick, entity.xRotO, entity.getXRot()) + 90.0F));
        VertexConsumer vertexconsumer = ItemRenderer.getFoilBufferDirect(pBuffer, this.model.renderType(this.getTextureLocation(entity)), false, false);

        this.model.renderToBuffer(pPoseStack, vertexconsumer, pPackedLight, OverlayTexture.NO_OVERLAY, 1f, 1f, 1f, 1f);
        pPoseStack.popPose();
        super.render(entity, pEntityYaw, pPartialTick, pPoseStack, pBuffer, pPackedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(VagabondThrowingKnifeEntity pEntity) {
        return TEXTURE;
    }
}
