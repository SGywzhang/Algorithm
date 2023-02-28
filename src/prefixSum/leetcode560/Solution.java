package prefixSum.leetcode560;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int subarraySum1(int[] nums, int k) {
        int count = 0;
        int[] preSum = new int[nums.length + 1];

        for(int i = 1; i <= nums.length; i++){
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        for(int start = 0; start < nums.length; start++){
            for(int end = start + 1; end <= nums.length; end++){
                if(preSum[end] - preSum[start] == k){
                    count++;
                }
            }
        }
        return count;
    }

    public static int subarraySum2(int[] nums, int k) {
        int count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int preSum = 0;
        for(int num : nums){
            preSum += num;
            if(map.containsKey(preSum - k)) count += map.get(preSum - k);
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum1(new int[]{1,1,2}, 2));
        System.out.println(subarraySum2(new int[]{1,1,2}, 2));
    }
}
