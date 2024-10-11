package com.coursera.algotoolbox.week2;

import java.math.BigDecimal;
import java.util.Scanner;

public class FibonacciLastDigit {

  private static int getFibonacciLastDigitNaive(int n) {
    if (n <= 1)
      return n;

    int previous = 0;
    int current = 1;

    for (int i = 0; i < n - 1; ++i) {
      int tmp_previous = previous;
      previous = current;
      current = tmp_previous + current;
    }
    // System.out.println(current);
    return current % 10;
  }



  private static int calcFibFast(int n) {


    if (n <= 1) {
      return n;
    }
    BigDecimal previous = new BigDecimal(0);
    BigDecimal current = new BigDecimal(1);

    for (int i = 2; i <= n; i++) {
      BigDecimal temp = previous;
      previous = current;

      current = temp.add(current);
    }

    return current.remainder(new BigDecimal(10)).intValue();
  }

  private static int lastDigit(int n) {

    if (n <= 1) {
      return n;
    }

    int previous = 0;
    int current = 1;

    for (int i = 0; i < n - 1; ++i) {
      int tmp_previous = previous % 10;
      previous = current % 10;
      current = tmp_previous % 10 + current % 10;
    }

    return current % 10;

  }



  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    long start = System.currentTimeMillis();

    // int c = getFibonacciLastDigitNaive(n);
    int c1 = calcFibFast(n);
    int c2 = lastDigit(n);


    System.out.println(c2);
    long finish = System.currentTimeMillis();
    // System.out.println(finish - start);

  }
}

