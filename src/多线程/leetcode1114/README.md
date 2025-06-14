# LeetCode 1114. 按序打印 (Print in Order)

## 题目描述

我们提供了一个类：

```java
public class Foo {
  public void first() { print("first"); }
  public void second() { print("second"); }
  public void third() { print("third"); }
}
```

三个不同的线程将会共用一个 Foo 实例。

- 线程 A 将会调用 first() 方法
- 线程 B 将会调用 second() 方法
- 线程 C 将会调用 third() 方法

请设计并实现保证这三个方法按 "first" -> "second" -> "third" 的顺序被调用。

---

**示例 1：**

```
输入: ["Foo", "first", "second", "third"]
输出: [null, null, null, null]
解释:
有三个线程会被异步启动。
输入顺序和输出顺序无关。
"first" 必须在 "second" 之前打印，"second" 必须在 "third" 之前打印。
```

**提示：**
- 1 <= 调用次数 <= 6 