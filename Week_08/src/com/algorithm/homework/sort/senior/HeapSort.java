package com.algorithm.homework.sort.senior;

/**
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/19 06:26<br>
 */
public class HeapSort {
  /**
   * 构建最大堆
   *
   * @param sortArray 待排序数组
   */
  private static void buildMaxHeap(int[] sortArray) {
    for (int i = (int) Math.floor(sortArray.length >> 2); i >= 0; i--) {
      heapify(sortArray, i, sortArray.length);
    }
  }

  /**
   * 堆化，递归调用
   *
   * @param sortArray 待排序树组
   * @param i
   * @param length 待排序树组长度
   */
  private static void heapify(int[] sortArray, int i, int length) {
    int left = 2 * i + 1;
    int right = 2 * i + 2;
    int largest = i;

    if (left < length && sortArray[left] > sortArray[largest]) {
      largest = left;
    }

    if (right < length && sortArray[right] > sortArray[largest]) {
      largest = right;
    }

    if (largest != i) {
      swap(sortArray, i, largest);
      heapify(sortArray, largest, length);
    }
  }

  /**
   * 值交换
   *
   * @param sortArray 待排序数组
   * @param i 索引下标
   * @param j 索引下标
   */
  private static void swap(int[] sortArray, int i, int j) {
    int temp = sortArray[i];
    sortArray[i] = sortArray[j];
    sortArray[j] = temp;
  }

  /**
   * 堆排序
   *
   * @param sortArray 待排序数组
   * @return 结果
   */
  public static int[] heapSort(int[] sortArray) {
    int len = sortArray.length;

    // 构建最大堆
    buildMaxHeap(sortArray);

    for (int i = len - 1; i > 0; i--) {
      swap(sortArray, 0, i);
      len--;
      heapify(sortArray, 0, len);
    }

    return sortArray;
  }
}
