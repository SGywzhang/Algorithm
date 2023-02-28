package slidingWindow.leetcode424;

import java.util.Arrays;

public class Solution {
    public static int characterReplacement(String s, int k) {
        int res = 0;
        int[] count = new int[26];
        int left = 0;
        for(int i = 0; i < s.length(); i++){
            count[s.charAt(i) - 'A']++;
            int maxCur = findMax(count);
            if(i - left + 1 - maxCur > k){
                count[s.charAt(left) - 'A']--;
                left++;
            }
            res = Math.max(res, i - left + 1);
        }
        return res;
    }

    static int findMax(int[] nums){
        return Arrays.stream(nums).max().getAsInt();
    }

    public static void main(String[] args) {
        System.out.println(characterReplacement("ABAB",2));
    }
}
