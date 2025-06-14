package Plus会员.leetcode253;

import java.util.Arrays;

/**
 * 计算最小会议室数量
 */
public class Solution {
    /**
     * 计算最小会议室数量
     * @param intervals 会议时间区间
     * @return 最小会议室数量
     */
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        int n = intervals.length;
        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int rooms = 0, endPtr = 0;
        for (int i = 0; i < n; i++) {
            if (starts[i] < ends[endPtr]) {
                rooms++;
            } else {
                endPtr++;
            }
        }
        return rooms;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] intervals1 = {{0,30},{5,10},{15,20}};
        int[][] intervals2 = {{7,10},{2,4}};
        // 测试用例
        System.out.println(sol.minMeetingRooms(intervals1)); // 2
        System.out.println(sol.minMeetingRooms(intervals2)); // 1
    }
} 