package com.algorithm.class7;

import com.algorithm.common.BinaryTreeNode;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * 297. 二叉树的序列化与反序列化
 *
 * <p>序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 *
 * <p>请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 *
 * <p>示例:
 *
 * <p>你可以将以下二叉树：
 *
 * <p>1 / \ 2 3 / \ 4 5
 *
 * <p>序列化为 "[1,2,3,null,null,4,5]" 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode
 * 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 *
 * <p>说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/7 17:08<br>
 */
public class SerializeAndDeserializeBinaryTree {
  public String serialize(BinaryTreeNode root) {
    String res = serializedByPre(root);
    return "[" + res.substring(0, res.length() - 1) + "]";
  }

  public String serializedByPre(BinaryTreeNode root) {
    if (root == null) {
      return "null,";
    }
    String res = root.val + ",";
    res += serializedByPre(root.left);
    res += serializedByPre(root.right);
    return res;
  }

  public BinaryTreeNode deserialize(String data) {
    String[] array = data.substring(1, data.length() - 1).split(",");
    Queue<String> queue = new LinkedList<>();
    for (String s : array) {
      queue.offer(s);
    }
    return deserializedByPre(queue);
  }

  public BinaryTreeNode deserializedByPre(Queue<String> queue) {
    String value = queue.poll();
    if (Objects.equals(value, "null")) {
      return null;
    }
    BinaryTreeNode cur = new BinaryTreeNode(Integer.parseInt(value));
    cur.left = deserializedByPre(queue);
    cur.right = deserializedByPre(queue);
    return cur;
  }
}
