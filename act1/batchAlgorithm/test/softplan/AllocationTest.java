package softplan;

import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;

public class AllocationTest {

    @Test
    public void getFileSizes() {
        Allocation test = new Allocation();
        int[] fileSizes = {20, 30, 50, 10, 15};
        assertArrayEquals(new int[]{20, 30, 50, 10, 15}, fileSizes);
    }

    @Test
    public void getTapeSize() {
        Allocation test = new Allocation();
        int tapeSize = 100;
        assertEquals(100, tapeSize);
    }
}