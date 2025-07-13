package cn.mmf.slashblade_addon.entity;

import cn.mmf.slashblade_addon.registry.SBAEntitiesRegistry;
import mods.flammpfeil.slashblade.entity.EntityDrive;
import mods.flammpfeil.slashblade.entity.Projectile;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.network.PlayMessages;

public class EntityWaterDrive extends EntityDrive {

	public EntityWaterDrive(EntityType<? extends Projectile> entityTypeIn, Level worldIn) {
		super(entityTypeIn, worldIn);
	}
	
	public static EntityWaterDrive createInstance(PlayMessages.SpawnEntity packet, Level worldIn) {
		return new EntityWaterDrive(SBAEntitiesRegistry.WaterDrive, worldIn);
	}

	@Override
	protected void onHitEntity(EntityHitResult result) {
		super.onHitEntity(result);
        Entity entity = result.getEntity();
		if (entity.isOnFire() && entity.isAlive()) 
        	entity.extinguishFire();
	}
	
}
