package com.sujan.practice;

import android.widget.TableLayout;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestSet12 {

    /*
    * The number 124 has the property that it is the smallest number whose first three multiples contain the digit 2. Observe that
124*1 = 124, 124*2 = 248, 124*3 = 372 and that 124, 248 and 372 each contain the digit 2. It is possible to generalize this property to be the smallest number whose first n multiples each contain the digit 2. Write a function named smallest(n) that returns the smallest number whose first n multiples contain the digit 2. Hint: use modulo base 10 arithmetic to examine digits.
    * */

    @Test
    public void smallestTest() {
        assertEquals(124, smallest(3));
        assertEquals(624, smallest(5));
        assertEquals(642, smallest(6));
        assertEquals(4062, smallest(7));
    }

    public static int smallest(int n) {

        int i = 1;
        int isSmallest = 0;
        while (isSmallest == 0) {
            int count = 0;
            for (int j = 1; j <= n; j++) {
                int multiple = i * j;
                if (hasDigit2(multiple)) {
                    count++;
                }
            }
            if (count == n) {
                isSmallest = i;
            }

            i++;
        }
        return isSmallest;
    }

    public static boolean hasDigit2(int n) {
        while (n > 0) {
            int last = n % 10;
            if (last == 2) {
                return true;
            }
            n = n / 10;
        }
        return false;
    }

    /*
     *  Define a cluster in an integer array to be a maximum sequence of elements that are all the same value. For example, in the array {3, 3, 3, 4, 4, 3, 2, 2, 2, 2, 4} there are 5 clusters, {3, 3, 3}, {4, 4}, {3}, {2, 2, 2, 2} and {4}. A cluster-compression of an array replaces each cluster with the number that is repeated in the cluster. So, the cluster compression of the previous array would be {3, 4, 3, 2, 4}. The first cluster {3, 3, 3} is replaced by a single 3, and so on.

     * The function returns the cluster compression of the array a. The length of the returned array must be equal to the number of clusters in the original array! This means that someplace in your answer you must dynamically allocate the returned array.

     * */

    @Test
    public void clusterCompressionTest() {
        assertArrayEquals(new int[]{3, 4, 3, 2, 4}, clusterCompression(new int[]{3, 3, 3, 4, 4, 3, 2, 2, 2, 2, 4}));
        assertArrayEquals(new int[]{0, 2, 0, 2, 0, 2, 0}, clusterCompression(new int[]{0, 0, 0, 2, 0, 2, 0, 2, 0, 0}));
        assertArrayEquals(new int[]{18}, clusterCompression(new int[]{18}));
        assertArrayEquals(new int[]{}, clusterCompression(new int[]{}));
        assertArrayEquals(new int[]{-5}, clusterCompression(new int[]{-5, -5, -5, -5}));
        assertArrayEquals(new int[]{1, 2, 1}, clusterCompression(new int[]{1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1}));
        assertArrayEquals(new int[]{8, 6, -2}, clusterCompression(new int[]{8, 8, 6, 6, -2, -2, -2}));

    }

    public static int[] clusterCompression(int[] a) {
        int numClusters = 0;
        int previous = Integer.MAX_VALUE;
        int count = 0;
        int[] allResult = new int[a.length];
        for (int value : a) {
            if (previous != value) {
                previous = value;
                allResult[count] = value;
                count++;
                numClusters++;
            }
        }
        int[] result = new int[numClusters];
        for (int i = 0; i < numClusters; i++) {
            result[i] = allResult[i];
        }
        return result;

    }


    /*
    *  Define an array to be a railroad-tie array if the following three conditions hold

a. The array contains at least one non-zero element
b. Every non-zero element has exactly one non-zero neighbor
c. Every zero element has two non-zero neighbors.

For example, {1, 2, 0, 3, -18, 0, 2, 2} is a railroad-tie array because

a[0] = 1 has exactly one non-zero neighbor (a[1])
a[1] = 2 has exactly one non-zero neighbor (a[0])
a[2] = 0 has two non-zero neighbors (a[1] and a[3])
a[3] = 3 has exactly one non-zero neighbor (a[4])
a[4] = -18 has exactly one non-zero neighbor (a[3])
a[5] = 0 has two non-zero neighbors (a[4] and a[6])
a[6] = 2 has exactly one non-zero neighbor (a[7])
a[7] = 2 has exactly one non-zero neighbor (a[6])

The following are not railroad-tie arrays

{1, 2, 3, 0, 2, 2}, because a[1]=2 has two non-zero neighbors.
{0, 1, 2, 0, 3, 4}, because a[0]=0 has only one non-zero neighbor (it has no left neighbor)
{1, 2, 0, 0, 3, 4}, because a[2]=0 has only one non-zero neighbor (a[1])
{1}, because a[0]=1 does not have any non-zero neighbors.
{}, because the array must have at least one non-zero element
{0}, because the array must have at lease one non-zero element.
    * */
    @Test
    public void isRailRoaTieTest() {
        assertEquals(1, isRailroadTie(new int[]{1, 2, 0, 3, -18, 0, 2, 2}));
        assertEquals(1, isRailroadTie(new int[]{1, 2}));
        assertEquals(1, isRailroadTie(new int[]{3, 3, 0, 3, 3, 0, 3, 3, 0, 3, 3}));
        assertEquals(0, isRailroadTie(new int[]{0, 0, 0, 0}));
        assertEquals(0, isRailroadTie(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
        assertEquals(0, isRailroadTie(new int[]{1, 3, 0, 3, 5, 0}));
    }

    public static int isRailroadTie(int[] a) {

        for (int i = 0; i < a.length; i++) {
            int current = a[i];
            int neighborcount = 0;

            if (i - 1 >= 0 && a[i - 1] != 0) neighborcount++;
            if (i + 1 < a.length && a[i + 1] != 0) neighborcount++;

            if (current != 0) {
                if (neighborcount != 1) return 0;
            } else {
                if (neighborcount != 2) return 0;
            }
        }
        return 1;
    }


    // question

    @Test
    public void isEvenSpreadTest() {
        assertEquals(0, isEvenSpread(new int[]{100, 19, 131, 140}));
        assertEquals(0, isEvenSpread(new int[]{200, 1, 151, 160}));
        assertEquals(1, isEvenSpread(new int[]{200, 10, 151, 160}));
        assertEquals(0, isEvenSpread(new int[]{80, -56, 11, -81}));
    }

    public static int isEvenSpread(int[] a) {

        if (a.length < 2) return 0;

        int largest = -215625;
        int smallest = 215625;
        for (int value : a) {
            if (value > largest)
                largest = value;
            if (value < smallest)
                smallest = value;
        }

        int diff = largest - smallest;
        if (diff % 2 == 0)
            return 1;
        return 0;
    }

    @Test
    public void isSubArrayTest() {
        assertEquals(1, isSubArray(new int[]{13, 6, 3, 2}));
        assertEquals(0, isSubArray(new int[]{15, 5, 3, 2}));
    }

    public static int isSubArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int value = a[i];
            int sum = 0;
            for (int j = i + 1; j < a.length; j++) {
                sum += a[j];
            }
            if (value <= sum)
                return 0;
        }
        return 1;
    }

    @Test
    public void isSymmetricTest() {

        assertEquals(1, isSymmetric(new int[]{2, 7, 9, 10, 11, 5, 8}));
        assertEquals(1, isSymmetric(new int[]{9, 8, 7, 13, 14, 17}));
        assertEquals(0, isSymmetric(new int[]{2, 7, 8, 9, 11, 13, 10}));
    }

    public static int isSymmetric(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int value = a[i];
            int symmetric = a[a.length - 1 - i];
            if (value % 2 == 0 && symmetric % 2 != 0)
                return 0;
            if (value % 2 != 0 && symmetric % 2 == 0)
                return 0;
        }
        return 1;
    }
}

