# LeetCode 157. 用 Read4 读取 N 个字符 (Read N Characters Given Read4)

## 题目描述

给你一个文件和一个能够读取文件的 API `int read4(char[] buf4)`，每次调用最多读取 4 个字符。请实现一个方法 `int read(char[] buf, int n)`，读取 n 个字符。

### 输入输出格式
- 输入：字符数组 buf，整数 n
- 输出：实际读取的字符数

### 示例
```
输入: file = "abc", n = 4
输出: 3
解释: 实际读取了 "abc"
``` 