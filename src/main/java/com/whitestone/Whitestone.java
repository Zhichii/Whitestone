package com.whitestone;

import com.whitestone.blocks.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Whitestone implements ModInitializer {

	public static final Logger LOGGER = LoggerFactory.getLogger("Whitestone-Mod");
	public static final int MEME_PERCENT = 5;

	public static final BlockSingle.SingleTransformationBlock SINGLE_BLOCK = new BlockSingle.SingleTransformationBlock(Block.Settings.create().nonOpaque().breakInstantly().luminance((state) -> (Boolean)state.get(Properties.POWERED) ? 10 : 0));
	public static final BlockItem SINGLE_BLOCKITEM = new BlockItem(SINGLE_BLOCK, new Item.Settings());
	public static final BlockAnd.AndBlock AND_BLOCK = new BlockAnd.AndBlock(Block.Settings.create().nonOpaque().breakInstantly().luminance((state) -> (Boolean)state.get(Properties.POWERED) ? 10 : 0));
	public static final BlockItem AND_BLOCKITEM = new BlockItem(AND_BLOCK, new Item.Settings());
	public static final BlockOr.OrBlock OR_BLOCK = new BlockOr.OrBlock(Block.Settings.create().nonOpaque().breakInstantly().luminance((state) -> (Boolean)state.get(Properties.POWERED) ? 10 : 0));
	public static final BlockItem OR_BLOCKITEM = new BlockItem(OR_BLOCK, new Item.Settings());
	public static final BlockNot.NotBlock NOT_BLOCK = new BlockNot.NotBlock(Block.Settings.create().nonOpaque().breakInstantly().luminance((state) -> (Boolean)state.get(Properties.POWERED) ? 10 : 0));
	public static final BlockItem NOT_BLOCKITEM = new BlockItem(NOT_BLOCK, new Item.Settings());
	public static final BlockStorer.StorerBlock STORER_BLOCK = new BlockStorer.StorerBlock(Block.Settings.create().nonOpaque().breakInstantly().luminance((state) -> (Boolean)state.get(Properties.POWERED) ? 14 : 0));
	public static final BlockItem STORER_BLOCKITEM = new BlockItem(STORER_BLOCK, new Item.Settings());
	public static final BlockLever.LeverBlock LEVER_BLOCK = new BlockLever.LeverBlock(Block.Settings.create().nonOpaque().breakInstantly().luminance((state) -> (Boolean)state.get(Properties.POWERED) ? 10 : 0));
	public static final BlockItem LEVER_BLOCKITEM = new BlockItem(LEVER_BLOCK, new Item.Settings());
	public static final BlockSource.SourceBlock SOURCE_BLOCK = new BlockSource.SourceBlock(Block.Settings.create().hardness(0.1f).luminance((state) -> 11));
	public static final BlockItem SOURCE_BLOCKITEM = new BlockItem(SOURCE_BLOCK, new Item.Settings());
	public static final BlockLamp.LampBlock LAMP_BLOCK = new BlockLamp.LampBlock(Block.Settings.create().hardness(0.1f).luminance((state) -> (Boolean)state.get(Properties.POWERED) ? 14 : 0));
	public static final BlockItem LAMP_BLOCKITEM = new BlockItem(LAMP_BLOCK, new Item.Settings());
	public static final BlockSoft.SoftConnectionBlock SOFT_BLOCK = new BlockSoft.SoftConnectionBlock(Block.Settings.create().hardness(0.1f));
	public static final BlockItem SOFT_BLOCKITEM = new BlockItem(SOFT_BLOCK, new Item.Settings());
	public static final Block ORE_BLOCK = new Block(Block.Settings.create().strength(3.0F, 3.0F).requiresTool());
	public static final BlockItem ORE_BLOCKITEM = new BlockItem(ORE_BLOCK, new Item.Settings());
	public static final Block DEEPSLATE_ORE_BLOCK = new Block(Block.Settings.copy(ORE_BLOCK).strength(4.5F, 3.0F));
	public static final BlockItem DEEPSLATE_ORE_BLOCKITEM = new BlockItem(DEEPSLATE_ORE_BLOCK, new Item.Settings());
	public static final BlockTransformerRToW.TransformerRToWBlock TRANSFORMER_RTOW_BLOCK = new BlockTransformerRToW.TransformerRToWBlock(Block.Settings.create().nonOpaque().breakInstantly().luminance((state) -> (Boolean)state.get(Properties.POWERED) ? 14 : 0));;
	public static final BlockItem TRANSFORMER_RTOW_BLOCKITEM = new BlockItem(TRANSFORMER_RTOW_BLOCK, new Item.Settings());
	public static final BlockTransformerWToR.TransformerWToRBlock TRANSFORMER_WTOR_BLOCK = new BlockTransformerWToR.TransformerWToRBlock(Block.Settings.create().nonOpaque().breakInstantly().luminance((state) -> (Boolean)state.get(Properties.POWERED) ? 14 : 0));;
	public static final BlockItem TRANSFORMER_WTOR_BLOCKITEM = new BlockItem(TRANSFORMER_WTOR_BLOCK, new Item.Settings());
	public static final Item DUST_ITEM = new Item(new Item.Settings());
	public static final RegistryKey<ItemGroup> WHITESTONE_GROUP = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier("whitestone"));;
	public static final RegistryKey<PlacedFeature> WHITESTONE_PLACEDFEATURE = PlacedFeatures.of("whitestone:ore_whitestone");
	public static final RegistryKey<ConfiguredFeature<?, ?>> WHITESTONE_CONFIGUREDFEATURE = ConfiguredFeatures.of("whitestone:ore_whitestone");


	@Override
	public void onInitialize() {
		LOGGER.info("Whitestone-Mod started to register!");
		Registry.register(Registries.BLOCK, new Identifier("whitestone", "single"), SINGLE_BLOCK);
		Registry.register(Registries.ITEM, new Identifier("whitestone", "single"), SINGLE_BLOCKITEM);
		Registry.register(Registries.BLOCK, new Identifier("whitestone", "and"), AND_BLOCK);
		Registry.register(Registries.ITEM, new Identifier("whitestone", "and"), AND_BLOCKITEM);
		Registry.register(Registries.BLOCK, new Identifier("whitestone", "or"), OR_BLOCK);
		Registry.register(Registries.ITEM, new Identifier("whitestone", "or"), OR_BLOCKITEM);
		Registry.register(Registries.BLOCK, new Identifier("whitestone", "not"), NOT_BLOCK);
		Registry.register(Registries.ITEM, new Identifier("whitestone", "not"), NOT_BLOCKITEM);
		Registry.register(Registries.BLOCK, new Identifier("whitestone", "lever"), LEVER_BLOCK);
		Registry.register(Registries.ITEM, new Identifier("whitestone", "lever"), LEVER_BLOCKITEM);
		Registry.register(Registries.BLOCK, new Identifier("whitestone", "source"), SOURCE_BLOCK);
		Registry.register(Registries.ITEM, new Identifier("whitestone", "source"), SOURCE_BLOCKITEM);
		Registry.register(Registries.BLOCK, new Identifier("whitestone", "lamp"), LAMP_BLOCK);
		Registry.register(Registries.ITEM, new Identifier("whitestone", "lamp"), LAMP_BLOCKITEM);
		Registry.register(Registries.BLOCK, new Identifier("whitestone", "storer"), STORER_BLOCK);
		Registry.register(Registries.ITEM, new Identifier("whitestone", "storer"), STORER_BLOCKITEM);
		Registry.register(Registries.BLOCK, new Identifier("whitestone", "soft"), SOFT_BLOCK);
		Registry.register(Registries.ITEM, new Identifier("whitestone", "soft"), SOFT_BLOCKITEM);
		Registry.register(Registries.BLOCK, new Identifier("whitestone", "ore"), ORE_BLOCK);
		Registry.register(Registries.ITEM, new Identifier("whitestone", "ore"), ORE_BLOCKITEM);
		Registry.register(Registries.BLOCK, new Identifier("whitestone", "deepslate_ore"), DEEPSLATE_ORE_BLOCK);
		Registry.register(Registries.ITEM, new Identifier("whitestone", "deepslate_ore"), DEEPSLATE_ORE_BLOCKITEM);
		Registry.register(Registries.BLOCK, new Identifier("whitestone", "transformer_rtow"), TRANSFORMER_RTOW_BLOCK);
		Registry.register(Registries.ITEM, new Identifier("whitestone", "transformer_rtow"), TRANSFORMER_RTOW_BLOCKITEM);
		Registry.register(Registries.BLOCK, new Identifier("whitestone", "transformer_wtor"), TRANSFORMER_WTOR_BLOCK);
		Registry.register(Registries.ITEM, new Identifier("whitestone", "transformer_wtor"), TRANSFORMER_WTOR_BLOCKITEM);
		Registry.register(Registries.ITEM, new Identifier("whitestone", "dust"), DUST_ITEM);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
				RegistryKey.of(RegistryKeys.PLACED_FEATURE,
						new Identifier("whitestone", "ore_whitestone")));

		Registry.register(Registries.ITEM_GROUP, WHITESTONE_GROUP, ItemGroup.create(ItemGroup.Row.TOP, 0).displayName(Text.translatable("itemGroup.whitestones")).icon(() -> new ItemStack(SOURCE_BLOCKITEM)).entries((displayContext, entries) -> {
			entries.add(DUST_ITEM);
			entries.add(SINGLE_BLOCKITEM);
			entries.add(AND_BLOCKITEM);
			entries.add(OR_BLOCKITEM);
			entries.add(NOT_BLOCKITEM);
			entries.add(STORER_BLOCKITEM);
			entries.add(LEVER_BLOCKITEM);
			entries.add(SOURCE_BLOCKITEM);
			entries.add(LAMP_BLOCKITEM);
			entries.add(SOFT_BLOCKITEM);
			entries.add(ORE_BLOCKITEM);
			entries.add(DEEPSLATE_ORE_BLOCKITEM);
			entries.add(TRANSFORMER_RTOW_BLOCKITEM);
			entries.add(TRANSFORMER_WTOR_BLOCKITEM);
		}).build());
	}
}