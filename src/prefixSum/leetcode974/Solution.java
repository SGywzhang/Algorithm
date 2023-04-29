package prefixSum.leetcode974;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int preSum = 0;
        int count = 0;
        for(int num : nums){
            preSum = (preSum + num) % k;
            if(preSum < 0){
                preSum += k;
            }
            if(preSum == 0){
                count++;
            }
            count += map.getOrDefault(preSum,0);
            map.put(preSum,map.getOrDefault(preSum,0) + 1);
        }
        return count;
    }
}
