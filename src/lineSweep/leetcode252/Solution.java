package lineSweep.leetcode252;

import java.util.Arrays;

public class Solution {
    public static boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            else{
                return a[0] - b[0];
            }
        });
        for(int i = 0; i < intervals.length - 1; i++){
           if(intervals[i][1] > intervals[i + 1][0]){
               return false;
           }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(canAttendMeetings(new int[][]{{0,30},{5,10},{15,20}}));
        System.out.println(canAttendMeetings(new int[][]{{7,10},{2,4}}));
    }
}
