package slidingWindow.leetcode1248;

public class Solution {
    public static int numberOfSubarrays(int[] nums, int k) {
       return findMost(nums, k) - findMost(nums, k - 1);
    }
    static int findMost(int[] nums, int k){
        int left = 0;
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            k -= nums[i] % 2;
            while(k < 0){
                k += nums[left] % 2;
                left++;
            }
            res += i - left + 1;
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(numberOfSubarrays(new int[]{1,1,2,1,1},3));
    }
}

