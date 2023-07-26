package org.example;

import java.util.HashMap;

public class FrequencyChecker {

    public static HashMap<Integer, Integer> calculateFrequency(int[] listOfNumbers) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int listOfNumber : listOfNumbers) {
            if (frequencyMap.containsKey(listOfNumber))
                frequencyMap.put(listOfNumber, frequencyMap.get(listOfNumber) + 1);
            else
                frequencyMap.put(listOfNumber, 1);
        }
        return frequencyMap;
    }
}
