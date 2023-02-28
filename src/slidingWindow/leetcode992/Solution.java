package slidingWindow.leetcode992;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int subarraysWithKDistinct(int[] nums, int k) {
        return findMost(nums, k) - findMost(nums, k - 1);
    }

    static int findMost(int[] nums, int k){
        int res = 0;
        Map<Integer,Integer> map = new HashMap<>();
        int left = 0;
        for(int i = 0; i < nums.length; i++){
            if(map.getOrDefault(nums[i],0) == 0){
                k--;
            }
            map.put(nums[i],map.getOrDefault(nums[i], 0) + 1);
            while(k < 0){
                map.put(nums[left], map.get(nums[left]) - 1);
                if(map.get(nums[left]) == 0){
                    k++;
                }
                left++;
            }
            res += i - left + 1;

        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(subarraysWithKDistinct(new int[]{1,2,1,2,3},2));
    }
}
