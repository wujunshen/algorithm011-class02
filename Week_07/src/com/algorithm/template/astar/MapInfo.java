package com.algorithm.template.astar;

/**
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/8/7 01:53<br>
 */
public class MapInfo {
  /** 二维数组的地图 */
  public int[][] maps;
  /** 地图的宽 */
  public int width;
  /** 地图的高 */
  public int height;
  /** 起始结点 */
  public Node start;
  /** 最终结点 */
  public Node end;

  public MapInfo(int[][] maps, int width, int height, Node start, Node end) {
    this.maps = maps;
    this.width = width;
    this.height = height;
    this.start = start;
    this.end = end;
  }
}
