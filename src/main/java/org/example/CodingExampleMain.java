package org.example;

import java.util.Scanner;

import static org.example.IntegerPalindromeChecker.isPalindrome;
import static org.example.LongestSequenceOfCharacters.findLongestSequenceOfCharacters;
import static org.example.PrimeNumberChecker.isAPrimeNumber;
import static org.example.VowelPresenceChecker.hasVowel;

public class CodingExampleMain {

    public static void main(String[] args) {
        Scanner program = new Scanner(System.in);
        String  choice;
        System.out.println("Welcome to our small set of Basic Java programming Examples");
        System.out.print("To continue, please press 'y' and to exit press 'n' : ");
        choice = program.next();

        while(choice.equalsIgnoreCase("Y")) {
            System.out.println("Please select the example you wish to run: ");
            System.out.println("1. Integer Palindrome Checker");
            System.out.println("2. Longest Sequence of Characters");
            System.out.println("3. Prime Number Checker");
            System.out.println("4. Vowel Presence Checker");
            System.out.println();
            System.out.print("Please enter a number to select the corresponding example: ");
            int option = program.nextInt();
            System.out.println();
            switch (option) {
                case 1:
                    System.out.print("Enter a number: ");
                    long number = program.nextLong();
                    System.out.println();
                    if (isPalindrome(number)) {
                        System.out.println(number + "is a palindrome");
                    } else {
                        System.out.println(number + "is not a palindrome");
                    }
                    System.out.print("To continue, please press 'y' and to exit press 'n' : ");
                    choice = program.next();
                    break;

                case 2:
                    System.out.print("Enter a word: ");
                    String word = program.next();
                    System.out.println();
                    System.out.println("The longest sequence of characters in "
                            + word + " is " + findLongestSequenceOfCharacters(word));
                    System.out.print("To continue, please press 'y' and to exit press 'n' : ");
                    choice = program.next();
                    break;

                case 3:
                    System.out.print("Enter a number: ");
                    long num = program.nextLong();
                    System.out.println();
                    if (isAPrimeNumber(num)) System.out.println(num + "is a Prime number");
                    else System.out.println(num + "is not a Prime number");
                    System.out.print("To continue, please press 'y' and to exit press 'n' : ");
                    choice = program.next();
                    break;

                case 4:
                    System.out.print("Enter a word: ");
                    String term = program.next();
                    System.out.println();
                    if (hasVowel(term)) System.out.println(term + " has one or more vowels in it");
                    else System.out.println(term + " has no vowel in it");
                    System.out.print("To continue, please press 'y' and to exit press 'n' : ");
                    choice = program.next();
                    break;

                default:
                    System.out.println();
                    System.out.print("That does not look like a feature we have yet." +
                            "To continue press Y and to exit press N : ");
                    choice = program.next();
                    break;
            }
        }
    }
}
