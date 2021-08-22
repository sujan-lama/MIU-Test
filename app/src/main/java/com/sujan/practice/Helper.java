package com.sujan.practice;

public class Helper {
    public static boolean isNumberPrime(int n) {
        if (n <= 1) return false;

        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static int nextPrimeNumber(int n) {
        int count = n + 1;

        while (true) {
            if (isNumberPrime(count)) {
                return count;
            }
            count++;
        }
    }

    public static int nfactorial(int a) {
        if (a == 0) {
            return 0;
        }

        int sum = 1;
        for (int i = a; i > 0; i--) {
            sum = sum * i;
        }
        return sum;
    }

    public static boolean arrayContains(int[] a, int n) {
        for (int value : a) {
            if (value == n) return true;
        }
        return false;
    }
}
