package com.whitestone.mixin;

import com.whitestone.Whitestone;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.world.gen.feature.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

import static com.whitestone.Whitestone.WHITESTONE_CONFIGUREDFEATURE;

@Mixin(OreConfiguredFeatures.class)
public class OreConfiguredFeaturesMixin {
    @Inject(at = @At("TAIL"), method = "bootstrap")
    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> featureRegisterable, CallbackInfo cbi) {
        RuleTest ruleTest2 = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest ruleTest3 = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        ConfiguredFeatures.register(featureRegisterable, WHITESTONE_CONFIGUREDFEATURE, Feature.ORE, new OreFeatureConfig(List.of(OreFeatureConfig.createTarget(ruleTest2, Whitestone.ORE_BLOCK.getDefaultState()), OreFeatureConfig.createTarget(ruleTest3, Whitestone.DEEPSLATE_ORE_BLOCK.getDefaultState())), 8));
    }
}
