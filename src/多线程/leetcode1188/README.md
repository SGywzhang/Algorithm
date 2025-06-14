# LeetCode 1188. 设计有限阻塞队列 (Design Bounded Blocking Queue)

## 题目描述

实现一个拥有固定容量的线程安全阻塞队列。

你的实现需要支持以下操作：
- `BoundedBlockingQueue(int capacity)` 初始化队列，容量为 capacity。
- `void enqueue(int element)` 将元素加入队列，如果队列满则阻塞。
- `int dequeue()` 移除队首元素并返回，如果队列空则阻塞。
- `int size()` 返回当前队列元素个数。

---

**示例 1：**

```
输入:
BoundedBlockingQueue queue = new BoundedBlockingQueue(2);
queue.enqueue(1);
queue.enqueue(2);
queue.dequeue(); // 返回 1
queue.enqueue(3);
queue.dequeue(); // 返回 2
queue.dequeue(); // 返回 3
queue.size();    // 返回 0
```

**提示：**
- 1 <= capacity <= 1000
- 1 <= element <= 1000
- 最多调用 1000 次 enqueue, dequeue 和 size 方法
- 多线程环境下调用 