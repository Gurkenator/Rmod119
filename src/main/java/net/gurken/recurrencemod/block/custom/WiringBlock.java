package net.gurken.recurrencemod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class WiringBlock extends Block implements SimpleWaterloggedBlock {

    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final DirectionProperty FACING = BlockStateProperties.FACING;
    protected final VoxelShape northAabb;
    protected final VoxelShape southAabb;
    protected final VoxelShape eastAabb;
    protected final VoxelShape westAabb;
    public WiringBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(false)).setValue(FACING, Direction.NORTH));
        this.eastAabb = Block.box(0,3,0,16,6,2);
        this.westAabb = Block.box(0,3,14,16,6,16);
        this.southAabb = Block.box(14,3,0,16,6,16);
        this.northAabb = Block.box(0,3,0,2,6,16);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext p_51454_) {
        FluidState fluidstate = p_51454_.getLevel().getFluidState(p_51454_.getClickedPos());
        boolean flag = fluidstate.getType() == Fluids.WATER;
        return super.getStateForPlacement(p_51454_).setValue(WATERLOGGED, Boolean.valueOf(flag)).setValue(FACING, p_51454_.getHorizontalDirection().getClockWise());
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        Direction direction = pState.getValue(FACING);
        switch (direction) {
            case SOUTH:
                return this.southAabb;
            case EAST:
                return this.eastAabb;
            case WEST:
                return this.westAabb;
            case NORTH:
            default:
                return this.northAabb;
        }
    }



    @Override
    public BlockState rotate(BlockState pState, Rotation pRotation) {
        return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
        builder.add(WATERLOGGED);
    }

    @Override
    public RenderShape getRenderShape(BlockState p_49232_) {
        return RenderShape.MODEL;
    }

    /**
     * Update the provided state given the provided neighbor direction and neighbor state, returning a new state.
     * For example, fences make their connections to the passed in state if possible, and wet concrete powder immediately
     * returns its solidified counterpart.
     * Note that this method should ideally consider only the specific direction passed in.
     */
    public BlockState updateShape(BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pPos, BlockPos pNeighborPos) {
        if (pState.getValue(WATERLOGGED)) {
            pLevel.scheduleTick(pPos, Fluids.WATER, Fluids.WATER.getTickDelay(pLevel));
        }

        return pDirection == pState.getValue(FACING).getOpposite() && !pState.canSurvive(pLevel, pPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(pState, pDirection, pNeighborState, pLevel, pPos, pNeighborPos);
    }

    public FluidState getFluidState(BlockState p_51475_) {
        return p_51475_.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(p_51475_);
    }

    public boolean isPathfindable(BlockState p_51456_, BlockGetter p_51457_, BlockPos p_51458_, PathComputationType p_51459_) {
        return false;
    }
}
