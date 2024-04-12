package net.gurken.recurrencemod.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.gurken.recurrencemod.RecurrenceMod;
import net.gurken.recurrencemod.client.ClientFactionFavourData;
import net.gurken.recurrencemod.faction_favour.PlayerFactionFavour;
import net.gurken.recurrencemod.screen.renderer.FluidTankRenderer;
import net.gurken.recurrencemod.util.MouseUtil;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidType;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class NomadFactionForgeScreen extends AbstractContainerScreen<NomadFactionForgeMenu> {
    private int imageHeight = 180;

    private static final ResourceLocation TEXTURE =
            new ResourceLocation(RecurrenceMod.MOD_ID, "textures/gui/nomad_faction_forge_gui.png");
    private FluidTankRenderer fluidRenderer;
    public NomadFactionForgeScreen(NomadFactionForgeMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    protected void init() {
        super.init();
        this.inventoryLabelY = 80;
        this.titleLabelY = -1;

        assignFluidRenderer();
    }

    private void assignFluidRenderer() {
        fluidRenderer = new FluidTankRenderer(64000, true, 16, 46);
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int pMouseX, int pMouseY) {
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        renderFluidTooltipArea(guiGraphics, pMouseX, pMouseY, x, y, menu.blockEntity.getFluid(), 152, 17, fluidRenderer);
        addFactionFavourTooltipArea(guiGraphics, pMouseX, pMouseY, x, y, 12, 17);
    }

    private void renderFluidTooltipArea(GuiGraphics guiGraphics, int pMouseX, int pMouseY, int x, int y,
                                        FluidStack stack, int offsetX, int offsetY, FluidTankRenderer renderer) {
        if(isMouseAboveArea(pMouseX, pMouseY, x, y, offsetX, offsetY, renderer)) {
            guiGraphics.renderTooltip(this.font, renderer.getTooltip(stack, TooltipFlag.Default.NORMAL),
                    Optional.empty(), pMouseX - x, pMouseY - y);
        }
    }

    private void addFactionFavourTooltipArea(GuiGraphics guiGraphics, int pMouseX, int pMouseY, int x, int y,
                                        int offsetX, int offsetY) {
        if(isMouseAboveFactionArea(pMouseX, pMouseY, x, y, offsetX, offsetY)) {
            guiGraphics.renderTooltip(this.font, this.getTooltip(TooltipFlag.Default.NORMAL),
                    Optional.empty(), pMouseX - x, pMouseY - y);
        }
    }

    public List<Component> getTooltip(TooltipFlag tooltipFlag) {
        List<Component> tooltip = new ArrayList<>();

        int u = ClientFactionFavourData.getPlayerFactionFavour();
        int k = PlayerFactionFavour.getMaxFactionFavour();

        try {
            Component displayName = Component.translatable("recurrencemod.tooltip.faction.favour");
            tooltip.add(displayName);
            MutableComponent amountString = Component.translatable("recurrencemod.tooltip.faction.favour.amount.capacity", u, k);
            tooltip.add(amountString.withStyle(ChatFormatting.GRAY));
        } catch (RuntimeException e) {
            RecurrenceMod.LOGGER.error("Failed to get tooltip for fluid: " + e);
        }

        return tooltip;
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        guiGraphics.blit(TEXTURE, x, y, 0, 0, imageWidth, imageHeight);

        //renderProgressArrow(guiGraphics, x, y);
        renderProgressBubbles(guiGraphics, x, y);
        renderFactionFavour(guiGraphics, x, y);

        fluidRenderer.render(guiGraphics, x + 152, y + 17, menu.blockEntity.getFluid());
    }

    private void renderProgressArrow(GuiGraphics guiGraphics, int x, int y) {
        if(menu.isCrafting()) {
            guiGraphics.blit(TEXTURE, x + 130, y + 33, 176, 0, 8, menu.getScaledProgress());
        }
    }

    private void renderProgressBubbles(GuiGraphics guiGraphics, int x, int y) {
        if(menu.isCrafting()) {
            int k = this.menu.getScaledProgressFluid();
            guiGraphics.blit(TEXTURE, x + 73, y + 32, 176, 0, 30, k + 1);
            guiGraphics.blit(TEXTURE, x + 73, y + 67 - k, 176, 15 - k, 30, k + 1);
        }
    }

    //private void renderFactionLevelRequirement(GuiGraphics guiGraphics, int x, int y) {
    //    if(menu.isCrafting()) {
    //        int k = this.menu.getScaledProgressFluid();
    //        guiGraphics.blit(TEXTURE, x + 73, y + 32, 176, 0, 30, k + 1);
    //        guiGraphics.blit(TEXTURE, x + 73, y + 67 - k, 176, 15 - k, 30, k + 1);
    //    }
    //}

    private void renderFactionFavour(GuiGraphics guiGraphics, int x, int y) {
        if(true) {
            int k = this.menu.getCurrentFactionFavour();
            guiGraphics.blit(TEXTURE, x + 12, y + 63 - k, 176, 70 - k, 8, k);
        }
    }

    @Override
    public void render(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        renderBackground(pGuiGraphics);
        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
        renderTooltip(pGuiGraphics, pMouseX, pMouseY);
    }

    private boolean isMouseAboveArea(int pMouseX, int pMouseY, int x, int y, int offsetX, int offsetY, FluidTankRenderer renderer) {
        return MouseUtil.isMouseOver(pMouseX, pMouseY, x + offsetX, y + offsetY, renderer.getWidth(), renderer.getHeight());
    }

    private boolean isMouseAboveFactionArea(int pMouseX, int pMouseY, int x, int y, int offsetX, int offsetY) {
        return MouseUtil.isMouseOver(pMouseX, pMouseY, x + offsetX, y + offsetY, 8, 46);
    }
}
