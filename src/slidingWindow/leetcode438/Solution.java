package slidingWindow.leetcode438;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        Map<Character,Integer> map = new HashMap<>();
        for(char c : p.toCharArray()){
            map.put(c, map.getOrDefault(c,0) + 1);
        }
        int left = 0;
        int right = 0;
        while(right < s.length()){
            if(map.containsKey(s.charAt(right)) && map.get(s.charAt(right)) > 0){
                map.put(s.charAt(right), map.get(s.charAt(right)) - 1);
                if(right - left + 1 == p.length()){
                    res.add(left);
                }
                right++;
            }
            else{
                map.put(s.charAt(left), map.getOrDefault(s.charAt(left), 0) + 1);
                left++;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd","abc"));
    }
}
