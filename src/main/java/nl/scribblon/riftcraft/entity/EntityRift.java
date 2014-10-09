package nl.scribblon.riftcraft.entity;

import net.minecraft.entity.Entity;
import nl.scribblon.riftcraft.util.iplace.ILocationRC;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 09-08-14
 *
 * Entity for the rifts in the world.
 */
public class EntityRift extends RCEntity {

    public static final double NATURAL_SPAWN_CHANCE = 0.02; //1:50...

    private RiftType type;
    private boolean hasBeenAttacked;

    public EntityRift(ILocationRC location, RiftType type) {
        super(location);
        this.type = type;
        this.hasBeenAttacked = false;
    }

    public RiftType getType() {
        return this.type;
    }

    public boolean hasBeenAttacked() {
        return hasBeenAttacked;
    }

    public void invokeNaturalClosing() {
        
    }

    public void invokeArtificialClosing() {

    }
    
    public void invokeSuddenClosing() {
        
    }

    public void invokeSuccessfulClosing() {

    }

    public void selfDestruct() {
        //The last tick you will see this.
    }

    @Override
    public boolean hitByEntity(Entity entity) {
        this.hasBeenAttacked = true;
        return false;
    }

    public static enum RiftType {
        NATURAL,                        //An entity spawned in nature
        RIFT_SHARD_ENTER,               //Created by the usage of RiftShard EnterPoint
        RIFT_SHARD_EXIT,                //Created by usage of RiftShard ExitPoint
        STRUCTURE_CREATED_IN,           //Created by structure in Structure
        STRUCTURE_CREATED_OUT_1WAY,     //Created by structure outside of Structure 1 Way type
        STRUCTURE_CREATED_OUT_2WAY;     //Created by structure outside of Structure 2 Way type
    }
}
