package com.coursera.algotoolbox.week4;

import java.util.Arrays;

public class MergeSort {

  public static void main(String[] args) {
    int[] testArray = new int[] {5, 4, 3, 1, 2, 0, -1, -2};
    System.out.println("Initial Array is : " + Arrays.toString(testArray));
    int[] finalSortedArray = mergeSort(testArray, 0, testArray.length - 1);
    System.out.println("\nFinal sorted array :  " + Arrays.toString(finalSortedArray));
  }

  private static int[] mergeSort(int[] testArray, int low, int high) {

    int mid = (low + high) / 2;

    System.out.println("\nlow: " + low + " mid: " + mid + " high: " + high);
    System.out.print("Array: ");
    for (int i = low; i <= high; i++) {
      if (i != high) {
        System.out.print(testArray[i] + ", ");
      } else {
        System.out.print(testArray[i]);
      }
    }

    if (low < high) {

      // System.out.println("Mid : " + mid);
      mergeSort(testArray, low, mid);
      mergeSort(testArray, mid + 1, high);
      merge(testArray, low, high, mid);

    }

    return testArray;
  }

  private static void merge(int[] testArray, int low, int high, int mid) {

    // System.out.println();
    System.out.print("\nMerging the array: ");
    for (int i = low; i <= high; i++) {
      if (i != high) {
        System.out.print(testArray[i] + ", ");
      } else {
        System.out.print(testArray[i]);
      }
    }

    int n1 = mid - low + 1;
    int n2 = high - mid;

    // Create temp arrays
    int L[] = new int[n1];
    int R[] = new int[n2];

    // Copy data to temp arrays
    for (int i = 0; i < n1; ++i)
      L[i] = testArray[low + i];
    for (int j = 0; j < n2; ++j)
      R[j] = testArray[mid + 1 + j];

    // Merge the temp arrays

    // Initial indices of first and second subarrays
    int i = 0, j = 0;

    // Initial index of merged subarray array
    int k = low;
    while (i < n1 && j < n2) {
      if (L[i] <= R[j]) {
        testArray[k] = L[i];
        i++;
      } else {
        testArray[k] = R[j];
        j++;
      }
      k++;
    }

    // Copy remaining elements of L[] if any
    while (i < n1) {
      testArray[k] = L[i];
      i++;
      k++;
    }

    // Copy remaining elements of R[] if any
    while (j < n2) {
      testArray[k] = R[j];
      j++;
      k++;
    }

    /*
     * int[] leftArray = new int[mid - low + 1]; int[] rightArray = new int[high - mid];
     * 
     * for
     * 
     * int j = mid + 1; int k = low;
     */

    /*
     * System.out.println("\nfinal low mid and high : "+ low + " " + mid + " " + high);
     * 
     * 
     * 
     * 
     * 
     * while (k <= mid && j <= high) { if (testArray[k] > testArray[j]) { int temp = testArray[k];
     * testArray[k] = testArray[j]; testArray[j] = temp; j++; } else { k++;
     * 
     * }
     * 
     * }
     */

    System.out.print("\nAfter merging: ");
    for (int z = low; z <= high; z++) {
      if (z != high) {
        System.out.print(testArray[z] + ", ");
      } else {
        System.out.print(testArray[z]);
      }
    }

    // System.out.println("The array to merge: " + Arrays.toString(testArray));

  }

}
