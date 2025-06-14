package Plus会员.leetcode296;

import java.util.*;

/**
 * 最佳开会地点
 */
public class Solution {
    /**
     * 找到最佳开会地点，使总距离最小
     * @param grid 二维网格，1表示有人住
     * @return 最小总距离
     */
    public int minTotalDistance(int[][] grid) {
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();
        
        // 收集所有人的坐标
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        
        // 对列坐标排序（行坐标已经有序）
        Collections.sort(cols);
        
        // 中位数是最佳聚会点
        int row = rows.get(rows.size() / 2);
        int col = cols.get(cols.size() / 2);
        
        // 计算总距离
        int distance = 0;
        for (int r : rows) {
            distance += Math.abs(r - row);
        }
        for (int c : cols) {
            distance += Math.abs(c - col);
        }
        
        return distance;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] grid = {{1,0,0,0,1},{0,0,0,0,0},{0,0,1,0,0}};
        System.out.println(sol.minTotalDistance(grid)); // 6
    }
} 