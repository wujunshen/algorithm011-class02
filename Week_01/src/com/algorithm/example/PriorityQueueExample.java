package com.algorithm.example;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author frank woo(吴峻申) <br>
 * email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/6/25 21:47<br>
 */
public class PriorityQueueExample {

  public static void main(String[] args) {
      Queue<Integer> priorityQueue = new PriorityQueue<>();
      priorityQueue.add(1);
      priorityQueue.add(4);
      priorityQueue.add(2);
      priorityQueue.add(3);

      System.out.println(priorityQueue.poll());
      System.out.println(priorityQueue.poll());
  }
}
