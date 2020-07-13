package com.algorithm.homework;

/**
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/13 23:34<br>
 */
public class BinarySearchRotateArray {

  public int search(int[] array, int length, int x) {
    int l = 0;
    int r = length - 1;
    int m;

    // 循环条件
    while (l <= r) {
      m = (l + r) / 2;
      // 找到了，终止
      if (array[m] == x) {
        return m;
      }
      // 右侧有序
      if (array[m] < array[r]) {
        if (array[m] < x && array[r] >= x) {
          l = m + 1;
        } else {
          r = m - 1;
        }
      } else { // 左侧有序
        if (array[m] > x && array[l] <= x) {
          r = m - 1;
        } else {
          l = m + 1;
        }
      }
    }
    return -1;
  }
}
