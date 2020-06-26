package com.algorithm.class4;

import java.util.Stack;

/**
 * 155. 最小栈
 *
 * <p>设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * <p>push(x) —— 将元素 x 推入栈中。 pop() —— 删除栈顶的元素。 top() —— 获取栈顶元素。 getMin() —— 检索栈中的最小元素。
 *
 * <p>示例:
 *
 * <p>输入： ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * <p>输出： [null,null,null,null,-3,null,0,-2]
 *
 * <p>解释： MinStack minStack = new MinStack(); minStack.push(-2); minStack.push(0);
 * minStack.push(-3); minStack.getMin(); --> 返回 -3. minStack.pop(); minStack.top(); --> 返回 0.
 * minStack.getMin(); --> 返回 -2.
 *
 * <p>提示：
 *
 * <p>pop、top 和 getMin 操作总是在 非空栈 上调用。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/min-stack
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/6/27 00:37<br>
 */
public class MinStack {
  private Stack<Integer> stack;
  private Stack<Integer> minStack;

  public MinStack() {
    stack = new Stack<>();
    minStack = new Stack<>();
  }

  public void push(int x) {
    stack.push(x);
    if (minStack.isEmpty() || x <= minStack.peek()) {
      minStack.push(x);
    }
  }

  public void pop() {
    if (stack.pop().equals(minStack.peek())) {
      minStack.pop();
    }
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return minStack.peek();
  }
}
