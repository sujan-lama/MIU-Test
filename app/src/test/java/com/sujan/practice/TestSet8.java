package com.sujan.practice;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestSet8 {

    /*
     * Write a function that will return 1 if all the elements are non-zero. Otherwise returns 0.
     * */
    @Test
    public void arrayHasNoZeroesTest() {
        assertEquals(1, arrayHasNoZeroes(new int[]{1, 2, 3}));
        assertEquals(0, arrayHasNoZeroes(new int[]{1, 0, 4, 0}));
        assertEquals(0, arrayHasNoZeroes(new int[]{1, 2, 3, 0}));
        assertEquals(0, arrayHasNoZeroes(new int[]{0, 0, 0, 0}));
        assertEquals(1, arrayHasNoZeroes(new int[]{}));
    }

    public static int arrayHasNoZeroes(int[] a) {
        for (int value : a) {
            if (value == 0) {
                return 0;
            }
        }
        return 1;
    }


    @Test
    public void computeDepthTest() {
        assertEquals(9, computeDepth(42));
        assertEquals(10, computeDepth(7));
        assertEquals(8, computeDepth(13));
        assertEquals(36, computeDepth(25));
    }


    public static int computeDepth(int n) {
        List<Integer> digitList = new ArrayList<>();
        int i = 0;
        while (digitList.size() < 10) {
            i++;
            int multiple = n * i;

            while (multiple > 0) {
                int lastDigit = multiple % 10;
                if (!digitList.contains(lastDigit)) {
                    digitList.add(lastDigit);
                }
                multiple = multiple / 10;
            }
        }

        System.out.println("depth " + i);
        return i;
    }




}
