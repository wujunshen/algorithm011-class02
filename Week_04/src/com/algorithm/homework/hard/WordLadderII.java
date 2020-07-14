package com.algorithm.homework.hard;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 126. 单词接龙 II
 *
 * <p>给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换需遵循如下规则：
 *
 * <p>每次转换只能改变一个字母。 转换后得到的单词必须是字典中的单词。 说明:
 *
 * <p>如果不存在这样的转换序列，返回一个空列表。 所有单词具有相同的长度。 所有单词只由小写字母组成。 字典中不存在重复的单词。 你可以假设 beginWord 和 endWord
 * 是非空的，且二者不相同。 示例 1:
 *
 * <p>输入: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * <p>输出: [ ["hit","hot","dot","dog","cog"],   ["hit","hot","lot","log","cog"] ] 示例 2:
 *
 * <p>输入: beginWord = "hit" endWord = "cog" wordList = ["hot","dot","dog","lot","log"]
 *
 * <p>输出: []
 *
 * <p>解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/word-ladder-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/13 09:51<br>
 */
public class WordLadderII {
  public static void main(String[] args) {
    List<String> wordList = new ArrayList<>();
    wordList.add("hot");
    wordList.add("dot");
    wordList.add("dog");
    wordList.add("lot");
    wordList.add("log");
    wordList.add("cog");

    WordLadderII wordLadder = new WordLadderII();
    String beginWord = "hit";
    String endWord = "cog";
    List<List<String>> res = wordLadder.findLadders(beginWord, endWord, wordList);
    System.out.println(res);
  }

  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    // 先将 wordList 放到哈希表里，便于判断某个单词是否在 wordList 里
    List<List<String>> result = new ArrayList<>();
    Set<String> wordSet = new HashSet<>(wordList);
    if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
      return result;
    }
    // 第 1 步：使用双向广度优先遍历得到后继结点列表 successors
    // key：字符串，value：广度优先遍历过程中 key 的后继结点列表
    Map<String, Set<String>> successors = new HashMap<>();
    boolean found = bidirectionalBfs(beginWord, endWord, wordSet, successors);
    if (!found) {
      return result;
    }
    // 第 2 步：基于后继结点列表 successors ，使用回溯算法得到所有最短路径列表
    Deque<String> path = new ArrayDeque<>();
    path.addLast(beginWord);
    dfs(beginWord, endWord, successors, path, result);
    return result;
  }

  private boolean bidirectionalBfs(
      String beginWord, String endWord, Set<String> wordSet, Map<String, Set<String>> successors) {
    // 记录访问过的单词
    Set<String> visited = new HashSet<>();
    visited.add(beginWord);
    visited.add(endWord);

    Set<String> beginVisited = new HashSet<>();
    beginVisited.add(beginWord);
    Set<String> endVisited = new HashSet<>();
    endVisited.add(endWord);

    int wordLen = beginWord.length();
    boolean forward = true;
    boolean found = false;
    // 在保证了 beginVisited 总是较小（可以等于）大小的集合前提下，&& !endVisited.isEmpty() 可以省略
    while (!beginVisited.isEmpty() && !endVisited.isEmpty()) {
      // 一直保证 beginVisited 是相对较小的集合，方便后续编码
      if (beginVisited.size() > endVisited.size()) {
        Set<String> temp = beginVisited;
        beginVisited = endVisited;
        endVisited = temp;

        // 只要交换，就更改方向，以便维护 successors 的定义
        forward = !forward;
      }
      Set<String> nextLevelVisited = new HashSet<>();
      // 默认 beginVisited 是小集合，因此从 beginVisited 出发
      for (String currentWord : beginVisited) {
        char[] charArray = currentWord.toCharArray();
        for (int i = 0; i < wordLen; i++) {
          char originChar = charArray[i];
          for (char j = 'a'; j <= 'z'; j++) {
            if (charArray[i] == j) {
              continue;
            }
            charArray[i] = j;
            String nextWord = new String(charArray);
            if (wordSet.contains(nextWord)) {
              if (endVisited.contains(nextWord)) {
                found = true;
                // 在另一侧找到单词以后，还需把这一层关系添加到「后继结点列表」
                addToSuccessors(successors, forward, currentWord, nextWord);
              }

              if (!visited.contains(nextWord)) {
                nextLevelVisited.add(nextWord);
                addToSuccessors(successors, forward, currentWord, nextWord);
              }
            }
          }
          charArray[i] = originChar;
        }
      }
      beginVisited = nextLevelVisited;
      visited.addAll(nextLevelVisited);
      if (found) {
        break;
      }
    }
    return found;
  }

  private void dfs(
      String beginWord,
      String endWord,
      Map<String, Set<String>> successors,
      Deque<String> path,
      List<List<String>> res) {
    if (beginWord.equals(endWord)) {
      res.add(new ArrayList<>(path));
      return;
    }

    if (!successors.containsKey(beginWord)) {
      return;
    }

    Set<String> successorWords = successors.get(beginWord);
    for (String successor : successorWords) {
      path.addLast(successor);
      dfs(successor, endWord, successors, path, res);
      path.removeLast();
    }
  }

  private void addToSuccessors(
      Map<String, Set<String>> successors, boolean forward, String currentWord, String nextWord) {
    if (!forward) {
      String temp = currentWord;
      currentWord = nextWord;
      nextWord = temp;
    }

    // Java 1.8 以后支持
    successors.computeIfAbsent(currentWord, a -> new HashSet<>());
    successors.get(currentWord).add(nextWord);
  }
}
