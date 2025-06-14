# LeetCode 10. 正则表达式匹配 (Regular Expression Matching)

## 题目描述

给你一个字符串 s 和一个字符规律 p，请你实现一个支持 '.' 和 '*' 的正则表达式匹配。
- '.' 匹配任意单个字符。
- '*' 匹配零个或多个前面的那一个元素。

匹配应覆盖整个字符串（而不是部分字符串）。

### 输入输出格式
- 输入：字符串 s，字符串 p
- 输出：布尔值，是否匹配

### 示例
```
输入: s = "aa", p = "a"
输出: false

输入: s = "aa", p = "a*"
输出: true

输入: s = "ab", p = ".*"
输出: true

输入: s = "aab", p = "c*a*b"
输出: true

输入: s = "mississippi", p = "mis*is*p*."
输出: false
``` 