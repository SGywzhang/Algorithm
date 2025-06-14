package Plus会员.leetcode252;

import java.util.Arrays;

/**
 * 判断是否能参加所有会议
 */
public class Solution {
    /**
     * 判断会议时间是否有重叠
     * @param intervals 会议时间区间
     * @return 是否能参加所有会议
     */
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]); // 按开始时间排序
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i-1][1]) {
                return false; // 有重叠
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] intervals1 = {{0,30},{5,10},{15,20}};
        int[][] intervals2 = {{7,10},{2,4}};
        // 测试用例
        System.out.println(sol.canAttendMeetings(intervals1)); // false
        System.out.println(sol.canAttendMeetings(intervals2)); // true
    }
} 