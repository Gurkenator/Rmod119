package net.gurken.recurrencemod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties CANNED_MEAT = (new FoodProperties.Builder()).nutrition(5).saturationMod(1.25F).build();
    public static final FoodProperties CANNED_VEGETABLES = (new FoodProperties.Builder()).nutrition(4).saturationMod(1.0F).build();
    public static final FoodProperties CANNED_SOUP = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.5F).build();

    //effect coding Tick Length, Effect Level, Chance
    public static final FoodProperties BLUE_PILLS = (new FoodProperties.Builder()).fast().nutrition(0).saturationMod(0.25F).effect(new MobEffectInstance(MobEffects.LEVITATION, 300, 1), 0.60F).effect(new MobEffectInstance(MobEffects.CONFUSION, 600, 0), 0.80F).alwaysEat().build();
    public static final FoodProperties RED_PILLS = (new FoodProperties.Builder()).fast().nutrition(0).saturationMod(0.25F).effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 300, 1), 0.60F).effect(new MobEffectInstance(MobEffects.POISON, 600, 0), 0.80F).alwaysEat().build();
    public static final FoodProperties YELLOW_PILLS = (new FoodProperties.Builder()).fast().nutrition(0).saturationMod(0.25F).effect(new MobEffectInstance(MobEffects.DIG_SPEED, 300, 0), 0.60F).effect(new MobEffectInstance(MobEffects.WEAKNESS, 600, 0), 0.80F).alwaysEat().build();
    public static final FoodProperties GREEN_PILLS = (new FoodProperties.Builder()).fast().nutrition(0).saturationMod(0.25F).effect(new MobEffectInstance(MobEffects.LUCK, 300, 1), 0.60F).effect(new MobEffectInstance(MobEffects.BLINDNESS, 600, 0), 0.80F).alwaysEat().build();

}
