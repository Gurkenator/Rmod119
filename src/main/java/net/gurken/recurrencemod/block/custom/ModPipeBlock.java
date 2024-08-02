package net.gurken.recurrencemod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class ModPipeBlock extends RotatedPillarBlock implements SimpleWaterloggedBlock {

    public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.AXIS;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    private static final VoxelShape Z_INSIDE = box(2.0D, 2.0D, 0.0D, 14.0D, 14.0D, 16.0D);
    private static final VoxelShape Y_INSIDE = box(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D);
    private static final VoxelShape X_INSIDE = box(0.0D, 2.0D, 2.0D, 16.0D, 14.0D, 14.0D);
    private static final VoxelShape X_AXIS_PIPE = Shapes.join(Shapes.block(), Shapes.or(X_INSIDE), BooleanOp.ONLY_FIRST);
    private static final VoxelShape Y_AXIS_PIPE = Shapes.join(Shapes.block(), Shapes.or(Y_INSIDE), BooleanOp.ONLY_FIRST);
    private static final VoxelShape Z_AXIS_PIPE = Shapes.join(Shapes.block(), Shapes.or(Z_INSIDE), BooleanOp.ONLY_FIRST);
    public ModPipeBlock(BlockBehaviour.Properties pProperties) {

        super(pProperties);
        this.registerDefaultState(this.defaultBlockState().setValue(AXIS, Direction.Axis.Y).setValue(WATERLOGGED, Boolean.valueOf(false)));
    }

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
            case X -> X_AXIS_PIPE;
            case Z -> Z_AXIS_PIPE;
            default -> Y_AXIS_PIPE;
        };
    }

    @Override
    public BlockState rotate(BlockState pState, Rotation pRotation) {
        return rotatePillar(pState, pRotation);
    }

    public static BlockState rotatePillar(BlockState pState, Rotation pRotation) {
        switch (pRotation) {
            case COUNTERCLOCKWISE_90:
            case CLOCKWISE_90:
                switch (pState.getValue(AXIS)) {
                    case X:
                        return pState.setValue(AXIS, Direction.Axis.Z);
                    case Z:
                        return pState.setValue(AXIS, Direction.Axis.X);
                    default:
                        return pState;
                }
            default:
                return pState;
        }
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
