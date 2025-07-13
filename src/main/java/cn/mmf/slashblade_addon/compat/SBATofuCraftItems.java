package cn.mmf.slashblade_addon.compat;

import baguchan.tofucraft.registry.TofuItemTier;
import cn.mmf.slashblade_addon.SlashBladeAddon;
import cn.mmf.slashblade_addon.item.TofuSlashBladeItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;

public class SBATofuCraftItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SlashBladeAddon.MODID);
    // Create a Deferred Register to hold CreativeModeTabs which will all be registered under the "examplemod" namespace
    public static final ResourceLocation TOFUISHI_SLASHBLADE = new ResourceLocation(SlashBladeAddon.MODID, "slashblade_tofu_ishi");
    public static final ResourceLocation TOFUMETAL_SLASHBLADE = new ResourceLocation(SlashBladeAddon.MODID, "slashblade_tofu_metal");
    public static final ResourceLocation TOFUDIAMOND_SLASHBLADE = new ResourceLocation(SlashBladeAddon.MODID, "slashblade_tofu_diamond");

    public static void register(RegisterEvent event) {
        event.register(ForgeRegistries.Keys.ITEMS, helper -> {

            helper.register(new ResourceLocation(SlashBladeAddon.MODID, "slashblade_tofu_ishi"),
                    new TofuSlashBladeItem(TofuItemTier.SOLID, 3, -2.4F, 200, new Item.Properties()).setTexture(SlashBladeAddon.prefix("model/tofuishi_katana.png")));
            helper.register(new ResourceLocation(SlashBladeAddon.MODID, "slashblade_tofu_metal"),
                    new TofuSlashBladeItem(TofuItemTier.METAL, 5, -2.4F, 500, new Item.Properties()).setTexture(SlashBladeAddon.prefix("model/tofumetal_katana.png")));
            helper.register(new ResourceLocation(SlashBladeAddon.MODID, "slashblade_tofu_diamond"),
                    new TofuSlashBladeItem(TofuItemTier.TOFUDIAMOND, 9, -2.4F, 1200, new Item.Properties()).setTexture(SlashBladeAddon.prefix("model/tofudiamond_katana.png")));

        });
    }

    public static Item getItem(ResourceLocation item) {
        return ForgeRegistries.ITEMS.getValue(item);
    }

}
