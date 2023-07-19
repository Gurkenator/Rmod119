package net.gurken.recurrencemod.block.custom;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ModPipeBlock extends RotatedPillarBlock implements SimpleWaterloggedBlock {
    BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    private static final VoxelShape HOLLOW_SHAPE = Shapes.join(Shapes.block(), Block.box(2, 0, 2, 14, 16, 14), BooleanOp.ONLY_FIRST);
    private static final VoxelShape COLLISION_SHAPE = Shapes.join(Shapes.block(), Block.box(1, 0, 1, 15, 16, 15), BooleanOp.ONLY_FIRST);
    public ModPipeBlock(Properties pProperties) {
        super(pProperties);
    }
}
