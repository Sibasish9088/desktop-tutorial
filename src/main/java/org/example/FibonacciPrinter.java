package org.example;

public class FibonacciPrinter {

    public static void printFibonacciUntil(long range) {
        int num1 = 0;
        int num2 = 1;
        int num3 = num1 + num2;
        System.out.print(num1 + " " + num2 + " " + num3 + " ");
        num1 = num2;
        num2 = num3;
        num3 = num1 + num2;
        while (num3 < range) {
            System.out.print(num3 + " ");
            num1 = num2;
            num2 = num3;
            num3 = num1 + num2;
        }
        System.out.println();
    }
}
