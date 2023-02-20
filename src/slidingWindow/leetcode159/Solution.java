package slidingWindow.leetcode159;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int left = 0;
        int res = 0;

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
            while(map.size() > 2){
                char cur = s.charAt(left);
                int count = map.get(cur) - 1;
                if(count == 0){
                    map.remove(cur);
                }
                else{
                    map.put(cur, count);
                }
                left++;
            }
            res = Math.max(res, i - left + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringTwoDistinct("eceba"));
        System.out.println(lengthOfLongestSubstringTwoDistinct("ccaabbb"));
    }
}
