package com.algorithm.homework.sort.special;

import java.util.Arrays;
import java.util.OptionalInt;

/**
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/19 04:58<br>
 */
public class RadixSort {
  /**
   * 获取待排序数组里最大值
   *
   * @param sortArray 待排序数组
   * @return 待排序数组里最大值
   */
  private static int getMaxValue(int[] sortArray) {
    OptionalInt view = Arrays.stream(sortArray).max();

    return view.isPresent() ? view.getAsInt() : 0;
  }

  /**
   * 获取最高位数
   *
   * @param number 数字
   * @return 数字位数
   */
  private static int getDigit(long number) {
    if (number == 0) {
      return 1;
    }
    int length = 0;
    for (long temp = number; temp != 0; temp /= 10) {
      length++;
    }
    return length;
  }

  /**
   * 基数排序
   *
   * @param sortArray 待排序数组
   * @return 排序结果
   */
  public static int[] radixSort(int[] sortArray) {
    // 获取待排序数组里最大值的位数
    int maxDigit = getDigit(getMaxValue(sortArray));
    int mod = 10;
    int dev = 1;

    for (int i = 0; i < maxDigit; i++, dev *= 10, mod *= 10) {
      // 考虑负数的情况，这里扩展一倍队列数，其中 [0-9]对应负数，[10-19]对应正数 (bucket + 10)
      int[][] counter = new int[mod * 2][0];

      for (int element : sortArray) {
        int bucket = ((element % mod) / dev) + mod;
        counter[bucket] = reSize(counter[bucket], element);
      }

      sortArray = Arrays.stream(counter).flatMapToInt(Arrays::stream).toArray();
    }

    return sortArray;
  }

  /**
   * 自动扩容，并保存数据
   *
   * @param bucket 每个桶数组
   * @param value 加在桶数组最后的值
   */
  private static int[] reSize(int[] bucket, int value) {
    bucket = Arrays.copyOf(bucket, bucket.length + 1);
    bucket[bucket.length - 1] = value;
    return bucket;
  }
}
