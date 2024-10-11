package com.coursera.algotoolbox.week5;

import java.util.Scanner;

class EditDistance {
  public static int editDistance(String s, String t) {
    // write your code here

    int m = t.length();
    int n = s.length();

    // System.out.println("M" + m);
    // System.out.println("N" + n);

    int[][] editDistArray = new int[n + 1][m + 1];
    editDistArray[0][0] = 0;
    for (int i = 1; i <= n; i++) {
      editDistArray[i][0] = i;

    }

    for (int j = 1; j <= m; j++) {
      editDistArray[0][j] = j;

    }

    for (int j = 1; j <= m; j++) {
      for (int i = 1; i <= n; i++) {
        int insertionCost = editDistArray[i][j - 1] + 1;
        int deletionCost = editDistArray[i - 1][j] + 1;
        int matchCost = editDistArray[i - 1][j - 1];
        int mismatchCost = editDistArray[i - 1][j - 1] + 1;

        // System.out.println(s.charAt(i - 1) + ":" + t.charAt(j - 1));
        // System.out.println(t.charAt(j));

        if (s.charAt(i - 1) == t.charAt(j - 1)) {
          editDistArray[i][j] = Math.min(insertionCost, Math.min(deletionCost, matchCost));
        } else {
          editDistArray[i][j] = Math.min(insertionCost, Math.min(deletionCost, mismatchCost));

        }

      }
    }

    // printArray(editDistArray, s, t);

    return editDistArray[s.length()][t.length()];
  }

  private static void printArray(int[][] editDistArray, String s, String t) {
    for (int i = 0; i < s.length() + 1; i++) {
      for (int j = 0; j < t.length() + 1; j++) {
        System.out.print(editDistArray[i][j]);
      }
      System.out.println();
    }
    // return null;
  }

  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    String t = scan.next();

    // EditDistance(s, t);
    System.out.println(editDistance(s, t));
  }

}
