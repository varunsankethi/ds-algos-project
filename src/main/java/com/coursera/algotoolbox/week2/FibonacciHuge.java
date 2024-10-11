package com.coursera.algotoolbox.week2;

import java.util.Scanner;

public class FibonacciHuge {
  private static long getFibonacciHugeNaive(long n, long m) {
    if (n <= 1)
      return n;

    long previous = 0;
    long current = 1;

    for (long i = 0; i < n - 1; ++i) {
      long tmp_previous = previous;
      previous = current;
      current = tmp_previous + current;
    }

    System.out.println(current);
    return current % m;
  }


  private static long getFibonacciLastDigitHugeFast(long n, long m) {

    if (n <= 1) {
      return n;
    }

    long previous = 0;
    long current = 1;

    for (int i = 0; i < n - 1; ++i) {
      long tmp_previous = previous % m;
      previous = current % m;
      current = tmp_previous % m + current % m;
    }

    return current % m;
  }


  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    long n = scanner.nextLong();
    long m = scanner.nextLong();
    System.out.println(getFibonacciHugeNaive(n, m));
    // System.out.println(getFibonacciLastDigitHugeFast(n, m));
  }
}

