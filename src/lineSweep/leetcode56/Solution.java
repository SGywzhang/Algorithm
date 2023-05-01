package lineSweep.leetcode56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b)-> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        List<int[]> res = new ArrayList<>();
        int[] cur = intervals[0];

        for(int i = 1; i < intervals.length; i++){
            if(cur[1] < intervals[i][0]){
                res.add(cur);
                cur = intervals[i];
            }
            else{
                cur[1] = Math.max(cur[1],intervals[i][1]);
            }
        }
        res.add(cur);
        return res.toArray(new int[res.size()][2]);
    }
}
