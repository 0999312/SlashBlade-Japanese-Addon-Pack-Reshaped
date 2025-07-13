package cn.mmf.slashblade_addon.specialeffect;

import cn.mmf.slashblade_addon.registry.SBASpecialEffectsRegistry;
import mods.flammpfeil.slashblade.capability.slashblade.ISlashBladeState;
import mods.flammpfeil.slashblade.event.SlashBladeEvent;
import mods.flammpfeil.slashblade.registry.specialeffects.SpecialEffect;
import mods.flammpfeil.slashblade.slasharts.Drive;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class BurstDrive extends SpecialEffect {

	public BurstDrive() {
		super(30, false, false);
	}

	@SubscribeEvent
	public static void onDoingSlash(SlashBladeEvent.DoSlashEvent event) {
		ISlashBladeState state = event.getSlashBladeState();
		if(state.hasSpecialEffect(SBASpecialEffectsRegistry.BURST_DRIVE.getId())) {
			if (!(event.getUser() instanceof Player)) {
				return;
			}
			
			Player player = (Player) event.getUser();
			
			int level = player.experienceLevel;
			
			if(SpecialEffect.isEffective(SBASpecialEffectsRegistry.BURST_DRIVE.get(),level)) {
				Drive.doSlash(player, event.getRoll(), 10, Vec3.ZERO, false, event.getDamage(), 1.5f);
			}
		}
	}
}
