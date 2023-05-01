package lineSweep.leetcode1288;

import java.util.Arrays;

class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int count = 0;
        Arrays.sort(intervals,(a, b)-> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int preEnd = 0;
        for(int[] interval : intervals){
            if(interval[1] > preEnd){
                preEnd = interval[1];
                count++;
            }
        }
        return count;
    }
}
