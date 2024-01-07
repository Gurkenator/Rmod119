package net.gurken.recurrencemod.entity.custom;

import net.gurken.recurrencemod.entity.ModEntities;
import net.gurken.recurrencemod.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.network.NetworkHooks;

public class SappingRazorProjectileEntity extends AbstractArrow {

    private static final EntityDataAccessor<Boolean> HIT =
            SynchedEntityData.defineId(SappingRazorProjectileEntity.class, EntityDataSerializers.BOOLEAN);
    private int counter = 0;

    public SappingRazorProjectileEntity.Pickup pickup = SappingRazorProjectileEntity.Pickup.DISALLOWED;
    public SappingRazorProjectileEntity(EntityType<? extends AbstractArrow> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public SappingRazorProjectileEntity(Level pLevel) {
        super(ModEntities.SAPPING_RAZOR_PROJECTILE.get(), pLevel);
    }

    public SappingRazorProjectileEntity(Level pLevel, LivingEntity livingEntity) {
        super(ModEntities.SAPPING_RAZOR_PROJECTILE.get(), livingEntity, pLevel);
        this.setOwner(livingEntity);
        if (livingEntity instanceof Player) {
            this.pickup = SappingRazorProjectileEntity.Pickup.ALLOWED;
        }
        BlockPos blockpos = livingEntity.blockPosition();
        double d0 = (double)blockpos.getX() + 0.5D;
        double d1 = (double)blockpos.getX() + 1.75D;
        double d2 = (double)blockpos.getX() + 0.5D;
        this.moveTo(d0, d1, d2, this.getYRot(), this.getXRot());
    }

    @Override
    public void tick() {
        super.tick();
        if(this.entityData.get(HIT)) {
            if(this.tickCount >= counter) {
                this.discard();
            }
        }

        if (this.tickCount >= 200) {
            this.remove(RemovalReason.DISCARDED);
        }

        Vec3 vec3 = this.getDeltaMovement();
        HitResult hitresult = ProjectileUtil.getHitResultOnMoveVector(this, this::canHitEntity);
        if (hitresult.getType() != HitResult.Type.MISS && !ForgeEventFactory.onProjectileImpact(this, hitresult))
            this.onHit(hitresult);

        double d0 = this.getX() + vec3.x;
        double d1 = this.getY() + vec3.y;
        double d2 = this.getZ() + vec3.z;
        this.updateRotation();

        double d5 = vec3.x;
        double d6 = vec3.y;
        double d7 = vec3.z;

        for(int i = 1; i < 5; ++i) {
            this.level().addParticle(ParticleTypes.DRIPPING_OBSIDIAN_TEAR, d0 - (d5 * 2), d1 - (d6 * 2), d2 - (d7 * 2),
                    -d5, -d6 - 0.1D, -d7);
        }

        if (this.level().getBlockStates(this.getBoundingBox()).noneMatch(BlockBehaviour.BlockStateBase::isAir)) {
            this.discard();
        } else {
            this.setDeltaMovement(vec3.scale(0.99F));
            this.setPos(d0, d1, d2);
        }
    }

    @Override
    protected void defineSynchedData() {
        this.entityData.define(HIT, false);
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    protected void onHitEntity(EntityHitResult hitResult) {
        super.onHitEntity(hitResult);
        Entity hitEntity = hitResult.getEntity();
        Entity owner = this.getOwner();

        if(hitEntity == owner && this.level().isClientSide()) {
            return;
        }

        //this.level().playSound(null, this.getX(), this.getY(), this.getZ(), ModSounds.METAL_DETECTOR_FOUND_ORE.get(), SoundSource.NEUTRAL, 2F, 1F);

        LivingEntity livingentity = owner instanceof LivingEntity ? (LivingEntity)owner : null;
        float damage = 5.5f;
        boolean hurt = hitEntity.hurt(this.damageSources().mobProjectile(this, livingentity), damage);
        if (hurt) {
            if(hitEntity instanceof LivingEntity livingHitEntity) {
                livingHitEntity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 100, 0), owner);
            }
        }
    }

    @Override
    protected void onHit(HitResult hitResult) {
        super.onHit(hitResult);
        for(int x = 0; x < 18; ++x) {
            for(int y = 0; y < 18; ++y) {
                this.level().addParticle(ParticleTypes.DRIPPING_OBSIDIAN_TEAR, this.getX(), this.getY(), this.getZ(),
                        Math.cos(x*20) * 0.15d, Math.cos(y*20) * 0.15d, Math.sin(x*20) * 0.15d);
            }
        }

        if(this.level().isClientSide()) {
            return;
        }

        if(hitResult.getType() == HitResult.Type.ENTITY && hitResult instanceof EntityHitResult entityHitResult) {
            Entity hit = entityHitResult.getEntity();
            Entity owner = this.getOwner();
            if(owner != hit) {
                this.entityData.set(HIT, true);
                counter = this.tickCount + 5;
            }
        } else {
            this.entityData.set(HIT, true);
            counter = this.tickCount + 5;
        }
    }

    protected void onHitBlock(BlockHitResult pResult) {
        super.onHitBlock(pResult);
        if (!this.level().isClientSide) {
            this.discard();
        }
        //Adapted from LlamaSpit.class
    }

    @Override
    protected ItemStack getPickupItem() {
        return new ItemStack(ModItems.SAPPING_RAZOR.get());
    }

    protected float getGravity() {
        return 0.015F;
    }

    public static enum Pickup {
        DISALLOWED,
        ALLOWED,
        CREATIVE_ONLY;

        public static SappingRazorProjectileEntity.Pickup byOrdinal(int pOrdinal) {
            if (pOrdinal < 0 || pOrdinal > values().length) {
                pOrdinal = 0;
            }

            return values()[pOrdinal];
        }
    }

    protected float getWaterInertia() {
        return 0.6F;
    }
}
