package slidingWindow.leetcode1234;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int balancedString(String s) {
        int target = s.length() / 4;
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int minLen = s.length();
        int left = 0;
        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.get(s.charAt(i)) - 1);

            while(left < s.length() &&
                    (map.getOrDefault('Q',0) <= target) &&
                    (map.getOrDefault('W',0) <= target) &&
                    (map.getOrDefault('E',0) <= target) &&
                    (map.getOrDefault('R',0) <= target)){
                minLen = Math.min(minLen, i - left + 1);
                map.put(s.charAt(left), map.get(s.charAt(left)) + 1);

                left++;
            }
        }
        return minLen;
    }
}
