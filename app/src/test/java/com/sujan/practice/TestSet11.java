package com.sujan.practice;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSet11 {

    /*
     *  Write a function named countRepresentations that returns the number of ways that an amount of money in rupees can be represented as rupee notes. For this problem we only use  rupee notes in denominations of 1, 2, 5, 10 and 20 rupee notes.
     * */

    @Test
    public void countRepresentationTest() {
        assertEquals(15, countRepresentations(12));
    }

    public static int countRepresentations(int numRupees) {

        int count = 0;

        for (int rupee20 = 0; rupee20 <= numRupees / 20; rupee20++)
            for (int rupee10 = 0; rupee10 <= numRupees / 10; rupee10++)
                for (int rupee5 = 0; rupee5 <= numRupees / 5; rupee5++)
                    for (int rupee2 = 0; rupee2 <= numRupees / 2; rupee2++)
                        for (int rupee1 = 0; rupee1 <= numRupees; rupee1++) {
                            if (rupee1 + (rupee2 * 2) + (rupee5 * 5) + (rupee10 * 10) + (rupee20 * 20) == numRupees)
                                count++;
                        }

        return count;
    }

    /*
     * An integer array is defined to be sequentially-bounded if it is in ascending order and each value, n,  in the array  occurs less than n times in the array. So {2, 3, 3, 99, 99, 99, 99, 99} is sequentially-bounded because it is in ascending order and the value 2 occurs less than 2 times, the value 3 occurs less than 3 times and the value 99 occurs less than 99 times. On the other hand, the array {1, 2, 3} is not sequentially-bounded because the value 1 does not occur < 1 times. The array {2, 3, 3, 3, 3} is not sequentially-bounded because the maximum allowable occurrences of 3 is 2 but 3 occurs 4 times. The array {12, 12, 9} is not sequentially-bounded because it is not in ascending order.
     * */

    @Test
    public void isSequentiallyBoundedTest() {

        assertEquals(0, isSequentiallyBounded(new int[]{0, 1}));
        assertEquals(0, isSequentiallyBounded(new int[]{-1, 2}));
        assertEquals(1, isSequentiallyBounded(new int[]{}));
        assertEquals(1, isSequentiallyBounded(new int[]{5, 5, 5, 5}));
        assertEquals(0, isSequentiallyBounded(new int[]{5, 5, 5, 2, 5}));

    }

    public static int isSequentiallyBounded(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int nextValue = a[i + 1];
            if (nextValue < a[i])
                return 0;
        }

        for (int value : a) {
            int count = 0;
            for (int i : a) {
                if (value == i) {
                    count++;
                }
            }
            if (count > value)
                return 0;
        }
        return 1;
    }

    /*
    * An array is defined to be minmax-disjoint if the following conditions hold:
a. The minimum and maximum values of the array are not equal.
b. The minimum and maximum values of the array are not adjacent to one another.
c. The minimum value occurs exactly once in the array.
d. The maximum value occurs exactly once in the array.

For example the array {5, 4, 1, 3, 2} is minmax-disjoint because
a. The maximum value is 5 and the minimum value is 1 and they are not equal.
b. 5 and 1 are not adjacent to one another
c. 5 occurs exactly once in the array
d. 2 occurs exactly once in the array
    * */
    @Test
    public void isMinMaxDisjointTest() {
        assertEquals(1, isMinMaxDisjoint(new int[]{5, 4, 1, 3, 2}));
        assertEquals(0, isMinMaxDisjoint(new int[]{-1, 18, 3, 4, 0}));
        assertEquals(0, isMinMaxDisjoint(new int[]{9, 0, 5, 9}));
        assertEquals(0, isMinMaxDisjoint(new int[]{0, 5, 18, 0, 9}));
        assertEquals(0, isMinMaxDisjoint(new int[]{7, 7, 7, 7}));
        assertEquals(0, isMinMaxDisjoint(new int[]{}));
        assertEquals(0, isMinMaxDisjoint(new int[]{1,2}));
        assertEquals(0, isMinMaxDisjoint(new int[]{1}));
    }

    public static int isMinMaxDisjoint(int[] a) {

        int maxValue = 0;
        int minValue = Integer.MAX_VALUE;
        int maxValueIndex = 0;
        int minValueIndex = 0;
        int maxValueCount = 0;
        int minValueCount = 0;
        for (int i = 0; i < a.length; i++) {
            int value = a[i];
            if (value > maxValue) {
                maxValueIndex = i;
                maxValue = value;
            }
            if (value < minValue) {
                minValueIndex = i;
                minValue = value;
            }
        }

        if (minValue == maxValue) return 0;

        if (maxValueIndex + 1 == minValueIndex || minValueIndex + 1 == maxValueIndex) return 0;

        for (int value : a) {
            if (value == maxValue)
                maxValueCount++;
            if (value == minValue)
                minValueCount++;
        }

        if (maxValueCount != 1 || minValueCount != 1) return 0;
        return 1;

    }
}
