package net.gurken.recurrencemod.util;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public class KeyBinding {
    public static final String KEY_CATEGORY_RECURRENCE = "key.category.recurrencemod.controls";
    public static final String KEY_FACTION = "key.recurrencemod.faction";

    public static final KeyMapping FACTION_KEY = new KeyMapping(KEY_FACTION, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_O, KEY_CATEGORY_RECURRENCE);
}
