package com.sujan.practice;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSet1 {

    /*Write a function named nextPerfectSquare that returns the first perfect square that is greater than its integer argument */

    @Test
    public void isPerfectSquareTest() {
        assertEquals(9, isPerfectSquare(6));
        assertEquals(49, isPerfectSquare(36));
        assertEquals(1, isPerfectSquare(0));
        assertEquals(0, isPerfectSquare(-5));

    }

    public static int isPerfectSquare(int n) {

        int nextPerfectSquare = 0;
        int i = 1;
        while (nextPerfectSquare <= n) {
            nextPerfectSquare = i * i;
            i++;
        }

        System.out.println("nextPerfectSquare is " + nextPerfectSquare);
        return nextPerfectSquare;
    }

    /*Define the n-upcount of an array to be the number of times the partial sum goes from less than equal to n to greater than n during the calculation of the sum of the elements of the array*/
    @Test
    public void nUpCountTest() {
        assertEquals(3, nUpCount(new int[]{2, 3, 1, -6, 8, -3, -1, 2}, 5));
        assertEquals(1, nUpCount(new int[]{6, 3, 1}, 6));
    }


    public static int nUpCount(int[] a, int n) {

        int partialSum = 0;
        int previousPartialSum = 0;
        int nUpCount = 0;

        for (int value : a) {
            partialSum += value;
            if (partialSum > n && previousPartialSum <= n) {
                nUpCount++;
            }
            previousPartialSum = partialSum;

        }
        System.out.println("nUpCount is " + nUpCount);
        return nUpCount;
    }
}
