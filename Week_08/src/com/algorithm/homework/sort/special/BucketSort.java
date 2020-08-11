package com.algorithm.homework.sort.special;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/19 03:25<br>
 */
public class BucketSort {
  public static int[] bucketSort(int[] sortArray) {
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    for (int value : sortArray) {
      max = Math.max(max, value);
      min = Math.min(min, value);
    }

    // 桶数
    int bucketNum = (max - min) / sortArray.length + 1;
    // 初始化桶
    List<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
    for (int i = 0; i < bucketNum; i++) {
      bucketArr.add(new ArrayList<>());
    }

    // 将每个元素放入桶
    for (int value : sortArray) {
      int num = (value - min) / (sortArray.length);
      bucketArr.get(num).add(value);
    }

    // 对每个桶进行排序
    for (ArrayList<Integer> integerArrayList : bucketArr) {
      Collections.sort(integerArrayList);
    }

    return bucketArr.stream().flatMap(List::stream).collect(toList()).stream()
        .mapToInt(Integer::valueOf)
        .toArray();
  }
}
