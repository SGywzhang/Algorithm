package slidingWindow.leetcode76;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static String minWindow(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();
        for(char c : t.toCharArray()){
            map.put(c,map.getOrDefault(c,0) + 1);
        }
        int count = 0;
        int left = 0;
        int minLeft = 0;
        int minLen = Integer.MAX_VALUE;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                if(map.get(c) > 0){
                    count++;
                }
                map.put(c, map.get(c) - 1);
            }
            while(count == t.length()){
                if(minLen > i - left + 1){
                    minLen = i - left + 1;
                    minLeft = left;
                }
                char charLeft = s.charAt(left);
                if(map.containsKey(charLeft)){
                    map.put(charLeft, map.get(charLeft) + 1);
                    if(map.get(charLeft) > 0){
                        count--;
                    }
                }
                left++;
            }
        }
        if(minLen == Integer.MAX_VALUE) return "";
        return s.substring(minLeft, minLeft + minLen);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC","ABC"));
    }
}
