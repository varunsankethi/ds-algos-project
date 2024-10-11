package com.coursera.algotoolbox.week3;

import java.util.Scanner;

public class CarFueling {

  static int computeMinRefills(int dist, int tank, int[] stops) {

    if (dist <= tank) {
      return 0;
    }

    int startingIndex = 0;
    // int distanceCovered = 0;
    int numberOfPitStops = 0;
    int startingKms = 0;

    while (true) {

      int hnpt = startingKms + tank;

      if (hnpt >= dist) {
        break;
      }
      int maxDistanceWithGasLessOrEqualThanHnpt = -1;

      for (int i = startingIndex; i < stops.length; i++) {
        if (stops[i] <= hnpt) {
          maxDistanceWithGasLessOrEqualThanHnpt = stops[i];
          startingIndex = i + 1;
          startingKms = maxDistanceWithGasLessOrEqualThanHnpt;
        }
      }

      if (maxDistanceWithGasLessOrEqualThanHnpt == -1) {
        numberOfPitStops = -1;
        break;// cannot reach the destination as the next pitstop is too far
      } else {
        ++numberOfPitStops;
      }

      // distanceCovered = maxDistanceWithGasLessOrEqualThanHnpt;

      // if (distanceCovered >= dist) {
      // break;
      // } else {
      // ++numberOfPitStops;
      // }

    }

    // if ((startingKms + tank) >= dist) {
    // break;
    // }

    return numberOfPitStops;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int dist = scanner.nextInt();
    int tank = scanner.nextInt();
    int n = scanner.nextInt();
    int stops[] = new int[n];
    for (int i = 0; i < n; i++) {
      stops[i] = scanner.nextInt();
    }

    System.out.println(computeMinRefills(dist, tank, stops));
  }
}
