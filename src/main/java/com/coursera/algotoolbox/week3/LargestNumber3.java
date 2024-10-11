package com.coursera.algotoolbox.week3;

import java.util.Scanner;

public class LargestNumber3 {

  private static String largestNumber(String[] a) {

    for (int i = 0; i < a.length; i++) {

      int num = Integer.parseInt(a[i]);
      a[i] = String.valueOf(num);

    }

    for (int i = 0; i < a.length; i++) {

      int maxInitialDigit = -1;

      for (int j = i; j < a.length; j++) {
        if (Integer.parseInt(a[j].substring(0, 1)) > maxInitialDigit) {
          maxInitialDigit = Integer.parseInt(a[j].substring(0, 1));
        }
      }

      String maxNumberFromMaxDigit = "-1";
      int maxNumberFromMaxDigitIndex = i;

      for (int n = i; n < a.length; n++) {
        if (a[n].startsWith(String.valueOf(maxInitialDigit))
            && Integer.parseInt(a[n]) > Integer.parseInt(maxNumberFromMaxDigit)) {
          maxNumberFromMaxDigit = a[n];
          maxNumberFromMaxDigitIndex = n;
        }
      }

      for (int k = i; k < a.length; k++) {

        if (a[k].equals(maxNumberFromMaxDigit)
            || !a[k].startsWith(String.valueOf(maxInitialDigit))) {
          continue;
        } else {

          int stringLenKth = a[k].length();
          int stringLenMaxNum = maxNumberFromMaxDigit.length();

          int kthCounter = 0;
          int maxCounter = 0;

          int kthDigit = -1;
          int maxNumDigit = -1;

          while (kthCounter <= (stringLenKth - 1) || maxCounter <= (stringLenMaxNum - 1)) {

            if (kthCounter < stringLenKth) {
              kthDigit = Integer.parseInt(a[k].substring(kthCounter, kthCounter + 1));
            } else {

              kthDigit = Integer.parseInt(a[k].substring(0, 1));
            }

            if (maxCounter < stringLenMaxNum) {
              maxNumDigit =
                  Integer.parseInt(maxNumberFromMaxDigit.substring(maxCounter, maxCounter + 1));
            } else {
              maxNumDigit = Integer.parseInt(maxNumberFromMaxDigit.substring(0, 1));
            }

            if (kthDigit > maxNumDigit) {
              maxNumberFromMaxDigit = a[k];
              maxNumberFromMaxDigitIndex = k;
              break;
            }

            if (kthCounter < stringLenKth) {
              ++kthCounter;
            }

            if (maxCounter < stringLenMaxNum) {
              ++maxCounter;
            }

          }

        }

      }
      String temp = a[i];
      a[i] = a[maxNumberFromMaxDigitIndex];
      a[maxNumberFromMaxDigitIndex] = temp;

    }

    String result = "";

    for (int i = 0; i < a.length; i++) {
      result += a[i];
    }

    return result;

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
