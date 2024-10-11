package com.coursera.algotoolbox.week2;

import java.math.BigDecimal;
import java.util.Scanner;

public class LCM {

  private static long lcm_naive(int a, int b) {

    System.out.println("A: " + a);
    System.out.println("B: " + b);

    for (long l = 1; l <= (long) a * b; ++l) {
      if (l % a == 0 && l % b == 0) {
        System.out.println("Returning L : " + l);
        return l;
      }
    }

    return (long) a * b;
  }


  private static long gcdFast(int a, int b) {

    if (a < b) {
      int temp = a;
      a = b;
      b = temp;

    }

    if (b == 0) {
      return a;
    }

    if (a % b == 0) {
      return b;
    }

    if (b % a == 0) {
      return a;
    }

    return gcdFast(b, a % b);

  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    // System.out.println(lcm_naive(a, b));

    BigDecimal gcd = new BigDecimal(gcdFast(a, b));

    System.out.println("GCD: " + gcd);

    if (gcd.intValue() == 1) {
      BigDecimal bda = new BigDecimal(a);
      BigDecimal bdb = new BigDecimal(b);
      System.out.print(bda.multiply(bdb).toString());
    } else {
      BigDecimal bda = new BigDecimal(a);
      BigDecimal bdb = new BigDecimal(b);
      BigDecimal product = bda.multiply(bdb);
      BigDecimal lcm = product.divide(gcd);
      System.out.println(lcm.toString());
    }
  }
}
