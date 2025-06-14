# LeetCode 379. 电话目录管理器 (Design Phone Directory)

## 题目描述

设计一个电话目录管理器，支持获取、检查和释放电话号码。

### 输入输出格式
- PhoneDirectory(int maxNumbers): 初始化目录，最大号码数量为 maxNumbers
- int get(): 提供一个未被分配的号码
- boolean check(int number): 检查某号码是否可用
- void release(int number): 释放一个号码

### 示例
```
输入:
["PhoneDirectory","get","get","check","get","check","release","check"]
[[3],[],[],[2],[],[2],[2],[2]]
输出:
[null,0,1,true,2,false,null,true]
``` 