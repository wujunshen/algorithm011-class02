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

### 递归代码模板

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