package com.algorithm.homework.sort.primary;

/**
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/19 00:46<br>
 */
public class InsertSort {
  public static int[] insertSort(int[] sortArray) {
    int insertValue;
    int index;
    for (int i = 1; i < sortArray.length; i++) {
      // 插入的值
      insertValue = sortArray[i];
      // 准备和前一个下标位置做比较
      index = i - 1;

      // 插入的值比被插入的值小
      while (index >= 0 && insertValue < sortArray[index]) {
        // sortArray[index]值向后移动一位
        sortArray[index + 1] = sortArray[index];
        // index向前移动
        index--;
      }
      // 插入值放入合适的地方
      sortArray[index + 1] = insertValue;
    }
    return sortArray;
  }
}
