package com.algorithm.homework.sort.senior;

/**
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/19 01:16<br>
 */
public class QuickSort {
  public static int[] quickSort(int[] sortArray) {
    int leftIndex = 0;
    int rightIndex = sortArray.length - 1;
    return quickSort(sortArray, leftIndex, rightIndex);
  }
  /**
   * 其实个人感觉就是双指针夹逼+递归
   *
   * @param sortArray 未排序数组
   * @return 排序后数组
   */
  public static int[] quickSort(int[] sortArray, int leftIndex, int rightIndex) {
    // 左指针，从左向右比较的index
    int start = leftIndex;
    // 右指针，从右往左比较的index
    int end = rightIndex;
    int temp;
    // 基准位的值
    int benchMarkValue = sortArray[leftIndex];

    while (start < end) {
      // 从右往左比较，依次遍历看是不是有比基准值小的
      while (benchMarkValue <= sortArray[end] && start < end) {
        end--;
      }
      // 如果有比基准值小的，则交换位置后，从前向后比较
      temp = sortArray[end];
      sortArray[end] = sortArray[start];
      sortArray[start] = temp;
      // 从前向后比较。遍历是否有比基准值大的
      while (benchMarkValue >= sortArray[start] && start < end) {
        start++;
      }
      // 如果有比基准值大的，则交换位置
      temp = sortArray[start];
      sortArray[start] = sortArray[end];
      sortArray[end] = temp;
    }
    // 此时循环结束后，基准值左边的都比它小，右边都比它大，但是两边大小顺序还不确定，所以接下来需要递归quickSort，决定基准值左右两边数组顺序
    // 递归调用左半数组
    if (start > leftIndex) {
      quickSort(sortArray, leftIndex, start - 1);
    }
    // 递归调用右半数组
    if (end < rightIndex) {
      quickSort(sortArray, end + 1, rightIndex);
    }
    return sortArray;
  }
}
