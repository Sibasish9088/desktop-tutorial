package org.example;

import java.util.ArrayList;
import java.util.Scanner;

import static org.example.FindNLargestNumbersFromArray.returnTwoMaxesFromArrayOf;
import static org.example.IntegerPalindromeChecker.isPalindrome;
import static org.example.LongestSequenceOfCharacters.findLongestSequenceOfCharacters;
import static org.example.PrimeNumberChecker.isAPrimeNumber;
import static org.example.RemoveDuplicatesFromAnArray.returnDistinctListOfNumbersFrom;
import static org.example.SortArrayOfStrings.createSortedList;
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
            System.out.println("5. Find Two max numbers from Array");
            System.out.println("6. Remove Duplicate numbers from Array");
            System.out.println("7. Sort Array of Strings in case");
            System.out.println();
            System.out.print("Please enter a number to select the corresponding example: ");
            int option = program.nextInt();
            System.out.println();
            switch (option) {
                case 1 -> {
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
                }
                case 2 -> {
                    System.out.print("Enter a word: ");
                    String word = program.next();
                    System.out.println();
                    System.out.println("The longest sequence of characters in "
                            + word + " is " + findLongestSequenceOfCharacters(word));
                    System.out.print("To continue, please press 'y' and to exit press 'n' : ");
                    choice = program.next();
                }
                case 3 -> {
                    System.out.print("Enter a number: ");
                    long num = program.nextLong();
                    System.out.println();
                    if (isAPrimeNumber(num)) System.out.println(num + "is a Prime number");
                    else System.out.println(num + "is not a Prime number");
                    System.out.print("To continue, please press 'y' and to exit press 'n' : ");
                    choice = program.next();
                }
                case 4 -> {
                    System.out.print("Enter a word: ");
                    String term = program.next();
                    System.out.println();
                    if (hasVowel(term)) System.out.println(term + " has one or more vowels in it");
                    else System.out.println(term + " has no vowel in it");
                    System.out.print("To continue, please press 'y' and to exit press 'n' : ");
                    choice = program.next();
                }
                case 5 -> {
                    ArrayList<Integer> listOfNumbers = new ArrayList<>();
                    String addMoreChoice = "Y";
                    int newNumber;
                    while (!addMoreChoice.equalsIgnoreCase("N")) {
                        System.out.println("Enter the array of numbers:");
                        System.out.print("new number to add to list: ");
                        newNumber = program.nextInt();
                        listOfNumbers.add(newNumber);
                        System.out.println();
                        System.out.print("Do you wish to continue adding numbers to the list? (y/n): ");
                        addMoreChoice = program.next();
                    }
                    System.out.println();
                    System.out.println("Your entered array of numbers is: [");
                    for (int no : listOfNumbers) {
                        System.out.print(no + ", ");
                    }
                    System.out.print("]");
                    System.out.println();
                    System.out.println("Please wait while we fetch the two maxes from the list of numbers");
                    int[] maxArray = returnTwoMaxesFromArrayOf(listOfNumbers);
                    System.out.println("The two maxes are: ");
                    System.out.println("First Max Number = " + maxArray[0]);
                    System.out.println("Second Max Number = " + maxArray[1]);
                }

                case 6 -> {
                    ArrayList<Integer> list = new ArrayList<>();
                    String addMore = "Y";
                    int newNo;
                    while (!addMore.equalsIgnoreCase("N")) {
                        System.out.println("Enter the array of numbers:");
                        System.out.print("new number to add to list: ");
                        newNo = program.nextInt();
                        list.add(newNo);
                        System.out.println();
                        System.out.print("Do you wish to continue adding numbers to the list? (y/n): ");
                        addMore = program.next();
                    }
                    System.out.println();
                    System.out.print("Your entered array of numbers is: [");
                    for (int no : list) {
                        if (no == list.get(list.size()-1))
                            System.out.print(no);
                        else
                            System.out.print(no + ", ");
                    }
                    System.out.print("]");
                    System.out.println();
                    System.out.println("Please wait while we remove the duplicates from the list");
                    ArrayList<Integer> distinctListOfNumbers = returnDistinctListOfNumbersFrom(list);
                    if (distinctListOfNumbers.size() == list.size())
                        System.out.println("There were no duplicates in the entered List");
                    else
                        System.out.println(list.size() - distinctListOfNumbers.size()
                                + " duplicate numbers were removed from the list");
                    System.out.print("The list of distinct numbers is: {");
                    for (int num : distinctListOfNumbers) {
                        if (num == distinctListOfNumbers.get(distinctListOfNumbers.size()-1))
                            System.out.print(num);
                        else
                            System.out.print(num + ", ");
                    }
                    System.out.print("}");
                    System.out.println();
                }

                case 7 -> {
                    System.out.println();
                    System.out.print("Please enter the number of words yo want in the Array: ");
                    int count = program.nextInt();
                    System.out.println();
                    String[] listOfWords = new String[count];
                    System.out.println("Please enter " + count + " words to add to the Array: ");
                    for (int i = 0; i < count; i++) {
                        System.out.print("word" + i + ": ");
                        listOfWords[i] = program.next();
                    }
                    System.out.println();
                    System.out.print("You have entered the following array of words: [");
                    for (String word : listOfWords) {
                        if (word.equalsIgnoreCase(listOfWords[listOfWords.length-1]))
                            System.out.print(word);
                        else
                            System.out.print(word + ", ");
                    }
                    System.out.print("]");
                    System.out.println();
                    System.out.println("Please wait while we process the sorted array");
                    System.out.println("Printing the sorted array of words");
                    createSortedList(listOfWords);
                }

                default -> {
                    System.out.println();
                    System.out.print("That does not look like a feature we have yet." +
                            "To continue press Y and to exit press N : ");
                    choice = program.next();
                }
            }
        }
    }
}
