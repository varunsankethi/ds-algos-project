package com.coursera.algotoolbox.week4;

import java.util.Arrays;

public class IterativePolynomialMultiplication {

  public static void main(String[] args) {

    int[] a = new int[3];
    int[] b = new int[3];

    a[0] = 3;
    a[1] = 2;
    a[2] = 5;

    b[0] = 5;
    b[1] = 1;
    b[2] = 2;

    int[] result = iterativePolynomialMultiplication(a, b);
    System.out.println(Arrays.toString(result));

  }

  public static int[] iterativePolynomialMultiplication(int[] a, int[] b) {

    // Here we are assuming that a and b are of the same degree.
    // if they are not we append 0 coefficients to the missing terms.

    int finalArrayLen = (2 * a.length) - 1;

    int[] product = new int[finalArrayLen];

    int[][] pair = new int[3][3];

    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < b.length; j++) {

        int value = a[i] * b[j];

        pair[i][j] = value;

      }
    }

    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < b.length; j++) {

        product[i + j] = product[i + j] + pair[i][j];

      }
    }

    return product;

  }

}
