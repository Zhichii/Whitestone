package com.whitestone.mixin;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.OrePlacedFeatures;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

import static com.whitestone.Whitestone.WHITESTONE_PLACEDFEATURE;
import static com.whitestone.Whitestone.WHITESTONE_CONFIGUREDFEATURE;

@Mixin(OrePlacedFeatures.class)
public class OrePlacedFeaturesMixin {
	@Inject(at = @At("TAIL"), method = "bootstrap")
	public static void bootstrap(Registerable<PlacedFeature> featureRegisterable, CallbackInfo abi) {
		RegistryEntryLookup<ConfiguredFeature<?, ?>> registryEntryLookup = featureRegisterable.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
		RegistryEntry<ConfiguredFeature<?, ?>> WHITESTONE_CONFIGUREDFEATURE_ENTRY = registryEntryLookup.getOrThrow(WHITESTONE_CONFIGUREDFEATURE);
		PlacedFeatures.register(featureRegisterable, WHITESTONE_PLACEDFEATURE, WHITESTONE_CONFIGUREDFEATURE_ENTRY, List.of(CountPlacementModifier.of(10), SquarePlacementModifier.of(), PlacedFeatures.TEN_ABOVE_AND_BELOW_RANGE, BiomePlacementModifier.of()));
	}
}