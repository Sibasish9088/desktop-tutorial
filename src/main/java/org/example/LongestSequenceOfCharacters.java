package org.example;

import java.util.HashSet;
import java.util.Set;

public class LongestSequenceOfCharacters {

    public static String findLongestSequenceOfCharacters(String enteredWord) {

        String longestSequence = "";
        Set<String> sequence = new HashSet<>();

        for (int i = 0; i < enteredWord.length(); i++) {
            sequence.add(String.valueOf(enteredWord.charAt(i)));
        }

        for (String letter : sequence) {
            longestSequence = longestSequence.concat(letter);
        }
        return longestSequence;
    }
}
