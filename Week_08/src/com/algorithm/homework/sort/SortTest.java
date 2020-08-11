package com.algorithm.homework.sort;

import com.algorithm.homework.sort.primary.BubbleSort;
import com.algorithm.homework.sort.primary.InsertSort;
import com.algorithm.homework.sort.primary.SelectSort;
import com.algorithm.homework.sort.senior.HeapSort;
import com.algorithm.homework.sort.senior.MergeSort;
import com.algorithm.homework.sort.senior.QuickSort;
import com.algorithm.homework.sort.special.BucketSort;
import com.algorithm.homework.sort.special.CountSort;
import com.algorithm.homework.sort.special.RadixSort;
import java.util.Arrays;
import java.util.Random;

/**
 * 十大排序算法单元测试
 *
 * <p>1、冒泡排序 2、选择排序 3、插入排序 4、希尔排序 5、归并排序 6、快速排序 7、堆排序 8、计数排序 9、桶排序 10、基数排序
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/20 00:04<br>
 */
public class SortTest {
  private static int[] sortArray = new int[5];

  public static void main(String[] args) {
    sortArray =
        new int[] {
          new Random().nextInt(1000),
          new Random().nextInt(1000),
          new Random().nextInt(1000),
          new Random().nextInt(1000),
          new Random().nextInt(1000),
        };
    System.out.println("生成的待排序整数数组为: " + Arrays.toString(sortArray));

    // 初级排序
    System.out.println("初级排序");
    System.out.println("冒泡排序: " + Arrays.toString(BubbleSort.bubbleSort(sortArray)));
    System.out.println("插入排序: " + Arrays.toString(InsertSort.insertSort(sortArray)));
    System.out.println("选择排序: " + Arrays.toString(SelectSort.selectSort(sortArray)));

    // 高级排序
    System.out.println("高级排序");
    System.out.println("堆排序: " + Arrays.toString(HeapSort.heapSort(sortArray)));
    System.out.println("归并排序: " + Arrays.toString(MergeSort.mergeSort(sortArray)));
    System.out.println("快速排序: " + Arrays.toString(QuickSort.quickSort(sortArray)));

    // 特殊排序
    System.out.println("特殊排序");
    System.out.println("桶排序: " + Arrays.toString(BucketSort.bucketSort(sortArray)));
    System.out.println("计数排序: " + Arrays.toString(CountSort.countSort(sortArray)));
    System.out.println("基数排序: " + Arrays.toString(RadixSort.radixSort(sortArray)));
  }
}
