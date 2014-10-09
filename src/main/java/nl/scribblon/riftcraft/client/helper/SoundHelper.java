package nl.scribblon.riftcraft.client.helper;

import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.util.ResourceLocation;
import nl.scribblon.riftcraft.reference.Reference;
import nl.scribblon.riftcraft.util.iplace.ILocationRC;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 20-09-14
 *
 * Helper for sounds.
 */
public class SoundHelper {

    public static void playSoundAt(String sound, ILocationRC location, float volume, float pitch) {
        FMLClientHandler.instance().getClient().getSoundHandler().playSound(
                new PositionedSoundRecord(
                        new ResourceLocation(Reference.MOD_ID.toLowerCase(), sound),
                        volume, pitch,
                        (float) location.getX(),
                        (float) location.getY(),
                        (float) location.getZ()
                )
        );
    }
}
