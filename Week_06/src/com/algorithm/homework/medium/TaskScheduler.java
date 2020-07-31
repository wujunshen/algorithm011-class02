package com.algorithm.homework.medium;

import java.util.Arrays;

/**
 * 621. 任务调度器
 *
 * <p>给定一个用字符数组表示的 CPU 需要执行的任务列表。其中包含使用大写的 A - Z 字母表示的26 种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1
 * 个单位时间内执行完。CPU 在任何一个单位时间内都可以执行一个任务，或者在待命状态。
 *
 * <p>然而，两个相同种类的任务之间必须有长度为 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
 *
 * <p>你需要计算完成所有任务所需要的最短时间。
 *
 * <p>
 *
 * <p>示例 ：
 *
 * <p>输入：tasks = ["A","A","A","B","B","B"], n = 2 输出：8 解释：A -> B -> (待命) -> A -> B -> (待命) -> A ->
 * B. 在本示例中，两个相同类型任务之间必须间隔长度为 n = 2 的冷却时间，而执行一个任务只需要一个单位时间，所以中间出现了（待命）状态。
 *
 * <p>提示：
 *
 * <p>任务的总个数为 [1, 10000]。 n 的取值范围为 [0, 100]。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/task-scheduler
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/31 00:49<br>
 */
public class TaskScheduler {
  /**
   * 解题思路： 1、将任务按类型分组，正好A-Z用一个int[26]保存任务类型个数 2、对数组进行排序，优先排列个数（count）最大的任务， 如题得到的时间至少为 retCount
   * =（count-1）* (n+1) + 1 ==> A->X->X->A->X->X->A(X为其他任务或者待命) 3、再排序下一个任务，如果下一个任务B个数和最大任务数一致，
   * 则retCount++ ==> A->B->X->A->B->X->A->B
   * 4、如果空位都插满之后还有任务，那就随便在这些间隔里面插入就可以，因为间隔长度肯定会大于n，在这种情况下就是任务的总数是最小所需时间
   *
   * @param tasks
   * @param n
   * @return
   */
  public int leastInterval(char[] tasks, int n) {
    if (tasks.length <= 1 || n < 1) {
      return tasks.length;
    }
    // 步骤1
    int[] counts = new int[26];
    for (char task : tasks) {
      counts[task - 'A']++;
    }
    // 步骤2
    Arrays.sort(counts);
    int maxCount = counts[25];
    int retCount = (maxCount - 1) * (n + 1) + 1;
    int i = 24;
    // 步骤3
    while (i >= 0 && counts[i] == maxCount) {
      retCount++;
      i--;
    }
    // 步骤4
    return Math.max(retCount, tasks.length);
  }
}
