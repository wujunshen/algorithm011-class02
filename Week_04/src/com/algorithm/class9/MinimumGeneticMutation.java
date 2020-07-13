package com.algorithm.class9;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

/**
 * 433. 最小基因变化
 *
 * <p>一条基因序列由一个带有8个字符的字符串表示，其中每个字符都属于 "A", "C", "G", "T"中的任意一个。
 *
 * <p>假设我们要调查一个基因序列的变化。一次基因变化意味着这个基因序列中的一个字符发生了变化。
 *
 * <p>例如，基因序列由"AACCGGTT" 变化至 "AACCGGTA" 即发生了一次基因变化。
 *
 * <p>与此同时，每一次基因变化的结果，都需要是一个合法的基因串，即该结果属于一个基因库。
 *
 * <p>现在给定3个参数 — start, end,
 * bank，分别代表起始基因序列，目标基因序列及基因库，请找出能够使起始基因序列变化为目标基因序列所需的最少变化次数。如果无法实现目标变化，请返回 -1。
 *
 * <p>注意:
 *
 * <p>起始基因序列默认是合法的，但是它并不一定会出现在基因库中。 所有的目标基因序列必须是合法的。 假定起始基因序列与目标基因序列是不一样的。 示例 1:
 *
 * <p>start: "AACCGGTT" end: "AACCGGTA" bank: ["AACCGGTA"]
 *
 * <p>返回值: 1 示例 2:
 *
 * <p>start: "AACCGGTT" end: "AAACGGTA" bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
 *
 * <p>返回值: 2 示例 3:
 *
 * <p>start: "AAAAACCC" end: "AACCCCCC" bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
 *
 * <p>返回值: 3
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/minimum-genetic-mutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/13 09:13<br>
 */
public class MinimumGeneticMutation {

  public static void main(String[] args) {
    String start = "AAAAACCC";
    String end = "AACCCCCC";
    String[] bank = {"AAAACCCC", "AAACCCCC", "AACCCCCC"};

    int result = minMutation(start, end, bank);
    System.out.println(result);
  }

  public static int minMutation(String start, String end, String[] bank) {
    Set<String> set = new HashSet<>(Arrays.asList(bank));
    // 1.判断边界(1如果开始值，目标值为空，返回-1；若目标值不在基因库返回-1)
    if (null == start || "".equals(start) || null == end || "".equals(end)) {
      return -1;
    }
    if (!set.contains(end)) {
      return -1;
    }
    // 2定义可变元素，及初始化步骤
    char[] eml = new char[] {'A', 'C', 'G', 'T'};
    int step = 0;
    set.remove(start);
    Queue<String> queue = new LinkedList<>();
    queue.offer(start);
    // 每层变化一个位置
    while (!queue.isEmpty()) {
      // 记录变换次数(进入下一层)
      step++;
      // 当前层，所有可能
      for (int d = 0; d < queue.size(); d++) {
        // 将起始数据从队列中取出，转为字符数组
        char[] temStr = Objects.requireNonNull(queue.poll()).toCharArray();
        // 循环遍历替换起始数据中的每一个元素（多种情况），查看是否为目标数据或在基因库中
        for (int i = 0; i < temStr.length; ++i) {
          char oldTemS = temStr[i];
          for (int j = 0; j < 4; ++j) {
            temStr[i] = eml[j];
            String newStr = new String(temStr);
            if (end.equals(newStr)) {
              // 如果替换后结果为目标值则返回变换次数
              return step;
            } else if (set.contains(newStr)) {
              // 若替换后的数据在基因库中，则说明当前为变化数据，将当前变化数据加入队列，并从基因库中去除
              queue.offer(newStr);
              set.remove(newStr);
            } else { // 恢复原始数据，方便寻找下一种变化可能
              temStr[i] = oldTemS;
            }
          }
        }
      }
    }
    return -1;
  }
}
