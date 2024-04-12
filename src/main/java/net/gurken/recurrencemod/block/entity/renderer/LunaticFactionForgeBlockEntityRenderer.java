package net.gurken.recurrencemod.block.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.gurken.recurrencemod.block.entity.LunaticFactionForgeBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.registries.ForgeRegistries;

public class LunaticFactionForgeBlockEntityRenderer  implements BlockEntityRenderer<LunaticFactionForgeBlockEntity> {
    // CREDIT GOES TO: WayofTime and the Blood Magic Team | https://github.com/WayofTime/BloodMagic/tree/1.20.1,
    // from whom I adapted the Blood Altar's renderItem and renderFluid methods.
    // Blood Magic uses a Creative Commons Attribution 4.0 International License
    // https://github.com/WayofTime/BloodMagic/blob/1.20.1/LICENSE

    public LunaticFactionForgeBlockEntityRenderer(BlockEntityRendererProvider.Context context) {

    }

    private static final float MIN_HEIGHT = 0.126f;
    private static final float MAX_HEIGHT = 0.249f;

    @Override
    public void render(LunaticFactionForgeBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBufferSource,
                       int pPackedLight, int pPackedOverlay) {
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        ItemStack itemStack = pBlockEntity.getRenderStack();

        float level = ((float) pBlockEntity.getCurrentFluid()) / (float) pBlockEntity.getFluidCapacity();

        this.renderItem(itemStack, pBlockEntity, pPoseStack, pBufferSource, pPackedLight, pPackedOverlay);
        renderFluid(level, pPoseStack, pBufferSource, pPackedLight, pPackedOverlay);
    }

    private void renderFluid(float fluidLevel, PoseStack pPoseStack, MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay)
    {
        Fluid fluid = Fluids.WATER;
        FluidStack fluidStack = new FluidStack(fluid, 1000);

        LunaticFactionForgeBlockEntityRenderer.FluidRenderData data = new LunaticFactionForgeBlockEntityRenderer.FluidRenderData(fluidStack);
        pPoseStack.pushPose();

        LiquidRenderer.Model3D model = getFluidModel(fluidLevel, data);
        VertexConsumer buffer = pBufferSource.getBuffer(Sheets.translucentCullBlockSheet());

//		matrixStack.translate(data.loca, y, z);
//		int glow = data.calculateGlowLight(0);
        RenderResizableCuboid.INSTANCE.renderCube(model, pPoseStack, buffer, data.getColorARGB(1), pPackedLight, pPackedOverlay);

        pPoseStack.popPose();
    }

    private void renderItem(ItemStack stack, LunaticFactionForgeBlockEntity pBlockEntity, PoseStack pPoseStack, MultiBufferSource pBufferSource,
                            int pPackedLight, int pPackedOverlay)
    {
        pPoseStack.pushPose();
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        if (!stack.isEmpty())
        {
            pPoseStack.translate(0.5, 1, 0.5);
            pPoseStack.pushPose();

            float rotation = (float) (720.0 * (System.currentTimeMillis() & 0x3FFFL) / 0x3FFFL);

            pPoseStack.mulPose(Axis.YP.rotationDegrees(rotation));
            pPoseStack.scale(0.5F, 0.5F, 0.5F);
//			Lighting.turnBackOn();
            BakedModel ibakedmodel = itemRenderer.getModel(stack, pBlockEntity.getLevel(), (LivingEntity) null, 1);
            itemRenderer.render(stack, ItemDisplayContext.FIXED, true, pPoseStack, pBufferSource, pPackedLight, pPackedOverlay, ibakedmodel); // renderItem

//			int k = this.getLightVal(p_115076_, 15728880, p_115081_);
//            p_115079_.scale(0.5F, 0.5F, 0.5F);
//            this.itemRenderer.renderStatic(itemstack, ItemTransforms.TransformType.FIXED, k, OverlayTexture.NO_OVERLAY, p_115079_, p_115080_, p_115076_.getId());

//			Lighting.turnOff();

            pPoseStack.popPose();
        }

        pPoseStack.popPose();
    }

    private LiquidRenderer.Model3D getFluidModel(float fluidLevel, LunaticFactionForgeBlockEntityRenderer.FluidRenderData data)
    {
        LiquidRenderer.Model3D model = new LiquidRenderer.Model3D();
        model.setTexture(data.getTexture());
        model.minX = 0.1;
        model.minY = MIN_HEIGHT;
        model.minZ = 0.1;
        model.maxX = 0.9;
        model.maxY = (MAX_HEIGHT - MIN_HEIGHT) * fluidLevel + MIN_HEIGHT;
        model.maxZ = 0.9;

        return model;
    }

    public class FluidRenderData
    {
        public BlockPos location;

        public int height;
        public int length;
        public int width;

        public final FluidStack fluidType;

        public FluidRenderData(FluidStack fluidType)
        {
            this.fluidType = fluidType;
        }

        public TextureAtlasSprite getTexture()
        {
            return Minecraft.getInstance().getTextureAtlas(TextureAtlas.LOCATION_BLOCKS).apply(IClientFluidTypeExtensions.of(fluidType.getFluid()).getStillTexture());
        }

        public boolean isGaseous()
        {
            // TODO: FIX GASES - Gases don't exist in fluidtypes
            return fluidType.getFluid().getFluidType().isLighterThanAir();
        }

        public int getColorARGB(float scale)
        {
            return IClientFluidTypeExtensions.of(fluidType.getFluid()).getTintColor(fluidType);
        }

        public int calculateGlowLight(int light)
        {
            return light;
        }

        @Override
        public int hashCode()
        {
            int code = super.hashCode();
            code = 31 * code + ForgeRegistries.FLUIDS.getKey(fluidType.getFluid()).hashCode();
            if (fluidType.hasTag())
            {
                code = 31 * code + fluidType.getTag().hashCode();
            }
            return code;
        }

        @Override
        public boolean equals(Object data)
        {
            return super.equals(data) && data instanceof LunaticFactionForgeBlockEntityRenderer.FluidRenderData && fluidType.isFluidEqual(((LunaticFactionForgeBlockEntityRenderer.FluidRenderData) data).fluidType);
        }
    }

    private int getLightLevel(Level level, BlockPos pos) {
        int bLight = level.getBrightness(LightLayer.BLOCK, pos);
        int sLight = level.getBrightness(LightLayer.SKY, pos);
        return LightTexture.pack(bLight, sLight);
    }
}
