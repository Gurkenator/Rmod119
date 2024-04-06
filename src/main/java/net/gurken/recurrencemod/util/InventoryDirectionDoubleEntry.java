package net.gurken.recurrencemod.util;

import net.minecraft.core.Direction;

public class InventoryDirectionDoubleEntry {
    public Direction direction;
    public int slotIndex0;
    public int slotIndex1;
    public boolean canInsert;

    public InventoryDirectionDoubleEntry(Direction direction, int slotIndex0, int slotIndex1, boolean canInsert) {
        this.direction = direction;
        this.slotIndex0 = slotIndex0;
        this.slotIndex1 = slotIndex1;
        this.canInsert = canInsert;
    }
}
