package cn.mmf.slashblade_addon;

import cn.mmf.slashblade_addon.compat.SBATofuCraftItems;
import cn.mmf.slashblade_addon.compat.botania.SBABotaniaCompat;
import cn.mmf.slashblade_addon.registry.SBAComboStateRegistry;
import cn.mmf.slashblade_addon.registry.SBASlashArtsRegistry;
import cn.mmf.slashblade_addon.registry.SBASpecialEffectsRegistry;
import cn.mmf.slashblade_addon.registry.SBAEntitiesRegistry;
import com.mojang.logging.LogUtils;

import mods.flammpfeil.slashblade.client.renderer.entity.DriveRenderer;
import mods.flammpfeil.slashblade.client.renderer.entity.SummonedSwordRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegisterEvent;
import vazkii.botania.api.BotaniaAPI;

import org.slf4j.Logger;

@Mod(SlashBladeAddon.MODID)
public class SlashBladeAddon {
    public static final String MODID = "slashblade_addon";
    public static final Logger LOGGER = LogUtils.getLogger();

    public SlashBladeAddon() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::register);
        modEventBus.addListener(this::onRegisterRenderers);

        SBASlashArtsRegistry.SLASH_ARTS.register(modEventBus);
        SBAComboStateRegistry.COMBO_STATES.register(modEventBus);
        SBASpecialEffectsRegistry.SPECIAL_EFFECT.register(modEventBus);
        if (ModList.get().isLoaded(BotaniaAPI.MODID)) {
        	SBABotaniaCompat.COMBO_STATES.register(modEventBus);
        	SBABotaniaCompat.SLASH_ARTS.register(modEventBus);
        	SBABotaniaCompat.SPECIAL_EFFECT.register(modEventBus);
        }
    }

    public static ResourceLocation prefix(String path) {
        return new ResourceLocation(MODID, path);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    public void register(RegisterEvent event) {
        if (ModList.get().isLoaded("tofucraft")) {
            SBATofuCraftItems.register(event);
        }
        SBAEntitiesRegistry.register(event);
    }

    public void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event)
    {
        event.registerEntityRenderer(SBAEntitiesRegistry.BlisteringSwords, SummonedSwordRenderer::new);
        event.registerEntityRenderer(SBAEntitiesRegistry.SpiralEdgeSwords, SummonedSwordRenderer::new);
        event.registerEntityRenderer(SBAEntitiesRegistry.GaleSwords, SummonedSwordRenderer::new);
        event.registerEntityRenderer(SBAEntitiesRegistry.LightingSwords, SummonedSwordRenderer::new);
        event.registerEntityRenderer(SBAEntitiesRegistry.WaterDrive, DriveRenderer::new);
    }

}
