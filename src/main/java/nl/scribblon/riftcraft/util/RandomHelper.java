package nl.scribblon.riftcraft.util;

import java.util.Random;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 7-8-2014
 */
public class RandomHelper {

    public static final double D100 = 100.0;

    public static Random rngesus;

    static {
        init();
    }

    private static void init() {
        if (rngesus == null){
            rngesus = new Random();
        }
    }

    public static boolean rollD100(double target){
        return rngesus.nextDouble()*D100 >= target;
    }
}
