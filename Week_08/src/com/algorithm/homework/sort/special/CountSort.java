package com.algorithm.homework.sort.special;

import java.util.Arrays;
import java.util.OptionalInt;

/**
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/19 06:40<br>
 */
public class CountSort {
  public static int[] countSort(int[] sortArray) {
    int maxValue = getMaxValue(sortArray) + 1;
    int[] bucket = new int[maxValue];
    int sortedIndex = 0;

    for (int value : sortArray) {
      bucket[value]++;
    }

    for (int j = 0; j < maxValue; j++) {
      while (bucket[j] > 0) {
        sortArray[sortedIndex++] = j;
        bucket[j]--;
      }
    }

    return sortArray;
  }

  private static int getMaxValue(int[] sortArray) {
    OptionalInt view = Arrays.stream(sortArray).max();

    return view.isPresent() ? view.getAsInt() : 0;
  }
}
