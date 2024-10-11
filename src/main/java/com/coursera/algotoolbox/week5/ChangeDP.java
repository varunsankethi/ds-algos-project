package com.coursera.algotoolbox.week5;

import java.util.Scanner;

public class ChangeDP {
  private static int getChange(int m) {
    // write your code here

    // This is the array that holds all the values from 0 to money
    int[] minNumberOfCoinsArray = new int[m + 1];
    int[] denominations = new int[] {1, 3, 4};
    minNumberOfCoinsArray[0] = 0;

    for (int money = 1; money <= m; money++) {

      minNumberOfCoinsArray[money] = Integer.MAX_VALUE;

      for (int deno : denominations) {

        if (money >= deno) {
          int numberOfCoins = minNumberOfCoinsArray[money - deno] + 1;
          if (numberOfCoins < minNumberOfCoinsArray[money]) {
            minNumberOfCoinsArray[money] = numberOfCoins;

          }

        }

      }

    }

    return minNumberOfCoinsArray[m];
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int m = scanner.nextInt();
    System.out.println(getChange(m));

  }
}
