package org.example;

public class PrimeNumberChecker {

    public static boolean isAPrimeNumber(long number) {

        if (number < 2) return false;
        else if (number == 2) return true;
        else {
            for (int i = 3; i <= number/2; i++) {
                if (number % i == 0) return false;
            }
        }
        return true;
    }
}
