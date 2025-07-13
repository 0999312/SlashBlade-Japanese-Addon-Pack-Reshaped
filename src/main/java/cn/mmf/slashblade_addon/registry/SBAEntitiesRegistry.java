package cn.mmf.slashblade_addon.registry;

import cn.mmf.slashblade_addon.SlashBladeAddon;
import cn.mmf.slashblade_addon.entity.BlisteringSwordsEntity;
import cn.mmf.slashblade_addon.entity.EntityWaterDrive;
import cn.mmf.slashblade_addon.entity.GaleSwordsEntity;
import cn.mmf.slashblade_addon.entity.SpiralEdgeSwordsEntity;
import com.google.common.base.CaseFormat;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;

public class SBAEntitiesRegistry {
	public static final ResourceLocation BlisteringSwordsLoc = new ResourceLocation(SlashBladeAddon.MODID,
			classToString(BlisteringSwordsEntity.class));
	public static final ResourceLocation SpiralEdgeSwordsLoc = new ResourceLocation(SlashBladeAddon.MODID,
			classToString(SpiralEdgeSwordsEntity.class));
	public static final ResourceLocation GaleSwordsLoc = new ResourceLocation(SlashBladeAddon.MODID,
			classToString(GaleSwordsEntity.class));

	public static EntityType<BlisteringSwordsEntity> BlisteringSwords;
	public static EntityType<SpiralEdgeSwordsEntity> SpiralEdgeSwords;
	public static EntityType<SpiralEdgeSwordsEntity> GaleSwords;
	public static EntityType<BlisteringSwordsEntity> LightingSwords;
	public static EntityType<EntityWaterDrive> WaterDrive;

	public static void register(RegisterEvent event) {
		
		event.register(ForgeRegistries.Keys.ENTITY_TYPES, helper -> {
			{
				EntityType<EntityWaterDrive> entity = WaterDrive = EntityType.Builder
						.of(EntityWaterDrive::new, MobCategory.MISC).sized(0.9F, 0.9F).setTrackingRange(4)
						.setUpdateInterval(20).setCustomClientFactory(EntityWaterDrive::createInstance)
						.build("water_drive");
				helper.register(new ResourceLocation(SlashBladeAddon.MODID,"water_drive"), entity);
			}
		});
		
		
		event.register(ForgeRegistries.Keys.ENTITY_TYPES, helper -> {
			{
				EntityType<BlisteringSwordsEntity> entity = LightingSwords = EntityType.Builder
						.of(BlisteringSwordsEntity::new, MobCategory.MISC).sized(0.9F, 0.9F).setTrackingRange(4)
						.setUpdateInterval(20).setCustomClientFactory(BlisteringSwordsEntity::createInstance)
						.build("lighting_swords");
				helper.register(new ResourceLocation(SlashBladeAddon.MODID,"lighting_swords"), entity);
			}
		});
		
		event.register(ForgeRegistries.Keys.ENTITY_TYPES, helper -> {
			{
				EntityType<BlisteringSwordsEntity> entity = BlisteringSwords = EntityType.Builder
						.of(BlisteringSwordsEntity::new, MobCategory.MISC).sized(0.9F, 0.9F).setTrackingRange(4)
						.setUpdateInterval(20).setCustomClientFactory(BlisteringSwordsEntity::createInstance)
						.build(BlisteringSwordsLoc.toString());
				helper.register(BlisteringSwordsLoc, entity);
			}
		});

		event.register(ForgeRegistries.Keys.ENTITY_TYPES, helper -> {
			{
				EntityType<SpiralEdgeSwordsEntity> entity = SpiralEdgeSwords = EntityType.Builder
						.of(SpiralEdgeSwordsEntity::new, MobCategory.MISC).sized(0.9F, 0.9F).setTrackingRange(4)
						.setUpdateInterval(20).setCustomClientFactory(SpiralEdgeSwordsEntity::createInstance)
						.build(SpiralEdgeSwordsLoc.toString());
				helper.register(SpiralEdgeSwordsLoc, entity);
			}
		});

		event.register(ForgeRegistries.Keys.ENTITY_TYPES, helper -> {
			{
				EntityType<SpiralEdgeSwordsEntity> entity = GaleSwords = EntityType.Builder
						.of(SpiralEdgeSwordsEntity::new, MobCategory.MISC).sized(0.9F, 0.9F).setTrackingRange(4)
						.setUpdateInterval(20).setCustomClientFactory(SpiralEdgeSwordsEntity::createInstance)
						.build(GaleSwordsLoc.toString());
				helper.register(GaleSwordsLoc, entity);
			}
		});
	}

	private static String classToString(Class<? extends Entity> entityClass) {
		return CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, entityClass.getSimpleName()).replace("entity_",
				"");
	}
}
