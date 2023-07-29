package com.whitestone.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.TransparentBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class BlockAbstactWhitestone {
    public abstract static class AbstactWhitestoneBlock extends TransparentBlock {

        public AbstactWhitestoneBlock(Settings settings) {
            super(settings);
        }

        public boolean getPower(BlockState state) {
            return false;
        }
        public boolean getAnyPower(BlockState state) {
            return getPower(state);
        }

        public float getAmbientOcclusionLightLevel(BlockState state, BlockView world, BlockPos pos) {
            return 1.0F;
        }

        public boolean isTransparent(BlockState state, BlockView world, BlockPos pos) {
            return true;
        }

    }
}
