# 学习笔记

## 用addFirst或addLast改写Deque代码

addFirst

```
import java.util.ArrayDeque;
import java.util.Deque;

public class AddFirstDeque {
  public static void main(String[] args) {
    Deque<String> deque = new ArrayDeque<>();
    deque.addFirst("a");
    deque.addFirst("b");
    deque.addFirst("c");

    String str = deque.peek();
    System.out.println(str);
    System.out.println(deque);

    while (deque.size() > 0) {
      System.out.println(deque.pop());
    }

    System.out.println(deque);
  }
}
```

addLast

```
import java.util.ArrayDeque;
import java.util.Deque;

public class AddLastDeque {
  public static void main(String[] args) {
    Deque<String> deque = new ArrayDeque<>();

    deque.addLast("c");
    deque.addLast("b");
    deque.addLast("a");

    String str = deque.peek();
    System.out.println(str);
    System.out.println(deque);

    while (deque.size() > 0) {
      System.out.println(deque.pop());
    }

    System.out.println(deque);
  }
}
```


## Queue和PriorityQueue解析

### Queue

Queue是个接口，用于模拟队列。采用“先进先出FIFO”的规则，插入在一端，删除则在另一端。入队（offer）在队尾，出队（poll）在队头

待实现接口方法

```
boolean add(E e);
boolean offer(E e);
E remove();
E poll();
E element();
E peek();
```


### PriorityQueue

JDK1.5集合引入，PriorityQueue<E>为优先级队列，优先级队列不同于常规的先进先出(FIFO)队列，PriorityQueue<E>每次从队列中取出的是具有最高优先权的元素。

如果不提供Comparator<E>接口的实现，优先队列中的元素默认按照自然顺序排列(数组默认小的在前，字符串按照编码计算)

示例
```
public static void main(String[] args) {
      Queue<Integer> priorityQueue = new PriorityQueue<>();
      priorityQueue.add(1);
      priorityQueue.add(4);
      priorityQueue.add(2);
      priorityQueue.add(3);

      System.out.println(priorityQueue.poll());
      System.out.println(priorityQueue.poll());
}
```
打印结果为
![1b483be459fee759f371f583610d4cf7.png](evernotecid://EECEFF39-1E5A-4B28-96AD-8ED20B2D6B48/appyinxiangcom/3657952/ENResource/p17700)

按照从小到大排列

如果提供了Comparator<E>接口的实现，那么就会按照Comparator<E>提供的规则进行排序

内部实现依然是数组，PriorityQueue<E>使用queue-数组、size-长度、comparator-比较机制。

PriorityQueue<E>重载了7个构造方法：

```
public PriorityQueue()

public PriorityQueue(int initialCapacity)

public PriorityQueue(Comparator<? super E> comparator)

public PriorityQueue(int initialCapacity, Comparator<? super E> comparator)

public PriorityQueue(Collection<? extends E> c)

public PriorityQueue(PriorityQueue<? extends E> c)

public PriorityQueue(SortedSet<? extends E> c)
```

注 无参构造函数初始化时，队列默认长度为11，当使用其他构造函数时，默认长度是显示指定的长度或者传入集合的长度

PriorityQueue方法实现是完全遵照Queue接口定义，但在内部实现上，每加入一个新的元素会对队列进行重排序构造
