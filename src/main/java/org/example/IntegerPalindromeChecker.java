package org.example;

public class IntegerPalindromeChecker {

    public static boolean isPalindrome(long number) {

        long probablePalindrome = 0;
        long archivedNumber = number;

        while (number/10 != 0) {
            probablePalindrome = (probablePalindrome * 10) + (number % 10);
            number = number/10;
        }

        probablePalindrome = (probablePalindrome * 10) + (number % 10);

        return probablePalindrome == archivedNumber;
    }
}
