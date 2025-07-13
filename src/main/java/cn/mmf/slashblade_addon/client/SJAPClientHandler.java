package cn.mmf.slashblade_addon.client;

import org.jetbrains.annotations.Nullable;

import cn.mmf.slashblade_addon.compat.SBATofuCraftItems;
import mods.flammpfeil.slashblade.SlashBladeCreativeGroup;
import mods.flammpfeil.slashblade.client.ClientHandler;
import mods.flammpfeil.slashblade.client.renderer.model.BladeModel;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.item.ClampedItemPropertyFunction;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SJAPClientHandler {
	@SubscribeEvent
	public static void doClientStuff(final FMLClientSetupEvent event) {
		if (ModList.get().isLoaded("tofucraft")) {
			ItemProperties.register(SBATofuCraftItems.getItem(SBATofuCraftItems.TOFUISHI_SLASHBLADE),
					new ResourceLocation("slashblade:user"), new ClampedItemPropertyFunction() {
						@Override
						public float unclampedCall(ItemStack p_174564_, @Nullable ClientLevel p_174565_,
								@Nullable LivingEntity p_174566_, int p_174567_) {
							BladeModel.user = p_174566_;
							return 0;
						}
					});
			ItemProperties.register(SBATofuCraftItems.getItem(SBATofuCraftItems.TOFUMETAL_SLASHBLADE),
					new ResourceLocation("slashblade:user"), new ClampedItemPropertyFunction() {
						@Override
						public float unclampedCall(ItemStack p_174564_, @Nullable ClientLevel p_174565_,
								@Nullable LivingEntity p_174566_, int p_174567_) {
							BladeModel.user = p_174566_;
							return 0;
						}
					});
			ItemProperties.register(SBATofuCraftItems.getItem(SBATofuCraftItems.TOFUDIAMOND_SLASHBLADE),
					new ResourceLocation("slashblade:user"), new ClampedItemPropertyFunction() {
						@Override
						public float unclampedCall(ItemStack p_174564_, @Nullable ClientLevel p_174565_,
								@Nullable LivingEntity p_174566_, int p_174567_) {
							BladeModel.user = p_174566_;
							return 0;
						}
					});
		}
	}

	@SubscribeEvent
	public static void Baked(final ModelEvent.ModifyBakingResult event) {
		if (ModList.get().isLoaded("tofucraft")) {
			ClientHandler.bakeBlade(SBATofuCraftItems.getItem(SBATofuCraftItems.TOFUISHI_SLASHBLADE), event);
			ClientHandler.bakeBlade(SBATofuCraftItems.getItem(SBATofuCraftItems.TOFUMETAL_SLASHBLADE), event);
			ClientHandler.bakeBlade(SBATofuCraftItems.getItem(SBATofuCraftItems.TOFUDIAMOND_SLASHBLADE), event);
		}

	}

	@SubscribeEvent
	public static void addCreative(BuildCreativeModeTabContentsEvent event) {
		if (ModList.get().isLoaded("tofucraft")) {
			if (event.getTabKey() == SlashBladeCreativeGroup.SLASHBLADE_GROUP.getKey()) {
				event.accept(SBATofuCraftItems.getItem(SBATofuCraftItems.TOFUISHI_SLASHBLADE));
				event.accept(SBATofuCraftItems.getItem(SBATofuCraftItems.TOFUMETAL_SLASHBLADE));
				event.accept(SBATofuCraftItems.getItem(SBATofuCraftItems.TOFUDIAMOND_SLASHBLADE));
			}
		}
	}
}
