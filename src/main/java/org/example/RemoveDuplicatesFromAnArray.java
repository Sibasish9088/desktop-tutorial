package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesFromAnArray {

    public static ArrayList<Integer> returnDistinctListOfNumbersFrom(ArrayList<Integer> listOfNumbers) {
        Set<Integer> distinctSet = new HashSet<>(listOfNumbers);

        ArrayList<Integer> distinctList = new ArrayList<>(distinctSet);

        return distinctList;
    }
}
