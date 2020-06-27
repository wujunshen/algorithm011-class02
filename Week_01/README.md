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

## 第一周学习总结

老实说，我感觉我很多题解都没看懂，就不要说后面再自己写好几遍代码去运行了。而且我是用idea的，那个leetcode插件我感觉超级不好用。但是第一周很多题目还是自己要手打一遍。不管自己理解不理解，手一定要熟。

周中时候微信了覃老师一个问题，老师给了我一个知乎连接。链接如下

[https://www.zhihu.com/question/387295413/answer/1154369980](https://www.zhihu.com/question/387295413/answer/1154369980)

我觉得说的很对，现在就是题数加遍数不够导致的。既然如此，先像知乎这篇文章说的，先模仿吧。我不知道还会需要模仿多久，但至少先模仿起来。


目前我对一周周的学习计划如下

1. 周一到周三把视频多次播放看熟悉，当中提到的各种leetcode问题，都至少保证手打好几遍，我觉得至少三遍吧
2. 周四开始做作业，相应的题目在看懂题目，和理解题解基础上，继续手打,估计要花3天时间
3. 周日空出来看预习题目，并复习本周视频，再一次手打一遍视频中说到的题目代码

不知道这样的学习计划会怎么样，反正先按照这个做吧，第五周就要考试了，有点没信心啊

下面是我针对第一周老师视频自己做的笔记和总结

### 数组

数组是用来存储固定大小的同类型元素的

java里声明数组变量方式如下

```
double[] myArray; // 首选
double myArray[]; 
```

创建数组方式如下

```
Integer[] array = new Integer[arraySize];
Integer[] array = {1, 2, ..., 100};
```

还可以有多维数组
```
String s[][] = new String[2][];
s[0] = new String[2];
s[1] = new String[3];
s[0][0] = new String("Good");
s[0][1] = new String("Luck");
s[1][0] = new String("to");
s[1][1] = new String("you");
s[1][2] = new String("!");
```

#### Arrays类

java.util.Arrays类能方便地操作数组，它提供的所有方法都是静态的

* 给数组赋值：通过fill方法
* 对数组排序：通过sort方法,按升序
* 比较数组：通过equals方法比较数组中元素值是否相等
* 查找数组元素：通过binarySearch方法能对排序好的数组进行二分查找法操作

### 链表

链表在进行循环遍历时效率不高，但是插入和删除时优势明显。java中最出名的是LinkedList

目前主要是单向链表，它是一种线性表，由节点（Node）组成的，一个链表拥有不定数量的节点。其数据在内存中存储是不连续的，它存储的数据分散在内存中，每个结点只能也只有它能知道下一个结点的存储位置。由N各节点（Node）组成单向链表，每一个Node记录自己这个Node的数据及下一个Node。向外暴露的只有一个头节点（Head），我们对链表的所有操作，都是直接或者间接地通过其头节点来进行的。

添加节点的顺序是从右向左的。最先添加的节点对下一节点的引用可以为空。引用是引用下一个节点而非下一个节点的对象。因为有着不断的引用，所以头节点就可以操作所有节点了。

总结：节点拥有两个成员：储存的对象、对下一个节点的引用

另外说一句，数组和链表的区别是数组中每个元素存放的物理地址是连续的，而链表中是不连续的

下面说一下LinkedList

#### LinkedList

LinkedList和ArrayList都实现了List接口，但其内部的数据结构不一样。LinkedList基于链表实现的（通过名字也能区分开来），它的插入和删除操作比ArrayList更高效。但随机访问的效率要比ArrayList差。

jdk源码（java11）
```
public class LinkedList<E>
     extends AbstractSequentialList<E>
     implements List<E>, Deque<E>, Cloneable, java.io.Serializable
```
由源码可知

* LinkedList是一个继承AbstractSequentialList的双向链表。它可当作堆栈、队列或双端队列进行操作
* LinkedList实现List接口，能对它进行队列操作
* LinkedList实现Deque接口，即能当作双端队列使用
* LinkedList实现Cloneable接口，即覆盖了函数clone()，能克隆
* LinkedList实现java.io.Serializable接口，所以它支持序列化，能通过序列化去传输
* LinkedList是非同步的

##### 数据结构

底层的数据结构是基于双向链表，且头结点中不存放数据

双向链表节点实例保存数据，还有前一个节点的位置信息和后一个节点位置信息

##### 私有属性

```
transient int size = 0;

transient Node<E> first;

transient Node<E> last;
```

first是双向链表的头节点，它是双向链表节点所对应的类Node实例。Node中包含成员变量: prev, next, item。prev是上一个节点，next是下一个节点，item是自身所包含的值。size是双向链表中节点实例个数。

Node类源码
```
 private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
}
```

##### 构造方法
LinkedList提供了两个构造方法。

```
public LinkedList() {
}

public LinkedList(Collection<? extends E> c) {
    this();
    addAll(c);
}
```

##### 添加元素
```
public void add(int index, E element) {
    checkPositionIndex(index);
    if (index == size)
        linkLast(element);
    else
        linkBefore(element, node(index));
}
private void checkPositionIndex(int index) {
 	if (!isPositionIndex(index))
        throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
}
void linkBefore(E e, Node<E> succ) {
	// 先找出当前节点的前一个节点
    final Node<E> pred = succ.prev;
    final Node<E> newNode = new Node<>(pred, e, succ);
    succ.prev = newNode;
    if (pred == null)
        first = newNode;
    else
        pred.next = newNode;
    size++;
    modCount++;
}
 /**
  * 根据索引来找节点
  */
Node<E> node(int index) {
    // assert isElementIndex(index);
    if (index < (size >> 1)) {  // 先判断给的index是否大于二分之一的size
        Node<E> x = first; // 如果小于，从first开始
        for (int i = 0; i < index; i++)
            x = x.next;
        return x;
    } else {
        Node<E> x = last; // 如果大于，就从last开始找
        for (int i = size - 1; i > index; i--)
            x = x.prev;
        return x;
    }
}
```
根据传入的index，判断是大于二分之一的size，还是小于，如果小于二分之一的size，从first开始找；如果大于二分之一的size，从last开始找

##### 删除元素

```
E unlink(Node<E> x) {
    final E element = x.item;
    final Node<E> next = x.next;
    final Node<E> prev = x.prev;

    if (prev == null) {
        first = next;
    } else {
        prev.next = next;
        x.prev = null;  
    }

    if (next == null) {
        last = prev;
    } else {
        next.prev = prev;
        x.next = null;
    }

    x.item = null;
    size--;
    modCount++;
    return element;
}
```
第一个判断是否为first结点
是: first引用直接指向当前节点下一个节点
否: 前一个节点的next引用指向下一个节点
第二个判断是否为last节点
是: 最后的last的引用指向前一个节点
否: 下一个节点的pre指向前一个节点

##### 迭代器
```
private class ListItr implements ListIterator<E> {
    private Node<E> lastReturned;
    private Node<E> next;
    private int nextIndex;
    private int expectedModCount = modCount;

    ListItr(int index) {
        // assert isPositionIndex(index);
        next = (index == size) ? null : node(index);
        nextIndex = index;
    }

    public boolean hasNext() {
        return nextIndex < size;
    }

    public E next() {
        checkForComodification();
        if (!hasNext())
            throw new NoSuchElementException();

        lastReturned = next;
        next = next.next;
        nextIndex++;
        return lastReturned.item;
    }

    public boolean hasPrevious() {
        return nextIndex > 0;
    }

    public E previous() {
        checkForComodification();
        if (!hasPrevious())
            throw new NoSuchElementException();

        lastReturned = next = (next == null) ? last : next.prev;
        nextIndex--;
        return lastReturned.item;
    }

    public int nextIndex() {
        return nextIndex;
    }

    public int previousIndex() {
        return nextIndex - 1;
    }

    public void remove() {
        checkForComodification();
        if (lastReturned == null)
            throw new IllegalStateException();

        Node<E> lastNext = lastReturned.next;
        unlink(lastReturned);
        if (next == lastReturned)
            next = lastNext;
        else
            nextIndex--;
        lastReturned = null;
        expectedModCount++;
    }

    public void set(E e) {
        if (lastReturned == null)
            throw new IllegalStateException();
        checkForComodification();
        lastReturned.item = e;
    }

    public void add(E e) {
        checkForComodification();
        lastReturned = null;
        if (next == null)
            linkLast(e);
        else
            linkBefore(e, next);
        nextIndex++;
        expectedModCount++;
    }

    public void forEachRemaining(Consumer<? super E> action) {
        Objects.requireNonNull(action);
        while (modCount == expectedModCount && nextIndex < size) {
            action.accept(next.item);
            lastReturned = next;
            next = next.next;
            nextIndex++;
        }
        checkForComodification();
    }

    final void checkForComodification() {
        if (modCount != expectedModCount)
            throw new ConcurrentModificationException();
    }
}
```
循环删除需要使用这个

应用代码

```
LinkedList<Integer> linkedList = new LinkedList<>();
Iterator<Integer> iterator = linkedList.iterator();
while (iterator.hasNext()) {
    iterator.remove();
}
```

### 跳表

跳表是一种各方面性能都比较优秀的动态数据结构，可以支持快速的插入、删除、查找操作

链表加多级索引的结构，提升查询元素效率。就像一本书，找其中相关内容，可以通过目录依次找到自己需要找到的章节

### 栈

在表尾进行插入和删除操作的线性表。分栈顶，栈底。向一个栈插入新元素称作进栈、入栈或压栈，把新元素放到栈顶元素的上面，使之成为新的栈顶元素；从一个栈删除元素又称作出栈或退栈，把栈顶元素删除掉，使其相邻的元素成为新的栈顶元素。元素是先进后出（FILO）

java中Stack方法包括

* push(num) //入栈
* pop() //栈顶元素出栈
* empty() //判定栈是否为空
* peek() //获取栈顶元素
* search(num) //判端元素num是否在栈中，如果在返回1，不在返回-1。

pop()和peek()区别。pop()会弹出栈顶元素并返回栈顶的值，peek()只获取栈顶的值，栈中元素不会变化

### 队列

队列的两端都可进出元素，要求数据只能从一端进，从另一端出。是先进先出（FIFO）

### 双端队列

具有栈和队列特性的数据结构是就是双端队列，java里就是Deque类


| 队列方法 | deque方法  |
| --- | --- |
| add(e) | addLast(e)  |
| offer(e) | offerLast(e)  |
| remove() | removeFirst() |
| poll() | pollFirst() |
| element() | getFirst()  |
| peek() | peekFirst()  |

当队列用时（FIFO），添加元素是添加到队尾，删除时删除的是头部元素
当栈用（FILO）。这时入栈、出栈元素都是在双端队列的头部进行

| 栈方法 | deque方法  |
| --- | --- |
| push(e) | addFirst(e)  |
| pop() | removeFist()  |
| peek() | peekFirst() |

### 优先队列

java里优先队列PriorityQueue是Queue接口的实现，可以对其中元素进行排序，

可以放基本数据类型的包装类（如Integer，Long等）或自定义的类

对于基本数据类型的包装器类，优先队列中元素默认排列顺序是升序排列（从小到大）

但对于自己定义的类来说，需要自己定义比较器

#### 常用方法
* peek()//返回队首元素
* poll()//返回队首元素，队首元素出队列
* add()//添加元素
* size()//返回队列元素个数
* isEmpty()//判断队列是否为空，为空返回true,不空返回false

#### 原理
PriorityQueue是基于最小堆原理实现。最小堆是一种经过排序的完全二叉树，其中任一非终端节点的数据值均不大于其左子节点和右子节的值

插入、删除操作的时间复杂度为 O(log(n))

