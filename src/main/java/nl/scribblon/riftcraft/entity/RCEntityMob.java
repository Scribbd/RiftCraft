package nl.scribblon.riftcraft.entity;

import net.minecraft.entity.monster.EntityMob;
import net.minecraft.world.World;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 08-09-14
 *
 * Base mod for Custom Mobs in RiftCraft
 */
public abstract class RCEntityMob extends EntityMob {

    public RCEntityMob(World world) {
        super(world);
    }
}
