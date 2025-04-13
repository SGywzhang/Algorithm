package Plus会员.leetcode159;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int left = 0;
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            while(map.size() > 2){
                int count = map.get(s.charAt(left));
                count--;
                if(count == 0){
                    map.remove(s.charAt(left));
                }
                else{
                    map.put(s.charAt(left), count);
                }
                left++;
            }
            res = Math.max(res, i - left + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        // 测试用例 1
        String s1 = "eceba";
        System.out.println("Input: " + s1);
        System.out.println("Output: " + sol.lengthOfLongestSubstringTwoDistinct(s1)); // Expected: 3

        // 测试用例 2
        String s2 = "ccaabbb";
        System.out.println("Input: " + s2);
        System.out.println("Output: " + sol.lengthOfLongestSubstringTwoDistinct(s2)); // Expected: 5 ("aabbb")
    }
}
