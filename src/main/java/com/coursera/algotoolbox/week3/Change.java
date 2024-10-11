package com.coursera.algotoolbox.week3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Change {
  private static int getChange(int m) {

    List<Integer> denominations = new ArrayList<Integer>();
    int minNumberOfCoins = 0;
    denominations.add(10);
    denominations.add(5);
    denominations.add(1);

    while (m > 0) {

      int maxDenomination = denominations.get(0);

      while (m >= maxDenomination) {
        ++minNumberOfCoins;
        m = m - maxDenomination;
      }

      denominations.remove(0);

    }

    return minNumberOfCoins;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int m = scanner.nextInt();
    System.out.println(getChange(m));

  }
}
