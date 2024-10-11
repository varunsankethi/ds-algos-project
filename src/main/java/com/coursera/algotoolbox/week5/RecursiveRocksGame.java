package com.coursera.algotoolbox.week5;

public class RecursiveRocksGame {

  static String[][] array = new String[3][5];

  public static void main(String[] args) {

    int row = 2;
    int col = 4;
    System.out.println(rocksGame(row, col));

  }

  private static String rocksGame(int row, int col) {

    String finalVerdict = "";

    if (row == 0 && col == 0) {
      finalVerdict = "L";
      return finalVerdict;

    }

    if ((row == 1 && col == 1) || (row == 0 && col == 1) || (row == 1 && col == 0)) {
      finalVerdict = "W";
      return finalVerdict;

    }

    if (row > 0) {

      finalVerdict = rocksGame(row - 1, col);

      if (col == 0 && finalVerdict == "W") {
        finalVerdict = "L";
      } else {
        finalVerdict = "W";
      }

      System.out.println("Row: " + row + " Col: " + col + " finalVerdict: " + finalVerdict);
      // array[row][col] = finalVerdict;

    }

    if (col > 0) {

      finalVerdict = rocksGame(row, col - 1);
      if (row == 0 && finalVerdict == "W") {
        finalVerdict = "L";
      } else {
        finalVerdict = "W";
      }

      System.out.println("Row: " + row + " Col: " + col + " finalVerdict: " + finalVerdict);
      // array[row][col] = finalVerdict;

    }

    if (row > 1 && col > 1) {

      finalVerdict = rocksGame(row - 1, col - 1);

      if (row == col && finalVerdict == "W") {
        finalVerdict = "L";
      } /*
         * else { finalVerdict = "W"; }
         */

      System.out.println("Row: " + row + " Col: " + col + " finalVerdict: " + finalVerdict);
      // array[row][col] = finalVerdict;
    }

    // System.out.println(array);
    return finalVerdict;
  }

}
