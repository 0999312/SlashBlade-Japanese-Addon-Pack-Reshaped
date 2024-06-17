package cn.mmf.slashblade_addon.entity;

import mods.flammpfeil.slashblade.SlashBlade;
import mods.flammpfeil.slashblade.ability.StunManager;
import mods.flammpfeil.slashblade.entity.EntityAbstractSummonedSword;
import mods.flammpfeil.slashblade.entity.IShootable;
import mods.flammpfeil.slashblade.entity.Projectile;
import mods.flammpfeil.slashblade.item.ItemSlashBlade;
import mods.flammpfeil.slashblade.util.KnockBacks;
import mods.flammpfeil.slashblade.util.RayTraceHelper;
import mods.flammpfeil.slashblade.util.TargetSelector;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.PlayMessages;

import java.util.Optional;
import java.util.stream.Stream;

public class BlisteringSwordsEntity extends EntityAbstractSummonedSword
{
    private static final EntityDataAccessor<Boolean> IT_FIRED = SynchedEntityData.defineId(BlisteringSwordsEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Float> SPEED = SynchedEntityData.defineId(BlisteringSwordsEntity.class, EntityDataSerializers.FLOAT);
    long fireTime = -1;

    public BlisteringSwordsEntity(EntityType<? extends Projectile> entityTypeIn, Level worldIn)
    {
        super(entityTypeIn, worldIn);

        this.setPierce((byte) 5);
    }

    public static BlisteringSwordsEntity createInstance(PlayMessages.SpawnEntity packet, Level worldIn)
    {
        return new BlisteringSwordsEntity(SlashBlade.RegistryEvents.BlisteringSwords, worldIn);
    }

    @Override
    protected void defineSynchedData()
    {
        super.defineSynchedData();

        this.entityData.define(IT_FIRED, false);
        this.entityData.define(SPEED, 3.0f);
    }

    public void doFire()
    {
        this.getEntityData().set(IT_FIRED, true);
    }

    public boolean itFired()
    {
        return this.getEntityData().get(IT_FIRED);
    }

    public void setSpeed(float speed)
    {
        this.getEntityData().set(SPEED, speed);
    }

    public float getSpeed() {return this.getEntityData().get(SPEED);}

    @Override
    public void tick()
    {
        if (!itFired() && level().isClientSide() && getVehicle() == null)
        {
            startRiding(this.getOwner(), true);
        }

        super.tick();
    }

    @Override
    public void rideTick()
    {
        if (itFired() && fireTime <= tickCount)
        {
            faceEntityStandby();
            Entity vehicle = getVehicle();
            Vec3 dir = this.getViewVector(0);
            if (!(vehicle instanceof LivingEntity))
            {
                this.shoot(dir.x, dir.y, dir.z, getSpeed(), 1.0f);
                return;
            }

            LivingEntity sender = (LivingEntity) getVehicle();
            this.stopRiding();

            this.tickCount = 0;

            Level worldIn = sender.level();
            Entity lockTarget = null;
            if (sender instanceof LivingEntity)
            {
                lockTarget = sender.getMainHandItem().getCapability(ItemSlashBlade.BLADESTATE)
                .filter(state -> state.getTargetEntity(worldIn) != null)
                .map(state -> state.getTargetEntity(worldIn)).orElse(null);
            }

            Optional<Entity> foundTarget = Stream
            .of(Optional.ofNullable(lockTarget),
                RayTraceHelper
                .rayTrace(sender.level(), sender, sender.getEyePosition(1.0f), sender.getLookAngle(), 12, 12, (e) -> true)
                .filter(r -> r.getType() == HitResult.Type.ENTITY).filter(r ->
                  {
                      EntityHitResult er = (EntityHitResult) r;
                      Entity target = er.getEntity();

                      boolean isMatch = true;
                      if (target instanceof LivingEntity)
                          isMatch = TargetSelector.lockon_focus.test(sender, (LivingEntity) target);

                      if (target instanceof IShootable)
                          isMatch = ((IShootable) target).getShooter() != sender;

                      return isMatch;
                  }).map(r -> ((EntityHitResult) r).getEntity()))
            .filter(Optional::isPresent).map(Optional::get).findFirst();

            Vec3 targetPos = foundTarget.map((e) -> new Vec3(e.getX(), e.getY() + e.getEyeHeight() * 0.5, e.getZ()))
            .orElseGet(() ->
                       {
                           Vec3 start = sender.getEyePosition(1.0f);
                           Vec3 end = start.add(sender.getLookAngle().scale(40));
                           HitResult result = worldIn.clip(new ClipContext(start, end, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, sender));
                           return result.getLocation();
                       });

            Vec3 pos = this.getPosition(0.0f);
            dir = targetPos.subtract(pos).normalize();

            this.shoot(dir.x, dir.y, dir.z, getSpeed(), 1.0f);
            if (sender instanceof ServerPlayer)
            {
                ((ServerPlayer) sender).playNotifySound(SoundEvents.ENDER_DRAGON_FLAP, SoundSource.PLAYERS, 1.0F, 1.0F);
            }

            return;
        }

        this.setDeltaMovement(Vec3.ZERO);
        if (canUpdate()) this.baseTick();

        faceEntityStandby();

        // lifetime check
        if (!itFired() && getVehicle() instanceof LivingEntity)
        {
            if (tickCount - getDelay() >= 40)
            {
                fireTime = tickCount + getDelay();
                doFire();
            }
        }
    }

    private void hitCheck()
    {
        Vec3 positionVec = this.position();
        Vec3 dirVec = this.getViewVector(1.0f);
        EntityHitResult raytraceresult = null;

        EntityHitResult entityraytraceresult = this.getRayTrace(positionVec, dirVec);
        if (entityraytraceresult != null)
        {
            raytraceresult = entityraytraceresult;
        }

        if (raytraceresult != null && raytraceresult.getType() == HitResult.Type.ENTITY)
        {
            Entity entity = raytraceresult.getEntity();
            Entity entity1 = this.getShooter();
            if (entity instanceof Player && entity1 instanceof Player
            && !((Player) entity1).canHarmPlayer((Player) entity))
            {
                raytraceresult = null;
                entityraytraceresult = null;
            }
        }

        if (raytraceresult != null && raytraceresult.getType() == HitResult.Type.ENTITY
        && !net.minecraftforge.event.ForgeEventFactory.onProjectileImpact(this, raytraceresult))
        {
            this.onHit(raytraceresult);
            this.resetAlreadyHits();
            this.hasImpulse = true;
        }
    }

    private void faceEntityStandby()
    {
        boolean isRight = getDelay() % 2 == 0;
        Vec3 pos = new Vec3(0, 0, 0);

        if (this.getVehicle() == null)
        {
            doFire();
            return;
        }

        pos = pos.add(this.getVehicle().position()).add(0, this.getVehicle().getEyeHeight() * 0.8, 0);

        double xOffset = random.nextDouble() * 1.5 * (isRight ? 1 : -1);
        double yOffset = random.nextFloat() * 2;
        double zOffset = random.nextFloat() * 0.5;

        Vec3 offset = new Vec3(xOffset, yOffset, zOffset);

        offset = offset.xRot((float) Math.toRadians(-this.getVehicle().getXRot()));
        offset = offset.yRot((float) Math.toRadians(-this.getVehicle().getYRot()));

        pos = pos.add(offset);

        this.xRotO = this.getXRot();
        this.yRotO = this.getYRot();

        setPos(pos);
        setRot(-this.getVehicle().getYRot(), -this.getVehicle().getXRot());
    }

    @Override
    protected void onHitEntity(EntityHitResult result)
    {

        Entity targetEntity = result.getEntity();
        if (targetEntity instanceof LivingEntity)
        {
            KnockBacks.cancel.action.accept((LivingEntity) targetEntity);
            StunManager.setStun((LivingEntity) targetEntity);
        }

        super.onHitEntity(result);
    }
}