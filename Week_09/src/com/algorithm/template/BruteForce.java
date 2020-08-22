package com.algorithm.template;

/**
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/8/22 18:24<br>
 */
public class BruteForce {
  public static int bruteForce(String txt, String pat) {
    int m = txt.length();
    int n = pat.length();
    for (int i = 0; i <= m - n; i++) {
      int j;
      for (j = 0; j < n; j++) {
        if (txt.charAt(i + j) != pat.charAt(j)) {
          break;
        }
      }
      if (j == n) {
        return i;
      }
      // 更加聪明？
      // 1. 预先判断 hash(txt.substring(i, m)) == hash(pat)
      // 2. KMP
    }
    return -1;
  }
}
