package com.sujan.practice;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSet7 {

    /*
     * Write a function named isSquare that returns 1 if its integer argument is a square of some integer, otherwise it returns 0. Your function must not use any function or method (e.g. sqrt) that comes with a runtime library or class library!
     * */
    @Test
    public void isSquareTest() {
        assertEquals(1, isSquare(4));
        assertEquals(1, isSquare(25));
        assertEquals(0, isSquare(-4));
        assertEquals(0, isSquare(8));
        assertEquals(1, isSquare(0));
    }

    public static int isSquare(int n) {

        if (n < 0) {
            return 0;
        }
        int i = 0;
        int square = 0;
        while (square <= n) {
            square = i * i;
            if (square == n) {
                return 1;
            }
            i++;
        }
        return 0;

    }

    /*
     * Write a method named isLegalNumber that takes two arguments. The first argument is an array whose elements are the digits of the number to test. The second argument is the base of the number represented by the first argument. The method returns 1 if the number represented by the array is a legal number in the given base, otherwise it returns 0.
     * */
    @Test
    public void isLegalNumberTest() {
        assertEquals(1, isLegalNumber(new int[]{3, 2, 1}, 4));
        assertEquals(0, isLegalNumber(new int[]{3, 7, 1}, 6));
    }

    public static int isLegalNumber(int[] a, int base) {

        for (int value : a) {
            if (value > base) {
                return 0;
            }
        }
        return 1;
    }

    @Test
    public void convertToBase10Test() {

        assertEquals(11, convertToBase10(new int[]{1, 0, 1, 1}, 2));
        assertEquals(14, convertToBase10(new int[]{1, 1, 2}, 3));
        assertEquals(213, convertToBase10(new int[]{3, 2, 5}, 8));
        assertEquals(0, convertToBase10(new int[]{3, 7, 1}, 6));
    }

    /*
     * Using the <array, base> representation for a number described in the second question write a method named convertToBase10 that  converts its <array, base> arguments to a base 10 number if the input is legal for the specified base. If it is not, it returns -1.

     * */
    public static int convertToBase10(int[] a, int base) {

        int power = a.length - 1;

        int converted = 0;

        for (int i = 0; i < a.length; i++, power--) {
            int value = a[i];
            if (value >= base) {
                return 0;
            }
            converted += value * Math.pow(base, power);
        }

        return converted;

    }
}
