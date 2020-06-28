package com.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/6/28 23:32<br>
 */
public class HashMapExample {

  public static void main(String[] args) {
    Map<Object, String> myMap = new HashMap<>();
    myMap.put(null, "example");
    System.out.println(myMap.get(null));

    myMap.clear();
    myMap.put("example", null);
    System.out.println(myMap.get("example"));

    myMap.put("example1", null);
    System.out.println(myMap.get("example1"));
  }


}
