# LeetCode 158. 用 Read4 读取 N 个字符 II (Read N Characters Given Read4 II - Call multiple times)

## 题目描述

与 157 题类似，但 read 方法会被多次调用。实现一个方法 `int read(char[] buf, int n)`，每次调用读取 n 个字符，且要记住上次未读完的内容。

### 输入输出格式
- 输入：字符数组 buf，整数 n
- 输出：实际读取的字符数

### 示例
```
输入: file = "abc", n = 1, read(1), read(2)
输出: 1, 2
解释: 第一次读取 "a"，第二次读取 "bc"
``` 