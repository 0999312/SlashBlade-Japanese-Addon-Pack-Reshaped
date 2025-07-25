package cn.mmf.slashblade_addon.compat.botania;

import mods.flammpfeil.slashblade.capability.slashblade.ISlashBladeState;
import mods.flammpfeil.slashblade.event.SlashBladeEvent;
import mods.flammpfeil.slashblade.registry.specialeffects.SpecialEffect;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.MinecraftForge;
import vazkii.botania.api.mana.ManaItemHandler;
import vazkii.botania.common.item.BotaniaItems;

public class ManaRapair extends SpecialEffect {

	public ManaRapair() {
		super(0, true, false);
		MinecraftForge.EVENT_BUS.addListener(this::onSlashBladeUpdate);
	}

    public void onSlashBladeUpdate(SlashBladeEvent.UpdateEvent event) {
        ISlashBladeState state = event.getSlashBladeState();
        if(state.hasSpecialEffect(SBABotaniaCompat.MANA_REPAIR.getId())) {
            if (!(event.getEntity() instanceof Player)) {
                return;
            }
            
            if(!event.isSelected())
                return;
            
            Player player = (Player) event.getEntity();
            
			if (!ManaItemHandler.instance().requestManaExactForTool(BotaniaItems.terraSword.getDefaultInstance(),
					player, 100, true))
				return;
            
			event.getBlade().setDamageValue(event.getBlade().getDamageValue() - 1);
        }
    }
}
