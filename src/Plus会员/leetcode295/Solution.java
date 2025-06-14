package Plus会员.leetcode295;

import java.util.*;

/**
 * 数据流中位数查找器
 */
public class Solution {
    static class MedianFinder {
        private PriorityQueue<Integer> maxHeap; // 存储较小的一半
        private PriorityQueue<Integer> minHeap; // 存储较大的一半
        
        /**
         * 初始化数据结构
         */
        public MedianFinder() {
            maxHeap = new PriorityQueue<>((a, b) -> b - a); // 大顶堆
            minHeap = new PriorityQueue<>(); // 小顶堆
        }
        
        /**
         * 添加数字到数据流
         * @param num 要添加的数字
         */
        public void addNum(int num) {
            if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                maxHeap.offer(num);
            } else {
                minHeap.offer(num);
            }
            
            // 平衡两个堆的大小
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.offer(maxHeap.poll());
            } else if (minHeap.size() > maxHeap.size() + 1) {
                maxHeap.offer(minHeap.poll());
            }
        }
        
        /**
         * 返回当前中位数
         * @return 中位数
         */
        public double findMedian() {
            if (maxHeap.size() == minHeap.size()) {
                return (maxHeap.peek() + minHeap.peek()) / 2.0;
            } else if (maxHeap.size() > minHeap.size()) {
                return maxHeap.peek();
            } else {
                return minHeap.peek();
            }
        }
    }
    
    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(1);
        mf.addNum(2);
        System.out.println(mf.findMedian()); // 1.5
        mf.addNum(3);
        System.out.println(mf.findMedian()); // 2.0
    }
} 