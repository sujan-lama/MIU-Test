package com.sujan.practice;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestSet6 {

    /*
     * A perfect number is one that is the sum of its factors, excluding itself. The 1st perfect number is 6 because 6 = 1 + 2 + 3. The 2nd perfect number is 28 which equals 1 + 2 + 4 + 7 + 14. The third is 496 = 1 + 2 + 4 + 8 + 16 + 31 + 62 + 124 + 248. In each case, the number is the sum of all its factors excluding itself.
     * */
    @Test
    public void henryTest() {
        assertEquals(502, henry(1, 3));
    }

    public static int henry(int i, int j) {

        int n = 1;
        int perfectIndex = 0;
        int iPerfect = 0;
        int jPerfect;

        while (true) {
            int factorSum = sumOfFactorOfNumber(n);
            if (factorSum == n) {
                perfectIndex++;
                if (perfectIndex == i) {
                    iPerfect = n;
                }
                if (perfectIndex == j) {
                    jPerfect = n;
                    break;
                }
            }
            n++;
        }

        return iPerfect + jPerfect;

    }

    public static int sumOfFactorOfNumber(int number) {
        int sum = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum;
    }


    /*Write a method named isDivisible that takes an integer array and a divisor and returns 1 if all its elements are divided by the divisor with no remainder. Otherwise it returns 0.
     */

    @Test
    public void isDivisibleTest() {
        assertEquals(1, isDivisible(new int[]{3, 3, 6, 36}, 3));
        assertEquals(1, isDivisible(new int[]{4}, 2));
        assertEquals(0, isDivisible(new int[]{3, 4, 3, 6, 36}, 3));
        assertEquals(0, isDivisible(new int[]{6, 12, 24, 36}, 12));
        assertEquals(1, isDivisible(new int[]{}, 3));
    }

    public static int isDivisible(int[] a, int divisor) {

        for (int value : a) {
            if (value % divisor != 0) {
                return 0;
            }
        }

        return 1;
    }

    /*
     * An array is defined to be n-unique if exactly one pair of its elements sum to n. For example, the array {2, 7,  3, 4} is 5-unique because only a[0] and a[2] sum to 5. But the array {2, 3, 3, 7} is not 5-unique because a[0] + a[1] = 5 and a[0] + a[2] = 5.
     * */

    @Test
    public void isNUniqueTest() {
        assertEquals(0, isNUnique(new int[]{7, 3, 3, 2, 4}, 6));
        assertEquals(0, isNUnique(new int[]{7, 3, 3, 2, 4}, 10));
        assertEquals(1, isNUnique(new int[]{7, 3, 3, 2, 4}, 11));
        assertEquals(0, isNUnique(new int[]{7, 3, 3, 2, 4}, 8));
        assertEquals(0, isNUnique(new int[]{7, 3, 3, 2, 4}, 4));
        assertEquals(0, isNUnique(new int[]{1}, 6));
    }

    public static int isNUnique(int[] a, int n) {
        if (a.length < 2) {
            return 0;
        }

        int equalCount = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                int sum = a[i] + a[j];
                if (sum == n) {
                    equalCount++;
                }
            }
        }
        if (equalCount == 1) {
            return 1;
        }
        return 0;
    }
}

