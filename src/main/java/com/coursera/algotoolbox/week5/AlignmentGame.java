package com.coursera.algotoolbox.week5;

public class AlignmentGame {

  public static void main(String[] args) {

    /*
     * String firstString = "ATGTTATA"; String secondString = "ATCGTCC";
     */

    /*
     * String firstString = "TCC"; String secondString = "ATC";
     */

    String firstString = "TC";
    String secondString = "AT";

    int firstStringEnd = firstString.length() - 1;
    int secondStringEnd = secondString.length() - 1;

    System.out
        .println(alignmentScore(firstString, secondString, 0, firstStringEnd, 0, secondStringEnd));

  }

  private static int alignmentScore(String firstString, String secondString, int firstStringStart,
      int firstStringEnd, int secondStringStart, int secondStringEnd) {

    int finalAlignmentScore = 0;

    int midFirstString = (firstStringStart + firstStringEnd) / 2;
    int midSecondString = (secondStringStart + secondStringEnd) / 2;

    if (firstStringStart < firstStringEnd || secondStringStart < secondStringEnd) {

      alignmentScore(firstString, secondString, firstStringStart, midFirstString, secondStringStart,
          midSecondString);
      alignmentScore(firstString, secondString, midFirstString + 1, firstStringEnd,
          midSecondString + 1, secondStringEnd);

      alignmentScore(firstString, secondString, firstStringStart, firstStringEnd,
          secondStringStart + 1, secondStringEnd);
      alignmentScore(firstString, secondString, firstStringStart + 1, firstStringEnd,
          secondStringStart, secondStringEnd);

      /*
       * alignmentScore(firstString, secondString, firstStringStart + 1, firstStringEnd,
       * secondStringStart, secondStringEnd); alignmentScore(firstString, secondString,
       * firstStringStart, firstStringEnd, secondStringStart + 1, secondStringEnd);
       */
      /*
       * finalAlignmentScore += max( alignmentScore(firstString, secondString, firstStringStart + 1,
       * firstStringEnd, secondStringStart, secondStringEnd), alignmentScore(firstString,
       * secondString, firstStringStart, firstStringEnd, secondStringStart + 1, secondStringEnd));
       */

    }

    finalAlignmentScore = calculateAlignmentScore(firstString, secondString, firstStringStart,
        firstStringEnd, secondStringStart, secondStringEnd, finalAlignmentScore);

    return finalAlignmentScore;

  }

  private static int max(int alignmentScoreFirst, int alignmentScoreSecond) {
    return Math.max(alignmentScoreFirst, alignmentScoreSecond);

  }

  private static int calculateAlignmentScore(String firstString, String secondString,
      int firstStringStart, int firstStringEnd, int secondStringStart, int secondStringEnd,
      int finalAlignmentScore) {
    int i = firstStringStart;
    int j = secondStringStart;

    while (i <= firstStringEnd && j <= secondStringEnd) {
      if (firstString.charAt(i) == secondString.charAt(j)) {
        finalAlignmentScore = finalAlignmentScore + 1;
      }

      i++;
      j++;
    }
    return finalAlignmentScore;
  }

}
