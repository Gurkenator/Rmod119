package net.gurken.recurrencemod.entity.custom;

import net.gurken.recurrencemod.entity.ModEntities;
import net.gurken.recurrencemod.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

public class VagabondThrowingKnifeEntity extends AbstractArrow implements DamageTypes {
    private ItemStack vagabondThrowingKnifeItem = new ItemStack(ModItems.VAGABOND_THROWING_KNIFE.get());
    private boolean dealtDamage;
    public VagabondThrowingKnifeEntity(EntityType<? extends AbstractArrow> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public VagabondThrowingKnifeEntity(Level pLevel, LivingEntity livingEntity) {
        super(ModEntities.VAGABOND_THROWING_KNIFE.get(), pLevel);
        setOwner(livingEntity);
        BlockPos blockpos = livingEntity.blockPosition();
        double d0 = (double)blockpos.getX() + 0.5D;
        double d1 = (double)blockpos.getY() + 1.75D;
        double d2 = (double)blockpos.getZ() + 0.5D;
        this.moveTo(d0, d1, d2, this.getYRot(), this.getXRot());
    }

    @Override
    protected ItemStack getPickupItem() {
        return this.vagabondThrowingKnifeItem.copy();
    }

    @Override
    protected float getWaterInertia() {
        return 0.8F;
    }

    protected void onHitEntity(EntityHitResult hitResult) {
        super.onHitEntity(hitResult);
        Entity hitEntity = hitResult.getEntity();
        float damage = 4.5F;

        Entity owner = this.getOwner();
        LivingEntity livingOwner = owner instanceof LivingEntity ? (LivingEntity)owner : null;
        boolean hurt = hitEntity.hurt(this.damageSources().mobProjectile(this, livingOwner), damage);
        //DamageSource damagesource = this.damageSources().trident(this, (Entity)(owner == null ? this : owner));
        this.dealtDamage = true;
        SoundEvent soundevent = SoundEvents.BAMBOO_BREAK;
        if (hurt) {

            if (hitEntity.getType() == EntityType.ENDERMAN) {
                return;
            }
            //TODO for some reason occasionally does not work
            if(hitEntity instanceof LivingEntity livingHitEntity) {
                livingHitEntity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 60, 0), owner);
                this.doPostHurtEffects(livingHitEntity);
            }
        }

        this.setDeltaMovement(this.getDeltaMovement().multiply(-0.01D, -0.1D, -0.01D));
        float f1 = 1.0F;

        this.playSound(soundevent, f1, 1.0F);
    }

    protected SoundEvent getDefaultHitGroundSoundEvent() {
        return SoundEvents.BAMBOO_FALL;
    }

    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        if (pCompound.contains("Vagabond Throwing Knife", 10)) {
            this.vagabondThrowingKnifeItem = ItemStack.of(pCompound.getCompound("Vagabond Throwing Knife"));
        }

        this.dealtDamage = pCompound.getBoolean("DealtDamage");
    }

    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.put("Vagabond Throwing Knife", this.vagabondThrowingKnifeItem.save(new CompoundTag()));
        pCompound.putBoolean("DealtDamage", this.dealtDamage);
    }
}
