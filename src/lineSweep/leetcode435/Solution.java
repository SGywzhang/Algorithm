package lineSweep.leetcode435;

import java.util.Arrays;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int end = Integer.MIN_VALUE;
        int count = 0;
        Arrays.sort(intervals,(a, b) -> a[1] - b[1]);
        for(int[] interval : intervals){
            if(interval[0] >= end){
                end = interval[1];
            }
            else{
                count++;
            }
        }
        return count;
    }
}
