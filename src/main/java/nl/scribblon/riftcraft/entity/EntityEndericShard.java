package nl.scribblon.riftcraft.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;
import nl.scribblon.riftcraft.item.crystalic.shard.ItemEndericShard;
import nl.scribblon.riftcraft.reference.Settings;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 1-8-2014
 *
 * Entity variant of the Item Enderic Shard. Created when thrown.
 */
public class EntityEndericShard extends EntityThrowable {

    private float throwStrength;

    public EntityEndericShard(World world) {
        super(world);
        this.throwStrength = ItemEndericShard.DEFAULT_THROW_STRENGTH;
    }

    public EntityEndericShard(World world, EntityLivingBase entityLivingBase) {
        super(world, entityLivingBase);
        this.throwStrength = ItemEndericShard.DEFAULT_THROW_STRENGTH;
    }

    @SideOnly(Side.CLIENT)
    public EntityEndericShard(World world, double x, double y, double z) {
        super(world, x, y, z);
        this.throwStrength = ItemEndericShard.DEFAULT_THROW_STRENGTH;
    }

    public EntityEndericShard(World world, EntityLivingBase entityLivingBase, float throwStrength) {
        this(world, entityLivingBase);
        this.throwStrength = throwStrength;
    }

    /**
     * This method is heavily inspired by the EntityEnderPearl.java in net.minecraft.entity.item .
     * @param movingObjectPosition
     */
    @Override
    protected void onImpact(MovingObjectPosition movingObjectPosition) {
        // Whenever an entity is hit it shouldn't hurt.
        if (movingObjectPosition.entityHit != null)
            movingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 0.0F);

        // Spawn particle part...
        //TODO change to rift-render or change particles
        for (int i = 0; i < 32; ++i) {
            this.worldObj.spawnParticle("portal", this.posX, this.posY + this.rand.nextDouble() * 2.0D, this.posZ, this.rand.nextGaussian(), 0.0D, this.rand.nextGaussian());
        }

        // Server stuff!
        if (!this.worldObj.isRemote) {
            // Whenever there is a LivingBase thrower, and it is a Player(MP).
            if (this.getThrower() != null && this.getThrower() instanceof EntityPlayerMP) {
                EntityPlayerMP entityplayermp = (EntityPlayerMP) this.getThrower();
                // Check if the player is still online (?) and whenever the player is still in the world from which it was thrown.
                if (entityplayermp.playerNetServerHandler.func_147362_b().isChannelOpen() && entityplayermp.worldObj == this.worldObj) {
                    // Will leave this in. Essentially this is an Ender Teleport Event.
                    EnderTeleportEvent event = new EnderTeleportEvent(entityplayermp, this.posX, this.posY, this.posZ, Settings.Shards.defaultThrowDamage); //4 Hearths (8.0F)

                    // Checks if Event is canceled.
                    if (!MinecraftForge.EVENT_BUS.post(event)) {
                        // Dismount player
                        if (this.getThrower().isRiding())
                            this.getThrower().mountEntity((Entity) null);

                        // Set player to new position
                        this.getThrower().setPositionAndUpdate(event.targetX, event.targetY, event.targetZ);
                        this.getThrower().fallDistance = 0.0F;
                        this.getThrower().attackEntityFrom(DamageSource.fall, event.attackDamage); //TODO customize death message
                    }
                }
            }

            // Prevents the entity from traveling to the void indefinitely.
            this.setDead();
        }
    }

    //TODO figure out how to throw the shard at custom speeds

}
