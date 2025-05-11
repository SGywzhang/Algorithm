package DP.zeroOneBag;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] weight = {1,3,4};
        int[] value = {15,20,30};
        int bagSize = 4;
        System.out.println(zeroOneBag_2D(weight,value,bagSize));
        System.out.println(zeroOneBag_1D(weight,value,bagSize));
    }
    public static int zeroOneBag_2D(int[] weight, int[] value, int bagSize){
        int[][] dp = new int[weight.length][bagSize + 1];
        for(int j = weight[0]; j <= bagSize; j++){
            dp[0][j] = value[0];
        }
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(j < weight[i]){
                    dp[i][j] = dp[i - 1][j];
                }
                else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }
        for(int[] arr : dp){
            System.out.println(Arrays.toString(arr));
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
    //          0  1  2  3  4
    // 0 (1,15) 0 15 15 15 15
    // 1 (3,20) 0 15 15 20 35
    // 2 (4,30) 0 15 15 20 35
    public static int zeroOneBag_1D(int[] weight, int[] value, int bagSize){
        int[] dp = new int[bagSize + 1];
        for(int i = 0; i < weight.length; i++){
            for(int j = bagSize; j >= weight[i]; j--){
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        System.out.print(Arrays.toString(dp));
        System.out.print("\n");
        return dp[dp.length - 1];
    }
}
