package org.example;

public class CheckIfOnlyOddNumbersInArray {

    public static boolean isOnlyOddArray(int[] numbers) {

        for (int number : numbers) {
            if(number % 2 == 0)
                return false;
        }
        return true;
    }
}
