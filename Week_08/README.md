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


初级排序

高级排序

特殊排序

SortTest.java是测试类




