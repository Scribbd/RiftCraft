package nl.scribblon.riftcraft.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 1-8-2014
 */
public class EntityShard extends EntityThrowable{


    public EntityShard(World world) {
        super(world);
    }

    public EntityShard(World world, EntityLivingBase entityLivingBase) {
        super(world, entityLivingBase);
    }

    public EntityShard(World world, double x, double y, double z) {
        super(world, x, y, z);
    }

    @Override
    protected void onImpact(MovingObjectPosition p_70184_1_) {

    }
}
