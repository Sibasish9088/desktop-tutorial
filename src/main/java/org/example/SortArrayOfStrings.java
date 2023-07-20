package org.example;

import java.util.Arrays;

public class SortArrayOfStrings {

    public static void createSortedList(String[] listOfWords) {
        Arrays.sort(listOfWords, String.CASE_INSENSITIVE_ORDER);
        System.out.print("The sorted array of Strings is: ");
        System.out.print("[");
        for (String word : listOfWords) {
            if (word.equals(listOfWords[listOfWords.length-1]))
                System.out.print(word);
            else
                System.out.print(word + ", ");
        }
        System.out.print("]");
        System.out.println();
    }
}
