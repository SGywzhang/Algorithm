# LeetCode 1195. 交替打印 FizzBuzz (Fizz Buzz Multithreaded)

## 题目描述

编写一个可以从 1 到 n 输出字符串的程序，但是：
- 如果这个数可以被 3 整除，输出 "fizz"。
- 如果这个数可以被 5 整除，输出 "buzz"。
- 如果这个数可以同时被 3 和 5 整除，输出 "fizzbuzz"。
- 否则，输出数字本身。

要求用四个线程分别打印 fizz、buzz、fizzbuzz 和数字。

---

**示例 1：**

```
输入: n = 15
输出: "1 2 fizz 4 buzz fizz 7 8 fizz buzz 11 fizz 13 14 fizzbuzz"
```

**提示：**
- 1 <= n <= 50 