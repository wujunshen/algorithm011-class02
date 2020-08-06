package com.algorithm.template.astar;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/8/7 01:45<br>
 */
public class Astar {
  /** 障碍值 */
  public static final int BAR = 1;
  /** 路径 */
  public static final int PATH = 2;
  /** 横竖移动代价 */
  public static final int DIRECT_VALUE = 10;
  /** 斜移动代价 */
  public static final int OBLIQUE_VALUE = 14;

  Queue<Node> openList = new PriorityQueue<>(); // 优先队列(升序)
  List<Node> closeList = new ArrayList<>();

  /** 开始算法 */
  public void start(MapInfo mapInfo) {
    if (mapInfo == null) {
      return;
    }
    // clean
    openList.clear();
    closeList.clear();
    // 开始搜索
    openList.add(mapInfo.start);
    moveNodes(mapInfo);
  }

  /** 移动当前结点 */
  private void moveNodes(MapInfo mapInfo) {
    while (!openList.isEmpty()) {
      Node current = openList.poll();
      closeList.add(current);
      addNeighborNodeInOpen(mapInfo, current);
      if (isCoordInClose(mapInfo.end.coord)) {
        drawPath(mapInfo.maps, mapInfo.end);
        break;
      }
    }
  }

  /** 在二维数组中绘制路径 */
  private void drawPath(int[][] maps, Node end) {
    if (end == null || maps == null) {
      return;
    }
    System.out.println("总代价：" + end.g);
    while (end != null) {
      Coord c = end.coord;
      maps[c.y][c.x] = PATH;
      end = end.parent;
    }
  }

  /** 添加所有邻结点到open表 */
  private void addNeighborNodeInOpen(MapInfo mapInfo, Node current) {
    int x = current.coord.x;
    int y = current.coord.y;
    // 左
    addNeighborNodeInOpen(mapInfo, current, x - 1, y, DIRECT_VALUE);
    // 上
    addNeighborNodeInOpen(mapInfo, current, x, y - 1, DIRECT_VALUE);
    // 右
    addNeighborNodeInOpen(mapInfo, current, x + 1, y, DIRECT_VALUE);
    // 下
    addNeighborNodeInOpen(mapInfo, current, x, y + 1, DIRECT_VALUE);
    // 左上
    addNeighborNodeInOpen(mapInfo, current, x - 1, y - 1, OBLIQUE_VALUE);
    // 右上
    addNeighborNodeInOpen(mapInfo, current, x + 1, y - 1, OBLIQUE_VALUE);
    // 右下
    addNeighborNodeInOpen(mapInfo, current, x + 1, y + 1, OBLIQUE_VALUE);
    // 左下
    addNeighborNodeInOpen(mapInfo, current, x - 1, y + 1, OBLIQUE_VALUE);
  }

  /** 添加一个邻结点到open表 */
  private void addNeighborNodeInOpen(MapInfo mapInfo, Node current, int x, int y, int value) {
    if (canAddNodeToOpen(mapInfo, x, y)) {
      Node end = mapInfo.end;
      Coord coord = new Coord(x, y);
      // 计算邻结点的G值
      int g = current.g + value;
      Node child = findNodeInOpen(coord);
      if (child == null) {
        // 计算H值
        int h = calcH(end.coord, coord);
        if (isEndNode(end.coord, coord)) {
          child = end;
          child.parent = current;
          child.g = g;
          child.h = h;
        } else {
          child = new Node(coord, current, g, h);
        }
        openList.add(child);
      } else if (child.g > g) {
        child.g = g;
        child.parent = current;
        openList.add(child);
      }
    }
  }

  /** 从Open列表中查找结点 */
  private Node findNodeInOpen(Coord coord) {
    if (coord == null || openList.isEmpty()) {
      return null;
    }
    for (Node node : openList) {
      if (node.coord.equals(coord)) {
        return node;
      }
    }
    return null;
  }

  /** 计算H的估值：“曼哈顿”法，坐标分别取差值相加 */
  private int calcH(Coord end, Coord coord) {
    return Math.abs(end.x - coord.x) + Math.abs(end.y - coord.y);
  }

  /** 判断结点是否是最终结点 */
  private boolean isEndNode(Coord end, Coord coord) {
    return end.equals(coord);
  }

  /** 判断结点能否放入Open列表 */
  private boolean canAddNodeToOpen(MapInfo mapInfo, int x, int y) {
    // 是否在地图中
    if (x < 0 || x >= mapInfo.width || y < 0 || y >= mapInfo.height) {
      return false;
    }
    // 判断是否是不可通过的结点
    if (mapInfo.maps[y][x] == BAR) {
      return false;
    }
    // 判断结点是否存在close表
    return !isCoordInClose(x, y);
  }

  /** 判断坐标是否在close表中 */
  private boolean isCoordInClose(Coord coord) {
    return coord != null && isCoordInClose(coord.x, coord.y);
  }

  /** 判断坐标是否在close表中 */
  private boolean isCoordInClose(int x, int y) {
    if (closeList.isEmpty()) {
      return false;
    }
    for (Node node : closeList) {
      if (node.coord.x == x && node.coord.y == y) {
        return true;
      }
    }
    return false;
  }
}
