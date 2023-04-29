package prefixSum.leetcode523;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int preSum = 0;
        map.put(-1,0);
        for(int i = 0; i < nums.length; i++){
            preSum += (preSum + nums[i]) % k;
            if(preSum < 0) preSum += k;
            if(map.containsKey(preSum)){
               if(i - map.get(preSum) > 1){
                    return true;
                }
            }
            else{
                map.put(preSum,i);
            }
        }
        return false;
    }
}
