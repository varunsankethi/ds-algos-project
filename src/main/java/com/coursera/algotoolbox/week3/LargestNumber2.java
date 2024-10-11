package com.coursera.algotoolbox.week3;

import java.util.Arrays;
import java.util.Scanner;

public class LargestNumber2 {

  private static String largestNumber(String[] a) {

    for (int i = 0; i < a.length; i++) {

      System.out.println("====");
      System.out.println("I = " + i);

      int maxInitialDigit = -1;

      for (int j = i; j < a.length; j++) {
        if (Integer.parseInt(a[j].substring(0, 1)) > maxInitialDigit) {
          maxInitialDigit = Integer.parseInt(a[j].substring(0, 1));
        }
      }
      System.out.println("maxInitialDigit : " + maxInitialDigit);

      String maxNumberFromMaxDigit = "-1";
      int maxNumberFromMaxDigitIndex = i;

      System.out.println(" >>>> " + Arrays.toString(a));
      for (int n = i; n < a.length; n++) {
        if (a[n].startsWith(String.valueOf(maxInitialDigit))
            && Integer.parseInt(a[n]) > Integer.parseInt(maxNumberFromMaxDigit)) {
          maxNumberFromMaxDigit = a[n];
          maxNumberFromMaxDigitIndex = n;

        }
      }

      System.out.println("maxNumberFromMaxDigit : " + maxNumberFromMaxDigit);
      System.out.println("maxNumberFromMaxDigitIndex : " + maxNumberFromMaxDigitIndex);

      for (int k = i; k < a.length; k++) {

        if (a[k].equals(maxNumberFromMaxDigit)
            || !a[k].startsWith(String.valueOf(maxInitialDigit))) {
          System.out.println("skipping");
          continue;
        } else {

          System.out.println("Processing k = " + k);

          int secondMostSignificantKth = -1;
          int secondMostSignificantMax = -1;
          int maxModofKthNumber = a[k].length() - 1;
          int maxModOfMaxNumber = maxNumberFromMaxDigit.length() - 1;

          int subStringStartKth = a[k].length() == 1 ? 0 : 1;
          int subStringStartMax = maxNumberFromMaxDigit.length() == 1 ? 0 : 1;

          int subStringLenKth = a[k].length();
          int subStringLenMax = maxNumberFromMaxDigit.length();

          // while()

          do {

            /*
             * if (subStringStartKth == 0) { secondMostSignificantKth =
             * Integer.parseInt(a[k].substring(0)); } else { secondMostSignificantKth =
             * Integer.parseInt(a[k].substring(subStringStartKth, subStringStartKth + 1)); }
             * 
             * if (subStringStartMax == 0) { secondMostSignificantMax =
             * Integer.parseInt(maxNumberFromMaxDigit.substring(0)); } else {
             * secondMostSignificantKth = Integer.parseInt(
             * maxNumberFromMaxDigit.substring(subStringStartMax, subStringStartMax + 1)); }
             */

            if (maxModofKthNumber == 0) {
              secondMostSignificantKth = Integer.parseInt(a[k]);
            } else {
              secondMostSignificantKth =
                  (int) (Integer.parseInt(a[k]) % Math.pow(10, maxModofKthNumber));
              secondMostSignificantKth =
                  Integer.parseInt(String.valueOf(secondMostSignificantKth).substring(0, 1));
            }

            if (maxModOfMaxNumber == 0) {
              secondMostSignificantMax = Integer.parseInt(maxNumberFromMaxDigit);
            } else {
              secondMostSignificantMax =
                  (int) (Integer.parseInt(maxNumberFromMaxDigit) % Math.pow(10, maxModOfMaxNumber));
              secondMostSignificantMax =
                  Integer.parseInt(String.valueOf(secondMostSignificantMax).substring(0, 1));
            }

            System.out.println("secondMostSignificantMax: " + secondMostSignificantMax);
            System.out.println("secondMostSignificantKth: " + secondMostSignificantKth);

            if (secondMostSignificantKth > secondMostSignificantMax) {
              maxNumberFromMaxDigit = a[k];
              maxNumberFromMaxDigitIndex = k;
              // swap = true;
            }

            --maxModofKthNumber;
            --maxModOfMaxNumber;

          } while (maxModofKthNumber > 0 || maxModOfMaxNumber > 0);

        }

      }

      String temp = a[i];
      a[i] = maxNumberFromMaxDigit;
      // a[i] = a[maxNumberFromMaxDigitIndex];
      a[maxNumberFromMaxDigitIndex] = temp;

      System.out.println(Arrays.toString(a));

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
