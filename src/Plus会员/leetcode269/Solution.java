package Plus会员.leetcode269;

import java.util.*;

public class Solution {

    public String alienOrder(String[] words) {
        Map<Character, >
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例1: 正常情况
        String[] words1 = {"wrt","wrf","er","ett","rftt"};
        System.out.println("Test Case 1:");
        System.out.println("Input: " + Arrays.toString(words1));
        System.out.println("Output: " + solution.alienOrder(words1));
        System.out.println("Expected: wertf");
        System.out.println();

        // 测试用例2: 简单顺序
        String[] words2 = {"z","x"};
        System.out.println("Test Case 2:");
        System.out.println("Input: " + Arrays.toString(words2));
        System.out.println("Output: " + solution.alienOrder(words2));
        System.out.println("Expected: zx");
        System.out.println();

        // 测试用例3: 无效情况(前缀规则)
        String[] words3 = {"abc","ab"};
        System.out.println("Test Case 3:");
        System.out.println("Input: " + Arrays.toString(words3));
        System.out.println("Output: " + solution.alienOrder(words3));
        System.out.println("Expected: ");
        System.out.println();

        // 测试用例4: 单字母单词
        String[] words4 = {"a","aa","aaa","aaaa"};
        System.out.println("Test Case 4:");
        System.out.println("Input: " + Arrays.toString(words4));
        System.out.println("Output: " + solution.alienOrder(words4));
        System.out.println("Expected: a");
        System.out.println();

        // 测试用例5: 复杂顺序
        String[] words5 = {"vlxpwiqbsg","cpwqwqcd"};
        System.out.println("Test Case 5:");
        System.out.println("Input: " + Arrays.toString(words5));
        System.out.println("Output: " + solution.alienOrder(words5));
        System.out.println("Expected: vlxpwiqbsgcd (or other valid order)");
        System.out.println();

        // 测试用例6: 空输入
        String[] words6 = {};
        System.out.println("Test Case 6:");
        System.out.println("Input: " + Arrays.toString(words6));
        System.out.println("Output: " + solution.alienOrder(words6));
        System.out.println("Expected: ");
        System.out.println();

        // 测试用例7: 单个单词
        String[] words7 = {"hello"};
        System.out.println("Test Case 7:");
        System.out.println("Input: " + Arrays.toString(words7));
        System.out.println("Output: " + solution.alienOrder(words7));
        System.out.println("Expected: ehlo (or other permutation)");
        System.out.println();

        // 测试用例8: 环的情况
        String[] words8 = {"a","b","a"};
        System.out.println("Test Case 8:");
        System.out.println("Input: " + Arrays.toString(words8));
        System.out.println("Output: " + solution.alienOrder(words8));
        System.out.println("Expected: ");
    }
}
