package org.example;

public class FactorialOfAnInteger {

    public static int calculateFactorialOf(int number) {
        int fact = 1;
        for (int i = number; i > 0; i--)
            fact = fact * i;
        return fact;
    }
}
