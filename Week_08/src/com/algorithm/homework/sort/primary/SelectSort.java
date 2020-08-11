package com.algorithm.homework.sort.primary;

/**
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/19 06:23<br>
 */
public class SelectSort {
  public static int[] selectSort(int[] sortArray) {
    int tmp;
    // 总共要经过 sortArray.length-1 轮比较
    for (int i = 0; i < sortArray.length - 1; i++) {
      int min = i;

      // 每轮需要比较的次数 sortArray.length-i
      for (int j = i + 1; j < sortArray.length; j++) {
        if (sortArray[j] < sortArray[min]) {
          // 记录目前能找到的最小值元素的下标
          min = j;
        }
      }

      // 将找到的最小值和i位置所在的值进行交换
      if (i != min) {
        tmp = sortArray[i];
        sortArray[i] = sortArray[min];
        sortArray[min] = tmp;
      }
    }
    return sortArray;
  }
}
