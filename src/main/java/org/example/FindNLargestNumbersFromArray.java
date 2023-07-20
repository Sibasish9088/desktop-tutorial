package org.example;

import java.util.ArrayList;

public class FindNLargestNumbersFromArray {

    public static int[] returnTwoMaxesFromArrayOf(ArrayList<Integer> inputArray) {

        int[] maxArray = new int[2];
        for (int num : inputArray) {
            if (maxArray[0] < num) {
                maxArray[1] = maxArray[0];
                maxArray[0] = num;
            } else if (maxArray[1] < num) {
                maxArray[1] = num;
            }
        }
        return maxArray;
    }
}
