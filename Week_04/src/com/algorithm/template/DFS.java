package com.algorithm.template;

/**
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/13 08:47<br>
 */
public class DFS {
  private static int max = 10;
  /** 访问标记 */
  private static boolean visited[][] = new boolean[max][max];

  /** 坐标范围 */
  private static int map[][] = new int[max][max];
  //  List<Point> dir = new ArrayList<>(); // 方向向量，(x,y)周围的四个方向

  /**
   * 边界条件和约束条件的判断
   *
   * @param x
   * @param y
   * @return
   */
  private static boolean CheckEdge(int x, int y) {
    // 满足条件
    //        if(!visited[x][y] && ) {
    //            return true;}
    //        else{
    //            // 与约束条件冲突
    //            return false;
    //        }
    return false;
  }

  public void dfs(int x, int y) {
    // 标记该节点被访问过
    visited[x][y] = true;
    // 出现目标态G
    //        if(map[x][y]==)         {
    //         // 做相应处理
    //            return;
    //        }
    for (int i = 0; i < 4; i++) {
      //            if(CheckEdge(x+dir[i][0],y+dir[i][1])){
      //                // 按照规则生成下一个节点
      //                dfs(x+dir[i][0],y+dir[i][1]);
      //            }
    }
    // 没有下层搜索节点，回溯
  }
}
