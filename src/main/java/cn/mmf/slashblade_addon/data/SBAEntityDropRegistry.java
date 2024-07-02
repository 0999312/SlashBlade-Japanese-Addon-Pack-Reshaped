package cn.mmf.slashblade_addon.data;

import cn.mmf.slashblade_addon.SlashBladeAddon;
import mods.flammpfeil.slashblade.event.drop.EntityDropEntry;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;

public class SBAEntityDropRegistry
{
    public static final ResourceKey<EntityDropEntry> RAVEN_DARKRAVEN = register("raven_darkraven");

    public static void registerAll(BootstapContext<EntityDropEntry> bootstrap)
    {
        bootstrap.register(RAVEN_DARKRAVEN, new EntityDropEntry(new ResourceLocation("twilightforest", "raven"), SlashBladeAddon.prefix("dark_raven"), 0.05F, false, true, new Vec3(0F, 60F, 0F)));
    }
    private static ResourceKey<EntityDropEntry> register(String id)
    {
        return ResourceKey.create(EntityDropEntry.REGISTRY_KEY, SlashBladeAddon.prefix(id));
    }
}
