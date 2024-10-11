package com.coursera.algotoolbox.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MoneyChangeProblem {

  private static int getChange(int money, List<Integer> denominations) {

    List<Integer> returnDenominations = new ArrayList<Integer>();

    System.out.println(denominations);

    while (money > 0) {

      int maxDenomination = denominations.stream().max(Integer::compareTo).get();
      int indexOfMaxDenomination = denominations.indexOf(maxDenomination);
      System.out.println("Max and max position: " + maxDenomination + " " + indexOfMaxDenomination);

      while (money >= maxDenomination) {
        returnDenominations.add(maxDenomination);
        System.out.println(returnDenominations);
        money = money - maxDenomination;
      }


      denominations.remove(indexOfMaxDenomination);

    }


    return returnDenominations.size();
  }

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int number = scanner.nextInt();
    int numOfDenominations = scanner.nextInt();
    List<Integer> denominations = new ArrayList<Integer>();
    FastScanner fastScanner = new FastScanner(System.in);

    for (int i = 0; i < numOfDenominations; i++) {
      denominations.add(fastScanner.nextInt());
    }

    int minNumberOfCoins = getChange(number, denominations);
    System.out.println(minNumberOfCoins);


  }



  static class FastScanner {
    BufferedReader br;
    StringTokenizer st;

    FastScanner(InputStream stream) {
      try {
        br = new BufferedReader(new InputStreamReader(stream));
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    String next() {
      while (st == null || !st.hasMoreTokens()) {
        try {
          st = new StringTokenizer(br.readLine());
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }

    int nextInt() {
      return Integer.parseInt(next());
    }
  }



}
