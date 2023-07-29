package com.whitestone.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;

public class BlockAnd {
    public static class AndBlock extends BlockAbstactWhitestone.AbstactWhitestoneBlock {
        public static final BooleanProperty POWERED;
        public static final DirectionProperty FACING;
        public AndBlock(Settings settings) {
            super(settings);
            this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH));
            this.setDefaultState(this.stateManager.getDefaultState().with(POWERED, false));
        }

        public BlockState getPlacementState(ItemPlacementContext ctx) {
            return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing());
        }

        @Override
        public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
            BlockState cbs = world.getBlockState(pos);
            BlockState bs1 = world.getBlockState(pos.offset(state.get(FACING).rotateCounterclockwise(Direction.Axis.Y)));
            BlockState bs2 = world.getBlockState(pos.offset(state.get(FACING).rotateClockwise(Direction.Axis.Y)));
            boolean a = false;
            boolean b = false;
            if (bs1.getBlock() instanceof BlockAbstactWhitestone.AbstactWhitestoneBlock awb) {
                a = awb.getAnyPower(bs1);
            }
            if (bs2.getBlock() instanceof BlockAbstactWhitestone.AbstactWhitestoneBlock awb) {
                b = awb.getAnyPower(bs1);
            }
            world.setBlockState(pos, cbs.with(POWERED, a && b));
        }

        public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
            BlockState cbs = world.getBlockState(pos);
            BlockState bs1 = world.getBlockState(pos.offset(state.get(FACING).rotateCounterclockwise(Direction.Axis.Y)));
            BlockState bs2 = world.getBlockState(pos.offset(state.get(FACING).rotateClockwise(Direction.Axis.Y)));
            boolean a = false;
            boolean b = false;
            if (bs1.getBlock() instanceof BlockAbstactWhitestone.AbstactWhitestoneBlock awb) {
                a = awb.getAnyPower(bs1);
            }
            if (bs2.getBlock() instanceof BlockAbstactWhitestone.AbstactWhitestoneBlock awb) {
                b = awb.getAnyPower(bs2);
            }
            world.setBlockState(pos, cbs.with(POWERED, a && b));
        }

        public boolean getPower(BlockState state) {
            return state.get(Properties.POWERED);
        }

        public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
            if (!state.get(Properties.POWERED)) return;
            Direction direction = state.get(FACING);
            double d = (double)pos.getX() + 0.55 - (double)(random.nextFloat() * 0.1F);
            double e = (double)pos.getY() + 0.55 - (double)(random.nextFloat() * 0.1F);
            double f = (double)pos.getZ() + 0.55 - (double)(random.nextFloat() * 0.1F);
            double g = 0.4F - (random.nextFloat() + random.nextFloat()) * 0.4F;
            if (random.nextInt(5) == 0) {
                world.addParticle(new DustParticleEffect(new Vector3f(1,1,1), 1.0F), d + (double)direction.getOffsetX() * g, e + (double)direction.getOffsetY() * g, f + (double)direction.getOffsetZ() * g, random.nextGaussian() * 0.005, random.nextGaussian() * 0.005, random.nextGaussian() * 0.005);
            }

        }

        protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
            builder.add(FACING);
            builder.add(POWERED);
        }

        static {
            POWERED = Properties.POWERED;
            FACING = Properties.HORIZONTAL_FACING;
        }
    }

}
