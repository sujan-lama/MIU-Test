package com.sujan.practice;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestSet10 {

    /*
    * Define a positive number to be isolated if none of the digits in its square are in its cube. For example 69 is n isolated number because 69*69 =  26569  and 69*69*69 = 4330747 and the square does not contain any of the digits 0, 3, 4 and 7 which are the digits used in the cube. On the other hand 162 is not an isolated number because 162*162=26244 and 162*162*162 = 4251528 and the digits 2 and 4 which appear in the square are also in the cube.

Write a function named isIsolated that returns 1 if its argument is an isolated number,  it returns 0 if its not an isolated number and it returns -1 if it cannot determine whether it is isolated or not (see the note below). The function signature is:

    * */
    @Test
    public void isIsolateTest() {
        assertEquals(1, isIsolate(69));
        assertEquals(1, isIsolate(2));
        assertEquals(1, isIsolate(3));
        assertEquals(0, isIsolate(4));
        assertEquals(-1, isIsolate(0));
        assertEquals(-1, isIsolate(2097152));
    }


    public static int isIsolate(long n) {

        if (n < 1 || n > 2097151) {
            return -1;
        }

        List<Long> digitList = new ArrayList<>();

        long square = n * n;
        long cube = n * n * n;

        while (cube > 0) {
            long rem = cube % 10;
            if (!digitList.contains(rem)) {
                digitList.add(rem);
            }
            cube = cube / 10;
        }


        while (square > 0) {
            long rem = square % 10;
            if (digitList.contains(rem)) {
                return 0;
            }
            square = square / 10;
        }

        return 1;

    }

    /*
     * An array is called vanilla if all its elements are made up of the same digit. For example {1, 1, 11, 1111, 1111111} is a vanilla array because all its elements use only the digit 1. However, the array {11, 101, 1111, 11111} is not a vanilla array because its elements use the digits 0 and 1. Write a method called isVanilla that returns 1 if its argument is a vanilla array. Otherwise it returns 0.

     * */

    @Test
    public void isVanillaTest() {
        assertEquals(1, isVanilla(new int[]{1, 1, 11, 1111, 1111111}));
        assertEquals(1, isVanilla(new int[]{1}));
        assertEquals(0, isVanilla(new int[]{11, 22, 13, 34, 125}));
        assertEquals(1, isVanilla(new int[]{9, 999, 99999, -9999}));
        assertEquals(1, isVanilla(new int[]{}));
    }

    public static int isVanilla(int[] a) {

        int sameDigit = -1;
        for (int value : a) {
            int digit = Math.abs(value);
            while (digit > 0) {
                int lastDigit = digit % 10;
                if (sameDigit == -1) {
                    sameDigit = lastDigit;
                }

                if (sameDigit != lastDigit) {
                    return 0;
                }
                digit = digit / 10;
            }
        }

        return 1;
    }

    @Test
    public void isTrivalentTest() {
        assertEquals(1, isTrivalent(new int[]{22, 19, 10, 10, 19, 22, 22, 10}));
        assertEquals(0, isTrivalent(new int[]{1, 2, 2, 2, 2, 2, 2}));
        assertEquals(0, isTrivalent(new int[]{2, 2, 3, 3, 3, 3, 2, 41, 65}));
        assertEquals(1, isTrivalent(new int[]{-1, 0, 1, 0, 0, 0}));
        assertEquals(1, isTrivalent(new int[]{2147483647, -1, -1, -2147483648}));
    }

    public static int isTrivalent(int[] a) {
        List<Integer> trivalentList = new ArrayList<>();
        for (int value : a) {
            if (!trivalentList.contains(value)) {
                trivalentList.add(value);
            }
        }
        if (trivalentList.size() == 3) return 1;

        return 0;
    }
}
