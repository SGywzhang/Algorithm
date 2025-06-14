# LeetCode 288. 唯一单词缩写 (Unique Word Abbreviation)

## 题目描述

单词的缩写需要遵循规则：初始字母+中间字母数量+最后字母。设计一个类来判断给定单词的缩写是否唯一。

### 输入输出格式
- 输入：字典 dictionary，查询单词 word
- 输出：布尔值，缩写是否唯一

### 示例
```
输入: dictionary = ["deer", "door", "cake", "card"]
查询: "dear" -> true (d2r 唯一)
查询: "cart" -> false (c2t 不唯一，与 cake 冲突)
``` 