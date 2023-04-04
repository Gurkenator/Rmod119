package net.gurken.recurrencemod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

public class ModGlimmeringBlock extends Block {
    public static final BooleanProperty LIT = BlockStateProperties.LIT;

    public ModGlimmeringBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.defaultBlockState().setValue(LIT, Boolean.valueOf(false)));
    }

    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        if (!pEntity.isSteppingCarefully() && pEntity instanceof LivingEntity && !EnchantmentHelper.hasFrostWalker((LivingEntity)pEntity)) {
            pEntity.hurt(DamageSource.HOT_FLOOR, 1.5F);
        }
        interact(pState, pLevel, pPos);
        super.stepOn(pLevel, pPos, pState, pEntity);
    }

    private static void interact(BlockState pState, Level pLevel, BlockPos pPos) {
        makeParticles(pLevel, pPos);
        if (!pState.getValue(LIT)) {
            pLevel.setBlock(pPos, pState.setValue(LIT, Boolean.valueOf(true)), 3);
        }
    }

    public boolean isRandomlyTicking(BlockState pState) {
        return pState.getValue(LIT);
    }

    public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if (pState.getValue(LIT)) {
            pLevel.setBlock(pPos, pState.setValue(LIT, Boolean.valueOf(false)), 3);
        }
    }

    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        if (pState.getValue(LIT)) {
            makeParticles(pLevel, pPos);
        }
    }

    public static void makeParticles(Level pLevel, BlockPos pPos) {
        RandomSource randomsource = pLevel.getRandom();
        SimpleParticleType simpleparticletype = ParticleTypes.FLAME;
        pLevel.addAlwaysVisibleParticle(simpleparticletype, true, (double)pPos.getX() + 0.5D + randomsource.nextDouble() / 3.0D * (double)(randomsource.nextBoolean() ? 1 : -1), (double)pPos.getY() +0.15D + randomsource.nextDouble() + randomsource.nextDouble(), (double)pPos.getZ() + 0.5D + randomsource.nextDouble() / 3.0D * (double)(randomsource.nextBoolean() ? 1 : -1), 0.0D, 0.075D, 0.0D);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(LIT);
    }
}
