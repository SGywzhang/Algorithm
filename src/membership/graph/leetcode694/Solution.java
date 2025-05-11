package membership.graph.leetcode694;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static int numDistinctIslands(int[][] grid) {
        Set<String> set = new HashSet<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    StringBuilder path = new StringBuilder();
                    dfs(grid,i,j,i,j,path);
                    System.out.println(path.toString());
                    set.add(path.toString());
                }
            }
        }
        return set.size();
    }

    static void dfs(int[][] grid, int orgin_x, int orgin_y, int cur_x, int cur_y, StringBuilder path){
        int m = grid.length;
        int n = grid[0].length;

        if(cur_x < 0 || cur_x >= m ||
                cur_y < 0 || cur_y >= n ||
                grid[cur_x][cur_y] == 0) return;

        grid[cur_x][cur_y] = 0;
        int[] offset = new int[]{cur_x - orgin_x, cur_y - orgin_y};
        path.append(offset[0] + " <-> " + offset[1] + " ");

        dfs(grid, orgin_x, orgin_y, cur_x + 1, cur_y, path);
        dfs(grid, orgin_x, orgin_y, cur_x - 1, cur_y, path);
        dfs(grid, orgin_x, orgin_y, cur_x, cur_y + 1, path);
        dfs(grid, orgin_x, orgin_y, cur_x, cur_y - 1, path);
    }
    public static void main(String[] args) {
        int[][] grid1 = {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1}
        };
        int[][] grid2 = {
                {1, 1, 0, 1, 1},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1},
                {1, 1, 0, 1, 1}
        };
        System.out.println(numDistinctIslands(grid2));
    }
}
