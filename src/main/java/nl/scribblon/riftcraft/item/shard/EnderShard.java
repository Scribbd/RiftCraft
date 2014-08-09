package nl.scribblon.riftcraft.item.shard;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import nl.scribblon.riftcraft.entity.EntityShard;
import nl.scribblon.riftcraft.entity.RCEntityItem;
import nl.scribblon.riftcraft.item.RCItem;
import nl.scribblon.riftcraft.reference.Names;

/**
 * Created by Scribblon for riftcraft.
 * Date Creation: 17-6-2014
 */
public class EnderShard extends Shard{

    public EnderShard(){
        super();
        this.setUnlocalizedName(Names.Items.ENDERSHARD);
    }

    @Override
    public Entity getEntityType(World word, EntityPlayer player) {
        return new EntityShard(word, player);
    }
}
