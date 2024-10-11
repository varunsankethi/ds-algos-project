package com.coursera.algotoolbox.week5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PrimitiveCalculator {

  static List<Integer> finalList3 = new ArrayList<Integer>();
  static List<Integer> finalList2 = new ArrayList<Integer>();

  static List<Integer> finalList1 = new ArrayList<Integer>();

  static List<List<Integer>> finalListOfList = new ArrayList<List<Integer>>();

  private static List<Integer> optimal_sequence(int n) {
    List<Integer> sequence = new ArrayList<Integer>();
    while (n >= 1) {
      sequence.add(n);
      if (n % 3 == 0) {
        n /= 3;
      } else if (n % 2 == 0) {
        n /= 2;
      } else {
        n -= 1;
      }
    }
    Collections.reverse(sequence);
    return sequence;
  }

  private static List<Integer> optimalSequenceNew(int n) {

    int minNumberOfOperations = 0;
    List<Integer> returnList = null;

    if (n <= 1) {
      List<Integer> intList = new ArrayList<Integer>();
      intList.add(1);
      return intList;
    }

    if (n > 1) {

      List<Integer> intList3 = optimalSequenceNew(n / 3);

      int mod3 = n % 3;
      intList3.add(intList3.get(intList3.size() - 1) * 3);
      for (int i = 1; i <= mod3; i++) {
        intList3.add(intList3.get(intList3.size() - 1) + i);
      }

      List<Integer> intList2 = optimalSequenceNew(n / 2);
      int mod2 = n % 2;
      intList2.add(intList2.get(intList2.size() - 1) * 2);
      for (int i = 1; i <= mod2; i++) {
        intList2.add(intList2.get(intList2.size() - 1) + i);
      }

      List<Integer> intList1 = optimalSequenceNew(n - 1);
      intList1.add(intList1.get(intList1.size() - 1) + 1);

      int sizeList3 = intList3.size();
      int sizeList2 = intList2.size();
      int sizeList1 = intList1.size();

      int smallest = sizeList3;

      returnList = intList3;

      if (intList3.get(intList3.size() - 1) == n) {
        smallest = sizeList3;
        returnList = intList3;
      } else if (intList2.get(intList2.size() - 1) == n) {
        smallest = sizeList2;
        returnList = intList2;
      } else if (intList1.get(intList1.size() - 1) == n) {
        smallest = sizeList1;
        returnList = intList1;
      }

      if (smallest > sizeList2) {

        smallest = sizeList2;
        returnList = intList2;

      }

      if (smallest > sizeList1) {
        smallest = sizeList1;
        returnList = intList1;

      }

    }
    // finalListOfList.add(valuesList);
    return returnList;
  }

  private static List<Integer> optimalSequenceDPNew(int n) {

    List<Integer> list = new ArrayList<>();
    list.add(0);
    list.add(0);

    for (int i = 2; i <= n; i++) {
      int num = i;

      int plusOneSteps = list.get(i - 1) + 1;
      int into2Steps = num % 2 == 0 ? list.get(num / 2) + 1 : Integer.MAX_VALUE;
      int into3Steps = num % 3 == 0 ? list.get(num / 3) + 1 : Integer.MAX_VALUE;

      int numOfSteps = Math.min(Math.min(plusOneSteps, into2Steps), into3Steps);

      list.add(numOfSteps);
    }

    // System.out.println("Final List = " + list);
    // System.out.println("Optimal steps for num: " + n + " = " + list.get(n));

    List<Integer> resultList = new ArrayList<>();
    resultList.add(n);
    while (n > 1) {

      int minusOneNumOfSteps = list.get(n - 1);
      int divideBy2NumOfSteps = n % 2 == 0 ? list.get(n / 2) : Integer.MAX_VALUE;
      int divideBy3NumOfSteps = n % 3 == 0 ? list.get(n / 3) : Integer.MAX_VALUE;

      int minNumOfSteps =
          Math.min(Math.min(minusOneNumOfSteps, divideBy2NumOfSteps), divideBy3NumOfSteps);

      if (minNumOfSteps == minusOneNumOfSteps) {
        n = n - 1;
        resultList.add(n);

      } else if (minNumOfSteps == divideBy2NumOfSteps) {
        n = n / 2;
        resultList.add(n);
      } else {
        n = n / 3;
        resultList.add(n);
      }

    }
    return resultList;

  }

  private static List<Integer> optimalSequenceDP(int n) {

    boolean numberFound = false;

    int level = 0;
    int foundLevel = 0;

    List<Integer> finalIntegerList = null;

    Map<Integer, List<List<Integer>>> listOfListMap = new HashMap<>();

    List<Integer> zerothList = new ArrayList<>();
    zerothList.add(1);

    List<List<Integer>> startingList = new ArrayList<>();
    startingList.add(zerothList);
    if (n == 1) {
      return zerothList;
    }
    listOfListMap.put(level, startingList);

    List<Integer> resultList = new ArrayList<>();
    int foundIndex = -1;

    while (numberFound == false) {

      List<List<Integer>> listToAddToMap = new ArrayList<>();
      List<List<Integer>> currentLevelLists = listOfListMap.get(level);
      for (List<Integer> list : currentLevelLists) {

        for (int i = 0; i < list.size(); i++) {

          List<Integer> nextList = new ArrayList<>();
          // int plusOneVal = list.get(i) + 1;
          // int mulTwoVal = list.get(i) * 2;
          // int mulThreeVal = list.get(i) * 3;

          nextList.add(list.get(i) + 1);
          nextList.add(list.get(i) * 2);
          nextList.add(list.get(i) * 3);

          if (nextList.get(0) == n) {
            // foundLevel = level + 1;
            numberFound = true;
            foundIndex = 0;

          }
          if (nextList.get(1) == n) {
            // foundLevel = level + 1;
            numberFound = true;
            foundIndex = 1;

          }
          if (nextList.get(2) == n) {
            // foundLevel = level + 1;
            numberFound = true;
            foundIndex = 2;

          }

          if (!listToAddToMap.contains(nextList)) {
            listToAddToMap.add(nextList);
          }
          // System.out.println(listToAddToMap);
        }

        if (numberFound) {
          break;
        }
      }

      listOfListMap.put(++level, listToAddToMap);
      // System.out.println(listOfListMap);

    }
    resultList.add(n);
    // System.out.println("Original Found index : " + foundIndex);
    while (--level > 0) {

      if (foundIndex == 0) {
        n = n - 1;
      } else if (foundIndex == 1) {
        n = n / 2;

      } else if (foundIndex == 2) {
        n = n / 3;
      }

      List<List<Integer>> listOfList = listOfListMap.get(level);
      for (List<Integer> list : listOfList) {
        if (list.get(0) == n) {
          foundIndex = 0;
          resultList.add(n);
          break;
        } else if (list.get(1) == n) {
          foundIndex = 1;
          resultList.add(n);
          break;
        } else if (list.get(2) == n) {
          foundIndex = 2;
          resultList.add(n);
          break;
        }
      }
    }
    // finalIntegerList = getSequence(n, foundLevel,finalNumberIndexInArray, listOfListMap);
    resultList.add(1);
    return resultList; // finalIntegerList;

  }

  // private static List<Integer> getSequence(int n, int foundLevel, int finalNumberIndexInArray,
  // Map<Integer, List<List<Integer>>> valuesMap) {
  //
  // List<Integer> returnList = new ArrayList<Integer>();
  // returnList.add(n);
  // int nextLowerIndex=0;
  //
  // if (finalNumberIndexInArray == 0) {
  // nextLowerIndex = 0;
  // n = n-1;
  // } else if (finalNumberIndexInArray == 1){
  // nextLowerIndex = 1;
  // n = n/2;
  // } else {
  // nextLowerIndex = 2;
  // n = n/3;
  // }
  //
  // for (int i = foundLevel-1; i > 0; i--) {
  //
  // List<List<Integer>> currentLevelListOfLists = valuesMap.get(i);
  //
  // for(int k =0 ; k< currentLevelListOfLists.size(); k++) {
  // List<Integer> list = currentLevelListOfLists.get(k);
  //
  //// if(nextLowerIndex == 0) {
  //// if (list.get(0) == n);
  //// returnList.add(n);
  ////
  //// }
  // boolean currentLevelDone = false;
  // for (int j = 0; j < list.size(); j++) {
  // boolean currentNumberFound = false;
  // if (list.get(j) == n && j == 0) {
  // returnList.add(n);
  // n = n - 1;
  // currentNumberFound = true;
  // } else if (list.get(j) == n && j == 1) {
  // returnList.add(n);
  // n = n / 2;
  // currentNumberFound = true;
  // } else if (list.get(j) == n && j == 2) {
  // returnList.add(n);
  // n = n / 3;
  // currentNumberFound = true;
  // }
  // if (currentNumberFound) {
  // currentLevelDone = true;
  // break;
  // }
  // }
  // if (currentLevelDone) {
  // break;
  // }
  // }
  // }
  // returnList.add(1);
  // return returnList;
  // }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();

    List<Integer> finalIntegerList = optimalSequenceDPNew(n);
    // List<Integer> finalIntegerList = optimalSequenceDP(n);
    //
    System.out.println(finalIntegerList.size() - 1);
    for (Integer x : finalIntegerList)
      System.out.print(x + " ");
  }

}
