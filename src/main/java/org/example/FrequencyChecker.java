package org.example;

import java.util.HashMap;

public class FrequencyChecker {

    public static HashMap<Integer, Integer> calculateFrequency(int[] listOfNumbers) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int number : listOfNumbers) {
            if (frequencyMap.containsKey(number))
                frequencyMap.put(number, frequencyMap.get(number) + 1);
            else
                frequencyMap.put(number, 1);
        }
        return frequencyMap;
    }
}
