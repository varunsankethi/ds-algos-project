package com.coursera.algotoolbox.week4;

import java.util.Scanner;

public class Inversions {

  private static long getNumberOfInversions(int[] a, int[] b, int left, int right) {
    long numberOfInversions = 0;
    if (right <= left) {
      return numberOfInversions;
    }
    int ave = (left + right) / 2;

    numberOfInversions += getNumberOfInversions(a, b, left, ave);
    numberOfInversions += getNumberOfInversions(a, b, ave + 1, right);
    // write your code here

    // countInversions(a, b, left, right, ave);

    /*
     * int i = left; int j = ave + 1; int k = left;
     * 
     * while (i <= ave && j <= right) {
     * 
     * if (a[i] <= a[j]) {
     * 
     * b[k] = a[i]; i++;
     * 
     * } else {
     * 
     * b[k] = a[j]; numberOfInversions = numberOfInversions + 1; j++; } k++;
     * 
     * }
     * 
     * while (i <= ave) { b[k] = a[i]; i++; k++; }
     * 
     * while (j <= right) { b[k] = a[j]; j++; k++; }
     * 
     * for (int z = left; z <= right; z++) { a[z] = b[z];
     * 
     * }
     */

    int n1 = ave - left + 1;
    int n2 = right - ave;

    // Create temp arrays
    int L[] = new int[n1];
    int R[] = new int[n2];

    // Copy data to temp arrays
    for (int i = 0; i < n1; ++i)
      L[i] = a[left + i];
    for (int j = 0; j < n2; ++j)
      R[j] = a[ave + 1 + j];

    // Merge the temp arrays

    // Initial indices of first and second subarrays
    int i = 0, j = 0;

    // Initial index of merged subarray array
    int k = left;
    while (i < n1 && j < n2) {
      if (L[i] <= R[j]) {
        if (a[k] < L[i]) {
          numberOfInversions++;
        }
        a[k] = L[i];
        i++;
      } else {
        a[k] = R[j];

        numberOfInversions++;
        j++;
      }
      k++;
    }

    // Copy remaining elements of L[] if any
    while (i < n1) {
      if (a[k] < L[i]) {
        numberOfInversions++;
      }

      a[k] = L[i];
      i++;
      k++;
    }

    // Copy remaining elements of R[] if any
    while (j < n2) {

      if (R[j] < a[k]) {
        numberOfInversions++;
      }
      a[k] = R[j];
      j++;
      k++;
    }

    return numberOfInversions;
  }

  private static void countInversions(int[] a, int[] b, int left, int right, int ave) {
    // TODO Auto-generated method stub

    // int[] leftArray =

  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = scanner.nextInt();
    }
    int[] b = new int[n];
    System.out.println(getNumberOfInversions(a, b, 0, a.length - 1));
  }
}
