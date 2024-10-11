package com.coursera.algotoolbox.week2;

import java.math.BigDecimal;
import java.util.Scanner;

public class FibonacciBigDecimal {

  private static BigDecimal calcFibFast(int n) {

    BigDecimal[] fibArray = new BigDecimal[n + 1];

    fibArray[0] = new BigDecimal(0);
    fibArray[1] = new BigDecimal(1);

    for (int i = 2; i <= n; i++) {
      fibArray[i] = fibArray[i - 1].add(fibArray[i - 2]);
    }

    return fibArray[n];
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    System.out.println(calcFibFast(n).toString());
  }

}
