package org.example;

public class Solution {

    public static void main(String[] args) {
        System.out.println("New Words after merging abc and pqr: " + mergeWords("abc", "pqr"));
        System.out.println("New Words after merging ab and pqrs: " + mergeWords("ab", "pqrs"));
        System.out.println("New Words after merging abcd and pq: " + mergeWords("abcd", "pq"));
    }

    /* Merge Strings Alternately
     * --------------------------------------------------
     *  Problem Statement:
     * Given two strings word1 and word2
     * merge the two strings such that
     * newWord made by alternating concatenation
     * of characters in word1 and word2
     * will bring the result as "wwoorrdd12".
     *
     * In case the word lengths do not match
     * for word1 and wrd2 the result should be
     * something like : "wworrdd21"
     * meaning that the merge always starts with
     * the characters from word1 and only the remaining
     * characters from the greater length string
     * need to be appended to the newWord.
     * --------------------------------------------------
     */

    public static String mergeWords(String word1, String word2) {

        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;

        // This code logic satisfies when both word lengths are equal
        while (i < word1.length() && j < word2.length()) {
            sb.append(word1.charAt(i++));
            sb.append(word2.charAt(j++));
        }

        // This additional code logic covers the scenarios where the word lengths are variable
        if (i < word1.length()) sb.append(word1.substring(i));
        if (j < word2.length()) sb.append(word2.substring(j));

        return sb.toString();
    }

}
