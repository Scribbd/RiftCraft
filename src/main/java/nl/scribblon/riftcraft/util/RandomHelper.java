package nl.scribblon.riftcraft.util;

import nl.scribblon.riftcraft.reference.Settings;

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
            LogHelper.reportWhenDebugging("Creating RnGesus!");
            rngesus = new Random();
        }
    }

    public static boolean rollD100(double target){
        double roll = rngesus.nextDouble()*D100;
        LogHelper.reportWhenDebugging("RnGesus rolled: " + roll);
        return roll >= target;
    }
}
