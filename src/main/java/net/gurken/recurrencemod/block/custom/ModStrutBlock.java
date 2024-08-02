package net.gurken.recurrencemod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class ModStrutBlock extends RotatedPillarBlock implements SimpleWaterloggedBlock{
    public ModStrutBlock(Properties p_49795_) {
        super(p_49795_);
        this.registerDefaultState(this.stateDefinition.any().setValue(WATERLOGGED, Boolean.FALSE).setValue(AXIS, Direction.Axis.X));
    }

    public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.AXIS;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    private static final VoxelShape SHAPE_X_AXIS = Shapes.or(Block.box(0,4,7,16,6,9), Block.box(0,10,7,16,12,9));
    private static final VoxelShape SHAPE_Y_AXIS = Shapes.or(Block.box(4,0,4,6,16,6), Block.box(10,0,10,12,16,12));
    private static final VoxelShape SHAPE_Z_AXIS = Shapes.or(Block.box(7,4,0,9,6,16), Block.box(7,10,0,9,12,16));

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext p_51454_) {
        FluidState fluidstate = p_51454_.getLevel().getFluidState(p_51454_.getClickedPos());
        boolean flag = fluidstate.getType() == Fluids.WATER;
        return this.defaultBlockState().setValue(AXIS, p_51454_.getClickedFace().getAxis()).setValue(WATERLOGGED, flag);
    }

    @Override
    public VoxelShape getShape(BlockState p_154346_, BlockGetter p_154347_, BlockPos p_154348_, CollisionContext p_154349_) {
        return switch (p_154346_.getValue(AXIS)) {
            case Y -> SHAPE_Y_AXIS;
            case Z -> SHAPE_Z_AXIS;
            default -> SHAPE_X_AXIS;
        };
    }

    @Override
    public BlockState rotate(BlockState pState, Rotation pRotation) {
        return rotatePillar(pState, pRotation);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED);
        builder.add(AXIS);
    }

    @Override
    public RenderShape getRenderShape(BlockState p_49232_) {
        return RenderShape.MODEL;
    }

    public BlockState updateShape(BlockState p_51461_, Direction p_51462_, BlockState p_51463_, LevelAccessor p_51464_, BlockPos p_51465_, BlockPos p_51466_) {
        if (p_51461_.getValue(WATERLOGGED)) {
            p_51464_.scheduleTick(p_51465_, Fluids.WATER, Fluids.WATER.getTickDelay(p_51464_));
        }

        return super.updateShape(p_51461_, p_51462_, p_51463_, p_51464_, p_51465_, p_51466_);
    }

    public FluidState getFluidState(BlockState p_51475_) {
        return p_51475_.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(p_51475_);
    }

    public boolean isPathfindable(BlockState p_51456_, BlockGetter p_51457_, BlockPos p_51458_, PathComputationType p_51459_) {
        return false;
    }
}
