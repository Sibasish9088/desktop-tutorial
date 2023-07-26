package org.example;

import java.util.HashMap;

public class FrequencyChecker {

    public static HashMap<Integer, Integer> calculateFrequency(int[] listOfNumbers) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < listOfNumbers.length; i++) {
            if (frequencyMap.containsKey(listOfNumbers[i]))
                frequencyMap.put(listOfNumbers[i], frequencyMap.get(listOfNumbers[i])+1);
            else
                frequencyMap.put(listOfNumbers[i], 1);
        }
        return frequencyMap;
    }
}
