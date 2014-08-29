package nl.scribblon.riftcraft.util;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RelativeLocationTest {

    private ILocationRC root;
    private ILocationRC location;

    private IRelativeLocationRC noShift;
    private IRelativeLocationRC shift1, shift2, shift3, shift4;
    private IRelativeLocationRC dupShift4;

    @Before
    public void SetUp() {
        this.root = new Location(0,0,0);
        this.location = new Location(100,100,100);
        this.noShift = new RelativeLocation(0,0,0);
        this.shift1 = new RelativeLocation(1,1,1);
        this.shift2 = new RelativeLocation(-1,-1,-1);
        this.shift3 = new RelativeLocation(100,205,3);
        this.shift4 = new RelativeLocation(-8,-7,-10);
        this.dupShift4 = new RelativeLocation(-8,-7,-10);
    }

    @Test
    public void testEquals(){
        assertEquals(noShift, noShift);
        assertEquals(shift1, shift1);
        assertEquals(shift2, shift2);
        assertEquals(shift3, shift3);
        assertEquals(shift4, shift4);
        assertEquals(shift4, dupShift4);
    }

    @Test
    public void testDifferenceOfSame(){
        IRelativeLocationRC differenceOfSame = shift4.subtract(shift4);
        assertEquals(noShift, differenceOfSame);
    }

    @Test
    public void testInverse() {
        assertEquals(shift1, shift2.getInverse());
    }

    @Test
    public void testLocationNoShift() {
        assertEquals(root, noShift.getRelativeILocationFrom(root));
        assertEquals(location, noShift.getRelativeILocationFrom(location));
    }

    @Test
    public void testLocationShift1(){
        ILocationRC expectedFromRoot = new Location(
                shift1.getXShift(),
                shift1.getYShift(),
                shift1.getZShift());

        ILocationRC expectedFrom1 = new Location(
                location.getX() + shift1.getXShift(),
                location.getY() + shift1.getYShift(),
                location.getZ() + shift1.getZShift());

        assertEquals(expectedFromRoot, shift1.getRelativeILocationFrom(root));
        assertEquals(expectedFrom1, shift1.getRelativeILocationFrom(location));
    }

}