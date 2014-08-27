package nl.scribblon.riftcraft.util.helper;

import java.util.Random;

/**
 * Here RNGesus resides judging all players.
 *
 * Singleton Design.
 * Created by Scribblon for RiftCraft.
 * Date Creation: 7-8-2014
 */
final public class RandomHelper {

    //START SINGLETON PATTERN

    /**
     * Singleton patter. The one and only instance of RNGesus!
     */
    private static RandomHelper instance = new RandomHelper();

    /**
     * Gives you the one single RNGesus
     * @return Praise the Dice!
     */
    public static RandomHelper getInstance(){
        return instance;
    }
    /**
     * All according to the singleton pattern.
     */
    private RandomHelper() {
        if (this.rngesus == null) {
            this.rngesus = new Random();
        }
    }

    //END SINGLETON PATTERN
    //FROM HERE IT IS THE DOMAIN OF RNGESUS

    /**
     * Set double for Math bollocks in Java.
     */
    public static final double D100 = 100.0;

    /**
     * RNGesus will judge all!
     */
    private Random rngesus;

    /**
     * RNGesus will roll 1D100 dice for you. And judge you on the result
     * @param target your karma
     * @return heaven or hell.
     */
    public boolean rollD100(double target){
        double roll = rngesus.nextDouble()*D100;
        LogHelper.reportWhenDebugging("RnGesus rolled: " + roll);
        return roll >= target;
    }
}
