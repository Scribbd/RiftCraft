package nl.scribblon.riftcraft.event.delayed;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 06-09-14
 *
 * Delayed event. Mostly used for
 */
public class DelayedRiftCraftEvent implements Comparable<DelayedRiftCraftEvent> {

    public final Priority priority;
    public final int fireInTicks;

    public DelayedRiftCraftEvent(int fireInTicks, Priority priority) {
        this.fireInTicks = fireInTicks;
        this.priority = priority;
    }

    public DelayedRiftCraftEvent(int fireInTicks) {
        this.fireInTicks = fireInTicks;
        this.priority = Priority.DEFAULT;
    }

    public DelayedRiftCraftEvent(DelayedRiftCraftEvent toBeQueued, int currentTick) {
        this.fireInTicks = currentTick + toBeQueued.fireInTicks;
        this.priority = toBeQueued.priority;
    }

    public boolean isItTime(int madeSwings) { //To Rule The World?
        return this.fireInTicks <= madeSwings;
    }

    @Override
    public int compareTo(DelayedRiftCraftEvent that) {
        //Check on the base attribute
        if(this.fireInTicks < that.fireInTicks)
            return +1;
        if(this.fireInTicks > that.fireInTicks)
            return -1;

        //Check on
        if(this.priority.equals(that.priority))
            return 0;

        switch (this.priority) {
            case HIGH:
                switch (that.priority) {
                    case HIGH:
                        return 0;
                    case DEFAULT:
                        return -1;
                    case LOW:
                        return -1;
                }
                break;
            case DEFAULT:
                switch (that.priority) {
                    case HIGH:
                        return +1;
                    case DEFAULT:
                        return 0;
                    case LOW:
                        return -1;
                }
                break;
            case LOW:
                switch (that.priority) {
                    case HIGH:
                        return -1;
                    case DEFAULT:
                        return -1;
                    case LOW:
                        return 0;
                }
                break;
        }

        //Should not be reachable... But you know java...
        return 0;
    }

    public static enum Priority {
        HIGH,
        DEFAULT,
        LOW;
    }
}
