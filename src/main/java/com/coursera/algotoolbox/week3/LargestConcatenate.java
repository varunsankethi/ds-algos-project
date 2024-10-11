package com.coursera.algotoolbox.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LargestConcatenate {


  private static int getLargestConcatenated(int[] numbers) {

    String largestNumber = "";

    Arrays.sort(numbers);

    int arraySize = numbers.length - 1;
    System.out.println("Array size: " + arraySize);
    for (int j = arraySize; j >= 0; j--) {
      largestNumber = largestNumber + numbers[j];
    }

    return Integer.parseInt(largestNumber);
  }

  public static void main(String[] args) {

    FastScanner scanner = new FastScanner(System.in);
    int n = scanner.nextInt();
    int[] numbers = new int[n];
    for (int i = 0; i < n; i++) {
      numbers[i] = scanner.nextInt();
    }

    int largestNumber = getLargestConcatenated(numbers);
    System.out.println(largestNumber);

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
