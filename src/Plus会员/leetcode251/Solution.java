package Plus会员.leetcode251;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

/**
 * 二维向量迭代器，支持 next 和 hasNext 操作
 */
public class Solution {
    static class Vector2D implements Iterator<Integer> {
        private List<Integer> data;
        private int index;
        /**
         * 构造函数，将二维数组展开为一维列表
         */
        public Vector2D(int[][] vec2d) {
            data = new ArrayList<>();
            for (int[] row : vec2d) {
                for (int num : row) {
                    data.add(num);
                }
            }
            index = 0;
        }
        /**
         * 是否还有下一个元素
         */
        public boolean hasNext() {
            return index < data.size();
        }
        /**
         * 返回下一个元素
         */
        public Integer next() {
            return data.get(index++);
        }
    }
    public static void main(String[] args) {
        int[][] vec2d = {{1,2},{3},{4}};
        Vector2D it = new Vector2D(vec2d);
        // 依次输出所有元素
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println(); // 1 2 3 4
    }
} 