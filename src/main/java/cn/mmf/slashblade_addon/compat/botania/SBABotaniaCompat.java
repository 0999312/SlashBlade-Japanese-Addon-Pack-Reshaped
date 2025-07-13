package cn.mmf.slashblade_addon.compat.botania;

import cn.mmf.slashblade_addon.SlashBladeAddon;
import mods.flammpfeil.slashblade.SlashBlade;
import mods.flammpfeil.slashblade.ability.StunManager;
import mods.flammpfeil.slashblade.init.DefaultResources;
import mods.flammpfeil.slashblade.registry.combo.ComboState;
import mods.flammpfeil.slashblade.registry.specialeffects.SpecialEffect;
import mods.flammpfeil.slashblade.slasharts.SlashArts;
import mods.flammpfeil.slashblade.util.AttackManager;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class SBABotaniaCompat {
	public static final DeferredRegister<ComboState> COMBO_STATES = DeferredRegister.create(ComboState.REGISTRY_KEY,
			SlashBladeAddon.MODID);
	public static final DeferredRegister<SlashArts> SLASH_ARTS = DeferredRegister.create(SlashArts.REGISTRY_KEY,
			SlashBladeAddon.MODID);
	public static final DeferredRegister<SpecialEffect> SPECIAL_EFFECT = DeferredRegister.create(SpecialEffect.REGISTRY_KEY,
            SlashBladeAddon.MODID);
	
    public static final RegistryObject<SpecialEffect> MANA_BURST = SPECIAL_EFFECT.register("mana_burst", 
    		ManaBurst::new);
    
    public static final RegistryObject<SpecialEffect> MANA_REPAIR = SPECIAL_EFFECT.register("mana_repair", 
    		ManaRapair::new);

    
	public static final RegistryObject<ComboState> BLISTERING_TERRA_SWORDS = COMBO_STATES.register(
			"blistering_terra_swords",
			ComboState.Builder.newInstance().startAndEnd(400, 459).priority(50)
					.motionLoc(DefaultResources.ExMotionLocation)
					.next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
					.nextOfTimeout(entity -> SlashBladeAddon.prefix("blistering_terra_swords_swords_end"))
					.addTickAction(ComboState.TimeLineTickAction.getBuilder()
							.put(2, (entityIn) -> AttackManager.doSlash(entityIn, -30F, Vec3.ZERO, false, false, 2F))
							.put(3, (entityIn) -> BlisteringTerraSwords.doSlash(entityIn, false, 7, 2f)).build())
					.addHitEffect(StunManager::setStun)::build);

	public static final RegistryObject<ComboState> BLISTERING_TERRA_SWORDS_END = COMBO_STATES.register(
			"blistering_terra_swords_swords_end",
			ComboState.Builder.newInstance().startAndEnd(459, 488).priority(50)
					.motionLoc(DefaultResources.ExMotionLocation).next(entity -> SlashBlade.prefix("none"))
					.nextOfTimeout(entity -> SlashBlade.prefix("none"))
					.addTickAction(ComboState.TimeLineTickAction.getBuilder()
							.put(0, AttackManager::playQuickSheathSoundAction).build())
					.releaseAction(ComboState::releaseActionQuickCharge)::build);
	
	
	public static final RegistryObject<SlashArts> BLISTERING_TERRA_SWORDS_SA = SLASH_ARTS.register("blistering_terra_swords",
			() -> new SlashArts((e) -> BLISTERING_TERRA_SWORDS.getId()));
}
