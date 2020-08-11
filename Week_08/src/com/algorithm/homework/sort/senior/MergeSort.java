package com.algorithm.homework.sort.senior;

/**
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/19 02:41<br>
 */
public class MergeSort {
  public static int[] mergeSort(int[] sortArray) {
    int left = 0;
    int right = sortArray.length - 1;
    return mergeSort(sortArray, left, right);
  }

  public static int[] mergeSort(int[] sortArray, int leftIndex, int rightIndex) {
    if (leftIndex < rightIndex) {
      int center = (leftIndex + rightIndex) / 2;
      // 对左边数组递归进行归并排序
      mergeSort(sortArray, leftIndex, center);
      // 对右边数组递归进行归并排序
      mergeSort(sortArray, center + 1, rightIndex);
      // 合并两个有序序列
      merge(sortArray, leftIndex, center, rightIndex);
    }
    return sortArray;
  }

  public static void merge(int[] sortArray, int left, int center, int right) {
    // 临时数组
    int[] tempArray = new int[sortArray.length];
    // 临时数组自身索引
    int tempIndex = 0;

    // sortArray左边数组起始索引
    int leftStartIndex = left;
    // sortArray右边数组起始索引
    int rightStartIndex = center + 1;
    while (leftStartIndex <= center && rightStartIndex <= right) {
      // sortArray左右两个数组取出最小值放入临时数组
      if (sortArray[leftStartIndex] < sortArray[rightStartIndex]) {
        tempArray[tempIndex++] = sortArray[leftStartIndex++];
      } else {
        tempArray[tempIndex++] = sortArray[rightStartIndex++];
      }
    }
    // 若还有剩余，则将剩余依次拷贝进临时数组中(两个while其实只会执行其中一个)
    while (leftStartIndex <= center) {
      tempArray[tempIndex++] = sortArray[leftStartIndex++];
    }

    while (rightStartIndex <= right) {
      tempArray[tempIndex++] = sortArray[rightStartIndex++];
    }

    // 将临时数组里内容复制到原来数组
    if (tempIndex >= 0) {
      System.arraycopy(tempArray, 0, sortArray, left, tempIndex);
    }
  }
}
