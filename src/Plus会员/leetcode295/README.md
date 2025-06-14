# LeetCode 295. 数据流的中位数 (Find Median from Data Stream)

## 题目描述

设计一个支持以下两个操作的数据结构：
- void addNum(int num) - 从数据流中添加一个整数到数据结构中
- double findMedian() - 返回目前所有元素的中位数

### 输入输出格式
- 输入：addNum 和 findMedian 操作序列
- 输出：findMedian 返回当前中位数

### 示例
```
addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3) 
findMedian() -> 2
``` 