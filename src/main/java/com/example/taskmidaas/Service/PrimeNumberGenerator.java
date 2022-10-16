package com.example.taskmidaas.Service;

import org.springframework.stereotype.Service;

@Service
public class PrimeNumberGenerator {
    //    Time complexity: O(sqrt(n))
    public static boolean isPrimeUsingLoop(int n) {
        if (n <= 1)
            return false;
        if (n == 2 || n == 3)
            return true;
        if (n % 2 == 0 || n % 3 == 0)
            return false;
        for (int i = 5; i <= Math.sqrt(n); i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        return true;
    }

    //  Time complexity:  O(N)
    public static boolean isPrimeUsingRecurrsion(int n, int i) {
        if (n <= 2)
            return (n == 2) ? true : false;
        if (n % i == 0)
            return false;
        if (i * i > n)
            return true;

        return isPrimeUsingRecurrsion(n, i + 1);
    }
}

