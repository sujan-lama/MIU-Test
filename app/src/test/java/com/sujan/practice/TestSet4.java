package com.sujan.practice;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TestSet4 {

    /*
    The Stanton measure of an array is computed as follows. Count the number of 1s in the array. Let this count be n. The Stanton measure is the number of times that n appears in the array. For example, the Stanton measure of {1, 4, 3, 2, 1, 2, 3, 2} is 3 because 1 occurs 2 times in the array and 2 occurs 3 times.
    * */
    @Test
    public void stantonMeasureTest() {
        assertEquals(6, stantonMeasure(new int[]{1, 3, 1, 1, 3, 3, 2, 3, 3, 3, 4}));
        assertEquals(3, stantonMeasure(new int[]{1, 4, 3, 2, 1, 2, 3, 2}));
        assertEquals(1, stantonMeasure(new int[]{1}));
        assertEquals(1, stantonMeasure(new int[]{0}));
        assertEquals(0, stantonMeasure(new int[]{3, 1, 1, 4}));
    }

    public static int stantonMeasure(int[] a) {
        int oneCount = 0;
        int stantonMeasure = 0;

        for (int value : a) {
            if (value == 1) oneCount++;
        }

        for (int value : a) {
            if (value == oneCount) stantonMeasure++;
        }
        System.out.println("Stanton Measure " + stantonMeasure);
        return stantonMeasure;
    }

    /*
    The sum factor of an array is defined to be the number of times that the sum of the array appears as an element of the array. So the sum factor of {1, -1, 1, -1, 1, -1, 1} is 4 because the sum of the elements of the array is 1 and 1 appears four times in the array. And the sum factor of
{1, 2, 3, 4} is 0 because the sum of the elements of the array is 10 and 10 does not occur as an element of the array. The sum factor of the empty array { } is defined to be 0.
    * */
    @Test
    public void sumFactorTest() {
        assertEquals(4, sumFactor(new int[]{1, -1, 1, -1, 1, -1, 1}));
        assertEquals(2, sumFactor(new int[]{3, 0, 2, -5, 0}));
        assertEquals(0, sumFactor(new int[]{9, -3, -3, -1, -1}));
        assertEquals(1, sumFactor(new int[]{1}));
        assertEquals(3, sumFactor(new int[]{0, 0, 0}));
    }

    public static int sumFactor(int[] a) {

        int sum = 0;
        int count = 0;

        for (int value : a) {
            sum += value;
        }

        for (int value : a) {
            if (sum == value) count++;
        }

        System.out.println("Sum factor is " + count);
        return count;
    }

    //question no 3 is guthrie sequence which is already in testSet3 {@link #isGuthrieSequenceTest}
}
