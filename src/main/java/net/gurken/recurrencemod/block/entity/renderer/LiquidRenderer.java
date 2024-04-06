package net.gurken.recurrencemod.block.entity.renderer;

import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;

import java.util.Arrays;

public class LiquidRenderer
    // CREDIT GOES TO: WayofTime and the Blood Magic Team | https://github.com/WayofTime/BloodMagic/tree/1.20.1,
    // from whom I adapted the BloodMagicRenderer class to use for Liquid display in Faction Forges
    // Blood Magic uses a Creative Commons Attribution 4.0 International License
    // https://github.com/WayofTime/BloodMagic/blob/1.20.1/LICENSE
{
    public static float getRed(int color)
    {
        return (color >> 16 & 0xFF) / 255.0F;
    }

    public static float getGreen(int color)
    {
        return (color >> 8 & 0xFF) / 255.0F;
    }

    public static float getBlue(int color)
    {
        return (color & 0xFF) / 255.0F;
    }

    public static float getAlpha(int color)
    {
        return (color >> 24 & 0xFF) / 255.0F;
    }

    public static class Model3D
    {
        public double minX, minY, minZ;
        public double maxX, maxY, maxZ;

        public final TextureAtlasSprite[] textures = new TextureAtlasSprite[6];

        public final boolean[] renderSides = new boolean[]
                { true, true, true, true, true, true, false };

        public double sizeX()
        {
            return maxX - minX;
        }

        public double sizeY()
        {
            return maxY - minY;
        }

        public double sizeZ()
        {
            return maxZ - minZ;
        }

        public void setSideRender(Direction side, boolean value)
        {
            renderSides[side.ordinal()] = value;
        }

        public boolean shouldSideRender(Direction side)
        {
            return renderSides[side.ordinal()];
        }

        public void setTexture(TextureAtlasSprite tex)
        {
            Arrays.fill(textures, tex);
        }

        public void setTextures(TextureAtlasSprite down, TextureAtlasSprite up, TextureAtlasSprite north, TextureAtlasSprite south, TextureAtlasSprite west, TextureAtlasSprite east)
        {
            textures[0] = down;
            textures[1] = up;
            textures[2] = north;
            textures[3] = south;
            textures[4] = west;
            textures[5] = east;
        }
    }
}
