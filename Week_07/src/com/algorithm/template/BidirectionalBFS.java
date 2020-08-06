package com.algorithm.template;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/8/7 02:11<br>
 */
public class BidirectionalBFS {
  public int xxx(Set<String> begin, Set<String> end) {
    String start = "";
    String end1 = "";
    // 方便使用HashSet
    // start和end放入两个set
    begin.add(start);
    end.add(end1);
    // 初始化步长为0
    int step = 0;

    // 当两个set都不为空，循环执行
    while (!(begin.isEmpty() || end.isEmpty())) {
      ++step; // 步长+1
      //        swap(begin, end); // 交替从左端扩展和从右端扩展
      Set<String> s = new HashSet<>(); // 定义新的空集合
      // 当前需要扩展的这一层节点进行遍历
      for (String element : begin) {
        // 扩展下一层节点
        Set<String> newElementSet = new HashSet<>();
        // Set<String> newElementSet = expand(element);
        // 新的元素在end集合中，返回step+1，找到路径
        if (end.containsAll(newElementSet)) {
          return step + 1;
        }
        // 如果没有找到结果，把下一层的所有节点加入队列
        s.addAll(newElementSet);
      }
      // 临时的集合赋值给begin，即把已经走的路径存储起来
      begin = s;
    }
    // 队列全部结束，没有找到结果
    return 0;
  }

  private boolean buildTree(
      Set<String> words,
      Set<String> begin,
      Set<String> end,
      Map<String, List<String>> mapTree,
      boolean isFront) {
    if (begin.size() == 0) {
      return false;
    }
    // 始终以少的进行探索
    if (begin.size() > end.size()) {
      return buildTree(words, end, begin, mapTree, !isFront);
    }
    // 在已访问的单词集合中去除
    words.removeAll(begin);
    // 标记本层是否已到达目标单词
    boolean isMeet = false;
    // 记录本层所访问的单词
    Set<String> nextLevel = new HashSet<>();
    for (String word : begin) {
      char[] chars = word.toCharArray();
      for (int i = 0; i < chars.length; i++) {
        char temp = chars[i];
        for (char ch = 'a'; ch <= 'z'; ch++) {
          chars[i] = ch;
          String str = String.valueOf(chars);
          if (words.contains(str)) {
            nextLevel.add(str);
            // 根据访问顺序，添加层级对应关系：始终保持从上层到下层的存储存储关系
            // true: 从上往下探索：word -> str
            // false: 从下往上探索：str -> word（查找到的 str 是 word 上层的单词）
            String key = isFront ? word : str;
            String nextWord = isFront ? str : word;
            // 判断是否遇见目标单词
            if (end.contains(str)) {
              isMeet = true;
            }
            if (!mapTree.containsKey(key)) {
              mapTree.put(key, new ArrayList<>());
            }
            mapTree.get(key).add(nextWord);
          }
        }
        chars[i] = temp;
      }
    }
    if (isMeet) {
      return true;
    }
    return buildTree(words, nextLevel, end, mapTree, isFront);
  }
}
