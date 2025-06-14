# LeetCode 1115. 交替打印 FooBar (Print FooBar Alternately)

## 题目描述

编写一个可以从 1 到 n 输出 "foobar" 的程序，要求输出 n 次。

其中有两个线程，一个输出 "foo"，另一个输出 "bar"。

---

**示例 1：**

```
输入: n = 2
输出: "foobarfoobar"
解释: 有两个线程被异步启动，一个调用 foo()，另一个调用 bar()。
"foo" 和 "bar" 交替输出 n 次。
```

**提示：**
- 1 <= n <= 1000 