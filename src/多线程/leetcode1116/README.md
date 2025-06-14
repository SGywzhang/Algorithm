# LeetCode 1116. 打印零与奇偶数 (Print Zero Even Odd)

## 题目描述

假设有这么一个类：

```java
class ZeroEvenOdd {
  public ZeroEvenOdd(int n) { ... }      // 构造函数
  public void zero(printNumber) { ... }  // 仅打印 0
  public void even(printNumber) { ... }  // 仅打印偶数
  public void odd(printNumber) { ... }   // 仅打印奇数
}
```

零线程会调用 zero()，偶数线程会调用 even()，奇数线程会调用 odd()。

请设计一个程序，使得零线程输出 0，偶数线程输出偶数，奇数线程输出奇数，输出的顺序是 0 1 0 2 0 3 0 4 ... 直到 n。

---

**示例 1：**

```
输入: n = 2
输出: "0102"
```

**示例 2：**

```
输入: n = 5
输出: "0102030405"
```

**提示：**
- 1 <= n <= 1000 