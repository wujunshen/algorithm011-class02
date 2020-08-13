# 学习笔记

## 位运算

### 2进制和10进制转化的java代码

```
private static String binaryToDecimal(int n) {
    StringBuilder str = new StringBuilder();
    while (n != 0) {
      str.insert(0, n % 2);
      n = n / 2;
    }
    return str.toString();
}
```

### 指定位置的位运算

1. x&(~0<<n) x最右边的n位清零
2. (x>>n)&1 得到x的第n位值(0或1)
3. x&(1<<n) 得到x的第n位幂值
4. x|(1<<n) 仅仅将第n位置1
5. x&(~(1<<n)) 仅仅将第n位置为0
6. x&((1<<n)-1) 将x最高位至第n位(包含第n位)清零

### tips
* 快速判断奇偶 x&1==1 奇数 x&1==0 偶数
* x>>1=x * 2的-1次方
* x<<1=x * 2的1次方
* x&-x 代表除最后一位1保留，其它位全部为0
* x&(x-1) 代表将最后一位1变成0
* x&~x =0 
* x ^ 0=x
* x ^ 1...1=~x
* x ^ ~x =1....1
* x ^ x=0

## 布隆过滤器

### 应用场景

####  Redis缓存穿透
黑客发起的恶意攻击或是人为向缓存数据发起了一个缓存和db都不存在的数据查询请求。这个不存在的数据每次请求发现缓存中没有就会去DB查询，这样就失去了缓存存在意义。请求流量大时，可导致DB挂机不可用
  
#### 解决方案
在缓存之前，设置布隆过滤器，实际上是一个bitMap结构。当一个元素被加入时，将这个元素映射成一个位数组中的K个点，把它们置为1。检索时，只要看看这些点是不是都是1就（大约）知道集合中有没有它了。如果这些点有任何一个0，则被检元素一定不存在；如果都是1，则被检元素很可能存在。不存在就直接返回（针对黑客攻击都采用这一方案）

### 资料

布隆过滤器的原理和实现
[https://www.cnblogs.com/cpselvis/p/6265825.html](https://www.cnblogs.com/cpselvis/p/6265825.html) 

使用布隆过滤器解决缓存击穿、垃圾邮件识别、集合判重
[https://blog.csdn.net/tianyaleixiaowu/article/details/74721877](https://blog.csdn.net/tianyaleixiaowu/article/details/74721877)

## LRU Cache

LRU全称是Least Recently Used，即最近最久未使用。LRU算法的设计原则是：如果一个数据在最近一段时间没有被访问到，那么在将来它被访问的可能性也很小。是缓存中一种常见的机制

### 应用场景

Redis的key淘汰策略
缓存可以帮助快速存取数据，但是容量小，LRU思想来自“最近用到的数据被重用的概率比最早用到的数据大的多”，是一种十分高效的key淘汰策略

当缓存空间满了的时候，将最近最少使用的数据从缓存空间中删除以增加可用的缓存空间来缓存新内容。是一个淘汰策略。

内部有一个缓存列表。每当一个缓存数据被访问的时候，这个数据就会被提到列表头部，每次都这样的话，列表的尾部数据就是最近最不常使用的了，当缓存空间不足时，就会删除列表尾部的缓存数据。



## 排序算法

### 作业

初级排序

[https://github.com/wujunshen/algorithm011-class02/tree/master/Week_08/src/com/algorithm/homework/sort/primary](https://github.com/wujunshen/algorithm011-class02/tree/master/Week_08/src/com/algorithm/homework/sort/primary)

高级排序

[https://github.com/wujunshen/algorithm011-class02/tree/master/Week_08/src/com/algorithm/homework/sort/senior](https://github.com/wujunshen/algorithm011-class02/tree/master/Week_08/src/com/algorithm/homework/sort/senior)

特殊排序

[https://github.com/wujunshen/algorithm011-class02/tree/master/Week_08/src/com/algorithm/homework/sort/special](https://github.com/wujunshen/algorithm011-class02/tree/master/Week_08/src/com/algorithm/homework/sort/special)

SortTest.java是测试类

[https://github.com/wujunshen/algorithm011-class02/blob/master/Week_08/src/com/algorithm/homework/sort/SortTest.java](https://github.com/wujunshen/algorithm011-class02/blob/master/Week_08/src/com/algorithm/homework/sort/SortTest.java)

### 资料

十大经典排序算法(动图展示)
[https://www.cnblogs.com/onepixel/p/7674659.html](https://www.cnblogs.com/onepixel/p/7674659.html)

9 种经典排序算法可视化动画
[https://www.bilibili.com/video/av25136272](https://www.bilibili.com/video/av25136272)

6 分钟看完 15 种排序算法动画展示
[https://www.bilibili.com/video/av63851336](https://www.bilibili.com/video/av63851336)




