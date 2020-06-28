# 学习笔记

## 关于HashMap的小总结

### 概念

HashMap是采用key->value形式，key可以为null，但不能重复。value可以重复，也可以为null

默认容量是16，扩充因子是0.75，也就是说put元素个数超过16* 0.75=12后，会自动扩充一倍，容量到32

### 基本结构

#### java8之前

HashMap是数组+链表结构

把key的hashcode经过散列函数获取到hash值，然后通过（n-1）&hash判断当前元素存放位置（n是数组的长度，初始时候是16）

使用散列函数原因是为了减少hash碰撞，尽量均匀放入数组，毕竟通过拉链法放入链表，链表可以很长，这样搜索时候本来时间复杂度是O(1)就会退化为O(n)

如果当前位置已存在元素，就判断已有元素和要存入元素的hash值以及key是否相同，相同就覆盖，不相同就放在链表后面一个元素里（也称之为拉链法）

拉链法就是数组和链表相结合，创建一个链表数组，数组中每个元素就是一个链表，遇到hash碰撞，就将冲突的值放到链表后面一个元素里

但是在多线程并发扩容情况下，HashMap的链表元素会形成循环引用的问题，具体可见[https://coolshell.cn/articles/9606.html](https://coolshell.cn/articles/9606.html)

#### 从java8开始及之后版本

hash碰撞解决方法有改变，链表长度大于阈值(默认为8)，链表转为红黑树，搜索时间复杂度从O(n)变为O(logn)

java8开始解决了链表元素循环引用的问题，但是并发情况，推荐使用ConcurrentHashMap

另外Java8之后版本有两点优化
1. 将key的hash值变成二进制，右移16位取异或值

源码如下 
```
    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
```

目的是为了减少哈希碰撞概率，即使有两个hash值的低16位相同或相似，取异或能让低16位有高16位特征，也能做区分，不会散列函数后进入同一个链表，也能减少哈希碰撞概率

2. hash值对数组长度取模等同于hash值和数组长度－1的取与操作

hash % n=(n - 1) & hash

目的是hash值的高16位都是和0取与，不需做计算，直接得出0，减少运算时间，更加高效

但是这个公式成立的前提是n也就是**数组长度必须是2的幂**，否则等式不成立的。因此初始化HashMap时，若指定容量初始值不是2的幂，它会用附录中tableSizeFor方法将容量初始值变为2的幂。若没有指定容量初始值，HashMap默认容量是16也是2的幂，所以这也是HashMap的长度不管如何都是2的幂的原因

### 源码分析

主要是put和get方法分析

#### put方法

源码
```
    public V put(K key, V value) {
        return putVal(hash(key), key, value, false, true);
    }
    
    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
        Node<K,V>[] tab; Node<K,V> p; int n, i;
        // 1. tab为空则创建
        if ((tab = table) == null || (n = tab.length) == 0)
            n = (tab = resize()).length;
        // 2. 计算index，并对null做处理    
        if ((p = tab[i = (n - 1) & hash]) == null)
            tab[i] = newNode(hash, key, value, null);
        else {
            Node<K,V> e; K k;
            // 3. 节点key存在，直接覆盖value
            if (p.hash == hash &&
                ((k = p.key) == key || (key != null && key.equals(k))))
                e = p;
            // 4. 判断是否为红黑树节点    
            else if (p instanceof TreeNode)
                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
            // 5. 如果是链表
            else {
                for (int binCount = 0; ; ++binCount) {
                    if ((e = p.next) == null) {
                        p.next = newNode(hash, key, value, null);
                        //链表长度大于8转换为红黑树进行处理
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                            treeifyBin(tab, hash);
                        break;
                    }
                    // key已存在就覆盖value
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    p = e;
                }
            }
            if (e != null) { // existing mapping for key
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;
                afterNodeAccess(e);
                return oldValue;
            }
        }
        ++modCount;
        //6. 超过最大容量就扩容
        if (++size > threshold)
            resize();
        afterNodeInsertion(evict);
        return null;
    }
```
1. 判断键值对数组tab[i]是否为空或为null，否则执行resize()进行扩容
2. 根据键值key计算hash值得到插入的数组索引i，如果table[i]==null，直接新建节点添加，转向6，如果不为空，转向3
3. 判断tab[i]的首个元素是否和key一样，如果相等直接覆盖value，否则转向4，这里相等指的是hashCode以及equals都要相等
4. 判断tab[i]是否为treeNode，即table[i]是否是红黑树，如果是红黑树，则直接在树中插入键值对，否则下一步
5. 遍历tab[i]，判断链表长度是否大于8，大于8的话把链表转换为红黑树，在红黑树中执行插入操作，否则进行链表的插入操作；遍历中若发现key已存在就覆盖value
6. 插入成功后，判断实际存在的键值对数量size是否超过了最大容量threshold，如果超过，进行扩容

#### get方法

源码
   
```
     public V get(Object key) {
        Node<K,V> e;
        return (e = getNode(hash(key), key)) == null ? null : e.value;
    }
    
    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
    
    final Node<K,V> getNode(int hash, Object key) {
        Node<K,V>[] tab; Node<K,V> first, e; int n; K k;
        //1. 得到tab数组的index,查看tab[index]是否有值
        if ((tab = table) != null && (n = tab.length) > 0 &&
            (first = tab[(n - 1) & hash]) != null) {
            //2. 判断tab[index]的首个元素是否和key一样，如果相等直接拿出来值返回，否则下一步
            if (first.hash == hash && // always check first node
                ((k = first.key) == key || (key != null && key.equals(k))))
                return first;
            //3. 是否有下一个链表元素
            if ((e = first.next) != null) {
                //4. 如果是TreeNode,说明采用的是数组+红黑树结构。遍历红黑树，得到节点值
                if (first instanceof TreeNode)
                    return ((TreeNode<K,V>)first).getTreeNode(hash, key);
                //5. 如果是链表，循环遍历和2一样判断的方法，返回值    
                do {
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        return e;
                } while ((e = e.next) != null);
            }
        }
        return null;
    }
```
1. 通过hash & (length-1)得到tab数组的index,查看tab[index]是否有值，如有继续下一步，没有就返回null
2. 判断tab[index]的首个元素是否和key一样，如果相等直接拿出来值返回，否则下一步，这里相等同样指的是hashCode以及equals都要相等
3. 是否有下一个链表元素
4. 如果是TreeNode,说明采用的是数组+红黑树结构。遍历红黑树，得到节点值
5. 如果是链表，循环遍历和2一样判断方法，返回值（也就是说元素个数没有超过8个，do-while循环最多循环7次）    


