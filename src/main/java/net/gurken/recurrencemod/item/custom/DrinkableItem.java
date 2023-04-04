package net.gurken.recurrencemod.item.custom;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

public class DrinkableItem extends Item {
    private static final int DRINK_DURATION = 32;

    public DrinkableItem(Item.Properties pProperties) {
        super(pProperties);
    }

    public ItemStack finishUsingItem(ItemStack pHeldItem, Level pLevel, LivingEntity pPlayer) {
        Player player = pPlayer instanceof Player ? (Player)pPlayer : null;
        super.finishUsingItem(pHeldItem, pLevel, pPlayer);
        if (pPlayer instanceof ServerPlayer serverplayer) {
            CriteriaTriggers.CONSUME_ITEM.trigger(serverplayer, pHeldItem);
            serverplayer.awardStat(Stats.ITEM_USED.get(this));
        }
        if (!player.getAbilities().instabuild) {
            pHeldItem.shrink(1);
        }

        return pHeldItem;
    }

    public int getUseDuration(ItemStack p_41360_) {
        return 32;
    }

    public UseAnim getUseAnimation(ItemStack p_41358_) {
        return UseAnim.DRINK;
    }

    public SoundEvent getDrinkingSound() {
        return SoundEvents.HONEY_DRINK;
    }

    public SoundEvent getEatingSound() {
        return SoundEvents.HONEY_DRINK;
    }

    public InteractionResultHolder<ItemStack> use(Level p_41352_, Player p_41353_, InteractionHand p_41354_) {
        return ItemUtils.startUsingInstantly(p_41352_, p_41353_, p_41354_);
    }
}