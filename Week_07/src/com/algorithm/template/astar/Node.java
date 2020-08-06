package com.algorithm.template.astar;

/**
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/8/7 01:51<br>
 */
public class Node implements Comparable<Node> {
  /** 坐标 */
  public Coord coord;
  /** 父结点 */
  public Node parent;
  /** G：是个准确的值，是起点到当前结点的代价 */
  public int g;
  /** H：是个估值，当前结点到目的结点的估计代价 */
  public int h;

  public Node(int x, int y) {
    this.coord = new Coord(x, y);
  }

  public Node(Coord coord, Node parent, int g, int h) {
    this.coord = coord;
    this.parent = parent;
    this.g = g;
    this.h = h;
  }

  @Override
  public int compareTo(Node o) {
    if (o == null) {
      return -1;
    }
    if (g + h > o.g + o.h) {
      return 1;
    } else if (g + h < o.g + o.h) {
      return -1;
    }
    return 0;
  }
}
