package cn.mmf.slashblade_addon.data;

import baguchan.tofucraft.registry.TofuBlocks;
import baguchan.tofucraft.registry.TofuItems;
import cn.mmf.slashblade_addon.SlashBladeAddon;
import cn.mmf.slashblade_addon.compat.SBATofuCraftItems;
import mods.flammpfeil.slashblade.data.builtin.SlashBladeBuiltInRegistry;
import mods.flammpfeil.slashblade.init.SBItems;
import mods.flammpfeil.slashblade.item.SwordType;
import mods.flammpfeil.slashblade.recipe.RequestDefinition;
import mods.flammpfeil.slashblade.recipe.SlashBladeIngredient;
import mods.flammpfeil.slashblade.recipe.SlashBladeShapedRecipeBuilder;
import mods.flammpfeil.slashblade.registry.slashblade.EnchantmentDefinition;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.registries.ForgeRegistries;
import vazkii.botania.common.item.BotaniaItems;

import java.util.function.Consumer;

public class SlashBladeAddonRecipeProvider extends RecipeProvider implements IConditionBuilder {
	public SlashBladeAddonRecipeProvider(PackOutput output) {
		super(output);
	}

	protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
		ConditionalRecipe.builder().addCondition(modLoaded("energyblade"))
				.addRecipe((r) -> SlashBladeShapedRecipeBuilder
						.shaped(SlashBladeAddonBuiltInRegistry.HF_MURASAMA.location()).pattern(" RI").pattern("RBG")
						.pattern("SL ").define('S', SBItems.proudsoul_trapezohedron).define('I', Tags.Items.INGOTS_IRON)
						.define('G', Tags.Items.GUNPOWDER).define('R', Tags.Items.STORAGE_BLOCKS_REDSTONE)
						.define('L', Items.LEVER)
						.define('B',
								SlashBladeIngredient.of(RequestDefinition.Builder.newInstance()
										.name(SlashBladeBuiltInRegistry.MURAMASA.location()).build()))
						.unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(r))
				.build(consumer, SlashBladeAddon.prefix("murasama_blade"));
		
		ConditionalRecipe.builder().addCondition(modLoaded("energyblade"))
		.addRecipe((r) -> SlashBladeShapedRecipeBuilder
				.shaped(SlashBladeAddonBuiltInRegistry.WANDERER_HF.location())
				.pattern("  I")
				.pattern("QI ")
				.pattern("BC ")
				.define('C', SBItems.proudsoul_trapezohedron)
				.define('I', Tags.Items.DUSTS_REDSTONE)
				.define('Q', Tags.Items.GEMS_QUARTZ)
				.define('B',
						SlashBladeIngredient.of(RequestDefinition.Builder.newInstance()
								.name(SlashBladeAddonBuiltInRegistry.WANDERER.location()).build()))
				.unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(r))
		.build(consumer, SlashBladeAddon.prefix("wanderer_hf"));
		
		SlashBladeShapedRecipeBuilder.shaped(SlashBladeAddonBuiltInRegistry.WANDERER.location())
		.pattern("  I")
		.pattern("QI ")
		.pattern("BC ")
		.define('C', Items.CLOCK)
		.define('I', SBItems.proudsoul_ingot)
		.define('Q', Tags.Items.GEMS_QUARTZ)
		.define('B',
				SlashBladeIngredient.of(RequestDefinition.Builder.newInstance()
						.name(SlashBladeBuiltInRegistry.DOUTANUKI.location()).build()))
		.unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);
		

		ConditionalRecipe.builder().addCondition(modLoaded("tofucraft"))
				.addRecipe((r) -> SmithingTransformRecipeBuilder
						.smithing(Ingredient.of(TofuItems.TOFU_UPGRADE_SMITHING_TEMPLATE.get()),
								Ingredient.of(getItem(SBATofuCraftItems.TOFUMETAL_SLASHBLADE)),
								Ingredient.of(TofuBlocks.DIAMONDTOFU.get()), RecipeCategory.COMBAT,
								getItem(SBATofuCraftItems.TOFUDIAMOND_SLASHBLADE))
						.unlocks("has_item", has(getItem(SBATofuCraftItems.TOFUMETAL_SLASHBLADE)))
						.save(r, SlashBladeAddon.prefix("tofu_diamond_blade"))

				).build(consumer, SlashBladeAddon.prefix("tofu_diamond_blade"));
		ConditionalRecipe.builder().addCondition(modLoaded("tofucraft"))
				.addRecipe(SlashBladeShapedRecipeBuilder.shaped(SBATofuCraftItems.TOFUMETAL_SLASHBLADE).pattern(" ST")
						.pattern("ST ").pattern("WR ").define('S', TofuItems.TOFUISHI.get())
						.define('R', Tags.Items.STRING).define('W', Tags.Items.RODS_WOODEN)
						.define('T', TofuItems.TOFUMETAL.get())
						.unlockedBy(getHasName(SBItems.slashblade_wood), has(SBItems.slashblade_wood))::save)
				.build(consumer, SBATofuCraftItems.TOFUMETAL_SLASHBLADE);
		ConditionalRecipe.builder().addCondition(modLoaded("botania")).addRecipe((r) -> SlashBladeShapedRecipeBuilder
				.shaped(SlashBladeAddonBuiltInRegistry.TERRA_BLADE.location()).pattern("ZCO").pattern(" BG")
				.pattern("Q X").define('G', SBItems.proudsoul).define('X', SBItems.proudsoul_sphere)
				.define('Q', BotaniaItems.terraSword).define('Z', BotaniaItems.vineBall)
				.define('C', BotaniaItems.thornChakram).define('O', BotaniaItems.gaiaIngot)
				.define('B', SBItems.slashblade).unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade))
				.save(r, SlashBladeAddonBuiltInRegistry.TERRA_BLADE.location()))
				.build(consumer, SlashBladeAddonBuiltInRegistry.TERRA_BLADE.location());

		ConditionalRecipe.builder().addCondition(modLoaded("tofucraft"))
				.addRecipe(SlashBladeShapedRecipeBuilder.shaped(SBATofuCraftItems.TOFUISHI_SLASHBLADE).pattern(" SS")
						.pattern("SS ").pattern("WR ").define('S', TofuItems.TOFUISHI.get())
						.define('R', Tags.Items.STRING).define('W', Tags.Items.RODS_WOODEN)
						.unlockedBy(getHasName(SBItems.slashblade_wood), has(SBItems.slashblade_wood))::save)
				.build(consumer, SBATofuCraftItems.TOFUISHI_SLASHBLADE);

		SlashBladeShapedRecipeBuilder.shaped(SlashBladeAddonBuiltInRegistry.KAMUY_NONE.location()).pattern("SNS")
				.pattern("IBI").pattern("SDS").define('S', SBItems.proudsoul_sphere)
				.define('I', SBItems.proudsoul_ingot).define('N', Tags.Items.GEMS_QUARTZ).define('D', Items.BOOK)
				.define('B',
						SlashBladeIngredient
								.of(RequestDefinition.Builder.newInstance().killCount(100).refineCount(1).build()))
				.unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);

		SlashBladeShapedRecipeBuilder.shaped(SlashBladeAddonBuiltInRegistry.KAMUY_WATER.location()).pattern("SNS")
				.pattern("ABQ").pattern("SDS").define('S', SBItems.proudsoul_sphere).define('A', Items.PACKED_ICE)
				.define('Q', Items.SNOW_BLOCK).define('N', Tags.Items.STORAGE_BLOCKS_LAPIS)
				.define('D', Items.WATER_BUCKET)
				.define('B',
						SlashBladeIngredient.of(RequestDefinition.Builder.newInstance()
								.name(SlashBladeAddonBuiltInRegistry.KAMUY_NONE.location()).killCount(500)
								.proudSoul(5000).refineCount(20).build()))
				.unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);

		SlashBladeShapedRecipeBuilder.shaped(SlashBladeAddonBuiltInRegistry.KAMUY_LIGHTING.location()).pattern("SNS")
				.pattern("ABQ").pattern("SDS").define('S', SBItems.proudsoul_sphere)
				.define('A', Tags.Items.STORAGE_BLOCKS_GOLD).define('Q', Tags.Items.STORAGE_BLOCKS_DIAMOND)
				.define('N', Tags.Items.STORAGE_BLOCKS_IRON).define('D', Tags.Items.STORAGE_BLOCKS_EMERALD)
				.define('B',
						SlashBladeIngredient.of(RequestDefinition.Builder.newInstance()
								.name(SlashBladeAddonBuiltInRegistry.KAMUY_NONE.location()).killCount(500)
								.proudSoul(5000).refineCount(20).build()))
				.unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);

		SlashBladeShapedRecipeBuilder.shaped(SlashBladeAddonBuiltInRegistry.KAMUY_FIRE.location()).pattern("SNS")
				.pattern("ABQ").pattern("SDS").define('S', SBItems.proudsoul_sphere).define('A', Items.FIRE_CHARGE)
				.define('Q', Tags.Items.RODS_BLAZE).define('N', Tags.Items.STORAGE_BLOCKS_REDSTONE)
				.define('D', Items.LAVA_BUCKET)
				.define('B',
						SlashBladeIngredient.of(RequestDefinition.Builder.newInstance()
								.name(SlashBladeAddonBuiltInRegistry.KAMUY_NONE.location()).killCount(500)
								.proudSoul(5000).refineCount(20).build()))
				.unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);

		// nihil
		SlashBladeShapedRecipeBuilder.shaped(SlashBladeAddonBuiltInRegistry.NIHIL.location()).pattern("SIS")
				.pattern("IBI").pattern("SIS").define('S', SBItems.proudsoul_sphere)
				.define('I', SBItems.proudsoul_ingot).define('B', SBItems.slashblade)
				.unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);

		SlashBladeShapedRecipeBuilder.shaped(SlashBladeAddonBuiltInRegistry.NIHILEX.location()).pattern("SNS")
				.pattern("IBI").pattern("SDS").define('S', SBItems.proudsoul_sphere)
				.define('I', SBItems.proudsoul_ingot).define('N', Items.NETHER_STAR).define('D', Items.DIAMOND_BLOCK)
				.define('B',
						SlashBladeIngredient.of(RequestDefinition.Builder.newInstance()
								.name(SlashBladeAddonBuiltInRegistry.NIHIL.location()).killCount(1000).proudSoul(100)
								.refineCount(1).build()))
				.unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);

		SlashBladeShapedRecipeBuilder.shaped(SlashBladeAddonBuiltInRegistry.NIHILUL.location()).pattern("SNS")
				.pattern("DBD").pattern("SYS").define('S', SBItems.slashblade)
				.define('Y',
						SlashBladeIngredient.of(RequestDefinition.Builder.newInstance()
								.name(SlashBladeBuiltInRegistry.YAMATO.location()).build()))
				.define('N', Items.NETHER_STAR).define('D', Items.DIAMOND_BLOCK)
				.define('B',
						SlashBladeIngredient.of(RequestDefinition.Builder.newInstance()
								.name(SlashBladeAddonBuiltInRegistry.NIHILEX.location()).killCount(3000).proudSoul(6500)
								.refineCount(3).build()))
				.unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);

		SlashBladeShapedRecipeBuilder.shaped(SlashBladeAddonBuiltInRegistry.CRIMSONCHERRY.location()).pattern("DUD")
				.pattern("DED").pattern("DDD")
				.define('E',
						SlashBladeIngredient.of(RequestDefinition.Builder.newInstance()
								.name(SlashBladeAddonBuiltInRegistry.NIHIL.location()).build()))
				.define('D', Items.DIAMOND_BLOCK)
				.define('U',
						SlashBladeIngredient.of(RequestDefinition.Builder.newInstance()
								.name(SlashBladeAddonBuiltInRegistry.NIHILEX.location()).killCount(3000).proudSoul(6500)
								.refineCount(3).build()))
				.unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);

		SlashBladeShapedRecipeBuilder.shaped(SlashBladeAddonBuiltInRegistry.NIHILBX.location()).pattern("DDD")
				.pattern("CSU").pattern("DDD").define('S', SBItems.slashblade).define('D', Items.DIAMOND_BLOCK)
				.define('C',
						SlashBladeIngredient.of(RequestDefinition.Builder.newInstance()
								.name(SlashBladeAddonBuiltInRegistry.CRIMSONCHERRY.location()).killCount(3000)
								.proudSoul(6500).refineCount(3).build()))
				.define('U',
						SlashBladeIngredient.of(RequestDefinition.Builder.newInstance()
								.name(SlashBladeAddonBuiltInRegistry.NIHILUL.location()).killCount(3000).proudSoul(6500)
								.refineCount(3).build()))
				.unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);

		// WA
		SlashBladeShapedRecipeBuilder.shaped(SlashBladeAddonBuiltInRegistry.KATANA.location()).pattern("  P")
				.pattern(" B ").pattern("S  ").define('P', SBItems.proudsoul_ingot).define('S', Items.IRON_SWORD)
				.define('B',
						SlashBladeIngredient.of(SBItems.slashblade_silverbamboo,
								RequestDefinition.Builder.newInstance().addSwordType(SwordType.BROKEN).build()))
				.unlockedBy(getHasName(SBItems.slashblade_silverbamboo), has(SBItems.slashblade_silverbamboo))
				.save(consumer);

		SlashBladeShapedRecipeBuilder.shaped(SlashBladeAddonBuiltInRegistry.TACHI.location()).pattern("  P")
				.pattern(" B ").pattern("S  ").define('P', SBItems.proudsoul_sphere).define('S', Items.IRON_SWORD)
				.define('B',
						SlashBladeIngredient.of(SBItems.slashblade_silverbamboo,
								RequestDefinition.Builder.newInstance().addSwordType(SwordType.BROKEN).build()))
				.unlockedBy(getHasName(SBItems.slashblade_silverbamboo), has(SBItems.slashblade_silverbamboo))
				.save(consumer);

		SlashBladeShapedRecipeBuilder.shaped(SlashBladeAddonBuiltInRegistry.BLUE.location()).pattern("BCI")
				.pattern("CI ").pattern("SL ").define('B', Items.BLUE_DYE).define('C', Items.COAL_BLOCK)
				.define('I', SBItems.proudsoul_ingot).define('S', Items.STICK).define('L', Items.STRING)
				.unlockedBy(getHasName(SBItems.proudsoul_ingot), has(SBItems.proudsoul_ingot)).save(consumer);

		// BladeMaster
		SlashBladeShapedRecipeBuilder.shaped(SlashBladeAddonBuiltInRegistry.GREEN_MIST.location()).pattern("PRE")
				.pattern("RE ").pattern("BGC").define('P', SBItems.proudsoul_sphere).define('R', Items.REDSTONE_BLOCK)
				.define('E', Items.EMERALD_BLOCK).define('G', Items.GOLD_BLOCK).define('C', Items.CHERRY_LEAVES)
				.define('B',
						SlashBladeIngredient.of(RequestDefinition.Builder.newInstance()
								.name(SlashBladeBuiltInRegistry.MURAMASA.location()).killCount(1000).proudSoul(10000)
								.refineCount(25)
								.addEnchantment(new EnchantmentDefinition(
										ForgeRegistries.ENCHANTMENTS.getKey(Enchantments.POWER_ARROWS), 3))
								.build()))
				.unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);

		SlashBladeShapedRecipeBuilder.shaped(SlashBladeAddonBuiltInRegistry.AQUABLAZE.location()).pattern("PRW")
				.pattern("RL ").pattern("BGC").define('P', SBItems.proudsoul_sphere).define('R', Items.REDSTONE_BLOCK)
				.define('W', Items.WATER_BUCKET).define('L', Items.LAVA_BUCKET).define('G', Items.GOLD_BLOCK)
				.define('C', Items.CHERRY_LEAVES)
				.define('B',
						SlashBladeIngredient.of(RequestDefinition.Builder.newInstance()
								.name(SlashBladeBuiltInRegistry.MURAMASA.location()).killCount(1000).proudSoul(10000)
								.refineCount(25)
								.addEnchantment(new EnchantmentDefinition(
										ForgeRegistries.ENCHANTMENTS.getKey(Enchantments.FIRE_PROTECTION), 1))
								.build()))
				.unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);

		SlashBladeShapedRecipeBuilder.shaped(SlashBladeAddonBuiltInRegistry.MOONLIGHT_CHERRY.location()).pattern("PRQ")
				.pattern("RL ").pattern("BGC").define('P', SBItems.proudsoul_sphere).define('R', Items.REDSTONE_BLOCK)
				.define('Q', Items.QUARTZ_BLOCK).define('L', Items.GLOWSTONE).define('G', Items.GOLD_BLOCK)
				.define('C', Items.CHERRY_LEAVES)
				.define('B',
						SlashBladeIngredient.of(RequestDefinition.Builder.newInstance()
								.name(SlashBladeBuiltInRegistry.MURAMASA.location()).killCount(1000).proudSoul(10000)
								.refineCount(25)
								.addEnchantment(new EnchantmentDefinition(
										ForgeRegistries.ENCHANTMENTS.getKey(Enchantments.THORNS), 1))
								.build()))
				.unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);

		// Dark Raven:Snow Crow
		SlashBladeShapedRecipeBuilder.shaped(SlashBladeAddonBuiltInRegistry.SNOW_CROW.location()).pattern(" FQ")
				.pattern("SQ ").pattern("B  ").define('F', Items.FEATHER).define('S', Items.SNOWBALL)
				.define('Q', Items.QUARTZ_BLOCK)
				.define('B',
						SlashBladeIngredient.of(RequestDefinition.Builder.newInstance()
								.name(SlashBladeBuiltInRegistry.DOUTANUKI.location()).build()))
				.unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);

		// Fluorescent Bar
		SlashBladeShapedRecipeBuilder.shaped(SlashBladeAddonBuiltInRegistry.FLUORESCENT_BAR.location()).pattern(" PS")
				.pattern("PGP").pattern("SP ").define('P', Items.PAPER).define('G', Items.GLASS)
				.define('S', SBItems.proudsoul).unlockedBy(getHasName(SBItems.proudsoul), has(SBItems.proudsoul))
				.save(consumer);

		// Frost Wolf
		SlashBladeShapedRecipeBuilder.shaped(SlashBladeAddonBuiltInRegistry.FROSTY_CHERRY.location()).pattern(" ID")
				.pattern("SP ").pattern("BQ ").define('I', Items.ICE).define('D', Items.BLUE_DYE)
				.define('S', Items.SNOW_BLOCK).define('P', SBItems.proudsoul_sphere).define('Q', Items.QUARTZ)
				.define('B',
						SlashBladeIngredient.of(RequestDefinition.Builder.newInstance()
								.name(SlashBladeBuiltInRegistry.DOUTANUKI.location()).refineCount(10)
								.addEnchantment(new EnchantmentDefinition(
										ForgeRegistries.ENCHANTMENTS.getKey(Enchantments.FIRE_PROTECTION), 1))
								.build()))
				.unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);

		SlashBladeShapedRecipeBuilder.shaped(SlashBladeAddonBuiltInRegistry.FROST_WOLF.location()).pattern(" ID")
				.pattern("SP ").pattern("BQ ").define('I', Items.ICE).define('D', Items.BLUE_DYE)
				.define('S', Items.SNOW_BLOCK).define('P', SBItems.proudsoul_sphere).define('Q', Items.QUARTZ)
				.define('B',
						SlashBladeIngredient.of(RequestDefinition.Builder.newInstance()
								.name(SlashBladeBuiltInRegistry.MURAMASA.location()).refineCount(25)
								.addEnchantment(new EnchantmentDefinition(
										ForgeRegistries.ENCHANTMENTS.getKey(Enchantments.FIRE_PROTECTION), 1))
								.build()))
				.unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);

		SlashBladeShapedRecipeBuilder.shaped(SlashBladeAddonBuiltInRegistry.YUKARI.location()).pattern("ISI")
				.pattern("SBS").pattern("ISI").define('I', SBItems.proudsoul_ingot)
				.define('S', SBItems.proudsoul_sphere)
				.define('B',
						SlashBladeIngredient.of(RequestDefinition.Builder.newInstance()
								.name(SlashBladeBuiltInRegistry.TUKUMO.location()).killCount(1000)
								.addEnchantment(new EnchantmentDefinition(
										ForgeRegistries.ENCHANTMENTS.getKey(Enchantments.FIRE_ASPECT), 1))
								.build()))
				.unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);

		SlashBladeShapedRecipeBuilder.shaped(SlashBladeAddonBuiltInRegistry.KIRISAYA.location()).pattern("DID")
				.pattern("SBS").pattern("IDI").define('D', Items.MUSIC_DISC_13).define('I', Items.GOLDEN_APPLE)
				.define('S', SBItems.proudsoul_sphere)
				.define('B',
						SlashBladeIngredient.of(SBItems.slashblade_silverbamboo, RequestDefinition.Builder.newInstance()
								.proudSoul(10000).killCount(1000).refineCount(1).addSwordType(SwordType.BROKEN)
								.addEnchantment(new EnchantmentDefinition(
										ForgeRegistries.ENCHANTMENTS.getKey(Enchantments.SHARPNESS), 3))
								.build()))
				.unlockedBy(getHasName(SBItems.slashblade_silverbamboo), has(SBItems.slashblade_silverbamboo))
				.save(consumer);

		SlashBladeShapedRecipeBuilder.shaped(SlashBladeAddonBuiltInRegistry.LAEMMLE.location()).pattern("XGO")
				.pattern("GBG").pattern("QGX").define('G', Tags.Items.INGOTS_GOLD)
				.define('X', Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.STRONG_STRENGTH)))
				.define('Q', Tags.Items.STORAGE_BLOCKS_QUARTZ).define('O', Tags.Items.OBSIDIAN)
				.define('B',
						SlashBladeIngredient.of(RequestDefinition.Builder.newInstance()
								.name(SlashBladeBuiltInRegistry.MURAMASA.location()).build()))
				.unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);

		SlashBladeShapedRecipeBuilder.shaped(SlashBladeAddonBuiltInRegistry.TBOEN.location()).pattern("SSS")
				.pattern("SBS").pattern("SSS").define('S', SBItems.proudsoul).define('B', SBItems.slashblade_white)
				.unlockedBy(getHasName(SBItems.slashblade_white), has(SBItems.slashblade_white)).save(consumer);

	}

	public Item getItem(ResourceLocation item) {
		return ForgeRegistries.ITEMS.getValue(item);
	}

}
