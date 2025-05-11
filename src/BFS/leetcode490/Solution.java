package BFS.leetcode490;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    static int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public static boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        visited[start[0]][start[1]] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        while(!q.isEmpty()){
            int[] cur = q.poll();
            if(visited[cur[0]][cur[1]]) continue;
            visited[cur[0]][cur[1]] = true;
            if(cur[0] == destination[0] && cur[1] == destination[1]) return true;
            for(int[] dir : dirs){
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                while(x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0){
                    x += dir[0];
                    y += dir[1];
                }
                x -= dir[0];
                y -= dir[1];
                q.offer(new int[]{x,y});
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] maze1 = new int[][]{{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
        int[] start1 = new int[]{0,4};
        int[] destination1 = new int[]{4,4};
        int[][] maze2 = new int[][]{{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
        int[] start2 = new int[]{0,4};
        int[] destination2 = new int[]{3,2};

        System.out.println(hasPath(maze1,start1,destination1));
        System.out.println(hasPath(maze2,start2,destination2));
    }
}
