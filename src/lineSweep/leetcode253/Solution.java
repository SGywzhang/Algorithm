package lineSweep.leetcode253;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static int minMeetingRooms(int[][] intervals) {
        int count = 0;
        int res = 0;
        List<int[]> lists = new ArrayList<>();
        for(int[] interval : intervals){
            lists.add(new int[]{interval[0], 1});
            lists.add(new int[]{interval[1], -1});
        }
        lists.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for(int[] list : lists){
            count += list[1];
            res = Math.max(res, count);
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(minMeetingRooms(new int[][]{{0,30},{5,10},{15,20}}));
        System.out.println(minMeetingRooms(new int[][]{{7,10},{2,4}}));
    }
}
