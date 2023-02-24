package slidingWindow.leetcode395;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int longestSubstring(String s, int k) {
        int res = 0;
        for(int l = 1; l <= 26; l++){
            int left = 0;
            int validCount = 0;
            Map<Character, Integer> map = new HashMap<>();
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                map.put(c,map.getOrDefault(c,0)+1);
                if(map.get(c) == k){
                    validCount++;
                }
                while(map.size() > l){
                    char charleft = s.charAt(left);
                    if(map.getOrDefault(charleft,0) == k) validCount--;
                    map.put(charleft,map.getOrDefault(charleft,0) - 1);
                    if(map.get(charleft) == 0) map.remove(charleft);
                    left++;
                }
                int count = map.size();
                if(count == validCount && count == l){
                    res = Math.max(res, i - left + 1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(longestSubstring("aaabb", 3));
        System.out.println(longestSubstring("ababbc", 2));

    }
}
