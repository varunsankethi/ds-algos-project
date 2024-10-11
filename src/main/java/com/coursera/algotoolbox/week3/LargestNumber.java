package com.coursera.algotoolbox.week3;

import java.util.Arrays;
import java.util.Scanner;

public class LargestNumber {
  private static String largestNumber(String[] a) {

    // write your code here

    for (int i = 0; i < a.length; i++) {
      int maxInitialDigit = 0;
      String maxNumber = a[i];
      int maxNumberIndex = 0;

      for (int j = i; j < a.length; j++) {
        if (Integer.parseInt(a[j].substring(0, 1)) >= maxInitialDigit) {
          maxInitialDigit = Integer.parseInt(a[j].substring(0, 1));
          maxNumber = a[j];
          maxNumberIndex = j;
        }

      }

      /*
       * for (int n = i; n < a.length; n++) { if (a[n].startsWith(String.valueOf(maxInitialDigit))
       * && Integer.parseInt(a[n]) >= Integer.parseInt(maxNumber)) { maxNumber = a[n];
       * maxNumberIndex = n; } }
       */

      for (int k = i; k < a.length; k++) {

        /*
         * if (a[k].startsWith(String.valueOf(maxInitialDigit)) && !a[i].equals(maxNumber) &&
         * a[k].length() == 1) { String temp = a[i]; a[i] = a[k]; a[k] = temp; break;
         * 
         * } else {
         */

        // This means there is more than 1 digit
        // Calculting max initial digit here and max number

        int checkNumberInt = Integer.parseInt(a[k]);
        int checkNumberMaxPower = a[k].length() - 1;
        int maxNumberMaxPower = maxNumber.length() - 1;
        int maxNumberInt = Integer.parseInt(maxNumber);

        System.out.println("========");
        System.out.println("I = " + i);
        System.out.println("Max Initial digit: " + maxInitialDigit);
        System.out.println("Max number: " + maxNumber);
        System.out.println("Max number index: " + maxNumberIndex);
        System.out.println("Check Number: " + checkNumberInt);
        System.out.println("Check Number Max Power: " + checkNumberMaxPower);
        System.out.println("Max Number: " + maxNumberInt);
        System.out.println("Max Number Max Power: " + maxNumberMaxPower);

        if (checkNumberMaxPower == 0) {
          checkNumberMaxPower = 1;
        }

        if (maxNumberMaxPower == 0) {
          maxNumberMaxPower = 1;
        }

        while (checkNumberMaxPower > 0 && maxNumberMaxPower > 0) {

          int smallerCheckNumber = (int) (checkNumberInt % Math.pow(10, checkNumberMaxPower));
          int smallerMaxNumber = (int) (maxNumberInt % Math.pow(10, maxNumberMaxPower));

          int smallerCheckNumberFirstVal =
              Integer.parseInt(String.valueOf(smallerCheckNumber).substring(0, 1));
          int smallerMaxNumberFirstVal =
              Integer.parseInt(String.valueOf(smallerMaxNumber).substring(0, 1));

          System.out.println("Smaller Check number first val : " + smallerCheckNumberFirstVal);
          System.out.println("Smaller Max number first val : " + smallerMaxNumberFirstVal);

          if (smallerCheckNumberFirstVal > smallerMaxNumberFirstVal) {

            // Swapping the ith element with the max number
            System.out.println("Check number greater");

            if (!a[i].equals(a[k])) {
              String temp = a[i];
              a[i] = a[k];
              a[maxNumberIndex] = temp;
              maxNumberIndex = i;
              maxNumber = a[i];
            }

          }

          if (smallerMaxNumberFirstVal > smallerCheckNumberFirstVal) {

            System.out.println("Check number not greater");

            System.out.println("A[i] : " + a[i]);
            System.out.println("A[k]: " + a[k]);
            System.out.println("A[maxNumberIndex] : " + a[maxNumberIndex]);

            if (!a[i].equals(a[k])) {
              String temp = a[i];
              a[i] = a[maxNumberIndex];
              a[maxNumberIndex] = temp;
              maxNumberIndex = i;
              maxNumber = a[i];
            }

          }

          System.out.println(Arrays.toString(a));

          checkNumberMaxPower--;
          maxNumberMaxPower--;

        }

      }

    }

    String result = "";

    for (int i = 0; i < a.length; i++) {
      result += a[i];
    }

    return result;
  }

  private static void swap(String[] a, int k, int i) {
    // TODO Auto-generated method stub

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
