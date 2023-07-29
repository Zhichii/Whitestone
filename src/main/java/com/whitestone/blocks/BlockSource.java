package com.whitestone.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class BlockSource {

    public static class SourceBlock extends BlockAbstactWhitestone.AbstactWhitestoneBlock {

        public SourceBlock(Settings settings) {
            super(settings);
        }

        public boolean getPower(BlockState state) {
            return true;
        }

        public float getAmbientOcclusionLightLevel(BlockState state, BlockView world, BlockPos pos) {
            return state.isFullCube(world, pos) ? 0.2F : 1.0F;
        }

    }
}
