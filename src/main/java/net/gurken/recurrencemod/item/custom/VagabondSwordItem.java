package net.gurken.recurrencemod.item.custom;

import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class VagabondSwordItem extends SwordItem {
    private final float nighttimeDamage;

    //Tier, Attack Damage, Attack Speed
    public VagabondSwordItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
        this.nighttimeDamage = pAttackDamageModifier+2;
    }

    //public float getDamage() {
    //    return this.nighttimeDamage;
    //}
}
