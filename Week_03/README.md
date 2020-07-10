# 学习笔记

## 递归

递归就是自己调用自己，把一个问题分解成可以同样操作的子问题

### 形成条件
* 子问题须与原始问题解决算法是同样一个算法
* 不能无限制地调用自己，必须有个出口，化为非递归状况
 
### 使用场景
1. 数据定义是按递归定义的（Fibonacci方法）
2. 问题解法按递归算法实现
   这类问题虽然本身没有明显的递归结构，但用递归比迭代求解更简单（汉诺塔问题）
3. 数据结构形式是按递归定义的（树）

二叉树从任意一个节点拆开，依然是一颗二叉树。换句话说，二叉树天生就可以把问题分解成子问题，而这类问题一般都是采用递归解决的

### 代码模板

```
  public void recur(int level, int param) {
     terminator
     if (level > MAX_LEVEL) {
        // process result
        return;
     }
            
     // process current logic
     process(level, param);
     
     // drill down
     recur(level + 1, newParam);
     restore current status
  }
```

## 分治

### 概念

将一个规模为N的问题分解为K个规模较小的子问题，这些子问题相互独立且与原问题性质相同。求出子问题的解，就可得到原问题的解。即一种分目标完成的算法

### 形成条件

1. 问题规模缩小到一定程度就可轻易解决
2. 问题可分解为若干个规模较小的相同问题，即该问题具有最优子结构性质
3. 利用该问题分解出的子问题解可合并成该问题的解
4. 问题分解出的各个子问题是相互独立的，即子问题之间不包含公共的子子问题

第1个是绝大多数问题都可满足的，因为问题的计算复杂性一般是随着问题规模的增加而增加
第2个是应用分治法的前提，它也是大多数问题都可满足，此特征反映了递归思想
第3个是关键，能否利用分治法完全取决于问题是否具有这个特征，如果具备前两个，而不具备第3个，则可考虑用贪心法或动态规划
第4个涉及到分治法效率，如果各子问题是不独立的，则分治法要做许多不必要的工作，重复地解公共的子问题，此时虽然可用分治法，但一般用动态规划法比较好

### 使用场景

降低问题求解的时间复杂度，解决海量数据处理问题等

### 代码模板

```
   public void recur(Problem problem) {
     //terminator
     if (problem == null) {
     //print result
        return;
     }

     //prepare data
     data = prepareData(problem);
     Array[] subProblems = splitProblem(problem, data);
     //conquer subProblems
     subResult1 = self.divideConquer(subProblems[0], p1, ...)
     subResult2 = self.divideConquer(subProblems[1], p1, ...)
     subResult3 = self.divideConquer(subProblems[2], p1, ...)

     //process and generate the final result
     result = processResult(subResult1, subResult2, subResult3, …);

     //revert the current level states
     }
```

## 回溯

### 概念

又称试探法。从问题的某一状态出发，不断“试探”着往前走一步，当一条路走到“尽头”，不能再前进（拓展出新状态）时，再倒回一步或者若干步，从另一种可能的状态出发，继续搜索，直到所有的“路径”都试探过了。这种不断前进、不断回溯，寻找解的方法，称为回溯法

### 形成条件

回溯实际上就是一个决策树的遍历过程

* 路径
  也就是已经做出的选择
* 选择列表
  也就是当前可以做的选择
* 结束条件
  到达决策树底层，无法再做选择的条件
 
### 使用场景

搜索算法、数独、八皇后问题、全排列、正则表达式匹配和编译原理中语法分析等

### 代码模板
```
   List<String> result =new ArrayList<>();

   public void backTrack(path,choiceList){
       //满足结束条件
       if (condition){
           result.add(path);
           return; 
       }

       for( Choice choice:choiceList){
           //做选择
           backtrack(path, choiceList);
           //撤销选择
       } 
   }
```
