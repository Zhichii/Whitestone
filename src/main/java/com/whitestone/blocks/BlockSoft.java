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

import static net.minecraft.state.property.Properties.FACING;
import static net.minecraft.state.property.Properties.HORIZONTAL_FACING;

public class BlockSoft {
    public static class SoftConnectionBlock extends BlockAbstactWhitestone.AbstactWhitestoneBlock {
        public static final BooleanProperty POWERED;
        public SoftConnectionBlock(Settings settings) {
            super(settings);
            this.setDefaultState(this.stateManager.getDefaultState().with(POWERED, false));
        }

        public BlockState getPlacementState(ItemPlacementContext ctx) {
            return this.getDefaultState();
        }

        @Override
        public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
            BlockState cbs = world.getBlockState(pos);
            boolean powered = false;

            BlockState bs = world.getBlockState(pos.up());
            if (bs.getBlock() instanceof BlockAbstactWhitestone.AbstactWhitestoneBlock awb) {
                if (bs.getProperties().contains(FACING)) {
                    if (bs.get(FACING) == Direction.DOWN) powered = awb.getPower(bs);
                } else {
                    powered = awb.getPower(bs);
                }
            }

            bs = world.getBlockState(pos.down());
            if (bs.getBlock() instanceof BlockAbstactWhitestone.AbstactWhitestoneBlock awb) {
                if (bs.getProperties().contains(FACING)) {
                    if (bs.get(FACING) == Direction.UP) powered = powered || awb.getPower(bs);
                } else {
                    powered = powered || awb.getPower(bs);
                }
            }

            bs = world.getBlockState(pos.north());
            if (bs.getBlock() instanceof BlockAbstactWhitestone.AbstactWhitestoneBlock awb) {
                if (bs.getProperties().contains(FACING)) {
                    if (bs.get(FACING) == Direction.SOUTH) powered = powered || awb.getPower(bs);
                } else if (bs.getProperties().contains(HORIZONTAL_FACING)) {
                    if (bs.get(HORIZONTAL_FACING) == Direction.SOUTH) powered = powered || awb.getPower(bs);
                } else {
                    powered = powered || awb.getPower(bs);
                }
            }

            bs = world.getBlockState(pos.south());
            if (bs.getBlock() instanceof BlockAbstactWhitestone.AbstactWhitestoneBlock awb) {
                if (bs.getProperties().contains(FACING)) {
                    if (bs.get(FACING) == Direction.NORTH) powered = powered || awb.getPower(bs);
                } else if (bs.getProperties().contains(HORIZONTAL_FACING)) {
                    if (bs.get(HORIZONTAL_FACING) == Direction.NORTH) powered = powered || awb.getPower(bs);
                } else {
                    powered = powered || awb.getPower(bs);
                }
            }

            bs = world.getBlockState(pos.east());
            if (bs.getBlock() instanceof BlockAbstactWhitestone.AbstactWhitestoneBlock awb) {
                if (bs.getProperties().contains(FACING)) {
                    if (bs.get(FACING) == Direction.WEST) powered = powered || awb.getPower(bs);
                } else if (bs.getProperties().contains(HORIZONTAL_FACING)) {
                    if (bs.get(HORIZONTAL_FACING) == Direction.WEST) powered = powered || awb.getPower(bs);
                } else {
                    powered = powered || awb.getPower(bs);
                }
            }

            bs = world.getBlockState(pos.west());
            if (bs.getBlock() instanceof BlockAbstactWhitestone.AbstactWhitestoneBlock awb) {
                if (bs.getProperties().contains(FACING)) {
                    if (bs.get(FACING) == Direction.EAST) powered = powered || awb.getPower(bs);
                } else if (bs.getProperties().contains(HORIZONTAL_FACING)) {
                    if (bs.get(HORIZONTAL_FACING) == Direction.EAST) powered = powered || awb.getPower(bs);
                } else {
                    powered = powered || awb.getPower(bs);
                }
            }

            world.setBlockState(pos, cbs.with(POWERED, powered));
        }

        public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
            BlockState cbs = world.getBlockState(pos);
            boolean powered = false;

            BlockState bs = world.getBlockState(pos.up());
            if (bs.getBlock() instanceof BlockAbstactWhitestone.AbstactWhitestoneBlock awb) {
                if (bs.getProperties().contains(FACING)) {
                    if (bs.get(FACING) == Direction.DOWN) powered = awb.getPower(bs);
                } else {
                    powered = awb.getPower(bs);
                }
            }

            bs = world.getBlockState(pos.down());
            if (bs.getBlock() instanceof BlockAbstactWhitestone.AbstactWhitestoneBlock awb) {
                if (bs.getProperties().contains(FACING)) {
                    if (bs.get(FACING) == Direction.UP) powered = powered || awb.getPower(bs);
                } else {
                    powered = powered || awb.getPower(bs);
                }
            }

            bs = world.getBlockState(pos.north());
            if (bs.getBlock() instanceof BlockAbstactWhitestone.AbstactWhitestoneBlock awb) {
                if (bs.getProperties().contains(FACING)) {
                    if (bs.get(FACING) == Direction.SOUTH) powered = powered || awb.getPower(bs);
                } else if (bs.getProperties().contains(HORIZONTAL_FACING)) {
                    if (bs.get(HORIZONTAL_FACING) == Direction.SOUTH) powered = powered || awb.getPower(bs);
                } else {
                    powered = powered || awb.getPower(bs);
                }
            }

            bs = world.getBlockState(pos.south());
            if (bs.getBlock() instanceof BlockAbstactWhitestone.AbstactWhitestoneBlock awb) {
                if (bs.getProperties().contains(FACING)) {
                    if (bs.get(FACING) == Direction.NORTH) powered = powered || awb.getPower(bs);
                } else if (bs.getProperties().contains(HORIZONTAL_FACING)) {
                    if (bs.get(HORIZONTAL_FACING) == Direction.NORTH) powered = powered || awb.getPower(bs);
                } else {
                    powered = powered || awb.getPower(bs);
                }
            }

            bs = world.getBlockState(pos.east());
            if (bs.getBlock() instanceof BlockAbstactWhitestone.AbstactWhitestoneBlock awb) {
                if (bs.getProperties().contains(FACING)) {
                    if (bs.get(FACING) == Direction.WEST) powered = powered || awb.getPower(bs);
                } else if (bs.getProperties().contains(HORIZONTAL_FACING)) {
                    if (bs.get(HORIZONTAL_FACING) == Direction.WEST) powered = powered || awb.getPower(bs);
                } else {
                    powered = powered || awb.getPower(bs);
                }
            }

            bs = world.getBlockState(pos.west());
            if (bs.getBlock() instanceof BlockAbstactWhitestone.AbstactWhitestoneBlock awb) {
                if (bs.getProperties().contains(FACING)) {
                    if (bs.get(FACING) == Direction.EAST) powered = powered || awb.getPower(bs);
                } else if (bs.getProperties().contains(HORIZONTAL_FACING)) {
                    if (bs.get(HORIZONTAL_FACING) == Direction.EAST) powered = powered || awb.getPower(bs);
                } else {
                    powered = powered || awb.getPower(bs);
                }
            }

            world.setBlockState(pos, cbs.with(POWERED, powered));
        }

        public boolean getPower(BlockState state) {
            return state.get(Properties.POWERED);
        }

        public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
            if (!state.get(Properties.POWERED)) return;
            double d = (double)pos.getX() + 0.55 - (double)(random.nextFloat() * 0.1F);
            double e = (double)pos.getY() + 0.55 - (double)(random.nextFloat() * 0.1F);
            double f = (double)pos.getZ() + 0.55 - (double)(random.nextFloat() * 0.1F);
            if (random.nextInt(5) == 0) {
                world.addParticle(new DustParticleEffect(new Vector3f(1,1,1), 1.0F), d, e, f, random.nextGaussian() * 0.005, random.nextGaussian() * 0.005, random.nextGaussian() * 0.005);
            }

        }

        protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
            builder.add(POWERED);
        }

        public float getAmbientOcclusionLightLevel(BlockState state, BlockView world, BlockPos pos) {
            return state.isFullCube(world, pos) ? 0.2F : 1.0F;
        }

        static {
            POWERED = Properties.POWERED;
        }
    }

}