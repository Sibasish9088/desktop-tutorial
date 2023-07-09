package org.example;

public class VowelPresenceChecker {

    public static boolean hasVowel(String enteredWord) {

        return enteredWord.toLowerCase().matches(".*[aeiou].*");
    }
}
