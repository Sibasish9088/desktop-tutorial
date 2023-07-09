package org.example;

public class PalindromeCheckHelper {

    public static boolean palindromeCheck(String enteredWord) {

        String reversedWord = "";

        for (int i = enteredWord.length()-1; i > -1; i--) {
            reversedWord = reversedWord.concat(String.valueOf(enteredWord.charAt(i)));
        }
        System.out.println("Reversed word: " + reversedWord);

        return reversedWord.equalsIgnoreCase(enteredWord);
    }
}
