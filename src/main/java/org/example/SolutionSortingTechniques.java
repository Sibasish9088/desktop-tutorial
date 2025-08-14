package org.example;

import java.util.Arrays;

public class SolutionSortingTechniques {

    /*
     * Numeric Array Sorting Techniques
     *
     * This is a solution demonstrated with:
     * 1. Bubble Sort
     * 2. Insertion Sort
     * 3. Merge Sort Techniques
     * 4. Arrays.sort() - Tim Sort (a combination of Merge and Insertion sort)
     *
     */

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 27, 10, 92, 2, 100, 39, 69, 17, 3, 72, 722, 94, 105};
        double startTime, endTime;
        double TIME_DIVIDER = 1000.0;

        printArray(arr);

        int[] bubbleArray = arr.clone();
        int[] insertionArray = arr.clone();
        int[] mergeArray = arr.clone();
        
        startTime = System.nanoTime();
        bubbleSort(bubbleArray);
        endTime = System.nanoTime();
        printArray(bubbleArray, "Bubble Sort");
        System.out.println("Time Taken : " + ((endTime - startTime) / TIME_DIVIDER) + " \u03BCs");

        startTime = System.nanoTime();
        insertionSort(insertionArray);
        endTime = System.nanoTime();
        printArray(insertionArray, "Insertion Sort");
        System.out.println("Time Taken : " + ((endTime - startTime) / TIME_DIVIDER) + " \u03BCs");

        startTime = System.nanoTime();
        mergeSort(mergeArray, 0, mergeArray.length - 1);
        endTime = System.nanoTime();
        printArray(mergeArray, "Merge Sort");
        System.out.println("Time Taken : " + ((endTime - startTime) / TIME_DIVIDER) + " \u03BCs");

        startTime = System.nanoTime();
        Arrays.sort(arr);
        endTime = System.nanoTime();
        printArray(arr, "Tim Sort (Java util Arrays.sort())");
        System.out.println("Time Taken : " + ((endTime - startTime) / TIME_DIVIDER) + " \u03BCs");
    }

    private static void mergeSort(int[] mergeArray, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(mergeArray, left, mid);
            mergeSort(mergeArray, mid + 1, right);
            merge(mergeArray, left, mid, right);
        }
    }

    private static void merge(int[] mergeArray, int left, int mid, int right) {
        int n1 = mid + 1 - left;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = mergeArray[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = mergeArray[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (L[i] < R[j]) {
                mergeArray[k] = L[i];
                i++;
            } else {
                mergeArray[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            mergeArray[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            mergeArray[k] = R[j];
            j++;
            k++;
        }
    }

    private static void insertionSort(int[] insertionArray) {
        int n = insertionArray.length;

        for (int i = 1; i < n; i++) {
            int key = insertionArray[i];
            int j = i - 1;

            while (j >= 0 && insertionArray[j] > key) {
                insertionArray[j + 1] = insertionArray[j];
                j--;
            }
            insertionArray[j + 1] = key;
        }
    }

    private static void bubbleSort(int[] bubbleArray) {
        int n = bubbleArray.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (bubbleArray[j] > bubbleArray[j + 1]) {
                    int temp = bubbleArray[j];
                    bubbleArray[j] = bubbleArray[j + 1];
                    bubbleArray[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    private static void printArray(int[] arr) {
        System.out.print("Before Sorting : [ ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.print("]");
        System.out.println();
    }

    private static void printArray(int[] arr, String sortingTechnique) {
        System.out.print("After Sorting using " + sortingTechnique + " : [ ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.print("]");
        System.out.println();
    }
}
