package com.sujan.practice;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSet9 {

    /*
    * There are 3 questions on this test. You have 2 hours to finish it. Please use tabs or spaces to indent your program.
1. A simple pattern match on the elements of an array A can be defined using another array P. Each element n of P is negative or positive (never zero) and defines the number of elements in a sequence in A. The first sequence in A starts at A[0] and its length is defined by P[0]. The second sequence follows the first sequence and its length is defined by P[1] and so on. Furthermore, for n in P, if n is positive then the sequence of n elements of A must all be positive. Otherwise the sequence of abs(n) elements must all be negative. The sum of the absolute values of the elements of P must be the length of A.  For example, consider the array
	A = {1,  2,  3, -5, -5,  2, 3, 18}
If P = {3, -2, 3} then A matches P because
	i.  the first 3 elements  of A  (1, 2, 3) are positive (P[0] is 3 and is positive),
	ii. the next 2 elements of A (-5, -5) are negative (P[1] is -2 and is negative)
	iii. and the last 3 elements of A (2, 3, 18) are positive (P[2] is 3 and is positive)
Notice that the absolute values of the elements of P  sum to 8 which is the length of A. The array A also matches the following patterns:
	{2, 1, -1, -1, 2, 1},  {1, 2, -1, -1, 1, 2},  {2, 1, -2, 3}, {1, 1, 1, -1, -1, 1, 1, 1}
In each case the sum of the absolute values is 8, which is the length of A and each sequence of numbers in A  defined in a pattern is negative or positive as required.
The array A = {1,  2,  3, -5, -5,  2, 3, 18} does not match the following patterns:
	i. P = {4, -1, 3} (because the first 4 elements of A are not positive (A[3] is negative) as required by P)
	ii. P = {2, -3, 3} (because even though the first 2 elements of A are positive, the next 3 are required to be negative but A[2] is positive which does not satisfy this requirement.)
	iii. P = {8} (because this requires all elements of A to be positive and they are not.)

Please note: Zero is neither positive nor negative.

Write a function named matches which takes arrays A and P as arguments and returns 1 if A matches P. Otherwise it returns 0. You may assume that P is a legal pattern, i.e., the absolute value of its elements sum to the length of A and it contains no zeros. So do not write code to check if P is legal!
*
    * */
    @Test
    public void matchesTest() {
        assertEquals(1, matches(new int[]{1, 2, 3, -5, -5, 2, 3, 18}, new int[]{3, -2, 3}));
        assertEquals(0, matches(new int[]{1, 2, 3, -5, -5, 2, 3, 18}, new int[]{4, -1, 3}));
        assertEquals(1, matches(new int[]{1, 0, 0, 4, 5, 6, 7, -8, -9, -10, 11, 12, 13, 14}, new int[]{5, 2, -1, -2, 4}));
    }

    public static int matches(int[] a, int[] p) {
        for (int pValue : p) {
            boolean isPvaluePositive = pValue >= 0;
            for (int j = 0; j < pValue; j++) {
                int aValue = a[j];
                boolean isAvaluePositive = aValue >= 0;
                if (isAvaluePositive != isPvaluePositive) {
                    return 0;
                }
            }

        }

        return 1;
    }

    /*
    * Define a stacked number to be a number that is the sum of the first n positive integers for some n. The first 5 stacked numbers are
	1 = 1
	3 = 1 + 2
	6 = 1 + 2 + 3
	10 = 1 + 2 + 3+ 4
	15 = 1 + 2 + 3 + 4 + 5

Note that from the above we can deduce that 7, 8, and 9 are not stacked numbers because they cannot be the sum of any sequence of positive integers that start at 1.
Write a function named isStacked that returns 1 if its argument is stacked
    * */
    @Test
    public void isStackedTest() {
        assertEquals(1, isStacked(10));
        assertEquals(0, isStacked(7));
    }


    public static int isStacked(int n) {

        int i = 0;
        int sum = 0;
        while (sum <= n) {
            sum += i;
            if (sum == n) {
                return 1;
            }
            i++;
        }
        return 0;
    }

    @Test
    public void isSumSafeTest(){
        assertEquals(0,isSumSafe(new int[]{5, -5, 0} ));
        assertEquals(1,isSumSafe(new int[]{5, -2, 1} ));
    }

    public static int isSumSafe(int[] a) {
        int sum = 0;
        for (int value : a) {
            sum += value;
        }

        for (int value : a) {
            if (value == sum)
                return 0;
        }

        return 1;
    }
}
