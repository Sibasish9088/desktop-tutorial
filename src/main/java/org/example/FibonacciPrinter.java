package org.example;

public class FibonacciPrinter {

    public static void printFibonacciUntil(long range) {
        int num1 = 0;
        int num2 = 1;
        int num3 = num1 + num2;
        int count = 0;

        while (num3 < range) {
            count++;
            num1 = num2;
            num2 = num3;
            num3 = num1 + num2;
        }

        num1 = 0;
        num2 = 1;
        num3 = num1 + num2;
        System.out.println("There are " + count + 2  + " fibonacci terms within " + range);
        System.out.print(num1 + " " + num2 + " " + num3 + " ");
        for (int i = 2; i <= count; i++) {
            num1 = num2;
            num2 = num3;
            num3 = num1 + num2;
            System.out.print(num3 + " ");
        }
        System.out.println();
    }
}
