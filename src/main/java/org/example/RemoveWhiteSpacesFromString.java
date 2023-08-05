package org.example;

public class RemoveWhiteSpacesFromString {

    public static String removeWhiteSpacesFrom(String irregularString) {
        String[] normalizedStringBits = irregularString.split(" ");
        String regularString = "";
        if (normalizedStringBits[0].equals(irregularString) && normalizedStringBits.length == 1)
            return null;
        for (String normalizedStringBit : normalizedStringBits) {
            regularString = regularString.concat(normalizedStringBit);
        }
        return regularString;
    }
}
