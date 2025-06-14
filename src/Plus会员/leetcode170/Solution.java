package Plus会员.leetcode170;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * 两数之和 III 数据结构
     * 支持add和find操作
     */
    static class TwoSum {
        private Map<Integer, Integer> map = new HashMap<>(); // 存储数字及出现次数
        /**
         * 添加一个数到数据结构
         * @param number 要添加的数
         */
        public void add(int number) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }
        /**
         * 判断是否存在任意两数之和等于value
         * @param value 目标和
         * @return 是否存在
         */
        public boolean find(int value) {
            for (int num : map.keySet()) {
                int target = value - num;
                if (target == num) {
                    if (map.get(num) > 1) return true; // 需要两个相同的数
                } else if (map.containsKey(target)) {
                    return true;
                }
            }
            return false;
        }
    }
    public static void main(String[] args) {
        TwoSum ts = new TwoSum();
        ts.add(1);
        ts.add(3);
        ts.add(5);
        // 测试用例
        System.out.println(ts.find(4)); // true (1+3)
        System.out.println(ts.find(7)); // false
        ts.add(3);
        System.out.println(ts.find(6)); // true (3+3)
    }
} 