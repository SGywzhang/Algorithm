package lineSweep.leetcode1272;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved){
        List<List<Integer>> res = new ArrayList<>();
        for (int[] interval : intervals) {
            if (interval[1] <= toBeRemoved[0] || interval[0] >= toBeRemoved[1]) {
                res.add(Arrays.asList(interval[0], interval[1]));
            } else{
                if (interval[0] < toBeRemoved[0]) {
                    res.add(Arrays.asList(interval[0], toBeRemoved[0]));
                }
                if (interval[1] > toBeRemoved[1]) {
                    res.add(Arrays.asList( toBeRemoved[1],interval[1]));
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(removeInterval(new int[][]{{0,2},{3,4},{5,7}}, new int[]{1,6}));
        System.out.println(removeInterval(new int[][]{{0,5}}, new int[]{2,3}));
    }
}
