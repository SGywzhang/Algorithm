package Plus会员.leetcode340;

import java.util.HashMap;
import java.util.Map;

/**
 * 至多包含 K 个不同字符的最长子串
 */
public class Solution {
    /**
     * 找到至多包含k个不同字符的最长子串长度
     * @param s 输入字符串
     * @param k 最多不同字符数
     * @return 最长子串长度
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) return 0;
        
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, maxLen = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            
            // 如果不同字符数超过k，收缩左边界
            while (map.size() > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                left++;
            }
            
            maxLen = Math.max(maxLen, right - left + 1);
        }
        
        return maxLen;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.lengthOfLongestSubstringKDistinct("eceba", 2)); // 3
        System.out.println(sol.lengthOfLongestSubstringKDistinct("aa", 1)); // 2
        System.out.println(sol.lengthOfLongestSubstringKDistinct("abaccc", 2)); // 4
    }
} 