package com.sujan.practice;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TestSet2 {

    /*The function returns the number of primes between start and end inclusive. Recall that a prime is a positive integer greater than 1 whose only integer factors  are 1 and itself.*/
    @Test
    public void primeCountTest() {
        assertEquals(6, primeCount(10, 30));
        assertEquals(6, primeCount(11, 29));
        assertEquals(0, primeCount(20, 22));
        assertEquals(0, primeCount(1, 1));
        assertEquals(1, primeCount(5, 5));
        assertEquals(0, primeCount(6, 2));
        assertEquals(3, primeCount(-10, 6));
    }

    public static int primeCount(int start, int end) {
        int primeCount = 0;

        for (int i = start; i <= end; i++) {
            if (Helper.isNumberPrime(i)) {
                primeCount++;
            }
        }
        System.out.println("Prime count is " + primeCount);
        return primeCount;
    }

    /*
    Madhav array has the following property.
    a[0] = a[1] + a[2] = a[3] + a[4] + a[5] = a[6] + a[7] + a[8] + a[9] = ...
    The length of a Madhav array must be n*(n+1)/2 for some n.

    Write a method named isMadhavArray that returns 1 if its array argument is a Madhav array, otherwise it returns 0.*/

    @Test
    public void isMadhavArrayTest() {
        assertEquals(1, isMadhavArray(new int[]{2, 1, 1}));
        assertEquals(1, isMadhavArray(new int[]{2, 1, 1, 4, -1, -1}));
        assertEquals(1, isMadhavArray(new int[]{6, 2, 4, 2, 2, 2, 1, 5, 0, 0}));
        assertEquals(0, isMadhavArray(new int[]{18, 9, 10, 6, 6, 6}));
        assertEquals(0, isMadhavArray(new int[]{-6, -3, -3, 8, -5, -4}));
        assertEquals(1, isMadhavArray(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, -2, -1}));
        assertEquals(0, isMadhavArray(new int[]{3, 1, 2, 3, 0}));
    }

    public int isMadhavArray(int[] a) {

        if (a.length == 0) return 0;

        boolean lengthSatisfy = false;
        int n = 1;
        int value = 0;
        while (value <= a.length) {
            value = n * (n + 1) / 2;
            if (a.length == value) {
                lengthSatisfy = true;
                break;
            }
            n++;
        }

        if (!lengthSatisfy) return 0;

        int total = a[0];
        int sum = 0;
        int step = 2;
        int isMadhavArray = 1;
        int round = 3;
        for (int i = 1; i < a.length; i++) {
            sum += a[i];

            if (i == step) {
                if (total != sum) {
                    isMadhavArray = 0;
                    break;
                }
                sum = 0;
                step = step + round;
                round++;
            }
        }
        return isMadhavArray;

    }

    /*
    An array is defined to be inertial if the following conditions hold:
    a. it contains at least one odd value
    b. the maximum value in the array is even
    c. every odd value is greater than every even value that is not the maximum value. */

    @Test
    public void isInertialTest() {
        assertEquals(1, isInertial(new int[]{11, 4, 20, 9, 2, 8}));
        assertEquals(0, isInertial(new int[]{12, 11, 4, 9, 2, 3, 10}));
        assertEquals(0, isInertial(new int[]{1}));
        assertEquals(0, isInertial(new int[]{2}));
        assertEquals(0, isInertial(new int[]{1, 2, 3, 4}));
        assertEquals(1, isInertial(new int[]{1, 1, 1, 1, 1, 1, 2}));
        assertEquals(1, isInertial(new int[]{2, 12, 4, 6, 8, 11}));
        assertEquals(0, isInertial(new int[]{-2, -4, -6, -8, -11}));
        assertEquals(0, isInertial(new int[]{2, 3, 5, 7}));
        assertEquals(0, isInertial(new int[]{2, 4, 6, 8, 10}));

    }

    public int isInertial(int[] a) {
        int maxValue = 0;
        ArrayList<Integer> oddArray = new ArrayList<>();
        ArrayList<Integer> evenArray = new ArrayList<>();

        for (int num : a) {

            if (num % 2 == 0) {
                evenArray.add(num);
            } else
                oddArray.add(num);


            if (num > maxValue) {
                maxValue = num;
            }
        }

        if (oddArray.isEmpty() || maxValue % 2 != 0)
            return 0;

        for (int i = 0; i < oddArray.size(); i++) {
            int oddValue = oddArray.get(i);

            for (int j = 0; j < evenArray.size(); j++) {
                int even = evenArray.get(j);
                if (oddValue < even && even != maxValue) {
                    return 0;
                }
            }
        }


        return 1;
    }
}
