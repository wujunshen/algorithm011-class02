package com.algorithm.homework.sort.primary;

/**
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/19 00:26<br>
 */
public class BubbleSort {
  public static int[] bubbleSort(int[] sortArray) {
    // 判断循环内部是否发生交换，若无交换直接退出循环，这样减少循环次数
    boolean flag = false;

    int temp;
    for (int i = 0; i < sortArray.length - 1; i++) {
      for (int j = 0; j < sortArray.length - 1 - i; j++) {
        if (sortArray[j] > sortArray[j + 1]) {
          temp = sortArray[j];
          sortArray[j] = sortArray[j + 1];
          sortArray[j + 1] = temp;
          flag = true;
        }
      }
      // 若没有发生交换，则退出循环
      if (!flag) {
        break;
      }
    }
    return sortArray;
  }
}
