package cn.mmf.slashblade_addon.registry;

import cn.mmf.slashblade_addon.SlashBladeAddon;
import cn.mmf.slashblade_addon.specialattacks.GaleSwords;
import cn.mmf.slashblade_addon.specialattacks.RapidBlisteringSwords;
import cn.mmf.slashblade_addon.specialattacks.SpiralEdge;
import mods.flammpfeil.slashblade.SlashBlade;
import mods.flammpfeil.slashblade.ability.StunManager;
import mods.flammpfeil.slashblade.init.DefaultResources;
import mods.flammpfeil.slashblade.registry.combo.ComboState;
import mods.flammpfeil.slashblade.util.AttackManager;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryBuilder;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class SBAComboStateRegistry
{
    public static final DeferredRegister<ComboState> COMBO_STATES = DeferredRegister.create(ComboState.REGISTRY_KEY, SlashBladeAddon.MODID);

    public static final Supplier<IForgeRegistry<ComboState>> REGISTRY = COMBO_STATES.makeRegistry(RegistryBuilder::new);

    public static final RegistryObject<ComboState> RAPID_BLISTERING_SWORDS = COMBO_STATES.register("rapid_blistering_swords",
       ComboState.Builder.newInstance().startAndEnd(400, 459).priority(50)
       .motionLoc(DefaultResources.ExMotionLocation)
       .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
       .nextOfTimeout(entity -> SlashBladeAddon.prefix("rapid_blistering_swords_end"))
       .addTickAction(ComboState.TimeLineTickAction.getBuilder()
          .put(2, (entityIn) -> AttackManager.doSlash(entityIn, -30F, Vec3.ZERO, false, false, 0.1F))
          .put(3, (entityIn) -> RapidBlisteringSwords.doSlash(entityIn, false, 7, 2f)).build())
       .addHitEffect(StunManager::setStun)
       ::build);

    public static final RegistryObject<ComboState> RAPID_BLISTERING_SWORDS_END = COMBO_STATES.register("rapid_blistering_swords_end",
       ComboState.Builder.newInstance().startAndEnd(459, 488).priority(50)
       .motionLoc(DefaultResources.ExMotionLocation).next(entity -> SlashBlade.prefix("none"))
       .nextOfTimeout(entity -> SlashBlade.prefix("none"))
       .addTickAction(ComboState.TimeLineTickAction.getBuilder()
          .put(0, AttackManager::playQuickSheathSoundAction).build())
       .releaseAction(ComboState::releaseActionQuickCharge)::build);

    public static final RegistryObject<ComboState> SPIRAL_EDGE = COMBO_STATES.register
    (
        "spiral_edge",
        ComboState.Builder.newInstance().startAndEnd(400, 459).priority(50)
        .motionLoc(DefaultResources.ExMotionLocation)
        .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
        .nextOfTimeout(entity -> SlashBladeAddon.prefix("spiral_edge_end"))
        .addTickAction
        (
            ComboState.TimeLineTickAction.getBuilder()
            .put(2, (entityIn) -> AttackManager.doSlash(entityIn, -90F, Vec3.ZERO, false, false, 2F))
            .put(3, (entityIn) -> SpiralEdge.doSlash(entityIn, false, 7, 2f)).build()
        )
        .addHitEffect(StunManager::setStun)
        ::build
    );

    public static final RegistryObject<ComboState> SPIRAL_EDGE_END = COMBO_STATES.register
    (
        "spiral_edge_end",
        ComboState.Builder.newInstance().startAndEnd(459, 488).priority(50)
        .motionLoc(DefaultResources.ExMotionLocation).next(entity -> SlashBlade.prefix("none"))
        .nextOfTimeout(entity -> SlashBlade.prefix("none"))
        .addTickAction(ComboState.TimeLineTickAction.getBuilder().put(0, AttackManager::playQuickSheathSoundAction).build())
        .releaseAction(ComboState::releaseActionQuickCharge)::build
    );

    public static final RegistryObject<ComboState> GALE_SWORDS = COMBO_STATES.register
    (
        "gale_swords",
        ComboState.Builder.newInstance().startAndEnd(400, 459).priority(50)
        .motionLoc(DefaultResources.ExMotionLocation)
        .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
        .nextOfTimeout(entity -> SlashBladeAddon.prefix("gale_swords_end"))
        .addTickAction
        (
            ComboState.TimeLineTickAction.getBuilder()
            .put(2, (entityIn) -> AttackManager.doSlash(entityIn, -90F, Vec3.ZERO, false, false, 2F))
            .put(3, (entityIn) -> GaleSwords.doSlash(entityIn, false, 7, 2f)).build()
        )
        .addHitEffect(StunManager::setStun)
        ::build
    );

    public static final RegistryObject<ComboState> GALE_SWORDS_END = COMBO_STATES.register
    (
        "gale_swords_end",
        ComboState.Builder.newInstance().startAndEnd(459, 488).priority(50)
        .motionLoc(DefaultResources.ExMotionLocation).next(entity -> SlashBlade.prefix("none"))
        .nextOfTimeout(entity -> SlashBlade.prefix("none"))
        .addTickAction(ComboState.TimeLineTickAction.getBuilder().put(0, AttackManager::playQuickSheathSoundAction).build())
        .releaseAction(ComboState::releaseActionQuickCharge)::build
    );
}
