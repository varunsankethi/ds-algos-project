package com.coursera.algotoolbox.week3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FractionalKnapsack {
  private static double getOptimalValue(int capacity, int[] values, int[] weights) {
    double value = 0;
    double remainingCapacity = Double.valueOf(capacity);
    // write your code here

    List<Double> valuePerUnitWeightList = new ArrayList<Double>();

    List<Double> valuesList = new ArrayList<Double>();
    List<Double> weightsList = new ArrayList<Double>();

    for (int i = 0; i < values.length; i++) {
      valuesList.add(Double.valueOf(values[i]));
    }
    for (int i = 0; i < weights.length; i++) {
      weightsList.add(Double.valueOf(weights[i]));
    }

    for (int i = 0; i < values.length; i++) {

      double valuePerUnitWeight = Double.valueOf(values[i]) / Double.valueOf(weights[i]);
      valuePerUnitWeightList.add(valuePerUnitWeight);

    }

    while (remainingCapacity > 0 && (Collections.max(valuePerUnitWeightList) != 0)) {

      double maxValuePerUnitWeight = Collections.max(valuePerUnitWeightList);
      int maxValuePerUnitWeightIndex = valuePerUnitWeightList.indexOf(maxValuePerUnitWeight);
      double availableWeightOfMaxUnitValue = weightsList.get(maxValuePerUnitWeightIndex);

      if (availableWeightOfMaxUnitValue < remainingCapacity) {
        value += valuesList.get(maxValuePerUnitWeightIndex);
        valuesList.set(maxValuePerUnitWeightIndex, 0.0);
        weightsList.set(maxValuePerUnitWeightIndex, 0.0);
        valuePerUnitWeightList.set(maxValuePerUnitWeightIndex, 0.0);
        remainingCapacity = remainingCapacity - availableWeightOfMaxUnitValue;

      } else {

        double valueToAdd =
            valuePerUnitWeightList.get(maxValuePerUnitWeightIndex) * remainingCapacity;
        value += valueToAdd;
        double remainingWeightOfItem =
            weightsList.get(maxValuePerUnitWeightIndex) - remainingCapacity;
        double remainingValueOfItem = valuesList.get(maxValuePerUnitWeightIndex) - valueToAdd;
        valuesList.set(maxValuePerUnitWeightIndex, remainingValueOfItem);
        weightsList.set(maxValuePerUnitWeightIndex, remainingWeightOfItem);
        remainingCapacity = 0;

      }

    }

    return value;
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int capacity = scanner.nextInt();
    int[] values = new int[n];
    int[] weights = new int[n];
    for (int i = 0; i < n; i++) {
      values[i] = scanner.nextInt();
      weights[i] = scanner.nextInt();
    }
    System.out.println(getOptimalValue(capacity, values, weights));
  }
}
