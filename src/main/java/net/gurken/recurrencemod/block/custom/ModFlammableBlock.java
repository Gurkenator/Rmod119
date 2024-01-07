package net.gurken.recurrencemod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;

public class ModFlammableBlock extends Block {
    private final int flammability;
    private final int fireSpreadSpeed;

    public ModFlammableBlock(Properties properties, int flammability, int fireSpreadSpeed) {
        super(properties);
        this.flammability = flammability;
        this.fireSpreadSpeed = fireSpreadSpeed;
    }
    //Thanks to DancerVLT69 on the Kaupenjoe Discord, who helped me clean up this code

    @Override
    public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return true;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return flammability;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return fireSpreadSpeed;
    }
}
