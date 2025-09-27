package cn.mmf.slashblade_addon.data;

import cn.mcmod_mmf.mmlib.data.AbstractConditionalDatapackEntriesProvider;
import cn.mmf.slashblade_addon.SlashBladeAddon;
import mods.flammpfeil.slashblade.event.drop.EntityDropEntry;
import mods.flammpfeil.slashblade.registry.slashblade.SlashBladeDefinition;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class SlashAddonDataGen {
    @SubscribeEvent
    public static void dataGen(GatherDataEvent event) {
        DataGenerator dataGenerator = event.getGenerator();
        CompletableFuture<Provider> lookupProvider = event.getLookupProvider();
        PackOutput packOutput = dataGenerator.getPackOutput();

        final RegistrySetBuilder bladeBuilder = new RegistrySetBuilder().add(SlashBladeDefinition.REGISTRY_KEY, SlashBladeAddonBuiltInRegistry::registerAll);
        final RegistrySetBuilder bladeDropBuilder = new RegistrySetBuilder().add(EntityDropEntry.REGISTRY_KEY, SBAEntityDropRegistry::registerAll);

        dataGenerator.addProvider(event.includeServer(), new SlashBladeAddonRecipeProvider(packOutput));
        dataGenerator.addProvider(event.includeServer(), new AbstractConditionalDatapackEntriesProvider
        		(packOutput, lookupProvider, bladeBuilder, Set.of(SlashBladeAddon.MODID)) {

			@Override
			public String getName() {
				return "SlashBlade Registry";
			}

			@SuppressWarnings("unchecked")
			@Override
			public Map<ResourceKey<SlashBladeDefinition>, List<ICondition>> getConditions() {
				return SlashBladeAddonBuiltInRegistry.getConditions();
			}
        	
        });
        dataGenerator.addProvider(event.includeServer(), new DatapackBuiltinEntriesProvider(packOutput, lookupProvider, bladeDropBuilder, Set.of(SlashBladeAddon.MODID))
        {
            @Override
            public String getName() {
                return "SlashBladeAddon Entity Drop Entry Registry";
            }
        });
    }
}
