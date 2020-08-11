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




