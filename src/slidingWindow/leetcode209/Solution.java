package slidingWindow.leetcode209;

public class Solution {
    public static int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;

        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            while(left <= i && sum >= target){
                sum -= nums[left];
                res = Math.min(res, i - left + 1);
                left++;
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }
}
