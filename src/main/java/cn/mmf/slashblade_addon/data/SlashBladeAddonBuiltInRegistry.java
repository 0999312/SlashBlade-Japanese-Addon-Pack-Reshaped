package cn.mmf.slashblade_addon.data;

import cn.mmf.energyblade.Energyblade;
import cn.mmf.slashblade_addon.SlashBladeAddon;
import cn.mmf.slashblade_addon.compat.botania.SBABotaniaCompat;
import cn.mmf.slashblade_addon.registry.SBASlashArtsRegistry;
import cn.mmf.slashblade_addon.registry.SBASpecialEffectsRegistry;
import mods.flammpfeil.slashblade.client.renderer.CarryType;
import mods.flammpfeil.slashblade.item.SwordType;
import mods.flammpfeil.slashblade.registry.SlashArtsRegistry;
import mods.flammpfeil.slashblade.registry.slashblade.EnchantmentDefinition;
import mods.flammpfeil.slashblade.registry.slashblade.PropertiesDefinition;
import mods.flammpfeil.slashblade.registry.slashblade.RenderDefinition;
import mods.flammpfeil.slashblade.registry.slashblade.SlashBladeDefinition;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

public class SlashBladeAddonBuiltInRegistry {

    //Nihil
    public static final ResourceKey<SlashBladeDefinition> NIHIL = register("nihil");
    public static final ResourceKey<SlashBladeDefinition> NIHILEX = register("nihilex");
    public static final ResourceKey<SlashBladeDefinition> NIHILBX = register("nihilbx");
    public static final ResourceKey<SlashBladeDefinition> NIHILUL = register("nihilul");
    public static final ResourceKey<SlashBladeDefinition> CRIMSONCHERRY = register("crimsoncherry");

    //WA
    public static final ResourceKey<SlashBladeDefinition> KATANA = register("katana");
    public static final ResourceKey<SlashBladeDefinition> TACHI = register("tachi");
    public static final ResourceKey<SlashBladeDefinition> BLUE = register("blue");

    //BladeMaster
    public static final ResourceKey<SlashBladeDefinition> GREEN_MIST = register("green_mist");
    public static final ResourceKey<SlashBladeDefinition> AQUABLAZE = register("aquablaze");
    public static final ResourceKey<SlashBladeDefinition> MOONLIGHT_CHERRY = register("moonlight_cherry");

    //Dark Raven
    public static final ResourceKey<SlashBladeDefinition> DARK_RAVEN = register("dark_raven");
    public static final ResourceKey<SlashBladeDefinition> SNOW_CROW = register("snow_crow");

    //Fluorescent Bar
    public static final ResourceKey<SlashBladeDefinition> FLUORESCENT_BAR = register("fluorescent_bar");

    //Frost Wolf
    public static final ResourceKey<SlashBladeDefinition> FROSTY_CHERRY = register("frosty_cherry");
    public static final ResourceKey<SlashBladeDefinition> FROST_WOLF = register("frost_wolf");
    
    //Toyako
    public static final ResourceKey<SlashBladeDefinition> TOYAKO = register("toyako");
    
    //Yukari
    public static final ResourceKey<SlashBladeDefinition> YUKARI = register("yukari");
    
    //Laemmle
    public static final ResourceKey<SlashBladeDefinition> LAEMMLE = register("laemmle");
    
    //Tboen
    public static final ResourceKey<SlashBladeDefinition> TBOEN = register("tboen");
    
    public static final ResourceKey<SlashBladeDefinition> KIRISAYA = register("kirisaya");
    
    public static final ResourceKey<SlashBladeDefinition> TERRA_BLADE = register("terra_blade");
    
    //Laemmle
    public static final ResourceKey<SlashBladeDefinition> KAMUY_NONE = register("kamuy_none");

    public static final ResourceKey<SlashBladeDefinition> KAMUY_WATER = register("kamuy_water");
    
    public static final ResourceKey<SlashBladeDefinition> KAMUY_FIRE = register("kamuy_fire");
    
    public static final ResourceKey<SlashBladeDefinition> KAMUY_LIGHTING = register("kamuy_lightning");
    
    public static final ResourceKey<SlashBladeDefinition> HF_MURASAMA = register("hf_murasama");
    
    //wanderer
    public static final ResourceKey<SlashBladeDefinition> WANDERER = register("wanderer");
    public static final ResourceKey<SlashBladeDefinition> WANDERER_HF = register("wanderer_hf");

    public static void registerAll(BootstapContext<SlashBladeDefinition> bootstrap) {
    	
		bootstrap.register(HF_MURASAMA, new SlashBladeDefinition(Energyblade.FORGE_ENERGY_BLADE.getId(),
				SlashBladeAddon.prefix("hf_murasama"),
				RenderDefinition.Builder.newInstance()
						.textureName(SlashBladeAddon.prefix("model/murasama/murasama.png"))
						.modelName(SlashBladeAddon.prefix("model/murasama/murasama.obj"))
						.effectColor(0xFFFF2600)
						.standbyRenderType(CarryType.PSO2).build(),
				PropertiesDefinition.Builder.newInstance().baseAttackModifier(8.0F).maxDamage(250)
						.defaultSwordType(List.of(SwordType.BEWITCHED))
						.slashArtsType(SBASlashArtsRegistry.SPIRAL_EDGE.getId()).build(),
				List.of()));

		bootstrap.register(WANDERER, new SlashBladeDefinition(
				SlashBladeAddon.prefix("wanderer"),
				RenderDefinition.Builder.newInstance()
						.textureName(SlashBladeAddon.prefix("model/wanderer/wanderer.png"))
						.modelName(SlashBladeAddon.prefix("model/wanderer/wanderer.obj"))
						.standbyRenderType(CarryType.NINJA).build(),
				PropertiesDefinition.Builder.newInstance().baseAttackModifier(7.0F).maxDamage(60)
						.defaultSwordType(List.of(SwordType.BEWITCHED))
						.slashArtsType(SBASlashArtsRegistry.RAPID_BLISTERING_SWORDS.getId()).build(),
				List.of()));
		
		bootstrap.register(WANDERER_HF, new SlashBladeDefinition(Energyblade.FORGE_ENERGY_BLADE.getId(),
				SlashBladeAddon.prefix("wanderer_hf"),
				RenderDefinition.Builder.newInstance()
						.textureName(SlashBladeAddon.prefix("model/wanderer/wanderer.png"))
						.modelName(SlashBladeAddon.prefix("model/wanderer/wanderer.obj"))
						.standbyRenderType(CarryType.NINJA).build(),
				PropertiesDefinition.Builder.newInstance().baseAttackModifier(7.0F).maxDamage(70)
						.defaultSwordType(List.of(SwordType.BEWITCHED))
						.slashArtsType(SBASlashArtsRegistry.RAPID_BLISTERING_SWORDS.getId()).build(),
				List.of()));
    	
        bootstrap.register(KAMUY_NONE,
                new SlashBladeDefinition(SlashBladeAddon.prefix("kamuy_none"),
                     RenderDefinition.Builder.newInstance()
                     .textureName(SlashBladeAddon.prefix("model/kamuy/kamuy.png"))
                     .modelName(SlashBladeAddon.prefix("model/kamuy/kamuy.obj"))
                     .standbyRenderType(CarryType.PSO2)
                     .build(),
                     PropertiesDefinition.Builder.newInstance()
                     .baseAttackModifier(7.0F)
                     .maxDamage(45)
                     .slashArtsType(SlashArtsRegistry.CIRCLE_SLASH.getId())
                     .defaultSwordType(List.of(SwordType.BEWITCHED)).build(),
                     List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.MOB_LOOTING), 1)))
                );
        
        bootstrap.register(KAMUY_WATER,
                new SlashBladeDefinition(SlashBladeAddon.prefix("kamuy_water"),
                     RenderDefinition.Builder.newInstance()
                     .textureName(SlashBladeAddon.prefix("model/kamuy/water.png"))
                     .modelName(SlashBladeAddon.prefix("model/kamuy/kamuy.obj"))
                     .standbyRenderType(CarryType.PSO2)
                     .build(),
                     PropertiesDefinition.Builder.newInstance()
                     .baseAttackModifier(7.0F)
                     .maxDamage(50)
                     .slashArtsType(SBASlashArtsRegistry.WATER_DRIVE.getId())
                     .defaultSwordType(List.of(SwordType.BEWITCHED)).build(),
                     List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 3),
                             new EnchantmentDefinition(getEnchantmentID(Enchantments.KNOCKBACK), 2),
                             new EnchantmentDefinition(getEnchantmentID(Enchantments.MOB_LOOTING), 3),
                             new EnchantmentDefinition(getEnchantmentID(Enchantments.FIRE_PROTECTION), 1)))
                );
        
        bootstrap.register(KAMUY_LIGHTING,
                new SlashBladeDefinition(SlashBladeAddon.prefix("kamuy_lightning"),
                     RenderDefinition.Builder.newInstance()
                     .textureName(SlashBladeAddon.prefix("model/kamuy/lightning.png"))
                     .modelName(SlashBladeAddon.prefix("model/kamuy/kamuy.obj"))
                     .effectColor(0xFFFAE900)
                     .standbyRenderType(CarryType.PSO2)
                     .build(),
                     PropertiesDefinition.Builder.newInstance()
                     .baseAttackModifier(7.0F)
                     .maxDamage(50)
                     .slashArtsType(SBASlashArtsRegistry.LIGHTING_SWORDS.getId())
                     .defaultSwordType(List.of(SwordType.BEWITCHED)).build(),
                     List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 3),
                             new EnchantmentDefinition(getEnchantmentID(Enchantments.SMITE), 3),
                             new EnchantmentDefinition(getEnchantmentID(Enchantments.FALL_PROTECTION), 1)))
                );
        
        bootstrap.register(KAMUY_FIRE,
                new SlashBladeDefinition(SlashBladeAddon.prefix("kamuy_fire"),
                     RenderDefinition.Builder.newInstance()
                     .textureName(SlashBladeAddon.prefix("model/kamuy/fire.png"))
                     .modelName(SlashBladeAddon.prefix("model/kamuy/kamuy.obj"))
                     .standbyRenderType(CarryType.PSO2)
                     .effectColor(0xFFEE2600)
                     .build(),
                     PropertiesDefinition.Builder.newInstance()
                     .baseAttackModifier(7.0F)
                     .maxDamage(40)
                     .slashArtsType(SBASlashArtsRegistry.FIRE_SPIRAL.getId())
                     .defaultSwordType(List.of(SwordType.BEWITCHED)).build(),
                     List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 3),
                             new EnchantmentDefinition(getEnchantmentID(Enchantments.BANE_OF_ARTHROPODS), 2),
                             new EnchantmentDefinition(getEnchantmentID(Enchantments.FIRE_PROTECTION), 1),
                             new EnchantmentDefinition(getEnchantmentID(Enchantments.FIRE_ASPECT), 1)))
                );
    	
        bootstrap.register(TERRA_BLADE,
                new SlashBladeDefinition(SlashBladeAddon.prefix("terra_blade"),
                    RenderDefinition.Builder.newInstance()
                    .textureName(SlashBladeAddon.prefix("model/terra/terra.png"))
                    .modelName(SlashBladeAddon.prefix("model/terra/terra.obj"))
                    .standbyRenderType(CarryType.RNINJA)
                    .effectColor(3524113)
                    .build(),
                     PropertiesDefinition.Builder.newInstance()
                     .baseAttackModifier(6.0F) 
                     .maxDamage(60)
                     .slashArtsType(SBABotaniaCompat.BLISTERING_TERRA_SWORDS_SA.getId())
                     .addSpecialEffect(SBABotaniaCompat.MANA_BURST.getId())
                     .addSpecialEffect(SBABotaniaCompat.MANA_REPAIR.getId())
                     .defaultSwordType(List.of(SwordType.BEWITCHED)).build(), 
                     List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.POWER_ARROWS), 1))));
    	
    	//Kirisaya
        bootstrap.register(KIRISAYA,
                new SlashBladeDefinition(SlashBladeAddon.prefix("kirisaya"),
                    RenderDefinition.Builder.newInstance()
                    .textureName(SlashBladeAddon.prefix("model/kirisaya/kirisaya.png"))
                    .modelName(SlashBladeAddon.prefix("model/kirisaya/kirisaya.obj"))
                    .standbyRenderType(CarryType.KATANA)
                    .build(),
                     PropertiesDefinition.Builder.newInstance()
                     .baseAttackModifier(3.0F)
                     .maxDamage(11)
                     .slashArtsType(SlashArtsRegistry.DRIVE_HORIZONTAL.getId())
                     .addSpecialEffect(SBASpecialEffectsRegistry.BURST_DRIVE.getId())
                     .defaultSwordType(List.of(SwordType.BEWITCHED)).build(), 
                     List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 3),
                             new EnchantmentDefinition(getEnchantmentID(Enchantments.POWER_ARROWS), 5)
                             )));
    	
    	//Laemmle
        bootstrap.register(LAEMMLE,
                new SlashBladeDefinition(SlashBladeAddon.prefix("laemmle"),
                    RenderDefinition.Builder.newInstance()
                    .textureName(SlashBladeAddon.prefix("model/laemmle/lem.png"))
                    .modelName(SlashBladeAddon.prefix("model/laemmle/blade.obj"))
                    .standbyRenderType(CarryType.PSO2)
                    .build(),
                     PropertiesDefinition.Builder.newInstance()
                     .baseAttackModifier(7.0F)
                     .maxDamage(80).build(), 
                     List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 3))));
    	
    	//Yukari
        bootstrap.register(YUKARI,
                new SlashBladeDefinition(SlashBladeAddon.prefix("yukari"),
                    RenderDefinition.Builder.newInstance()
                    .textureName(SlashBladeAddon.prefix("model/yukari/texture.png"))
                    .modelName(SlashBladeAddon.prefix("model/yukari/model.obj"))
                    .standbyRenderType(CarryType.PSO2)
                    .build(),
                     PropertiesDefinition.Builder.newInstance()
                     .baseAttackModifier(8.0F)
                     .maxDamage(50)
                     .slashArtsType(SlashArtsRegistry.DRIVE_HORIZONTAL.getId())
                     .defaultSwordType(List.of(SwordType.NONE)).build(), List.of()));
        
    	//Tboen
        bootstrap.register(TBOEN,
             new SlashBladeDefinition(SlashBladeAddon.prefix("tboen"),
                     RenderDefinition.Builder.newInstance()
                     .textureName(SlashBladeAddon.prefix("model/tboen/texture.png"))
                     .modelName(SlashBladeAddon.prefix("model/tboen/model.obj"))
                     .standbyRenderType(CarryType.KATANA)
                     .build(),
                     PropertiesDefinition.Builder.newInstance()
                     .baseAttackModifier(6.0F)
                     .slashArtsType(SlashArtsRegistry.SAKURA_END.getId())
                     .maxDamage(70)
                     .defaultSwordType(List.of(SwordType.NONE)).build(), List.of()));
    	
    	//Toyako
        bootstrap.register(TOYAKO,
                new SlashBladeDefinition(SlashBladeAddon.prefix("toyako"),
                     RenderDefinition.Builder.newInstance()
                     .textureName(SlashBladeAddon.prefix("model/toyako/toyako.png"))
                     .modelName(SlashBladeAddon.prefix("model/toyako/toyako.obj"))
                     .standbyRenderType(CarryType.KATANA)
                     .build(),
                     PropertiesDefinition.Builder.newInstance()
                     .baseAttackModifier(6.0F)
                     .maxDamage(70)
                     .defaultSwordType(List.of(SwordType.NONE)).build(), List.of()));
    	
        //nihil
        bootstrap.register(NIHIL,
           new SlashBladeDefinition(SlashBladeAddon.prefix("nihil"),
                RenderDefinition.Builder.newInstance()
                .textureName(SlashBladeAddon.prefix("model/nihil/nihil.png"))
                .modelName(SlashBladeAddon.prefix("model/nihil/nihil.obj"))
                .standbyRenderType(CarryType.KATANA)
                .build(),
                PropertiesDefinition.Builder.newInstance()
                .baseAttackModifier(8.0F)
                .maxDamage(45)
                .slashArtsType(SlashArtsRegistry.DRIVE_HORIZONTAL.getId())
                .defaultSwordType(List.of(SwordType.BEWITCHED)).build(),
                List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 3),
                    new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 2),
                    new EnchantmentDefinition(getEnchantmentID(Enchantments.SMITE), 1),
                    new EnchantmentDefinition(getEnchantmentID(Enchantments.FIRE_ASPECT), 1))));

        bootstrap.register(NIHILEX,
           new SlashBladeDefinition(SlashBladeAddon.prefix("nihilex"),
                RenderDefinition.Builder.newInstance()
                .textureName(SlashBladeAddon.prefix("model/nihil/nihilex.png"))
                .modelName(SlashBladeAddon.prefix("model/nihil/nihil.obj"))
                .standbyRenderType(CarryType.KATANA)
                .build(),
                PropertiesDefinition.Builder.newInstance()
                .baseAttackModifier(10.0F)
                .maxDamage(60)
                .slashArtsType(SlashArtsRegistry.WAVE_EDGE.getId())
                .defaultSwordType(List.of(SwordType.BEWITCHED)).build(),
                List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 2),
                        new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 3),
                        new EnchantmentDefinition(getEnchantmentID(Enchantments.SMITE), 2),
                        new EnchantmentDefinition(getEnchantmentID(Enchantments.BANE_OF_ARTHROPODS), 1),
                        new EnchantmentDefinition(getEnchantmentID(Enchantments.FIRE_ASPECT), 2),
                        new EnchantmentDefinition(getEnchantmentID(Enchantments.MOB_LOOTING), 1))));

        bootstrap.register(NIHILUL,
           new SlashBladeDefinition(SlashBladeAddon.prefix("nihilul"),
                RenderDefinition.Builder.newInstance()
                .textureName(SlashBladeAddon.prefix("model/nihil/nihilul.png"))
                .modelName(SlashBladeAddon.prefix("model/nihil/nihil.obj"))
                .standbyRenderType(CarryType.KATANA)
                .build(),
                PropertiesDefinition.Builder.newInstance()
                .baseAttackModifier(12.0F)
                .maxDamage(70)
                .slashArtsType(SlashArtsRegistry.WAVE_EDGE.getId())
                .defaultSwordType(List.of(SwordType.BEWITCHED)).build(),
                List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 3),
                        new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 5),
                        new EnchantmentDefinition(getEnchantmentID(Enchantments.SMITE), 3),
                        new EnchantmentDefinition(getEnchantmentID(Enchantments.BANE_OF_ARTHROPODS), 2),
                        new EnchantmentDefinition(getEnchantmentID(Enchantments.FIRE_ASPECT), 2),
                        new EnchantmentDefinition(getEnchantmentID(Enchantments.MOB_LOOTING), 3))));

        bootstrap.register(CRIMSONCHERRY,
           new SlashBladeDefinition(SlashBladeAddon.prefix("crimsoncherry"),
                RenderDefinition.Builder.newInstance()
                .textureName(SlashBladeAddon.prefix("model/nihil/crimsoncherry.png"))
                .modelName(SlashBladeAddon.prefix("model/nihil/nihil.obj"))
                .standbyRenderType(CarryType.KATANA)
                .build(),
                PropertiesDefinition.Builder.newInstance()
                .baseAttackModifier(11.0F)
                .maxDamage(65)
                .slashArtsType(SlashArtsRegistry.SAKURA_END.getId())
                .defaultSwordType(List.of(SwordType.BEWITCHED)).build(),
                List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 5),
                        new EnchantmentDefinition(getEnchantmentID(Enchantments.SMITE), 3),
                        new EnchantmentDefinition(getEnchantmentID(Enchantments.BANE_OF_ARTHROPODS), 3),
                        new EnchantmentDefinition(getEnchantmentID(Enchantments.FIRE_ASPECT), 2))));

        bootstrap.register(NIHILBX,
           new SlashBladeDefinition(SlashBladeAddon.prefix("nihilbx"),
                RenderDefinition.Builder.newInstance()
                .textureName(SlashBladeAddon.prefix("model/nihil/nihil_bx.png"))
                .modelName(SlashBladeAddon.prefix("model/nihil/nihil.obj"))
                .standbyRenderType(CarryType.KATANA)
                .build(),
                PropertiesDefinition.Builder.newInstance()
                .baseAttackModifier(13.0F)
                .maxDamage(240)
                .slashArtsType(SlashArtsRegistry.SAKURA_END.getId())
                .defaultSwordType(List.of(SwordType.BEWITCHED)).build(),
                List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 3),
                        new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 5),
                        new EnchantmentDefinition(getEnchantmentID(Enchantments.SMITE), 5),
                        new EnchantmentDefinition(getEnchantmentID(Enchantments.BANE_OF_ARTHROPODS), 5),
                        new EnchantmentDefinition(getEnchantmentID(Enchantments.FIRE_ASPECT), 2))));

        //WA
        bootstrap.register(KATANA,
           new SlashBladeDefinition(SlashBladeAddon.prefix("katana"),
                RenderDefinition.Builder.newInstance()
                .textureName(SlashBladeAddon.prefix("model/wa/katana.png"))
                .modelName(SlashBladeAddon.prefix("model/wa/wa.obj"))
                .standbyRenderType(CarryType.KATANA)
                .build(),
                PropertiesDefinition.Builder.newInstance()
                .baseAttackModifier(3.0F)
                .maxDamage(457)
                .defaultSwordType(List.of(SwordType.NONE)).build(), List.of()));

        bootstrap.register(TACHI,
           new SlashBladeDefinition(SlashBladeAddon.prefix("tachi"),
                RenderDefinition.Builder.newInstance()
                .textureName(SlashBladeAddon.prefix("model/wa/tachi.png"))
                .modelName(SlashBladeAddon.prefix("model/wa/wa.obj"))
                .standbyRenderType(CarryType.DEFAULT)
                .build(),
                PropertiesDefinition.Builder.newInstance()
                .baseAttackModifier(3.0F)
                .maxDamage(457)
                .defaultSwordType(List.of(SwordType.NONE)).build(), List.of()));

        bootstrap.register(BLUE,
           new SlashBladeDefinition(SlashBladeAddon.prefix("blue"),
                RenderDefinition.Builder.newInstance()
                .textureName(SlashBladeAddon.prefix("model/wa/blue.png"))
                .modelName(SlashBladeAddon.prefix("model/wa/wa.obj"))
                .standbyRenderType(CarryType.KATANA)
                .build(),
                PropertiesDefinition.Builder.newInstance()
                .baseAttackModifier(7.0F)
                .maxDamage(75)
                .defaultSwordType(List.of(SwordType.NONE)).build(), List.of()));

        //BladeMaster
        bootstrap.register(GREEN_MIST,
           new SlashBladeDefinition(SlashBladeAddon.prefix("green_mist"),
                RenderDefinition.Builder.newInstance()
                .textureName(SlashBladeAddon.prefix("model/blademaster/green_mist.png"))
                .modelName(SlashBladeAddon.prefix("model/blademaster/blademaster.obj"))
                .standbyRenderType(CarryType.PSO2)
                .build(),
                PropertiesDefinition.Builder.newInstance()
                .baseAttackModifier(4.0F + Tiers.DIAMOND.getAttackDamageBonus())
                .maxDamage(60)
                .slashArtsType(SBASlashArtsRegistry.RAPID_BLISTERING_SWORDS.getId())
                .defaultSwordType(List.of(SwordType.BEWITCHED)).build(),
                List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.POWER_ARROWS), 3),
                        new EnchantmentDefinition(getEnchantmentID(Enchantments.BLOCK_FORTUNE), 3))));

        bootstrap.register
        (
            AQUABLAZE,
            new SlashBladeDefinition
            (
                SlashBladeAddon.prefix("aquablaze"),
                RenderDefinition.Builder.newInstance()
                .textureName(SlashBladeAddon.prefix("model/blademaster/aquablaze.png"))
                .modelName(SlashBladeAddon.prefix("model/blademaster/blademaster.obj"))
                .standbyRenderType(CarryType.PSO2)
                .build(),
                PropertiesDefinition.Builder.newInstance()
                .baseAttackModifier(4.0F + Tiers.DIAMOND.getAttackDamageBonus())
                .maxDamage(60)
                .slashArtsType(SBASlashArtsRegistry.SPIRAL_EDGE.getId())
                .defaultSwordType(List.of(SwordType.BEWITCHED)).build(),
                List.of
                (
                    new EnchantmentDefinition(getEnchantmentID(Enchantments.FIRE_ASPECT), 2),
                    new EnchantmentDefinition(getEnchantmentID(Enchantments.FIRE_PROTECTION), 1)
                )
            )
        );

        bootstrap.register
        (
            MOONLIGHT_CHERRY,
            new SlashBladeDefinition
            (
                SlashBladeAddon.prefix("moonlight_cherry"),
                RenderDefinition.Builder.newInstance()
                .textureName(SlashBladeAddon.prefix("model/blademaster/moonlightcherry.png"))
                .modelName(SlashBladeAddon.prefix("model/blademaster/blademaster.obj"))
                .standbyRenderType(CarryType.PSO2)
                .build(),
                PropertiesDefinition.Builder.newInstance()
                .baseAttackModifier(4.0F + Tiers.DIAMOND.getAttackDamageBonus())
                .maxDamage(60)
                .slashArtsType(SBASlashArtsRegistry.GALE_SWORDS.getId())
                .defaultSwordType(List.of(SwordType.BEWITCHED)).build(),
                List.of
                (
                    new EnchantmentDefinition(getEnchantmentID(Enchantments.THORNS), 1),
                    new EnchantmentDefinition(getEnchantmentID(Enchantments.SMITE), 5)
                )
            )
        );

        //Dark Raven
        bootstrap.register
        (
            DARK_RAVEN,
            new SlashBladeDefinition
            (
                SlashBladeAddon.prefix("dark_raven"),
                RenderDefinition.Builder.newInstance()
                .textureName(SlashBladeAddon.prefix("model/darkraven/dark_raven.png"))
                .modelName(SlashBladeAddon.prefix("model/darkraven/dark_raven.obj"))
                .standbyRenderType(CarryType.PSO2)
                .build(),
                PropertiesDefinition.Builder.newInstance()
                .baseAttackModifier(4.0F + Tiers.DIAMOND.getAttackDamageBonus())
                .maxDamage(80)
                .slashArtsType(SlashArtsRegistry.WAVE_EDGE.getId())
                .defaultSwordType(List.of(SwordType.NONE)).build(),
                List.of()
            )
        );

        bootstrap.register
        (
            SNOW_CROW,
            new SlashBladeDefinition
            (
                SlashBladeAddon.prefix("snow_crow"),
                RenderDefinition.Builder.newInstance()
                .textureName(SlashBladeAddon.prefix("model/darkraven/snow_crow.png"))
                .modelName(SlashBladeAddon.prefix("model/darkraven/snow_crow.obj"))
                .standbyRenderType(CarryType.PSO2)
                .build(),
                PropertiesDefinition.Builder.newInstance()
                .baseAttackModifier(4.0F + Tiers.IRON.getAttackDamageBonus())
                .maxDamage(60)
                .defaultSwordType(List.of(SwordType.NONE)).build(),
                List.of()
            )
        );

        //Fluorescent Bar
        bootstrap.register
        (
            FLUORESCENT_BAR,
            new SlashBladeDefinition
            (
                SlashBladeAddon.prefix("fluorescent_bar"),
                RenderDefinition.Builder.newInstance()
                .textureName(SlashBladeAddon.prefix("model/fluorescentbar/fluorescent_bar.png"))
                .modelName(SlashBladeAddon.prefix("model/fluorescentbar/fluorescent_bar.obj"))
                .standbyRenderType(CarryType.PSO2)
                .build(),
                PropertiesDefinition.Builder.newInstance()
                .baseAttackModifier(2.0F)
                .maxDamage(Tiers.DIAMOND.getUses())
                .defaultSwordType(List.of(SwordType.NONE)).build(),
                List.of
                (
                    new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 3)
                )
            )
        );

        //Frost Wolf
        bootstrap.register
        (
            FROSTY_CHERRY,
            new SlashBladeDefinition
            (
                SlashBladeAddon.prefix("frosty_cherry"),
                RenderDefinition.Builder.newInstance()
                .textureName(SlashBladeAddon.prefix("model/frostwolf/frosty_cherry.png"))
                .modelName(SlashBladeAddon.prefix("model/frostwolf/frosty_cherry.obj"))
                .standbyRenderType(CarryType.PSO2)
                .build(),
                PropertiesDefinition.Builder.newInstance()
                .baseAttackModifier(4.0F + Tiers.DIAMOND.getAttackDamageBonus())
                .maxDamage(150)
                .slashArtsType(SBASlashArtsRegistry.RAPID_BLISTERING_SWORDS.getId())
                .defaultSwordType(List.of(SwordType.BEWITCHED)).build(),
                List.of()
            )
        );

        bootstrap.register
        (
            FROST_WOLF,
            new SlashBladeDefinition
            (
                SlashBladeAddon.prefix("frost_wolf"),
                RenderDefinition.Builder.newInstance()
                .textureName(SlashBladeAddon.prefix("model/frostwolf/frost_wolf.png"))
                .modelName(SlashBladeAddon.prefix("model/frostwolf/frost_wolf.obj"))
                .standbyRenderType(CarryType.PSO2)
                .build(),
                PropertiesDefinition.Builder.newInstance()
                .baseAttackModifier(4.0F + Tiers.DIAMOND.getAttackDamageBonus())
                .maxDamage(150)
                .slashArtsType(SBASlashArtsRegistry.GALE_SWORDS.getId())
                .defaultSwordType(List.of(SwordType.BEWITCHED)).build(),
                List.of()
            )
        );
    }

    private static ResourceKey<SlashBladeDefinition> register(String id) {
        return ResourceKey.create(SlashBladeDefinition.REGISTRY_KEY, SlashBladeAddon.prefix(id));
    }

    private static ResourceLocation getEnchantmentID(Enchantment enchantment) {
        return ForgeRegistries.ENCHANTMENTS.getKey(enchantment);
    }
}
