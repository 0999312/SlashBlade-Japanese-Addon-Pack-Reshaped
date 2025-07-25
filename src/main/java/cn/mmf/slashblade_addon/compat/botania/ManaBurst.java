package cn.mmf.slashblade_addon.compat.botania;

import mods.flammpfeil.slashblade.capability.slashblade.ISlashBladeState;
import mods.flammpfeil.slashblade.event.SlashBladeEvent;
import mods.flammpfeil.slashblade.registry.specialeffects.SpecialEffect;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.MinecraftForge;
import vazkii.botania.api.mana.ManaItemHandler;
import vazkii.botania.common.entity.ManaBurstEntity;
import vazkii.botania.common.handler.BotaniaSounds;
import vazkii.botania.common.item.BotaniaItems;
import vazkii.botania.common.item.equipment.tool.terrasteel.TerraBladeItem;

public class ManaBurst extends SpecialEffect {

	public ManaBurst() {
		super(10, true, false);
		MinecraftForge.EVENT_BUS.addListener(this::onDoingSlash);
	}

	public void onDoingSlash(SlashBladeEvent.DoSlashEvent event) {
		ISlashBladeState state = event.getSlashBladeState();
		if(state.hasSpecialEffect(SBABotaniaCompat.MANA_BURST.getId())) {
			if (!(event.getUser() instanceof Player)) {
				return;
			}
			
			Player player = (Player) event.getUser();
			
			int level = player.experienceLevel;
			
			if(SpecialEffect.isEffective(SBABotaniaCompat.MANA_BURST.get(),level)) {
				if (!ManaItemHandler.instance().requestManaExactForTool(BotaniaItems.terraSword.getDefaultInstance(),
						player, 100, true))
					return;
				ManaBurstEntity burst = TerraBladeItem.getBurst(player, BotaniaItems.terraSword.getDefaultInstance());
				player.level().addFreshEntity(burst);
				player.getMainHandItem().hurtAndBreak(1, player, p -> p.broadcastBreakEvent(InteractionHand.MAIN_HAND));
				player.level().playSound(null, player.getX(), player.getY(), player.getZ(), BotaniaSounds.terraBlade, SoundSource.PLAYERS, 1F, 1F);
			}
		}
	}
}
