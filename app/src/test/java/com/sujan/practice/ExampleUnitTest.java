package com.sujan.practice;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }


    @Test
    public void questions() {
        int[] a = new int[]{0, 0, 0};

        int sumFactor = sumFactor(a);
        System.out.println("sum factor = " + sumFactor);
    }


    public static int sumFactor(int[] a) {
        if (a.length == 0)
            return 0;

        int sum = 0;
        int count = 0;

        for (int num : a) {
            sum += num;
        }

        for (int num : a) {
            if (num == sum) {
                count++;
            }
        }
        return count;
    }


    @Test
    public void sampleTest1() {
        int[] list = new int[]{3, 1, 2, 3, 1};
        int answer = calculateCenterElement(list);
        System.out.println(answer);
    }

    public int calculateCenterElement(int[] list) {
        if (list == null || list.length % 2 == 0) {
            return 0;
        }

        int centerElementIndex = list.length / 2;
        int middleValue = list[centerElementIndex];
        for (int i = 0; i < list.length; i++) {
            int integer = list[i];
            if (i != centerElementIndex) {
                if (middleValue >= integer) {
                    return 0;
                }
            }
        }
        return 1;
    }


    @Test
    public void sampleTest2() {
        int[] list = new int[]{};
        int answer = calculateSum(list);
        System.out.println(answer);
    }

    public int calculateSum(int[] a) {
        int sumOfEven = 0;
        int sumOfOdd = 0;
        for (int integer : a) {
            if (integer % 2 == 0) {
                sumOfEven = sumOfEven + integer;
            } else {
                sumOfOdd = sumOfOdd + integer;
            }
        }
        return sumOfOdd - sumOfEven;
    }

    @Test
    public void sampleTest3() {
        char[] list = new char[]{'a', 'b', 'c'};
        int start = 1;
        int len = 2;
        char[] answer = getCharArray(list, start, len);
        System.out.println(answer == null ? "null" : new String(answer));
    }


    public char[] getCharArray(char[] a, int start, int len) {
        if (start < 0 || len < 0 || start + len - 1 >= a.length)
            return null;
        char[] answer = new char[len];

        for (int i = start, j = 0; j < len; i++, j++) {
            answer[j] = a[i];
        }
        return answer;
    }

    @Test
    public void sampleTest4() {
        int answer = reverseNumber(12345);
        System.out.println(answer);
    }

    public int reverseNumber(int n) {
        int answer = 0;
        boolean isNegativeNumber = n < 0;
        while (isNegativeNumber ? n < 0 : n > 0) {
            answer = answer * 10 + (n % 10);
            n = n / 10;
        }
        return answer;
    }

    @Test
    public void sampleTest5() {
        int[] first = new int[]{};
        int[] second = new int[]{3, 4};

        int[] answer = commonArray(first, second);
        System.out.println(Arrays.toString(answer));
    }

    public int[] commonArray(int[] first, int[] second) {
        if (first == null || second == null)
            return null;

        int[] answer = new int[Math.min(first.length, second.length)];
        int index = 0;
        for (int f : first) {
            for (int s : second) {
                if (f == s) {
                    answer[index] = f;
                    index++;
                }
            }
        }


        return answer;
    }


}