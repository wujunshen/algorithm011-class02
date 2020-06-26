package com.algorithm.example;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/6/25 17:09<br>
 */
public class OldDeque {

  public static void main(String[] args) {
    Deque<String> deque = new LinkedList<>();

    deque.push("a");
    deque.push("b");
    deque.push("c");

    String str = deque.peek();
    System.out.println(str);
    System.out.println(deque);

    while (deque.size() > 0) {
      System.out.println(deque.pop());
    }

    System.out.println(deque);

    //c
    //[c, b, a]
    //c
    //b
    //a
    //[]
  }
}
