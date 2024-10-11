package com.coursera.algotoolbox.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class MajorityElement {

  private static int getMajorityElement(int[] a, int left, int right) {
    if (left == right) {
      return -1;
    }
    if (left + 1 == right) {
      return a[left];
    }
    // write your code here

    // int[] frequencyArray = new int[10];

    int mid = (left + right) / 2;

    int nForCurrentLevel = (right - left + 1) / 2;

    boolean isMajorityElement = false;

    Map<Integer, Integer> map = new HashMap<>();

    getMajorityElement(a, left, mid);
    getMajorityElement(a, mid + 1, right);

    for (int i = left; i <= right; i++) {

      if (map.containsKey(a[i])) {
        int val = map.get(a[i]);
        map.put(a[i], ++val);
      } else {
        map.put(a[i], 1);
      }

    }

    for (int val : map.values()) {
      if (val > nForCurrentLevel) {
        isMajorityElement = true;
        break;
      } else {
        isMajorityElement = false;
      }
    }

    if (isMajorityElement) {

      // System.out.println("majority element exists :" + map);
      return 1;
    } else {
      // System.out.println(map);
      return -1;
    }

    // return -1;
  }

  public static void main(String[] args) {
    FastScanner scanner = new FastScanner(System.in);
    int n = scanner.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = scanner.nextInt();
    }
    if (getMajorityElement(a, 0, a.length - 1) != -1) {
      System.out.println(1);
    } else {
      System.out.println(0);
    }
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
