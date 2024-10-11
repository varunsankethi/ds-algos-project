package com.coursera.algotoolbox.week6;

import java.util.Scanner;

public class Knapsack {
  static int optimalWeight(int W, int[] w) {
    // write you code here

    int itemRows = w.length + 1;
    int weightCols = W + 1;
    int[][] value = new int[itemRows][weightCols];

    // Initializing top row to 0 - meaning that if items are 0 then any weight would have 0 as the
    // max value
    for (int j = 0; j <= weightCols; j++) {
      value[0][j] = 0;
    }

    // Initializing 0th row as 0 - meaning that if weight is 0 then any number of items would result
    // in 0 value
    for (int i = 0; i <= itemRows; i++) {
      value[i][0] = 0;
    }

    // System.out.println();

    for (int i = 1; i <= itemRows; i++) {

      for (int weight = 1; weight <= weightCols; weight++) {

        value[i][weight] = value[i - 1][weight];
        if (w[i] <= weight) {
          int val = value[i - 1][weight] + w[i];
          if (val > value[i][weight]) {
            value[i][weight] = val;
          }
        }

      }

    }

    System.out.println(value[itemRows][weightCols]);

    int result = 0;
    /*
     * for (int i = 0; i < w.length; i++) { if (result + w[i] <= W) { result += w[i]; } }
     */
    return result;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int W, n;
    W = scanner.nextInt();
    n = scanner.nextInt();
    int[] w = new int[n];
    for (int i = 0; i < n; i++) {
      w[i] = scanner.nextInt();
    }
    System.out.println(optimalWeight(W, w));
  }
}
