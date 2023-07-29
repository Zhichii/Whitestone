package com.whitestone.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.joml.Vector3f;

public class BlockLever {

    public static class LeverBlock extends BlockAbstactWhitestone.AbstactWhitestoneBlock {
        public static final BooleanProperty POWERED;

        public LeverBlock(Settings settings) {
            super(settings);
            this.setDefaultState(this.stateManager.getDefaultState().with(POWERED, false));
        }

        public boolean getPower(BlockState state) {
            return state.get(Properties.POWERED);
        }

        public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
            if (player.canModifyBlocks()) {
                world.setBlockState(pos, state.with(POWERED, !state.get(POWERED)));
                return ActionResult.SUCCESS;
            }
            return ActionResult.PASS;
        }

        protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
            builder.add(POWERED);
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

        static {
            POWERED = Properties.POWERED;
        }

    }
}
