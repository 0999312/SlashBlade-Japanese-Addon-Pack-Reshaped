package cn.mmf.slashblade_addon;

import java.util.List;

import cn.mmf.slashblade_addon.data.SlashBladeAddonBuiltInRegistry;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class CommonEventHandler {
    @SubscribeEvent
    public static void onVillagerTrades(VillagerTradesEvent event) {
        addVillageTrade(event, "weaponsmith", 2,
                new VillagerSlashBladeListing(4, SlashBladeAddonBuiltInRegistry.TOYAKO.location(), 3, 5, 0.05F));
    }
    
    @SubscribeEvent
    public static void onWandererTrades(WandererTradesEvent event) {
    	List<VillagerTrades.ItemListing> rareTrades = event.getRareTrades();
    	rareTrades.add(new VillagerSlashBladeListing(4, SlashBladeAddonBuiltInRegistry.TOYAKO.location(), 3, 5, 0.05F));
    }
    
    public static void addVillageTrade(VillagerTradesEvent event, String villager, int level,
            VillagerTrades.ItemListing listing) {
        Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
        VillagerProfession profession = event.getType();
        if (profession.name() == null)
            return;
        if (profession.name().equals(villager)) {
            trades.get(level).add(listing);
        }
    }
}
