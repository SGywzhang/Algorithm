# LeetCode 1242. 多线程网页爬虫 (Web Crawler Multithreaded)

## 题目描述

给定一个初始 URL startUrl 和一个 HtmlParser 接口，实现多线程网页爬虫，抓取与 startUrl 属于同一主机名下的所有网页。

HtmlParser 接口定义：
```java
public interface HtmlParser {
    public List<String> getUrls(String url);
}
```

要求：
- 只能抓取与 startUrl 主机名相同的网页。
- 多线程并发抓取。
- 返回所有已访问过的 URL。

---

**示例 1：**

```
输入: startUrl = "http://news.example.com/one.html"
输出: 所有属于 "news.example.com" 的网页 URL
```

**提示：**
- 1 <= url 长度 <= 300
- 最多调用 20 次 getUrls 