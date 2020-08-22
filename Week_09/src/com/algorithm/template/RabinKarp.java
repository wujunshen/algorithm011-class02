package com.algorithm.template;

/**
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/8/22 18:25<br>
 */
public class RabinKarp {
  public static final int D = 256;
  public static final int Q = 9997;

  static int rabinKarp(String txt, String pat) {
    int m = pat.length();
    int n = txt.length();
    int i, j;
    int patHash = 0, txtHash = 0;

    for (i = 0; i < m; i++) {
      patHash = (D * patHash + pat.charAt(i)) % Q;
      txtHash = (D * txtHash + txt.charAt(i)) % Q;
    }
    // pow(256, M-1)
    int highestPow = 1;
    for (i = 0; i < m - 1; i++) {
      highestPow = (highestPow * D) % Q;
    }

    // 枚举起点
    for (i = 0; i <= n - m; i++) {
      if (patHash == txtHash) {
        for (j = 0; j < m; j++) {
          if (txt.charAt(i + j) != pat.charAt(j)) {
            break;
          }
        }
        if (j == m) {
          return i;
        }
      }
      if (i < n - m) {
        txtHash = (D * (txtHash - txt.charAt(i) * highestPow) + txt.charAt(i + m)) % Q;
        if (txtHash < 0) {
          txtHash += Q;
        }
      }
    }

    return -1;
  }
}
