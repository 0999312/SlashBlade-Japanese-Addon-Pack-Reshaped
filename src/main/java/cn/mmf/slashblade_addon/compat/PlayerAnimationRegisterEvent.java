package cn.mmf.slashblade_addon.compat;

import cn.mmf.slashblade_addon.compat.botania.SBABotaniaCompat;
import cn.mmf.slashblade_addon.registry.SBAComboStateRegistry;
import mods.flammpfeil.slashblade.SlashBlade;
import mods.flammpfeil.slashblade.compat.playerAnim.PlayerAnimationOverrider;
import mods.flammpfeil.slashblade.compat.playerAnim.VmdAnimation;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(bus = Bus.MOD, value = Dist.CLIENT)
public class PlayerAnimationRegisterEvent {
    private static final ResourceLocation MotionLocation = new ResourceLocation(SlashBlade.MODID,
            "model/pa/player_motion.vmd");
    
	@SubscribeEvent
	public static void onRegisterPlayerAnim(FMLClientSetupEvent event) {
		if (ModList.get().isLoaded("playeranimator")) {
			PlayerAnimationOverrider.getInstance().getAnimation().put(SBAComboStateRegistry.RAPID_BLISTERING_SWORDS.getId(), 
					new VmdAnimation(MotionLocation, 400, 488, false));
			PlayerAnimationOverrider.getInstance().getAnimation().put(SBAComboStateRegistry.SPIRAL_EDGE.getId(), 
					new VmdAnimation(MotionLocation, 400, 488, false));
			PlayerAnimationOverrider.getInstance().getAnimation().put(SBAComboStateRegistry.GALE_SWORDS.getId(), 
					new VmdAnimation(MotionLocation, 400, 488, false));
			
			PlayerAnimationOverrider.getInstance().getAnimation().put(SBAComboStateRegistry.WATER_DRIVE.getId(), 
					new VmdAnimation(MotionLocation, 400, 488, false));
			PlayerAnimationOverrider.getInstance().getAnimation().put(SBAComboStateRegistry.LIGHTING_SWORDS.getId(), 
					new VmdAnimation(MotionLocation, 400, 488, false));
			PlayerAnimationOverrider.getInstance().getAnimation().put(SBAComboStateRegistry.FIRE_SPIRAL.getId(), 
					new VmdAnimation(MotionLocation, 400, 488, false));
			
			if(ModList.get().isLoaded("botania")) {
				PlayerAnimationOverrider.getInstance().getAnimation().put(SBABotaniaCompat.BLISTERING_TERRA_SWORDS.getId(), 
						new VmdAnimation(MotionLocation, 400, 488, false));
			}
		}
	}
}
