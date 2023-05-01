package lineSweep.leetcode57;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        for(int i = 0; i < intervals.length; i++){
            if(newInterval == null || intervals[i][1] < newInterval[0]){
                res.add(intervals[i]);
            }
            else if(newInterval[1] < intervals[i][0]){
                res.addAll(Arrays.asList(newInterval,intervals[i]));
                newInterval = null;
            }
            else{
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }
        if(newInterval != null){
            res.add(newInterval);
        }
        return res.toArray(new int[res.size()][]);
    }
}
