package net.gurken.recurrencemod.entity.client;

// Made with Blockbench 4.9.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;

public class SappingRazorModel<T extends Entity> extends EntityModel<T> {
    private final ModelPart sapping_razor;

    public SappingRazorModel(ModelPart root) {
        this.sapping_razor = root.getChild("sapping_razor");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition sapping_razor = partdefinition.addOrReplaceChild("sapping_razor", CubeListBuilder.create(), PartPose.offset(0.0F, 16.1863F, 0.3328F));

        PartDefinition cube_r1 = sapping_razor.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(17, 8).addBox(-0.5F, 0.0F, 3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(6, 14).addBox(-0.5F, -2.0F, 1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 14).addBox(-0.5F, -4.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(6, 0).addBox(-0.5F, -12.0F, -9.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 12).addBox(-0.5F, -13.0F, -13.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(6, 2).addBox(-0.5F, -10.0F, -7.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(33, 10).addBox(-0.5F, -11.0F, -12.0F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(6, 6).addBox(-0.5F, -8.0F, -5.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(18, 26).addBox(-0.5F, -9.0F, -11.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(6, 12).addBox(-0.5F, -6.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 12).addBox(-0.5F, 2.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 8).addBox(-0.5F, 9.0F, 5.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 24).addBox(-0.5F, 11.0F, 7.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 34).addBox(-0.5F, 9.0F, 6.0F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(26, 0).addBox(-0.5F, 7.0F, 2.0F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(26, 32).addBox(-0.5F, 8.0F, 4.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(0, 6).addBox(-0.5F, 8.0F, -2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(13, 0).addBox(0.5F, 0.0F, 7.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 6).addBox(0.5F, 1.0F, 5.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 18).addBox(0.5F, 2.0F, 4.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(13, 4).addBox(-1.5F, 4.0F, 6.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(12, 15).addBox(-1.5F, 3.0F, 5.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(13, 8).addBox(-1.5F, 2.0F, 4.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(18, 0).addBox(-0.5F, 7.0F, -3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-0.5F, 5.0F, -4.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(27, 24).addBox(-0.5F, 5.0F, 1.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(6, 8).addBox(-0.5F, 6.0F, 7.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-0.5F, 4.0F, -5.0F, 1.0F, 1.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(0, 12).addBox(-0.5F, 2.0F, -5.0F, 1.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(15, 3).addBox(-0.5F, -1.0F, -6.0F, 1.0F, 3.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(24, 15).addBox(-0.5F, -7.0F, -10.0F, 1.0F, 2.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(0, 24).addBox(-0.5F, -5.0F, -9.0F, 1.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(13, 15).addBox(-0.5F, -3.0F, -8.0F, 1.0F, 2.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-0.5F, -1.0F, -7.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.6863F, -0.3328F, 0.7854F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        sapping_razor.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}
