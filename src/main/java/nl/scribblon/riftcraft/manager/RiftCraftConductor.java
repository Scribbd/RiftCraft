package nl.scribblon.riftcraft.manager;


import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.relauncher.Side;
import nl.scribblon.riftcraft.event.delayed.DelayedRiftCraftEvent;
import nl.scribblon.riftcraft.reference.Reference;
import nl.scribblon.riftcraft.util.IRiftConductable;
import nl.scribblon.riftcraft.util.helper.LogHelper;

import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 05-09-14
 *
 * Used to conduct musicians like a stern conductor. Conducting them all to the beat of the server.
 * 20 swings a second, imagine that.
 */
public class RiftCraftConductor {

    /*
     * Singleton Design Pattern
     */
    private static RiftCraftConductor instance = new RiftCraftConductor();

    private RiftCraftConductor() {
        this.musicians = new HashSet<IRiftConductable>();
        this.slowSwingers = new PriorityQueue<DelayedRiftCraftEvent>();
        this.madeSwings = 0;
    }

    public static RiftCraftConductor getInstance(){
        return instance;
    }
    /*
     * End Singleton Design Pattern
     */

    private HashSet<IRiftConductable> musicians;
    private PriorityQueue<DelayedRiftCraftEvent> slowSwingers;
    private int madeSwings;

    @SubscribeEvent
    public void onTick(TickEvent.ServerTickEvent event) {
        this.swingOnBeat(event);
        //this.punishTheSlowPlayers(event);
        if(this.madeSwings >= Integer.MAX_VALUE) LogHelper.fatal("Congratulations you gave the conductor RSI, but hey, if you read this he has been swinging his wand for 3.5 years Non-Stop!");
        ++this.madeSwings;
    }

    public boolean seatMusician(IRiftConductable musician) {
        if(this.musicians.contains(musician)) {
            LogHelper.reportWhenDebugging("The conductor got confused. A musician is already sitting on the seat is trying to sit on.");
            return false;
        }
        return this.musicians.add(musician);
    }

    public boolean fireMusician(IRiftConductable musician) {
        if(!this.musicians.contains(musician)) {
            LogHelper.reportWhenDebugging("The conductor got confused. He can't fire the lousy musician as the seat is empty. What a downer.");
            return false;
        }
        return this.musicians.remove(musician);
    }

    public void noticeSlowSwinger(DelayedRiftCraftEvent slowSwinger) {
        this.slowSwingers.add(new DelayedRiftCraftEvent(slowSwinger, this.madeSwings));
    }

    private void swingOnBeat(TickEvent.ServerTickEvent event) {
        // Check if the list is populated.
        if(this.musicians.isEmpty()) return;

        // Check for the tick posted on server
        if(!event.side.equals(Side.SERVER)) return;
        // Check if event-type is right (prevent double firing)
        if(!event.phase.equals(TickEvent.Phase.START)) return;

        // Give tick to all musicians
        for(IRiftConductable subject : this.musicians) {
            if(subject.receiveConductorTick(Reference.DEFAULT_TICK_SPACE)) {
                this.musicians.remove(subject);
            }
        }
    }

    private void punishTheSlowPlayers(TickEvent event) {
        // Return when queue is empty
        if(slowSwingers.isEmpty()) return;

        // Check if empty while in the while loop.
        while(!slowSwingers.isEmpty() && slowSwingers.peek().isItTime(this.madeSwings)) {
            slowSwingers.poll();
        }
    }

    public HashSet<IRiftConductable> getMusicians(){
        return this.musicians;
    }

    public PriorityQueue<DelayedRiftCraftEvent> getSlowSwingers() {
        return this.slowSwingers;
    }
}
