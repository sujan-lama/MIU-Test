package com.sujan.practice;

import org.junit.Test;

import java.util.ArrayList;

import static com.sujan.practice.Helper.nfactorial;
import static org.junit.Assert.assertEquals;

public class TestSet5 {

    /* It is a fact that there exist two numbers x and y such that  x! + y! = 10!. Write a method named solve10  that returns the values x and y in an array.*/
    @Test
    public void solve10Test() {
        int[] a = solve10();

        System.out.println("x is " + a[0] + " , y is " + a[1]);

    }


    public static int[] solve10() {
        int x, y;

        int sum = nfactorial(10);

        for (int i = 10; i >= 0; i--) {
            x = Helper.nfactorial(i);
            for (int j = 10; j >= 0; j--) {
                y = Helper.nfactorial(j);
                if (x + y == sum) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0, 0};
    }

    /*
     *  An array can hold the digits of a number. For example the digits of the number 32053 are stored in the array {3, 2, 0, 5, 3}. Write a method call repsEqual that takes an array and an integer and returns 1 if the array contains only the digits of the number in the same order that they appear in the number. Otherwise it returns 0.
     * */
    @Test
    public void repsEqualTest() {

        assertEquals(1, repsEqual(new int[]{3, 2, 0, 5, 3}, 32053));
        assertEquals(0, repsEqual(new int[]{3, 2, 0, 5}, 32053));
        assertEquals(0, repsEqual(new int[]{3, 2, 0, 5, 3, 4}, 32053));
        assertEquals(0, repsEqual(new int[]{2, 3, 0, 5, 3}, 32053));
        assertEquals(0, repsEqual(new int[]{9, 3, 1, 1, 2}, 32053));
        assertEquals(1, repsEqual(new int[]{0, 3, 2, 0, 5, 3}, 32053));

    }

    public static int repsEqual(int[] a, int n) {

        int i = a.length - 1;
        int rem = n;
        while (rem > 0) {
            int lastDigit = rem % 10;
            if (lastDigit != a[i]) {
                return 0;
            }
            rem = rem / 10;
            i--;
        }
        return 1;
    }

    /*
    * An array is called centered-15 if some consecutive sequence of elements of the array sum to 15 and this sequence is preceded and followed by the same number of elements.  For example
{3, 2, 10, 4, 1, 6, 9} is centered-15 because  the sequence 10, 4, 1 sums to 15 and the sequence is preceded by two elements (3, 2) and followed by two elements(6,9).
    * */

    @Test
    public void isCentered15Test() {

        assertEquals(1, isCentered15(new int[]{3, 2, 10, 4, 1, 6, 9}));
        assertEquals(0, isCentered15(new int[]{2, 10, 4, 1, 6, 9}));
        assertEquals(0, isCentered15(new int[]{3, 2, 10, 4, 1, 6}));
        assertEquals(1, isCentered15(new int[]{1,1,8, 3, 1, 1}));
        assertEquals(1, isCentered15(new int[]{9, 15, 6}));
        assertEquals(0, isCentered15(new int[]{1, 1, 2, 2, 1, 1}));
        assertEquals(1, isCentered15(new int[]{1, 1, 15 -1,-1}));

    }

    public static int isCentered15(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int sum = 0;
            for (int j = i; j < a.length; j++) {
                sum += a[j];
                if (sum == 15 && (i == ((a.length - 1) - j))) {
                    return 1;
                }
            }
        }

        return 0;
    }
}
