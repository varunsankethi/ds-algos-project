package com.coursera.algotoolbox.week3;

import java.util.Scanner;

public class LargestNumber1 {

  private static String largestNumber(String[] a) {

    for (int i = 0; i < a.length; i++) {

      int maxInitialDigit = 0;
      int maxInitialDigitIndex = 0;

      for (int j = i; j < a.length; j++) {
        if (Integer.parseInt(a[j].substring(0, 1)) > maxInitialDigit) {
          maxInitialDigit = Integer.parseInt(a[j].substring(0, 1));
          maxInitialDigitIndex = j;

        }

      }

      // Assumption
      String maxNumberWithMaxDigit = getMaxNumberWithMaxDigit(maxInitialDigit);

      for (int k = i; k < a.length; k++) {

        if (!a[k].startsWith(String.valueOf(maxInitialDigit))) {
          continue;
        }

      }

    }

    String result = "";

    for (int i = 0; i < a.length; i++) {
      result += a[i];
    }

    return result;
  }

  private static String getMaxNumberWithMaxDigit(int maxInitialDigit) {

    return null;
  }

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    String[] a = new String[n];
    for (int i = 0; i < n; i++) {
      a[i] = scanner.next();
    }
    if (a.length > 0) {
      System.out.println(largestNumber(a));
    }

  }

}
