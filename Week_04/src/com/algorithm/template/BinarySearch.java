package com.algorithm.template;

/**
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/13 22:57<br>
 */
public class BinarySearch {
  public static int binarySearch(int[] array, int a) {
    int low = 0;
    int high = array.length - 1;
    int mid;
    while (low < high) {
      // 中间位置
      mid = (low + high) / 2;
      if (array[mid] == a) {
        return mid;
      } else if (a > array[mid]) {
        // 向右查找
        low = mid + 1;
      } else {
        // 向左查找
        high = mid - 1;
      }
    }
    return -1;
  }
}
