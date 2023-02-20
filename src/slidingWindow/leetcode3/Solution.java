package slidingWindow.leetcode3;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int res = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i++){
            while(!set.add(s.charAt(i))){
                char c = s.charAt(left);
                set.remove(c);
                left++;
            }
            res = Math.max(res, i - left + 1);

        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
